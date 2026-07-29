package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f6926d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f6927e = "ChildrenHelper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f6928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f6929b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<View> f6930c = new ArrayList();

    public static class a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f6931c = 64;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final long f6932d = Long.MIN_VALUE;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f6933a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public a f6934b;

        public void a(int i10) {
            if (i10 < 64) {
                this.f6933a &= ~(1 << i10);
                return;
            }
            a aVar = this.f6934b;
            if (aVar != null) {
                aVar.a(i10 - 64);
            }
        }

        public int b(int i10) {
            a aVar = this.f6934b;
            return aVar == null ? i10 >= 64 ? Long.bitCount(this.f6933a) : Long.bitCount(this.f6933a & ((1 << i10) - 1)) : i10 < 64 ? Long.bitCount(this.f6933a & ((1 << i10) - 1)) : aVar.b(i10 - 64) + Long.bitCount(this.f6933a);
        }

        public final void c() {
            if (this.f6934b == null) {
                this.f6934b = new a();
            }
        }

        public boolean d(int i10) {
            if (i10 < 64) {
                return (this.f6933a & (1 << i10)) != 0;
            }
            c();
            return this.f6934b.d(i10 - 64);
        }

        public void e(int i10, boolean z10) {
            if (i10 >= 64) {
                c();
                this.f6934b.e(i10 - 64, z10);
                return;
            }
            long j10 = this.f6933a;
            boolean z11 = (Long.MIN_VALUE & j10) != 0;
            long j11 = (1 << i10) - 1;
            this.f6933a = ((j10 & (~j11)) << 1) | (j10 & j11);
            if (z10) {
                h(i10);
            } else {
                a(i10);
            }
            if (z11 || this.f6934b != null) {
                c();
                this.f6934b.e(0, z11);
            }
        }

        public boolean f(int i10) {
            if (i10 >= 64) {
                c();
                return this.f6934b.f(i10 - 64);
            }
            long j10 = 1 << i10;
            long j11 = this.f6933a;
            boolean z10 = (j11 & j10) != 0;
            long j12 = j11 & (~j10);
            this.f6933a = j12;
            long j13 = j10 - 1;
            this.f6933a = (j12 & j13) | Long.rotateRight((~j13) & j12, 1);
            a aVar = this.f6934b;
            if (aVar != null) {
                if (aVar.d(0)) {
                    h(63);
                }
                this.f6934b.f(0);
            }
            return z10;
        }

        public void g() {
            this.f6933a = 0L;
            a aVar = this.f6934b;
            if (aVar != null) {
                aVar.g();
            }
        }

        public void h(int i10) {
            if (i10 < 64) {
                this.f6933a |= 1 << i10;
            } else {
                c();
                this.f6934b.h(i10 - 64);
            }
        }

        public String toString() {
            if (this.f6934b == null) {
                return Long.toBinaryString(this.f6933a);
            }
            return this.f6934b.toString() + "xx" + Long.toBinaryString(this.f6933a);
        }
    }

    public interface b {
        View a(int i10);

        void addView(View view, int i10);

        void b(View view);

        int c();

        int d(View view);

        RecyclerView.e0 e(View view);

        void f(int i10);

        void g(View view);

        void h(View view, int i10, ViewGroup.LayoutParams layoutParams);

        void removeAllViews();

        void removeViewAt(int i10);
    }

    public g(b bVar) {
        this.f6928a = bVar;
    }

    public void a(View view, int i10, boolean z10) {
        int iC = i10 < 0 ? this.f6928a.c() : h(i10);
        this.f6929b.e(iC, z10);
        if (z10) {
            l(view);
        }
        this.f6928a.addView(view, iC);
    }

    public void b(View view, boolean z10) {
        a(view, -1, z10);
    }

    public void c(View view, int i10, ViewGroup.LayoutParams layoutParams, boolean z10) {
        int iC = i10 < 0 ? this.f6928a.c() : h(i10);
        this.f6929b.e(iC, z10);
        if (z10) {
            l(view);
        }
        this.f6928a.h(view, iC, layoutParams);
    }

    public void d(int i10) {
        int iH = h(i10);
        this.f6929b.f(iH);
        this.f6928a.f(iH);
    }

    public View e(int i10) {
        int size = this.f6930c.size();
        for (int i11 = 0; i11 < size; i11++) {
            View view = this.f6930c.get(i11);
            RecyclerView.e0 e0VarE = this.f6928a.e(view);
            if (e0VarE.getLayoutPosition() == i10 && !e0VarE.isInvalid() && !e0VarE.isRemoved()) {
                return view;
            }
        }
        return null;
    }

    public View f(int i10) {
        return this.f6928a.a(h(i10));
    }

    public int g() {
        return this.f6928a.c() - this.f6930c.size();
    }

    public final int h(int i10) {
        if (i10 < 0) {
            return -1;
        }
        int iC = this.f6928a.c();
        int i11 = i10;
        while (i11 < iC) {
            int iB = i10 - (i11 - this.f6929b.b(i11));
            if (iB == 0) {
                while (this.f6929b.d(i11)) {
                    i11++;
                }
                return i11;
            }
            i11 += iB;
        }
        return -1;
    }

    public View i(int i10) {
        return this.f6928a.a(i10);
    }

    public int j() {
        return this.f6928a.c();
    }

    public void k(View view) {
        int iD = this.f6928a.d(view);
        if (iD >= 0) {
            this.f6929b.h(iD);
            l(view);
        } else {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    public final void l(View view) {
        this.f6930c.add(view);
        this.f6928a.b(view);
    }

    public int m(View view) {
        int iD = this.f6928a.d(view);
        if (iD == -1 || this.f6929b.d(iD)) {
            return -1;
        }
        return iD - this.f6929b.b(iD);
    }

    public boolean n(View view) {
        return this.f6930c.contains(view);
    }

    public void o() {
        this.f6929b.g();
        for (int size = this.f6930c.size() - 1; size >= 0; size--) {
            this.f6928a.g(this.f6930c.get(size));
            this.f6930c.remove(size);
        }
        this.f6928a.removeAllViews();
    }

    public void p(View view) {
        int iD = this.f6928a.d(view);
        if (iD < 0) {
            return;
        }
        if (this.f6929b.f(iD)) {
            t(view);
        }
        this.f6928a.removeViewAt(iD);
    }

    public void q(int i10) {
        int iH = h(i10);
        View viewA = this.f6928a.a(iH);
        if (viewA == null) {
            return;
        }
        if (this.f6929b.f(iH)) {
            t(viewA);
        }
        this.f6928a.removeViewAt(iH);
    }

    public boolean r(View view) {
        int iD = this.f6928a.d(view);
        if (iD == -1) {
            t(view);
            return true;
        }
        if (!this.f6929b.d(iD)) {
            return false;
        }
        this.f6929b.f(iD);
        t(view);
        this.f6928a.removeViewAt(iD);
        return true;
    }

    public void s(View view) {
        int iD = this.f6928a.d(view);
        if (iD < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        if (this.f6929b.d(iD)) {
            this.f6929b.a(iD);
            t(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    public final boolean t(View view) {
        if (!this.f6930c.remove(view)) {
            return false;
        }
        this.f6928a.g(view);
        return true;
    }

    public String toString() {
        return this.f6929b.toString() + ", hidden list:" + this.f6930c.size();
    }
}
