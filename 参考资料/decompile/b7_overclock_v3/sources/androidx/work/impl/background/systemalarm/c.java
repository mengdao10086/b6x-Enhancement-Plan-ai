package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import androidx.annotation.RestrictTo;
import androidx.work.impl.background.systemalarm.d;
import androidx.work.l;
import g.j1;
import g.n0;
import g.p0;
import java.util.Collections;
import java.util.List;
import u2.r;
import v2.o;
import v2.s;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class c implements q2.c, l2.b, s.b {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f8442j = l.f("DelayMetCommandHandler");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f8443k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f8444l = 1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f8445m = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f8446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8447b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f8448c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f8449d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final q2.d f8450e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @p0
    public PowerManager.WakeLock f8453h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f8454i = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f8452g = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f8451f = new Object();

    public c(@n0 Context context, int startId, @n0 String workSpecId, @n0 d dispatcher) {
        this.f8446a = context;
        this.f8447b = startId;
        this.f8449d = dispatcher;
        this.f8448c = workSpecId;
        this.f8450e = new q2.d(context, dispatcher.f(), this);
    }

    @Override // v2.s.b
    public void a(@n0 String workSpecId) {
        l.c().a(f8442j, String.format("Exceeded time limits on execution for %s", workSpecId), new Throwable[0]);
        g();
    }

    @Override // q2.c
    public void b(@n0 List<String> workSpecIds) {
        g();
    }

    @Override // l2.b
    public void c(@n0 String workSpecId, boolean needsReschedule) {
        l.c().a(f8442j, String.format("onExecuted %s, %s", workSpecId, Boolean.valueOf(needsReschedule)), new Throwable[0]);
        d();
        if (needsReschedule) {
            Intent intentF = a.f(this.f8446a, this.f8448c);
            d dVar = this.f8449d;
            dVar.k(new d.b(dVar, intentF, this.f8447b));
        }
        if (this.f8454i) {
            Intent intentA = a.a(this.f8446a);
            d dVar2 = this.f8449d;
            dVar2.k(new d.b(dVar2, intentA, this.f8447b));
        }
    }

    public final void d() {
        synchronized (this.f8451f) {
            this.f8450e.e();
            this.f8449d.h().f(this.f8448c);
            PowerManager.WakeLock wakeLock = this.f8453h;
            if (wakeLock != null && wakeLock.isHeld()) {
                l.c().a(f8442j, String.format("Releasing wakelock %s for WorkSpec %s", this.f8453h, this.f8448c), new Throwable[0]);
                this.f8453h.release();
            }
        }
    }

    @j1
    public void e() {
        this.f8453h = o.b(this.f8446a, String.format("%s (%s)", this.f8448c, Integer.valueOf(this.f8447b)));
        l lVarC = l.c();
        String str = f8442j;
        lVarC.a(str, String.format("Acquiring wakelock %s for WorkSpec %s", this.f8453h, this.f8448c), new Throwable[0]);
        this.f8453h.acquire();
        r rVarU = this.f8449d.g().M().W().u(this.f8448c);
        if (rVarU == null) {
            g();
            return;
        }
        boolean zB = rVarU.b();
        this.f8454i = zB;
        if (zB) {
            this.f8450e.d(Collections.singletonList(rVarU));
        } else {
            l.c().a(str, String.format("No constraints for %s", this.f8448c), new Throwable[0]);
            f(Collections.singletonList(this.f8448c));
        }
    }

    @Override // q2.c
    public void f(@n0 List<String> workSpecIds) {
        if (workSpecIds.contains(this.f8448c)) {
            synchronized (this.f8451f) {
                if (this.f8452g == 0) {
                    this.f8452g = 1;
                    l.c().a(f8442j, String.format("onAllConstraintsMet for %s", this.f8448c), new Throwable[0]);
                    if (this.f8449d.e().k(this.f8448c)) {
                        this.f8449d.h().e(this.f8448c, a.f8433m, this);
                    } else {
                        d();
                    }
                } else {
                    l.c().a(f8442j, String.format("Already started work for %s", this.f8448c), new Throwable[0]);
                }
            }
        }
    }

    public final void g() {
        synchronized (this.f8451f) {
            if (this.f8452g < 2) {
                this.f8452g = 2;
                l lVarC = l.c();
                String str = f8442j;
                lVarC.a(str, String.format("Stopping work for WorkSpec %s", this.f8448c), new Throwable[0]);
                Intent intentG = a.g(this.f8446a, this.f8448c);
                d dVar = this.f8449d;
                dVar.k(new d.b(dVar, intentG, this.f8447b));
                if (this.f8449d.e().h(this.f8448c)) {
                    l.c().a(str, String.format("WorkSpec %s needs to be rescheduled", this.f8448c), new Throwable[0]);
                    Intent intentF = a.f(this.f8446a, this.f8448c);
                    d dVar2 = this.f8449d;
                    dVar2.k(new d.b(dVar2, intentF, this.f8447b));
                } else {
                    l.c().a(str, String.format("Processor does not have WorkSpec %s. No need to reschedule ", this.f8448c), new Throwable[0]);
                }
            } else {
                l.c().a(f8442j, String.format("Already stopped work for %s", this.f8448c), new Throwable[0]);
            }
        }
    }
}
