package a;

import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class bt1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ et1 f5732a;

    public bt1(et1 et1Var) {
        this.f5732a = et1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f5732a.s1(new Intent("android.intent.action.VIEW", Uri.parse("http://vtools.omarea.com/")));
        } catch (Exception unused) {
            Toast.makeText(this.f5732a.p(), "Failed to open browser!", 0).show();
        }
    }
}
