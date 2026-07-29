package p1;

import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import p1.a;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends a {
    /* JADX WARN: Multi-variable type inference failed */
    public e() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public e(@k a initialExtras) {
        f0.p(initialExtras, "initialExtras");
        b().putAll(initialExtras.b());
    }

    @Override // p1.a
    @l
    public <T> T a(@k a.b<T> key) {
        f0.p(key, "key");
        return (T) b().get(key);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> void c(@k a.b<T> key, T t10) {
        f0.p(key, "key");
        b().put(key, t10);
    }

    public /* synthetic */ e(a aVar, int i10, u uVar) {
        this((i10 & 1) != 0 ? a.C0519a.f46302b : aVar);
    }
}
