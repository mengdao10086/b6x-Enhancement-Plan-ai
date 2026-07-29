package n2;

import androidx.annotation.RestrictTo;
import androidx.work.l;
import androidx.work.t;
import g.n0;
import java.util.HashMap;
import java.util.Map;
import u2.r;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f41751d = l.f("DelayedWorkTracker");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f41752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t f41753b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Runnable> f41754c = new HashMap();

    /* JADX INFO: renamed from: n2.a$a, reason: collision with other inner class name */
    public class RunnableC0461a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r f41755a;

        public RunnableC0461a(final r val$workSpec) {
            this.f41755a = val$workSpec;
        }

        @Override // java.lang.Runnable
        public void run() {
            l.c().a(a.f41751d, String.format("Scheduling work %s", this.f41755a.f51841a), new Throwable[0]);
            a.this.f41752a.e(this.f41755a);
        }
    }

    public a(@n0 b scheduler, @n0 t runnableScheduler) {
        this.f41752a = scheduler;
        this.f41753b = runnableScheduler;
    }

    public void a(@n0 final r workSpec) {
        Runnable runnableRemove = this.f41754c.remove(workSpec.f51841a);
        if (runnableRemove != null) {
            this.f41753b.b(runnableRemove);
        }
        RunnableC0461a runnableC0461a = new RunnableC0461a(workSpec);
        this.f41754c.put(workSpec.f51841a, runnableC0461a);
        this.f41753b.a(workSpec.a() - System.currentTimeMillis(), runnableC0461a);
    }

    public void b(@n0 String workSpecId) {
        Runnable runnableRemove = this.f41754c.remove(workSpecId);
        if (runnableRemove != null) {
            this.f41753b.b(runnableRemove);
        }
    }
}
