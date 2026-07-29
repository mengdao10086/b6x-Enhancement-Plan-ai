package ed;

import android.net.Uri;
import android.util.Base64;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.common.base.Charsets;
import g.p0;
import hd.u0;
import java.io.IOException;
import java.net.URLDecoder;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends e {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f26907j = "data";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @p0
    public com.google.android.exoplayer2.upstream.b f26908f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @p0
    public byte[] f26909g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f26910h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f26911i;

    public i() {
        super(false);
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public long a(com.google.android.exoplayer2.upstream.b bVar) throws IOException {
        w(bVar);
        this.f26908f = bVar;
        this.f26911i = (int) bVar.f19098g;
        Uri uri = bVar.f19092a;
        String scheme = uri.getScheme();
        if (!"data".equals(scheme)) {
            throw new ParserException("Unsupported scheme: " + scheme);
        }
        String[] strArrN1 = u0.n1(uri.getSchemeSpecificPart(), ag.c.f654g);
        if (strArrN1.length != 2) {
            throw new ParserException("Unexpected URI format: " + uri);
        }
        String str = strArrN1[1];
        if (strArrN1[0].contains(h4.e.f30442c)) {
            try {
                this.f26909g = Base64.decode(str, 0);
            } catch (IllegalArgumentException e10) {
                throw new ParserException("Error while parsing Base64 encoded string: " + str, e10);
            }
        } else {
            this.f26909g = u0.w0(URLDecoder.decode(str, Charsets.US_ASCII.name()));
        }
        long j10 = bVar.f19099h;
        int length = j10 != -1 ? ((int) j10) + this.f26911i : this.f26909g.length;
        this.f26910h = length;
        if (length > this.f26909g.length || this.f26911i > length) {
            this.f26909g = null;
            throw new DataSourceException(0);
        }
        x(bVar);
        return ((long) this.f26910h) - ((long) this.f26911i);
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() {
        if (this.f26909g != null) {
            this.f26909g = null;
            v();
        }
        this.f26908f = null;
    }

    @Override // ed.h
    public int read(byte[] bArr, int i10, int i11) {
        if (i11 == 0) {
            return 0;
        }
        int i12 = this.f26910h - this.f26911i;
        if (i12 == 0) {
            return -1;
        }
        int iMin = Math.min(i11, i12);
        System.arraycopy(u0.k(this.f26909g), this.f26911i, bArr, i10, iMin);
        this.f26911i += iMin;
        u(iMin);
        return iMin;
    }

    @Override // com.google.android.exoplayer2.upstream.a
    @p0
    public Uri s() {
        com.google.android.exoplayer2.upstream.b bVar = this.f26908f;
        if (bVar != null) {
            return bVar.f19092a;
        }
        return null;
    }
}
