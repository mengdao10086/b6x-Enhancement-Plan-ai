package vm;

import gm.c0;
import gm.f0;
import gm.f2;
import gm.i;
import gm.j2;
import gm.w;
import gm.z;
import zn.h0;

/* JADX INFO: loaded from: classes5.dex */
public class d extends w {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final zn.b f53235d = new zn.b(kn.d.f37592c);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public zn.b f53236a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f53237b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h0 f53238c;

    public d(f0 f0Var) {
        if (f0Var.size() > 3) {
            throw new IllegalArgumentException("Bad sequence size: " + f0Var.size());
        }
        int i10 = 0;
        if (f0Var.K(0) instanceof z) {
            this.f53236a = f53235d;
        } else {
            this.f53236a = zn.b.z(f0Var.K(0).b());
            i10 = 1;
        }
        int i11 = i10 + 1;
        this.f53237b = z.I(f0Var.K(i10).b()).J();
        if (f0Var.size() > i11) {
            this.f53238c = h0.y(f0Var.K(i11));
        }
    }

    public d(zn.b bVar, byte[] bArr) {
        this(bVar, bArr, null);
    }

    public d(zn.b bVar, byte[] bArr, h0 h0Var) {
        this.f53236a = bVar == null ? f53235d : bVar;
        this.f53237b = org.bouncycastle.util.a.p(bArr);
        this.f53238c = h0Var;
    }

    public d(byte[] bArr) {
        this(null, bArr, null);
    }

    public d(byte[] bArr, h0 h0Var) {
        this(null, bArr, h0Var);
    }

    public static d z(Object obj) {
        if (obj instanceof d) {
            return (d) obj;
        }
        if (obj != null) {
            return new d(f0.J(obj));
        }
        return null;
    }

    public h0 A() {
        return this.f53238c;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        i iVar = new i(3);
        if (!this.f53236a.equals(f53235d)) {
            iVar.a(this.f53236a);
        }
        iVar.a(new f2(this.f53237b).b());
        h0 h0Var = this.f53238c;
        if (h0Var != null) {
            iVar.a(h0Var);
        }
        return new j2(iVar);
    }

    public byte[] x() {
        return org.bouncycastle.util.a.p(this.f53237b);
    }

    public zn.b y() {
        return this.f53236a;
    }
}
