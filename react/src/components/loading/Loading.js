import React, { Fragment } from 'react'

const Loading = () => {
  return (
    <Fragment>
        <div className='loading-containeer'>
            <div className='loading-spinner'>
                <p>LOADING ...</p>
            </div>
        </div>
    </Fragment>
  )
}

export default Loading