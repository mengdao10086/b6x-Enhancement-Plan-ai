package a;

import android.app.Activity;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ua implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f7579a;

    public ua(Activity activity) {
        this.f7579a = activity;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f7579a.isFinishing() || cb.i(this.f7579a)) {
            return;
        }
        this.f7579a.recreate();
    }
}
