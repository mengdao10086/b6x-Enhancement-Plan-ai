package xr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class l extends gm.w implements j1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f55965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<h1> f55966b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public m f55967a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<h1> f55968b = new ArrayList();

        public a a(h1 h1Var) {
            this.f55968b.add(h1Var);
            return this;
        }

        public l b() {
            return new l(this.f55967a, this.f55968b);
        }

        public a c(m mVar) {
            this.f55967a = mVar;
            return this;
        }

        public a d(List<h1> list) {
            this.f55968b.addAll(list);
            return this;
        }
    }

    public l(m mVar, List<h1> list) {
        this.f55965a = mVar;
        this.f55966b = Collections.unmodifiableList(list);
    }

    public static a x() {
        return new a();
    }

    public static l z(Object obj) {
        if (obj instanceof l) {
            return (l) obj;
        }
        gm.f0 f0VarJ = gm.f0.J(obj);
        return new l(m.z(f0VarJ.K(0)), i2.a(h1.class, gm.f0.J(f0VarJ.K(1))));
    }

    public List<h1> A() {
        return this.f55966b;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return i2.e(this.f55965a, i2.d(this.f55966b));
    }

    public m y() {
        return this.f55965a;
    }
}
