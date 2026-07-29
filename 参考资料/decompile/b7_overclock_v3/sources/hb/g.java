package hb;

import hd.u0;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements l {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f30865i = 65536;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f30866j = 524288;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f30867k = 4096;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ed.h f30869c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f30870d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f30871e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f30873g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f30874h;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte[] f30872f = new byte[65536];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f30868b = new byte[4096];

    public g(ed.h hVar, long j10, long j11) {
        this.f30869c = hVar;
        this.f30871e = j10;
        this.f30870d = j11;
    }

    @Override // hb.l
    public int b(int i10) throws IOException {
        int iY = y(i10);
        if (iY == 0) {
            byte[] bArr = this.f30868b;
            iY = x(bArr, 0, Math.min(i10, bArr.length), 0, true);
        }
        u(iY);
        return iY;
    }

    @Override // hb.l
    public boolean e(byte[] bArr, int i10, int i11, boolean z10) throws IOException {
        int iW = w(bArr, i10, i11);
        while (iW < i11 && iW != -1) {
            iW = x(bArr, i10, i11, iW, z10);
        }
        u(iW);
        return iW != -1;
    }

    @Override // hb.l
    public boolean g(int i10, boolean z10) throws IOException {
        int iY = y(i10);
        while (iY < i10 && iY != -1) {
            iY = x(this.f30868b, -iY, Math.min(i10, this.f30868b.length + iY), iY, z10);
        }
        u(iY);
        return iY != -1;
    }

    @Override // hb.l
    public long getLength() {
        return this.f30870d;
    }

    @Override // hb.l
    public long getPosition() {
        return this.f30871e;
    }

    @Override // hb.l
    public boolean h(byte[] bArr, int i10, int i11, boolean z10) throws IOException {
        if (!q(i11, z10)) {
            return false;
        }
        System.arraycopy(this.f30872f, this.f30873g - i11, bArr, i10, i11);
        return true;
    }

    @Override // hb.l
    public long i() {
        return this.f30871e + ((long) this.f30873g);
    }

    @Override // hb.l
    public void j(int i10) throws IOException {
        q(i10, false);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: E extends java.lang.Throwable */
    @Override // hb.l
    public <E extends Throwable> void l(long j10, E e10) throws Throwable {
        hd.a.a(j10 >= 0);
        this.f30871e = j10;
        throw e10;
    }

    @Override // hb.l
    public int m(byte[] bArr, int i10, int i11) throws IOException {
        int iMin;
        v(i11);
        int i12 = this.f30874h;
        int i13 = this.f30873g;
        int i14 = i12 - i13;
        if (i14 == 0) {
            iMin = x(this.f30872f, i13, i11, 0, true);
            if (iMin == -1) {
                return -1;
            }
            this.f30874h += iMin;
        } else {
            iMin = Math.min(i11, i14);
        }
        System.arraycopy(this.f30872f, this.f30873g, bArr, i10, iMin);
        this.f30873g += iMin;
        return iMin;
    }

    @Override // hb.l
    public void n() {
        this.f30873g = 0;
    }

    @Override // hb.l
    public void o(int i10) throws IOException {
        g(i10, false);
    }

    @Override // hb.l
    public boolean q(int i10, boolean z10) throws IOException {
        v(i10);
        int iX = this.f30874h - this.f30873g;
        while (iX < i10) {
            iX = x(this.f30872f, this.f30873g, i10, iX, z10);
            if (iX == -1) {
                return false;
            }
            this.f30874h = this.f30873g + iX;
        }
        this.f30873g += i10;
        return true;
    }

    @Override // hb.l, ed.h
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        int iW = w(bArr, i10, i11);
        if (iW == 0) {
            iW = x(bArr, i10, i11, 0, true);
        }
        u(iW);
        return iW;
    }

    @Override // hb.l
    public void readFully(byte[] bArr, int i10, int i11) throws IOException {
        e(bArr, i10, i11, false);
    }

    @Override // hb.l
    public void t(byte[] bArr, int i10, int i11) throws IOException {
        h(bArr, i10, i11, false);
    }

    public final void u(int i10) {
        if (i10 != -1) {
            this.f30871e += (long) i10;
        }
    }

    public final void v(int i10) {
        int i11 = this.f30873g + i10;
        byte[] bArr = this.f30872f;
        if (i11 > bArr.length) {
            this.f30872f = Arrays.copyOf(this.f30872f, u0.t(bArr.length * 2, 65536 + i11, i11 + 524288));
        }
    }

    public final int w(byte[] bArr, int i10, int i11) {
        int i12 = this.f30874h;
        if (i12 == 0) {
            return 0;
        }
        int iMin = Math.min(i12, i11);
        System.arraycopy(this.f30872f, 0, bArr, i10, iMin);
        z(iMin);
        return iMin;
    }

    public final int x(byte[] bArr, int i10, int i11, int i12, boolean z10) throws IOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException();
        }
        int i13 = this.f30869c.read(bArr, i10 + i12, i11 - i12);
        if (i13 != -1) {
            return i12 + i13;
        }
        if (i12 == 0 && z10) {
            return -1;
        }
        throw new EOFException();
    }

    public final int y(int i10) {
        int iMin = Math.min(this.f30874h, i10);
        z(iMin);
        return iMin;
    }

    public final void z(int i10) {
        int i11 = this.f30874h - i10;
        this.f30874h = i11;
        this.f30873g = 0;
        byte[] bArr = this.f30872f;
        byte[] bArr2 = i11 < bArr.length - 524288 ? new byte[65536 + i11] : bArr;
        System.arraycopy(bArr, i10, bArr2, 0, i11);
        this.f30872f = bArr2;
    }
}
