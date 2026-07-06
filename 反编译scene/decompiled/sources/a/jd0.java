package a;

import android.app.AlertDialog;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class jd0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AlertDialog f6501a;

    public jd0(AlertDialog alertDialog) {
        this.f6501a = alertDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            AlertDialog alertDialog = this.f6501a;
            f92.b(alertDialog);
            alertDialog.dismiss();
        } catch (Exception unused) {
        }
    }
}
