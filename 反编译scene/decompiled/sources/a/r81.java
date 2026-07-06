package a;

import com.omarea.vtools.activities.ActivityAppXposedConfig;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class r81 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityAppXposedConfig.a f7282a;

    public r81(ActivityAppXposedConfig.a aVar) {
        this.f7282a = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ActivityAppXposedConfig.m(ActivityAppXposedConfig.this).c();
    }
}
