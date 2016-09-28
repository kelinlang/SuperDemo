//
// Created by Administrator on 2016/9/26 0026.
//

#include "SimpleServer.h"
#include <stdio.h>
#include<stdlib.h>
#include <string.h>
#include <errno.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <android/log.h>
#include <pthread.h>
#include<unistd.h>

#include "../log/log.h"
#include "string-uitls.h"

#define DEFAULT_PORT 8000
#define MAXLINE 4096

static int runFlag = 1;


void do_receive(int connect_fd);

void receive_data(int *connect_fd);

void *startServer(void *arg) {
    int socket_fd, connect_fd;
    struct sockaddr_in servaddr;


    if (socket_fd = socket(AF_INET, SOCK_STREAM, IPPROTO_TCP) == -1) {
        LOGD("创建服务套字失败");
        return NULL;
    }

    memset(&servaddr, 0, sizeof(servaddr));
    servaddr.sin_family = AF_INET;
    servaddr.sin_addr.s_addr = htonl(INADDR_ANY);
    servaddr.sin_port = htonl(DEFAULT_PORT);

    if (bind(socket_fd, (struct sockaddr *) &servaddr, sizeof(servaddr)) == -1) {
        LOGD("创建服务套字绑定失败");
        return NULL;
    }

    if (listen(socket_fd, 10) == -1) {
        LOGD("创建服务套字监听失败");
        return NULL;
    }

    runFlag = 1;
    while (runFlag) {
        if ((connect_fd = accept(socket_fd, (struct sockaddr *) NULL, NULL)) == -1) {
            LOGD("等待连接失败");
            do_receive(connect_fd);
        }
    }
}

void do_receive(int connect_fd) {
    pthread_t pt;
    pthread_attr_t attr;
    pthread_attr_init(&attr);
    pthread_attr_setdetachstate(&attr, PTHREAD_CREATE_DETACHED);
    pthread_create(&pt, &attr, &receive_data, &connect_fd);
}


void receive_data(int *connect_fd) {
    int n;
    char buff[MAXLINE];
    while (runFlag) {
        n = recv(*connect_fd, buff, MAXLINE, 0);
        /*char read[n];
        strncpy(read, buff, n);
        char *readString = byteToString(read);*/
        buff[n] = "\0";
        LOGD("client->server 收到字符串：%s", buff);

        if (send(connect_fd, "I back client", 14, 0) == -1) {
            close(connect_fd);
            runFlag = 0;
        }
    }
    close(*connect_fd);
}

void *stopServer(void *arg) {
    runFlag = 0;
}