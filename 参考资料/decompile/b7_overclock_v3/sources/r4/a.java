package r4;

import g.n0;
import g.p0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<C0551a<?>> f47724a = new ArrayList();

    /* JADX INFO: renamed from: r4.a$a, reason: collision with other inner class name */
    public static final class C0551a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class<T> f47725a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c4.a<T> f47726b;

        public C0551a(@n0 Class<T> cls, @n0 c4.a<T> aVar) {
            this.f47725a = cls;
            this.f47726b = aVar;
        }

        public boolean a(@n0 Class<?> cls) {
            return this.f47725a.isAssignableFrom(cls);
        }
    }

    public synchronized <T> void a(@n0 Class<T> cls, @n0 c4.a<T> aVar) {
        this.f47724a.add(new C0551a<>(cls, aVar));
    }

    @p0
    public synchronized <T> c4.a<T> b(@n0 Class<T> cls) {
        for (C0551a<?> c0551a : this.f47724a) {
            if (c0551a.a(cls)) {
                return (c4.a<T>) c0551a.f47726b;
            }
        }
        return null;
    }

    public synchronized <T> void c(@n0 Class<T> cls, @n0 c4.a<T> aVar) {
        this.f47724a.add(0, new C0551a<>(cls, aVar));
    }
}
