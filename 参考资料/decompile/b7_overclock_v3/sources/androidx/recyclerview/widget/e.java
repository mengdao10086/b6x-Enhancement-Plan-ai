package androidx.recyclerview.widget;

import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import androidx.recyclerview.widget.e0;
import androidx.recyclerview.widget.f0;
import g.h1;
import g.j1;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public class e<T> {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f6879s = "AsyncListUtil";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final boolean f6880t = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<T> f6881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c<T> f6883c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f6884d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f0<T> f6885e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e0.b<T> f6886f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final e0.a<T> f6887g;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f6891k;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final e0.b<T> f6897q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final e0.a<T> f6898r;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int[] f6888h = new int[2];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int[] f6889i = new int[2];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int[] f6890j = new int[2];

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f6892l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f6893m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f6894n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f6895o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final SparseIntArray f6896p = new SparseIntArray();

    public class a implements e0.b<T> {
        public a() {
        }

        @Override // androidx.recyclerview.widget.e0.b
        public void a(int i10, f0.a<T> aVar) {
            if (!d(i10)) {
                e.this.f6887g.b(aVar);
                return;
            }
            f0.a<T> aVarA = e.this.f6885e.a(aVar);
            if (aVarA != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("duplicate tile @");
                sb2.append(aVarA.f6923b);
                e.this.f6887g.b(aVarA);
            }
            int i11 = aVar.f6923b + aVar.f6924c;
            int i12 = 0;
            while (i12 < e.this.f6896p.size()) {
                int iKeyAt = e.this.f6896p.keyAt(i12);
                if (aVar.f6923b > iKeyAt || iKeyAt >= i11) {
                    i12++;
                } else {
                    e.this.f6896p.removeAt(i12);
                    e.this.f6884d.d(iKeyAt);
                }
            }
        }

        @Override // androidx.recyclerview.widget.e0.b
        public void b(int i10, int i11) {
            if (d(i10)) {
                f0.a<T> aVarE = e.this.f6885e.e(i11);
                if (aVarE != null) {
                    e.this.f6887g.b(aVarE);
                    return;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("tile not found @");
                sb2.append(i11);
            }
        }

        @Override // androidx.recyclerview.widget.e0.b
        public void c(int i10, int i11) {
            if (d(i10)) {
                e eVar = e.this;
                eVar.f6893m = i11;
                eVar.f6884d.c();
                e eVar2 = e.this;
                eVar2.f6894n = eVar2.f6895o;
                e();
                e eVar3 = e.this;
                eVar3.f6891k = false;
                eVar3.g();
            }
        }

        public final boolean d(int i10) {
            return i10 == e.this.f6895o;
        }

        public final void e() {
            for (int i10 = 0; i10 < e.this.f6885e.f(); i10++) {
                e eVar = e.this;
                eVar.f6887g.b(eVar.f6885e.c(i10));
            }
            e.this.f6885e.b();
        }
    }

    public class b implements e0.a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public f0.a<T> f6900a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final SparseBooleanArray f6901b = new SparseBooleanArray();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f6902c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f6903d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f6904e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f6905f;

        public b() {
        }

        @Override // androidx.recyclerview.widget.e0.a
        public void a(int i10, int i11, int i12, int i13, int i14) {
            if (i10 > i11) {
                return;
            }
            int iH = h(i10);
            int iH2 = h(i11);
            this.f6904e = h(i12);
            int iH3 = h(i13);
            this.f6905f = iH3;
            if (i14 == 1) {
                l(this.f6904e, iH2, i14, true);
                l(iH2 + e.this.f6882b, this.f6905f, i14, false);
            } else {
                l(iH, iH3, i14, false);
                l(this.f6904e, iH - e.this.f6882b, i14, true);
            }
        }

        @Override // androidx.recyclerview.widget.e0.a
        public void b(f0.a<T> aVar) {
            e.this.f6883c.c(aVar.f6922a, aVar.f6924c);
            aVar.f6925d = this.f6900a;
            this.f6900a = aVar;
        }

        @Override // androidx.recyclerview.widget.e0.a
        public void c(int i10, int i11) {
            if (i(i10)) {
                return;
            }
            f0.a<T> aVarE = e();
            aVarE.f6923b = i10;
            int iMin = Math.min(e.this.f6882b, this.f6903d - i10);
            aVarE.f6924c = iMin;
            e.this.f6883c.a(aVarE.f6922a, aVarE.f6923b, iMin);
            g(i11);
            f(aVarE);
        }

        @Override // androidx.recyclerview.widget.e0.a
        public void d(int i10) {
            this.f6902c = i10;
            this.f6901b.clear();
            int iD = e.this.f6883c.d();
            this.f6903d = iD;
            e.this.f6886f.c(this.f6902c, iD);
        }

        public final f0.a<T> e() {
            f0.a<T> aVar = this.f6900a;
            if (aVar != null) {
                this.f6900a = aVar.f6925d;
                return aVar;
            }
            e eVar = e.this;
            return new f0.a<>(eVar.f6881a, eVar.f6882b);
        }

        public final void f(f0.a<T> aVar) {
            this.f6901b.put(aVar.f6923b, true);
            e.this.f6886f.a(this.f6902c, aVar);
        }

        public final void g(int i10) {
            int iB = e.this.f6883c.b();
            while (this.f6901b.size() >= iB) {
                int iKeyAt = this.f6901b.keyAt(0);
                SparseBooleanArray sparseBooleanArray = this.f6901b;
                int iKeyAt2 = sparseBooleanArray.keyAt(sparseBooleanArray.size() - 1);
                int i11 = this.f6904e - iKeyAt;
                int i12 = iKeyAt2 - this.f6905f;
                if (i11 > 0 && (i11 >= i12 || i10 == 2)) {
                    k(iKeyAt);
                } else {
                    if (i12 <= 0) {
                        return;
                    }
                    if (i11 >= i12 && i10 != 1) {
                        return;
                    } else {
                        k(iKeyAt2);
                    }
                }
            }
        }

        public final int h(int i10) {
            return i10 - (i10 % e.this.f6882b);
        }

        public final boolean i(int i10) {
            return this.f6901b.get(i10);
        }

        public final void j(String str, Object... objArr) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[BKGR] ");
            sb2.append(String.format(str, objArr));
        }

        public final void k(int i10) {
            this.f6901b.delete(i10);
            e.this.f6886f.b(this.f6902c, i10);
        }

        public final void l(int i10, int i11, int i12, boolean z10) {
            int i13 = i10;
            while (i13 <= i11) {
                e.this.f6887g.c(z10 ? (i11 + i10) - i13 : i13, i12);
                i13 += e.this.f6882b;
            }
        }
    }

    public static abstract class c<T> {
        @j1
        public abstract void a(@n0 T[] tArr, int i10, int i11);

        @j1
        public int b() {
            return 10;
        }

        @j1
        public void c(@n0 T[] tArr, int i10) {
        }

        @j1
        public abstract int d();
    }

    public static abstract class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f6907a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f6908b = 1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f6909c = 2;

        @h1
        public void a(@n0 int[] iArr, @n0 int[] iArr2, int i10) {
            int i11 = (iArr[1] - iArr[0]) + 1;
            int i12 = i11 / 2;
            iArr2[0] = iArr[0] - (i10 == 1 ? i11 : i12);
            int i13 = iArr[1];
            if (i10 != 2) {
                i11 = i12;
            }
            iArr2[1] = i13 + i11;
        }

        @h1
        public abstract void b(@n0 int[] iArr);

        @h1
        public abstract void c();

        @h1
        public abstract void d(int i10);
    }

    public e(@n0 Class<T> cls, int i10, @n0 c<T> cVar, @n0 d dVar) {
        a aVar = new a();
        this.f6897q = aVar;
        b bVar = new b();
        this.f6898r = bVar;
        this.f6881a = cls;
        this.f6882b = i10;
        this.f6883c = cVar;
        this.f6884d = dVar;
        this.f6885e = new f0<>(i10);
        u uVar = new u();
        this.f6886f = uVar.b(aVar);
        this.f6887g = uVar.a(bVar);
        f();
    }

    @p0
    public T a(int i10) {
        if (i10 < 0 || i10 >= this.f6893m) {
            throw new IndexOutOfBoundsException(i10 + " is not within 0 and " + this.f6893m);
        }
        T tD = this.f6885e.d(i10);
        if (tD == null && !c()) {
            this.f6896p.put(i10, 0);
        }
        return tD;
    }

    public int b() {
        return this.f6893m;
    }

    public final boolean c() {
        return this.f6895o != this.f6894n;
    }

    public void d(String str, Object... objArr) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[MAIN] ");
        sb2.append(String.format(str, objArr));
    }

    public void e() {
        if (c()) {
            return;
        }
        g();
        this.f6891k = true;
    }

    public void f() {
        this.f6896p.clear();
        e0.a<T> aVar = this.f6887g;
        int i10 = this.f6895o + 1;
        this.f6895o = i10;
        aVar.d(i10);
    }

    public void g() {
        this.f6884d.b(this.f6888h);
        int[] iArr = this.f6888h;
        if (iArr[0] > iArr[1] || iArr[0] < 0 || iArr[1] >= this.f6893m) {
            return;
        }
        if (this.f6891k) {
            int i10 = iArr[0];
            int[] iArr2 = this.f6889i;
            if (i10 > iArr2[1] || iArr2[0] > iArr[1]) {
                this.f6892l = 0;
            } else if (iArr[0] < iArr2[0]) {
                this.f6892l = 1;
            } else if (iArr[0] > iArr2[0]) {
                this.f6892l = 2;
            }
        } else {
            this.f6892l = 0;
        }
        int[] iArr3 = this.f6889i;
        iArr3[0] = iArr[0];
        iArr3[1] = iArr[1];
        this.f6884d.a(iArr, this.f6890j, this.f6892l);
        int[] iArr4 = this.f6890j;
        iArr4[0] = Math.min(this.f6888h[0], Math.max(iArr4[0], 0));
        int[] iArr5 = this.f6890j;
        iArr5[1] = Math.max(this.f6888h[1], Math.min(iArr5[1], this.f6893m - 1));
        e0.a<T> aVar = this.f6887g;
        int[] iArr6 = this.f6888h;
        int i11 = iArr6[0];
        int i12 = iArr6[1];
        int[] iArr7 = this.f6890j;
        aVar.a(i11, i12, iArr7[0], iArr7[1], this.f6892l);
    }
}
