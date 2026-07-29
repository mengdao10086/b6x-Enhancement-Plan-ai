package ed;

import android.net.Uri;
import g.p0;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class y implements com.google.android.exoplayer2.upstream.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.a f26972b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j f26973c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f26974d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f26975e;

    public y(com.google.android.exoplayer2.upstream.a aVar, j jVar) {
        this.f26972b = (com.google.android.exoplayer2.upstream.a) hd.a.g(aVar);
        this.f26973c = (j) hd.a.g(jVar);
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public long a(com.google.android.exoplayer2.upstream.b bVar) throws IOException {
        long jA = this.f26972b.a(bVar);
        this.f26975e = jA;
        if (jA == 0) {
            return 0L;
        }
        if (bVar.f19099h == -1 && jA != -1) {
            bVar = bVar.f(0L, jA);
        }
        this.f26974d = true;
        this.f26973c.a(bVar);
        return this.f26975e;
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public Map<String, List<String>> c() {
        return this.f26972b.c();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() throws IOException {
        try {
            this.f26972b.close();
        } finally {
            if (this.f26974d) {
                this.f26974d = false;
                this.f26973c.close();
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void d(z zVar) {
        hd.a.g(zVar);
        this.f26972b.d(zVar);
    }

    @Override // ed.h
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        if (this.f26975e == 0) {
            return -1;
        }
        int i12 = this.f26972b.read(bArr, i10, i11);
        if (i12 > 0) {
            this.f26973c.write(bArr, i10, i12);
            long j10 = this.f26975e;
            if (j10 != -1) {
                this.f26975e = j10 - ((long) i12);
            }
        }
        return i12;
    }

    @Override // com.google.android.exoplayer2.upstream.a
    @p0
    public Uri s() {
        return this.f26972b.s();
    }
}
