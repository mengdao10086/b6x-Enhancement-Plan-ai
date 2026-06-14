package a;

import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ne implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6904a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f2079a;

    public ne(String str, int i) {
        this.f2079a = str;
        this.f6904a = i;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return new me(runnable, this.f2079a, this.f6904a);
    }
}
