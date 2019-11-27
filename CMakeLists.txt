##cmake版本
#cmake_minimum_required(VERSION 3.4.1)
##c++和C的版本
#set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")
#set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS}  -fopenmp")
#set(CMAKE_C_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")
#set(CMAKE_C_FLAGS "${CMAKE_CXX_FLAGS} -fopenmp")
##定义了两个全局路径
#file(GLOB OPEN_DOOR_SRC src/main/cpp/opendoor/*.cpp )
#file(GLOB OPEN_DOORM_SRC src/main/cpp/opendoorm/*.cpp )
##这句配置就能够生成opendoor的so文件并且制定资源路径
#add_library(opendoor
#    SHARED
#    src/main/cpp/opendoor/opendoor_jni.cpp
#    ${OPEN_DOOR_SRC})
##这句配置就能够生成opendoorm的so文件并且制定资源路径
#add_library(opendoorm
#    SHARED
#    src/main/cpp/opendoorm/opendoor_jni.cpp
#    ${OPEN_DOORM_SRC})
#
#target_link_libraries(
#    opendoor
#    log
#)
#target_link_libraries(
#    opendoorm
#    log
#)
#include_directories(src/main/cpp/opendoor)
#include_directories(src/main/cpp/opendoorm)
##
###set(CMAKE_ARCHIVE_OUTPUT_DIRECTORY ${CMAKE_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI})
###set(CMAKE_LIBRARY_OUTPUT_DIRECTORY ${CMAKE_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI})
##set(CMAKE_RUNTIME_OUTPUT_DIRECTORY ${CMAKE_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI})
##set(OPENCV_JNI_DIR ${CMAKE_SOURCE_DIR}/src/main/cpp/opencv/libs)
##
##include_directories(src/main/cpp/include
##                    src/main/cpp/opencv/jni/include/
##                    src/main/cpp/facedetect/
##                    src/main/cpp/facerecognize/
##                    src/main/cpp/opendoor/
##                    src/main/cpp/antispoofing/
##                    src/main/cpp/facedetectNew/
##                    src/main/cpp/tracker/detector/
##                    src/main/cpp/tracker/quality/
##                    src/main/cpp/tracker/tracker/
##                    src/main/cpp/tracker/utils/
##                    src/main/cpp/tracker/
##                    )
##
##file(GLOB FACE_DETECT_SRC src/main/cpp/facedetect/*.cpp )
##
##file(GLOB FACE_RECOGNIZE_SRC src/main/cpp/facerecognize/*.cpp )
##
##file(GLOB OPENDOOR_SRC  src/main/cpp/opendoor/*.cpp )
##
##file(GLOB OPENDOOR_EX_SRC  src/main/cpp/opendoorEx/*.cpp )
##
##
##file(GLOB ANTI_SPOOFING_SRC src/main/cpp/antispoofing/*.cpp )
##
##file(GLOB FACE_DETECT_NEW_SRC src/main/cpp/facedetectNew/*.cpp )
##
##file(GLOB TRACKER_SRC src/main/cpp/tracker/*.cpp
##                         src/main/cpp/tracker/detector/*.cpp
##                         src/main/cpp/tracker/tracker/*.cpp
##                         src/main/cpp/tracker/quality/*.cpp
##                         src/main/cpp/tracker/utils/*.cpp
##                         )
##
##
##find_library(log-lib log)
##
##add_library(libopencv_java3 SHARED IMPORTED)
##set_target_properties(libopencv_java3 PROPERTIES IMPORTED_LOCATION ${OPENCV_JNI_DIR}/${ANDROID_ABI}/libopencv_java3.so)
##
##add_library(opendoor SHARED ${OPENDOOR_SRC})
##(opendoor  z ${log-lib})
#
##add_library(newtracker SHARED ${TRACKER_SRC})
##target_link_libraries(newtracker libopencv_java3 libncnn z ${log-lib})
##add_executable(newtracker ${TRACKER_SRC})
##target_link_libraries(newtracker libopencv_java3 libncnn z ${log-lib})