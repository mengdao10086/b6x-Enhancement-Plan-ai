package a;

import android.content.Context;
import android.graphics.Color;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class sw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f7437a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f2930a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f2931a;
    public final int b;

    public sw(Context context) {
        this.f2931a = my.b(context, zu.elevationOverlayEnabled, false);
        this.f2930a = iw.a(context, zu.elevationOverlayColor, 0);
        this.b = iw.a(context, zu.colorSurface, 0);
        this.f7437a = context.getResources().getDisplayMetrics().density;
    }

    public float a(float f) {
        if (this.f7437a <= 0.0f || f <= 0.0f) {
            return 0.0f;
        }
        return Math.min(((((float) Math.log1p(f / r0)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
    }

    public int b(int i, float f) {
        float fA = a(f);
        return tc.d(iw.f(tc.d(i, 255), this.f2930a, fA), Color.alpha(i));
    }

    public int c(int i, float f) {
        return (this.f2931a && e(i)) ? b(i, f) : i;
    }

    public boolean d() {
        return this.f2931a;
    }

    public final boolean e(int i) {
        return tc.d(i, 255) == this.b;
    }
}
