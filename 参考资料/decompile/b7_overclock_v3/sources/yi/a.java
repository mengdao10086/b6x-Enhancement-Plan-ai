package yi;

import android.os.Looper;
import io.reactivex.disposables.b;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes5.dex */
public abstract class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f57356a = new AtomicBoolean();

    /* JADX INFO: renamed from: yi.a$a, reason: collision with other inner class name */
    public class RunnableC0673a implements Runnable {
        public RunnableC0673a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.a();
        }
    }

    public static void b() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        throw new IllegalStateException("Expected to be called on the main thread but was " + Thread.currentThread().getName());
    }

    public abstract void a();

    @Override // io.reactivex.disposables.b
    public final void dispose() {
        if (this.f57356a.compareAndSet(false, true)) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                a();
            } else {
                aj.a.c().f(new RunnableC0673a());
            }
        }
    }

    @Override // io.reactivex.disposables.b
    public final boolean isDisposed() {
        return this.f57356a.get();
    }
}
