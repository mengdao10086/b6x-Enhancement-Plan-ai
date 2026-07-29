package com.google.android.exoplayer2.trackselection;

import ad.h;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.l;
import g.p0;
import gc.m;
import gc.n;
import java.util.List;
import ya.x1;

/* JADX INFO: loaded from: classes3.dex */
public interface b extends h {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TrackGroup f18623a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f18624b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f18625c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @p0
        public final Object f18626d;

        public a(TrackGroup trackGroup, int... iArr) {
            this(trackGroup, iArr, 0, null);
        }

        public a(TrackGroup trackGroup, int[] iArr, int i10, @p0 Object obj) {
            this.f18623a = trackGroup;
            this.f18624b = iArr;
            this.f18625c = i10;
            this.f18626d = obj;
        }
    }

    /* JADX INFO: renamed from: com.google.android.exoplayer2.trackselection.b$b, reason: collision with other inner class name */
    public interface InterfaceC0194b {
        b[] a(a[] aVarArr, ed.d dVar, l.a aVar, x1 x1Var);
    }

    void g();

    boolean h(long j10, gc.e eVar, List<? extends m> list);

    int i();

    boolean j(int i10, long j10);

    void k(boolean z10);

    void l();

    void m(long j10, long j11, long j12, List<? extends m> list, n[] nVarArr);

    int n(long j10, List<? extends m> list);

    int o();

    Format p();

    int q();

    void r(float f10);

    @p0
    Object s();

    void t();

    void u();
}
