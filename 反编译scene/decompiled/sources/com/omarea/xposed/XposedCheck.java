package com.omarea.xposed;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class XposedCheck {
    public static int check;

    public static boolean xposedIsRunning() {
        check %= 1;
        return false;
    }
}
