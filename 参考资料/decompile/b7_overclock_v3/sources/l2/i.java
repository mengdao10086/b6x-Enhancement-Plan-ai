package l2;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.LiveData;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ExistingWorkPolicy;
import androidx.work.R;
import androidx.work.WorkInfo;
import androidx.work.WorkerParameters;
import androidx.work.a;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.utils.ForceStopRunnable;
import androidx.work.l;
import androidx.work.multiprocess.l;
import androidx.work.o;
import androidx.work.p;
import androidx.work.u;
import androidx.work.v;
import androidx.work.w;
import androidx.work.x;
import com.google.common.util.concurrent.ListenableFuture;
import g.n0;
import g.p0;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import u2.r;
import v2.m;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class i extends v {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f39375l = 22;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f39376m = 23;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f39377n = "androidx.work.multiprocess.RemoteWorkManagerClient";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f39381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public androidx.work.a f39382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WorkDatabase f39383c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public w2.a f39384d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<e> f39385e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d f39386f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public v2.f f39387g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f39388h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public BroadcastReceiver.PendingResult f39389i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile l f39390j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f39374k = androidx.work.l.f("WorkManagerImpl");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static i f39378o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static i f39379p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Object f39380q = new Object();

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ androidx.work.impl.utils.futures.a f39391a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ v2.f f39392b;

        public a(final androidx.work.impl.utils.futures.a val$future, final v2.f val$preferenceUtils) {
            this.f39391a = val$future;
            this.f39392b = val$preferenceUtils;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f39391a.p(Long.valueOf(this.f39392b.a()));
            } catch (Throwable th2) {
                this.f39391a.q(th2);
            }
        }
    }

    public class b implements p.a<List<r.c>, WorkInfo> {
        public b() {
        }

        @Override // p.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public WorkInfo apply(List<r.c> input) {
            if (input == null || input.size() <= 0) {
                return null;
            }
            return input.get(0).a();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public i(@n0 Context context, @n0 androidx.work.a configuration, @n0 w2.a workTaskExecutor) {
        this(context, configuration, workTaskExecutor, context.getResources().getBoolean(R.bool.workmanager_test_configuration));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void A(@n0 Context context, @n0 androidx.work.a configuration) {
        synchronized (f39380q) {
            i iVar = f39378o;
            if (iVar != null && f39379p != null) {
                throw new IllegalStateException("WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class level Javadoc for more information.");
            }
            if (iVar == null) {
                Context applicationContext = context.getApplicationContext();
                if (f39379p == null) {
                    f39379p = new i(applicationContext, configuration, new w2.b(configuration.l()));
                }
                f39378o = f39379p;
            }
        }
    }

    @p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @Deprecated
    public static i G() {
        synchronized (f39380q) {
            i iVar = f39378o;
            if (iVar != null) {
                return iVar;
            }
            return f39379p;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @n0
    public static i H(@n0 Context context) {
        i iVarG;
        synchronized (f39380q) {
            iVarG = G();
            if (iVarG == null) {
                Context applicationContext = context.getApplicationContext();
                if (!(applicationContext instanceof a.c)) {
                    throw new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");
                }
                A(applicationContext, ((a.c) applicationContext).c());
                iVarG = H(applicationContext);
            }
        }
        return iVarG;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static void S(@p0 i delegate) {
        synchronized (f39380q) {
            f39378o = delegate;
        }
    }

    @Override // androidx.work.v
    @n0
    public o B() {
        v2.h hVar = new v2.h(this);
        this.f39384d.c(hVar);
        return hVar.a();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @n0
    public List<e> C(@n0 Context context, @n0 androidx.work.a configuration, @n0 w2.a taskExecutor) {
        return Arrays.asList(f.a(context, this), new n2.b(context, configuration, taskExecutor, this));
    }

    @n0
    public g D(@n0 String uniqueWorkName, @n0 ExistingPeriodicWorkPolicy existingPeriodicWorkPolicy, @n0 p periodicWork) {
        return new g(this, uniqueWorkName, existingPeriodicWorkPolicy == ExistingPeriodicWorkPolicy.KEEP ? ExistingWorkPolicy.KEEP : ExistingWorkPolicy.REPLACE, Collections.singletonList(periodicWork));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @n0
    public Context E() {
        return this.f39381a;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @n0
    public androidx.work.a F() {
        return this.f39382b;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @n0
    public v2.f I() {
        return this.f39387g;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @n0
    public d J() {
        return this.f39386f;
    }

    @p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public l K() {
        if (this.f39390j == null) {
            synchronized (f39380q) {
                if (this.f39390j == null) {
                    Y();
                    if (this.f39390j == null && !TextUtils.isEmpty(this.f39382b.c())) {
                        throw new IllegalStateException("Invalid multiprocess configuration. Define an `implementation` dependency on :work:work-multiprocess library");
                    }
                }
            }
        }
        return this.f39390j;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @n0
    public List<e> L() {
        return this.f39385e;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @n0
    public WorkDatabase M() {
        return this.f39383c;
    }

    public LiveData<List<WorkInfo>> N(@n0 List<String> workSpecIds) {
        return v2.d.a(this.f39383c.W().y(workSpecIds), r.f51840u, this.f39384d);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @n0
    public w2.a O() {
        return this.f39384d;
    }

    public final void P(@n0 Context context, @n0 androidx.work.a configuration, @n0 w2.a workTaskExecutor, @n0 WorkDatabase workDatabase, @n0 List<e> schedulers, @n0 d processor) {
        Context applicationContext = context.getApplicationContext();
        this.f39381a = applicationContext;
        this.f39382b = configuration;
        this.f39384d = workTaskExecutor;
        this.f39383c = workDatabase;
        this.f39385e = schedulers;
        this.f39386f = processor;
        this.f39387g = new v2.f(workDatabase);
        this.f39388h = false;
        if (Build.VERSION.SDK_INT >= 24 && applicationContext.isDeviceProtectedStorage()) {
            throw new IllegalStateException("Cannot initialize WorkManager in direct boot mode");
        }
        this.f39384d.c(new ForceStopRunnable(applicationContext, this));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void Q() {
        synchronized (f39380q) {
            this.f39388h = true;
            BroadcastReceiver.PendingResult pendingResult = this.f39389i;
            if (pendingResult != null) {
                pendingResult.finish();
                this.f39389i = null;
            }
        }
    }

    public void R() {
        if (Build.VERSION.SDK_INT >= 23) {
            p2.b.b(E());
        }
        M().W().H();
        f.b(F(), M(), L());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void T(@n0 BroadcastReceiver.PendingResult rescheduleReceiverResult) {
        synchronized (f39380q) {
            this.f39389i = rescheduleReceiverResult;
            if (this.f39388h) {
                rescheduleReceiverResult.finish();
                this.f39389i = null;
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void U(@n0 String workSpecId) {
        V(workSpecId, null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void V(@n0 String workSpecId, @p0 WorkerParameters.a runtimeExtras) {
        this.f39384d.c(new v2.k(this, workSpecId, runtimeExtras));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void W(@n0 String workSpecId) {
        this.f39384d.c(new m(this, workSpecId, true));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void X(@n0 String workSpecId) {
        this.f39384d.c(new m(this, workSpecId, false));
    }

    public final void Y() {
        try {
            this.f39390j = (l) Class.forName(f39377n).getConstructor(Context.class, i.class).newInstance(this.f39381a, this);
        } catch (Throwable th2) {
            androidx.work.l.c().a(f39374k, "Unable to initialize multi-process support", th2);
        }
    }

    @Override // androidx.work.v
    @n0
    public u b(@n0 String uniqueWorkName, @n0 ExistingWorkPolicy existingWorkPolicy, @n0 List<androidx.work.m> work) {
        if (work.isEmpty()) {
            throw new IllegalArgumentException("beginUniqueWork needs at least one OneTimeWorkRequest.");
        }
        return new g(this, uniqueWorkName, existingWorkPolicy, work);
    }

    @Override // androidx.work.v
    @n0
    public u d(@n0 List<androidx.work.m> work) {
        if (work.isEmpty()) {
            throw new IllegalArgumentException("beginWith needs at least one OneTimeWorkRequest.");
        }
        return new g(this, work);
    }

    @Override // androidx.work.v
    @n0
    public o e() {
        v2.a aVarB = v2.a.b(this);
        this.f39384d.c(aVarB);
        return aVarB.f();
    }

    @Override // androidx.work.v
    @n0
    public o f(@n0 final String tag) {
        v2.a aVarE = v2.a.e(tag, this);
        this.f39384d.c(aVarE);
        return aVarE.f();
    }

    @Override // androidx.work.v
    @n0
    public o g(@n0 String uniqueWorkName) {
        v2.a aVarD = v2.a.d(uniqueWorkName, this, true);
        this.f39384d.c(aVarD);
        return aVarD.f();
    }

    @Override // androidx.work.v
    @n0
    public o h(@n0 UUID id2) {
        v2.a aVarC = v2.a.c(id2, this);
        this.f39384d.c(aVarC);
        return aVarC.f();
    }

    @Override // androidx.work.v
    @n0
    public PendingIntent i(@n0 UUID id2) {
        return PendingIntent.getService(this.f39381a, 0, androidx.work.impl.foreground.a.a(this.f39381a, id2.toString()), androidx.core.os.a.i() ? 167772160 : 134217728);
    }

    @Override // androidx.work.v
    @n0
    public o k(@n0 List<? extends x> requests) {
        if (requests.isEmpty()) {
            throw new IllegalArgumentException("enqueue needs at least one WorkRequest.");
        }
        return new g(this, requests).c();
    }

    @Override // androidx.work.v
    @n0
    public o l(@n0 String uniqueWorkName, @n0 ExistingPeriodicWorkPolicy existingPeriodicWorkPolicy, @n0 p periodicWork) {
        return D(uniqueWorkName, existingPeriodicWorkPolicy, periodicWork).c();
    }

    @Override // androidx.work.v
    @n0
    public o n(@n0 String uniqueWorkName, @n0 ExistingWorkPolicy existingWorkPolicy, @n0 List<androidx.work.m> work) {
        return new g(this, uniqueWorkName, existingWorkPolicy, work).c();
    }

    @Override // androidx.work.v
    @n0
    public ListenableFuture<Long> q() {
        androidx.work.impl.utils.futures.a aVarU = androidx.work.impl.utils.futures.a.u();
        this.f39384d.c(new a(aVarU, this.f39387g));
        return aVarU;
    }

    @Override // androidx.work.v
    @n0
    public LiveData<Long> r() {
        return this.f39387g.b();
    }

    @Override // androidx.work.v
    @n0
    public ListenableFuture<WorkInfo> s(@n0 UUID id2) {
        v2.l<WorkInfo> lVarC = v2.l.c(this, id2);
        this.f39384d.d().execute(lVarC);
        return lVarC.f();
    }

    @Override // androidx.work.v
    @n0
    public LiveData<WorkInfo> t(@n0 UUID id2) {
        return v2.d.a(this.f39383c.W().y(Collections.singletonList(id2.toString())), new b(), this.f39384d);
    }

    @Override // androidx.work.v
    @n0
    public ListenableFuture<List<WorkInfo>> u(@n0 w workQuery) {
        v2.l<List<WorkInfo>> lVarE = v2.l.e(this, workQuery);
        this.f39384d.d().execute(lVarE);
        return lVarE.f();
    }

    @Override // androidx.work.v
    @n0
    public ListenableFuture<List<WorkInfo>> v(@n0 String tag) {
        v2.l<List<WorkInfo>> lVarB = v2.l.b(this, tag);
        this.f39384d.d().execute(lVarB);
        return lVarB.f();
    }

    @Override // androidx.work.v
    @n0
    public LiveData<List<WorkInfo>> w(@n0 String tag) {
        return v2.d.a(this.f39383c.W().o(tag), r.f51840u, this.f39384d);
    }

    @Override // androidx.work.v
    @n0
    public ListenableFuture<List<WorkInfo>> x(@n0 String uniqueWorkName) {
        v2.l<List<WorkInfo>> lVarD = v2.l.d(this, uniqueWorkName);
        this.f39384d.d().execute(lVarD);
        return lVarD.f();
    }

    @Override // androidx.work.v
    @n0
    public LiveData<List<WorkInfo>> y(@n0 String uniqueWorkName) {
        return v2.d.a(this.f39383c.W().m(uniqueWorkName), r.f51840u, this.f39384d);
    }

    @Override // androidx.work.v
    @n0
    public LiveData<List<WorkInfo>> z(@n0 w workQuery) {
        return v2.d.a(this.f39383c.S().b(v2.i.b(workQuery)), r.f51840u, this.f39384d);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public i(@n0 Context context, @n0 androidx.work.a configuration, @n0 w2.a workTaskExecutor, boolean useTestDatabase) {
        this(context, configuration, workTaskExecutor, WorkDatabase.M(context.getApplicationContext(), workTaskExecutor.d(), useTestDatabase));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public i(@n0 Context context, @n0 androidx.work.a configuration, @n0 w2.a workTaskExecutor, @n0 WorkDatabase database) {
        Context applicationContext = context.getApplicationContext();
        androidx.work.l.e(new l.a(configuration.j()));
        List<e> listC = C(applicationContext, configuration, workTaskExecutor);
        P(context, configuration, workTaskExecutor, database, listC, new d(context, configuration, workTaskExecutor, database, listC));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public i(@n0 Context context, @n0 androidx.work.a configuration, @n0 w2.a workTaskExecutor, @n0 WorkDatabase workDatabase, @n0 List<e> schedulers, @n0 d processor) {
        P(context, configuration, workTaskExecutor, workDatabase, schedulers, processor);
    }
}
