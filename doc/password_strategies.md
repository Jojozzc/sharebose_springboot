传输过程采用RSA加密
服务器端生成一对公钥和密钥，把公钥发给客户端，客户端利用公钥将密码加密后发送给服务器

数据库存储中的加密，将明文密码进行MD5加密后存如数据库
比对密码时现将密码进行MD5加密，用密文进行匹配。

密码限定为8位ASCII中的部分可打印字符，不能包括中文，所有字符和约束如下
        1. 所有英文字母（大小写）a-z，A-Z
	2. 所有数字0-9
	3. 部分标点 !@#$%^&*()_+-=*
	4. 密码长度为8~16位，必须至少包含数字和字母