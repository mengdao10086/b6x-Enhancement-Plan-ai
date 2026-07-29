package zr;

import gm.f0;
import gm.j2;
import gm.n0;
import gm.n2;
import gm.p2;
import gm.r0;
import gm.y;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f0 f59645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f0 f59646b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f59647c;

    public a(String str, Set<y> set) {
        this(str, set, null);
    }

    public a(String str, Set<y> set, Set<y> set2) {
        this.f59647c = str;
        this.f59645a = e(set);
        this.f59646b = e(set2);
    }

    public a(Set<y> set) {
        this(null, set, null);
    }

    public a(byte[] bArr) {
        Enumeration enumerationL = f0.J(bArr).L();
        while (enumerationL.hasMoreElements()) {
            gm.h hVar = (gm.h) enumerationL.nextElement();
            if (hVar instanceof f0) {
                this.f59645a = f0.J(hVar);
            } else if (hVar instanceof n0) {
                this.f59646b = f0.I((n0) hVar, false);
            } else if (hVar instanceof r0) {
                this.f59647c = r0.I(hVar).d();
            }
        }
    }

    public String a() {
        return this.f59647c;
    }

    public Set<y> b() {
        return f(this.f59646b);
    }

    public Set<y> c() {
        return f(this.f59645a);
    }

    public f0 d() {
        gm.i iVar = new gm.i();
        f0 f0Var = this.f59645a;
        if (f0Var != null) {
            iVar.a(f0Var);
        }
        f0 f0Var2 = this.f59646b;
        if (f0Var2 != null) {
            iVar.a(new n2(false, 0, (gm.h) f0Var2));
        }
        if (this.f59647c != null) {
            iVar.a(new p2(this.f59647c));
        }
        return new j2(iVar);
    }

    public final f0 e(Set<y> set) {
        if (set == null || set.isEmpty()) {
            return null;
        }
        gm.i iVar = new gm.i();
        Iterator<y> it2 = set.iterator();
        while (it2.hasNext()) {
            iVar.a(it2.next());
        }
        return new j2(iVar);
    }

    public final Set<y> f(f0 f0Var) {
        if (f0Var == null) {
            return Collections.EMPTY_SET;
        }
        HashSet hashSet = new HashSet(f0Var.size());
        Enumeration enumerationL = f0Var.L();
        while (enumerationL.hasMoreElements()) {
            hashSet.add(y.N(enumerationL.nextElement()));
        }
        return hashSet;
    }
}
