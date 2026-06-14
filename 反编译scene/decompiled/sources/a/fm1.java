package a;

import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class fm1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n92 f6120a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ nm1 f925a;

    public fm1(nm1 nm1Var, n92 n92Var) {
        this.f925a = nm1Var;
        this.f6120a = n92Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        new no0().D(new em1(this));
    }
}
