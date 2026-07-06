package a;

import android.annotation.SuppressLint;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ap implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<ap> f5627a = new ThreadLocal<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Comparator<bp> f93a = new zo();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f94a;
    public long b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<RecyclerView> f95a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public ArrayList<bp> f96b = new ArrayList<>();

    @SuppressLint({"VisibleForTests"})
    public static class a implements RecyclerView.o.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f5628a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public int[] f97a;
        public int b;
        public int c;

        @Override // androidx.recyclerview.widget.RecyclerView.o.a
        public void a(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i2 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            int i3 = this.c * 2;
            int[] iArr = this.f97a;
            if (iArr == null) {
                int[] iArr2 = new int[4];
                this.f97a = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i3 >= iArr.length) {
                int[] iArr3 = new int[i3 * 2];
                this.f97a = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            }
            int[] iArr4 = this.f97a;
            iArr4[i3] = i;
            iArr4[i3 + 1] = i2;
            this.c++;
        }

        public void b() {
            int[] iArr = this.f97a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.c = 0;
        }

        public void c(RecyclerView recyclerView, boolean z) {
            this.c = 0;
            int[] iArr = this.f97a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.o oVar = recyclerView.f4337a;
            if (recyclerView.f4332a == null || oVar == null || !oVar.z0()) {
                return;
            }
            if (z) {
                if (!recyclerView.f4320a.p()) {
                    oVar.z(recyclerView.f4332a.e(), this);
                }
            } else if (!recyclerView.m0()) {
                oVar.y(this.f5628a, this.b, recyclerView.f4330a, this);
            }
            int i = this.c;
            if (i > oVar.f8235a) {
                oVar.f8235a = i;
                oVar.f = z;
                recyclerView.f4341a.K();
            }
        }

        public boolean d(int i) {
            if (this.f97a != null) {
                int i2 = this.c * 2;
                for (int i3 = 0; i3 < i2; i3 += 2) {
                    if (this.f97a[i3] == i) {
                        return true;
                    }
                }
            }
            return false;
        }

        public void e(int i, int i2) {
            this.f5628a = i;
            this.b = i2;
        }
    }

    public static boolean e(RecyclerView recyclerView, int i) {
        int iJ = recyclerView.f4322a.j();
        for (int i2 = 0; i2 < iJ; i2++) {
            RecyclerView.d0 d0VarG0 = RecyclerView.g0(recyclerView.f4322a.i(i2));
            if (d0VarG0.f8228a == i && !d0VarG0.t()) {
                return true;
            }
        }
        return false;
    }

    public void a(RecyclerView recyclerView) {
        this.f95a.add(recyclerView);
    }

    public final void b() {
        bp bpVar;
        int size = this.f95a.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            RecyclerView recyclerView = this.f95a.get(i2);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.f4317a.c(recyclerView, false);
                i += recyclerView.f4317a.c;
            }
        }
        this.f96b.ensureCapacity(i);
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView recyclerView2 = this.f95a.get(i4);
            if (recyclerView2.getWindowVisibility() == 0) {
                a aVar = recyclerView2.f4317a;
                int iAbs = Math.abs(aVar.f5628a) + Math.abs(aVar.b);
                for (int i5 = 0; i5 < aVar.c * 2; i5 += 2) {
                    if (i3 >= this.f96b.size()) {
                        bpVar = new bp();
                        this.f96b.add(bpVar);
                    } else {
                        bpVar = this.f96b.get(i3);
                    }
                    int i6 = aVar.f97a[i5 + 1];
                    bpVar.f291a = i6 <= iAbs;
                    bpVar.f5721a = iAbs;
                    bpVar.b = i6;
                    bpVar.f290a = recyclerView2;
                    bpVar.c = aVar.f97a[i5];
                    i3++;
                }
            }
        }
        Collections.sort(this.f96b, f93a);
    }

    public final void c(bp bpVar, long j) {
        RecyclerView.d0 d0VarI = i(bpVar.f290a, bpVar.c, bpVar.f291a ? Long.MAX_VALUE : j);
        if (d0VarI == null || d0VarI.f4391a == null || !d0VarI.s() || d0VarI.t()) {
            return;
        }
        h(d0VarI.f4391a.get(), j);
    }

    public final void d(long j) {
        for (int i = 0; i < this.f96b.size(); i++) {
            bp bpVar = this.f96b.get(i);
            if (bpVar.f290a == null) {
                return;
            }
            c(bpVar, j);
            bpVar.a();
        }
    }

    public void f(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow() && this.f94a == 0) {
            this.f94a = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.f4317a.e(i, i2);
    }

    public void g(long j) {
        b();
        d(j);
    }

    public final void h(RecyclerView recyclerView, long j) {
        if (recyclerView == null) {
            return;
        }
        if (recyclerView.f4371k && recyclerView.f4322a.j() != 0) {
            recyclerView.T0();
        }
        a aVar = recyclerView.f4317a;
        aVar.c(recyclerView, true);
        if (aVar.c != 0) {
            try {
                ud.a("RV Nested Prefetch");
                recyclerView.f4330a.f(recyclerView.f4332a);
                for (int i = 0; i < aVar.c * 2; i += 2) {
                    i(recyclerView, aVar.f97a[i], j);
                }
            } finally {
                ud.b();
            }
        }
    }

    public final RecyclerView.d0 i(RecyclerView recyclerView, int i, long j) {
        if (e(recyclerView, i)) {
            return null;
        }
        RecyclerView.v vVar = recyclerView.f4341a;
        try {
            recyclerView.F0();
            RecyclerView.d0 d0VarI = vVar.I(i, false, j);
            if (d0VarI != null) {
                if (!d0VarI.s() || d0VarI.t()) {
                    vVar.a(d0VarI, false);
                } else {
                    vVar.B(d0VarI.f4387a);
                }
            }
            return d0VarI;
        } finally {
            recyclerView.H0(false);
        }
    }

    public void j(RecyclerView recyclerView) {
        this.f95a.remove(recyclerView);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            ud.a("RV Prefetch");
            if (!this.f95a.isEmpty()) {
                int size = this.f95a.size();
                long jMax = 0;
                for (int i = 0; i < size; i++) {
                    RecyclerView recyclerView = this.f95a.get(i);
                    if (recyclerView.getWindowVisibility() == 0) {
                        jMax = Math.max(recyclerView.getDrawingTime(), jMax);
                    }
                }
                if (jMax != 0) {
                    g(TimeUnit.MILLISECONDS.toNanos(jMax) + this.b);
                }
            }
        } finally {
            this.f94a = 0L;
            ud.b();
        }
    }
}
