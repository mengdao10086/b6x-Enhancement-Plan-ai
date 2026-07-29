package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.upstream.cache.Cache;
import fd.g;
import g.p0;
import hd.t;
import hd.u0;
import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements Cache.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f19192f = "CachedRegionTracker";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f19193g = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f19194h = -2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Cache f19195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f19196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final hb.e f19197c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TreeSet<a> f19198d = new TreeSet<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f19199e = new a(0, 0);

    public static class a implements Comparable<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f19200a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f19201b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f19202c;

        public a(long j10, long j11) {
            this.f19200a = j10;
            this.f19201b = j11;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            return u0.r(this.f19200a, aVar.f19200a);
        }
    }

    public d(Cache cache, String str, hb.e eVar) {
        this.f19195a = cache;
        this.f19196b = str;
        this.f19197c = eVar;
        synchronized (this) {
            Iterator<g> itDescendingIterator = cache.p(str, this).descendingIterator();
            while (itDescendingIterator.hasNext()) {
                h(itDescendingIterator.next());
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.a
    public synchronized void b(Cache cache, g gVar) {
        h(gVar);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.a
    public synchronized void c(Cache cache, g gVar) {
        long j10 = gVar.f28055b;
        a aVar = new a(j10, gVar.f28056c + j10);
        a aVarFloor = this.f19198d.floor(aVar);
        if (aVarFloor == null) {
            t.d(f19192f, "Removed a span we were not aware of");
            return;
        }
        this.f19198d.remove(aVarFloor);
        long j11 = aVarFloor.f19200a;
        long j12 = aVar.f19200a;
        if (j11 < j12) {
            a aVar2 = new a(j11, j12);
            int iBinarySearch = Arrays.binarySearch(this.f19197c.f30828f, aVar2.f19201b);
            if (iBinarySearch < 0) {
                iBinarySearch = (-iBinarySearch) - 2;
            }
            aVar2.f19202c = iBinarySearch;
            this.f19198d.add(aVar2);
        }
        long j13 = aVarFloor.f19201b;
        long j14 = aVar.f19201b;
        if (j13 > j14) {
            a aVar3 = new a(j14 + 1, j13);
            aVar3.f19202c = aVarFloor.f19202c;
            this.f19198d.add(aVar3);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.a
    public void f(Cache cache, g gVar, g gVar2) {
    }

    public synchronized int g(long j10) {
        int i10;
        a aVar = this.f19199e;
        aVar.f19200a = j10;
        a aVarFloor = this.f19198d.floor(aVar);
        if (aVarFloor != null) {
            long j11 = aVarFloor.f19201b;
            if (j10 <= j11 && (i10 = aVarFloor.f19202c) != -1) {
                hb.e eVar = this.f19197c;
                if (i10 == eVar.f30826d - 1) {
                    if (j11 == eVar.f30828f[i10] + ((long) eVar.f30827e[i10])) {
                        return -2;
                    }
                }
                return (int) ((eVar.f30830h[i10] + ((eVar.f30829g[i10] * (j11 - eVar.f30828f[i10])) / ((long) eVar.f30827e[i10]))) / 1000);
            }
        }
        return -1;
    }

    public final void h(g gVar) {
        long j10 = gVar.f28055b;
        a aVar = new a(j10, gVar.f28056c + j10);
        a aVarFloor = this.f19198d.floor(aVar);
        a aVarCeiling = this.f19198d.ceiling(aVar);
        boolean zI = i(aVarFloor, aVar);
        if (i(aVar, aVarCeiling)) {
            if (zI) {
                aVarFloor.f19201b = aVarCeiling.f19201b;
                aVarFloor.f19202c = aVarCeiling.f19202c;
            } else {
                aVar.f19201b = aVarCeiling.f19201b;
                aVar.f19202c = aVarCeiling.f19202c;
                this.f19198d.add(aVar);
            }
            this.f19198d.remove(aVarCeiling);
            return;
        }
        if (!zI) {
            int iBinarySearch = Arrays.binarySearch(this.f19197c.f30828f, aVar.f19201b);
            if (iBinarySearch < 0) {
                iBinarySearch = (-iBinarySearch) - 2;
            }
            aVar.f19202c = iBinarySearch;
            this.f19198d.add(aVar);
            return;
        }
        aVarFloor.f19201b = aVar.f19201b;
        int i10 = aVarFloor.f19202c;
        while (true) {
            hb.e eVar = this.f19197c;
            if (i10 >= eVar.f30826d - 1) {
                break;
            }
            int i11 = i10 + 1;
            if (eVar.f30828f[i11] > aVarFloor.f19201b) {
                break;
            } else {
                i10 = i11;
            }
        }
        aVarFloor.f19202c = i10;
    }

    public final boolean i(@p0 a aVar, @p0 a aVar2) {
        return (aVar == null || aVar2 == null || aVar.f19201b != aVar2.f19200a) ? false : true;
    }

    public void j() {
        this.f19195a.r(this.f19196b, this);
    }
}
