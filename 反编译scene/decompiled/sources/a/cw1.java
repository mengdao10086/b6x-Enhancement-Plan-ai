package a;

import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class cw1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ bx1 f5834a;

    public cw1(bx1 bx1Var) {
        this.f5834a = bx1Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        view.performHapticFeedback(1);
        this.f5834a.Q1().s(false);
    }
}
