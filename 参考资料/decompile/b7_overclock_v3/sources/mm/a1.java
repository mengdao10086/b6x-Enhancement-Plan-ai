package mm;

import gm.c2;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.t f41276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.r f41277b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e0 f41278c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public gm.a0 f41279d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public v f41280e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public gm.g0 f41281f;

    public a1(gm.g0 g0Var) throws IOException {
        this.f41281f = g0Var;
        this.f41276a = gm.t.I(g0Var.readObject());
        gm.h object = g0Var.readObject();
        if (object instanceof gm.r) {
            this.f41277b = gm.r.I(object);
            object = g0Var.readObject();
        }
        if ((object instanceof e0) || (object instanceof gm.g0)) {
            this.f41278c = e0.z(object.b());
            object = g0Var.readObject();
        }
        if (object instanceof gm.a0) {
            this.f41279d = (gm.a0) object;
        }
    }

    public static a1 d(Object obj) throws IOException {
        if (obj instanceof gm.f0) {
            return new a1(((gm.f0) obj).M());
        }
        if (obj instanceof gm.g0) {
            return new a1((gm.g0) obj);
        }
        return null;
    }

    public gm.a0 a() {
        return this.f41279d;
    }

    public c2 b() {
        gm.r rVar = this.f41277b;
        return (rVar == null || (rVar instanceof c2)) ? (c2) rVar : new c2(this.f41277b.d(), false);
    }

    public gm.r c() {
        return this.f41277b;
    }

    public e0 e() {
        return this.f41278c;
    }

    public v f() throws IOException {
        if (this.f41280e == null) {
            this.f41280e = v.z(this.f41281f.readObject().b());
        }
        return this.f41280e;
    }

    public int g() {
        return this.f41276a.K().intValue();
    }
}
