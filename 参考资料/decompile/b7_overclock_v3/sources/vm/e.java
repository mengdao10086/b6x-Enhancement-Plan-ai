package vm;

import gm.c0;
import gm.f0;
import gm.i;
import gm.j2;
import gm.w;
import gm.z;
import zn.h0;
import zn.t;

/* JADX INFO: loaded from: classes5.dex */
public class e extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.h f53239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h0 f53240b;

    public e(f0 f0Var) {
        if (f0Var.size() < 1 || f0Var.size() > 2) {
            throw new IllegalArgumentException("Bad sequence size: " + f0Var.size());
        }
        boolean z10 = f0Var.K(0).b() instanceof z;
        gm.h hVarK = f0Var.K(0);
        this.f53239a = z10 ? z.I(hVarK) : t.A(hVarK);
        if (f0Var.size() > 1) {
            this.f53240b = h0.y(f0Var.K(1));
        }
    }

    public e(zn.b bVar, byte[] bArr) {
        this.f53239a = new t(bVar, bArr);
    }

    public e(zn.b bVar, byte[] bArr, h0 h0Var) {
        this.f53239a = new t(bVar, bArr);
        this.f53240b = h0Var;
    }

    public static e z(Object obj) {
        if (obj instanceof e) {
            return (e) obj;
        }
        if (obj != null) {
            return new e(f0.J(obj));
        }
        return null;
    }

    public h0 A() {
        return this.f53240b;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        i iVar = new i(2);
        iVar.a(this.f53239a);
        h0 h0Var = this.f53240b;
        if (h0Var != null) {
            iVar.a(h0Var);
        }
        return new j2(iVar);
    }

    public zn.b x() {
        return this.f53239a.b() instanceof z ? new zn.b(on.b.f44365i) : t.A(this.f53239a).x();
    }

    public byte[] y() {
        return this.f53239a.b() instanceof z ? ((z) this.f53239a.b()).J() : t.A(this.f53239a).y();
    }
}
