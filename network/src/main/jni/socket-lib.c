//
// Created by Administrator on 2016/9/26 0026.
//

#include <stdint.h>
#include "socket-lib.h"
#include "socket/SimpleClient.h"
#include "socket/SimpleServer.h"
#include <pthread.h>
#include <android/log.h>


#define  LOG_TAG    "kelinlang"
#define LOGV(...) __android_log_print(ANDROID_LOG_VERBOSE, LOG_TAG, __VA_ARGS__)
#define LOGD(...) __android_log_print(ANDROID_LOG_DEBUG  , LOG_TAG, __VA_ARGS__)
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO   , LOG_TAG, __VA_ARGS__)
#define LOGW(...) __android_log_print(ANDROID_LOG_WARN   , LOG_TAG, __VA_ARGS__)
#define LOGE(...) __android_log_print(ANDROID_LOG_ERROR  , LOG_TAG, __VA_ARGS__)


/*
 * Class:     com_kelinlang_network_socket_SocketDemo
 * Method:    startServer
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_kelinlang_network_socket_SocketDemo_startServer
        (JNIEnv *env, jobject jobject1){
    int i = 0;
    LOGD("I am in");
    pthread_t pt;
    pthread_attr_t attr;
    pthread_attr_init(&attr);
    pthread_attr_setdetachstate(&attr, PTHREAD_CREATE_DETACHED);
    pthread_create(&pt, &attr, &startServer, NULL);
}

/*
 * Class:     com_kelinlang_network_socket_SocketDemo
 * Method:    stopServer
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_kelinlang_network_socket_SocketDemo_stopServer
        (JNIEnv *env, jobject jobject1){
    stopServer(NULL);
}

/*
 * Class:     com_kelinlang_network_socket_SocketDemo
 * Method:    startClient
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_kelinlang_network_socket_SocketDemo_startClient
        (JNIEnv *env, jobject jobject1){
    pthread_t pt;
    pthread_attr_t attr;
    pthread_attr_init(&attr);
    pthread_attr_setdetachstate(&attr, PTHREAD_CREATE_DETACHED);
    pthread_create(&pt, &attr, &startClient, NULL);
}

/*
 * Class:     com_kelinlang_network_socket_SocketDemo
 * Method:    stopClient
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_kelinlang_network_socket_SocketDemo_stopClient
        (JNIEnv *env, jobject jobject1){
    stopClient(NULL);
}