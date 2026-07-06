package a;

import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class jw1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ bx1 f6551a;

    public jw1(bx1 bx1Var) {
        this.f6551a = bx1Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        view.performHapticFeedback(1);
        this.f6551a.U1(new iw1(this));
    }
}
