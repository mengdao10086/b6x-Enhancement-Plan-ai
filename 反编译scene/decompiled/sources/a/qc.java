package a;

import android.content.res.Resources;
import android.os.Build;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class qc {
    public static void a(Resources.Theme theme) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            pc.a(theme);
        } else if (i >= 23) {
            oc.a(theme);
        }
    }
}
