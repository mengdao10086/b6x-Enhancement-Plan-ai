package r4;

import com.bumptech.glide.load.engine.g;
import com.bumptech.glide.load.engine.q;
import g.p0;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;
import v4.l;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final q<?, ?, ?> f47728c = new q<>(Object.class, Object.class, Object.class, Collections.singletonList(new g(Object.class, Object.class, Object.class, Collections.emptyList(), new o4.g(), null)), null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.collection.a<l, q<?, ?, ?>> f47729a = new androidx.collection.a<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference<l> f47730b = new AtomicReference<>();

    @p0
    public <Data, TResource, Transcode> q<Data, TResource, Transcode> a(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        q<Data, TResource, Transcode> qVar;
        l lVarB = b(cls, cls2, cls3);
        synchronized (this.f47729a) {
            qVar = (q) this.f47729a.get(lVarB);
        }
        this.f47730b.set(lVarB);
        return qVar;
    }

    public final l b(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        l andSet = this.f47730b.getAndSet(null);
        if (andSet == null) {
            andSet = new l();
        }
        andSet.b(cls, cls2, cls3);
        return andSet;
    }

    public boolean c(@p0 q<?, ?, ?> qVar) {
        return f47728c.equals(qVar);
    }

    public void d(Class<?> cls, Class<?> cls2, Class<?> cls3, @p0 q<?, ?, ?> qVar) {
        synchronized (this.f47729a) {
            androidx.collection.a<l, q<?, ?, ?>> aVar = this.f47729a;
            l lVar = new l(cls, cls2, cls3);
            if (qVar == null) {
                qVar = f47728c;
            }
            aVar.put(lVar, qVar);
        }
    }
}
