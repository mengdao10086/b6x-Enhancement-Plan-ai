package zc;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements qc.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<qc.b> f58341a;

    public c(List<qc.b> list) {
        this.f58341a = Collections.unmodifiableList(list);
    }

    @Override // qc.f
    public int c(long j10) {
        return j10 < 0 ? 0 : -1;
    }

    @Override // qc.f
    public long d(int i10) {
        hd.a.a(i10 == 0);
        return 0L;
    }

    @Override // qc.f
    public List<qc.b> e(long j10) {
        return j10 >= 0 ? this.f58341a : Collections.emptyList();
    }

    @Override // qc.f
    public int f() {
        return 1;
    }
}
