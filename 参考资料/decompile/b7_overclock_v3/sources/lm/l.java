package lm;

import gm.j2;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class l extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b0 f39925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.t f39926b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public v f39927c;

    public l(gm.f0 f0Var) {
        Enumeration enumerationL = f0Var.L();
        this.f39925a = b0.z(enumerationL.nextElement());
        while (enumerationL.hasMoreElements()) {
            Object objNextElement = enumerationL.nextElement();
            if (objNextElement instanceof gm.t) {
                this.f39926b = gm.t.I(objNextElement);
            } else {
                this.f39927c = v.y(objNextElement);
            }
        }
    }

    public l(b0 b0Var) {
        this(b0Var, null, null);
    }

    public l(b0 b0Var, gm.t tVar, v vVar) {
        if (b0Var == null) {
            throw new IllegalArgumentException("'pkiStatusInfo' cannot be null");
        }
        this.f39925a = b0Var;
        this.f39926b = tVar;
        this.f39927c = vVar;
    }

    public static l A(Object obj) {
        if (obj instanceof l) {
            return (l) obj;
        }
        if (obj != null) {
            return new l(gm.f0.J(obj));
        }
        return null;
    }

    public b0 B() {
        return this.f39925a;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(3);
        iVar.a(this.f39925a);
        x(iVar, this.f39926b);
        x(iVar, this.f39927c);
        return new j2(iVar);
    }

    public final void x(gm.i iVar, gm.h hVar) {
        if (hVar != null) {
            iVar.a(hVar);
        }
    }

    public gm.t y() {
        return this.f39926b;
    }

    public v z() {
        return this.f39927c;
    }
}
