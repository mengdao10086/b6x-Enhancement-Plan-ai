package a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class pl extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f7126a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ViewGroup f2436a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Fragment f2437a;

    public pl(yl ylVar, ViewGroup viewGroup, View view, Fragment fragment) {
        this.f2436a = viewGroup;
        this.f7126a = view;
        this.f2437a = fragment;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f2436a.endViewTransition(this.f7126a);
        animator.removeListener(this);
        Fragment fragment = this.f2437a;
        View view = fragment.f4263a;
        if (view == null || !fragment.h) {
            return;
        }
        view.setVisibility(8);
    }
}
