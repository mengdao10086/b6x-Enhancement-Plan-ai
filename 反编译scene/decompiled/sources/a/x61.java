package a;

import android.content.DialogInterface;
import android.webkit.JsResult;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class x61 implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JsResult f7857a;

    public x61(JsResult jsResult) {
        this.f7857a = jsResult;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        JsResult jsResult = this.f7857a;
        if (jsResult != null) {
            jsResult.confirm();
        }
    }
}
