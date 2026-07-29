package xr;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class l1 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<j0> f55973a;

    public l1(List<j0> list) {
        this.f55973a = Collections.unmodifiableList(list);
    }

    public static l1 y(Object obj) {
        return obj instanceof l1 ? (l1) obj : new l1(i2.a(j0.class, gm.f0.J(obj)));
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return new gm.j2((gm.h[]) this.f55973a.toArray(new gm.h[0]));
    }

    public List<j0> x() {
        return this.f55973a;
    }
}
