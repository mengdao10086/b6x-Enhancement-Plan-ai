package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.RestrictTo;
import androidx.work.impl.background.systemalarm.d;
import androidx.work.l;
import g.j1;
import g.n0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import u2.r;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f8437e = l.f("ConstraintsCmdHandler");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f8438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f8440c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q2.d f8441d;

    public b(@n0 Context context, int startId, @n0 d dispatcher) {
        this.f8438a = context;
        this.f8439b = startId;
        this.f8440c = dispatcher;
        this.f8441d = new q2.d(context, dispatcher.f(), null);
    }

    @j1
    public void a() {
        List<r> listI = this.f8440c.g().M().W().i();
        ConstraintProxy.a(this.f8438a, listI);
        this.f8441d.d(listI);
        ArrayList arrayList = new ArrayList(listI.size());
        long jCurrentTimeMillis = System.currentTimeMillis();
        for (r rVar : listI) {
            String str = rVar.f51841a;
            if (jCurrentTimeMillis >= rVar.a() && (!rVar.b() || this.f8441d.c(str))) {
                arrayList.add(rVar);
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            String str2 = ((r) it2.next()).f51841a;
            Intent intentB = a.b(this.f8438a, str2);
            l.c().a(f8437e, String.format("Creating a delay_met command for workSpec with id (%s)", str2), new Throwable[0]);
            d dVar = this.f8440c;
            dVar.k(new d.b(dVar, intentB, this.f8439b));
        }
        this.f8441d.e();
    }
}
