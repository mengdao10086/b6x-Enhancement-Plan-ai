package zn;

import gm.j2;
import gm.n2;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class q extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o f58904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public o f58905b;

    public q(gm.f0 f0Var) {
        if (f0Var.size() != 1 && f0Var.size() != 2) {
            throw new IllegalArgumentException("Bad sequence size: " + f0Var.size());
        }
        Enumeration enumerationL = f0Var.L();
        while (enumerationL.hasMoreElements()) {
            gm.n0 n0VarT = gm.n0.T(enumerationL.nextElement());
            if (n0VarT.q() == 0) {
                this.f58904a = o.y(n0VarT, true);
            } else {
                if (n0VarT.q() != 1) {
                    throw new IllegalArgumentException("Bad tag number: " + n0VarT.q());
                }
                this.f58905b = o.y(n0VarT, true);
            }
        }
    }

    public q(o oVar, o oVar2) {
        this.f58904a = oVar;
        this.f58905b = oVar2;
    }

    public static q y(Object obj) {
        if (obj == null || (obj instanceof q)) {
            return (q) obj;
        }
        if (obj instanceof gm.f0) {
            return new q((gm.f0) obj);
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(2);
        o oVar = this.f58904a;
        if (oVar != null) {
            iVar.a(new n2(0, oVar));
        }
        o oVar2 = this.f58905b;
        if (oVar2 != null) {
            iVar.a(new n2(1, oVar2));
        }
        return new j2(iVar);
    }

    public o x() {
        return this.f58904a;
    }

    public o z() {
        return this.f58905b;
    }
}
