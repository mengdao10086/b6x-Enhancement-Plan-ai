package io.reactivex.internal.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class o<T> implements dj.o<List<T>, List<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Comparator<? super T> f35271a;

    public o(Comparator<? super T> comparator) {
        this.f35271a = comparator;
    }

    @Override // dj.o
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public List<T> apply(List<T> list) throws Exception {
        Collections.sort(list, this.f35271a);
        return list;
    }
}
