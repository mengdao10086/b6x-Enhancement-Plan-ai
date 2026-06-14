package a;

import a.ix;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class bx extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ix.b f5740a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ix f305a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ boolean f306a;

    public bx(ix ixVar, boolean z, ix.b bVar) {
        this.f305a = ixVar;
        this.f306a = z;
        this.f5740a = bVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f305a.f1441c = 0;
        this.f305a.f1424a = null;
        ix.b bVar = this.f5740a;
        if (bVar != null) {
            bVar.b();
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f305a.f1430a.b(0, this.f306a);
        this.f305a.f1441c = 2;
        this.f305a.f1424a = animator;
    }
}
