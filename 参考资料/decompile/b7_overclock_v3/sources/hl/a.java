package hl;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import dl.c;
import il.b;
import il.d;
import java.util.ArrayList;
import java.util.List;
import net.lucode.hackware.magicindicator.R;

/* JADX INFO: loaded from: classes5.dex */
public class a extends FrameLayout implements el.a, c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HorizontalScrollView f31344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinearLayout f31345b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinearLayout f31346c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public il.c f31347d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public il.a f31348e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f31349f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f31350g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f31351h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f31352i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f31353j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f31354k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f31355l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f31356m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f31357n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f31358o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f31359p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public List<kl.a> f31360q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public DataSetObserver f31361r;

    /* JADX INFO: renamed from: hl.a$a, reason: collision with other inner class name */
    public class C0368a extends DataSetObserver {
        public C0368a() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            a.this.f31349f.m(a.this.f31348e.a());
            a.this.l();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
        }
    }

    public a(Context context) {
        super(context);
        this.f31352i = 0.5f;
        this.f31353j = true;
        this.f31354k = true;
        this.f31359p = true;
        this.f31360q = new ArrayList();
        this.f31361r = new C0368a();
        c cVar = new c();
        this.f31349f = cVar;
        cVar.k(this);
    }

    @Override // dl.c.a
    public void a(int i10, int i11) {
        LinearLayout linearLayout = this.f31345b;
        if (linearLayout == null) {
            return;
        }
        KeyEvent.Callback childAt = linearLayout.getChildAt(i10);
        if (childAt instanceof d) {
            ((d) childAt).a(i10, i11);
        }
    }

    @Override // dl.c.a
    public void b(int i10, int i11, float f10, boolean z10) {
        LinearLayout linearLayout = this.f31345b;
        if (linearLayout == null) {
            return;
        }
        KeyEvent.Callback childAt = linearLayout.getChildAt(i10);
        if (childAt instanceof d) {
            ((d) childAt).b(i10, i11, f10, z10);
        }
    }

    @Override // dl.c.a
    public void c(int i10, int i11) {
        LinearLayout linearLayout = this.f31345b;
        if (linearLayout == null) {
            return;
        }
        KeyEvent.Callback childAt = linearLayout.getChildAt(i10);
        if (childAt instanceof d) {
            ((d) childAt).c(i10, i11);
        }
        if (this.f31350g || this.f31354k || this.f31344a == null || this.f31360q.size() <= 0) {
            return;
        }
        kl.a aVar = this.f31360q.get(Math.min(this.f31360q.size() - 1, i10));
        if (this.f31351h) {
            float fD = aVar.d() - (this.f31344a.getWidth() * this.f31352i);
            if (this.f31353j) {
                this.f31344a.smoothScrollTo((int) fD, 0);
                return;
            } else {
                this.f31344a.scrollTo((int) fD, 0);
                return;
            }
        }
        int scrollX = this.f31344a.getScrollX();
        int i12 = aVar.f37414a;
        if (scrollX > i12) {
            if (this.f31353j) {
                this.f31344a.smoothScrollTo(i12, 0);
                return;
            } else {
                this.f31344a.scrollTo(i12, 0);
                return;
            }
        }
        int scrollX2 = this.f31344a.getScrollX() + getWidth();
        int i13 = aVar.f37416c;
        if (scrollX2 < i13) {
            if (this.f31353j) {
                this.f31344a.smoothScrollTo(i13 - getWidth(), 0);
            } else {
                this.f31344a.scrollTo(i13 - getWidth(), 0);
            }
        }
    }

    @Override // dl.c.a
    public void d(int i10, int i11, float f10, boolean z10) {
        LinearLayout linearLayout = this.f31345b;
        if (linearLayout == null) {
            return;
        }
        KeyEvent.Callback childAt = linearLayout.getChildAt(i10);
        if (childAt instanceof d) {
            ((d) childAt).d(i10, i11, f10, z10);
        }
    }

    @Override // el.a
    public void e() {
        il.a aVar = this.f31348e;
        if (aVar != null) {
            aVar.e();
        }
    }

    @Override // el.a
    public void f() {
        l();
    }

    @Override // el.a
    public void g() {
    }

    public il.a getAdapter() {
        return this.f31348e;
    }

    public int getLeftPadding() {
        return this.f31356m;
    }

    public il.c getPagerIndicator() {
        return this.f31347d;
    }

    public int getRightPadding() {
        return this.f31355l;
    }

    public float getScrollPivotX() {
        return this.f31352i;
    }

    public LinearLayout getTitleContainer() {
        return this.f31345b;
    }

    public d k(int i10) {
        LinearLayout linearLayout = this.f31345b;
        if (linearLayout == null) {
            return null;
        }
        return (d) linearLayout.getChildAt(i10);
    }

    public final void l() {
        removeAllViews();
        View viewInflate = this.f31350g ? LayoutInflater.from(getContext()).inflate(R.layout.pager_navigator_layout_no_scroll, this) : LayoutInflater.from(getContext()).inflate(R.layout.pager_navigator_layout, this);
        this.f31344a = (HorizontalScrollView) viewInflate.findViewById(R.id.scroll_view);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.title_container);
        this.f31345b = linearLayout;
        linearLayout.setPadding(this.f31356m, 0, this.f31355l, 0);
        LinearLayout linearLayout2 = (LinearLayout) viewInflate.findViewById(R.id.indicator_container);
        this.f31346c = linearLayout2;
        if (this.f31357n) {
            linearLayout2.getParent().bringChildToFront(this.f31346c);
        }
        m();
    }

    public final void m() {
        LinearLayout.LayoutParams layoutParams;
        int iG = this.f31349f.g();
        for (int i10 = 0; i10 < iG; i10++) {
            Object objC = this.f31348e.c(getContext(), i10);
            if (objC instanceof View) {
                View view = (View) objC;
                if (this.f31350g) {
                    layoutParams = new LinearLayout.LayoutParams(0, -1);
                    layoutParams.weight = this.f31348e.d(getContext(), i10);
                } else {
                    layoutParams = new LinearLayout.LayoutParams(-2, -1);
                }
                this.f31345b.addView(view, layoutParams);
            }
        }
        il.a aVar = this.f31348e;
        if (aVar != null) {
            il.c cVarB = aVar.b(getContext());
            this.f31347d = cVarB;
            if (cVarB instanceof View) {
                this.f31346c.addView((View) this.f31347d, new FrameLayout.LayoutParams(-1, -1));
            }
        }
    }

    public boolean n() {
        return this.f31350g;
    }

    public boolean o() {
        return this.f31351h;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (this.f31348e != null) {
            u();
            il.c cVar = this.f31347d;
            if (cVar != null) {
                cVar.a(this.f31360q);
            }
            if (this.f31359p && this.f31349f.f() == 0) {
                onPageSelected(this.f31349f.e());
                onPageScrolled(this.f31349f.e(), 0.0f, 0);
            }
        }
    }

    @Override // el.a
    public void onPageScrollStateChanged(int i10) {
        if (this.f31348e != null) {
            this.f31349f.h(i10);
            il.c cVar = this.f31347d;
            if (cVar != null) {
                cVar.onPageScrollStateChanged(i10);
            }
        }
    }

    @Override // el.a
    public void onPageScrolled(int i10, float f10, int i11) {
        if (this.f31348e != null) {
            this.f31349f.i(i10, f10, i11);
            il.c cVar = this.f31347d;
            if (cVar != null) {
                cVar.onPageScrolled(i10, f10, i11);
            }
            if (this.f31344a == null || this.f31360q.size() <= 0 || i10 < 0 || i10 >= this.f31360q.size() || !this.f31354k) {
                return;
            }
            int iMin = Math.min(this.f31360q.size() - 1, i10);
            int iMin2 = Math.min(this.f31360q.size() - 1, i10 + 1);
            kl.a aVar = this.f31360q.get(iMin);
            kl.a aVar2 = this.f31360q.get(iMin2);
            float fD = aVar.d() - (this.f31344a.getWidth() * this.f31352i);
            this.f31344a.scrollTo((int) (fD + (((aVar2.d() - (this.f31344a.getWidth() * this.f31352i)) - fD) * f10)), 0);
        }
    }

    @Override // el.a
    public void onPageSelected(int i10) {
        if (this.f31348e != null) {
            this.f31349f.j(i10);
            il.c cVar = this.f31347d;
            if (cVar != null) {
                cVar.onPageSelected(i10);
            }
        }
    }

    public boolean p() {
        return this.f31354k;
    }

    public boolean q() {
        return this.f31357n;
    }

    public boolean r() {
        return this.f31359p;
    }

    public boolean s() {
        return this.f31358o;
    }

    public void setAdapter(il.a aVar) {
        il.a aVar2 = this.f31348e;
        if (aVar2 == aVar) {
            return;
        }
        if (aVar2 != null) {
            aVar2.h(this.f31361r);
        }
        this.f31348e = aVar;
        if (aVar == null) {
            this.f31349f.m(0);
            l();
            return;
        }
        aVar.g(this.f31361r);
        this.f31349f.m(this.f31348e.a());
        if (this.f31345b != null) {
            this.f31348e.e();
        }
    }

    public void setAdjustMode(boolean z10) {
        this.f31350g = z10;
    }

    public void setEnablePivotScroll(boolean z10) {
        this.f31351h = z10;
    }

    public void setFollowTouch(boolean z10) {
        this.f31354k = z10;
    }

    public void setIndicatorOnTop(boolean z10) {
        this.f31357n = z10;
    }

    public void setLeftPadding(int i10) {
        this.f31356m = i10;
    }

    public void setReselectWhenLayout(boolean z10) {
        this.f31359p = z10;
    }

    public void setRightPadding(int i10) {
        this.f31355l = i10;
    }

    public void setScrollPivotX(float f10) {
        this.f31352i = f10;
    }

    public void setSkimOver(boolean z10) {
        this.f31358o = z10;
        this.f31349f.l(z10);
    }

    public void setSmoothScroll(boolean z10) {
        this.f31353j = z10;
    }

    public boolean t() {
        return this.f31353j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void u() {
        this.f31360q.clear();
        int iG = this.f31349f.g();
        for (int i10 = 0; i10 < iG; i10++) {
            kl.a aVar = new kl.a();
            View childAt = this.f31345b.getChildAt(i10);
            if (childAt != 0) {
                aVar.f37414a = childAt.getLeft();
                aVar.f37415b = childAt.getTop();
                aVar.f37416c = childAt.getRight();
                int bottom = childAt.getBottom();
                aVar.f37417d = bottom;
                if (childAt instanceof b) {
                    b bVar = (b) childAt;
                    aVar.f37418e = bVar.getContentLeft();
                    aVar.f37419f = bVar.getContentTop();
                    aVar.f37420g = bVar.getContentRight();
                    aVar.f37421h = bVar.getContentBottom();
                } else {
                    aVar.f37418e = aVar.f37414a;
                    aVar.f37419f = aVar.f37415b;
                    aVar.f37420g = aVar.f37416c;
                    aVar.f37421h = bottom;
                }
            }
            this.f31360q.add(aVar);
        }
    }
}
