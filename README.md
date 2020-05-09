# SecurityBoot-API
SpringBoot+SpringSecurity实现前后端分离+图片验证码
先调用获取kaptcha图片验证码：http://localhost:8088/cloud/getVerify
在登录post请求：http://localhost:8088/cloud/login?username=admin&password=123456789qaz&vercode=2540
