package n;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.RestrictTo;
import g.n0;
import g.p0;
import g.v0;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class d extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f41709a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ExecutorService f41710b = Executors.newFixedThreadPool(4, new a());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @p0
    public volatile Handler f41711c;

    public class a implements ThreadFactory {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f41712c = "arch_disk_io_";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicInteger f41713a = new AtomicInteger(0);

        public a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(f41712c + this.f41713a.getAndIncrement());
            return thread;
        }
    }

    @v0(28)
    public static class b {
        @n0
        public static Handler a(@n0 Looper looper) {
            return Handler.createAsync(looper);
        }
    }

    @n0
    public static Handler e(@n0 Looper looper) {
        if (Build.VERSION.SDK_INT >= 28) {
            return b.a(looper);
        }
        try {
            return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException unused) {
            return new Handler(looper);
        } catch (InvocationTargetException unused2) {
            return new Handler(looper);
        }
    }

    @Override // n.e
    public void a(@n0 Runnable runnable) {
        this.f41710b.execute(runnable);
    }

    @Override // n.e
    public boolean c() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    @Override // n.e
    public void d(@n0 Runnable runnable) {
        if (this.f41711c == null) {
            synchronized (this.f41709a) {
                if (this.f41711c == null) {
                    this.f41711c = e(Looper.getMainLooper());
                }
            }
        }
        this.f41711c.post(runnable);
    }
}
