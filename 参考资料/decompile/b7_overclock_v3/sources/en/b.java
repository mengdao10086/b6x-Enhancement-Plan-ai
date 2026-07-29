package en;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.w;
import java.util.Enumeration;
import zn.b0;

/* JADX INFO: loaded from: classes5.dex */
public class b extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b0 f27038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f0 f27039b;

    public b(f0 f0Var) {
        gm.h hVarK;
        int size = f0Var.size();
        if (size == 1) {
            hVarK = f0Var.K(0);
        } else {
            if (size != 2) {
                throw new IllegalArgumentException("Bad sequence size: " + f0Var.size());
            }
            this.f27038a = b0.z(f0Var.K(0));
            hVarK = f0Var.K(1);
        }
        this.f27039b = f0.J(hVarK);
    }

    public b(b0 b0Var, f0 f0Var) {
        this.f27038a = b0Var;
        this.f27039b = f0Var;
    }

    public static b z(Object obj) {
        if (obj == null || (obj instanceof b)) {
            return (b) obj;
        }
        if (obj instanceof f0) {
            return new b((f0) obj);
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(2);
        b0 b0Var = this.f27038a;
        if (b0Var != null) {
            iVar.a(b0Var);
        }
        iVar.a(this.f27039b);
        return new j2(iVar);
    }

    public b0 x() {
        return this.f27038a;
    }

    public c[] y() {
        c[] cVarArr = new c[this.f27039b.size()];
        Enumeration enumerationL = this.f27039b.L();
        int i10 = 0;
        while (enumerationL.hasMoreElements()) {
            cVarArr[i10] = c.y(enumerationL.nextElement());
            i10++;
        }
        return cVarArr;
    }
}
