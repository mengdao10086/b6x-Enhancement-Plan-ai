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
public class b extends w {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte[] f37582c = new byte[0];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f37583d = 512;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f37584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f37585b;

    public b(int i10) {
        this.f37584a = i10;
        this.f37585b = f37582c;
    }

    public b(int i10, byte[] bArr) {
        this.f37584a = i10;
        this.f37585b = org.bouncycastle.util.a.p(bArr);
    }

    public b(f0 f0Var) {
        if (f0Var.size() > 2) {
            throw new IllegalArgumentException("sequence size greater than 2");
        }
        if (f0Var.size() == 2) {
            this.f37584a = t.I(f0Var.K(0)).Q();
            this.f37585b = org.bouncycastle.util.a.p(z.I(f0Var.K(1)).J());
        } else if (f0Var.size() != 1) {
            this.f37584a = 512;
            this.f37585b = f37582c;
        } else if (f0Var.K(0) instanceof t) {
            this.f37584a = t.I(f0Var.K(0)).Q();
            this.f37585b = f37582c;
        } else {
            this.f37584a = 512;
            this.f37585b = org.bouncycastle.util.a.p(z.I(f0Var.K(0)).J());
        }
    }

    public static b y(Object obj) {
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
        i iVar = new i();
        if (this.f37584a != 512) {
            iVar.a(new t(this.f37584a));
        }
        if (this.f37585b.length != 0) {
            iVar.a(new f2(x()));
        }
        return new j2(iVar);
    }

    public byte[] x() {
        return org.bouncycastle.util.a.p(this.f37585b);
    }

    public int z() {
        return this.f37584a;
    }
}
