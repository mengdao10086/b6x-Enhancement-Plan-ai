package a;

import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class i12 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j12 f6367a;

    public i12(j12 j12Var) {
        this.f6367a = j12Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f6367a.f1490a != null) {
            this.f6367a.f1492a.updateViewLayout(this.f6367a.f1490a, this.f6367a.f1491a);
            return;
        }
        this.f6367a.f1490a = new View(this.f6367a.f6463a);
        this.f6367a.f1492a.addView(this.f6367a.f1490a, this.f6367a.f1491a);
    }
}
