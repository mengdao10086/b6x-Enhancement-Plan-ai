package a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.tabs.TabLayout;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class f10 extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6062a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ TabLayout.f f835a;

    public f10(TabLayout.f fVar, int i) {
        this.f835a = fVar;
        this.f6062a = i;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        TabLayout.f fVar = this.f835a;
        fVar.b = this.f6062a;
        fVar.f8325a = 0.0f;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f835a.b = this.f6062a;
    }
}
