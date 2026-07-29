package androidx.profileinstaller;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class f implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ f f6454a = new f();

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
