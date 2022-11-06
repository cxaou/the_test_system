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

### 3. 运行

编写DockerFile文件

```dockerfile
# Docker image for springboot file run
# VERSION 0.0.1
# Author: eangulee
# 基础镜像使用java
FROM openjdk:8
# 作者
MAINTAINER cxaou <2576353248@qq.com>
# VOLUME 指定了临时文件目录为/tmp。
# 其效果是在主机 /var/lib/docker 目录下创建了一个临时文件，并链接到容器的/tmp
VOLUME /tmp 
# 将jar包添加到容器中并更名为the_test_system.jar
ADD  the_test_system-0.0.1-SNAPSHOT.jar  /the_test_system.jar 
# 运行jar包
RUN bash -c 'touch /the_test_system.jar'
ENV TZ 'Asia/Shanghai'p
EXPOSE 8080
ENTRYPOINT ["java","-jar","/the_test_system.jar"]

```

打包镜像

```shell
docker build -t the_test_system:v1 .
```

运行

```shell
docker run --name   the_test_system -d  -p 8080:8080 the_test_system:v1 
```

