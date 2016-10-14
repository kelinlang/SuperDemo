# Sets the minimum version of CMake required to build your native library.
# This ensures that a certain set of CMake features is available to
# your build.

cmake_minimum_required(VERSION 3.4.1)

# Specifies a library name, specifies whether the library is STATIC or
# SHARED, and provides relative paths to the source code. You can
# define multiple libraries by adding multiple add.library() commands,
# and CMake builds them for you. When you build your app, Gradle
# automatically packages shared libraries with your APK.

MESSAGE(STATUS "This is BINARY dir " ${HELLO_BINARY_DIR})

add_library( # Specifies the name of the library.
             ImageProc

             # Sets the library as a shared library.
             SHARED

             # Provides a relative path to your source file(s).
             src/main/jni/ImageProc/ImageProc.c


    src/main/jni/jpeg8d/jcapimin.c
    src/main/jni/jpeg8d/jcapistd.c
    src/main/jni/jpeg8d/jccoefct.c
    src/main/jni/jpeg8d/jccolor.c
    src/main/jni/jpeg8d/jcdctmgr.c
    src/main/jni/jpeg8d/jchuff.c
	src/main/jni/jpeg8d/jcinit.c
	src/main/jni/jpeg8d/jcmainct.c
	src/main/jni/jpeg8d/jcmarker.c
	src/main/jni/jpeg8d/jcmaster.c
	src/main/jni/jpeg8d/jcomapi.c
	src/main/jni/jpeg8d/jcparam.c
	src/main/jni/jpeg8d/jcprepct.c
	src/main/jni/jpeg8d/jcsample.c
	src/main/jni/jpeg8d/jctrans.c
	src/main/jni/jpeg8d/jdapimin.c
	src/main/jni/jpeg8d/jdapistd.c
	src/main/jni/jpeg8d/jdatadst.c
	src/main/jni/jpeg8d/jdatasrc.c
	src/main/jni/jpeg8d/jdcoefct.c
	src/main/jni/jpeg8d/jdcolor.c
	src/main/jni/jpeg8d/jddctmgr.c
	src/main/jni/jpeg8d/jdhuff.c
	src/main/jni/jpeg8d/jdinput.c
	src/main/jni/jpeg8d/jdmainct.c
	src/main/jni/jpeg8d/jdmarker.c
	src/main/jni/jpeg8d/jdmaster.c
	src/main/jni/jpeg8d/jdmerge.c
	src/main/jni/jpeg8d/jdpostct.c
	src/main/jni/jpeg8d/jdsample.c
	src/main/jni/jpeg8d/jdtrans.c
	src/main/jni/jpeg8d/jerror.c
	src/main/jni/jpeg8d/jfdctflt.c
	src/main/jni/jpeg8d/jfdctfst.c
	src/main/jni/jpeg8d/jfdctint.c
	src/main/jni/jpeg8d/jidctflt.c
	src/main/jni/jpeg8d/jidctfst.c
	src/main/jni/jpeg8d/jidctint.c
	src/main/jni/jpeg8d/jquant1.c
	src/main/jni/jpeg8d/jquant2.c
	src/main/jni/jpeg8d/jutils.c
	src/main/jni/jpeg8d/jmemmgr.c
	src/main/jni/jpeg8d/jcarith.c
	src/main/jni/jpeg8d/jdarith.c
	src/main/jni/jpeg8d/jaricom.c
             )

  # Specifies a path to native header files.
  include_directories(src/main/jni/ImageProc/)
  include_directories(src/main/jni/jpeg8d/)


  #ADD_SUBDIRECTORY(src/main/jni)

  find_library( # Defines the name of the path variable that stores the
                # location of the NDK library.
                log-lib

                # Specifies the name of the NDK library that
                # CMake needs to locate.
                log )

 # Links your native library against one or more other native libraries.
 target_link_libraries( # Specifies the target library.
                        ImageProc

                        # Links the log library to the target library.
                        ${log-lib} )


#add_library( app-glue
#             STATIC
#             ${ANDROID_NDK}/sources/android/native_app_glue/android_native_app_glue.c )
#
# You need to link static libraries against your shared native library.
#target_link_libraries( native-lib app-glue ${log-lib} )
