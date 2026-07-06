package a;

import android.accessibilityservice.AccessibilityService;
import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
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
import com.omarea.ui.CpuChartBarView;
import java.util.ArrayList;
import java.util.Timer;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class az1 {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static WindowManager f161a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Timer f163a;

    @SuppressLint({"StaticFieldLeak"})
    public static View b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f164a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public em0 f165a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public kl0 f166a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final z32 f167a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ActivityManager.MemoryInfo f168a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ActivityManager f169a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f170a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public BatteryManager f171a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View f172a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TextView f173a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CpuChartBarView f174a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<String[]> f175a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Integer[] f176a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f177b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final z32 f178b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public TextView f179b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public CpuChartBarView f180b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Integer[] f181b;
    public int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final z32 f182c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public TextView f183c;
    public final z32 d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public TextView f184d;
    public final z32 e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final qy1 f5657a = new qy1(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Boolean f162a = Boolean.FALSE;

    public az1(Context context) {
        f92.d(context, "mContext");
        this.f170a = context;
        this.f168a = new ActivityManager.MemoryInfo();
        this.f164a = -1;
        this.f175a = new ArrayList<>();
        this.f165a = new em0();
        this.f167a = a42.a(ty1.f7546a);
        this.f178b = a42.a(uy1.f7642a);
        this.f166a = new kl0();
        this.f182c = a42.a(sy1.f7444a);
        this.d = a42.a(new ry1(this));
        this.e = a42.a(new vy1(this));
    }

    public static final /* synthetic */ Integer[] c(az1 az1Var) {
        Integer[] numArr = az1Var.f176a;
        if (numArr != null) {
            return numArr;
        }
        f92.m("coreLoads");
        throw null;
    }

    public static /* synthetic */ void w(az1 az1Var, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        az1Var.v(z);
    }

    public final void A() {
        B();
        Timer timer = new Timer("FloatMonitorMini");
        f163a = timer;
        f92.b(timer);
        timer.schedule(new xy1(this), 2000L, 1500L);
    }

    public final void B() {
        Timer timer = f163a;
        if (timer != null) {
            f92.b(timer);
            timer.cancel();
            f163a = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:53:0x012a  */
    /* JADX WARN: Type inference failed for: r0v5, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v11, types: [T, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final /* synthetic */ java.lang.Object C(a.b62<? super a.m42> r14) {
        /*
            Method dump skipped, instruction units count: 410
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.az1.C(a.b62):java.lang.Object");
    }

    public final boolean r() {
        return ((Boolean) this.d.getValue()).booleanValue();
    }

    public final boolean s() {
        return ((Boolean) this.f167a.getValue()).booleanValue();
    }

    public final xl0 t() {
        return (xl0) this.f178b.getValue();
    }

    public final int u() {
        return ((Number) this.e.getValue()).intValue();
    }

    public final void v(boolean z) {
        View view;
        B();
        Boolean bool = f162a;
        f92.b(bool);
        if (bool.booleanValue() && (view = b) != null) {
            try {
                WindowManager windowManager = f161a;
                if (windowManager != null) {
                    windowManager.removeViewImmediate(view);
                }
            } catch (Exception unused) {
            }
            b = null;
        }
        f162a = Boolean.FALSE;
        if (z) {
            Scene.f4798a.k(hz0.f1282a.j0(), false);
        }
    }

    public final boolean x() {
        return ((Boolean) this.f182c.getValue()).booleanValue();
    }

    @SuppressLint({"ApplySharedPref", "ClickableViewAccessibility"})
    public final View y(Context context) {
        TextView textView;
        String str;
        View viewInflate = LayoutInflater.from(context).inflate(2131558563, (ViewGroup) null);
        this.f172a = viewInflate;
        f92.b(viewInflate);
        viewInflate.findViewById(t61.fw_gpu);
        View view = this.f172a;
        f92.b(view);
        view.findViewById(t61.fw_battery);
        View view2 = this.f172a;
        f92.b(view2);
        this.f173a = (TextView) view2.findViewById(t61.fw_cpu_freq);
        View view3 = this.f172a;
        f92.b(view3);
        this.f174a = (CpuChartBarView) view3.findViewById(t61.fw_cpu_chart);
        View view4 = this.f172a;
        f92.b(view4);
        this.f180b = (CpuChartBarView) view4.findViewById(t61.fw_gpu_chart);
        View view5 = this.f172a;
        f92.b(view5);
        this.f179b = (TextView) view5.findViewById(t61.fw_gpu_freq);
        View view6 = this.f172a;
        f92.b(view6);
        this.f183c = (TextView) view6.findViewById(t61.fw_battery_temp);
        View view7 = this.f172a;
        f92.b(view7);
        this.f184d = (TextView) view7.findViewById(t61.fw_mini_col3_value);
        if (x()) {
            textView = this.f184d;
            if (textView != null) {
                str = "RAM";
                textView.setText(str);
            }
        } else {
            textView = this.f184d;
            if (textView != null) {
                str = "FPS";
                textView.setText(str);
            }
        }
        Object systemService = context.getSystemService("activity");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
        }
        this.f169a = (ActivityManager) systemService;
        View view8 = this.f172a;
        f92.b(view8);
        return view8;
    }

    public final boolean z() {
        Boolean bool = f162a;
        f92.b(bool);
        if (bool.booleanValue()) {
            return true;
        }
        Scene.f4798a.k(hz0.f1282a.j0(), true);
        System.currentTimeMillis();
        if (this.f171a == null) {
            Object systemService = this.f170a.getSystemService("batterymanager");
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.os.BatteryManager");
            }
            this.f171a = (BatteryManager) systemService;
        }
        Context context = this.f170a;
        if (!(context instanceof AccessibilityService) && !Settings.canDrawOverlays(context)) {
            Context context2 = this.f170a;
            Toast.makeText(context2, context2.getString(u61.permission_float), 1).show();
            return false;
        }
        Object systemService2 = this.f170a.getSystemService("window");
        if (systemService2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
        }
        f161a = (WindowManager) systemService2;
        View viewY = y(this.f170a);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        int i = 2003;
        layoutParams.type = 2003;
        if (this.f170a instanceof AccessibilityService) {
            i = 2032;
        } else if (Build.VERSION.SDK_INT >= 26) {
            i = 2038;
        }
        layoutParams.type = i;
        layoutParams.format = -3;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.gravity = 49;
        layoutParams.x = 0;
        layoutParams.y = 0;
        layoutParams.flags = u42.k(new String[]{"dipper", "sirius", "ursa", "equuleus", "platina"}, Build.DEVICE) ? 1080 : 1832;
        if (Build.VERSION.SDK_INT >= 28) {
            layoutParams.layoutInDisplayCutoutMode = 1;
        }
        try {
            WindowManager windowManager = f161a;
            f92.b(windowManager);
            windowManager.addView(viewY, layoutParams);
            b = viewY;
            f162a = Boolean.TRUE;
            A();
            return true;
        } catch (Exception e) {
            Scene.c.p(Scene.f4798a, "FloatMonitorMini Error\n" + e.getMessage(), 0, 2, null);
            return false;
        }
    }
}
