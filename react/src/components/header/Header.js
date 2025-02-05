import React, { Fragment, useState } from 'react'
import * as FaIcons from 'react-icons/fa'
import { USUARIO } from '../../config/Config'

const Header = ({isToggle}) => {

    const [toggle, setToggle]=useState(true);

    const toggleClick = () => {
        setToggle(!toggle);
        isToggle(toggle);
    }
  return (
    <Fragment> 
        
        <header className='app-header' >
        
            <div className="app-leftarea">
                <h4>
                    SISTEMA<span>IFSP</span>
                </h4>
            </div>
            <div className="app-toggle">
                <i id="sidebar_toggle">
                    <FaIcons.FaBars onClick={()=>toggleClick()}/>
                </i>
            </div>
            
            <div className="app-profile">
                <img 
                  src={USUARIO}
                  alt="foto"
                  className="img-avatar__header"
                />
                <span>Francisco</span>
                <div className="app-logout">
                    <i>
                        <FaIcons.FaSignOutAlt/>
                   </i> 
                </div>
            </div>
            

        </header>



    </Fragment>
  )
}

export default Header
