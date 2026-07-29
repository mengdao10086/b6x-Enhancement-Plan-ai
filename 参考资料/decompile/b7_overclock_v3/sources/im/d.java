package im;

import gm.c0;
import gm.f0;
import gm.f2;
import gm.j2;
import gm.w;
import gm.z;

/* JADX INFO: loaded from: classes5.dex */
public class d extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zn.b f32509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z f32510b;

    public d(f0 f0Var) {
        this.f32509a = zn.b.z(f0Var.K(0));
        this.f32510b = z.I(f0Var.K(1));
    }

    public d(zn.b bVar, byte[] bArr) {
        this.f32509a = bVar;
        this.f32510b = new f2(org.bouncycastle.util.a.p(bArr));
    }

    public static d y(Object obj) {
        if (obj instanceof d) {
            return (d) obj;
        }
        if (obj != null) {
            return new d(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f32509a);
        iVar.a(this.f32510b);
        return new j2(iVar);
    }

    public byte[] x() {
        return org.bouncycastle.util.a.p(this.f32510b.J());
    }

    public zn.b z() {
        return this.f32509a;
    }
}
