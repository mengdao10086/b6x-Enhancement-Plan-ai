package ya;

import android.util.Pair;
import ya.x1;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends x1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f56552b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.google.android.exoplayer2.source.t f56553c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f56554d;

    public a(boolean z10, com.google.android.exoplayer2.source.t tVar) {
        this.f56554d = z10;
        this.f56553c = tVar;
        this.f56552b = tVar.getLength();
    }

    public static Object w(Object obj) {
        return ((Pair) obj).second;
    }

    public static Object x(Object obj) {
        return ((Pair) obj).first;
    }

    public static Object z(Object obj, Object obj2) {
        return Pair.create(obj, obj2);
    }

    public abstract int A(int i10);

    public abstract int B(int i10);

    public final int C(int i10, boolean z10) {
        if (z10) {
            return this.f56553c.d(i10);
        }
        if (i10 < this.f56552b - 1) {
            return i10 + 1;
        }
        return -1;
    }

    public final int D(int i10, boolean z10) {
        if (z10) {
            return this.f56553c.c(i10);
        }
        if (i10 > 0) {
            return i10 - 1;
        }
        return -1;
    }

    public abstract x1 E(int i10);

    @Override // ya.x1
    public int a(boolean z10) {
        if (this.f56552b == 0) {
            return -1;
        }
        if (this.f56554d) {
            z10 = false;
        }
        int iB = z10 ? this.f56553c.b() : 0;
        while (E(iB).r()) {
            iB = C(iB, z10);
            if (iB == -1) {
                return -1;
            }
        }
        return B(iB) + E(iB).a(z10);
    }

    @Override // ya.x1
    public final int b(Object obj) {
        int iB;
        if (!(obj instanceof Pair)) {
            return -1;
        }
        Object objX = x(obj);
        Object objW = w(obj);
        int iT = t(objX);
        if (iT == -1 || (iB = E(iT).b(objW)) == -1) {
            return -1;
        }
        return A(iT) + iB;
    }

    @Override // ya.x1
    public int c(boolean z10) {
        int i10 = this.f56552b;
        if (i10 == 0) {
            return -1;
        }
        if (this.f56554d) {
            z10 = false;
        }
        int iF = z10 ? this.f56553c.f() : i10 - 1;
        while (E(iF).r()) {
            iF = D(iF, z10);
            if (iF == -1) {
                return -1;
            }
        }
        return B(iF) + E(iF).c(z10);
    }

    @Override // ya.x1
    public int e(int i10, int i11, boolean z10) {
        if (this.f56554d) {
            if (i11 == 1) {
                i11 = 2;
            }
            z10 = false;
        }
        int iV = v(i10);
        int iB = B(iV);
        int iE = E(iV).e(i10 - iB, i11 != 2 ? i11 : 0, z10);
        if (iE != -1) {
            return iB + iE;
        }
        int iC = C(iV, z10);
        while (iC != -1 && E(iC).r()) {
            iC = C(iC, z10);
        }
        if (iC != -1) {
            return B(iC) + E(iC).a(z10);
        }
        if (i11 == 2) {
            return a(z10);
        }
        return -1;
    }

    @Override // ya.x1
    public final x1.b g(int i10, x1.b bVar, boolean z10) {
        int iU = u(i10);
        int iB = B(iU);
        E(iU).g(i10 - A(iU), bVar, z10);
        bVar.f57234c += iB;
        if (z10) {
            bVar.f57233b = z(y(iU), hd.a.g(bVar.f57233b));
        }
        return bVar;
    }

    @Override // ya.x1
    public final x1.b h(Object obj, x1.b bVar) {
        Object objX = x(obj);
        Object objW = w(obj);
        int iT = t(objX);
        int iB = B(iT);
        E(iT).h(objW, bVar);
        bVar.f57234c += iB;
        bVar.f57233b = obj;
        return bVar;
    }

    @Override // ya.x1
    public int l(int i10, int i11, boolean z10) {
        if (this.f56554d) {
            if (i11 == 1) {
                i11 = 2;
            }
            z10 = false;
        }
        int iV = v(i10);
        int iB = B(iV);
        int iL = E(iV).l(i10 - iB, i11 != 2 ? i11 : 0, z10);
        if (iL != -1) {
            return iB + iL;
        }
        int iD = D(iV, z10);
        while (iD != -1 && E(iD).r()) {
            iD = D(iD, z10);
        }
        if (iD != -1) {
            return B(iD) + E(iD).c(z10);
        }
        if (i11 == 2) {
            return c(z10);
        }
        return -1;
    }

    @Override // ya.x1
    public final Object m(int i10) {
        int iU = u(i10);
        return z(y(iU), E(iU).m(i10 - A(iU)));
    }

    @Override // ya.x1
    public final x1.c o(int i10, x1.c cVar, long j10) {
        int iV = v(i10);
        int iB = B(iV);
        int iA = A(iV);
        E(iV).o(i10 - iB, cVar, j10);
        Object objY = y(iV);
        if (!x1.c.f57238r.equals(cVar.f57240a)) {
            objY = z(objY, cVar.f57240a);
        }
        cVar.f57240a = objY;
        cVar.f57252m += iA;
        cVar.f57253n += iA;
        return cVar;
    }

    public abstract int t(Object obj);

    public abstract int u(int i10);

    public abstract int v(int i10);

    public abstract Object y(int i10);
}
