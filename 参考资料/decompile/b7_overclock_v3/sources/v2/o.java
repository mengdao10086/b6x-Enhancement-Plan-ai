package v2;

import android.content.Context;
import android.os.PowerManager;
import androidx.annotation.RestrictTo;
import g.n0;
import java.util.HashMap;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f52612a = androidx.work.l.f("WakeLocks");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final WeakHashMap<PowerManager.WakeLock, String> f52613b = new WeakHashMap<>();

    public static void a() {
        HashMap map = new HashMap();
        WeakHashMap<PowerManager.WakeLock, String> weakHashMap = f52613b;
        synchronized (weakHashMap) {
            map.putAll(weakHashMap);
        }
        for (PowerManager.WakeLock wakeLock : map.keySet()) {
            if (wakeLock != null && wakeLock.isHeld()) {
                androidx.work.l.c().h(f52612a, String.format("WakeLock held for %s", map.get(wakeLock)), new Throwable[0]);
            }
        }
    }

    public static PowerManager.WakeLock b(@n0 Context context, @n0 String tag) {
        String str = "WorkManager: " + tag;
        PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) context.getApplicationContext().getSystemService("power")).newWakeLock(1, str);
        WeakHashMap<PowerManager.WakeLock, String> weakHashMap = f52613b;
        synchronized (weakHashMap) {
            weakHashMap.put(wakeLockNewWakeLock, str);
        }
        return wakeLockNewWakeLock;
    }
}
