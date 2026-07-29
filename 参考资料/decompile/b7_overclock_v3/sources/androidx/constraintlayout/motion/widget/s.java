package androidx.constraintlayout.motion.widget;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.d;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import g.n0;
import java.util.Arrays;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class s implements Comparable<s> {
    public static final int A = 4;
    public static final int B = 5;
    public static final int C = 1;
    public static final int D = 0;
    public static String[] K0 = {CommonNetImpl.POSITION, "x", "y", SocializeProtocolConstants.WIDTH, SocializeProtocolConstants.HEIGHT, "pathRotate"};

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final int f3874k0 = 2;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f3875t = "MotionPaths";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final boolean f3876u = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final boolean f3877v = false;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f3878w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f3879x = 1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f3880y = 2;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f3881z = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public w.d f3882a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f3884c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f3885d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f3886e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f3887f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f3888g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f3889h;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f3892k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f3893l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f3894m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public o f3895n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public LinkedHashMap<String, ConstraintAttribute> f3896o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f3897p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f3898q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public double[] f3899r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public double[] f3900s;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3883b = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f3890i = Float.NaN;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f3891j = Float.NaN;

    public s() {
        int i10 = f.f3644f;
        this.f3892k = i10;
        this.f3893l = i10;
        this.f3894m = Float.NaN;
        this.f3895n = null;
        this.f3896o = new LinkedHashMap<>();
        this.f3897p = 0;
        this.f3899r = new double[18];
        this.f3900s = new double[18];
    }

    public static final float A(float sin, float cos, float cx, float cy, float x10, float y10) {
        return ((x10 - cx) * sin) + ((y10 - cy) * cos) + cy;
    }

    public static final float y(float sin, float cos, float cx, float cy, float x10, float y10) {
        return (((x10 - cx) * cos) - ((y10 - cy) * sin)) + cx;
    }

    public void c(d.a c10) {
        this.f3882a = w.d.c(c10.f4294d.f4408d);
        d.c cVar = c10.f4294d;
        this.f3892k = cVar.f4409e;
        this.f3893l = cVar.f4406b;
        this.f3890i = cVar.f4413i;
        this.f3883b = cVar.f4410f;
        this.f3898q = cVar.f4407c;
        this.f3891j = c10.f4293c.f4423e;
        this.f3894m = c10.f4295e.D;
        for (String str : c10.f4297g.keySet()) {
            ConstraintAttribute constraintAttribute = c10.f4297g.get(str);
            if (constraintAttribute != null && constraintAttribute.n()) {
                this.f3896o.put(str, constraintAttribute);
            }
        }
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public int compareTo(@n0 s o10) {
        return Float.compare(this.f3885d, o10.f3885d);
    }

    public void e(o toOrbit) {
        toOrbit.A(this.f3891j);
    }

    public final boolean f(float a10, float b10) {
        return (Float.isNaN(a10) || Float.isNaN(b10)) ? Float.isNaN(a10) != Float.isNaN(b10) : Math.abs(a10 - b10) > 1.0E-6f;
    }

    public void g(s points, boolean[] mask, String[] custom, boolean arcMode) {
        boolean zF = f(this.f3886e, points.f3886e);
        boolean zF2 = f(this.f3887f, points.f3887f);
        mask[0] = mask[0] | f(this.f3885d, points.f3885d);
        boolean z10 = zF | zF2 | arcMode;
        mask[1] = mask[1] | z10;
        mask[2] = z10 | mask[2];
        mask[3] = mask[3] | f(this.f3888g, points.f3888g);
        mask[4] = f(this.f3889h, points.f3889h) | mask[4];
    }

    public void h(double[] data, int[] toUse) {
        float[] fArr = {this.f3885d, this.f3886e, this.f3887f, this.f3888g, this.f3889h, this.f3890i};
        int i10 = 0;
        for (int i11 = 0; i11 < toUse.length; i11++) {
            if (toUse[i11] < 6) {
                data[i10] = fArr[toUse[i11]];
                i10++;
            }
        }
    }

    public void i(int[] toUse, double[] data, float[] point, int offset) {
        float f10 = this.f3888g;
        float f11 = this.f3889h;
        for (int i10 = 0; i10 < toUse.length; i10++) {
            float f12 = (float) data[i10];
            int i11 = toUse[i10];
            if (i11 == 3) {
                f10 = f12;
            } else if (i11 == 4) {
                f11 = f12;
            }
        }
        point[offset] = f10;
        point[offset + 1] = f11;
    }

    public void j(double p10, int[] toUse, double[] data, float[] point, int offset) {
        float fSin = this.f3886e;
        float fCos = this.f3887f;
        float f10 = this.f3888g;
        float f11 = this.f3889h;
        for (int i10 = 0; i10 < toUse.length; i10++) {
            float f12 = (float) data[i10];
            int i11 = toUse[i10];
            if (i11 == 1) {
                fSin = f12;
            } else if (i11 == 2) {
                fCos = f12;
            } else if (i11 == 3) {
                f10 = f12;
            } else if (i11 == 4) {
                f11 = f12;
            }
        }
        o oVar = this.f3895n;
        if (oVar != null) {
            float[] fArr = new float[2];
            oVar.m(p10, fArr, new float[2]);
            float f13 = fArr[0];
            float f14 = fArr[1];
            double d10 = f13;
            double d11 = fSin;
            double d12 = fCos;
            fSin = (float) ((d10 + (Math.sin(d12) * d11)) - ((double) (f10 / 2.0f)));
            fCos = (float) ((((double) f14) - (d11 * Math.cos(d12))) - ((double) (f11 / 2.0f)));
        }
        point[offset] = fSin + (f10 / 2.0f) + 0.0f;
        point[offset + 1] = fCos + (f11 / 2.0f) + 0.0f;
    }

    public void k(double p10, int[] toUse, double[] data, float[] point, double[] vdata, float[] velocity) {
        float f10;
        float f11 = this.f3886e;
        float f12 = this.f3887f;
        float f13 = this.f3888g;
        float f14 = this.f3889h;
        float f15 = 0.0f;
        float f16 = 0.0f;
        float f17 = 0.0f;
        float f18 = 0.0f;
        for (int i10 = 0; i10 < toUse.length; i10++) {
            float f19 = (float) data[i10];
            float f20 = (float) vdata[i10];
            int i11 = toUse[i10];
            if (i11 == 1) {
                f11 = f19;
                f15 = f20;
            } else if (i11 == 2) {
                f12 = f19;
                f17 = f20;
            } else if (i11 == 3) {
                f13 = f19;
                f16 = f20;
            } else if (i11 == 4) {
                f14 = f19;
                f18 = f20;
            }
        }
        float f21 = 2.0f;
        float f22 = (f16 / 2.0f) + f15;
        float fCos = (f18 / 2.0f) + f17;
        o oVar = this.f3895n;
        if (oVar != null) {
            float[] fArr = new float[2];
            float[] fArr2 = new float[2];
            oVar.m(p10, fArr, fArr2);
            float f23 = fArr[0];
            float f24 = fArr[1];
            float f25 = fArr2[0];
            float f26 = fArr2[1];
            double d10 = f11;
            double d11 = f12;
            f10 = f13;
            float fSin = (float) ((((double) f23) + (Math.sin(d11) * d10)) - ((double) (f13 / 2.0f)));
            float fCos2 = (float) ((((double) f24) - (d10 * Math.cos(d11))) - ((double) (f14 / 2.0f)));
            double d12 = f15;
            double d13 = f17;
            float fSin2 = (float) (((double) f25) + (Math.sin(d11) * d12) + (Math.cos(d11) * d13));
            fCos = (float) ((((double) f26) - (d12 * Math.cos(d11))) + (Math.sin(d11) * d13));
            f22 = fSin2;
            f11 = fSin;
            f12 = fCos2;
            f21 = 2.0f;
        } else {
            f10 = f13;
        }
        point[0] = f11 + (f10 / f21) + 0.0f;
        point[1] = f12 + (f14 / f21) + 0.0f;
        velocity[0] = f22;
        velocity[1] = fCos;
    }

    public void l(double p10, int[] toUse, double[] data, float[] point, int offset) {
        float fSin = this.f3886e;
        float fCos = this.f3887f;
        float f10 = this.f3888g;
        float f11 = this.f3889h;
        for (int i10 = 0; i10 < toUse.length; i10++) {
            float f12 = (float) data[i10];
            int i11 = toUse[i10];
            if (i11 == 1) {
                fSin = f12;
            } else if (i11 == 2) {
                fCos = f12;
            } else if (i11 == 3) {
                f10 = f12;
            } else if (i11 == 4) {
                f11 = f12;
            }
        }
        o oVar = this.f3895n;
        if (oVar != null) {
            float[] fArr = new float[2];
            oVar.m(p10, fArr, new float[2]);
            float f13 = fArr[0];
            float f14 = fArr[1];
            double d10 = f13;
            double d11 = fSin;
            double d12 = fCos;
            fSin = (float) ((d10 + (Math.sin(d12) * d11)) - ((double) (f10 / 2.0f)));
            fCos = (float) ((((double) f14) - (d11 * Math.cos(d12))) - ((double) (f11 / 2.0f)));
        }
        point[offset] = fSin + (f10 / 2.0f) + 0.0f;
        point[offset + 1] = fCos + (f11 / 2.0f) + 0.0f;
    }

    public int m(String name, double[] value, int offset) {
        ConstraintAttribute constraintAttribute = this.f3896o.get(name);
        int i10 = 0;
        if (constraintAttribute == null) {
            return 0;
        }
        if (constraintAttribute.p() == 1) {
            value[offset] = constraintAttribute.k();
            return 1;
        }
        int iP = constraintAttribute.p();
        constraintAttribute.l(new float[iP]);
        while (i10 < iP) {
            value[offset] = r2[i10];
            i10++;
            offset++;
        }
        return iP;
    }

    public int n(String name) {
        ConstraintAttribute constraintAttribute = this.f3896o.get(name);
        if (constraintAttribute == null) {
            return 0;
        }
        return constraintAttribute.p();
    }

    public void o(int[] toUse, double[] data, float[] path, int offset) {
        float f10 = this.f3886e;
        float fCos = this.f3887f;
        float f11 = this.f3888g;
        float f12 = this.f3889h;
        for (int i10 = 0; i10 < toUse.length; i10++) {
            float f13 = (float) data[i10];
            int i11 = toUse[i10];
            if (i11 == 1) {
                f10 = f13;
            } else if (i11 == 2) {
                fCos = f13;
            } else if (i11 == 3) {
                f11 = f13;
            } else if (i11 == 4) {
                f12 = f13;
            }
        }
        o oVar = this.f3895n;
        if (oVar != null) {
            float fN = oVar.n();
            float fO = this.f3895n.o();
            double d10 = f10;
            double d11 = fCos;
            float fSin = (float) ((((double) fN) + (Math.sin(d11) * d10)) - ((double) (f11 / 2.0f)));
            fCos = (float) ((((double) fO) - (d10 * Math.cos(d11))) - ((double) (f12 / 2.0f)));
            f10 = fSin;
        }
        float f14 = f11 + f10;
        float f15 = f12 + fCos;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        int i12 = offset + 1;
        path[offset] = f10 + 0.0f;
        int i13 = i12 + 1;
        path[i12] = fCos + 0.0f;
        int i14 = i13 + 1;
        path[i13] = f14 + 0.0f;
        int i15 = i14 + 1;
        path[i14] = fCos + 0.0f;
        int i16 = i15 + 1;
        path[i15] = f14 + 0.0f;
        int i17 = i16 + 1;
        path[i16] = f15 + 0.0f;
        path[i17] = f10 + 0.0f;
        path[i17 + 1] = f15 + 0.0f;
    }

    public boolean p(String name) {
        return this.f3896o.containsKey(name);
    }

    public void q(j c10, s startTimePoint, s endTimePoint) {
        float f10 = c10.f3665a / 100.0f;
        this.f3884c = f10;
        this.f3883b = c10.H;
        float f11 = Float.isNaN(c10.I) ? f10 : c10.I;
        float f12 = Float.isNaN(c10.J) ? f10 : c10.J;
        float f13 = endTimePoint.f3888g;
        float f14 = startTimePoint.f3888g;
        float f15 = endTimePoint.f3889h;
        float f16 = startTimePoint.f3889h;
        this.f3885d = this.f3884c;
        float f17 = startTimePoint.f3886e;
        float f18 = startTimePoint.f3887f;
        float f19 = (endTimePoint.f3886e + (f13 / 2.0f)) - ((f14 / 2.0f) + f17);
        float f20 = (endTimePoint.f3887f + (f15 / 2.0f)) - (f18 + (f16 / 2.0f));
        float f21 = ((f13 - f14) * f11) / 2.0f;
        this.f3886e = (int) ((f17 + (f19 * f10)) - f21);
        float f22 = ((f15 - f16) * f12) / 2.0f;
        this.f3887f = (int) ((f18 + (f20 * f10)) - f22);
        this.f3888g = (int) (f14 + r9);
        this.f3889h = (int) (f16 + r12);
        float f23 = Float.isNaN(c10.K) ? f10 : c10.K;
        float f24 = Float.isNaN(c10.N) ? 0.0f : c10.N;
        if (!Float.isNaN(c10.L)) {
            f10 = c10.L;
        }
        float f25 = Float.isNaN(c10.M) ? 0.0f : c10.M;
        this.f3897p = 0;
        this.f3886e = (int) (((startTimePoint.f3886e + (f23 * f19)) + (f25 * f20)) - f21);
        this.f3887f = (int) (((startTimePoint.f3887f + (f19 * f24)) + (f20 * f10)) - f22);
        this.f3882a = w.d.c(c10.F);
        this.f3892k = c10.G;
    }

    public void r(j c10, s startTimePoint, s endTimePoint) {
        float f10 = c10.f3665a / 100.0f;
        this.f3884c = f10;
        this.f3883b = c10.H;
        float f11 = Float.isNaN(c10.I) ? f10 : c10.I;
        float f12 = Float.isNaN(c10.J) ? f10 : c10.J;
        float f13 = endTimePoint.f3888g - startTimePoint.f3888g;
        float f14 = endTimePoint.f3889h - startTimePoint.f3889h;
        this.f3885d = this.f3884c;
        if (!Float.isNaN(c10.K)) {
            f10 = c10.K;
        }
        float f15 = startTimePoint.f3886e;
        float f16 = startTimePoint.f3888g;
        float f17 = startTimePoint.f3887f;
        float f18 = startTimePoint.f3889h;
        float f19 = (endTimePoint.f3886e + (endTimePoint.f3888g / 2.0f)) - ((f16 / 2.0f) + f15);
        float f20 = (endTimePoint.f3887f + (endTimePoint.f3889h / 2.0f)) - ((f18 / 2.0f) + f17);
        float f21 = f19 * f10;
        float f22 = (f13 * f11) / 2.0f;
        this.f3886e = (int) ((f15 + f21) - f22);
        float f23 = f10 * f20;
        float f24 = (f14 * f12) / 2.0f;
        this.f3887f = (int) ((f17 + f23) - f24);
        this.f3888g = (int) (f16 + r7);
        this.f3889h = (int) (f18 + r8);
        float f25 = Float.isNaN(c10.L) ? 0.0f : c10.L;
        this.f3897p = 1;
        float f26 = (int) ((startTimePoint.f3886e + f21) - f22);
        float f27 = (int) ((startTimePoint.f3887f + f23) - f24);
        this.f3886e = f26 + ((-f20) * f25);
        this.f3887f = f27 + (f19 * f25);
        this.f3893l = this.f3893l;
        this.f3882a = w.d.c(c10.F);
        this.f3892k = c10.G;
    }

    public void s(int parentWidth, int parentHeight, j c10, s s10, s e10) {
        float fMin;
        float f10;
        float f11 = c10.f3665a / 100.0f;
        this.f3884c = f11;
        this.f3883b = c10.H;
        this.f3897p = c10.O;
        float f12 = Float.isNaN(c10.I) ? f11 : c10.I;
        float f13 = Float.isNaN(c10.J) ? f11 : c10.J;
        float f14 = e10.f3888g;
        float f15 = s10.f3888g;
        float f16 = e10.f3889h;
        float f17 = s10.f3889h;
        this.f3885d = this.f3884c;
        this.f3888g = (int) (f15 + ((f14 - f15) * f12));
        this.f3889h = (int) (f17 + ((f16 - f17) * f13));
        int i10 = c10.O;
        if (i10 == 1) {
            float f18 = Float.isNaN(c10.K) ? f11 : c10.K;
            float f19 = e10.f3886e;
            float f20 = s10.f3886e;
            this.f3886e = (f18 * (f19 - f20)) + f20;
            if (!Float.isNaN(c10.L)) {
                f11 = c10.L;
            }
            float f21 = e10.f3887f;
            float f22 = s10.f3887f;
            this.f3887f = (f11 * (f21 - f22)) + f22;
        } else if (i10 != 2) {
            float f23 = Float.isNaN(c10.K) ? f11 : c10.K;
            float f24 = e10.f3886e;
            float f25 = s10.f3886e;
            this.f3886e = (f23 * (f24 - f25)) + f25;
            if (!Float.isNaN(c10.L)) {
                f11 = c10.L;
            }
            float f26 = e10.f3887f;
            float f27 = s10.f3887f;
            this.f3887f = (f11 * (f26 - f27)) + f27;
        } else {
            if (Float.isNaN(c10.K)) {
                float f28 = e10.f3886e;
                float f29 = s10.f3886e;
                fMin = ((f28 - f29) * f11) + f29;
            } else {
                fMin = Math.min(f13, f12) * c10.K;
            }
            this.f3886e = fMin;
            if (Float.isNaN(c10.L)) {
                float f30 = e10.f3887f;
                float f31 = s10.f3887f;
                f10 = (f11 * (f30 - f31)) + f31;
            } else {
                f10 = c10.L;
            }
            this.f3887f = f10;
        }
        this.f3893l = s10.f3893l;
        this.f3882a = w.d.c(c10.F);
        this.f3892k = c10.G;
    }

    public void t(int parentWidth, int parentHeight, j c10, s startTimePoint, s endTimePoint) {
        float f10 = c10.f3665a / 100.0f;
        this.f3884c = f10;
        this.f3883b = c10.H;
        float f11 = Float.isNaN(c10.I) ? f10 : c10.I;
        float f12 = Float.isNaN(c10.J) ? f10 : c10.J;
        float f13 = endTimePoint.f3888g;
        float f14 = startTimePoint.f3888g;
        float f15 = endTimePoint.f3889h;
        float f16 = startTimePoint.f3889h;
        this.f3885d = this.f3884c;
        float f17 = startTimePoint.f3886e;
        float f18 = startTimePoint.f3887f;
        float f19 = endTimePoint.f3886e + (f13 / 2.0f);
        float f20 = endTimePoint.f3887f + (f15 / 2.0f);
        float f21 = (f13 - f14) * f11;
        this.f3886e = (int) ((f17 + ((f19 - ((f14 / 2.0f) + f17)) * f10)) - (f21 / 2.0f));
        float f22 = (f15 - f16) * f12;
        this.f3887f = (int) ((f18 + ((f20 - (f18 + (f16 / 2.0f))) * f10)) - (f22 / 2.0f));
        this.f3888g = (int) (f14 + f21);
        this.f3889h = (int) (f16 + f22);
        this.f3897p = 2;
        if (!Float.isNaN(c10.K)) {
            this.f3886e = (int) (c10.K * ((int) (parentWidth - this.f3888g)));
        }
        if (!Float.isNaN(c10.L)) {
            this.f3887f = (int) (c10.L * ((int) (parentHeight - this.f3889h)));
        }
        this.f3893l = this.f3893l;
        this.f3882a = w.d.c(c10.F);
        this.f3892k = c10.G;
    }

    public void u(float x10, float y10, float w10, float h10) {
        this.f3886e = x10;
        this.f3887f = y10;
        this.f3888g = w10;
        this.f3889h = h10;
    }

    public void v(float locationX, float locationY, float[] mAnchorDpDt, int[] toUse, double[] deltaData, double[] data) {
        float f10 = 0.0f;
        float f11 = 0.0f;
        float f12 = 0.0f;
        float f13 = 0.0f;
        for (int i10 = 0; i10 < toUse.length; i10++) {
            float f14 = (float) deltaData[i10];
            double d10 = data[i10];
            int i11 = toUse[i10];
            if (i11 == 1) {
                f10 = f14;
            } else if (i11 == 2) {
                f12 = f14;
            } else if (i11 == 3) {
                f11 = f14;
            } else if (i11 == 4) {
                f13 = f14;
            }
        }
        float f15 = f10 - ((0.0f * f11) / 2.0f);
        float f16 = f12 - ((0.0f * f13) / 2.0f);
        mAnchorDpDt[0] = (f15 * (1.0f - locationX)) + (((f11 * 1.0f) + f15) * locationX) + 0.0f;
        mAnchorDpDt[1] = (f16 * (1.0f - locationY)) + (((f13 * 1.0f) + f16) * locationY) + 0.0f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void w(float position, View view, int[] toUse, double[] data, double[] slope, double[] cycle, boolean mForceMeasure) {
        float f10;
        boolean z10;
        float f11;
        float f12 = this.f3886e;
        float f13 = this.f3887f;
        float f14 = this.f3888g;
        float f15 = this.f3889h;
        if (toUse.length != 0 && this.f3899r.length <= toUse[toUse.length - 1]) {
            int i10 = toUse[toUse.length - 1] + 1;
            this.f3899r = new double[i10];
            this.f3900s = new double[i10];
        }
        Arrays.fill(this.f3899r, Double.NaN);
        for (int i11 = 0; i11 < toUse.length; i11++) {
            this.f3899r[toUse[i11]] = data[i11];
            this.f3900s[toUse[i11]] = slope[i11];
        }
        float f16 = Float.NaN;
        int i12 = 0;
        float f17 = 0.0f;
        float f18 = 0.0f;
        float f19 = 0.0f;
        float f20 = 0.0f;
        while (true) {
            double[] dArr = this.f3899r;
            if (i12 >= dArr.length) {
                break;
            }
            if (Double.isNaN(dArr[i12]) && (cycle == null || cycle[i12] == 0.0d)) {
                f11 = f16;
            } else {
                double d10 = cycle != null ? cycle[i12] : 0.0d;
                if (!Double.isNaN(this.f3899r[i12])) {
                    d10 = this.f3899r[i12] + d10;
                }
                f11 = f16;
                float f21 = (float) d10;
                float f22 = (float) this.f3900s[i12];
                if (i12 == 1) {
                    f16 = f11;
                    f17 = f22;
                    f12 = f21;
                } else if (i12 == 2) {
                    f16 = f11;
                    f18 = f22;
                    f13 = f21;
                } else if (i12 == 3) {
                    f16 = f11;
                    f19 = f22;
                    f14 = f21;
                } else if (i12 == 4) {
                    f16 = f11;
                    f20 = f22;
                    f15 = f21;
                } else if (i12 == 5) {
                    f16 = f21;
                }
                i12++;
            }
            f16 = f11;
            i12++;
        }
        float f23 = f16;
        o oVar = this.f3895n;
        if (oVar != null) {
            float[] fArr = new float[2];
            float[] fArr2 = new float[2];
            oVar.m(position, fArr, fArr2);
            float f24 = fArr[0];
            float f25 = fArr[1];
            float f26 = fArr2[0];
            float f27 = fArr2[1];
            double d11 = f12;
            double d12 = f13;
            float fSin = (float) ((((double) f24) + (Math.sin(d12) * d11)) - ((double) (f14 / 2.0f)));
            f10 = f15;
            float fCos = (float) ((((double) f25) - (Math.cos(d12) * d11)) - ((double) (f15 / 2.0f)));
            double d13 = f17;
            double d14 = f18;
            float fSin2 = (float) (((double) f26) + (Math.sin(d12) * d13) + (Math.cos(d12) * d11 * d14));
            float fCos2 = (float) ((((double) f27) - (d13 * Math.cos(d12))) + (d11 * Math.sin(d12) * d14));
            if (slope.length >= 2) {
                z10 = false;
                slope[0] = fSin2;
                slope[1] = fCos2;
            } else {
                z10 = false;
            }
            if (!Float.isNaN(f23)) {
                view.setRotation((float) (((double) f23) + Math.toDegrees(Math.atan2(fCos2, fSin2))));
            }
            f12 = fSin;
            f13 = fCos;
        } else {
            f10 = f15;
            z10 = false;
            if (!Float.isNaN(f23)) {
                view.setRotation((float) (((double) 0.0f) + ((double) f23) + Math.toDegrees(Math.atan2(f18 + (f20 / 2.0f), f17 + (f19 / 2.0f)))));
            }
        }
        if (view instanceof e) {
            ((e) view).a(f12, f13, f14 + f12, f13 + f10);
            return;
        }
        float f28 = f12 + 0.5f;
        int i13 = (int) f28;
        float f29 = f13 + 0.5f;
        int i14 = (int) f29;
        int i15 = (int) (f28 + f14);
        int i16 = (int) (f29 + f10);
        int i17 = i15 - i13;
        int i18 = i16 - i14;
        if (i17 != view.getMeasuredWidth() || i18 != view.getMeasuredHeight()) {
            z10 = true;
        }
        if (z10 || mForceMeasure) {
            view.measure(View.MeasureSpec.makeMeasureSpec(i17, 1073741824), View.MeasureSpec.makeMeasureSpec(i18, 1073741824));
        }
        view.layout(i13, i14, i15, i16);
    }

    public void x(o mc2, s relative) {
        double d10 = ((this.f3886e + (this.f3888g / 2.0f)) - relative.f3886e) - (relative.f3888g / 2.0f);
        double d11 = ((this.f3887f + (this.f3889h / 2.0f)) - relative.f3887f) - (relative.f3889h / 2.0f);
        this.f3895n = mc2;
        this.f3886e = (float) Math.hypot(d11, d10);
        if (Float.isNaN(this.f3894m)) {
            this.f3887f = (float) (Math.atan2(d11, d10) + 1.5707963267948966d);
        } else {
            this.f3887f = (float) Math.toRadians(this.f3894m);
        }
    }

    public s(int parentWidth, int parentHeight, j c10, s startTimePoint, s endTimePoint) {
        int i10 = f.f3644f;
        this.f3892k = i10;
        this.f3893l = i10;
        this.f3894m = Float.NaN;
        this.f3895n = null;
        this.f3896o = new LinkedHashMap<>();
        this.f3897p = 0;
        this.f3899r = new double[18];
        this.f3900s = new double[18];
        if (startTimePoint.f3893l != f.f3644f) {
            s(parentWidth, parentHeight, c10, startTimePoint, endTimePoint);
            return;
        }
        int i11 = c10.O;
        if (i11 == 1) {
            r(c10, startTimePoint, endTimePoint);
        } else if (i11 != 2) {
            q(c10, startTimePoint, endTimePoint);
        } else {
            t(parentWidth, parentHeight, c10, startTimePoint, endTimePoint);
        }
    }
}
