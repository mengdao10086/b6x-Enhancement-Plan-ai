package org.bouncycastle.est;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes5.dex */
public class d extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream f44784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f44785b = new byte[1024];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f44786c = new byte[768];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final OutputStream f44787d = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f44788e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f44789f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f44790g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f44791h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f44792i;

    public class a extends OutputStream {
        public a() {
        }

        @Override // java.io.OutputStream
        public void write(int i10) throws IOException {
            d dVar = d.this;
            byte[] bArr = dVar.f44786c;
            int i11 = dVar.f44790g;
            dVar.f44790g = i11 + 1;
            bArr[i11] = (byte) i10;
        }
    }

    public d(InputStream inputStream, Long l10) {
        this.f44784a = inputStream;
        this.f44788e = l10;
    }

    public int a() throws IOException {
        int i10;
        if (this.f44792i >= this.f44788e.longValue()) {
            return -1;
        }
        int i11 = 0;
        do {
            i10 = this.f44784a.read();
            if (i10 >= 33 || i10 == 13 || i10 == 10) {
                byte[] bArr = this.f44785b;
                if (i11 >= bArr.length) {
                    throw new IOException("Content Transfer Encoding, base64 line length > 1024");
                }
                bArr[i11] = (byte) i10;
                this.f44792i++;
                i11++;
            } else if (i10 >= 0) {
                this.f44792i++;
            }
            if (i10 <= -1 || i11 >= this.f44785b.length || i10 == 10) {
                break;
            }
        } while (this.f44792i < this.f44788e.longValue());
        if (i11 > 0) {
            try {
                jt.c.b(this.f44785b, 0, i11, this.f44787d);
            } catch (Exception e10) {
                throw new IOException("Decode Base64 Content-Transfer-Encoding: " + e10);
            }
        } else if (i10 == -1) {
            return -1;
        }
        return this.f44790g;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f44784a.close();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.f44789f == this.f44790g) {
            this.f44789f = 0;
            this.f44790g = 0;
            int iA = a();
            if (iA == -1) {
                return iA;
            }
        }
        byte[] bArr = this.f44786c;
        int i10 = this.f44789f;
        this.f44789f = i10 + 1;
        return bArr[i10] & 255;
    }
}
