package com.google.android.exoplayer2.trackselection;

import android.os.SystemClock;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.trackselection.b;
import com.google.android.exoplayer2.trackselection.e;
import g.p0;
import gc.m;
import gc.n;
import java.util.List;
import java.util.Random;
import ya.x1;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends ad.b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Random f18639g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f18640h;

    public d(TrackGroup trackGroup, int... iArr) {
        super(trackGroup, iArr);
        Random random = new Random();
        this.f18639g = random;
        this.f18640h = random.nextInt(this.f556b);
    }

    @Override // com.google.android.exoplayer2.trackselection.b
    public int i() {
        return this.f18640h;
    }

    @Override // com.google.android.exoplayer2.trackselection.b
    public void m(long j10, long j11, long j12, List<? extends m> list, n[] nVarArr) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        int i10 = 0;
        for (int i11 = 0; i11 < this.f556b; i11++) {
            if (!v(i11, jElapsedRealtime)) {
                i10++;
            }
        }
        this.f18640h = this.f18639g.nextInt(i10);
        if (i10 != this.f556b) {
            int i12 = 0;
            for (int i13 = 0; i13 < this.f556b; i13++) {
                if (!v(i13, jElapsedRealtime)) {
                    int i14 = i12 + 1;
                    if (this.f18640h == i12) {
                        this.f18640h = i13;
                        return;
                    }
                    i12 = i14;
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.trackselection.b
    public int q() {
        return 3;
    }

    @Override // com.google.android.exoplayer2.trackselection.b
    @p0
    public Object s() {
        return null;
    }

    public static final class a implements b.InterfaceC0194b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Random f18641a;

        public a() {
            this.f18641a = new Random();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ b c(b.a aVar) {
            return new d(aVar.f18623a, aVar.f18624b, this.f18641a);
        }

        @Override // com.google.android.exoplayer2.trackselection.b.InterfaceC0194b
        public b[] a(b.a[] aVarArr, ed.d dVar, l.a aVar, x1 x1Var) {
            return e.a(aVarArr, new e.a() { // from class: ad.g
                @Override // com.google.android.exoplayer2.trackselection.e.a
                public final com.google.android.exoplayer2.trackselection.b a(b.a aVar2) {
                    return this.f565a.c(aVar2);
                }
            });
        }

        public a(int i10) {
            this.f18641a = new Random(i10);
        }
    }

    public d(TrackGroup trackGroup, int[] iArr, long j10) {
        this(trackGroup, iArr, new Random(j10));
    }

    public d(TrackGroup trackGroup, int[] iArr, Random random) {
        super(trackGroup, iArr);
        this.f18639g = random;
        this.f18640h = random.nextInt(this.f556b);
    }
}
