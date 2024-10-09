const express = require("express");
// console.log(express);
const mysql=require('mysql2');
var app = express();
const cd = {
  host: "localhost",
  user: "root",
  password: "manager",
  database: "web",
  port: 3306
};

app.get("/employees", (request, response) => {
const conn=mysql.createConnection();
  const q = `select * from employees`;
  conn.query(q, (err, result) => {
    response.setHeader("content-type", "application/json");
    if (err == null) {
      response.write(JSON.stringify(result));
      response.end();
    } else {
      response.write("Error");
      response.end();
    }
  });
  response.write("EMPLOYEE requested using GET");
});
conn.end();

// app.post("/employees", (request, response)=>{
//     response.write("EMPLOYEE requested using POST");
//     response.end();
// });
// app.put("/employees", (request, response)=>{
//     response.write("EMPLOYEE requested using PUT");
//     response.end();
// });
// app.delete("/employees", (request, response)=>{
//     response.write("EMPLOYEE requested using DELETE");
//     response.end();
// });
// app.listen(9999, ()=>{console.log("server started at port 9999")});
// const exp=require('express');
// const { createConnection } = require('mysql2');
// var app=express();
