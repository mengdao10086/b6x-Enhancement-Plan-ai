package androidx.core.os;

import android.os.Handler;
import g.n0;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    public static class a implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f4657a;

        public a(@n0 Handler handler) {
            this.f4657a = (Handler) androidx.core.util.o.l(handler);
        }

        @Override // java.util.concurrent.Executor
        public void execute(@n0 Runnable runnable) {
            if (this.f4657a.post((Runnable) androidx.core.util.o.l(runnable))) {
                return;
            }
            throw new RejectedExecutionException(this.f4657a + " is shutting down");
        }
    }

    @n0
    public static Executor a(@n0 Handler handler) {
        return new a(handler);
    }
}
