import React, { Fragment } from 'react'
import Navegacao from '../../components/mensagem/Navegacao'
import * as FaIcons from 'react-icons/fa';
import * as MdIcons from 'react-icons/md';
import {  BUTTON_SIZE, BUTTON_SIZE_SHOW_MESSAGE } from '../../config/Config';
//import { useValidarDadosUsuario } from './ValidarDadosUsuario';
import { ERRORS_USUARIO, USUARIO } from '../../types/Usuario';
import MensagemErro from '../../components/mensagem/MensagemErro';
import useApiUsuario from '../../service/UsuarioService';
import { useNavigate } from 'react-router-dom';
import { useValidarDadosUsuarios } from './ValidarUsuarios';



const Incluir = () => {
  
  const {usuario,
    setUsuario,
    errors,
    setErrors,
    changeDataUsuario,
    validateAll,
    isValid
  } = useValidarDadosUsuarios();


  /*
  const { usuario, 
          errors, 
          setUsuario,
          setErrors, 
          changeDataUsuario, 
          validateAll, 
          isValid 
  } = useValidarDadosUsuario(USUARIO,ERRORS_USUARIO);
  */

  const {salvarUsuario} = useApiUsuario();
  const navigate = useNavigate();

  const onSubmitData = async (e) => {

     e.preventDefault();
     let erros = validateAll();

     if (isValid(erros)){
        await salvarUsuario(usuario);
        setUsuario(USUARIO);
        navigate('/usuario/listar');

     } else {
       setErrors({...erros});
     }


  }

 

  return (
    <Fragment>
     <Navegacao
         titulo="Usuários"
         descricao="Inclusão de usuários no sistema"
         iconTitulo={<FaIcons.FaUserEdit size={BUTTON_SIZE_SHOW_MESSAGE}/>}
         iconReturn={<MdIcons.MdList size={BUTTON_SIZE}/>}
         caminho="Usuário"
         url="/usuario/listar"
         tituloUrl="Listagem de Usuários"
      /><div className='row justify-content-center'>
      <div className='col-xs-12 col-sm-12 col-md-12 col-lg-8 '>
        <div className='app-windows'>

          <form onSubmit={onSubmitData}>
             <div className='row mt-3 mb-3'>
                <div className='col-xs-12 col-sm-12 col-md-12'>
                  <div className='form-group'>
                    <label className='app-label control-label mb-2' htmlFor='username'>Nome:</label>
                    <input type='text'
                           name="username"
                           id="username"
                           value={usuario.username}
                           onChange={changeDataUsuario}
                           className={ 
                             errors.username ? "form-control is-invalid "
                                             : "form-control app-label "
                           } />
                           {
                             errors.username ? (<MensagemErro mensagem={errors.usernameMensagem}/>) : null
                           }
                  </div>
               </div>
             </div>

             <div className='row mb-3'>
                <div className='col-xs-12 col-sm-12 col-md-12'>
                  <div className='form-group'>
                    <label className='control-label mb-2' htmlFor='email'>E-mail:</label>
                    <input type='text'
                           name="email"
                           id="email"
                           value={usuario.email}
                           onChange={changeDataUsuario}
                           className={ 
                            errors.email ? "form-control is-invalid "
                                            : "form-control app-label "
                          }/>
                          {
                             errors.email ? (<MensagemErro mensagem={errors.emailMensagem}/>) : null
                           }
                  </div>
               </div>
             </div>

             <div className='row mb-3'>
                <div className='col-xs-12 col-sm-12 col-md-12'>
                  <div className='form-group'>
                    <label className='control-label mb-2' htmlFor='password'>Senha:</label>
                    <input type='password'
                           name="password"
                           id="password"
                           value={usuario.password}
                           onChange={changeDataUsuario}
                           className={ 
                            errors.password ? "form-control is-invalid "
                                            : "form-control app-label "
                          }/>
                          {
                             errors.password ? (<MensagemErro mensagem={errors.passwordMensagem}/>) : null
                          }
                  </div>
                </div>
             </div>

             <div className='row mb-3'>
                <div className='col-xs-12 col-sm-12 col-md-12'>
                  <div className='form-group'>
                    <label className='control-label mb-2' htmlFor='confirmPassword'>Confirme a Senha:</label>
                    <input type='password'
                           name="confirmPassword"
                           id="confirmPassword"
                           value={usuario.confirmPassword}
                           onChange={changeDataUsuario}
                           className={ 
                            errors.confirmPassword ? "form-control is-invalid "
                                                   : "form-control app-label "
                          }/>
                          {
                             errors.confirmPassword ? (<MensagemErro mensagem={errors.confirmPasswordMensagem }/>) : null
                          }
                  </div>
                </div>
             </div>
             <div className='row'>
                <div className='col-xs-12 col-sm-12 col-md-4'>
                  <button type="submit"
                          title="Incluir dados de usuário"
                          className='btn btn-success btn-lg app-label'
                  >
                    <FaIcons.FaSave size={BUTTON_SIZE}/>&nbsp;&nbsp;
                    Salvar Usuário
                  </button>
                </div>
             </div>

          </form>

        </div>

      </div>

    </div>
    </Fragment>
  )
}

export default Incluir
