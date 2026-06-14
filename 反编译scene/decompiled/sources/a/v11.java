package a;

import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class v11 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7649a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ s11 f3228a;

    public v11(s11 s11Var, int i) {
        this.f3228a = s11Var;
        this.f7649a = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f3228a.K(this.f7649a, true);
    }
}
