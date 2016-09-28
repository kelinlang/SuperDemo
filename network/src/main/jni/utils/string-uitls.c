//
// Created by Administrator on 2016/9/28 0028.
//

#include <malloc.h>
#include <string.h>
#include "string-uitls.h"

char* byteToString(char array[]){
    char* string;
    string = (char*)malloc(sizeof(char) * sizeof(array) + 1);
    strncpy(string, array, sizeof(array));
    return string;
}
