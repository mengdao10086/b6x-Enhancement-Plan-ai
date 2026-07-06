package a;

import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class lw1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ bx1 f6743a;

    public lw1(bx1 bx1Var) {
        this.f6743a = bx1Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        view.performHapticFeedback(1);
        this.f6743a.P1();
    }
}
