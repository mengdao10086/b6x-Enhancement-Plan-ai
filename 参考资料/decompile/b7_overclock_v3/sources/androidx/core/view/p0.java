package androidx.core.view;

import android.view.ScaleGestureDetector;

/* JADX INFO: loaded from: classes2.dex */
public final class p0 {

    @g.v0(19)
    public static class a {
        @g.u
        public static boolean a(ScaleGestureDetector scaleGestureDetector) {
            return scaleGestureDetector.isQuickScaleEnabled();
        }

        @g.u
        public static void b(ScaleGestureDetector scaleGestureDetector, boolean z10) {
            scaleGestureDetector.setQuickScaleEnabled(z10);
        }
    }

    public static boolean a(@g.n0 ScaleGestureDetector scaleGestureDetector) {
        return a.a(scaleGestureDetector);
    }

    @Deprecated
    public static boolean b(Object obj) {
        return a((ScaleGestureDetector) obj);
    }

    public static void c(@g.n0 ScaleGestureDetector scaleGestureDetector, boolean z10) {
        a.b(scaleGestureDetector, z10);
    }

    @Deprecated
    public static void d(Object obj, boolean z10) {
        c((ScaleGestureDetector) obj, z10);
    }
}
