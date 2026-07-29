package v2;

import androidx.annotation.RestrictTo;
import androidx.work.o;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l2.i f52586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l2.c f52587b = new l2.c();

    public h(l2.i workManagerImpl) {
        this.f52586a = workManagerImpl;
    }

    public androidx.work.o a() {
        return this.f52587b;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f52586a.M().W().c();
            this.f52587b.a(androidx.work.o.f8746a);
        } catch (Throwable th2) {
            this.f52587b.a(new o.b.a(th2));
        }
    }
}
