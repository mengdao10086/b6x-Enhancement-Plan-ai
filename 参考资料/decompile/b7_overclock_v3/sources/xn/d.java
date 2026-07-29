package xn;

import gm.c0;
import gm.f0;
import gm.g;
import gm.h;
import gm.j2;
import gm.n0;
import gm.w;
import gm.y;
import java.util.Enumeration;
import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public class d extends w implements g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static f f55656f = yn.c.Q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f55657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f55658b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f f55659c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c[] f55660d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public j2 f55661e;

    public d(f0 f0Var) {
        this(f55656f, f0Var);
    }

    public d(String str) {
        this(f55656f, str);
    }

    public d(f fVar, f0 f0Var) {
        this.f55659c = fVar;
        this.f55660d = new c[f0Var.size()];
        Enumeration enumerationL = f0Var.L();
        boolean z10 = true;
        int i10 = 0;
        while (enumerationL.hasMoreElements()) {
            Object objNextElement = enumerationL.nextElement();
            c cVarA = c.A(objNextElement);
            z10 &= cVarA == objNextElement;
            this.f55660d[i10] = cVarA;
            i10++;
        }
        this.f55661e = z10 ? j2.T(f0Var) : new j2(this.f55660d);
    }

    public d(f fVar, String str) {
        this(fVar.d(str));
        this.f55659c = fVar;
    }

    public d(f fVar, d dVar) {
        this.f55659c = fVar;
        this.f55660d = dVar.f55660d;
        this.f55661e = dVar.f55661e;
    }

    public d(f fVar, c[] cVarArr) {
        this.f55659c = fVar;
        this.f55660d = (c[]) cVarArr.clone();
        this.f55661e = new j2(this.f55660d);
    }

    public d(c[] cVarArr) {
        this(f55656f, cVarArr);
    }

    public static d A(Object obj) {
        if (obj instanceof d) {
            return (d) obj;
        }
        if (obj != null) {
            return new d(f0.J(obj));
        }
        return null;
    }

    public static d B(f fVar, Object obj) {
        if (obj instanceof d) {
            return new d(fVar, (d) obj);
        }
        if (obj != null) {
            return new d(fVar, f0.J(obj));
        }
        return null;
    }

    public static void E(f fVar) {
        Objects.requireNonNull(fVar, "cannot set style to null");
        f55656f = fVar;
    }

    public static f y() {
        return f55656f;
    }

    public static d z(n0 n0Var, boolean z10) {
        return A(f0.I(n0Var, true));
    }

    public c[] C() {
        return (c[]) this.f55660d.clone();
    }

    public c[] D(y yVar) {
        int length = this.f55660d.length;
        c[] cVarArr = new c[length];
        int i10 = 0;
        int i11 = 0;
        while (true) {
            c[] cVarArr2 = this.f55660d;
            if (i10 == cVarArr2.length) {
                break;
            }
            c cVar = cVarArr2[i10];
            if (cVar.y(yVar)) {
                cVarArr[i11] = cVar;
                i11++;
            }
            i10++;
        }
        if (i11 >= length) {
            return cVarArr;
        }
        c[] cVarArr3 = new c[i11];
        System.arraycopy(cVarArr, 0, cVarArr3, 0, i11);
        return cVarArr3;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        return this.f55661e;
    }

    @Override // gm.w
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d) && !(obj instanceof f0)) {
            return false;
        }
        if (b().C(((h) obj).b())) {
            return true;
        }
        try {
            return this.f55659c.c(this, new d(f0.J(((h) obj).b())));
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // gm.w
    public int hashCode() {
        if (this.f55657a) {
            return this.f55658b;
        }
        this.f55657a = true;
        int iA = this.f55659c.a(this);
        this.f55658b = iA;
        return iA;
    }

    public String toString() {
        return this.f55659c.h(this);
    }

    public y[] x() {
        int length = this.f55660d.length;
        int size = 0;
        for (int i10 = 0; i10 < length; i10++) {
            size += this.f55660d[i10].size();
        }
        y[] yVarArr = new y[size];
        int iX = 0;
        for (int i11 = 0; i11 < length; i11++) {
            iX += this.f55660d[i11].x(yVarArr, iX);
        }
        return yVarArr;
    }
}
