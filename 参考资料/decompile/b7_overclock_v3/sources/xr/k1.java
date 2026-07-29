package xr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class k1 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<e> f55956a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<e> f55957a = new ArrayList();

        public a a(e... eVarArr) {
            this.f55957a.addAll(Arrays.asList(eVarArr));
            return this;
        }

        public k1 b() {
            return new k1(this.f55957a);
        }
    }

    public k1(List<e> list) {
        this.f55956a = Collections.unmodifiableList(list);
    }

    public static a x() {
        return new a();
    }

    public static k1 z(Object obj) {
        if (obj instanceof k1) {
            return (k1) obj;
        }
        Iterator<gm.h> it2 = gm.f0.J(obj).iterator();
        ArrayList arrayList = new ArrayList();
        while (it2.hasNext()) {
            arrayList.add(e.c(it2.next()));
        }
        return new k1(arrayList);
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return i2.d(this.f55956a);
    }

    public List<e> y() {
        return this.f55956a;
    }
}
