package gc;

import com.google.android.exoplayer2.source.r;
import gc.f;
import hb.d0;
import hd.t;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements f.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f29143c = "BaseMediaChunkOutput";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[] f29144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r[] f29145b;

    public c(int[] iArr, r[] rVarArr) {
        this.f29144a = iArr;
        this.f29145b = rVarArr;
    }

    public int[] a() {
        int[] iArr = new int[this.f29145b.length];
        int i10 = 0;
        while (true) {
            r[] rVarArr = this.f29145b;
            if (i10 >= rVarArr.length) {
                return iArr;
            }
            iArr[i10] = rVarArr[i10].G();
            i10++;
        }
    }

    public void b(long j10) {
        for (r rVar : this.f29145b) {
            rVar.a0(j10);
        }
    }

    @Override // gc.f.a
    public d0 d(int i10, int i11) {
        int i12 = 0;
        while (true) {
            int[] iArr = this.f29144a;
            if (i12 >= iArr.length) {
                t.d(f29143c, "Unmatched track of type: " + i11);
                return new hb.j();
            }
            if (i11 == iArr[i12]) {
                return this.f29145b[i12];
            }
            i12++;
        }
    }
}
