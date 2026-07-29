package v2;

import androidx.annotation.RestrictTo;
import androidx.work.WorkInfo;
import androidx.work.impl.WorkDatabase;
import g.n0;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class m implements Runnable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f52608d = androidx.work.l.f("StopWorkRunnable");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l2.i f52609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f52610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f52611c;

    public m(@n0 l2.i workManagerImpl, @n0 String workSpecId, boolean stopInForeground) {
        this.f52609a = workManagerImpl;
        this.f52610b = workSpecId;
        this.f52611c = stopInForeground;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean zP;
        WorkDatabase workDatabaseM = this.f52609a.M();
        l2.d dVarJ = this.f52609a.J();
        u2.s sVarW = workDatabaseM.W();
        workDatabaseM.e();
        try {
            boolean zI = dVarJ.i(this.f52610b);
            if (this.f52611c) {
                zP = this.f52609a.J().o(this.f52610b);
            } else {
                if (!zI && sVarW.t(this.f52610b) == WorkInfo.State.RUNNING) {
                    sVarW.b(WorkInfo.State.ENQUEUED, this.f52610b);
                }
                zP = this.f52609a.J().p(this.f52610b);
            }
            androidx.work.l.c().a(f52608d, String.format("StopWorkRunnable for %s; Processor.stopWork = %s", this.f52610b, Boolean.valueOf(zP)), new Throwable[0]);
            workDatabaseM.K();
        } finally {
            workDatabaseM.k();
        }
    }
}
