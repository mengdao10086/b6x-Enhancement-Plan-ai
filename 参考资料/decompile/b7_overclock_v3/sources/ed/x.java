package ed;

import android.net.Uri;
import g.p0;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class x implements com.google.android.exoplayer2.upstream.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.a f26968b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f26969c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Uri f26970d = Uri.EMPTY;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<String, List<String>> f26971e = Collections.emptyMap();

    public x(com.google.android.exoplayer2.upstream.a aVar) {
        this.f26968b = (com.google.android.exoplayer2.upstream.a) hd.a.g(aVar);
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public long a(com.google.android.exoplayer2.upstream.b bVar) throws IOException {
        this.f26970d = bVar.f19092a;
        this.f26971e = Collections.emptyMap();
        long jA = this.f26968b.a(bVar);
        this.f26970d = (Uri) hd.a.g(s());
        this.f26971e = c();
        return jA;
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public Map<String, List<String>> c() {
        return this.f26968b.c();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() throws IOException {
        this.f26968b.close();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void d(z zVar) {
        hd.a.g(zVar);
        this.f26968b.d(zVar);
    }

    @Override // ed.h
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        int i12 = this.f26968b.read(bArr, i10, i11);
        if (i12 != -1) {
            this.f26969c += (long) i12;
        }
        return i12;
    }

    @Override // com.google.android.exoplayer2.upstream.a
    @p0
    public Uri s() {
        return this.f26968b.s();
    }

    public long u() {
        return this.f26969c;
    }

    public Uri v() {
        return this.f26970d;
    }

    public Map<String, List<String>> w() {
        return this.f26971e;
    }

    public void x() {
        this.f26969c = 0L;
    }
}
