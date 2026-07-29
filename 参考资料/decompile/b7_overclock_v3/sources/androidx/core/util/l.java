package androidx.core.util;

import android.annotation.SuppressLint;
import android.util.Pair;

/* JADX INFO: loaded from: classes2.dex */
public final class l {
    @SuppressLint({"UnknownNullness"})
    public static final <F, S> F a(@yt.k Pair<F, S> pair) {
        kotlin.jvm.internal.f0.p(pair, "<this>");
        return (F) pair.first;
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> F b(@yt.k k<F, S> kVar) {
        kotlin.jvm.internal.f0.p(kVar, "<this>");
        return kVar.f4741a;
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> S c(@yt.k Pair<F, S> pair) {
        kotlin.jvm.internal.f0.p(pair, "<this>");
        return (S) pair.second;
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> S d(@yt.k k<F, S> kVar) {
        kotlin.jvm.internal.f0.p(kVar, "<this>");
        return kVar.f4742b;
    }

    @yt.k
    public static final <F, S> Pair<F, S> e(@yt.k kotlin.Pair<? extends F, ? extends S> pair) {
        kotlin.jvm.internal.f0.p(pair, "<this>");
        return new Pair<>(pair.f(), pair.h());
    }

    @yt.k
    public static final <F, S> k<F, S> f(@yt.k kotlin.Pair<? extends F, ? extends S> pair) {
        kotlin.jvm.internal.f0.p(pair, "<this>");
        return new k<>(pair.f(), pair.h());
    }

    @yt.k
    public static final <F, S> kotlin.Pair<F, S> g(@yt.k Pair<F, S> pair) {
        kotlin.jvm.internal.f0.p(pair, "<this>");
        return new kotlin.Pair<>(pair.first, pair.second);
    }

    @yt.k
    public static final <F, S> kotlin.Pair<F, S> h(@yt.k k<F, S> kVar) {
        kotlin.jvm.internal.f0.p(kVar, "<this>");
        return new kotlin.Pair<>(kVar.f4741a, kVar.f4742b);
    }
}
