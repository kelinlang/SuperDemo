//
// Created by Administrator on 2016/9/26 0026.
//

#include "SimpleServer.h"

#include <android/log.h>


#define  LOG_TAG    "kelinlang"
#define LOGV(...) __android_log_print(ANDROID_LOG_VERBOSE, LOG_TAG, __VA_ARGS__)
#define LOGD(...) __android_log_print(ANDROID_LOG_DEBUG  , LOG_TAG, __VA_ARGS__)
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO   , LOG_TAG, __VA_ARGS__)
#define LOGW(...) __android_log_print(ANDROID_LOG_WARN   , LOG_TAG, __VA_ARGS__)
#define LOGE(...) __android_log_print(ANDROID_LOG_ERROR  , LOG_TAG, __VA_ARGS__)

static  int runFlag = 1;

void * startServer(void *arg){
    runFlag = 1;
    while (runFlag == 1){
        LOGD("I am looper");
    }
}

void * stopServer(void *arg){
    runFlag = 0;
}