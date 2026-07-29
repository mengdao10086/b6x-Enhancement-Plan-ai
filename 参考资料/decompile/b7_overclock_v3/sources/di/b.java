package di;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.core.view.u0;
import androidx.recyclerview.widget.RecyclerView;
import ei.i;
import eu.davidea.flexibleadapter.b;
import gi.d;

/* JADX INFO: loaded from: classes5.dex */
public final class b extends RecyclerView.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public eu.davidea.flexibleadapter.b f26267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RecyclerView f26268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ViewGroup f26269c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d f26270d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b.d0 f26271e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f26272f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f26273g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f26274h;

    public class a implements Animator.AnimatorListener {
        public a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            b.this.f26273g = true;
            b.this.f26269c.setAlpha(0.0f);
            b.this.j();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            b.this.f26272f = -1;
        }
    }

    public b(eu.davidea.flexibleadapter.b bVar, b.d0 d0Var, ViewGroup viewGroup) {
        this.f26267a = bVar;
        this.f26271e = d0Var;
        this.f26269c = viewGroup;
    }

    public static void g(ViewGroup viewGroup, View view) {
        try {
            viewGroup.addView(view);
        } catch (IllegalStateException unused) {
            fi.b.t("The specified child already has a parent! (but parent was removed!)", new Object[0]);
        }
    }

    public static void w(View view) {
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(view);
        }
    }

    public final void A() {
        float f10 = this.f26274h;
        int iMin = 0;
        int iMin2 = 0;
        for (int i10 = 0; i10 < this.f26268b.getChildCount(); i10++) {
            View childAt = this.f26268b.getChildAt(i10);
            if (childAt != null) {
                if (this.f26272f == s(this.f26268b.p0(childAt))) {
                    continue;
                } else if (this.f26267a.s().c() == 0) {
                    if (childAt.getLeft() > 0) {
                        int left = ((childAt.getLeft() - this.f26269c.getMeasuredWidth()) - this.f26268b.getLayoutManager().r0(childAt)) - this.f26268b.getLayoutManager().w0(childAt);
                        iMin = Math.min(left, 0);
                        if (left < 5) {
                            f10 = 0.0f;
                        }
                        if (iMin < 0) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else if (childAt.getTop() > 0) {
                    int top2 = ((childAt.getTop() - this.f26269c.getMeasuredHeight()) - this.f26268b.getLayoutManager().z0(childAt)) - this.f26268b.getLayoutManager().W(childAt);
                    iMin2 = Math.min(top2, 0);
                    if (top2 < 5) {
                        f10 = 0.0f;
                    }
                    if (iMin2 < 0) {
                        break;
                    }
                } else {
                    continue;
                }
            }
        }
        u0.N1(this.f26269c, f10);
        this.f26269c.setTranslationX(iMin);
        this.f26269c.setTranslationY(iMin2);
    }

    public final void B(int i10, boolean z10) {
        if (this.f26272f != i10 && this.f26269c != null) {
            int iB = this.f26267a.s().b();
            if (this.f26273g && this.f26272f == -1 && i10 != iB) {
                this.f26273g = false;
                this.f26269c.setAlpha(0.0f);
                this.f26269c.animate().alpha(1.0f).start();
            } else {
                this.f26269c.setAlpha(1.0f);
            }
            int i11 = this.f26272f;
            this.f26272f = i10;
            z(p(i10), i11);
        } else if (z10) {
            if (this.f26270d.getItemViewType() == this.f26267a.getItemViewType(i10)) {
                this.f26267a.onBindViewHolder(this.f26270d, i10);
            } else {
                fi.b.c("updateHeader Wrong itemViewType for StickyViewHolder=%s, PositionViewHolder=%s", fi.a.e(this.f26270d), fi.a.e(p(i10)));
            }
            o();
        }
        A();
    }

    public void C(boolean z10) {
        if (!this.f26267a.i1() || this.f26267a.getItemCount() == 0) {
            k();
            return;
        }
        int iS = s(-1);
        if (iS >= 0) {
            B(iS, z10);
        } else {
            j();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.t
    public void b(RecyclerView recyclerView, int i10, int i11) {
        this.f26273g = this.f26268b.getScrollState() == 0;
        C(false);
    }

    public final void h(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f26269c.getLayoutParams();
        marginLayoutParams.width = view.getLayoutParams().width;
        marginLayoutParams.height = view.getLayoutParams().height;
        if (marginLayoutParams.leftMargin == 0) {
            marginLayoutParams.leftMargin = this.f26268b.getLayoutManager().r0(this.f26270d.itemView);
        }
        if (marginLayoutParams.topMargin == 0) {
            marginLayoutParams.topMargin = this.f26268b.getLayoutManager().z0(this.f26270d.itemView);
        }
        if (marginLayoutParams.rightMargin == 0) {
            marginLayoutParams.rightMargin = this.f26268b.getLayoutManager().w0(this.f26270d.itemView);
        }
        if (marginLayoutParams.bottomMargin == 0) {
            marginLayoutParams.bottomMargin = this.f26268b.getLayoutManager().W(this.f26270d.itemView);
        }
    }

    public void i(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f26268b;
        if (recyclerView2 != null) {
            recyclerView2.u1(this);
            j();
        }
        if (recyclerView == null) {
            throw new IllegalStateException("Adapter is not attached to RecyclerView. Enable sticky headers after setting adapter to RecyclerView.");
        }
        this.f26268b = recyclerView;
        recyclerView.r(this);
        u();
    }

    public final void j() {
        if (this.f26270d != null) {
            fi.b.b("clearHeader", new Object[0]);
            x(this.f26270d);
            this.f26269c.setAlpha(0.0f);
            this.f26269c.animate().cancel();
            this.f26269c.animate().setListener(null);
            this.f26270d = null;
            y();
            int i10 = this.f26272f;
            this.f26272f = -1;
            v(-1, i10);
        }
    }

    public void k() {
        if (this.f26270d == null || this.f26272f == -1) {
            return;
        }
        this.f26269c.animate().setListener(new a());
        this.f26269c.animate().alpha(0.0f).start();
    }

    public final void l() {
        float fR = u0.R(this.f26270d.h());
        this.f26274h = fR;
        if (fR == 0.0f) {
            this.f26274h = this.f26268b.getContext().getResources().getDisplayMetrics().density * this.f26267a.w2();
        }
        if (this.f26274h > 0.0f) {
            u0.I1(this.f26269c, this.f26270d.h().getBackground());
        }
    }

    public final FrameLayout m(int i10, int i11) {
        FrameLayout frameLayout = new FrameLayout(this.f26268b.getContext());
        frameLayout.setLayoutParams(new ViewGroup.MarginLayoutParams(i10, i11));
        return frameLayout;
    }

    public void n() {
        this.f26268b.u1(this);
        this.f26268b = null;
        k();
        fi.b.b("StickyHolderLayout detached", new Object[0]);
    }

    public void o() {
        View viewH = this.f26270d.h();
        this.f26270d.itemView.getLayoutParams().width = viewH.getMeasuredWidth();
        this.f26270d.itemView.getLayoutParams().height = viewH.getMeasuredHeight();
        this.f26270d.itemView.setVisibility(4);
        h(viewH);
        w(viewH);
        g(this.f26269c, viewH);
        l();
    }

    public final d p(int i10) {
        int iMakeMeasureSpec;
        int iMakeMeasureSpec2;
        d dVar = (d) this.f26268b.g0(i10);
        if (dVar == null) {
            eu.davidea.flexibleadapter.b bVar = this.f26267a;
            dVar = (d) bVar.createViewHolder(this.f26268b, bVar.getItemViewType(i10));
            dVar.setIsRecyclable(false);
            this.f26267a.bindViewHolder(dVar, i10);
            dVar.setIsRecyclable(true);
            if (this.f26267a.s().c() == 1) {
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f26268b.getWidth(), 1073741824);
                iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.f26268b.getHeight(), 0);
            } else {
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f26268b.getWidth(), 0);
                iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(this.f26268b.getHeight(), 1073741824);
            }
            View viewH = dVar.h();
            viewH.measure(ViewGroup.getChildMeasureSpec(iMakeMeasureSpec, this.f26268b.getPaddingLeft() + this.f26268b.getPaddingRight(), viewH.getLayoutParams().width), ViewGroup.getChildMeasureSpec(iMakeMeasureSpec2, this.f26268b.getPaddingTop() + this.f26268b.getPaddingBottom(), viewH.getLayoutParams().height));
            viewH.layout(0, 0, viewH.getMeasuredWidth(), viewH.getMeasuredHeight());
        }
        dVar.j(i10);
        return dVar;
    }

    public final ViewGroup q(View view) {
        return (ViewGroup) view.getParent();
    }

    public int r() {
        return this.f26272f;
    }

    public final int s(int i10) {
        i iVarS2;
        if ((i10 == -1 && (i10 = this.f26267a.s().b()) == 0 && !t(0)) || (iVarS2 = this.f26267a.s2(i10)) == null || (this.f26267a.W2(iVarS2) && !this.f26267a.Y2(iVarS2))) {
            return -1;
        }
        return this.f26267a.d2(iVarS2);
    }

    public final boolean t(int i10) {
        RecyclerView.e0 e0VarG0 = this.f26268b.g0(i10);
        return e0VarG0 != null && (e0VarG0.itemView.getX() < 0.0f || e0VarG0.itemView.getY() < 0.0f);
    }

    public final void u() {
        if (this.f26269c == null) {
            ViewGroup viewGroupQ = q(this.f26268b);
            if (viewGroupQ != null) {
                FrameLayout frameLayoutM = m(-2, -2);
                this.f26269c = frameLayoutM;
                viewGroupQ.addView(frameLayoutM);
                fi.b.g("Default StickyHolderLayout initialized", new Object[0]);
            }
        } else {
            fi.b.g("User defined StickyHolderLayout initialized", new Object[0]);
        }
        this.f26273g = true;
        C(false);
    }

    public final void v(int i10, int i11) {
        b.d0 d0Var = this.f26271e;
        if (d0Var != null) {
            d0Var.a(i10, i11);
        }
    }

    public final void x(d dVar) {
        y();
        View viewH = dVar.h();
        w(viewH);
        viewH.setTranslationX(0.0f);
        viewH.setTranslationY(0.0f);
        if (!dVar.itemView.equals(viewH)) {
            g((ViewGroup) dVar.itemView, viewH);
        }
        dVar.setIsRecyclable(true);
        dVar.itemView.getLayoutParams().width = viewH.getLayoutParams().width;
        dVar.itemView.getLayoutParams().height = viewH.getLayoutParams().height;
    }

    public final void y() {
        if (this.f26268b == null) {
            return;
        }
        for (int i10 = 0; i10 < this.f26268b.getChildCount(); i10++) {
            View childAt = this.f26268b.getChildAt(i10);
            int iP0 = this.f26268b.p0(childAt);
            eu.davidea.flexibleadapter.b bVar = this.f26267a;
            if (bVar.b3(bVar.g2(iP0))) {
                childAt.setVisibility(0);
            }
        }
    }

    public final void z(d dVar, int i10) {
        fi.b.b("swapHeader newHeaderPosition=%s", Integer.valueOf(this.f26272f));
        d dVar2 = this.f26270d;
        if (dVar2 != null) {
            x(dVar2);
            if (this.f26272f > i10) {
                this.f26267a.onViewRecycled(this.f26270d);
            }
        }
        this.f26270d = dVar;
        dVar.setIsRecyclable(false);
        o();
        v(this.f26272f, i10);
    }
}
