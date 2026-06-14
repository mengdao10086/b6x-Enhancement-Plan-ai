package a;

import android.view.KeyEvent;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class nz1 implements View.OnKeyListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l02 f6962a;

    public nz1(l02 l02Var) {
        this.f6962a = l02Var;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        this.f6962a.k();
        return true;
    }
}
