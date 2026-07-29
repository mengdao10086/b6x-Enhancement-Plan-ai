package om;

import gm.c0;
import gm.f0;
import gm.j2;
import zn.b0;

/* JADX INFO: loaded from: classes5.dex */
public class v extends gm.w {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final gm.t f44347c = new gm.t(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final gm.t f44348d = new gm.t(1);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final gm.t f44349e = new gm.t(2);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final gm.t f44350f = new gm.t(3);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.t f44351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b0 f44352b;

    public v(f0 f0Var) {
        this.f44351a = gm.t.I(f0Var.K(0));
        if (f0Var.size() == 2) {
            this.f44352b = b0.z(f0Var.K(1));
        }
    }

    public v(gm.t tVar, b0 b0Var) {
        this.f44351a = tVar;
        this.f44352b = b0Var;
    }

    public static v x(Object obj) {
        if (obj instanceof v) {
            return (v) obj;
        }
        if (obj != null) {
            return new v(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f44351a);
        b0 b0Var = this.f44352b;
        if (b0Var != null) {
            iVar.a(b0Var);
        }
        return new j2(iVar);
    }

    public b0 y() {
        return this.f44352b;
    }

    public gm.t z() {
        return this.f44351a;
    }
}
