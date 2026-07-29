package um;

import gm.c0;
import gm.f0;
import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class h extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m f52237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f52238b;

    public h(f0 f0Var) {
        if (f0Var.size() < 1 || f0Var.size() > 2) {
            throw new IllegalArgumentException("Bad sequence size: " + f0Var.size());
        }
        this.f52237a = m.z(f0Var.K(0));
        if (f0Var.size() > 1) {
            this.f52238b = e.A(f0Var.K(1));
        }
    }

    public h(m mVar) {
        this(mVar, null);
    }

    public h(m mVar, e eVar) {
        this.f52237a = mVar;
        this.f52238b = eVar;
    }

    public static h z(Object obj) {
        if (obj instanceof h) {
            return (h) obj;
        }
        if (obj != null) {
            return new h(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f52237a.b());
        e eVar = this.f52238b;
        if (eVar != null) {
            iVar.a(eVar.b());
        }
        return new j2(iVar);
    }

    public m x() {
        return this.f52237a;
    }

    public e y() {
        return this.f52238b;
    }
}
