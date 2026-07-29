package xr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class p1 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<c1> f55999a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ArrayList<c1> f56000a = new ArrayList<>();

        public a a(c1... c1VarArr) {
            this.f56000a.addAll(Arrays.asList(c1VarArr));
            return this;
        }

        public p1 b() {
            return new p1(this.f56000a);
        }
    }

    public p1(List<c1> list) {
        this.f55999a = Collections.unmodifiableList(list);
    }

    public static a x() {
        return new a();
    }

    public static p1 y(Object obj) {
        if (obj instanceof p1) {
            return (p1) obj;
        }
        Enumeration enumerationL = gm.f0.J(obj).L();
        ArrayList arrayList = new ArrayList();
        while (enumerationL.hasMoreElements()) {
            arrayList.add(c1.y(enumerationL.nextElement()));
        }
        return new p1(arrayList);
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i();
        Iterator<c1> it2 = this.f55999a.iterator();
        while (it2.hasNext()) {
            iVar.a(it2.next());
        }
        return new gm.j2(iVar);
    }
}
