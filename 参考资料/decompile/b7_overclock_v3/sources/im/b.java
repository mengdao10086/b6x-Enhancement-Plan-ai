package im;

import gm.c0;
import gm.f0;
import gm.f2;
import gm.j2;
import gm.w;
import gm.z;

/* JADX INFO: loaded from: classes5.dex */
public class b extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zn.b f32505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z f32506b;

    public b(f0 f0Var) {
        this.f32505a = zn.b.z(f0Var.K(0));
        this.f32506b = z.I(f0Var.K(1));
    }

    public b(zn.b bVar, byte[] bArr) {
        this.f32505a = bVar;
        this.f32506b = new f2(bArr);
    }

    public static b z(Object obj) {
        if (obj instanceof b) {
            return (b) obj;
        }
        if (obj != null) {
            return new b(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f32505a);
        iVar.a(this.f32506b);
        return new j2(iVar);
    }

    public z x() {
        return this.f32506b;
    }

    public zn.b y() {
        return this.f32505a;
    }
}
