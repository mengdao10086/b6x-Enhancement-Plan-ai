package com.umeng.commonsdk.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.pro.an;
import com.umeng.analytics.pro.bf;
import com.umeng.analytics.pro.d;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.idtracking.Envelope;
import com.umeng.commonsdk.statistics.idtracking.e;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f24153a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f24154b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f24155c = "EnvelopeManager";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f24156d = "debug.umeng.umTaskId";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f24157e = "debug.umeng.umCaseId";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f24158f = "empty";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static String f24159g = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static String f24160h = "";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static String f24161i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static Map<String, String> f24162j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static boolean f24163l;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f24164k = 0;

    static {
        HashMap map = new HashMap();
        f24162j = map;
        map.put("header", "#h");
        f24162j.put(an.f23255u, "#sdt");
        f24162j.put(an.Q, "#ac");
        f24162j.put("device_model", "#dm");
        f24162j.put("umid", "#umid");
        f24162j.put("os", "os");
        f24162j.put(an.N, "#lang");
        f24162j.put(an.f23207ai, "#dt");
        f24162j.put(an.f23260z, "#rl");
        f24162j.put(an.H, "#dmf");
        f24162j.put("device_name", "#dn");
        f24162j.put("platform_version", "#pv");
        f24162j.put("font_size_setting", "#fss");
        f24162j.put("os_version", "#ov");
        f24162j.put(an.I, "#did");
        f24162j.put("platform_sdk_version", "#psv");
        f24162j.put(an.F, "#db");
        f24162j.put("appkey", "#ak");
        f24162j.put(an.Y, "#itr");
        f24162j.put("id_type", "#it");
        f24162j.put("uuid", "#ud");
        f24162j.put("device_id", "#dd");
        f24162j.put(an.X, "#imp");
        f24162j.put("sdk_version", "#sv");
        f24162j.put("st", "#st");
        f24162j.put("analytics", "#a");
        f24162j.put("package_name", "#pkg");
        f24162j.put(an.f23250p, "#sig");
        f24162j.put(an.f23251q, "#sis1");
        f24162j.put(an.f23252r, "#sis");
        f24162j.put("app_version", "#av");
        f24162j.put("version_code", "#vc");
        f24162j.put(an.f23256v, "#imd");
        f24162j.put(an.B, "#mnc");
        f24162j.put(an.E, "#boa");
        f24162j.put(an.G, "#mant");
        f24162j.put(an.M, "#tz");
        f24162j.put("country", "#ct");
        f24162j.put(an.P, "#car");
        f24162j.put("display_name", "#disn");
        f24162j.put(an.T, "#nt");
        f24162j.put(an.f23220b, "#cv");
        f24162j.put(an.f23238d, "#mv");
        f24162j.put(an.f23237c, "#cot");
        f24162j.put(an.f23239e, "#mod");
        f24162j.put(an.f23208aj, "#al");
        f24162j.put("session_id", "#sid");
        f24162j.put(an.S, "#ip");
        f24162j.put(an.U, "#sre");
        f24162j.put(an.V, "#fre");
        f24162j.put(an.W, "#ret");
        f24162j.put("channel", "#chn");
        f24162j.put("wrapper_type", "#wt");
        f24162j.put("wrapper_version", "#wv");
        f24162j.put(an.aV, "#tsv");
        f24162j.put(an.aW, "#rps");
        f24162j.put(an.aZ, "#mov");
        f24162j.put(d.f23505i, "#vt");
        f24162j.put("secret", "#sec");
        f24162j.put(d.f23484ah, "#prv");
        f24162j.put(d.f23508l, "#$prv");
        f24162j.put(d.f23509m, "#uda");
        f24162j.put(an.f23198a, "#tok");
        f24162j.put(an.aN, "#iv");
        f24162j.put(an.R, "#ast");
        f24162j.put("backstate", "#bst");
        f24162j.put("zdata_ver", "#zv");
        f24162j.put("zdata_req_ts", "#zrt");
        f24162j.put("app_b_v", "#bv");
        f24162j.put("zdata", "#zta");
        f24162j.put(an.f23214ap, "#mt");
        f24162j.put(an.f23211am, "#zsv");
        f24162j.put("others_OS", "#oos");
    }

    public static String a(String str) {
        return f24162j.containsKey(str) ? f24162j.get(str) : str;
    }

    private static boolean b() {
        f24159g = UMUtils.getSystemProperty(f24156d, "");
        f24160h = UMUtils.getSystemProperty(f24157e, "");
        return (!TextUtils.isEmpty(f24159g) && !f24158f.equals(f24159g)) && (!TextUtils.isEmpty(f24160h) && !f24158f.equals(f24160h));
    }

    public static void a() {
        if (f24161i != null) {
            f24161i = null;
            e.a();
        }
    }

    public JSONObject b(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str) {
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(a("header"), new JSONObject());
            try {
                if (b()) {
                    jSONObject.put("umTaskId", f24159g);
                    jSONObject.put("umCaseId", f24160h);
                }
            } catch (Throwable unused) {
            }
            if (jSONObject != null) {
                jSONObject3 = a(jSONObject3, jSONObject);
            }
            if (jSONObject3 != null && jSONObject2 != null) {
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (next != null && (next instanceof String)) {
                        String str2 = next;
                        if (jSONObject2.opt(str2) != null) {
                            try {
                                jSONObject3.put(str2, jSONObject2.opt(str2));
                            } catch (Exception unused2) {
                            }
                        }
                    }
                }
            }
            if (jSONObject3 != null && DataHelper.largeThanMaxSize(jSONObject3.toString().getBytes().length, DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX)) {
                SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putInt("serial", sharedPreferences.getInt("serial", 1) + 1).commit();
                }
                return a(113, jSONObject3);
            }
            Envelope envelopeA = null;
            if (jSONObject3 != null && (envelopeA = a(context, jSONObject3.toString().getBytes())) == null) {
                return a(111, jSONObject3);
            }
            Envelope envelope = envelopeA;
            if (envelope != null && DataHelper.largeThanMaxSize(envelope.toBinary().length, DataHelper.ENVELOPE_LENGTH_MAX)) {
                return a(114, jSONObject3);
            }
            int iA = a(context, envelope, "z==1.2.0", DeviceConfig.getAppVersionName(context), str);
            if (iA != 0) {
                return a(iA, jSONObject3);
            }
            if (ULog.DEBUG) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("constructHeader size is ");
                sb2.append(jSONObject3.toString().getBytes().length);
            }
            return jSONObject3;
        } catch (Throwable th2) {
            UMCrashManager.reportCrash(context, th2);
            return a(110, new JSONObject());
        }
    }

    public static long a(Context context) {
        long j10 = DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX - DataHelper.ENVELOPE_EXTRA_LENGTH;
        if (ULog.DEBUG) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("free size is ");
            sb2.append(j10);
        }
        return j10;
    }

    private JSONObject a(int i10, JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                jSONObject.put("exception", i10);
            } catch (Exception unused) {
            }
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("exception", i10);
        } catch (Exception unused2) {
        }
        return jSONObject2;
    }

    public JSONObject a(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str, String str2, String str3) {
        JSONObject jSONObject3;
        String str4;
        boolean z10;
        String str5;
        Envelope envelope;
        JSONObject jSONObjectOptJSONObject;
        if (ULog.DEBUG && jSONObject != null && jSONObject2 != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("headerJSONObject size is ");
            sb2.append(jSONObject.toString().getBytes().length);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("bodyJSONObject size is ");
            sb3.append(jSONObject2.toString().getBytes().length);
        }
        JSONObject jSONObject4 = null;
        if (context != null && jSONObject2 != null) {
            try {
                if (jSONObject2.has("analytics") && (jSONObjectOptJSONObject = jSONObject2.optJSONObject("analytics")) != null && jSONObjectOptJSONObject.has(d.f23510n)) {
                    str4 = str2;
                    z10 = true;
                } else {
                    str4 = str2;
                    z10 = false;
                }
                JSONObject jSONObjectA = a(context, str4, z10);
                if (jSONObjectA != null && jSONObject != null) {
                    jSONObjectA = a(jSONObjectA, jSONObject);
                }
                JSONObject jSONObject5 = jSONObjectA;
                if (jSONObject5 != null) {
                    Iterator<String> itKeys = jSONObject2.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        if (next != null && (next instanceof String)) {
                            String str6 = next;
                            if (jSONObject2.opt(str6) != null) {
                                try {
                                    jSONObject5.put(a(str6), jSONObject2.opt(str6));
                                } catch (Exception unused) {
                                }
                            }
                        }
                    }
                }
                if (TextUtils.isEmpty(str2)) {
                    str4 = "u";
                }
                String str7 = TextUtils.isEmpty(str3) ? "1.0.0" : str3;
                if (jSONObject5 != null) {
                    String strSubstring = str4 + "==" + str7 + "&=";
                    if (TextUtils.isEmpty(strSubstring)) {
                        return a(101, jSONObject5);
                    }
                    if (strSubstring.endsWith("&=")) {
                        strSubstring = strSubstring.substring(0, strSubstring.length() - 2);
                    }
                    str5 = strSubstring;
                } else {
                    str5 = null;
                }
                if (jSONObject5 != null) {
                    try {
                        e eVarA = e.a(context);
                        if (eVarA != null) {
                            eVarA.b();
                            String strEncodeToString = Base64.encodeToString(new bf().a(eVarA.c()), 0);
                            if (!TextUtils.isEmpty(strEncodeToString)) {
                                JSONObject jSONObject6 = jSONObject5.getJSONObject(a("header"));
                                jSONObject6.put(a(an.Y), strEncodeToString);
                                jSONObject5.put(a("header"), jSONObject6);
                            }
                        }
                    } catch (Exception unused2) {
                    }
                }
                if (jSONObject5 != null && DataHelper.largeThanMaxSize(jSONObject5.toString().getBytes().length, DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX)) {
                    SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
                    if (sharedPreferences != null) {
                        sharedPreferences.edit().putInt("serial", sharedPreferences.getInt("serial", 1) + 1).commit();
                    }
                    return a(113, jSONObject5);
                }
                if (jSONObject5 != null) {
                    Envelope envelopeA = a(context, jSONObject5.toString().getBytes());
                    if (envelopeA == null) {
                        return a(111, jSONObject5);
                    }
                    envelope = envelopeA;
                } else {
                    envelope = null;
                }
                if (envelope != null && DataHelper.largeThanMaxSize(envelope.toBinary().length, DataHelper.ENVELOPE_LENGTH_MAX)) {
                    return a(114, jSONObject5);
                }
                int iA = a(context, envelope, str5, jSONObject5 != null ? jSONObject5.optJSONObject(a("header")).optString(a("app_version")) : null, str);
                if (iA != 0) {
                    return a(iA, jSONObject5);
                }
                if (ULog.DEBUG) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("constructHeader size is ");
                    sb4.append(jSONObject5.toString().getBytes().length);
                }
                if (!str5.startsWith(an.aD) && !str5.startsWith("i") && !str5.startsWith("t") && !str5.startsWith("a") && !com.umeng.commonsdk.stateless.b.a()) {
                    new com.umeng.commonsdk.stateless.b(context);
                    com.umeng.commonsdk.stateless.b.b();
                }
                return jSONObject5;
            } catch (Throwable th2) {
                UMCrashManager.reportCrash(context, th2);
                if (jSONObject != null) {
                    try {
                        jSONObject3 = new JSONObject();
                    } catch (Exception e10) {
                        e = e10;
                    }
                    try {
                        jSONObject3.put("header", jSONObject);
                    } catch (JSONException unused3) {
                    } catch (Exception e11) {
                        e = e11;
                        jSONObject4 = jSONObject3;
                        UMCrashManager.reportCrash(context, e);
                        return a(110, jSONObject4);
                    }
                    jSONObject4 = jSONObject3;
                }
                if (jSONObject4 == null) {
                    jSONObject4 = new JSONObject();
                }
                Iterator<String> itKeys2 = jSONObject2.keys();
                while (itKeys2.hasNext()) {
                    String next2 = itKeys2.next();
                    if (next2 != null && (next2 instanceof String)) {
                        String str8 = next2;
                        if (jSONObject2.opt(str8) != null) {
                            try {
                                jSONObject4.put(str8, jSONObject2.opt(str8));
                            } catch (Exception unused4) {
                            }
                        }
                    }
                }
                return a(110, jSONObject4);
            }
        }
        return a(110, (JSONObject) null);
    }

    private static int[] b(Context context) {
        int[] iArr = new int[3];
        try {
            SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(com.umeng.commonsdk.internal.c.f24058a, 0);
            if (sharedPreferences != null) {
                iArr[0] = sharedPreferences.getInt(com.umeng.commonsdk.internal.c.f24059b, 0);
                iArr[1] = sharedPreferences.getInt(com.umeng.commonsdk.internal.c.f24060c, 0);
                iArr[2] = sharedPreferences.getInt("policyGrantResult", 0);
            }
        } catch (Throwable unused) {
        }
        return iArr;
    }

    public JSONObject a(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str) {
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(a("header"), new JSONObject());
            if (jSONObject != null) {
                jSONObject3 = a(jSONObject3, jSONObject);
            }
            if (jSONObject3 != null && jSONObject2 != null) {
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (next != null && (next instanceof String)) {
                        String str2 = next;
                        if (jSONObject2.opt(str2) != null) {
                            try {
                                jSONObject3.put(str2, jSONObject2.opt(str2));
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
            }
            if (jSONObject3 != null && DataHelper.largeThanMaxSize(jSONObject3.toString().getBytes().length, DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX)) {
                SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putInt("serial", sharedPreferences.getInt("serial", 1) + 1).commit();
                }
                return a(113, jSONObject3);
            }
            Envelope envelopeA = null;
            if (jSONObject3 != null && (envelopeA = a(context, jSONObject3.toString().getBytes())) == null) {
                return a(111, jSONObject3);
            }
            Envelope envelope = envelopeA;
            if (envelope != null && DataHelper.largeThanMaxSize(envelope.toBinary().length, DataHelper.ENVELOPE_LENGTH_MAX)) {
                return a(114, jSONObject3);
            }
            int iA = a(context, envelope, "h==1.2.0", "", str);
            if (iA != 0) {
                return a(iA, jSONObject3);
            }
            if (ULog.DEBUG) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("constructHeader size is ");
                sb2.append(jSONObject3.toString().getBytes().length);
            }
            return jSONObject3;
        } catch (Throwable th2) {
            UMCrashManager.reportCrash(context, th2);
            return a(110, new JSONObject());
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:162:0x03ad
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1182)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    private static org.json.JSONObject a(android.content.Context r16, java.lang.String r17, boolean r18) {
        /*
            Method dump skipped, instruction units count: 1440
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.b.a(android.content.Context, java.lang.String, boolean):org.json.JSONObject");
    }

    private JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null && jSONObject2 != null && jSONObject.opt(a("header")) != null && (jSONObject.opt(a("header")) instanceof JSONObject)) {
            JSONObject jSONObject3 = (JSONObject) jSONObject.opt(a("header"));
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (next != null && (next instanceof String)) {
                    String str = next;
                    if (jSONObject2.opt(str) != null) {
                        try {
                            jSONObject3.put(str, jSONObject2.opt(str));
                            if (str.equals(a(d.f23505i)) && (jSONObject2.opt(str) instanceof Integer)) {
                                this.f24164k = ((Integer) jSONObject2.opt(str)).intValue();
                            }
                        } catch (Exception unused) {
                        }
                    }
                }
            }
        }
        return jSONObject;
    }

    private Envelope a(Context context, byte[] bArr) {
        String strImprintProperty = UMEnvelopeBuild.imprintProperty(context, "codex", null);
        int iIntValue = -1;
        try {
            if (!TextUtils.isEmpty(strImprintProperty)) {
                iIntValue = Integer.valueOf(strImprintProperty).intValue();
            }
        } catch (NumberFormatException e10) {
            UMCrashManager.reportCrash(context, e10);
        }
        if (iIntValue == 0) {
            return Envelope.genEnvelope(context, UMUtils.getAppkey(context), bArr);
        }
        if (iIntValue == 1) {
            return Envelope.genEncryptEnvelope(context, UMUtils.getAppkey(context), bArr);
        }
        if (f24163l) {
            return Envelope.genEncryptEnvelope(context, UMUtils.getAppkey(context), bArr);
        }
        return Envelope.genEnvelope(context, UMUtils.getAppkey(context), bArr);
    }

    private int a(Context context, Envelope envelope, String str, String str2, String str3) {
        if (context == null || envelope == null || TextUtils.isEmpty(str)) {
            return 101;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = DeviceConfig.getAppVersionName(context);
        }
        String strB = com.umeng.commonsdk.stateless.d.b(str3);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append("&&");
        sb2.append(str2);
        sb2.append("_");
        sb2.append(System.currentTimeMillis());
        sb2.append("_");
        sb2.append(strB);
        sb2.append(".log");
        byte[] binary = envelope.toBinary();
        if (com.umeng.commonsdk.utils.c.a()) {
            if (str.startsWith("h")) {
                return UMFrUtils.saveEnvelopeFile(context, sb2.toString(), binary);
            }
            return 122;
        }
        if (str.startsWith("h")) {
            return 122;
        }
        if (!str.startsWith(an.aD) && !str.startsWith("i") && !str.startsWith("a") && !str.startsWith("t")) {
            return com.umeng.commonsdk.stateless.d.a(context, com.umeng.commonsdk.stateless.a.f24125f, sb2.toString(), binary);
        }
        return UMFrUtils.saveEnvelopeFile(context, sb2.toString(), binary);
    }

    public static void a(boolean z10) {
        f24163l = z10;
    }
}
