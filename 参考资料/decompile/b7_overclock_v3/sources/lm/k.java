package lm;

import gm.f2;
import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class k extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public zn.b f39919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.z f39920b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public gm.z f39921c;

    public k(gm.f0 f0Var) {
        int i10 = 0;
        if (f0Var.size() == 3) {
            this.f39919a = zn.b.z(f0Var.K(0));
            i10 = 1;
        }
        this.f39920b = gm.z.I(f0Var.K(i10));
        this.f39921c = gm.z.I(f0Var.K(i10 + 1));
    }

    public k(zn.b bVar, byte[] bArr, byte[] bArr2) {
        this.f39919a = bVar;
        this.f39920b = new f2(bArr);
        this.f39921c = new f2(bArr2);
    }

    public k(byte[] bArr, byte[] bArr2) {
        this(null, bArr, bArr2);
    }

    public static k z(Object obj) {
        if (obj instanceof k) {
            return (k) obj;
        }
        if (obj != null) {
            return new k(gm.f0.J(obj));
        }
        return null;
    }

    public zn.b A() {
        return this.f39919a;
    }

    public byte[] B() {
        return this.f39920b.J();
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(3);
        x(iVar, this.f39919a);
        iVar.a(this.f39920b);
        iVar.a(this.f39921c);
        return new j2(iVar);
    }

    public final void x(gm.i iVar, gm.h hVar) {
        if (hVar != null) {
            iVar.a(hVar);
        }
    }

    public byte[] y() {
        return this.f39921c.J();
    }
}
