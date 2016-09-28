//
// Created by Administrator on 2016/9/26 0026.
//

#include "SimpleClient.h"
#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<errno.h>
#include<sys/types.h>
#include<sys/socket.h>
#include<netinet/in.h>
#include <android/log.h>
#include<arpa/inet.h>
#include<unistd.h>

#include "../log/log.h"
#include "string-uitls.h"


#define MAXLINE 4096

int runFlag = 1;

void *startClient(void *arg) {
    int sockfd, n, rec_len;
    char recvline[4096], sendline[4096];
    char buf[MAXLINE];
    struct sockaddr_in servaddr;

    if ((sockfd = socket(AF_INET, SOCK_STREAM, 0)) < 0) {
        LOGD("创建客户端套接字失败");
    }

    memset(&servaddr, 0, sizeof(servaddr));
    servaddr.sin_family = AF_INET;
    servaddr.sin_port = htons(8000);
    if (inet_pton(AF_INET, "127.0.0.1", &servaddr.sin_addr) <= 0) {
        printf("inet_pton error for %s\n", "127.0.0.1");
        return NULL;
    }

    if (connect(sockfd, (struct sockaddr *) &servaddr, sizeof(servaddr)) < 0) {
        printf("connect error: %s(errno: %d)\n", strerror(errno), errno);
        return NULL;
    }
    runFlag = 1;
    while (runFlag) {
        if (send(sockfd, "I connect server", 17, 0) < 0) {
            LOGD("发送失败");
            runFlag = 0;
            close(sockfd);
            return NULL;
        }
        if((rec_len = recv(sockfd, buf, MAXLINE,0)) == -1) {
            LOGD("接收失败");
            runFlag = 0;
            close(sockfd);
            return NULL;
        }
        buf[rec_len]  = '\0';
        LOGD("server->client 收到数据：%s", buf);

        sleep(10);
    }
    close(sockfd);
}

void *stopClient(void *arg) {
    runFlag = 0;
}