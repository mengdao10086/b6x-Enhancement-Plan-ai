package a;

import a.v4;
import android.view.Window;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class h1 implements v4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w1 f6261a;

    public h1(w1 w1Var) {
        this.f6261a = w1Var;
    }

    @Override // a.v4.a
    public void b(i4 i4Var, boolean z) {
        this.f6261a.R(i4Var);
    }

    @Override // a.v4.a
    public boolean c(i4 i4Var) {
        Window.Callback callbackL0 = this.f6261a.l0();
        if (callbackL0 == null) {
            return true;
        }
        callbackL0.onMenuOpened(108, i4Var);
        return true;
    }
}
