package com.umeng.analytics.pro;

import android.text.TextUtils;
import com.umeng.umcrash.UMCrash;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class z {
    public static final String A = "rtd";
    public static final String B = "lepd";
    private static Map<String, String> C = null;
    private static String D = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f23795a = "env";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f23796b = "exp";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f23797c = "imp";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f23798d = "ua";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f23799e = "zc";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f23800f = "id";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f23801g = "zf";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f23802h = "exid";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f23803i = "ucc";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f23804j = "ugc";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f23805k = "usi";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f23806l = "uso";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f23807m = "user";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f23808n = "uspi";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f23809o = "dtfn";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f23810p = "pr";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f23811q = "upg";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f23812r = "pri";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f23813s = "probe";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f23814t = "bl";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f23815u = "wl";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f23816v = "subp";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f23817w = "subua";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f23818x = "sta";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f23819y = "emi";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f23820z = "sli";

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final z f23821a = new z();

        private a() {
        }
    }

    static {
        HashMap map = new HashMap();
        C = map;
        D = "";
        map.put(f23795a, "envelope");
        C.put(f23796b, ".umeng");
        C.put(f23797c, ".imprint");
        C.put(f23798d, "ua.db");
        C.put(f23799e, "umeng_zero_cache.db");
        C.put("id", "umeng_it.cache");
        C.put(f23801g, "umeng_zcfg_flag");
        C.put(f23802h, "exid.dat");
        C.put(f23803i, "umeng_common_config");
        C.put(f23804j, "umeng_general_config");
        C.put(f23805k, UMCrash.KEY_CALLBACK_SESSION_ID);
        C.put(f23806l, "umeng_sp_oaid");
        C.put(f23807m, "mobclick_agent_user_");
        C.put(f23808n, "umeng_subprocess_info");
        C.put(f23809o, "delayed_transmission_flag_new");
        C.put("pr", "umeng_policy_result_flag");
        C.put(f23811q, "um_policy_grant");
        C.put(f23812r, "um_pri");
        C.put(f23813s, "UM_PROBE_DATA");
        C.put(f23814t, "ekv_bl");
        C.put(f23815u, "ekv_wl");
        C.put(f23816v, e.f23523a);
        C.put(f23817w, "ua_");
        C.put(f23818x, "stateless");
        C.put(f23819y, ".emitter");
        C.put(f23820z, "um_slmode_sp");
        C.put(A, "um_rtd_conf");
        C.put(B, "");
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str) && TextUtils.isEmpty(D)) {
            if (str.length() > 3) {
                D = str.substring(0, 3) + "_";
                return;
            }
            D = str + "_";
        }
    }

    public String b(String str) {
        if (!C.containsKey(str)) {
            return "";
        }
        String str2 = C.get(str);
        if (!f23796b.equalsIgnoreCase(str) && !f23797c.equalsIgnoreCase(str) && !f23819y.equalsIgnoreCase(str)) {
            return D + str2;
        }
        return j3.b.f36044h + D + str2.substring(1);
    }

    private z() {
    }

    public void a() {
        D = "";
    }

    public static z b() {
        return a.f23821a;
    }
}
