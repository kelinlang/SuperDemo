//
// Created by Administrator on 2016/9/21 0021.
//


#include "test.h"
#include <android/log.h>
#include <stdio.h>
#include <string.h>
#include "com_kelinlang_superdemo_MainActivity.h"

#define  LOG_TAG    "kelinlang"
#define LOGV(...) __android_log_print(ANDROID_LOG_VERBOSE, LOG_TAG, __VA_ARGS__)
#define LOGD(...) __android_log_print(ANDROID_LOG_DEBUG  , LOG_TAG, __VA_ARGS__)
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO   , LOG_TAG, __VA_ARGS__)
#define LOGW(...) __android_log_print(ANDROID_LOG_WARN   , LOG_TAG, __VA_ARGS__)
#define LOGE(...) __android_log_print(ANDROID_LOG_ERROR  , LOG_TAG, __VA_ARGS__)

char *getSting();


// java中的jstring, 转化为c的一个字符数组
char*   Jstring2CStr(JNIEnv*   env,   jstring   jstr)
{
    char*   rtn   =   NULL;
    jclass   clsstring   =   (*env)->FindClass(env,"java/lang/String");
    jstring   strencode   =   (*env)->NewStringUTF(env,"GB2312");
    jmethodID   mid   =   (*env)->GetMethodID(env,clsstring,   "getBytes",   "(Ljava/lang/String;)[B");
    jbyteArray   barr=   (jbyteArray)(*env)->CallObjectMethod(env,jstr,mid,strencode); // String .getByte("GB2312");
    jsize   alen   =   (*env)->GetArrayLength(env,barr);
    jbyte*   ba   =   (*env)->GetByteArrayElements(env,barr,JNI_FALSE);
    if(alen   >   0)
    {
        rtn   =   (char*)malloc(alen+1);         //new   char[alen+1]; "\0"
        memcpy(rtn,ba,alen);
        rtn[alen]=0;
    }
    (*env)->ReleaseByteArrayElements(env,barr,ba,0);  //释放内存

    return rtn;
}




JNIEXPORT jstring JNICALL Java_com_kelinlang_superdemo_MainActivity_stringFromJNI
        (JNIEnv *env, jobject jo) {
    char *hello = "";
    return (*env)->NewStringUTF(env, hello);
}


char * fun1(char * p)
{
    printf("%s\n",p);
    return p;
}
char * fun2(char * p)
{
    printf("%s\n",p);
    return p;
}

char * fun3(char * p)
{
    printf("%s\n",p);
    return p;
}

char * fun(char * p1,char * p2)
{
    int i = 0;
    i = strcmp(p1,p2);
    if (0 == i)
    {
        return p1;
    }
    else
    {
        return p2;
    }
}

JNIEXPORT jstring JNICALL Java_com_kelinlang_superdemo_MainActivity_get
        (JNIEnv *env, jobject jo, jstring jstring1){
   /* char buf[128];
     const jchar *cbyte;
    cbyte = (*env)->GetStringChars(env,jstring1, JNI_FALSE);
    if(cbyte == NULL){
        return NULL;
    }
//    LOGD("传了%s", cbyte);
    (*env)->ReleaseStringChars(env, jstring1,cbyte);*/
//    scanf("%127s",buf);




    int a[5]={1,2,3,4,5};
    int *ptr=(int *)(&a+1);
    printf("%d,%d",*(a+1),*(ptr-1));



    char *(*pf)(char* p1, char* p2);
    pf = &fun;

    (*pf)("wo", "ni");








    return (*env)->NewStringUTF(env,"hell");
}


JNIEXPORT jstring JNICALL  Java_com_kelinlang_superdemo_MainActivity_getLine(JNIEnv *env, jobject obj, jstring prompt)
{
    char buf[128];
    const jbyte *str;
    str = (*env)->GetStringUTFChars(env, prompt, NULL);
    if (str == NULL) { //不要忘记检测，否则分配内存失败会抛出异常
        return NULL; /* OutOfMemoryError already thrown */
    }
    printf("%s", str);

    const   char* get;
   get = (*env)->GetStringChars(env,prompt,NULL);



    char* p = "ddd";
    LOGD("传了%s",p);
//    LOGD("传了%s",str);
    (*env)->ReleaseStringUTFChars(env, prompt, str);

    /* We assume here that the user does not type more than  * 127 characters */
    scanf("%s", buf);
    return (*env)->NewStringUTF(env, buf);
}