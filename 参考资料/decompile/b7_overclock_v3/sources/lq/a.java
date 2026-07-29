package lq;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import org.bouncycastle.crypto.io.InvalidCipherTextIOException;

/* JADX INFO: loaded from: classes7.dex */
public class a extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Cipher f40113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f40114b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f40115c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f40116d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f40117e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f40118f;

    public a(InputStream inputStream, Cipher cipher) {
        super(inputStream);
        this.f40114b = new byte[512];
        this.f40115c = false;
        this.f40113a = cipher;
    }

    public final byte[] a() throws InvalidCipherTextIOException {
        try {
            if (this.f40115c) {
                return null;
            }
            this.f40115c = true;
            return this.f40113a.doFinal();
        } catch (GeneralSecurityException e10) {
            throw new InvalidCipherTextIOException("Error finalising cipher", e10);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        return this.f40117e - this.f40118f;
    }

    public final int c() throws IOException {
        if (this.f40115c) {
            return -1;
        }
        this.f40118f = 0;
        this.f40117e = 0;
        while (true) {
            int i10 = this.f40117e;
            if (i10 != 0) {
                return i10;
            }
            int i11 = ((FilterInputStream) this).in.read(this.f40114b);
            if (i11 == -1) {
                byte[] bArrA = a();
                this.f40116d = bArrA;
                if (bArrA == null || bArrA.length == 0) {
                    return -1;
                }
                int length = bArrA.length;
                this.f40117e = length;
                return length;
            }
            byte[] bArrUpdate = this.f40113a.update(this.f40114b, 0, i11);
            this.f40116d = bArrUpdate;
            if (bArrUpdate != null) {
                this.f40117e = bArrUpdate.length;
            }
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            ((FilterInputStream) this).in.close();
            this.f40118f = 0;
            this.f40117e = 0;
        } finally {
            if (!this.f40115c) {
                a();
            }
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i10) {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (this.f40118f >= this.f40117e && c() < 0) {
            return -1;
        }
        byte[] bArr = this.f40116d;
        int i10 = this.f40118f;
        this.f40118f = i10 + 1;
        return bArr[i10] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        if (this.f40118f >= this.f40117e && c() < 0) {
            return -1;
        }
        int iMin = Math.min(i11, available());
        System.arraycopy(this.f40116d, this.f40118f, bArr, i10, iMin);
        this.f40118f += iMin;
        return iMin;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j10) throws IOException {
        if (j10 <= 0) {
            return 0L;
        }
        int iMin = (int) Math.min(j10, available());
        this.f40118f += iMin;
        return iMin;
    }
}
