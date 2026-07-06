package a;

import android.animation.ValueAnimator;
import com.google.android.material.snackbar.BaseTransientBottomBar;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class i00 implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6361a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ BaseTransientBottomBar f1299a;

    public i00(BaseTransientBottomBar baseTransientBottomBar) {
        this.f1299a = baseTransientBottomBar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        if (BaseTransientBottomBar.b) {
            eh.W(this.f1299a.f4663a, iIntValue - this.f6361a);
        } else {
            this.f1299a.f4663a.setTranslationY(iIntValue);
        }
        this.f6361a = iIntValue;
    }
}
