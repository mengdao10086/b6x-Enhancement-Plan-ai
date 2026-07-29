package com.google.android.exoplayer2.ui;

import g.p0;

/* JADX INFO: loaded from: classes3.dex */
public interface l {

    public interface a {
        void a(l lVar, long j10);

        void c(l lVar, long j10, boolean z10);

        void d(l lVar, long j10);
    }

    void a(@p0 long[] jArr, @p0 boolean[] zArr, int i10);

    void b(a aVar);

    void c(a aVar);

    long getPreferredUpdateDelay();

    void setBufferedPosition(long j10);

    void setDuration(long j10);

    void setEnabled(boolean z10);

    void setKeyCountIncrement(int i10);

    void setKeyTimeIncrement(long j10);

    void setPosition(long j10);
}
