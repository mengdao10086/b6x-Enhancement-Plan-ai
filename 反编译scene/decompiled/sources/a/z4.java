package a;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class z4 implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b5 f8034a;

    public z4(b5 b5Var) {
        this.f8034a = b5Var;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        if (!this.f8034a.a() || this.f8034a.f218a.B()) {
            return;
        }
        View view = this.f8034a.f225b;
        if (view == null || !view.isShown()) {
            this.f8034a.dismiss();
        } else {
            this.f8034a.f218a.c();
        }
    }
}
