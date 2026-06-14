package a;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Toast;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class um1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zm1 f7613a;

    public um1(zm1 zm1Var) {
        this.f7613a = zm1Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            this.f7613a.f3870a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://vtools.omarea.com/#/email")));
        } catch (Exception unused) {
            Toast.makeText(this.f7613a.f3870a, u61.home_browser_error, 0).show();
        }
    }
}
