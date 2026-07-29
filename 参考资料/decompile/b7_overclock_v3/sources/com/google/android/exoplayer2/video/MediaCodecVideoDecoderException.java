package com.google.android.exoplayer2.video;

import android.view.Surface;
import com.google.android.exoplayer2.mediacodec.MediaCodecDecoderException;
import com.google.android.exoplayer2.mediacodec.c;
import g.p0;

/* JADX INFO: loaded from: classes3.dex */
public class MediaCodecVideoDecoderException extends MediaCodecDecoderException {
    public final boolean isSurfaceValid;
    public final int surfaceIdentityHashCode;

    public MediaCodecVideoDecoderException(Throwable th2, @p0 c cVar, @p0 Surface surface) {
        super(th2, cVar);
        this.surfaceIdentityHashCode = System.identityHashCode(surface);
        this.isSurfaceValid = surface == null || surface.isValid();
    }
}
