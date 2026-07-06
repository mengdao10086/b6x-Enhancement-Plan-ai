package a;

import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class hw1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ bx1 f6350a;

    public hw1(bx1 bx1Var) {
        this.f6350a = bx1Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        view.performHapticFeedback(1);
        this.f6350a.U1(new gw1(this));
    }
}
