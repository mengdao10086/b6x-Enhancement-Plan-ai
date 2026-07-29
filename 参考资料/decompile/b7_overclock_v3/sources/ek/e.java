package ek;

import java.io.IOException;
import java.io.OutputStream;
import kotlin.collections.m;
import kotlin.jvm.internal.f0;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
@f
public final class e extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final OutputStream f27027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public final a f27028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f27029c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f27030d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @k
    public final byte[] f27031e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @k
    public final byte[] f27032f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f27033g;

    public e(@k OutputStream output, @k a base64) {
        f0.p(output, "output");
        f0.p(base64, "base64");
        this.f27027a = output;
        this.f27028b = base64;
        this.f27030d = base64.D() ? 76 : -1;
        this.f27031e = new byte[1024];
        this.f27032f = new byte[3];
    }

    public final void a() throws IOException {
        if (this.f27029c) {
            throw new IOException("The output stream is closed.");
        }
    }

    public final int c(byte[] bArr, int i10, int i11) {
        int iMin = Math.min(3 - this.f27033g, i11 - i10);
        m.W0(bArr, this.f27032f, this.f27033g, i10, i10 + iMin);
        int i12 = this.f27033g + iMin;
        this.f27033g = i12;
        if (i12 == 3) {
            d();
        }
        return iMin;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f27029c) {
            return;
        }
        this.f27029c = true;
        if (this.f27033g != 0) {
            d();
        }
        this.f27027a.close();
    }

    public final void d() {
        if (!(f(this.f27032f, 0, this.f27033g) == 4)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        this.f27033g = 0;
    }

    public final int f(byte[] bArr, int i10, int i11) throws IOException {
        int iT = this.f27028b.t(bArr, this.f27031e, 0, i10, i11);
        if (this.f27030d == 0) {
            this.f27027a.write(a.f27001c.H());
            this.f27030d = 76;
            if (!(iT <= 76)) {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        this.f27027a.write(this.f27031e, 0, iT);
        this.f27030d -= iT;
        return iT;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        a();
        this.f27027a.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i10) throws IOException {
        a();
        byte[] bArr = this.f27032f;
        int i11 = this.f27033g;
        int i12 = i11 + 1;
        this.f27033g = i12;
        bArr[i11] = (byte) i10;
        if (i12 == 3) {
            d();
        }
    }

    @Override // java.io.OutputStream
    public void write(@k byte[] source, int i10, int i11) throws IOException {
        int i12;
        f0.p(source, "source");
        a();
        if (i10 < 0 || i11 < 0 || (i12 = i10 + i11) > source.length) {
            throw new IndexOutOfBoundsException("offset: " + i10 + ", length: " + i11 + ", source size: " + source.length);
        }
        if (i11 == 0) {
            return;
        }
        int i13 = this.f27033g;
        if (i13 < 3) {
            if (i13 != 0) {
                i10 += c(source, i10, i12);
                if (this.f27033g != 0) {
                    return;
                }
            }
            while (i10 + 3 <= i12) {
                int iMin = Math.min((this.f27028b.D() ? this.f27030d : this.f27031e.length) / 4, (i12 - i10) / 3);
                int i14 = (iMin * 3) + i10;
                if (!(f(source, i10, i14) == iMin * 4)) {
                    throw new IllegalStateException("Check failed.".toString());
                }
                i10 = i14;
            }
            m.W0(source, this.f27032f, 0, i10, i12);
            this.f27033g = i12 - i10;
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }
}
