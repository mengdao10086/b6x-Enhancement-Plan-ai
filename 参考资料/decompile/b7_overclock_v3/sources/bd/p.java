package bd;

import android.util.SparseLongArray;
import g.v0;
import hd.u0;
import hd.v;
import ya.h1;

/* JADX INFO: loaded from: classes3.dex */
@v0(18)
public final class p implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseLongArray f9379a = new SparseLongArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f9380b;

    public void a(int i10, long j10) {
        long j11 = this.f9379a.get(i10, ya.g.f56663b);
        if (j11 == ya.g.f56663b || j10 > j11) {
            this.f9379a.put(i10, j10);
            if (j11 == ya.g.f56663b || j11 == this.f9380b) {
                this.f9380b = u0.P0(this.f9379a);
            }
        }
    }

    @Override // hd.v
    public void c(h1 h1Var) {
    }

    @Override // hd.v
    public h1 e() {
        return h1.f56784d;
    }

    @Override // hd.v
    public long n() {
        return this.f9380b;
    }
}
