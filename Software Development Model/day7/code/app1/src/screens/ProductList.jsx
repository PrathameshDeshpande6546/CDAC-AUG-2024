import { useEffect, useState } from 'react'
import { getProductList } from '../services/product'
import { toast } from 'react-toastify'

function ProductList() {
  const [products, setProducts] = useState([])

  const onLoadProductList = async () => {
    const result = await getProductList()
    console.log(result)
    if (result['status'] == 'success') {
      setProducts(result['data'])
    } else {
      toast.error(result['error'])
    }
  }

  useEffect(() => {
    onLoadProductList()
  }, [])

  return (
    <div>
      <h2>Product List</h2>
      <table className='table table-hover'>
        <thead>
          <tr>
            <th>No</th>
            <th>Title</th>
            <th>Price</th>
            <th>Description</th>
          </tr>
        </thead>
        <tbody>
          {products.map((product, index) => {
            return (
              <tr>
                <td>{index + 1}</td>
                <td>{product['title']}</td>
                <td>{product['price']}</td>
                <td>{product['description']}</td>
              </tr>
            )
          })}
        </tbody>
      </table>
    </div>
  )
}

export default ProductList
