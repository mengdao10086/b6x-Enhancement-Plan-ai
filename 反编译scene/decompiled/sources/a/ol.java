package a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ol extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ yl f7034a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ View f2265a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ViewGroup f2266a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Fragment f2267a;

    public ol(yl ylVar, ViewGroup viewGroup, View view, Fragment fragment) {
        this.f7034a = ylVar;
        this.f2266a = viewGroup;
        this.f2265a = view;
        this.f2267a = fragment;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f2266a.endViewTransition(this.f2265a);
        Animator animatorN = this.f2267a.n();
        this.f2267a.j1(null);
        if (animatorN == null || this.f2266a.indexOfChild(this.f2265a) >= 0) {
            return;
        }
        yl ylVar = this.f7034a;
        Fragment fragment = this.f2267a;
        ylVar.S0(fragment, fragment.I(), 0, 0, false);
    }
}
