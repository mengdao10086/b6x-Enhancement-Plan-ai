package com.blankj.utilcode.util;

import android.media.AudioManager;
import android.os.Build;

/* JADX INFO: loaded from: classes2.dex */
public class o1 {
    public static int a(int i10) {
        return ((AudioManager) j1.a().getSystemService("audio")).getStreamMaxVolume(i10);
    }

    public static int b(int i10) {
        AudioManager audioManager = (AudioManager) j1.a().getSystemService("audio");
        if (Build.VERSION.SDK_INT >= 28) {
            return audioManager.getStreamMinVolume(i10);
        }
        return 0;
    }

    public static int c(int i10) {
        return ((AudioManager) j1.a().getSystemService("audio")).getStreamVolume(i10);
    }

    public static void d(int i10, int i11, int i12) {
        try {
            ((AudioManager) j1.a().getSystemService("audio")).setStreamVolume(i10, i11, i12);
        } catch (SecurityException unused) {
        }
    }
}
