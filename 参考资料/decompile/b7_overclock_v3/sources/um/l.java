package um;

import gm.c0;
import gm.f0;
import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class l extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j f52256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public m f52257b;

    public l(f0 f0Var) {
        if (f0Var.size() < 1 || f0Var.size() > 2) {
            throw new IllegalArgumentException("Bad sequence size: " + f0Var.size());
        }
        this.f52256a = j.x(f0Var.K(0));
        if (f0Var.size() > 1) {
            this.f52257b = m.z(f0Var.K(1));
        }
    }

    public l(j jVar) {
        this(jVar, null);
    }

    public l(j jVar, m mVar) {
        this.f52256a = jVar;
        this.f52257b = mVar;
    }

    public static l x(Object obj) {
        if (obj instanceof l) {
            return (l) obj;
        }
        if (obj != null) {
            return new l(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f52256a);
        m mVar = this.f52257b;
        if (mVar != null) {
            iVar.a(mVar);
        }
        return new j2(iVar);
    }

    public j y() {
        return this.f52256a;
    }

    public m z() {
        return this.f52257b;
    }
}
