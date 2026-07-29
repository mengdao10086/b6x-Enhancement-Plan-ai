package uj;

import java.util.Comparator;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes5.dex */
public final class l<T> implements Comparator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final Comparator<T> f52158a;

    public l(@yt.k Comparator<T> comparator) {
        f0.p(comparator, "comparator");
        this.f52158a = comparator;
    }

    @yt.k
    public final Comparator<T> a() {
        return this.f52158a;
    }

    @Override // java.util.Comparator
    public int compare(T t10, T t11) {
        return this.f52158a.compare(t11, t10);
    }

    @Override // java.util.Comparator
    @yt.k
    public final Comparator<T> reversed() {
        return this.f52158a;
    }
}
