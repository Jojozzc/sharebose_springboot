# interface
##
   状态码code（服务器端返回）

    状态码 含义
    2001    成功
    
    
    4001    账号或密码错误
    4002    访问缺少必要参数
    
    5001    服务器错误
    
    6001    已经是好友
    6002    不存在此微博
## 登录部分(测试)
    1. 获取公钥
	方法 GET
	URL: xxx.xxx.xxx.xxx:8080/blog/login/publicKey
	无参数
	返回值:json
	格式:{publicKey:'xxxxxxxxxx'}
	2. 登录
    方法 POST
    URL: xxx.xxx.xxx.xxx:8080/blog/login
	参数            备注 
	userId          用公钥加密的账号
	pw              用公钥加密的密码
	
	返回值
	code 
	
	
	
	