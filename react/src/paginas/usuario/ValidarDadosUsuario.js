import { useState } from "react"


export const useValidarDadosUsuario = (USUARIO, ERRORS_USUARIO) => {

    const [usuario, setUsuario] = useState(USUARIO);
    const [errors, setErrors] = useState(ERRORS_USUARIO);

    const changeDataUsuario = (e) => {
        const { name, value } = e.target;
        setUsuario({ ...usuario, [name]: value });
    }

    const handleBlurField = (name) => {
        let erros = validBlurInput(name);
        if (!isValid(erros)) {
            setError({ ...erros });
        } else {
            setError({ ...erros });
        }
    }

    const isValid = useCallback((erros) => {
        let count = Object.values(erros).some(value => value === true);
        return count;
    }, []);

    const validateAll = () => {
        let { username, email, password, confirmPassword } = usuario;
        let erros = {};

        erros.usernameMensagem = validateUsername(username);
        erros.username = !!(erros.usernameMensagem && erros.usernameMensagem.length > 0);
        erros.emailMensagem = validateEmail(email);
        erros.email = !!(erros.emailMensagem && erros.emailMensagem.length > 0);
        erros.passwordMensagem = validatePassword(password);
        erros.password = !!(erros.passwordMensagem && erros.passwordMensagem.length > 0);
        erros.confirmPasswordMensagem = validateConfirmePassword(confirmPassword);
        erros.confirmPassword = !!(erros.confirmPasswordMensagem && erros.confirmPasswordMensagem.length > 0);

        return erros;

    }

    const validateUsername = (username) => {
        let mensagem = [];
        if (!username || username.trim().length === 0) {
            mensagem.push('Informa o nome do usuário')
        }
        if (!username || username.length < 5) {
            mensagem.push('O nome do usuario deve conter 5 caracteres ')
        }

        return mensagem;
    }


    const validateEmail = (email) => {
        let mensagem = [];
        if (!email || email.trim().length === 0) {
            mensagem.push('Informa o email')
        }
        if (!username || username.length < 5) {
            mensagem.push('O  email deve conter 5 caracteres ')
        }
        if (email && /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/.test(email)) {
            mensagem.push('Email ivalido!')
        }

        return mensagem;
    }

    const validatePassword = (password) => {
        let mensagem = [];
        if (!password || password.trim().length === 0) {
            mensagem.push('A senha deve ser informada')
        }
        if (!password || password.length < 6) {
            mensagem.push('A senha deve conter pelo menos seis caracteres')
        }
        return mensagem;
    }


    const validateConfirmePassword = (password, confirmPassword) => {
        let mensagem = [];
        if (!confirmPassword || confirmPassword.trim().length === 0) {
            mensagem.push('A senha deve ser informada')
        }
        if (confirmPassword && confirmPassword !== password) {
            mensagem.push('As senhas devem ser iguais')
        }

        return mensagem;
    }









    const validBlurInput = (field) => {
        let { username, email, password, confirmPassword } = usuario;
        let erros = {};
        switch (field) {
            case "username":
                erros.usernameMensagem = validateUsername(username);
                erros.username = !!(erros.usernameMensagem && erros.usernameMensagem.length > 0);
                break;
            case "email":
                erros.emailMensagem = validateEmail(email);
                erros.email = !!(erros.emailMensagem && erros.emailMensagem.length > 0);
                break;
            case "password":
                erros.passwordMensagem = validatePassword(password);
                erros.password = !!(erros.passwordMensagem && erros.passwordMensagem.length > 0);
                break;
            case "confirmPassword":
                erros.confirmPasswordMensagem = validateConfirmePassword(confirmPassword);
                erros.confirmPassword = !!(erros.confirmPasswordMensagem && erros.confirmPasswordMensagem.length > 0);
                break;
            
        }
        return erros;
    }


    const getErrorServidor = useCallback(async (field) => {
        if (field === undefined) {
            return;
        }

        let erros = {};

        erros = ERROR_CIDADE;

        for (let i = 0; i < field.length; i++) {
            if (field[i].nome === 'codCidade') {
                erros.codCidadeMensagem.push(field[i].mensagem);
                erros.codCidade = !!(erros.codCidadeMensagem && erros.codCidadeMensagem.length > 0);
            }
            if (field[i].nome === 'nomeCidade') {
                erros.nomeCidadeMensagem.push(field[i].mensagem);
                erros.nomeCidade = !!(erros.nomeCidadeMensagem && erros.nomeCidadeMensagem.length > 0);
            }

        }
        return erros;
    }, []);


    return {
        usuario,
        setUsuario,
        errors,
        setErrors,
        changeDataUsuario,
        isValid,
        validateAll,
    }
}