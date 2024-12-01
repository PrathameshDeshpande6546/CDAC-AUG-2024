const express = require('express')
const utils = require('../utils')
const db = require('../db')

const router = express.Router()

router.get('/', (request, response) => {
  const statement = `SELECT id, title, price, description FROM Product`
  db.pool.query(statement, (error, products) => {
    response.send(utils.createResult(error, products))
  })
})

module.exports = router
