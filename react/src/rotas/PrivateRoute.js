import React, { Fragment } from 'react'
import Layout from '../components/layout/Layout'
import { Outlet } from 'react-router-dom'

const PrivateRoute = () => {
  return (
    <Fragment>
        <Layout>
            <Outlet/>
        </Layout>
    </Fragment>

  )
}

export default PrivateRoute
