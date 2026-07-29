package androidx.core.util;

import android.annotation.SuppressLint;
import android.util.Range;
import g.v0;
import qk.h;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"ClassVerificationFailure"})
public final class x {

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a<T> implements qk.h<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Range<T> f4779a;

        public a(Range<T> range) {
            this.f4779a = range;
        }

        /* JADX WARN: Incorrect return type in method signature: ()TT; */
        @Override // qk.h
        public Comparable a() {
            return this.f4779a.getLower();
        }

        /* JADX WARN: Incorrect types in method signature: (TT;)Z */
        @Override // qk.h
        public boolean contains(@yt.k Comparable comparable) {
            return h.a.a(this, comparable);
        }

        /* JADX WARN: Incorrect return type in method signature: ()TT; */
        @Override // qk.h
        public Comparable e() {
            return this.f4779a.getUpper();
        }

        @Override // qk.h
        public boolean isEmpty() {
            return h.a.b(this);
        }
    }

    @yt.k
    @v0(21)
    public static final <T extends Comparable<? super T>> Range<T> a(@yt.k Range<T> range, @yt.k Range<T> other) {
        kotlin.jvm.internal.f0.p(range, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        Range<T> rangeIntersect = range.intersect(other);
        kotlin.jvm.internal.f0.o(rangeIntersect, "intersect(other)");
        return rangeIntersect;
    }

    @yt.k
    @v0(21)
    public static final <T extends Comparable<? super T>> Range<T> b(@yt.k Range<T> range, @yt.k Range<T> other) {
        kotlin.jvm.internal.f0.p(range, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        Range<T> rangeExtend = range.extend(other);
        kotlin.jvm.internal.f0.o(rangeExtend, "extend(other)");
        return rangeExtend;
    }

    @yt.k
    @v0(21)
    public static final <T extends Comparable<? super T>> Range<T> c(@yt.k Range<T> range, @yt.k T value) {
        kotlin.jvm.internal.f0.p(range, "<this>");
        kotlin.jvm.internal.f0.p(value, "value");
        Range<T> rangeExtend = range.extend(value);
        kotlin.jvm.internal.f0.o(rangeExtend, "extend(value)");
        return rangeExtend;
    }

    @yt.k
    @v0(21)
    public static final <T extends Comparable<? super T>> Range<T> d(@yt.k T t10, @yt.k T that) {
        kotlin.jvm.internal.f0.p(t10, "<this>");
        kotlin.jvm.internal.f0.p(that, "that");
        return new Range<>(t10, that);
    }

    @yt.k
    @v0(21)
    public static final <T extends Comparable<? super T>> qk.h<T> e(@yt.k Range<T> range) {
        kotlin.jvm.internal.f0.p(range, "<this>");
        return new a(range);
    }

    @yt.k
    @v0(21)
    public static final <T extends Comparable<? super T>> Range<T> f(@yt.k qk.h<T> hVar) {
        kotlin.jvm.internal.f0.p(hVar, "<this>");
        return new Range<>(hVar.a(), hVar.e());
    }
}
