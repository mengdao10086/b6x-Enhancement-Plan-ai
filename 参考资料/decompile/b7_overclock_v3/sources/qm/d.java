package qm;

import gm.c0;
import gm.f0;
import gm.f2;
import gm.j2;
import gm.n0;
import gm.w;
import gm.y;
import gm.z;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class d extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public z f47486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public y f47487b;

    public d(f0 f0Var) {
        Enumeration enumerationL = f0Var.L();
        this.f47486a = (z) enumerationL.nextElement();
        this.f47487b = (y) enumerationL.nextElement();
    }

    public d(byte[] bArr, y yVar) {
        this.f47486a = new f2(bArr);
        this.f47487b = yVar;
    }

    public static d A(Object obj) {
        if (obj instanceof d) {
            return (d) obj;
        }
        if (obj != null) {
            return new d(f0.J(obj));
        }
        return null;
    }

    public static d z(n0 n0Var, boolean z10) {
        return A(f0.I(n0Var, z10));
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f47486a);
        iVar.a(this.f47487b);
        return new j2(iVar);
    }

    public y x() {
        return this.f47487b;
    }

    public byte[] y() {
        return org.bouncycastle.util.a.p(this.f47486a.J());
    }
}
