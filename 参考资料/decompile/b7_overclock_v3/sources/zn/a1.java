package zn;

import gm.j2;
import java.util.Enumeration;
import java.util.Vector;

/* JADX INFO: loaded from: classes5.dex */
public class a1 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Vector f58665a = new Vector();

    public a1(gm.f0 f0Var) {
        Enumeration enumerationL = f0Var.L();
        while (enumerationL.hasMoreElements()) {
            this.f58665a.addElement(e.A(gm.f0.J(enumerationL.nextElement())));
        }
    }

    public a1(Vector vector) {
        Enumeration enumerationElements = vector.elements();
        while (enumerationElements.hasMoreElements()) {
            this.f58665a.addElement(enumerationElements.nextElement());
        }
    }

    public static a1 y(Object obj) {
        if (obj instanceof a1) {
            return (a1) obj;
        }
        if (obj != null) {
            return new a1(gm.f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(this.f58665a.size());
        Enumeration enumerationElements = this.f58665a.elements();
        while (enumerationElements.hasMoreElements()) {
            iVar.a((e) enumerationElements.nextElement());
        }
        return new j2(iVar);
    }

    public Vector x() {
        return this.f58665a;
    }
}
