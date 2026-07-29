package kotlin.sequences;

import java.util.Iterator;
import kotlin.c2;
import kotlin.h1;
import kotlin.jvm.internal.f0;
import kotlin.l1;
import kotlin.p1;
import kotlin.v0;
import kotlin.v1;

/* JADX INFO: loaded from: classes5.dex */
public class y {
    @hk.h(name = "sumOfUByte")
    @c2(markerClass = {kotlin.s.class})
    @v0(version = "1.5")
    public static final int a(@yt.k m<h1> mVar) {
        f0.p(mVar, "<this>");
        Iterator<h1> it2 = mVar.iterator();
        int iJ = 0;
        while (it2.hasNext()) {
            iJ = l1.j(iJ + l1.j(it2.next().j0() & 255));
        }
        return iJ;
    }

    @hk.h(name = "sumOfUInt")
    @c2(markerClass = {kotlin.s.class})
    @v0(version = "1.5")
    public static final int b(@yt.k m<l1> mVar) {
        f0.p(mVar, "<this>");
        Iterator<l1> it2 = mVar.iterator();
        int iJ = 0;
        while (it2.hasNext()) {
            iJ = l1.j(iJ + it2.next().l0());
        }
        return iJ;
    }

    @hk.h(name = "sumOfULong")
    @c2(markerClass = {kotlin.s.class})
    @v0(version = "1.5")
    public static final long c(@yt.k m<p1> mVar) {
        f0.p(mVar, "<this>");
        Iterator<p1> it2 = mVar.iterator();
        long j10 = 0;
        while (it2.hasNext()) {
            j10 = p1.j(j10 + it2.next().l0());
        }
        return j10;
    }

    @hk.h(name = "sumOfUShort")
    @c2(markerClass = {kotlin.s.class})
    @v0(version = "1.5")
    public static final int d(@yt.k m<v1> mVar) {
        f0.p(mVar, "<this>");
        Iterator<v1> it2 = mVar.iterator();
        int iJ = 0;
        while (it2.hasNext()) {
            iJ = l1.j(iJ + l1.j(it2.next().j0() & v1.f38215d));
        }
        return iJ;
    }
}
