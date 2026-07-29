package com.google.android.exoplayer2.source.hls;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
final class UnexpectedSampleTimestampException extends IOException {
    public final long lastAcceptedSampleTimeUs;
    public final gc.m mediaChunk;
    public final long rejectedSampleTimeUs;

    public UnexpectedSampleTimestampException(gc.m mVar, long j10, long j11) {
        super("Unexpected sample timestamp: " + ya.g.d(j11) + " in chunk [" + mVar.f29169g + ", " + mVar.f29170h + "]");
        this.mediaChunk = mVar;
        this.lastAcceptedSampleTimeUs = j10;
        this.rejectedSampleTimeUs = j11;
    }
}
