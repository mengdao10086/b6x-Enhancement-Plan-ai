package km;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class z extends gm.w implements gm.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f37575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0 f37576b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r f37577c;

    public z(c0 c0Var) {
        this(null, c0Var, null);
    }

    public z(e eVar) {
        this(eVar, null, null);
    }

    public z(e eVar, c0 c0Var, r rVar) {
        this.f37575a = eVar;
        this.f37576b = c0Var;
        this.f37577c = rVar;
    }

    public z(r rVar) {
        this(null, null, rVar);
    }

    public static z x(Object obj) {
        if (obj instanceof z) {
            return (z) obj;
        }
        if (obj instanceof gm.h) {
            gm.c0 c0VarB = ((gm.h) obj).b();
            if (c0VarB instanceof gm.t) {
                return new z(e.x(c0VarB));
            }
            if (c0VarB instanceof gm.f0) {
                return ((gm.f0) c0VarB).K(0) instanceof gm.y ? new z(r.z(c0VarB)) : new z(c0.x(c0VarB));
            }
        } else if (obj instanceof byte[]) {
            try {
                return x(gm.c0.D((byte[]) obj));
            } catch (IOException e10) {
                throw new IllegalArgumentException("parsing error: " + e10.getMessage());
            }
        }
        throw new IllegalArgumentException("unknown object in getInstance(): " + obj.getClass().getName());
    }

    public boolean A() {
        return this.f37576b != null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        c0 c0Var = this.f37576b;
        if (c0Var != null) {
            return c0Var.b();
        }
        e eVar = this.f37575a;
        return eVar != null ? eVar.b() : this.f37577c.b();
    }

    public boolean y() {
        return this.f37577c != null;
    }

    public boolean z() {
        return this.f37575a != null;
    }
}
