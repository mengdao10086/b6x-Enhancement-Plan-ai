package com.google.android.material.textfield;

import a1.c;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.core.view.u0;
import com.google.android.material.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes3.dex */
public class p extends s {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @g.k(api = 21)
    public static final boolean f20952p = true;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f20953q = 50;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f20954r = 67;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @p0
    public AutoCompleteTextView f20955e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View.OnClickListener f20956f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View.OnFocusChangeListener f20957g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c.e f20958h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f20959i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f20960j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f20961k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f20962l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @p0
    public AccessibilityManager f20963m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ValueAnimator f20964n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ValueAnimator f20965o;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            p.this.r();
            p.this.f20965o.start();
        }
    }

    public p(@n0 r rVar) {
        super(rVar);
        this.f20956f = new View.OnClickListener() { // from class: com.google.android.material.textfield.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f20947a.J(view);
            }
        };
        this.f20957g = new View.OnFocusChangeListener() { // from class: com.google.android.material.textfield.l
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z10) {
                this.f20948a.K(view, z10);
            }
        };
        this.f20958h = new c.e() { // from class: com.google.android.material.textfield.i
            @Override // a1.c.e
            public final void onTouchExplorationStateChanged(boolean z10) {
                this.f20945a.L(z10);
            }
        };
        this.f20962l = Long.MAX_VALUE;
    }

    @n0
    public static AutoCompleteTextView D(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H() {
        boolean zIsPopupShowing = this.f20955e.isPopupShowing();
        O(zIsPopupShowing);
        this.f20960j = zIsPopupShowing;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I(ValueAnimator valueAnimator) {
        this.f20998d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J(View view) {
        Q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(View view, boolean z10) {
        this.f20959i = z10;
        r();
        if (z10) {
            return;
        }
        O(false);
        this.f20960j = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(boolean z10) {
        AutoCompleteTextView autoCompleteTextView = this.f20955e;
        if (autoCompleteTextView == null || q.a(autoCompleteTextView)) {
            return;
        }
        u0.R1(this.f20998d, z10 ? 2 : 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean M(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (G()) {
                this.f20960j = false;
            }
            Q();
            R();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N() {
        R();
        O(false);
    }

    public final ValueAnimator E(int i10, float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(kd.a.f37166a);
        valueAnimatorOfFloat.setDuration(i10);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.j
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f20946a.I(valueAnimator);
            }
        });
        return valueAnimatorOfFloat;
    }

    public final void F() {
        this.f20965o = E(67, 0.0f, 1.0f);
        ValueAnimator valueAnimatorE = E(50, 1.0f, 0.0f);
        this.f20964n = valueAnimatorE;
        valueAnimatorE.addListener(new a());
    }

    public final boolean G() {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f20962l;
        return jCurrentTimeMillis < 0 || jCurrentTimeMillis > 300;
    }

    public final void O(boolean z10) {
        if (this.f20961k != z10) {
            this.f20961k = z10;
            this.f20965o.cancel();
            this.f20964n.start();
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void P() {
        this.f20955e.setOnTouchListener(new View.OnTouchListener() { // from class: com.google.android.material.textfield.m
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return this.f20949a.M(view, motionEvent);
            }
        });
        if (f20952p) {
            this.f20955e.setOnDismissListener(new AutoCompleteTextView.OnDismissListener() { // from class: com.google.android.material.textfield.n
                @Override // android.widget.AutoCompleteTextView.OnDismissListener
                public final void onDismiss() {
                    this.f20950a.N();
                }
            });
        }
        this.f20955e.setThreshold(0);
    }

    public final void Q() {
        if (this.f20955e == null) {
            return;
        }
        if (G()) {
            this.f20960j = false;
        }
        if (this.f20960j) {
            this.f20960j = false;
            return;
        }
        if (f20952p) {
            O(!this.f20961k);
        } else {
            this.f20961k = !this.f20961k;
            r();
        }
        if (!this.f20961k) {
            this.f20955e.dismissDropDown();
        } else {
            this.f20955e.requestFocus();
            this.f20955e.showDropDown();
        }
    }

    public final void R() {
        this.f20960j = true;
        this.f20962l = System.currentTimeMillis();
    }

    @Override // com.google.android.material.textfield.s
    public void a(Editable editable) {
        if (this.f20963m.isTouchExplorationEnabled() && q.a(this.f20955e) && !this.f20998d.hasFocus()) {
            this.f20955e.dismissDropDown();
        }
        this.f20955e.post(new Runnable() { // from class: com.google.android.material.textfield.o
            @Override // java.lang.Runnable
            public final void run() {
                this.f20951a.H();
            }
        });
    }

    @Override // com.google.android.material.textfield.s
    public int c() {
        return R.string.exposed_dropdown_menu_content_description;
    }

    @Override // com.google.android.material.textfield.s
    public int d() {
        return f20952p ? R.drawable.mtrl_dropdown_arrow : R.drawable.mtrl_ic_arrow_drop_down;
    }

    @Override // com.google.android.material.textfield.s
    public View.OnFocusChangeListener e() {
        return this.f20957g;
    }

    @Override // com.google.android.material.textfield.s
    public View.OnClickListener f() {
        return this.f20956f;
    }

    @Override // com.google.android.material.textfield.s
    public c.e h() {
        return this.f20958h;
    }

    @Override // com.google.android.material.textfield.s
    public boolean i(int i10) {
        return i10 != 0;
    }

    @Override // com.google.android.material.textfield.s
    public boolean j() {
        return true;
    }

    @Override // com.google.android.material.textfield.s
    public boolean k() {
        return this.f20959i;
    }

    @Override // com.google.android.material.textfield.s
    public boolean l() {
        return true;
    }

    @Override // com.google.android.material.textfield.s
    public boolean m() {
        return this.f20961k;
    }

    @Override // com.google.android.material.textfield.s
    public void n(@p0 EditText editText) {
        this.f20955e = D(editText);
        P();
        this.f20995a.setErrorIconDrawable((Drawable) null);
        if (!q.a(editText) && this.f20963m.isTouchExplorationEnabled()) {
            u0.R1(this.f20998d, 2);
        }
        this.f20995a.setEndIconVisible(true);
    }

    @Override // com.google.android.material.textfield.s
    public void o(View view, @n0 a1.d dVar) {
        if (!q.a(this.f20955e)) {
            dVar.b1(Spinner.class.getName());
        }
        if (dVar.D0()) {
            dVar.q1(null);
        }
    }

    @Override // com.google.android.material.textfield.s
    public void p(View view, @n0 AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 1 && this.f20963m.isEnabled() && !q.a(this.f20955e)) {
            Q();
            R();
        }
    }

    @Override // com.google.android.material.textfield.s
    public void s() {
        F();
        this.f20963m = (AccessibilityManager) this.f20997c.getSystemService("accessibility");
    }

    @Override // com.google.android.material.textfield.s
    public boolean t() {
        return true;
    }

    @Override // com.google.android.material.textfield.s
    @SuppressLint({"ClickableViewAccessibility"})
    public void u() {
        AutoCompleteTextView autoCompleteTextView = this.f20955e;
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setOnTouchListener(null);
            if (f20952p) {
                this.f20955e.setOnDismissListener(null);
            }
        }
    }
}
