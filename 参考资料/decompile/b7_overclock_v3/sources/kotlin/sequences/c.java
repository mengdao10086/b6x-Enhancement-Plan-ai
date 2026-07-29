package kotlin.sequences;

import java.util.Iterator;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes5.dex */
public final class c<T, K> implements m<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final m<T> f38063a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final ik.l<T, K> f38064b;

    /* JADX WARN: Multi-variable type inference failed */
    public c(@yt.k m<? extends T> source, @yt.k ik.l<? super T, ? extends K> keySelector) {
        f0.p(source, "source");
        f0.p(keySelector, "keySelector");
        this.f38063a = source;
        this.f38064b = keySelector;
    }

    @Override // kotlin.sequences.m
    @yt.k
    public Iterator<T> iterator() {
        return new b(this.f38063a.iterator(), this.f38064b);
    }
}
