package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import g.n0;
import g.u;
import g.v0;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class ProfileInstallerInitializer implements e2.a<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f6426a = 5000;

    @v0(16)
    public static class a {
        @u
        public static void c(final Runnable runnable) {
            Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() { // from class: androidx.profileinstaller.m
                @Override // android.view.Choreographer.FrameCallback
                public final void doFrame(long j10) {
                    runnable.run();
                }
            });
        }
    }

    @v0(28)
    public static class b {
        @u
        public static Handler a(Looper looper) {
            return Handler.createAsync(looper);
        }
    }

    public static class c {
    }

    public static void l(@n0 final Context context) {
        new ThreadPoolExecutor(0, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()).execute(new Runnable() { // from class: androidx.profileinstaller.k
            @Override // java.lang.Runnable
            public final void run() {
                i.l(context);
            }
        });
    }

    @Override // e2.a
    @n0
    public List<Class<? extends e2.a<?>>> a() {
        return Collections.emptyList();
    }

    @Override // e2.a
    @n0
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public c b(@n0 Context context) {
        if (Build.VERSION.SDK_INT < 24) {
            return new c();
        }
        g(context.getApplicationContext());
        return new c();
    }

    @v0(16)
    public void g(@n0 final Context context) {
        a.c(new Runnable() { // from class: androidx.profileinstaller.l
            @Override // java.lang.Runnable
            public final void run() {
                this.f6490a.i(context);
            }
        });
    }

    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public void i(@n0 final Context context) {
        (Build.VERSION.SDK_INT >= 28 ? b.a(Looper.getMainLooper()) : new Handler(Looper.getMainLooper())).postDelayed(new Runnable() { // from class: androidx.profileinstaller.j
            @Override // java.lang.Runnable
            public final void run() {
                ProfileInstallerInitializer.l(context);
            }
        }, new Random().nextInt(Math.max(1000, 1)) + 5000);
    }
}
