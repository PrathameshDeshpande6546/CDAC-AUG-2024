import axios from 'axios'
import { createUrl } from '../utils'

export async function getProductList() {
  try {
    const url = createUrl('product/')
    const response = await axios.get(url)
    return response.data
  } catch (ex) {
    return { status: 'error', error: ex }
  }
}
