package androidx.work;

import android.content.Context;
import g.i1;
import g.n0;
import g.p0;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class f extends y {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f8364c = l.f("DelegatingWkrFctry");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<y> f8365b = new CopyOnWriteArrayList();

    @Override // androidx.work.y
    @p0
    public final ListenableWorker a(@n0 Context appContext, @n0 String workerClassName, @n0 WorkerParameters workerParameters) {
        Iterator<y> it2 = this.f8365b.iterator();
        while (it2.hasNext()) {
            try {
                ListenableWorker listenableWorkerA = it2.next().a(appContext, workerClassName, workerParameters);
                if (listenableWorkerA != null) {
                    return listenableWorkerA;
                }
            } catch (Throwable th2) {
                l.c().b(f8364c, String.format("Unable to instantiate a ListenableWorker (%s)", workerClassName), th2);
                throw th2;
            }
        }
        return null;
    }

    public final void d(@n0 y workerFactory) {
        this.f8365b.add(workerFactory);
    }

    @i1
    @n0
    public List<y> e() {
        return this.f8365b;
    }
}
