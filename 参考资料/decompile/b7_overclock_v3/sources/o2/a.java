package o2;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import androidx.annotation.RestrictTo;
import androidx.work.impl.WorkDatabase;
import androidx.work.l;
import f0.v;
import g.n0;
import l2.i;
import u2.j;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f42694a = l.f("Alarms");

    public static void a(@n0 Context context, @n0 i workManager, @n0 String workSpecId) {
        j jVarT = workManager.M().T();
        u2.i iVarC = jVarT.c(workSpecId);
        if (iVarC != null) {
            b(context, workSpecId, iVarC.f51818b);
            l.c().a(f42694a, String.format("Removing SystemIdInfo for workSpecId (%s)", workSpecId), new Throwable[0]);
            jVarT.d(workSpecId);
        }
    }

    public static void b(@n0 Context context, @n0 String workSpecId, int alarmId) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(v.K0);
        PendingIntent service = PendingIntent.getService(context, alarmId, androidx.work.impl.background.systemalarm.a.b(context, workSpecId), Build.VERSION.SDK_INT >= 23 ? 603979776 : 536870912);
        if (service == null || alarmManager == null) {
            return;
        }
        l.c().a(f42694a, String.format("Cancelling existing alarm with (workSpecId, systemId) (%s, %s)", workSpecId, Integer.valueOf(alarmId)), new Throwable[0]);
        alarmManager.cancel(service);
    }

    public static void c(@n0 Context context, @n0 i workManager, @n0 String workSpecId, long triggerAtMillis) {
        WorkDatabase workDatabaseM = workManager.M();
        j jVarT = workDatabaseM.T();
        u2.i iVarC = jVarT.c(workSpecId);
        if (iVarC != null) {
            b(context, workSpecId, iVarC.f51818b);
            d(context, workSpecId, iVarC.f51818b, triggerAtMillis);
        } else {
            int iB = new v2.c(workDatabaseM).b();
            jVarT.b(new u2.i(workSpecId, iB));
            d(context, workSpecId, iB, triggerAtMillis);
        }
    }

    public static void d(@n0 Context context, @n0 String workSpecId, int alarmId, long triggerAtMillis) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(v.K0);
        PendingIntent service = PendingIntent.getService(context, alarmId, androidx.work.impl.background.systemalarm.a.b(context, workSpecId), Build.VERSION.SDK_INT >= 23 ? 201326592 : 134217728);
        if (alarmManager != null) {
            alarmManager.setExact(0, triggerAtMillis, service);
        }
    }
}
