package lo;

import java.util.Date;
import java.util.List;
import java.util.Set;
import nn.p;
import zn.y;
import zn.z;

/* JADX INFO: loaded from: classes5.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p f40102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public z f40103b;

    public n(p pVar) {
        this.f40102a = pVar;
        this.f40103b = pVar.C();
    }

    public c a() {
        return new c(this.f40102a.x());
    }

    public d b() {
        nn.c cVarY = this.f40102a.y();
        if (cVarY.q() == 0) {
            return null;
        }
        return cVarY.q() == 1 ? new m(nn.m.y(cVarY.z())) : new o();
    }

    public Set c() {
        return i.b(this.f40103b);
    }

    public y d(gm.y yVar) {
        z zVar = this.f40103b;
        if (zVar != null) {
            return zVar.z(yVar);
        }
        return null;
    }

    public List e() {
        return i.c(this.f40103b);
    }

    public Date f() {
        if (this.f40102a.B() == null) {
            return null;
        }
        return i.a(this.f40102a.B());
    }

    public Set g() {
        return i.d(this.f40103b);
    }

    public Date h() {
        return i.a(this.f40102a.D());
    }

    public boolean i() {
        return this.f40103b != null;
    }
}
