const express = require('express')
const cors = require('cors')
const morgan = require('morgan')

const app = express()
app.use(cors())
app.use(morgan('combined'))

// add the router
const productRouter = require('./routes/product')
app.use('/product', productRouter)

app.use('/', (request, response) => {
  response.send('<h1>Welcome to my express backend app.</h1>')
})

app.listen(4000, '0.0.0.0', () => {
  console.log('server started on port 4000')
})
