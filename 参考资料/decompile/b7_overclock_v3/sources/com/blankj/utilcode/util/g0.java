package com.blankj.utilcode.util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte f11765a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte f11766b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte f11767c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final byte f11768d = 3;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final byte f11769e = 4;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final byte f11770f = 5;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final byte f11771g = 6;

    public g0() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static <T> T A(String str, String str2, T t10, byte b10) {
        if (str != null && str.length() != 0 && str2 != null && str2.length() != 0) {
            try {
                return (T) B(new JSONObject(str), str2, t10, b10);
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
        }
        return t10;
    }

    public static <T> T B(JSONObject jSONObject, String str, T t10, byte b10) {
        T t11;
        if (jSONObject != null && str != null && str.length() != 0) {
            try {
                if (b10 == 0) {
                    t11 = (T) Boolean.valueOf(jSONObject.getBoolean(str));
                } else if (b10 == 1) {
                    t11 = (T) Integer.valueOf(jSONObject.getInt(str));
                } else if (b10 == 2) {
                    t11 = (T) Long.valueOf(jSONObject.getLong(str));
                } else if (b10 == 3) {
                    t11 = (T) Double.valueOf(jSONObject.getDouble(str));
                } else if (b10 == 4) {
                    t11 = (T) jSONObject.getString(str);
                } else if (b10 == 5) {
                    t11 = (T) jSONObject.getJSONObject(str);
                } else if (b10 == 6) {
                    t11 = (T) jSONObject.getJSONArray(str);
                }
                return t11;
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
        }
        return t10;
    }

    public static String a(String str) {
        return b(str, 4);
    }

    public static String b(String str, int i10) {
        try {
            int length = str.length();
            for (int i11 = 0; i11 < length; i11++) {
                char cCharAt = str.charAt(i11);
                if (cCharAt == '{') {
                    return new JSONObject(str).toString(i10);
                }
                if (cCharAt == '[') {
                    return new JSONArray(str).toString(i10);
                }
                if (!Character.isWhitespace(cCharAt)) {
                    return str;
                }
            }
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        return str;
    }

    public static boolean c(String str, String str2) {
        return d(str, str2, false);
    }

    public static boolean d(String str, String str2, boolean z10) {
        return ((Boolean) A(str, str2, Boolean.valueOf(z10), (byte) 0)).booleanValue();
    }

    public static boolean e(JSONObject jSONObject, String str) {
        return f(jSONObject, str, false);
    }

    public static boolean f(JSONObject jSONObject, String str, boolean z10) {
        return ((Boolean) B(jSONObject, str, Boolean.valueOf(z10), (byte) 0)).booleanValue();
    }

    public static double g(String str, String str2) {
        return h(str, str2, -1.0d);
    }

    public static double h(String str, String str2, double d10) {
        return ((Double) A(str, str2, Double.valueOf(d10), (byte) 3)).doubleValue();
    }

    public static double i(JSONObject jSONObject, String str) {
        return j(jSONObject, str, -1.0d);
    }

    public static double j(JSONObject jSONObject, String str, double d10) {
        return ((Double) B(jSONObject, str, Double.valueOf(d10), (byte) 3)).doubleValue();
    }

    public static int k(String str, String str2) {
        return l(str, str2, -1);
    }

    public static int l(String str, String str2, int i10) {
        return ((Integer) A(str, str2, Integer.valueOf(i10), (byte) 1)).intValue();
    }

    public static int m(JSONObject jSONObject, String str) {
        return n(jSONObject, str, -1);
    }

    public static int n(JSONObject jSONObject, String str, int i10) {
        return ((Integer) B(jSONObject, str, Integer.valueOf(i10), (byte) 1)).intValue();
    }

    public static JSONArray o(String str, String str2, JSONArray jSONArray) {
        return (JSONArray) A(str, str2, jSONArray, (byte) 6);
    }

    public static JSONArray p(JSONObject jSONObject, String str, JSONArray jSONArray) {
        return (JSONArray) B(jSONObject, str, jSONArray, (byte) 6);
    }

    public static JSONObject q(String str, String str2, JSONObject jSONObject) {
        return (JSONObject) A(str, str2, jSONObject, (byte) 5);
    }

    public static JSONObject r(JSONObject jSONObject, String str, JSONObject jSONObject2) {
        return (JSONObject) B(jSONObject, str, jSONObject2, (byte) 5);
    }

    public static long s(String str, String str2) {
        return t(str, str2, -1L);
    }

    public static long t(String str, String str2, long j10) {
        return ((Long) A(str, str2, Long.valueOf(j10), (byte) 2)).longValue();
    }

    public static long u(JSONObject jSONObject, String str) {
        return v(jSONObject, str, -1L);
    }

    public static long v(JSONObject jSONObject, String str, long j10) {
        return ((Long) B(jSONObject, str, Long.valueOf(j10), (byte) 2)).longValue();
    }

    public static String w(String str, String str2) {
        return x(str, str2, "");
    }

    public static String x(String str, String str2, String str3) {
        return (String) A(str, str2, str3, (byte) 4);
    }

    public static String y(JSONObject jSONObject, String str) {
        return z(jSONObject, str, "");
    }

    public static String z(JSONObject jSONObject, String str, String str2) {
        return (String) B(jSONObject, str, str2, (byte) 4);
    }
}
