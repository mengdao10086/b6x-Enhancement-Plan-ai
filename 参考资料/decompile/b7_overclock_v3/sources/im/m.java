package im;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.n0;
import gm.n2;
import gm.u1;
import gm.w;
import zn.o;

/* JADX INFO: loaded from: classes5.dex */
public class m extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zn.b f32539a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f0 f32540b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final gm.d f32541c;

    public m(f0 f0Var) {
        this.f32539a = zn.b.z(f0Var.K(0));
        int i10 = 1;
        if (f0Var.K(1) instanceof n0) {
            this.f32540b = f0.J(n0.T(f0Var.K(1)).U());
            i10 = 2;
        } else {
            this.f32540b = null;
        }
        this.f32541c = u1.S(f0Var.K(i10));
    }

    public m(zn.b bVar, byte[] bArr) {
        this.f32539a = bVar;
        this.f32540b = null;
        this.f32541c = new u1(org.bouncycastle.util.a.p(bArr));
    }

    public m(zn.b bVar, o[] oVarArr, byte[] bArr) {
        this.f32539a = bVar;
        this.f32540b = new j2(oVarArr);
        this.f32541c = new u1(org.bouncycastle.util.a.p(bArr));
    }

    public static m y(Object obj) {
        if (obj instanceof m) {
            return (m) obj;
        }
        if (obj != null) {
            return new m(f0.J(obj));
        }
        return null;
    }

    public zn.b A() {
        return this.f32539a;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(3);
        iVar.a(this.f32539a);
        f0 f0Var = this.f32540b;
        if (f0Var != null) {
            iVar.a(new n2(0, f0Var));
        }
        iVar.a(this.f32541c);
        return new j2(iVar);
    }

    public o[] x() {
        f0 f0Var = this.f32540b;
        if (f0Var == null) {
            return null;
        }
        int size = f0Var.size();
        o[] oVarArr = new o[size];
        for (int i10 = 0; i10 != size; i10++) {
            oVarArr[i10] = o.z(this.f32540b.K(i10));
        }
        return oVarArr;
    }

    public gm.d z() {
        return new u1(this.f32541c.H(), this.f32541c.m());
    }
}
