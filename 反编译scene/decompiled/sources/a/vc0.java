package a;

import android.widget.Toast;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class vc0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ wc0 f7678a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f3265a;

    public vc0(wc0 wc0Var, String str) {
        this.f7678a = wc0Var;
        this.f3265a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        Toast.makeText(this.f7678a.f3422a, "ExtractFail " + this.f3265a, 1).show();
    }
}
