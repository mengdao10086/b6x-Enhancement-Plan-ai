package androidx.work;

import android.content.Context;
import androidx.annotation.RestrictTo;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f8770a = l.f("WorkerFactory");

    public class a extends y {
        @Override // androidx.work.y
        @p0
        public ListenableWorker a(@n0 Context appContext, @n0 String workerClassName, @n0 WorkerParameters workerParameters) {
            return null;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @n0
    public static y c() {
        return new a();
    }

    @p0
    public abstract ListenableWorker a(@n0 Context appContext, @n0 String workerClassName, @n0 WorkerParameters workerParameters);

    @p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final ListenableWorker b(@n0 Context appContext, @n0 String workerClassName, @n0 WorkerParameters workerParameters) {
        ListenableWorker listenableWorkerA = a(appContext, workerClassName, workerParameters);
        if (listenableWorkerA == null) {
            Class clsAsSubclass = null;
            try {
                clsAsSubclass = Class.forName(workerClassName).asSubclass(ListenableWorker.class);
            } catch (Throwable th2) {
                l.c().b(f8770a, "Invalid class: " + workerClassName, th2);
            }
            if (clsAsSubclass != null) {
                try {
                    listenableWorkerA = (ListenableWorker) clsAsSubclass.getDeclaredConstructor(Context.class, WorkerParameters.class).newInstance(appContext, workerParameters);
                } catch (Throwable th3) {
                    l.c().b(f8770a, "Could not instantiate " + workerClassName, th3);
                }
            }
        }
        if (listenableWorkerA == null || !listenableWorkerA.q()) {
            return listenableWorkerA;
        }
        throw new IllegalStateException(String.format("WorkerFactory (%s) returned an instance of a ListenableWorker (%s) which has already been invoked. createWorker() must always return a new instance of a ListenableWorker.", getClass().getName(), workerClassName));
    }
}
