package a;

import android.app.Application;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class za implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ bb f8051a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Application f3820a;

    public za(Application application, bb bbVar) {
        this.f3820a = application;
        this.f8051a = bbVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3820a.unregisterActivityLifecycleCallbacks(this.f8051a);
    }
}
