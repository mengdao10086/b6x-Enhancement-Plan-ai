package p2;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.annotation.RestrictTo;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemjob.SystemJobService;
import androidx.work.l;
import g.i1;
import g.n0;
import g.p0;
import g.v0;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import l2.e;
import l2.i;
import u2.r;
import u2.s;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@v0(23)
public class b implements e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f46312e = l.f("SystemJobScheduler");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f46313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JobScheduler f46314b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i f46315c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f46316d;

    public b(@n0 Context context, @n0 i workManager) {
        this(context, workManager, (JobScheduler) context.getSystemService("jobscheduler"), new a(context));
    }

    public static void b(@n0 Context context) {
        List<JobInfo> listG;
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler == null || (listG = g(context, jobScheduler)) == null || listG.isEmpty()) {
            return;
        }
        Iterator<JobInfo> it2 = listG.iterator();
        while (it2.hasNext()) {
            c(jobScheduler, it2.next().getId());
        }
    }

    public static void c(@n0 JobScheduler jobScheduler, int id2) {
        try {
            jobScheduler.cancel(id2);
        } catch (Throwable th2) {
            l.c().b(f46312e, String.format(Locale.getDefault(), "Exception while trying to cancel job (%d)", Integer.valueOf(id2)), th2);
        }
    }

    @p0
    public static List<Integer> f(@n0 Context context, @n0 JobScheduler jobScheduler, @n0 String workSpecId) {
        List<JobInfo> listG = g(context, jobScheduler);
        if (listG == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(2);
        for (JobInfo jobInfo : listG) {
            if (workSpecId.equals(h(jobInfo))) {
                arrayList.add(Integer.valueOf(jobInfo.getId()));
            }
        }
        return arrayList;
    }

    @p0
    public static List<JobInfo> g(@n0 Context context, @n0 JobScheduler jobScheduler) {
        List<JobInfo> allPendingJobs;
        try {
            allPendingJobs = jobScheduler.getAllPendingJobs();
        } catch (Throwable th2) {
            l.c().b(f46312e, "getAllPendingJobs() is not reliable on this device.", th2);
            allPendingJobs = null;
        }
        if (allPendingJobs == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(allPendingJobs.size());
        ComponentName componentName = new ComponentName(context, (Class<?>) SystemJobService.class);
        for (JobInfo jobInfo : allPendingJobs) {
            if (componentName.equals(jobInfo.getService())) {
                arrayList.add(jobInfo);
            }
        }
        return arrayList;
    }

    @p0
    public static String h(@n0 JobInfo jobInfo) {
        PersistableBundle extras = jobInfo.getExtras();
        if (extras == null) {
            return null;
        }
        try {
            if (extras.containsKey(a.f46308c)) {
                return extras.getString(a.f46308c);
            }
            return null;
        } catch (NullPointerException unused) {
            return null;
        }
    }

    public static boolean i(@n0 Context context, @n0 i workManager) {
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        List<JobInfo> listG = g(context, jobScheduler);
        List<String> listA = workManager.M().T().a();
        boolean z10 = false;
        HashSet hashSet = new HashSet(listG != null ? listG.size() : 0);
        if (listG != null && !listG.isEmpty()) {
            for (JobInfo jobInfo : listG) {
                String strH = h(jobInfo);
                if (TextUtils.isEmpty(strH)) {
                    c(jobScheduler, jobInfo.getId());
                } else {
                    hashSet.add(strH);
                }
            }
        }
        Iterator<String> it2 = listA.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            if (!hashSet.contains(it2.next())) {
                l.c().a(f46312e, "Reconciling jobs", new Throwable[0]);
                z10 = true;
                break;
            }
        }
        if (z10) {
            WorkDatabase workDatabaseM = workManager.M();
            workDatabaseM.e();
            try {
                s sVarW = workDatabaseM.W();
                Iterator<String> it3 = listA.iterator();
                while (it3.hasNext()) {
                    sVarW.d(it3.next(), -1L);
                }
                workDatabaseM.K();
            } finally {
                workDatabaseM.k();
            }
        }
        return z10;
    }

    @Override // l2.e
    public boolean a() {
        return true;
    }

    @Override // l2.e
    public void d(@n0 String workSpecId) {
        List<Integer> listF = f(this.f46313a, this.f46314b, workSpecId);
        if (listF == null || listF.isEmpty()) {
            return;
        }
        Iterator<Integer> it2 = listF.iterator();
        while (it2.hasNext()) {
            c(this.f46314b, it2.next().intValue());
        }
        this.f46315c.M().T().d(workSpecId);
    }

    @Override // l2.e
    public void e(@n0 r... workSpecs) {
        List<Integer> listF;
        WorkDatabase workDatabaseM = this.f46315c.M();
        v2.c cVar = new v2.c(workDatabaseM);
        for (r rVar : workSpecs) {
            workDatabaseM.e();
            try {
                r rVarU = workDatabaseM.W().u(rVar.f51841a);
                if (rVarU == null) {
                    l.c().h(f46312e, "Skipping scheduling " + rVar.f51841a + " because it's no longer in the DB", new Throwable[0]);
                    workDatabaseM.K();
                } else if (rVarU.f51842b != WorkInfo.State.ENQUEUED) {
                    l.c().h(f46312e, "Skipping scheduling " + rVar.f51841a + " because it is no longer enqueued", new Throwable[0]);
                    workDatabaseM.K();
                } else {
                    u2.i iVarC = workDatabaseM.T().c(rVar.f51841a);
                    int iD = iVarC != null ? iVarC.f51818b : cVar.d(this.f46315c.F().i(), this.f46315c.F().g());
                    if (iVarC == null) {
                        this.f46315c.M().T().b(new u2.i(rVar.f51841a, iD));
                    }
                    j(rVar, iD);
                    if (Build.VERSION.SDK_INT == 23 && (listF = f(this.f46313a, this.f46314b, rVar.f51841a)) != null) {
                        int iIndexOf = listF.indexOf(Integer.valueOf(iD));
                        if (iIndexOf >= 0) {
                            listF.remove(iIndexOf);
                        }
                        j(rVar, !listF.isEmpty() ? listF.get(0).intValue() : cVar.d(this.f46315c.F().i(), this.f46315c.F().g()));
                    }
                    workDatabaseM.K();
                }
                workDatabaseM.k();
            } catch (Throwable th2) {
                workDatabaseM.k();
                throw th2;
            }
        }
    }

    @i1
    public void j(r workSpec, int jobId) {
        JobInfo jobInfoA = this.f46316d.a(workSpec, jobId);
        l lVarC = l.c();
        String str = f46312e;
        lVarC.a(str, String.format("Scheduling work ID %s Job ID %s", workSpec.f51841a, Integer.valueOf(jobId)), new Throwable[0]);
        try {
            if (this.f46314b.schedule(jobInfoA) == 0) {
                l.c().h(str, String.format("Unable to schedule work ID %s", workSpec.f51841a), new Throwable[0]);
                if (workSpec.f51857q && workSpec.f51858r == OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST) {
                    workSpec.f51857q = false;
                    l.c().a(str, String.format("Scheduling a non-expedited job (work ID %s)", workSpec.f51841a), new Throwable[0]);
                    j(workSpec, jobId);
                }
            }
        } catch (IllegalStateException e10) {
            List<JobInfo> listG = g(this.f46313a, this.f46314b);
            String str2 = String.format(Locale.getDefault(), "JobScheduler 100 job limit exceeded.  We count %d WorkManager jobs in JobScheduler; we have %d tracked jobs in our DB; our Configuration limit is %d.", Integer.valueOf(listG != null ? listG.size() : 0), Integer.valueOf(this.f46315c.M().W().i().size()), Integer.valueOf(this.f46315c.F().h()));
            l.c().b(f46312e, str2, new Throwable[0]);
            throw new IllegalStateException(str2, e10);
        } catch (Throwable th2) {
            l.c().b(f46312e, String.format("Unable to schedule %s", workSpec), th2);
        }
    }

    @i1
    public b(Context context, i workManager, JobScheduler jobScheduler, a systemJobInfoConverter) {
        this.f46313a = context;
        this.f46315c = workManager;
        this.f46314b = jobScheduler;
        this.f46316d = systemJobInfoConverter;
    }
}
