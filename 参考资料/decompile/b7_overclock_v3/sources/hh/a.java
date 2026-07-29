package hh;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes5.dex */
public class a {
    public static void a(Runnable runnable) {
        new Handler(Looper.getMainLooper()).post(runnable);
    }
}
