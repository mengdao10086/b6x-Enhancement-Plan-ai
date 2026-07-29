package h0;

import android.accounts.AccountManager;
import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.AppOpsManager;
import android.app.DownloadManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.app.SearchManager;
import android.app.UiModeManager;
import android.app.WallpaperManager;
import android.app.admin.DevicePolicyManager;
import android.app.job.JobScheduler;
import android.app.usage.UsageStatsManager;
import android.appwidget.AppWidgetManager;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.RestrictionsManager;
import android.content.pm.LauncherApps;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.hardware.ConsumerIrManager;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraManager;
import android.hardware.display.DisplayManager;
import android.hardware.input.InputManager;
import android.hardware.usb.UsbManager;
import android.location.LocationManager;
import android.media.AudioManager;
import android.media.MediaRouter;
import android.media.projection.MediaProjectionManager;
import android.media.session.MediaSessionManager;
import android.media.tv.TvInputManager;
import android.net.ConnectivityManager;
import android.net.nsd.NsdManager;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pManager;
import android.nfc.NfcManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.os.DropBoxManager;
import android.os.Handler;
import android.os.PowerManager;
import android.os.Process;
import android.os.UserManager;
import android.os.Vibrator;
import android.os.storage.StorageManager;
import android.print.PrintManager;
import android.telecom.TelecomManager;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.CaptioningManager;
import android.view.inputmethod.InputMethodManager;
import android.view.textservice.TextServicesManager;
import androidx.annotation.RestrictTo;
import androidx.core.os.a;
import bg.c;
import com.efs.sdk.base.core.util.NetworkUtil;
import com.flydigi.action.FirmwareUpgradeStatisticsLog;
import com.umeng.analytics.pro.an;
import com.umeng.socialize.common.SocializeConstants;
import g.r0;
import g.v0;
import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"PrivateConstructorForUtilityClass"})
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f30103a = "ContextCompat";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f30104b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f30105c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static TypedValue f30106d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f30107e = ".DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f30108f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f30109g = 2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f30110h = 4;

    @v0(16)
    public static class a {
        @g.u
        public static void a(Context context, Intent[] intentArr, Bundle bundle) {
            context.startActivities(intentArr, bundle);
        }

        @g.u
        public static void b(Context context, Intent intent, Bundle bundle) {
            context.startActivity(intent, bundle);
        }
    }

    @v0(19)
    public static class b {
        @g.u
        public static File[] a(Context context) {
            return context.getExternalCacheDirs();
        }

        @g.u
        public static File[] b(Context context, String str) {
            return context.getExternalFilesDirs(str);
        }

        @g.u
        public static File[] c(Context context) {
            return context.getObbDirs();
        }
    }

    @v0(21)
    public static class c {
        @g.u
        public static File a(Context context) {
            return context.getCodeCacheDir();
        }

        @g.u
        public static Drawable b(Context context, int i10) {
            return context.getDrawable(i10);
        }

        @g.u
        public static File c(Context context) {
            return context.getNoBackupFilesDir();
        }
    }

    /* JADX INFO: renamed from: h0.d$d, reason: collision with other inner class name */
    @v0(23)
    public static class C0354d {
        @g.u
        public static int a(Context context, int i10) {
            return context.getColor(i10);
        }

        @g.u
        public static <T> T b(Context context, Class<T> cls) {
            return (T) context.getSystemService(cls);
        }

        @g.u
        public static String c(Context context, Class<?> cls) {
            return context.getSystemServiceName(cls);
        }
    }

    @v0(24)
    public static class e {
        @g.u
        public static Context a(Context context) {
            return context.createDeviceProtectedStorageContext();
        }

        @g.u
        public static File b(Context context) {
            return context.getDataDir();
        }

        @g.u
        public static boolean c(Context context) {
            return context.isDeviceProtectedStorage();
        }
    }

    @v0(26)
    public static class f {
        @g.u
        public static Intent a(Context context, @g.p0 BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i10) {
            return ((i10 & 4) == 0 || str != null) ? context.registerReceiver(broadcastReceiver, intentFilter, str, handler, i10 & 1) : context.registerReceiver(broadcastReceiver, intentFilter, d.r(context), handler);
        }

        @g.u
        public static ComponentName b(Context context, Intent intent) {
            return context.startForegroundService(intent);
        }
    }

    @v0(28)
    public static class g {
        @g.u
        public static Executor a(Context context) {
            return context.getMainExecutor();
        }
    }

    @v0(30)
    public static class h {
        @g.u
        public static String a(Context context) {
            return context.getAttributionTag();
        }
    }

    @v0(33)
    public static class i {
        @g.u
        public static Intent a(Context context, @g.p0 BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i10) {
            return context.registerReceiver(broadcastReceiver, intentFilter, str, handler, i10);
        }
    }

    public static final class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final HashMap<Class<?>, String> f30111a;

        static {
            HashMap<Class<?>, String> map = new HashMap<>();
            f30111a = map;
            if (Build.VERSION.SDK_INT >= 22) {
                map.put(SubscriptionManager.class, "telephony_subscription_service");
                map.put(UsageStatsManager.class, "usagestats");
            }
            map.put(AppWidgetManager.class, "appwidget");
            map.put(BatteryManager.class, "batterymanager");
            map.put(CameraManager.class, "camera");
            map.put(JobScheduler.class, "jobscheduler");
            map.put(LauncherApps.class, "launcherapps");
            map.put(MediaProjectionManager.class, "media_projection");
            map.put(MediaSessionManager.class, "media_session");
            map.put(RestrictionsManager.class, "restrictions");
            map.put(TelecomManager.class, "telecom");
            map.put(TvInputManager.class, "tv_input");
            map.put(AppOpsManager.class, "appops");
            map.put(CaptioningManager.class, "captioning");
            map.put(ConsumerIrManager.class, "consumer_ir");
            map.put(PrintManager.class, "print");
            map.put(BluetoothManager.class, FirmwareUpgradeStatisticsLog.f13300c);
            map.put(DisplayManager.class, "display");
            map.put(UserManager.class, com.umeng.analytics.pro.z.f23807m);
            map.put(InputManager.class, "input");
            map.put(MediaRouter.class, "media_router");
            map.put(NsdManager.class, "servicediscovery");
            map.put(AccessibilityManager.class, "accessibility");
            map.put(AccountManager.class, "account");
            map.put(ActivityManager.class, androidx.appcompat.widget.c.f2369r);
            map.put(AlarmManager.class, f0.v.K0);
            map.put(AudioManager.class, "audio");
            map.put(ClipboardManager.class, "clipboard");
            map.put(ConnectivityManager.class, "connectivity");
            map.put(DevicePolicyManager.class, "device_policy");
            map.put(DownloadManager.class, "download");
            map.put(DropBoxManager.class, "dropbox");
            map.put(InputMethodManager.class, "input_method");
            map.put(KeyguardManager.class, "keyguard");
            map.put(LayoutInflater.class, "layout_inflater");
            map.put(LocationManager.class, SocializeConstants.KEY_LOCATION);
            map.put(NfcManager.class, "nfc");
            map.put(NotificationManager.class, "notification");
            map.put(PowerManager.class, "power");
            map.put(SearchManager.class, "search");
            map.put(SensorManager.class, an.f23201ac);
            map.put(StorageManager.class, "storage");
            map.put(TelephonyManager.class, "phone");
            map.put(TextServicesManager.class, "textservices");
            map.put(UiModeManager.class, "uimode");
            map.put(UsbManager.class, "usb");
            map.put(Vibrator.class, "vibrator");
            map.put(WallpaperManager.class, "wallpaper");
            map.put(WifiP2pManager.class, "wifip2p");
            map.put(WifiManager.class, NetworkUtil.NETWORK_TYPE_WIFI);
            map.put(WindowManager.class, "window");
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface k {
    }

    @r0(markerClass = {a.b.class})
    public static int a(@g.n0 Context context, @g.n0 String str) {
        androidx.core.util.j.e(str, "permission must be non-null");
        return (androidx.core.os.a.k() || !TextUtils.equals(c.a.f9430a, str)) ? context.checkPermission(str, Process.myPid(), Process.myUid()) : f0.a0.p(context).a() ? 0 : -1;
    }

    @g.p0
    public static Context b(@g.n0 Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return e.a(context);
        }
        return null;
    }

    public static File c(File file) {
        synchronized (f30105c) {
            if (!file.exists()) {
                if (file.mkdirs()) {
                    return file;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unable to create files subdir ");
                sb2.append(file.getPath());
            }
            return file;
        }
    }

    @g.p0
    public static String d(@g.n0 Context context) {
        if (Build.VERSION.SDK_INT >= 30) {
            return h.a(context);
        }
        return null;
    }

    @g.n0
    public static File e(@g.n0 Context context) {
        return c.a(context);
    }

    @g.l
    public static int f(@g.n0 Context context, @g.n int i10) {
        return Build.VERSION.SDK_INT >= 23 ? C0354d.a(context, i10) : context.getResources().getColor(i10);
    }

    @g.p0
    public static ColorStateList g(@g.n0 Context context, @g.n int i10) {
        return j0.i.f(context.getResources(), i10, context.getTheme());
    }

    @g.p0
    public static File h(@g.n0 Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return e.b(context);
        }
        String str = context.getApplicationInfo().dataDir;
        if (str != null) {
            return new File(str);
        }
        return null;
    }

    @g.p0
    public static Drawable i(@g.n0 Context context, @g.v int i10) {
        return c.b(context, i10);
    }

    @g.n0
    public static File[] j(@g.n0 Context context) {
        return b.a(context);
    }

    @g.n0
    public static File[] k(@g.n0 Context context, @g.p0 String str) {
        return b.b(context, str);
    }

    @g.n0
    public static Executor l(@g.n0 Context context) {
        return Build.VERSION.SDK_INT >= 28 ? g.a(context) : androidx.core.os.i.a(new Handler(context.getMainLooper()));
    }

    @g.p0
    public static File m(@g.n0 Context context) {
        return c.c(context);
    }

    @g.n0
    public static File[] n(@g.n0 Context context) {
        return b.c(context);
    }

    @g.p0
    public static <T> T o(@g.n0 Context context, @g.n0 Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 23) {
            return (T) C0354d.b(context, cls);
        }
        String strP = p(context, cls);
        if (strP != null) {
            return (T) context.getSystemService(strP);
        }
        return null;
    }

    @g.p0
    public static String p(@g.n0 Context context, @g.n0 Class<?> cls) {
        return Build.VERSION.SDK_INT >= 23 ? C0354d.c(context, cls) : j.f30111a.get(cls);
    }

    public static boolean q(@g.n0 Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return e.c(context);
        }
        return false;
    }

    public static String r(Context context) {
        String str = context.getPackageName() + f30107e;
        if (i0.d(context, str) == 0) {
            return str;
        }
        throw new RuntimeException("Permission " + str + " is required by your application to receive broadcasts, please add it to your manifest");
    }

    @g.p0
    public static Intent s(@g.n0 Context context, @g.p0 BroadcastReceiver broadcastReceiver, @g.n0 IntentFilter intentFilter, int i10) {
        return t(context, broadcastReceiver, intentFilter, null, null, i10);
    }

    @g.p0
    @r0(markerClass = {a.b.class})
    public static Intent t(@g.n0 Context context, @g.p0 BroadcastReceiver broadcastReceiver, @g.n0 IntentFilter intentFilter, @g.p0 String str, @g.p0 Handler handler, int i10) {
        int i11 = i10 & 1;
        if (i11 != 0 && (i10 & 4) != 0) {
            throw new IllegalArgumentException("Cannot specify both RECEIVER_VISIBLE_TO_INSTANT_APPS and RECEIVER_NOT_EXPORTED");
        }
        if (i11 != 0) {
            i10 |= 2;
        }
        int i12 = i10;
        int i13 = i12 & 2;
        if (i13 == 0 && (i12 & 4) == 0) {
            throw new IllegalArgumentException("One of either RECEIVER_EXPORTED or RECEIVER_NOT_EXPORTED is required");
        }
        if (i13 == 0 || (i12 & 4) == 0) {
            return androidx.core.os.a.k() ? i.a(context, broadcastReceiver, intentFilter, str, handler, i12) : Build.VERSION.SDK_INT >= 26 ? f.a(context, broadcastReceiver, intentFilter, str, handler, i12) : ((i12 & 4) == 0 || str != null) ? context.registerReceiver(broadcastReceiver, intentFilter, str, handler) : context.registerReceiver(broadcastReceiver, intentFilter, r(context), handler);
        }
        throw new IllegalArgumentException("Cannot specify both RECEIVER_EXPORTED and RECEIVER_NOT_EXPORTED");
    }

    public static boolean u(@g.n0 Context context, @g.n0 Intent[] intentArr) {
        return v(context, intentArr, null);
    }

    public static boolean v(@g.n0 Context context, @g.n0 Intent[] intentArr, @g.p0 Bundle bundle) {
        a.a(context, intentArr, bundle);
        return true;
    }

    public static void w(@g.n0 Context context, @g.n0 Intent intent, @g.p0 Bundle bundle) {
        a.b(context, intent, bundle);
    }

    public static void x(@g.n0 Context context, @g.n0 Intent intent) {
        if (Build.VERSION.SDK_INT >= 26) {
            f.b(context, intent);
        } else {
            context.startService(intent);
        }
    }
}
