package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import hd.u0;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends c {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final long f16898u = 150000;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final long f16899v = 20000;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final short f16900w = 1024;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f16901x = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f16902y = 1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f16903z = 2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f16904i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f16905j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final short f16906k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f16907l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f16908m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public byte[] f16909n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public byte[] f16910o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f16911p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f16912q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f16913r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f16914s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f16915t;

    public j() {
        this(f16898u, f16899v, f16900w);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void d(ByteBuffer byteBuffer) {
        while (byteBuffer.hasRemaining() && !a()) {
            int i10 = this.f16911p;
            if (i10 == 0) {
                s(byteBuffer);
            } else if (i10 == 1) {
                r(byteBuffer);
            } else {
                if (i10 != 2) {
                    throw new IllegalStateException();
                }
                t(byteBuffer);
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.c
    public AudioProcessor.a g(AudioProcessor.a aVar) throws AudioProcessor.UnhandledAudioFormatException {
        if (aVar.f16756c == 2) {
            return this.f16908m ? aVar : AudioProcessor.a.f16753e;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(aVar);
    }

    @Override // com.google.android.exoplayer2.audio.c
    public void h() {
        if (this.f16908m) {
            this.f16907l = this.f16862b.f16757d;
            int iL = l(this.f16904i) * this.f16907l;
            if (this.f16909n.length != iL) {
                this.f16909n = new byte[iL];
            }
            int iL2 = l(this.f16905j) * this.f16907l;
            this.f16913r = iL2;
            if (this.f16910o.length != iL2) {
                this.f16910o = new byte[iL2];
            }
        }
        this.f16911p = 0;
        this.f16915t = 0L;
        this.f16912q = 0;
        this.f16914s = false;
    }

    @Override // com.google.android.exoplayer2.audio.c
    public void i() {
        int i10 = this.f16912q;
        if (i10 > 0) {
            q(this.f16909n, i10);
        }
        if (this.f16914s) {
            return;
        }
        this.f16915t += (long) (this.f16913r / this.f16907l);
    }

    @Override // com.google.android.exoplayer2.audio.c, com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        return this.f16908m;
    }

    @Override // com.google.android.exoplayer2.audio.c
    public void j() {
        this.f16908m = false;
        this.f16913r = 0;
        byte[] bArr = u0.f31159f;
        this.f16909n = bArr;
        this.f16910o = bArr;
    }

    public final int l(long j10) {
        return (int) ((j10 * ((long) this.f16862b.f16754a)) / 1000000);
    }

    public final int m(ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit();
        do {
            iLimit -= 2;
            if (iLimit < byteBuffer.position()) {
                return byteBuffer.position();
            }
        } while (Math.abs((int) byteBuffer.getShort(iLimit)) <= this.f16906k);
        int i10 = this.f16907l;
        return ((iLimit / i10) * i10) + i10;
    }

    public final int n(ByteBuffer byteBuffer) {
        for (int iPosition = byteBuffer.position(); iPosition < byteBuffer.limit(); iPosition += 2) {
            if (Math.abs((int) byteBuffer.getShort(iPosition)) > this.f16906k) {
                int i10 = this.f16907l;
                return i10 * (iPosition / i10);
            }
        }
        return byteBuffer.limit();
    }

    public long o() {
        return this.f16915t;
    }

    public final void p(ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        k(iRemaining).put(byteBuffer).flip();
        if (iRemaining > 0) {
            this.f16914s = true;
        }
    }

    public final void q(byte[] bArr, int i10) {
        k(i10).put(bArr, 0, i10).flip();
        if (i10 > 0) {
            this.f16914s = true;
        }
    }

    public final void r(ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit();
        int iN = n(byteBuffer);
        int iPosition = iN - byteBuffer.position();
        byte[] bArr = this.f16909n;
        int length = bArr.length;
        int i10 = this.f16912q;
        int i11 = length - i10;
        if (iN < iLimit && iPosition < i11) {
            q(bArr, i10);
            this.f16912q = 0;
            this.f16911p = 0;
            return;
        }
        int iMin = Math.min(iPosition, i11);
        byteBuffer.limit(byteBuffer.position() + iMin);
        byteBuffer.get(this.f16909n, this.f16912q, iMin);
        int i12 = this.f16912q + iMin;
        this.f16912q = i12;
        byte[] bArr2 = this.f16909n;
        if (i12 == bArr2.length) {
            if (this.f16914s) {
                q(bArr2, this.f16913r);
                this.f16915t += (long) ((this.f16912q - (this.f16913r * 2)) / this.f16907l);
            } else {
                this.f16915t += (long) ((i12 - this.f16913r) / this.f16907l);
            }
            v(byteBuffer, this.f16909n, this.f16912q);
            this.f16912q = 0;
            this.f16911p = 2;
        }
        byteBuffer.limit(iLimit);
    }

    public final void s(ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit();
        byteBuffer.limit(Math.min(iLimit, byteBuffer.position() + this.f16909n.length));
        int iM = m(byteBuffer);
        if (iM == byteBuffer.position()) {
            this.f16911p = 1;
        } else {
            byteBuffer.limit(iM);
            p(byteBuffer);
        }
        byteBuffer.limit(iLimit);
    }

    public final void t(ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit();
        int iN = n(byteBuffer);
        byteBuffer.limit(iN);
        this.f16915t += (long) (byteBuffer.remaining() / this.f16907l);
        v(byteBuffer, this.f16910o, this.f16913r);
        if (iN < iLimit) {
            q(this.f16910o, this.f16913r);
            this.f16911p = 0;
            byteBuffer.limit(iLimit);
        }
    }

    public void u(boolean z10) {
        this.f16908m = z10;
    }

    public final void v(ByteBuffer byteBuffer, byte[] bArr, int i10) {
        int iMin = Math.min(byteBuffer.remaining(), this.f16913r);
        int i11 = this.f16913r - iMin;
        System.arraycopy(bArr, i10 - i11, this.f16910o, 0, i11);
        byteBuffer.position(byteBuffer.limit() - iMin);
        byteBuffer.get(this.f16910o, i11, iMin);
    }

    public j(long j10, long j11, short s10) {
        hd.a.a(j11 <= j10);
        this.f16904i = j10;
        this.f16905j = j11;
        this.f16906k = s10;
        byte[] bArr = u0.f31159f;
        this.f16909n = bArr;
        this.f16910o = bArr;
    }
}
