package xr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class q1 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<f1> f56010a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<f1> f56011a;

        public a a(f1... f1VarArr) {
            if (this.f56011a == null) {
                this.f56011a = new ArrayList();
            }
            this.f56011a.addAll(Arrays.asList(f1VarArr));
            return this;
        }

        public q1 b() {
            return new q1(this.f56011a);
        }

        public a c(List<f1> list) {
            this.f56011a = list;
            return this;
        }
    }

    public q1(List<f1> list) {
        this.f56010a = Collections.unmodifiableList(list);
    }

    public static q1 x(Object obj) {
        if (obj instanceof q1) {
            return (q1) obj;
        }
        Enumeration enumerationL = gm.f0.J(obj).L();
        ArrayList arrayList = new ArrayList();
        while (enumerationL.hasMoreElements()) {
            arrayList.add(f1.a(enumerationL.nextElement()));
        }
        return new a().c(arrayList).b();
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return new gm.j2(new gm.i());
    }

    public List<f1> y() {
        return this.f56010a;
    }
}
