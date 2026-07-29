package androidx.work.impl.utils;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.ApplicationExitInfo;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteAccessPermException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteTableLockedException;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.c;
import androidx.core.os.a;
import androidx.work.WorkInfo;
import androidx.work.impl.WorkDatabase;
import androidx.work.l;
import f0.v;
import g.i1;
import g.n0;
import g.p0;
import java.util.List;
import java.util.concurrent.TimeUnit;
import l2.f;
import l2.h;
import l2.i;
import p2.b;
import u2.p;
import u2.r;
import u2.s;
import v2.g;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ForceStopRunnable implements Runnable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @i1
    public static final String f8516e = "ACTION_FORCE_STOP_RESCHEDULE";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @i1
    public static final int f8517f = 3;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f8518g = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final long f8519h = 300;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f8521a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f8522b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8523c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f8515d = l.f("ForceStopRunnable");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final long f8520i = TimeUnit.DAYS.toMillis(3650);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class BroadcastReceiver extends android.content.BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f8524a = l.f("ForceStopRunnable$Rcvr");

        @Override // android.content.BroadcastReceiver
        public void onReceive(@n0 Context context, @p0 Intent intent) {
            if (intent == null || !ForceStopRunnable.f8516e.equals(intent.getAction())) {
                return;
            }
            l.c().g(f8524a, "Rescheduling alarm that keeps track of force-stops.", new Throwable[0]);
            ForceStopRunnable.g(context);
        }
    }

    public ForceStopRunnable(@n0 Context context, @n0 i workManager) {
        this.f8521a = context.getApplicationContext();
        this.f8522b = workManager;
    }

    @i1
    public static Intent c(Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, (Class<?>) BroadcastReceiver.class));
        intent.setAction(f8516e);
        return intent;
    }

    public static PendingIntent d(Context context, int flags) {
        return PendingIntent.getBroadcast(context, -1, c(context), flags);
    }

    @SuppressLint({"ClassVerificationFailure"})
    public static void g(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(v.K0);
        PendingIntent pendingIntentD = d(context, a.i() ? 167772160 : 134217728);
        long jCurrentTimeMillis = System.currentTimeMillis() + f8520i;
        if (alarmManager != null) {
            alarmManager.setExact(0, jCurrentTimeMillis, pendingIntentD);
        }
    }

    @i1
    public boolean a() {
        boolean zI = Build.VERSION.SDK_INT >= 23 ? b.i(this.f8521a, this.f8522b) : false;
        WorkDatabase workDatabaseM = this.f8522b.M();
        s sVarW = workDatabaseM.W();
        p pVarV = workDatabaseM.V();
        workDatabaseM.e();
        try {
            List<r> listN = sVarW.n();
            boolean z10 = (listN == null || listN.isEmpty()) ? false : true;
            if (z10) {
                for (r rVar : listN) {
                    sVarW.b(WorkInfo.State.ENQUEUED, rVar.f51841a);
                    sVarW.d(rVar.f51841a, -1L);
                }
            }
            pVarV.b();
            workDatabaseM.K();
            return z10 || zI;
        } finally {
            workDatabaseM.k();
        }
    }

    @i1
    public void b() {
        boolean zA = a();
        if (h()) {
            l.c().a(f8515d, "Rescheduling Workers.", new Throwable[0]);
            this.f8522b.R();
            this.f8522b.I().f(false);
        } else if (e()) {
            l.c().a(f8515d, "Application was force-stopped, rescheduling.", new Throwable[0]);
            this.f8522b.R();
        } else if (zA) {
            l.c().a(f8515d, "Found unfinished work, scheduling it.", new Throwable[0]);
            f.b(this.f8522b.F(), this.f8522b.M(), this.f8522b.L());
        }
    }

    @i1
    @SuppressLint({"ClassVerificationFailure"})
    public boolean e() {
        try {
            PendingIntent pendingIntentD = d(this.f8521a, a.i() ? 570425344 : 536870912);
            if (Build.VERSION.SDK_INT >= 30) {
                if (pendingIntentD != null) {
                    pendingIntentD.cancel();
                }
                List<ApplicationExitInfo> historicalProcessExitReasons = ((ActivityManager) this.f8521a.getSystemService(c.f2369r)).getHistoricalProcessExitReasons(null, 0, 0);
                if (historicalProcessExitReasons != null && !historicalProcessExitReasons.isEmpty()) {
                    for (int i10 = 0; i10 < historicalProcessExitReasons.size(); i10++) {
                        if (historicalProcessExitReasons.get(i10).getReason() == 10) {
                            return true;
                        }
                    }
                }
            } else if (pendingIntentD == null) {
                g(this.f8521a);
                return true;
            }
            return false;
        } catch (IllegalArgumentException | SecurityException e10) {
            l.c().h(f8515d, "Ignoring exception", e10);
            return true;
        }
    }

    @i1
    public boolean f() {
        androidx.work.a aVarF = this.f8522b.F();
        if (TextUtils.isEmpty(aVarF.c())) {
            l.c().a(f8515d, "The default process name was not specified.", new Throwable[0]);
            return true;
        }
        boolean zB = g.b(this.f8521a, aVarF);
        l.c().a(f8515d, String.format("Is default app process = %s", Boolean.valueOf(zB)), new Throwable[0]);
        return zB;
    }

    @i1
    public boolean h() {
        return this.f8522b.I().c();
    }

    @i1
    public void i(long duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException unused) {
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        int i10;
        try {
            if (f()) {
                while (true) {
                    h.e(this.f8521a);
                    l.c().a(f8515d, "Performing cleanup operations.", new Throwable[0]);
                    try {
                        b();
                        break;
                    } catch (SQLiteAccessPermException | SQLiteCantOpenDatabaseException | SQLiteConstraintException | SQLiteDatabaseCorruptException | SQLiteDatabaseLockedException | SQLiteTableLockedException e10) {
                        i10 = this.f8523c + 1;
                        this.f8523c = i10;
                        if (i10 >= 3) {
                            l lVarC = l.c();
                            String str = f8515d;
                            lVarC.b(str, "The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e10);
                            IllegalStateException illegalStateException = new IllegalStateException("The file system on the device is in a bad state. WorkManager cannot access the app's internal data store.", e10);
                            androidx.work.i iVarD = this.f8522b.F().d();
                            if (iVarD == null) {
                                throw illegalStateException;
                            }
                            l.c().a(str, "Routing exception to the specified exception handler", illegalStateException);
                            iVarD.a(illegalStateException);
                        } else {
                            l.c().a(f8515d, String.format("Retrying after %s", Long.valueOf(((long) i10) * 300)), e10);
                            i(((long) this.f8523c) * 300);
                        }
                    }
                    l.c().a(f8515d, String.format("Retrying after %s", Long.valueOf(((long) i10) * 300)), e10);
                    i(((long) this.f8523c) * 300);
                }
            }
        } finally {
            this.f8522b.Q();
        }
    }
}
