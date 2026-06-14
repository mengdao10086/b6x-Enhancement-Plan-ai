package a;

import android.animation.ValueAnimator;
import com.google.android.material.snackbar.BaseTransientBottomBar;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class g00 implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6154a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ BaseTransientBottomBar f953a;
    public final /* synthetic */ int b;

    public g00(BaseTransientBottomBar baseTransientBottomBar, int i) {
        this.f953a = baseTransientBottomBar;
        this.b = i;
        this.f6154a = this.b;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        if (BaseTransientBottomBar.b) {
            eh.W(this.f953a.f4663a, iIntValue - this.f6154a);
        } else {
            this.f953a.f4663a.setTranslationY(iIntValue);
        }
        this.f6154a = iIntValue;
    }
}
