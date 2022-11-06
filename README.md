# the_test_system

## 考试系统后台管理

该考试系统的目前只开发了后端，后端的接口文档展示使用用了swagger技术，需要看接口的，可以等服务运行起来访问

http://localhost:8080/doc.html  查看接口，前端页面后续会慢慢开发的，也可以自己开发前端页面练习练习

### 1. 环境

数据库的关系可以看er图，er图在项目图的**er图文件下面**

数据库的SQL文件在 **sql**文件夹下面

### 2. 配置

#### 1. 如果想要用腾讯的短信服务只需要修改如下配置文件即可

```yaml
SSM: # 配置是否开启短信验证，默认false ，不开启会在控制台输出
  StartSSM: false
```

#### 2. 如果需要使用用腾讯的短信验证码服务，需要自行配置一个配置文件  

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

#### 3. 上传的配置文件中没有配置redis跟mysql的配置，需要自行配置

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

#### 4. swagger在生产过程中不希望开启可以修改配置文件

默认值是false

```yaml
swagger:
  enable: true # 是否开启swagger
```

#### 5. docker映射配置文件

在jar包的同级目录下建立一个config目录，在config目录下创建一个application.yaml 目录，在该文件中可以修改配置

### 3. 运行

编写DockerFile文件

```dockerfile
FROM  openjdk:8
# author 作者
MAINTAINER cxaou

# 挂载目录，宿主机目录，我这里是jar包目录
VOLUME /project/the_test_system
# 指定路径，docker容器里jar包的目录
WORKDIR /project/the_test_system

# 添加jar到镜像并命名为the_test_system.jar
ADD the_test_system-0.0.1-SNAPSHOT.jar  the_test_system.jar
#在docker容器里创建和宿主机同样的配置文件的目录, jar包要和config目录同级
CMD mkdir /project/the_test_system/config
# 启动服务
ENTRYPOINT ["java","-jar","the_test_system.jar"]

```

打包镜像

```shell
docker build -t the_test_system:v1 .
```

运行

```shell
docker run -d -p 8080:8080 -v /project/the_test_system/config:/project/the_test_system/config --name the_test_system the_test_system:v1
```

