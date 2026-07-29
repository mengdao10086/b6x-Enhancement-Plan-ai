package ad;

import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import g.p0;
import gc.m;
import hd.u0;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b implements com.google.android.exoplayer2.trackselection.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TrackGroup f555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f556b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int[] f557c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Format[] f558d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long[] f559e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f560f;

    public b(TrackGroup trackGroup, int... iArr) {
        int i10 = 0;
        hd.a.i(iArr.length > 0);
        this.f555a = (TrackGroup) hd.a.g(trackGroup);
        int length = iArr.length;
        this.f556b = length;
        this.f558d = new Format[length];
        for (int i11 = 0; i11 < iArr.length; i11++) {
            this.f558d[i11] = trackGroup.a(iArr[i11]);
        }
        Arrays.sort(this.f558d, new Comparator() { // from class: ad.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return b.w((Format) obj, (Format) obj2);
            }
        });
        this.f557c = new int[this.f556b];
        while (true) {
            int i12 = this.f556b;
            if (i10 >= i12) {
                this.f559e = new long[i12];
                return;
            } else {
                this.f557c[i10] = trackGroup.b(this.f558d[i10]);
                i10++;
            }
        }
    }

    public static /* synthetic */ int w(Format format, Format format2) {
        return format2.f16694h - format.f16694h;
    }

    @Override // ad.h
    public final TrackGroup a() {
        return this.f555a;
    }

    @Override // ad.h
    public final Format b(int i10) {
        return this.f558d[i10];
    }

    @Override // ad.h
    public final int c(int i10) {
        return this.f557c[i10];
    }

    @Override // ad.h
    public final int d(Format format) {
        for (int i10 = 0; i10 < this.f556b; i10++) {
            if (this.f558d[i10] == format) {
                return i10;
            }
        }
        return -1;
    }

    @Override // ad.h
    public final int e(int i10) {
        for (int i11 = 0; i11 < this.f556b; i11++) {
            if (this.f557c[i11] == i10) {
                return i11;
            }
        }
        return -1;
    }

    public boolean equals(@p0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f555a == bVar.f555a && Arrays.equals(this.f557c, bVar.f557c);
    }

    @Override // com.google.android.exoplayer2.trackselection.b
    public void g() {
    }

    @Override // com.google.android.exoplayer2.trackselection.b
    public /* synthetic */ boolean h(long j10, gc.e eVar, List list) {
        return e.d(this, j10, eVar, list);
    }

    public int hashCode() {
        if (this.f560f == 0) {
            this.f560f = (System.identityHashCode(this.f555a) * 31) + Arrays.hashCode(this.f557c);
        }
        return this.f560f;
    }

    @Override // com.google.android.exoplayer2.trackselection.b
    public final boolean j(int i10, long j10) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        boolean zV = v(i10, jElapsedRealtime);
        int i11 = 0;
        while (i11 < this.f556b && !zV) {
            zV = (i11 == i10 || v(i11, jElapsedRealtime)) ? false : true;
            i11++;
        }
        if (!zV) {
            return false;
        }
        long[] jArr = this.f559e;
        jArr[i10] = Math.max(jArr[i10], u0.b(jElapsedRealtime, j10, Long.MAX_VALUE));
        return true;
    }

    @Override // com.google.android.exoplayer2.trackselection.b
    public /* synthetic */ void k(boolean z10) {
        e.b(this, z10);
    }

    @Override // com.google.android.exoplayer2.trackselection.b
    public void l() {
    }

    @Override // ad.h
    public final int length() {
        return this.f557c.length;
    }

    @Override // com.google.android.exoplayer2.trackselection.b
    public int n(long j10, List<? extends m> list) {
        return list.size();
    }

    @Override // com.google.android.exoplayer2.trackselection.b
    public final int o() {
        return this.f557c[i()];
    }

    @Override // com.google.android.exoplayer2.trackselection.b
    public final Format p() {
        return this.f558d[i()];
    }

    @Override // com.google.android.exoplayer2.trackselection.b
    public void r(float f10) {
    }

    @Override // com.google.android.exoplayer2.trackselection.b
    public /* synthetic */ void t() {
        e.a(this);
    }

    @Override // com.google.android.exoplayer2.trackselection.b
    public /* synthetic */ void u() {
        e.c(this);
    }

    public final boolean v(int i10, long j10) {
        return this.f559e[i10] > j10;
    }
}
