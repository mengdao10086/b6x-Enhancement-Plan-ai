package kotlin.sequences;

import java.util.HashSet;
import java.util.Iterator;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes5.dex */
public final class b<T, K> extends kotlin.collections.a<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public final Iterator<T> f38060c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public final ik.l<T, K> f38061d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public final HashSet<K> f38062e;

    /* JADX WARN: Multi-variable type inference failed */
    public b(@yt.k Iterator<? extends T> source, @yt.k ik.l<? super T, ? extends K> keySelector) {
        f0.p(source, "source");
        f0.p(keySelector, "keySelector");
        this.f38060c = source;
        this.f38061d = keySelector;
        this.f38062e = new HashSet<>();
    }

    @Override // kotlin.collections.a
    public void a() {
        while (this.f38060c.hasNext()) {
            T next = this.f38060c.next();
            if (this.f38062e.add(this.f38061d.i(next))) {
                d(next);
                return;
            }
        }
        b();
    }
}
