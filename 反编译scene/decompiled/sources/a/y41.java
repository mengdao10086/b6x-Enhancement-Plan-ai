package a;

import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class y41 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7948a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ w41 f3658a;

    public y41(w41 w41Var, int i) {
        this.f3658a = w41Var;
        this.f7948a = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f3658a.J(-1, false);
        v41 v41Var = this.f3658a.b;
        if (v41Var != null) {
            v41Var.b(this.f7948a);
        }
    }
}
