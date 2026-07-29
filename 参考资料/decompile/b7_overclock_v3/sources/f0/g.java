package f0;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.os.Build;
import g.n0;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    @v0(19)
    public static class a {
        @g.u
        public static void a(AlarmManager alarmManager, int i10, long j10, PendingIntent pendingIntent) {
            alarmManager.setExact(i10, j10, pendingIntent);
        }
    }

    @v0(21)
    public static class b {
        @g.u
        public static AlarmManager.AlarmClockInfo a(long j10, PendingIntent pendingIntent) {
            return new AlarmManager.AlarmClockInfo(j10, pendingIntent);
        }

        @g.u
        public static void b(AlarmManager alarmManager, Object obj, PendingIntent pendingIntent) {
            alarmManager.setAlarmClock((AlarmManager.AlarmClockInfo) obj, pendingIntent);
        }
    }

    @v0(23)
    public static class c {
        @g.u
        public static void a(AlarmManager alarmManager, int i10, long j10, PendingIntent pendingIntent) {
            alarmManager.setAndAllowWhileIdle(i10, j10, pendingIntent);
        }

        @g.u
        public static void b(AlarmManager alarmManager, int i10, long j10, PendingIntent pendingIntent) {
            alarmManager.setExactAndAllowWhileIdle(i10, j10, pendingIntent);
        }
    }

    @SuppressLint({"MissingPermission"})
    public static void a(@n0 AlarmManager alarmManager, long j10, @n0 PendingIntent pendingIntent, @n0 PendingIntent pendingIntent2) {
        b.b(alarmManager, b.a(j10, pendingIntent), pendingIntent2);
    }

    public static void b(@n0 AlarmManager alarmManager, int i10, long j10, @n0 PendingIntent pendingIntent) {
        if (Build.VERSION.SDK_INT >= 23) {
            c.a(alarmManager, i10, j10, pendingIntent);
        } else {
            alarmManager.set(i10, j10, pendingIntent);
        }
    }

    public static void c(@n0 AlarmManager alarmManager, int i10, long j10, @n0 PendingIntent pendingIntent) {
        a.a(alarmManager, i10, j10, pendingIntent);
    }

    public static void d(@n0 AlarmManager alarmManager, int i10, long j10, @n0 PendingIntent pendingIntent) {
        if (Build.VERSION.SDK_INT >= 23) {
            c.b(alarmManager, i10, j10, pendingIntent);
        } else {
            c(alarmManager, i10, j10, pendingIntent);
        }
    }
}
