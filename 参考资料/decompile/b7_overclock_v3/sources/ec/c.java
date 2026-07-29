package ec;

/* JADX INFO: loaded from: classes3.dex */
public class c implements com.google.android.exoplayer2.source.s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.android.exoplayer2.source.s[] f26819a;

    public c(com.google.android.exoplayer2.source.s[] sVarArr) {
        this.f26819a = sVarArr;
    }

    @Override // com.google.android.exoplayer2.source.s
    public final long b() {
        long jMin = Long.MAX_VALUE;
        for (com.google.android.exoplayer2.source.s sVar : this.f26819a) {
            long jB = sVar.b();
            if (jB != Long.MIN_VALUE) {
                jMin = Math.min(jMin, jB);
            }
        }
        if (jMin == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return jMin;
    }

    @Override // com.google.android.exoplayer2.source.s
    public boolean e(long j10) {
        boolean zE;
        boolean z10 = false;
        do {
            long jB = b();
            if (jB == Long.MIN_VALUE) {
                break;
            }
            zE = false;
            for (com.google.android.exoplayer2.source.s sVar : this.f26819a) {
                long jB2 = sVar.b();
                boolean z11 = jB2 != Long.MIN_VALUE && jB2 <= j10;
                if (jB2 == jB || z11) {
                    zE |= sVar.e(j10);
                }
            }
            z10 |= zE;
        } while (zE);
        return z10;
    }

    @Override // com.google.android.exoplayer2.source.s
    public final long f() {
        long jMin = Long.MAX_VALUE;
        for (com.google.android.exoplayer2.source.s sVar : this.f26819a) {
            long jF = sVar.f();
            if (jF != Long.MIN_VALUE) {
                jMin = Math.min(jMin, jF);
            }
        }
        if (jMin == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return jMin;
    }

    @Override // com.google.android.exoplayer2.source.s
    public final void g(long j10) {
        for (com.google.android.exoplayer2.source.s sVar : this.f26819a) {
            sVar.g(j10);
        }
    }

    @Override // com.google.android.exoplayer2.source.s
    public boolean isLoading() {
        for (com.google.android.exoplayer2.source.s sVar : this.f26819a) {
            if (sVar.isLoading()) {
                return true;
            }
        }
        return false;
    }
}
