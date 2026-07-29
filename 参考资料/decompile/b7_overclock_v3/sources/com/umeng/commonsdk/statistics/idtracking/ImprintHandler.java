package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.an;
import com.umeng.analytics.pro.az;
import com.umeng.analytics.pro.bf;
import com.umeng.analytics.pro.z;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import com.umeng.commonsdk.statistics.internal.UMImprintPreProcessCallback;
import com.umeng.commonsdk.utils.FileLockCallback;
import com.umeng.commonsdk.utils.FileLockUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes5.dex */
public class ImprintHandler implements FileLockCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24194a = "ImprintHandler";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static Context f24201k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static FileLockUtil f24202l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f24203m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f24204n = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.umeng.commonsdk.statistics.internal.d f24207e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private a f24208h = new a();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private com.umeng.commonsdk.statistics.proto.d f24209i = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Object f24195b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f24196c = z.b().b(z.f23797c);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final byte[] f24197d = "pbl0".getBytes();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Map<String, ArrayList<UMImprintChangeCallback>> f24198f = new HashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Object f24199g = new Object();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static ImprintHandler f24200j = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static Map<String, UMImprintPreProcessCallback> f24205o = new HashMap();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static Object f24206p = new Object();

    private ImprintHandler(Context context) {
        f24201k = context.getApplicationContext();
    }

    private static void a(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        synchronized (f24199g) {
            try {
                int i10 = 0;
                if (f24198f.containsKey(str)) {
                    ArrayList<UMImprintChangeCallback> arrayList = f24198f.get(str);
                    int size = arrayList.size();
                    ULog.i("--->>> addCallback: before add: callbacks size is: " + size);
                    while (i10 < size) {
                        if (uMImprintChangeCallback == arrayList.get(i10)) {
                            ULog.i("--->>> addCallback: callback has exist, just exit");
                            return;
                        }
                        i10++;
                    }
                    arrayList.add(uMImprintChangeCallback);
                    ULog.i("--->>> addCallback: after add: callbacks size is: " + arrayList.size());
                } else {
                    ArrayList<UMImprintChangeCallback> arrayList2 = new ArrayList<>();
                    int size2 = arrayList2.size();
                    ULog.i("--->>> addCallback: before add: callbacks size is: " + size2);
                    while (i10 < size2) {
                        if (uMImprintChangeCallback == arrayList2.get(i10)) {
                            ULog.i("--->>> addCallback: callback has exist, just exit");
                            return;
                        }
                        i10++;
                    }
                    arrayList2.add(uMImprintChangeCallback);
                    ULog.i("--->>> addCallback: after add: callbacks size is: " + arrayList2.size());
                    f24198f.put(str, arrayList2);
                }
            } catch (Throwable th2) {
                UMCrashManager.reportCrash(f24201k, th2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x009d A[Catch: all -> 0x009f, DONT_GENERATE, TryCatch #1 {, blocks: (B:24:0x009d, B:23:0x0098, B:8:0x000d, B:10:0x0015, B:12:0x0023, B:14:0x003e, B:16:0x0044, B:17:0x005c, B:18:0x005f, B:20:0x007d), top: B:30:0x000d, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void b(java.lang.String r5, com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback r6) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 != 0) goto La2
            if (r6 != 0) goto La
            goto La2
        La:
            java.lang.Object r0 = com.umeng.commonsdk.statistics.idtracking.ImprintHandler.f24199g
            monitor-enter(r0)
            java.util.Map<java.lang.String, java.util.ArrayList<com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback>> r1 = com.umeng.commonsdk.statistics.idtracking.ImprintHandler.f24198f     // Catch: java.lang.Throwable -> L97
            boolean r1 = r1.containsKey(r5)     // Catch: java.lang.Throwable -> L97
            if (r1 == 0) goto L9d
            java.util.Map<java.lang.String, java.util.ArrayList<com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback>> r1 = com.umeng.commonsdk.statistics.idtracking.ImprintHandler.f24198f     // Catch: java.lang.Throwable -> L97
            java.lang.Object r1 = r1.get(r5)     // Catch: java.lang.Throwable -> L97
            java.util.ArrayList r1 = (java.util.ArrayList) r1     // Catch: java.lang.Throwable -> L97
            int r2 = r1.size()     // Catch: java.lang.Throwable -> L97
            if (r2 <= 0) goto L9d
            int r2 = r1.size()     // Catch: java.lang.Throwable -> L97
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L97
            r3.<init>()     // Catch: java.lang.Throwable -> L97
            java.lang.String r4 = "--->>> removeCallback: before remove: callbacks size is: "
            r3.append(r4)     // Catch: java.lang.Throwable -> L97
            r3.append(r2)     // Catch: java.lang.Throwable -> L97
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L97
            com.umeng.commonsdk.statistics.common.ULog.i(r3)     // Catch: java.lang.Throwable -> L97
            r3 = 0
        L3c:
            if (r3 >= r2) goto L5f
            java.lang.Object r4 = r1.get(r3)     // Catch: java.lang.Throwable -> L97
            if (r6 != r4) goto L5c
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L97
            r6.<init>()     // Catch: java.lang.Throwable -> L97
            java.lang.String r2 = "--->>> removeCallback: remove index "
            r6.append(r2)     // Catch: java.lang.Throwable -> L97
            r6.append(r3)     // Catch: java.lang.Throwable -> L97
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L97
            com.umeng.commonsdk.statistics.common.ULog.i(r6)     // Catch: java.lang.Throwable -> L97
            r1.remove(r3)     // Catch: java.lang.Throwable -> L97
            goto L5f
        L5c:
            int r3 = r3 + 1
            goto L3c
        L5f:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L97
            r6.<init>()     // Catch: java.lang.Throwable -> L97
            java.lang.String r2 = "--->>> removeCallback: after remove: callbacks size is: "
            r6.append(r2)     // Catch: java.lang.Throwable -> L97
            int r2 = r1.size()     // Catch: java.lang.Throwable -> L97
            r6.append(r2)     // Catch: java.lang.Throwable -> L97
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L97
            com.umeng.commonsdk.statistics.common.ULog.i(r6)     // Catch: java.lang.Throwable -> L97
            int r6 = r1.size()     // Catch: java.lang.Throwable -> L97
            if (r6 != 0) goto L9d
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L97
            r6.<init>()     // Catch: java.lang.Throwable -> L97
            java.lang.String r1 = "--->>> removeCallback: remove key from map: key = "
            r6.append(r1)     // Catch: java.lang.Throwable -> L97
            r6.append(r5)     // Catch: java.lang.Throwable -> L97
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L97
            com.umeng.commonsdk.statistics.common.ULog.i(r6)     // Catch: java.lang.Throwable -> L97
            java.util.Map<java.lang.String, java.util.ArrayList<com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback>> r6 = com.umeng.commonsdk.statistics.idtracking.ImprintHandler.f24198f     // Catch: java.lang.Throwable -> L97
            r6.remove(r5)     // Catch: java.lang.Throwable -> L97
            goto L9d
        L97:
            r5 = move-exception
            android.content.Context r6 = com.umeng.commonsdk.statistics.idtracking.ImprintHandler.f24201k     // Catch: java.lang.Throwable -> L9f
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r6, r5)     // Catch: java.lang.Throwable -> L9f
        L9d:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L9f
            return
        L9f:
            r5 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L9f
            throw r5
        La2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.idtracking.ImprintHandler.b(java.lang.String, com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback):void");
    }

    private boolean c(com.umeng.commonsdk.statistics.proto.d dVar) {
        if (!dVar.i().equals(a(dVar))) {
            return false;
        }
        for (com.umeng.commonsdk.statistics.proto.e eVar : dVar.c().values()) {
            String strH = eVar.h();
            if (!TextUtils.isEmpty(strH)) {
                byte[] bArrReverseHexString = DataHelper.reverseHexString(strH);
                byte[] bArrA = a(eVar);
                for (int i10 = 0; i10 < 4; i10++) {
                    if (bArrReverseHexString[i10] != bArrA[i10]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private com.umeng.commonsdk.statistics.proto.d d(com.umeng.commonsdk.statistics.proto.d dVar) {
        Map<String, com.umeng.commonsdk.statistics.proto.e> mapC = dVar.c();
        if (mapC.containsKey(an.f23240f)) {
            mapC.remove(an.f23240f);
            this.f24208h.a(an.f23240f);
            dVar.a(dVar.f());
            dVar.a(a(dVar));
        }
        return dVar;
    }

    private com.umeng.commonsdk.statistics.proto.d e(com.umeng.commonsdk.statistics.proto.d dVar) {
        ArrayList<UMImprintChangeCallback> arrayList;
        boolean z10;
        ArrayList<UMImprintChangeCallback> arrayList2;
        UMImprintPreProcessCallback uMImprintPreProcessCallback;
        Map<String, com.umeng.commonsdk.statistics.proto.e> mapC = dVar.c();
        ArrayList<String> arrayList3 = new ArrayList(mapC.size() / 2);
        Iterator<Map.Entry<String, com.umeng.commonsdk.statistics.proto.e>> it2 = mapC.entrySet().iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> next = it2.next();
            if (next.getValue().d()) {
                String key = next.getKey();
                String str = next.getValue().f24356a;
                synchronized (f24206p) {
                    z10 = !TextUtils.isEmpty(key) && f24205o.containsKey(key) && (uMImprintPreProcessCallback = f24205o.get(key)) != null && uMImprintPreProcessCallback.onPreProcessImprintKey(key, str);
                }
                if (z10) {
                    arrayList3.add(key);
                }
                synchronized (f24199g) {
                    if (!TextUtils.isEmpty(key) && f24198f.containsKey(key) && (arrayList2 = f24198f.get(key)) != null) {
                        for (int i10 = 0; i10 < arrayList2.size(); i10++) {
                            arrayList2.get(i10).onImprintValueChanged(key, str);
                        }
                    }
                }
            } else {
                arrayList3.add(next.getKey());
            }
        }
        for (String str2 : arrayList3) {
            synchronized (f24199g) {
                if (!TextUtils.isEmpty(str2) && f24198f.containsKey(str2) && (arrayList = f24198f.get(str2)) != null) {
                    for (int i11 = 0; i11 < arrayList.size(); i11++) {
                        arrayList.get(i11).onImprintValueChanged(str2, null);
                    }
                }
            }
            mapC.remove(str2);
        }
        return dVar;
    }

    public static synchronized ImprintHandler getImprintService(Context context) {
        if (f24200j == null) {
            f24200j = new ImprintHandler(context);
            f24202l = new FileLockUtil();
            f24202l.doFileOperateion(new File(f24201k.getFilesDir(), f24196c), f24200j, 0);
        }
        return f24200j;
    }

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(File file, int i10) {
        if (i10 == 0) {
            f24200j.e();
        } else if (i10 == 1) {
            f24200j.a(file);
        }
        return true;
    }

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(String str) {
        return false;
    }

    @Override // com.umeng.commonsdk.utils.FileLockCallback
    public boolean onFileLock(String str, Object obj) {
        return false;
    }

    public void registImprintCallback(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        if (TextUtils.isEmpty(str) || uMImprintChangeCallback == null) {
            return;
        }
        a(str, uMImprintChangeCallback);
    }

    public void registPreProcessCallback(String str, UMImprintPreProcessCallback uMImprintPreProcessCallback) {
        if (TextUtils.isEmpty(str) || uMImprintPreProcessCallback == null) {
            return;
        }
        synchronized (f24206p) {
            try {
                if (f24205o.containsKey(str)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> key : " + str + " PreProcesser has registed!");
                } else {
                    f24205o.put(str, uMImprintPreProcessCallback);
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> registPreProcessCallback: key : " + str + " regist success.");
                }
            } finally {
            }
        }
    }

    public void unregistImprintCallback(String str, UMImprintChangeCallback uMImprintChangeCallback) {
        if (TextUtils.isEmpty(str) || uMImprintChangeCallback == null) {
            return;
        }
        b(str, uMImprintChangeCallback);
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Map<String, String> f24210a = new HashMap();

        public a() {
        }

        private synchronized void b(com.umeng.commonsdk.statistics.proto.d dVar) {
            com.umeng.commonsdk.statistics.proto.e eVar;
            if (dVar != null) {
                try {
                    if (dVar.e()) {
                        Map<String, com.umeng.commonsdk.statistics.proto.e> mapC = dVar.c();
                        for (String str : mapC.keySet()) {
                            if (!TextUtils.isEmpty(str) && (eVar = mapC.get(str)) != null) {
                                String strB = eVar.b();
                                if (!TextUtils.isEmpty(strB)) {
                                    this.f24210a.put(str, strB);
                                    if (AnalyticsConstants.UM_DEBUG) {
                                        StringBuilder sb2 = new StringBuilder();
                                        sb2.append("imKey is ");
                                        sb2.append(str);
                                        sb2.append(", imValue is ");
                                        sb2.append(strB);
                                    }
                                }
                            }
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }

        public synchronized void a(String str) {
            Map<String, String> map = this.f24210a;
            if (map != null && map.size() > 0 && !TextUtils.isEmpty(str) && this.f24210a.containsKey(str)) {
                this.f24210a.remove(str);
            }
        }

        public a(com.umeng.commonsdk.statistics.proto.d dVar) {
            a(dVar);
        }

        public void a(com.umeng.commonsdk.statistics.proto.d dVar) {
            if (dVar == null) {
                return;
            }
            b(dVar);
        }

        public synchronized String a(String str, String str2) {
            if (!TextUtils.isEmpty(str) && this.f24210a.size() > 0) {
                String str3 = this.f24210a.get(str);
                return !TextUtils.isEmpty(str3) ? str3 : str2;
            }
            return str2;
        }
    }

    public void d() {
        if (this.f24209i == null || f24202l == null) {
            return;
        }
        File file = new File(f24201k.getFilesDir(), f24196c);
        if (!file.exists()) {
            try {
                try {
                    file.createNewFile();
                } catch (IOException e10) {
                    UMCrashManager.reportCrash(f24201k, e10);
                }
            } catch (IOException unused) {
                file.createNewFile();
            }
        }
        f24202l.doFileOperateion(file, f24200j, 1);
    }

    public a c() {
        return this.f24208h;
    }

    public void b(com.umeng.commonsdk.statistics.proto.d dVar) {
        com.umeng.commonsdk.statistics.proto.d dVarA;
        boolean z10;
        if (dVar == null) {
            if (AnalyticsConstants.UM_DEBUG) {
                UMRTLog.d(UMRTLog.RTLOG_TAG, "Imprint is null");
                return;
            }
            return;
        }
        if (!c(dVar)) {
            if (AnalyticsConstants.UM_DEBUG) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "Imprint is not valid");
                return;
            }
            return;
        }
        boolean z11 = AnalyticsConstants.UM_DEBUG;
        HashMap map = new HashMap();
        synchronized (this) {
            com.umeng.commonsdk.statistics.proto.d dVar2 = this.f24209i;
            com.umeng.commonsdk.statistics.proto.d dVarD = d(dVar);
            String strI = null;
            String strI2 = dVar2 == null ? null : dVar2.i();
            if (dVar2 == null) {
                dVarA = e(dVarD);
            } else {
                dVarA = a(dVar2, dVarD, map);
            }
            this.f24209i = dVarA;
            if (dVarA != null) {
                strI = dVarA.i();
            }
            z10 = !a(strI2, strI);
        }
        com.umeng.commonsdk.statistics.proto.d dVar3 = this.f24209i;
        if (dVar3 != null && z10) {
            this.f24208h.a(dVar3);
            com.umeng.commonsdk.statistics.internal.d dVar4 = this.f24207e;
            if (dVar4 != null) {
                dVar4.onImprintChanged(this.f24208h);
            }
        }
        if (map.size() > 0) {
            synchronized (f24199g) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(key) && f24198f.containsKey(key)) {
                        ULog.i("--->>> target imprint key is: " + key + "; value is: " + value);
                        ArrayList<UMImprintChangeCallback> arrayList = f24198f.get(key);
                        if (arrayList != null) {
                            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                                arrayList.get(i10).onImprintValueChanged(key, value);
                            }
                        }
                    }
                }
            }
        }
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (f24206p) {
            try {
                if (f24205o.containsKey(str)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> unregistPreProcessCallback: unregist [" + str + "] success.");
                    f24198f.remove(str);
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> unregistPreProcessCallback: can't find [" + str + "], pls regist first.");
                }
            } finally {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v3, types: [android.content.Context] */
    private void e() {
        Throwable th2;
        FileInputStream fileInputStreamOpenFileInput;
        File filesDir = f24201k.getFilesDir();
        ?? r22 = f24196c;
        File file = new File(filesDir, (String) r22);
        synchronized (f24195b) {
            if (file.exists()) {
                byte[] streamToByteArray = null;
                try {
                    try {
                        fileInputStreamOpenFileInput = f24201k.openFileInput(r22);
                        try {
                            streamToByteArray = HelperUtils.readStreamToByteArray(fileInputStreamOpenFileInput);
                            r22 = fileInputStreamOpenFileInput;
                        } catch (Exception e10) {
                            e = e10;
                            e.printStackTrace();
                            r22 = fileInputStreamOpenFileInput;
                        }
                    } catch (Throwable th3) {
                        th2 = th3;
                        HelperUtils.safeClose((InputStream) r22);
                        throw th2;
                    }
                } catch (Exception e11) {
                    e = e11;
                    fileInputStreamOpenFileInput = null;
                } catch (Throwable th4) {
                    r22 = 0;
                    th2 = th4;
                    HelperUtils.safeClose((InputStream) r22);
                    throw th2;
                }
                HelperUtils.safeClose((InputStream) r22);
                if (streamToByteArray != null) {
                    try {
                        com.umeng.commonsdk.statistics.proto.d dVar = new com.umeng.commonsdk.statistics.proto.d();
                        new az().a(dVar, streamToByteArray);
                        this.f24209i = dVar;
                        this.f24208h.a(dVar);
                        this.f24209i = d(this.f24209i);
                    } catch (Exception e12) {
                        e12.printStackTrace();
                    }
                }
            }
        }
    }

    public void a(com.umeng.commonsdk.statistics.internal.d dVar) {
        this.f24207e = dVar;
    }

    public String a(com.umeng.commonsdk.statistics.proto.d dVar) {
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry entry : new TreeMap(dVar.c()).entrySet()) {
            sb2.append((String) entry.getKey());
            if (((com.umeng.commonsdk.statistics.proto.e) entry.getValue()).d()) {
                sb2.append(((com.umeng.commonsdk.statistics.proto.e) entry.getValue()).b());
            }
        }
        sb2.append(dVar.f24338b);
        return HelperUtils.MD5(sb2.toString()).toLowerCase(Locale.US);
    }

    public byte[] a(com.umeng.commonsdk.statistics.proto.e eVar) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(null);
        byteBufferAllocate.putLong(eVar.e());
        byte[] bArrArray = byteBufferAllocate.array();
        byte[] bArr = f24197d;
        byte[] bArr2 = new byte[4];
        for (int i10 = 0; i10 < 4; i10++) {
            bArr2[i10] = (byte) (bArrArray[i10] ^ bArr[i10]);
        }
        return bArr2;
    }

    public byte[] a() {
        try {
            synchronized (this) {
                com.umeng.commonsdk.statistics.proto.d dVar = this.f24209i;
                if (dVar == null) {
                    return null;
                }
                if (dVar.b() <= 0) {
                    return null;
                }
                return new bf().a(this.f24209i);
            }
        } catch (Throwable th2) {
            UMCrashManager.reportCrash(f24201k, th2);
            return null;
        }
    }

    public synchronized com.umeng.commonsdk.statistics.proto.d b() {
        return this.f24209i;
    }

    private boolean a(String str, String str2) {
        if (str == null) {
            return str2 == null;
        }
        return str.equals(str2);
    }

    private com.umeng.commonsdk.statistics.proto.d a(com.umeng.commonsdk.statistics.proto.d dVar, com.umeng.commonsdk.statistics.proto.d dVar2, Map<String, String> map) {
        UMImprintPreProcessCallback uMImprintPreProcessCallback;
        ArrayList<UMImprintChangeCallback> arrayList;
        if (dVar2 == null) {
            return dVar;
        }
        Map<String, com.umeng.commonsdk.statistics.proto.e> mapC = dVar.c();
        for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar2.c().entrySet()) {
            int i10 = 0;
            if (entry.getValue().d()) {
                String key = entry.getKey();
                String str = entry.getValue().f24356a;
                synchronized (f24206p) {
                    if (!TextUtils.isEmpty(key) && f24205o.containsKey(key) && (uMImprintPreProcessCallback = f24205o.get(key)) != null && uMImprintPreProcessCallback.onPreProcessImprintKey(key, str)) {
                        i10 = 1;
                    }
                }
                if (i10 == 0) {
                    mapC.put(entry.getKey(), entry.getValue());
                    synchronized (f24199g) {
                        if (!TextUtils.isEmpty(key) && f24198f.containsKey(key) && f24198f.get(key) != null) {
                            map.put(key, str);
                        }
                    }
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> merge: [" + key + "] should be ignored.");
                }
            } else {
                String key2 = entry.getKey();
                synchronized (f24199g) {
                    if (!TextUtils.isEmpty(key2) && f24198f.containsKey(key2) && (arrayList = f24198f.get(key2)) != null) {
                        while (i10 < arrayList.size()) {
                            arrayList.get(i10).onImprintValueChanged(key2, null);
                            i10++;
                        }
                    }
                }
                mapC.remove(key2);
                this.f24208h.a(key2);
            }
        }
        dVar.a(dVar2.f());
        dVar.a(a(dVar));
        return dVar;
    }

    private void a(File file) {
        if (this.f24209i == null) {
            return;
        }
        try {
            synchronized (f24195b) {
                byte[] bArrA = new bf().a(this.f24209i);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    fileOutputStream.write(bArrA);
                    fileOutputStream.flush();
                } finally {
                    HelperUtils.safeClose(fileOutputStream);
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
