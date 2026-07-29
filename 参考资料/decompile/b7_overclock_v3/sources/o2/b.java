package o2;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.work.l;
import g.n0;
import l2.e;
import u2.r;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class b implements e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f42695b = l.f("SystemAlarmScheduler");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f42696a;

    public b(@n0 Context context) {
        this.f42696a = context.getApplicationContext();
    }

    @Override // l2.e
    public boolean a() {
        return true;
    }

    public final void b(@n0 r workSpec) {
        l.c().a(f42695b, String.format("Scheduling work with workSpecId %s", workSpec.f51841a), new Throwable[0]);
        this.f42696a.startService(androidx.work.impl.background.systemalarm.a.f(this.f42696a, workSpec.f51841a));
    }

    @Override // l2.e
    public void d(@n0 String workSpecId) {
        this.f42696a.startService(androidx.work.impl.background.systemalarm.a.g(this.f42696a, workSpecId));
    }

    @Override // l2.e
    public void e(@n0 r... workSpecs) {
        for (r rVar : workSpecs) {
            b(rVar);
        }
    }
}
