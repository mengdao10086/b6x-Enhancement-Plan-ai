package androidx.work.impl.workers;

import ag.c;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.RestrictTo;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.l;
import g.n0;
import g.p0;
import java.util.List;
import java.util.concurrent.TimeUnit;
import u2.i;
import u2.j;
import u2.m;
import u2.r;
import u2.s;
import u2.v;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class DiagnosticsWorker extends Worker {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f8563g = l.f("DiagnosticsWrkr");

    public DiagnosticsWorker(@n0 Context context, @n0 WorkerParameters parameters) {
        super(context, parameters);
    }

    @n0
    public static String A(@n0 m workNameDao, @n0 v workTagDao, @n0 j systemIdInfoDao, @n0 List<r> workSpecs) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(String.format("\n Id \t Class Name\t %s\t State\t Unique Name\t Tags\t", Build.VERSION.SDK_INT >= 23 ? "Job Id" : "Alarm Id"));
        for (r rVar : workSpecs) {
            Integer numValueOf = null;
            i iVarC = systemIdInfoDao.c(rVar.f51841a);
            if (iVarC != null) {
                numValueOf = Integer.valueOf(iVarC.f51818b);
            }
            sb2.append(z(rVar, TextUtils.join(c.f654g, workNameDao.c(rVar.f51841a)), numValueOf, TextUtils.join(c.f654g, workTagDao.a(rVar.f51841a))));
        }
        return sb2.toString();
    }

    @n0
    public static String z(@n0 r workSpec, @p0 String name, @p0 Integer systemId, @n0 String tags) {
        return String.format("\n%s\t %s\t %s\t %s\t %s\t %s\t", workSpec.f51841a, workSpec.f51843c, systemId, workSpec.f51842b.name(), name, tags);
    }

    @Override // androidx.work.Worker
    @n0
    public ListenableWorker.a y() {
        WorkDatabase workDatabaseM = l2.i.H(a()).M();
        s sVarW = workDatabaseM.W();
        m mVarU = workDatabaseM.U();
        v vVarX = workDatabaseM.X();
        j jVarT = workDatabaseM.T();
        List<r> listF = sVarW.f(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1L));
        List<r> listN = sVarW.n();
        List<r> listF2 = sVarW.F(200);
        if (listF != null && !listF.isEmpty()) {
            l lVarC = l.c();
            String str = f8563g;
            lVarC.d(str, "Recently completed work:\n\n", new Throwable[0]);
            l.c().d(str, A(mVarU, vVarX, jVarT, listF), new Throwable[0]);
        }
        if (listN != null && !listN.isEmpty()) {
            l lVarC2 = l.c();
            String str2 = f8563g;
            lVarC2.d(str2, "Running work:\n\n", new Throwable[0]);
            l.c().d(str2, A(mVarU, vVarX, jVarT, listN), new Throwable[0]);
        }
        if (listF2 != null && !listF2.isEmpty()) {
            l lVarC3 = l.c();
            String str3 = f8563g;
            lVarC3.d(str3, "Enqueued work:\n\n", new Throwable[0]);
            l.c().d(str3, A(mVarU, vVarX, jVarT, listF2), new Throwable[0]);
        }
        return ListenableWorker.a.e();
    }
}
