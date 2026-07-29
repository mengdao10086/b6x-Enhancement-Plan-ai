package un;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.w;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class d extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f0 f52296a;

    public d(f0 f0Var) throws IllegalArgumentException {
        gm.i iVar = new gm.i(f0Var.size());
        Enumeration enumerationL = f0Var.L();
        while (enumerationL.hasMoreElements()) {
            iVar.a(c.z(enumerationL.nextElement()));
        }
        this.f52296a = new j2(iVar);
    }

    public d(c cVar) {
        this.f52296a = new j2(cVar);
    }

    public d(c[] cVarArr) {
        this.f52296a = new j2(cVarArr);
    }

    public static d z(Object obj) {
        if (obj instanceof c) {
            return (d) obj;
        }
        if (obj != null) {
            return new d(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        return this.f52296a;
    }

    public int size() {
        return this.f52296a.size();
    }

    public d x(c cVar) {
        gm.i iVar = new gm.i(this.f52296a.size() + 1);
        for (int i10 = 0; i10 != this.f52296a.size(); i10++) {
            iVar.a(this.f52296a.K(i10));
        }
        iVar.a(cVar);
        return new d(new j2(iVar));
    }

    public c[] y() {
        int size = this.f52296a.size();
        c[] cVarArr = new c[size];
        for (int i10 = 0; i10 != size; i10++) {
            cVarArr[i10] = c.z(this.f52296a.K(i10));
        }
        return cVarArr;
    }
}
