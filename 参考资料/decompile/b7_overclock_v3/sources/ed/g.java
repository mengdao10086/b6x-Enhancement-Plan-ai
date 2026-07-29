package ed;

import android.net.Uri;
import g.p0;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte[] f26902f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @p0
    public Uri f26903g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f26904h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f26905i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f26906j;

    public g(byte[] bArr) {
        super(false);
        hd.a.g(bArr);
        hd.a.a(bArr.length > 0);
        this.f26902f = bArr;
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public long a(com.google.android.exoplayer2.upstream.b bVar) throws IOException {
        this.f26903g = bVar.f19092a;
        w(bVar);
        long j10 = bVar.f19098g;
        int i10 = (int) j10;
        this.f26904h = i10;
        long length = bVar.f19099h;
        if (length == -1) {
            length = ((long) this.f26902f.length) - j10;
        }
        int i11 = (int) length;
        this.f26905i = i11;
        if (i11 > 0 && i10 + i11 <= this.f26902f.length) {
            this.f26906j = true;
            x(bVar);
            return this.f26905i;
        }
        throw new IOException("Unsatisfiable range: [" + this.f26904h + ", " + bVar.f19099h + "], length: " + this.f26902f.length);
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() {
        if (this.f26906j) {
            this.f26906j = false;
            v();
        }
        this.f26903g = null;
    }

    @Override // ed.h
    public int read(byte[] bArr, int i10, int i11) {
        if (i11 == 0) {
            return 0;
        }
        int i12 = this.f26905i;
        if (i12 == 0) {
            return -1;
        }
        int iMin = Math.min(i11, i12);
        System.arraycopy(this.f26902f, this.f26904h, bArr, i10, iMin);
        this.f26904h += iMin;
        this.f26905i -= iMin;
        u(iMin);
        return iMin;
    }

    @Override // com.google.android.exoplayer2.upstream.a
    @p0
    public Uri s() {
        return this.f26903g;
    }
}
