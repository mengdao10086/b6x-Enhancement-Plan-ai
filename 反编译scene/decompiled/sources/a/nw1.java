package a;

import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class nw1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ bx1 f6955a;

    public nw1(bx1 bx1Var) {
        this.f6955a = bx1Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        view.performHapticFeedback(1);
        new no0().D(new mw1(this));
    }
}
