package ao;

import gm.c0;
import gm.c2;
import gm.f0;
import gm.i;
import gm.j2;
import gm.r;
import gm.w;
import gm.z;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class a extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h f8771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public zn.b f8772b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public z f8773c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public r f8774d;

    public a(h hVar, zn.b bVar, z zVar) {
        this.f8771a = hVar;
        this.f8772b = bVar;
        this.f8773c = zVar;
        this.f8774d = null;
    }

    public a(h hVar, zn.b bVar, z zVar, r rVar) {
        this.f8771a = hVar;
        this.f8772b = bVar;
        this.f8773c = zVar;
        this.f8774d = rVar;
    }

    public a(f0 f0Var) {
        Enumeration enumerationL = f0Var.L();
        this.f8771a = h.y(enumerationL.nextElement());
        this.f8772b = zn.b.z(enumerationL.nextElement());
        this.f8773c = z.I(enumerationL.nextElement());
        if (enumerationL.hasMoreElements()) {
            this.f8774d = r.I(enumerationL.nextElement());
        }
    }

    public static a z(Object obj) {
        if (obj instanceof a) {
            return (a) obj;
        }
        if (obj != null) {
            return new a(f0.J(obj));
        }
        return null;
    }

    public c2 A() {
        r rVar = this.f8774d;
        return (rVar == null || (rVar instanceof c2)) ? (c2) rVar : new c2(this.f8774d.d(), false);
    }

    public r B() {
        return this.f8774d;
    }

    public h C() {
        return this.f8771a;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        i iVar = new i(4);
        iVar.a(this.f8771a);
        iVar.a(this.f8772b);
        iVar.a(this.f8773c);
        r rVar = this.f8774d;
        if (rVar != null) {
            iVar.a(rVar);
        }
        return new j2(iVar);
    }

    public z x() {
        return this.f8773c;
    }

    public zn.b y() {
        return this.f8772b;
    }
}
