package a;

import android.os.Process;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class me extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6798a;

    public me(Runnable runnable, String str, int i) {
        super(runnable, str);
        this.f6798a = i;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(this.f6798a);
        super.run();
    }
}
