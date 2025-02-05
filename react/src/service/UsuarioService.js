
import { useCallback, useState } from 'react';
import http from '../config/Banco';
import useAlert from '../hook/useAlert';
import { DANGER, SUCCESS, TIME } from '../config/Config';
import {getMessageByStatus, getMessageByType} from '../components/mensagem/StatusMensagens';


const useApiUsuario = () => {
  const [data, setData] = useState([]);

  const { setLoading, showAlert } = useAlert();

  const getListaDataUsuario = useCallback(async (pageNunber, pageSize, props, dir) => {

    setLoading(true);
    try {
      const params = {
        pageNunber,
        pageSize,
        props,
        dir
      }

      const response = await http.get('/usuario/listar', { params })
      setData(response.data.page);

      const { mensagem, status } = response.data;
      

      const msg = mensagem ? mensagem : getMessageByStatus(status);

      showAlert(msg, SUCCESS, TIME);

    } catch (error) {
      showAlert(getMessageByType(error), DANGER, TIME);
    } finally {
      setLoading(false)
    };

  }, [showAlert, setLoading])

  
const salvarUsuario = async (usuario) => {
  setLoading(true);
  try{
    const response = await http.post(
      '/usuario/salvar',
      usuario
    );
    setData(response.data.objeto)
    const {mensagem, status } = response.data;
    const msg = mensagem || getMessageByStatus(status);
    showAlert(msg, SUCCESS, TIME);
  }catch(erro){
    showAlert(getMessageByType(erro), DANGER, TIME);
  } finally {
    setLoading(false);
  }
}



const updateUsuario = async (id,usuario) => {
  setLoading(true);
  try{
    const response = await http.put(
      `/usuario/alterar/${id}`,
      usuario
    );
    setData(response.data.objeto)
    const {mensagem, status } = response.data;
    const msg = mensagem || getMessageByStatus(status);
    showAlert(msg, SUCCESS, TIME);
  }catch(erro){
    showAlert(getMessageByType(erro), DANGER, TIME);
  } finally {
    setLoading(false);
  }

}


const excluirusuarioById =
  async (id) => {

    setLoading(true);
    try {
      const response = await http.delete(`/usuario/excluir/${id}`)
      const { mensagem, status } = response.data;
      const msg = mensagem ? mensagem : getMessageByStatus(status);
  
      showAlert(msg, SUCCESS, TIME);
  
    } catch (error) {
      showAlert(getMessageByType(error), DANGER, TIME);
    } finally {
      setLoading(false)
    }
  };
  



const getDataUsuarioById = useCallback(
  async (id) => {

  setLoading(true);
  try {

    const response = await http.get(`/usuario/buscar/${id}`)
    setData(response.data.objeto);

    const { mensagem, status } = response.data;
    

    const msg = mensagem ? mensagem : getMessageByStatus(status);

    showAlert(msg, SUCCESS, TIME);

  } catch (error) {
    showAlert(getMessageByType(error), DANGER, TIME);
  } finally {
    setLoading(false)
  };

}, [showAlert, setLoading])




  return {
    data,
    getListaDataUsuario,
    salvarUsuario,
    getDataUsuarioById,
    updateUsuario,
    excluirusuarioById
  }
}

export default useApiUsuario;
