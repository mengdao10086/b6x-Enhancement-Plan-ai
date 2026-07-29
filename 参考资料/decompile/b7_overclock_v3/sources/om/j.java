package om;

import gm.c0;
import gm.f0;
import gm.f2;
import gm.j2;
import gm.z;
import mm.y;

/* JADX INFO: loaded from: classes5.dex */
public class j extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f44304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z f44305b;

    public j(f0 f0Var) {
        gm.h hVarK;
        if (f0Var.size() == 1) {
            this.f44304a = null;
            hVarK = f0Var.K(0);
        } else {
            if (f0Var.size() != 2) {
                throw new IllegalArgumentException("sequence wrong length for DhSigStatic");
            }
            this.f44304a = y.x(f0Var.K(0));
            hVarK = f0Var.K(1);
        }
        this.f44305b = z.I(hVarK);
    }

    public j(y yVar, byte[] bArr) {
        this.f44304a = yVar;
        this.f44305b = new f2(org.bouncycastle.util.a.p(bArr));
    }

    public j(byte[] bArr) {
        this(null, bArr);
    }

    public static j y(Object obj) {
        if (obj instanceof j) {
            return (j) obj;
        }
        if (obj != null) {
            return new j(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(2);
        y yVar = this.f44304a;
        if (yVar != null) {
            iVar.a(yVar);
        }
        iVar.a(this.f44305b);
        return new j2(iVar);
    }

    public byte[] x() {
        return org.bouncycastle.util.a.p(this.f44305b.J());
    }

    public y z() {
        return this.f44304a;
    }
}
