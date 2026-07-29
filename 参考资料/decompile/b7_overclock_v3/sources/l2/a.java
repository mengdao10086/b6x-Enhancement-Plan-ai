package l2;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.RestrictTo;
import androidx.work.t;
import g.i1;
import g.n0;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class a implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f39340a;

    public a() {
        this.f39340a = androidx.core.os.j.a(Looper.getMainLooper());
    }

    @Override // androidx.work.t
    public void a(long delayInMillis, @n0 Runnable runnable) {
        this.f39340a.postDelayed(runnable, delayInMillis);
    }

    @Override // androidx.work.t
    public void b(@n0 Runnable runnable) {
        this.f39340a.removeCallbacks(runnable);
    }

    @n0
    public Handler c() {
        return this.f39340a;
    }

    @i1
    public a(@n0 Handler handler) {
        this.f39340a = handler;
    }
}
