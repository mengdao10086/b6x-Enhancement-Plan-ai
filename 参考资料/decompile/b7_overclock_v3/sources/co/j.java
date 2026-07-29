package co;

import gm.c0;
import gm.n0;
import gm.u;
import gm.w;
import gm.y;

/* JADX INFO: loaded from: classes5.dex */
public class j extends w implements gm.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c0 f11135a;

    public j(l lVar) {
        this.f11135a = null;
        this.f11135a = lVar.b();
    }

    public j(c0 c0Var) {
        this.f11135a = c0Var;
    }

    public j(u uVar) {
        this.f11135a = uVar;
    }

    public j(y yVar) {
        this.f11135a = yVar;
    }

    public static j x(n0 n0Var, boolean z10) {
        return y(n0Var.U());
    }

    public static j y(Object obj) {
        if (obj == null || (obj instanceof j)) {
            return (j) obj;
        }
        if (obj instanceof c0) {
            return new j((c0) obj);
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("unknown object in getInstance()");
        }
        try {
            return new j(c0.D((byte[]) obj));
        } catch (Exception e10) {
            throw new IllegalArgumentException("unable to parse encoded data: " + e10.getMessage());
        }
    }

    public boolean A() {
        return this.f11135a instanceof u;
    }

    public boolean B() {
        return this.f11135a instanceof y;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        return this.f11135a;
    }

    public c0 z() {
        return this.f11135a;
    }
}
