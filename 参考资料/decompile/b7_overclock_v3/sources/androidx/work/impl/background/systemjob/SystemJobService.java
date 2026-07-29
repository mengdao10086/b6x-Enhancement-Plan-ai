package androidx.work.impl.background.systemjob;

import android.app.Application;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Build;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.annotation.RestrictTo;
import androidx.work.WorkerParameters;
import androidx.work.l;
import g.n0;
import g.p0;
import g.v0;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import l2.b;
import l2.i;
import p2.a;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@v0(23)
public class SystemJobService extends JobService implements b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f8474c = l.f("SystemJobService");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public i f8475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, JobParameters> f8476b = new HashMap();

    @p0
    public static String a(@n0 JobParameters parameters) {
        try {
            PersistableBundle extras = parameters.getExtras();
            if (extras == null || !extras.containsKey(a.f46308c)) {
                return null;
            }
            return extras.getString(a.f46308c);
        } catch (NullPointerException unused) {
            return null;
        }
    }

    @Override // l2.b
    public void c(@n0 String workSpecId, boolean needsReschedule) {
        JobParameters jobParametersRemove;
        l.c().a(f8474c, String.format("%s executed on JobScheduler", workSpecId), new Throwable[0]);
        synchronized (this.f8476b) {
            jobParametersRemove = this.f8476b.remove(workSpecId);
        }
        if (jobParametersRemove != null) {
            jobFinished(jobParametersRemove, needsReschedule);
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        try {
            i iVarH = i.H(getApplicationContext());
            this.f8475a = iVarH;
            iVarH.J().d(this);
        } catch (IllegalStateException unused) {
            if (!Application.class.equals(getApplication().getClass())) {
                throw new IllegalStateException("WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().");
            }
            l.c().h(f8474c, "Could not find WorkManager instance; this may be because an auto-backup is in progress. Ignoring JobScheduler commands for now. Please make sure that you are initializing WorkManager if you have manually disabled WorkManagerInitializer.", new Throwable[0]);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        i iVar = this.f8475a;
        if (iVar != null) {
            iVar.J().j(this);
        }
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(@n0 JobParameters params) {
        if (this.f8475a == null) {
            l.c().a(f8474c, "WorkManager is not initialized; requesting retry.", new Throwable[0]);
            jobFinished(params, true);
            return false;
        }
        String strA = a(params);
        if (TextUtils.isEmpty(strA)) {
            l.c().b(f8474c, "WorkSpec id not found!", new Throwable[0]);
            return false;
        }
        synchronized (this.f8476b) {
            if (this.f8476b.containsKey(strA)) {
                l.c().a(f8474c, String.format("Job is already being executed by SystemJobService: %s", strA), new Throwable[0]);
                return false;
            }
            l.c().a(f8474c, String.format("onStartJob for %s", strA), new Throwable[0]);
            this.f8476b.put(strA, params);
            WorkerParameters.a aVar = null;
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 24) {
                aVar = new WorkerParameters.a();
                if (params.getTriggeredContentUris() != null) {
                    aVar.f8310b = Arrays.asList(params.getTriggeredContentUris());
                }
                if (params.getTriggeredContentAuthorities() != null) {
                    aVar.f8309a = Arrays.asList(params.getTriggeredContentAuthorities());
                }
                if (i10 >= 28) {
                    aVar.f8311c = params.getNetwork();
                }
            }
            this.f8475a.V(strA, aVar);
            return true;
        }
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(@n0 JobParameters params) {
        if (this.f8475a == null) {
            l.c().a(f8474c, "WorkManager is not initialized; requesting retry.", new Throwable[0]);
            return true;
        }
        String strA = a(params);
        if (TextUtils.isEmpty(strA)) {
            l.c().b(f8474c, "WorkSpec id not found!", new Throwable[0]);
            return false;
        }
        l.c().a(f8474c, String.format("onStopJob for %s", strA), new Throwable[0]);
        synchronized (this.f8476b) {
            this.f8476b.remove(strA);
        }
        this.f8475a.X(strA);
        return !this.f8475a.J().g(strA);
    }
}
