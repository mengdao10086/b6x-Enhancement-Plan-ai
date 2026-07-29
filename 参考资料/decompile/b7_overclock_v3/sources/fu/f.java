package fu;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes6.dex */
public class f {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile f f28837g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f28838h;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BroadcastReceiver f28844f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f28839a = new a("udid");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f28840b = new a("oaid");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f28842d = new a("vaid");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f28841c = new a("aaid");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f28843e = new c();

    public static d a(Cursor cursor) {
        String str;
        d dVar = new d(null, 0);
        if (cursor == null) {
            str = "parseValue fail, cursor is null.";
        } else {
            if (!cursor.isClosed()) {
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex("value");
                if (columnIndex >= 0) {
                    dVar.f28834a = cursor.getString(columnIndex);
                } else {
                    e("parseValue fail, index < 0.");
                }
                int columnIndex2 = cursor.getColumnIndex("code");
                if (columnIndex2 >= 0) {
                    dVar.f28835b = cursor.getInt(columnIndex2);
                } else {
                    e("parseCode fail, index < 0.");
                }
                int columnIndex3 = cursor.getColumnIndex("expired");
                if (columnIndex3 >= 0) {
                    dVar.f28836c = cursor.getLong(columnIndex3);
                } else {
                    e("parseExpired fail, index < 0.");
                }
                return dVar;
            }
            str = "parseValue fail, cursor is closed.";
        }
        e(str);
        return dVar;
    }

    public static final f b() {
        if (f28837g == null) {
            synchronized (f.class) {
                if (f28837g == null) {
                    f28837g = new f();
                }
            }
        }
        return f28837g;
    }

    public static String d(PackageManager packageManager, String str) {
        ProviderInfo providerInfoResolveContentProvider;
        if (packageManager == null || (providerInfoResolveContentProvider = packageManager.resolveContentProvider(str, 0)) == null || (providerInfoResolveContentProvider.applicationInfo.flags & 1) == 0) {
            return null;
        }
        return providerInfoResolveContentProvider.packageName;
    }

    public static void e(String str) {
    }

    public static void f(boolean z10) {
        f28838h = z10;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean g(android.content.Context r8) {
        /*
            java.lang.String r0 = "querySupport version : 1.0.8"
            e(r0)
            java.lang.String r0 = "content://com.meizu.flyme.openidsdk/"
            android.net.Uri r2 = android.net.Uri.parse(r0)
            r0 = 0
            r7 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L41
            r3 = 0
            r4 = 0
            java.lang.String r8 = "supported"
            java.lang.String[] r5 = new java.lang.String[]{r8}     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L41
            r6 = 0
            android.database.Cursor r7 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L41
            if (r7 == 0) goto L39
            fu.d r8 = a(r7)     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L41
            r1 = 1000(0x3e8, float:1.401E-42)
            int r2 = r8.f28835b     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L41
            if (r1 != r2) goto L34
            java.lang.String r1 = "0"
            java.lang.String r8 = r8.f28834a     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L41
            boolean r8 = r1.equals(r8)     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L41
            if (r8 == 0) goto L35
        L34:
            r0 = 1
        L35:
            r7.close()
            return r0
        L39:
            if (r7 == 0) goto L5a
        L3b:
            r7.close()
            goto L5a
        L3f:
            r8 = move-exception
            goto L5b
        L41:
            r8 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3f
            java.lang.String r2 = "querySupport, Exception : "
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L3f
            java.lang.String r8 = r8.getMessage()     // Catch: java.lang.Throwable -> L3f
            r1.append(r8)     // Catch: java.lang.Throwable -> L3f
            java.lang.String r8 = r1.toString()     // Catch: java.lang.Throwable -> L3f
            e(r8)     // Catch: java.lang.Throwable -> L3f
            if (r7 == 0) goto L5a
            goto L3b
        L5a:
            return r0
        L5b:
            if (r7 == 0) goto L60
            r7.close()
        L60:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: fu.f.g(android.content.Context):boolean");
    }

    public static String j(PackageManager packageManager, String str) {
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
            return null;
        } catch (Exception e10) {
            e10.printStackTrace();
            e("getAppVersion, Exception : " + e10.getMessage());
            return null;
        }
    }

    public final String c(Context context, a aVar) {
        String str;
        if (aVar == null) {
            str = "getId, openId = null.";
        } else {
            if (aVar.d()) {
                return aVar.f28827b;
            }
            if (h(context, true)) {
                return i(context, aVar);
            }
            str = "getId, isSupported = false.";
        }
        e(str);
        return null;
    }

    public final boolean h(Context context, boolean z10) {
        if (this.f28843e.b() && !z10) {
            return this.f28843e.e();
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        String strD = d(packageManager, "com.meizu.flyme.openidsdk");
        if (TextUtils.isEmpty(strD)) {
            return false;
        }
        String strJ = j(packageManager, strD);
        if (this.f28843e.b() && this.f28843e.c(strJ)) {
            e("use same version cache, safeVersion : ".concat(String.valueOf(strJ)));
            return this.f28843e.e();
        }
        this.f28843e.d(strJ);
        boolean zG = g(context);
        e("query support, result : ".concat(String.valueOf(zG)));
        this.f28843e.a(zG);
        return zG;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0095  */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String i(android.content.Context r10, fu.a r11) throws java.lang.Throwable {
        /*
            r9 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "queryId : "
            r0.<init>(r1)
            java.lang.String r1 = r11.f28828c
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            e(r0)
            java.lang.String r0 = "content://com.meizu.flyme.openidsdk/"
            android.net.Uri r2 = android.net.Uri.parse(r0)
            r0 = 0
            android.content.ContentResolver r1 = r10.getContentResolver()     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            r3 = 0
            r4 = 0
            r7 = 1
            java.lang.String[] r5 = new java.lang.String[r7]     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            java.lang.String r6 = r11.f28828c     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            r8 = 0
            r5[r8] = r6     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            r6 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> La0 java.lang.Exception -> La2
            if (r1 == 0) goto L7e
            fu.d r2 = a(r1)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            java.lang.String r0 = r2.f28834a     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            r11.c(r0)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            long r3 = r2.f28836c     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            r11.b(r3)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            int r3 = r2.f28835b     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            r11.a(r3)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            r3.<init>()     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            java.lang.String r4 = r11.f28828c     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            r3.append(r4)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            java.lang.String r4 = " errorCode : "
            r3.append(r4)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            int r11 = r11.f28829d     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            r3.append(r11)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            java.lang.String r11 = r3.toString()     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            e(r11)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            int r11 = r2.f28835b     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            r2 = 1000(0x3e8, float:1.401E-42)
            if (r11 == r2) goto L93
            r9.k(r10)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            boolean r11 = r9.h(r10, r8)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            if (r11 != 0) goto L93
            boolean r10 = r9.h(r10, r7)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            java.lang.String r11 = "not support, forceQuery isSupported: "
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            java.lang.String r10 = r11.concat(r10)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
        L7a:
            e(r10)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            goto L93
        L7e:
            boolean r11 = r9.h(r10, r8)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            if (r11 == 0) goto L93
            boolean r10 = r9.h(r10, r7)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            java.lang.String r11 = "forceQuery isSupported : "
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            java.lang.String r10 = r11.concat(r10)     // Catch: java.lang.Throwable -> L99 java.lang.Exception -> L9c
            goto L7a
        L93:
            if (r1 == 0) goto Lbf
            r1.close()
            goto Lbf
        L99:
            r10 = move-exception
            r0 = r1
            goto Lc0
        L9c:
            r10 = move-exception
            r11 = r0
            r0 = r1
            goto La4
        La0:
            r10 = move-exception
            goto Lc0
        La2:
            r10 = move-exception
            r11 = r0
        La4:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La0
            java.lang.String r2 = "queryId, Exception : "
            r1.<init>(r2)     // Catch: java.lang.Throwable -> La0
            java.lang.String r10 = r10.getMessage()     // Catch: java.lang.Throwable -> La0
            r1.append(r10)     // Catch: java.lang.Throwable -> La0
            java.lang.String r10 = r1.toString()     // Catch: java.lang.Throwable -> La0
            e(r10)     // Catch: java.lang.Throwable -> La0
            if (r0 == 0) goto Lbe
            r0.close()
        Lbe:
            r0 = r11
        Lbf:
            return r0
        Lc0:
            if (r0 == 0) goto Lc5
            r0.close()
        Lc5:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: fu.f.i(android.content.Context, fu.a):java.lang.String");
    }

    public final synchronized void k(Context context) {
        if (this.f28844f != null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.meizu.flyme.openid.ACTION_OPEN_ID_CHANGE");
        e eVar = new e();
        this.f28844f = eVar;
        context.registerReceiver(eVar, intentFilter, "com.meizu.flyme.openid.permission.OPEN_ID_CHANGE", null);
    }
}
