package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import g.p0;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends c {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @p0
    public int[] f16869i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @p0
    public int[] f16870j;

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void d(ByteBuffer byteBuffer) {
        int[] iArr = (int[]) hd.a.g(this.f16870j);
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        ByteBuffer byteBufferK = k(((iLimit - iPosition) / this.f16862b.f16757d) * this.f16863c.f16757d);
        while (iPosition < iLimit) {
            for (int i10 : iArr) {
                byteBufferK.putShort(byteBuffer.getShort((i10 * 2) + iPosition));
            }
            iPosition += this.f16862b.f16757d;
        }
        byteBuffer.position(iLimit);
        byteBufferK.flip();
    }

    @Override // com.google.android.exoplayer2.audio.c
    public AudioProcessor.a g(AudioProcessor.a aVar) throws AudioProcessor.UnhandledAudioFormatException {
        int[] iArr = this.f16869i;
        if (iArr == null) {
            return AudioProcessor.a.f16753e;
        }
        if (aVar.f16756c != 2) {
            throw new AudioProcessor.UnhandledAudioFormatException(aVar);
        }
        boolean z10 = aVar.f16755b != iArr.length;
        int i10 = 0;
        while (i10 < iArr.length) {
            int i11 = iArr[i10];
            if (i11 >= aVar.f16755b) {
                throw new AudioProcessor.UnhandledAudioFormatException(aVar);
            }
            z10 |= i11 != i10;
            i10++;
        }
        return z10 ? new AudioProcessor.a(aVar.f16754a, iArr.length, 2) : AudioProcessor.a.f16753e;
    }

    @Override // com.google.android.exoplayer2.audio.c
    public void h() {
        this.f16870j = this.f16869i;
    }

    @Override // com.google.android.exoplayer2.audio.c
    public void j() {
        this.f16870j = null;
        this.f16869i = null;
    }

    public void l(@p0 int[] iArr) {
        this.f16869i = iArr;
    }
}
