package v2;

import android.text.TextUtils;
import androidx.annotation.RestrictTo;
import androidx.work.d;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import androidx.work.o;
import g.i1;
import g.n0;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class b implements Runnable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f52564c = androidx.work.l.f("EnqueueRunnable");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l2.g f52565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l2.c f52566b = new l2.c();

    public b(@n0 l2.g workContinuation) {
        this.f52565a = workContinuation;
    }

    public static boolean b(@n0 l2.g workContinuation) {
        boolean zC = c(workContinuation.n(), workContinuation.m(), (String[]) l2.g.s(workContinuation).toArray(new String[0]), workContinuation.k(), workContinuation.i());
        workContinuation.r();
        return zC;
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01e1 A[LOOP:5: B:125:0x01db->B:127:0x01e1, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x020a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x014e A[PHI: r1 r9 r12 r13 r14
  0x014e: PHI (r1v1 java.lang.String[]) = (r1v0 java.lang.String[]), (r1v0 java.lang.String[]), (r1v4 java.lang.String[]) binds: [B:32:0x006c, B:34:0x007a, B:88:0x014d] A[DONT_GENERATE, DONT_INLINE]
  0x014e: PHI (r9v2 boolean) = (r9v1 boolean), (r9v1 boolean), (r9v7 boolean) binds: [B:32:0x006c, B:34:0x007a, B:88:0x014d] A[DONT_GENERATE, DONT_INLINE]
  0x014e: PHI (r12v2 boolean) = (r12v1 boolean), (r12v1 boolean), (r12v4 boolean) binds: [B:32:0x006c, B:34:0x007a, B:88:0x014d] A[DONT_GENERATE, DONT_INLINE]
  0x014e: PHI (r13v2 boolean) = (r13v1 boolean), (r13v1 boolean), (r13v5 boolean) binds: [B:32:0x006c, B:34:0x007a, B:88:0x014d] A[DONT_GENERATE, DONT_INLINE]
  0x014e: PHI (r14v2 boolean) = (r14v1 boolean), (r14v1 boolean), (r14v5 boolean) binds: [B:32:0x006c, B:34:0x007a, B:88:0x014d] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean c(l2.i r19, @g.n0 java.util.List<? extends androidx.work.x> r20, java.lang.String[] r21, java.lang.String r22, androidx.work.ExistingWorkPolicy r23) {
        /*
            Method dump skipped, instruction units count: 529
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v2.b.c(l2.i, java.util.List, java.lang.String[], java.lang.String, androidx.work.ExistingWorkPolicy):boolean");
    }

    public static boolean e(@n0 l2.g workContinuation) {
        List<l2.g> listL = workContinuation.l();
        boolean z10 = false;
        if (listL != null) {
            boolean zE = false;
            for (l2.g gVar : listL) {
                if (gVar.q()) {
                    androidx.work.l.c().h(f52564c, String.format("Already enqueued work ids (%s).", TextUtils.join(", ", gVar.j())), new Throwable[0]);
                } else {
                    zE |= e(gVar);
                }
            }
            z10 = zE;
        }
        return b(workContinuation) | z10;
    }

    public static void g(u2.r workSpec) {
        androidx.work.b bVar = workSpec.f51850j;
        String str = workSpec.f51843c;
        if (str.equals(ConstraintTrackingWorker.class.getName())) {
            return;
        }
        if (bVar.f() || bVar.i()) {
            d.a aVar = new d.a();
            aVar.c(workSpec.f51845e).q(ConstraintTrackingWorker.f8554l, str);
            workSpec.f51843c = ConstraintTrackingWorker.class.getName();
            workSpec.f51845e = aVar.a();
        }
    }

    public static boolean h(@n0 l2.i workManager, @n0 String className) {
        try {
            Class<?> cls = Class.forName(className);
            Iterator<l2.e> it2 = workManager.L().iterator();
            while (it2.hasNext()) {
                if (cls.isAssignableFrom(it2.next().getClass())) {
                    return true;
                }
            }
        } catch (ClassNotFoundException unused) {
        }
        return false;
    }

    @i1
    public boolean a() {
        WorkDatabase workDatabaseM = this.f52565a.n().M();
        workDatabaseM.e();
        try {
            boolean zE = e(this.f52565a);
            workDatabaseM.K();
            return zE;
        } finally {
            workDatabaseM.k();
        }
    }

    @n0
    public androidx.work.o d() {
        return this.f52566b;
    }

    @i1
    public void f() {
        l2.i iVarN = this.f52565a.n();
        l2.f.b(iVarN.F(), iVarN.M(), iVarN.L());
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.f52565a.o()) {
                throw new IllegalStateException(String.format("WorkContinuation has cycles (%s)", this.f52565a));
            }
            if (a()) {
                e.c(this.f52565a.n().E(), RescheduleReceiver.class, true);
                f();
            }
            this.f52566b.a(androidx.work.o.f8746a);
        } catch (Throwable th2) {
            this.f52566b.a(new o.b.a(th2));
        }
    }
}
