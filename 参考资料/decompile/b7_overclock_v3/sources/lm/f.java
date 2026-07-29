package lm;

import gm.n0;
import gm.n2;

/* JADX INFO: loaded from: classes5.dex */
public class f extends gm.w implements gm.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f39892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public om.l f39893b;

    public f(n0 n0Var) {
        if (n0Var.q() == 0) {
            this.f39892a = b.x(n0Var.U());
        } else {
            if (n0Var.q() == 1) {
                this.f39893b = om.l.x(n0Var.U());
                return;
            }
            throw new IllegalArgumentException("unknown tag: " + n0Var.q());
        }
    }

    public f(b bVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("'certificate' cannot be null");
        }
        this.f39892a = bVar;
    }

    public f(om.l lVar) {
        if (lVar == null) {
            throw new IllegalArgumentException("'encryptedKey' cannot be null");
        }
        this.f39893b = lVar;
    }

    public f(om.m mVar) {
        if (mVar == null) {
            throw new IllegalArgumentException("'encryptedCert' cannot be null");
        }
        this.f39893b = new om.l(mVar);
    }

    public static f z(Object obj) {
        if (obj instanceof f) {
            return (f) obj;
        }
        if (obj instanceof n0) {
            return new f((n0) obj);
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        b bVar = this.f39892a;
        return bVar != null ? new n2(true, 0, (gm.h) bVar) : new n2(true, 1, (gm.h) this.f39893b);
    }

    public b x() {
        return this.f39892a;
    }

    public om.l y() {
        return this.f39893b;
    }
}
