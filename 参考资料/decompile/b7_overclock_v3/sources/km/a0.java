package km;

import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class a0 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g0[] f37424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j0[] f37425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i0[] f37426c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final y[] f37427d;

    public a0(gm.f0 f0Var) {
        if (f0Var.size() != 4) {
            throw new IllegalArgumentException("Sequence not 4 elements.");
        }
        int i10 = 0;
        gm.f0 f0Var2 = (gm.f0) f0Var.K(0);
        this.f37424a = new g0[f0Var2.size()];
        int i11 = 0;
        while (true) {
            g0[] g0VarArr = this.f37424a;
            if (i11 >= g0VarArr.length) {
                break;
            }
            g0VarArr[i11] = g0.A(f0Var2.K(i11));
            i11++;
        }
        gm.f0 f0Var3 = (gm.f0) f0Var.K(1);
        this.f37425b = new j0[f0Var3.size()];
        int i12 = 0;
        while (true) {
            j0[] j0VarArr = this.f37425b;
            if (i12 >= j0VarArr.length) {
                break;
            }
            j0VarArr[i12] = j0.x(f0Var3.K(i12));
            i12++;
        }
        gm.f0 f0Var4 = (gm.f0) f0Var.K(2);
        this.f37426c = new i0[f0Var4.size()];
        int i13 = 0;
        while (true) {
            i0[] i0VarArr = this.f37426c;
            if (i13 >= i0VarArr.length) {
                break;
            }
            i0VarArr[i13] = i0.A(f0Var4.K(i13));
            i13++;
        }
        gm.f0 f0Var5 = (gm.f0) f0Var.K(3);
        this.f37427d = new y[f0Var5.size()];
        while (true) {
            y[] yVarArr = this.f37427d;
            if (i10 >= yVarArr.length) {
                return;
            }
            yVarArr[i10] = y.z(f0Var5.K(i10));
            i10++;
        }
    }

    public a0(g0[] g0VarArr, j0[] j0VarArr, i0[] i0VarArr, y[] yVarArr) {
        this.f37424a = y(g0VarArr);
        this.f37425b = A(j0VarArr);
        this.f37426c = z(i0VarArr);
        this.f37427d = x(yVarArr);
    }

    public static a0 D(Object obj) {
        if (obj instanceof a0) {
            return (a0) obj;
        }
        if (obj != null) {
            return new a0(gm.f0.J(obj));
        }
        return null;
    }

    public final j0[] A(j0[] j0VarArr) {
        int length = j0VarArr.length;
        j0[] j0VarArr2 = new j0[length];
        System.arraycopy(j0VarArr, 0, j0VarArr2, 0, length);
        return j0VarArr2;
    }

    public i0[] B() {
        return z(this.f37426c);
    }

    public g0[] C() {
        return y(this.f37424a);
    }

    public y[] E() {
        return x(this.f37427d);
    }

    public j0[] F() {
        return A(this.f37425b);
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return new j2(new gm.h[]{new j2(this.f37424a), new j2(this.f37425b), new j2(this.f37426c), new j2(this.f37427d)});
    }

    public final y[] x(y[] yVarArr) {
        int length = yVarArr.length;
        y[] yVarArr2 = new y[length];
        System.arraycopy(yVarArr, 0, yVarArr2, 0, length);
        return yVarArr2;
    }

    public final g0[] y(g0[] g0VarArr) {
        int length = g0VarArr.length;
        g0[] g0VarArr2 = new g0[length];
        System.arraycopy(g0VarArr, 0, g0VarArr2, 0, length);
        return g0VarArr2;
    }

    public final i0[] z(i0[] i0VarArr) {
        int length = i0VarArr.length;
        i0[] i0VarArr2 = new i0[length];
        System.arraycopy(i0VarArr, 0, i0VarArr2, 0, length);
        return i0VarArr2;
    }
}
