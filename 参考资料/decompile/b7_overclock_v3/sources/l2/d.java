package l2;

import android.content.Context;
import android.os.PowerManager;
import androidx.annotation.RestrictTo;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.l;
import com.google.common.util.concurrent.ListenableFuture;
import g.n0;
import g.p0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import l2.k;
import v2.o;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class d implements b, t2.a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f39343l = l.f("Processor");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f39344m = "ProcessorForegroundLck";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f39346b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public androidx.work.a f39347c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public w2.a f39348d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public WorkDatabase f39349e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List<e> f39352h;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Map<String, k> f39351g = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map<String, k> f39350f = new HashMap();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Set<String> f39353i = new HashSet();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<b> f39354j = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @p0
    public PowerManager.WakeLock f39345a = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Object f39355k = new Object();

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @n0
        public b f39356a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @n0
        public String f39357b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @n0
        public ListenableFuture<Boolean> f39358c;

        public a(@n0 b executionListener, @n0 String workSpecId, @n0 ListenableFuture<Boolean> future) {
            this.f39356a = executionListener;
            this.f39357b = workSpecId;
            this.f39358c = future;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean zBooleanValue;
            try {
                zBooleanValue = this.f39358c.get().booleanValue();
            } catch (InterruptedException | ExecutionException unused) {
                zBooleanValue = true;
            }
            this.f39356a.c(this.f39357b, zBooleanValue);
        }
    }

    public d(@n0 Context appContext, @n0 androidx.work.a configuration, @n0 w2.a workTaskExecutor, @n0 WorkDatabase workDatabase, @n0 List<e> schedulers) {
        this.f39346b = appContext;
        this.f39347c = configuration;
        this.f39348d = workTaskExecutor;
        this.f39349e = workDatabase;
        this.f39352h = schedulers;
    }

    public static boolean f(@n0 String id2, @p0 k wrapper) {
        if (wrapper == null) {
            l.c().a(f39343l, String.format("WorkerWrapper could not be found for %s", id2), new Throwable[0]);
            return false;
        }
        wrapper.d();
        l.c().a(f39343l, String.format("WorkerWrapper interrupted for %s", id2), new Throwable[0]);
        return true;
    }

    @Override // t2.a
    public void a(@n0 String workSpecId, @n0 androidx.work.g foregroundInfo) {
        synchronized (this.f39355k) {
            l.c().d(f39343l, String.format("Moving WorkSpec (%s) to the foreground", workSpecId), new Throwable[0]);
            k kVarRemove = this.f39351g.remove(workSpecId);
            if (kVarRemove != null) {
                if (this.f39345a == null) {
                    PowerManager.WakeLock wakeLockB = o.b(this.f39346b, f39344m);
                    this.f39345a = wakeLockB;
                    wakeLockB.acquire();
                }
                this.f39350f.put(workSpecId, kVarRemove);
                h0.d.x(this.f39346b, androidx.work.impl.foreground.a.e(this.f39346b, workSpecId, foregroundInfo));
            }
        }
    }

    @Override // t2.a
    public void b(@n0 String workSpecId) {
        synchronized (this.f39355k) {
            this.f39350f.remove(workSpecId);
            n();
        }
    }

    @Override // l2.b
    public void c(@n0 final String workSpecId, boolean needsReschedule) {
        synchronized (this.f39355k) {
            this.f39351g.remove(workSpecId);
            l.c().a(f39343l, String.format("%s %s executed; reschedule = %s", getClass().getSimpleName(), workSpecId, Boolean.valueOf(needsReschedule)), new Throwable[0]);
            Iterator<b> it2 = this.f39354j.iterator();
            while (it2.hasNext()) {
                it2.next().c(workSpecId, needsReschedule);
            }
        }
    }

    public void d(@n0 b executionListener) {
        synchronized (this.f39355k) {
            this.f39354j.add(executionListener);
        }
    }

    public boolean e() {
        boolean z10;
        synchronized (this.f39355k) {
            z10 = (this.f39351g.isEmpty() && this.f39350f.isEmpty()) ? false : true;
        }
        return z10;
    }

    public boolean g(@n0 String id2) {
        boolean zContains;
        synchronized (this.f39355k) {
            zContains = this.f39353i.contains(id2);
        }
        return zContains;
    }

    public boolean h(@n0 String workSpecId) {
        boolean z10;
        synchronized (this.f39355k) {
            z10 = this.f39351g.containsKey(workSpecId) || this.f39350f.containsKey(workSpecId);
        }
        return z10;
    }

    public boolean i(@n0 String workSpecId) {
        boolean zContainsKey;
        synchronized (this.f39355k) {
            zContainsKey = this.f39350f.containsKey(workSpecId);
        }
        return zContainsKey;
    }

    public void j(@n0 b executionListener) {
        synchronized (this.f39355k) {
            this.f39354j.remove(executionListener);
        }
    }

    public boolean k(@n0 String id2) {
        return l(id2, null);
    }

    public boolean l(@n0 String id2, @p0 WorkerParameters.a runtimeExtras) {
        synchronized (this.f39355k) {
            if (h(id2)) {
                l.c().a(f39343l, String.format("Work %s is already enqueued for processing", id2), new Throwable[0]);
                return false;
            }
            k kVarA = new k.c(this.f39346b, this.f39347c, this.f39348d, this, this.f39349e, id2).c(this.f39352h).b(runtimeExtras).a();
            ListenableFuture<Boolean> listenableFutureB = kVarA.b();
            listenableFutureB.addListener(new a(this, id2, listenableFutureB), this.f39348d.b());
            this.f39351g.put(id2, kVarA);
            this.f39348d.d().execute(kVarA);
            l.c().a(f39343l, String.format("%s: processing %s", getClass().getSimpleName(), id2), new Throwable[0]);
            return true;
        }
    }

    public boolean m(@n0 String id2) {
        boolean zF;
        synchronized (this.f39355k) {
            boolean z10 = true;
            l.c().a(f39343l, String.format("Processor cancelling %s", id2), new Throwable[0]);
            this.f39353i.add(id2);
            k kVarRemove = this.f39350f.remove(id2);
            if (kVarRemove == null) {
                z10 = false;
            }
            if (kVarRemove == null) {
                kVarRemove = this.f39351g.remove(id2);
            }
            zF = f(id2, kVarRemove);
            if (z10) {
                n();
            }
        }
        return zF;
    }

    public final void n() {
        synchronized (this.f39355k) {
            if (!(!this.f39350f.isEmpty())) {
                try {
                    this.f39346b.startService(androidx.work.impl.foreground.a.g(this.f39346b));
                } catch (Throwable th2) {
                    l.c().b(f39343l, "Unable to stop foreground service", th2);
                }
                PowerManager.WakeLock wakeLock = this.f39345a;
                if (wakeLock != null) {
                    wakeLock.release();
                    this.f39345a = null;
                }
            }
        }
    }

    public boolean o(@n0 String id2) {
        boolean zF;
        synchronized (this.f39355k) {
            l.c().a(f39343l, String.format("Processor stopping foreground work %s", id2), new Throwable[0]);
            zF = f(id2, this.f39350f.remove(id2));
        }
        return zF;
    }

    public boolean p(@n0 String id2) {
        boolean zF;
        synchronized (this.f39355k) {
            l.c().a(f39343l, String.format("Processor stopping background work %s", id2), new Throwable[0]);
            zF = f(id2, this.f39351g.remove(id2));
        }
        return zF;
    }
}
