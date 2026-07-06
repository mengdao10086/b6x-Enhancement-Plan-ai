package a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.BatteryManager;
import android.os.Build;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;
import com.omarea.Scene;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Timer;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class d22 {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static WindowManager f457a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Timer f459a;

    @SuppressLint({"StaticFieldLeak"})
    public static View b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f460a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public BatteryManager f461a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View f462a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TextView f463a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Map<String, String> f464a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f465a;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v12 f5853a = new v12(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Boolean f458a = Boolean.FALSE;

    public d22(Context context) {
        f92.d(context, "mContext");
        this.f460a = context;
        LinkedHashMap linkedHashMapE = t52.e(j42.a("cpu", "# CPU "), j42.a("gpu", "# GPU "), j42.a("ddr", "# DDR "), j42.a("soc_max", "# SOC "), j42.a("camera", "# CAM "));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : linkedHashMapE.entrySet()) {
            if (((Boolean) pc2.b(null, new a22(entry, null), 1, null)).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        this.f464a = linkedHashMap;
    }

    public final void f() {
        View view;
        j();
        Boolean bool = f458a;
        f92.b(bool);
        if (!bool.booleanValue() || (view = b) == null) {
            return;
        }
        try {
            WindowManager windowManager = f457a;
            if (windowManager != null) {
                windowManager.removeViewImmediate(view);
            }
        } catch (Exception unused) {
        }
        b = null;
        f458a = Boolean.FALSE;
    }

    @SuppressLint({"ApplySharedPref", "ClickableViewAccessibility"})
    public final View g(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(2131558568, (ViewGroup) null);
        this.f462a = viewInflate;
        f92.b(viewInflate);
        this.f463a = (TextView) viewInflate.findViewById(t61.fw_info);
        Object systemService = context.getSystemService("activity");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
        }
        View view = this.f462a;
        f92.b(view);
        view.setOnClickListener(new w12(this));
        View view2 = this.f462a;
        f92.b(view2);
        return view2;
    }

    public final boolean h() {
        Boolean bool = f458a;
        f92.b(bool);
        if (bool.booleanValue()) {
            return true;
        }
        if (this.f461a == null) {
            Object systemService = this.f460a.getSystemService("batterymanager");
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.os.BatteryManager");
            }
            this.f461a = (BatteryManager) systemService;
        }
        if (Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(this.f460a)) {
            Context context = this.f460a;
            Toast.makeText(context, context.getString(u61.permission_float), 1).show();
            return false;
        }
        f458a = Boolean.TRUE;
        Object systemService2 = this.f460a.getSystemService("window");
        if (systemService2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
        }
        f457a = (WindowManager) systemService2;
        View viewG = g(this.f460a);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        SharedPreferences sharedPreferences = this.f460a.getSharedPreferences("monitor", 0);
        layoutParams.type = 2003;
        layoutParams.type = Build.VERSION.SDK_INT >= 26 ? 2038 : 2003;
        layoutParams.format = -3;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.gravity = 51;
        layoutParams.x = sharedPreferences.getInt("temperature_x", 0);
        layoutParams.y = sharedPreferences.getInt("temperature_y", 0);
        layoutParams.flags = 1064;
        if (Build.VERSION.SDK_INT >= 28) {
            layoutParams.layoutInDisplayCutoutMode = 1;
        }
        try {
            WindowManager windowManager = f457a;
            f92.b(windowManager);
            windowManager.addView(viewG, layoutParams);
            b = viewG;
            viewG.setOnTouchListener(new x12(this, layoutParams, sharedPreferences));
            i();
            return true;
        } catch (Exception e) {
            Scene.c.p(Scene.f4798a, "FloatMonitor Error\n" + e.getMessage(), 0, 2, null);
            return false;
        }
    }

    public final void i() {
        j();
        Timer timer = new Timer("FloatTemperature");
        f459a = timer;
        f92.b(timer);
        timer.schedule(new z12(this), 0L, 1500L);
    }

    public final void j() {
        Timer timer = f459a;
        if (timer != null) {
            f92.b(timer);
            timer.cancel();
            f459a = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00aa -> B:24:0x00ae). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final /* synthetic */ java.lang.Object k(a.b62<? super a.m42> r21) throws javax.crypto.NoSuchPaddingException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, java.security.InvalidAlgorithmParameterException {
        /*
            Method dump skipped, instruction units count: 217
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d22.k(a.b62):java.lang.Object");
    }
}
