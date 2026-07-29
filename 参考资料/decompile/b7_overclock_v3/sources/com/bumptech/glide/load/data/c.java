package com.bumptech.glide.load.data;

import g.i1;
import g.n0;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final OutputStream f12185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f12186b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bumptech.glide.load.engine.bitmap_recycle.b f12187c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f12188d;

    public c(@n0 OutputStream outputStream, @n0 com.bumptech.glide.load.engine.bitmap_recycle.b bVar) {
        this(outputStream, bVar, 65536);
    }

    public final void a() throws IOException {
        int i10 = this.f12188d;
        if (i10 > 0) {
            this.f12185a.write(this.f12186b, 0, i10);
            this.f12188d = 0;
        }
    }

    public final void c() throws IOException {
        if (this.f12188d == this.f12186b.length) {
            a();
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            flush();
            this.f12185a.close();
            d();
        } catch (Throwable th2) {
            this.f12185a.close();
            throw th2;
        }
    }

    public final void d() {
        byte[] bArr = this.f12186b;
        if (bArr != null) {
            this.f12187c.put(bArr);
            this.f12186b = null;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        a();
        this.f12185a.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i10) throws IOException {
        byte[] bArr = this.f12186b;
        int i11 = this.f12188d;
        this.f12188d = i11 + 1;
        bArr[i11] = (byte) i10;
        c();
    }

    @i1
    public c(@n0 OutputStream outputStream, com.bumptech.glide.load.engine.bitmap_recycle.b bVar, int i10) {
        this.f12185a = outputStream;
        this.f12187c = bVar;
        this.f12186b = (byte[]) bVar.f(i10, byte[].class);
    }

    @Override // java.io.OutputStream
    public void write(@n0 byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(@n0 byte[] bArr, int i10, int i11) throws IOException {
        int i12 = 0;
        do {
            int i13 = i11 - i12;
            int i14 = i10 + i12;
            int i15 = this.f12188d;
            if (i15 == 0 && i13 >= this.f12186b.length) {
                this.f12185a.write(bArr, i14, i13);
                return;
            }
            int iMin = Math.min(i13, this.f12186b.length - i15);
            System.arraycopy(bArr, i14, this.f12186b, this.f12188d, iMin);
            this.f12188d += iMin;
            i12 += iMin;
            c();
        } while (i12 < i11);
    }
}
