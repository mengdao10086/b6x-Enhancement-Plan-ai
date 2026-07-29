package kotlin.sequences;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes5.dex */
public final class a<T> implements m<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final AtomicReference<m<T>> f38059a;

    public a(@yt.k m<? extends T> sequence) {
        f0.p(sequence, "sequence");
        this.f38059a = new AtomicReference<>(sequence);
    }

    @Override // kotlin.sequences.m
    @yt.k
    public Iterator<T> iterator() {
        m<T> andSet = this.f38059a.getAndSet(null);
        if (andSet != null) {
            return andSet.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
