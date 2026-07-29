package dc;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PersistableBundle;
import com.google.android.exoplayer2.scheduler.Requirements;
import g.v0;
import g.y0;
import hd.t;
import hd.u0;

/* JADX INFO: loaded from: classes3.dex */
@v0(21)
public final class a implements e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f26143d = "PlatformScheduler";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f26144e = "service_action";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f26145f = "service_package";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f26146g = "requirements";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f26147h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f26148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ComponentName f26149b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final JobScheduler f26150c;

    /* JADX INFO: renamed from: dc.a$a, reason: collision with other inner class name */
    public static final class JobServiceC0293a extends JobService {
        @Override // android.app.job.JobService
        public boolean onStartJob(JobParameters jobParameters) {
            PersistableBundle extras = jobParameters.getExtras();
            int iG = new Requirements(extras.getInt("requirements")).g(this);
            if (iG == 0) {
                u0.q1(this, new Intent((String) hd.a.g(extras.getString(a.f26144e))).setPackage((String) hd.a.g(extras.getString(a.f26145f))));
                return false;
            }
            t.n(a.f26143d, "Requirements not met: " + iG);
            jobFinished(jobParameters, true);
            return false;
        }

        @Override // android.app.job.JobService
        public boolean onStopJob(JobParameters jobParameters) {
            return false;
        }
    }

    static {
        f26147h = (u0.f31154a >= 26 ? 16 : 0) | 15;
    }

    @y0("android.permission.RECEIVE_BOOT_COMPLETED")
    public a(Context context, int i10) {
        Context applicationContext = context.getApplicationContext();
        this.f26148a = i10;
        this.f26149b = new ComponentName(applicationContext, (Class<?>) JobServiceC0293a.class);
        this.f26150c = (JobScheduler) hd.a.g((JobScheduler) applicationContext.getSystemService("jobscheduler"));
    }

    public static JobInfo c(int i10, ComponentName componentName, Requirements requirements, String str, String str2) {
        Requirements requirementsB = requirements.b(f26147h);
        if (!requirementsB.equals(requirements)) {
            t.n(f26143d, "Ignoring unsupported requirements: " + (requirementsB.j() ^ requirements.j()));
        }
        JobInfo.Builder builder = new JobInfo.Builder(i10, componentName);
        if (requirements.V()) {
            builder.setRequiredNetworkType(2);
        } else if (requirements.S()) {
            builder.setRequiredNetworkType(1);
        }
        builder.setRequiresDeviceIdle(requirements.F());
        builder.setRequiresCharging(requirements.s());
        if (u0.f31154a >= 26 && requirements.U()) {
            builder.setRequiresStorageNotLow(true);
        }
        builder.setPersisted(true);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString(f26144e, str);
        persistableBundle.putString(f26145f, str2);
        persistableBundle.putInt("requirements", requirements.j());
        builder.setExtras(persistableBundle);
        return builder.build();
    }

    @Override // dc.e
    public boolean a(Requirements requirements, String str, String str2) {
        return this.f26150c.schedule(c(this.f26148a, this.f26149b, requirements, str2, str)) == 1;
    }

    @Override // dc.e
    public Requirements b(Requirements requirements) {
        return requirements.b(f26147h);
    }

    @Override // dc.e
    public boolean cancel() {
        this.f26150c.cancel(this.f26148a);
        return true;
    }
}
