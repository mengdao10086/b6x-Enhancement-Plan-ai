package com.omarea.vtools;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class SceneJNI {
    static {
        System.loadLibrary("native-lib");
    }

    public final native long getKernelPropLong(String str);
}
