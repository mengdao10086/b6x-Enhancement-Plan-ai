package androidx.core.view;

import android.graphics.Rect;
import android.view.Gravity;

/* JADX INFO: loaded from: classes2.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f5024a = 8388608;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f5025b = 8388611;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f5026c = 8388613;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f5027d = 8388615;

    @g.v0(17)
    public static class a {
        @g.u
        public static void a(int i10, int i11, int i12, Rect rect, int i13, int i14, Rect rect2, int i15) {
            Gravity.apply(i10, i11, i12, rect, i13, i14, rect2, i15);
        }

        @g.u
        public static void b(int i10, int i11, int i12, Rect rect, Rect rect2, int i13) {
            Gravity.apply(i10, i11, i12, rect, rect2, i13);
        }

        @g.u
        public static void c(int i10, Rect rect, Rect rect2, int i11) {
            Gravity.applyDisplay(i10, rect, rect2, i11);
        }
    }

    public static void a(int i10, int i11, int i12, @g.n0 Rect rect, int i13, int i14, @g.n0 Rect rect2, int i15) {
        a.a(i10, i11, i12, rect, i13, i14, rect2, i15);
    }

    public static void b(int i10, int i11, int i12, @g.n0 Rect rect, @g.n0 Rect rect2, int i13) {
        a.b(i10, i11, i12, rect, rect2, i13);
    }

    public static void c(int i10, @g.n0 Rect rect, @g.n0 Rect rect2, int i11) {
        a.c(i10, rect, rect2, i11);
    }

    public static int d(int i10, int i11) {
        return Gravity.getAbsoluteGravity(i10, i11);
    }
}
