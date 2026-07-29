package androidx.work.impl;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.room.RoomDatabase;
import androidx.room.i3;
import androidx.room.m0;
import androidx.room.r2;
import androidx.work.d;
import androidx.work.impl.a;
import c2.e;
import d2.c;
import g.n0;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import l2.h;
import u2.g;
import u2.i;
import u2.j;
import u2.l;
import u2.m;
import u2.o;
import u2.p;
import u2.r;
import u2.s;
import u2.u;
import u2.v;
import u2.x;

/* JADX INFO: loaded from: classes2.dex */
@i3({d.class, x.class})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@m0(entities = {u2.a.class, r.class, u.class, i.class, l.class, o.class, u2.d.class}, version = 12)
public abstract class WorkDatabase extends RoomDatabase {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f8369q = "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (period_start_time + minimum_retention_duration) < ";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f8370r = " AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final long f8371s = TimeUnit.DAYS.toMillis(1);

    public class a implements e.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f8372a;

        public a(final Context val$context) {
            this.f8372a = val$context;
        }

        @Override // c2.e.c
        @n0
        public e a(@n0 e.b configuration) {
            e.b.a aVarA = e.b.a(this.f8372a);
            aVarA.c(configuration.f9701b).b(configuration.f9702c).d(true);
            return new c().a(aVarA.a());
        }
    }

    public class b extends RoomDatabase.b {
        @Override // androidx.room.RoomDatabase.b
        public void c(@n0 c2.d db2) {
            super.c(db2);
            db2.o();
            try {
                db2.C(WorkDatabase.Q());
                db2.v0();
            } finally {
                db2.T0();
            }
        }
    }

    @n0
    public static WorkDatabase M(@n0 final Context context, @n0 Executor queryExecutor, boolean useTestDatabase) {
        RoomDatabase.a aVarA;
        if (useTestDatabase) {
            aVarA = r2.c(context, WorkDatabase.class).e();
        } else {
            aVarA = r2.a(context, WorkDatabase.class, h.d());
            aVarA.q(new a(context));
        }
        return (WorkDatabase) aVarA.v(queryExecutor).b(O()).c(androidx.work.impl.a.f8405y).c(new a.h(context, 2, 3)).c(androidx.work.impl.a.f8406z).c(androidx.work.impl.a.A).c(new a.h(context, 5, 6)).c(androidx.work.impl.a.B).c(androidx.work.impl.a.C).c(androidx.work.impl.a.D).c(new a.i(context)).c(new a.h(context, 10, 11)).c(androidx.work.impl.a.E).n().f();
    }

    public static RoomDatabase.b O() {
        return new b();
    }

    public static long P() {
        return System.currentTimeMillis() - f8371s;
    }

    @n0
    public static String Q() {
        return f8369q + P() + f8370r;
    }

    @n0
    public abstract u2.b N();

    @n0
    public abstract u2.e R();

    @n0
    public abstract g S();

    @n0
    public abstract j T();

    @n0
    public abstract m U();

    @n0
    public abstract p V();

    @n0
    public abstract s W();

    @n0
    public abstract v X();
}
