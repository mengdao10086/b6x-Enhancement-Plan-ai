package a;

import android.os.Process;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class op0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final op0 f7044a = new op0();

    @Override // java.lang.Runnable
    public final void run() {
        Process.killProcess(Process.myPid());
    }
}
