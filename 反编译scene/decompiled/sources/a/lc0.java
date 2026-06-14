package a;

import android.widget.Toast;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class lc0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ mc0 f6692a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Exception f1784a;

    public lc0(mc0 mc0Var, Exception exc) {
        this.f6692a = mc0Var;
        this.f1784a = exc;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Toast.makeText(this.f6692a.f1915a, "解析配置文件失败\n" + this.f1784a.getMessage(), 1).show();
    }
}
