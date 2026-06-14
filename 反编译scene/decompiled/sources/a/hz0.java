package a;

import com.omarea.Scene;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class hz0 {
    public static String A = "is_skip_ad";
    public static String B = "is_skip_ad_precise2";
    public static String C = "scene_logview";
    public static String D = "frame_time_monitor";
    public static String E = "layer_always_on";
    public static String F = "app_night_mode";
    public static String G = "app_theme5";
    public static String H = "wifi_mac";
    public static String I = "wifi_mac_autochange_mode";
    public static String J = "scene_profile_source";
    public static String K = "scene9.3_contract";
    public static String L = "last_update";
    public static String M = "hardware_report";
    public static String N = "freeze_icon_notify";
    public static String O = "freeze_suspend";
    public static String P = "freeze_suspend_time_limit";
    public static String Q = "simple_notification";
    public static String R = "quickly_grant";
    public static String S = "daemon_build_time";
    public static String T = "daemon_version_name";
    public static String U = "swap";
    public static String V = "swap";
    public static String W = "swap_size";
    public static String X = "swap_priority";
    public static String Y = "swap_use_loop";
    public static String Z = "zram";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f6357a = 3000;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final hz0 f1282a = new hz0();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static String f1283a = "working_mode";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static boolean f1284a = true;
    public static String a0 = "zram_size";
    public static int b = 90;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static String f1285b = "su_alias7";
    public static String b0 = "swappiness";
    public static int c = 420;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static String f1286c = "powercfg";
    public static String c0 = "extra_free_kbytes";
    public static int d = 1350;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static String f1287d = "charge";
    public static String d0 = "watermark_scale";
    public static int e = 0;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public static String f1288e = "qc_booster";
    public static String e0 = "auto_lmk";
    public static int f = 1;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public static String f1289f = "charge_limit_ma";
    public static String f0 = "comp_algorithm";
    public static int g = 2;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public static String f1290g = "bp";
    public static String g0 = "scene_black_list_spf";
    public static int h = 1;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public static String f1291h = "bp_level";
    public static String h0 = "AUTO_SKIP_BLACKLIST";
    public static int i = 1;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public static String f1292i = "cdp_disable";
    public static int j = 2;

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    public static String f1293j = "sleep_time";
    public static int k = -1000;

    /* JADX INFO: renamed from: k, reason: collision with other field name */
    public static String f1294k = "time_get_up";
    public static String l = "time_slepp";
    public static String m = "current_control_mode";
    public static String n = "CLOUD_PROFILE_VERSION";
    public static String o = "CLOUD_PROFILE_BRANCH";
    public static String p = "monitor_mini";
    public static String q = "monitor_general";
    public static String r = "monitor_fps";
    public static String s = "monitor_task";
    public static String t = "global";
    public static String u = "keep_alive";
    public static String v = "daemon_alive";
    public static String w = "is_auto_install";
    public static String x = "is_auto_allow";
    public static String y = "show_help_icon";
    public static String z = "precision_monitor";

    public final String A() {
        return v;
    }

    public final String A0(String str, String str2) {
        return Scene.f4798a.g().getString(str, str2);
    }

    public final boolean B() {
        return e("daemon_auto", false);
    }

    public final String B0() {
        return A0("user_name", "");
    }

    public final String C() {
        return T;
    }

    public final String C0() {
        return f1283a;
    }

    public final String D() {
        return u;
    }

    public final void D0(String str) {
        L0("random_id2", str);
    }

    public final boolean E() {
        return f1284a;
    }

    public final void E0(String str) {
        L0("activate_v2_type", str);
    }

    public final String F() {
        return R;
    }

    public final void F0(boolean z2) {
        G0("auto_upload", z2);
    }

    public final String G() {
        return Q;
    }

    public final void G0(String str, boolean z2) {
        Scene.f4798a.g().edit().putBoolean(str, z2).apply();
    }

    public final String H() {
        return t;
    }

    public final void H0(boolean z2) {
        G0("daemon_auto", z2);
    }

    public final String I() {
        return x;
    }

    public final void I0(boolean z2) {
        G0("kernel_mem", z2);
    }

    public final String J() {
        return w;
    }

    public final void J0(boolean z2) {
        G0("pedestal_mode", z2);
    }

    public final String K() {
        return K;
    }

    public final void K0(boolean z2) {
        G0("dynamic_control", z2);
    }

    public final int L() {
        return k;
    }

    public final void L0(String str, String str2) {
        (str2 == null ? Scene.f4798a.g().edit().remove(str) : Scene.f4798a.g().edit().putString(str, str2)).apply();
    }

    public final String M() {
        return N;
    }

    public final void M0(String str) {
        L0("user_name", str);
    }

    public final String N() {
        return P;
    }

    public final String O() {
        return D;
    }

    public final String P() {
        return M;
    }

    public final String Q() {
        return y;
    }

    public final boolean R() {
        return e("kernel_mem", true);
    }

    public final String S() {
        return L;
    }

    public final String T() {
        return E;
    }

    public final String U() {
        return H;
    }

    public final String V() {
        return I;
    }

    public final int W() {
        return i;
    }

    public final int X() {
        return j;
    }

    public final String Y() {
        return z;
    }

    public final String Z() {
        return F;
    }

    public final String a() {
        return A0("random_id2", "");
    }

    public final boolean a0() {
        return e("pedestal_mode", false);
    }

    public final String b() {
        return A0("activate_v2_type", "");
    }

    public final boolean b0() {
        return e("dynamic_control", false);
    }

    public final String c() {
        return h0;
    }

    public final String c0() {
        return J;
    }

    public final boolean d() {
        return e("auto_upload", true);
    }

    public final String d0() {
        return C;
    }

    public final boolean e(String str, boolean z2) {
        return Scene.f4798a.g().getBoolean(str, z2);
    }

    public final String e0() {
        return A;
    }

    public final String f() {
        return f1287d;
    }

    public final String f0() {
        return B;
    }

    public final String g() {
        return f1290g;
    }

    public final String g0() {
        return G;
    }

    public final String h() {
        return f1291h;
    }

    public final String h0() {
        return r;
    }

    public final int i() {
        return b;
    }

    public final String i0() {
        return q;
    }

    public final String j() {
        return f1292i;
    }

    public final String j0() {
        return p;
    }

    public final String k() {
        return m;
    }

    public final String k0() {
        return s;
    }

    public final int l() {
        return h;
    }

    public final String l0() {
        return f1286c;
    }

    public final int m() {
        return f;
    }

    public final String m0() {
        return g0;
    }

    public final int n() {
        return g;
    }

    public final String n0() {
        return f1285b;
    }

    public final int o() {
        return e;
    }

    public final String o0() {
        return U;
    }

    public final String p() {
        return f1293j;
    }

    public final String p0() {
        return f0;
    }

    public final String q() {
        return f1288e;
    }

    public final String q0() {
        return e0;
    }

    public final String r() {
        return f1289f;
    }

    public final String r0() {
        return c0;
    }

    public final int s() {
        return f6357a;
    }

    public final String s0() {
        return V;
    }

    public final String t() {
        return f1294k;
    }

    public final String t0() {
        return b0;
    }

    public final int u() {
        return c;
    }

    public final String u0() {
        return X;
    }

    public final String v() {
        return l;
    }

    public final String v0() {
        return W;
    }

    public final int w() {
        return d;
    }

    public final String w0() {
        return Y;
    }

    public final String x() {
        return o;
    }

    public final String x0() {
        return d0;
    }

    public final String y() {
        return n;
    }

    public final String y0() {
        return Z;
    }

    public final String z() {
        return S;
    }

    public final String z0() {
        return a0;
    }
}
