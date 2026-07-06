package a;

import android.view.ViewParent;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class j7 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l7 f6481a;

    public j7(l7 l7Var) {
        this.f6481a = l7Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        ViewParent parent = this.f6481a.f1762a.getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }
}
