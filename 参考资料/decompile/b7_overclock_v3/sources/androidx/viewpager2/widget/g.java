package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import g.n0;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends RecyclerView.t {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f8249n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f8250o = 1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f8251p = 2;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f8252q = 3;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f8253r = 4;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f8254s = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewPager2.j f8255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final ViewPager2 f8256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final RecyclerView f8257c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final LinearLayoutManager f8258d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f8259e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f8260f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public a f8261g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f8262h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f8263i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f8264j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f8265k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f8266l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f8267m;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8268a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f8269b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f8270c;

        public void a() {
            this.f8268a = -1;
            this.f8269b = 0.0f;
            this.f8270c = 0;
        }
    }

    public g(@n0 ViewPager2 viewPager2) {
        this.f8256b = viewPager2;
        RecyclerView recyclerView = viewPager2.f8203j;
        this.f8257c = recyclerView;
        this.f8258d = (LinearLayoutManager) recyclerView.getLayoutManager();
        this.f8261g = new a();
        q();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.t
    public void a(@n0 RecyclerView recyclerView, int i10) {
        boolean z10 = true;
        if (!(this.f8259e == 1 && this.f8260f == 1) && i10 == 1) {
            s(false);
            return;
        }
        if (l() && i10 == 2) {
            if (this.f8265k) {
                e(2);
                this.f8264j = true;
                return;
            }
            return;
        }
        if (l() && i10 == 0) {
            t();
            if (this.f8265k) {
                a aVar = this.f8261g;
                if (aVar.f8270c == 0) {
                    int i11 = this.f8262h;
                    int i12 = aVar.f8268a;
                    if (i11 != i12) {
                        d(i12);
                    }
                } else {
                    z10 = false;
                }
            } else {
                int i13 = this.f8261g.f8268a;
                if (i13 != -1) {
                    c(i13, 0.0f, 0);
                }
            }
            if (z10) {
                e(0);
                q();
            }
        }
        if (this.f8259e == 2 && i10 == 0 && this.f8266l) {
            t();
            a aVar2 = this.f8261g;
            if (aVar2.f8270c == 0) {
                int i14 = this.f8263i;
                int i15 = aVar2.f8268a;
                if (i14 != i15) {
                    if (i15 == -1) {
                        i15 = 0;
                    }
                    d(i15);
                }
                e(0);
                q();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x002f  */
    @Override // androidx.recyclerview.widget.RecyclerView.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(@g.n0 androidx.recyclerview.widget.RecyclerView r4, int r5, int r6) {
        /*
            r3 = this;
            r4 = 1
            r3.f8265k = r4
            r3.t()
            boolean r0 = r3.f8264j
            r1 = -1
            r2 = 0
            if (r0 == 0) goto L3d
            r3.f8264j = r2
            if (r6 > 0) goto L22
            if (r6 != 0) goto L20
            if (r5 >= 0) goto L16
            r5 = 1
            goto L17
        L16:
            r5 = 0
        L17:
            androidx.viewpager2.widget.ViewPager2 r6 = r3.f8256b
            boolean r6 = r6.k()
            if (r5 != r6) goto L20
            goto L22
        L20:
            r5 = 0
            goto L23
        L22:
            r5 = 1
        L23:
            if (r5 == 0) goto L2f
            androidx.viewpager2.widget.g$a r5 = r3.f8261g
            int r6 = r5.f8270c
            if (r6 == 0) goto L2f
            int r5 = r5.f8268a
            int r5 = r5 + r4
            goto L33
        L2f:
            androidx.viewpager2.widget.g$a r5 = r3.f8261g
            int r5 = r5.f8268a
        L33:
            r3.f8263i = r5
            int r6 = r3.f8262h
            if (r6 == r5) goto L4b
            r3.d(r5)
            goto L4b
        L3d:
            int r5 = r3.f8259e
            if (r5 != 0) goto L4b
            androidx.viewpager2.widget.g$a r5 = r3.f8261g
            int r5 = r5.f8268a
            if (r5 != r1) goto L48
            r5 = 0
        L48:
            r3.d(r5)
        L4b:
            androidx.viewpager2.widget.g$a r5 = r3.f8261g
            int r6 = r5.f8268a
            if (r6 != r1) goto L52
            r6 = 0
        L52:
            float r0 = r5.f8269b
            int r5 = r5.f8270c
            r3.c(r6, r0, r5)
            androidx.viewpager2.widget.g$a r5 = r3.f8261g
            int r6 = r5.f8268a
            int r0 = r3.f8263i
            if (r6 == r0) goto L63
            if (r0 != r1) goto L71
        L63:
            int r5 = r5.f8270c
            if (r5 != 0) goto L71
            int r5 = r3.f8260f
            if (r5 == r4) goto L71
            r3.e(r2)
            r3.q()
        L71:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager2.widget.g.b(androidx.recyclerview.widget.RecyclerView, int, int):void");
    }

    public final void c(int i10, float f10, int i11) {
        ViewPager2.j jVar = this.f8255a;
        if (jVar != null) {
            jVar.b(i10, f10, i11);
        }
    }

    public final void d(int i10) {
        ViewPager2.j jVar = this.f8255a;
        if (jVar != null) {
            jVar.c(i10);
        }
    }

    public final void e(int i10) {
        if ((this.f8259e == 3 && this.f8260f == 0) || this.f8260f == i10) {
            return;
        }
        this.f8260f = i10;
        ViewPager2.j jVar = this.f8255a;
        if (jVar != null) {
            jVar.a(i10);
        }
    }

    public final int f() {
        return this.f8258d.y2();
    }

    public double g() {
        t();
        a aVar = this.f8261g;
        return ((double) aVar.f8268a) + ((double) aVar.f8269b);
    }

    public int h() {
        return this.f8260f;
    }

    public boolean i() {
        return this.f8260f == 1;
    }

    public boolean j() {
        return this.f8267m;
    }

    public boolean k() {
        return this.f8260f == 0;
    }

    public final boolean l() {
        int i10 = this.f8259e;
        return i10 == 1 || i10 == 4;
    }

    public void m() {
        this.f8259e = 4;
        s(true);
    }

    public void n() {
        this.f8266l = true;
    }

    public void o() {
        if (!i() || this.f8267m) {
            this.f8267m = false;
            t();
            a aVar = this.f8261g;
            if (aVar.f8270c != 0) {
                e(2);
                return;
            }
            int i10 = aVar.f8268a;
            if (i10 != this.f8262h) {
                d(i10);
            }
            e(0);
            q();
        }
    }

    public void p(int i10, boolean z10) {
        this.f8259e = z10 ? 2 : 3;
        this.f8267m = false;
        boolean z11 = this.f8263i != i10;
        this.f8263i = i10;
        e(2);
        if (z11) {
            d(i10);
        }
    }

    public final void q() {
        this.f8259e = 0;
        this.f8260f = 0;
        this.f8261g.a();
        this.f8262h = -1;
        this.f8263i = -1;
        this.f8264j = false;
        this.f8265k = false;
        this.f8267m = false;
        this.f8266l = false;
    }

    public void r(ViewPager2.j jVar) {
        this.f8255a = jVar;
    }

    public final void s(boolean z10) {
        this.f8267m = z10;
        this.f8259e = z10 ? 4 : 1;
        int i10 = this.f8263i;
        if (i10 != -1) {
            this.f8262h = i10;
            this.f8263i = -1;
        } else if (this.f8262h == -1) {
            this.f8262h = f();
        }
        e(1);
    }

    public final void t() {
        int top2;
        a aVar = this.f8261g;
        int iY2 = this.f8258d.y2();
        aVar.f8268a = iY2;
        if (iY2 == -1) {
            aVar.a();
            return;
        }
        View viewR = this.f8258d.R(iY2);
        if (viewR == null) {
            aVar.a();
            return;
        }
        int iR0 = this.f8258d.r0(viewR);
        int iW0 = this.f8258d.w0(viewR);
        int iZ0 = this.f8258d.z0(viewR);
        int iW = this.f8258d.W(viewR);
        ViewGroup.LayoutParams layoutParams = viewR.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            iR0 += marginLayoutParams.leftMargin;
            iW0 += marginLayoutParams.rightMargin;
            iZ0 += marginLayoutParams.topMargin;
            iW += marginLayoutParams.bottomMargin;
        }
        int height = viewR.getHeight() + iZ0 + iW;
        int width = viewR.getWidth() + iR0 + iW0;
        if (this.f8258d.Q2() == 0) {
            top2 = (viewR.getLeft() - iR0) - this.f8257c.getPaddingLeft();
            if (this.f8256b.k()) {
                top2 = -top2;
            }
            height = width;
        } else {
            top2 = (viewR.getTop() - iZ0) - this.f8257c.getPaddingTop();
        }
        int i10 = -top2;
        aVar.f8270c = i10;
        if (i10 >= 0) {
            aVar.f8269b = height == 0 ? 0.0f : i10 / height;
        } else {
            if (!new androidx.viewpager2.widget.a(this.f8258d).d()) {
                throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", Integer.valueOf(aVar.f8270c)));
            }
            throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
        }
    }
}
