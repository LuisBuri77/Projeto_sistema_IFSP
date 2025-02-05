import { useState, useCaallback, useCallback } from "react"
import { ERRORS_USUARIO, USUARIO } from '../../types/Usuario';


export const useValidarDadosUsuarios = () => {
    const model = USUARIO;

    const [usuario, setUsuario] = useState(model);
    const [errors, setErrors] = useState(ERRORS_USUARIO);

    const changeDataUsuario = (e) => {
        const { name, value } = e.target;
        setUsuario({...usuario, [name]:value});
    }

    const isValid = (erros) => {
        let key = Object.keys(erros);
        let count = key.reduce((acc, curr) => erros[curr] ? acc + 1 : acc, 0);
        return count === 0;
    }
    

    const isEmpty = (val) => !val || val.trim() == "";
    const isNullorUndefined = (val) => val === null || val === undefined;

    const validationRules = {


        username:   [
            (val) => isEmpty(val) && 'informe o nome de usuário',
            (val) => isNullorUndefined(val) && 'informe o nome de usuário',
        ].filter(Boolean),

        email:  [
            (val) => isEmpty(val) && 'informe o email',
            (val) => isNullorUndefined(val) && 'informe o email',
        ].filter(Boolean),

        password: [
            (val) => isEmpty(val) && 'informe a senha',
            (val) => isNullorUndefined(val) && 'informe a senha',
        ].filter(Boolean),

        confirmPassword:  [
            (val) => isEmpty(val) && 'informe confirmação da senha',
            (val) => isNullorUndefined(val) && 'informe confirmação da senha',
        ].filter(Boolean),

    }

    const validateField = useCallback((name, value) => {
        const newErros = { ...errors };

        newErros[`${name}Mensagem`] = [];

        if (validationRules[name]) {

            for (let i = 0; i < validationRules[name].length; i++) {
                const rule = validationRules[name][i];
                const errorMensagem = rule(value);

                if (errorMensagem) {
                    newErros[name] = true;
                    newErros[`${name}Mensagem`].push(errorMensagem);
                }
            }

        } else {
            newErros[name] = false;
        }

    }, [errors])

    const validateAll = useCallback(() => {

        const newErros = { ...errors };
        Object.keys(usuario).forEach((field) => {
            validateField(field, usuario[field]);
        })
        return newErros;
    }, [usuario, validateField, errors]);


    return {
        usuario,
        setUsuario,
        errors,
        setErrors,
        validateAll,
        isValid,
        changeDataUsuario,
    }
}