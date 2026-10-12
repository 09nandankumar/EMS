import React from 'react'

export const HeaderComponent = () => {
  return (
    <div>
        <header>
            <nav className='navbar navbar-dark bg-dark'>
                {/* <a className="navbar-brand" display='' color='blue' justifycontent = 'center' hight = '10vh' href="#">Employee Management System</a> */}
          <a className="navbar-brand custom-navbar" href="#">
            Employee Management System
          </a>
            </nav>
        </header>
    </div>
  )
}
