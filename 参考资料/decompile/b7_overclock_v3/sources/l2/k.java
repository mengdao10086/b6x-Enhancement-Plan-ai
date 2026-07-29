package l2;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.work.ListenableWorker;
import androidx.work.WorkInfo;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.l;
import com.google.common.util.concurrent.ListenableFuture;
import g.i1;
import g.j1;
import g.n0;
import g.p0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import u2.r;
import u2.s;
import u2.v;
import v2.p;
import v2.q;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class k implements Runnable {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f39395t = l.f("WorkerWrapper");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f39396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f39397b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<e> f39398c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WorkerParameters.a f39399d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public r f39400e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ListenableWorker f39401f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public w2.a f39402g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public androidx.work.a f39404i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public t2.a f39405j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public WorkDatabase f39406k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public s f39407l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public u2.b f39408m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public v f39409n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public List<String> f39410o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f39411p;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public volatile boolean f39414s;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @n0
    public ListenableWorker.a f39403h = ListenableWorker.a.a();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @n0
    public androidx.work.impl.utils.futures.a<Boolean> f39412q = androidx.work.impl.utils.futures.a.u();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @p0
    public ListenableFuture<ListenableWorker.a> f39413r = null;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ListenableFuture f39415a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ androidx.work.impl.utils.futures.a f39416b;

        public a(final ListenableFuture val$runExpedited, final androidx.work.impl.utils.futures.a val$future) {
            this.f39415a = val$runExpedited;
            this.f39416b = val$future;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f39415a.get();
                l.c().a(k.f39395t, String.format("Starting work for %s", k.this.f39400e.f51843c), new Throwable[0]);
                k kVar = k.this;
                kVar.f39413r = kVar.f39401f.w();
                this.f39416b.r(k.this.f39413r);
            } catch (Throwable th2) {
                this.f39416b.q(th2);
            }
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ androidx.work.impl.utils.futures.a f39418a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f39419b;

        public b(final androidx.work.impl.utils.futures.a val$future, final String val$workDescription) {
            this.f39418a = val$future;
            this.f39419b = val$workDescription;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        @SuppressLint({"SyntheticAccessor"})
        public void run() {
            try {
                try {
                    ListenableWorker.a aVar = (ListenableWorker.a) this.f39418a.get();
                    if (aVar == null) {
                        l.c().b(k.f39395t, String.format("%s returned a null result. Treating it as a failure.", k.this.f39400e.f51843c), new Throwable[0]);
                    } else {
                        l.c().a(k.f39395t, String.format("%s returned a %s result.", k.this.f39400e.f51843c, aVar), new Throwable[0]);
                        k.this.f39403h = aVar;
                    }
                } catch (InterruptedException e10) {
                    e = e10;
                    l.c().b(k.f39395t, String.format("%s failed because it threw an exception/error", this.f39419b), e);
                } catch (CancellationException e11) {
                    l.c().d(k.f39395t, String.format("%s was cancelled", this.f39419b), e11);
                } catch (ExecutionException e12) {
                    e = e12;
                    l.c().b(k.f39395t, String.format("%s failed because it threw an exception/error", this.f39419b), e);
                }
            } finally {
                k.this.f();
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @n0
        public Context f39421a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @p0
        public ListenableWorker f39422b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @n0
        public t2.a f39423c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @n0
        public w2.a f39424d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @n0
        public androidx.work.a f39425e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @n0
        public WorkDatabase f39426f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @n0
        public String f39427g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public List<e> f39428h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @n0
        public WorkerParameters.a f39429i = new WorkerParameters.a();

        public c(@n0 Context context, @n0 androidx.work.a configuration, @n0 w2.a workTaskExecutor, @n0 t2.a foregroundProcessor, @n0 WorkDatabase database, @n0 String workSpecId) {
            this.f39421a = context.getApplicationContext();
            this.f39424d = workTaskExecutor;
            this.f39423c = foregroundProcessor;
            this.f39425e = configuration;
            this.f39426f = database;
            this.f39427g = workSpecId;
        }

        @n0
        public k a() {
            return new k(this);
        }

        @n0
        public c b(@p0 WorkerParameters.a runtimeExtras) {
            if (runtimeExtras != null) {
                this.f39429i = runtimeExtras;
            }
            return this;
        }

        @n0
        public c c(@n0 List<e> schedulers) {
            this.f39428h = schedulers;
            return this;
        }

        @i1
        @n0
        public c d(@n0 ListenableWorker worker) {
            this.f39422b = worker;
            return this;
        }
    }

    public k(@n0 c builder) {
        this.f39396a = builder.f39421a;
        this.f39402g = builder.f39424d;
        this.f39405j = builder.f39423c;
        this.f39397b = builder.f39427g;
        this.f39398c = builder.f39428h;
        this.f39399d = builder.f39429i;
        this.f39401f = builder.f39422b;
        this.f39404i = builder.f39425e;
        WorkDatabase workDatabase = builder.f39426f;
        this.f39406k = workDatabase;
        this.f39407l = workDatabase.W();
        this.f39408m = this.f39406k.N();
        this.f39409n = this.f39406k.X();
    }

    public final String a(List<String> tags) {
        StringBuilder sb2 = new StringBuilder("Work [ id=");
        sb2.append(this.f39397b);
        sb2.append(", tags={ ");
        boolean z10 = true;
        for (String str : tags) {
            if (z10) {
                z10 = false;
            } else {
                sb2.append(", ");
            }
            sb2.append(str);
        }
        sb2.append(" } ]");
        return sb2.toString();
    }

    @n0
    public ListenableFuture<Boolean> b() {
        return this.f39412q;
    }

    public final void c(ListenableWorker.a result) {
        if (result instanceof ListenableWorker.a.c) {
            l.c().d(f39395t, String.format("Worker result SUCCESS for %s", this.f39411p), new Throwable[0]);
            if (this.f39400e.d()) {
                h();
                return;
            } else {
                m();
                return;
            }
        }
        if (result instanceof ListenableWorker.a.b) {
            l.c().d(f39395t, String.format("Worker result RETRY for %s", this.f39411p), new Throwable[0]);
            g();
            return;
        }
        l.c().d(f39395t, String.format("Worker result FAILURE for %s", this.f39411p), new Throwable[0]);
        if (this.f39400e.d()) {
            h();
        } else {
            l();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void d() {
        boolean zIsDone;
        this.f39414s = true;
        n();
        ListenableFuture<ListenableWorker.a> listenableFuture = this.f39413r;
        if (listenableFuture != null) {
            zIsDone = listenableFuture.isDone();
            this.f39413r.cancel(true);
        } else {
            zIsDone = false;
        }
        ListenableWorker listenableWorker = this.f39401f;
        if (listenableWorker == null || zIsDone) {
            l.c().a(f39395t, String.format("WorkSpec %s is already done. Not interrupting.", this.f39400e), new Throwable[0]);
        } else {
            listenableWorker.x();
        }
    }

    public final void e(String workSpecId) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(workSpecId);
        while (!linkedList.isEmpty()) {
            String str = (String) linkedList.remove();
            if (this.f39407l.t(str) != WorkInfo.State.CANCELLED) {
                this.f39407l.b(WorkInfo.State.FAILED, str);
            }
            linkedList.addAll(this.f39408m.a(str));
        }
    }

    public void f() {
        if (!n()) {
            this.f39406k.e();
            try {
                WorkInfo.State stateT = this.f39407l.t(this.f39397b);
                this.f39406k.V().a(this.f39397b);
                if (stateT == null) {
                    i(false);
                } else if (stateT == WorkInfo.State.RUNNING) {
                    c(this.f39403h);
                } else if (!stateT.isFinished()) {
                    g();
                }
                this.f39406k.K();
            } finally {
                this.f39406k.k();
            }
        }
        List<e> list = this.f39398c;
        if (list != null) {
            Iterator<e> it2 = list.iterator();
            while (it2.hasNext()) {
                it2.next().d(this.f39397b);
            }
            f.b(this.f39404i, this.f39406k, this.f39398c);
        }
    }

    public final void g() {
        this.f39406k.e();
        try {
            this.f39407l.b(WorkInfo.State.ENQUEUED, this.f39397b);
            this.f39407l.C(this.f39397b, System.currentTimeMillis());
            this.f39407l.d(this.f39397b, -1L);
            this.f39406k.K();
        } finally {
            this.f39406k.k();
            i(true);
        }
    }

    public final void h() {
        this.f39406k.e();
        try {
            this.f39407l.C(this.f39397b, System.currentTimeMillis());
            this.f39407l.b(WorkInfo.State.ENQUEUED, this.f39397b);
            this.f39407l.v(this.f39397b);
            this.f39407l.d(this.f39397b, -1L);
            this.f39406k.K();
        } finally {
            this.f39406k.k();
            i(false);
        }
    }

    public final void i(final boolean needsReschedule) {
        ListenableWorker listenableWorker;
        this.f39406k.e();
        try {
            if (!this.f39406k.W().q()) {
                v2.e.c(this.f39396a, RescheduleReceiver.class, false);
            }
            if (needsReschedule) {
                this.f39407l.b(WorkInfo.State.ENQUEUED, this.f39397b);
                this.f39407l.d(this.f39397b, -1L);
            }
            if (this.f39400e != null && (listenableWorker = this.f39401f) != null && listenableWorker.o()) {
                this.f39405j.b(this.f39397b);
            }
            this.f39406k.K();
            this.f39406k.k();
            this.f39412q.p(Boolean.valueOf(needsReschedule));
        } catch (Throwable th2) {
            this.f39406k.k();
            throw th2;
        }
    }

    public final void j() {
        WorkInfo.State stateT = this.f39407l.t(this.f39397b);
        if (stateT == WorkInfo.State.RUNNING) {
            l.c().a(f39395t, String.format("Status for %s is RUNNING;not doing any work and rescheduling for later execution", this.f39397b), new Throwable[0]);
            i(true);
        } else {
            l.c().a(f39395t, String.format("Status for %s is %s; not doing any work", this.f39397b, stateT), new Throwable[0]);
            i(false);
        }
    }

    public final void k() {
        androidx.work.d dVarB;
        if (n()) {
            return;
        }
        this.f39406k.e();
        try {
            r rVarU = this.f39407l.u(this.f39397b);
            this.f39400e = rVarU;
            if (rVarU == null) {
                l.c().b(f39395t, String.format("Didn't find WorkSpec for id %s", this.f39397b), new Throwable[0]);
                i(false);
                this.f39406k.K();
                return;
            }
            if (rVarU.f51842b != WorkInfo.State.ENQUEUED) {
                j();
                this.f39406k.K();
                l.c().a(f39395t, String.format("%s is not in ENQUEUED state. Nothing more to do.", this.f39400e.f51843c), new Throwable[0]);
                return;
            }
            if (rVarU.d() || this.f39400e.c()) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                r rVar = this.f39400e;
                if (!(rVar.f51854n == 0) && jCurrentTimeMillis < rVar.a()) {
                    l.c().a(f39395t, String.format("Delaying execution for %s because it is being executed before schedule.", this.f39400e.f51843c), new Throwable[0]);
                    i(true);
                    this.f39406k.K();
                    return;
                }
            }
            this.f39406k.K();
            this.f39406k.k();
            if (this.f39400e.d()) {
                dVarB = this.f39400e.f51845e;
            } else {
                androidx.work.j jVarB = this.f39404i.f().b(this.f39400e.f51844d);
                if (jVarB == null) {
                    l.c().b(f39395t, String.format("Could not create Input Merger %s", this.f39400e.f51844d), new Throwable[0]);
                    l();
                    return;
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(this.f39400e.f51845e);
                    arrayList.addAll(this.f39407l.A(this.f39397b));
                    dVarB = jVarB.b(arrayList);
                }
            }
            WorkerParameters workerParameters = new WorkerParameters(UUID.fromString(this.f39397b), dVarB, this.f39410o, this.f39399d, this.f39400e.f51851k, this.f39404i.e(), this.f39402g, this.f39404i.m(), new v2.r(this.f39406k, this.f39402g), new q(this.f39406k, this.f39405j, this.f39402g));
            if (this.f39401f == null) {
                this.f39401f = this.f39404i.m().b(this.f39396a, this.f39400e.f51843c, workerParameters);
            }
            ListenableWorker listenableWorker = this.f39401f;
            if (listenableWorker == null) {
                l.c().b(f39395t, String.format("Could not create Worker %s", this.f39400e.f51843c), new Throwable[0]);
                l();
                return;
            }
            if (listenableWorker.q()) {
                l.c().b(f39395t, String.format("Received an already-used Worker %s; WorkerFactory should return new instances", this.f39400e.f51843c), new Throwable[0]);
                l();
                return;
            }
            this.f39401f.v();
            if (!o()) {
                j();
                return;
            }
            if (n()) {
                return;
            }
            androidx.work.impl.utils.futures.a aVarU = androidx.work.impl.utils.futures.a.u();
            p pVar = new p(this.f39396a, this.f39400e, this.f39401f, workerParameters.b(), this.f39402g);
            this.f39402g.b().execute(pVar);
            ListenableFuture<Void> listenableFutureA = pVar.a();
            listenableFutureA.addListener(new a(listenableFutureA, aVarU), this.f39402g.b());
            aVarU.addListener(new b(aVarU, this.f39411p), this.f39402g.d());
        } finally {
            this.f39406k.k();
        }
    }

    @i1
    public void l() {
        this.f39406k.e();
        try {
            e(this.f39397b);
            this.f39407l.k(this.f39397b, ((ListenableWorker.a.C0079a) this.f39403h).c());
            this.f39406k.K();
        } finally {
            this.f39406k.k();
            i(false);
        }
    }

    public final void m() {
        this.f39406k.e();
        try {
            this.f39407l.b(WorkInfo.State.SUCCEEDED, this.f39397b);
            this.f39407l.k(this.f39397b, ((ListenableWorker.a.c) this.f39403h).c());
            long jCurrentTimeMillis = System.currentTimeMillis();
            for (String str : this.f39408m.a(this.f39397b)) {
                if (this.f39407l.t(str) == WorkInfo.State.BLOCKED && this.f39408m.b(str)) {
                    l.c().d(f39395t, String.format("Setting status to enqueued for %s", str), new Throwable[0]);
                    this.f39407l.b(WorkInfo.State.ENQUEUED, str);
                    this.f39407l.C(str, jCurrentTimeMillis);
                }
            }
            this.f39406k.K();
        } finally {
            this.f39406k.k();
            i(false);
        }
    }

    public final boolean n() {
        if (!this.f39414s) {
            return false;
        }
        l.c().a(f39395t, String.format("Work interrupted for %s", this.f39411p), new Throwable[0]);
        if (this.f39407l.t(this.f39397b) == null) {
            i(false);
        } else {
            i(!r0.isFinished());
        }
        return true;
    }

    public final boolean o() {
        this.f39406k.e();
        try {
            boolean z10 = true;
            if (this.f39407l.t(this.f39397b) == WorkInfo.State.ENQUEUED) {
                this.f39407l.b(WorkInfo.State.RUNNING, this.f39397b);
                this.f39407l.B(this.f39397b);
            } else {
                z10 = false;
            }
            this.f39406k.K();
            return z10;
        } finally {
            this.f39406k.k();
        }
    }

    @Override // java.lang.Runnable
    @j1
    public void run() {
        List<String> listA = this.f39409n.a(this.f39397b);
        this.f39410o = listA;
        this.f39411p = a(listA);
        k();
    }
}
