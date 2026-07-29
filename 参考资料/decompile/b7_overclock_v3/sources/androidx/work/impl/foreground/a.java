package androidx.work.impl.foreground;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.RestrictTo;
import androidx.work.g;
import androidx.work.impl.WorkDatabase;
import androidx.work.l;
import g.i1;
import g.k0;
import g.n0;
import g.p0;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import l2.i;
import q2.c;
import q2.d;
import u2.r;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class a implements c, l2.b {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f8493k = l.f("SystemFgDispatcher");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f8494l = "KEY_NOTIFICATION";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f8495m = "KEY_NOTIFICATION_ID";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f8496n = "KEY_FOREGROUND_SERVICE_TYPE";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f8497o = "KEY_WORKSPEC_ID";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f8498p = "ACTION_START_FOREGROUND";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f8499q = "ACTION_NOTIFY";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f8500r = "ACTION_CANCEL_WORK";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f8501s = "ACTION_STOP_FOREGROUND";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f8502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i f8503b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final w2.a f8504c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f8505d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f8506e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, g> f8507f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, r> f8508g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Set<r> f8509h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final d f8510i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @p0
    public b f8511j;

    /* JADX INFO: renamed from: androidx.work.impl.foreground.a$a, reason: collision with other inner class name */
    public class RunnableC0083a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WorkDatabase f8512a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f8513b;

        public RunnableC0083a(final WorkDatabase val$database, final String val$workSpecId) {
            this.f8512a = val$database;
            this.f8513b = val$workSpecId;
        }

        @Override // java.lang.Runnable
        public void run() {
            r rVarU = this.f8512a.W().u(this.f8513b);
            if (rVarU == null || !rVarU.b()) {
                return;
            }
            synchronized (a.this.f8505d) {
                a.this.f8508g.put(this.f8513b, rVarU);
                a.this.f8509h.add(rVarU);
                a aVar = a.this;
                aVar.f8510i.d(aVar.f8509h);
            }
        }
    }

    public interface b {
        void C(int notificationId);

        void p(int notificationId, int notificationType, @n0 Notification notification);

        void s(int notificationId, @n0 Notification notification);

        void stop();
    }

    public a(@n0 Context context) {
        this.f8502a = context;
        this.f8505d = new Object();
        i iVarH = i.H(context);
        this.f8503b = iVarH;
        w2.a aVarO = iVarH.O();
        this.f8504c = aVarO;
        this.f8506e = null;
        this.f8507f = new LinkedHashMap();
        this.f8509h = new HashSet();
        this.f8508g = new HashMap();
        this.f8510i = new d(this.f8502a, aVarO, this);
        this.f8503b.J().d(this);
    }

    @n0
    public static Intent a(@n0 Context context, @n0 String workSpecId) {
        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
        intent.setAction(f8500r);
        intent.setData(Uri.parse(String.format("workspec://%s", workSpecId)));
        intent.putExtra("KEY_WORKSPEC_ID", workSpecId);
        return intent;
    }

    @n0
    public static Intent d(@n0 Context context, @n0 String workSpecId, @n0 g info) {
        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
        intent.setAction(f8499q);
        intent.putExtra(f8495m, info.c());
        intent.putExtra(f8496n, info.a());
        intent.putExtra(f8494l, info.b());
        intent.putExtra("KEY_WORKSPEC_ID", workSpecId);
        return intent;
    }

    @n0
    public static Intent e(@n0 Context context, @n0 String workSpecId, @n0 g info) {
        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
        intent.setAction(f8498p);
        intent.putExtra("KEY_WORKSPEC_ID", workSpecId);
        intent.putExtra(f8495m, info.c());
        intent.putExtra(f8496n, info.a());
        intent.putExtra(f8494l, info.b());
        intent.putExtra("KEY_WORKSPEC_ID", workSpecId);
        return intent;
    }

    @n0
    public static Intent g(@n0 Context context) {
        Intent intent = new Intent(context, (Class<?>) SystemForegroundService.class);
        intent.setAction(f8501s);
        return intent;
    }

    @Override // q2.c
    public void b(@n0 List<String> workSpecIds) {
        if (workSpecIds.isEmpty()) {
            return;
        }
        for (String str : workSpecIds) {
            l.c().a(f8493k, String.format("Constraints unmet for WorkSpec %s", str), new Throwable[0]);
            this.f8503b.W(str);
        }
    }

    @Override // l2.b
    @k0
    public void c(@n0 String workSpecId, boolean needsReschedule) {
        Map.Entry<String, g> entry;
        synchronized (this.f8505d) {
            r rVarRemove = this.f8508g.remove(workSpecId);
            if (rVarRemove != null ? this.f8509h.remove(rVarRemove) : false) {
                this.f8510i.d(this.f8509h);
            }
        }
        g gVarRemove = this.f8507f.remove(workSpecId);
        if (workSpecId.equals(this.f8506e) && this.f8507f.size() > 0) {
            Iterator<Map.Entry<String, g>> it2 = this.f8507f.entrySet().iterator();
            Map.Entry<String, g> next = it2.next();
            while (true) {
                entry = next;
                if (!it2.hasNext()) {
                    break;
                } else {
                    next = it2.next();
                }
            }
            this.f8506e = entry.getKey();
            if (this.f8511j != null) {
                g value = entry.getValue();
                this.f8511j.p(value.c(), value.a(), value.b());
                this.f8511j.C(value.c());
            }
        }
        b bVar = this.f8511j;
        if (gVarRemove == null || bVar == null) {
            return;
        }
        l.c().a(f8493k, String.format("Removing Notification (id: %s, workSpecId: %s ,notificationType: %s)", Integer.valueOf(gVarRemove.c()), workSpecId, Integer.valueOf(gVarRemove.a())), new Throwable[0]);
        bVar.C(gVarRemove.c());
    }

    @Override // q2.c
    public void f(@n0 List<String> workSpecIds) {
    }

    public i h() {
        return this.f8503b;
    }

    @k0
    public final void i(@n0 Intent intent) {
        l.c().d(f8493k, String.format("Stopping foreground work for %s", intent), new Throwable[0]);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        if (stringExtra == null || TextUtils.isEmpty(stringExtra)) {
            return;
        }
        this.f8503b.h(UUID.fromString(stringExtra));
    }

    @k0
    public final void j(@n0 Intent intent) {
        int iA = 0;
        int intExtra = intent.getIntExtra(f8495m, 0);
        int intExtra2 = intent.getIntExtra(f8496n, 0);
        String stringExtra = intent.getStringExtra("KEY_WORKSPEC_ID");
        Notification notification = (Notification) intent.getParcelableExtra(f8494l);
        l.c().a(f8493k, String.format("Notifying with (id: %s, workSpecId: %s, notificationType: %s)", Integer.valueOf(intExtra), stringExtra, Integer.valueOf(intExtra2)), new Throwable[0]);
        if (notification == null || this.f8511j == null) {
            return;
        }
        this.f8507f.put(stringExtra, new g(intExtra, notification, intExtra2));
        if (TextUtils.isEmpty(this.f8506e)) {
            this.f8506e = stringExtra;
            this.f8511j.p(intExtra, intExtra2, notification);
            return;
        }
        this.f8511j.s(intExtra, notification);
        if (intExtra2 == 0 || Build.VERSION.SDK_INT < 29) {
            return;
        }
        Iterator<Map.Entry<String, g>> it2 = this.f8507f.entrySet().iterator();
        while (it2.hasNext()) {
            iA |= it2.next().getValue().a();
        }
        g gVar = this.f8507f.get(this.f8506e);
        if (gVar != null) {
            this.f8511j.p(gVar.c(), iA, gVar.b());
        }
    }

    @k0
    public final void k(@n0 Intent intent) {
        l.c().d(f8493k, String.format("Started foreground service %s", intent), new Throwable[0]);
        this.f8504c.c(new RunnableC0083a(this.f8503b.M(), intent.getStringExtra("KEY_WORKSPEC_ID")));
    }

    @k0
    public void l(@n0 Intent intent) {
        l.c().d(f8493k, "Stopping foreground service", new Throwable[0]);
        b bVar = this.f8511j;
        if (bVar != null) {
            bVar.stop();
        }
    }

    @k0
    public void m() {
        this.f8511j = null;
        synchronized (this.f8505d) {
            this.f8510i.e();
        }
        this.f8503b.J().j(this);
    }

    public void n(@n0 Intent intent) {
        String action = intent.getAction();
        if (f8498p.equals(action)) {
            k(intent);
            j(intent);
        } else if (f8499q.equals(action)) {
            j(intent);
        } else if (f8500r.equals(action)) {
            i(intent);
        } else if (f8501s.equals(action)) {
            l(intent);
        }
    }

    @k0
    public void o(@n0 b callback) {
        if (this.f8511j != null) {
            l.c().b(f8493k, "A callback already exists.", new Throwable[0]);
        } else {
            this.f8511j = callback;
        }
    }

    @i1
    public a(@n0 Context context, @n0 i workManagerImpl, @n0 d tracker) {
        this.f8502a = context;
        this.f8505d = new Object();
        this.f8503b = workManagerImpl;
        this.f8504c = workManagerImpl.O();
        this.f8506e = null;
        this.f8507f = new LinkedHashMap();
        this.f8509h = new HashSet();
        this.f8508g = new HashMap();
        this.f8510i = tracker;
        this.f8503b.J().d(this);
    }
}
