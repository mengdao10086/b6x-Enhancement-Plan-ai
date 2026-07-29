package com.google.android.exoplayer2;

import ya.x1;

/* JADX INFO: loaded from: classes3.dex */
public final class IllegalSeekPositionException extends IllegalStateException {
    public final long positionMs;
    public final x1 timeline;
    public final int windowIndex;

    public IllegalSeekPositionException(x1 x1Var, int i10, long j10) {
        this.timeline = x1Var;
        this.windowIndex = i10;
        this.positionMs = j10;
    }
}
