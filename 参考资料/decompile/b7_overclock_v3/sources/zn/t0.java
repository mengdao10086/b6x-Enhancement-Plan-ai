package zn;

import gm.j2;
import java.util.Enumeration;
import java.util.Hashtable;

/* JADX INFO: loaded from: classes5.dex */
public class t0 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.f0 f58945a;

    public t0(gm.f0 f0Var) {
        this.f58945a = f0Var;
    }

    public t0(Hashtable hashtable) {
        this.f58945a = null;
        gm.i iVar = new gm.i(hashtable.size());
        Enumeration enumerationKeys = hashtable.keys();
        while (enumerationKeys.hasMoreElements()) {
            String str = (String) enumerationKeys.nextElement();
            String str2 = (String) hashtable.get(str);
            gm.i iVar2 = new gm.i(2);
            iVar2.a(new gm.y(str));
            iVar2.a(new gm.y(str2));
            iVar.a(new j2(iVar2));
        }
        this.f58945a = new j2(iVar);
    }

    public t0(n nVar, n nVar2) {
        this.f58945a = null;
        gm.i iVar = new gm.i(2);
        iVar.a(nVar);
        iVar.a(nVar2);
        this.f58945a = new j2(new j2(iVar));
    }

    public t0(n[] nVarArr, n[] nVarArr2) {
        this.f58945a = null;
        gm.i iVar = new gm.i(nVarArr.length);
        for (int i10 = 0; i10 != nVarArr.length; i10++) {
            gm.i iVar2 = new gm.i(2);
            iVar2.a(nVarArr[i10]);
            iVar2.a(nVarArr2[i10]);
            iVar.a(new j2(iVar2));
        }
        this.f58945a = new j2(iVar);
    }

    public static t0 x(Object obj) {
        if (obj instanceof t0) {
            return (t0) obj;
        }
        if (obj != null) {
            return new t0(gm.f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return this.f58945a;
    }
}
