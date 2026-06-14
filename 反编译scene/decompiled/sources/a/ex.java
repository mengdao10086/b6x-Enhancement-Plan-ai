package a;

import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ex implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ix f6049a;

    public ex(ix ixVar) {
        this.f6049a = ixVar;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        this.f6049a.E();
        return true;
    }
}
