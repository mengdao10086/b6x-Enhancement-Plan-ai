package a;

import android.widget.Toast;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class nc0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ pc0 f6898a;

    public nc0(pc0 pc0Var) {
        this.f6898a = pc0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Toast.makeText(this.f6898a.f7103a, this.f6898a.f7103a.getString(ob0.kr_page_sh_file_permission), 1).show();
    }
}
