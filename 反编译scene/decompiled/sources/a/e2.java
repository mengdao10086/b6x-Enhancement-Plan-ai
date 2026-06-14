package a;

import a.v4;
import android.view.Window;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class e2 implements v4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h2 f5958a;
    public boolean b;

    public e2(h2 h2Var) {
        this.f5958a = h2Var;
    }

    @Override // a.v4.a
    public void b(i4 i4Var, boolean z) {
        if (this.b) {
            return;
        }
        this.b = true;
        this.f5958a.f6265a.n();
        Window.Callback callback = this.f5958a.f1096a;
        if (callback != null) {
            callback.onPanelClosed(108, i4Var);
        }
        this.b = false;
    }

    @Override // a.v4.a
    public boolean c(i4 i4Var) {
        Window.Callback callback = this.f5958a.f1096a;
        if (callback == null) {
            return false;
        }
        callback.onMenuOpened(108, i4Var);
        return true;
    }
}
