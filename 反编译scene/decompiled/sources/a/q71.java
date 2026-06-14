package a;

import android.content.DialogInterface;
import android.webkit.JsResult;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class q71 implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JsResult f7185a;

    public q71(JsResult jsResult) {
        this.f7185a = jsResult;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        JsResult jsResult = this.f7185a;
        if (jsResult != null) {
            jsResult.confirm();
        }
    }
}
