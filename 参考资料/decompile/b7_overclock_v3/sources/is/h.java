package is;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.t;
import gm.w;

/* JADX INFO: loaded from: classes6.dex */
public class h extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f35800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f35801b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[] f35802c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f35803d;

    public h(int i10, int[] iArr, int[] iArr2, int[] iArr3) {
        this.f35800a = i10;
        this.f35801b = iArr;
        this.f35802c = iArr2;
        this.f35803d = iArr3;
    }

    public h(f0 f0Var) {
        if (f0Var.size() != 4) {
            throw new IllegalArgumentException("sie of seqOfParams = " + f0Var.size());
        }
        this.f35800a = x(f0Var.K(0));
        f0 f0Var2 = (f0) f0Var.K(1);
        f0 f0Var3 = (f0) f0Var.K(2);
        f0 f0Var4 = (f0) f0Var.K(3);
        if (f0Var2.size() != this.f35800a || f0Var3.size() != this.f35800a || f0Var4.size() != this.f35800a) {
            throw new IllegalArgumentException("invalid size of sequences");
        }
        this.f35801b = new int[f0Var2.size()];
        this.f35802c = new int[f0Var3.size()];
        this.f35803d = new int[f0Var4.size()];
        for (int i10 = 0; i10 < this.f35800a; i10++) {
            this.f35801b[i10] = x(f0Var2.K(i10));
            this.f35802c[i10] = x(f0Var3.K(i10));
            this.f35803d[i10] = x(f0Var4.K(i10));
        }
    }

    public static int x(gm.h hVar) {
        int iQ = ((t) hVar).Q();
        if (iQ > 0) {
            return iQ;
        }
        throw new IllegalArgumentException("BigInteger not in Range: " + iQ);
    }

    public static h z(Object obj) {
        if (obj instanceof h) {
            return (h) obj;
        }
        if (obj != null) {
            return new h(f0.J(obj));
        }
        return null;
    }

    public int[] A() {
        return org.bouncycastle.util.a.s(this.f35803d);
    }

    public int B() {
        return this.f35800a;
    }

    public int[] C() {
        return org.bouncycastle.util.a.s(this.f35802c);
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i();
        gm.i iVar2 = new gm.i();
        gm.i iVar3 = new gm.i();
        for (int i10 = 0; i10 < this.f35801b.length; i10++) {
            iVar.a(new t(this.f35801b[i10]));
            iVar2.a(new t(this.f35802c[i10]));
            iVar3.a(new t(this.f35803d[i10]));
        }
        gm.i iVar4 = new gm.i();
        iVar4.a(new t(this.f35800a));
        iVar4.a(new j2(iVar));
        iVar4.a(new j2(iVar2));
        iVar4.a(new j2(iVar3));
        return new j2(iVar4);
    }

    public int[] y() {
        return org.bouncycastle.util.a.s(this.f35801b);
    }
}
