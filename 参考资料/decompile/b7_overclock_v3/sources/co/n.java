package co;

import gm.c0;
import gm.f2;
import gm.w;
import gm.z;

/* JADX INFO: loaded from: classes5.dex */
public class n extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z f11147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ir.e f11148b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ir.i f11149c;

    public n(ir.e eVar, z zVar) {
        this(eVar, zVar.J());
    }

    public n(ir.e eVar, byte[] bArr) {
        this.f11148b = eVar;
        this.f11147a = new f2(org.bouncycastle.util.a.p(bArr));
    }

    public n(ir.i iVar, boolean z10) {
        this.f11149c = iVar.B();
        this.f11147a = new f2(iVar.l(z10));
    }

    @Override // gm.w, gm.h
    public c0 b() {
        return this.f11147a;
    }

    public synchronized ir.i x() {
        if (this.f11149c == null) {
            this.f11149c = this.f11148b.k(this.f11147a.J()).B();
        }
        return this.f11149c;
    }

    public byte[] y() {
        return org.bouncycastle.util.a.p(this.f11147a.J());
    }

    public boolean z() {
        byte[] bArrJ = this.f11147a.J();
        if (bArrJ == null || bArrJ.length <= 0) {
            return false;
        }
        return bArrJ[0] == 2 || bArrJ[0] == 3;
    }
}
