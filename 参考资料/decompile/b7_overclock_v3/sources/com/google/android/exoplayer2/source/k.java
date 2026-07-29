package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.s;
import ec.d0;
import java.io.IOException;
import java.util.List;
import ya.t1;

/* JADX INFO: loaded from: classes3.dex */
public interface k extends s {

    public interface a extends s.a<k> {
        void l(k kVar);
    }

    @Override // com.google.android.exoplayer2.source.s
    long b();

    long c(long j10, t1 t1Var);

    @Override // com.google.android.exoplayer2.source.s
    boolean e(long j10);

    @Override // com.google.android.exoplayer2.source.s
    long f();

    @Override // com.google.android.exoplayer2.source.s
    void g(long j10);

    @Override // com.google.android.exoplayer2.source.s
    boolean isLoading();

    List<StreamKey> j(List<com.google.android.exoplayer2.trackselection.b> list);

    void m() throws IOException;

    long n(long j10);

    long p();

    void q(a aVar, long j10);

    TrackGroupArray r();

    long s(com.google.android.exoplayer2.trackselection.b[] bVarArr, boolean[] zArr, d0[] d0VarArr, boolean[] zArr2, long j10);

    void u(long j10, boolean z10);
}
