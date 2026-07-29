package v0;

import android.os.Handler;
import android.os.Looper;
import g.n0;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    @n0
    public static Handler a() {
        return Looper.myLooper() == null ? new Handler(Looper.getMainLooper()) : new Handler();
    }
}
