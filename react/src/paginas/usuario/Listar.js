
import React, { Fragment, useEffect, useState } from 'react'
import useApiUsuario from '../../service/UsuarioService'
import { Link } from 'react-router-dom';
import * as FaIcons from 'react-icons/fa';
import * as AiIcons from 'react-icons/ai';
import Navegacao from '../../components/mensagem/Navegacao';
import {  BUTTON_SIZE, BUTTON_SIZE_SHOW_MESSAGE } from '../../config/Config';
import useAlert from '../../hook/useAlert';
import Loading from '../../components/loading/Loading';

const Listar = () => {

  const [pageNumber, setPageNumber] = useState(0);
  const [pageSize, setPageSize] = useState(10);
  const [props, setProps] = useState("id");
  const [dir, setDir] = useState("asc");
  const [totalPages, setTotalPages] = useState(0);
  const [totalElements, setTotalElements] = useState(0);
  const [usuarios, setUsuarios] = useState([]);

  const { loading } = useAlert();

  const {data, getListaDataUsuario} = useApiUsuario();
  useEffect(() => {
    async function loadUsuario() {
      await getListaDataUsuario(pageNumber, pageSize, props, dir);
      console.log(data);
      setPageNumber(data.pageNumber);
      setPageSize(data.pageSize);
      setTotalPages(data.totalPages);
      setTotalElements(data.totalElements);
      setUsuarios(data.content);
    }
    loadUsuario();
  }, [pageNumber, pageSize, props, dir])

  return (
    <Fragment>
      <Navegacao
         titulo="Manutenção de Usuários"
         descricao="Listagem dos usuários cadastrados no sistema"
         iconTitulo={<FaIcons.FaListAlt size={BUTTON_SIZE_SHOW_MESSAGE}/>}
         iconReturn={<AiIcons.AiFillDashboard size={BUTTON_SIZE}/>}
         url="/dashboard"
         tituloUrl="Dashboard"
      />

      {loading ? <Loading/> : null}

      <div className='row justify-content-center'>
        <div className='col-xs-12 col-md-12 col-lg-10'>
          <div className='app-windows'>

            <div id="no_more_table">
              <table id="tabela-usuario"
                className='app-tabela table table-striped table-bordered table-hover cf'>
                <thead className='cf'>
                  <tr>
                    <th className='app-cabecalho-tabela p-3 bg-success text-white app-label'>Nome</th>
                    <th className='app-cabecalho-tabela p-3 bg-success text-white app-label'>Email</th>
                    <th className='app-cabecalho-tabela p-3 bg-success text-white app-label'>Ações</th>
                  </tr>
                </thead>
                <tbody>
                  {
                    usuarios && usuarios.map((usuario) => (
                      <tr key={usuario.id}>
                        <td data-label="Nome">{usuario.username}</td>
                        <td data-label="E-mail">{usuario.email}</td>
                        <td data-label="Ações">
                          <Link to={`/usuario/alterar/${usuario.id}`} type="button" title='Alterar dados do usuário'
                                className='btn btn-secondary'>
                            <i><FaIcons.FaPencilAlt /></i>
                          </Link>
                          <Link to={`/usuario/excluir/${usuario.id}`} type="button" title='Excluir dados do usuário'
                                className='btn btn-danger'>
                            <i><FaIcons.FaTrash /></i>
                          </Link>
                          <Link to={`/usuario/consultar/${usuario.id}`} type="button" title='Consultar dados do usuário'
                                className='btn btn-info'>
                            <i><FaIcons.FaSearchPlus /></i>
                          </Link>

                        </td>
                      </tr>
                    ))
                  }

                </tbody>
              </table>
              <div className='row mt-4'>
                  <div className='col-xs-12 col-sm-12 col-md-3 ml-5'>
                    <Link to="/usuario/incluir" type="botton" className='btn btn-primary '>
                      Incluir dados do usuário
                       <i><FaIcons.FaPlus/></i>
                    </Link>

                  </div>
 
              </div>
            </div>
          </div>
        </div>
      </div>
    </Fragment>
  )
}

export default Listar;
