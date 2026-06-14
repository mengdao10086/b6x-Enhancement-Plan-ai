package a;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class pi0 implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ qi0 f7121a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ v72 f2430a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ View f2431a;

    public pi0(qi0 qi0Var, View view, v72 v72Var) {
        this.f7121a = qi0Var;
        this.f2431a = view;
        this.f2430a = v72Var;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        Rect rect = new Rect();
        this.f2431a.getWindowVisibleDisplayFrame(rect);
        if (this.f2431a.getRootView().getHeight() - rect.bottom > 200) {
            this.f7121a.f2572a = true;
        } else if (this.f7121a.f2572a && this.f2431a.hasFocus()) {
            this.f7121a.f2572a = false;
            this.f2430a.i();
        }
    }
}
