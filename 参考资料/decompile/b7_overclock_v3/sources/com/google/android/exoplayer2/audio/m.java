package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import hd.u0;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public final class m extends c {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f16948p = 2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f16949i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f16950j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f16951k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f16952l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public byte[] f16953m = u0.f31159f;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f16954n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f16955o;

    @Override // com.google.android.exoplayer2.audio.c, com.google.android.exoplayer2.audio.AudioProcessor
    public boolean b() {
        return super.b() && this.f16954n == 0;
    }

    @Override // com.google.android.exoplayer2.audio.c, com.google.android.exoplayer2.audio.AudioProcessor
    public ByteBuffer c() {
        int i10;
        if (super.b() && (i10 = this.f16954n) > 0) {
            k(i10).put(this.f16953m, 0, this.f16954n).flip();
            this.f16954n = 0;
        }
        return super.c();
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void d(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i10 = iLimit - iPosition;
        if (i10 == 0) {
            return;
        }
        int iMin = Math.min(i10, this.f16952l);
        this.f16955o += (long) (iMin / this.f16862b.f16757d);
        this.f16952l -= iMin;
        byteBuffer.position(iPosition + iMin);
        if (this.f16952l > 0) {
            return;
        }
        int i11 = i10 - iMin;
        int length = (this.f16954n + i11) - this.f16953m.length;
        ByteBuffer byteBufferK = k(length);
        int iT = u0.t(length, 0, this.f16954n);
        byteBufferK.put(this.f16953m, 0, iT);
        int iT2 = u0.t(length - iT, 0, i11);
        byteBuffer.limit(byteBuffer.position() + iT2);
        byteBufferK.put(byteBuffer);
        byteBuffer.limit(iLimit);
        int i12 = i11 - iT2;
        int i13 = this.f16954n - iT;
        this.f16954n = i13;
        byte[] bArr = this.f16953m;
        System.arraycopy(bArr, iT, bArr, 0, i13);
        byteBuffer.get(this.f16953m, this.f16954n, i12);
        this.f16954n += i12;
        byteBufferK.flip();
    }

    @Override // com.google.android.exoplayer2.audio.c
    public AudioProcessor.a g(AudioProcessor.a aVar) throws AudioProcessor.UnhandledAudioFormatException {
        if (aVar.f16756c != 2) {
            throw new AudioProcessor.UnhandledAudioFormatException(aVar);
        }
        this.f16951k = true;
        return (this.f16949i == 0 && this.f16950j == 0) ? AudioProcessor.a.f16753e : aVar;
    }

    @Override // com.google.android.exoplayer2.audio.c
    public void h() {
        if (this.f16951k) {
            this.f16951k = false;
            int i10 = this.f16950j;
            int i11 = this.f16862b.f16757d;
            this.f16953m = new byte[i10 * i11];
            this.f16952l = this.f16949i * i11;
        }
        this.f16954n = 0;
    }

    @Override // com.google.android.exoplayer2.audio.c
    public void i() {
        if (this.f16951k) {
            int i10 = this.f16954n;
            if (i10 > 0) {
                this.f16955o += (long) (i10 / this.f16862b.f16757d);
            }
            this.f16954n = 0;
        }
    }

    @Override // com.google.android.exoplayer2.audio.c
    public void j() {
        this.f16953m = u0.f31159f;
    }

    public long l() {
        return this.f16955o;
    }

    public void m() {
        this.f16955o = 0L;
    }

    public void n(int i10, int i11) {
        this.f16949i = i10;
        this.f16950j = i11;
    }
}
