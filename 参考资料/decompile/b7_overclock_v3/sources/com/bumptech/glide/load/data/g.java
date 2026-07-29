package com.bumptech.glide.load.data;

import g.n0;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends FilterInputStream {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f12192c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final byte[] f12193d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f12194e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f12195f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte f12196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12197b;

    static {
        byte[] bArr = {-1, -31, 0, 28, 69, tc.a.f51065w, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};
        f12193d = bArr;
        int length = bArr.length;
        f12194e = length;
        f12195f = length + 2;
    }

    public g(InputStream inputStream, int i10) {
        super(inputStream);
        if (i10 >= -1 && i10 <= 8) {
            this.f12196a = (byte) i10;
            return;
        }
        throw new IllegalArgumentException("Cannot add invalid orientation: " + i10);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i10;
        int i11 = this.f12197b;
        int i12 = (i11 < 2 || i11 > (i10 = f12195f)) ? super.read() : i11 == i10 ? this.f12196a : f12193d[i11 - 2] & 255;
        if (i12 != -1) {
            this.f12197b++;
        }
        return i12;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j10) throws IOException {
        long jSkip = super.skip(j10);
        if (jSkip > 0) {
            this.f12197b = (int) (((long) this.f12197b) + jSkip);
        }
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(@n0 byte[] bArr, int i10, int i11) throws IOException {
        int i12;
        int i13 = this.f12197b;
        int i14 = f12195f;
        if (i13 > i14) {
            i12 = super.read(bArr, i10, i11);
        } else if (i13 == i14) {
            bArr[i10] = this.f12196a;
            i12 = 1;
        } else if (i13 < 2) {
            i12 = super.read(bArr, i10, 2 - i13);
        } else {
            int iMin = Math.min(i14 - i13, i11);
            System.arraycopy(f12193d, this.f12197b - 2, bArr, i10, iMin);
            i12 = iMin;
        }
        if (i12 > 0) {
            this.f12197b += i12;
        }
        return i12;
    }
}
