package fd;

import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.CacheDataSink;
import ed.j;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public final class a implements j.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Cache f28034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f28035b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f28036c;

    public a(Cache cache, long j10) {
        this(cache, j10, CacheDataSink.f19134l);
    }

    @Override // ed.j.a
    public ed.j a() {
        return new CacheDataSink(this.f28034a, this.f28035b, this.f28036c);
    }

    public a(Cache cache, long j10, int i10) {
        this.f28034a = cache;
        this.f28035b = j10;
        this.f28036c = i10;
    }
}
