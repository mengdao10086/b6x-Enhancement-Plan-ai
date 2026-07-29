package lc;

import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.google.android.exoplayer2.upstream.k;
import g.p0;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements f {
    @Override // lc.f
    public k.a<e> a(com.google.android.exoplayer2.source.hls.playlist.b bVar, @p0 com.google.android.exoplayer2.source.hls.playlist.c cVar) {
        return new HlsPlaylistParser(bVar, cVar);
    }

    @Override // lc.f
    public k.a<e> b() {
        return new HlsPlaylistParser();
    }
}
