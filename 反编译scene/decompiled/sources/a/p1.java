package a;

import android.content.res.Configuration;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class p1 {
    public static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
        int i = configuration.densityDpi;
        int i2 = configuration2.densityDpi;
        if (i != i2) {
            configuration3.densityDpi = i2;
        }
    }
}
