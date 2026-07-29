package xr;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class i1 extends gm.w implements j1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h1 f55927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<g2> f55928b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public h1 f55929a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<g2> f55930b;

        public i1 a() {
            return new i1(this.f55929a, this.f55930b);
        }

        public a b(h1 h1Var) {
            this.f55929a = h1Var;
            return this;
        }

        public a c(g2... g2VarArr) {
            this.f55930b.addAll(Arrays.asList(g2VarArr));
            return this;
        }

        public a d(List<g2> list) {
            this.f55930b = list;
            return this;
        }
    }

    public i1(h1 h1Var, List<g2> list) {
        this.f55927a = h1Var;
        this.f55928b = Collections.unmodifiableList(list);
    }

    public static i1 x(Object obj) {
        if (obj instanceof i1) {
            return (i1) obj;
        }
        gm.f0 f0VarJ = gm.f0.J(0);
        a aVar = new a();
        aVar.b(h1.z(f0VarJ.K(0)));
        Iterator<gm.h> it2 = gm.f0.J(f0VarJ.K(1)).iterator();
        while (it2.hasNext()) {
            aVar.c(g2.x(it2.next()));
        }
        return aVar.a();
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return i2.e(this.f55927a, i2.d(this.f55928b));
    }
}
