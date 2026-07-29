package lc;

import cc.z;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.upstream.k;
import g.p0;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f39564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<StreamKey> f39565b;

    public d(f fVar, List<StreamKey> list) {
        this.f39564a = fVar;
        this.f39565b = list;
    }

    @Override // lc.f
    public k.a<e> a(com.google.android.exoplayer2.source.hls.playlist.b bVar, @p0 com.google.android.exoplayer2.source.hls.playlist.c cVar) {
        return new z(this.f39564a.a(bVar, cVar), this.f39565b);
    }

    @Override // lc.f
    public k.a<e> b() {
        return new z(this.f39564a.b(), this.f39565b);
    }
}
