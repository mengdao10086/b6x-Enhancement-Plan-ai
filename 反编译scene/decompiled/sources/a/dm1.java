package a;

import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class dm1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n92 f5916a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ nm1 f583a;

    public dm1(nm1 nm1Var, n92 n92Var) {
        this.f583a = nm1Var;
        this.f5916a = n92Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        new no0().D(new cm1(this));
    }
}
