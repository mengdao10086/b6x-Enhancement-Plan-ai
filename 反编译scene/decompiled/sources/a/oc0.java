package a;

import android.widget.Toast;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class oc0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ pc0 f7005a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f2228a;

    public oc0(pc0 pc0Var, String str) {
        this.f7005a = pc0Var;
        this.f2228a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Toast.makeText(this.f7005a.f7103a, this.f7005a.f7103a.getString(ob0.kr_page_sh_invalid) + "\n" + this.f2228a, 1).show();
    }
}
