package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.app.a;
import androidx.appcompat.widget.i0;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class q0 extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f2634l = "ScrollingTabContainerView";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Interpolator f2635m = new DecelerateInterpolator();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f2636n = 200;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Runnable f2637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f2638b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public i0 f2639c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Spinner f2640d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f2641e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2642f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2643g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f2644h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f2645i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ViewPropertyAnimator f2646j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final e f2647k;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f2648a;

        public a(View view) {
            this.f2648a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            q0.this.smoothScrollTo(this.f2648a.getLeft() - ((q0.this.getWidth() - this.f2648a.getWidth()) / 2), 0);
            q0.this.f2637a = null;
        }
    }

    public class b extends BaseAdapter {
        public b() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return q0.this.f2639c.getChildCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i10) {
            return ((d) q0.this.f2639c.getChildAt(i10)).b();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i10) {
            return i10;
        }

        @Override // android.widget.Adapter
        public View getView(int i10, View view, ViewGroup viewGroup) {
            if (view == null) {
                return q0.this.g((a.f) getItem(i10), true);
            }
            ((d) view).a((a.f) getItem(i10));
            return view;
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((d) view).b().g();
            int childCount = q0.this.f2639c.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = q0.this.f2639c.getChildAt(i10);
                childAt.setSelected(childAt == view);
            }
        }
    }

    public class d extends LinearLayout {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final String f2652g = "androidx.appcompat.app.ActionBar$Tab";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int[] f2653a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public a.f f2654b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public TextView f2655c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ImageView f2656d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public View f2657e;

        /* JADX WARN: Illegal instructions before constructor call */
        public d(Context context, a.f fVar, boolean z10) {
            int i10 = R.attr.actionBarTabStyle;
            super(context, null, i10);
            int[] iArr = {android.R.attr.background};
            this.f2653a = iArr;
            this.f2654b = fVar;
            y0 y0VarG = y0.G(context, null, iArr, i10, 0);
            if (y0VarG.C(0)) {
                setBackgroundDrawable(y0VarG.h(0));
            }
            y0VarG.I();
            if (z10) {
                setGravity(8388627);
            }
            c();
        }

        public void a(a.f fVar) {
            this.f2654b = fVar;
            c();
        }

        public a.f b() {
            return this.f2654b;
        }

        public void c() {
            a.f fVar = this.f2654b;
            View viewB = fVar.b();
            if (viewB != null) {
                ViewParent parent = viewB.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(viewB);
                    }
                    addView(viewB);
                }
                this.f2657e = viewB;
                TextView textView = this.f2655c;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f2656d;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f2656d.setImageDrawable(null);
                    return;
                }
                return;
            }
            View view = this.f2657e;
            if (view != null) {
                removeView(view);
                this.f2657e = null;
            }
            Drawable drawableC = fVar.c();
            CharSequence charSequenceF = fVar.f();
            if (drawableC != null) {
                if (this.f2656d == null) {
                    AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    appCompatImageView.setLayoutParams(layoutParams);
                    addView(appCompatImageView, 0);
                    this.f2656d = appCompatImageView;
                }
                this.f2656d.setImageDrawable(drawableC);
                this.f2656d.setVisibility(0);
            } else {
                ImageView imageView2 = this.f2656d;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.f2656d.setImageDrawable(null);
                }
            }
            boolean z10 = !TextUtils.isEmpty(charSequenceF);
            if (z10) {
                if (this.f2655c == null) {
                    AppCompatTextView appCompatTextView = new AppCompatTextView(getContext(), null, R.attr.actionBarTabTextStyle);
                    appCompatTextView.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    appCompatTextView.setLayoutParams(layoutParams2);
                    addView(appCompatTextView);
                    this.f2655c = appCompatTextView;
                }
                this.f2655c.setText(charSequenceF);
                this.f2655c.setVisibility(0);
            } else {
                TextView textView2 = this.f2655c;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    this.f2655c.setText((CharSequence) null);
                }
            }
            ImageView imageView3 = this.f2656d;
            if (imageView3 != null) {
                imageView3.setContentDescription(fVar.a());
            }
            b1.a(this, z10 ? null : fVar.a());
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(f2652g);
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(f2652g);
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i10, int i11) {
            super.onMeasure(i10, i11);
            if (q0.this.f2642f > 0) {
                int measuredWidth = getMeasuredWidth();
                int i12 = q0.this.f2642f;
                if (measuredWidth > i12) {
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(i12, 1073741824), i11);
                }
            }
        }

        @Override // android.view.View
        public void setSelected(boolean z10) {
            boolean z11 = isSelected() != z10;
            super.setSelected(z10);
            if (z11 && z10) {
                sendAccessibilityEvent(4);
            }
        }
    }

    public class e extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f2659a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2660b;

        public e() {
        }

        public e a(ViewPropertyAnimator viewPropertyAnimator, int i10) {
            this.f2660b = i10;
            q0.this.f2646j = viewPropertyAnimator;
            return this;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f2659a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f2659a) {
                return;
            }
            q0 q0Var = q0.this;
            q0Var.f2646j = null;
            q0Var.setVisibility(this.f2660b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            q0.this.setVisibility(0);
            this.f2659a = false;
        }
    }

    public q0(@g.n0 Context context) {
        super(context);
        this.f2647k = new e();
        setHorizontalScrollBarEnabled(false);
        l.a aVarB = l.a.b(context);
        setContentHeight(aVarB.f());
        this.f2643g = aVarB.e();
        i0 i0VarF = f();
        this.f2639c = i0VarF;
        addView(i0VarF, new ViewGroup.LayoutParams(-2, -1));
    }

    public void a(a.f fVar, int i10, boolean z10) {
        d dVarG = g(fVar, false);
        this.f2639c.addView(dVarG, i10, new i0.b(0, -1, 1.0f));
        Spinner spinner = this.f2640d;
        if (spinner != null) {
            ((b) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (z10) {
            dVarG.setSelected(true);
        }
        if (this.f2641e) {
            requestLayout();
        }
    }

    public void b(a.f fVar, boolean z10) {
        d dVarG = g(fVar, false);
        this.f2639c.addView(dVarG, new i0.b(0, -1, 1.0f));
        Spinner spinner = this.f2640d;
        if (spinner != null) {
            ((b) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (z10) {
            dVarG.setSelected(true);
        }
        if (this.f2641e) {
            requestLayout();
        }
    }

    public void c(int i10) {
        View childAt = this.f2639c.getChildAt(i10);
        Runnable runnable = this.f2637a;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        a aVar = new a(childAt);
        this.f2637a = aVar;
        post(aVar);
    }

    public void d(int i10) {
        ViewPropertyAnimator viewPropertyAnimator = this.f2646j;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
        if (i10 != 0) {
            ViewPropertyAnimator viewPropertyAnimatorAlpha = animate().alpha(0.0f);
            viewPropertyAnimatorAlpha.setDuration(200L);
            viewPropertyAnimatorAlpha.setInterpolator(f2635m);
            viewPropertyAnimatorAlpha.setListener(this.f2647k.a(viewPropertyAnimatorAlpha, i10));
            viewPropertyAnimatorAlpha.start();
            return;
        }
        if (getVisibility() != 0) {
            setAlpha(0.0f);
        }
        ViewPropertyAnimator viewPropertyAnimatorAlpha2 = animate().alpha(1.0f);
        viewPropertyAnimatorAlpha2.setDuration(200L);
        viewPropertyAnimatorAlpha2.setInterpolator(f2635m);
        viewPropertyAnimatorAlpha2.setListener(this.f2647k.a(viewPropertyAnimatorAlpha2, i10));
        viewPropertyAnimatorAlpha2.start();
    }

    public final Spinner e() {
        AppCompatSpinner appCompatSpinner = new AppCompatSpinner(getContext(), null, R.attr.actionDropDownStyle);
        appCompatSpinner.setLayoutParams(new i0.b(-2, -1));
        appCompatSpinner.setOnItemSelectedListener(this);
        return appCompatSpinner;
    }

    public final i0 f() {
        i0 i0Var = new i0(getContext(), null, R.attr.actionBarTabBarStyle);
        i0Var.setMeasureWithLargestChildEnabled(true);
        i0Var.setGravity(17);
        i0Var.setLayoutParams(new i0.b(-2, -1));
        return i0Var;
    }

    public d g(a.f fVar, boolean z10) {
        d dVar = new d(getContext(), fVar, z10);
        if (z10) {
            dVar.setBackgroundDrawable(null);
            dVar.setLayoutParams(new AbsListView.LayoutParams(-1, this.f2644h));
        } else {
            dVar.setFocusable(true);
            if (this.f2638b == null) {
                this.f2638b = new c();
            }
            dVar.setOnClickListener(this.f2638b);
        }
        return dVar;
    }

    public final boolean h() {
        Spinner spinner = this.f2640d;
        return spinner != null && spinner.getParent() == this;
    }

    public final void i() {
        if (h()) {
            return;
        }
        if (this.f2640d == null) {
            this.f2640d = e();
        }
        removeView(this.f2639c);
        addView(this.f2640d, new ViewGroup.LayoutParams(-2, -1));
        if (this.f2640d.getAdapter() == null) {
            this.f2640d.setAdapter((SpinnerAdapter) new b());
        }
        Runnable runnable = this.f2637a;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.f2637a = null;
        }
        this.f2640d.setSelection(this.f2645i);
    }

    public final boolean j() {
        if (!h()) {
            return false;
        }
        removeView(this.f2640d);
        addView(this.f2639c, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.f2640d.getSelectedItemPosition());
        return false;
    }

    public void k() {
        this.f2639c.removeAllViews();
        Spinner spinner = this.f2640d;
        if (spinner != null) {
            ((b) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (this.f2641e) {
            requestLayout();
        }
    }

    public void l(int i10) {
        this.f2639c.removeViewAt(i10);
        Spinner spinner = this.f2640d;
        if (spinner != null) {
            ((b) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (this.f2641e) {
            requestLayout();
        }
    }

    public void m(int i10) {
        ((d) this.f2639c.getChildAt(i10)).c();
        Spinner spinner = this.f2640d;
        if (spinner != null) {
            ((b) spinner.getAdapter()).notifyDataSetChanged();
        }
        if (this.f2641e) {
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f2637a;
        if (runnable != null) {
            post(runnable);
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        l.a aVarB = l.a.b(getContext());
        setContentHeight(aVarB.f());
        this.f2643g = aVarB.e();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f2637a;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i10, long j10) {
        ((d) view).b().g();
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        boolean z10 = mode == 1073741824;
        setFillViewport(z10);
        int childCount = this.f2639c.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.f2642f = -1;
        } else {
            if (childCount > 2) {
                this.f2642f = (int) (View.MeasureSpec.getSize(i10) * 0.4f);
            } else {
                this.f2642f = View.MeasureSpec.getSize(i10) / 2;
            }
            this.f2642f = Math.min(this.f2642f, this.f2643g);
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f2644h, 1073741824);
        if (!z10 && this.f2641e) {
            this.f2639c.measure(0, iMakeMeasureSpec);
            if (this.f2639c.getMeasuredWidth() > View.MeasureSpec.getSize(i10)) {
                i();
            } else {
                j();
            }
        } else {
            j();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i10, iMakeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (!z10 || measuredWidth == measuredWidth2) {
            return;
        }
        setTabSelected(this.f2645i);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void setAllowCollapse(boolean z10) {
        this.f2641e = z10;
    }

    public void setContentHeight(int i10) {
        this.f2644h = i10;
        requestLayout();
    }

    public void setTabSelected(int i10) {
        this.f2645i = i10;
        int childCount = this.f2639c.getChildCount();
        int i11 = 0;
        while (i11 < childCount) {
            View childAt = this.f2639c.getChildAt(i11);
            boolean z10 = i11 == i10;
            childAt.setSelected(z10);
            if (z10) {
                c(i10);
            }
            i11++;
        }
        Spinner spinner = this.f2640d;
        if (spinner == null || i10 < 0) {
            return;
        }
        spinner.setSelection(i10);
    }
}
