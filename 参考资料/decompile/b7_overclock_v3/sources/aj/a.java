package aj;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.Objects;
import java.util.concurrent.Callable;
import xi.h0;

/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h0 f715a = zi.a.f(new CallableC0013a());

    /* JADX INFO: renamed from: aj.a$a, reason: collision with other inner class name */
    public static class CallableC0013a implements Callable<h0> {
        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public h0 call() throws Exception {
            return b.f716a;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h0 f716a = new aj.b(new Handler(Looper.getMainLooper()), false);
    }

    public a() {
        throw new AssertionError("No instances.");
    }

    public static h0 a(Looper looper) {
        return b(looper, false);
    }

    @SuppressLint({"NewApi"})
    public static h0 b(Looper looper, boolean z10) {
        Objects.requireNonNull(looper, "looper == null");
        int i10 = Build.VERSION.SDK_INT;
        if (z10 && i10 < 22) {
            Message messageObtain = Message.obtain();
            try {
                messageObtain.setAsynchronous(true);
            } catch (NoSuchMethodError unused) {
                z10 = false;
            }
            messageObtain.recycle();
        }
        return new aj.b(new Handler(looper), z10);
    }

    public static h0 c() {
        return zi.a.g(f715a);
    }
}
