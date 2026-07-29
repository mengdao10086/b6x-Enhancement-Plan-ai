package qp;

import ir.i;

/* JADX INFO: loaded from: classes5.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f47545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f47546b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f47547c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f47548d;

    public b(int i10, i iVar, i iVar2, int i11) {
        if (!iVar.i().m(iVar2.i())) {
            throw new IllegalArgumentException("points need to be on the same curve");
        }
        this.f47547c = i10;
        this.f47545a = iVar;
        this.f47546b = iVar2;
        this.f47548d = i11;
    }

    public static int g(int i10) {
        int i11 = 0;
        while (true) {
            i10 >>= 1;
            if (i10 == 0) {
                return i11;
            }
            i11++;
        }
    }

    public int a() {
        return this.f47548d;
    }

    public int b() {
        return ((this.f47545a.i().v() - (g(this.f47548d) + 13)) / 8) * 8;
    }

    public i c() {
        return this.f47545a;
    }

    public i d() {
        return this.f47546b;
    }

    public int e() {
        return this.f47547c;
    }

    public int f() {
        return this.f47545a.i().v();
    }
}
