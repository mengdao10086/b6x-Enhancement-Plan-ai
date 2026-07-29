package xr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class x0 extends gm.w implements j1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<f2> f56096a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<f2> f56097a = new ArrayList();

        public x0 a() {
            return new x0(this.f56097a);
        }

        public a b(List<f2> list) {
            this.f56097a = list;
            return this;
        }

        public a c(f2... f2VarArr) {
            this.f56097a.addAll(Arrays.asList(f2VarArr));
            return this;
        }
    }

    public x0(List<f2> list) {
        this.f56096a = Collections.unmodifiableList(list);
    }

    public static x0 x(Object obj) {
        if (obj instanceof x0) {
            return (x0) obj;
        }
        if (obj != null) {
            return new x0(i2.a(f2.class, gm.f0.J(obj)));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return i2.d(this.f56096a);
    }

    public List<f2> y() {
        return this.f56096a;
    }
}
