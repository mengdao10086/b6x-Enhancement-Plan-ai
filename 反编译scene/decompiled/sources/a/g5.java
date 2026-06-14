package a;

import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class g5 extends u4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n5 f6170a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g5(n5 n5Var, Context context, c5 c5Var, View view) {
        super(context, c5Var, view, false, t.actionOverflowMenuStyle);
        this.f6170a = n5Var;
        if (!((l4) c5Var.getItem()).n()) {
            View view2 = n5Var.f2009a;
            f(view2 == null ? (View) ((x3) ((x3) n5Var)).f3517a : view2);
        }
        j(n5Var.f2011a);
    }

    @Override // a.u4
    public void e() {
        n5 n5Var = this.f6170a;
        n5Var.f6875a = null;
        n5Var.g = 0;
        super.e();
    }
}
