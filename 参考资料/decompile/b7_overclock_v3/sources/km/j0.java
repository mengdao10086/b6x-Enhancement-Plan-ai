package km;

import gm.n0;
import gm.n2;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class j0 extends gm.w implements gm.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f37520c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f37521d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f37522e = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f37523a = 2;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gm.h f37524b;

    public j0(gm.f0 f0Var) {
        this.f37524b = f0Var;
    }

    public j0(h0 h0Var) {
        this.f37524b = h0Var;
    }

    public j0(om.e eVar) {
        this.f37524b = eVar;
    }

    public static j0 x(Object obj) {
        if (obj instanceof j0) {
            return (j0) obj;
        }
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof gm.h)) {
            if (obj instanceof byte[]) {
                try {
                    return x(gm.c0.D((byte[]) obj));
                } catch (IOException unused) {
                    throw new IllegalArgumentException("unknown encoding in getInstance()");
                }
            }
            throw new IllegalArgumentException("unknown object in getInstance(): " + obj.getClass().getName());
        }
        n0 n0VarT = n0.T(((gm.h) obj).b());
        int iQ = n0VarT.q();
        if (iQ == 0) {
            return new j0(h0.x(n0VarT, false));
        }
        if (iQ == 1) {
            return new j0(om.e.z(n0VarT, false));
        }
        if (iQ == 2) {
            return new j0(gm.f0.I(n0VarT, false));
        }
        throw new IllegalArgumentException("unknown tag in getInstance(): " + n0VarT.q());
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return new n2(false, this.f37523a, this.f37524b);
    }

    public int q() {
        return this.f37523a;
    }

    public gm.h y() {
        return this.f37524b;
    }
}
