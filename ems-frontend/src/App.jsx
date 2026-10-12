import { useState } from 'react'

import './App.css'
import Helloworld from './HelloWorld'
import ListEmployeeComponent from './components/ListEmployeeComponent'
import { HeaderComponent } from './components/HeaderComponent'
import { FooterComponent } from './components/FooterComponent'
import {EmployeeComponent} from './components/EmployeeComponent'
import { BrowserRouter, Routes, Route } from 'react-router-dom'

function App() {

  return (
    <>
      {/* <h1>hekoo</h1>  
    <Helloworld/> */}
      <BrowserRouter>
        <HeaderComponent />
        <Routes>
          // http://localhost:3000
          < Route path='/' element = {<ListEmployeeComponent/>}></Route>
           // http://localhost:3000/employees
           <Route path='/employees' element={<ListEmployeeComponent/>}></Route>
            // http://localhost:3000/add-employees
           <Route path='/add-employee' element={<EmployeeComponent/>}></Route>

           // http://localhost:3000/edit-employees/1
           <Route path='/edit-employee/:id' element={<EmployeeComponent/>}></Route>
        </Routes>
        
        <FooterComponent />
      </BrowserRouter>
    </>
  )
}

export default App
