const http=require('http');
const { stringify } = require('querystring');
 
var h=http.createServer((request,response)=>{
    console.log("You called for "+request.url);
    if(request.url=="/api/res"){

        var users=[{"Name":"Prathamesh"},
            {"Age":"25"},
            {"DOB":"31-05-2002"}]
        }
        response.setHeader("content-type","application/json")
response.write(JSON.stringify(users));
 
        response.end();
    }
)
h.listen(4000,()=>console.log("Executed"));
