package a;

import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class m6 implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o6 f6773a;

    public m6(o6 o6Var) {
        this.f6773a = o6Var;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        o6 o6Var = this.f6773a;
        if (!o6Var.U(o6Var.f6986a)) {
            this.f6773a.dismiss();
        } else {
            this.f6773a.S();
            super/*a.t7*/.c();
        }
    }
}
