package a;

import android.animation.Animator;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ep extends mp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ np f6027a;
    public final /* synthetic */ int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final /* synthetic */ RecyclerView.d0 f777b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ep(np npVar, RecyclerView.d0 d0Var, int i, int i2, float f, float f2, float f3, float f4, int i3, RecyclerView.d0 d0Var2) {
        super(d0Var, i, i2, f, f2, f3, f4);
        this.f6027a = npVar;
        this.b = i3;
        this.f777b = d0Var2;
    }

    @Override // a.mp, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        if (((mp) this).f1975b) {
            return;
        }
        if (this.b <= 0) {
            np npVar = this.f6027a;
            npVar.f2133a.c(npVar.f2141a, this.f777b);
        } else {
            this.f6027a.f2143a.add(this.f777b.f4387a);
            ((mp) this).f1974a = true;
            int i = this.b;
            if (i > 0) {
                this.f6027a.A(this, i);
            }
        }
        np npVar2 = this.f6027a;
        View view = npVar2.f2137a;
        View view2 = this.f777b.f4387a;
        if (view == view2) {
            npVar2.C(view2);
        }
    }
}
