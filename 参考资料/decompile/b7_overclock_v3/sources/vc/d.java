package vc;

import hd.u0;
import java.util.Collections;
import java.util.List;
import qc.f;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<List<qc.b>> f52970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Long> f52971b;

    public d(List<List<qc.b>> list, List<Long> list2) {
        this.f52970a = list;
        this.f52971b = list2;
    }

    @Override // qc.f
    public int c(long j10) {
        int iD = u0.d(this.f52971b, Long.valueOf(j10), false, false);
        if (iD < this.f52971b.size()) {
            return iD;
        }
        return -1;
    }

    @Override // qc.f
    public long d(int i10) {
        hd.a.a(i10 >= 0);
        hd.a.a(i10 < this.f52971b.size());
        return this.f52971b.get(i10).longValue();
    }

    @Override // qc.f
    public List<qc.b> e(long j10) {
        int iH = u0.h(this.f52971b, Long.valueOf(j10), true, false);
        return iH == -1 ? Collections.emptyList() : this.f52970a.get(iH);
    }

    @Override // qc.f
    public int f() {
        return this.f52971b.size();
    }
}
