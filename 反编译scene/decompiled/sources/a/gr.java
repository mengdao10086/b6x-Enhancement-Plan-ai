package a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class gr extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f6234a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f1052a = false;

    public gr(View view) {
        this.f6234a = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        ys.g(this.f6234a, 1.0f);
        if (this.f1052a) {
            this.f6234a.setLayerType(0, null);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        if (eh.M(this.f6234a) && this.f6234a.getLayerType() == 0) {
            this.f1052a = true;
            this.f6234a.setLayerType(2, null);
        }
    }
}
