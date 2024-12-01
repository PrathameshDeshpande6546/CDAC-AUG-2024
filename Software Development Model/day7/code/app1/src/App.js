import logo from './logo.svg'
import './App.css'
import ProductList from './screens/ProductList'
import { ToastContainer } from 'react-toastify'
import 'react-toastify/dist/ReactToastify.css'

function App() {
  return (
    <div className='container'>
      <ProductList />
      <ToastContainer />
    </div>
  )
}

export default App
