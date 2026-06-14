package a;

import android.os.Build;
import android.widget.EdgeEffect;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class hj {
    public static void a(EdgeEffect edgeEffect, float f, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            edgeEffect.onPull(f, f2);
        } else {
            edgeEffect.onPull(f);
        }
    }
}
