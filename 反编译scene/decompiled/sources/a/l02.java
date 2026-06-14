package a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.provider.Settings;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.omarea.Scene;
import com.omarea.model.SceneConfigInfo;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class l02 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static WindowManager f6661a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Boolean f1702a = Boolean.FALSE;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ez0 f1703a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final wr0 f1704a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public wu0 f1705a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final z32 f1706a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f1707a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SharedPreferences f1708a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View f1709a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f1710a;
    public final z32 b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Context f1711b;
    public final z32 c;

    public l02(Context context) {
        f92.d(context, "context");
        this.f1711b = context;
        Context applicationContext = context.getApplicationContext();
        f92.c(applicationContext, "context.applicationContext");
        this.f1707a = applicationContext;
        this.f1705a = new wu0();
        this.f1706a = a42.a(new lz1(this));
        this.b = a42.a(new kz1(this));
        this.c = a42.a(new jz1(this));
        SharedPreferences sharedPreferences = this.f1711b.getSharedPreferences(hz0.f1282a.l0(), 0);
        this.f1708a = sharedPreferences;
        this.f1710a = sharedPreferences.getString("*", wu0.f3480a.c());
        this.f1703a = new ez0();
        this.f1704a = new wr0();
    }

    public final void k() {
        Boolean bool = f1702a;
        f92.b(bool);
        if (!bool.booleanValue() || this.f1709a == null) {
            return;
        }
        WindowManager windowManager = f6661a;
        f92.b(windowManager);
        windowManager.removeView(this.f1709a);
        f1702a = Boolean.FALSE;
    }

    public final String l() {
        String string = o() ? this.f1708a.getString(m(), this.f1710a) : wu0.f3480a.d();
        f92.b(string);
        return string;
    }

    public final String m() {
        return (String) this.c.getValue();
    }

    public final boolean n() {
        return this.f1705a.r() && hz0.f1282a.a0();
    }

    public final boolean o() {
        return ((Boolean) this.b.getValue()).booleanValue();
    }

    public final boolean p() {
        return ((Boolean) this.f1706a.getValue()).booleanValue();
    }

    public final void q(String str) {
        z90 z90Var = z90.f8048a;
        aa0 aa0Var = aa0.SCENE_APP_CONFIG;
        HashMap<String, Object> map = new HashMap<>();
        map.put("app", str);
        m42 m42Var = m42.f6769a;
        z90Var.a(aa0Var, map);
    }

    public final void r() {
        int i;
        Boolean bool = f1702a;
        f92.b(bool);
        if (bool.booleanValue()) {
            return;
        }
        f1702a = Boolean.TRUE;
        Object systemService = this.f1707a.getSystemService("window");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
        }
        f6661a = (WindowManager) systemService;
        View viewU = u(this.f1707a);
        if (viewU != null) {
            this.f1709a = viewU;
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            if (Build.VERSION.SDK_INT < 23) {
                layoutParams.type = 2003;
            } else {
                if (Settings.canDrawOverlays(this.f1707a)) {
                    i = Build.VERSION.SDK_INT >= 26 ? 2038 : 2032;
                    layoutParams.type = 2003;
                }
                layoutParams.type = i;
            }
            layoutParams.flags = 131072;
            layoutParams.format = -3;
            layoutParams.width = -1;
            layoutParams.height = -1;
            layoutParams.gravity = 17;
            layoutParams.windowAnimations = pb0.windowAnim;
            WindowManager windowManager = f6661a;
            f92.b(windowManager);
            windowManager.addView(this.f1709a, layoutParams);
        }
    }

    public final void s(View view) {
        view.setOnTouchListener(new mz1(this, view.findViewById(t61.popup_window)));
        view.setOnKeyListener(new nz1(this));
        ((ImageButton) view.findViewById(t61.fw_float_close)).setOnClickListener(new oz1(this));
    }

    public final void t(View view) {
        View viewFindViewById = view.findViewById(t61.fw_float_monitor);
        viewFindViewById.setAlpha(f92.a(ox1.f7064a.a(), Boolean.TRUE) ? 1.0f : 0.15f);
        viewFindViewById.setOnClickListener(new pz1(viewFindViewById));
        View viewFindViewById2 = view.findViewById(t61.fw_float_task);
        viewFindViewById2.setAlpha(u12.f3107a.b() ? 1.0f : 0.15f);
        viewFindViewById2.setOnClickListener(new qz1(viewFindViewById2));
        View viewFindViewById3 = view.findViewById(t61.fw_float_threads);
        viewFindViewById3.setAlpha(iz1.f6457a.b() ? 1.0f : 0.15f);
        viewFindViewById3.setOnClickListener(new rz1(viewFindViewById3));
        View viewFindViewById4 = view.findViewById(t61.fw_float_fps);
        viewFindViewById4.setAlpha(f92.a(py1.f7160a.a(), Boolean.TRUE) ? 1.0f : 0.15f);
        viewFindViewById4.setOnClickListener(new sz1(viewFindViewById4));
        View viewFindViewById5 = view.findViewById(t61.fw_float_monitor_mini);
        viewFindViewById5.setAlpha(f92.a(az1.f5657a.a(), Boolean.TRUE) ? 1.0f : 0.15f);
        viewFindViewById5.setOnClickListener(new tz1(viewFindViewById5));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v33 */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v20, types: [android.widget.CheckBox] */
    /* JADX WARN: Type inference failed for: r2v3, types: [T, java.lang.String] */
    public final View u(Context context) throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        f02 f02Var;
        h02 h02Var;
        ?? r0;
        View view;
        Object next;
        h02 h02Var2;
        View view2;
        CompoundButton compoundButton;
        CompoundButton compoundButton2;
        String str;
        SceneConfigInfo sceneConfigInfo;
        Object next2;
        fz0 fz0Var = new fz0(context);
        String str2 = (String) i52.A(ec2.d0(m(), new String[]{":"}, false, 0, 6, null));
        boolean z = (str2.length() == 0) || f92.a(str2, context.getPackageName()) || f92.a(str2, "android");
        SceneConfigInfo sceneConfigInfoB = fz0Var.b(m());
        if (sceneConfigInfoB == null) {
            k();
            return null;
        }
        View viewInflate = LayoutInflater.from(context).inflate(2131558565, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(t61.fw_title);
        boolean zO = o();
        n92 n92Var = new n92();
        n92Var.f6891a = l();
        boolean zS = this.f1705a.s();
        List<Display.Mode> listE = this.f1703a.e();
        int iF = this.f1703a.f();
        boolean zA = f92.a(new ri0(context).d(str2), Boolean.TRUE);
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str2, 0);
            f92.c(textView, "titleView");
            textView.setText(packageInfo.applicationInfo.loadLabel(packageManager).toString());
        } catch (Exception unused) {
            f92.c(textView, "titleView");
            textView.setText(m());
        }
        f02 f02Var2 = new f02(viewInflate);
        CompoundButton compoundButton3 = (CompoundButton) viewInflate.findViewById(t61.fw_fas_state);
        CompoundButton compoundButton4 = (CompoundButton) viewInflate.findViewById(t61.fw_pedestal_state);
        View viewFindViewById = viewInflate.findViewById(t61.btn_powersave);
        View viewFindViewById2 = viewInflate.findViewById(t61.btn_defaultmode);
        View viewFindViewById3 = viewInflate.findViewById(t61.btn_gamemode);
        View viewFindViewById4 = viewInflate.findViewById(t61.btn_fastmode);
        boolean zB = this.f1703a.b();
        boolean zK = new ez0().k();
        TextView textView2 = (TextView) viewInflate.findViewById(t61.btn_rr_60);
        TextView textView3 = (TextView) viewInflate.findViewById(t61.btn_rr_90);
        TextView textView4 = (TextView) viewInflate.findViewById(t61.btn_rr_120);
        SceneConfigInfo sceneConfigInfo2 = sceneConfigInfoB;
        TextView textView5 = (TextView) viewInflate.findViewById(t61.btn_rr_144);
        TextView textView6 = (TextView) viewInflate.findViewById(t61.btn_rr_165);
        Drawable drawableD = yb.d(context, 2131231113);
        if (iF > 165) {
            f92.c(textView6, "rr165");
            textView6.setText(String.valueOf(iF));
        }
        int i = 4;
        TextView[] textViewArr = {textView2, textView3, textView4, textView5, textView6};
        if (zK) {
            int i2 = 0;
            for (int i3 = 5; i2 < i3; i3 = 5) {
                TextView textView7 = textViewArr[i2];
                int i4 = Integer.parseInt(String.valueOf(textView7 != null ? textView7.getText() : null));
                Iterator it = listE.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next2 = null;
                        break;
                    }
                    next2 = it.next();
                    if (u92.b(((Display.Mode) next2).getRefreshRate()) == i4) {
                        break;
                    }
                }
                if (next2 == null) {
                    if (i4 > 144) {
                        f92.c(textView7, "it");
                        textView7.setVisibility(8);
                    }
                    f92.c(textView7, "it");
                    textView7.setAlpha(0.0f);
                    textView7.setClickable(false);
                    textView7.setEnabled(false);
                    textView7.setBackground(drawableD);
                }
                i2++;
                i = 4;
            }
        }
        View[] viewArr = new View[i];
        viewArr[0] = viewFindViewById;
        viewArr[1] = viewFindViewById2;
        viewArr[2] = viewFindViewById3;
        viewArr[3] = viewFindViewById4;
        if (!Scene.f4798a.b(hz0.f1282a.Z(), false)) {
            ((LinearLayout) viewInflate.findViewById(t61.popup_window)).setBackgroundColor(-1);
            textView.setTextColor(-16777216);
        }
        CompoundButton compoundButton5 = compoundButton4;
        CompoundButton compoundButton6 = compoundButton3;
        k02 k02Var = new k02(this, n92Var, viewArr, compoundButton5, zK, str2, textViewArr);
        h02 h02Var3 = new h02(this, k02Var, zO, str2, context, n92Var);
        if (zS && o()) {
            int i5 = 0;
            for (int i6 = 4; i5 < i6; i6 = 4) {
                viewArr[i5].setOnClickListener(new xz1(this, z, f02Var2, n92Var, h02Var3));
                i5++;
            }
        } else {
            for (int i7 = 0; i7 < 4; i7++) {
                viewArr[i7].setOnClickListener(c02.f5747a);
            }
        }
        if (zK) {
            int i8 = 0;
            while (i8 < 5) {
                TextView textView8 = textViewArr[i8];
                boolean z2 = zB && !z && zO;
                if (textView8 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
                }
                CharSequence text = textView8.getText();
                f92.b(text);
                int i9 = Integer.parseInt(text.toString());
                Iterator it2 = listE.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it2.next();
                    if (u92.b(((Display.Mode) next).getRefreshRate()) == i9) {
                        break;
                    }
                }
                if (next != null) {
                    h02Var2 = h02Var3;
                    view2 = viewInflate;
                    compoundButton = compoundButton6;
                    str = str2;
                    sceneConfigInfo = sceneConfigInfo2;
                    compoundButton2 = compoundButton5;
                    textView8.setOnClickListener(new a02(z2, i9, this, zB, z, zO, listE, f02Var2, str2, context, k02Var));
                } else {
                    h02Var2 = h02Var3;
                    view2 = viewInflate;
                    compoundButton = compoundButton6;
                    compoundButton2 = compoundButton5;
                    str = str2;
                    sceneConfigInfo = sceneConfigInfo2;
                }
                i8++;
                str2 = str;
                h02Var3 = h02Var2;
                viewInflate = view2;
                compoundButton6 = compoundButton;
                sceneConfigInfo2 = sceneConfigInfo;
                compoundButton5 = compoundButton2;
            }
        }
        h02 h02Var4 = h02Var3;
        View view3 = viewInflate;
        CompoundButton compoundButton7 = compoundButton6;
        CompoundButton compoundButton8 = compoundButton5;
        String str3 = str2;
        SceneConfigInfo sceneConfigInfo3 = sceneConfigInfo2;
        if (zA && this.f1704a.o() && zO) {
            f92.c(compoundButton7, "fasSwitch");
            compoundButton7.setChecked(this.f1704a.k(str3));
            f02Var = f02Var2;
            h02Var = h02Var4;
            compoundButton7.setOnClickListener(new d02(this, str3, h02Var, f02Var));
        } else {
            f02Var = f02Var2;
            h02Var = h02Var4;
            f92.c(compoundButton7, "fasSwitch");
            compoundButton7.setVisibility(8);
        }
        if (this.f1705a.r() && zO) {
            compoundButton8.setChecked(hz0.f1282a.a0());
            r0 = 0;
            compoundButton8.setVisibility(0);
            compoundButton8.setOnClickListener(new b02(h02Var, f02Var));
            m42 m42Var = m42.f6769a;
        } else {
            r0 = 0;
            f92.c(compoundButton8, "pedestalSwitch");
            compoundButton8.setVisibility(8);
        }
        if (z) {
            Integer[] numArr = new Integer[3];
            numArr[r0] = Integer.valueOf(t61.fw_app_light);
            numArr[1] = Integer.valueOf(t61.fw_app_dis_notice);
            numArr[2] = Integer.valueOf(t61.fw_app_gps);
            for (?? r11 = r0; r11 < 3; r11++) {
                numArr[r11].intValue();
                View viewFindViewById5 = view3.findViewById(t61.fw_app_light);
                f92.c(viewFindViewById5, "view.findViewById<CheckBox>(R.id.fw_app_light)");
                ((CheckBox) viewFindViewById5).setEnabled(r0);
            }
            view = view3;
        } else {
            view = view3;
            CheckBox checkBox = (CheckBox) view.findViewById(t61.fw_app_light);
            checkBox.setChecked(sceneConfigInfo3.aloneLight);
            checkBox.setOnClickListener(new uz1(this, sceneConfigInfo3, fz0Var, n92Var));
            m42 m42Var2 = m42.f6769a;
            CheckBox checkBox2 = (CheckBox) view.findViewById(t61.fw_app_dis_notice);
            checkBox2.setChecked(sceneConfigInfo3.disNotice);
            checkBox2.setOnClickListener(new vz1(this, sceneConfigInfo3, context, fz0Var));
            m42 m42Var3 = m42.f6769a;
            CheckBox checkBox3 = (CheckBox) view.findViewById(t61.fw_app_gps);
            checkBox3.setChecked(sceneConfigInfo3.gpsOn);
            checkBox3.setOnClickListener(new wz1(this, sceneConfigInfo3, fz0Var));
            m42 m42Var4 = m42.f6769a;
        }
        f92.c(view, "view");
        s(view);
        t(view);
        k02Var.run();
        return view;
    }
}
