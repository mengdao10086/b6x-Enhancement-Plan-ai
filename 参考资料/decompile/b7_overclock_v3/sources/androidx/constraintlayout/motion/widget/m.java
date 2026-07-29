package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R;
import com.blankj.utilcode.util.i0;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class m extends f {
    public static final String Y = "KeyTrigger";
    public static final String Z = "KeyTrigger";

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final String f3773a0 = "viewTransitionOnCross";

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final String f3774b0 = "viewTransitionOnPositiveCross";

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final String f3775c0 = "viewTransitionOnNegativeCross";

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final String f3776d0 = "postLayout";

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final String f3777e0 = "triggerSlack";

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final String f3778f0 = "triggerCollisionView";

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final String f3779g0 = "triggerCollisionId";

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final String f3780h0 = "triggerID";

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final String f3781i0 = "positiveCross";

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final String f3782j0 = "negativeCross";

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final String f3783k0 = "triggerReceiver";

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public static final String f3784l0 = "CROSS";

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final int f3785m0 = 5;
    public int D = -1;
    public String E = null;
    public int F;
    public String G;
    public String H;
    public int I;
    public int J;
    public View K;
    public float L;
    public boolean M;
    public boolean N;
    public boolean O;
    public float P;
    public float Q;
    public boolean R;
    public int S;
    public int T;
    public int U;
    public RectF V;
    public RectF W;
    public HashMap<String, Method> X;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f3786a = 1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f3787b = 2;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f3788c = 4;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f3789d = 5;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f3790e = 6;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f3791f = 7;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f3792g = 8;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f3793h = 9;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f3794i = 10;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final int f3795j = 11;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final int f3796k = 12;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final int f3797l = 13;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final int f3798m = 14;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static SparseIntArray f3799n;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f3799n = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyTrigger_framePosition, 8);
            f3799n.append(R.styleable.KeyTrigger_onCross, 4);
            f3799n.append(R.styleable.KeyTrigger_onNegativeCross, 1);
            f3799n.append(R.styleable.KeyTrigger_onPositiveCross, 2);
            f3799n.append(R.styleable.KeyTrigger_motionTarget, 7);
            f3799n.append(R.styleable.KeyTrigger_triggerId, 6);
            f3799n.append(R.styleable.KeyTrigger_triggerSlack, 5);
            f3799n.append(R.styleable.KeyTrigger_motion_triggerOnCollision, 9);
            f3799n.append(R.styleable.KeyTrigger_motion_postLayoutCollision, 10);
            f3799n.append(R.styleable.KeyTrigger_triggerReceiver, 11);
            f3799n.append(R.styleable.KeyTrigger_viewTransitionOnCross, 12);
            f3799n.append(R.styleable.KeyTrigger_viewTransitionOnNegativeCross, 13);
            f3799n.append(R.styleable.KeyTrigger_viewTransitionOnPositiveCross, 14);
        }

        public static void a(m c10, TypedArray a10, Context context) {
            int indexCount = a10.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = a10.getIndex(i10);
                switch (f3799n.get(index)) {
                    case 1:
                        c10.G = a10.getString(index);
                        break;
                    case 2:
                        c10.H = a10.getString(index);
                        break;
                    case 3:
                    default:
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("unused attribute 0x");
                        sb2.append(Integer.toHexString(index));
                        sb2.append("   ");
                        sb2.append(f3799n.get(index));
                        break;
                    case 4:
                        c10.E = a10.getString(index);
                        break;
                    case 5:
                        c10.L = a10.getFloat(index, c10.L);
                        break;
                    case 6:
                        c10.I = a10.getResourceId(index, c10.I);
                        break;
                    case 7:
                        if (MotionLayout.f3495k9) {
                            int resourceId = a10.getResourceId(index, c10.f3666b);
                            c10.f3666b = resourceId;
                            if (resourceId == -1) {
                                c10.f3667c = a10.getString(index);
                            }
                        } else if (a10.peekValue(index).type == 3) {
                            c10.f3667c = a10.getString(index);
                        } else {
                            c10.f3666b = a10.getResourceId(index, c10.f3666b);
                        }
                        break;
                    case 8:
                        int integer = a10.getInteger(index, c10.f3665a);
                        c10.f3665a = integer;
                        c10.P = (integer + 0.5f) / 100.0f;
                        break;
                    case 9:
                        c10.J = a10.getResourceId(index, c10.J);
                        break;
                    case 10:
                        c10.R = a10.getBoolean(index, c10.R);
                        break;
                    case 11:
                        c10.F = a10.getResourceId(index, c10.F);
                        break;
                    case 12:
                        c10.U = a10.getResourceId(index, c10.U);
                        break;
                    case 13:
                        c10.S = a10.getResourceId(index, c10.S);
                        break;
                    case 14:
                        c10.T = a10.getResourceId(index, c10.T);
                        break;
                }
            }
        }
    }

    public m() {
        int i10 = f.f3644f;
        this.F = i10;
        this.G = null;
        this.H = null;
        this.I = i10;
        this.J = i10;
        this.K = null;
        this.L = 0.1f;
        this.M = true;
        this.N = true;
        this.O = true;
        this.P = Float.NaN;
        this.R = false;
        this.S = i10;
        this.T = i10;
        this.U = i10;
        this.V = new RectF();
        this.W = new RectF();
        this.X = new HashMap<>();
        this.f3668d = 5;
        this.f3669e = new HashMap<>();
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void A(float r10, android.view.View r11) {
        /*
            Method dump skipped, instruction units count: 357
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.m.A(float, android.view.View):void");
    }

    public final void B(String str, View call) {
        Method method;
        if (str == null) {
            return;
        }
        if (str.startsWith(j3.b.f36044h)) {
            C(str, call);
            return;
        }
        if (this.X.containsKey(str)) {
            method = this.X.get(str);
            if (method == null) {
                return;
            }
        } else {
            method = null;
        }
        if (method == null) {
            try {
                method = call.getClass().getMethod(str, new Class[0]);
                this.X.put(str, method);
            } catch (NoSuchMethodException unused) {
                this.X.put(str, null);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Could not find method \"");
                sb2.append(str);
                sb2.append("\"on class ");
                sb2.append(call.getClass().getSimpleName());
                sb2.append(i0.f11861z);
                sb2.append(c.k(call));
                return;
            }
        }
        try {
            method.invoke(call, new Object[0]);
        } catch (Exception unused2) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Exception in call \"");
            sb3.append(this.E);
            sb3.append("\"on class ");
            sb3.append(call.getClass().getSimpleName());
            sb3.append(i0.f11861z);
            sb3.append(c.k(call));
        }
    }

    public final void C(String str, View view) {
        boolean z10 = str.length() == 1;
        if (!z10) {
            str = str.substring(1).toLowerCase(Locale.ROOT);
        }
        for (String str2 : this.f3669e.keySet()) {
            String lowerCase = str2.toLowerCase(Locale.ROOT);
            if (z10 || lowerCase.matches(str)) {
                ConstraintAttribute constraintAttribute = this.f3669e.get(str2);
                if (constraintAttribute != null) {
                    constraintAttribute.a(view);
                }
            }
        }
    }

    public int D() {
        return this.D;
    }

    public final void E(RectF rect, View child, boolean postLayout) {
        rect.top = child.getTop();
        rect.bottom = child.getBottom();
        rect.left = child.getLeft();
        rect.right = child.getRight();
        if (postLayout) {
            child.getMatrix().mapRect(rect);
        }
    }

    @Override // androidx.constraintlayout.motion.widget.f
    public void a(HashMap<String, a0.d> splines) {
    }

    @Override // androidx.constraintlayout.motion.widget.f
    /* JADX INFO: renamed from: b */
    public f clone() {
        return new m().c(this);
    }

    @Override // androidx.constraintlayout.motion.widget.f
    public f c(f src) {
        super.c(src);
        m mVar = (m) src;
        this.D = mVar.D;
        this.E = mVar.E;
        this.F = mVar.F;
        this.G = mVar.G;
        this.H = mVar.H;
        this.I = mVar.I;
        this.J = mVar.J;
        this.K = mVar.K;
        this.L = mVar.L;
        this.M = mVar.M;
        this.N = mVar.N;
        this.O = mVar.O;
        this.P = mVar.P;
        this.Q = mVar.Q;
        this.R = mVar.R;
        this.V = mVar.V;
        this.W = mVar.W;
        this.X = mVar.X;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.f
    public void d(HashSet<String> attributes) {
    }

    @Override // androidx.constraintlayout.motion.widget.f
    public void f(Context context, AttributeSet attrs) {
        a.a(this, context.obtainStyledAttributes(attrs, R.styleable.KeyTrigger), context);
    }

    @Override // androidx.constraintlayout.motion.widget.f
    public void j(String tag, Object value) {
        tag.hashCode();
        switch (tag) {
            case "positiveCross":
                this.H = value.toString();
                break;
            case "viewTransitionOnPositiveCross":
                this.T = n(value);
                break;
            case "triggerCollisionId":
                this.J = n(value);
                break;
            case "triggerID":
                this.I = n(value);
                break;
            case "negativeCross":
                this.G = value.toString();
                break;
            case "triggerCollisionView":
                this.K = (View) value;
                break;
            case "viewTransitionOnNegativeCross":
                this.S = n(value);
                break;
            case "CROSS":
                this.E = value.toString();
                break;
            case "triggerSlack":
                this.L = m(value);
                break;
            case "viewTransitionOnCross":
                this.U = n(value);
                break;
            case "postLayout":
                this.R = l(value);
                break;
            case "triggerReceiver":
                this.F = n(value);
                break;
        }
    }
}
