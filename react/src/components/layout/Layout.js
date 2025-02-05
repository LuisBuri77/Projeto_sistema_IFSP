// flowbit react 

import React, { Fragment, useState } from 'react'
import Header from '../header/Header'
import SideBar from '../menu/SideBar'

const Layout = ({ children }) => {
  
    const [toggle, setToggle] = useState(false);

    const toggleMenu = () => {
        setToggle(!toggle);
    }

  return (
    <Fragment>
        <Header isToggle={toggleMenu}/>
        <SideBar isToggle={toggle}/>
        <main className={toggle ? 'app-content active': 'app-content'}>{children}</main>
    </Fragment>
  )
}

export default Layout
