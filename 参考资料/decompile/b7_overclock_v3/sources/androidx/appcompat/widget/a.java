package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends ViewGroup {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f2322i = 200;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f2323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f2324b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ActionMenuView f2325c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ActionMenuPresenter f2326d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2327e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public androidx.core.view.b1 f2328f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f2329g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f2330h;

    /* JADX INFO: renamed from: androidx.appcompat.widget.a$a, reason: collision with other inner class name */
    public class RunnableC0033a implements Runnable {
        public RunnableC0033a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.o();
        }
    }

    public class b implements androidx.core.view.c1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f2332a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2333b;

        public b() {
        }

        @Override // androidx.core.view.c1
        public void a(View view) {
            this.f2332a = true;
        }

        @Override // androidx.core.view.c1
        public void b(View view) {
            if (this.f2332a) {
                return;
            }
            a aVar = a.this;
            aVar.f2328f = null;
            a.super.setVisibility(this.f2333b);
        }

        @Override // androidx.core.view.c1
        public void c(View view) {
            a.super.setVisibility(0);
            this.f2332a = false;
        }

        public b d(androidx.core.view.b1 b1Var, int i10) {
            a.this.f2328f = b1Var;
            this.f2333b = i10;
            return this;
        }
    }

    public a(@g.n0 Context context) {
        this(context, null);
    }

    public static int k(int i10, int i11, boolean z10) {
        return z10 ? i10 - i11 : i10 + i11;
    }

    public void c(int i10) {
        n(i10, 200L).y();
    }

    public boolean d() {
        return i() && getVisibility() == 0;
    }

    public void e() {
        ActionMenuPresenter actionMenuPresenter = this.f2326d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.B();
        }
    }

    public boolean f() {
        ActionMenuPresenter actionMenuPresenter = this.f2326d;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.E();
        }
        return false;
    }

    public boolean g() {
        ActionMenuPresenter actionMenuPresenter = this.f2326d;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.G();
        }
        return false;
    }

    public int getAnimatedVisibility() {
        return this.f2328f != null ? this.f2323a.f2333b : getVisibility();
    }

    public int getContentHeight() {
        return this.f2327e;
    }

    public boolean h() {
        ActionMenuPresenter actionMenuPresenter = this.f2326d;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.H();
        }
        return false;
    }

    public boolean i() {
        ActionMenuPresenter actionMenuPresenter = this.f2326d;
        return actionMenuPresenter != null && actionMenuPresenter.I();
    }

    public int j(View view, int i10, int i11, int i12) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i10, Integer.MIN_VALUE), i11);
        return Math.max(0, (i10 - view.getMeasuredWidth()) - i12);
    }

    public int l(View view, int i10, int i11, int i12, boolean z10) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i13 = i11 + ((i12 - measuredHeight) / 2);
        if (z10) {
            view.layout(i10 - measuredWidth, i13, i10, measuredHeight + i13);
        } else {
            view.layout(i10, i13, i10 + measuredWidth, measuredHeight + i13);
        }
        return z10 ? -measuredWidth : measuredWidth;
    }

    public void m() {
        post(new RunnableC0033a());
    }

    public androidx.core.view.b1 n(int i10, long j10) {
        androidx.core.view.b1 b1Var = this.f2328f;
        if (b1Var != null) {
            b1Var.d();
        }
        if (i10 != 0) {
            androidx.core.view.b1 b1VarB = androidx.core.view.u0.g(this).b(0.0f);
            b1VarB.s(j10);
            b1VarB.u(this.f2323a.d(b1VarB, i10));
            return b1VarB;
        }
        if (getVisibility() != 0) {
            setAlpha(0.0f);
        }
        androidx.core.view.b1 b1VarB2 = androidx.core.view.u0.g(this).b(1.0f);
        b1VarB2.s(j10);
        b1VarB2.u(this.f2323a.d(b1VarB2, i10));
        return b1VarB2;
    }

    public boolean o() {
        ActionMenuPresenter actionMenuPresenter = this.f2326d;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.Q();
        }
        return false;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, R.styleable.ActionBar, R.attr.actionBarStyle, 0);
        setContentHeight(typedArrayObtainStyledAttributes.getLayoutDimension(R.styleable.ActionBar_height, 0));
        typedArrayObtainStyledAttributes.recycle();
        ActionMenuPresenter actionMenuPresenter = this.f2326d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.J(configuration);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f2330h = false;
        }
        if (!this.f2330h) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.f2330h = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f2330h = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f2329g = false;
        }
        if (!this.f2329g) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.f2329g = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f2329g = false;
        }
        return true;
    }

    public void setContentHeight(int i10) {
        this.f2327e = i10;
        requestLayout();
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        if (i10 != getVisibility()) {
            androidx.core.view.b1 b1Var = this.f2328f;
            if (b1Var != null) {
                b1Var.d();
            }
            super.setVisibility(i10);
        }
    }

    public a(@g.n0 Context context, @g.p0 AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(@g.n0 Context context, @g.p0 AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f2323a = new b();
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true) && typedValue.resourceId != 0) {
            this.f2324b = new ContextThemeWrapper(context, typedValue.resourceId);
        } else {
            this.f2324b = context;
        }
    }
}
