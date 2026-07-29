package r4;

import g.n0;
import g.p0;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import v4.l;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<l> f47731a = new AtomicReference<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.collection.a<l, List<Class<?>>> f47732b = new androidx.collection.a<>();

    public void a() {
        synchronized (this.f47732b) {
            this.f47732b.clear();
        }
    }

    @p0
    public List<Class<?>> b(@n0 Class<?> cls, @n0 Class<?> cls2, @n0 Class<?> cls3) {
        List<Class<?>> list;
        l andSet = this.f47731a.getAndSet(null);
        if (andSet == null) {
            andSet = new l(cls, cls2, cls3);
        } else {
            andSet.b(cls, cls2, cls3);
        }
        synchronized (this.f47732b) {
            list = this.f47732b.get(andSet);
        }
        this.f47731a.set(andSet);
        return list;
    }

    public void c(@n0 Class<?> cls, @n0 Class<?> cls2, @n0 Class<?> cls3, @n0 List<Class<?>> list) {
        synchronized (this.f47732b) {
            this.f47732b.put(new l(cls, cls2, cls3), list);
        }
    }
}
