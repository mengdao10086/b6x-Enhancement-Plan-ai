package ek;

import java.io.IOException;
import java.io.InputStream;
import kotlin.collections.m;
import kotlin.jvm.internal.f0;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
@f
public final class d extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final InputStream f27018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public final a f27019b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f27020c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f27021d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @k
    public final byte[] f27022e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @k
    public final byte[] f27023f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @k
    public final byte[] f27024g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f27025h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f27026i;

    public d(@k InputStream input, @k a base64) {
        f0.p(input, "input");
        f0.p(base64, "base64");
        this.f27018a = input;
        this.f27019b = base64;
        this.f27022e = new byte[1];
        this.f27023f = new byte[1024];
        this.f27024g = new byte[1024];
    }

    public final void a(byte[] bArr, int i10, int i11) {
        byte[] bArr2 = this.f27024g;
        int i12 = this.f27025h;
        m.W0(bArr2, bArr, i10, i12, i12 + i11);
        this.f27025h += i11;
        i();
    }

    public final int c(byte[] bArr, int i10, int i11, int i12) {
        int i13 = this.f27026i;
        this.f27026i = i13 + this.f27019b.n(this.f27023f, this.f27024g, i13, 0, i12);
        int iMin = Math.min(d(), i11 - i10);
        a(bArr, i10, iMin);
        k();
        return iMin;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f27020c) {
            return;
        }
        this.f27020c = true;
        this.f27018a.close();
    }

    public final int d() {
        return this.f27026i - this.f27025h;
    }

    public final int f(int i10) throws IOException {
        this.f27023f[i10] = 61;
        if ((i10 & 3) != 2) {
            return i10 + 1;
        }
        int iH = h();
        if (iH >= 0) {
            this.f27023f[i10 + 1] = (byte) iH;
        }
        return i10 + 2;
    }

    public final int h() throws IOException {
        int i10;
        if (!this.f27019b.D()) {
            return this.f27018a.read();
        }
        do {
            i10 = this.f27018a.read();
            if (i10 == -1) {
                break;
            }
        } while (!c.i(i10));
        return i10;
    }

    public final void i() {
        if (this.f27025h == this.f27026i) {
            this.f27025h = 0;
            this.f27026i = 0;
        }
    }

    public final void k() {
        byte[] bArr = this.f27024g;
        int length = bArr.length;
        int i10 = this.f27026i;
        if ((this.f27023f.length / 4) * 3 > length - i10) {
            m.W0(bArr, bArr, 0, this.f27025h, i10);
            this.f27026i -= this.f27025h;
            this.f27025h = 0;
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int i10 = this.f27025h;
        if (i10 < this.f27026i) {
            int i11 = this.f27024g[i10] & 255;
            this.f27025h = i10 + 1;
            i();
            return i11;
        }
        int i12 = read(this.f27022e, 0, 1);
        if (i12 == -1) {
            return -1;
        }
        if (i12 == 1) {
            return this.f27022e[0] & 255;
        }
        throw new IllegalStateException("Unreachable".toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0081, code lost:
    
        if (r4 != r11) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0083, code lost:
    
        if (r5 == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0088, code lost:
    
        return r4 - r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:?, code lost:
    
        return -1;
     */
    @Override // java.io.InputStream
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int read(@yt.k byte[] r10, int r11, int r12) throws java.io.IOException {
        /*
            r9 = this;
            java.lang.String r0 = "destination"
            kotlin.jvm.internal.f0.p(r10, r0)
            if (r11 < 0) goto L91
            if (r12 < 0) goto L91
            int r0 = r11 + r12
            int r1 = r10.length
            if (r0 > r1) goto L91
            boolean r1 = r9.f27020c
            if (r1 != 0) goto L89
            boolean r1 = r9.f27021d
            r2 = -1
            if (r1 == 0) goto L18
            return r2
        L18:
            r1 = 0
            if (r12 != 0) goto L1c
            return r1
        L1c:
            int r3 = r9.d()
            if (r3 < r12) goto L26
            r9.a(r10, r11, r12)
            return r12
        L26:
            int r3 = r9.d()
            int r12 = r12 - r3
            int r12 = r12 + 3
            r3 = 1
            int r12 = r12 - r3
            int r12 = r12 / 3
            int r12 = r12 * 4
            r4 = r11
        L34:
            boolean r5 = r9.f27021d
            if (r5 != 0) goto L81
            if (r12 <= 0) goto L81
            byte[] r5 = r9.f27023f
            int r5 = r5.length
            int r5 = java.lang.Math.min(r5, r12)
            r6 = 0
        L42:
            boolean r7 = r9.f27021d
            if (r7 != 0) goto L64
            if (r6 >= r5) goto L64
            int r7 = r9.h()
            if (r7 == r2) goto L61
            r8 = 61
            if (r7 == r8) goto L5a
            byte[] r8 = r9.f27023f
            byte r7 = (byte) r7
            r8[r6] = r7
            int r6 = r6 + 1
            goto L42
        L5a:
            int r6 = r9.f(r6)
            r9.f27021d = r3
            goto L42
        L61:
            r9.f27021d = r3
            goto L42
        L64:
            if (r7 != 0) goto L6b
            if (r6 != r5) goto L69
            goto L6b
        L69:
            r5 = 0
            goto L6c
        L6b:
            r5 = 1
        L6c:
            if (r5 == 0) goto L75
            int r12 = r12 - r6
            int r5 = r9.c(r10, r4, r0, r6)
            int r4 = r4 + r5
            goto L34
        L75:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "Check failed."
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            throw r10
        L81:
            if (r4 != r11) goto L86
            if (r5 == 0) goto L86
            goto L88
        L86:
            int r2 = r4 - r11
        L88:
            return r2
        L89:
            java.io.IOException r10 = new java.io.IOException
            java.lang.String r11 = "The input stream is closed."
            r10.<init>(r11)
            throw r10
        L91:
            java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "offset: "
            r1.append(r2)
            r1.append(r11)
            java.lang.String r11 = ", length: "
            r1.append(r11)
            r1.append(r12)
            java.lang.String r11 = ", buffer size: "
            r1.append(r11)
            int r10 = r10.length
            r1.append(r10)
            java.lang.String r10 = r1.toString()
            r0.<init>(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ek.d.read(byte[], int, int):int");
    }
}
