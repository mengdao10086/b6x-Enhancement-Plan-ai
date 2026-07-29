package n1;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.util.SparseArray;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public abstract class a extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f41748a = "androidx.contentpager.content.wakelockid";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SparseArray<PowerManager.WakeLock> f41749b = new SparseArray<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f41750c = 1;

    public static boolean a(Intent intent) {
        int intExtra = intent.getIntExtra(f41748a, 0);
        if (intExtra == 0) {
            return false;
        }
        SparseArray<PowerManager.WakeLock> sparseArray = f41749b;
        synchronized (sparseArray) {
            PowerManager.WakeLock wakeLock = sparseArray.get(intExtra);
            if (wakeLock != null) {
                wakeLock.release();
                sparseArray.remove(intExtra);
                return true;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("No active wake lock id #");
            sb2.append(intExtra);
            return true;
        }
    }

    public static ComponentName b(Context context, Intent intent) {
        SparseArray<PowerManager.WakeLock> sparseArray = f41749b;
        synchronized (sparseArray) {
            int i10 = f41750c;
            int i11 = i10 + 1;
            f41750c = i11;
            if (i11 <= 0) {
                f41750c = 1;
            }
            intent.putExtra(f41748a, i10);
            ComponentName componentNameStartService = context.startService(intent);
            if (componentNameStartService == null) {
                return null;
            }
            PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "androidx.core:wake:" + componentNameStartService.flattenToShortString());
            wakeLockNewWakeLock.setReferenceCounted(false);
            wakeLockNewWakeLock.acquire(60000L);
            sparseArray.put(i10, wakeLockNewWakeLock);
            return componentNameStartService;
        }
    }
}
