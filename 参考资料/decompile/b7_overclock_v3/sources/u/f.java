package u;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import w.o;
import w.y;

/* JADX INFO: loaded from: classes2.dex */
public class f extends b {
    public static final String Q = "KeyTimeCycle";
    public static final String R = "KeyTimeCycle";
    public static final int S = 3;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f51764y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f51765z = -1;
    public float A = Float.NaN;
    public float B = Float.NaN;
    public float C = Float.NaN;
    public float D = Float.NaN;
    public float E = Float.NaN;
    public float F = Float.NaN;
    public float G = Float.NaN;
    public float H = Float.NaN;
    public float I = Float.NaN;
    public float J = Float.NaN;
    public float K = Float.NaN;
    public float L = Float.NaN;
    public int M = 0;
    public String N = null;
    public float O = Float.NaN;
    public float P = 0.0f;

    public f() {
        this.f51751k = 3;
        this.f51752l = new HashMap<>();
    }

    @Override // u.b, w.w
    public boolean a(int i10, int i11) {
        if (i10 == 100) {
            this.f51748h = i11;
            return true;
        }
        if (i10 != 421) {
            return super.a(i10, i11);
        }
        this.M = i11;
        return true;
    }

    @Override // u.b, w.w
    public boolean b(int i10, float f10) {
        if (i10 == 315) {
            this.L = t(Float.valueOf(f10));
            return true;
        }
        if (i10 == 401) {
            this.f51765z = u(Float.valueOf(f10));
            return true;
        }
        if (i10 == 403) {
            this.A = f10;
            return true;
        }
        if (i10 == 416) {
            this.F = t(Float.valueOf(f10));
            return true;
        }
        if (i10 == 423) {
            this.O = t(Float.valueOf(f10));
            return true;
        }
        if (i10 == 424) {
            this.P = t(Float.valueOf(f10));
            return true;
        }
        switch (i10) {
            case 304:
                this.I = t(Float.valueOf(f10));
                return true;
            case 305:
                this.J = t(Float.valueOf(f10));
                return true;
            case 306:
                this.K = t(Float.valueOf(f10));
                return true;
            case 307:
                this.B = t(Float.valueOf(f10));
                return true;
            case 308:
                this.D = t(Float.valueOf(f10));
                return true;
            case 309:
                this.E = t(Float.valueOf(f10));
                return true;
            case 310:
                this.C = t(Float.valueOf(f10));
                return true;
            case 311:
                this.G = t(Float.valueOf(f10));
                return true;
            case 312:
                this.H = t(Float.valueOf(f10));
                return true;
            default:
                return super.b(i10, f10);
        }
    }

    @Override // u.b, w.w
    public boolean c(int i10, String str) {
        if (i10 == 420) {
            this.f51764y = str;
            return true;
        }
        if (i10 != 421) {
            return super.c(i10, str);
        }
        this.M = 7;
        this.N = str;
        return true;
    }

    @Override // u.b, w.w
    public boolean d(int i10, boolean z10) {
        return super.d(i10, z10);
    }

    @Override // w.w
    public int e(String str) {
        return y.a(str);
    }

    @Override // u.b
    public void f(HashMap<String, o> map) {
    }

    @Override // u.b
    /* JADX INFO: renamed from: g */
    public b clone() {
        return new f().h(this);
    }

    @Override // u.b
    public void i(HashSet<String> hashSet) {
        if (!Float.isNaN(this.A)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.B)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.C)) {
            hashSet.add("rotationZ");
        }
        if (!Float.isNaN(this.D)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.E)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.G)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.H)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.F)) {
            hashSet.add("pathRotate");
        }
        if (!Float.isNaN(this.I)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.J)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.K)) {
            hashSet.add("translationZ");
        }
        if (this.f51752l.size() > 0) {
            Iterator<String> it2 = this.f51752l.keySet().iterator();
            while (it2.hasNext()) {
                hashSet.add("CUSTOM," + it2.next());
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void v(java.util.HashMap<java.lang.String, w.t> r11) {
        /*
            Method dump skipped, instruction units count: 604
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u.f.v(java.util.HashMap):void");
    }

    @Override // u.b
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public f h(b bVar) {
        super.h(bVar);
        f fVar = (f) bVar;
        this.f51764y = fVar.f51764y;
        this.f51765z = fVar.f51765z;
        this.M = fVar.M;
        this.O = fVar.O;
        this.P = fVar.P;
        this.L = fVar.L;
        this.A = fVar.A;
        this.B = fVar.B;
        this.C = fVar.C;
        this.F = fVar.F;
        this.D = fVar.D;
        this.E = fVar.E;
        this.G = fVar.G;
        this.H = fVar.H;
        this.I = fVar.I;
        this.J = fVar.J;
        this.K = fVar.K;
        return this;
    }
}
