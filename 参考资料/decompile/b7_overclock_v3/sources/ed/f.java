package ed;

import g.p0;
import hd.u0;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ByteArrayOutputStream f26901a;

    @Override // ed.j
    public void a(com.google.android.exoplayer2.upstream.b bVar) {
        long j10 = bVar.f19099h;
        if (j10 == -1) {
            this.f26901a = new ByteArrayOutputStream();
        } else {
            hd.a.a(j10 <= 2147483647L);
            this.f26901a = new ByteArrayOutputStream((int) bVar.f19099h);
        }
    }

    @p0
    public byte[] b() {
        ByteArrayOutputStream byteArrayOutputStream = this.f26901a;
        if (byteArrayOutputStream == null) {
            return null;
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override // ed.j
    public void close() throws IOException {
        ((ByteArrayOutputStream) u0.k(this.f26901a)).close();
    }

    @Override // ed.j
    public void write(byte[] bArr, int i10, int i11) {
        ((ByteArrayOutputStream) u0.k(this.f26901a)).write(bArr, i10, i11);
    }
}
