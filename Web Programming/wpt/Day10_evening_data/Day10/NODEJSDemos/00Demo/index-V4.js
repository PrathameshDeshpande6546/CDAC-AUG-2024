const http = require('http');
// console.log(http);

var helper =  http.createServer((request, response)=>{
    console.log("u called for " + request.url);
    if(request.url == "/api/users")
    {
        response.write("This is my reply!");//we can also print json,html code // if we want multiple line then use back tikc(``)
        // response.end();
    }
    else
    {
        response.write("pratik other reply!");
        response.end();
    }
});
helper.listen(9999,()=>{console.log("Server started at port no 9999");}) //executes first 