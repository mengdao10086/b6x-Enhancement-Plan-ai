package a;

import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class u01 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7551a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ r01 f3091a;

    public u01(r01 r01Var, int i) {
        this.f3091a = r01Var;
        this.f7551a = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f3091a.K(this.f7551a, true);
    }
}
