

import React, { Fragment } from 'react';
import items from './SideBarData';
import ShowItens from './ShowItens';

const SideBar = ({isToggle}) => {
  return (
     <Fragment>
        <div className={ isToggle ? "app-sidebar active":"app-sidebar"}>
           {
             items.map((item,index)=>{
                 return(
                    <ShowItens 
                      key={index}
                      item={item}/>

                 )
             })

           }
        </div>
     </Fragment>
  )
}

export default SideBar
