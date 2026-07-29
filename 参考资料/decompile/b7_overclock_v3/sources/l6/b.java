package l6;

import m6.c;
import m6.d;

/* JADX INFO: loaded from: classes7.dex */
public class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final double f39460d = -36.0d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final double f39461e = 12.0d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a[] f39462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f39463b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f39464c = new c();

    public b(int i10) {
        this.f39462a = new a[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            this.f39462a[i11] = new a();
        }
        this.f39463b = 1;
        this.f39464c.p(-36.0d, 12.0d);
    }

    public a a(int i10) {
        if (i10 < 1) {
            i10 = 1;
        } else {
            a[] aVarArr = this.f39462a;
            if (i10 > aVarArr.length) {
                i10 = aVarArr.length;
            }
        }
        return this.f39462a[i10 - 1];
    }

    public a b() {
        return this.f39462a[this.f39463b - 1];
    }

    public d c() {
        return this.f39464c;
    }

    public int d() {
        return this.f39463b;
    }

    public void e() {
        for (a aVar : this.f39462a) {
            aVar.e();
        }
    }

    public void f(int i10) {
        if (i10 < 1) {
            i10 = 1;
        } else {
            a[] aVarArr = this.f39462a;
            if (i10 >= aVarArr.length) {
                i10 = aVarArr.length;
            }
        }
        this.f39463b = i10;
    }
}
