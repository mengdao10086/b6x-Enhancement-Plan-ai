package a;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class q10 extends f20 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AnimatorSet f7167a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ValueAnimator f2523a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final TextWatcher f2524a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final View.OnFocusChangeListener f2525a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final TextInputLayout.f f2526a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final TextInputLayout.g f2527a;

    public q10(TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.f2524a = new h10(this);
        this.f2525a = new i10(this);
        this.f2526a = new j10(this);
        this.f2527a = new k10(this);
    }

    public static boolean l(Editable editable) {
        return editable.length() > 0;
    }

    @Override // a.f20
    public void a() {
        ((f20) this).f838a.setEndIconDrawable(r2.d(((f20) this).f6066a, cv.mtrl_ic_cancel));
        TextInputLayout textInputLayout = ((f20) this).f838a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(hv.clear_text_end_icon_content_description));
        ((f20) this).f838a.setEndIconOnClickListener(new l10(this));
        ((f20) this).f838a.e(this.f2526a);
        ((f20) this).f838a.f(this.f2527a);
        m();
    }

    @Override // a.f20
    public void c(boolean z) {
        if (((f20) this).f838a.getSuffixText() == null) {
            return;
        }
        i(z);
    }

    public final void i(boolean z) {
        boolean z2 = ((f20) this).f838a.J() == z;
        if (z) {
            this.f2523a.cancel();
            this.f7167a.start();
            if (z2) {
                this.f7167a.end();
                return;
            }
            return;
        }
        this.f7167a.cancel();
        this.f2523a.start();
        if (z2) {
            this.f2523a.end();
        }
    }

    public final ValueAnimator j(float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(kv.f6644a);
        valueAnimatorOfFloat.setDuration(100L);
        valueAnimatorOfFloat.addUpdateListener(new o10(this));
        return valueAnimatorOfFloat;
    }

    public final ValueAnimator k() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        valueAnimatorOfFloat.setInterpolator(kv.d);
        valueAnimatorOfFloat.setDuration(150L);
        valueAnimatorOfFloat.addUpdateListener(new p10(this));
        return valueAnimatorOfFloat;
    }

    public final void m() {
        ValueAnimator valueAnimatorK = k();
        ValueAnimator valueAnimatorJ = j(0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f7167a = animatorSet;
        animatorSet.playTogether(valueAnimatorK, valueAnimatorJ);
        this.f7167a.addListener(new m10(this));
        ValueAnimator valueAnimatorJ2 = j(1.0f, 0.0f);
        this.f2523a = valueAnimatorJ2;
        valueAnimatorJ2.addListener(new n10(this));
    }
}
