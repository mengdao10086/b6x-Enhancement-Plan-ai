package zn;

import gm.j2;
import java.math.BigInteger;
import java.util.Enumeration;
import java.util.Vector;

/* JADX INFO: loaded from: classes5.dex */
public class n0 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public u f58861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.f0 f58862b;

    public n0(gm.f0 f0Var) {
        if (f0Var.size() == 2) {
            this.f58861a = u.y(f0Var.K(0));
            this.f58862b = gm.f0.J(f0Var.K(1));
        } else {
            throw new IllegalArgumentException("Bad sequence size: " + f0Var.size());
        }
    }

    public n0(String str, gm.i iVar) {
        this(new u(str), iVar);
    }

    public n0(String str, Vector vector) {
        this(str, x(vector));
    }

    public n0(u uVar, gm.i iVar) {
        this.f58861a = uVar;
        this.f58862b = new j2(iVar);
    }

    public static gm.i x(Vector vector) {
        gm.t tVar;
        gm.i iVar = new gm.i(vector.size());
        Enumeration enumerationElements = vector.elements();
        while (enumerationElements.hasMoreElements()) {
            Object objNextElement = enumerationElements.nextElement();
            if (objNextElement instanceof BigInteger) {
                tVar = new gm.t((BigInteger) objNextElement);
            } else {
                if (!(objNextElement instanceof Integer)) {
                    throw new IllegalArgumentException();
                }
                tVar = new gm.t(((Integer) objNextElement).intValue());
            }
            iVar.a(tVar);
        }
        return iVar;
    }

    public static n0 y(Object obj) {
        if (obj instanceof n0) {
            return (n0) obj;
        }
        if (obj != null) {
            return new n0(gm.f0.J(obj));
        }
        return null;
    }

    public u A() {
        return this.f58861a;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f58861a);
        iVar.a(this.f58862b);
        return new j2(iVar);
    }

    public gm.t[] z() {
        gm.t[] tVarArr = new gm.t[this.f58862b.size()];
        for (int i10 = 0; i10 != this.f58862b.size(); i10++) {
            tVarArr[i10] = gm.t.I(this.f58862b.K(i10));
        }
        return tVarArr;
    }
}
