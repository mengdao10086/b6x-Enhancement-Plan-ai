package xr;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class j extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g0 f55933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<x> f55934b;

    public j(g0 g0Var, List<x> list) {
        this.f55933a = g0Var;
        this.f55934b = list;
    }

    public static j z(Object obj) {
        if (obj instanceof j) {
            return (j) obj;
        }
        Iterator<gm.h> it2 = gm.f0.J(obj).iterator();
        g0 g0VarV = g0.V(it2.next());
        ArrayList arrayList = new ArrayList();
        while (it2.hasNext()) {
            arrayList.add(x.z(it2.next()));
        }
        return new j(g0VarV, arrayList);
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return i2.e(this.f55933a, i2.d(this.f55934b));
    }

    public g0 x() {
        return this.f55933a;
    }

    public List<x> y() {
        return this.f55934b;
    }
}
