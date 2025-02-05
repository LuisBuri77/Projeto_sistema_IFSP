import React, { Fragment } from 'react'
import Navegacao from '../components/mensagem/Navegacao'
import * as AiIcons from 'react-icons/ai';
import {  BUTTON_SIZE, BUTTON_SIZE_SHOW_MESSAGE } from '../config/Config';


const Dashboard = () => {
  return (
<Fragment>

      <Navegacao
         titulo="Página principal"
         descricao="Página principal do sistema"
         iconTitulo={<AiIcons.AiFillDashboard size={BUTTON_SIZE_SHOW_MESSAGE}/>}
         iconReturn={<AiIcons.AiFillDashboard size={BUTTON_SIZE}/>}
         url="/dashboard"
         tituloUrl="Página principal"
      />
    </Fragment>
  )
}

export default Dashboard
