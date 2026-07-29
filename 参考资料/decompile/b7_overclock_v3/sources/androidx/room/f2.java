package androidx.room;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class f2 implements c2.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<Object> f7375a = new ArrayList();

    @Override // c2.f
    public void D(int i10, String str) {
        c(i10, str);
    }

    @Override // c2.f
    public void E0(int i10, byte[] bArr) {
        c(i10, bArr);
    }

    @Override // c2.f
    public void M1() {
        this.f7375a.clear();
    }

    @Override // c2.f
    public void R(int i10, double d10) {
        c(i10, Double.valueOf(d10));
    }

    public List<Object> a() {
        return this.f7375a;
    }

    public final void c(int i10, Object obj) {
        int i11 = i10 - 1;
        if (i11 >= this.f7375a.size()) {
            for (int size = this.f7375a.size(); size <= i11; size++) {
                this.f7375a.add(null);
            }
        }
        this.f7375a.set(i11, obj);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // c2.f
    public void l1(int i10) {
        c(i10, null);
    }

    @Override // c2.f
    public void s0(int i10, long j10) {
        c(i10, Long.valueOf(j10));
    }
}
