package com.google.android.exoplayer2.source.hls;

import g.p0;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class SampleQueueMappingException extends IOException {
    public SampleQueueMappingException(@p0 String str) {
        super("Unable to bind a sample queue to TrackGroup with mime type " + str + j3.b.f36044h);
    }
}
