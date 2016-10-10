
    # 添加头文件的查找目录  
    INCLUDE_DIRECTORIES(${PROJECT_SOURCE_DIR}/RtmpDump/librtmp/)
    ## 生成各种目标(target)文件: 可执行文件、动态库、静态库  
    # 指定可执行文件的输出目录，输出到bin下面  
    SET(EXECUTABLE_OUTPUT_PATH ${PROJECT_SOURCE_DIR}/bin)

    #SET(SRC_LIST
    #            rtmpdump.c
    #            librtmp/rtmp.c
    #            librtmp/log.c
    #            librtmp/hashswf.c
    #            librtmp/amf.c)
#
    # 指定可执行文件名(hello)和相关源文件   
    ADD_EXECUTABLE(rtmpdump rtmpdump.c librtmp/rtmp.c librtmp/log.c librtmp/hashswf.c librtmp/amf.c)

    # 指定库文件输出路径  
    SET(LIBRARY_OUTPUT_PATH ${PROJECT_SOURCE_DIR}/lib)

    # 生成动态库  
    # 注意，前面已经使用target文件名hello，这里不能再用。  
    ADD_LIBRARY(rtmpdump_so SHARED rtmpdump.c)

    # 设置库输出名为 rtmpdump => librtmpdump.so
    SET_TARGET_PROPERTIES(rtmpdump_so PROPERTIES OUTPUT_NAME "rtmpdump")

    # 生成静态库  
    # 注意，前面已经使用target文件名hello，这里不能再用。  
    ADD_LIBRARY(rtmpdump_a STATIC rtmpdump.c)

    # 设置输库出名为 rtmpdump => librtmpdump.a
    SET_TARGET_PROPERTIES(rtmpdump_a PROPERTIES OUTPUT_NAME "rtmpdump")