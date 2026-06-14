package a;

import android.widget.Toast;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class i11 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k11 f6366a;

    public i11(k11 k11Var) {
        this.f6366a = k11Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!this.f6366a.f1596a.exists()) {
            Toast.makeText(this.f6366a.f1595a.getContext(), "所选的文件已被删除，请重新选择！", 0).show();
            return;
        }
        k11 k11Var = this.f6366a;
        k11Var.f6564a.b = k11Var.f1596a;
        this.f6366a.f6564a.f1714a.run();
    }
}
