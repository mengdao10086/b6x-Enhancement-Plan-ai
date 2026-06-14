package a;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.BatteryManager;
import android.os.Build;
import android.provider.Settings;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;
import com.omarea.Scene;
import com.omarea.ui.FloatMonitorBatteryView;
import com.omarea.ui.FloatMonitorChartView;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Timer;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ox1 {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static WindowManager f2311a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Timer f2313a;

    @SuppressLint({"StaticFieldLeak"})
    public static View b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f2314a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final em0 f2315a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final fn0 f2316a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public kl0 f2317a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public rl0 f2318a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final xl0 f2319a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final z32 f2320a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ActivityManager.MemoryInfo f2321a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ActivityManager f2322a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f2323a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public BatteryManager f2324a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SpannableString f2325a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View f2326a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TextView f2327a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public FloatMonitorBatteryView f2328a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public FloatMonitorChartView f2329a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<String[]> f2330a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f2331a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Double[] f2332a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Integer[] f2333a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f2334b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public TextView f2335b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public FloatMonitorChartView f2336b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f2337b;
    public int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public TextView f2338c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final boolean f2339c;
    public int d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public TextView f2340d;
    public int e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public TextView f2341e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final gx1 f7064a = new gx1(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Boolean f2312a = Boolean.FALSE;

    public ox1(Context context) {
        f92.d(context, "mContext");
        this.f2323a = context;
        this.f2317a = new kl0();
        this.f2331a = f92.a(e50.f677a.y0(), "root");
        this.f2318a = new rl0();
        this.f2321a = new ActivityManager.MemoryInfo();
        this.c = -1;
        this.f2330a = new ArrayList<>();
        this.f2319a = new xl0();
        this.f2316a = new fn0(this.f2323a);
        this.f2315a = new em0();
        this.f2320a = a42.a(ix1.f6451a);
        this.f2339c = Scene.f4798a.b(hz0.f1282a.Y(), false);
    }

    public static /* synthetic */ void s(ox1 ox1Var, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        ox1Var.r(z);
    }

    public final boolean p() {
        return ((Boolean) this.f2320a.getValue()).booleanValue();
    }

    public final CharSequence q() {
        String string;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.f2325a == null || jCurrentTimeMillis - ((long) this.d) > 5000) {
            ActivityManager activityManager = this.f2322a;
            f92.b(activityManager);
            activityManager.getMemoryInfo(this.f2321a);
            this.f2314a = (int) (this.f2321a.totalMem / 1024.0f);
            Long lU = this.f2316a.u();
            if (this.f2314a != 0) {
                if (!f92.a(e50.f677a.y0(), "basic")) {
                    vl0 vl0Var = (vl0) pc2.b(null, new hx1(this, null), 1, null);
                    this.f2334b = p() ? vl0Var.a() + vl0Var.c() : (int) (this.f2321a.availMem / 1024.0f);
                    long jE = ((this.f2314a + vl0Var.e()) - this.f2334b) - vl0Var.d();
                    long jLongValue = lU != null ? lU.longValue() : 0L;
                    String str = "" + ((int) (((jE - jLongValue) / this.f2314a) * 100.0f)) + "%";
                    StringBuilder sb = new StringBuilder();
                    sb.append("#RAM  ");
                    int i = this.f2314a;
                    sb.append(String.valueOf(((i - this.f2334b) * 100) / i));
                    sb.append("% ");
                    sb.append(str);
                    string = sb.toString();
                } else {
                    this.f2334b = (int) (this.f2321a.availMem / 1024.0f);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("#RAM  ");
                    int i2 = this.f2314a;
                    sb2.append(String.valueOf(((i2 - this.f2334b) * 100) / i2));
                    sb2.append("%");
                    string = sb2.toString();
                }
                this.f2325a = z(string);
                SpannableString spannableString = this.f2325a;
                f92.b(spannableString);
                return spannableString;
            }
        }
        SpannableString spannableString2 = this.f2325a;
        return spannableString2 != null ? spannableString2 : "";
    }

    public final void r(boolean z) {
        View view;
        w();
        if (f92.a(f2312a, Boolean.TRUE) && (view = b) != null) {
            try {
                WindowManager windowManager = f2311a;
                if (windowManager != null) {
                    windowManager.removeViewImmediate(view);
                }
            } catch (Exception unused) {
            }
            b = null;
            f2312a = Boolean.FALSE;
        }
        if (z) {
            Scene.f4798a.k(hz0.f1282a.i0(), false);
        }
    }

    @SuppressLint({"ApplySharedPref", "ClickableViewAccessibility"})
    public final View t(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(2131558562, (ViewGroup) null);
        viewInflate.findViewById(t61.fw_gpu);
        viewInflate.findViewById(t61.fw_battery);
        this.f2329a = (FloatMonitorChartView) viewInflate.findViewById(t61.fw_cpu_load);
        this.f2336b = (FloatMonitorChartView) viewInflate.findViewById(t61.fw_gpu_load);
        this.f2328a = (FloatMonitorBatteryView) viewInflate.findViewById(t61.fw_battery_chart);
        this.f2327a = (TextView) viewInflate.findViewById(t61.fw_cpu_freq);
        this.f2335b = (TextView) viewInflate.findViewById(t61.fw_gpu_freq);
        this.f2338c = (TextView) viewInflate.findViewById(t61.fw_battery_temp);
        this.f2340d = (TextView) viewInflate.findViewById(t61.fw_battery_level);
        TextView textView = (TextView) viewInflate.findViewById(t61.fw_other_info);
        File file = new File("/system/fonts/DroidSansMono.ttf");
        if (file.exists()) {
            textView.setTypeface(Typeface.createFromFile(file));
        }
        m42 m42Var = m42.f6769a;
        this.f2341e = textView;
        m92 m92Var = new m92();
        m92Var.f6785a = 0L;
        viewInflate.setOnClickListener(new jx1(m92Var, this));
        m42 m42Var2 = m42.f6769a;
        this.f2326a = viewInflate;
        Object systemService = context.getSystemService("activity");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
        }
        this.f2322a = (ActivityManager) systemService;
        View view = this.f2326a;
        f92.b(view);
        return view;
    }

    public final boolean u() {
        Boolean bool = f2312a;
        f92.b(bool);
        if (bool.booleanValue()) {
            return true;
        }
        Scene.f4798a.k(hz0.f1282a.i0(), true);
        if (this.f2324a == null) {
            Object systemService = this.f2323a.getSystemService("batterymanager");
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.os.BatteryManager");
            }
            this.f2324a = (BatteryManager) systemService;
        }
        if (Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(this.f2323a)) {
            Context context = this.f2323a;
            Toast.makeText(context, context.getString(u61.permission_float), 1).show();
            return false;
        }
        f2312a = Boolean.TRUE;
        Object systemService2 = this.f2323a.getSystemService("window");
        if (systemService2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
        }
        f2311a = (WindowManager) systemService2;
        View viewT = t(this.f2323a);
        SharedPreferences sharedPreferences = this.f2323a.getSharedPreferences("monitor", 0);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.type = 2003;
        layoutParams.type = Build.VERSION.SDK_INT >= 26 ? 2038 : 2003;
        layoutParams.format = -3;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.gravity = 8388659;
        layoutParams.x = sharedPreferences.getInt("basic_x", 0);
        layoutParams.y = sharedPreferences.getInt("basic_y", 0);
        layoutParams.flags = 1064;
        if (Build.VERSION.SDK_INT >= 28) {
            layoutParams.layoutInDisplayCutoutMode = 1;
        }
        try {
            WindowManager windowManager = f2311a;
            f92.b(windowManager);
            windowManager.addView(viewT, layoutParams);
            b = viewT;
            viewT.setOnTouchListener(new kx1(layoutParams, sharedPreferences));
            v();
            return true;
        } catch (Exception e) {
            Scene.c.p(Scene.f4798a, "FloatMonitor Error\n" + e.getMessage(), 0, 2, null);
            return false;
        }
    }

    public final void v() {
        w();
        Timer timer = new Timer("FloatMonitor");
        f2313a = timer;
        f92.b(timer);
        timer.schedule(new mx1(this), 0L, this.f2339c ? 200L : 1000L);
    }

    public final void w() {
        Timer timer = f2313a;
        if (timer != null) {
            f92.b(timer);
            timer.cancel();
            f2313a = null;
        }
    }

    public final String x(String str) {
        if (str == null) {
            return "";
        }
        if (str.length() <= 3) {
            return str.length() == 0 ? "0" : str;
        }
        String strSubstring = str.substring(0, str.length() - 3);
        f92.c(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v14, types: [double] */
    /* JADX WARN: Type inference failed for: r13v15 */
    /* JADX WARN: Type inference failed for: r13v16 */
    /* JADX WARN: Type inference failed for: r13v17 */
    /* JADX WARN: Type inference failed for: r13v18 */
    /* JADX WARN: Type inference failed for: r13v25 */
    /* JADX WARN: Type inference failed for: r13v26 */
    /* JADX WARN: Type inference failed for: r13v27 */
    /* JADX WARN: Type inference failed for: r13v28 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Type inference failed for: r27v1, types: [java.lang.Number] */
    /* JADX WARN: Type inference failed for: r29v0 */
    /* JADX WARN: Type inference failed for: r29v1 */
    /* JADX WARN: Type inference failed for: r29v10 */
    /* JADX WARN: Type inference failed for: r29v11 */
    /* JADX WARN: Type inference failed for: r29v2, types: [double] */
    /* JADX WARN: Type inference failed for: r29v3 */
    /* JADX WARN: Type inference failed for: r29v4 */
    /* JADX WARN: Type inference failed for: r29v5 */
    /* JADX WARN: Type inference failed for: r29v6 */
    /* JADX WARN: Type inference failed for: r29v7 */
    /* JADX WARN: Type inference failed for: r29v8 */
    /* JADX WARN: Type inference failed for: r29v9 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.lang.Double] */
    public final /* synthetic */ Object y(b62<? super m42> b62Var) {
        j92 j92Var;
        String str;
        String str2;
        Iterator it;
        boolean z;
        String str3;
        String str4;
        ?? r29;
        String str5;
        String str6;
        int i;
        int i2;
        ox1 ox1Var = this;
        int i3 = ox1Var.e + 1;
        ox1Var.e = i3;
        ox1Var.e = i3 % 3;
        int i4 = 0;
        if (ox1Var.c < 1) {
            ox1Var.c = ox1Var.f2317a.h();
            ArrayList<String[]> arrayListF = ox1Var.f2317a.f();
            f92.c(arrayListF, "cpuUtil.clusterInfo");
            ox1Var.f2330a = arrayListF;
            int i5 = ox1Var.c;
            Integer[] numArr = new Integer[i5];
            for (int i6 = 0; i6 < i5; i6++) {
                t62.e(i6).intValue();
                numArr[i6] = t62.e(0);
            }
            int size = ox1Var.f2330a.size();
            Double[] dArr = new Double[size];
            for (int i7 = 0; i7 < size; i7++) {
                t62.e(i7).intValue();
                dArr[i7] = t62.c(0.0d);
            }
            ox1Var.f2332a = dArr;
            int size2 = ox1Var.f2330a.size();
            Integer[] numArr2 = new Integer[size2];
            for (int i8 = 0; i8 < size2; i8++) {
                t62.e(i8).intValue();
                numArr2[i8] = t62.e(0);
            }
            ox1Var.f2333a = numArr2;
        }
        cm0 cm0VarF = ox1Var.f2337b ? ox1Var.f2315a.f() : ox1Var.f2315a.h();
        if (cm0VarF == null) {
            return cm0VarF == r62.c() ? cm0VarF : m42.f6769a;
        }
        Double[] dArrB = cm0VarF.b();
        StringBuilder sb = new StringBuilder();
        String str7 = "";
        sb.append("");
        sb.append(cm0VarF.d());
        String str8 = "MHz";
        sb.append("MHz");
        String string = sb.toString();
        int iE = cm0VarF.e();
        Iterator it2 = ox1Var.f2330a.iterator();
        int i9 = 0;
        int i10 = 0;
        while (it2.hasNext()) {
            String[] strArr = (String[]) it2.next();
            int iIntValue = cm0VarF.a()[i10].intValue();
            int length = strArr.length;
            double dMax = 0.0d;
            while (i4 < length) {
                dMax = Math.max(dMax, dArrB[Integer.parseInt(strArr[i4])].doubleValue());
                i4++;
                iE = iE;
                it2 = it2;
            }
            int i11 = iE;
            Iterator it3 = it2;
            if (i9 == 0 || dMax >= 2) {
                i2 = iIntValue;
                if (i2 > i9) {
                    i9 = i2;
                }
            } else {
                i2 = iIntValue;
            }
            Integer[] numArr3 = ox1Var.f2333a;
            if (numArr3 == null) {
                f92.m("clustersFreq");
                throw null;
            }
            numArr3[i10] = t62.e(i2);
            Double[] dArr2 = ox1Var.f2332a;
            if (dArr2 == null) {
                f92.m("clustersLoad");
                throw null;
            }
            dArr2[i10] = t62.c(dMax);
            i10++;
            iE = i11;
            it2 = it3;
            i4 = 0;
        }
        int i12 = iE;
        String strValueOf = String.valueOf(i9);
        j92 j92Var2 = new j92();
        double dDoubleValue = 0.0d;
        for (Double d : dArrB) {
            dDoubleValue += t62.c(d.doubleValue()).doubleValue();
        }
        double length2 = dDoubleValue / ((double) dArrB.length);
        j92Var2.f6490a = length2;
        double d2 = 0;
        if (length2 < d2) {
            j92Var2.f6490a = 0.0d;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (ox1Var.f2337b && (cm0VarF instanceof am0)) {
            boolean z2 = ox1Var.f2331a && ((am0) cm0VarF).k().length >= ox1Var.c;
            spannableStringBuilder.append(q());
            am0 am0Var = (am0) cm0VarF;
            int iM = am0Var.m();
            if (iM > -1) {
                spannableStringBuilder.append((CharSequence) "\n DDR  ");
                spannableStringBuilder.append((CharSequence) String.valueOf(iM));
            }
            String str9 = "\n";
            spannableStringBuilder.append((CharSequence) "\n");
            String strI = ox1Var.f2339c ? ox1Var.f2318a.i() : null;
            if (strI != null) {
                str2 = string;
                StringBuilder sb2 = new StringBuilder();
                str = strValueOf;
                sb2.append("#GMEM ");
                sb2.append(strI);
                spannableStringBuilder.append((CharSequence) ox1Var.z(sb2.toString()));
                spannableStringBuilder.append((CharSequence) "\n");
            } else {
                str = strValueOf;
                str2 = string;
            }
            double dL = am0Var.l();
            j92Var = j92Var2;
            if (!f92.a(d22.f5853a.a(), t62.a(true))) {
                spannableStringBuilder.append((CharSequence) ox1Var.z("#CPU  " + dL + (char) 8451));
                spannableStringBuilder.append((CharSequence) "\n");
            }
            Iterator it4 = ox1Var.f2330a.iterator();
            int i13 = 0;
            ?? r6 = dArrB;
            ?? r13 = d2;
            while (it4.hasNext()) {
                String[] strArr2 = (String[]) it4.next();
                if (i13 != 0) {
                    spannableStringBuilder.append((CharSequence) str9);
                }
                if (!(strArr2.length == 0)) {
                    try {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("#");
                        it = it4;
                        try {
                            sb3.append(strArr2[0]);
                            sb3.append("~");
                            sb3.append(strArr2[strArr2.length - 1]);
                            sb3.append("  ");
                            Integer[] numArr4 = ox1Var.f2333a;
                            if (numArr4 == null) {
                                z = z2;
                                str3 = str7;
                                str4 = str8;
                                r29 = r13;
                                r13 = r6;
                                str5 = str9;
                                f92.m("clustersFreq");
                                throw null;
                            }
                            sb3.append(numArr4[i13].intValue() / 1000);
                            sb3.append(str8);
                            spannableStringBuilder.append((CharSequence) ox1Var.z(sb3.toString()));
                            StringBuilder sb4 = new StringBuilder(str7);
                            if (z2) {
                                z = z2;
                                try {
                                    int length3 = strArr2.length;
                                    str3 = str7;
                                    int i14 = 0;
                                    r13 = r13;
                                    while (i14 < length3) {
                                        try {
                                            str6 = strArr2[i14];
                                            sb4.append(str9);
                                            str4 = str8;
                                        } catch (Exception unused) {
                                            str4 = str8;
                                            r29 = r13;
                                            str5 = str9;
                                            r13 = r6;
                                            i13++;
                                            ox1Var = this;
                                            r6 = r13;
                                            str9 = str5;
                                            it4 = it;
                                            z2 = z;
                                            str7 = str3;
                                            str8 = str4;
                                            r13 = r29;
                                        }
                                        try {
                                            double dDoubleValue2 = r6[Integer.parseInt(str6)].doubleValue();
                                            if (dDoubleValue2 >= r13) {
                                                i = length3;
                                                r29 = r13;
                                                str5 = str9;
                                                if (dDoubleValue2 < 10) {
                                                    try {
                                                        sb4.append("  ");
                                                    } catch (Exception unused2) {
                                                        r13 = r6;
                                                        i13++;
                                                        ox1Var = this;
                                                        r6 = r13;
                                                        str9 = str5;
                                                        it4 = it;
                                                        z2 = z;
                                                        str7 = str3;
                                                        str8 = str4;
                                                        r13 = r29;
                                                    }
                                                } else if (dDoubleValue2 < 100) {
                                                    sb4.append(" ");
                                                }
                                                sb4.append((int) dDoubleValue2);
                                                sb4.append("%  ");
                                                if (cm0VarF == null) {
                                                    throw new NullPointerException("null cannot be cast to non-null type com.omarea.library.shell.Monitor.MonitorFullData");
                                                }
                                                sb4.append(((am0) cm0VarF).k()[Integer.parseInt(str6)].intValue() / 1000);
                                                sb4.append("M");
                                            } else {
                                                i = length3;
                                                r29 = r13;
                                                str5 = str9;
                                                sb4.append("  ×");
                                            }
                                            i14++;
                                            str9 = str5;
                                            length3 = i;
                                            str8 = str4;
                                            r13 = r29;
                                        } catch (Exception unused3) {
                                            r29 = r13;
                                            str5 = str9;
                                            r13 = r6;
                                            i13++;
                                            ox1Var = this;
                                            r6 = r13;
                                            str9 = str5;
                                            it4 = it;
                                            z2 = z;
                                            str7 = str3;
                                            str8 = str4;
                                            r13 = r29;
                                        }
                                    }
                                    str4 = str8;
                                    r29 = r13;
                                    str5 = str9;
                                } catch (Exception unused4) {
                                    str3 = str7;
                                }
                            } else {
                                z = z2;
                                str3 = str7;
                                str4 = str8;
                                r29 = r13;
                                str5 = str9;
                                int length4 = strArr2.length;
                                int i15 = 0;
                                r6 = r6;
                                r13 = r13;
                                while (i15 < length4) {
                                    String str10 = strArr2[i15];
                                    sb4.append("\nCPU");
                                    sb4.append(str10);
                                    sb4.append("  ");
                                    double dDoubleValue3 = r6[Integer.parseInt(str10)].doubleValue();
                                    int i16 = length4;
                                    ?? r132 = r6;
                                    if (dDoubleValue3 >= r29) {
                                        if (dDoubleValue3 < 10) {
                                            sb4.append(" ");
                                        }
                                        sb4.append((int) dDoubleValue3);
                                        sb4.append("%");
                                    } else {
                                        sb4.append("  ×");
                                    }
                                    i15++;
                                    r6 = r132;
                                    length4 = i16;
                                    r13 = r132;
                                }
                            }
                            try {
                                r13 = r6;
                                spannableStringBuilder.append((CharSequence) sb4.toString());
                            } catch (Exception unused5) {
                            }
                        } catch (Exception unused6) {
                            z = z2;
                            str3 = str7;
                            str4 = str8;
                            r29 = r13;
                            r13 = r6;
                            str5 = str9;
                        }
                    } catch (Exception unused7) {
                        it = it4;
                    }
                } else {
                    it = it4;
                    z = z2;
                    str3 = str7;
                    str4 = str8;
                    r29 = r13;
                    r13 = r6;
                    str5 = str9;
                }
                i13++;
                ox1Var = this;
                r6 = r13;
                str9 = str5;
                it4 = it;
                z2 = z;
                str7 = str3;
                str8 = str4;
                r13 = r29;
            }
            String str11 = str9;
            double dC = cm0VarF.c();
            spannableStringBuilder.append((CharSequence) str11);
            q92 q92Var = q92.f7191a;
            String str12 = String.format("#FPS  " + dC, Arrays.copyOf(new Object[0], 0));
            f92.c(str12, "java.lang.String.format(format, *args)");
            spannableStringBuilder.append((CharSequence) z(str12));
            spannableStringBuilder.append((CharSequence) str11);
            spannableStringBuilder.append((CharSequence) z("#PWR  " + fa0.f867a.n()));
        } else {
            j92Var = j92Var2;
            str = strValueOf;
            str2 = string;
        }
        fa0.z(fa0.f867a, 0L, 1, null);
        Scene.f4798a.i(new nx1(this, spannableStringBuilder, j92Var, str, str2, i12, fa0.f867a.o()));
        return m42.f6769a;
    }

    public final SpannableString z(String str) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(-1), 0, str.length(), 33);
        spannableString.setSpan(new StyleSpan(1), 0, str.length(), 33);
        return spannableString;
    }
}
