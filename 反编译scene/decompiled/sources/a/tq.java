package a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class tq extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ float f7523a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ BitmapDrawable f3052a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ View f3053a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ViewGroup f3054a;

    public tq(er erVar, ViewGroup viewGroup, BitmapDrawable bitmapDrawable, View view, float f) {
        this.f3054a = viewGroup;
        this.f3052a = bitmapDrawable;
        this.f3053a = view;
        this.f7523a = f;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        ys.b(this.f3054a).b(this.f3052a);
        ys.g(this.f3053a, this.f7523a);
    }
}
