package u;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import w.o;

/* JADX INFO: loaded from: classes2.dex */
public class g extends b {
    public static final String R = "KeyTrigger";
    public static final String S = "viewTransitionOnCross";
    public static final String T = "viewTransitionOnPositiveCross";
    public static final String U = "viewTransitionOnNegativeCross";
    public static final String V = "postLayout";
    public static final String W = "triggerSlack";
    public static final String X = "triggerCollisionView";
    public static final String Y = "triggerCollisionId";
    public static final String Z = "triggerID";

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final String f51766a0 = "positiveCross";

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final String f51767b0 = "negativeCross";

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final String f51768c0 = "triggerReceiver";

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final String f51769d0 = "CROSS";

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final int f51770e0 = 301;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final int f51771f0 = 302;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final int f51772g0 = 303;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final int f51773h0 = 304;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final int f51774i0 = 305;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final int f51775j0 = 306;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final int f51776k0 = 307;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public static final int f51777l0 = 308;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final int f51778m0 = 309;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final int f51779n0 = 310;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public static final int f51780o0 = 311;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final int f51781p0 = 312;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public static final int f51782q0 = 5;
    public int A;
    public String B;
    public String C;
    public int D;
    public int E;
    public float F;
    public boolean G;
    public boolean H;
    public boolean I;
    public float J;
    public float K;
    public boolean L;
    public int M;
    public int N;
    public int O;
    public w.e P;
    public w.e Q;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f51783y = -1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f51784z = null;

    public g() {
        int i10 = b.f51736m;
        this.A = i10;
        this.B = null;
        this.C = null;
        this.D = i10;
        this.E = i10;
        this.F = 0.1f;
        this.G = true;
        this.H = true;
        this.I = true;
        this.J = Float.NaN;
        this.L = false;
        this.M = i10;
        this.N = i10;
        this.O = i10;
        this.P = new w.e();
        this.Q = new w.e();
        this.f51751k = 5;
        this.f51752l = new HashMap<>();
    }

    @Override // u.b, w.w
    public boolean a(int i10, int i11) {
        if (i10 == 307) {
            this.E = i11;
            return true;
        }
        if (i10 == 308) {
            this.D = u(Integer.valueOf(i11));
            return true;
        }
        if (i10 == 311) {
            this.A = i11;
            return true;
        }
        switch (i10) {
            case 301:
                this.O = i11;
                return true;
            case 302:
                this.N = i11;
                return true;
            case 303:
                this.M = i11;
                return true;
            default:
                return super.a(i10, i11);
        }
    }

    @Override // u.b, w.w
    public boolean b(int i10, float f10) {
        if (i10 != 305) {
            return super.b(i10, f10);
        }
        this.F = f10;
        return true;
    }

    @Override // u.b, w.w
    public boolean c(int i10, String str) {
        if (i10 == 309) {
            this.C = str;
            return true;
        }
        if (i10 == 310) {
            this.B = str;
            return true;
        }
        if (i10 != 312) {
            return super.c(i10, str);
        }
        this.f51784z = str;
        return true;
    }

    @Override // u.b, w.w
    public boolean d(int i10, boolean z10) {
        if (i10 != 304) {
            return super.d(i10, z10);
        }
        this.L = z10;
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:4:0x000b  */
    @Override // w.w
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int e(java.lang.String r3) {
        /*
            Method dump skipped, instruction units count: 250
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u.g.e(java.lang.String):int");
    }

    @Override // u.b
    public void f(HashMap<String, o> map) {
    }

    @Override // u.b
    /* JADX INFO: renamed from: g */
    public b clone() {
        return new g().h(this);
    }

    @Override // u.b
    public void i(HashSet<String> hashSet) {
    }

    public void v(float f10, t.e eVar) {
    }

    @Override // u.b
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public g h(b bVar) {
        super.h(bVar);
        g gVar = (g) bVar;
        this.f51783y = gVar.f51783y;
        this.f51784z = gVar.f51784z;
        this.A = gVar.A;
        this.B = gVar.B;
        this.C = gVar.C;
        this.D = gVar.D;
        this.E = gVar.E;
        this.F = gVar.F;
        this.G = gVar.G;
        this.H = gVar.H;
        this.I = gVar.I;
        this.J = gVar.J;
        this.K = gVar.K;
        this.L = gVar.L;
        this.P = gVar.P;
        this.Q = gVar.Q;
        return this;
    }

    public final void x(String str, t.e eVar) {
        boolean z10 = str.length() == 1;
        if (!z10) {
            str = str.substring(1).toLowerCase(Locale.ROOT);
        }
        for (String str2 : this.f51752l.keySet()) {
            String lowerCase = str2.toLowerCase(Locale.ROOT);
            if (z10 || lowerCase.matches(str)) {
                t.a aVar = this.f51752l.get(str2);
                if (aVar != null) {
                    aVar.a(eVar);
                }
            }
        }
    }
}
