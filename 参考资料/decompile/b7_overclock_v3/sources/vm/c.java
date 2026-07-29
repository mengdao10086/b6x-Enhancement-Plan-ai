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
public class c extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public z f53233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h0 f53234b;

    public c(f0 f0Var) {
        if (f0Var.size() < 1 || f0Var.size() > 2) {
            throw new IllegalArgumentException("Bad sequence size: " + f0Var.size());
        }
        this.f53233a = z.I(f0Var.K(0));
        if (f0Var.size() > 1) {
            this.f53234b = h0.y(f0Var.K(1));
        }
    }

    public c(byte[] bArr) {
        this.f53233a = new f2(bArr);
    }

    public c(byte[] bArr, h0 h0Var) {
        this.f53233a = new f2(bArr);
        this.f53234b = h0Var;
    }

    public static c y(Object obj) {
        if (obj instanceof c) {
            return (c) obj;
        }
        if (obj != null) {
            return new c(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        i iVar = new i(2);
        iVar.a(this.f53233a);
        h0 h0Var = this.f53234b;
        if (h0Var != null) {
            iVar.a(h0Var);
        }
        return new j2(iVar);
    }

    public byte[] x() {
        return this.f53233a.J();
    }

    public h0 z() {
        return this.f53234b;
    }
}
