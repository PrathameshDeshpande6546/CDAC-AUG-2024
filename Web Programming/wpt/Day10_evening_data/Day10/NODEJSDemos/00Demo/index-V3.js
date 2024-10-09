const fs = require('fs');

console.log("Hi...............");

fs.readdir("D:\\Sunbeam data\\wpt\\Day10\\Day10\\Demos",(error, result)=>
{
    if(error == null)
    {
        for(var i = 0; i <result.length; i++)
        {
            console.log(result[i]);
        }
    }
});


console.log("Bye...............");

