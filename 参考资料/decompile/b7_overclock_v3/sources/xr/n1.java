package xr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class n1 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a1> f55983a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<a1> f55984a = new ArrayList();

        public a a(a1... a1VarArr) {
            this.f55984a.addAll(Arrays.asList(a1VarArr));
            return this;
        }

        public n1 b() {
            return new n1(this.f55984a);
        }

        public a c(List<a1> list) {
            this.f55984a.addAll(list);
            return this;
        }
    }

    public n1(List<a1> list) {
        this.f55983a = Collections.unmodifiableList(list);
    }

    public static a x() {
        return new a();
    }

    public static n1 y(Object obj) {
        if (obj instanceof n1) {
            return (n1) obj;
        }
        gm.f0 f0VarJ = gm.f0.J(obj);
        ArrayList arrayList = new ArrayList();
        Enumeration enumerationL = f0VarJ.L();
        while (enumerationL.hasMoreElements()) {
            arrayList.add(a1.A(enumerationL.nextElement()));
        }
        return new a().c(arrayList).b();
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return new gm.j2((gm.h[]) this.f55983a.toArray(new a1[0]));
    }
}
