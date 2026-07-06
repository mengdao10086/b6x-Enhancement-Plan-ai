package a;

import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class z41 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8036a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ w41 f3796a;

    public z41(w41 w41Var, int i) {
        this.f3796a = w41Var;
        this.f8036a = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f3796a.J(this.f8036a, true);
    }
}
