package mk;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import kotlin.c2;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.c1;
import kotlin.collections.d1;
import kotlin.collections.s;
import kotlin.jvm.internal.f0;
import kotlin.q;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.m;
import kotlin.v0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
public final class a {
    @c2(markerClass = {q.class})
    @v0(version = "1.8")
    @k
    public static final <T> m<T> a(@k Optional<? extends T> optional) {
        f0.p(optional, "<this>");
        return optional.isPresent() ? SequencesKt__SequencesKt.q(optional.get()) : SequencesKt__SequencesKt.g();
    }

    @c2(markerClass = {q.class})
    @v0(version = "1.8")
    public static final <T> T b(@k Optional<? extends T> optional, T t10) {
        f0.p(optional, "<this>");
        return optional.isPresent() ? optional.get() : t10;
    }

    @c2(markerClass = {q.class})
    @v0(version = "1.8")
    public static final <T> T c(@k Optional<? extends T> optional, @k ik.a<? extends T> defaultValue) {
        f0.p(optional, "<this>");
        f0.p(defaultValue, "defaultValue");
        return optional.isPresent() ? optional.get() : defaultValue.o();
    }

    @c2(markerClass = {q.class})
    @v0(version = "1.8")
    @l
    public static final <T> T d(@k Optional<T> optional) {
        f0.p(optional, "<this>");
        return optional.orElse(null);
    }

    @c2(markerClass = {q.class})
    @v0(version = "1.8")
    @k
    public static final <T, C extends Collection<? super T>> C e(@k Optional<T> optional, @k C destination) {
        f0.p(optional, "<this>");
        f0.p(destination, "destination");
        if (optional.isPresent()) {
            T t10 = optional.get();
            f0.o(t10, "get()");
            destination.add(t10);
        }
        return destination;
    }

    @c2(markerClass = {q.class})
    @v0(version = "1.8")
    @k
    public static final <T> List<T> f(@k Optional<? extends T> optional) {
        f0.p(optional, "<this>");
        return optional.isPresent() ? s.k(optional.get()) : CollectionsKt__CollectionsKt.E();
    }

    @c2(markerClass = {q.class})
    @v0(version = "1.8")
    @k
    public static final <T> Set<T> g(@k Optional<? extends T> optional) {
        f0.p(optional, "<this>");
        return optional.isPresent() ? c1.f(optional.get()) : d1.k();
    }
}
