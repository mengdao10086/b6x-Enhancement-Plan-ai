package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import com.google.android.exoplayer2.decoder.DecoderException;
import g.p0;
import g.v0;
import hd.u0;

/* JADX INFO: loaded from: classes3.dex */
public class MediaCodecDecoderException extends DecoderException {

    @p0
    public final c codecInfo;

    @p0
    public final String diagnosticInfo;

    public MediaCodecDecoderException(Throwable th2, @p0 c cVar) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Decoder failed: ");
        sb2.append(cVar == null ? null : cVar.f17203a);
        super(sb2.toString(), th2);
        this.codecInfo = cVar;
        this.diagnosticInfo = u0.f31154a >= 21 ? a(th2) : null;
    }

    @p0
    @v0(21)
    public static String a(Throwable th2) {
        if (th2 instanceof MediaCodec.CodecException) {
            return ((MediaCodec.CodecException) th2).getDiagnosticInfo();
        }
        return null;
    }
}
