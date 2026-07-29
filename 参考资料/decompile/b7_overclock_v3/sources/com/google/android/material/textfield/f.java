package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes3.dex */
public class f extends s {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f20934j = 100;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f20935k = 150;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final float f20936l = 0.8f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @p0
    public EditText f20937e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View.OnClickListener f20938f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View.OnFocusChangeListener f20939g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AnimatorSet f20940h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ValueAnimator f20941i;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            f.this.f20996b.a0(true);
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f.this.f20996b.a0(false);
        }
    }

    public f(@n0 r rVar) {
        super(rVar);
        this.f20938f = new View.OnClickListener() { // from class: com.google.android.material.textfield.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f20931a.G(view);
            }
        };
        this.f20939g = new View.OnFocusChangeListener() { // from class: com.google.android.material.textfield.d
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z10) {
                this.f20932a.H(view, z10);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E(ValueAnimator valueAnimator) {
        this.f20998d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F(ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f20998d.setScaleX(fFloatValue);
        this.f20998d.setScaleY(fFloatValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G(View view) {
        EditText editText = this.f20937e;
        if (editText == null) {
            return;
        }
        Editable text = editText.getText();
        if (text != null) {
            text.clear();
        }
        r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(View view, boolean z10) {
        A(J());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I() {
        A(true);
    }

    public final void A(boolean z10) {
        boolean z11 = this.f20996b.F() == z10;
        if (z10 && !this.f20940h.isRunning()) {
            this.f20941i.cancel();
            this.f20940h.start();
            if (z11) {
                this.f20940h.end();
                return;
            }
            return;
        }
        if (z10) {
            return;
        }
        this.f20940h.cancel();
        this.f20941i.start();
        if (z11) {
            this.f20941i.end();
        }
    }

    public final ValueAnimator B(float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(kd.a.f37166a);
        valueAnimatorOfFloat.setDuration(100L);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f20930a.E(valueAnimator);
            }
        });
        return valueAnimatorOfFloat;
    }

    public final ValueAnimator C() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        valueAnimatorOfFloat.setInterpolator(kd.a.f37169d);
        valueAnimatorOfFloat.setDuration(150L);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f20928a.F(valueAnimator);
            }
        });
        return valueAnimatorOfFloat;
    }

    public final void D() {
        ValueAnimator valueAnimatorC = C();
        ValueAnimator valueAnimatorB = B(0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f20940h = animatorSet;
        animatorSet.playTogether(valueAnimatorC, valueAnimatorB);
        this.f20940h.addListener(new a());
        ValueAnimator valueAnimatorB2 = B(1.0f, 0.0f);
        this.f20941i = valueAnimatorB2;
        valueAnimatorB2.addListener(new b());
    }

    public final boolean J() {
        EditText editText = this.f20937e;
        return editText != null && (editText.hasFocus() || this.f20998d.hasFocus()) && this.f20937e.getText().length() > 0;
    }

    @Override // com.google.android.material.textfield.s
    public void a(@n0 Editable editable) {
        if (this.f20996b.w() != null) {
            return;
        }
        A(J());
    }

    @Override // com.google.android.material.textfield.s
    public int c() {
        return R.string.clear_text_end_icon_content_description;
    }

    @Override // com.google.android.material.textfield.s
    public int d() {
        return R.drawable.mtrl_ic_cancel;
    }

    @Override // com.google.android.material.textfield.s
    public View.OnFocusChangeListener e() {
        return this.f20939g;
    }

    @Override // com.google.android.material.textfield.s
    public View.OnClickListener f() {
        return this.f20938f;
    }

    @Override // com.google.android.material.textfield.s
    public View.OnFocusChangeListener g() {
        return this.f20939g;
    }

    @Override // com.google.android.material.textfield.s
    public void n(@p0 EditText editText) {
        this.f20937e = editText;
        this.f20995a.setEndIconVisible(J());
    }

    @Override // com.google.android.material.textfield.s
    public void q(boolean z10) {
        if (this.f20996b.w() == null) {
            return;
        }
        A(z10);
    }

    @Override // com.google.android.material.textfield.s
    public void s() {
        D();
    }

    @Override // com.google.android.material.textfield.s
    public void u() {
        EditText editText = this.f20937e;
        if (editText != null) {
            editText.post(new Runnable() { // from class: com.google.android.material.textfield.e
                @Override // java.lang.Runnable
                public final void run() {
                    this.f20933a.I();
                }
            });
        }
    }
}
