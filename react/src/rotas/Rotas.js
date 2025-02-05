import React, { Fragment } from 'react'
import { Routes, Route } from 'react-router-dom'
import PrivateRoute from './PrivateRoute'
import Listar from '../paginas/usuario/Listar'
import Dashboard from '../paginas/Dashboard'
import Incluir from '../paginas/usuario/Incluir'
import Alterar from '../paginas/usuario/Alterar'
import Excluir from '../paginas/usuario/Excluir'
import Consultar from '../paginas/usuario/Consultar'


const Rotas = () => {
  return (
    <Fragment>
        <Routes>
            <Route element={<PrivateRoute/>}>
                <Route path='/' element={<Dashboard/>}/>
                <Route path="/usuario/listar" element={<Listar/>}/>
                <Route path="/usuario/incluir" element={<Incluir/>}/>
                <Route path="/usuario/alterar/:id" element={<Alterar/>}/>
                <Route path="/usuario/excluir/:id" element={<Excluir/>}/>
                <Route path="/dashboard" element={<Dashboard/>}/>
                <Route path="/usuario/consultar/:id" element={<Consultar/>}/>



            </Route>
        </Routes>
    </Fragment>
  )
}

export default Rotas
