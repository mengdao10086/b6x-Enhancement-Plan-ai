package a;

import android.widget.Toast;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class kc0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ mc0 f6591a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Exception f1611a;

    public kc0(mc0 mc0Var, Exception exc) {
        this.f6591a = mc0Var;
        this.f1611a = exc;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Toast.makeText(this.f6591a.f1915a, "Page configuration parsing error!\n" + this.f1611a.getMessage(), 1).show();
    }
}
