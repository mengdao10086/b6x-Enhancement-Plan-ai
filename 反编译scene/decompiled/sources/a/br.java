package a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Rect;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class br extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5726a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Rect f298a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ View f299a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f300a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;

    public br(er erVar, View view, Rect rect, int i, int i2, int i3, int i4) {
        this.f299a = view;
        this.f298a = rect;
        this.f5726a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.f300a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        if (this.f300a) {
            return;
        }
        eh.p0(this.f299a, this.f298a);
        ys.f(this.f299a, this.f5726a, this.b, this.c, this.d);
    }
}
