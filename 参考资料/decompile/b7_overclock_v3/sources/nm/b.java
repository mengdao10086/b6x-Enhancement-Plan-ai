package nm;

import gm.c0;
import gm.f0;
import gm.h;
import gm.i;
import gm.j2;
import gm.n0;
import gm.n2;
import gm.w;
import gm.z;
import mm.h0;

/* JADX INFO: loaded from: classes5.dex */
public class b extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h0 f42241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public z f42242b;

    public b(f0 f0Var) {
        if (f0Var.size() != 1 && f0Var.size() != 2) {
            throw new IllegalArgumentException("Sequence has incorrect number of elements");
        }
        this.f42241a = h0.z(f0Var.K(0));
        if (f0Var.size() > 1) {
            this.f42242b = z.H((n0) f0Var.K(1), true);
        }
    }

    public b(h0 h0Var, z zVar) {
        if (h0Var == null) {
            throw new IllegalArgumentException("Ephemeral public key cannot be null");
        }
        this.f42241a = h0Var;
        this.f42242b = zVar;
    }

    public static b A(Object obj) {
        if (obj instanceof b) {
            return (b) obj;
        }
        if (obj != null) {
            return new b(f0.J(obj));
        }
        return null;
    }

    public static b z(n0 n0Var, boolean z10) {
        return A(f0.I(n0Var, z10));
    }

    @Override // gm.w, gm.h
    public c0 b() {
        i iVar = new i(2);
        iVar.a(this.f42241a);
        z zVar = this.f42242b;
        if (zVar != null) {
            iVar.a(new n2(true, 0, (h) zVar));
        }
        return new j2(iVar);
    }

    public z x() {
        return this.f42242b;
    }

    public h0 y() {
        return this.f42241a;
    }
}
