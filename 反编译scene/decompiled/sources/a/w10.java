package a;

import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class w10 implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e20 f7743a;

    public w10(e20 e20Var) {
        this.f7743a = e20Var;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        ((f20) this.f7743a).f838a.setEndIconActivated(z);
        if (z) {
            return;
        }
        this.f7743a.C(false);
        this.f7743a.f649a = false;
    }
}
