package u;

import java.util.HashMap;
import java.util.HashSet;
import w.b0;
import w.o;
import w.w;

/* JADX INFO: loaded from: classes2.dex */
public class e extends b {
    public static final String L = "KeyPosition";
    public static final float M = 20.0f;
    public static final int N = 2;
    public static final int O = 1;
    public static final int P = 0;
    public static final int Q = 2;
    public int A;
    public int B;
    public float C;
    public float D;
    public float E;
    public float F;
    public float G;
    public float H;
    public int I;
    public float J;
    public float K;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f51762y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f51763z;

    public e() {
        int i10 = b.f51736m;
        this.f51762y = i10;
        this.f51763z = null;
        this.A = i10;
        this.B = 0;
        this.C = Float.NaN;
        this.D = Float.NaN;
        this.E = Float.NaN;
        this.F = Float.NaN;
        this.G = Float.NaN;
        this.H = Float.NaN;
        this.I = 0;
        this.J = Float.NaN;
        this.K = Float.NaN;
        this.f51751k = 2;
    }

    public float A() {
        return this.K;
    }

    public boolean B(int i10, int i11, w.e eVar, w.e eVar2, float f10, float f11) {
        x(i10, i11, eVar.a(), eVar.b(), eVar2.a(), eVar2.b());
        return Math.abs(f10 - this.J) < 20.0f && Math.abs(f11 - this.K) < 20.0f;
    }

    public void C(t.e eVar, w.e eVar2, w.e eVar3, float f10, float f11, String[] strArr, float[] fArr) {
        int i10 = this.I;
        if (i10 == 1) {
            E(eVar2, eVar3, f10, f11, strArr, fArr);
        } else if (i10 != 2) {
            D(eVar2, eVar3, f10, f11, strArr, fArr);
        } else {
            F(eVar, eVar2, eVar3, f10, f11, strArr, fArr);
        }
    }

    public void D(w.e eVar, w.e eVar2, float f10, float f11, String[] strArr, float[] fArr) {
        float fA = eVar.a();
        float fB = eVar.b();
        float fA2 = eVar2.a() - fA;
        float fB2 = eVar2.b() - fB;
        if (strArr[0] == null) {
            strArr[0] = "percentX";
            fArr[0] = (f10 - fA) / fA2;
            strArr[1] = "percentY";
            fArr[1] = (f11 - fB) / fB2;
            return;
        }
        if ("percentX".equals(strArr[0])) {
            fArr[0] = (f10 - fA) / fA2;
            fArr[1] = (f11 - fB) / fB2;
        } else {
            fArr[1] = (f10 - fA) / fA2;
            fArr[0] = (f11 - fB) / fB2;
        }
    }

    public void E(w.e eVar, w.e eVar2, float f10, float f11, String[] strArr, float[] fArr) {
        float fA = eVar.a();
        float fB = eVar.b();
        float fA2 = eVar2.a() - fA;
        float fB2 = eVar2.b() - fB;
        float fHypot = (float) Math.hypot(fA2, fB2);
        if (fHypot < 1.0E-4d) {
            System.out.println("distance ~ 0");
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            return;
        }
        float f12 = fA2 / fHypot;
        float f13 = fB2 / fHypot;
        float f14 = f11 - fB;
        float f15 = f10 - fA;
        float f16 = ((f12 * f14) - (f15 * f13)) / fHypot;
        float f17 = ((f12 * f15) + (f13 * f14)) / fHypot;
        if (strArr[0] != null) {
            if ("percentX".equals(strArr[0])) {
                fArr[0] = f17;
                fArr[1] = f16;
                return;
            }
            return;
        }
        strArr[0] = "percentX";
        strArr[1] = "percentY";
        fArr[0] = f17;
        fArr[1] = f16;
    }

    public void F(t.e eVar, w.e eVar2, w.e eVar3, float f10, float f11, String[] strArr, float[] fArr) {
        eVar2.a();
        eVar2.b();
        eVar3.a();
        eVar3.b();
        t.e eVarN = eVar.n();
        int iD = eVarN.D();
        int iK = eVarN.k();
        if (strArr[0] == null) {
            strArr[0] = "percentX";
            fArr[0] = f10 / iD;
            strArr[1] = "percentY";
            fArr[1] = f11 / iK;
            return;
        }
        if ("percentX".equals(strArr[0])) {
            fArr[0] = f10 / iD;
            fArr[1] = f11 / iK;
        } else {
            fArr[1] = f10 / iD;
            fArr[0] = f11 / iK;
        }
    }

    @Override // u.b, w.w
    public boolean a(int i10, int i11) {
        if (i10 == 100) {
            this.f51748h = i11;
            return true;
        }
        if (i10 == 508) {
            this.f51762y = i11;
            return true;
        }
        if (i10 != 510) {
            return super.a(i10, i11);
        }
        this.I = i11;
        return true;
    }

    @Override // u.b, w.w
    public boolean b(int i10, float f10) {
        switch (i10) {
            case w.g.f53772k /* 503 */:
                this.C = f10;
                return true;
            case w.g.f53773l /* 504 */:
                this.D = f10;
                return true;
            case w.g.f53774m /* 505 */:
                this.C = f10;
                this.D = f10;
                return true;
            case w.g.f53775n /* 506 */:
                this.E = f10;
                return true;
            case w.g.f53776o /* 507 */:
                this.F = f10;
                return true;
            default:
                return super.b(i10, f10);
        }
    }

    @Override // u.b, w.w
    public boolean c(int i10, String str) {
        if (i10 != 501) {
            return super.c(i10, str);
        }
        this.f51763z = str.toString();
        return true;
    }

    @Override // w.w
    public int e(String str) {
        return b0.a(str);
    }

    @Override // u.b
    public void f(HashMap<String, o> map) {
    }

    @Override // u.b
    /* JADX INFO: renamed from: g */
    public b clone() {
        return new e().h(this);
    }

    @Override // u.b
    public b h(b bVar) {
        super.h(bVar);
        e eVar = (e) bVar;
        this.f51763z = eVar.f51763z;
        this.A = eVar.A;
        this.B = eVar.B;
        this.C = eVar.C;
        this.D = Float.NaN;
        this.E = eVar.E;
        this.F = eVar.F;
        this.G = eVar.G;
        this.H = eVar.H;
        this.J = eVar.J;
        this.K = eVar.K;
        return this;
    }

    @Override // u.b
    public void i(HashSet<String> hashSet) {
    }

    public final void v(float f10, float f11, float f12, float f13) {
        float f14 = f12 - f10;
        float f15 = f13 - f11;
        float f16 = Float.isNaN(this.E) ? 0.0f : this.E;
        float f17 = Float.isNaN(this.H) ? 0.0f : this.H;
        float f18 = Float.isNaN(this.F) ? 0.0f : this.F;
        this.J = (int) (f10 + (f16 * f14) + ((Float.isNaN(this.G) ? 0.0f : this.G) * f15));
        this.K = (int) (f11 + (f14 * f17) + (f15 * f18));
    }

    public final void w(float f10, float f11, float f12, float f13) {
        float f14 = f12 - f10;
        float f15 = f13 - f11;
        float f16 = this.E;
        float f17 = this.F;
        this.J = f10 + (f14 * f16) + ((-f15) * f17);
        this.K = f11 + (f15 * f16) + (f14 * f17);
    }

    public void x(int i10, int i11, float f10, float f11, float f12, float f13) {
        int i12 = this.I;
        if (i12 == 1) {
            w(f10, f11, f12, f13);
        } else if (i12 != 2) {
            v(f10, f11, f12, f13);
        } else {
            y(i10, i11);
        }
    }

    public final void y(int i10, int i11) {
        float f10 = this.E;
        float f11 = 0;
        this.J = ((i10 - 0) * f10) + f11;
        this.K = ((i11 - 0) * f10) + f11;
    }

    public float z() {
        return this.J;
    }
}
