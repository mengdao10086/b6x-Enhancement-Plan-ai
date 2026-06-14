package a;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class cd2 implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicInteger f5782a;

    public cd2(AtomicInteger atomicInteger) {
        this.f5782a = atomicInteger;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, "CommonPool-worker-" + this.f5782a.incrementAndGet());
        thread.setDaemon(true);
        return thread;
    }
}
