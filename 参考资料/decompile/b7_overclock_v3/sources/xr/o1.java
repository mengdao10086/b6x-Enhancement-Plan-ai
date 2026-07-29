package xr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class o1 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<b1> f55994a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<b1> f55995a = new ArrayList();

        public o1 a() {
            return new o1(this.f55995a);
        }

        public a b(b1... b1VarArr) {
            for (int i10 = 0; i10 != b1VarArr.length; i10++) {
                this.f55995a.add(b1VarArr[i10]);
            }
            return this;
        }

        public a c(List<b1> list) {
            this.f55995a = list;
            return this;
        }
    }

    public o1(List<b1> list) {
        this.f55994a = Collections.unmodifiableList(list);
    }

    public static a x() {
        return new a();
    }

    public static o1 y(Object obj) {
        if (obj instanceof o1) {
            return (o1) obj;
        }
        Enumeration enumerationL = gm.f0.J(obj).L();
        ArrayList arrayList = new ArrayList();
        while (enumerationL.hasMoreElements()) {
            arrayList.add(b1.y(enumerationL.nextElement()));
        }
        return new a().c(arrayList).a();
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i();
        Iterator<b1> it2 = this.f55994a.iterator();
        while (it2.hasNext()) {
            iVar.a(it2.next());
        }
        return new gm.j2(iVar);
    }

    public List<b1> z() {
        return this.f55994a;
    }
}
