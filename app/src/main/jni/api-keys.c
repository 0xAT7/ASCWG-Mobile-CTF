#include <jni.h>

JNIEXPORT jstring JNICALL
Java_com_ctf_ascwg_MyBroadcastReceiver_getKeys(JNIEnv *env, jobject thiz) {
    return (*env)-> NewStringUTF(env, "ASCWG{C0mplete_Me_");
}

JNIEXPORT jstring JNICALL
Java_com_ctf_ascwg_AnotherActivity_getKeys(JNIEnv *env, jobject thiz) {
    return (*env)-> NewStringUTF(env, "N!cE_C4tCH_R3v3rsEr}");
}