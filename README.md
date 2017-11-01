### 峳课课程微服务

    安装maven，设置aliyun镜像
    安装docker，设置网易镜像 hub-mirror.c.163.com
    mvn clean package docker:build -Dmaven.test.skip=true
    docker image ls
    docker run --name ykcourse1 -p 8080:8080 --link mariadb -d youkke/ykcourse
    docker logs -f ykcourse1
    或者
    docker-compose up -d
    docker-compose stop
    导出
    docker save -o xxx.tar xxx
    导入
    docker load --input xxx.tar