package g2;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;
import androidx.core.view.u0;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final androidx.transition.z f28991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f28992b = "ViewUtils";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Property<View, Float> f28993c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Property<View, Rect> f28994d;

    public class a extends Property<View, Float> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(z.c(view));
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f10) {
            z.h(view, f10.floatValue());
        }
    }

    public class b extends Property<View, Rect> {
        public b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Rect get(View view) {
            return u0.P(view);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Rect rect) {
            u0.M1(view, rect);
        }
    }

    static {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 29) {
            f28991a = new e0();
        } else if (i10 >= 23) {
            f28991a = new d0();
        } else if (i10 >= 22) {
            f28991a = new c0();
        } else {
            f28991a = new b0();
        }
        f28993c = new a(Float.class, "translationAlpha");
        f28994d = new b(Rect.class, "clipBounds");
    }

    public static void a(@n0 View view) {
        f28991a.a(view);
    }

    public static y b(@n0 View view) {
        return new x(view);
    }

    public static float c(@n0 View view) {
        return f28991a.c(view);
    }

    public static i0 d(@n0 View view) {
        return new h0(view);
    }

    public static void e(@n0 View view) {
        f28991a.d(view);
    }

    public static void f(@n0 View view, @p0 Matrix matrix) {
        f28991a.e(view, matrix);
    }

    public static void g(@n0 View view, int i10, int i11, int i12, int i13) {
        f28991a.f(view, i10, i11, i12, i13);
    }

    public static void h(@n0 View view, float f10) {
        f28991a.g(view, f10);
    }

    public static void i(@n0 View view, int i10) {
        f28991a.h(view, i10);
    }

    public static void j(@n0 View view, @n0 Matrix matrix) {
        f28991a.i(view, matrix);
    }

    public static void k(@n0 View view, @n0 Matrix matrix) {
        f28991a.j(view, matrix);
    }
}
