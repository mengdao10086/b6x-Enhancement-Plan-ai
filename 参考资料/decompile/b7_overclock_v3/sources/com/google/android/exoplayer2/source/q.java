package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.r;
import g.p0;
import hb.d0;
import hd.c0;
import hd.u0;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class q {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f18245h = 32;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ed.b f18246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f18247b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c0 f18248c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f18249d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f18250e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f18251f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f18252g;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f18253a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f18254b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f18255c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @p0
        public ed.a f18256d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @p0
        public a f18257e;

        public a(long j10, int i10) {
            this.f18253a = j10;
            this.f18254b = j10 + ((long) i10);
        }

        public a a() {
            this.f18256d = null;
            a aVar = this.f18257e;
            this.f18257e = null;
            return aVar;
        }

        public void b(ed.a aVar, a aVar2) {
            this.f18256d = aVar;
            this.f18257e = aVar2;
            this.f18255c = true;
        }

        public int c(long j10) {
            return ((int) (j10 - this.f18253a)) + this.f18256d.f26888b;
        }
    }

    public q(ed.b bVar) {
        this.f18246a = bVar;
        int iF = bVar.f();
        this.f18247b = iF;
        this.f18248c = new c0(32);
        a aVar = new a(0L, iF);
        this.f18249d = aVar;
        this.f18250e = aVar;
        this.f18251f = aVar;
    }

    public static a d(a aVar, long j10) {
        while (j10 >= aVar.f18254b) {
            aVar = aVar.f18257e;
        }
        return aVar;
    }

    public static a i(a aVar, long j10, ByteBuffer byteBuffer, int i10) {
        a aVarD = d(aVar, j10);
        while (i10 > 0) {
            int iMin = Math.min(i10, (int) (aVarD.f18254b - j10));
            byteBuffer.put(aVarD.f18256d.f26887a, aVarD.c(j10), iMin);
            i10 -= iMin;
            j10 += (long) iMin;
            if (j10 == aVarD.f18254b) {
                aVarD = aVarD.f18257e;
            }
        }
        return aVarD;
    }

    public static a j(a aVar, long j10, byte[] bArr, int i10) {
        a aVarD = d(aVar, j10);
        int i11 = i10;
        while (i11 > 0) {
            int iMin = Math.min(i11, (int) (aVarD.f18254b - j10));
            System.arraycopy(aVarD.f18256d.f26887a, aVarD.c(j10), bArr, i10 - i11, iMin);
            i11 -= iMin;
            j10 += (long) iMin;
            if (j10 == aVarD.f18254b) {
                aVarD = aVarD.f18257e;
            }
        }
        return aVarD;
    }

    public static a k(a aVar, DecoderInputBuffer decoderInputBuffer, r.a aVar2, c0 c0Var) {
        int iM;
        long j10 = aVar2.f18282b;
        c0Var.O(1);
        a aVarJ = j(aVar, j10, c0Var.d(), 1);
        long j11 = j10 + 1;
        byte b10 = c0Var.d()[0];
        boolean z10 = (b10 & 128) != 0;
        int i10 = b10 & 127;
        eb.b bVar = decoderInputBuffer.f16959b;
        byte[] bArr = bVar.f26746a;
        if (bArr == null) {
            bVar.f26746a = new byte[16];
        } else {
            Arrays.fill(bArr, (byte) 0);
        }
        a aVarJ2 = j(aVarJ, j11, bVar.f26746a, i10);
        long j12 = j11 + ((long) i10);
        if (z10) {
            c0Var.O(2);
            aVarJ2 = j(aVarJ2, j12, c0Var.d(), 2);
            j12 += 2;
            iM = c0Var.M();
        } else {
            iM = 1;
        }
        int[] iArr = bVar.f26749d;
        if (iArr == null || iArr.length < iM) {
            iArr = new int[iM];
        }
        int[] iArr2 = iArr;
        int[] iArr3 = bVar.f26750e;
        if (iArr3 == null || iArr3.length < iM) {
            iArr3 = new int[iM];
        }
        int[] iArr4 = iArr3;
        if (z10) {
            int i11 = iM * 6;
            c0Var.O(i11);
            aVarJ2 = j(aVarJ2, j12, c0Var.d(), i11);
            j12 += (long) i11;
            c0Var.S(0);
            for (int i12 = 0; i12 < iM; i12++) {
                iArr2[i12] = c0Var.M();
                iArr4[i12] = c0Var.K();
            }
        } else {
            iArr2[0] = 0;
            iArr4[0] = aVar2.f18281a - ((int) (j12 - aVar2.f18282b));
        }
        d0.a aVar3 = (d0.a) u0.k(aVar2.f18283c);
        bVar.d(iM, iArr2, iArr4, aVar3.f30823b, bVar.f26746a, aVar3.f30822a, aVar3.f30824c, aVar3.f30825d);
        long j13 = aVar2.f18282b;
        int i13 = (int) (j12 - j13);
        aVar2.f18282b = j13 + ((long) i13);
        aVar2.f18281a -= i13;
        return aVarJ2;
    }

    public static a l(a aVar, DecoderInputBuffer decoderInputBuffer, r.a aVar2, c0 c0Var) {
        if (decoderInputBuffer.s()) {
            aVar = k(aVar, decoderInputBuffer, aVar2, c0Var);
        }
        if (!decoderInputBuffer.k()) {
            decoderInputBuffer.q(aVar2.f18281a);
            return i(aVar, aVar2.f18282b, decoderInputBuffer.f16960c, aVar2.f18281a);
        }
        c0Var.O(4);
        a aVarJ = j(aVar, aVar2.f18282b, c0Var.d(), 4);
        int iK = c0Var.K();
        aVar2.f18282b += 4;
        aVar2.f18281a -= 4;
        decoderInputBuffer.q(iK);
        a aVarI = i(aVarJ, aVar2.f18282b, decoderInputBuffer.f16960c, iK);
        aVar2.f18282b += (long) iK;
        int i10 = aVar2.f18281a - iK;
        aVar2.f18281a = i10;
        decoderInputBuffer.v(i10);
        return i(aVarI, aVar2.f18282b, decoderInputBuffer.f16963f, aVar2.f18281a);
    }

    public final void a(a aVar) {
        if (aVar.f18255c) {
            a aVar2 = this.f18251f;
            boolean z10 = aVar2.f18255c;
            int i10 = (z10 ? 1 : 0) + (((int) (aVar2.f18253a - aVar.f18253a)) / this.f18247b);
            ed.a[] aVarArr = new ed.a[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                aVarArr[i11] = aVar.f18256d;
                aVar = aVar.a();
            }
            this.f18246a.a(aVarArr);
        }
    }

    public void b(long j10) {
        a aVar;
        if (j10 == -1) {
            return;
        }
        while (true) {
            aVar = this.f18249d;
            if (j10 < aVar.f18254b) {
                break;
            }
            this.f18246a.d(aVar.f18256d);
            this.f18249d = this.f18249d.a();
        }
        if (this.f18250e.f18253a < aVar.f18253a) {
            this.f18250e = aVar;
        }
    }

    public void c(long j10) {
        this.f18252g = j10;
        if (j10 != 0) {
            a aVar = this.f18249d;
            if (j10 != aVar.f18253a) {
                while (this.f18252g > aVar.f18254b) {
                    aVar = aVar.f18257e;
                }
                a aVar2 = aVar.f18257e;
                a(aVar2);
                a aVar3 = new a(aVar.f18254b, this.f18247b);
                aVar.f18257e = aVar3;
                if (this.f18252g == aVar.f18254b) {
                    aVar = aVar3;
                }
                this.f18251f = aVar;
                if (this.f18250e == aVar2) {
                    this.f18250e = aVar3;
                    return;
                }
                return;
            }
        }
        a(this.f18249d);
        a aVar4 = new a(this.f18252g, this.f18247b);
        this.f18249d = aVar4;
        this.f18250e = aVar4;
        this.f18251f = aVar4;
    }

    public long e() {
        return this.f18252g;
    }

    public void f(DecoderInputBuffer decoderInputBuffer, r.a aVar) {
        l(this.f18250e, decoderInputBuffer, aVar, this.f18248c);
    }

    public final void g(int i10) {
        long j10 = this.f18252g + ((long) i10);
        this.f18252g = j10;
        a aVar = this.f18251f;
        if (j10 == aVar.f18254b) {
            this.f18251f = aVar.f18257e;
        }
    }

    public final int h(int i10) {
        a aVar = this.f18251f;
        if (!aVar.f18255c) {
            aVar.b(this.f18246a.b(), new a(this.f18251f.f18254b, this.f18247b));
        }
        return Math.min(i10, (int) (this.f18251f.f18254b - this.f18252g));
    }

    public void m(DecoderInputBuffer decoderInputBuffer, r.a aVar) {
        this.f18250e = l(this.f18250e, decoderInputBuffer, aVar, this.f18248c);
    }

    public void n() {
        a(this.f18249d);
        a aVar = new a(0L, this.f18247b);
        this.f18249d = aVar;
        this.f18250e = aVar;
        this.f18251f = aVar;
        this.f18252g = 0L;
        this.f18246a.c();
    }

    public void o() {
        this.f18250e = this.f18249d;
    }

    public int p(ed.h hVar, int i10, boolean z10) throws IOException {
        int iH = h(i10);
        a aVar = this.f18251f;
        int i11 = hVar.read(aVar.f18256d.f26887a, aVar.c(this.f18252g), iH);
        if (i11 != -1) {
            g(i11);
            return i11;
        }
        if (z10) {
            return -1;
        }
        throw new EOFException();
    }

    public void q(c0 c0Var, int i10) {
        while (i10 > 0) {
            int iH = h(i10);
            a aVar = this.f18251f;
            c0Var.k(aVar.f18256d.f26887a, aVar.c(this.f18252g), iH);
            i10 -= iH;
            g(iH);
        }
    }
}
