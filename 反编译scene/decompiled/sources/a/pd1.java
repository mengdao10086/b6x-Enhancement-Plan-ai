package a;

import com.omarea.vtools.activities.ActivityOtherSettings;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class pd1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityOtherSettings.d f7107a;

    public pd1(ActivityOtherSettings.d dVar) {
        this.f7107a = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws e30 {
        new vo0(ActivityOtherSettings.this).z();
        e50.Q0(e50.f677a, null, 1, null);
        System.exit(0);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }
}
