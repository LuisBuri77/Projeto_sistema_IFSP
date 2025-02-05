import React, { Fragment } from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import 'bootstrap/dist/css/bootstrap.css';
import './assets/styles/resset.css';
import './assets/styles/styles.css';
import { BrowserRouter } from 'react-router-dom';


const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <Fragment>
       <BrowserRouter>
          <App />
        </BrowserRouter>
    </Fragment>
  </React.StrictMode>
);



