package a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.snackbar.BaseTransientBottomBar;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class c00 extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5745a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ BaseTransientBottomBar f314a;

    public c00(BaseTransientBottomBar baseTransientBottomBar, int i) {
        this.f314a = baseTransientBottomBar;
        this.f5745a = i;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f314a.G(this.f5745a);
    }
}
