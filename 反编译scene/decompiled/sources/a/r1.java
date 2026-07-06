package a;

import android.content.res.Configuration;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class r1 {
    public static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
        int i = configuration.colorMode & 3;
        int i2 = configuration2.colorMode;
        if (i != (i2 & 3)) {
            configuration3.colorMode |= i2 & 3;
        }
        int i3 = configuration.colorMode & 12;
        int i4 = configuration2.colorMode;
        if (i3 != (i4 & 12)) {
            configuration3.colorMode |= i4 & 12;
        }
    }
}
