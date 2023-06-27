import React from 'react'
import './App.css'
import { Header } from './header'
import { RouterProvider } from 'react-router-dom'
import { router } from '../app/router'

function App() {
  return (
    <div className='App'>
      <Header />
      <div className='MainPart'>
        <RouterProvider router={router} />
      </div>
    </div>
  )
}

export default App
