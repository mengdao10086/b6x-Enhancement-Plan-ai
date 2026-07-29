package um;

import gm.c0;
import gm.c2;

/* JADX INFO: loaded from: classes5.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.r f52271a;

    public s(gm.r rVar) {
        this.f52271a = rVar;
    }

    public static s a(Object obj) {
        if (obj instanceof s) {
            return (s) obj;
        }
        if (obj instanceof gm.r) {
            return new s(gm.r.I(obj));
        }
        return null;
    }

    public c2 b() {
        gm.r rVar = this.f52271a;
        return (rVar == null || (rVar instanceof c2)) ? (c2) rVar : new c2(this.f52271a.d(), false);
    }

    public gm.r c() {
        return this.f52271a;
    }

    public c0 d() {
        return this.f52271a.b();
    }
}
