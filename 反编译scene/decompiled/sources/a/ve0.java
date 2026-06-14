package a;

import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ve0 implements View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ye0 f7686a;

    public ve0(ye0 ye0Var) {
        this.f7686a = ye0Var;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        xe0 xe0VarJ = this.f7686a.j();
        if (xe0VarJ == null) {
            return true;
        }
        xe0VarJ.a(this.f7686a);
        return true;
    }
}
