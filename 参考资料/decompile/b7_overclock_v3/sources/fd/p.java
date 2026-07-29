package fd;

import com.google.android.exoplayer2.upstream.cache.Cache;
import java.util.Comparator;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes3.dex */
public final class p implements com.google.android.exoplayer2.upstream.cache.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f28123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TreeSet<g> f28124b = new TreeSet<>(new Comparator() { // from class: fd.o
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return p.h((g) obj, (g) obj2);
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f28125c;

    public p(long j10) {
        this.f28123a = j10;
    }

    public static int h(g gVar, g gVar2) {
        long j10 = gVar.f28059f;
        long j11 = gVar2.f28059f;
        return j10 - j11 == 0 ? gVar.compareTo(gVar2) : j10 < j11 ? -1 : 1;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.c
    public void a(Cache cache, String str, long j10, long j11) {
        if (j11 != -1) {
            i(cache, j11);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.a
    public void b(Cache cache, g gVar) {
        this.f28124b.add(gVar);
        this.f28125c += gVar.f28056c;
        i(cache, 0L);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.a
    public void c(Cache cache, g gVar) {
        this.f28124b.remove(gVar);
        this.f28125c -= gVar.f28056c;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.c
    public void d() {
    }

    @Override // com.google.android.exoplayer2.upstream.cache.c
    public boolean e() {
        return true;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.a
    public void f(Cache cache, g gVar, g gVar2) {
        c(cache, gVar);
        b(cache, gVar2);
    }

    public final void i(Cache cache, long j10) {
        while (this.f28125c + j10 > this.f28123a && !this.f28124b.isEmpty()) {
            cache.c(this.f28124b.first());
        }
    }
}
