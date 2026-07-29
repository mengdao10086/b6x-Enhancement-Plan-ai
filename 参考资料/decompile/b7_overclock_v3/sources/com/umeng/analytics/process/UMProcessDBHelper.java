package com.umeng.analytics.process;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.umeng.analytics.process.DBFileTraversalUtil;
import com.umeng.analytics.process.a;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.utils.FileLockCallback;
import com.umeng.commonsdk.utils.FileLockUtil;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class UMProcessDBHelper {
    private static UMProcessDBHelper mInstance;
    private Context mContext;
    private FileLockUtil mFileLock = new FileLockUtil();
    private InsertEventCallback ekvCallBack = new InsertEventCallback();

    public class InsertEventCallback implements FileLockCallback {
        private InsertEventCallback() {
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(File file, int i10) {
            return false;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str) {
            return false;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str, Object obj) throws Throwable {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            String str2 = com.umeng.analytics.process.a.f23844c;
            if (str.startsWith(str2)) {
                str = str.replaceFirst(str2, "");
            }
            UMProcessDBHelper.this.insertEvents(str.replace(com.umeng.analytics.process.a.f23845d, ""), (JSONArray) obj);
            return true;
        }
    }

    public class ProcessToMainCallback implements FileLockCallback {
        private ProcessToMainCallback() {
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(File file, int i10) {
            return false;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str) throws Throwable {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            String str2 = com.umeng.analytics.process.a.f23844c;
            if (str.startsWith(str2)) {
                str = str.replaceFirst(str2, "");
            }
            UMProcessDBHelper.this.processToMain(str.replace(com.umeng.analytics.process.a.f23845d, ""));
            return true;
        }

        @Override // com.umeng.commonsdk.utils.FileLockCallback
        public boolean onFileLock(String str, Object obj) {
            return false;
        }
    }

    public class a implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f23833a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f23834b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f23835c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f23836d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f23837e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f23838f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f23839g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f23840h;

        private a() {
        }
    }

    private UMProcessDBHelper() {
    }

    private List<a> datasAdapter(String str, JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i10);
                a aVar = new a();
                aVar.f23835c = jSONObject.optString("id");
                aVar.f23839g = UMUtils.getAppVersionName(this.mContext);
                aVar.f23840h = UMUtils.getAppVersionCode(this.mContext);
                aVar.f23834b = jSONObject.optString("__i");
                aVar.f23837e = jSONObject.optInt("__t");
                aVar.f23838f = str;
                if (jSONObject.has("ds")) {
                    jSONObject.remove("ds");
                }
                jSONObject.put("ds", getDataSource());
                jSONObject.remove("__i");
                jSONObject.remove("__t");
                aVar.f23836d = com.umeng.common.a.a().a(jSONObject.toString());
                jSONObject.remove("ds");
                arrayList.add(aVar);
            } catch (Exception unused) {
            }
        }
        return arrayList;
    }

    private boolean dbIsExists(String str) {
        try {
            return new File(b.b(this.mContext, str)).exists();
        } catch (Throwable unused) {
            return false;
        }
    }

    private int getDataSource() {
        return 0;
    }

    public static UMProcessDBHelper getInstance(Context context) {
        if (mInstance == null) {
            synchronized (UMProcessDBHelper.class) {
                if (mInstance == null) {
                    mInstance = new UMProcessDBHelper(context);
                }
            }
        }
        UMProcessDBHelper uMProcessDBHelper = mInstance;
        uMProcessDBHelper.mContext = context;
        return uMProcessDBHelper;
    }

    private boolean insertEvents_(String str, List<a> list) throws Throwable {
        if (TextUtils.isEmpty(str) || list == null || list.isEmpty()) {
            return true;
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            SQLiteDatabase sQLiteDatabaseA = c.a(this.mContext).a(str);
            try {
                try {
                    sQLiteDatabaseA.beginTransaction();
                    for (a aVar : list) {
                        try {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("__i", aVar.f23834b);
                            contentValues.put("__e", aVar.f23835c);
                            contentValues.put("__t", Integer.valueOf(aVar.f23837e));
                            contentValues.put(a.InterfaceC0257a.f23855f, aVar.f23838f);
                            contentValues.put("__av", aVar.f23839g);
                            contentValues.put("__vc", aVar.f23840h);
                            contentValues.put("__s", aVar.f23836d);
                            sQLiteDatabaseA.insert(a.InterfaceC0257a.f23850a, null, contentValues);
                        } catch (Exception unused) {
                        }
                    }
                    sQLiteDatabaseA.setTransactionSuccessful();
                    try {
                        sQLiteDatabaseA.endTransaction();
                    } catch (Throwable unused2) {
                    }
                    c.a(this.mContext).b(str);
                    return true;
                } catch (Exception unused3) {
                    sQLiteDatabase = sQLiteDatabaseA;
                    if (sQLiteDatabase != null) {
                        try {
                            sQLiteDatabase.endTransaction();
                        } catch (Throwable unused4) {
                        }
                    }
                    c.a(this.mContext).b(str);
                    return false;
                }
            } catch (Throwable th2) {
                th = th2;
                sQLiteDatabase = sQLiteDatabaseA;
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable unused5) {
                    }
                }
                c.a(this.mContext).b(str);
                throw th;
            }
        } catch (Exception unused6) {
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private boolean processIsService(Context context) {
        return context.getPackageManager().getServiceInfo(new ComponentName(context, this.mContext.getClass()), 0) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processToMain(String str) throws Throwable {
        if (dbIsExists(str)) {
            List<a> eventByProcess = readEventByProcess(str);
            if (!eventByProcess.isEmpty() && insertEvents_(com.umeng.analytics.process.a.f23849h, eventByProcess)) {
                deleteEventDatas(str, null, eventByProcess);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c2 A[Catch: Exception -> 0x00c5, TRY_LEAVE, TryCatch #6 {Exception -> 0x00c5, blocks: (B:33:0x00bd, B:35:0x00c2), top: B:45:0x00bd }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00bd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.umeng.analytics.process.UMProcessDBHelper$1] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.util.List<com.umeng.analytics.process.UMProcessDBHelper.a> readEventByProcess(java.lang.String r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 207
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.process.UMProcessDBHelper.readEventByProcess(java.lang.String):java.util.List");
    }

    public void createDBByProcess(String str) {
        try {
            c.a(this.mContext).a(str);
            c.a(this.mContext).b(str);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void deleteEventDatas(String str, String str2, List<a> list) throws Throwable {
        SQLiteDatabase sQLiteDatabaseA;
        Throwable th2;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SQLiteDatabase sQLiteDatabase = null;
        try {
            sQLiteDatabaseA = c.a(this.mContext).a(str);
        } catch (Exception unused) {
        } catch (Throwable th3) {
            sQLiteDatabaseA = null;
            th2 = th3;
        }
        try {
            sQLiteDatabaseA.beginTransaction();
            int size = list.size();
            if (size > 0) {
                for (int i10 = 0; i10 < size; i10++) {
                    sQLiteDatabaseA.execSQL("delete from __et_p where rowid=" + list.get(i10).f23833a);
                }
            } else {
                sQLiteDatabaseA.delete(a.InterfaceC0257a.f23850a, null, null);
            }
            sQLiteDatabaseA.setTransactionSuccessful();
            sQLiteDatabaseA.endTransaction();
        } catch (Exception unused2) {
            sQLiteDatabase = sQLiteDatabaseA;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
        } catch (Throwable th4) {
            th2 = th4;
            if (sQLiteDatabaseA != null) {
                sQLiteDatabaseA.endTransaction();
            }
            c.a(this.mContext).b(str);
            throw th2;
        }
        c.a(this.mContext).b(str);
    }

    public void deleteMainProcessEventDatasByIds(List<Integer> list) {
        SQLiteDatabase sQLiteDatabaseA = null;
        try {
            sQLiteDatabaseA = c.a(this.mContext).a(com.umeng.analytics.process.a.f23849h);
            sQLiteDatabaseA.beginTransaction();
            Iterator<Integer> it2 = list.iterator();
            while (it2.hasNext()) {
                sQLiteDatabaseA.delete(a.InterfaceC0257a.f23850a, "id=?", new String[]{String.valueOf(it2.next())});
            }
            sQLiteDatabaseA.setTransactionSuccessful();
        } catch (Exception unused) {
            if (sQLiteDatabaseA != null) {
            }
            c.a(this.mContext).b(com.umeng.analytics.process.a.f23849h);
        } catch (Throwable th2) {
            if (sQLiteDatabaseA != null) {
                sQLiteDatabaseA.endTransaction();
            }
            c.a(this.mContext).b(com.umeng.analytics.process.a.f23849h);
            throw th2;
        }
        sQLiteDatabaseA.endTransaction();
        c.a(this.mContext).b(com.umeng.analytics.process.a.f23849h);
    }

    public void insertEvents(String str, JSONArray jSONArray) throws Throwable {
        if (AnalyticsConstants.SUB_PROCESS_EVENT && !TextUtils.isEmpty(str)) {
            insertEvents_(str, datasAdapter(str, jSONArray));
        }
    }

    public void insertEventsInSubProcess(String str, JSONArray jSONArray) throws Throwable {
        if (AnalyticsConstants.SUB_PROCESS_EVENT && !TextUtils.isEmpty(str)) {
            File file = new File(b.b(this.mContext, str));
            if (file.exists()) {
                this.mFileLock.doFileOperateion(file, this.ekvCallBack, jSONArray);
            } else {
                insertEvents(str, jSONArray);
            }
        }
    }

    public void processDBToMain() {
        try {
            DBFileTraversalUtil.traverseDBFiles(b.a(this.mContext), new ProcessToMainCallback(), new DBFileTraversalUtil.a() { // from class: com.umeng.analytics.process.UMProcessDBHelper.1
                @Override // com.umeng.analytics.process.DBFileTraversalUtil.a
                public void a() {
                    if (AnalyticsConstants.SUB_PROCESS_EVENT) {
                        UMWorkDispatch.sendEvent(UMProcessDBHelper.this.mContext, UMProcessDBDatasSender.UM_PROCESS_CONSTRUCTMESSAGE, UMProcessDBDatasSender.getInstance(UMProcessDBHelper.this.mContext), null);
                    }
                }
            });
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0187 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.json.JSONObject readMainEvents(long r20, java.util.List<java.lang.Integer> r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 404
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.process.UMProcessDBHelper.readMainEvents(long, java.util.List):org.json.JSONObject");
    }

    public JSONObject readVersionInfoFromColumId(Integer num) throws Throwable {
        SQLiteDatabase sQLiteDatabaseA;
        JSONObject jSONObject;
        Cursor cursor = null;
        jSONObject = null;
        JSONObject jSONObject2 = null;
        cursor = null;
        cursor = null;
        cursor = null;
        try {
            sQLiteDatabaseA = c.a(this.mContext).a(com.umeng.analytics.process.a.f23849h);
            try {
                try {
                    sQLiteDatabaseA.beginTransaction();
                    Cursor cursorQuery = sQLiteDatabaseA.query(a.InterfaceC0257a.f23850a, null, "rowid=?", new String[]{String.valueOf(num)}, null, null, null);
                    if (cursorQuery != null) {
                        try {
                            try {
                                if (cursorQuery.moveToNext()) {
                                    jSONObject = new JSONObject();
                                    try {
                                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("__av"));
                                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("__vc"));
                                        if (!TextUtils.isEmpty(string)) {
                                            jSONObject.put("__av", string);
                                        }
                                        if (!TextUtils.isEmpty(string2)) {
                                            jSONObject.put("__vc", string2);
                                        }
                                        jSONObject2 = jSONObject;
                                    } catch (Exception e10) {
                                        e = e10;
                                        cursor = cursorQuery;
                                        e.printStackTrace();
                                        if (cursor != null) {
                                            try {
                                                cursor.close();
                                            } catch (Exception unused) {
                                                c.a(this.mContext).b(com.umeng.analytics.process.a.f23849h);
                                                return jSONObject;
                                            }
                                        }
                                        if (sQLiteDatabaseA != null) {
                                            sQLiteDatabaseA.endTransaction();
                                        }
                                        c.a(this.mContext).b(com.umeng.analytics.process.a.f23849h);
                                        return jSONObject;
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                cursor = cursorQuery;
                                if (cursor != null) {
                                    try {
                                        cursor.close();
                                    } catch (Exception unused2) {
                                        c.a(this.mContext).b(com.umeng.analytics.process.a.f23849h);
                                        throw th;
                                    }
                                }
                                if (sQLiteDatabaseA != null) {
                                    sQLiteDatabaseA.endTransaction();
                                }
                                c.a(this.mContext).b(com.umeng.analytics.process.a.f23849h);
                                throw th;
                            }
                        } catch (Exception e11) {
                            e = e11;
                            jSONObject = null;
                        }
                    }
                    if (cursorQuery != null) {
                        try {
                            cursorQuery.close();
                        } catch (Exception unused3) {
                        }
                    }
                    sQLiteDatabaseA.endTransaction();
                    c.a(this.mContext).b(com.umeng.analytics.process.a.f23849h);
                    return jSONObject2;
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Exception e12) {
                e = e12;
                jSONObject = null;
            }
        } catch (Exception e13) {
            e = e13;
            sQLiteDatabaseA = null;
            jSONObject = null;
        } catch (Throwable th4) {
            th = th4;
            sQLiteDatabaseA = null;
        }
    }

    private UMProcessDBHelper(Context context) {
        com.umeng.common.a.a().a(context);
    }
}
