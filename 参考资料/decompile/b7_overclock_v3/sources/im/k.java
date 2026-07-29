package im;

import gm.c0;
import gm.f0;
import gm.f2;
import gm.j2;
import gm.w;
import gm.z;

/* JADX INFO: loaded from: classes5.dex */
public class k extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zn.b f32534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final pn.m f32535b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z f32536c;

    public k(f0 f0Var) {
        this.f32534a = zn.b.z(f0Var.K(0));
        this.f32535b = pn.m.y(f0Var.K(1));
        this.f32536c = z.I(f0Var.K(2));
    }

    public k(zn.b bVar, pn.m mVar, byte[] bArr) {
        this.f32534a = bVar;
        this.f32535b = mVar;
        this.f32536c = new f2(org.bouncycastle.util.a.p(bArr));
    }

    public static k x(Object obj) {
        if (obj instanceof k) {
            return (k) obj;
        }
        if (obj != null) {
            return new k(f0.J(obj));
        }
        return null;
    }

    public pn.m A() {
        return this.f32535b;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(3);
        iVar.a(this.f32534a);
        iVar.a(this.f32535b);
        iVar.a(this.f32536c);
        return new j2(iVar);
    }

    public byte[] y() {
        return org.bouncycastle.util.a.p(this.f32536c.J());
    }

    public zn.b z() {
        return this.f32534a;
    }
}
