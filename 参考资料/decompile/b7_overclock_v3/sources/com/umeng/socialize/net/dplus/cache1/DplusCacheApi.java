package com.umeng.socialize.net.dplus.cache1;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.umeng.socialize.c.b.a;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.umeng.socialize.net.dplus.db.DBConfig;
import com.umeng.socialize.net.dplus.db.DBManager;
import com.umeng.socialize.utils.ContextUtil;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class DplusCacheApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24741a = "DplusCacheApi";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HandlerThread f24742b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Handler f24743c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f24744d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ArrayList<Integer> f24745e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ArrayList<Integer> f24746f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ArrayList<Integer> f24747g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ArrayList<Integer> f24748h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ArrayList<Integer> f24749i;

    public static class SingletonHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final DplusCacheApi f24765a = new DplusCacheApi();

        private SingletonHolder() {
        }
    }

    public static double checkFile() {
        File dataFile = ContextUtil.getDataFile(DBConfig.DB_NAME);
        if (dataFile == null || !dataFile.exists()) {
            return 0.0d;
        }
        return dataFile.length();
    }

    public static final DplusCacheApi getInstance() {
        return SingletonHolder.f24765a;
    }

    public void cleanCache(Context context) {
        this.f24743c.post(new Runnable() { // from class: com.umeng.socialize.net.dplus.cache1.DplusCacheApi.2
            @Override // java.lang.Runnable
            public void run() {
                a.b();
            }
        });
    }

    public void closeDBConnection(final Context context) {
        this.f24743c.post(new Runnable() { // from class: com.umeng.socialize.net.dplus.cache1.DplusCacheApi.1
            @Override // java.lang.Runnable
            public void run() {
                DBManager.get(context).closeDatabase();
            }
        });
    }

    public void deleteAll(Context context) {
        this.f24743c.post(new Runnable() { // from class: com.umeng.socialize.net.dplus.cache1.DplusCacheApi.6
            @Override // java.lang.Runnable
            public void run() {
                DBManager.get(ContextUtil.getContext()).deleteTable("stats");
            }
        });
    }

    public void deleteAllAsnc(Context context) {
        DBManager.get(ContextUtil.getContext()).deleteTable("stats");
    }

    public void deleteFile(final Context context) {
        this.f24743c.post(new Runnable() { // from class: com.umeng.socialize.net.dplus.cache1.DplusCacheApi.5
            @Override // java.lang.Runnable
            public void run() {
                if (DplusCacheApi.this.f24745e.size() > 0) {
                    DBManager.get(context).delete(DplusCacheApi.this.f24745e, "s_e");
                    DplusCacheApi.this.f24745e.clear();
                }
                if (DplusCacheApi.this.f24746f.size() > 0) {
                    DBManager.get(context).delete(DplusCacheApi.this.f24746f, "auth");
                    DplusCacheApi.this.f24746f.clear();
                }
                if (DplusCacheApi.this.f24748h.size() > 0) {
                    DBManager.get(context).delete(DplusCacheApi.this.f24748h, "dau");
                    DplusCacheApi.this.f24748h.clear();
                }
                if (DplusCacheApi.this.f24747g.size() > 0) {
                    DBManager.get(context).delete(DplusCacheApi.this.f24747g, "userinfo");
                    DplusCacheApi.this.f24747g.clear();
                }
                if (DplusCacheApi.this.f24749i.size() > 0) {
                    DBManager.get(context).delete(DplusCacheApi.this.f24749i, "stats");
                    DplusCacheApi.this.f24749i.clear();
                }
            }
        });
    }

    public void deleteFileAsnc(Context context) {
        if (this.f24745e.size() > 0) {
            DBManager.get(context).delete(this.f24745e, "s_e");
            this.f24745e.clear();
        }
        if (this.f24746f.size() > 0) {
            DBManager.get(context).delete(this.f24746f, "auth");
            this.f24746f.clear();
        }
        if (this.f24748h.size() > 0) {
            DBManager.get(context).delete(this.f24748h, "dau");
            this.f24748h.clear();
        }
        if (this.f24747g.size() > 0) {
            DBManager.get(context).delete(this.f24747g, "userinfo");
            this.f24747g.clear();
        }
        if (this.f24749i.size() > 0) {
            DBManager.get(context).delete(this.f24749i, "stats");
            this.f24749i.clear();
        }
    }

    public void readFile(final Context context, final int i10, final DplusCacheListener dplusCacheListener) {
        this.f24743c.post(new Runnable() { // from class: com.umeng.socialize.net.dplus.cache1.DplusCacheApi.4
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // java.lang.Runnable
            public void run() {
                JSONArray jSONArray;
                JSONArray jSONArray2;
                JSONArray jSONArray3;
                JSONArray jSONArray4;
                JSONArray jSONArray5;
                JSONArray jSONArray6;
                double dCheckFile = DplusCacheApi.checkFile();
                if (dCheckFile >= 5242880.0d) {
                    DBManager.get(ContextUtil.getContext()).deleteTable("stats");
                    return;
                }
                boolean z10 = 1048576.0d <= dCheckFile + 24576.0d;
                JSONObject jSONObject = new JSONObject();
                try {
                    new JSONObject();
                    JSONObject jSONObject2 = new JSONObject();
                    JSONArray jSONArraySelect = DBManager.get(context).select("s_e", DplusCacheApi.this.f24745e, 1047552.0d, z10);
                    double length = 1024.0d + ((double) jSONArraySelect.toString().getBytes().length);
                    JSONArray jSONArraySelect2 = DBManager.get(context).select("auth", DplusCacheApi.this.f24746f, 1048576.0d - length, z10);
                    double length2 = length + ((double) jSONArraySelect2.toString().getBytes().length);
                    JSONArray jSONArraySelect3 = DBManager.get(context).select("userinfo", DplusCacheApi.this.f24747g, 1048576.0d - length2, z10);
                    double length3 = length2 + ((double) jSONArraySelect3.toString().getBytes().length);
                    JSONArray jSONArraySelect4 = DBManager.get(context).select("dau", DplusCacheApi.this.f24748h, 1048576.0d - length3, z10);
                    double length4 = length3 + ((double) jSONArraySelect4.toString().getBytes().length);
                    double dCheckFile2 = DplusCacheApi.checkFile();
                    if (jSONArraySelect4.length() != 0) {
                        jSONObject2.put("dau", jSONArraySelect4);
                    }
                    if (jSONArraySelect.length() != 0) {
                        jSONArray = jSONArraySelect;
                        jSONObject2.put("s_e", jSONArray);
                    } else {
                        jSONArray = jSONArraySelect;
                    }
                    if (jSONArraySelect2.length() != 0) {
                        jSONArray2 = jSONArraySelect2;
                        jSONObject2.put("auth", jSONArray2);
                    } else {
                        jSONArray2 = jSONArraySelect2;
                    }
                    if (jSONArraySelect3.length() != 0) {
                        jSONArray3 = jSONArraySelect3;
                        jSONObject2.put("userinfo", jSONArray3);
                    } else {
                        jSONArray3 = jSONArraySelect3;
                    }
                    JSONArray jSONArray7 = new JSONArray();
                    if (dCheckFile2 >= 524288.0d || i10 == 24583) {
                        double d10 = 1048576.0d - length4;
                        jSONArray4 = jSONArray;
                        jSONArray5 = jSONArray2;
                        jSONArray6 = jSONArraySelect4;
                        jSONArray7 = DBManager.get(context).select("stats", DplusCacheApi.this.f24749i, d10, z10);
                        if (jSONArray7.length() != 0) {
                            jSONObject2.put("stats", jSONArray7);
                        }
                    } else {
                        jSONArray4 = jSONArray;
                        jSONArray5 = jSONArray2;
                        jSONArray6 = jSONArraySelect4;
                    }
                    jSONObject.put("share", jSONObject2);
                    if (jSONArray4.length() == 0 && jSONArray5.length() == 0 && jSONArray3.length() == 0 && jSONArray6.length() == 0) {
                        if (jSONArray7.length() == 0) {
                            jSONObject = null;
                        }
                    }
                } catch (JSONException e10) {
                    SLog.error(UmengText.CACHE.CACHEFILE, e10);
                }
                if (jSONObject != null && jSONObject.toString().getBytes().length > 1048576.0d) {
                    dplusCacheListener.onResult(null);
                }
                dplusCacheListener.onResult(jSONObject);
            }
        });
    }

    public JSONObject readFileAsnc(Context context, int i10) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        JSONArray jSONArray3;
        JSONArray jSONArray4;
        JSONArray jSONArray5;
        JSONArray jSONArray6;
        double dCheckFile = checkFile();
        if (dCheckFile >= 5242880.0d) {
            DBManager.get(ContextUtil.getContext()).deleteTable("stats");
            return null;
        }
        boolean z10 = 1048576.0d <= dCheckFile + 24576.0d;
        JSONObject jSONObject = new JSONObject();
        try {
            new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArraySelect = DBManager.get(context).select("s_e", this.f24745e, 1047552.0d, z10);
            double length = 1024.0d + ((double) jSONArraySelect.toString().getBytes().length);
            JSONArray jSONArraySelect2 = DBManager.get(context).select("auth", this.f24746f, 1048576.0d - length, z10);
            double length2 = length + ((double) jSONArraySelect2.toString().getBytes().length);
            JSONArray jSONArraySelect3 = DBManager.get(context).select("userinfo", this.f24747g, 1048576.0d - length2, z10);
            double length3 = length2 + ((double) jSONArraySelect3.toString().getBytes().length);
            JSONArray jSONArraySelect4 = DBManager.get(context).select("dau", this.f24748h, 1048576.0d - length3, z10);
            double length4 = length3 + ((double) jSONArraySelect4.toString().getBytes().length);
            double dCheckFile2 = checkFile();
            if (jSONArraySelect4.length() != 0) {
                jSONObject2.put("dau", jSONArraySelect4);
            }
            if (jSONArraySelect.length() != 0) {
                jSONArray = jSONArraySelect;
                jSONObject2.put("s_e", jSONArray);
            } else {
                jSONArray = jSONArraySelect;
            }
            if (jSONArraySelect2.length() != 0) {
                jSONArray2 = jSONArraySelect2;
                jSONObject2.put("auth", jSONArray2);
            } else {
                jSONArray2 = jSONArraySelect2;
            }
            if (jSONArraySelect3.length() != 0) {
                jSONArray3 = jSONArraySelect3;
                jSONObject2.put("userinfo", jSONArray3);
            } else {
                jSONArray3 = jSONArraySelect3;
            }
            JSONArray jSONArray7 = new JSONArray();
            if (dCheckFile2 >= 524288.0d || i10 == 24583) {
                double d10 = 1048576.0d - length4;
                jSONArray4 = jSONArray;
                jSONArray5 = jSONArray2;
                jSONArray6 = jSONArraySelect4;
                jSONArray7 = DBManager.get(context).select("stats", this.f24749i, d10, z10);
                if (jSONArray7.length() != 0) {
                    jSONObject2.put("stats", jSONArray7);
                }
            } else {
                jSONArray4 = jSONArray;
                jSONArray5 = jSONArray2;
                jSONArray6 = jSONArraySelect4;
            }
            jSONObject.put("share", jSONObject2);
            if (jSONArray4.length() == 0 && jSONArray5.length() == 0 && jSONArray3.length() == 0 && jSONArray6.length() == 0) {
                if (jSONArray7.length() == 0) {
                    jSONObject = null;
                }
            }
        } catch (JSONException e10) {
            SLog.error(UmengText.CACHE.CACHEFILE, e10);
        }
        if (jSONObject == null || jSONObject.toString().getBytes().length <= 1048576.0d) {
            return jSONObject;
        }
        return null;
    }

    public void saveFile(final Context context, final JSONObject jSONObject, final int i10, final DplusCacheListener dplusCacheListener) {
        this.f24743c.post(new Runnable() { // from class: com.umeng.socialize.net.dplus.cache1.DplusCacheApi.3
            @Override // java.lang.Runnable
            public void run() {
                switch (i10) {
                    case SocializeConstants.DAU_EVENT /* 24577 */:
                        DBManager.get(context).insertDau(jSONObject);
                        break;
                    case SocializeConstants.SHARE_EVENT /* 24578 */:
                        DBManager.get(context).insertS_E(jSONObject);
                        break;
                    case SocializeConstants.AUTH_EVENT /* 24579 */:
                        DBManager.get(context).insertAuth(jSONObject);
                        break;
                    case SocializeConstants.GET_EVENT /* 24580 */:
                        DBManager.get(context).insertUserInfo(jSONObject);
                        break;
                    case SocializeConstants.SAVE_STATS_EVENT /* 24581 */:
                    case SocializeConstants.SEND_DAU_STATS_EVENT /* 24583 */:
                        DBManager.get(context).insertStats(jSONObject);
                        break;
                    case SocializeConstants.CHECK_STATS_EVENT /* 24582 */:
                    default:
                        DBManager.get(context).insertStats(jSONObject);
                        break;
                }
                dplusCacheListener.onResult(null);
            }
        });
    }

    private DplusCacheApi() {
        this.f24744d = 1048576;
        this.f24745e = new ArrayList<>();
        this.f24746f = new ArrayList<>();
        this.f24747g = new ArrayList<>();
        this.f24748h = new ArrayList<>();
        this.f24749i = new ArrayList<>();
        HandlerThread handlerThread = new HandlerThread(f24741a, 10);
        this.f24742b = handlerThread;
        handlerThread.start();
        this.f24743c = new Handler(this.f24742b.getLooper());
    }

    private static JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("s_sdk_v", "7.2.2");
        jSONObject.put(CommonNetImpl.PCV, SocializeConstants.PROTOCOL_VERSON);
        return jSONObject;
    }
}
