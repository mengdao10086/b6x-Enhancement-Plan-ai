package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.t;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.e;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import hb.u;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    public static final int A = 1;
    public static final int A0 = 29;
    public static final int A1 = 81;
    public static final int B = 0;
    public static final int B0 = 30;
    public static final int B1 = 82;
    public static final int C = 1;
    public static final int C0 = 31;
    public static final int C1 = 83;
    public static final int D = 0;
    public static final int D0 = 32;
    public static final int D1 = 84;
    public static final int E = 4;
    public static final int E0 = 33;
    public static final int E1 = 85;
    public static final int F = 8;
    public static final int F0 = 34;
    public static final int F1 = 86;
    public static final int G = 1;
    public static final int G0 = 35;
    public static final int G1 = 87;
    public static final int H = 2;
    public static final int H0 = 36;
    public static final int H1 = 88;
    public static final int I = 3;
    public static final int I0 = 37;
    public static final int I1 = 89;
    public static final int J = 4;
    public static final int J0 = 38;
    public static final int J1 = 90;
    public static final int K = 5;
    public static final int K0 = 39;
    public static final int K1 = 91;
    public static final int L = 6;
    public static final int L0 = 40;
    public static final int L1 = 92;
    public static final int M = 7;
    public static final int M0 = 41;
    public static final int M1 = 93;
    public static final int N = 8;
    public static final int N0 = 42;
    public static final int N1 = 94;
    public static final int O = 0;
    public static final int O0 = 43;
    public static final int O1 = 95;
    public static final int P = 1;
    public static final int P0 = 44;
    public static final int P1 = 96;
    public static final int Q = 0;
    public static final int Q0 = 45;
    public static final int Q1 = 97;
    public static final int R = 1;
    public static final int R0 = 46;
    public static final int R1 = 98;
    public static final int S = 2;
    public static final int S0 = 47;
    public static final int S1 = 99;
    public static final boolean T = false;
    public static final int T0 = 48;
    public static final String T1 = "weight";
    public static final int U0 = 49;
    public static final String U1 = "ratio";
    public static final int V = 1;
    public static final int V0 = 50;
    public static final String V1 = "parent";
    public static final int W0 = 51;
    public static final int X0 = 52;
    public static final int Y = 1;
    public static final int Y0 = 53;
    public static final int Z = 2;
    public static final int Z0 = 54;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final int f4213a0 = 3;

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    public static final int f4214a1 = 55;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final int f4215b0 = 4;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public static final int f4216b1 = 56;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final int f4217c0 = 5;

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    public static final int f4218c1 = 57;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final int f4219d0 = 6;

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    public static final int f4220d1 = 58;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final int f4221e0 = 7;

    /* JADX INFO: renamed from: e1, reason: collision with root package name */
    public static final int f4222e1 = 59;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final int f4223f0 = 8;

    /* JADX INFO: renamed from: f1, reason: collision with root package name */
    public static final int f4224f1 = 60;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final int f4225g0 = 9;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public static final int f4226g1 = 61;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f4227h = "ConstraintSet";

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final int f4228h0 = 10;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public static final int f4229h1 = 62;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f4230i = "XML parser error must be within a Constraint ";

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final int f4231i0 = 11;

    /* JADX INFO: renamed from: i1, reason: collision with root package name */
    public static final int f4232i1 = 63;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f4233j = -1;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final int f4234j0 = 12;

    /* JADX INFO: renamed from: j1, reason: collision with root package name */
    public static final int f4235j1 = 64;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f4236k = -2;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final int f4237k0 = 13;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public static final int f4238k1 = 65;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f4239l = -3;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public static final int f4240l0 = 14;

    /* JADX INFO: renamed from: l1, reason: collision with root package name */
    public static final int f4241l1 = 66;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f4242m = -4;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final int f4243m0 = 15;

    /* JADX INFO: renamed from: m1, reason: collision with root package name */
    public static final int f4244m1 = 67;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f4245n = 0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final int f4246n0 = 16;

    /* JADX INFO: renamed from: n1, reason: collision with root package name */
    public static final int f4247n1 = 68;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f4248o = 1;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public static final int f4249o0 = 17;

    /* JADX INFO: renamed from: o1, reason: collision with root package name */
    public static final int f4250o1 = 69;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f4251p = 2;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final int f4252p0 = 18;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public static final int f4253p1 = 70;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f4254q = 3;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public static final int f4255q0 = 19;

    /* JADX INFO: renamed from: q1, reason: collision with root package name */
    public static final int f4256q1 = 71;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f4257r = 4;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public static final int f4258r0 = 20;

    /* JADX INFO: renamed from: r1, reason: collision with root package name */
    public static final int f4259r1 = 72;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f4260s = -1;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public static final int f4261s0 = 21;

    /* JADX INFO: renamed from: s1, reason: collision with root package name */
    public static final int f4262s1 = 73;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f4263t = 0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public static final int f4264t0 = 22;

    /* JADX INFO: renamed from: t1, reason: collision with root package name */
    public static final int f4265t1 = 74;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f4266u = -2;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public static final int f4267u0 = 23;

    /* JADX INFO: renamed from: u1, reason: collision with root package name */
    public static final int f4268u1 = 75;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f4269v = 1;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public static final int f4270v0 = 24;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public static final int f4271v1 = 76;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f4272w = 0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public static final int f4273w0 = 25;

    /* JADX INFO: renamed from: w1, reason: collision with root package name */
    public static final int f4274w1 = 77;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f4275x = 2;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public static final int f4276x0 = 26;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public static final int f4277x1 = 78;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f4278y = 0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public static final int f4279y0 = 27;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    public static final int f4280y1 = 79;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f4281z = 0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public static final int f4282z0 = 28;

    /* JADX INFO: renamed from: z1, reason: collision with root package name */
    public static final int f4283z1 = 80;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f4284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f4285b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f4286c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f4287d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public HashMap<String, ConstraintAttribute> f4288e = new HashMap<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f4289f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public HashMap<Integer, a> f4290g = new HashMap<>();
    public static final int[] U = {0, 4, 8};
    public static SparseIntArray W = new SparseIntArray();
    public static SparseIntArray X = new SparseIntArray();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f4291a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f4292b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final C0039d f4293c = new C0039d();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final c f4294d = new c();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final b f4295e = new b();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final e f4296f = new e();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public HashMap<String, ConstraintAttribute> f4297g = new HashMap<>();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public C0038a f4298h;

        /* JADX INFO: renamed from: androidx.constraintlayout.widget.d$a$a, reason: collision with other inner class name */
        public static class C0038a {

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public static final int f4299m = 4;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public static final int f4300n = 10;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            public static final int f4301o = 10;

            /* JADX INFO: renamed from: p, reason: collision with root package name */
            public static final int f4302p = 5;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int[] f4303a = new int[10];

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int[] f4304b = new int[10];

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f4305c = 0;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int[] f4306d = new int[10];

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public float[] f4307e = new float[10];

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public int f4308f = 0;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public int[] f4309g = new int[5];

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public String[] f4310h = new String[5];

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public int f4311i = 0;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public int[] f4312j = new int[4];

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public boolean[] f4313k = new boolean[4];

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public int f4314l = 0;

            public void a(int type, float value) {
                int i10 = this.f4308f;
                int[] iArr = this.f4306d;
                if (i10 >= iArr.length) {
                    this.f4306d = Arrays.copyOf(iArr, iArr.length * 2);
                    float[] fArr = this.f4307e;
                    this.f4307e = Arrays.copyOf(fArr, fArr.length * 2);
                }
                int[] iArr2 = this.f4306d;
                int i11 = this.f4308f;
                iArr2[i11] = type;
                float[] fArr2 = this.f4307e;
                this.f4308f = i11 + 1;
                fArr2[i11] = value;
            }

            public void b(int type, int value) {
                int i10 = this.f4305c;
                int[] iArr = this.f4303a;
                if (i10 >= iArr.length) {
                    this.f4303a = Arrays.copyOf(iArr, iArr.length * 2);
                    int[] iArr2 = this.f4304b;
                    this.f4304b = Arrays.copyOf(iArr2, iArr2.length * 2);
                }
                int[] iArr3 = this.f4303a;
                int i11 = this.f4305c;
                iArr3[i11] = type;
                int[] iArr4 = this.f4304b;
                this.f4305c = i11 + 1;
                iArr4[i11] = value;
            }

            public void c(int type, String value) {
                int i10 = this.f4311i;
                int[] iArr = this.f4309g;
                if (i10 >= iArr.length) {
                    this.f4309g = Arrays.copyOf(iArr, iArr.length * 2);
                    String[] strArr = this.f4310h;
                    this.f4310h = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                }
                int[] iArr2 = this.f4309g;
                int i11 = this.f4311i;
                iArr2[i11] = type;
                String[] strArr2 = this.f4310h;
                this.f4311i = i11 + 1;
                strArr2[i11] = value;
            }

            public void d(int type, boolean value) {
                int i10 = this.f4314l;
                int[] iArr = this.f4312j;
                if (i10 >= iArr.length) {
                    this.f4312j = Arrays.copyOf(iArr, iArr.length * 2);
                    boolean[] zArr = this.f4313k;
                    this.f4313k = Arrays.copyOf(zArr, zArr.length * 2);
                }
                int[] iArr2 = this.f4312j;
                int i11 = this.f4314l;
                iArr2[i11] = type;
                boolean[] zArr2 = this.f4313k;
                this.f4314l = i11 + 1;
                zArr2[i11] = value;
            }

            public void e(a c10) {
                for (int i10 = 0; i10 < this.f4305c; i10++) {
                    d.S0(c10, this.f4303a[i10], this.f4304b[i10]);
                }
                for (int i11 = 0; i11 < this.f4308f; i11++) {
                    d.R0(c10, this.f4306d[i11], this.f4307e[i11]);
                }
                for (int i12 = 0; i12 < this.f4311i; i12++) {
                    d.T0(c10, this.f4309g[i12], this.f4310h[i12]);
                }
                for (int i13 = 0; i13 < this.f4314l; i13++) {
                    d.U0(c10, this.f4312j[i13], this.f4313k[i13]);
                }
            }

            @SuppressLint({"LogConditional"})
            public void f(String tag) {
                for (int i10 = 0; i10 < this.f4305c; i10++) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(this.f4303a[i10]);
                    sb2.append(" = ");
                    sb2.append(this.f4304b[i10]);
                }
                for (int i11 = 0; i11 < this.f4308f; i11++) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(this.f4306d[i11]);
                    sb3.append(" = ");
                    sb3.append(this.f4307e[i11]);
                }
                for (int i12 = 0; i12 < this.f4311i; i12++) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(this.f4309g[i12]);
                    sb4.append(" = ");
                    sb4.append(this.f4310h[i12]);
                }
                for (int i13 = 0; i13 < this.f4314l; i13++) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(this.f4312j[i13]);
                    sb5.append(" = ");
                    sb5.append(this.f4313k[i13]);
                }
            }
        }

        public void h(a c10) {
            C0038a c0038a = this.f4298h;
            if (c0038a != null) {
                c0038a.e(c10);
            }
        }

        public void i(ConstraintLayout.b param) {
            b bVar = this.f4295e;
            param.f4081e = bVar.f4368j;
            param.f4083f = bVar.f4370k;
            param.f4085g = bVar.f4372l;
            param.f4087h = bVar.f4374m;
            param.f4089i = bVar.f4376n;
            param.f4091j = bVar.f4378o;
            param.f4093k = bVar.f4380p;
            param.f4095l = bVar.f4382q;
            param.f4097m = bVar.f4384r;
            param.f4099n = bVar.f4385s;
            param.f4101o = bVar.f4386t;
            param.f4109s = bVar.f4387u;
            param.f4111t = bVar.f4388v;
            param.f4113u = bVar.f4389w;
            param.f4115v = bVar.f4390x;
            ((ViewGroup.MarginLayoutParams) param).leftMargin = bVar.H;
            ((ViewGroup.MarginLayoutParams) param).rightMargin = bVar.I;
            ((ViewGroup.MarginLayoutParams) param).topMargin = bVar.J;
            ((ViewGroup.MarginLayoutParams) param).bottomMargin = bVar.K;
            param.A = bVar.T;
            param.B = bVar.S;
            param.f4119x = bVar.P;
            param.f4121z = bVar.R;
            param.G = bVar.f4391y;
            param.H = bVar.f4392z;
            param.f4103p = bVar.B;
            param.f4105q = bVar.C;
            param.f4107r = bVar.D;
            param.I = bVar.A;
            param.X = bVar.E;
            param.Y = bVar.F;
            param.M = bVar.V;
            param.L = bVar.W;
            param.O = bVar.Y;
            param.N = bVar.X;
            param.f4074a0 = bVar.f4377n0;
            param.f4076b0 = bVar.f4379o0;
            param.P = bVar.Z;
            param.Q = bVar.f4351a0;
            param.T = bVar.f4353b0;
            param.U = bVar.f4355c0;
            param.R = bVar.f4357d0;
            param.S = bVar.f4359e0;
            param.V = bVar.f4361f0;
            param.W = bVar.f4363g0;
            param.Z = bVar.G;
            param.f4077c = bVar.f4364h;
            param.f4073a = bVar.f4360f;
            param.f4075b = bVar.f4362g;
            ((ViewGroup.MarginLayoutParams) param).width = bVar.f4356d;
            ((ViewGroup.MarginLayoutParams) param).height = bVar.f4358e;
            String str = bVar.f4375m0;
            if (str != null) {
                param.f4078c0 = str;
            }
            param.f4080d0 = bVar.f4383q0;
            param.setMarginStart(bVar.M);
            param.setMarginEnd(this.f4295e.L);
            param.e();
        }

        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public a clone() {
            a aVar = new a();
            aVar.f4295e.a(this.f4295e);
            aVar.f4294d.a(this.f4294d);
            aVar.f4293c.a(this.f4293c);
            aVar.f4296f.a(this.f4296f);
            aVar.f4291a = this.f4291a;
            aVar.f4298h = this.f4298h;
            return aVar;
        }

        public final void k(int viewId, ConstraintLayout.b param) {
            this.f4291a = viewId;
            b bVar = this.f4295e;
            bVar.f4368j = param.f4081e;
            bVar.f4370k = param.f4083f;
            bVar.f4372l = param.f4085g;
            bVar.f4374m = param.f4087h;
            bVar.f4376n = param.f4089i;
            bVar.f4378o = param.f4091j;
            bVar.f4380p = param.f4093k;
            bVar.f4382q = param.f4095l;
            bVar.f4384r = param.f4097m;
            bVar.f4385s = param.f4099n;
            bVar.f4386t = param.f4101o;
            bVar.f4387u = param.f4109s;
            bVar.f4388v = param.f4111t;
            bVar.f4389w = param.f4113u;
            bVar.f4390x = param.f4115v;
            bVar.f4391y = param.G;
            bVar.f4392z = param.H;
            bVar.A = param.I;
            bVar.B = param.f4103p;
            bVar.C = param.f4105q;
            bVar.D = param.f4107r;
            bVar.E = param.X;
            bVar.F = param.Y;
            bVar.G = param.Z;
            bVar.f4364h = param.f4077c;
            bVar.f4360f = param.f4073a;
            bVar.f4362g = param.f4075b;
            bVar.f4356d = ((ViewGroup.MarginLayoutParams) param).width;
            bVar.f4358e = ((ViewGroup.MarginLayoutParams) param).height;
            bVar.H = ((ViewGroup.MarginLayoutParams) param).leftMargin;
            bVar.I = ((ViewGroup.MarginLayoutParams) param).rightMargin;
            bVar.J = ((ViewGroup.MarginLayoutParams) param).topMargin;
            bVar.K = ((ViewGroup.MarginLayoutParams) param).bottomMargin;
            bVar.N = param.D;
            bVar.V = param.M;
            bVar.W = param.L;
            bVar.Y = param.O;
            bVar.X = param.N;
            bVar.f4377n0 = param.f4074a0;
            bVar.f4379o0 = param.f4076b0;
            bVar.Z = param.P;
            bVar.f4351a0 = param.Q;
            bVar.f4353b0 = param.T;
            bVar.f4355c0 = param.U;
            bVar.f4357d0 = param.R;
            bVar.f4359e0 = param.S;
            bVar.f4361f0 = param.V;
            bVar.f4363g0 = param.W;
            bVar.f4375m0 = param.f4078c0;
            bVar.P = param.f4119x;
            bVar.R = param.f4121z;
            bVar.O = param.f4117w;
            bVar.Q = param.f4120y;
            bVar.T = param.A;
            bVar.S = param.B;
            bVar.U = param.C;
            bVar.f4383q0 = param.f4080d0;
            bVar.L = param.getMarginEnd();
            this.f4295e.M = param.getMarginStart();
        }

        public final void l(int viewId, e.a param) {
            k(viewId, param);
            this.f4293c.f4422d = param.V0;
            e eVar = this.f4296f;
            eVar.f4437b = param.Y0;
            eVar.f4438c = param.Z0;
            eVar.f4439d = param.f4482a1;
            eVar.f4440e = param.f4483b1;
            eVar.f4441f = param.f4484c1;
            eVar.f4442g = param.f4485d1;
            eVar.f4443h = param.f4486e1;
            eVar.f4445j = param.f4487f1;
            eVar.f4446k = param.f4488g1;
            eVar.f4447l = param.f4489h1;
            eVar.f4449n = param.X0;
            eVar.f4448m = param.W0;
        }

        public final void m(androidx.constraintlayout.widget.a helper, int viewId, e.a param) {
            l(viewId, param);
            if (helper instanceof Barrier) {
                b bVar = this.f4295e;
                bVar.f4369j0 = 1;
                Barrier barrier = (Barrier) helper;
                bVar.f4365h0 = barrier.getType();
                this.f4295e.f4371k0 = barrier.getReferencedIds();
                this.f4295e.f4367i0 = barrier.getMargin();
            }
        }

        public final ConstraintAttribute n(String attributeName, ConstraintAttribute.AttributeType attributeType) {
            if (!this.f4297g.containsKey(attributeName)) {
                ConstraintAttribute constraintAttribute = new ConstraintAttribute(attributeName, attributeType);
                this.f4297g.put(attributeName, constraintAttribute);
                return constraintAttribute;
            }
            ConstraintAttribute constraintAttribute2 = this.f4297g.get(attributeName);
            if (constraintAttribute2.j() == attributeType) {
                return constraintAttribute2;
            }
            throw new IllegalArgumentException("ConstraintAttribute is already a " + constraintAttribute2.j().name());
        }

        public void o(String tag) {
            C0038a c0038a = this.f4298h;
            if (c0038a != null) {
                c0038a.f(tag);
            }
        }

        public final void p(String attributeName, int value) {
            n(attributeName, ConstraintAttribute.AttributeType.COLOR_TYPE).s(value);
        }

        public final void q(String attributeName, float value) {
            n(attributeName, ConstraintAttribute.AttributeType.FLOAT_TYPE).t(value);
        }

        public final void r(String attributeName, int value) {
            n(attributeName, ConstraintAttribute.AttributeType.INT_TYPE).u(value);
        }

        public final void s(String attributeName, String value) {
            n(attributeName, ConstraintAttribute.AttributeType.STRING_TYPE).v(value);
        }
    }

    public static class b {
        public static final int A0 = 7;
        public static final int A1 = 82;
        public static final int B0 = 8;
        public static final int B1 = 83;
        public static final int C0 = 9;
        public static final int C1 = 84;
        public static final int D0 = 10;
        public static final int D1 = 85;
        public static final int E0 = 11;
        public static final int E1 = 86;
        public static final int F0 = 12;
        public static final int F1 = 87;
        public static final int G0 = 13;
        public static final int G1 = 88;
        public static final int H0 = 14;
        public static final int H1 = 89;
        public static final int I0 = 15;
        public static final int I1 = 90;
        public static final int J0 = 16;
        public static final int J1 = 91;
        public static final int K0 = 17;
        public static final int L0 = 18;
        public static final int M0 = 19;
        public static final int N0 = 20;
        public static final int O0 = 21;
        public static final int P0 = 22;
        public static final int Q0 = 23;
        public static final int R0 = 24;
        public static final int S0 = 25;
        public static final int T0 = 26;
        public static final int U0 = 27;
        public static final int V0 = 28;
        public static final int W0 = 29;
        public static final int X0 = 30;
        public static final int Y0 = 31;
        public static final int Z0 = 32;

        /* JADX INFO: renamed from: a1, reason: collision with root package name */
        public static final int f4315a1 = 33;

        /* JADX INFO: renamed from: b1, reason: collision with root package name */
        public static final int f4316b1 = 34;

        /* JADX INFO: renamed from: c1, reason: collision with root package name */
        public static final int f4317c1 = 35;

        /* JADX INFO: renamed from: d1, reason: collision with root package name */
        public static final int f4318d1 = 36;

        /* JADX INFO: renamed from: e1, reason: collision with root package name */
        public static final int f4319e1 = 37;

        /* JADX INFO: renamed from: f1, reason: collision with root package name */
        public static final int f4320f1 = 38;

        /* JADX INFO: renamed from: g1, reason: collision with root package name */
        public static final int f4321g1 = 39;

        /* JADX INFO: renamed from: h1, reason: collision with root package name */
        public static final int f4322h1 = 40;

        /* JADX INFO: renamed from: i1, reason: collision with root package name */
        public static final int f4323i1 = 41;

        /* JADX INFO: renamed from: j1, reason: collision with root package name */
        public static final int f4324j1 = 42;

        /* JADX INFO: renamed from: k1, reason: collision with root package name */
        public static final int f4325k1 = 61;

        /* JADX INFO: renamed from: l1, reason: collision with root package name */
        public static final int f4326l1 = 62;

        /* JADX INFO: renamed from: m1, reason: collision with root package name */
        public static final int f4327m1 = 63;

        /* JADX INFO: renamed from: n1, reason: collision with root package name */
        public static final int f4328n1 = 69;

        /* JADX INFO: renamed from: o1, reason: collision with root package name */
        public static final int f4329o1 = 70;

        /* JADX INFO: renamed from: p1, reason: collision with root package name */
        public static final int f4330p1 = 71;

        /* JADX INFO: renamed from: q1, reason: collision with root package name */
        public static final int f4331q1 = 72;

        /* JADX INFO: renamed from: r0, reason: collision with root package name */
        public static final int f4332r0 = -1;

        /* JADX INFO: renamed from: r1, reason: collision with root package name */
        public static final int f4333r1 = 73;

        /* JADX INFO: renamed from: s0, reason: collision with root package name */
        public static final int f4334s0 = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: s1, reason: collision with root package name */
        public static final int f4335s1 = 74;

        /* JADX INFO: renamed from: t0, reason: collision with root package name */
        public static SparseIntArray f4336t0 = null;

        /* JADX INFO: renamed from: t1, reason: collision with root package name */
        public static final int f4337t1 = 75;

        /* JADX INFO: renamed from: u0, reason: collision with root package name */
        public static final int f4338u0 = 1;

        /* JADX INFO: renamed from: u1, reason: collision with root package name */
        public static final int f4339u1 = 76;

        /* JADX INFO: renamed from: v0, reason: collision with root package name */
        public static final int f4340v0 = 2;

        /* JADX INFO: renamed from: v1, reason: collision with root package name */
        public static final int f4341v1 = 77;

        /* JADX INFO: renamed from: w0, reason: collision with root package name */
        public static final int f4342w0 = 3;

        /* JADX INFO: renamed from: w1, reason: collision with root package name */
        public static final int f4343w1 = 78;

        /* JADX INFO: renamed from: x0, reason: collision with root package name */
        public static final int f4344x0 = 4;

        /* JADX INFO: renamed from: x1, reason: collision with root package name */
        public static final int f4345x1 = 79;

        /* JADX INFO: renamed from: y0, reason: collision with root package name */
        public static final int f4346y0 = 5;

        /* JADX INFO: renamed from: y1, reason: collision with root package name */
        public static final int f4347y1 = 80;

        /* JADX INFO: renamed from: z0, reason: collision with root package name */
        public static final int f4348z0 = 6;

        /* JADX INFO: renamed from: z1, reason: collision with root package name */
        public static final int f4349z1 = 81;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f4356d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f4358e;

        /* JADX INFO: renamed from: k0, reason: collision with root package name */
        public int[] f4371k0;

        /* JADX INFO: renamed from: l0, reason: collision with root package name */
        public String f4373l0;

        /* JADX INFO: renamed from: m0, reason: collision with root package name */
        public String f4375m0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f4350a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f4352b = false;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f4354c = false;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f4360f = -1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f4362g = -1;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f4364h = -1.0f;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f4366i = true;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f4368j = -1;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f4370k = -1;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f4372l = -1;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f4374m = -1;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f4376n = -1;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f4378o = -1;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f4380p = -1;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f4382q = -1;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f4384r = -1;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f4385s = -1;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f4386t = -1;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f4387u = -1;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f4388v = -1;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f4389w = -1;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public int f4390x = -1;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public float f4391y = 0.5f;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public float f4392z = 0.5f;
        public String A = null;
        public int B = -1;
        public int C = 0;
        public float D = 0.0f;
        public int E = -1;
        public int F = -1;
        public int G = -1;
        public int H = 0;
        public int I = 0;
        public int J = 0;
        public int K = 0;
        public int L = 0;
        public int M = 0;
        public int N = 0;
        public int O = Integer.MIN_VALUE;
        public int P = Integer.MIN_VALUE;
        public int Q = Integer.MIN_VALUE;
        public int R = Integer.MIN_VALUE;
        public int S = Integer.MIN_VALUE;
        public int T = Integer.MIN_VALUE;
        public int U = Integer.MIN_VALUE;
        public float V = -1.0f;
        public float W = -1.0f;
        public int X = 0;
        public int Y = 0;
        public int Z = 0;

        /* JADX INFO: renamed from: a0, reason: collision with root package name */
        public int f4351a0 = 0;

        /* JADX INFO: renamed from: b0, reason: collision with root package name */
        public int f4353b0 = 0;

        /* JADX INFO: renamed from: c0, reason: collision with root package name */
        public int f4355c0 = 0;

        /* JADX INFO: renamed from: d0, reason: collision with root package name */
        public int f4357d0 = 0;

        /* JADX INFO: renamed from: e0, reason: collision with root package name */
        public int f4359e0 = 0;

        /* JADX INFO: renamed from: f0, reason: collision with root package name */
        public float f4361f0 = 1.0f;

        /* JADX INFO: renamed from: g0, reason: collision with root package name */
        public float f4363g0 = 1.0f;

        /* JADX INFO: renamed from: h0, reason: collision with root package name */
        public int f4365h0 = -1;

        /* JADX INFO: renamed from: i0, reason: collision with root package name */
        public int f4367i0 = 0;

        /* JADX INFO: renamed from: j0, reason: collision with root package name */
        public int f4369j0 = -1;

        /* JADX INFO: renamed from: n0, reason: collision with root package name */
        public boolean f4377n0 = false;

        /* JADX INFO: renamed from: o0, reason: collision with root package name */
        public boolean f4379o0 = false;

        /* JADX INFO: renamed from: p0, reason: collision with root package name */
        public boolean f4381p0 = true;

        /* JADX INFO: renamed from: q0, reason: collision with root package name */
        public int f4383q0 = 0;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f4336t0 = sparseIntArray;
            sparseIntArray.append(R.styleable.Layout_layout_constraintLeft_toLeftOf, 24);
            f4336t0.append(R.styleable.Layout_layout_constraintLeft_toRightOf, 25);
            f4336t0.append(R.styleable.Layout_layout_constraintRight_toLeftOf, 28);
            f4336t0.append(R.styleable.Layout_layout_constraintRight_toRightOf, 29);
            f4336t0.append(R.styleable.Layout_layout_constraintTop_toTopOf, 35);
            f4336t0.append(R.styleable.Layout_layout_constraintTop_toBottomOf, 34);
            f4336t0.append(R.styleable.Layout_layout_constraintBottom_toTopOf, 4);
            f4336t0.append(R.styleable.Layout_layout_constraintBottom_toBottomOf, 3);
            f4336t0.append(R.styleable.Layout_layout_constraintBaseline_toBaselineOf, 1);
            f4336t0.append(R.styleable.Layout_layout_editor_absoluteX, 6);
            f4336t0.append(R.styleable.Layout_layout_editor_absoluteY, 7);
            f4336t0.append(R.styleable.Layout_layout_constraintGuide_begin, 17);
            f4336t0.append(R.styleable.Layout_layout_constraintGuide_end, 18);
            f4336t0.append(R.styleable.Layout_layout_constraintGuide_percent, 19);
            f4336t0.append(R.styleable.Layout_guidelineUseRtl, 90);
            f4336t0.append(R.styleable.Layout_android_orientation, 26);
            f4336t0.append(R.styleable.Layout_layout_constraintStart_toEndOf, 31);
            f4336t0.append(R.styleable.Layout_layout_constraintStart_toStartOf, 32);
            f4336t0.append(R.styleable.Layout_layout_constraintEnd_toStartOf, 10);
            f4336t0.append(R.styleable.Layout_layout_constraintEnd_toEndOf, 9);
            f4336t0.append(R.styleable.Layout_layout_goneMarginLeft, 13);
            f4336t0.append(R.styleable.Layout_layout_goneMarginTop, 16);
            f4336t0.append(R.styleable.Layout_layout_goneMarginRight, 14);
            f4336t0.append(R.styleable.Layout_layout_goneMarginBottom, 11);
            f4336t0.append(R.styleable.Layout_layout_goneMarginStart, 15);
            f4336t0.append(R.styleable.Layout_layout_goneMarginEnd, 12);
            f4336t0.append(R.styleable.Layout_layout_constraintVertical_weight, 38);
            f4336t0.append(R.styleable.Layout_layout_constraintHorizontal_weight, 37);
            f4336t0.append(R.styleable.Layout_layout_constraintHorizontal_chainStyle, 39);
            f4336t0.append(R.styleable.Layout_layout_constraintVertical_chainStyle, 40);
            f4336t0.append(R.styleable.Layout_layout_constraintHorizontal_bias, 20);
            f4336t0.append(R.styleable.Layout_layout_constraintVertical_bias, 36);
            f4336t0.append(R.styleable.Layout_layout_constraintDimensionRatio, 5);
            f4336t0.append(R.styleable.Layout_layout_constraintLeft_creator, 91);
            f4336t0.append(R.styleable.Layout_layout_constraintTop_creator, 91);
            f4336t0.append(R.styleable.Layout_layout_constraintRight_creator, 91);
            f4336t0.append(R.styleable.Layout_layout_constraintBottom_creator, 91);
            f4336t0.append(R.styleable.Layout_layout_constraintBaseline_creator, 91);
            f4336t0.append(R.styleable.Layout_android_layout_marginLeft, 23);
            f4336t0.append(R.styleable.Layout_android_layout_marginRight, 27);
            f4336t0.append(R.styleable.Layout_android_layout_marginStart, 30);
            f4336t0.append(R.styleable.Layout_android_layout_marginEnd, 8);
            f4336t0.append(R.styleable.Layout_android_layout_marginTop, 33);
            f4336t0.append(R.styleable.Layout_android_layout_marginBottom, 2);
            f4336t0.append(R.styleable.Layout_android_layout_width, 22);
            f4336t0.append(R.styleable.Layout_android_layout_height, 21);
            f4336t0.append(R.styleable.Layout_layout_constraintWidth, 41);
            f4336t0.append(R.styleable.Layout_layout_constraintHeight, 42);
            f4336t0.append(R.styleable.Layout_layout_constrainedWidth, 41);
            f4336t0.append(R.styleable.Layout_layout_constrainedHeight, 42);
            f4336t0.append(R.styleable.Layout_layout_wrapBehaviorInParent, 76);
            f4336t0.append(R.styleable.Layout_layout_constraintCircle, 61);
            f4336t0.append(R.styleable.Layout_layout_constraintCircleRadius, 62);
            f4336t0.append(R.styleable.Layout_layout_constraintCircleAngle, 63);
            f4336t0.append(R.styleable.Layout_layout_constraintWidth_percent, 69);
            f4336t0.append(R.styleable.Layout_layout_constraintHeight_percent, 70);
            f4336t0.append(R.styleable.Layout_chainUseRtl, 71);
            f4336t0.append(R.styleable.Layout_barrierDirection, 72);
            f4336t0.append(R.styleable.Layout_barrierMargin, 73);
            f4336t0.append(R.styleable.Layout_constraint_referenced_ids, 74);
            f4336t0.append(R.styleable.Layout_barrierAllowsGoneWidgets, 75);
        }

        public void a(b src) {
            this.f4350a = src.f4350a;
            this.f4356d = src.f4356d;
            this.f4352b = src.f4352b;
            this.f4358e = src.f4358e;
            this.f4360f = src.f4360f;
            this.f4362g = src.f4362g;
            this.f4364h = src.f4364h;
            this.f4366i = src.f4366i;
            this.f4368j = src.f4368j;
            this.f4370k = src.f4370k;
            this.f4372l = src.f4372l;
            this.f4374m = src.f4374m;
            this.f4376n = src.f4376n;
            this.f4378o = src.f4378o;
            this.f4380p = src.f4380p;
            this.f4382q = src.f4382q;
            this.f4384r = src.f4384r;
            this.f4385s = src.f4385s;
            this.f4386t = src.f4386t;
            this.f4387u = src.f4387u;
            this.f4388v = src.f4388v;
            this.f4389w = src.f4389w;
            this.f4390x = src.f4390x;
            this.f4391y = src.f4391y;
            this.f4392z = src.f4392z;
            this.A = src.A;
            this.B = src.B;
            this.C = src.C;
            this.D = src.D;
            this.E = src.E;
            this.F = src.F;
            this.G = src.G;
            this.H = src.H;
            this.I = src.I;
            this.J = src.J;
            this.K = src.K;
            this.L = src.L;
            this.M = src.M;
            this.N = src.N;
            this.O = src.O;
            this.P = src.P;
            this.Q = src.Q;
            this.R = src.R;
            this.S = src.S;
            this.T = src.T;
            this.U = src.U;
            this.V = src.V;
            this.W = src.W;
            this.X = src.X;
            this.Y = src.Y;
            this.Z = src.Z;
            this.f4351a0 = src.f4351a0;
            this.f4353b0 = src.f4353b0;
            this.f4355c0 = src.f4355c0;
            this.f4357d0 = src.f4357d0;
            this.f4359e0 = src.f4359e0;
            this.f4361f0 = src.f4361f0;
            this.f4363g0 = src.f4363g0;
            this.f4365h0 = src.f4365h0;
            this.f4367i0 = src.f4367i0;
            this.f4369j0 = src.f4369j0;
            this.f4375m0 = src.f4375m0;
            int[] iArr = src.f4371k0;
            if (iArr == null || src.f4373l0 != null) {
                this.f4371k0 = null;
            } else {
                this.f4371k0 = Arrays.copyOf(iArr, iArr.length);
            }
            this.f4373l0 = src.f4373l0;
            this.f4377n0 = src.f4377n0;
            this.f4379o0 = src.f4379o0;
            this.f4381p0 = src.f4381p0;
            this.f4383q0 = src.f4383q0;
        }

        public void b(t tVar, StringBuilder sb2) {
            Field[] declaredFields = getClass().getDeclaredFields();
            sb2.append("\n");
            for (Field field : declaredFields) {
                String name = field.getName();
                if (!Modifier.isStatic(field.getModifiers())) {
                    try {
                        Object obj = field.get(this);
                        Class<?> type = field.getType();
                        if (type == Integer.TYPE) {
                            Integer num = (Integer) obj;
                            if (num.intValue() != -1) {
                                Object objX = tVar.X(num.intValue());
                                sb2.append(wn.a.f54751a);
                                sb2.append(name);
                                sb2.append(" = \"");
                                sb2.append(objX == null ? num : objX);
                                sb2.append("\"\n");
                            }
                        } else if (type == Float.TYPE) {
                            Float f10 = (Float) obj;
                            if (f10.floatValue() != -1.0f) {
                                sb2.append(wn.a.f54751a);
                                sb2.append(name);
                                sb2.append(" = \"");
                                sb2.append(f10);
                                sb2.append("\"\n");
                            }
                        }
                    } catch (IllegalAccessException e10) {
                        e10.printStackTrace();
                    }
                }
            }
        }

        public void c(Context context, AttributeSet attrs) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.Layout);
            this.f4352b = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                int i11 = f4336t0.get(index);
                switch (i11) {
                    case 1:
                        this.f4384r = d.y0(typedArrayObtainStyledAttributes, index, this.f4384r);
                        break;
                    case 2:
                        this.K = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.K);
                        break;
                    case 3:
                        this.f4382q = d.y0(typedArrayObtainStyledAttributes, index, this.f4382q);
                        break;
                    case 4:
                        this.f4380p = d.y0(typedArrayObtainStyledAttributes, index, this.f4380p);
                        break;
                    case 5:
                        this.A = typedArrayObtainStyledAttributes.getString(index);
                        break;
                    case 6:
                        this.E = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.E);
                        break;
                    case 7:
                        this.F = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.F);
                        break;
                    case 8:
                        this.L = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.L);
                        break;
                    case 9:
                        this.f4390x = d.y0(typedArrayObtainStyledAttributes, index, this.f4390x);
                        break;
                    case 10:
                        this.f4389w = d.y0(typedArrayObtainStyledAttributes, index, this.f4389w);
                        break;
                    case 11:
                        this.R = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.R);
                        break;
                    case 12:
                        this.S = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.S);
                        break;
                    case 13:
                        this.O = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.O);
                        break;
                    case 14:
                        this.Q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.Q);
                        break;
                    case 15:
                        this.T = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.T);
                        break;
                    case 16:
                        this.P = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.P);
                        break;
                    case 17:
                        this.f4360f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f4360f);
                        break;
                    case 18:
                        this.f4362g = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f4362g);
                        break;
                    case 19:
                        this.f4364h = typedArrayObtainStyledAttributes.getFloat(index, this.f4364h);
                        break;
                    case 20:
                        this.f4391y = typedArrayObtainStyledAttributes.getFloat(index, this.f4391y);
                        break;
                    case 21:
                        this.f4358e = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.f4358e);
                        break;
                    case 22:
                        this.f4356d = typedArrayObtainStyledAttributes.getLayoutDimension(index, this.f4356d);
                        break;
                    case 23:
                        this.H = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.H);
                        break;
                    case 24:
                        this.f4368j = d.y0(typedArrayObtainStyledAttributes, index, this.f4368j);
                        break;
                    case 25:
                        this.f4370k = d.y0(typedArrayObtainStyledAttributes, index, this.f4370k);
                        break;
                    case 26:
                        this.G = typedArrayObtainStyledAttributes.getInt(index, this.G);
                        break;
                    case 27:
                        this.I = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.I);
                        break;
                    case 28:
                        this.f4372l = d.y0(typedArrayObtainStyledAttributes, index, this.f4372l);
                        break;
                    case 29:
                        this.f4374m = d.y0(typedArrayObtainStyledAttributes, index, this.f4374m);
                        break;
                    case 30:
                        this.M = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.M);
                        break;
                    case 31:
                        this.f4387u = d.y0(typedArrayObtainStyledAttributes, index, this.f4387u);
                        break;
                    case 32:
                        this.f4388v = d.y0(typedArrayObtainStyledAttributes, index, this.f4388v);
                        break;
                    case 33:
                        this.J = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.J);
                        break;
                    case 34:
                        this.f4378o = d.y0(typedArrayObtainStyledAttributes, index, this.f4378o);
                        break;
                    case 35:
                        this.f4376n = d.y0(typedArrayObtainStyledAttributes, index, this.f4376n);
                        break;
                    case 36:
                        this.f4392z = typedArrayObtainStyledAttributes.getFloat(index, this.f4392z);
                        break;
                    case 37:
                        this.W = typedArrayObtainStyledAttributes.getFloat(index, this.W);
                        break;
                    case 38:
                        this.V = typedArrayObtainStyledAttributes.getFloat(index, this.V);
                        break;
                    case 39:
                        this.X = typedArrayObtainStyledAttributes.getInt(index, this.X);
                        break;
                    case 40:
                        this.Y = typedArrayObtainStyledAttributes.getInt(index, this.Y);
                        break;
                    case 41:
                        d.A0(this, typedArrayObtainStyledAttributes, index, 0);
                        break;
                    case 42:
                        d.A0(this, typedArrayObtainStyledAttributes, index, 1);
                        break;
                    default:
                        switch (i11) {
                            case 61:
                                this.B = d.y0(typedArrayObtainStyledAttributes, index, this.B);
                                break;
                            case 62:
                                this.C = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.C);
                                break;
                            case 63:
                                this.D = typedArrayObtainStyledAttributes.getFloat(index, this.D);
                                break;
                            default:
                                switch (i11) {
                                    case 69:
                                        this.f4361f0 = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                        break;
                                    case 70:
                                        this.f4363g0 = typedArrayObtainStyledAttributes.getFloat(index, 1.0f);
                                        break;
                                    case 71:
                                        break;
                                    case 72:
                                        this.f4365h0 = typedArrayObtainStyledAttributes.getInt(index, this.f4365h0);
                                        break;
                                    case 73:
                                        this.f4367i0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f4367i0);
                                        break;
                                    case 74:
                                        this.f4373l0 = typedArrayObtainStyledAttributes.getString(index);
                                        break;
                                    case 75:
                                        this.f4381p0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f4381p0);
                                        break;
                                    case 76:
                                        this.f4383q0 = typedArrayObtainStyledAttributes.getInt(index, this.f4383q0);
                                        break;
                                    case 77:
                                        this.f4385s = d.y0(typedArrayObtainStyledAttributes, index, this.f4385s);
                                        break;
                                    case 78:
                                        this.f4386t = d.y0(typedArrayObtainStyledAttributes, index, this.f4386t);
                                        break;
                                    case 79:
                                        this.U = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.U);
                                        break;
                                    case 80:
                                        this.N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.N);
                                        break;
                                    case 81:
                                        this.Z = typedArrayObtainStyledAttributes.getInt(index, this.Z);
                                        break;
                                    case 82:
                                        this.f4351a0 = typedArrayObtainStyledAttributes.getInt(index, this.f4351a0);
                                        break;
                                    case 83:
                                        this.f4355c0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f4355c0);
                                        break;
                                    case 84:
                                        this.f4353b0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f4353b0);
                                        break;
                                    case 85:
                                        this.f4359e0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f4359e0);
                                        break;
                                    case 86:
                                        this.f4357d0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f4357d0);
                                        break;
                                    case 87:
                                        this.f4377n0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f4377n0);
                                        break;
                                    case 88:
                                        this.f4379o0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f4379o0);
                                        break;
                                    case 89:
                                        this.f4375m0 = typedArrayObtainStyledAttributes.getString(index);
                                        break;
                                    case 90:
                                        this.f4366i = typedArrayObtainStyledAttributes.getBoolean(index, this.f4366i);
                                        break;
                                    case 91:
                                        StringBuilder sb2 = new StringBuilder();
                                        sb2.append("unused attribute 0x");
                                        sb2.append(Integer.toHexString(index));
                                        sb2.append("   ");
                                        sb2.append(f4336t0.get(index));
                                        break;
                                    default:
                                        StringBuilder sb3 = new StringBuilder();
                                        sb3.append("Unknown attribute 0x");
                                        sb3.append(Integer.toHexString(index));
                                        sb3.append("   ");
                                        sb3.append(f4336t0.get(index));
                                        break;
                                }
                                break;
                        }
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static class c {
        public static final int A = 9;
        public static final int B = 10;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final int f4393o = -2;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final int f4394p = -1;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final int f4395q = -3;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static SparseIntArray f4396r = null;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final int f4397s = 1;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static final int f4398t = 2;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public static final int f4399u = 3;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public static final int f4400v = 4;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public static final int f4401w = 5;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public static final int f4402x = 6;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public static final int f4403y = 7;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public static final int f4404z = 8;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f4405a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f4406b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f4407c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f4408d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f4409e = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f4410f = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f4411g = Float.NaN;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f4412h = -1;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f4413i = Float.NaN;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f4414j = Float.NaN;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f4415k = -1;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f4416l = null;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f4417m = -3;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f4418n = -1;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f4396r = sparseIntArray;
            sparseIntArray.append(R.styleable.Motion_motionPathRotate, 1);
            f4396r.append(R.styleable.Motion_pathMotionArc, 2);
            f4396r.append(R.styleable.Motion_transitionEasing, 3);
            f4396r.append(R.styleable.Motion_drawPath, 4);
            f4396r.append(R.styleable.Motion_animateRelativeTo, 5);
            f4396r.append(R.styleable.Motion_animateCircleAngleTo, 6);
            f4396r.append(R.styleable.Motion_motionStagger, 7);
            f4396r.append(R.styleable.Motion_quantizeMotionSteps, 8);
            f4396r.append(R.styleable.Motion_quantizeMotionPhase, 9);
            f4396r.append(R.styleable.Motion_quantizeMotionInterpolator, 10);
        }

        public void a(c src) {
            this.f4405a = src.f4405a;
            this.f4406b = src.f4406b;
            this.f4408d = src.f4408d;
            this.f4409e = src.f4409e;
            this.f4410f = src.f4410f;
            this.f4413i = src.f4413i;
            this.f4411g = src.f4411g;
            this.f4412h = src.f4412h;
        }

        public void b(Context context, AttributeSet attrs) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.Motion);
            this.f4405a = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                switch (f4396r.get(index)) {
                    case 1:
                        this.f4413i = typedArrayObtainStyledAttributes.getFloat(index, this.f4413i);
                        break;
                    case 2:
                        this.f4409e = typedArrayObtainStyledAttributes.getInt(index, this.f4409e);
                        break;
                    case 3:
                        if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                            this.f4408d = typedArrayObtainStyledAttributes.getString(index);
                        } else {
                            this.f4408d = w.d.f53426o[typedArrayObtainStyledAttributes.getInteger(index, 0)];
                        }
                        break;
                    case 4:
                        this.f4410f = typedArrayObtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        this.f4406b = d.y0(typedArrayObtainStyledAttributes, index, this.f4406b);
                        break;
                    case 6:
                        this.f4407c = typedArrayObtainStyledAttributes.getInteger(index, this.f4407c);
                        break;
                    case 7:
                        this.f4411g = typedArrayObtainStyledAttributes.getFloat(index, this.f4411g);
                        break;
                    case 8:
                        this.f4415k = typedArrayObtainStyledAttributes.getInteger(index, this.f4415k);
                        break;
                    case 9:
                        this.f4414j = typedArrayObtainStyledAttributes.getFloat(index, this.f4414j);
                        break;
                    case 10:
                        int i11 = typedArrayObtainStyledAttributes.peekValue(index).type;
                        if (i11 == 1) {
                            int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                            this.f4418n = resourceId;
                            if (resourceId != -1) {
                                this.f4417m = -2;
                            }
                        } else if (i11 == 3) {
                            String string = typedArrayObtainStyledAttributes.getString(index);
                            this.f4416l = string;
                            if (string.indexOf(fh.a.f28350w) > 0) {
                                this.f4418n = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                                this.f4417m = -2;
                            } else {
                                this.f4417m = -1;
                            }
                        } else {
                            this.f4417m = typedArrayObtainStyledAttributes.getInteger(index, this.f4418n);
                        }
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: renamed from: androidx.constraintlayout.widget.d$d, reason: collision with other inner class name */
    public static class C0039d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f4419a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f4420b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f4421c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f4422d = 1.0f;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f4423e = Float.NaN;

        public void a(C0039d src) {
            this.f4419a = src.f4419a;
            this.f4420b = src.f4420b;
            this.f4422d = src.f4422d;
            this.f4423e = src.f4423e;
            this.f4421c = src.f4421c;
        }

        public void b(Context context, AttributeSet attrs) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.PropertySet);
            this.f4419a = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.PropertySet_android_alpha) {
                    this.f4422d = typedArrayObtainStyledAttributes.getFloat(index, this.f4422d);
                } else if (index == R.styleable.PropertySet_android_visibility) {
                    this.f4420b = typedArrayObtainStyledAttributes.getInt(index, this.f4420b);
                    this.f4420b = d.U[this.f4420b];
                } else if (index == R.styleable.PropertySet_visibilityMode) {
                    this.f4421c = typedArrayObtainStyledAttributes.getInt(index, this.f4421c);
                } else if (index == R.styleable.PropertySet_motionProgress) {
                    this.f4423e = typedArrayObtainStyledAttributes.getFloat(index, this.f4423e);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static class e {
        public static final int A = 12;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static SparseIntArray f4424o = null;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final int f4425p = 1;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final int f4426q = 2;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final int f4427r = 3;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final int f4428s = 4;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static final int f4429t = 5;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public static final int f4430u = 6;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public static final int f4431v = 7;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public static final int f4432w = 8;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public static final int f4433x = 9;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public static final int f4434y = 10;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public static final int f4435z = 11;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f4436a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f4437b = 0.0f;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f4438c = 0.0f;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f4439d = 0.0f;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f4440e = 1.0f;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f4441f = 1.0f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f4442g = Float.NaN;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f4443h = Float.NaN;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f4444i = -1;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f4445j = 0.0f;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float f4446k = 0.0f;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public float f4447l = 0.0f;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f4448m = false;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public float f4449n = 0.0f;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f4424o = sparseIntArray;
            sparseIntArray.append(R.styleable.Transform_android_rotation, 1);
            f4424o.append(R.styleable.Transform_android_rotationX, 2);
            f4424o.append(R.styleable.Transform_android_rotationY, 3);
            f4424o.append(R.styleable.Transform_android_scaleX, 4);
            f4424o.append(R.styleable.Transform_android_scaleY, 5);
            f4424o.append(R.styleable.Transform_android_transformPivotX, 6);
            f4424o.append(R.styleable.Transform_android_transformPivotY, 7);
            f4424o.append(R.styleable.Transform_android_translationX, 8);
            f4424o.append(R.styleable.Transform_android_translationY, 9);
            f4424o.append(R.styleable.Transform_android_translationZ, 10);
            f4424o.append(R.styleable.Transform_android_elevation, 11);
            f4424o.append(R.styleable.Transform_transformPivotTarget, 12);
        }

        public void a(e src) {
            this.f4436a = src.f4436a;
            this.f4437b = src.f4437b;
            this.f4438c = src.f4438c;
            this.f4439d = src.f4439d;
            this.f4440e = src.f4440e;
            this.f4441f = src.f4441f;
            this.f4442g = src.f4442g;
            this.f4443h = src.f4443h;
            this.f4444i = src.f4444i;
            this.f4445j = src.f4445j;
            this.f4446k = src.f4446k;
            this.f4447l = src.f4447l;
            this.f4448m = src.f4448m;
            this.f4449n = src.f4449n;
        }

        public void b(Context context, AttributeSet attrs) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.Transform);
            this.f4436a = true;
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                switch (f4424o.get(index)) {
                    case 1:
                        this.f4437b = typedArrayObtainStyledAttributes.getFloat(index, this.f4437b);
                        break;
                    case 2:
                        this.f4438c = typedArrayObtainStyledAttributes.getFloat(index, this.f4438c);
                        break;
                    case 3:
                        this.f4439d = typedArrayObtainStyledAttributes.getFloat(index, this.f4439d);
                        break;
                    case 4:
                        this.f4440e = typedArrayObtainStyledAttributes.getFloat(index, this.f4440e);
                        break;
                    case 5:
                        this.f4441f = typedArrayObtainStyledAttributes.getFloat(index, this.f4441f);
                        break;
                    case 6:
                        this.f4442g = typedArrayObtainStyledAttributes.getDimension(index, this.f4442g);
                        break;
                    case 7:
                        this.f4443h = typedArrayObtainStyledAttributes.getDimension(index, this.f4443h);
                        break;
                    case 8:
                        this.f4445j = typedArrayObtainStyledAttributes.getDimension(index, this.f4445j);
                        break;
                    case 9:
                        this.f4446k = typedArrayObtainStyledAttributes.getDimension(index, this.f4446k);
                        break;
                    case 10:
                        this.f4447l = typedArrayObtainStyledAttributes.getDimension(index, this.f4447l);
                        break;
                    case 11:
                        this.f4448m = true;
                        this.f4449n = typedArrayObtainStyledAttributes.getDimension(index, this.f4449n);
                        break;
                    case 12:
                        this.f4444i = d.y0(typedArrayObtainStyledAttributes, index, this.f4444i);
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public class f {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final String f4450o = "       ";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Writer f4451a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ConstraintLayout f4452b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Context f4453c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f4454d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f4455e = 0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f4456f = "'left'";

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f4457g = "'right'";

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f4458h = "'baseline'";

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f4459i = "'bottom'";

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final String f4460j = "'top'";

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final String f4461k = "'start'";

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final String f4462l = "'end'";

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public HashMap<Integer, String> f4463m = new HashMap<>();

        public f(Writer writer, ConstraintLayout layout, int flags) throws IOException {
            this.f4451a = writer;
            this.f4452b = layout;
            this.f4453c = layout.getContext();
            this.f4454d = flags;
        }

        public String a(int id2) {
            if (this.f4463m.containsKey(Integer.valueOf(id2))) {
                return "'" + this.f4463m.get(Integer.valueOf(id2)) + "'";
            }
            if (id2 == 0) {
                return "'parent'";
            }
            String strB = b(id2);
            this.f4463m.put(Integer.valueOf(id2), strB);
            return "'" + strB + "'";
        }

        public String b(int id2) {
            try {
                if (id2 != -1) {
                    return this.f4453c.getResources().getResourceEntryName(id2);
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("unknown");
                int i10 = this.f4455e + 1;
                this.f4455e = i10;
                sb2.append(i10);
                return sb2.toString();
            } catch (Exception unused) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("unknown");
                int i11 = this.f4455e + 1;
                this.f4455e = i11;
                sb3.append(i11);
                return sb3.toString();
            }
        }

        public void c(int circleConstraint, float circleAngle, int circleRadius) throws IOException {
            if (circleConstraint == -1) {
                return;
            }
            this.f4451a.write("       circle");
            this.f4451a.write(":[");
            this.f4451a.write(a(circleConstraint));
            this.f4451a.write(", " + circleAngle);
            this.f4451a.write(circleRadius + "]");
        }

        public void d(String my, int leftToLeft, String other, int margin, int goneMargin) throws IOException {
            if (leftToLeft == -1) {
                return;
            }
            this.f4451a.write(f4450o + my);
            this.f4451a.write(":[");
            this.f4451a.write(a(leftToLeft));
            this.f4451a.write(" , ");
            this.f4451a.write(other);
            if (margin != 0) {
                this.f4451a.write(" , " + margin);
            }
            this.f4451a.write("],\n");
        }

        public final void e(String dimString, int dim, int dimDefault, float dimPercent, int dimMin, int dimMax, boolean constrainedDim) throws IOException {
            if (dim != 0) {
                if (dim == -2) {
                    this.f4451a.write(f4450o + dimString + ": 'wrap'\n");
                    return;
                }
                if (dim == -1) {
                    this.f4451a.write(f4450o + dimString + ": 'parent'\n");
                    return;
                }
                this.f4451a.write(f4450o + dimString + ": " + dim + ",\n");
                return;
            }
            if (dimMax == -1 && dimMin == -1) {
                if (dimDefault == 1) {
                    this.f4451a.write(f4450o + dimString + ": '???????????',\n");
                    return;
                }
                if (dimDefault != 2) {
                    return;
                }
                this.f4451a.write(f4450o + dimString + ": '" + dimPercent + "%',\n");
                return;
            }
            if (dimDefault == 0) {
                this.f4451a.write(f4450o + dimString + ": {'spread' ," + dimMin + ", " + dimMax + "}\n");
                return;
            }
            if (dimDefault == 1) {
                this.f4451a.write(f4450o + dimString + ": {'wrap' ," + dimMin + ", " + dimMax + "}\n");
                return;
            }
            if (dimDefault != 2) {
                return;
            }
            this.f4451a.write(f4450o + dimString + ": {'" + dimPercent + "'% ," + dimMin + ", " + dimMax + "}\n");
        }

        public final void f(int orientation, int guideBegin, int guideEnd, float guidePercent) {
        }

        public void g() throws IOException {
            this.f4451a.write("\n'ConstraintSet':{\n");
            for (Integer num : d.this.f4290g.keySet()) {
                a aVar = (a) d.this.f4290g.get(num);
                String strA = a(num.intValue());
                this.f4451a.write(strA + ":{\n");
                b bVar = aVar.f4295e;
                e(SocializeProtocolConstants.HEIGHT, bVar.f4358e, bVar.f4351a0, bVar.f4363g0, bVar.f4359e0, bVar.f4355c0, bVar.f4379o0);
                e(SocializeProtocolConstants.WIDTH, bVar.f4356d, bVar.Z, bVar.f4361f0, bVar.f4357d0, bVar.f4353b0, bVar.f4377n0);
                d("'left'", bVar.f4368j, "'left'", bVar.H, bVar.O);
                d("'left'", bVar.f4370k, "'right'", bVar.H, bVar.O);
                d("'right'", bVar.f4372l, "'left'", bVar.I, bVar.Q);
                d("'right'", bVar.f4374m, "'right'", bVar.I, bVar.Q);
                d("'baseline'", bVar.f4384r, "'baseline'", -1, bVar.U);
                d("'baseline'", bVar.f4385s, "'top'", -1, bVar.U);
                d("'baseline'", bVar.f4386t, "'bottom'", -1, bVar.U);
                d("'top'", bVar.f4378o, "'bottom'", bVar.J, bVar.P);
                d("'top'", bVar.f4376n, "'top'", bVar.J, bVar.P);
                d("'bottom'", bVar.f4382q, "'bottom'", bVar.K, bVar.R);
                d("'bottom'", bVar.f4380p, "'top'", bVar.K, bVar.R);
                d("'start'", bVar.f4388v, "'start'", bVar.M, bVar.T);
                d("'start'", bVar.f4387u, "'end'", bVar.M, bVar.T);
                d("'end'", bVar.f4389w, "'start'", bVar.L, bVar.S);
                d("'end'", bVar.f4390x, "'end'", bVar.L, bVar.S);
                i("'horizontalBias'", bVar.f4391y, 0.5f);
                i("'verticalBias'", bVar.f4392z, 0.5f);
                c(bVar.B, bVar.D, bVar.C);
                f(bVar.G, bVar.f4360f, bVar.f4362g, bVar.f4364h);
                k("'dimensionRatio'", bVar.A);
                j("'barrierMargin'", bVar.f4367i0);
                j("'type'", bVar.f4369j0);
                k("'ReferenceId'", bVar.f4373l0);
                m("'mBarrierAllowsGoneWidgets'", bVar.f4381p0, true);
                j("'WrapBehavior'", bVar.f4383q0);
                h("'verticalWeight'", bVar.V);
                h("'horizontalWeight'", bVar.W);
                j("'horizontalChainStyle'", bVar.X);
                j("'verticalChainStyle'", bVar.Y);
                j("'barrierDirection'", bVar.f4365h0);
                int[] iArr = bVar.f4371k0;
                if (iArr != null) {
                    n("'ReferenceIds'", iArr);
                }
                this.f4451a.write("}\n");
            }
            this.f4451a.write("}\n");
        }

        public void h(String name, float value) throws IOException {
            if (value == -1.0f) {
                return;
            }
            this.f4451a.write(f4450o + name);
            this.f4451a.write(": " + value);
            this.f4451a.write(",\n");
        }

        public void i(String name, float value, float def) throws IOException {
            if (value == def) {
                return;
            }
            this.f4451a.write(f4450o + name);
            this.f4451a.write(": " + value);
            this.f4451a.write(",\n");
        }

        public void j(String name, int value) throws IOException {
            if (value == 0 || value == -1) {
                return;
            }
            this.f4451a.write(f4450o + name);
            this.f4451a.write(":");
            this.f4451a.write(", " + value);
            this.f4451a.write("\n");
        }

        public void k(String name, String value) throws IOException {
            if (value == null) {
                return;
            }
            this.f4451a.write(f4450o + name);
            this.f4451a.write(":");
            this.f4451a.write(", " + value);
            this.f4451a.write("\n");
        }

        public void l(String name, boolean value) throws IOException {
            if (value) {
                this.f4451a.write(f4450o + name);
                this.f4451a.write(": " + value);
                this.f4451a.write(",\n");
            }
        }

        public void m(String name, boolean value, boolean def) throws IOException {
            if (value == def) {
                return;
            }
            this.f4451a.write(f4450o + name);
            this.f4451a.write(": " + value);
            this.f4451a.write(",\n");
        }

        public void n(String name, int[] value) throws IOException {
            if (value == null) {
                return;
            }
            this.f4451a.write(f4450o + name);
            this.f4451a.write(": ");
            int i10 = 0;
            while (i10 < value.length) {
                Writer writer = this.f4451a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i10 == 0 ? "[" : ", ");
                sb2.append(a(value[i10]));
                writer.write(sb2.toString());
                i10++;
            }
            this.f4451a.write("],\n");
        }
    }

    public class g {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final String f4465o = "\n       ";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Writer f4466a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ConstraintLayout f4467b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Context f4468c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f4469d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f4470e = 0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f4471f = "'left'";

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f4472g = "'right'";

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f4473h = "'baseline'";

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f4474i = "'bottom'";

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final String f4475j = "'top'";

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final String f4476k = "'start'";

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final String f4477l = "'end'";

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public HashMap<Integer, String> f4478m = new HashMap<>();

        public g(Writer writer, ConstraintLayout layout, int flags) throws IOException {
            this.f4466a = writer;
            this.f4467b = layout;
            this.f4468c = layout.getContext();
            this.f4469d = flags;
        }

        public String a(int id2) {
            if (this.f4478m.containsKey(Integer.valueOf(id2))) {
                return "@+id/" + this.f4478m.get(Integer.valueOf(id2)) + "";
            }
            if (id2 == 0) {
                return d.V1;
            }
            String strB = b(id2);
            this.f4478m.put(Integer.valueOf(id2), strB);
            return "@+id/" + strB + "";
        }

        public String b(int id2) {
            try {
                if (id2 != -1) {
                    return this.f4468c.getResources().getResourceEntryName(id2);
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("unknown");
                int i10 = this.f4470e + 1;
                this.f4470e = i10;
                sb2.append(i10);
                return sb2.toString();
            } catch (Exception unused) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("unknown");
                int i11 = this.f4470e + 1;
                this.f4470e = i11;
                sb3.append(i11);
                return sb3.toString();
            }
        }

        public final void c(String dimString, int dim, int def) throws IOException {
            if (dim != def) {
                if (dim == -2) {
                    this.f4466a.write(f4465o + dimString + "=\"wrap_content\"");
                    return;
                }
                if (dim == -1) {
                    this.f4466a.write(f4465o + dimString + "=\"match_parent\"");
                    return;
                }
                this.f4466a.write(f4465o + dimString + "=\"" + dim + "dp\"");
            }
        }

        public final void d(String dimString, boolean val, boolean def) throws IOException {
            if (val != def) {
                this.f4466a.write(f4465o + dimString + "=\"" + val + "dp\"");
            }
        }

        public void e(int circleConstraint, float circleAngle, int circleRadius) throws IOException {
            if (circleConstraint == -1) {
                return;
            }
            this.f4466a.write(xc.d.f55106y0);
            this.f4466a.write(":[");
            this.f4466a.write(a(circleConstraint));
            this.f4466a.write(", " + circleAngle);
            this.f4466a.write(circleRadius + "]");
        }

        public void f(String my, int leftToLeft, String other, int margin, int goneMargin) throws IOException {
            if (leftToLeft == -1) {
                return;
            }
            this.f4466a.write(f4465o + my);
            this.f4466a.write(":[");
            this.f4466a.write(a(leftToLeft));
            this.f4466a.write(" , ");
            this.f4466a.write(other);
            if (margin != 0) {
                this.f4466a.write(" , " + margin);
            }
            this.f4466a.write("],\n");
        }

        public final void g(String dimString, int dim, int def) throws IOException {
            if (dim != def) {
                this.f4466a.write(f4465o + dimString + "=\"" + dim + "dp\"");
            }
        }

        public final void h(String dimString, int val, String[] types, int def) throws IOException {
            if (val != def) {
                this.f4466a.write(f4465o + dimString + "=\"" + types[val] + "\"");
            }
        }

        public void i() throws IOException {
            this.f4466a.write("\n<ConstraintSet>\n");
            for (Integer num : d.this.f4290g.keySet()) {
                a aVar = (a) d.this.f4290g.get(num);
                String strA = a(num.intValue());
                this.f4466a.write("  <Constraint");
                this.f4466a.write("\n       android:id=\"" + strA + "\"");
                b bVar = aVar.f4295e;
                c("android:layout_width", bVar.f4356d, -5);
                c("android:layout_height", bVar.f4358e, -5);
                j("app:layout_constraintGuide_begin", (float) bVar.f4360f, -1.0f);
                j("app:layout_constraintGuide_end", bVar.f4362g, -1.0f);
                j("app:layout_constraintGuide_percent", bVar.f4364h, -1.0f);
                j("app:layout_constraintHorizontal_bias", bVar.f4391y, 0.5f);
                j("app:layout_constraintVertical_bias", bVar.f4392z, 0.5f);
                m("app:layout_constraintDimensionRatio", bVar.A, null);
                o("app:layout_constraintCircle", bVar.B);
                j("app:layout_constraintCircleRadius", bVar.C, 0.0f);
                j("app:layout_constraintCircleAngle", bVar.D, 0.0f);
                j("android:orientation", bVar.G, -1.0f);
                j("app:layout_constraintVertical_weight", bVar.V, -1.0f);
                j("app:layout_constraintHorizontal_weight", bVar.W, -1.0f);
                j("app:layout_constraintHorizontal_chainStyle", bVar.X, 0.0f);
                j("app:layout_constraintVertical_chainStyle", bVar.Y, 0.0f);
                j("app:barrierDirection", bVar.f4365h0, -1.0f);
                j("app:barrierMargin", bVar.f4367i0, 0.0f);
                g("app:layout_marginLeft", bVar.H, 0);
                g("app:layout_goneMarginLeft", bVar.O, Integer.MIN_VALUE);
                g("app:layout_marginRight", bVar.I, 0);
                g("app:layout_goneMarginRight", bVar.Q, Integer.MIN_VALUE);
                g("app:layout_marginStart", bVar.M, 0);
                g("app:layout_goneMarginStart", bVar.T, Integer.MIN_VALUE);
                g("app:layout_marginEnd", bVar.L, 0);
                g("app:layout_goneMarginEnd", bVar.S, Integer.MIN_VALUE);
                g("app:layout_marginTop", bVar.J, 0);
                g("app:layout_goneMarginTop", bVar.P, Integer.MIN_VALUE);
                g("app:layout_marginBottom", bVar.K, 0);
                g("app:layout_goneMarginBottom", bVar.R, Integer.MIN_VALUE);
                g("app:goneBaselineMargin", bVar.U, Integer.MIN_VALUE);
                g("app:baselineMargin", bVar.N, 0);
                d("app:layout_constrainedWidth", bVar.f4377n0, false);
                d("app:layout_constrainedHeight", bVar.f4379o0, false);
                d("app:barrierAllowsGoneWidgets", bVar.f4381p0, true);
                j("app:layout_wrapBehaviorInParent", bVar.f4383q0, 0.0f);
                o("app:baselineToBaseline", bVar.f4384r);
                o("app:baselineToBottom", bVar.f4386t);
                o("app:baselineToTop", bVar.f4385s);
                o("app:layout_constraintBottom_toBottomOf", bVar.f4382q);
                o("app:layout_constraintBottom_toTopOf", bVar.f4380p);
                o("app:layout_constraintEnd_toEndOf", bVar.f4390x);
                o("app:layout_constraintEnd_toStartOf", bVar.f4389w);
                o("app:layout_constraintLeft_toLeftOf", bVar.f4368j);
                o("app:layout_constraintLeft_toRightOf", bVar.f4370k);
                o("app:layout_constraintRight_toLeftOf", bVar.f4372l);
                o("app:layout_constraintRight_toRightOf", bVar.f4374m);
                o("app:layout_constraintStart_toEndOf", bVar.f4387u);
                o("app:layout_constraintStart_toStartOf", bVar.f4388v);
                o("app:layout_constraintTop_toBottomOf", bVar.f4378o);
                o("app:layout_constraintTop_toTopOf", bVar.f4376n);
                String[] strArr = {"spread", "wrap", "percent"};
                h("app:layout_constraintHeight_default", bVar.f4351a0, strArr, 0);
                j("app:layout_constraintHeight_percent", bVar.f4363g0, 1.0f);
                g("app:layout_constraintHeight_min", bVar.f4359e0, 0);
                g("app:layout_constraintHeight_max", bVar.f4355c0, 0);
                d("android:layout_constrainedHeight", bVar.f4379o0, false);
                h("app:layout_constraintWidth_default", bVar.Z, strArr, 0);
                j("app:layout_constraintWidth_percent", bVar.f4361f0, 1.0f);
                g("app:layout_constraintWidth_min", bVar.f4357d0, 0);
                g("app:layout_constraintWidth_max", bVar.f4353b0, 0);
                d("android:layout_constrainedWidth", bVar.f4377n0, false);
                j("app:layout_constraintVertical_weight", bVar.V, -1.0f);
                j("app:layout_constraintHorizontal_weight", bVar.W, -1.0f);
                k("app:layout_constraintHorizontal_chainStyle", bVar.X);
                k("app:layout_constraintVertical_chainStyle", bVar.Y);
                h("app:barrierDirection", bVar.f4365h0, new String[]{xc.d.f55080k0, xc.d.f55082m0, "top", "bottom", xc.d.f55084n0, "end"}, -1);
                m("app:layout_constraintTag", bVar.f4375m0, null);
                int[] iArr = bVar.f4371k0;
                if (iArr != null) {
                    n("'ReferenceIds'", iArr);
                }
                this.f4466a.write(" />\n");
            }
            this.f4466a.write("</ConstraintSet>\n");
        }

        public void j(String name, float value, float def) throws IOException {
            if (value == def) {
                return;
            }
            this.f4466a.write(f4465o + name);
            this.f4466a.write("=\"" + value + "\"");
        }

        public void k(String name, int value) throws IOException {
            if (value == 0 || value == -1) {
                return;
            }
            this.f4466a.write(f4465o + name + "=\"" + value + "\"\n");
        }

        public void l(String name, String value) throws IOException {
            if (value == null) {
                return;
            }
            this.f4466a.write(name);
            this.f4466a.write(":");
            this.f4466a.write(", " + value);
            this.f4466a.write("\n");
        }

        public void m(String name, String value, String def) throws IOException {
            if (value == null || value.equals(def)) {
                return;
            }
            this.f4466a.write(f4465o + name);
            this.f4466a.write("=\"" + value + "\"");
        }

        public void n(String name, int[] value) throws IOException {
            if (value == null) {
                return;
            }
            this.f4466a.write(f4465o + name);
            this.f4466a.write(":");
            int i10 = 0;
            while (i10 < value.length) {
                Writer writer = this.f4466a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i10 == 0 ? "[" : ", ");
                sb2.append(a(value[i10]));
                writer.write(sb2.toString());
                i10++;
            }
            this.f4466a.write("],\n");
        }

        public void o(String str, int leftToLeft) throws IOException {
            if (leftToLeft == -1) {
                return;
            }
            this.f4466a.write(f4465o + str);
            this.f4466a.write("=\"" + a(leftToLeft) + "\"");
        }
    }

    static {
        W.append(R.styleable.Constraint_layout_constraintLeft_toLeftOf, 25);
        W.append(R.styleable.Constraint_layout_constraintLeft_toRightOf, 26);
        W.append(R.styleable.Constraint_layout_constraintRight_toLeftOf, 29);
        W.append(R.styleable.Constraint_layout_constraintRight_toRightOf, 30);
        W.append(R.styleable.Constraint_layout_constraintTop_toTopOf, 36);
        W.append(R.styleable.Constraint_layout_constraintTop_toBottomOf, 35);
        W.append(R.styleable.Constraint_layout_constraintBottom_toTopOf, 4);
        W.append(R.styleable.Constraint_layout_constraintBottom_toBottomOf, 3);
        W.append(R.styleable.Constraint_layout_constraintBaseline_toBaselineOf, 1);
        W.append(R.styleable.Constraint_layout_constraintBaseline_toTopOf, 91);
        W.append(R.styleable.Constraint_layout_constraintBaseline_toBottomOf, 92);
        W.append(R.styleable.Constraint_layout_editor_absoluteX, 6);
        W.append(R.styleable.Constraint_layout_editor_absoluteY, 7);
        W.append(R.styleable.Constraint_layout_constraintGuide_begin, 17);
        W.append(R.styleable.Constraint_layout_constraintGuide_end, 18);
        W.append(R.styleable.Constraint_layout_constraintGuide_percent, 19);
        W.append(R.styleable.Constraint_guidelineUseRtl, 99);
        W.append(R.styleable.Constraint_android_orientation, 27);
        W.append(R.styleable.Constraint_layout_constraintStart_toEndOf, 32);
        W.append(R.styleable.Constraint_layout_constraintStart_toStartOf, 33);
        W.append(R.styleable.Constraint_layout_constraintEnd_toStartOf, 10);
        W.append(R.styleable.Constraint_layout_constraintEnd_toEndOf, 9);
        W.append(R.styleable.Constraint_layout_goneMarginLeft, 13);
        W.append(R.styleable.Constraint_layout_goneMarginTop, 16);
        W.append(R.styleable.Constraint_layout_goneMarginRight, 14);
        W.append(R.styleable.Constraint_layout_goneMarginBottom, 11);
        W.append(R.styleable.Constraint_layout_goneMarginStart, 15);
        W.append(R.styleable.Constraint_layout_goneMarginEnd, 12);
        W.append(R.styleable.Constraint_layout_constraintVertical_weight, 40);
        W.append(R.styleable.Constraint_layout_constraintHorizontal_weight, 39);
        W.append(R.styleable.Constraint_layout_constraintHorizontal_chainStyle, 41);
        W.append(R.styleable.Constraint_layout_constraintVertical_chainStyle, 42);
        W.append(R.styleable.Constraint_layout_constraintHorizontal_bias, 20);
        W.append(R.styleable.Constraint_layout_constraintVertical_bias, 37);
        W.append(R.styleable.Constraint_layout_constraintDimensionRatio, 5);
        W.append(R.styleable.Constraint_layout_constraintLeft_creator, 87);
        W.append(R.styleable.Constraint_layout_constraintTop_creator, 87);
        W.append(R.styleable.Constraint_layout_constraintRight_creator, 87);
        W.append(R.styleable.Constraint_layout_constraintBottom_creator, 87);
        W.append(R.styleable.Constraint_layout_constraintBaseline_creator, 87);
        W.append(R.styleable.Constraint_android_layout_marginLeft, 24);
        W.append(R.styleable.Constraint_android_layout_marginRight, 28);
        W.append(R.styleable.Constraint_android_layout_marginStart, 31);
        W.append(R.styleable.Constraint_android_layout_marginEnd, 8);
        W.append(R.styleable.Constraint_android_layout_marginTop, 34);
        W.append(R.styleable.Constraint_android_layout_marginBottom, 2);
        W.append(R.styleable.Constraint_android_layout_width, 23);
        W.append(R.styleable.Constraint_android_layout_height, 21);
        W.append(R.styleable.Constraint_layout_constraintWidth, 95);
        W.append(R.styleable.Constraint_layout_constraintHeight, 96);
        W.append(R.styleable.Constraint_android_visibility, 22);
        W.append(R.styleable.Constraint_android_alpha, 43);
        W.append(R.styleable.Constraint_android_elevation, 44);
        W.append(R.styleable.Constraint_android_rotationX, 45);
        W.append(R.styleable.Constraint_android_rotationY, 46);
        W.append(R.styleable.Constraint_android_rotation, 60);
        W.append(R.styleable.Constraint_android_scaleX, 47);
        W.append(R.styleable.Constraint_android_scaleY, 48);
        W.append(R.styleable.Constraint_android_transformPivotX, 49);
        W.append(R.styleable.Constraint_android_transformPivotY, 50);
        W.append(R.styleable.Constraint_android_translationX, 51);
        W.append(R.styleable.Constraint_android_translationY, 52);
        W.append(R.styleable.Constraint_android_translationZ, 53);
        W.append(R.styleable.Constraint_layout_constraintWidth_default, 54);
        W.append(R.styleable.Constraint_layout_constraintHeight_default, 55);
        W.append(R.styleable.Constraint_layout_constraintWidth_max, 56);
        W.append(R.styleable.Constraint_layout_constraintHeight_max, 57);
        W.append(R.styleable.Constraint_layout_constraintWidth_min, 58);
        W.append(R.styleable.Constraint_layout_constraintHeight_min, 59);
        W.append(R.styleable.Constraint_layout_constraintCircle, 61);
        W.append(R.styleable.Constraint_layout_constraintCircleRadius, 62);
        W.append(R.styleable.Constraint_layout_constraintCircleAngle, 63);
        W.append(R.styleable.Constraint_animateRelativeTo, 64);
        W.append(R.styleable.Constraint_transitionEasing, 65);
        W.append(R.styleable.Constraint_drawPath, 66);
        W.append(R.styleable.Constraint_transitionPathRotate, 67);
        W.append(R.styleable.Constraint_motionStagger, 79);
        W.append(R.styleable.Constraint_android_id, 38);
        W.append(R.styleable.Constraint_motionProgress, 68);
        W.append(R.styleable.Constraint_layout_constraintWidth_percent, 69);
        W.append(R.styleable.Constraint_layout_constraintHeight_percent, 70);
        W.append(R.styleable.Constraint_layout_wrapBehaviorInParent, 97);
        W.append(R.styleable.Constraint_chainUseRtl, 71);
        W.append(R.styleable.Constraint_barrierDirection, 72);
        W.append(R.styleable.Constraint_barrierMargin, 73);
        W.append(R.styleable.Constraint_constraint_referenced_ids, 74);
        W.append(R.styleable.Constraint_barrierAllowsGoneWidgets, 75);
        W.append(R.styleable.Constraint_pathMotionArc, 76);
        W.append(R.styleable.Constraint_layout_constraintTag, 77);
        W.append(R.styleable.Constraint_visibilityMode, 78);
        W.append(R.styleable.Constraint_layout_constrainedWidth, 80);
        W.append(R.styleable.Constraint_layout_constrainedHeight, 81);
        W.append(R.styleable.Constraint_polarRelativeTo, 82);
        W.append(R.styleable.Constraint_transformPivotTarget, 83);
        W.append(R.styleable.Constraint_quantizeMotionSteps, 84);
        W.append(R.styleable.Constraint_quantizeMotionPhase, 85);
        W.append(R.styleable.Constraint_quantizeMotionInterpolator, 86);
        SparseIntArray sparseIntArray = X;
        int i10 = R.styleable.ConstraintOverride_layout_editor_absoluteY;
        sparseIntArray.append(i10, 6);
        X.append(i10, 7);
        X.append(R.styleable.ConstraintOverride_android_orientation, 27);
        X.append(R.styleable.ConstraintOverride_layout_goneMarginLeft, 13);
        X.append(R.styleable.ConstraintOverride_layout_goneMarginTop, 16);
        X.append(R.styleable.ConstraintOverride_layout_goneMarginRight, 14);
        X.append(R.styleable.ConstraintOverride_layout_goneMarginBottom, 11);
        X.append(R.styleable.ConstraintOverride_layout_goneMarginStart, 15);
        X.append(R.styleable.ConstraintOverride_layout_goneMarginEnd, 12);
        X.append(R.styleable.ConstraintOverride_layout_constraintVertical_weight, 40);
        X.append(R.styleable.ConstraintOverride_layout_constraintHorizontal_weight, 39);
        X.append(R.styleable.ConstraintOverride_layout_constraintHorizontal_chainStyle, 41);
        X.append(R.styleable.ConstraintOverride_layout_constraintVertical_chainStyle, 42);
        X.append(R.styleable.ConstraintOverride_layout_constraintHorizontal_bias, 20);
        X.append(R.styleable.ConstraintOverride_layout_constraintVertical_bias, 37);
        X.append(R.styleable.ConstraintOverride_layout_constraintDimensionRatio, 5);
        X.append(R.styleable.ConstraintOverride_layout_constraintLeft_creator, 87);
        X.append(R.styleable.ConstraintOverride_layout_constraintTop_creator, 87);
        X.append(R.styleable.ConstraintOverride_layout_constraintRight_creator, 87);
        X.append(R.styleable.ConstraintOverride_layout_constraintBottom_creator, 87);
        X.append(R.styleable.ConstraintOverride_layout_constraintBaseline_creator, 87);
        X.append(R.styleable.ConstraintOverride_android_layout_marginLeft, 24);
        X.append(R.styleable.ConstraintOverride_android_layout_marginRight, 28);
        X.append(R.styleable.ConstraintOverride_android_layout_marginStart, 31);
        X.append(R.styleable.ConstraintOverride_android_layout_marginEnd, 8);
        X.append(R.styleable.ConstraintOverride_android_layout_marginTop, 34);
        X.append(R.styleable.ConstraintOverride_android_layout_marginBottom, 2);
        X.append(R.styleable.ConstraintOverride_android_layout_width, 23);
        X.append(R.styleable.ConstraintOverride_android_layout_height, 21);
        X.append(R.styleable.ConstraintOverride_layout_constraintWidth, 95);
        X.append(R.styleable.ConstraintOverride_layout_constraintHeight, 96);
        X.append(R.styleable.ConstraintOverride_android_visibility, 22);
        X.append(R.styleable.ConstraintOverride_android_alpha, 43);
        X.append(R.styleable.ConstraintOverride_android_elevation, 44);
        X.append(R.styleable.ConstraintOverride_android_rotationX, 45);
        X.append(R.styleable.ConstraintOverride_android_rotationY, 46);
        X.append(R.styleable.ConstraintOverride_android_rotation, 60);
        X.append(R.styleable.ConstraintOverride_android_scaleX, 47);
        X.append(R.styleable.ConstraintOverride_android_scaleY, 48);
        X.append(R.styleable.ConstraintOverride_android_transformPivotX, 49);
        X.append(R.styleable.ConstraintOverride_android_transformPivotY, 50);
        X.append(R.styleable.ConstraintOverride_android_translationX, 51);
        X.append(R.styleable.ConstraintOverride_android_translationY, 52);
        X.append(R.styleable.ConstraintOverride_android_translationZ, 53);
        X.append(R.styleable.ConstraintOverride_layout_constraintWidth_default, 54);
        X.append(R.styleable.ConstraintOverride_layout_constraintHeight_default, 55);
        X.append(R.styleable.ConstraintOverride_layout_constraintWidth_max, 56);
        X.append(R.styleable.ConstraintOverride_layout_constraintHeight_max, 57);
        X.append(R.styleable.ConstraintOverride_layout_constraintWidth_min, 58);
        X.append(R.styleable.ConstraintOverride_layout_constraintHeight_min, 59);
        X.append(R.styleable.ConstraintOverride_layout_constraintCircleRadius, 62);
        X.append(R.styleable.ConstraintOverride_layout_constraintCircleAngle, 63);
        X.append(R.styleable.ConstraintOverride_animateRelativeTo, 64);
        X.append(R.styleable.ConstraintOverride_transitionEasing, 65);
        X.append(R.styleable.ConstraintOverride_drawPath, 66);
        X.append(R.styleable.ConstraintOverride_transitionPathRotate, 67);
        X.append(R.styleable.ConstraintOverride_motionStagger, 79);
        X.append(R.styleable.ConstraintOverride_android_id, 38);
        X.append(R.styleable.ConstraintOverride_motionTarget, 98);
        X.append(R.styleable.ConstraintOverride_motionProgress, 68);
        X.append(R.styleable.ConstraintOverride_layout_constraintWidth_percent, 69);
        X.append(R.styleable.ConstraintOverride_layout_constraintHeight_percent, 70);
        X.append(R.styleable.ConstraintOverride_chainUseRtl, 71);
        X.append(R.styleable.ConstraintOverride_barrierDirection, 72);
        X.append(R.styleable.ConstraintOverride_barrierMargin, 73);
        X.append(R.styleable.ConstraintOverride_constraint_referenced_ids, 74);
        X.append(R.styleable.ConstraintOverride_barrierAllowsGoneWidgets, 75);
        X.append(R.styleable.ConstraintOverride_pathMotionArc, 76);
        X.append(R.styleable.ConstraintOverride_layout_constraintTag, 77);
        X.append(R.styleable.ConstraintOverride_visibilityMode, 78);
        X.append(R.styleable.ConstraintOverride_layout_constrainedWidth, 80);
        X.append(R.styleable.ConstraintOverride_layout_constrainedHeight, 81);
        X.append(R.styleable.ConstraintOverride_polarRelativeTo, 82);
        X.append(R.styleable.ConstraintOverride_transformPivotTarget, 83);
        X.append(R.styleable.ConstraintOverride_quantizeMotionSteps, 84);
        X.append(R.styleable.ConstraintOverride_quantizeMotionPhase, 85);
        X.append(R.styleable.ConstraintOverride_quantizeMotionInterpolator, 86);
        X.append(R.styleable.ConstraintOverride_layout_wrapBehaviorInParent, 97);
    }

    public static void A0(Object data, TypedArray a10, int attr, int orientation) {
        if (data == null) {
            return;
        }
        int i10 = a10.peekValue(attr).type;
        if (i10 == 3) {
            B0(data, a10.getString(attr), orientation);
            return;
        }
        int dimensionPixelSize = -2;
        boolean z10 = false;
        if (i10 != 5) {
            int i11 = a10.getInt(attr, 0);
            if (i11 != -4) {
                dimensionPixelSize = (i11 == -3 || !(i11 == -2 || i11 == -1)) ? 0 : i11;
            } else {
                z10 = true;
            }
        } else {
            dimensionPixelSize = a10.getDimensionPixelSize(attr, 0);
        }
        if (data instanceof ConstraintLayout.b) {
            ConstraintLayout.b bVar = (ConstraintLayout.b) data;
            if (orientation == 0) {
                ((ViewGroup.MarginLayoutParams) bVar).width = dimensionPixelSize;
                bVar.f4074a0 = z10;
                return;
            } else {
                ((ViewGroup.MarginLayoutParams) bVar).height = dimensionPixelSize;
                bVar.f4076b0 = z10;
                return;
            }
        }
        if (data instanceof b) {
            b bVar2 = (b) data;
            if (orientation == 0) {
                bVar2.f4356d = dimensionPixelSize;
                bVar2.f4377n0 = z10;
                return;
            } else {
                bVar2.f4358e = dimensionPixelSize;
                bVar2.f4379o0 = z10;
                return;
            }
        }
        if (data instanceof a.C0038a) {
            a.C0038a c0038a = (a.C0038a) data;
            if (orientation == 0) {
                c0038a.b(23, dimensionPixelSize);
                c0038a.d(80, z10);
            } else {
                c0038a.b(21, dimensionPixelSize);
                c0038a.d(81, z10);
            }
        }
    }

    public static void B0(Object data, String value, int orientation) {
        if (value == null) {
            return;
        }
        int iIndexOf = value.indexOf(61);
        int length = value.length();
        if (iIndexOf <= 0 || iIndexOf >= length - 1) {
            return;
        }
        String strSubstring = value.substring(0, iIndexOf);
        String strSubstring2 = value.substring(iIndexOf + 1);
        if (strSubstring2.length() > 0) {
            String strTrim = strSubstring.trim();
            String strTrim2 = strSubstring2.trim();
            if (U1.equalsIgnoreCase(strTrim)) {
                if (data instanceof ConstraintLayout.b) {
                    ConstraintLayout.b bVar = (ConstraintLayout.b) data;
                    if (orientation == 0) {
                        ((ViewGroup.MarginLayoutParams) bVar).width = 0;
                    } else {
                        ((ViewGroup.MarginLayoutParams) bVar).height = 0;
                    }
                    C0(bVar, strTrim2);
                    return;
                }
                if (data instanceof b) {
                    ((b) data).A = strTrim2;
                    return;
                } else {
                    if (data instanceof a.C0038a) {
                        ((a.C0038a) data).c(5, strTrim2);
                        return;
                    }
                    return;
                }
            }
            try {
                if ("weight".equalsIgnoreCase(strTrim)) {
                    float f10 = Float.parseFloat(strTrim2);
                    if (data instanceof ConstraintLayout.b) {
                        ConstraintLayout.b bVar2 = (ConstraintLayout.b) data;
                        if (orientation == 0) {
                            ((ViewGroup.MarginLayoutParams) bVar2).width = 0;
                            bVar2.L = f10;
                        } else {
                            ((ViewGroup.MarginLayoutParams) bVar2).height = 0;
                            bVar2.M = f10;
                        }
                    } else if (data instanceof b) {
                        b bVar3 = (b) data;
                        if (orientation == 0) {
                            bVar3.f4356d = 0;
                            bVar3.W = f10;
                        } else {
                            bVar3.f4358e = 0;
                            bVar3.V = f10;
                        }
                    } else if (data instanceof a.C0038a) {
                        a.C0038a c0038a = (a.C0038a) data;
                        if (orientation == 0) {
                            c0038a.b(23, 0);
                            c0038a.a(39, f10);
                        } else {
                            c0038a.b(21, 0);
                            c0038a.a(40, f10);
                        }
                    }
                } else {
                    if (!V1.equalsIgnoreCase(strTrim)) {
                        return;
                    }
                    float fMax = Math.max(0.0f, Math.min(1.0f, Float.parseFloat(strTrim2)));
                    if (data instanceof ConstraintLayout.b) {
                        ConstraintLayout.b bVar4 = (ConstraintLayout.b) data;
                        if (orientation == 0) {
                            ((ViewGroup.MarginLayoutParams) bVar4).width = 0;
                            bVar4.V = fMax;
                            bVar4.P = 2;
                        } else {
                            ((ViewGroup.MarginLayoutParams) bVar4).height = 0;
                            bVar4.W = fMax;
                            bVar4.Q = 2;
                        }
                    } else if (data instanceof b) {
                        b bVar5 = (b) data;
                        if (orientation == 0) {
                            bVar5.f4356d = 0;
                            bVar5.f4361f0 = fMax;
                            bVar5.Z = 2;
                        } else {
                            bVar5.f4358e = 0;
                            bVar5.f4363g0 = fMax;
                            bVar5.f4351a0 = 2;
                        }
                    } else if (data instanceof a.C0038a) {
                        a.C0038a c0038a2 = (a.C0038a) data;
                        if (orientation == 0) {
                            c0038a2.b(23, 0);
                            c0038a2.b(54, 2);
                        } else {
                            c0038a2.b(21, 0);
                            c0038a2.b(55, 2);
                        }
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
    }

    public static void C0(ConstraintLayout.b params, String value) {
        float fAbs = Float.NaN;
        int i10 = -1;
        if (value != null) {
            int length = value.length();
            int iIndexOf = value.indexOf(44);
            int i11 = 0;
            if (iIndexOf > 0 && iIndexOf < length - 1) {
                String strSubstring = value.substring(0, iIndexOf);
                if (strSubstring.equalsIgnoreCase(i1.a.T4)) {
                    i10 = 0;
                } else if (strSubstring.equalsIgnoreCase("H")) {
                    i10 = 1;
                }
                i11 = iIndexOf + 1;
            }
            int iIndexOf2 = value.indexOf(58);
            try {
                if (iIndexOf2 < 0 || iIndexOf2 >= length - 1) {
                    String strSubstring2 = value.substring(i11);
                    if (strSubstring2.length() > 0) {
                        fAbs = Float.parseFloat(strSubstring2);
                    }
                } else {
                    String strSubstring3 = value.substring(i11, iIndexOf2);
                    String strSubstring4 = value.substring(iIndexOf2 + 1);
                    if (strSubstring3.length() > 0 && strSubstring4.length() > 0) {
                        float f10 = Float.parseFloat(strSubstring3);
                        float f11 = Float.parseFloat(strSubstring4);
                        if (f10 > 0.0f && f11 > 0.0f) {
                            fAbs = i10 == 1 ? Math.abs(f11 / f10) : Math.abs(f10 / f11);
                        }
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
        params.I = value;
        params.J = fAbs;
        params.K = i10;
    }

    public static String[] G1(String str) {
        char[] charArray = str.toCharArray();
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        boolean z10 = false;
        for (int i11 = 0; i11 < charArray.length; i11++) {
            if (charArray[i11] == ',' && !z10) {
                arrayList.add(new String(charArray, i10, i11 - i10));
                i10 = i11 + 1;
            } else if (charArray[i11] == '\"') {
                z10 = !z10;
            }
        }
        arrayList.add(new String(charArray, i10, charArray.length - i10));
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static void H0(Context ctx, a c10, TypedArray a10) {
        int indexCount = a10.getIndexCount();
        a.C0038a c0038a = new a.C0038a();
        c10.f4298h = c0038a;
        c10.f4294d.f4405a = false;
        c10.f4295e.f4352b = false;
        c10.f4293c.f4419a = false;
        c10.f4296f.f4436a = false;
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = a10.getIndex(i10);
            switch (X.get(index)) {
                case 2:
                    c0038a.b(2, a10.getDimensionPixelSize(index, c10.f4295e.K));
                    break;
                case 3:
                case 4:
                case 9:
                case 10:
                case 25:
                case 26:
                case 29:
                case 30:
                case 32:
                case 33:
                case 35:
                case 36:
                case 61:
                case 88:
                case 89:
                case 90:
                case 91:
                case 92:
                default:
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Unknown attribute 0x");
                    sb2.append(Integer.toHexString(index));
                    sb2.append("   ");
                    sb2.append(W.get(index));
                    break;
                case 5:
                    c0038a.c(5, a10.getString(index));
                    break;
                case 6:
                    c0038a.b(6, a10.getDimensionPixelOffset(index, c10.f4295e.E));
                    break;
                case 7:
                    c0038a.b(7, a10.getDimensionPixelOffset(index, c10.f4295e.F));
                    break;
                case 8:
                    c0038a.b(8, a10.getDimensionPixelSize(index, c10.f4295e.L));
                    break;
                case 11:
                    c0038a.b(11, a10.getDimensionPixelSize(index, c10.f4295e.R));
                    break;
                case 12:
                    c0038a.b(12, a10.getDimensionPixelSize(index, c10.f4295e.S));
                    break;
                case 13:
                    c0038a.b(13, a10.getDimensionPixelSize(index, c10.f4295e.O));
                    break;
                case 14:
                    c0038a.b(14, a10.getDimensionPixelSize(index, c10.f4295e.Q));
                    break;
                case 15:
                    c0038a.b(15, a10.getDimensionPixelSize(index, c10.f4295e.T));
                    break;
                case 16:
                    c0038a.b(16, a10.getDimensionPixelSize(index, c10.f4295e.P));
                    break;
                case 17:
                    c0038a.b(17, a10.getDimensionPixelOffset(index, c10.f4295e.f4360f));
                    break;
                case 18:
                    c0038a.b(18, a10.getDimensionPixelOffset(index, c10.f4295e.f4362g));
                    break;
                case 19:
                    c0038a.a(19, a10.getFloat(index, c10.f4295e.f4364h));
                    break;
                case 20:
                    c0038a.a(20, a10.getFloat(index, c10.f4295e.f4391y));
                    break;
                case 21:
                    c0038a.b(21, a10.getLayoutDimension(index, c10.f4295e.f4358e));
                    break;
                case 22:
                    c0038a.b(22, U[a10.getInt(index, c10.f4293c.f4420b)]);
                    break;
                case 23:
                    c0038a.b(23, a10.getLayoutDimension(index, c10.f4295e.f4356d));
                    break;
                case 24:
                    c0038a.b(24, a10.getDimensionPixelSize(index, c10.f4295e.H));
                    break;
                case 27:
                    c0038a.b(27, a10.getInt(index, c10.f4295e.G));
                    break;
                case 28:
                    c0038a.b(28, a10.getDimensionPixelSize(index, c10.f4295e.I));
                    break;
                case 31:
                    c0038a.b(31, a10.getDimensionPixelSize(index, c10.f4295e.M));
                    break;
                case 34:
                    c0038a.b(34, a10.getDimensionPixelSize(index, c10.f4295e.J));
                    break;
                case 37:
                    c0038a.a(37, a10.getFloat(index, c10.f4295e.f4392z));
                    break;
                case 38:
                    int resourceId = a10.getResourceId(index, c10.f4291a);
                    c10.f4291a = resourceId;
                    c0038a.b(38, resourceId);
                    break;
                case 39:
                    c0038a.a(39, a10.getFloat(index, c10.f4295e.W));
                    break;
                case 40:
                    c0038a.a(40, a10.getFloat(index, c10.f4295e.V));
                    break;
                case 41:
                    c0038a.b(41, a10.getInt(index, c10.f4295e.X));
                    break;
                case 42:
                    c0038a.b(42, a10.getInt(index, c10.f4295e.Y));
                    break;
                case 43:
                    c0038a.a(43, a10.getFloat(index, c10.f4293c.f4422d));
                    break;
                case 44:
                    c0038a.d(44, true);
                    c0038a.a(44, a10.getDimension(index, c10.f4296f.f4449n));
                    break;
                case 45:
                    c0038a.a(45, a10.getFloat(index, c10.f4296f.f4438c));
                    break;
                case 46:
                    c0038a.a(46, a10.getFloat(index, c10.f4296f.f4439d));
                    break;
                case 47:
                    c0038a.a(47, a10.getFloat(index, c10.f4296f.f4440e));
                    break;
                case 48:
                    c0038a.a(48, a10.getFloat(index, c10.f4296f.f4441f));
                    break;
                case 49:
                    c0038a.a(49, a10.getDimension(index, c10.f4296f.f4442g));
                    break;
                case 50:
                    c0038a.a(50, a10.getDimension(index, c10.f4296f.f4443h));
                    break;
                case 51:
                    c0038a.a(51, a10.getDimension(index, c10.f4296f.f4445j));
                    break;
                case 52:
                    c0038a.a(52, a10.getDimension(index, c10.f4296f.f4446k));
                    break;
                case 53:
                    c0038a.a(53, a10.getDimension(index, c10.f4296f.f4447l));
                    break;
                case 54:
                    c0038a.b(54, a10.getInt(index, c10.f4295e.Z));
                    break;
                case 55:
                    c0038a.b(55, a10.getInt(index, c10.f4295e.f4351a0));
                    break;
                case 56:
                    c0038a.b(56, a10.getDimensionPixelSize(index, c10.f4295e.f4353b0));
                    break;
                case 57:
                    c0038a.b(57, a10.getDimensionPixelSize(index, c10.f4295e.f4355c0));
                    break;
                case 58:
                    c0038a.b(58, a10.getDimensionPixelSize(index, c10.f4295e.f4357d0));
                    break;
                case 59:
                    c0038a.b(59, a10.getDimensionPixelSize(index, c10.f4295e.f4359e0));
                    break;
                case 60:
                    c0038a.a(60, a10.getFloat(index, c10.f4296f.f4437b));
                    break;
                case 62:
                    c0038a.b(62, a10.getDimensionPixelSize(index, c10.f4295e.C));
                    break;
                case 63:
                    c0038a.a(63, a10.getFloat(index, c10.f4295e.D));
                    break;
                case 64:
                    c0038a.b(64, y0(a10, index, c10.f4294d.f4406b));
                    break;
                case 65:
                    if (a10.peekValue(index).type == 3) {
                        c0038a.c(65, a10.getString(index));
                    } else {
                        c0038a.c(65, w.d.f53426o[a10.getInteger(index, 0)]);
                    }
                    break;
                case 66:
                    c0038a.b(66, a10.getInt(index, 0));
                    break;
                case 67:
                    c0038a.a(67, a10.getFloat(index, c10.f4294d.f4413i));
                    break;
                case 68:
                    c0038a.a(68, a10.getFloat(index, c10.f4293c.f4423e));
                    break;
                case 69:
                    c0038a.a(69, a10.getFloat(index, 1.0f));
                    break;
                case 70:
                    c0038a.a(70, a10.getFloat(index, 1.0f));
                    break;
                case 71:
                    break;
                case 72:
                    c0038a.b(72, a10.getInt(index, c10.f4295e.f4365h0));
                    break;
                case 73:
                    c0038a.b(73, a10.getDimensionPixelSize(index, c10.f4295e.f4367i0));
                    break;
                case 74:
                    c0038a.c(74, a10.getString(index));
                    break;
                case 75:
                    c0038a.d(75, a10.getBoolean(index, c10.f4295e.f4381p0));
                    break;
                case 76:
                    c0038a.b(76, a10.getInt(index, c10.f4294d.f4409e));
                    break;
                case 77:
                    c0038a.c(77, a10.getString(index));
                    break;
                case 78:
                    c0038a.b(78, a10.getInt(index, c10.f4293c.f4421c));
                    break;
                case 79:
                    c0038a.a(79, a10.getFloat(index, c10.f4294d.f4411g));
                    break;
                case 80:
                    c0038a.d(80, a10.getBoolean(index, c10.f4295e.f4377n0));
                    break;
                case 81:
                    c0038a.d(81, a10.getBoolean(index, c10.f4295e.f4379o0));
                    break;
                case 82:
                    c0038a.b(82, a10.getInteger(index, c10.f4294d.f4407c));
                    break;
                case 83:
                    c0038a.b(83, y0(a10, index, c10.f4296f.f4444i));
                    break;
                case 84:
                    c0038a.b(84, a10.getInteger(index, c10.f4294d.f4415k));
                    break;
                case 85:
                    c0038a.a(85, a10.getFloat(index, c10.f4294d.f4414j));
                    break;
                case 86:
                    int i11 = a10.peekValue(index).type;
                    if (i11 == 1) {
                        c10.f4294d.f4418n = a10.getResourceId(index, -1);
                        c0038a.b(89, c10.f4294d.f4418n);
                        c cVar = c10.f4294d;
                        if (cVar.f4418n != -1) {
                            cVar.f4417m = -2;
                            c0038a.b(88, -2);
                        }
                    } else if (i11 == 3) {
                        c10.f4294d.f4416l = a10.getString(index);
                        c0038a.c(90, c10.f4294d.f4416l);
                        if (c10.f4294d.f4416l.indexOf(fh.a.f28350w) > 0) {
                            c10.f4294d.f4418n = a10.getResourceId(index, -1);
                            c0038a.b(89, c10.f4294d.f4418n);
                            c10.f4294d.f4417m = -2;
                            c0038a.b(88, -2);
                        } else {
                            c10.f4294d.f4417m = -1;
                            c0038a.b(88, -1);
                        }
                    } else {
                        c cVar2 = c10.f4294d;
                        cVar2.f4417m = a10.getInteger(index, cVar2.f4418n);
                        c0038a.b(88, c10.f4294d.f4417m);
                    }
                    break;
                case 87:
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("unused attribute 0x");
                    sb3.append(Integer.toHexString(index));
                    sb3.append("   ");
                    sb3.append(W.get(index));
                    break;
                case 93:
                    c0038a.b(93, a10.getDimensionPixelSize(index, c10.f4295e.N));
                    break;
                case 94:
                    c0038a.b(94, a10.getDimensionPixelSize(index, c10.f4295e.U));
                    break;
                case 95:
                    A0(c0038a, a10, index, 0);
                    break;
                case 96:
                    A0(c0038a, a10, index, 1);
                    break;
                case 97:
                    c0038a.b(97, a10.getInt(index, c10.f4295e.f4383q0));
                    break;
                case 98:
                    if (MotionLayout.f3495k9) {
                        int resourceId2 = a10.getResourceId(index, c10.f4291a);
                        c10.f4291a = resourceId2;
                        if (resourceId2 == -1) {
                            c10.f4292b = a10.getString(index);
                        }
                    } else if (a10.peekValue(index).type == 3) {
                        c10.f4292b = a10.getString(index);
                    } else {
                        c10.f4291a = a10.getResourceId(index, c10.f4291a);
                    }
                    break;
                case 99:
                    c0038a.d(99, a10.getBoolean(index, c10.f4295e.f4366i));
                    break;
            }
        }
    }

    public static void R0(a c10, int type, float value) {
        if (type == 19) {
            c10.f4295e.f4364h = value;
        }
        if (type == 20) {
            c10.f4295e.f4391y = value;
            return;
        }
        if (type == 37) {
            c10.f4295e.f4392z = value;
            return;
        }
        if (type == 60) {
            c10.f4296f.f4437b = value;
            return;
        }
        if (type == 63) {
            c10.f4295e.D = value;
            return;
        }
        if (type == 79) {
            c10.f4294d.f4411g = value;
            return;
        }
        if (type == 85) {
            c10.f4294d.f4414j = value;
            return;
        }
        if (type == 39) {
            c10.f4295e.W = value;
            return;
        }
        if (type == 40) {
            c10.f4295e.V = value;
            return;
        }
        switch (type) {
            case 43:
                c10.f4293c.f4422d = value;
                break;
            case 44:
                e eVar = c10.f4296f;
                eVar.f4449n = value;
                eVar.f4448m = true;
                break;
            case 45:
                c10.f4296f.f4438c = value;
                break;
            case 46:
                c10.f4296f.f4439d = value;
                break;
            case 47:
                c10.f4296f.f4440e = value;
                break;
            case 48:
                c10.f4296f.f4441f = value;
                break;
            case 49:
                c10.f4296f.f4442g = value;
                break;
            case 50:
                c10.f4296f.f4443h = value;
                break;
            case 51:
                c10.f4296f.f4445j = value;
                break;
            case 52:
                c10.f4296f.f4446k = value;
                break;
            case 53:
                c10.f4296f.f4447l = value;
                break;
            default:
                switch (type) {
                    case 67:
                        c10.f4294d.f4413i = value;
                        break;
                    case 68:
                        c10.f4293c.f4423e = value;
                        break;
                    case 69:
                        c10.f4295e.f4361f0 = value;
                        break;
                    case 70:
                        c10.f4295e.f4363g0 = value;
                        break;
                }
                break;
        }
    }

    public static void S0(a c10, int type, int value) {
        if (type == 6) {
            c10.f4295e.E = value;
        }
        if (type == 7) {
            c10.f4295e.F = value;
            return;
        }
        if (type == 8) {
            c10.f4295e.L = value;
            return;
        }
        if (type == 27) {
            c10.f4295e.G = value;
            return;
        }
        if (type == 28) {
            c10.f4295e.I = value;
            return;
        }
        if (type == 41) {
            c10.f4295e.X = value;
            return;
        }
        if (type == 42) {
            c10.f4295e.Y = value;
            return;
        }
        if (type == 61) {
            c10.f4295e.B = value;
            return;
        }
        if (type == 62) {
            c10.f4295e.C = value;
            return;
        }
        if (type == 72) {
            c10.f4295e.f4365h0 = value;
            return;
        }
        if (type == 73) {
            c10.f4295e.f4367i0 = value;
            return;
        }
        if (type == 88) {
            c10.f4294d.f4417m = value;
            return;
        }
        if (type == 89) {
            c10.f4294d.f4418n = value;
            return;
        }
        switch (type) {
            case 2:
                c10.f4295e.K = value;
                break;
            case 11:
                c10.f4295e.R = value;
                break;
            case 12:
                c10.f4295e.S = value;
                break;
            case 13:
                c10.f4295e.O = value;
                break;
            case 14:
                c10.f4295e.Q = value;
                break;
            case 15:
                c10.f4295e.T = value;
                break;
            case 16:
                c10.f4295e.P = value;
                break;
            case 17:
                c10.f4295e.f4360f = value;
                break;
            case 18:
                c10.f4295e.f4362g = value;
                break;
            case 31:
                c10.f4295e.M = value;
                break;
            case 34:
                c10.f4295e.J = value;
                break;
            case 38:
                c10.f4291a = value;
                break;
            case 64:
                c10.f4294d.f4406b = value;
                break;
            case 66:
                c10.f4294d.f4410f = value;
                break;
            case 76:
                c10.f4294d.f4409e = value;
                break;
            case 78:
                c10.f4293c.f4421c = value;
                break;
            case 93:
                c10.f4295e.N = value;
                break;
            case 94:
                c10.f4295e.U = value;
                break;
            case 97:
                c10.f4295e.f4383q0 = value;
                break;
            default:
                switch (type) {
                    case 21:
                        c10.f4295e.f4358e = value;
                        break;
                    case 22:
                        c10.f4293c.f4420b = value;
                        break;
                    case 23:
                        c10.f4295e.f4356d = value;
                        break;
                    case 24:
                        c10.f4295e.H = value;
                        break;
                    default:
                        switch (type) {
                            case 54:
                                c10.f4295e.Z = value;
                                break;
                            case 55:
                                c10.f4295e.f4351a0 = value;
                                break;
                            case 56:
                                c10.f4295e.f4353b0 = value;
                                break;
                            case 57:
                                c10.f4295e.f4355c0 = value;
                                break;
                            case 58:
                                c10.f4295e.f4357d0 = value;
                                break;
                            case 59:
                                c10.f4295e.f4359e0 = value;
                                break;
                            default:
                                switch (type) {
                                    case 82:
                                        c10.f4294d.f4407c = value;
                                        break;
                                    case 83:
                                        c10.f4296f.f4444i = value;
                                        break;
                                    case 84:
                                        c10.f4294d.f4415k = value;
                                        break;
                                }
                                break;
                        }
                        break;
                }
                break;
        }
    }

    public static void T0(a c10, int type, String value) {
        if (type == 5) {
            c10.f4295e.A = value;
            return;
        }
        if (type == 65) {
            c10.f4294d.f4408d = value;
            return;
        }
        if (type == 74) {
            b bVar = c10.f4295e;
            bVar.f4373l0 = value;
            bVar.f4371k0 = null;
        } else if (type == 77) {
            c10.f4295e.f4375m0 = value;
        } else {
            if (type != 90) {
                return;
            }
            c10.f4294d.f4416l = value;
        }
    }

    public static void U0(a c10, int type, boolean value) {
        if (type == 44) {
            c10.f4296f.f4448m = value;
            return;
        }
        if (type == 75) {
            c10.f4295e.f4381p0 = value;
        } else if (type == 80) {
            c10.f4295e.f4377n0 = value;
        } else {
            if (type != 81) {
                return;
            }
            c10.f4295e.f4379o0 = value;
        }
    }

    public static String m0(int v10) {
        for (Field field : d.class.getDeclaredFields()) {
            if (field.getName().contains("_") && field.getType() == Integer.TYPE && Modifier.isStatic(field.getModifiers()) && Modifier.isFinal(field.getModifiers())) {
                try {
                    if (field.getInt(null) == v10) {
                        return field.getName();
                    }
                    continue;
                } catch (IllegalAccessException e10) {
                    e10.printStackTrace();
                }
            }
        }
        return o5.h.f42757n;
    }

    public static String p0(Context context, int resourceId, XmlPullParser pullParser) {
        return ".(" + androidx.constraintlayout.motion.widget.c.i(context, resourceId) + ".xml:" + pullParser.getLineNumber() + ") \"" + pullParser.getName() + "\"";
    }

    public static a w(Context context, XmlPullParser parser) {
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(parser);
        a aVar = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSetAsAttributeSet, R.styleable.ConstraintOverride);
        H0(context, aVar, typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
        return aVar;
    }

    public static int y0(TypedArray a10, int index, int def) {
        int resourceId = a10.getResourceId(index, def);
        return resourceId == -1 ? a10.getInt(index, -1) : resourceId;
    }

    public void A(int viewId, int toView) {
        if (toView == 0) {
            x(viewId, 0, 6, 0, 0, 7, 0, 0.5f);
        } else {
            x(viewId, toView, 7, 0, toView, 6, 0, 0.5f);
        }
    }

    public void A1(int viewId, float bias) {
        i0(viewId).f4295e.f4392z = bias;
    }

    public void B(int centerID, int startId, int startSide, int startMargin, int endId, int endSide, int endMargin, float bias) {
        L(centerID, 6, startId, startSide, startMargin);
        L(centerID, 7, endId, endSide, endMargin);
        a aVar = this.f4290g.get(Integer.valueOf(centerID));
        if (aVar != null) {
            aVar.f4295e.f4391y = bias;
        }
    }

    public void B1(int viewId, int chainStyle) {
        i0(viewId).f4295e.Y = chainStyle;
    }

    public void C(int viewId, int toView) {
        if (toView == 0) {
            x(viewId, 0, 3, 0, 0, 4, 0, 0.5f);
        } else {
            x(viewId, toView, 4, 0, toView, 3, 0, 0.5f);
        }
    }

    public void C1(int viewId, float weight) {
        i0(viewId).f4295e.V = weight;
    }

    public void D(int centerID, int topId, int topSide, int topMargin, int bottomId, int bottomSide, int bottomMargin, float bias) {
        L(centerID, 3, topId, topSide, topMargin);
        L(centerID, 4, bottomId, bottomSide, bottomMargin);
        a aVar = this.f4290g.get(Integer.valueOf(centerID));
        if (aVar != null) {
            aVar.f4295e.f4392z = bias;
        }
    }

    public void D0(a set, String attributes) {
        String[] strArrSplit = attributes.split(ag.c.f654g);
        for (int i10 = 0; i10 < strArrSplit.length; i10++) {
            String[] strArrSplit2 = strArrSplit[i10].split(u.f30904o);
            if (strArrSplit2.length != 2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(" Unable to parse ");
                sb2.append(strArrSplit[i10]);
            } else {
                set.q(strArrSplit2[0], Float.parseFloat(strArrSplit2[1]));
            }
        }
    }

    public void D1(int viewId, int visibility) {
        i0(viewId).f4293c.f4420b = visibility;
    }

    public void E(int viewId) {
        this.f4290g.remove(Integer.valueOf(viewId));
    }

    public void E0(a set, String attributes) {
        String[] strArrSplit = attributes.split(ag.c.f654g);
        for (int i10 = 0; i10 < strArrSplit.length; i10++) {
            String[] strArrSplit2 = strArrSplit[i10].split(u.f30904o);
            if (strArrSplit2.length != 2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(" Unable to parse ");
                sb2.append(strArrSplit[i10]);
            } else {
                set.q(strArrSplit2[0], Integer.decode(strArrSplit2[1]).intValue());
            }
        }
    }

    public void E1(int viewId, int visibilityMode) {
        i0(viewId).f4293c.f4421c = visibilityMode;
    }

    public void F(int viewId, int anchor) {
        a aVar;
        if (!this.f4290g.containsKey(Integer.valueOf(viewId)) || (aVar = this.f4290g.get(Integer.valueOf(viewId))) == null) {
            return;
        }
        switch (anchor) {
            case 1:
                b bVar = aVar.f4295e;
                bVar.f4370k = -1;
                bVar.f4368j = -1;
                bVar.H = -1;
                bVar.O = Integer.MIN_VALUE;
                return;
            case 2:
                b bVar2 = aVar.f4295e;
                bVar2.f4374m = -1;
                bVar2.f4372l = -1;
                bVar2.I = -1;
                bVar2.Q = Integer.MIN_VALUE;
                return;
            case 3:
                b bVar3 = aVar.f4295e;
                bVar3.f4378o = -1;
                bVar3.f4376n = -1;
                bVar3.J = 0;
                bVar3.P = Integer.MIN_VALUE;
                return;
            case 4:
                b bVar4 = aVar.f4295e;
                bVar4.f4380p = -1;
                bVar4.f4382q = -1;
                bVar4.K = 0;
                bVar4.R = Integer.MIN_VALUE;
                return;
            case 5:
                b bVar5 = aVar.f4295e;
                bVar5.f4384r = -1;
                bVar5.f4385s = -1;
                bVar5.f4386t = -1;
                bVar5.N = 0;
                bVar5.U = Integer.MIN_VALUE;
                return;
            case 6:
                b bVar6 = aVar.f4295e;
                bVar6.f4387u = -1;
                bVar6.f4388v = -1;
                bVar6.M = 0;
                bVar6.T = Integer.MIN_VALUE;
                return;
            case 7:
                b bVar7 = aVar.f4295e;
                bVar7.f4389w = -1;
                bVar7.f4390x = -1;
                bVar7.L = 0;
                bVar7.S = Integer.MIN_VALUE;
                return;
            case 8:
                b bVar8 = aVar.f4295e;
                bVar8.D = -1.0f;
                bVar8.C = -1;
                bVar8.B = -1;
                return;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public void F0(a set, String attributes) {
        String[] strArrG1 = G1(attributes);
        for (int i10 = 0; i10 < strArrG1.length; i10++) {
            String[] strArrSplit = strArrG1[i10].split(u.f30904o);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(" Unable to parse ");
            sb2.append(strArrG1[i10]);
            set.s(strArrSplit[0], strArrSplit[1]);
        }
    }

    public final String F1(int side) {
        switch (side) {
            case 1:
                return xc.d.f55080k0;
            case 2:
                return xc.d.f55082m0;
            case 3:
                return "top";
            case 4:
                return "bottom";
            case 5:
                return "baseline";
            case 6:
                return xc.d.f55084n0;
            case 7:
                return "end";
            default:
                return "undefined";
        }
    }

    public void G(Context context, int constraintLayoutId) {
        H((ConstraintLayout) LayoutInflater.from(context).inflate(constraintLayoutId, (ViewGroup) null));
    }

    public final void G0(Context ctx, a c10, TypedArray a10, boolean override) {
        if (override) {
            H0(ctx, c10, a10);
            return;
        }
        int indexCount = a10.getIndexCount();
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = a10.getIndex(i10);
            if (index != R.styleable.Constraint_android_id && R.styleable.Constraint_android_layout_marginStart != index && R.styleable.Constraint_android_layout_marginEnd != index) {
                c10.f4294d.f4405a = true;
                c10.f4295e.f4352b = true;
                c10.f4293c.f4419a = true;
                c10.f4296f.f4436a = true;
            }
            switch (W.get(index)) {
                case 1:
                    b bVar = c10.f4295e;
                    bVar.f4384r = y0(a10, index, bVar.f4384r);
                    break;
                case 2:
                    b bVar2 = c10.f4295e;
                    bVar2.K = a10.getDimensionPixelSize(index, bVar2.K);
                    break;
                case 3:
                    b bVar3 = c10.f4295e;
                    bVar3.f4382q = y0(a10, index, bVar3.f4382q);
                    break;
                case 4:
                    b bVar4 = c10.f4295e;
                    bVar4.f4380p = y0(a10, index, bVar4.f4380p);
                    break;
                case 5:
                    c10.f4295e.A = a10.getString(index);
                    break;
                case 6:
                    b bVar5 = c10.f4295e;
                    bVar5.E = a10.getDimensionPixelOffset(index, bVar5.E);
                    break;
                case 7:
                    b bVar6 = c10.f4295e;
                    bVar6.F = a10.getDimensionPixelOffset(index, bVar6.F);
                    break;
                case 8:
                    b bVar7 = c10.f4295e;
                    bVar7.L = a10.getDimensionPixelSize(index, bVar7.L);
                    break;
                case 9:
                    b bVar8 = c10.f4295e;
                    bVar8.f4390x = y0(a10, index, bVar8.f4390x);
                    break;
                case 10:
                    b bVar9 = c10.f4295e;
                    bVar9.f4389w = y0(a10, index, bVar9.f4389w);
                    break;
                case 11:
                    b bVar10 = c10.f4295e;
                    bVar10.R = a10.getDimensionPixelSize(index, bVar10.R);
                    break;
                case 12:
                    b bVar11 = c10.f4295e;
                    bVar11.S = a10.getDimensionPixelSize(index, bVar11.S);
                    break;
                case 13:
                    b bVar12 = c10.f4295e;
                    bVar12.O = a10.getDimensionPixelSize(index, bVar12.O);
                    break;
                case 14:
                    b bVar13 = c10.f4295e;
                    bVar13.Q = a10.getDimensionPixelSize(index, bVar13.Q);
                    break;
                case 15:
                    b bVar14 = c10.f4295e;
                    bVar14.T = a10.getDimensionPixelSize(index, bVar14.T);
                    break;
                case 16:
                    b bVar15 = c10.f4295e;
                    bVar15.P = a10.getDimensionPixelSize(index, bVar15.P);
                    break;
                case 17:
                    b bVar16 = c10.f4295e;
                    bVar16.f4360f = a10.getDimensionPixelOffset(index, bVar16.f4360f);
                    break;
                case 18:
                    b bVar17 = c10.f4295e;
                    bVar17.f4362g = a10.getDimensionPixelOffset(index, bVar17.f4362g);
                    break;
                case 19:
                    b bVar18 = c10.f4295e;
                    bVar18.f4364h = a10.getFloat(index, bVar18.f4364h);
                    break;
                case 20:
                    b bVar19 = c10.f4295e;
                    bVar19.f4391y = a10.getFloat(index, bVar19.f4391y);
                    break;
                case 21:
                    b bVar20 = c10.f4295e;
                    bVar20.f4358e = a10.getLayoutDimension(index, bVar20.f4358e);
                    break;
                case 22:
                    C0039d c0039d = c10.f4293c;
                    c0039d.f4420b = a10.getInt(index, c0039d.f4420b);
                    C0039d c0039d2 = c10.f4293c;
                    c0039d2.f4420b = U[c0039d2.f4420b];
                    break;
                case 23:
                    b bVar21 = c10.f4295e;
                    bVar21.f4356d = a10.getLayoutDimension(index, bVar21.f4356d);
                    break;
                case 24:
                    b bVar22 = c10.f4295e;
                    bVar22.H = a10.getDimensionPixelSize(index, bVar22.H);
                    break;
                case 25:
                    b bVar23 = c10.f4295e;
                    bVar23.f4368j = y0(a10, index, bVar23.f4368j);
                    break;
                case 26:
                    b bVar24 = c10.f4295e;
                    bVar24.f4370k = y0(a10, index, bVar24.f4370k);
                    break;
                case 27:
                    b bVar25 = c10.f4295e;
                    bVar25.G = a10.getInt(index, bVar25.G);
                    break;
                case 28:
                    b bVar26 = c10.f4295e;
                    bVar26.I = a10.getDimensionPixelSize(index, bVar26.I);
                    break;
                case 29:
                    b bVar27 = c10.f4295e;
                    bVar27.f4372l = y0(a10, index, bVar27.f4372l);
                    break;
                case 30:
                    b bVar28 = c10.f4295e;
                    bVar28.f4374m = y0(a10, index, bVar28.f4374m);
                    break;
                case 31:
                    b bVar29 = c10.f4295e;
                    bVar29.M = a10.getDimensionPixelSize(index, bVar29.M);
                    break;
                case 32:
                    b bVar30 = c10.f4295e;
                    bVar30.f4387u = y0(a10, index, bVar30.f4387u);
                    break;
                case 33:
                    b bVar31 = c10.f4295e;
                    bVar31.f4388v = y0(a10, index, bVar31.f4388v);
                    break;
                case 34:
                    b bVar32 = c10.f4295e;
                    bVar32.J = a10.getDimensionPixelSize(index, bVar32.J);
                    break;
                case 35:
                    b bVar33 = c10.f4295e;
                    bVar33.f4378o = y0(a10, index, bVar33.f4378o);
                    break;
                case 36:
                    b bVar34 = c10.f4295e;
                    bVar34.f4376n = y0(a10, index, bVar34.f4376n);
                    break;
                case 37:
                    b bVar35 = c10.f4295e;
                    bVar35.f4392z = a10.getFloat(index, bVar35.f4392z);
                    break;
                case 38:
                    c10.f4291a = a10.getResourceId(index, c10.f4291a);
                    break;
                case 39:
                    b bVar36 = c10.f4295e;
                    bVar36.W = a10.getFloat(index, bVar36.W);
                    break;
                case 40:
                    b bVar37 = c10.f4295e;
                    bVar37.V = a10.getFloat(index, bVar37.V);
                    break;
                case 41:
                    b bVar38 = c10.f4295e;
                    bVar38.X = a10.getInt(index, bVar38.X);
                    break;
                case 42:
                    b bVar39 = c10.f4295e;
                    bVar39.Y = a10.getInt(index, bVar39.Y);
                    break;
                case 43:
                    C0039d c0039d3 = c10.f4293c;
                    c0039d3.f4422d = a10.getFloat(index, c0039d3.f4422d);
                    break;
                case 44:
                    e eVar = c10.f4296f;
                    eVar.f4448m = true;
                    eVar.f4449n = a10.getDimension(index, eVar.f4449n);
                    break;
                case 45:
                    e eVar2 = c10.f4296f;
                    eVar2.f4438c = a10.getFloat(index, eVar2.f4438c);
                    break;
                case 46:
                    e eVar3 = c10.f4296f;
                    eVar3.f4439d = a10.getFloat(index, eVar3.f4439d);
                    break;
                case 47:
                    e eVar4 = c10.f4296f;
                    eVar4.f4440e = a10.getFloat(index, eVar4.f4440e);
                    break;
                case 48:
                    e eVar5 = c10.f4296f;
                    eVar5.f4441f = a10.getFloat(index, eVar5.f4441f);
                    break;
                case 49:
                    e eVar6 = c10.f4296f;
                    eVar6.f4442g = a10.getDimension(index, eVar6.f4442g);
                    break;
                case 50:
                    e eVar7 = c10.f4296f;
                    eVar7.f4443h = a10.getDimension(index, eVar7.f4443h);
                    break;
                case 51:
                    e eVar8 = c10.f4296f;
                    eVar8.f4445j = a10.getDimension(index, eVar8.f4445j);
                    break;
                case 52:
                    e eVar9 = c10.f4296f;
                    eVar9.f4446k = a10.getDimension(index, eVar9.f4446k);
                    break;
                case 53:
                    e eVar10 = c10.f4296f;
                    eVar10.f4447l = a10.getDimension(index, eVar10.f4447l);
                    break;
                case 54:
                    b bVar40 = c10.f4295e;
                    bVar40.Z = a10.getInt(index, bVar40.Z);
                    break;
                case 55:
                    b bVar41 = c10.f4295e;
                    bVar41.f4351a0 = a10.getInt(index, bVar41.f4351a0);
                    break;
                case 56:
                    b bVar42 = c10.f4295e;
                    bVar42.f4353b0 = a10.getDimensionPixelSize(index, bVar42.f4353b0);
                    break;
                case 57:
                    b bVar43 = c10.f4295e;
                    bVar43.f4355c0 = a10.getDimensionPixelSize(index, bVar43.f4355c0);
                    break;
                case 58:
                    b bVar44 = c10.f4295e;
                    bVar44.f4357d0 = a10.getDimensionPixelSize(index, bVar44.f4357d0);
                    break;
                case 59:
                    b bVar45 = c10.f4295e;
                    bVar45.f4359e0 = a10.getDimensionPixelSize(index, bVar45.f4359e0);
                    break;
                case 60:
                    e eVar11 = c10.f4296f;
                    eVar11.f4437b = a10.getFloat(index, eVar11.f4437b);
                    break;
                case 61:
                    b bVar46 = c10.f4295e;
                    bVar46.B = y0(a10, index, bVar46.B);
                    break;
                case 62:
                    b bVar47 = c10.f4295e;
                    bVar47.C = a10.getDimensionPixelSize(index, bVar47.C);
                    break;
                case 63:
                    b bVar48 = c10.f4295e;
                    bVar48.D = a10.getFloat(index, bVar48.D);
                    break;
                case 64:
                    c cVar = c10.f4294d;
                    cVar.f4406b = y0(a10, index, cVar.f4406b);
                    break;
                case 65:
                    if (a10.peekValue(index).type == 3) {
                        c10.f4294d.f4408d = a10.getString(index);
                    } else {
                        c10.f4294d.f4408d = w.d.f53426o[a10.getInteger(index, 0)];
                    }
                    break;
                case 66:
                    c10.f4294d.f4410f = a10.getInt(index, 0);
                    break;
                case 67:
                    c cVar2 = c10.f4294d;
                    cVar2.f4413i = a10.getFloat(index, cVar2.f4413i);
                    break;
                case 68:
                    C0039d c0039d4 = c10.f4293c;
                    c0039d4.f4423e = a10.getFloat(index, c0039d4.f4423e);
                    break;
                case 69:
                    c10.f4295e.f4361f0 = a10.getFloat(index, 1.0f);
                    break;
                case 70:
                    c10.f4295e.f4363g0 = a10.getFloat(index, 1.0f);
                    break;
                case 71:
                    break;
                case 72:
                    b bVar49 = c10.f4295e;
                    bVar49.f4365h0 = a10.getInt(index, bVar49.f4365h0);
                    break;
                case 73:
                    b bVar50 = c10.f4295e;
                    bVar50.f4367i0 = a10.getDimensionPixelSize(index, bVar50.f4367i0);
                    break;
                case 74:
                    c10.f4295e.f4373l0 = a10.getString(index);
                    break;
                case 75:
                    b bVar51 = c10.f4295e;
                    bVar51.f4381p0 = a10.getBoolean(index, bVar51.f4381p0);
                    break;
                case 76:
                    c cVar3 = c10.f4294d;
                    cVar3.f4409e = a10.getInt(index, cVar3.f4409e);
                    break;
                case 77:
                    c10.f4295e.f4375m0 = a10.getString(index);
                    break;
                case 78:
                    C0039d c0039d5 = c10.f4293c;
                    c0039d5.f4421c = a10.getInt(index, c0039d5.f4421c);
                    break;
                case 79:
                    c cVar4 = c10.f4294d;
                    cVar4.f4411g = a10.getFloat(index, cVar4.f4411g);
                    break;
                case 80:
                    b bVar52 = c10.f4295e;
                    bVar52.f4377n0 = a10.getBoolean(index, bVar52.f4377n0);
                    break;
                case 81:
                    b bVar53 = c10.f4295e;
                    bVar53.f4379o0 = a10.getBoolean(index, bVar53.f4379o0);
                    break;
                case 82:
                    c cVar5 = c10.f4294d;
                    cVar5.f4407c = a10.getInteger(index, cVar5.f4407c);
                    break;
                case 83:
                    e eVar12 = c10.f4296f;
                    eVar12.f4444i = y0(a10, index, eVar12.f4444i);
                    break;
                case 84:
                    c cVar6 = c10.f4294d;
                    cVar6.f4415k = a10.getInteger(index, cVar6.f4415k);
                    break;
                case 85:
                    c cVar7 = c10.f4294d;
                    cVar7.f4414j = a10.getFloat(index, cVar7.f4414j);
                    break;
                case 86:
                    int i11 = a10.peekValue(index).type;
                    if (i11 == 1) {
                        c10.f4294d.f4418n = a10.getResourceId(index, -1);
                        c cVar8 = c10.f4294d;
                        if (cVar8.f4418n != -1) {
                            cVar8.f4417m = -2;
                        }
                    } else if (i11 == 3) {
                        c10.f4294d.f4416l = a10.getString(index);
                        if (c10.f4294d.f4416l.indexOf(fh.a.f28350w) > 0) {
                            c10.f4294d.f4418n = a10.getResourceId(index, -1);
                            c10.f4294d.f4417m = -2;
                        } else {
                            c10.f4294d.f4417m = -1;
                        }
                    } else {
                        c cVar9 = c10.f4294d;
                        cVar9.f4417m = a10.getInteger(index, cVar9.f4418n);
                    }
                    break;
                case 87:
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("unused attribute 0x");
                    sb2.append(Integer.toHexString(index));
                    sb2.append("   ");
                    sb2.append(W.get(index));
                    break;
                case 88:
                case 89:
                case 90:
                default:
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Unknown attribute 0x");
                    sb3.append(Integer.toHexString(index));
                    sb3.append("   ");
                    sb3.append(W.get(index));
                    break;
                case 91:
                    b bVar54 = c10.f4295e;
                    bVar54.f4385s = y0(a10, index, bVar54.f4385s);
                    break;
                case 92:
                    b bVar55 = c10.f4295e;
                    bVar55.f4386t = y0(a10, index, bVar55.f4386t);
                    break;
                case 93:
                    b bVar56 = c10.f4295e;
                    bVar56.N = a10.getDimensionPixelSize(index, bVar56.N);
                    break;
                case 94:
                    b bVar57 = c10.f4295e;
                    bVar57.U = a10.getDimensionPixelSize(index, bVar57.U);
                    break;
                case 95:
                    A0(c10.f4295e, a10, index, 0);
                    break;
                case 96:
                    A0(c10.f4295e, a10, index, 1);
                    break;
                case 97:
                    b bVar58 = c10.f4295e;
                    bVar58.f4383q0 = a10.getInt(index, bVar58.f4383q0);
                    break;
            }
        }
        b bVar59 = c10.f4295e;
        if (bVar59.f4373l0 != null) {
            bVar59.f4371k0 = null;
        }
    }

    public void H(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        this.f4290g.clear();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = constraintLayout.getChildAt(i10);
            ConstraintLayout.b bVar = (ConstraintLayout.b) childAt.getLayoutParams();
            int id2 = childAt.getId();
            if (this.f4289f && id2 == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.f4290g.containsKey(Integer.valueOf(id2))) {
                this.f4290g.put(Integer.valueOf(id2), new a());
            }
            a aVar = this.f4290g.get(Integer.valueOf(id2));
            if (aVar != null) {
                aVar.f4297g = ConstraintAttribute.d(this.f4288e, childAt);
                aVar.k(id2, bVar);
                aVar.f4293c.f4420b = childAt.getVisibility();
                aVar.f4293c.f4422d = childAt.getAlpha();
                aVar.f4296f.f4437b = childAt.getRotation();
                aVar.f4296f.f4438c = childAt.getRotationX();
                aVar.f4296f.f4439d = childAt.getRotationY();
                aVar.f4296f.f4440e = childAt.getScaleX();
                aVar.f4296f.f4441f = childAt.getScaleY();
                float pivotX = childAt.getPivotX();
                float pivotY = childAt.getPivotY();
                if (pivotX != 0.0d || pivotY != 0.0d) {
                    e eVar = aVar.f4296f;
                    eVar.f4442g = pivotX;
                    eVar.f4443h = pivotY;
                }
                aVar.f4296f.f4445j = childAt.getTranslationX();
                aVar.f4296f.f4446k = childAt.getTranslationY();
                aVar.f4296f.f4447l = childAt.getTranslationZ();
                e eVar2 = aVar.f4296f;
                if (eVar2.f4448m) {
                    eVar2.f4449n = childAt.getElevation();
                }
                if (childAt instanceof Barrier) {
                    Barrier barrier = (Barrier) childAt;
                    aVar.f4295e.f4381p0 = barrier.getAllowsGoneWidget();
                    aVar.f4295e.f4371k0 = barrier.getReferencedIds();
                    aVar.f4295e.f4365h0 = barrier.getType();
                    aVar.f4295e.f4367i0 = barrier.getMargin();
                }
            }
        }
    }

    public void H1(Writer writer, ConstraintLayout layout, int flags) throws IOException {
        writer.write("\n---------------------------------------------\n");
        if ((flags & 1) == 1) {
            new g(writer, layout, flags).i();
        } else {
            new f(writer, layout, flags).g();
        }
        writer.write("\n---------------------------------------------\n");
    }

    public void I(d set) {
        this.f4290g.clear();
        for (Integer num : set.f4290g.keySet()) {
            a aVar = set.f4290g.get(num);
            if (aVar != null) {
                this.f4290g.put(num, aVar.clone());
            }
        }
    }

    public void I0(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = constraintLayout.getChildAt(i10);
            ConstraintLayout.b bVar = (ConstraintLayout.b) childAt.getLayoutParams();
            int id2 = childAt.getId();
            if (this.f4289f && id2 == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.f4290g.containsKey(Integer.valueOf(id2))) {
                this.f4290g.put(Integer.valueOf(id2), new a());
            }
            a aVar = this.f4290g.get(Integer.valueOf(id2));
            if (aVar != null) {
                if (!aVar.f4295e.f4352b) {
                    aVar.k(id2, bVar);
                    if (childAt instanceof androidx.constraintlayout.widget.a) {
                        aVar.f4295e.f4371k0 = ((androidx.constraintlayout.widget.a) childAt).getReferencedIds();
                        if (childAt instanceof Barrier) {
                            Barrier barrier = (Barrier) childAt;
                            aVar.f4295e.f4381p0 = barrier.getAllowsGoneWidget();
                            aVar.f4295e.f4365h0 = barrier.getType();
                            aVar.f4295e.f4367i0 = barrier.getMargin();
                        }
                    }
                    aVar.f4295e.f4352b = true;
                }
                C0039d c0039d = aVar.f4293c;
                if (!c0039d.f4419a) {
                    c0039d.f4420b = childAt.getVisibility();
                    aVar.f4293c.f4422d = childAt.getAlpha();
                    aVar.f4293c.f4419a = true;
                }
                e eVar = aVar.f4296f;
                if (!eVar.f4436a) {
                    eVar.f4436a = true;
                    eVar.f4437b = childAt.getRotation();
                    aVar.f4296f.f4438c = childAt.getRotationX();
                    aVar.f4296f.f4439d = childAt.getRotationY();
                    aVar.f4296f.f4440e = childAt.getScaleX();
                    aVar.f4296f.f4441f = childAt.getScaleY();
                    float pivotX = childAt.getPivotX();
                    float pivotY = childAt.getPivotY();
                    if (pivotX != 0.0d || pivotY != 0.0d) {
                        e eVar2 = aVar.f4296f;
                        eVar2.f4442g = pivotX;
                        eVar2.f4443h = pivotY;
                    }
                    aVar.f4296f.f4445j = childAt.getTranslationX();
                    aVar.f4296f.f4446k = childAt.getTranslationY();
                    aVar.f4296f.f4447l = childAt.getTranslationZ();
                    e eVar3 = aVar.f4296f;
                    if (eVar3.f4448m) {
                        eVar3.f4449n = childAt.getElevation();
                    }
                }
            }
        }
    }

    public void J(androidx.constraintlayout.widget.e constraints) {
        int childCount = constraints.getChildCount();
        this.f4290g.clear();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = constraints.getChildAt(i10);
            e.a aVar = (e.a) childAt.getLayoutParams();
            int id2 = childAt.getId();
            if (this.f4289f && id2 == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.f4290g.containsKey(Integer.valueOf(id2))) {
                this.f4290g.put(Integer.valueOf(id2), new a());
            }
            a aVar2 = this.f4290g.get(Integer.valueOf(id2));
            if (aVar2 != null) {
                if (childAt instanceof androidx.constraintlayout.widget.a) {
                    aVar2.m((androidx.constraintlayout.widget.a) childAt, id2, aVar);
                }
                aVar2.l(id2, aVar);
            }
        }
    }

    public void J0(d set) {
        for (Integer num : set.f4290g.keySet()) {
            int iIntValue = num.intValue();
            a aVar = set.f4290g.get(num);
            if (!this.f4290g.containsKey(Integer.valueOf(iIntValue))) {
                this.f4290g.put(Integer.valueOf(iIntValue), new a());
            }
            a aVar2 = this.f4290g.get(Integer.valueOf(iIntValue));
            if (aVar2 != null) {
                b bVar = aVar2.f4295e;
                if (!bVar.f4352b) {
                    bVar.a(aVar.f4295e);
                }
                C0039d c0039d = aVar2.f4293c;
                if (!c0039d.f4419a) {
                    c0039d.a(aVar.f4293c);
                }
                e eVar = aVar2.f4296f;
                if (!eVar.f4436a) {
                    eVar.a(aVar.f4296f);
                }
                c cVar = aVar2.f4294d;
                if (!cVar.f4405a) {
                    cVar.a(aVar.f4294d);
                }
                for (String str : aVar.f4297g.keySet()) {
                    if (!aVar2.f4297g.containsKey(str)) {
                        aVar2.f4297g.put(str, aVar.f4297g.get(str));
                    }
                }
            }
        }
    }

    public void K(int startID, int startSide, int endID, int endSide) {
        if (!this.f4290g.containsKey(Integer.valueOf(startID))) {
            this.f4290g.put(Integer.valueOf(startID), new a());
        }
        a aVar = this.f4290g.get(Integer.valueOf(startID));
        if (aVar == null) {
            return;
        }
        switch (startSide) {
            case 1:
                if (endSide == 1) {
                    b bVar = aVar.f4295e;
                    bVar.f4368j = endID;
                    bVar.f4370k = -1;
                    return;
                } else if (endSide == 2) {
                    b bVar2 = aVar.f4295e;
                    bVar2.f4370k = endID;
                    bVar2.f4368j = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("left to " + F1(endSide) + " undefined");
                }
            case 2:
                if (endSide == 1) {
                    b bVar3 = aVar.f4295e;
                    bVar3.f4372l = endID;
                    bVar3.f4374m = -1;
                    return;
                } else if (endSide == 2) {
                    b bVar4 = aVar.f4295e;
                    bVar4.f4374m = endID;
                    bVar4.f4372l = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + F1(endSide) + " undefined");
                }
            case 3:
                if (endSide == 3) {
                    b bVar5 = aVar.f4295e;
                    bVar5.f4376n = endID;
                    bVar5.f4378o = -1;
                    bVar5.f4384r = -1;
                    bVar5.f4385s = -1;
                    bVar5.f4386t = -1;
                    return;
                }
                if (endSide != 4) {
                    throw new IllegalArgumentException("right to " + F1(endSide) + " undefined");
                }
                b bVar6 = aVar.f4295e;
                bVar6.f4378o = endID;
                bVar6.f4376n = -1;
                bVar6.f4384r = -1;
                bVar6.f4385s = -1;
                bVar6.f4386t = -1;
                return;
            case 4:
                if (endSide == 4) {
                    b bVar7 = aVar.f4295e;
                    bVar7.f4382q = endID;
                    bVar7.f4380p = -1;
                    bVar7.f4384r = -1;
                    bVar7.f4385s = -1;
                    bVar7.f4386t = -1;
                    return;
                }
                if (endSide != 3) {
                    throw new IllegalArgumentException("right to " + F1(endSide) + " undefined");
                }
                b bVar8 = aVar.f4295e;
                bVar8.f4380p = endID;
                bVar8.f4382q = -1;
                bVar8.f4384r = -1;
                bVar8.f4385s = -1;
                bVar8.f4386t = -1;
                return;
            case 5:
                if (endSide == 5) {
                    b bVar9 = aVar.f4295e;
                    bVar9.f4384r = endID;
                    bVar9.f4382q = -1;
                    bVar9.f4380p = -1;
                    bVar9.f4376n = -1;
                    bVar9.f4378o = -1;
                    return;
                }
                if (endSide == 3) {
                    b bVar10 = aVar.f4295e;
                    bVar10.f4385s = endID;
                    bVar10.f4382q = -1;
                    bVar10.f4380p = -1;
                    bVar10.f4376n = -1;
                    bVar10.f4378o = -1;
                    return;
                }
                if (endSide != 4) {
                    throw new IllegalArgumentException("right to " + F1(endSide) + " undefined");
                }
                b bVar11 = aVar.f4295e;
                bVar11.f4386t = endID;
                bVar11.f4382q = -1;
                bVar11.f4380p = -1;
                bVar11.f4376n = -1;
                bVar11.f4378o = -1;
                return;
            case 6:
                if (endSide == 6) {
                    b bVar12 = aVar.f4295e;
                    bVar12.f4388v = endID;
                    bVar12.f4387u = -1;
                    return;
                } else if (endSide == 7) {
                    b bVar13 = aVar.f4295e;
                    bVar13.f4387u = endID;
                    bVar13.f4388v = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + F1(endSide) + " undefined");
                }
            case 7:
                if (endSide == 7) {
                    b bVar14 = aVar.f4295e;
                    bVar14.f4390x = endID;
                    bVar14.f4389w = -1;
                    return;
                } else if (endSide == 6) {
                    b bVar15 = aVar.f4295e;
                    bVar15.f4389w = endID;
                    bVar15.f4390x = -1;
                    return;
                } else {
                    throw new IllegalArgumentException("right to " + F1(endSide) + " undefined");
                }
            default:
                throw new IllegalArgumentException(F1(startSide) + " to " + F1(endSide) + " unknown");
        }
    }

    public void K0(String attributeName) {
        this.f4288e.remove(attributeName);
    }

    public void L(int startID, int startSide, int endID, int endSide, int margin) {
        if (!this.f4290g.containsKey(Integer.valueOf(startID))) {
            this.f4290g.put(Integer.valueOf(startID), new a());
        }
        a aVar = this.f4290g.get(Integer.valueOf(startID));
        if (aVar == null) {
            return;
        }
        switch (startSide) {
            case 1:
                if (endSide == 1) {
                    b bVar = aVar.f4295e;
                    bVar.f4368j = endID;
                    bVar.f4370k = -1;
                } else {
                    if (endSide != 2) {
                        throw new IllegalArgumentException("Left to " + F1(endSide) + " undefined");
                    }
                    b bVar2 = aVar.f4295e;
                    bVar2.f4370k = endID;
                    bVar2.f4368j = -1;
                }
                aVar.f4295e.H = margin;
                return;
            case 2:
                if (endSide == 1) {
                    b bVar3 = aVar.f4295e;
                    bVar3.f4372l = endID;
                    bVar3.f4374m = -1;
                } else {
                    if (endSide != 2) {
                        throw new IllegalArgumentException("right to " + F1(endSide) + " undefined");
                    }
                    b bVar4 = aVar.f4295e;
                    bVar4.f4374m = endID;
                    bVar4.f4372l = -1;
                }
                aVar.f4295e.I = margin;
                return;
            case 3:
                if (endSide == 3) {
                    b bVar5 = aVar.f4295e;
                    bVar5.f4376n = endID;
                    bVar5.f4378o = -1;
                    bVar5.f4384r = -1;
                    bVar5.f4385s = -1;
                    bVar5.f4386t = -1;
                } else {
                    if (endSide != 4) {
                        throw new IllegalArgumentException("right to " + F1(endSide) + " undefined");
                    }
                    b bVar6 = aVar.f4295e;
                    bVar6.f4378o = endID;
                    bVar6.f4376n = -1;
                    bVar6.f4384r = -1;
                    bVar6.f4385s = -1;
                    bVar6.f4386t = -1;
                }
                aVar.f4295e.J = margin;
                return;
            case 4:
                if (endSide == 4) {
                    b bVar7 = aVar.f4295e;
                    bVar7.f4382q = endID;
                    bVar7.f4380p = -1;
                    bVar7.f4384r = -1;
                    bVar7.f4385s = -1;
                    bVar7.f4386t = -1;
                } else {
                    if (endSide != 3) {
                        throw new IllegalArgumentException("right to " + F1(endSide) + " undefined");
                    }
                    b bVar8 = aVar.f4295e;
                    bVar8.f4380p = endID;
                    bVar8.f4382q = -1;
                    bVar8.f4384r = -1;
                    bVar8.f4385s = -1;
                    bVar8.f4386t = -1;
                }
                aVar.f4295e.K = margin;
                return;
            case 5:
                if (endSide == 5) {
                    b bVar9 = aVar.f4295e;
                    bVar9.f4384r = endID;
                    bVar9.f4382q = -1;
                    bVar9.f4380p = -1;
                    bVar9.f4376n = -1;
                    bVar9.f4378o = -1;
                    return;
                }
                if (endSide == 3) {
                    b bVar10 = aVar.f4295e;
                    bVar10.f4385s = endID;
                    bVar10.f4382q = -1;
                    bVar10.f4380p = -1;
                    bVar10.f4376n = -1;
                    bVar10.f4378o = -1;
                    return;
                }
                if (endSide != 4) {
                    throw new IllegalArgumentException("right to " + F1(endSide) + " undefined");
                }
                b bVar11 = aVar.f4295e;
                bVar11.f4386t = endID;
                bVar11.f4382q = -1;
                bVar11.f4380p = -1;
                bVar11.f4376n = -1;
                bVar11.f4378o = -1;
                return;
            case 6:
                if (endSide == 6) {
                    b bVar12 = aVar.f4295e;
                    bVar12.f4388v = endID;
                    bVar12.f4387u = -1;
                } else {
                    if (endSide != 7) {
                        throw new IllegalArgumentException("right to " + F1(endSide) + " undefined");
                    }
                    b bVar13 = aVar.f4295e;
                    bVar13.f4387u = endID;
                    bVar13.f4388v = -1;
                }
                aVar.f4295e.M = margin;
                return;
            case 7:
                if (endSide == 7) {
                    b bVar14 = aVar.f4295e;
                    bVar14.f4390x = endID;
                    bVar14.f4389w = -1;
                } else {
                    if (endSide != 6) {
                        throw new IllegalArgumentException("right to " + F1(endSide) + " undefined");
                    }
                    b bVar15 = aVar.f4295e;
                    bVar15.f4389w = endID;
                    bVar15.f4390x = -1;
                }
                aVar.f4295e.L = margin;
                return;
            default:
                throw new IllegalArgumentException(F1(startSide) + " to " + F1(endSide) + " unknown");
        }
    }

    public void L0(int viewId) {
        a aVar;
        if (!this.f4290g.containsKey(Integer.valueOf(viewId)) || (aVar = this.f4290g.get(Integer.valueOf(viewId))) == null) {
            return;
        }
        b bVar = aVar.f4295e;
        int i10 = bVar.f4370k;
        int i11 = bVar.f4372l;
        if (i10 != -1 || i11 != -1) {
            if (i10 == -1 || i11 == -1) {
                int i12 = bVar.f4374m;
                if (i12 != -1) {
                    L(i10, 2, i12, 2, 0);
                } else {
                    int i13 = bVar.f4368j;
                    if (i13 != -1) {
                        L(i11, 1, i13, 1, 0);
                    }
                }
            } else {
                L(i10, 2, i11, 1, 0);
                L(i11, 1, i10, 2, 0);
            }
            F(viewId, 1);
            F(viewId, 2);
            return;
        }
        int i14 = bVar.f4387u;
        int i15 = bVar.f4389w;
        if (i14 != -1 || i15 != -1) {
            if (i14 != -1 && i15 != -1) {
                L(i14, 7, i15, 6, 0);
                L(i15, 6, i10, 7, 0);
            } else if (i15 != -1) {
                int i16 = bVar.f4374m;
                if (i16 != -1) {
                    L(i10, 7, i16, 7, 0);
                } else {
                    int i17 = bVar.f4368j;
                    if (i17 != -1) {
                        L(i15, 6, i17, 6, 0);
                    }
                }
            }
        }
        F(viewId, 6);
        F(viewId, 7);
    }

    public void M(int viewId, int id2, int radius, float angle) {
        b bVar = i0(viewId).f4295e;
        bVar.B = id2;
        bVar.C = radius;
        bVar.D = angle;
    }

    public void M0(int viewId) {
        if (this.f4290g.containsKey(Integer.valueOf(viewId))) {
            a aVar = this.f4290g.get(Integer.valueOf(viewId));
            if (aVar == null) {
                return;
            }
            b bVar = aVar.f4295e;
            int i10 = bVar.f4378o;
            int i11 = bVar.f4380p;
            if (i10 != -1 || i11 != -1) {
                if (i10 == -1 || i11 == -1) {
                    int i12 = bVar.f4382q;
                    if (i12 != -1) {
                        L(i10, 4, i12, 4, 0);
                    } else {
                        int i13 = bVar.f4376n;
                        if (i13 != -1) {
                            L(i11, 3, i13, 3, 0);
                        }
                    }
                } else {
                    L(i10, 4, i11, 3, 0);
                    L(i11, 3, i10, 4, 0);
                }
            }
        }
        F(viewId, 3);
        F(viewId, 4);
    }

    public void N(int viewId, int height) {
        i0(viewId).f4295e.f4351a0 = height;
    }

    public void N0(int viewId, float alpha) {
        i0(viewId).f4293c.f4422d = alpha;
    }

    public void O(int viewId, int width) {
        i0(viewId).f4295e.Z = width;
    }

    public void O0(int viewId, boolean apply) {
        i0(viewId).f4296f.f4448m = apply;
    }

    public void P(int viewId, int height) {
        i0(viewId).f4295e.f4358e = height;
    }

    public void P0(int id2, int type) {
        i0(id2).f4295e.f4369j0 = type;
    }

    public void Q(int viewId, int height) {
        i0(viewId).f4295e.f4355c0 = height;
    }

    public void Q0(int viewId, String attributeName, int value) {
        i0(viewId).p(attributeName, value);
    }

    public void R(int viewId, int width) {
        i0(viewId).f4295e.f4353b0 = width;
    }

    public void S(int viewId, int height) {
        i0(viewId).f4295e.f4359e0 = height;
    }

    public void T(int viewId, int width) {
        i0(viewId).f4295e.f4357d0 = width;
    }

    public void U(int viewId, float percent) {
        i0(viewId).f4295e.f4363g0 = percent;
    }

    public void V(int viewId, float percent) {
        i0(viewId).f4295e.f4361f0 = percent;
    }

    public void V0(int viewId, String ratio) {
        i0(viewId).f4295e.A = ratio;
    }

    public void W(int viewId, int width) {
        i0(viewId).f4295e.f4356d = width;
    }

    public void W0(int viewId, int position) {
        i0(viewId).f4295e.E = position;
    }

    public void X(int viewId, boolean constrained) {
        i0(viewId).f4295e.f4379o0 = constrained;
    }

    public void X0(int viewId, int position) {
        i0(viewId).f4295e.F = position;
    }

    public void Y(int viewId, boolean constrained) {
        i0(viewId).f4295e.f4377n0 = constrained;
    }

    public void Y0(int viewId, float elevation) {
        i0(viewId).f4296f.f4449n = elevation;
        i0(viewId).f4296f.f4448m = true;
    }

    public final int[] Z(View view, String referenceIdString) {
        int iIntValue;
        Object objQ;
        String[] strArrSplit = referenceIdString.split(ag.c.f654g);
        Context context = view.getContext();
        int[] iArr = new int[strArrSplit.length];
        int i10 = 0;
        int i11 = 0;
        while (i10 < strArrSplit.length) {
            String strTrim = strArrSplit[i10].trim();
            try {
                iIntValue = R.id.class.getField(strTrim).getInt(null);
            } catch (Exception unused) {
                iIntValue = 0;
            }
            if (iIntValue == 0) {
                iIntValue = context.getResources().getIdentifier(strTrim, "id", context.getPackageName());
            }
            if (iIntValue == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (objQ = ((ConstraintLayout) view.getParent()).q(0, strTrim)) != null && (objQ instanceof Integer)) {
                iIntValue = ((Integer) objQ).intValue();
            }
            iArr[i11] = iIntValue;
            i10++;
            i11++;
        }
        return i11 != strArrSplit.length ? Arrays.copyOf(iArr, i11) : iArr;
    }

    public void Z0(int viewId, String attributeName, float value) {
        i0(viewId).q(attributeName, value);
    }

    public void a0(int guidelineID, int orientation) {
        b bVar = i0(guidelineID).f4295e;
        bVar.f4350a = true;
        bVar.G = orientation;
    }

    public void a1(boolean forceId) {
        this.f4289f = forceId;
    }

    public void b0(int id2, int direction, int margin, int... referenced) {
        b bVar = i0(id2).f4295e;
        bVar.f4369j0 = 1;
        bVar.f4365h0 = direction;
        bVar.f4367i0 = margin;
        bVar.f4350a = false;
        bVar.f4371k0 = referenced;
    }

    public void b1(int viewId, int anchor, int value) {
        a aVarI0 = i0(viewId);
        switch (anchor) {
            case 1:
                aVarI0.f4295e.O = value;
                return;
            case 2:
                aVarI0.f4295e.Q = value;
                return;
            case 3:
                aVarI0.f4295e.P = value;
                return;
            case 4:
                aVarI0.f4295e.R = value;
                return;
            case 5:
                aVarI0.f4295e.U = value;
                return;
            case 6:
                aVarI0.f4295e.T = value;
                return;
            case 7:
                aVarI0.f4295e.S = value;
                return;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public void c0(int leftId, int leftSide, int rightId, int rightSide, int[] chainIds, float[] weights, int style) {
        d0(leftId, leftSide, rightId, rightSide, chainIds, weights, style, 1, 2);
    }

    public void c1(int guidelineID, int margin) {
        i0(guidelineID).f4295e.f4360f = margin;
        i0(guidelineID).f4295e.f4362g = -1;
        i0(guidelineID).f4295e.f4364h = -1.0f;
    }

    public final void d0(int leftId, int leftSide, int rightId, int rightSide, int[] chainIds, float[] weights, int style, int left, int right) {
        if (chainIds.length < 2) {
            throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        }
        if (weights != null && weights.length != chainIds.length) {
            throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        }
        if (weights != null) {
            i0(chainIds[0]).f4295e.W = weights[0];
        }
        i0(chainIds[0]).f4295e.X = style;
        L(chainIds[0], left, leftId, leftSide, -1);
        for (int i10 = 1; i10 < chainIds.length; i10++) {
            int i11 = chainIds[i10];
            int i12 = i10 - 1;
            L(chainIds[i10], left, chainIds[i12], right, -1);
            L(chainIds[i12], right, chainIds[i10], left, -1);
            if (weights != null) {
                i0(chainIds[i10]).f4295e.W = weights[i10];
            }
        }
        L(chainIds[chainIds.length - 1], right, rightId, rightSide, -1);
    }

    public void d1(int guidelineID, int margin) {
        i0(guidelineID).f4295e.f4362g = margin;
        i0(guidelineID).f4295e.f4360f = -1;
        i0(guidelineID).f4295e.f4364h = -1.0f;
    }

    public void e0(int startId, int startSide, int endId, int endSide, int[] chainIds, float[] weights, int style) {
        d0(startId, startSide, endId, endSide, chainIds, weights, style, 6, 7);
    }

    public void e1(int guidelineID, float ratio) {
        i0(guidelineID).f4295e.f4364h = ratio;
        i0(guidelineID).f4295e.f4362g = -1;
        i0(guidelineID).f4295e.f4360f = -1;
    }

    public void f0(int topId, int topSide, int bottomId, int bottomSide, int[] chainIds, float[] weights, int style) {
        if (chainIds.length < 2) {
            throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        }
        if (weights != null && weights.length != chainIds.length) {
            throw new IllegalArgumentException("must have 2 or more widgets in a chain");
        }
        if (weights != null) {
            i0(chainIds[0]).f4295e.V = weights[0];
        }
        i0(chainIds[0]).f4295e.Y = style;
        L(chainIds[0], 3, topId, topSide, 0);
        for (int i10 = 1; i10 < chainIds.length; i10++) {
            int i11 = chainIds[i10];
            int i12 = i10 - 1;
            L(chainIds[i10], 3, chainIds[i12], 4, 0);
            L(chainIds[i12], 4, chainIds[i10], 3, 0);
            if (weights != null) {
                i0(chainIds[i10]).f4295e.V = weights[i10];
            }
        }
        L(chainIds[chainIds.length - 1], 4, bottomId, bottomSide, 0);
    }

    public void f1(int viewId, float bias) {
        i0(viewId).f4295e.f4391y = bias;
    }

    public void g0(t scene, int... ids) {
        HashSet hashSet;
        Set<Integer> setKeySet = this.f4290g.keySet();
        if (ids.length != 0) {
            hashSet = new HashSet();
            for (int i10 : ids) {
                hashSet.add(Integer.valueOf(i10));
            }
        } else {
            hashSet = new HashSet(setKeySet);
        }
        System.out.println(hashSet.size() + " constraints");
        StringBuilder sb2 = new StringBuilder();
        for (Integer num : (Integer[]) hashSet.toArray(new Integer[0])) {
            a aVar = this.f4290g.get(num);
            if (aVar != null) {
                sb2.append("<Constraint id=");
                sb2.append(num);
                sb2.append(" \n");
                aVar.f4295e.b(scene, sb2);
                sb2.append("/>\n");
            }
        }
        System.out.println(sb2.toString());
    }

    public void g1(int viewId, int chainStyle) {
        i0(viewId).f4295e.X = chainStyle;
    }

    public final void h(ConstraintAttribute.AttributeType attributeType, String... attributeName) {
        for (int i10 = 0; i10 < attributeName.length; i10++) {
            if (this.f4288e.containsKey(attributeName[i10])) {
                ConstraintAttribute constraintAttribute = this.f4288e.get(attributeName[i10]);
                if (constraintAttribute != null && constraintAttribute.j() != attributeType) {
                    throw new IllegalArgumentException("ConstraintAttribute is already a " + constraintAttribute.j().name());
                }
            } else {
                this.f4288e.put(attributeName[i10], new ConstraintAttribute(attributeName[i10], attributeType));
            }
        }
    }

    public final a h0(Context context, AttributeSet attrs, boolean override) {
        a aVar = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, override ? R.styleable.ConstraintOverride : R.styleable.Constraint);
        G0(context, aVar, typedArrayObtainStyledAttributes, override);
        typedArrayObtainStyledAttributes.recycle();
        return aVar;
    }

    public void h1(int viewId, float weight) {
        i0(viewId).f4295e.W = weight;
    }

    public void i(String... attributeName) {
        h(ConstraintAttribute.AttributeType.COLOR_TYPE, attributeName);
    }

    public final a i0(int id2) {
        if (!this.f4290g.containsKey(Integer.valueOf(id2))) {
            this.f4290g.put(Integer.valueOf(id2), new a());
        }
        return this.f4290g.get(Integer.valueOf(id2));
    }

    public void i1(int viewId, String attributeName, int value) {
        i0(viewId).r(attributeName, value);
    }

    public void j(String... attributeName) {
        h(ConstraintAttribute.AttributeType.FLOAT_TYPE, attributeName);
    }

    public boolean j0(int viewId) {
        return i0(viewId).f4296f.f4448m;
    }

    public void j1(int viewId, int behavior) {
        if (behavior < 0 || behavior > 3) {
            return;
        }
        i0(viewId).f4295e.f4383q0 = behavior;
    }

    public void k(String... attributeName) {
        h(ConstraintAttribute.AttributeType.INT_TYPE, attributeName);
    }

    public a k0(int id2) {
        if (this.f4290g.containsKey(Integer.valueOf(id2))) {
            return this.f4290g.get(Integer.valueOf(id2));
        }
        return null;
    }

    public void k1(int viewId, int anchor, int value) {
        a aVarI0 = i0(viewId);
        switch (anchor) {
            case 1:
                aVarI0.f4295e.H = value;
                return;
            case 2:
                aVarI0.f4295e.I = value;
                return;
            case 3:
                aVarI0.f4295e.J = value;
                return;
            case 4:
                aVarI0.f4295e.K = value;
                return;
            case 5:
                aVarI0.f4295e.N = value;
                return;
            case 6:
                aVarI0.f4295e.M = value;
                return;
            case 7:
                aVarI0.f4295e.L = value;
                return;
            default:
                throw new IllegalArgumentException("unknown constraint");
        }
    }

    public void l(String... attributeName) {
        h(ConstraintAttribute.AttributeType.STRING_TYPE, attributeName);
    }

    public HashMap<String, ConstraintAttribute> l0() {
        return this.f4288e;
    }

    public void l1(int id2, int... referenced) {
        i0(id2).f4295e.f4371k0 = referenced;
    }

    public void m(int viewId, int leftId, int rightId) {
        L(viewId, 1, leftId, leftId == 0 ? 1 : 2, 0);
        L(viewId, 2, rightId, rightId == 0 ? 2 : 1, 0);
        if (leftId != 0) {
            L(leftId, 2, viewId, 1, 0);
        }
        if (rightId != 0) {
            L(rightId, 1, viewId, 2, 0);
        }
    }

    public void m1(int viewId, float rotation) {
        i0(viewId).f4296f.f4437b = rotation;
    }

    public void n(int viewId, int leftId, int rightId) {
        L(viewId, 6, leftId, leftId == 0 ? 6 : 7, 0);
        L(viewId, 7, rightId, rightId == 0 ? 7 : 6, 0);
        if (leftId != 0) {
            L(leftId, 7, viewId, 6, 0);
        }
        if (rightId != 0) {
            L(rightId, 6, viewId, 7, 0);
        }
    }

    public int n0(int viewId) {
        return i0(viewId).f4295e.f4358e;
    }

    public void n1(int viewId, float rotationX) {
        i0(viewId).f4296f.f4438c = rotationX;
    }

    public void o(int viewId, int topId, int bottomId) {
        L(viewId, 3, topId, topId == 0 ? 3 : 4, 0);
        L(viewId, 4, bottomId, bottomId == 0 ? 4 : 3, 0);
        if (topId != 0) {
            L(topId, 4, viewId, 3, 0);
        }
        if (bottomId != 0) {
            L(bottomId, 3, viewId, 4, 0);
        }
    }

    public int[] o0() {
        Integer[] numArr = (Integer[]) this.f4290g.keySet().toArray(new Integer[0]);
        int length = numArr.length;
        int[] iArr = new int[length];
        for (int i10 = 0; i10 < length; i10++) {
            iArr[i10] = numArr[i10].intValue();
        }
        return iArr;
    }

    public void o1(int viewId, float rotationY) {
        i0(viewId).f4296f.f4439d = rotationY;
    }

    public void p(ConstraintLayout constraintLayout) {
        a aVar;
        int childCount = constraintLayout.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = constraintLayout.getChildAt(i10);
            int id2 = childAt.getId();
            if (!this.f4290g.containsKey(Integer.valueOf(id2))) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("id unknown ");
                sb2.append(androidx.constraintlayout.motion.widget.c.k(childAt));
            } else {
                if (this.f4289f && id2 == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (this.f4290g.containsKey(Integer.valueOf(id2)) && (aVar = this.f4290g.get(Integer.valueOf(id2))) != null) {
                    ConstraintAttribute.r(childAt, aVar.f4297g);
                }
            }
        }
    }

    public void p1(int viewId, float scaleX) {
        i0(viewId).f4296f.f4440e = scaleX;
    }

    public void q(d cs2) {
        for (a aVar : cs2.f4290g.values()) {
            if (aVar.f4298h != null) {
                if (aVar.f4292b != null) {
                    Iterator<Integer> it2 = this.f4290g.keySet().iterator();
                    while (it2.hasNext()) {
                        a aVarK0 = k0(it2.next().intValue());
                        String str = aVarK0.f4295e.f4375m0;
                        if (str != null && aVar.f4292b.matches(str)) {
                            aVar.f4298h.e(aVarK0);
                            aVarK0.f4297g.putAll((HashMap) aVar.f4297g.clone());
                        }
                    }
                } else {
                    aVar.f4298h.e(k0(aVar.f4291a));
                }
            }
        }
    }

    public a q0(int mId) {
        return i0(mId);
    }

    public void q1(int viewId, float scaleY) {
        i0(viewId).f4296f.f4441f = scaleY;
    }

    public void r(ConstraintLayout constraintLayout) {
        t(constraintLayout, true);
        constraintLayout.setConstraintSet(null);
        constraintLayout.requestLayout();
    }

    public int[] r0(int id2) {
        int[] iArr = i0(id2).f4295e.f4371k0;
        return iArr == null ? new int[0] : Arrays.copyOf(iArr, iArr.length);
    }

    public void r1(int viewId, String attributeName, String value) {
        i0(viewId).s(attributeName, value);
    }

    public void s(androidx.constraintlayout.widget.a helper, ConstraintWidget child, ConstraintLayout.b layoutParams, SparseArray<ConstraintWidget> mapIdToWidget) {
        a aVar;
        int id2 = helper.getId();
        if (this.f4290g.containsKey(Integer.valueOf(id2)) && (aVar = this.f4290g.get(Integer.valueOf(id2))) != null && (child instanceof y.b)) {
            helper.z(aVar, (y.b) child, layoutParams, mapIdToWidget);
        }
    }

    public int s0(int viewId) {
        return i0(viewId).f4293c.f4420b;
    }

    public void s1(int viewId, float transformPivotX, float transformPivotY) {
        e eVar = i0(viewId).f4296f;
        eVar.f4443h = transformPivotY;
        eVar.f4442g = transformPivotX;
    }

    public void t(ConstraintLayout constraintLayout, boolean applyPostLayout) {
        int childCount = constraintLayout.getChildCount();
        HashSet<Integer> hashSet = new HashSet(this.f4290g.keySet());
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = constraintLayout.getChildAt(i10);
            int id2 = childAt.getId();
            if (!this.f4290g.containsKey(Integer.valueOf(id2))) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("id unknown ");
                sb2.append(androidx.constraintlayout.motion.widget.c.k(childAt));
            } else {
                if (this.f4289f && id2 == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (id2 != -1) {
                    if (this.f4290g.containsKey(Integer.valueOf(id2))) {
                        hashSet.remove(Integer.valueOf(id2));
                        a aVar = this.f4290g.get(Integer.valueOf(id2));
                        if (aVar != null) {
                            if (childAt instanceof Barrier) {
                                aVar.f4295e.f4369j0 = 1;
                                Barrier barrier = (Barrier) childAt;
                                barrier.setId(id2);
                                barrier.setType(aVar.f4295e.f4365h0);
                                barrier.setMargin(aVar.f4295e.f4367i0);
                                barrier.setAllowsGoneWidget(aVar.f4295e.f4381p0);
                                b bVar = aVar.f4295e;
                                int[] iArr = bVar.f4371k0;
                                if (iArr != null) {
                                    barrier.setReferencedIds(iArr);
                                } else {
                                    String str = bVar.f4373l0;
                                    if (str != null) {
                                        bVar.f4371k0 = Z(barrier, str);
                                        barrier.setReferencedIds(aVar.f4295e.f4371k0);
                                    }
                                }
                            }
                            ConstraintLayout.b bVar2 = (ConstraintLayout.b) childAt.getLayoutParams();
                            bVar2.e();
                            aVar.i(bVar2);
                            if (applyPostLayout) {
                                ConstraintAttribute.r(childAt, aVar.f4297g);
                            }
                            childAt.setLayoutParams(bVar2);
                            C0039d c0039d = aVar.f4293c;
                            if (c0039d.f4421c == 0) {
                                childAt.setVisibility(c0039d.f4420b);
                            }
                            childAt.setAlpha(aVar.f4293c.f4422d);
                            childAt.setRotation(aVar.f4296f.f4437b);
                            childAt.setRotationX(aVar.f4296f.f4438c);
                            childAt.setRotationY(aVar.f4296f.f4439d);
                            childAt.setScaleX(aVar.f4296f.f4440e);
                            childAt.setScaleY(aVar.f4296f.f4441f);
                            e eVar = aVar.f4296f;
                            if (eVar.f4444i != -1) {
                                if (((View) childAt.getParent()).findViewById(aVar.f4296f.f4444i) != null) {
                                    float top2 = (r4.getTop() + r4.getBottom()) / 2.0f;
                                    float left = (r4.getLeft() + r4.getRight()) / 2.0f;
                                    if (childAt.getRight() - childAt.getLeft() > 0 && childAt.getBottom() - childAt.getTop() > 0) {
                                        childAt.setPivotX(left - childAt.getLeft());
                                        childAt.setPivotY(top2 - childAt.getTop());
                                    }
                                }
                            } else {
                                if (!Float.isNaN(eVar.f4442g)) {
                                    childAt.setPivotX(aVar.f4296f.f4442g);
                                }
                                if (!Float.isNaN(aVar.f4296f.f4443h)) {
                                    childAt.setPivotY(aVar.f4296f.f4443h);
                                }
                            }
                            childAt.setTranslationX(aVar.f4296f.f4445j);
                            childAt.setTranslationY(aVar.f4296f.f4446k);
                            childAt.setTranslationZ(aVar.f4296f.f4447l);
                            e eVar2 = aVar.f4296f;
                            if (eVar2.f4448m) {
                                childAt.setElevation(eVar2.f4449n);
                            }
                        }
                    } else {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("WARNING NO CONSTRAINTS for view ");
                        sb3.append(id2);
                    }
                }
            }
        }
        for (Integer num : hashSet) {
            a aVar2 = this.f4290g.get(num);
            if (aVar2 != null) {
                if (aVar2.f4295e.f4369j0 == 1) {
                    Barrier barrier2 = new Barrier(constraintLayout.getContext());
                    barrier2.setId(num.intValue());
                    b bVar3 = aVar2.f4295e;
                    int[] iArr2 = bVar3.f4371k0;
                    if (iArr2 != null) {
                        barrier2.setReferencedIds(iArr2);
                    } else {
                        String str2 = bVar3.f4373l0;
                        if (str2 != null) {
                            bVar3.f4371k0 = Z(barrier2, str2);
                            barrier2.setReferencedIds(aVar2.f4295e.f4371k0);
                        }
                    }
                    barrier2.setType(aVar2.f4295e.f4365h0);
                    barrier2.setMargin(aVar2.f4295e.f4367i0);
                    ConstraintLayout.b bVarGenerateDefaultLayoutParams = constraintLayout.generateDefaultLayoutParams();
                    barrier2.I();
                    aVar2.i(bVarGenerateDefaultLayoutParams);
                    constraintLayout.addView(barrier2, bVarGenerateDefaultLayoutParams);
                }
                if (aVar2.f4295e.f4350a) {
                    View guideline = new Guideline(constraintLayout.getContext());
                    guideline.setId(num.intValue());
                    ConstraintLayout.b bVarGenerateDefaultLayoutParams2 = constraintLayout.generateDefaultLayoutParams();
                    aVar2.i(bVarGenerateDefaultLayoutParams2);
                    constraintLayout.addView(guideline, bVarGenerateDefaultLayoutParams2);
                }
            }
        }
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt2 = constraintLayout.getChildAt(i11);
            if (childAt2 instanceof androidx.constraintlayout.widget.a) {
                ((androidx.constraintlayout.widget.a) childAt2).r(constraintLayout);
            }
        }
    }

    public int t0(int viewId) {
        return i0(viewId).f4293c.f4421c;
    }

    public void t1(int viewId, float transformPivotX) {
        i0(viewId).f4296f.f4442g = transformPivotX;
    }

    public void u(int id2, ConstraintLayout.b layoutParams) {
        a aVar;
        if (!this.f4290g.containsKey(Integer.valueOf(id2)) || (aVar = this.f4290g.get(Integer.valueOf(id2))) == null) {
            return;
        }
        aVar.i(layoutParams);
    }

    public int u0(int viewId) {
        return i0(viewId).f4295e.f4356d;
    }

    public void u1(int viewId, float transformPivotY) {
        i0(viewId).f4296f.f4443h = transformPivotY;
    }

    public void v(ConstraintLayout constraintLayout) {
        t(constraintLayout, false);
        constraintLayout.setConstraintSet(null);
    }

    public boolean v0() {
        return this.f4289f;
    }

    public void v1(int viewId, float translationX, float translationY) {
        e eVar = i0(viewId).f4296f;
        eVar.f4445j = translationX;
        eVar.f4446k = translationY;
    }

    public void w0(Context context, int resourceId) {
        XmlResourceParser xml = context.getResources().getXml(resourceId);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    a aVarH0 = h0(context, Xml.asAttributeSet(xml), false);
                    if (name.equalsIgnoreCase("Guideline")) {
                        aVarH0.f4295e.f4350a = true;
                    }
                    this.f4290g.put(Integer.valueOf(aVarH0.f4291a), aVarH0);
                }
            }
        } catch (IOException e10) {
            e10.printStackTrace();
        } catch (XmlPullParserException e11) {
            e11.printStackTrace();
        }
    }

    public void w1(int viewId, float translationX) {
        i0(viewId).f4296f.f4445j = translationX;
    }

    public void x(int centerID, int firstID, int firstSide, int firstMargin, int secondId, int secondSide, int secondMargin, float bias) {
        if (firstMargin < 0) {
            throw new IllegalArgumentException("margin must be > 0");
        }
        if (secondMargin < 0) {
            throw new IllegalArgumentException("margin must be > 0");
        }
        if (bias <= 0.0f || bias > 1.0f) {
            throw new IllegalArgumentException("bias must be between 0 and 1 inclusive");
        }
        if (firstSide == 1 || firstSide == 2) {
            L(centerID, 1, firstID, firstSide, firstMargin);
            L(centerID, 2, secondId, secondSide, secondMargin);
            a aVar = this.f4290g.get(Integer.valueOf(centerID));
            if (aVar != null) {
                aVar.f4295e.f4391y = bias;
                return;
            }
            return;
        }
        if (firstSide == 6 || firstSide == 7) {
            L(centerID, 6, firstID, firstSide, firstMargin);
            L(centerID, 7, secondId, secondSide, secondMargin);
            a aVar2 = this.f4290g.get(Integer.valueOf(centerID));
            if (aVar2 != null) {
                aVar2.f4295e.f4391y = bias;
                return;
            }
            return;
        }
        L(centerID, 3, firstID, firstSide, firstMargin);
        L(centerID, 4, secondId, secondSide, secondMargin);
        a aVar3 = this.f4290g.get(Integer.valueOf(centerID));
        if (aVar3 != null) {
            aVar3.f4295e.f4392z = bias;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:119:0x01cb, code lost:
    
        continue;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void x0(android.content.Context r10, org.xmlpull.v1.XmlPullParser r11) {
        /*
            Method dump skipped, instruction units count: 560
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.d.x0(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    public void x1(int viewId, float translationY) {
        i0(viewId).f4296f.f4446k = translationY;
    }

    public void y(int viewId, int toView) {
        if (toView == 0) {
            x(viewId, 0, 1, 0, 0, 2, 0, 0.5f);
        } else {
            x(viewId, toView, 2, 0, toView, 1, 0, 0.5f);
        }
    }

    public void y1(int viewId, float translationZ) {
        i0(viewId).f4296f.f4447l = translationZ;
    }

    public void z(int centerID, int leftId, int leftSide, int leftMargin, int rightId, int rightSide, int rightMargin, float bias) {
        L(centerID, 1, leftId, leftSide, leftMargin);
        L(centerID, 2, rightId, rightSide, rightMargin);
        a aVar = this.f4290g.get(Integer.valueOf(centerID));
        if (aVar != null) {
            aVar.f4295e.f4391y = bias;
        }
    }

    public void z0(a set, String attributes) {
        String[] strArrSplit = attributes.split(ag.c.f654g);
        for (int i10 = 0; i10 < strArrSplit.length; i10++) {
            String[] strArrSplit2 = strArrSplit[i10].split(u.f30904o);
            if (strArrSplit2.length != 2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(" Unable to parse ");
                sb2.append(strArrSplit[i10]);
            } else {
                set.p(strArrSplit2[0], Color.parseColor(strArrSplit2[1]));
            }
        }
    }

    public void z1(boolean validate) {
        this.f4284a = validate;
    }
}
