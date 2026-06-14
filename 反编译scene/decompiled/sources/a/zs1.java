package a;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.omarea.Scene;
import com.omarea.common.ui.OverScrollGridView;
import com.omarea.ui.BlurViewLinearLayout;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Timer;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class zs1 extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ActivityManager f3879a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public BatteryManager f3880a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HashMap f3881a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Timer f3882a;
    public int g;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public kl0 f3875a = new kl0();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final xl0 f3877a = new xl0();
    public String d = "" + Scene.f4798a.h("gpu_info", "");
    public final boolean t = f92.a(e50.f677a.y0(), "basic");

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final z32 f3878a = a42.a(new qs1(this));
    public final int f = new sr1(this, Scene.f4798a.c(), "CoreCount").i();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final rm0 f3876a = new rm0(Scene.f4798a.c());
    public final z32 b = a42.a(ur1.f7625a);
    public final z32 c = a42.a(new ps1(this));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public em0 f8094a = new em0();

    @Override // androidx.fragment.app.Fragment
    @SuppressLint({"ClickableViewAccessibility"})
    public void D0(View view, Bundle bundle) {
        f92.d(view, "view");
        super.D0(view, bundle);
        Context contextP = p();
        f92.b(contextP);
        Object systemService = contextP.getSystemService("activity");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
        }
        this.f3879a = (ActivityManager) systemService;
        Context contextP2 = p();
        f92.b(contextP2);
        Object systemService2 = contextP2.getSystemService("batterymanager");
        if (systemService2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.os.BatteryManager");
        }
        this.f3880a = (BatteryManager) systemService2;
        ((ImageButton) w1(t61.home_memory_clear)).setOnClickListener(new cs1(this));
        ((ImageButton) w1(t61.home_memory_compact)).setOnClickListener(new es1(this));
        ((ImageButton) w1(t61.home_memory_compact)).setOnLongClickListener(new gs1(this));
        ((LinearLayout) w1(t61.home_help)).setOnClickListener(new hs1(this));
        ((ImageView) w1(t61.home_battery_edit)).setOnClickListener(new is1(this));
        ((OverScrollGridView) w1(t61.cpu_core_list)).setOnItemClickListener(new js1(this));
        qc2.d(xd2.a(qe2.c()), null, null, new ls1(this, null), 3, null);
        ListView listView = (ListView) w1(t61.home_process_list);
        Context context = listView.getContext();
        f92.b(context);
        f21 f21Var = new f21(context, null, null, 0, 0, 30, null);
        f21Var.m(1);
        m42 m42Var = m42.f6769a;
        listView.setAdapter((ListAdapter) f21Var);
        listView.setOnTouchListener(new xr1(this));
        listView.setOnItemClickListener(new yr1(listView, this));
        TextView textView = (TextView) w1(t61.home_device_name);
        f92.c(textView, "home_device_name");
        textView.setText(tj0.f7508a.c(Build.VERSION.SDK_INT));
        if (f92.a(e50.f677a.y0(), "root")) {
            ((BlurViewLinearLayout) w1(t61.home_memory)).setOnClickListener(new ms1(this));
            ((RelativeLayout) w1(t61.home_cpu)).setOnClickListener(new as1(this));
        } else {
            ImageButton imageButton = (ImageButton) w1(t61.home_memory_clear);
            f92.c(imageButton, "home_memory_clear");
            imageButton.setVisibility(8);
            ImageButton imageButton2 = (ImageButton) w1(t61.home_memory_compact);
            f92.c(imageButton2, "home_memory_compact");
            imageButton2.setVisibility(8);
        }
        ((BlurViewLinearLayout) w1(t61.home_battery)).setOnClickListener(new bs1(this));
    }

    public final int I1(float f) {
        Context contextP = p();
        f92.b(contextP);
        f92.c(contextP, "context!!");
        Resources resources = contextP.getResources();
        f92.c(resources, "context!!.resources");
        return (int) ((f * resources.getDisplayMetrics().density) + 0.5f);
    }

    public final void J1() {
        s60.f7366a.a("sync\necho 3 > /proc/sys/vm/drop_caches\necho 1 > /proc/sys/vm/compact_memory");
    }

    public final String K1() {
        long jElapsedRealtime = SystemClock.elapsedRealtime() / ((long) 1000);
        q92 q92Var = q92.f7191a;
        long j = 3600;
        long j2 = 60;
        String str = String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(jElapsedRealtime / j), Long.valueOf((jElapsedRealtime % j) / j2), Long.valueOf(jElapsedRealtime % j2)}, 3));
        f92.c(str, "java.lang.String.format(format, *args)");
        return str;
    }

    public final /* synthetic */ Object L1(int i, b62<? super String> b62Var) {
        return oc2.g(qe2.a(), new tr1(this, i, null), b62Var);
    }

    public final String M1(double d) {
        BigDecimal scale = new BigDecimal(d).setScale(1, RoundingMode.HALF_UP);
        f92.c(scale, "bd.setScale(1, RoundingMode.HALF_UP)");
        String string = scale.toString();
        f92.c(string, "bd.toString()");
        return string;
    }

    public final boolean N1() {
        return ((Boolean) this.b.getValue()).booleanValue();
    }

    public final String O1() {
        return (String) this.c.getValue();
    }

    public final fn0 P1() {
        return (fn0) this.f3878a.getValue();
    }

    public final void Q1() {
        g91 g91Var = (g91) j();
        if (g91Var != null) {
            ArrayList arrayList = new ArrayList();
            int i = this.f;
            for (int i2 = 0; i2 < i; i2++) {
                n30 n30Var = new n30();
                n30Var.i("CPU " + i2);
                n30Var.j("" + i2);
                n30Var.h(this.f3875a.i(i2));
                m42 m42Var = m42.f6769a;
                arrayList.add(n30Var);
            }
            b90 b90Var = new b90(g91Var.getThemeMode().a(), arrayList, true, new os1(this, g91Var), 999);
            String strJ = J(u61.home_core_switch);
            f92.c(strJ, "getString(R.string.home_core_switch)");
            b90Var.K1(strJ);
            b90Var.B1(g91Var.getSupportFragmentManager(), "home-cpu-control");
        }
    }

    public final void R1() {
        Timer timer = this.f3882a;
        if (timer != null) {
            this.g = 0;
            f92.b(timer);
            timer.cancel();
            this.f3882a = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    @android.annotation.SuppressLint({"SetTextI18n"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final /* synthetic */ java.lang.Object S1(a.b62<? super a.m42> r31) {
        /*
            Method dump skipped, instruction units count: 436
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.zs1.S1(a.b62):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    @android.annotation.SuppressLint({"SetTextI18n"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final /* synthetic */ java.lang.Object T1(a.b62<? super a.m42> r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            boolean r2 = r1 instanceof a.vs1
            if (r2 == 0) goto L17
            r2 = r1
            a.vs1 r2 = (a.vs1) r2
            int r3 = r2.f7721a
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.f7721a = r3
            goto L1c
        L17:
            a.vs1 r2 = new a.vs1
            r2.<init>(r0, r1)
        L1c:
            java.lang.Object r1 = r2.f3303a
            java.lang.Object r3 = a.r62.c()
            int r4 = r2.f7721a
            r5 = 1
            if (r4 == 0) goto L3a
            if (r4 != r5) goto L32
            java.lang.Object r2 = r2.b
            a.zs1 r2 = (a.zs1) r2
            a.h42.b(r1)     // Catch: java.lang.Exception -> Laf
            r7 = r2
            goto L4b
        L32:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L3a:
            a.h42.b(r1)
            a.xl0 r1 = r0.f3877a     // Catch: java.lang.Exception -> Laf
            r2.b = r0     // Catch: java.lang.Exception -> Laf
            r2.f7721a = r5     // Catch: java.lang.Exception -> Laf
            java.lang.Object r1 = r1.b(r2)     // Catch: java.lang.Exception -> Laf
            if (r1 != r3) goto L4a
            return r3
        L4a:
            r7 = r0
        L4b:
            r8 = r1
            a.vl0 r8 = (a.vl0) r8     // Catch: java.lang.Exception -> Laf
            android.app.ActivityManager$MemoryInfo r1 = new android.app.ActivityManager$MemoryInfo     // Catch: java.lang.Exception -> Laf
            r1.<init>()     // Catch: java.lang.Exception -> Laf
            android.app.ActivityManager r2 = r7.f3879a     // Catch: java.lang.Exception -> Laf
            if (r2 == 0) goto La8
            r2.getMemoryInfo(r1)     // Catch: java.lang.Exception -> Laf
            long r2 = r1.totalMem     // Catch: java.lang.Exception -> Laf
            r4 = 1024(0x400, float:1.435E-42)
            long r9 = (long) r4     // Catch: java.lang.Exception -> Laf
            long r2 = r2 / r9
            int r4 = r8.a()     // Catch: java.lang.Exception -> Laf
            int r6 = r8.c()     // Catch: java.lang.Exception -> Laf
            int r4 = r4 + r6
            long r13 = (long) r4     // Catch: java.lang.Exception -> Laf
            long r11 = r1.availMem     // Catch: java.lang.Exception -> Laf
            long r15 = r11 / r9
            boolean r1 = r7.N1()     // Catch: java.lang.Exception -> Laf
            if (r1 == 0) goto L85
            a.e50 r1 = a.e50.f677a     // Catch: java.lang.Exception -> Laf
            java.lang.String r1 = r1.y0()     // Catch: java.lang.Exception -> Laf
            java.lang.String r4 = "basic"
            boolean r1 = a.f92.a(r1, r4)     // Catch: java.lang.Exception -> Laf
            r1 = r1 ^ r5
            if (r1 == 0) goto L85
            r11 = r13
            goto L86
        L85:
            r11 = r15
        L86:
            int r1 = r8.e()     // Catch: java.lang.Exception -> Laf
            int r4 = r8.d()     // Catch: java.lang.Exception -> Laf
            int r17 = r1 - r4
            a.fn0 r1 = r7.P1()     // Catch: java.lang.Exception -> Laf
            java.lang.Long r18 = r1.u()     // Catch: java.lang.Exception -> Laf
            com.omarea.Scene$c r1 = com.omarea.Scene.f4798a     // Catch: java.lang.Exception -> Laf
            a.ys1 r4 = new a.ys1     // Catch: java.lang.Exception -> Laf
            r6 = r4
            r9 = r2
            r2 = r13
            r13 = r15
            r15 = r2
            r6.<init>(r7, r8, r9, r11, r13, r15, r17, r18)     // Catch: java.lang.Exception -> Laf
            r1.i(r4)     // Catch: java.lang.Exception -> Laf
            goto Laf
        La8:
            java.lang.String r1 = "activityManager"
            a.f92.m(r1)     // Catch: java.lang.Exception -> Laf
            r1 = 0
            throw r1
        Laf:
            a.m42 r1 = a.m42.f6769a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a.zs1.T1(a.b62):java.lang.Object");
    }

    @Override // androidx.fragment.app.Fragment
    public View i0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        f92.d(layoutInflater, "inflater");
        return layoutInflater.inflate(2131558553, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void l0() {
        super.l0();
        v1();
    }

    @Override // androidx.fragment.app.Fragment
    public void u0() {
        R1();
        super.u0();
    }

    public void v1() {
        HashMap map = this.f3881a;
        if (map != null) {
            map.clear();
        }
    }

    public View w1(int i) {
        if (this.f3881a == null) {
            this.f3881a = new HashMap();
        }
        View view = (View) this.f3881a.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewM = M();
        if (viewM == null) {
            return null;
        }
        View viewFindViewById = viewM.findViewById(i);
        this.f3881a.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    @Override // androidx.fragment.app.Fragment
    public void z0() {
        super.z0();
        if (R()) {
            return;
        }
        cl clVarJ = j();
        f92.b(clVarJ);
        f92.c(clVarJ, "activity!!");
        clVarJ.setTitle(J(u61.app_name));
        R1();
        this.g = 0;
        Timer timer = new Timer("HomeMonitor");
        timer.schedule(new wr1(this), 0L, 1500L);
        m42 m42Var = m42.f6769a;
        this.f3882a = timer;
    }
}
