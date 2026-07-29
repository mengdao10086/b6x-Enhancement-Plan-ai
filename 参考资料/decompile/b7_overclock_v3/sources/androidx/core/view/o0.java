package androidx.core.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.PointerIcon;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes2.dex */
public final class o0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f5058b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f5059c = 1000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f5060d = 1001;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f5061e = 1002;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f5062f = 1003;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f5063g = 1004;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f5064h = 1006;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f5065i = 1007;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f5066j = 1008;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f5067k = 1009;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f5068l = 1010;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f5069m = 1011;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f5070n = 1012;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f5071o = 1013;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f5072p = 1014;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f5073q = 1015;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f5074r = 1016;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f5075s = 1017;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f5076t = 1018;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f5077u = 1019;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f5078v = 1020;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f5079w = 1021;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f5080x = 1000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PointerIcon f5081a;

    @g.v0(24)
    public static class a {
        @g.u
        public static PointerIcon a(Bitmap bitmap, float f10, float f11) {
            return PointerIcon.create(bitmap, f10, f11);
        }

        @g.u
        public static PointerIcon b(Context context, int i10) {
            return PointerIcon.getSystemIcon(context, i10);
        }

        @g.u
        public static PointerIcon c(Resources resources, int i10) {
            return PointerIcon.load(resources, i10);
        }
    }

    public o0(PointerIcon pointerIcon) {
        this.f5081a = pointerIcon;
    }

    @g.n0
    public static o0 a(@g.n0 Bitmap bitmap, float f10, float f11) {
        return Build.VERSION.SDK_INT >= 24 ? new o0(a.a(bitmap, f10, f11)) : new o0(null);
    }

    @g.n0
    public static o0 c(@g.n0 Context context, int i10) {
        return Build.VERSION.SDK_INT >= 24 ? new o0(a.b(context, i10)) : new o0(null);
    }

    @g.n0
    public static o0 d(@g.n0 Resources resources, int i10) {
        return Build.VERSION.SDK_INT >= 24 ? new o0(a.c(resources, i10)) : new o0(null);
    }

    @g.p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public Object b() {
        return this.f5081a;
    }
}
