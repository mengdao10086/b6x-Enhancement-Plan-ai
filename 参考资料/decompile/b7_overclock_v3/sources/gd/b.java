package gd;

import android.net.Uri;
import ed.z;
import g.p0;
import hd.u0;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements com.google.android.exoplayer2.upstream.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.a f29235b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f29236c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @p0
    public c f29237d;

    public b(byte[] bArr, com.google.android.exoplayer2.upstream.a aVar) {
        this.f29235b = aVar;
        this.f29236c = bArr;
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public long a(com.google.android.exoplayer2.upstream.b bVar) throws IOException {
        long jA = this.f29235b.a(bVar);
        long jA2 = d.a(bVar.f19100i);
        this.f29237d = new c(2, this.f29236c, jA2, bVar.f19098g + bVar.f19093b);
        return jA;
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public Map<String, List<String>> c() {
        return this.f29235b.c();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() throws IOException {
        this.f29237d = null;
        this.f29235b.close();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void d(z zVar) {
        hd.a.g(zVar);
        this.f29235b.d(zVar);
    }

    @Override // ed.h
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        if (i11 == 0) {
            return 0;
        }
        int i12 = this.f29235b.read(bArr, i10, i11);
        if (i12 == -1) {
            return -1;
        }
        ((c) u0.k(this.f29237d)).d(bArr, i10, i12);
        return i12;
    }

    @Override // com.google.android.exoplayer2.upstream.a
    @p0
    public Uri s() {
        return this.f29235b.s();
    }
}
