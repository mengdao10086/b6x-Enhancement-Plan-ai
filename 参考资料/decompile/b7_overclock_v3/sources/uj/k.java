package uj;

import java.util.Comparator;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes5.dex */
public final class k implements Comparator<Comparable<? super Object>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final k f52157a = new k();

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(@yt.k Comparable<Object> a10, @yt.k Comparable<Object> b10) {
        f0.p(a10, "a");
        f0.p(b10, "b");
        return b10.compareTo(a10);
    }

    @Override // java.util.Comparator
    @yt.k
    public final Comparator<Comparable<? super Object>> reversed() {
        return j.f52156a;
    }
}
