package in;

import gm.c0;
import gm.f0;
import gm.f2;
import gm.i;
import gm.j2;
import gm.t;
import gm.w;
import gm.z;

/* JADX INFO: loaded from: classes5.dex */
public class a extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public t f32542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public z f32543b;

    public a(f0 f0Var) {
        this.f32543b = (z) f0Var.K(0);
        this.f32542a = (t) f0Var.K(1);
    }

    public a(byte[] bArr, int i10) {
        this.f32543b = new f2(org.bouncycastle.util.a.p(bArr));
        this.f32542a = new t(i10);
    }

    public static a y(Object obj) {
        if (obj instanceof a) {
            return (a) obj;
        }
        if (obj != null) {
            return new a(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        i iVar = new i(2);
        iVar.a(this.f32543b);
        iVar.a(this.f32542a);
        return new j2(iVar);
    }

    public byte[] x() {
        return org.bouncycastle.util.a.p(this.f32543b.J());
    }

    public int z() {
        return this.f32542a.Q();
    }
}
