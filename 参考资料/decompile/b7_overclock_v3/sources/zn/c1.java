package zn;

import gm.j2;
import java.io.IOException;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class c1 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f58683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.d f58684b;

    public c1(gm.f0 f0Var) {
        if (f0Var.size() == 2) {
            Enumeration enumerationL = f0Var.L();
            this.f58683a = b.z(enumerationL.nextElement());
            this.f58684b = gm.u1.S(enumerationL.nextElement());
        } else {
            throw new IllegalArgumentException("Bad sequence size: " + f0Var.size());
        }
    }

    public c1(b bVar, gm.h hVar) throws IOException {
        this.f58684b = new gm.u1(hVar);
        this.f58683a = bVar;
    }

    public c1(b bVar, byte[] bArr) {
        this.f58684b = new gm.u1(bArr);
        this.f58683a = bVar;
    }

    public static c1 A(Object obj) {
        if (obj instanceof c1) {
            return (c1) obj;
        }
        if (obj != null) {
            return new c1(gm.f0.J(obj));
        }
        return null;
    }

    public static c1 z(gm.n0 n0Var, boolean z10) {
        return A(gm.f0.I(n0Var, z10));
    }

    public gm.c0 B() throws IOException {
        return gm.c0.D(this.f58684b.L());
    }

    public gm.d C() {
        return this.f58684b;
    }

    public gm.c0 D() throws IOException {
        return gm.c0.D(this.f58684b.L());
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f58683a);
        iVar.a(this.f58684b);
        return new j2(iVar);
    }

    public b x() {
        return this.f58683a;
    }

    public b y() {
        return this.f58683a;
    }
}
