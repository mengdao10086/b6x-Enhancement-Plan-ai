package a;

import a.ix;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ax extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ix.b f5649a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ix f154a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f155a;
    public final /* synthetic */ boolean b;

    public ax(ix ixVar, boolean z, ix.b bVar) {
        this.f154a = ixVar;
        this.b = z;
        this.f5649a = bVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.f155a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f154a.f1441c = 0;
        this.f154a.f1424a = null;
        if (this.f155a) {
            return;
        }
        this.f154a.f1430a.b(this.b ? 8 : 4, this.b);
        ix.b bVar = this.f5649a;
        if (bVar != null) {
            bVar.a();
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f154a.f1430a.b(0, this.b);
        this.f154a.f1441c = 1;
        this.f154a.f1424a = animator;
        this.f155a = false;
    }
}
