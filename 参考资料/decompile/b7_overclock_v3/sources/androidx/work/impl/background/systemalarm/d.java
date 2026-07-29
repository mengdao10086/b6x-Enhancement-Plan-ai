package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import androidx.annotation.RestrictTo;
import androidx.work.l;
import g.i1;
import g.k0;
import g.n0;
import g.p0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import l2.i;
import v2.j;
import v2.o;
import v2.s;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class d implements l2.b {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f8455k = l.f("SystemAlarmDispatcher");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f8456l = "ProcessCommand";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f8457m = "KEY_START_ID";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f8458n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f8459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w2.a f8460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s f8461c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l2.d f8462d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final i f8463e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final androidx.work.impl.background.systemalarm.a f8464f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Handler f8465g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<Intent> f8466h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Intent f8467i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @p0
    public c f8468j;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar;
            RunnableC0082d runnableC0082d;
            synchronized (d.this.f8466h) {
                d dVar2 = d.this;
                dVar2.f8467i = dVar2.f8466h.get(0);
            }
            Intent intent = d.this.f8467i;
            if (intent != null) {
                String action = intent.getAction();
                int intExtra = d.this.f8467i.getIntExtra(d.f8457m, 0);
                l lVarC = l.c();
                String str = d.f8455k;
                lVarC.a(str, String.format("Processing command %s, %s", d.this.f8467i, Integer.valueOf(intExtra)), new Throwable[0]);
                PowerManager.WakeLock wakeLockB = o.b(d.this.f8459a, String.format("%s (%s)", action, Integer.valueOf(intExtra)));
                try {
                    l.c().a(str, String.format("Acquiring operation wake lock (%s) %s", action, wakeLockB), new Throwable[0]);
                    wakeLockB.acquire();
                    d dVar3 = d.this;
                    dVar3.f8464f.p(dVar3.f8467i, intExtra, dVar3);
                    l.c().a(str, String.format("Releasing operation wake lock (%s) %s", action, wakeLockB), new Throwable[0]);
                    wakeLockB.release();
                    dVar = d.this;
                    runnableC0082d = new RunnableC0082d(dVar);
                } catch (Throwable th2) {
                    try {
                        l lVarC2 = l.c();
                        String str2 = d.f8455k;
                        lVarC2.b(str2, "Unexpected error in onHandleIntent", th2);
                        l.c().a(str2, String.format("Releasing operation wake lock (%s) %s", action, wakeLockB), new Throwable[0]);
                        wakeLockB.release();
                        dVar = d.this;
                        runnableC0082d = new RunnableC0082d(dVar);
                    } catch (Throwable th3) {
                        l.c().a(d.f8455k, String.format("Releasing operation wake lock (%s) %s", action, wakeLockB), new Throwable[0]);
                        wakeLockB.release();
                        d dVar4 = d.this;
                        dVar4.k(new RunnableC0082d(dVar4));
                        throw th3;
                    }
                }
                dVar.k(runnableC0082d);
            }
        }
    }

    public static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f8470a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Intent f8471b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f8472c;

        public b(@n0 d dispatcher, @n0 Intent intent, int startId) {
            this.f8470a = dispatcher;
            this.f8471b = intent;
            this.f8472c = startId;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f8470a.a(this.f8471b, this.f8472c);
        }
    }

    public interface c {
        void h();
    }

    /* JADX INFO: renamed from: androidx.work.impl.background.systemalarm.d$d, reason: collision with other inner class name */
    public static class RunnableC0082d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f8473a;

        public RunnableC0082d(@n0 d dispatcher) {
            this.f8473a = dispatcher;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f8473a.d();
        }
    }

    public d(@n0 Context context) {
        this(context, null, null);
    }

    @k0
    public boolean a(@n0 final Intent intent, final int startId) {
        l lVarC = l.c();
        String str = f8455k;
        lVarC.a(str, String.format("Adding command %s (%s)", intent, Integer.valueOf(startId)), new Throwable[0]);
        b();
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            l.c().h(str, "Unknown command. Ignoring", new Throwable[0]);
            return false;
        }
        if (androidx.work.impl.background.systemalarm.a.f8428h.equals(action) && i(androidx.work.impl.background.systemalarm.a.f8428h)) {
            return false;
        }
        intent.putExtra(f8457m, startId);
        synchronized (this.f8466h) {
            boolean z10 = this.f8466h.isEmpty() ? false : true;
            this.f8466h.add(intent);
            if (!z10) {
                l();
            }
        }
        return true;
    }

    public final void b() {
        if (this.f8465g.getLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Needs to be invoked on the main thread.");
        }
    }

    @Override // l2.b
    public void c(@n0 String workSpecId, boolean needsReschedule) {
        k(new b(this, androidx.work.impl.background.systemalarm.a.d(this.f8459a, workSpecId, needsReschedule), 0));
    }

    @k0
    public void d() {
        l lVarC = l.c();
        String str = f8455k;
        lVarC.a(str, "Checking if commands are complete.", new Throwable[0]);
        b();
        synchronized (this.f8466h) {
            if (this.f8467i != null) {
                l.c().a(str, String.format("Removing command %s", this.f8467i), new Throwable[0]);
                if (!this.f8466h.remove(0).equals(this.f8467i)) {
                    throw new IllegalStateException("Dequeue-d command is not the first.");
                }
                this.f8467i = null;
            }
            j jVarD = this.f8460b.d();
            if (!this.f8464f.o() && this.f8466h.isEmpty() && !jVarD.b()) {
                l.c().a(str, "No more commands & intents.", new Throwable[0]);
                c cVar = this.f8468j;
                if (cVar != null) {
                    cVar.h();
                }
            } else if (!this.f8466h.isEmpty()) {
                l();
            }
        }
    }

    public l2.d e() {
        return this.f8462d;
    }

    public w2.a f() {
        return this.f8460b;
    }

    public i g() {
        return this.f8463e;
    }

    public s h() {
        return this.f8461c;
    }

    @k0
    public final boolean i(@n0 String action) {
        b();
        synchronized (this.f8466h) {
            Iterator<Intent> it2 = this.f8466h.iterator();
            while (it2.hasNext()) {
                if (action.equals(it2.next().getAction())) {
                    return true;
                }
            }
            return false;
        }
    }

    public void j() {
        l.c().a(f8455k, "Destroying SystemAlarmDispatcher", new Throwable[0]);
        this.f8462d.j(this);
        this.f8461c.d();
        this.f8468j = null;
    }

    public void k(@n0 Runnable runnable) {
        this.f8465g.post(runnable);
    }

    @k0
    public final void l() {
        b();
        PowerManager.WakeLock wakeLockB = o.b(this.f8459a, f8456l);
        try {
            wakeLockB.acquire();
            this.f8463e.O().c(new a());
        } finally {
            wakeLockB.release();
        }
    }

    public void m(@n0 c listener) {
        if (this.f8468j != null) {
            l.c().b(f8455k, "A completion listener for SystemAlarmDispatcher already exists.", new Throwable[0]);
        } else {
            this.f8468j = listener;
        }
    }

    @i1
    public d(@n0 Context context, @p0 l2.d processor, @p0 i workManager) {
        Context applicationContext = context.getApplicationContext();
        this.f8459a = applicationContext;
        this.f8464f = new androidx.work.impl.background.systemalarm.a(applicationContext);
        this.f8461c = new s();
        workManager = workManager == null ? i.H(context) : workManager;
        this.f8463e = workManager;
        processor = processor == null ? workManager.J() : processor;
        this.f8462d = processor;
        this.f8460b = workManager.O();
        processor.d(this);
        this.f8466h = new ArrayList();
        this.f8467i = null;
        this.f8465g = new Handler(Looper.getMainLooper());
    }
}
