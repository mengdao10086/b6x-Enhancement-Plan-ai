package pn;

import gm.f0;
import gm.f2;
import gm.j2;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class j extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public zn.b f46767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.z f46768b;

    public j(f0 f0Var) {
        Enumeration enumerationL = f0Var.L();
        this.f46767a = zn.b.z(enumerationL.nextElement());
        this.f46768b = gm.z.I(enumerationL.nextElement());
    }

    public j(zn.b bVar, byte[] bArr) {
        this.f46767a = bVar;
        this.f46768b = new f2(bArr);
    }

    public static j z(Object obj) {
        if (obj instanceof j) {
            return (j) obj;
        }
        if (obj != null) {
            return new j(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f46767a);
        iVar.a(this.f46768b);
        return new j2(iVar);
    }

    public byte[] x() {
        return this.f46768b.J();
    }

    public zn.b y() {
        return this.f46767a;
    }
}
