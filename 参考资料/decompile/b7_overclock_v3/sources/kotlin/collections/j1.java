package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import kotlin.c2;
import kotlin.l1;
import kotlin.m1;
import kotlin.p1;
import kotlin.q1;
import kotlin.v1;
import kotlin.w1;

/* JADX INFO: loaded from: classes5.dex */
public class j1 {
    @hk.h(name = "sumOfUByte")
    @c2(markerClass = {kotlin.s.class})
    @kotlin.v0(version = "1.5")
    public static final int a(@yt.k Iterable<kotlin.h1> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        Iterator<kotlin.h1> it2 = iterable.iterator();
        int iJ = 0;
        while (it2.hasNext()) {
            iJ = l1.j(iJ + l1.j(it2.next().j0() & 255));
        }
        return iJ;
    }

    @hk.h(name = "sumOfUInt")
    @c2(markerClass = {kotlin.s.class})
    @kotlin.v0(version = "1.5")
    public static final int b(@yt.k Iterable<l1> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        Iterator<l1> it2 = iterable.iterator();
        int iJ = 0;
        while (it2.hasNext()) {
            iJ = l1.j(iJ + it2.next().l0());
        }
        return iJ;
    }

    @hk.h(name = "sumOfULong")
    @c2(markerClass = {kotlin.s.class})
    @kotlin.v0(version = "1.5")
    public static final long c(@yt.k Iterable<p1> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        Iterator<p1> it2 = iterable.iterator();
        long j10 = 0;
        while (it2.hasNext()) {
            j10 = p1.j(j10 + it2.next().l0());
        }
        return j10;
    }

    @hk.h(name = "sumOfUShort")
    @c2(markerClass = {kotlin.s.class})
    @kotlin.v0(version = "1.5")
    public static final int d(@yt.k Iterable<v1> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        Iterator<v1> it2 = iterable.iterator();
        int iJ = 0;
        while (it2.hasNext()) {
            iJ = l1.j(iJ + l1.j(it2.next().j0() & v1.f38215d));
        }
        return iJ;
    }

    @kotlin.s
    @kotlin.v0(version = "1.3")
    @yt.k
    public static final byte[] e(@yt.k Collection<kotlin.h1> collection) {
        kotlin.jvm.internal.f0.p(collection, "<this>");
        byte[] bArrD = kotlin.i1.d(collection.size());
        Iterator<kotlin.h1> it2 = collection.iterator();
        int i10 = 0;
        while (it2.hasNext()) {
            kotlin.i1.w(bArrD, i10, it2.next().j0());
            i10++;
        }
        return bArrD;
    }

    @kotlin.s
    @kotlin.v0(version = "1.3")
    @yt.k
    public static final int[] f(@yt.k Collection<l1> collection) {
        kotlin.jvm.internal.f0.p(collection, "<this>");
        int[] iArrD = m1.d(collection.size());
        Iterator<l1> it2 = collection.iterator();
        int i10 = 0;
        while (it2.hasNext()) {
            m1.w(iArrD, i10, it2.next().l0());
            i10++;
        }
        return iArrD;
    }

    @kotlin.s
    @kotlin.v0(version = "1.3")
    @yt.k
    public static final long[] g(@yt.k Collection<p1> collection) {
        kotlin.jvm.internal.f0.p(collection, "<this>");
        long[] jArrD = q1.d(collection.size());
        Iterator<p1> it2 = collection.iterator();
        int i10 = 0;
        while (it2.hasNext()) {
            q1.w(jArrD, i10, it2.next().l0());
            i10++;
        }
        return jArrD;
    }

    @kotlin.s
    @kotlin.v0(version = "1.3")
    @yt.k
    public static final short[] h(@yt.k Collection<v1> collection) {
        kotlin.jvm.internal.f0.p(collection, "<this>");
        short[] sArrD = w1.d(collection.size());
        Iterator<v1> it2 = collection.iterator();
        int i10 = 0;
        while (it2.hasNext()) {
            w1.w(sArrD, i10, it2.next().j0());
            i10++;
        }
        return sArrD;
    }
}
