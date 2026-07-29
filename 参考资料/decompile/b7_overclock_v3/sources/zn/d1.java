package zn;

import gm.j2;
import gm.n2;
import java.util.Enumeration;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes5.dex */
public class d1 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.t f58688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public zn.b f58689b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public xn.d f58690c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public j1 f58691d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public j1 f58692e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public gm.f0 f58693f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public z f58694g;

    public static class b extends gm.w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public gm.f0 f58695a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public z f58696b;

        public b(gm.f0 f0Var) {
            if (f0Var.size() >= 2 && f0Var.size() <= 3) {
                this.f58695a = f0Var;
                return;
            }
            throw new IllegalArgumentException("Bad sequence size: " + f0Var.size());
        }

        public static b y(Object obj) {
            if (obj instanceof b) {
                return (b) obj;
            }
            if (obj != null) {
                return new b(gm.f0.J(obj));
            }
            return null;
        }

        public gm.t A() {
            return gm.t.I(this.f58695a.K(0));
        }

        public boolean B() {
            return this.f58695a.size() == 3;
        }

        @Override // gm.w, gm.h
        public gm.c0 b() {
            return this.f58695a;
        }

        public z x() {
            if (this.f58696b == null && this.f58695a.size() == 3) {
                this.f58696b = z.G(this.f58695a.K(2));
            }
            return this.f58696b;
        }

        public j1 z() {
            return j1.z(this.f58695a.K(1));
        }
    }

    public class c implements Enumeration {
        public c() {
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return false;
        }

        @Override // java.util.Enumeration
        public Object nextElement() {
            throw new NoSuchElementException("Empty Enumeration");
        }
    }

    public class d implements Enumeration {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Enumeration f58698a;

        public d(Enumeration enumeration) {
            this.f58698a = enumeration;
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return this.f58698a.hasMoreElements();
        }

        @Override // java.util.Enumeration
        public Object nextElement() {
            return b.y(this.f58698a.nextElement());
        }
    }

    public d1(gm.f0 f0Var) {
        if (f0Var.size() < 3 || f0Var.size() > 7) {
            throw new IllegalArgumentException("Bad sequence size: " + f0Var.size());
        }
        int i10 = 0;
        if (f0Var.K(0) instanceof gm.t) {
            this.f58688a = gm.t.I(f0Var.K(0));
            i10 = 1;
        } else {
            this.f58688a = null;
        }
        int i11 = i10 + 1;
        this.f58689b = zn.b.z(f0Var.K(i10));
        int i12 = i11 + 1;
        this.f58690c = xn.d.A(f0Var.K(i11));
        int i13 = i12 + 1;
        this.f58691d = j1.z(f0Var.K(i12));
        if (i13 < f0Var.size() && ((f0Var.K(i13) instanceof gm.q0) || (f0Var.K(i13) instanceof gm.o) || (f0Var.K(i13) instanceof j1))) {
            this.f58692e = j1.z(f0Var.K(i13));
            i13++;
        }
        if (i13 < f0Var.size() && !(f0Var.K(i13) instanceof gm.n0)) {
            this.f58693f = gm.f0.J(f0Var.K(i13));
            i13++;
        }
        if (i13 >= f0Var.size() || !(f0Var.K(i13) instanceof gm.n0)) {
            return;
        }
        this.f58694g = z.G(gm.f0.I((gm.n0) f0Var.K(i13), true));
    }

    public static d1 y(gm.n0 n0Var, boolean z10) {
        return z(gm.f0.I(n0Var, z10));
    }

    public static d1 z(Object obj) {
        if (obj instanceof d1) {
            return (d1) obj;
        }
        if (obj != null) {
            return new d1(gm.f0.J(obj));
        }
        return null;
    }

    public xn.d A() {
        return this.f58690c;
    }

    public j1 B() {
        return this.f58692e;
    }

    public Enumeration C() {
        gm.f0 f0Var = this.f58693f;
        return f0Var == null ? new c() : new d(f0Var.L());
    }

    public b[] D() {
        gm.f0 f0Var = this.f58693f;
        if (f0Var == null) {
            return new b[0];
        }
        int size = f0Var.size();
        b[] bVarArr = new b[size];
        for (int i10 = 0; i10 < size; i10++) {
            bVarArr[i10] = b.y(this.f58693f.K(i10));
        }
        return bVarArr;
    }

    public zn.b E() {
        return this.f58689b;
    }

    public j1 F() {
        return this.f58691d;
    }

    public gm.t G() {
        return this.f58688a;
    }

    public int H() {
        gm.t tVar = this.f58688a;
        if (tVar == null) {
            return 1;
        }
        return tVar.Q() + 1;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(7);
        gm.t tVar = this.f58688a;
        if (tVar != null) {
            iVar.a(tVar);
        }
        iVar.a(this.f58689b);
        iVar.a(this.f58690c);
        iVar.a(this.f58691d);
        j1 j1Var = this.f58692e;
        if (j1Var != null) {
            iVar.a(j1Var);
        }
        gm.f0 f0Var = this.f58693f;
        if (f0Var != null) {
            iVar.a(f0Var);
        }
        z zVar = this.f58694g;
        if (zVar != null) {
            iVar.a(new n2(0, zVar));
        }
        return new j2(iVar);
    }

    public z x() {
        return this.f58694g;
    }
}
