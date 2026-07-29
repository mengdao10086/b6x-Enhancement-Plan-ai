package l2;

import android.content.Context;
import android.os.Build;
import androidx.annotation.RestrictTo;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import androidx.work.impl.background.systemjob.SystemJobService;
import androidx.work.l;
import g.n0;
import g.p0;
import java.util.Iterator;
import java.util.List;
import u2.r;
import u2.s;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f39359a = "androidx.work.impl.background.gcm.GcmScheduler";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f39360b = l.f("Schedulers");

    @n0
    public static e a(@n0 Context context, @n0 i workManager) {
        if (Build.VERSION.SDK_INT >= 23) {
            p2.b bVar = new p2.b(context, workManager);
            v2.e.c(context, SystemJobService.class, true);
            l.c().a(f39360b, "Created SystemJobScheduler and enabled SystemJobService", new Throwable[0]);
            return bVar;
        }
        e eVarC = c(context);
        if (eVarC != null) {
            return eVarC;
        }
        o2.b bVar2 = new o2.b(context);
        v2.e.c(context, SystemAlarmService.class, true);
        l.c().a(f39360b, "Created SystemAlarmScheduler", new Throwable[0]);
        return bVar2;
    }

    public static void b(@n0 androidx.work.a configuration, @n0 WorkDatabase workDatabase, List<e> schedulers) {
        if (schedulers == null || schedulers.size() == 0) {
            return;
        }
        s sVarW = workDatabase.W();
        workDatabase.e();
        try {
            List<r> listG = sVarW.g(configuration.h());
            List<r> listF = sVarW.F(200);
            if (listG != null && listG.size() > 0) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                Iterator<r> it2 = listG.iterator();
                while (it2.hasNext()) {
                    sVarW.d(it2.next().f51841a, jCurrentTimeMillis);
                }
            }
            workDatabase.K();
            if (listG != null && listG.size() > 0) {
                r[] rVarArr = (r[]) listG.toArray(new r[listG.size()]);
                for (e eVar : schedulers) {
                    if (eVar.a()) {
                        eVar.e(rVarArr);
                    }
                }
            }
            if (listF == null || listF.size() <= 0) {
                return;
            }
            r[] rVarArr2 = (r[]) listF.toArray(new r[listF.size()]);
            for (e eVar2 : schedulers) {
                if (!eVar2.a()) {
                    eVar2.e(rVarArr2);
                }
            }
        } finally {
            workDatabase.k();
        }
    }

    @p0
    public static e c(@n0 Context context) {
        try {
            e eVar = (e) Class.forName(f39359a).getConstructor(Context.class).newInstance(context);
            l.c().a(f39360b, String.format("Created %s", f39359a), new Throwable[0]);
            return eVar;
        } catch (Throwable th2) {
            l.c().a(f39360b, "Unable to create GCM Scheduler", th2);
            return null;
        }
    }
}
