package om;

import gm.c0;
import gm.n0;
import gm.n2;
import gm.z;

/* JADX INFO: loaded from: classes5.dex */
public class o extends gm.w implements gm.g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f44318b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f44319c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f44320d = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.h f44321a;

    public o(n0 n0Var) {
        gm.h hVarX;
        int iQ = n0Var.q();
        if (iQ == 0) {
            hVarX = l.x(n0Var.U());
        } else if (iQ == 1) {
            hVarX = z.H(n0Var, false);
        } else {
            if (iQ != 2) {
                throw new IllegalArgumentException("unknown tag number: " + n0Var.q());
            }
            hVarX = gm.f.I(n0Var, false);
        }
        this.f44321a = hVarX;
    }

    public o(z zVar) {
        this.f44321a = zVar;
    }

    public o(l lVar) {
        this.f44321a = lVar;
    }

    public o(boolean z10) {
        this.f44321a = gm.f.K(z10);
    }

    public static o x(Object obj) {
        if (obj == null || (obj instanceof o)) {
            return (o) obj;
        }
        if (obj instanceof n0) {
            return new o((n0) obj);
        }
        throw new IllegalArgumentException("unknown object: " + obj);
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.h hVar = this.f44321a;
        return hVar instanceof l ? new n2(true, 0, hVar) : hVar instanceof z ? new n2(false, 1, hVar) : new n2(false, 2, hVar);
    }

    public int y() {
        gm.h hVar = this.f44321a;
        if (hVar instanceof l) {
            return 0;
        }
        return hVar instanceof z ? 1 : 2;
    }

    public gm.h z() {
        return this.f44321a;
    }
}
