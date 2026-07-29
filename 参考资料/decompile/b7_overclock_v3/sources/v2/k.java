package v2;

import androidx.annotation.RestrictTo;
import androidx.work.WorkerParameters;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l2.i f52594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f52595b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WorkerParameters.a f52596c;

    public k(l2.i workManagerImpl, String workSpecId, WorkerParameters.a runtimeExtras) {
        this.f52594a = workManagerImpl;
        this.f52595b = workSpecId;
        this.f52596c = runtimeExtras;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f52594a.J().l(this.f52595b, this.f52596c);
    }
}
