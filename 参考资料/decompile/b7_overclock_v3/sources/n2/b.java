package n2;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.RestrictTo;
import androidx.work.WorkInfo;
import androidx.work.l;
import g.i1;
import g.n0;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import l2.e;
import l2.i;
import q2.c;
import q2.d;
import u2.r;
import v2.g;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class b implements e, c, l2.b {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f41757i = l.f("GreedyScheduler");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f41758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f41759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f41760c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f41762e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f41763f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Boolean f41765h;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<r> f41761d = new HashSet();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f41764g = new Object();

    public b(@n0 Context context, @n0 androidx.work.a configuration, @n0 w2.a taskExecutor, @n0 i workManagerImpl) {
        this.f41758a = context;
        this.f41759b = workManagerImpl;
        this.f41760c = new d(context, taskExecutor, this);
        this.f41762e = new a(this, configuration.k());
    }

    @Override // l2.e
    public boolean a() {
        return false;
    }

    @Override // q2.c
    public void b(@n0 List<String> workSpecIds) {
        for (String str : workSpecIds) {
            l.c().a(f41757i, String.format("Constraints not met: Cancelling work ID %s", str), new Throwable[0]);
            this.f41759b.X(str);
        }
    }

    @Override // l2.b
    public void c(@n0 String workSpecId, boolean needsReschedule) {
        i(workSpecId);
    }

    @Override // l2.e
    public void d(@n0 String workSpecId) {
        if (this.f41765h == null) {
            g();
        }
        if (!this.f41765h.booleanValue()) {
            l.c().d(f41757i, "Ignoring schedule request in non-main process", new Throwable[0]);
            return;
        }
        h();
        l.c().a(f41757i, String.format("Cancelling work ID %s", workSpecId), new Throwable[0]);
        a aVar = this.f41762e;
        if (aVar != null) {
            aVar.b(workSpecId);
        }
        this.f41759b.X(workSpecId);
    }

    @Override // l2.e
    public void e(@n0 r... workSpecs) {
        if (this.f41765h == null) {
            g();
        }
        if (!this.f41765h.booleanValue()) {
            l.c().d(f41757i, "Ignoring schedule request in a secondary process", new Throwable[0]);
            return;
        }
        h();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (r rVar : workSpecs) {
            long jA = rVar.a();
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (rVar.f51842b == WorkInfo.State.ENQUEUED) {
                if (jCurrentTimeMillis < jA) {
                    a aVar = this.f41762e;
                    if (aVar != null) {
                        aVar.a(rVar);
                    }
                } else if (rVar.b()) {
                    int i10 = Build.VERSION.SDK_INT;
                    if (i10 >= 23 && rVar.f51850j.h()) {
                        l.c().a(f41757i, String.format("Ignoring WorkSpec %s, Requires device idle.", rVar), new Throwable[0]);
                    } else if (i10 < 24 || !rVar.f51850j.e()) {
                        hashSet.add(rVar);
                        hashSet2.add(rVar.f51841a);
                    } else {
                        l.c().a(f41757i, String.format("Ignoring WorkSpec %s, Requires ContentUri triggers.", rVar), new Throwable[0]);
                    }
                } else {
                    l.c().a(f41757i, String.format("Starting work for %s", rVar.f51841a), new Throwable[0]);
                    this.f41759b.U(rVar.f51841a);
                }
            }
        }
        synchronized (this.f41764g) {
            if (!hashSet.isEmpty()) {
                l.c().a(f41757i, String.format("Starting tracking for [%s]", TextUtils.join(ag.c.f654g, hashSet2)), new Throwable[0]);
                this.f41761d.addAll(hashSet);
                this.f41760c.d(this.f41761d);
            }
        }
    }

    @Override // q2.c
    public void f(@n0 List<String> workSpecIds) {
        for (String str : workSpecIds) {
            l.c().a(f41757i, String.format("Constraints met: Scheduling work ID %s", str), new Throwable[0]);
            this.f41759b.U(str);
        }
    }

    public final void g() {
        this.f41765h = Boolean.valueOf(g.b(this.f41758a, this.f41759b.F()));
    }

    public final void h() {
        if (this.f41763f) {
            return;
        }
        this.f41759b.J().d(this);
        this.f41763f = true;
    }

    public final void i(@n0 String workSpecId) {
        synchronized (this.f41764g) {
            Iterator<r> it2 = this.f41761d.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                r next = it2.next();
                if (next.f51841a.equals(workSpecId)) {
                    l.c().a(f41757i, String.format("Stopping tracking for %s", workSpecId), new Throwable[0]);
                    this.f41761d.remove(next);
                    this.f41760c.d(this.f41761d);
                    break;
                }
            }
        }
    }

    @i1
    public void j(@n0 a delayedWorkTracker) {
        this.f41762e = delayedWorkTracker;
    }

    @i1
    public b(@n0 Context context, @n0 i workManagerImpl, @n0 d workConstraintsTracker) {
        this.f41758a = context;
        this.f41759b = workManagerImpl;
        this.f41760c = workConstraintsTracker;
    }
}
