package pn;

import gm.f0;
import gm.f2;
import gm.j2;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
public class v extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.t f46870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.z f46871b;

    public v(int i10, byte[] bArr) {
        this.f46870a = new gm.t(i10);
        this.f46871b = new f2(bArr);
    }

    public v(f0 f0Var) {
        gm.h hVarK;
        if (f0Var.size() == 1) {
            this.f46870a = null;
            hVarK = f0Var.K(0);
        } else {
            this.f46870a = (gm.t) f0Var.K(0);
            hVarK = f0Var.K(1);
        }
        this.f46871b = (gm.z) hVarK;
    }

    public v(byte[] bArr) {
        this.f46870a = null;
        this.f46871b = new f2(bArr);
    }

    public static v y(Object obj) {
        if (obj instanceof v) {
            return (v) obj;
        }
        if (obj != null) {
            return new v(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(2);
        gm.t tVar = this.f46870a;
        if (tVar != null) {
            iVar.a(tVar);
        }
        iVar.a(this.f46871b);
        return new j2(iVar);
    }

    public byte[] x() {
        return this.f46871b.J();
    }

    public BigInteger z() {
        gm.t tVar = this.f46870a;
        if (tVar == null) {
            return null;
        }
        return tVar.K();
    }
}
