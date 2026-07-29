package xr;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class r1 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<g1> f56021a;

    public r1(List<g1> list) {
        this.f56021a = Collections.unmodifiableList(list);
    }

    public static r1 x(Object obj) {
        return obj instanceof r1 ? (r1) obj : new r1(i2.a(g1.class, gm.f0.J(obj)));
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return i2.d(this.f56021a);
    }

    public List<g1> y() {
        return this.f56021a;
    }
}
