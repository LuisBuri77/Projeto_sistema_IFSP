import React, { Fragment, useCallback, useEffect, useState } from 'react'
import useAlert from '../../hook/useAlert';
import  ReactDOM  from 'react-dom';

const TimeAlert = ({ }) => {

    const { message, variant, show, handleShowAlert, duration, showAlert } = useAlert();

    useEffect(() => {
        const timer = setTimeout(async () => {
            handleShowAlert();
        }, duration);
        return () => clearTimeout(timer);
    }, [duration, handleShowAlert])


    return ReactDOM.createPortal(
        
            show && (
                <div className="alert-message">
                    <div className='alert-message-container'>
                        <div className={`alert-message-content alert-${variant}`}>
                            <div className='alert-message-header'>
                                <span className='alert-txt'>{message}</span>
                                <span className='app-close-bth' onClick={()=>handleShowAlert()}>
                                    X
                                    </span>
                            </div>
                        </div>
                    </div>
                </div>
            ),document.body
    )

    
}

export default TimeAlert
