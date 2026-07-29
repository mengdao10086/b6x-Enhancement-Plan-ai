package ok;

import kotlin.jvm.internal.f0;
import kotlin.reflect.n;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
public final class b<T> implements f<Object, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public T f43410a;

    @Override // ok.f, ok.e
    @k
    public T a(@l Object obj, @k n<?> property) {
        f0.p(property, "property");
        T t10 = this.f43410a;
        if (t10 != null) {
            return t10;
        }
        throw new IllegalStateException("Property " + property.getName() + " should be initialized before get.");
    }

    @Override // ok.f
    public void b(@l Object obj, @k n<?> property, @k T value) {
        f0.p(property, "property");
        f0.p(value, "value");
        this.f43410a = value;
    }
}
