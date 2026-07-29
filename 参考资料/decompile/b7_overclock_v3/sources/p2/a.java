package p2;

import android.app.job.JobInfo;
import android.content.ComponentName;
import android.content.Context;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.annotation.RestrictTo;
import androidx.work.BackoffPolicy;
import androidx.work.NetworkType;
import androidx.work.c;
import androidx.work.impl.background.systemjob.SystemJobService;
import androidx.work.l;
import g.i1;
import g.n0;
import g.v0;
import java.util.Iterator;
import u2.r;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@v0(api = 23)
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f46307b = l.f("SystemJobInfoConverter");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f46308c = "EXTRA_WORK_SPEC_ID";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f46309d = "EXTRA_IS_PERIODIC";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ComponentName f46310a;

    /* JADX INFO: renamed from: p2.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0520a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f46311a;

        static {
            int[] iArr = new int[NetworkType.values().length];
            f46311a = iArr;
            try {
                iArr[NetworkType.NOT_REQUIRED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f46311a[NetworkType.CONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f46311a[NetworkType.UNMETERED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f46311a[NetworkType.NOT_ROAMING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f46311a[NetworkType.METERED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    @i1(otherwise = 3)
    public a(@n0 Context context) {
        this.f46310a = new ComponentName(context.getApplicationContext(), (Class<?>) SystemJobService.class);
    }

    @v0(24)
    public static JobInfo.TriggerContentUri b(c.a aVar) {
        return new JobInfo.TriggerContentUri(aVar.a(), aVar.b() ? 1 : 0);
    }

    public static int c(NetworkType networkType) {
        int i10 = C0520a.f46311a[networkType.ordinal()];
        if (i10 == 1) {
            return 0;
        }
        if (i10 == 2) {
            return 1;
        }
        if (i10 == 3) {
            return 2;
        }
        if (i10 != 4) {
            if (i10 == 5 && Build.VERSION.SDK_INT >= 26) {
                return 4;
            }
        } else if (Build.VERSION.SDK_INT >= 24) {
            return 3;
        }
        l.c().a(f46307b, String.format("API version too low. Cannot convert network type value %s", networkType), new Throwable[0]);
        return 1;
    }

    public static void d(@n0 JobInfo.Builder builder, @n0 NetworkType networkType) {
        if (Build.VERSION.SDK_INT < 30 || networkType != NetworkType.TEMPORARILY_UNMETERED) {
            builder.setRequiredNetworkType(c(networkType));
        } else {
            builder.setRequiredNetwork(new NetworkRequest.Builder().addCapability(25).build());
        }
    }

    public JobInfo a(r workSpec, int jobId) {
        androidx.work.b bVar = workSpec.f51850j;
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString(f46308c, workSpec.f51841a);
        persistableBundle.putBoolean(f46309d, workSpec.d());
        JobInfo.Builder extras = new JobInfo.Builder(jobId, this.f46310a).setRequiresCharging(bVar.g()).setRequiresDeviceIdle(bVar.h()).setExtras(persistableBundle);
        d(extras, bVar.b());
        if (!bVar.h()) {
            extras.setBackoffCriteria(workSpec.f51853m, workSpec.f51852l == BackoffPolicy.LINEAR ? 0 : 1);
        }
        long jMax = Math.max(workSpec.a() - System.currentTimeMillis(), 0L);
        int i10 = Build.VERSION.SDK_INT;
        if (i10 <= 28 || jMax > 0) {
            extras.setMinimumLatency(jMax);
        } else if (!workSpec.f51857q) {
            extras.setImportantWhileForeground(true);
        }
        if (i10 >= 24 && bVar.e()) {
            Iterator<c.a> it2 = bVar.a().b().iterator();
            while (it2.hasNext()) {
                extras.addTriggerContentUri(b(it2.next()));
            }
            extras.setTriggerContentUpdateDelay(bVar.c());
            extras.setTriggerContentMaxDelay(bVar.d());
        }
        extras.setPersisted(false);
        if (Build.VERSION.SDK_INT >= 26) {
            extras.setRequiresBatteryNotLow(bVar.f());
            extras.setRequiresStorageNotLow(bVar.i());
        }
        boolean z10 = workSpec.f51851k > 0;
        boolean z11 = jMax > 0;
        if (androidx.core.os.a.i() && workSpec.f51857q && !z10 && !z11) {
            extras.setExpedited(true);
        }
        return extras.build();
    }
}
