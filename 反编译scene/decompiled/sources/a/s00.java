package a;

import com.google.android.material.snackbar.BaseTransientBottomBar;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class s00 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseTransientBottomBar f7347a;

    public s00(BaseTransientBottomBar baseTransientBottomBar) {
        this.f7347a = baseTransientBottomBar;
    }

    @Override // java.lang.Runnable
    public void run() {
        BaseTransientBottomBar.b bVar = this.f7347a.f4663a;
        if (bVar == null) {
            return;
        }
        bVar.setVisibility(0);
        if (this.f7347a.f4663a.getAnimationMode() == 1) {
            this.f7347a.P();
        } else {
            this.f7347a.R();
        }
    }
}
