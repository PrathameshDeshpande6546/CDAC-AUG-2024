
const express=require('express')
const db=require('../db');
// const mysql=require('mysql2')
const utils=require('../utils')
const jwt=require('jsonwebtoken')
const config=require('../config')
const crypto=require('crypto-js')

const router=express.Router() //create various types of route

router.put('/profile/:id',(request,response)=>{
    const{firstName,lastName,phoneNumber}=request.body
const statement=`update user set firstName=?,lastName=?,phoneNumber=? where id=?`
db.pool.execute(
    statement,[firstName,lastName,phoneNumber,request.params.id],(error,result)=>{
        console.log(error)
        response.send(utils.createResult(error,result))
    }
)
})

router.get('/profile/:userId',(request,response)=>{
    const statement=`SELECT firstName,lastName,phoneNumber,email FROM user WHERE id = ?`
    db.pool.execute(statement,[request.params.userId],(error,result)=>{
       console.log(error)
        response.send(utils.createResult(error,result))
    })
})



router.post('/register',(request,response)=>{
    const { firstName,lastName,email,password,phoneNumber
    } = request.body

const statement=`insert into user(firstName,lastName,email,password,phoneNumber) values(?,?,?,?,?)`;

db.pool.execute(statement,[firstName,lastName,email,password,phoneNumber],(error,result)=>{
    response.send(utils.createResult(error,result))
})
})


router.post('/login', (request, response) => {
    const { email, password } = request.body
    const statement = 'select id , firstName , lastName, phoneNumber, isDeleted from user where email = ? and password = ?'
    //const encryptedPassword=String(crypto.SHA256(password))
    //db.pool.query(statement,[email,encryptedPassword],(error,users)={})
    db.pool.query(statement, [email, password], (error, users) => {

        if (error) {
            response.send(utils.createErrorResult(error))
        } else {
            if (users.length == 0) {
                response.send(utils.createErrorResult('user does not exists'))
            } else {
                const user = users[0]
                if (user.isDeleted) {
                    response.send(utils.createErrorResult('your account is closed'))
                } else {
                    const payload = { id: user.id }
                    const token=jwt.sign(payload,config.secret)
                    const userData = {
                        token,
                        name: `${user['firstName']} ${user['lastName']}`,
                    }
                    response.send(utils.createSuccessResult(userData))
                }
            }
        }
    })
})



module.exports=router




