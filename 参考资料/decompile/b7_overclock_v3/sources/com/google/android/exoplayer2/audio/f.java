package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import hd.u0;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends c {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f16889i = Float.floatToIntBits(Float.NaN);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final double f16890j = 4.656612875245797E-10d;

    public static void l(int i10, ByteBuffer byteBuffer) {
        int iFloatToIntBits = Float.floatToIntBits((float) (((double) i10) * 4.656612875245797E-10d));
        if (iFloatToIntBits == f16889i) {
            iFloatToIntBits = Float.floatToIntBits(0.0f);
        }
        byteBuffer.putInt(iFloatToIntBits);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void d(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferK;
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i10 = iLimit - iPosition;
        int i11 = this.f16862b.f16756c;
        if (i11 == 536870912) {
            byteBufferK = k((i10 / 3) * 4);
            while (iPosition < iLimit) {
                l(((byteBuffer.get(iPosition) & 255) << 8) | ((byteBuffer.get(iPosition + 1) & 255) << 16) | ((byteBuffer.get(iPosition + 2) & 255) << 24), byteBufferK);
                iPosition += 3;
            }
        } else {
            if (i11 != 805306368) {
                throw new IllegalStateException();
            }
            byteBufferK = k(i10);
            while (iPosition < iLimit) {
                l((byteBuffer.get(iPosition) & 255) | ((byteBuffer.get(iPosition + 1) & 255) << 8) | ((byteBuffer.get(iPosition + 2) & 255) << 16) | ((byteBuffer.get(iPosition + 3) & 255) << 24), byteBufferK);
                iPosition += 4;
            }
        }
        byteBuffer.position(byteBuffer.limit());
        byteBufferK.flip();
    }

    @Override // com.google.android.exoplayer2.audio.c
    public AudioProcessor.a g(AudioProcessor.a aVar) throws AudioProcessor.UnhandledAudioFormatException {
        int i10 = aVar.f16756c;
        if (u0.D0(i10)) {
            return i10 != 4 ? new AudioProcessor.a(aVar.f16754a, aVar.f16755b, 4) : AudioProcessor.a.f16753e;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(aVar);
    }
}
