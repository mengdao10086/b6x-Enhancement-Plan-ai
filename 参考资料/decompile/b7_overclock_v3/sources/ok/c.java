package ok;

import kotlin.jvm.internal.f0;
import kotlin.reflect.n;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
public abstract class c<V> implements f<Object, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public V f43411a;

    public c(V v10) {
        this.f43411a = v10;
    }

    @Override // ok.f, ok.e
    public V a(@l Object obj, @k n<?> property) {
        f0.p(property, "property");
        return this.f43411a;
    }

    @Override // ok.f
    public void b(@l Object obj, @k n<?> property, V v10) {
        f0.p(property, "property");
        V v11 = this.f43411a;
        if (d(property, v11, v10)) {
            this.f43411a = v10;
            c(property, v11, v10);
        }
    }

    public void c(@k n<?> property, V v10, V v11) {
        f0.p(property, "property");
    }

    public boolean d(@k n<?> property, V v10, V v11) {
        f0.p(property, "property");
        return true;
    }
}
