package nm;

import gm.c0;
import gm.f0;
import gm.f2;
import gm.h;
import gm.i;
import gm.j2;
import gm.n0;
import gm.n2;
import gm.w;
import gm.z;

/* JADX INFO: loaded from: classes5.dex */
public class a extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zn.b f42238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f42239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f42240c;

    public a(f0 f0Var) {
        this.f42238a = zn.b.z(f0Var.K(0));
        if (f0Var.size() == 2) {
            this.f42239b = null;
            this.f42240c = z.H((n0) f0Var.K(1), true).J();
        } else {
            this.f42239b = z.H((n0) f0Var.K(1), true).J();
            this.f42240c = z.H((n0) f0Var.K(2), true).J();
        }
    }

    public a(zn.b bVar, byte[] bArr) {
        this.f42238a = bVar;
        this.f42239b = null;
        this.f42240c = org.bouncycastle.util.a.p(bArr);
    }

    public a(zn.b bVar, byte[] bArr, byte[] bArr2) {
        this.f42238a = bVar;
        this.f42239b = org.bouncycastle.util.a.p(bArr);
        this.f42240c = org.bouncycastle.util.a.p(bArr2);
    }

    public static a x(n0 n0Var, boolean z10) {
        return y(f0.I(n0Var, z10));
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
        i iVar = new i(3);
        iVar.a(this.f42238a);
        if (this.f42239b != null) {
            iVar.a(new n2(true, 0, (h) new f2(this.f42239b)));
        }
        iVar.a(new n2(true, 2, (h) new f2(this.f42240c)));
        return new j2(iVar);
    }
}
