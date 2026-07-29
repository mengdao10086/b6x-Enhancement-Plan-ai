package r4;

import c4.g;
import g.n0;
import g.p0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a<?>> f47738a = new ArrayList();

    public static final class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class<T> f47739a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final g<T> f47740b;

        public a(@n0 Class<T> cls, @n0 g<T> gVar) {
            this.f47739a = cls;
            this.f47740b = gVar;
        }

        public boolean a(@n0 Class<?> cls) {
            return this.f47739a.isAssignableFrom(cls);
        }
    }

    public synchronized <Z> void a(@n0 Class<Z> cls, @n0 g<Z> gVar) {
        this.f47738a.add(new a<>(cls, gVar));
    }

    @p0
    public synchronized <Z> g<Z> b(@n0 Class<Z> cls) {
        int size = this.f47738a.size();
        for (int i10 = 0; i10 < size; i10++) {
            a<?> aVar = this.f47738a.get(i10);
            if (aVar.a(cls)) {
                return (g<Z>) aVar.f47740b;
            }
        }
        return null;
    }

    public synchronized <Z> void c(@n0 Class<Z> cls, @n0 g<Z> gVar) {
        this.f47738a.add(0, new a<>(cls, gVar));
    }
}
