package ab;

import android.os.Handler;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class v implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Handler f490a;

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f490a.post(runnable);
    }
}
