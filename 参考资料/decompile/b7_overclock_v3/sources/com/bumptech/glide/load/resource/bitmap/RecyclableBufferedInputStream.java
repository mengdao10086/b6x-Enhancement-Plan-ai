package com.bumptech.glide.load.resource.bitmap;

import g.i1;
import g.n0;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class RecyclableBufferedInputStream extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile byte[] f12540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f12541b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12542c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f12543d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f12544e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bumptech.glide.load.engine.bitmap_recycle.b f12545f;

    public static class InvalidMarkException extends IOException {
        private static final long serialVersionUID = -4338378848813561757L;

        public InvalidMarkException(String str) {
            super(str);
        }
    }

    public RecyclableBufferedInputStream(@n0 InputStream inputStream, @n0 com.bumptech.glide.load.engine.bitmap_recycle.b bVar) {
        this(inputStream, bVar, 65536);
    }

    public static IOException f() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    public final int a(InputStream inputStream, byte[] bArr) throws IOException {
        int i10 = this.f12543d;
        if (i10 != -1) {
            int i11 = this.f12544e - i10;
            int i12 = this.f12542c;
            if (i11 < i12) {
                if (i10 == 0 && i12 > bArr.length && this.f12541b == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i12) {
                        i12 = length;
                    }
                    byte[] bArr2 = (byte[]) this.f12545f.f(i12, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.f12540a = bArr2;
                    this.f12545f.put(bArr);
                    bArr = bArr2;
                } else if (i10 > 0) {
                    System.arraycopy(bArr, i10, bArr, 0, bArr.length - i10);
                }
                int i13 = this.f12544e - this.f12543d;
                this.f12544e = i13;
                this.f12543d = 0;
                this.f12541b = 0;
                int i14 = inputStream.read(bArr, i13, bArr.length - i13);
                int i15 = this.f12544e;
                if (i14 > 0) {
                    i15 += i14;
                }
                this.f12541b = i15;
                return i14;
            }
        }
        int i16 = inputStream.read(bArr);
        if (i16 > 0) {
            this.f12543d = -1;
            this.f12544e = 0;
            this.f12541b = i16;
        }
        return i16;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.f12540a == null || inputStream == null) {
            throw f();
        }
        return (this.f12541b - this.f12544e) + inputStream.available();
    }

    public synchronized void c() {
        this.f12542c = this.f12540a.length;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f12540a != null) {
            this.f12545f.put(this.f12540a);
            this.f12540a = null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public synchronized void d() {
        if (this.f12540a != null) {
            this.f12545f.put(this.f12540a);
            this.f12540a = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i10) {
        this.f12542c = Math.max(this.f12542c, i10);
        this.f12543d = this.f12544e;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        byte[] bArr = this.f12540a;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr == null || inputStream == null) {
            throw f();
        }
        if (this.f12544e >= this.f12541b && a(inputStream, bArr) == -1) {
            return -1;
        }
        if (bArr != this.f12540a && (bArr = this.f12540a) == null) {
            throw f();
        }
        int i10 = this.f12541b;
        int i11 = this.f12544e;
        if (i10 - i11 <= 0) {
            return -1;
        }
        this.f12544e = i11 + 1;
        return bArr[i11] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        if (this.f12540a == null) {
            throw new IOException("Stream is closed");
        }
        int i10 = this.f12543d;
        if (-1 == i10) {
            throw new InvalidMarkException("Mark has been invalidated, pos: " + this.f12544e + " markLimit: " + this.f12542c);
        }
        this.f12544e = i10;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j10) throws IOException {
        if (j10 < 1) {
            return 0L;
        }
        byte[] bArr = this.f12540a;
        if (bArr == null) {
            throw f();
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream == null) {
            throw f();
        }
        int i10 = this.f12541b;
        int i11 = this.f12544e;
        if (i10 - i11 >= j10) {
            this.f12544e = (int) (((long) i11) + j10);
            return j10;
        }
        long j11 = ((long) i10) - ((long) i11);
        this.f12544e = i10;
        if (this.f12543d == -1 || j10 > this.f12542c) {
            long jSkip = inputStream.skip(j10 - j11);
            if (jSkip > 0) {
                this.f12543d = -1;
            }
            return j11 + jSkip;
        }
        if (a(inputStream, bArr) == -1) {
            return j11;
        }
        int i12 = this.f12541b;
        int i13 = this.f12544e;
        if (i12 - i13 >= j10 - j11) {
            this.f12544e = (int) ((((long) i13) + j10) - j11);
            return j10;
        }
        long j12 = (j11 + ((long) i12)) - ((long) i13);
        this.f12544e = i12;
        return j12;
    }

    @i1
    public RecyclableBufferedInputStream(@n0 InputStream inputStream, @n0 com.bumptech.glide.load.engine.bitmap_recycle.b bVar, int i10) {
        super(inputStream);
        this.f12543d = -1;
        this.f12545f = bVar;
        this.f12540a = (byte[]) bVar.f(i10, byte[].class);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(@n0 byte[] bArr, int i10, int i11) throws IOException {
        int i12;
        int i13;
        byte[] bArr2 = this.f12540a;
        if (bArr2 == null) {
            throw f();
        }
        if (i11 == 0) {
            return 0;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream != null) {
            int i14 = this.f12544e;
            int i15 = this.f12541b;
            if (i14 < i15) {
                int i16 = i15 - i14 >= i11 ? i11 : i15 - i14;
                System.arraycopy(bArr2, i14, bArr, i10, i16);
                this.f12544e += i16;
                if (i16 == i11 || inputStream.available() == 0) {
                    return i16;
                }
                i10 += i16;
                i12 = i11 - i16;
            } else {
                i12 = i11;
            }
            while (true) {
                if (this.f12543d == -1 && i12 >= bArr2.length) {
                    i13 = inputStream.read(bArr, i10, i12);
                    if (i13 == -1) {
                        return i12 != i11 ? i11 - i12 : -1;
                    }
                } else {
                    if (a(inputStream, bArr2) == -1) {
                        return i12 != i11 ? i11 - i12 : -1;
                    }
                    if (bArr2 != this.f12540a && (bArr2 = this.f12540a) == null) {
                        throw f();
                    }
                    int i17 = this.f12541b;
                    int i18 = this.f12544e;
                    i13 = i17 - i18 >= i12 ? i12 : i17 - i18;
                    System.arraycopy(bArr2, i18, bArr, i10, i13);
                    this.f12544e += i13;
                }
                i12 -= i13;
                if (i12 == 0) {
                    return i11;
                }
                if (inputStream.available() == 0) {
                    return i11 - i12;
                }
                i10 += i13;
            }
        } else {
            throw f();
        }
    }
}
