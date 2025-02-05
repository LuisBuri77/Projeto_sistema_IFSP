
import { Fragment } from 'react';
import './App.css';
import Rotas from './rotas/Rotas';
import {AlertProveder } from './contexto/AlertContexto';

//import Listar from './paginas/usuario/Listar';

function App() {
  return (
    <Fragment>
      <AlertProveder>
        <Rotas/>
        </AlertProveder>
    </Fragment>

  );
}

export default App;
