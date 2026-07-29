package nb;

import android.util.Pair;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import hb.a0;
import hb.b0;
import hd.u0;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long[] f42023d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long[] f42024e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f42025f;

    public c(long[] jArr, long[] jArr2, long j10) {
        this.f42023d = jArr;
        this.f42024e = jArr2;
        this.f42025f = j10 == ya.g.f56663b ? ya.g.c(jArr2[jArr2.length - 1]) : j10;
    }

    public static c b(long j10, MlltFrame mlltFrame, long j11) {
        int length = mlltFrame.f17313e.length;
        int i10 = length + 1;
        long[] jArr = new long[i10];
        long[] jArr2 = new long[i10];
        jArr[0] = j10;
        long j12 = 0;
        jArr2[0] = 0;
        for (int i11 = 1; i11 <= length; i11++) {
            int i12 = i11 - 1;
            j10 += (long) (mlltFrame.f17311c + mlltFrame.f17313e[i12]);
            j12 += (long) (mlltFrame.f17312d + mlltFrame.f17314f[i12]);
            jArr[i11] = j10;
            jArr2[i11] = j12;
        }
        return new c(jArr, jArr2, j11);
    }

    public static Pair<Long, Long> c(long j10, long[] jArr, long[] jArr2) {
        int iJ = u0.j(jArr, j10, true, true);
        long j11 = jArr[iJ];
        long j12 = jArr2[iJ];
        int i10 = iJ + 1;
        if (i10 == jArr.length) {
            return Pair.create(Long.valueOf(j11), Long.valueOf(j12));
        }
        return Pair.create(Long.valueOf(j10), Long.valueOf(((long) ((jArr[i10] == j11 ? 0.0d : (j10 - j11) / (r6 - j11)) * (jArr2[i10] - j12))) + j12));
    }

    @Override // nb.g
    public long a(long j10) {
        return ya.g.c(((Long) c(j10, this.f42023d, this.f42024e).second).longValue());
    }

    @Override // nb.g
    public long d() {
        return -1L;
    }

    @Override // hb.a0
    public boolean e() {
        return true;
    }

    @Override // hb.a0
    public a0.a g(long j10) {
        Pair<Long, Long> pairC = c(ya.g.d(u0.u(j10, 0L, this.f42025f)), this.f42024e, this.f42023d);
        return new a0.a(new b0(ya.g.c(((Long) pairC.first).longValue()), ((Long) pairC.second).longValue()));
    }

    @Override // hb.a0
    public long h() {
        return this.f42025f;
    }
}
