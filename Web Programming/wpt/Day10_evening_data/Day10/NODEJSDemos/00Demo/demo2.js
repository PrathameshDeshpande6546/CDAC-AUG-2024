const { error } = require('console');
const fs=require('fs');
const { resourceLimits } = require('worker_threads');
fs.readdir("D:\\Sunbeam data\\wpt\\Day10\\Day10\\Demos",(error,result)=>{
    if(error==null){
        for(var i=0;i<result.length;i++){
            console.log(result[i]);
        }

    }
});