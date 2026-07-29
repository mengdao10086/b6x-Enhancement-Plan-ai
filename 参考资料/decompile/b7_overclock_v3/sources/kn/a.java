package kn;

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

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte[] f37578c = new byte[0];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f37579d = 256;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f37580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f37581b;

    public a(int i10) {
        this.f37580a = i10;
        this.f37581b = f37578c;
    }

    public a(int i10, byte[] bArr) {
        this.f37580a = i10;
        this.f37581b = org.bouncycastle.util.a.p(bArr);
    }

    public a(f0 f0Var) {
        if (f0Var.size() > 2) {
            throw new IllegalArgumentException("sequence size greater than 2");
        }
        if (f0Var.size() == 2) {
            this.f37580a = t.I(f0Var.K(0)).Q();
            this.f37581b = org.bouncycastle.util.a.p(z.I(f0Var.K(1)).J());
        } else if (f0Var.size() != 1) {
            this.f37580a = 256;
            this.f37581b = f37578c;
        } else if (f0Var.K(0) instanceof t) {
            this.f37580a = t.I(f0Var.K(0)).Q();
            this.f37581b = f37578c;
        } else {
            this.f37580a = 256;
            this.f37581b = org.bouncycastle.util.a.p(z.I(f0Var.K(0)).J());
        }
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
        i iVar = new i();
        if (this.f37580a != 256) {
            iVar.a(new t(this.f37580a));
        }
        if (this.f37581b.length != 0) {
            iVar.a(new f2(x()));
        }
        return new j2(iVar);
    }

    public byte[] x() {
        return org.bouncycastle.util.a.p(this.f37581b);
    }

    public int z() {
        return this.f37580a;
    }
}
