package ed;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.a f26912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.b f26913b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f26917f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f26915d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f26916e = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f26914c = new byte[1];

    public l(com.google.android.exoplayer2.upstream.a aVar, com.google.android.exoplayer2.upstream.b bVar) {
        this.f26912a = aVar;
        this.f26913b = bVar;
    }

    public long a() {
        return this.f26917f;
    }

    public final void c() throws IOException {
        if (this.f26915d) {
            return;
        }
        this.f26912a.a(this.f26913b);
        this.f26915d = true;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f26916e) {
            return;
        }
        this.f26912a.close();
        this.f26916e = true;
    }

    public void d() throws IOException {
        c();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.f26914c) == -1) {
            return -1;
        }
        return this.f26914c[0] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        hd.a.i(!this.f26916e);
        c();
        int i12 = this.f26912a.read(bArr, i10, i11);
        if (i12 == -1) {
            return -1;
        }
        this.f26917f += (long) i12;
        return i12;
    }
}
