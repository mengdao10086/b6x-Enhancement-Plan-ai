package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.recyclerview.widget.RecyclerView;
import g.p0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ThreadLocal<l> f7093e = new ThreadLocal<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Comparator<c> f7094f = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f7096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f7097c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<RecyclerView> f7095a = new ArrayList<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList<c> f7098d = new ArrayList<>();

    public static class a implements Comparator<c> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(c cVar, c cVar2) {
            RecyclerView recyclerView = cVar.f7106d;
            if ((recyclerView == null) != (cVar2.f7106d == null)) {
                return recyclerView == null ? 1 : -1;
            }
            boolean z10 = cVar.f7103a;
            if (z10 != cVar2.f7103a) {
                return z10 ? -1 : 1;
            }
            int i10 = cVar2.f7104b - cVar.f7104b;
            if (i10 != 0) {
                return i10;
            }
            int i11 = cVar.f7105c - cVar2.f7105c;
            if (i11 != 0) {
                return i11;
            }
            return 0;
        }
    }

    @SuppressLint({"VisibleForTests"})
    public static class b implements RecyclerView.o.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7099a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f7100b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int[] f7101c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f7102d;

        @Override // androidx.recyclerview.widget.RecyclerView.o.c
        public void a(int i10, int i11) {
            if (i10 < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i11 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            int i12 = this.f7102d * 2;
            int[] iArr = this.f7101c;
            if (iArr == null) {
                int[] iArr2 = new int[4];
                this.f7101c = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i12 >= iArr.length) {
                int[] iArr3 = new int[i12 * 2];
                this.f7101c = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            }
            int[] iArr4 = this.f7101c;
            iArr4[i12] = i10;
            iArr4[i12 + 1] = i11;
            this.f7102d++;
        }

        public void b() {
            int[] iArr = this.f7101c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f7102d = 0;
        }

        public void c(RecyclerView recyclerView, boolean z10) {
            this.f7102d = 0;
            int[] iArr = this.f7101c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.o oVar = recyclerView.f6625m;
            if (recyclerView.f6623l == null || oVar == null || !oVar.K0()) {
                return;
            }
            if (z10) {
                if (!recyclerView.f6605d.q()) {
                    oVar.A(recyclerView.f6623l.getItemCount(), this);
                }
            } else if (!recyclerView.D0()) {
                oVar.z(this.f7099a, this.f7100b, recyclerView.V7, this);
            }
            int i10 = this.f7102d;
            if (i10 > oVar.f6723m) {
                oVar.f6723m = i10;
                oVar.f6724n = z10;
                recyclerView.f6601b.L();
            }
        }

        public boolean d(int i10) {
            if (this.f7101c != null) {
                int i11 = this.f7102d * 2;
                for (int i12 = 0; i12 < i11; i12 += 2) {
                    if (this.f7101c[i12] == i10) {
                        return true;
                    }
                }
            }
            return false;
        }

        public void e(int i10, int i11) {
            this.f7099a = i10;
            this.f7100b = i11;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f7103a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f7104b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f7105c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public RecyclerView f7106d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f7107e;

        public void a() {
            this.f7103a = false;
            this.f7104b = 0;
            this.f7105c = 0;
            this.f7106d = null;
            this.f7107e = 0;
        }
    }

    public static boolean e(RecyclerView recyclerView, int i10) {
        int iJ = recyclerView.f6607e.j();
        for (int i11 = 0; i11 < iJ; i11++) {
            RecyclerView.e0 e0VarU0 = RecyclerView.u0(recyclerView.f6607e.i(i11));
            if (e0VarU0.mPosition == i10 && !e0VarU0.isInvalid()) {
                return true;
            }
        }
        return false;
    }

    public void a(RecyclerView recyclerView) {
        this.f7095a.add(recyclerView);
    }

    public final void b() {
        c cVar;
        int size = this.f7095a.size();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            RecyclerView recyclerView = this.f7095a.get(i11);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.U7.c(recyclerView, false);
                i10 += recyclerView.U7.f7102d;
            }
        }
        this.f7098d.ensureCapacity(i10);
        int i12 = 0;
        for (int i13 = 0; i13 < size; i13++) {
            RecyclerView recyclerView2 = this.f7095a.get(i13);
            if (recyclerView2.getWindowVisibility() == 0) {
                b bVar = recyclerView2.U7;
                int iAbs = Math.abs(bVar.f7099a) + Math.abs(bVar.f7100b);
                for (int i14 = 0; i14 < bVar.f7102d * 2; i14 += 2) {
                    if (i12 >= this.f7098d.size()) {
                        cVar = new c();
                        this.f7098d.add(cVar);
                    } else {
                        cVar = this.f7098d.get(i12);
                    }
                    int[] iArr = bVar.f7101c;
                    int i15 = iArr[i14 + 1];
                    cVar.f7103a = i15 <= iAbs;
                    cVar.f7104b = iAbs;
                    cVar.f7105c = i15;
                    cVar.f7106d = recyclerView2;
                    cVar.f7107e = iArr[i14];
                    i12++;
                }
            }
        }
        Collections.sort(this.f7098d, f7094f);
    }

    public final void c(c cVar, long j10) {
        RecyclerView.e0 e0VarI = i(cVar.f7106d, cVar.f7107e, cVar.f7103a ? Long.MAX_VALUE : j10);
        if (e0VarI == null || e0VarI.mNestedRecyclerView == null || !e0VarI.isBound() || e0VarI.isInvalid()) {
            return;
        }
        h(e0VarI.mNestedRecyclerView.get(), j10);
    }

    public final void d(long j10) {
        for (int i10 = 0; i10 < this.f7098d.size(); i10++) {
            c cVar = this.f7098d.get(i10);
            if (cVar.f7106d == null) {
                return;
            }
            c(cVar, j10);
            cVar.a();
        }
    }

    public void f(RecyclerView recyclerView, int i10, int i11) {
        if (recyclerView.isAttachedToWindow() && this.f7096b == 0) {
            this.f7096b = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.U7.e(i10, i11);
    }

    public void g(long j10) {
        b();
        d(j10);
    }

    public final void h(@p0 RecyclerView recyclerView, long j10) {
        if (recyclerView == null) {
            return;
        }
        if (recyclerView.D && recyclerView.f6607e.j() != 0) {
            recyclerView.o1();
        }
        b bVar = recyclerView.U7;
        bVar.c(recyclerView, true);
        if (bVar.f7102d != 0) {
            try {
                androidx.core.os.y.b(RecyclerView.N8);
                recyclerView.V7.k(recyclerView.f6623l);
                for (int i10 = 0; i10 < bVar.f7102d * 2; i10 += 2) {
                    i(recyclerView, bVar.f7101c[i10], j10);
                }
            } finally {
                androidx.core.os.y.d();
            }
        }
    }

    public final RecyclerView.e0 i(RecyclerView recyclerView, int i10, long j10) {
        if (e(recyclerView, i10)) {
            return null;
        }
        RecyclerView.w wVar = recyclerView.f6601b;
        try {
            recyclerView.a1();
            RecyclerView.e0 e0VarJ = wVar.J(i10, false, j10);
            if (e0VarJ != null) {
                if (!e0VarJ.isBound() || e0VarJ.isInvalid()) {
                    wVar.a(e0VarJ, false);
                } else {
                    wVar.C(e0VarJ.itemView);
                }
            }
            return e0VarJ;
        } finally {
            recyclerView.c1(false);
        }
    }

    public void j(RecyclerView recyclerView) {
        this.f7095a.remove(recyclerView);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            androidx.core.os.y.b(RecyclerView.M8);
            if (!this.f7095a.isEmpty()) {
                int size = this.f7095a.size();
                long jMax = 0;
                for (int i10 = 0; i10 < size; i10++) {
                    RecyclerView recyclerView = this.f7095a.get(i10);
                    if (recyclerView.getWindowVisibility() == 0) {
                        jMax = Math.max(recyclerView.getDrawingTime(), jMax);
                    }
                }
                if (jMax != 0) {
                    g(TimeUnit.MILLISECONDS.toNanos(jMax) + this.f7097c);
                }
            }
        } finally {
            this.f7096b = 0L;
            androidx.core.os.y.d();
        }
    }
}
