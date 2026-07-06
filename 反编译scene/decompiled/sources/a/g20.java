package a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.TextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class g20 extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6160a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ h20 f956a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ TextView f957a;
    public final /* synthetic */ int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final /* synthetic */ TextView f958b;

    public g20(h20 h20Var, int i, TextView textView, int i2, TextView textView2) {
        this.f956a = h20Var;
        this.f6160a = i;
        this.f957a = textView;
        this.b = i2;
        this.f958b = textView2;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f956a.c = this.f6160a;
        this.f956a.f1102a = null;
        TextView textView = this.f957a;
        if (textView != null) {
            textView.setVisibility(4);
            if (this.b == 1 && this.f956a.f1108a != null) {
                this.f956a.f1108a.setText((CharSequence) null);
            }
        }
        TextView textView2 = this.f958b;
        if (textView2 != null) {
            textView2.setTranslationY(0.0f);
            this.f958b.setAlpha(1.0f);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        TextView textView = this.f958b;
        if (textView != null) {
            textView.setVisibility(0);
        }
    }
}
