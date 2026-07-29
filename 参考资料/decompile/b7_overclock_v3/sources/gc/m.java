package gc;

import com.google.android.exoplayer2.Format;
import g.p0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class m extends e {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f29216j;

    public m(com.google.android.exoplayer2.upstream.a aVar, com.google.android.exoplayer2.upstream.b bVar, Format format, int i10, @p0 Object obj, long j10, long j11, long j12) {
        super(aVar, bVar, 1, format, i10, obj, j10, j11);
        hd.a.g(format);
        this.f29216j = j12;
    }

    public long g() {
        long j10 = this.f29216j;
        if (j10 != -1) {
            return 1 + j10;
        }
        return -1L;
    }

    public abstract boolean h();
}
