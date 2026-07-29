package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.RestrictTo;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.d;
import androidx.work.l;
import g.j1;
import g.n0;
import g.p0;
import java.util.HashMap;
import java.util.Map;
import u2.r;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class a implements l2.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f8424d = l.f("CommandHandler");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f8425e = "ACTION_SCHEDULE_WORK";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f8426f = "ACTION_DELAY_MET";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f8427g = "ACTION_STOP_WORK";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f8428h = "ACTION_CONSTRAINTS_CHANGED";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f8429i = "ACTION_RESCHEDULE";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f8430j = "ACTION_EXECUTION_COMPLETED";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f8431k = "KEY_WORKSPEC_ID";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f8432l = "KEY_NEEDS_RESCHEDULE";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final long f8433m = 600000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f8434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, l2.b> f8435b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f8436c = new Object();

    public a(@n0 Context context) {
        this.f8434a = context;
    }

    public static Intent a(@n0 Context context) {
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction(f8428h);
        return intent;
    }

    public static Intent b(@n0 Context context, @n0 String workSpecId) {
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction(f8426f);
        intent.putExtra("KEY_WORKSPEC_ID", workSpecId);
        return intent;
    }

    public static Intent d(@n0 Context context, @n0 String workSpecId, boolean needsReschedule) {
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction(f8430j);
        intent.putExtra("KEY_WORKSPEC_ID", workSpecId);
        intent.putExtra(f8432l, needsReschedule);
        return intent;
    }

    public static Intent e(@n0 Context context) {
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction(f8429i);
        return intent;
    }

    public static Intent f(@n0 Context context, @n0 String workSpecId) {
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction(f8425e);
        intent.putExtra("KEY_WORKSPEC_ID", workSpecId);
        return intent;
    }

    public static Intent g(@n0 Context context, @n0 String workSpecId) {
        Intent intent = new Intent(context, (Class<?>) SystemAlarmService.class);
        intent.setAction(f8427g);
        intent.putExtra("KEY_WORKSPEC_ID", workSpecId);
        return intent;
    }

    public static boolean n(@p0 Bundle bundle, @n0 String... keys) {
        if (bundle == null || bundle.isEmpty()) {
            return false;
        }
        for (String str : keys) {
            if (bundle.get(str) == null) {
                return false;
            }
        }
        return true;
    }

    @Override // l2.b
    public void c(@n0 String workSpecId, boolean needsReschedule) {
        synchronized (this.f8436c) {
            l2.b bVarRemove = this.f8435b.remove(workSpecId);
            if (bVarRemove != null) {
                bVarRemove.c(workSpecId, needsReschedule);
            }
        }
    }

    public final void h(@n0 Intent intent, int startId, @n0 d dispatcher) {
        l.c().a(f8424d, String.format("Handling constraints changed %s", intent), new Throwable[0]);
        new b(this.f8434a, startId, dispatcher).a();
    }

    public final void i(@n0 Intent intent, int startId, @n0 d dispatcher) {
        Bundle extras = intent.getExtras();
        synchronized (this.f8436c) {
            String string = extras.getString("KEY_WORKSPEC_ID");
            l lVarC = l.c();
            String str = f8424d;
            lVarC.a(str, String.format("Handing delay met for %s", string), new Throwable[0]);
            if (this.f8435b.containsKey(string)) {
                l.c().a(str, String.format("WorkSpec %s is already being handled for ACTION_DELAY_MET", string), new Throwable[0]);
            } else {
                c cVar = new c(this.f8434a, startId, string, dispatcher);
                this.f8435b.put(string, cVar);
                cVar.e();
            }
        }
    }

    public final void j(@n0 Intent intent, int startId) {
        Bundle extras = intent.getExtras();
        String string = extras.getString("KEY_WORKSPEC_ID");
        boolean z10 = extras.getBoolean(f8432l);
        l.c().a(f8424d, String.format("Handling onExecutionCompleted %s, %s", intent, Integer.valueOf(startId)), new Throwable[0]);
        c(string, z10);
    }

    public final void k(@n0 Intent intent, int startId, @n0 d dispatcher) {
        l.c().a(f8424d, String.format("Handling reschedule %s, %s", intent, Integer.valueOf(startId)), new Throwable[0]);
        dispatcher.g().R();
    }

    public final void l(@n0 Intent intent, int startId, @n0 d dispatcher) {
        String string = intent.getExtras().getString("KEY_WORKSPEC_ID");
        l lVarC = l.c();
        String str = f8424d;
        lVarC.a(str, String.format("Handling schedule work for %s", string), new Throwable[0]);
        WorkDatabase workDatabaseM = dispatcher.g().M();
        workDatabaseM.e();
        try {
            r rVarU = workDatabaseM.W().u(string);
            if (rVarU == null) {
                l.c().h(str, "Skipping scheduling " + string + " because it's no longer in the DB", new Throwable[0]);
                return;
            }
            if (rVarU.f51842b.isFinished()) {
                l.c().h(str, "Skipping scheduling " + string + "because it is finished.", new Throwable[0]);
                return;
            }
            long jA = rVarU.a();
            if (rVarU.b()) {
                l.c().a(str, String.format("Opportunistically setting an alarm for %s at %s", string, Long.valueOf(jA)), new Throwable[0]);
                o2.a.c(this.f8434a, dispatcher.g(), string, jA);
                dispatcher.k(new d.b(dispatcher, a(this.f8434a), startId));
            } else {
                l.c().a(str, String.format("Setting up Alarms for %s at %s", string, Long.valueOf(jA)), new Throwable[0]);
                o2.a.c(this.f8434a, dispatcher.g(), string, jA);
            }
            workDatabaseM.K();
        } finally {
            workDatabaseM.k();
        }
    }

    public final void m(@n0 Intent intent, @n0 d dispatcher) {
        String string = intent.getExtras().getString("KEY_WORKSPEC_ID");
        l.c().a(f8424d, String.format("Handing stopWork work for %s", string), new Throwable[0]);
        dispatcher.g().X(string);
        o2.a.a(this.f8434a, dispatcher.g(), string);
        dispatcher.c(string, false);
    }

    public boolean o() {
        boolean z10;
        synchronized (this.f8436c) {
            z10 = !this.f8435b.isEmpty();
        }
        return z10;
    }

    @j1
    public void p(@n0 Intent intent, int startId, @n0 d dispatcher) {
        String action = intent.getAction();
        if (f8428h.equals(action)) {
            h(intent, startId, dispatcher);
            return;
        }
        if (f8429i.equals(action)) {
            k(intent, startId, dispatcher);
            return;
        }
        if (!n(intent.getExtras(), "KEY_WORKSPEC_ID")) {
            l.c().b(f8424d, String.format("Invalid request for %s, requires %s.", action, "KEY_WORKSPEC_ID"), new Throwable[0]);
            return;
        }
        if (f8425e.equals(action)) {
            l(intent, startId, dispatcher);
            return;
        }
        if (f8426f.equals(action)) {
            i(intent, startId, dispatcher);
            return;
        }
        if (f8427g.equals(action)) {
            m(intent, dispatcher);
        } else if (f8430j.equals(action)) {
            j(intent, startId);
        } else {
            l.c().h(f8424d, String.format("Ignoring intent %s", intent), new Throwable[0]);
        }
    }
}
