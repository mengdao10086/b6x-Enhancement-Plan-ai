package is;

import gm.c0;
import gm.f0;
import gm.f2;
import gm.j2;
import gm.t;
import gm.w;
import gm.y;
import gm.z;

/* JADX INFO: loaded from: classes6.dex */
public class j extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public t f35812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public y f35813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public t f35814c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[][] f35815d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[][] f35816e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte[] f35817f;

    public j(int i10, short[][] sArr, short[][] sArr2, short[] sArr3) {
        this.f35812a = new t(0L);
        this.f35814c = new t(i10);
        this.f35815d = qs.c.c(sArr);
        this.f35816e = qs.c.c(sArr2);
        this.f35817f = qs.c.a(sArr3);
    }

    public j(f0 f0Var) {
        if (f0Var.K(0) instanceof t) {
            this.f35812a = t.I(f0Var.K(0));
        } else {
            this.f35813b = y.N(f0Var.K(0));
        }
        this.f35814c = t.I(f0Var.K(1));
        f0 f0VarJ = f0.J(f0Var.K(2));
        this.f35815d = new byte[f0VarJ.size()][];
        for (int i10 = 0; i10 < f0VarJ.size(); i10++) {
            this.f35815d[i10] = z.I(f0VarJ.K(i10)).J();
        }
        f0 f0Var2 = (f0) f0Var.K(3);
        this.f35816e = new byte[f0Var2.size()][];
        for (int i11 = 0; i11 < f0Var2.size(); i11++) {
            this.f35816e[i11] = z.I(f0Var2.K(i11)).J();
        }
        this.f35817f = z.I(((f0) f0Var.K(4)).K(0)).J();
    }

    public static j B(Object obj) {
        if (obj instanceof j) {
            return (j) obj;
        }
        if (obj != null) {
            return new j(f0.J(obj));
        }
        return null;
    }

    public int A() {
        return this.f35814c.Q();
    }

    public t C() {
        return this.f35812a;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i();
        gm.h hVar = this.f35812a;
        if (hVar == null) {
            hVar = this.f35813b;
        }
        iVar.a(hVar);
        iVar.a(this.f35814c);
        gm.i iVar2 = new gm.i();
        for (int i10 = 0; i10 < this.f35815d.length; i10++) {
            iVar2.a(new f2(this.f35815d[i10]));
        }
        iVar.a(new j2(iVar2));
        gm.i iVar3 = new gm.i();
        for (int i11 = 0; i11 < this.f35816e.length; i11++) {
            iVar3.a(new f2(this.f35816e[i11]));
        }
        iVar.a(new j2(iVar3));
        gm.i iVar4 = new gm.i();
        iVar4.a(new f2(this.f35817f));
        iVar.a(new j2(iVar4));
        return new j2(iVar);
    }

    public short[][] x() {
        return qs.c.d(this.f35815d);
    }

    public short[] y() {
        return qs.c.b(this.f35817f);
    }

    public short[][] z() {
        return qs.c.d(this.f35816e);
    }
}
