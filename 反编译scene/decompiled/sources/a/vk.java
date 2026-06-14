package a;

import android.app.Dialog;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class vk implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ wk f7701a;

    public vk(wk wkVar) {
        this.f7701a = wkVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        wk wkVar = this.f7701a;
        Dialog dialog = wkVar.f7797a;
        if (dialog != null) {
            wkVar.onDismiss(dialog);
        }
    }
}
