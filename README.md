# the_test_system

## 考试系统后台管理

该考试系统的目前只开发了后端，后端的接口文档展示使用用了swagger技术，需要看接口的，可以等服务运行起来访问

http://localhost:8080/doc.html  查看接口，前端页面后续会慢慢开发的，也可以自己开发前端页面练习练习

### 1. 环境

数据库的关系可以看er图，er图在项目图的**er图文件下面**

数据库的SQL文件在 **sql**文件夹下面

### 2. 配置

如果想要用腾讯的短信服务只需要修改如下配置文件即可

```yaml
SSM: # 配置是否开启短信验证，默认false ，不开启会在控制台输出
  StartSSM: false
```

如果需要使用用腾讯的短信验证码服务，需要自行配置一个配置文件  

```properties
# 腾讯云账户 secrtId，secretKey
tencent.sms.secretId=
tencent.sms.keysecret=
# 短信应用ID：短信SdkAppId在 【短信控制台】添加应用后生成实际的SdkAppId
tencent.sms.smsSdkAppId=
# 短信签名内容：使用UTF-8编码，必须填写已审核通过的签名，签名内容是中文，推荐转换为Unicode编码，使用工具转化,不转码的话可能会报错https://tools.ijkxs.com/tools/unicode
tencent.sms.signName=
# 模板ID：必须是已经审核通过的模板ID
tencent.sms.templateId=


```

 上传的配置文件中没有配置redis跟mysql的配置，需要自行配置

```yaml
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: 
    username: 
    password:
  redis:
    database: 0
    url: 
    client-type: jedis
    jedis:
      pool:
        max-active: 10
  profiles:
    active: dev


```

