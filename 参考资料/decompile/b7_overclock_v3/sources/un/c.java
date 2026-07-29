package un;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.w;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class c extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f0 f52295a;

    public c(f0 f0Var) {
        gm.i iVar = new gm.i(f0Var.size());
        Enumeration enumerationL = f0Var.L();
        while (enumerationL.hasMoreElements()) {
            iVar.a(b.z(enumerationL.nextElement()));
        }
        this.f52295a = new j2(iVar);
    }

    public c(b bVar) {
        this.f52295a = new j2(bVar);
    }

    public c(b[] bVarArr) {
        this.f52295a = new j2(bVarArr);
    }

    public static c z(Object obj) {
        if (obj instanceof c) {
            return (c) obj;
        }
        if (obj != null) {
            return new c(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        return this.f52295a;
    }

    public c x(b bVar) {
        gm.i iVar = new gm.i(this.f52295a.size() + 1);
        for (int i10 = 0; i10 != this.f52295a.size(); i10++) {
            iVar.a(this.f52295a.K(i10));
        }
        iVar.a(bVar);
        return new c(new j2(iVar));
    }

    public b[] y() {
        int size = this.f52295a.size();
        b[] bVarArr = new b[size];
        for (int i10 = 0; i10 != size; i10++) {
            bVarArr[i10] = b.z(this.f52295a.K(i10));
        }
        return bVarArr;
    }
}
