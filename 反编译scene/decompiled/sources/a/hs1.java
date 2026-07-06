package a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Toast;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class hs1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zs1 f6339a;

    public hs1(zs1 zs1Var) {
        this.f6339a = zs1Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            this.f6339a.s1(new Intent("android.intent.action.VIEW", Uri.parse("https://omarea.com/")));
        } catch (Exception unused) {
            Context contextP = this.f6339a.p();
            f92.b(contextP);
            Toast.makeText(contextP, u61.home_browser_error, 0).show();
        }
    }
}
