package im;

import gm.c0;
import gm.f0;
import gm.f2;
import gm.j2;
import gm.w;
import gm.y;
import gm.z;

/* JADX INFO: loaded from: classes5.dex */
public class l extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f32537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z f32538b;

    public l(f0 f0Var) {
        this.f32537a = y.N(f0Var.K(0));
        this.f32538b = z.I(f0Var.K(1));
    }

    public l(y yVar, byte[] bArr) {
        this.f32537a = yVar;
        this.f32538b = new f2(org.bouncycastle.util.a.p(bArr));
    }

    public static l x(Object obj) {
        if (obj instanceof l) {
            return (l) obj;
        }
        if (obj != null) {
            return new l(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f32537a);
        iVar.a(this.f32538b);
        return new j2(iVar);
    }

    public y y() {
        return this.f32537a;
    }

    public byte[] z() {
        return org.bouncycastle.util.a.p(this.f32538b.J());
    }
}
