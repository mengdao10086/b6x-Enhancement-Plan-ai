package a;

import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class o70 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n30 f6991a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ v70 f2213a;

    public o70(v70 v70Var, n30 n30Var) {
        this.f2213a = v70Var;
        this.f6991a = n30Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        g82<n30, Boolean> g82VarH = this.f2213a.h();
        f92.b(g82VarH);
        if (g82VarH.f(this.f6991a).booleanValue()) {
            this.f2213a.f3257b.remove(this.f6991a);
            this.f2213a.e().remove(this.f6991a);
            this.f2213a.notifyDataSetChanged();
        }
    }
}
