package a;

import android.content.ContentResolver;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;
import com.omarea.Scene;
import com.omarea.model.SceneConfigInfo;
import com.omarea.vtools.AccessibilitySceneMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class tw0 {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static volatile tw0 f3071a = null;
    public static String c = "";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f3072a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public fz0 f3073a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final j12 f3074a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ContentResolver f3075a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SceneConfigInfo f3076a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final AccessibilitySceneMode f3077a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f3078a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<uw0> f3079a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f3080a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f3081b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f3082b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public int f3083c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final a f3070a = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static nb2 f7540a = new nb2("^[A-Za-z0-9._]+$");
    public static final nb2 b = new nb2(" +");

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(b92 b92Var) {
            this();
        }

        public final void a(String str) {
            StringBuilder sb;
            String str2;
            f92.d(str, "app");
            if (tw0.f7540a.f(str)) {
                if (f92.a(str, "com.android.vending")) {
                    ql0.b(new ql0(), null, 1, null);
                    return;
                }
                s60 s60Var = s60.f7366a;
                if (f92.a(e50.f677a.y0(), "adb")) {
                    sb = new StringBuilder();
                    str2 = "pm disable-user ";
                } else {
                    sb = new StringBuilder();
                    str2 = "pm disable ";
                }
                sb.append(str2);
                sb.append(str);
                sb.append(" 2>/dev/null");
                s60Var.a(sb.toString());
            }
        }

        public final tw0 b() {
            return tw0.f3071a;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final /* synthetic */ java.lang.Object c(a.b62<? super java.util.ArrayList<java.lang.String>> r18) {
            /*
                Method dump skipped, instruction units count: 294
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: a.tw0.a.c(a.b62):java.lang.Object");
        }

        public final tw0 d(AccessibilitySceneMode accessibilitySceneMode, fz0 fz0Var) {
            tw0 tw0Var;
            f92.d(accessibilitySceneMode, "context");
            f92.d(fz0Var, "store");
            if (tw0.f3071a != null && (tw0Var = tw0.f3071a) != null) {
                tw0Var.o();
            }
            tw0.f3071a = new tw0(accessibilitySceneMode, fz0Var, null);
            tw0 tw0Var2 = tw0.f3071a;
            f92.b(tw0Var2);
            return tw0Var2;
        }

        public final void e(String str) {
            f92.d(str, "app");
            if (tw0.f7540a.f(str)) {
                if (f92.a(str, "com.android.vending")) {
                    ql0.b(new ql0(), null, 1, null);
                    return;
                }
                s60.f7366a.a("pm suspend " + str + "\nam force-stop " + str + " || am kill current " + str);
            }
        }

        public final void f(String str) {
            f92.d(str, "app");
            if (tw0.f7540a.f(str)) {
                tw0 tw0VarB = b();
                if (tw0VarB != null) {
                    tw0VarB.F(str);
                }
                if (f92.a(str, "com.android.vending") || f92.a(str, "com.google.android.googlequicksearchbox")) {
                    new ql0().c(str);
                }
                s60.f7366a.a("pm unsuspend " + str + "\nsu 1000 -c 'pm unsuspend " + str + "' 2>/dev/null\npm enable " + str);
            }
        }
    }

    public tw0(AccessibilitySceneMode accessibilitySceneMode, fz0 fz0Var) {
        this.f3077a = accessibilitySceneMode;
        this.f3073a = fz0Var;
        this.f3078a = "com.android.systemui";
        ContentResolver contentResolver = accessibilitySceneMode.getContentResolver();
        f92.c(contentResolver, "context.contentResolver");
        this.f3075a = contentResolver;
        this.f3079a = new ArrayList<>();
        this.f3074a = new j12(this.f3077a);
        this.f3072a = -1;
        this.f3081b = -1;
        this.f3082b = "none";
        this.f3083c = -1;
    }

    public /* synthetic */ tw0(AccessibilitySceneMode accessibilitySceneMode, fz0 fz0Var, b92 b92Var) {
        this(accessibilitySceneMode, fz0Var);
    }

    public static /* synthetic */ void v(tw0 tw0Var, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        tw0Var.u(str, z);
    }

    public final void A() {
        I();
    }

    public final uw0 B(String str) {
        f92.d(str, "packageName");
        for (uw0 uw0Var : this.f3079a) {
            if (f92.a(uw0Var.b(), str)) {
                this.f3079a.remove(uw0Var);
                return uw0Var;
            }
        }
        return null;
    }

    public final void C() {
        try {
            if (this.f3083c > -1) {
                Settings.Global.putInt(this.f3075a, "heads_up_notifications_enabled", this.f3083c);
                this.f3075a.notifyChange(Settings.System.getUriFor("heads_up_notifications_enabled"), null);
                this.f3083c = -1;
            }
        } catch (Exception unused) {
        }
    }

    public final void D() {
        if (!f92.a(this.f3082b, "none")) {
            if (!ec2.C(this.f3082b, "gps", false, 2, null)) {
                if (ec2.C(this.f3082b, "network", false, 2, null)) {
                    new tl0().a();
                } else {
                    new tl0().b();
                }
            }
            this.f3082b = "none";
        }
    }

    public final void E() {
        try {
            int i = this.f3072a;
            if (i > -1) {
                Settings.System.putInt(this.f3075a, "screen_brightness_mode", i);
                this.f3075a.notifyChange(Settings.System.getUriFor("screen_brightness_mode"), null);
            }
            this.f3072a = -1;
            if (this.f3081b > -1 && i == 0) {
                Settings.System.putInt(this.f3075a, "screen_brightness", this.f3081b);
                this.f3075a.notifyChange(Settings.System.getUriFor("screen_brightness"), null);
            }
            this.f3081b = -1;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void F(String str) {
        f92.d(str, "packageName");
        uw0 uw0VarB = B(str);
        if (uw0VarB == null) {
            uw0VarB = new uw0();
        }
        uw0VarB.c(System.currentTimeMillis());
        uw0VarB.d(str);
        this.f3079a.add(uw0VarB);
    }

    public final void G(String str) {
        f92.d(str, "packageName");
        B(str);
        uw0 uw0Var = new uw0();
        uw0Var.e(System.currentTimeMillis());
        uw0Var.c(-1L);
        uw0Var.d(str);
        this.f3079a.add(uw0Var);
    }

    public final void H() {
        if (this.f3078a.length() == 0) {
            return;
        }
        u(this.f3078a, true);
    }

    public final void I() {
        SceneConfigInfo sceneConfigInfo = this.f3076a;
        if (sceneConfigInfo != null) {
            this.f3074a.g(sceneConfigInfo);
        }
    }

    public final boolean i(int i) {
        try {
            if (Settings.System.putInt(this.f3075a, "screen_brightness_mode", 0)) {
                this.f3075a.notifyChange(Settings.System.getUriFor("screen_brightness_mode"), null);
                if (i > -1 && Settings.System.putInt(this.f3075a, "screen_brightness", i)) {
                    this.f3075a.notifyChange(Settings.System.getUriFor("screen_brightness"), null);
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public final int j() {
        if (this.f3072a == -1) {
            try {
                this.f3072a = Settings.System.getInt(this.f3075a, "screen_brightness_mode");
                this.f3081b = Settings.System.getInt(this.f3075a, "screen_brightness");
            } catch (Settings.SettingNotFoundException e) {
                e.printStackTrace();
            }
        }
        return this.f3072a;
    }

    public final void k() {
        if (this.f3083c < 0) {
            try {
                this.f3083c = Settings.Global.getInt(this.f3075a, "heads_up_notifications_enabled");
            } catch (Exception unused) {
            }
        }
    }

    public final void l() {
        String string;
        if (f92.a(this.f3082b, "none")) {
            if (Build.VERSION.SDK_INT >= 30) {
                string = f92.a(Settings.Secure.getString(this.f3075a, "location_mode"), "3") ? "gps" : "";
            } else {
                string = Settings.Secure.getString(this.f3075a, "location_providers_allowed");
                f92.c(string, "Settings.Secure.getStrin…CATION_PROVIDERS_ALLOWED)");
            }
            this.f3082b = string;
        }
    }

    public final void m() {
        if (c.length() > 0) {
            qc2.d(xd2.a(qe2.b()), null, null, new zw0(null), 3, null);
        }
    }

    public final void n() {
        int iR = r();
        if (iR <= 0 || !(!this.f3079a.isEmpty())) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        ArrayList<uw0> arrayList = this.f3079a;
        ArrayList<uw0> arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            uw0 uw0Var = (uw0) obj;
            if (uw0Var.a() > ((long) (-1)) && jCurrentTimeMillis - uw0Var.a() > ((long) iR) && (f92.a(uw0Var.b(), this.f3078a) ^ true)) {
                arrayList2.add(obj);
            }
        }
        if (!arrayList2.isEmpty()) {
            String[] strArrR = this.f3077a.r();
            for (uw0 uw0Var2 : arrayList2) {
                if (u42.k(strArrR, uw0Var2.b())) {
                    uw0Var2.c(jCurrentTimeMillis);
                } else {
                    q(uw0Var2);
                }
            }
        }
    }

    public final void o() {
        this.f3078a = "com.android.systemui";
        D();
        E();
        this.f3076a = null;
        this.f3074a.f();
        f3071a = null;
    }

    public final boolean p() {
        if (Build.VERSION.SDK_INT >= 30) {
            return f92.a(Settings.Secure.getString(this.f3075a, "location_mode"), "3");
        }
        String string = Settings.Secure.getString(this.f3075a, "location_providers_allowed");
        f92.c(string, "Settings.Secure.getStrin…CATION_PROVIDERS_ALLOWED)");
        return ec2.C(string, "gps", false, 2, null);
    }

    public final void q(uw0 uw0Var) {
        if (this.f3073a.b(uw0Var.b()).freeze) {
            if (t()) {
                f3070a.e(uw0Var.b());
            } else {
                f3070a.a(uw0Var.b());
            }
        }
        this.f3079a.remove(uw0Var);
    }

    public final int r() {
        return Scene.f4798a.g().getInt(hz0.f1282a.N(), 2) * 60 * 1000;
    }

    public final List<String> s() {
        ArrayList arrayList = new ArrayList();
        ArrayList<uw0> arrayList2 = this.f3079a;
        ArrayList arrayList3 = new ArrayList(z42.m(arrayList2, 10));
        Iterator<T> it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(((uw0) it.next()).b());
        }
        arrayList.addAll(arrayList3);
        ArrayList<String> arrayListC = new fz0(this.f3077a).c();
        for (String str : this.f3077a.r()) {
            if (arrayListC.contains(str) && !arrayList.contains(str)) {
                arrayList.add(str);
                G(str);
            }
        }
        return arrayList;
    }

    public final boolean t() {
        return Scene.f4798a.b(hz0.O, Build.VERSION.SDK_INT >= 28);
    }

    public final void u(String str, boolean z) {
        f92.d(str, "packageName");
        if (!f92.a(this.f3078a, str) || z) {
            synchronized (this) {
                try {
                    this.f3078a = str;
                    if (this.f3076a != null) {
                        if (!f92.a(this.f3076a != null ? r12.packageName : null, str)) {
                            SceneConfigInfo sceneConfigInfo = this.f3076a;
                            f92.b(sceneConfigInfo);
                            w(sceneConfigInfo);
                        }
                    }
                    SceneConfigInfo sceneConfigInfoB = this.f3073a.b(str);
                    this.f3076a = sceneConfigInfoB;
                    if (sceneConfigInfoB == null) {
                        D();
                        E();
                        C();
                    } else {
                        f92.b(sceneConfigInfoB);
                        if (sceneConfigInfoB.aloneLight) {
                            j();
                            SceneConfigInfo sceneConfigInfo2 = this.f3076a;
                            f92.b(sceneConfigInfo2);
                            i(sceneConfigInfo2.aloneLightValue);
                        } else {
                            E();
                        }
                        SceneConfigInfo sceneConfigInfo3 = this.f3076a;
                        f92.b(sceneConfigInfo3);
                        if (sceneConfigInfo3.showMonitor) {
                            if (!f92.a(az1.f5657a.a(), Boolean.TRUE)) {
                                Scene.f4798a.i(new ax0(this, str));
                            }
                        } else if (this.f3080a) {
                            Scene.f4798a.i(new bx0(this, str));
                            this.f3080a = false;
                        }
                        SceneConfigInfo sceneConfigInfo4 = this.f3076a;
                        f92.b(sceneConfigInfo4);
                        if (sceneConfigInfo4.gpsOn) {
                            l();
                            if (!p()) {
                                new tl0().c();
                            }
                        } else {
                            D();
                        }
                        SceneConfigInfo sceneConfigInfo5 = this.f3076a;
                        f92.b(sceneConfigInfo5);
                        if (sceneConfigInfo5.disNotice) {
                            try {
                                int i = Settings.Global.getInt(this.f3075a, "heads_up_notifications_enabled");
                                k();
                                if (i != 0) {
                                    Settings.Global.putInt(this.f3075a, "heads_up_notifications_enabled", 0);
                                    this.f3075a.notifyChange(Settings.System.getUriFor("heads_up_notifications_enabled"), null);
                                }
                            } catch (Exception unused) {
                            }
                        } else {
                            C();
                        }
                        SceneConfigInfo sceneConfigInfo6 = this.f3076a;
                        f92.b(sceneConfigInfo6);
                        if (sceneConfigInfo6.freeze) {
                            G(str);
                        }
                        Set<String> setA = new gz0(this.f3077a).a(str);
                        if (!setA.isEmpty()) {
                            s60.f7366a.b(i52.H(setA, "\n", null, null, 0, null, cx0.f5836a, 30, null));
                        }
                    }
                    I();
                    m42 m42Var = m42.f6769a;
                } catch (Exception e) {
                    Log.e(">>>>", "" + e.getMessage());
                }
            }
        }
    }

    public final void w(SceneConfigInfo sceneConfigInfo) {
        if (sceneConfigInfo.freeze) {
            String str = sceneConfigInfo.packageName;
            f92.c(str, "sceneConfigInfo.packageName");
            F(str);
        }
        if (sceneConfigInfo.aloneLight) {
            try {
                int i = Settings.System.getInt(this.f3075a, "screen_brightness");
                if (i != sceneConfigInfo.aloneLightValue) {
                    sceneConfigInfo.aloneLightValue = i;
                    this.f3073a.g(sceneConfigInfo);
                }
            } catch (Exception unused) {
            }
        }
    }

    public final boolean x() {
        SceneConfigInfo sceneConfigInfo = this.f3076a;
        if (sceneConfigInfo == null) {
            return false;
        }
        f92.b(sceneConfigInfo);
        return sceneConfigInfo.disNotice;
    }

    public final void y() {
        this.f3074a.f();
    }

    public final void z() {
    }
}
