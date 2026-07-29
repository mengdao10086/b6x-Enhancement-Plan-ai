package b1;

import android.graphics.Path;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import g.n0;
import g.u;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    @v0(21)
    public static class a {
        @u
        public static PathInterpolator a(float f10, float f11) {
            return new PathInterpolator(f10, f11);
        }

        @u
        public static PathInterpolator b(float f10, float f11, float f12, float f13) {
            return new PathInterpolator(f10, f11, f12, f13);
        }

        @u
        public static PathInterpolator c(Path path) {
            return new PathInterpolator(path);
        }
    }

    @n0
    public static Interpolator a(float f10, float f11) {
        return a.a(f10, f11);
    }

    @n0
    public static Interpolator b(float f10, float f11, float f12, float f13) {
        return a.b(f10, f11, f12, f13);
    }

    @n0
    public static Interpolator c(@n0 Path path) {
        return a.c(path);
    }
}
