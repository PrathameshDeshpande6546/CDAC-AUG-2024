const express=require('express');
const utils = require('./db');
// const config=require('./config')
// const utils=require('./utils')
// constuser=require('user')

const user=require('./routes/user')
const categoryRouter=require('./routes/category')
const app=express();
const bookingRouter=require('./routes/booking')
const propertyRouter=require('./routes/property')

app.use(express.json());
const userRouter=require('./routes/user')
app.use('/user',userRouter)
app.use('/category',categoryRouter)
app.use('/booking',bookingRouter)
app.use('/property',propertyRouter)
app.use('/profile/:id',userRouter)
app.use('/profile/:userId',userRouter)
// app.use(cors())
// app.use(express.json())

app.use((request,response,next)=>{
    if (
        request.url==='/user/login' ||
        request.url === '/user/register' ||
        request.url.startsWith('user/image/')
        || request.url.startsWith('/booking/')
       

    ) {
        next()
    }
    else (
        console.log("success")

)
})


app.listen(9999, () => {
    console.log('Server is running on port 9999');
});
