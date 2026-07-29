package pn;

import gm.f0;
import gm.j2;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class p extends gm.w implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m f46779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public k f46780b;

    public p(f0 f0Var) {
        Enumeration enumerationL = f0Var.L();
        f0 f0VarJ = f0.J(((gm.h) enumerationL.nextElement()).b());
        gm.h hVarK = f0VarJ.K(0);
        gm.y yVar = s.X3;
        if (hVarK.equals(yVar)) {
            this.f46779a = new m(yVar, q.x(f0VarJ.K(1)));
        } else {
            this.f46779a = m.y(f0VarJ);
        }
        this.f46780b = k.y(enumerationL.nextElement());
    }

    public p(m mVar, k kVar) {
        this.f46779a = mVar;
        this.f46780b = kVar;
    }

    public static p y(Object obj) {
        if (obj instanceof p) {
            return (p) obj;
        }
        if (obj != null) {
            return new p(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f46779a);
        iVar.a(this.f46780b);
        return new j2(iVar);
    }

    public k x() {
        return this.f46780b;
    }

    public m z() {
        return this.f46779a;
    }
}
