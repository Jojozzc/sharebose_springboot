
//导入http模块
var http = require('http');
var fs = require('fs');

//创建http server,并传入回调函数
var server = http.createServer(function(request,response) {
        //回调函数接收request和response对象
        //获得HTTP请求的method和url
  
        console.log(request.method + ':' + request.url);
        if(request.url === '/') {
        response.writeHead(200,{'Content-Type':'text/html'});
        fs.readFile('./index.html','utf-8',function(err,data) {
            if(err) throw err;
            response.write(data);
            response.end();

        });
    } else {
        response.setHeader('Access-Control-Allow-Origin','*');
        response.writeHead(200,{'Content-Type':'text/plain'});
        fs.readFile('./main.html','utf-8',function(err,data) {
            if(err) throw err;
            response.write(data);
            response.end();

        });
    }
});

server.listen(8080);
console.log('Server is running at http://127.0.0.1:8080');