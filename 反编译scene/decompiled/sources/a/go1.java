package a;

import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class go1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ jo1 f6228a;

    public go1(jo1 jo1Var) {
        this.f6228a = jo1Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f6228a.l("https://play.google.com/store/apps/details?id=" + this.f6228a.f1572a.getPackageName());
    }
}
