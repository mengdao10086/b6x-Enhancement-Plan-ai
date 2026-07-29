package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import com.google.android.exoplayer2.source.hls.g;
import com.google.android.exoplayer2.source.m;
import com.google.android.exoplayer2.upstream.j;
import g.p0;
import java.io.IOException;
import lc.f;

/* JADX INFO: loaded from: classes3.dex */
public interface HlsPlaylistTracker {

    public static final class PlaylistResetException extends IOException {
        public final Uri url;

        public PlaylistResetException(Uri uri) {
            this.url = uri;
        }
    }

    public static final class PlaylistStuckException extends IOException {
        public final Uri url;

        public PlaylistStuckException(Uri uri) {
            this.url = uri;
        }
    }

    public interface a {
        HlsPlaylistTracker a(g gVar, j jVar, f fVar);
    }

    public interface b {
        void d();

        boolean h(Uri uri, long j10);
    }

    public interface c {
        void c(com.google.android.exoplayer2.source.hls.playlist.c cVar);
    }

    boolean a(Uri uri);

    void b(b bVar);

    void c(Uri uri) throws IOException;

    long d();

    @p0
    com.google.android.exoplayer2.source.hls.playlist.b e();

    void f(Uri uri, m.a aVar, c cVar);

    void g() throws IOException;

    void h(Uri uri);

    boolean isLive();

    void j(b bVar);

    @p0
    com.google.android.exoplayer2.source.hls.playlist.c k(Uri uri, boolean z10);

    void stop();
}
