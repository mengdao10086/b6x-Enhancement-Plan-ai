package androidx.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.EdgeEffect;
import g.n0;
import g.p0;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EdgeEffect f5253a;

    @v0(21)
    public static class a {
        private a() {
        }

        @g.u
        public static void a(EdgeEffect edgeEffect, float f10, float f11) {
            edgeEffect.onPull(f10, f11);
        }
    }

    @v0(31)
    public static class b {
        private b() {
        }

        @g.u
        public static EdgeEffect a(Context context, AttributeSet attributeSet) {
            try {
                return new EdgeEffect(context, attributeSet);
            } catch (Throwable unused) {
                return new EdgeEffect(context);
            }
        }

        @g.u
        public static float b(EdgeEffect edgeEffect) {
            try {
                return edgeEffect.getDistance();
            } catch (Throwable unused) {
                return 0.0f;
            }
        }

        @g.u
        public static float c(EdgeEffect edgeEffect, float f10, float f11) {
            try {
                return edgeEffect.onPullDistance(f10, f11);
            } catch (Throwable unused) {
                edgeEffect.onPull(f10, f11);
                return 0.0f;
            }
        }
    }

    @Deprecated
    public j(Context context) {
        this.f5253a = new EdgeEffect(context);
    }

    @n0
    public static EdgeEffect a(@n0 Context context, @p0 AttributeSet attributeSet) {
        return Build.VERSION.SDK_INT >= 31 ? b.a(context, attributeSet) : new EdgeEffect(context);
    }

    public static float d(@n0 EdgeEffect edgeEffect) {
        if (Build.VERSION.SDK_INT >= 31) {
            return b.b(edgeEffect);
        }
        return 0.0f;
    }

    public static void g(@n0 EdgeEffect edgeEffect, float f10, float f11) {
        a.a(edgeEffect, f10, f11);
    }

    public static float j(@n0 EdgeEffect edgeEffect, float f10, float f11) {
        if (Build.VERSION.SDK_INT >= 31) {
            return b.c(edgeEffect, f10, f11);
        }
        g(edgeEffect, f10, f11);
        return f10;
    }

    @Deprecated
    public boolean b(Canvas canvas) {
        return this.f5253a.draw(canvas);
    }

    @Deprecated
    public void c() {
        this.f5253a.finish();
    }

    @Deprecated
    public boolean e() {
        return this.f5253a.isFinished();
    }

    @Deprecated
    public boolean f(int i10) {
        this.f5253a.onAbsorb(i10);
        return true;
    }

    @Deprecated
    public boolean h(float f10) {
        this.f5253a.onPull(f10);
        return true;
    }

    @Deprecated
    public boolean i(float f10, float f11) {
        g(this.f5253a, f10, f11);
        return true;
    }

    @Deprecated
    public boolean k() {
        this.f5253a.onRelease();
        return this.f5253a.isFinished();
    }

    @Deprecated
    public void l(int i10, int i11) {
        this.f5253a.setSize(i10, i11);
    }
}
