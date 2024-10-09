
const mysql=require('mysql2');
var cD={
    host:"localhost",
    database:"web",
    user:"root",
    password:"manager",
    port:"3306"

};

var conn=mysql.createConnection(cD);
conn.connect();
var query='insert into employees values(1,"Prathamesh","Kagal");'
conn.query(query,(error,result)=>
{
    if(error==null){
        console.log(JSON.stringify(result));
    }else{
        console.log("Invalid broo");
    }
});
conn.end();