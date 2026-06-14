package a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class a12 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static WindowManager f5559a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Boolean f9a = Boolean.FALSE;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final z32 f10a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f11a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View f12a;
    public final Context b;

    public a12(Context context) {
        f92.d(context, "context");
        this.b = context;
        Context applicationContext = context.getApplicationContext();
        f92.c(applicationContext, "context.applicationContext");
        this.f11a = applicationContext;
        a42.a(new n02(this));
        this.f10a = a42.a(m02.f6756a);
    }

    public final void b() {
        Boolean bool = f9a;
        f92.b(bool);
        if (!bool.booleanValue() || this.f12a == null) {
            return;
        }
        WindowManager windowManager = f5559a;
        f92.b(windowManager);
        windowManager.removeView(this.f12a);
        f9a = Boolean.FALSE;
    }

    public final String c() {
        return (String) this.f10a.getValue();
    }

    public final void d() {
        Boolean bool = f9a;
        f92.b(bool);
        if (bool.booleanValue()) {
            return;
        }
        f9a = Boolean.TRUE;
        Object systemService = this.f11a.getSystemService("window");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
        }
        f5559a = (WindowManager) systemService;
        View viewG = g(this.f11a);
        if (viewG != null) {
            this.f12a = viewG;
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.type = Settings.canDrawOverlays(this.f11a) ? Build.VERSION.SDK_INT >= 26 ? 2038 : 2003 : 2032;
            layoutParams.flags = 131072;
            layoutParams.format = -3;
            layoutParams.width = -1;
            layoutParams.height = -1;
            layoutParams.gravity = 17;
            layoutParams.windowAnimations = pb0.windowAnim;
            WindowManager windowManager = f5559a;
            f92.b(windowManager);
            windowManager.addView(this.f12a, layoutParams);
        }
    }

    public final void e(View view) {
        view.setOnTouchListener(new o02(this, view.findViewById(t61.popup_window)));
        view.setOnKeyListener(new p02(this));
        ((ImageButton) view.findViewById(t61.fw_float_close)).setOnClickListener(new q02(this));
    }

    public final void f(View view) {
        y02 y02Var = new y02(view);
        View viewFindViewById = view.findViewById(t61.fw_float_monitor);
        viewFindViewById.setAlpha(f92.a(ox1.f7064a.a(), Boolean.TRUE) ? 1.0f : 0.3f);
        viewFindViewById.setOnClickListener(new r02(viewFindViewById, 0.3f));
        View viewFindViewById2 = view.findViewById(t61.fw_float_task);
        viewFindViewById2.setAlpha(u12.f3107a.b() ? 1.0f : 0.3f);
        viewFindViewById2.setOnClickListener(new s02(viewFindViewById2, 0.3f));
        View viewFindViewById3 = view.findViewById(t61.fw_float_threads);
        viewFindViewById3.setAlpha(iz1.f6457a.b() ? 1.0f : 0.3f);
        viewFindViewById3.setOnClickListener(new t02(viewFindViewById3, 0.3f));
        View viewFindViewById4 = view.findViewById(t61.fw_float_fps);
        viewFindViewById4.setAlpha(f92.a(py1.f7160a.a(), Boolean.TRUE) ? 1.0f : 0.3f);
        viewFindViewById4.setOnClickListener(new u02(viewFindViewById4, 0.3f));
        View viewFindViewById5 = view.findViewById(t61.fw_float_monitor_mini);
        viewFindViewById5.setAlpha(f92.a(az1.f5657a.a(), Boolean.TRUE) ? 1.0f : 0.3f);
        viewFindViewById5.setOnClickListener(new v02(viewFindViewById5, 0.3f));
        TextView textView = (TextView) view.findViewById(t61.fw_scene_version);
        StringBuilder sb = new StringBuilder();
        sb.append("SCENE ");
        Context context = textView.getContext();
        f92.c(context, "context");
        PackageManager packageManager = context.getPackageManager();
        Context context2 = textView.getContext();
        f92.c(context2, "context");
        sb.append(packageManager.getPackageInfo(context2.getPackageName(), 0).versionName);
        textView.setText(sb.toString());
        CompoundButton compoundButton = (CompoundButton) view.findViewById(t61.fw_perf_boost);
        compoundButton.setChecked(gm0.f6221a.a());
        gm0 gm0Var = new gm0();
        compoundButton.setEnabled(gm0Var.e());
        compoundButton.setVisibility(gm0Var.f() ? 0 : 8);
        compoundButton.setOnClickListener(new w02(compoundButton, gm0Var, y02Var));
    }

    public final View g(Context context) {
        String str = (String) i52.A(ec2.d0(c(), new String[]{":"}, false, 0, 6, null));
        View viewInflate = LayoutInflater.from(context).inflate(2131558566, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(t61.fw_title);
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            f92.c(textView, "titleView");
            textView.setText(packageInfo.applicationInfo.loadLabel(packageManager).toString());
        } catch (Exception unused) {
            f92.c(textView, "titleView");
            textView.setText(c());
        }
        z02 z02Var = z02.f8024a;
        f92.c(viewInflate, "view");
        e(viewInflate);
        f(viewInflate);
        z02Var.run();
        return viewInflate;
    }
}
