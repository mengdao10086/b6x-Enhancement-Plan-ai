package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f {
    public static final String A = "motionProgress";
    public static final String B = "transitionEasing";
    public static final String C = "visibility";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f3644f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f3645g = "alpha";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f3646h = "elevation";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f3647i = "rotation";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f3648j = "rotationX";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f3649k = "rotationY";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f3650l = "transformPivotX";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f3651m = "transformPivotY";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f3652n = "transitionPathRotate";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f3653o = "scaleX";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f3654p = "scaleY";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f3655q = "wavePeriod";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f3656r = "waveOffset";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f3657s = "wavePhase";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f3658t = "waveVariesBy";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f3659u = "translationX";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f3660v = "translationY";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f3661w = "translationZ";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f3662x = "progress";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f3663y = "CUSTOM";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f3664z = "curveFit";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3666b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f3667c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3668d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public HashMap<String, ConstraintAttribute> f3669e;

    public f() {
        int i10 = f3644f;
        this.f3665a = i10;
        this.f3666b = i10;
        this.f3667c = null;
    }

    public abstract void a(HashMap<String, a0.d> splines);

    @Override // 
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public abstract f clone();

    public f c(f src) {
        this.f3665a = src.f3665a;
        this.f3666b = src.f3666b;
        this.f3667c = src.f3667c;
        this.f3668d = src.f3668d;
        this.f3669e = src.f3669e;
        return this;
    }

    public abstract void d(HashSet<String> attributes);

    public int e() {
        return this.f3665a;
    }

    public abstract void f(Context context, AttributeSet attrs);

    public boolean g(String constraintTag) {
        String str = this.f3667c;
        if (str == null || constraintTag == null) {
            return false;
        }
        return constraintTag.matches(str);
    }

    public void h(int pos) {
        this.f3665a = pos;
    }

    public void i(HashMap<String, Integer> interpolation) {
    }

    public abstract void j(String tag, Object value);

    public f k(int id2) {
        this.f3666b = id2;
        return this;
    }

    public boolean l(Object value) {
        return value instanceof Boolean ? ((Boolean) value).booleanValue() : Boolean.parseBoolean(value.toString());
    }

    public float m(Object value) {
        return value instanceof Float ? ((Float) value).floatValue() : Float.parseFloat(value.toString());
    }

    public int n(Object value) {
        return value instanceof Integer ? ((Integer) value).intValue() : Integer.parseInt(value.toString());
    }
}
