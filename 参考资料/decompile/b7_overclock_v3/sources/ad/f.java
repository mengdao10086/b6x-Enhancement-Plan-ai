package ad;

import com.google.android.exoplayer2.source.TrackGroup;
import g.p0;
import gc.m;
import gc.n;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f563g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @p0
    public final Object f564h;

    public f(TrackGroup trackGroup, int i10) {
        this(trackGroup, i10, 0, null);
    }

    @Override // com.google.android.exoplayer2.trackselection.b
    public int i() {
        return 0;
    }

    @Override // com.google.android.exoplayer2.trackselection.b
    public void m(long j10, long j11, long j12, List<? extends m> list, n[] nVarArr) {
    }

    @Override // com.google.android.exoplayer2.trackselection.b
    public int q() {
        return this.f563g;
    }

    @Override // com.google.android.exoplayer2.trackselection.b
    @p0
    public Object s() {
        return this.f564h;
    }

    public f(TrackGroup trackGroup, int i10, int i11, @p0 Object obj) {
        super(trackGroup, i10);
        this.f563g = i11;
        this.f564h = obj;
    }
}
