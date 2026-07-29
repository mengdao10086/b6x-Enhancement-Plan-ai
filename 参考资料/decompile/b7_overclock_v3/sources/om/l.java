package om;

import gm.c0;
import gm.n0;
import gm.n2;

/* JADX INFO: loaded from: classes5.dex */
public class l extends gm.w implements gm.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public mm.t f44308a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public m f44309b;

    public l(mm.t tVar) {
        this.f44308a = tVar;
    }

    public l(m mVar) {
        this.f44309b = mVar;
    }

    public static l x(Object obj) {
        return obj instanceof l ? (l) obj : obj instanceof n0 ? new l(mm.t.z((n0) obj, false)) : obj instanceof m ? new l((m) obj) : new l(m.A(obj));
    }

    @Override // gm.w, gm.h
    public c0 b() {
        m mVar = this.f44309b;
        return mVar != null ? mVar.b() : new n2(false, 0, (gm.h) this.f44308a);
    }

    public gm.h y() {
        m mVar = this.f44309b;
        return mVar != null ? mVar : this.f44308a;
    }

    public boolean z() {
        return this.f44309b != null;
    }
}
