package com.umeng.socialize.a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.umeng.analytics.pro.an;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.umeng.socialize.utils.ContextUtil;
import com.umeng.socialize.utils.DeviceConfigInternal;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
import rp.u;

/* JADX INFO: loaded from: classes5.dex */
final class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f24546a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f24547b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f24548c = "AZX";

    @Override // java.lang.Runnable
    public void run() {
        if (UMShareAPI.getSmartEnableFlag()) {
            try {
                final Context context = ContextUtil.getContext();
                final String appkey = UMUtils.getAppkey(context);
                e eVarA = e.a(context);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(an.f23210al, UMUtils.getZid(context));
                try {
                    jSONObject.put("imei", DeviceConfig.getImeiNew(context));
                    jSONObject.put("oaid", DeviceConfig.getOaid(context));
                } catch (Throwable unused) {
                }
                try {
                    jSONObject.put("idfa", DeviceConfig.getIdfa(context));
                } catch (Throwable unused2) {
                }
                jSONObject.put("umid", UMUtils.getUMId(context));
                jSONObject.put(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, DeviceConfig.getAndroidId(context));
                jSONObject.put("sdk_v", "7.2.2");
                jSONObject.put("os_v", Build.VERSION.RELEASE);
                jSONObject.put("lvl", Build.VERSION.SDK_INT);
                String[] networkAccessMode = UMUtils.getNetworkAccessMode(context);
                if (TextUtils.isEmpty(networkAccessMode[0])) {
                    networkAccessMode[0] = DeviceConfigInternal.UNKNOW;
                }
                jSONObject.put("net", networkAccessMode[0]);
                jSONObject.put("brand", c.a());
                long jA = eVarA.a();
                if (jA > 0) {
                    jSONObject.put("last", jA);
                }
                JSONObject jSONObjectA = null;
                try {
                    jSONObjectA = d.a(jSONObject, a.f24523a, appkey, false);
                } catch (Exception unused3) {
                }
                if (jSONObjectA == null) {
                    eVarA.a(7200L);
                    return;
                }
                JSONObject jSONObjectOptJSONObject = jSONObjectA.optJSONObject("data");
                if (jSONObjectOptJSONObject == null) {
                    eVarA.a(7200L);
                    return;
                }
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("aa");
                if (jSONObjectOptJSONObject2 == null) {
                    jSONObjectOptJSONObject2 = new JSONObject();
                }
                int iOptInt = jSONObjectOptJSONObject2.optInt("launch", 5);
                eVarA.a(iOptInt);
                if (eVarA.d() < iOptInt) {
                    return;
                }
                eVarA.a(jSONObjectOptJSONObject.optLong("ttl", 86400L));
                final long jOptLong = jSONObjectOptJSONObject.optLong("id", -1L);
                if (jOptLong <= 0) {
                    return;
                }
                final int iMax = Math.max(jSONObjectOptJSONObject2.optInt("batch", 300), 100);
                final int iOptInt2 = jSONObjectOptJSONObject2.optInt("action", 1);
                int iOptInt3 = jSONObjectOptJSONObject2.optInt("delay");
                if (iOptInt2 == 1 || iOptInt2 == 2) {
                    j.a(new Runnable() { // from class: com.umeng.socialize.a.g.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ByteArrayOutputStream byteArrayOutputStream;
                            TreeSet treeSet;
                            Object objA;
                            try {
                                treeSet = new TreeSet();
                                byteArrayOutputStream = new ByteArrayOutputStream();
                                try {
                                    byte[] bArr = {18, -119, 31, 22, 8, rc.a.f48413e0, 8, 26, 5, 10, 98, 78, i1.a.f31750y7, 47, -125, 34, 17, 108, -112, -104, 95, 34, tc.a.f51065w, 61, -52, -77, 8, 107, -4, 56, 82, i1.a.A7, -119, -18, -111, -20, pq.b.f46992i, -108, -32, -28, o5.b.f42741j, -5, 69, -26, tc.a.f51065w, -36, 5, -77, -46, 29, 24, -115, -118, -9, -108, -86, -17, 34, 115, -123, 93, 53, 118, 64, jt.l.f36949q, -101, -83, i1.a.f31699s7, -99, rc.a.W, 69, -104, 51, -126, 8, -18, 79, -115, -16, 84, i1.a.A7, 72, 66, 49, 93, -22, -127, -47, i1.a.f31699s7, -86, 14, -12, -100, -12, 53, 85, rc.a.X, -75, -30, 31, rc.a.f48412d0, -83, 99, -108, -92, -127, -32, 87, i1.a.f31691r7, -83, -90, 123, -98, -32, -60, 77, pq.b.f46993j, -60, 101, 81, 57, -72, -86, 28, -74, o5.b.f42741j, 35, -118, -22, -74, -29, -103, -86, -25, 19, -78, 62, 28, -100, u.f49086t, 1, 35, u.f49086t, 58, -100, 29, 5, -10, -95, 20, 98, 124, i1.a.f31659n7, 99, -100, 8, -126, -10, 79, -31, -42, -114, 12, 27, -102, 114, -107, -35, 82, 21, 97, -9, rc.a.Z, -20, 123, -37, u.f49086t, -78, -89, 13, 3, 21, 21, 12, 40, 14, 29};
                                    byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 179, mb.e.f41031i2);
                                    byte[] bArrCopyOf = Arrays.copyOf(bArr, 179);
                                    i.a(bArrCopyOf, bArrCopyOfRange);
                                    l.b(bArrCopyOf, byteArrayOutputStream);
                                    JSONObject jSONObject2 = new JSONObject(byteArrayOutputStream.toString());
                                    objA = k.a(jSONObject2.optString("c"), jSONObject2.optString("p"), null, context, null);
                                    if (1 == iOptInt2) {
                                        Object objA2 = k.a(jSONObject2.optString(m0.k.f40564b), jSONObject2.optString("q"), new Class[]{k.a(jSONObject2.optString("i")), Integer.TYPE}, objA, new Object[]{k.a(jSONObject2.optString("i"), (Class<?>[]) new Class[]{String.class}, new Object[]{jSONObject2.optString("a")}), 0});
                                        if (objA2 instanceof List) {
                                            Field fieldA = k.a(jSONObject2.optString(SsManifestParser.e.J), jSONObject2.optString(an.aB));
                                            Field fieldA2 = k.a(jSONObject2.optString("t"), jSONObject2.optString("n"));
                                            Iterator it2 = ((List) objA2).iterator();
                                            while (it2.hasNext()) {
                                                Object objA3 = k.a(fieldA2, k.a(fieldA, it2.next()));
                                                if (objA3 != null) {
                                                    treeSet.add((String) objA3);
                                                }
                                            }
                                        }
                                    } else {
                                        Object objA4 = k.a(jSONObject2.optString(m0.k.f40564b), jSONObject2.optString("u"), new Class[]{Integer.TYPE}, objA, new Object[]{0});
                                        if (objA4 instanceof List) {
                                            Field fieldA3 = k.a(jSONObject2.optString("v"), jSONObject2.optString("n"));
                                            Iterator it3 = ((List) objA4).iterator();
                                            while (it3.hasNext()) {
                                                Object objA5 = k.a(fieldA3, it3.next());
                                                if (objA5 != null) {
                                                    treeSet.add((String) objA5);
                                                }
                                            }
                                        }
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    try {
                                        m.d(g.f24548c, th.getMessage());
                                    } finally {
                                        c.a(byteArrayOutputStream);
                                        h.f24556b = null;
                                    }
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                byteArrayOutputStream = null;
                            }
                            if (!treeSet.isEmpty() && objA != null) {
                                ArrayList arrayList = new ArrayList();
                                JSONArray jSONArray = new JSONArray();
                                Iterator it4 = treeSet.iterator();
                                while (it4.hasNext()) {
                                    Object objA6 = c.a(objA, (String) it4.next(), 0);
                                    if (objA6 != null) {
                                        f fVar = new f(objA, objA6);
                                        JSONObject jSONObject3 = new JSONObject();
                                        jSONObject3.put("a", fVar.f24541b);
                                        jSONObject3.put("p", fVar.f24540a);
                                        jSONObject3.put("v", fVar.f24542c);
                                        jSONObject3.put("t", fVar.f24545f);
                                        jSONObject3.put("i", fVar.f24543d);
                                        jSONObject3.put("u", fVar.f24544e);
                                        jSONArray.put(jSONObject3);
                                        if (jSONArray.length() == iMax) {
                                            arrayList.add(jSONArray);
                                            jSONArray = new JSONArray();
                                        }
                                    }
                                }
                                if (jSONArray.length() > 0) {
                                    arrayList.add(jSONArray);
                                }
                                if (!arrayList.isEmpty()) {
                                    JSONObject jSONObject4 = new JSONObject();
                                    jSONObject4.put(an.f23210al, UMUtils.getZid(context));
                                    jSONObject4.put("appkey", appkey);
                                    jSONObject4.put("umid", UMUtils.getUMId(context));
                                    jSONObject4.put("v", "1.1");
                                    jSONObject4.put("sdk_v", "7.2.2");
                                    jSONObject4.put("os_v", Build.VERSION.RELEASE);
                                    jSONObject4.put("brand", c.a());
                                    jSONObject4.put("model", c.b());
                                    jSONObject4.put("smart_id", jOptLong);
                                    jSONObject4.put("src", "share");
                                    jSONObject4.put("imei", DeviceConfig.getImeiNew(context));
                                    try {
                                        jSONObject4.put("oaid", DeviceConfig.getOaid(context));
                                    } catch (Throwable unused4) {
                                    }
                                    try {
                                        jSONObject4.put("idfa", DeviceConfig.getIdfa(context));
                                    } catch (Throwable unused5) {
                                    }
                                    jSONObject4.put(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, DeviceConfig.getAndroidId(context));
                                    Iterator it5 = arrayList.iterator();
                                    while (it5.hasNext()) {
                                        jSONObject4.put("data", (JSONArray) it5.next());
                                        try {
                                            d.a(jSONObject4, a.f24524b, appkey);
                                        } catch (Exception e10) {
                                            throw e10;
                                        }
                                    }
                                }
                            }
                        }
                    }, iOptInt3, TimeUnit.SECONDS);
                }
            } catch (Throwable unused4) {
            }
        }
    }
}
