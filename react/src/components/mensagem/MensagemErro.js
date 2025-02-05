import React, { Fragment } from 'react'

const MensagemErro = ({mensagem}) => {
    return (
        <Fragment>
            {
                <div className='invalid-feedback'>
                    {
                        mensagem.map((erro, index ) => (
                        <p style={{margin:"0"}}>
                            <span>{mensagem}</span>
                        </p>
                    ))}
                </div>
            }
        </Fragment>
    )
}

export default MensagemErro
