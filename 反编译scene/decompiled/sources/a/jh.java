package a;

import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class jh implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ oh f6508a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ View f1543a;

    public jh(lh lhVar, oh ohVar, View view) {
        this.f6508a = ohVar;
        this.f1543a = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f6508a.a(this.f1543a);
    }
}
