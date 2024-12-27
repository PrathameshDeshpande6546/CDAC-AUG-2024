const express=require('express')
const db=require('../db')
const utils=require('../utils')


const multer=require('multer')
const upload=multer({dest:'images'})
const router=express.Router()

router.get('/',(request,response)=>{
    const statement=`select id,title,details,image from category;`
    db.pool.query(statement,(error,categories)=>{
        response.send(utils.createResult(error,categories))
    })
})
//use the middleware (upload) to upload a single 'icon'
router.post('/',upload.single('icon'),(request,response)=>{
    const {title,details}=request.body
    //get the name of uploaded file
    // const fileName=request.file.filename
    const fileName=request.file.filename
    const statement=`insert into category (title,details,image) values(?,?,?)`
    db.pool.execute(
        statement,[title,details,filename],(error,categories)=>{
            response.send(utils.createResult(error,categories))
        }
    )
    
})
module.exports=router