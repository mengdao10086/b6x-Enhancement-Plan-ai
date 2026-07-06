package a;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class kv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TimeInterpolator f6644a = new LinearInterpolator();
    public static final TimeInterpolator b = new an();
    public static final TimeInterpolator c = new zm();
    public static final TimeInterpolator d = new bn();
    public static final TimeInterpolator e = new DecelerateInterpolator();

    public static float a(float f, float f2, float f3) {
        return f + (f3 * (f2 - f));
    }

    public static int b(int i, int i2, float f) {
        return i + Math.round(f * (i2 - i));
    }
}
