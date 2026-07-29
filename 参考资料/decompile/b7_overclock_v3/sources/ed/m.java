package ed;

import g.p0;
import hd.u0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class m implements b {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f26918i = 100;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f26919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f26920b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @p0
    public final byte[] f26921c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a[] f26922d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f26923e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f26924f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f26925g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a[] f26926h;

    public m(boolean z10, int i10) {
        this(z10, i10, 0);
    }

    @Override // ed.b
    public synchronized void a(a[] aVarArr) {
        int i10 = this.f26925g;
        int length = aVarArr.length + i10;
        a[] aVarArr2 = this.f26926h;
        if (length >= aVarArr2.length) {
            this.f26926h = (a[]) Arrays.copyOf(aVarArr2, Math.max(aVarArr2.length * 2, i10 + aVarArr.length));
        }
        for (a aVar : aVarArr) {
            a[] aVarArr3 = this.f26926h;
            int i11 = this.f26925g;
            this.f26925g = i11 + 1;
            aVarArr3[i11] = aVar;
        }
        this.f26924f -= aVarArr.length;
        notifyAll();
    }

    @Override // ed.b
    public synchronized a b() {
        a aVar;
        this.f26924f++;
        int i10 = this.f26925g;
        if (i10 > 0) {
            a[] aVarArr = this.f26926h;
            int i11 = i10 - 1;
            this.f26925g = i11;
            aVar = (a) hd.a.g(aVarArr[i11]);
            this.f26926h[this.f26925g] = null;
        } else {
            aVar = new a(new byte[this.f26920b], 0);
        }
        return aVar;
    }

    @Override // ed.b
    public synchronized void c() {
        int i10 = 0;
        int iMax = Math.max(0, u0.m(this.f26923e, this.f26920b) - this.f26924f);
        int i11 = this.f26925g;
        if (iMax >= i11) {
            return;
        }
        if (this.f26921c != null) {
            int i12 = i11 - 1;
            while (i10 <= i12) {
                a aVar = (a) hd.a.g(this.f26926h[i10]);
                if (aVar.f26887a == this.f26921c) {
                    i10++;
                } else {
                    a aVar2 = (a) hd.a.g(this.f26926h[i12]);
                    if (aVar2.f26887a != this.f26921c) {
                        i12--;
                    } else {
                        a[] aVarArr = this.f26926h;
                        aVarArr[i10] = aVar2;
                        aVarArr[i12] = aVar;
                        i12--;
                        i10++;
                    }
                }
            }
            iMax = Math.max(iMax, i10);
            if (iMax >= this.f26925g) {
                return;
            }
        }
        Arrays.fill(this.f26926h, iMax, this.f26925g, (Object) null);
        this.f26925g = iMax;
    }

    @Override // ed.b
    public synchronized void d(a aVar) {
        a[] aVarArr = this.f26922d;
        aVarArr[0] = aVar;
        a(aVarArr);
    }

    @Override // ed.b
    public synchronized int e() {
        return this.f26924f * this.f26920b;
    }

    @Override // ed.b
    public int f() {
        return this.f26920b;
    }

    public synchronized void g() {
        if (this.f26919a) {
            h(0);
        }
    }

    public synchronized void h(int i10) {
        boolean z10 = i10 < this.f26923e;
        this.f26923e = i10;
        if (z10) {
            c();
        }
    }

    public m(boolean z10, int i10, int i11) {
        hd.a.a(i10 > 0);
        hd.a.a(i11 >= 0);
        this.f26919a = z10;
        this.f26920b = i10;
        this.f26925g = i11;
        this.f26926h = new a[i11 + 100];
        if (i11 > 0) {
            this.f26921c = new byte[i11 * i10];
            for (int i12 = 0; i12 < i11; i12++) {
                this.f26926h[i12] = new a(this.f26921c, i12 * i10);
            }
        } else {
            this.f26921c = null;
        }
        this.f26922d = new a[1];
    }
}
