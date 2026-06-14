package a;

import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class t01 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7449a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ r01 f2937a;

    public t01(r01 r01Var, int i) {
        this.f2937a = r01Var;
        this.f7449a = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f2937a.K(-1, false);
        q01 q01Var = this.f2937a.b;
        if (q01Var != null) {
            q01Var.b(this.f7449a);
        }
    }
}
