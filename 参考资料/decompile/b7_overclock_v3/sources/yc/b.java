package yc;

import java.util.Collections;
import java.util.List;
import qc.f;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f57299b = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<qc.b> f57300a;

    public b(qc.b bVar) {
        this.f57300a = Collections.singletonList(bVar);
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
        return j10 >= 0 ? this.f57300a : Collections.emptyList();
    }

    @Override // qc.f
    public int f() {
        return 1;
    }

    public b() {
        this.f57300a = Collections.emptyList();
    }
}
