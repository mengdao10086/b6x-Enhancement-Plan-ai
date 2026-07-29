package androidx.appcompat.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ActionBarContextView extends androidx.appcompat.widget.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CharSequence f2016j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public CharSequence f2017k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f2018l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f2019m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f2020n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public LinearLayout f2021o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public TextView f2022p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public TextView f2023q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f2024r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f2025s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f2026t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f2027u;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l.b f2028a;

        public a(l.b bVar) {
            this.f2028a = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f2028a.c();
        }
    }

    public ActionBarContextView(@g.n0 Context context) {
        this(context, null);
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ void c(int i10) {
        super.c(i10);
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ boolean d() {
        return super.d();
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ void e() {
        super.e();
    }

    @Override // androidx.appcompat.widget.a
    public boolean f() {
        ActionMenuPresenter actionMenuPresenter = this.f2326d;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.E();
        }
        return false;
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ boolean g() {
        return super.g();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.f2017k;
    }

    public CharSequence getTitle() {
        return this.f2016j;
    }

    @Override // androidx.appcompat.widget.a
    public boolean h() {
        ActionMenuPresenter actionMenuPresenter = this.f2326d;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.H();
        }
        return false;
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ boolean i() {
        return super.i();
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ void m() {
        super.m();
    }

    @Override // androidx.appcompat.widget.a
    public /* bridge */ /* synthetic */ androidx.core.view.b1 n(int i10, long j10) {
        return super.n(i10, j10);
    }

    @Override // androidx.appcompat.widget.a
    public boolean o() {
        ActionMenuPresenter actionMenuPresenter = this.f2326d;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.Q();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActionMenuPresenter actionMenuPresenter = this.f2326d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.E();
            this.f2326d.F();
        }
    }

    @Override // androidx.appcompat.widget.a, android.view.View
    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        boolean zB = h1.b(this);
        int paddingRight = zB ? (i12 - i10) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i13 - i11) - getPaddingTop()) - getPaddingBottom();
        View view = this.f2018l;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f2018l.getLayoutParams();
            int i14 = zB ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i15 = zB ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int iK = androidx.appcompat.widget.a.k(paddingRight, i14, zB);
            paddingRight = androidx.appcompat.widget.a.k(iK + l(this.f2018l, iK, paddingTop, paddingTop2, zB), i15, zB);
        }
        int iL = paddingRight;
        LinearLayout linearLayout = this.f2021o;
        if (linearLayout != null && this.f2020n == null && linearLayout.getVisibility() != 8) {
            iL += l(this.f2021o, iL, paddingTop, paddingTop2, zB);
        }
        int i16 = iL;
        View view2 = this.f2020n;
        if (view2 != null) {
            l(view2, i16, paddingTop, paddingTop2, zB);
        }
        int paddingLeft = zB ? getPaddingLeft() : (i12 - i10) - getPaddingRight();
        ActionMenuView actionMenuView = this.f2325c;
        if (actionMenuView != null) {
            l(actionMenuView, paddingLeft, paddingTop, paddingTop2, !zB);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        if (View.MeasureSpec.getMode(i10) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        }
        if (View.MeasureSpec.getMode(i11) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
        int size = View.MeasureSpec.getSize(i10);
        int size2 = this.f2327e;
        if (size2 <= 0) {
            size2 = View.MeasureSpec.getSize(i11);
        }
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int iMin = size2 - paddingTop;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMin, Integer.MIN_VALUE);
        View view = this.f2018l;
        if (view != null) {
            int iJ = j(view, paddingLeft, iMakeMeasureSpec, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f2018l.getLayoutParams();
            paddingLeft = iJ - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        ActionMenuView actionMenuView = this.f2325c;
        if (actionMenuView != null && actionMenuView.getParent() == this) {
            paddingLeft = j(this.f2325c, paddingLeft, iMakeMeasureSpec, 0);
        }
        LinearLayout linearLayout = this.f2021o;
        if (linearLayout != null && this.f2020n == null) {
            if (this.f2026t) {
                this.f2021o.measure(View.MeasureSpec.makeMeasureSpec(0, 0), iMakeMeasureSpec);
                int measuredWidth = this.f2021o.getMeasuredWidth();
                boolean z10 = measuredWidth <= paddingLeft;
                if (z10) {
                    paddingLeft -= measuredWidth;
                }
                this.f2021o.setVisibility(z10 ? 0 : 8);
            } else {
                paddingLeft = j(linearLayout, paddingLeft, iMakeMeasureSpec, 0);
            }
        }
        View view2 = this.f2020n;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            int i12 = layoutParams.width;
            int i13 = i12 != -2 ? 1073741824 : Integer.MIN_VALUE;
            if (i12 >= 0) {
                paddingLeft = Math.min(i12, paddingLeft);
            }
            int i14 = layoutParams.height;
            int i15 = i14 == -2 ? Integer.MIN_VALUE : 1073741824;
            if (i14 >= 0) {
                iMin = Math.min(i14, iMin);
            }
            this.f2020n.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i13), View.MeasureSpec.makeMeasureSpec(iMin, i15));
        }
        if (this.f2327e > 0) {
            setMeasuredDimension(size, size2);
            return;
        }
        int childCount = getChildCount();
        int i16 = 0;
        for (int i17 = 0; i17 < childCount; i17++) {
            int measuredHeight = getChildAt(i17).getMeasuredHeight() + paddingTop;
            if (measuredHeight > i16) {
                i16 = measuredHeight;
            }
        }
        setMeasuredDimension(size, i16);
    }

    @Override // androidx.appcompat.widget.a, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public void p() {
        if (this.f2018l == null) {
            t();
        }
    }

    public void q(l.b bVar) {
        View view = this.f2018l;
        if (view == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(this.f2027u, (ViewGroup) this, false);
            this.f2018l = viewInflate;
            addView(viewInflate);
        } else if (view.getParent() == null) {
            addView(this.f2018l);
        }
        View viewFindViewById = this.f2018l.findViewById(R.id.action_mode_close_button);
        this.f2019m = viewFindViewById;
        viewFindViewById.setOnClickListener(new a(bVar));
        androidx.appcompat.view.menu.e eVar = (androidx.appcompat.view.menu.e) bVar.e();
        ActionMenuPresenter actionMenuPresenter = this.f2326d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.B();
        }
        ActionMenuPresenter actionMenuPresenter2 = new ActionMenuPresenter(getContext());
        this.f2326d = actionMenuPresenter2;
        actionMenuPresenter2.O(true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        eVar.c(this.f2326d, this.f2324b);
        ActionMenuView actionMenuView = (ActionMenuView) this.f2326d.m(this);
        this.f2325c = actionMenuView;
        androidx.core.view.u0.I1(actionMenuView, null);
        addView(this.f2325c, layoutParams);
    }

    public final void r() {
        if (this.f2021o == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.abc_action_bar_title_item, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f2021o = linearLayout;
            this.f2022p = (TextView) linearLayout.findViewById(R.id.action_bar_title);
            this.f2023q = (TextView) this.f2021o.findViewById(R.id.action_bar_subtitle);
            if (this.f2024r != 0) {
                this.f2022p.setTextAppearance(getContext(), this.f2024r);
            }
            if (this.f2025s != 0) {
                this.f2023q.setTextAppearance(getContext(), this.f2025s);
            }
        }
        this.f2022p.setText(this.f2016j);
        this.f2023q.setText(this.f2017k);
        boolean z10 = !TextUtils.isEmpty(this.f2016j);
        boolean z11 = !TextUtils.isEmpty(this.f2017k);
        int i10 = 0;
        this.f2023q.setVisibility(z11 ? 0 : 8);
        LinearLayout linearLayout2 = this.f2021o;
        if (!z10 && !z11) {
            i10 = 8;
        }
        linearLayout2.setVisibility(i10);
        if (this.f2021o.getParent() == null) {
            addView(this.f2021o);
        }
    }

    public boolean s() {
        return this.f2026t;
    }

    @Override // androidx.appcompat.widget.a
    public void setContentHeight(int i10) {
        this.f2327e = i10;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f2020n;
        if (view2 != null) {
            removeView(view2);
        }
        this.f2020n = view;
        if (view != null && (linearLayout = this.f2021o) != null) {
            removeView(linearLayout);
            this.f2021o = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f2017k = charSequence;
        r();
    }

    public void setTitle(CharSequence charSequence) {
        this.f2016j = charSequence;
        r();
        androidx.core.view.u0.E1(this, charSequence);
    }

    public void setTitleOptional(boolean z10) {
        if (z10 != this.f2026t) {
            requestLayout();
        }
        this.f2026t = z10;
    }

    @Override // androidx.appcompat.widget.a, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i10) {
        super.setVisibility(i10);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public void t() {
        removeAllViews();
        this.f2020n = null;
        this.f2325c = null;
        this.f2326d = null;
        View view = this.f2019m;
        if (view != null) {
            view.setOnClickListener(null);
        }
    }

    public ActionBarContextView(@g.n0 Context context, @g.p0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.actionModeStyle);
    }

    public ActionBarContextView(@g.n0 Context context, @g.p0 AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        y0 y0VarG = y0.G(context, attributeSet, R.styleable.ActionMode, i10, 0);
        androidx.core.view.u0.I1(this, y0VarG.h(R.styleable.ActionMode_background));
        this.f2024r = y0VarG.u(R.styleable.ActionMode_titleTextStyle, 0);
        this.f2025s = y0VarG.u(R.styleable.ActionMode_subtitleTextStyle, 0);
        this.f2327e = y0VarG.q(R.styleable.ActionMode_height, 0);
        this.f2027u = y0VarG.u(R.styleable.ActionMode_closeItemLayout, R.layout.abc_action_mode_close_item_material);
        y0VarG.I();
    }
}
