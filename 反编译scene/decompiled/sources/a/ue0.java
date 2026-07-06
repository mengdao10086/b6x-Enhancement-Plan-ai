package a;

import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ue0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ye0 f7589a;

    public ue0(ye0 ye0Var) {
        this.f7589a = ye0Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        we0 we0VarI = this.f7589a.i();
        if (we0VarI != null) {
            we0VarI.a(this.f7589a);
        }
    }
}
