package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class j extends k {
    public static final String R = "KeyPosition";
    public static final String S = "KeyPosition";
    public static final int T = 2;
    public static final int U = 1;
    public static final int V = 0;
    public static final String W = "transitionEasing";
    public static final String X = "drawPath";
    public static final String Y = "percentWidth";
    public static final String Z = "percentHeight";

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final String f3728a0 = "sizePercent";

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final String f3729b0 = "percentX";

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final String f3730c0 = "percentY";

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final int f3731d0 = 2;
    public String F = null;
    public int G = f.f3644f;
    public int H = 0;
    public float I = Float.NaN;
    public float J = Float.NaN;
    public float K = Float.NaN;
    public float L = Float.NaN;
    public float M = Float.NaN;
    public float N = Float.NaN;
    public int O = 0;
    public float P = Float.NaN;
    public float Q = Float.NaN;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f3732a = 1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f3733b = 2;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f3734c = 3;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f3735d = 4;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f3736e = 5;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f3737f = 6;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f3738g = 7;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f3739h = 8;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f3740i = 9;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final int f3741j = 10;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final int f3742k = 11;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final int f3743l = 12;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static SparseIntArray f3744m;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f3744m = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyPosition_motionTarget, 1);
            f3744m.append(R.styleable.KeyPosition_framePosition, 2);
            f3744m.append(R.styleable.KeyPosition_transitionEasing, 3);
            f3744m.append(R.styleable.KeyPosition_curveFit, 4);
            f3744m.append(R.styleable.KeyPosition_drawPath, 5);
            f3744m.append(R.styleable.KeyPosition_percentX, 6);
            f3744m.append(R.styleable.KeyPosition_percentY, 7);
            f3744m.append(R.styleable.KeyPosition_keyPositionType, 9);
            f3744m.append(R.styleable.KeyPosition_sizePercent, 8);
            f3744m.append(R.styleable.KeyPosition_percentWidth, 11);
            f3744m.append(R.styleable.KeyPosition_percentHeight, 12);
            f3744m.append(R.styleable.KeyPosition_pathMotionArc, 10);
        }

        public static void b(j c10, TypedArray a10) {
            int indexCount = a10.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = a10.getIndex(i10);
                switch (f3744m.get(index)) {
                    case 1:
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
                    case 2:
                        c10.f3665a = a10.getInt(index, c10.f3665a);
                        break;
                    case 3:
                        if (a10.peekValue(index).type == 3) {
                            c10.F = a10.getString(index);
                        } else {
                            c10.F = w.d.f53426o[a10.getInteger(index, 0)];
                        }
                        break;
                    case 4:
                        c10.D = a10.getInteger(index, c10.D);
                        break;
                    case 5:
                        c10.H = a10.getInt(index, c10.H);
                        break;
                    case 6:
                        c10.K = a10.getFloat(index, c10.K);
                        break;
                    case 7:
                        c10.L = a10.getFloat(index, c10.L);
                        break;
                    case 8:
                        float f10 = a10.getFloat(index, c10.J);
                        c10.I = f10;
                        c10.J = f10;
                        break;
                    case 9:
                        c10.O = a10.getInt(index, c10.O);
                        break;
                    case 10:
                        c10.G = a10.getInt(index, c10.G);
                        break;
                    case 11:
                        c10.I = a10.getFloat(index, c10.I);
                        break;
                    case 12:
                        c10.J = a10.getFloat(index, c10.J);
                        break;
                    default:
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("unused attribute 0x");
                        sb2.append(Integer.toHexString(index));
                        sb2.append("   ");
                        sb2.append(f3744m.get(index));
                        break;
                }
            }
            int i11 = c10.f3665a;
        }
    }

    public j() {
        this.f3668d = 2;
    }

    @Override // androidx.constraintlayout.motion.widget.f
    public void a(HashMap<String, a0.d> splines) {
    }

    @Override // androidx.constraintlayout.motion.widget.f
    /* JADX INFO: renamed from: b */
    public f clone() {
        return new j().c(this);
    }

    @Override // androidx.constraintlayout.motion.widget.f
    public f c(f src) {
        super.c(src);
        j jVar = (j) src;
        this.F = jVar.F;
        this.G = jVar.G;
        this.H = jVar.H;
        this.I = jVar.I;
        this.J = Float.NaN;
        this.K = jVar.K;
        this.L = jVar.L;
        this.M = jVar.M;
        this.N = jVar.N;
        this.P = jVar.P;
        this.Q = jVar.Q;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.f
    public void f(Context context, AttributeSet attrs) {
        a.b(this, context.obtainStyledAttributes(attrs, R.styleable.KeyPosition));
    }

    @Override // androidx.constraintlayout.motion.widget.f
    public void j(String tag, Object value) {
        tag.hashCode();
        switch (tag) {
            case "transitionEasing":
                this.F = value.toString();
                break;
            case "percentWidth":
                this.I = m(value);
                break;
            case "percentHeight":
                this.J = m(value);
                break;
            case "drawPath":
                this.H = n(value);
                break;
            case "sizePercent":
                float fM = m(value);
                this.I = fM;
                this.J = fM;
                break;
            case "percentX":
                this.K = m(value);
                break;
            case "percentY":
                this.L = m(value);
                break;
        }
    }

    @Override // androidx.constraintlayout.motion.widget.k
    public void o(int layoutWidth, int layoutHeight, float start_x, float start_y, float end_x, float end_y) {
        int i10 = this.O;
        if (i10 == 1) {
            u(start_x, start_y, end_x, end_y);
        } else if (i10 != 2) {
            t(start_x, start_y, end_x, end_y);
        } else {
            v(layoutWidth, layoutHeight);
        }
    }

    @Override // androidx.constraintlayout.motion.widget.k
    public float p() {
        return this.P;
    }

    @Override // androidx.constraintlayout.motion.widget.k
    public float q() {
        return this.Q;
    }

    @Override // androidx.constraintlayout.motion.widget.k
    public boolean r(int layoutWidth, int layoutHeight, RectF start, RectF end, float x10, float y10) {
        o(layoutWidth, layoutHeight, start.centerX(), start.centerY(), end.centerX(), end.centerY());
        return Math.abs(x10 - this.P) < 20.0f && Math.abs(y10 - this.Q) < 20.0f;
    }

    @Override // androidx.constraintlayout.motion.widget.k
    public void s(View view, RectF start, RectF end, float x10, float y10, String[] attribute, float[] value) {
        int i10 = this.O;
        if (i10 == 1) {
            x(start, end, x10, y10, attribute, value);
        } else if (i10 != 2) {
            w(start, end, x10, y10, attribute, value);
        } else {
            y(view, start, end, x10, y10, attribute, value);
        }
    }

    public final void t(float start_x, float start_y, float end_x, float end_y) {
        float f10 = end_x - start_x;
        float f11 = end_y - start_y;
        float f12 = Float.isNaN(this.K) ? 0.0f : this.K;
        float f13 = Float.isNaN(this.N) ? 0.0f : this.N;
        float f14 = Float.isNaN(this.L) ? 0.0f : this.L;
        this.P = (int) (start_x + (f12 * f10) + ((Float.isNaN(this.M) ? 0.0f : this.M) * f11));
        this.Q = (int) (start_y + (f10 * f13) + (f11 * f14));
    }

    public final void u(float start_x, float start_y, float end_x, float end_y) {
        float f10 = end_x - start_x;
        float f11 = end_y - start_y;
        float f12 = this.K;
        float f13 = this.L;
        this.P = start_x + (f10 * f12) + ((-f11) * f13);
        this.Q = start_y + (f11 * f12) + (f10 * f13);
    }

    public final void v(int layoutWidth, int layoutHeight) {
        float f10 = this.K;
        float f11 = 0;
        this.P = ((layoutWidth - 0) * f10) + f11;
        this.Q = ((layoutHeight - 0) * f10) + f11;
    }

    public void w(RectF start, RectF end, float x10, float y10, String[] attribute, float[] value) {
        float fCenterX = start.centerX();
        float fCenterY = start.centerY();
        float fCenterX2 = end.centerX() - fCenterX;
        float fCenterY2 = end.centerY() - fCenterY;
        if (attribute[0] == null) {
            attribute[0] = "percentX";
            value[0] = (x10 - fCenterX) / fCenterX2;
            attribute[1] = "percentY";
            value[1] = (y10 - fCenterY) / fCenterY2;
            return;
        }
        if ("percentX".equals(attribute[0])) {
            value[0] = (x10 - fCenterX) / fCenterX2;
            value[1] = (y10 - fCenterY) / fCenterY2;
        } else {
            value[1] = (x10 - fCenterX) / fCenterX2;
            value[0] = (y10 - fCenterY) / fCenterY2;
        }
    }

    public void x(RectF start, RectF end, float x10, float y10, String[] attribute, float[] value) {
        float fCenterX = start.centerX();
        float fCenterY = start.centerY();
        float fCenterX2 = end.centerX() - fCenterX;
        float fCenterY2 = end.centerY() - fCenterY;
        float fHypot = (float) Math.hypot(fCenterX2, fCenterY2);
        if (fHypot < 1.0E-4d) {
            System.out.println("distance ~ 0");
            value[0] = 0.0f;
            value[1] = 0.0f;
            return;
        }
        float f10 = fCenterX2 / fHypot;
        float f11 = fCenterY2 / fHypot;
        float f12 = y10 - fCenterY;
        float f13 = x10 - fCenterX;
        float f14 = ((f10 * f12) - (f13 * f11)) / fHypot;
        float f15 = ((f10 * f13) + (f11 * f12)) / fHypot;
        if (attribute[0] != null) {
            if ("percentX".equals(attribute[0])) {
                value[0] = f15;
                value[1] = f14;
                return;
            }
            return;
        }
        attribute[0] = "percentX";
        attribute[1] = "percentY";
        value[0] = f15;
        value[1] = f14;
    }

    public void y(View view, RectF start, RectF end, float x10, float y10, String[] attribute, float[] value) {
        start.centerX();
        start.centerY();
        end.centerX();
        end.centerY();
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        int width = viewGroup.getWidth();
        int height = viewGroup.getHeight();
        if (attribute[0] == null) {
            attribute[0] = "percentX";
            value[0] = x10 / width;
            attribute[1] = "percentY";
            value[1] = y10 / height;
            return;
        }
        if ("percentX".equals(attribute[0])) {
            value[0] = x10 / width;
            value[1] = y10 / height;
        } else {
            value[1] = x10 / width;
            value[0] = y10 / height;
        }
    }

    public void z(int type) {
        this.O = type;
    }
}
