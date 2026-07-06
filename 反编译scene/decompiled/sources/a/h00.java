package a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.snackbar.BaseTransientBottomBar;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class h00 extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6258a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ BaseTransientBottomBar f1079a;

    public h00(BaseTransientBottomBar baseTransientBottomBar, int i) {
        this.f1079a = baseTransientBottomBar;
        this.f6258a = i;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f1079a.G(this.f6258a);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f1079a.f4655a.a(0, 180);
    }
}
