package a;

import android.widget.Toast;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class f11 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h11 f6063a;

    public f11(h11 h11Var) {
        this.f6063a = h11Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!this.f6063a.f1091a.exists()) {
            Toast.makeText(this.f6063a.f1090a.getContext(), "所选的目录已被删除，请重新选择！", 0).show();
            return;
        }
        h11 h11Var = this.f6063a;
        h11Var.f6263a.b = h11Var.f1091a;
        this.f6063a.f6263a.f1714a.run();
    }
}
