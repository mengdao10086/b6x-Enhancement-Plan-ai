package com.umeng.analytics.pro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.pro.e;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f23598a = 2049;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f23599b = 2050;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f23600c = 1000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Context f23601d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f23602e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f23603f = "umeng+";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f23604g = "ek__id";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f23605h = "ek_key";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List<String> f23606i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private List<Integer> f23607j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f23608k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private List<String> f23609l;

    public enum a {
        AUTOPAGE,
        PAGE,
        BEGIN,
        END,
        NEWSESSION,
        INSTANTSESSIONBEGIN
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final i f23617a = new i();

        private b() {
        }
    }

    public static i a(Context context) {
        i iVar = b.f23617a;
        if (f23601d == null && context != null) {
            f23601d = context.getApplicationContext();
            iVar.k();
        }
        return iVar;
    }

    private void k() {
        synchronized (this) {
            l();
            this.f23606i.clear();
            this.f23609l.clear();
            this.f23607j.clear();
        }
    }

    private void l() {
        try {
            if (TextUtils.isEmpty(f23602e)) {
                String multiProcessSP = UMUtils.getMultiProcessSP(f23601d, f23604g);
                if (TextUtils.isEmpty(multiProcessSP)) {
                    multiProcessSP = PreferenceWrapper.getDefault(f23601d).getString(f23604g, null);
                    if (TextUtils.isEmpty(multiProcessSP)) {
                        multiProcessSP = UMUtils.genId();
                    }
                    if (!TextUtils.isEmpty(multiProcessSP)) {
                        UMUtils.setMultiProcessSP(f23601d, f23604g, multiProcessSP);
                    }
                }
                if (!TextUtils.isEmpty(multiProcessSP)) {
                    String strSubstring = multiProcessSP.substring(1, 9);
                    StringBuilder sb2 = new StringBuilder();
                    for (int i10 = 0; i10 < strSubstring.length(); i10++) {
                        char cCharAt = strSubstring.charAt(i10);
                        if (!Character.isDigit(cCharAt)) {
                            sb2.append(cCharAt);
                        } else if (Integer.parseInt(Character.toString(cCharAt)) == 0) {
                            sb2.append(0);
                        } else {
                            sb2.append(10 - Integer.parseInt(Character.toString(cCharAt)));
                        }
                    }
                    f23602e = sb2.toString();
                }
                if (TextUtils.isEmpty(f23602e)) {
                    return;
                }
                f23602e += new StringBuilder(f23602e).reverse().toString();
                String multiProcessSP2 = UMUtils.getMultiProcessSP(f23601d, f23605h);
                if (TextUtils.isEmpty(multiProcessSP2)) {
                    UMUtils.setMultiProcessSP(f23601d, f23605h, c(f23603f));
                } else {
                    if (f23603f.equals(d(multiProcessSP2))) {
                        return;
                    }
                    b(true, false);
                    a(true, false);
                    h();
                    i();
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void b() {
        this.f23609l.clear();
    }

    public boolean c() {
        return this.f23609l.isEmpty();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:0|2|(3:35|3|(4:33|5|6|7)(5:8|9|(1:11)|38|12))|31|15|16|20|(1:(0))) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d() {
        /*
            r7 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.i.f23601d     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            com.umeng.analytics.pro.g r1 = com.umeng.analytics.pro.g.a(r1)     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            com.umeng.analytics.pro.u r1 = com.umeng.analytics.pro.u.a()     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            java.lang.String r1 = r1.c()     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            if (r2 == 0) goto L29
            r0.endTransaction()     // Catch: java.lang.Throwable -> L1f
        L1f:
            android.content.Context r0 = com.umeng.analytics.pro.i.f23601d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            return
        L29:
            r2 = 2
            java.lang.String r3 = ""
            java.lang.String r4 = "-1"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4}     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            r4 = 0
        L33:
            if (r4 >= r2) goto L65
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            r5.<init>()     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            java.lang.String r6 = "update __et set __i=\""
            r5.append(r6)     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            r5.append(r1)     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            java.lang.String r6 = "\" where "
            r5.append(r6)     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            java.lang.String r6 = "__i"
            r5.append(r6)     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            java.lang.String r6 = "=\""
            r5.append(r6)     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            r6 = r3[r4]     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            r5.append(r6)     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            java.lang.String r6 = "\""
            r5.append(r6)     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            r0.execSQL(r5)     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            int r4 = r4 + 1
            goto L33
        L65:
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L69 android.database.sqlite.SQLiteDatabaseCorruptException -> L78
            goto L6b
        L69:
            if (r0 == 0) goto L6e
        L6b:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L6e
        L6e:
            android.content.Context r0 = com.umeng.analytics.pro.i.f23601d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            goto L80
        L78:
            android.content.Context r1 = com.umeng.analytics.pro.i.f23601d     // Catch: java.lang.Throwable -> L81
            com.umeng.analytics.pro.h.a(r1)     // Catch: java.lang.Throwable -> L81
            if (r0 == 0) goto L6e
            goto L6b
        L80:
            return
        L81:
            r1 = move-exception
            if (r0 == 0) goto L87
            r0.endTransaction()     // Catch: java.lang.Throwable -> L87
        L87:
            android.content.Context r0 = com.umeng.analytics.pro.i.f23601d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.d():void");
    }

    public boolean e() {
        return this.f23606i.isEmpty();
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0085 A[EXC_TOP_SPLITTER, PHI: r2 r5
  0x0085: PHI (r2v5 android.database.sqlite.SQLiteDatabase) = (r2v4 android.database.sqlite.SQLiteDatabase), (r2v6 android.database.sqlite.SQLiteDatabase) binds: [B:27:0x0083, B:34:0x009f] A[DONT_GENERATE, DONT_INLINE]
  0x0085: PHI (r5v3 org.json.JSONObject) = (r5v2 org.json.JSONObject), (r5v5 org.json.JSONObject) binds: [B:27:0x0083, B:34:0x009f] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.json.JSONObject f() {
        /*
            r14 = this;
            java.lang.String r0 = "__vc"
            java.lang.String r1 = "__av"
            java.util.List<java.lang.String> r2 = r14.f23609l
            boolean r2 = r2.isEmpty()
            r3 = 0
            if (r2 == 0) goto Le
            return r3
        Le:
            android.content.Context r2 = com.umeng.analytics.pro.i.f23601d     // Catch: java.lang.Throwable -> L7c android.database.sqlite.SQLiteDatabaseCorruptException -> L93
            com.umeng.analytics.pro.g r2 = com.umeng.analytics.pro.g.a(r2)     // Catch: java.lang.Throwable -> L7c android.database.sqlite.SQLiteDatabaseCorruptException -> L93
            android.database.sqlite.SQLiteDatabase r2 = r2.a()     // Catch: java.lang.Throwable -> L7c android.database.sqlite.SQLiteDatabaseCorruptException -> L93
            r2.beginTransaction()     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            java.util.List<java.lang.String> r4 = r14.f23609l     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            r5 = 0
            java.lang.Object r4 = r4.get(r5)     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            java.lang.String r6 = "__is"
            r7 = 0
            java.lang.String r8 = "__ii=? "
            r9 = 1
            java.lang.String[] r9 = new java.lang.String[r9]     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            r9[r5] = r4     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r4 = r14
            r5 = r6
            r6 = r2
            android.database.Cursor r4 = r4.a(r5, r6, r7, r8, r9, r10, r11, r12, r13)     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            if (r4 == 0) goto L5d
            boolean r5 = r4.moveToNext()     // Catch: java.lang.Throwable -> L72 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            if (r5 == 0) goto L5d
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L72 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            r5.<init>()     // Catch: java.lang.Throwable -> L72 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            int r3 = r4.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            java.lang.String r3 = r4.getString(r3)     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            int r6 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            java.lang.String r6 = r4.getString(r6)     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            r5.put(r1, r3)     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            r5.put(r0, r6)     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            r3 = r5
        L5d:
            r2.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L72 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            if (r4 == 0) goto L65
            r4.close()
        L65:
            r2.endTransaction()     // Catch: java.lang.Throwable -> L68
        L68:
            android.content.Context r0 = com.umeng.analytics.pro.i.f23601d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            goto La2
        L72:
            r5 = r3
        L73:
            r3 = r4
            goto L7e
        L75:
            r5 = r3
        L76:
            r3 = r4
            goto L95
        L78:
            r5 = r3
            goto L7e
        L7a:
            r5 = r3
            goto L95
        L7c:
            r2 = r3
            r5 = r2
        L7e:
            if (r3 == 0) goto L83
            r3.close()
        L83:
            if (r2 == 0) goto L88
        L85:
            r2.endTransaction()     // Catch: java.lang.Throwable -> L88
        L88:
            android.content.Context r0 = com.umeng.analytics.pro.i.f23601d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            r3 = r5
            goto La2
        L93:
            r2 = r3
            r5 = r2
        L95:
            android.content.Context r0 = com.umeng.analytics.pro.i.f23601d     // Catch: java.lang.Throwable -> La3
            com.umeng.analytics.pro.h.a(r0)     // Catch: java.lang.Throwable -> La3
            if (r3 == 0) goto L9f
            r3.close()
        L9f:
            if (r2 == 0) goto L88
            goto L85
        La2:
            return r3
        La3:
            r0 = move-exception
            if (r3 == 0) goto La9
            r3.close()
        La9:
            if (r2 == 0) goto Lae
            r2.endTransaction()     // Catch: java.lang.Throwable -> Lae
        Lae:
            android.content.Context r1 = com.umeng.analytics.pro.i.f23601d
            com.umeng.analytics.pro.g r1 = com.umeng.analytics.pro.g.a(r1)
            r1.b()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.f():org.json.JSONObject");
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0085 A[EXC_TOP_SPLITTER, PHI: r2 r5
  0x0085: PHI (r2v5 android.database.sqlite.SQLiteDatabase) = (r2v4 android.database.sqlite.SQLiteDatabase), (r2v6 android.database.sqlite.SQLiteDatabase) binds: [B:27:0x0083, B:34:0x009f] A[DONT_GENERATE, DONT_INLINE]
  0x0085: PHI (r5v3 org.json.JSONObject) = (r5v2 org.json.JSONObject), (r5v5 org.json.JSONObject) binds: [B:27:0x0083, B:34:0x009f] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.json.JSONObject g() {
        /*
            r14 = this;
            java.lang.String r0 = "__vc"
            java.lang.String r1 = "__av"
            java.util.List<java.lang.String> r2 = r14.f23606i
            boolean r2 = r2.isEmpty()
            r3 = 0
            if (r2 == 0) goto Le
            return r3
        Le:
            android.content.Context r2 = com.umeng.analytics.pro.i.f23601d     // Catch: java.lang.Throwable -> L7c android.database.sqlite.SQLiteDatabaseCorruptException -> L93
            com.umeng.analytics.pro.g r2 = com.umeng.analytics.pro.g.a(r2)     // Catch: java.lang.Throwable -> L7c android.database.sqlite.SQLiteDatabaseCorruptException -> L93
            android.database.sqlite.SQLiteDatabase r2 = r2.a()     // Catch: java.lang.Throwable -> L7c android.database.sqlite.SQLiteDatabaseCorruptException -> L93
            r2.beginTransaction()     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            java.util.List<java.lang.String> r4 = r14.f23606i     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            r5 = 0
            java.lang.Object r4 = r4.get(r5)     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            java.lang.String r6 = "__sd"
            r7 = 0
            java.lang.String r8 = "__ii=? "
            r9 = 1
            java.lang.String[] r9 = new java.lang.String[r9]     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            r9[r5] = r4     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r4 = r14
            r5 = r6
            r6 = r2
            android.database.Cursor r4 = r4.a(r5, r6, r7, r8, r9, r10, r11, r12, r13)     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteDatabaseCorruptException -> L7a
            if (r4 == 0) goto L5d
            boolean r5 = r4.moveToNext()     // Catch: java.lang.Throwable -> L72 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            if (r5 == 0) goto L5d
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L72 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            r5.<init>()     // Catch: java.lang.Throwable -> L72 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            int r3 = r4.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            java.lang.String r3 = r4.getString(r3)     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            int r6 = r4.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            java.lang.String r6 = r4.getString(r6)     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            r5.put(r1, r3)     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            r5.put(r0, r6)     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteDatabaseCorruptException -> L76
            r3 = r5
        L5d:
            r2.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L72 android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            if (r4 == 0) goto L65
            r4.close()
        L65:
            r2.endTransaction()     // Catch: java.lang.Throwable -> L68
        L68:
            android.content.Context r0 = com.umeng.analytics.pro.i.f23601d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            goto La2
        L72:
            r5 = r3
        L73:
            r3 = r4
            goto L7e
        L75:
            r5 = r3
        L76:
            r3 = r4
            goto L95
        L78:
            r5 = r3
            goto L7e
        L7a:
            r5 = r3
            goto L95
        L7c:
            r2 = r3
            r5 = r2
        L7e:
            if (r3 == 0) goto L83
            r3.close()
        L83:
            if (r2 == 0) goto L88
        L85:
            r2.endTransaction()     // Catch: java.lang.Throwable -> L88
        L88:
            android.content.Context r0 = com.umeng.analytics.pro.i.f23601d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            r3 = r5
            goto La2
        L93:
            r2 = r3
            r5 = r2
        L95:
            android.content.Context r0 = com.umeng.analytics.pro.i.f23601d     // Catch: java.lang.Throwable -> La3
            com.umeng.analytics.pro.h.a(r0)     // Catch: java.lang.Throwable -> La3
            if (r3 == 0) goto L9f
            r3.close()
        L9f:
            if (r2 == 0) goto L88
            goto L85
        La2:
            return r3
        La3:
            r0 = move-exception
            if (r3 == 0) goto La9
            r3.close()
        La9:
            if (r2 == 0) goto Lae
            r2.endTransaction()     // Catch: java.lang.Throwable -> Lae
        Lae:
            android.content.Context r1 = com.umeng.analytics.pro.i.f23601d
            com.umeng.analytics.pro.g r1 = com.umeng.analytics.pro.g.a(r1)
            r1.b()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.g():org.json.JSONObject");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:0|2|(4:29|3|(3:5|(2:8|6)|32)|9)|27|12|13|17|(1:(0))) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void h() {
        /*
            r4 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.i.f23601d     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            com.umeng.analytics.pro.g r1 = com.umeng.analytics.pro.g.a(r1)     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            java.util.List<java.lang.Integer> r1 = r4.f23607j     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            if (r1 <= 0) goto L3c
            r1 = 0
        L17:
            java.util.List<java.lang.Integer> r2 = r4.f23607j     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            int r2 = r2.size()     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            if (r1 >= r2) goto L3c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            r2.<init>()     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            java.lang.String r3 = "delete from __et where rowid="
            r2.append(r3)     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            java.util.List<java.lang.Integer> r3 = r4.f23607j     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            java.lang.Object r3 = r3.get(r1)     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            r2.append(r3)     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            r0.execSQL(r2)     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            int r1 = r1 + 1
            goto L17
        L3c:
            java.util.List<java.lang.Integer> r1 = r4.f23607j     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            r1.clear()     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L45 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            goto L47
        L45:
            if (r0 == 0) goto L4a
        L47:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L4a
        L4a:
            android.content.Context r0 = com.umeng.analytics.pro.i.f23601d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            goto L5c
        L54:
            android.content.Context r1 = com.umeng.analytics.pro.i.f23601d     // Catch: java.lang.Throwable -> L5d
            com.umeng.analytics.pro.h.a(r1)     // Catch: java.lang.Throwable -> L5d
            if (r0 == 0) goto L4a
            goto L47
        L5c:
            return
        L5d:
            r1 = move-exception
            if (r0 == 0) goto L63
            r0.endTransaction()     // Catch: java.lang.Throwable -> L63
        L63:
            android.content.Context r0 = com.umeng.analytics.pro.i.f23601d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.h():void");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:0|2|(2:23|3)|21|6|7|11|(1:(0))) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void i() {
        /*
            r2 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.i.f23601d     // Catch: java.lang.Throwable -> L17 android.database.sqlite.SQLiteDatabaseCorruptException -> L26
            com.umeng.analytics.pro.g r1 = com.umeng.analytics.pro.g.a(r1)     // Catch: java.lang.Throwable -> L17 android.database.sqlite.SQLiteDatabaseCorruptException -> L26
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L17 android.database.sqlite.SQLiteDatabaseCorruptException -> L26
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L17 android.database.sqlite.SQLiteDatabaseCorruptException -> L26
            java.lang.String r1 = "delete from __er"
            r0.execSQL(r1)     // Catch: java.lang.Throwable -> L17 android.database.sqlite.SQLiteDatabaseCorruptException -> L26
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L17 android.database.sqlite.SQLiteDatabaseCorruptException -> L26
            goto L19
        L17:
            if (r0 == 0) goto L1c
        L19:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L1c
        L1c:
            android.content.Context r0 = com.umeng.analytics.pro.i.f23601d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            goto L2e
        L26:
            android.content.Context r1 = com.umeng.analytics.pro.i.f23601d     // Catch: java.lang.Throwable -> L2f
            com.umeng.analytics.pro.h.a(r1)     // Catch: java.lang.Throwable -> L2f
            if (r0 == 0) goto L1c
            goto L19
        L2e:
            return
        L2f:
            r1 = move-exception
            if (r0 == 0) goto L35
            r0.endTransaction()     // Catch: java.lang.Throwable -> L35
        L35:
            android.content.Context r0 = com.umeng.analytics.pro.i.f23601d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.i():void");
    }

    public void j() {
        SQLiteDatabase sQLiteDatabaseA;
        if (!TextUtils.isEmpty(this.f23608k)) {
            try {
                sQLiteDatabaseA = g.a(f23601d).a();
                try {
                    sQLiteDatabaseA.beginTransaction();
                    sQLiteDatabaseA.execSQL("delete from __er where __i=\"" + this.f23608k + "\"");
                    sQLiteDatabaseA.execSQL("delete from __et where __i=\"" + this.f23608k + "\"");
                    sQLiteDatabaseA.setTransactionSuccessful();
                } catch (SQLiteDatabaseCorruptException unused) {
                    try {
                        h.a(f23601d);
                        if (sQLiteDatabaseA != null) {
                        }
                        this.f23608k = null;
                    } finally {
                        if (sQLiteDatabaseA != null) {
                            try {
                                sQLiteDatabaseA.endTransaction();
                            } catch (Throwable unused2) {
                            }
                        }
                        g.a(f23601d).b();
                    }
                } catch (Throwable unused3) {
                    this.f23608k = null;
                }
            } catch (SQLiteDatabaseCorruptException unused4) {
                sQLiteDatabaseA = null;
            } catch (Throwable unused5) {
                sQLiteDatabaseA = null;
            }
        }
        this.f23608k = null;
    }

    private i() {
        this.f23606i = new ArrayList();
        this.f23607j = new ArrayList();
        this.f23608k = null;
        this.f23609l = new ArrayList();
    }

    private void b(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase) {
        try {
            long jLongValue = ((Long) jSONObject.get("__e")).longValue();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("__sp");
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("__pp");
            String strC = "";
            String strC2 = (jSONObjectOptJSONObject == null || jSONObjectOptJSONObject.length() <= 0) ? "" : c(jSONObjectOptJSONObject.toString());
            if (jSONObjectOptJSONObject2 != null && jSONObjectOptJSONObject2.length() > 0) {
                strC = c(jSONObjectOptJSONObject2.toString());
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("__ii", str);
            contentValues.put("__e", String.valueOf(jLongValue));
            contentValues.put("__sp", strC2);
            contentValues.put("__pp", strC);
            contentValues.put("__av", UMGlobalContext.getInstance(f23601d).getAppVersion());
            contentValues.put("__vc", UMUtils.getAppVersionCode(f23601d));
            sQLiteDatabase.insert(e.c.f23552a, null, contentValues);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void c(java.lang.String r20, org.json.JSONObject r21, android.database.sqlite.SQLiteDatabase r22) {
        /*
            Method dump skipped, instruction units count: 283
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.c(java.lang.String, org.json.JSONObject, android.database.sqlite.SQLiteDatabase):void");
    }

    private Cursor a(String str, SQLiteDatabase sQLiteDatabase, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
        if (sQLiteDatabase == null) {
            return null;
        }
        try {
            if (sQLiteDatabase.isOpen()) {
                return sQLiteDatabase.query(str, strArr, str2, strArr2, str3, str4, str5, str6);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void a() {
        this.f23606i.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0098, code lost:
    
        if (r2 == null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x009a, code lost:
    
        r2.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00ac, code lost:
    
        if (r2 == null) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(org.json.JSONArray r11) {
        /*
            r10 = this;
            java.lang.String r0 = "__t"
            java.lang.String r1 = "__i"
            r2 = 0
            android.content.Context r3 = com.umeng.analytics.pro.i.f23601d     // Catch: java.lang.Throwable -> L98 android.database.sqlite.SQLiteDatabaseCorruptException -> La7
            com.umeng.analytics.pro.g r3 = com.umeng.analytics.pro.g.a(r3)     // Catch: java.lang.Throwable -> L98 android.database.sqlite.SQLiteDatabaseCorruptException -> La7
            android.database.sqlite.SQLiteDatabase r3 = r3.a()     // Catch: java.lang.Throwable -> L98 android.database.sqlite.SQLiteDatabaseCorruptException -> La7
            r3.beginTransaction()     // Catch: java.lang.Throwable -> L94 android.database.sqlite.SQLiteDatabaseCorruptException -> L96
            r4 = 0
        L13:
            int r5 = r11.length()     // Catch: java.lang.Throwable -> L94 android.database.sqlite.SQLiteDatabaseCorruptException -> L96
            if (r4 >= r5) goto L8d
            org.json.JSONObject r5 = r11.getJSONObject(r4)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            android.content.ContentValues r6 = new android.content.ContentValues     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            r6.<init>()     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            java.lang.String r7 = r5.optString(r1)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            java.lang.String r9 = "-1"
            if (r8 != 0) goto L34
            boolean r8 = r9.equals(r7)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            if (r8 == 0) goto L43
        L34:
            com.umeng.analytics.pro.u r7 = com.umeng.analytics.pro.u.a()     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            java.lang.String r7 = r7.b()     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            if (r8 == 0) goto L43
            r7 = r9
        L43:
            r6.put(r1, r7)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            java.lang.String r7 = "__e"
            java.lang.String r8 = "id"
            java.lang.String r8 = r5.optString(r8)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            r6.put(r7, r8)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            int r7 = r5.optInt(r0)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            r6.put(r0, r7)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            java.lang.String r7 = "__av"
            android.content.Context r8 = com.umeng.analytics.pro.i.f23601d     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            java.lang.String r8 = com.umeng.commonsdk.utils.UMUtils.getAppVersionName(r8)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            r6.put(r7, r8)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            java.lang.String r7 = "__vc"
            android.content.Context r8 = com.umeng.analytics.pro.i.f23601d     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            java.lang.String r8 = com.umeng.commonsdk.utils.UMUtils.getAppVersionCode(r8)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            r6.put(r7, r8)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            r5.remove(r1)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            r5.remove(r0)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            java.lang.String r7 = "__s"
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            java.lang.String r5 = r10.c(r5)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            r6.put(r7, r5)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
            java.lang.String r5 = "__et"
            r3.insert(r5, r2, r6)     // Catch: java.lang.Exception -> L8a java.lang.Throwable -> L94
        L8a:
            int r4 = r4 + 1
            goto L13
        L8d:
            r3.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L94 android.database.sqlite.SQLiteDatabaseCorruptException -> L96
            r3.endTransaction()     // Catch: java.lang.Throwable -> L9d
            goto L9d
        L94:
            r2 = r3
            goto L98
        L96:
            r2 = r3
            goto La7
        L98:
            if (r2 == 0) goto L9d
        L9a:
            r2.endTransaction()     // Catch: java.lang.Throwable -> L9d
        L9d:
            android.content.Context r11 = com.umeng.analytics.pro.i.f23601d
            com.umeng.analytics.pro.g r11 = com.umeng.analytics.pro.g.a(r11)
            r11.b()
            goto Laf
        La7:
            android.content.Context r11 = com.umeng.analytics.pro.i.f23601d     // Catch: java.lang.Throwable -> Lb0
            com.umeng.analytics.pro.h.a(r11)     // Catch: java.lang.Throwable -> Lb0
            if (r2 == 0) goto L9d
            goto L9a
        Laf:
            return
        Lb0:
            r11 = move-exception
            if (r2 == 0) goto Lb6
            r2.endTransaction()     // Catch: java.lang.Throwable -> Lb6
        Lb6:
            android.content.Context r0 = com.umeng.analytics.pro.i.f23601d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.a(org.json.JSONArray):void");
    }

    public String d(String str) {
        try {
            return TextUtils.isEmpty(f23602e) ? str : new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), f23602e.getBytes()));
        } catch (Exception unused) {
            if (Build.VERSION.SDK_INT >= 29 && !TextUtils.isEmpty(str)) {
                try {
                    new JSONObject(str);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> UMStoreManager decrypt failed, return origin data.");
                    return str;
                } catch (Throwable unused2) {
                    return null;
                }
            }
            return null;
        }
    }

    public JSONObject b(boolean z10) {
        JSONObject jSONObject = new JSONObject();
        b(jSONObject, z10);
        return jSONObject;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0096 A[PHI: r0 r1
  0x0096: PHI (r0v4 android.database.Cursor) = (r0v2 android.database.Cursor), (r0v3 android.database.Cursor), (r0v5 android.database.Cursor) binds: [B:26:0x0083, B:32:0x0091, B:33:0x0093] A[DONT_GENERATE, DONT_INLINE]
  0x0096: PHI (r1v5 android.database.sqlite.SQLiteDatabase) = 
  (r1v3 android.database.sqlite.SQLiteDatabase)
  (r1v4 android.database.sqlite.SQLiteDatabase)
  (r1v6 android.database.sqlite.SQLiteDatabase)
 binds: [B:26:0x0083, B:32:0x0091, B:33:0x0093] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void b(org.json.JSONObject r13, java.lang.String r14) {
        /*
            r12 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.i.f23601d     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteDatabaseCorruptException -> L86
            com.umeng.analytics.pro.g r1 = com.umeng.analytics.pro.g.a(r1)     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteDatabaseCorruptException -> L86
            android.database.sqlite.SQLiteDatabase r1 = r1.a()     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteDatabaseCorruptException -> L86
            r1.beginTransaction()     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteDatabaseCorruptException -> L87
            boolean r2 = android.text.TextUtils.isEmpty(r14)     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteDatabaseCorruptException -> L87
            if (r2 != 0) goto L2a
            java.lang.String r3 = "__er"
            r5 = 0
            java.lang.String r6 = "__i=? "
            r2 = 1
            java.lang.String[] r7 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteDatabaseCorruptException -> L87
            r2 = 0
            r7[r2] = r14     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteDatabaseCorruptException -> L87
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r2 = r12
            r4 = r1
            android.database.Cursor r14 = r2.a(r3, r4, r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteDatabaseCorruptException -> L87
            goto L39
        L2a:
            java.lang.String r3 = "__er"
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r2 = r12
            r4 = r1
            android.database.Cursor r14 = r2.a(r3, r4, r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteDatabaseCorruptException -> L87
        L39:
            r0 = r14
            if (r0 == 0) goto L6f
            org.json.JSONArray r14 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteDatabaseCorruptException -> L87
            r14.<init>()     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteDatabaseCorruptException -> L87
        L41:
            boolean r2 = r0.moveToNext()     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteDatabaseCorruptException -> L87
            if (r2 == 0) goto L64
            java.lang.String r2 = "__a"
            int r2 = r0.getColumnIndex(r2)     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteDatabaseCorruptException -> L87
            java.lang.String r2 = r0.getString(r2)     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteDatabaseCorruptException -> L87
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteDatabaseCorruptException -> L87
            if (r3 != 0) goto L41
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteDatabaseCorruptException -> L87
            java.lang.String r2 = r12.d(r2)     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteDatabaseCorruptException -> L87
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteDatabaseCorruptException -> L87
            r14.put(r3)     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteDatabaseCorruptException -> L87
            goto L41
        L64:
            int r2 = r14.length()     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteDatabaseCorruptException -> L87
            if (r2 <= 0) goto L6f
            java.lang.String r2 = "error"
            r13.put(r2, r14)     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteDatabaseCorruptException -> L87
        L6f:
            r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L79 android.database.sqlite.SQLiteDatabaseCorruptException -> L87
            if (r0 == 0) goto L93
            r0.close()
            goto L93
        L78:
            r1 = r0
        L79:
            android.content.Context r13 = com.umeng.analytics.pro.i.f23601d     // Catch: java.lang.Throwable -> La0
            com.umeng.analytics.pro.h.a(r13)     // Catch: java.lang.Throwable -> La0
            if (r0 == 0) goto L83
            r0.close()
        L83:
            if (r1 == 0) goto L96
            goto L93
        L86:
            r1 = r0
        L87:
            android.content.Context r13 = com.umeng.analytics.pro.i.f23601d     // Catch: java.lang.Throwable -> La0
            com.umeng.analytics.pro.h.a(r13)     // Catch: java.lang.Throwable -> La0
            if (r0 == 0) goto L91
            r0.close()
        L91:
            if (r1 == 0) goto L96
        L93:
            r1.endTransaction()     // Catch: java.lang.Throwable -> L96
        L96:
            android.content.Context r13 = com.umeng.analytics.pro.i.f23601d
            com.umeng.analytics.pro.g r13 = com.umeng.analytics.pro.g.a(r13)
            r13.b()
            return
        La0:
            r13 = move-exception
            if (r0 == 0) goto La6
            r0.close()
        La6:
            if (r1 == 0) goto Lab
            r1.endTransaction()     // Catch: java.lang.Throwable -> Lab
        Lab:
            android.content.Context r14 = com.umeng.analytics.pro.i.f23601d
            com.umeng.analytics.pro.g r14 = com.umeng.analytics.pro.g.a(r14)
            r14.b()
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.b(org.json.JSONObject, java.lang.String):void");
    }

    public String c(String str) {
        try {
            return TextUtils.isEmpty(f23602e) ? str : Base64.encodeToString(DataHelper.encrypt(str.getBytes(), f23602e.getBytes()), 0);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0056, code lost:
    
        if (r0 == null) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0058, code lost:
    
        r0.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x006a, code lost:
    
        if (r0 == null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(java.lang.String r5, java.lang.String r6, int r7) {
        /*
            r4 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.i.f23601d     // Catch: java.lang.Throwable -> L56 android.database.sqlite.SQLiteDatabaseCorruptException -> L65
            com.umeng.analytics.pro.g r1 = com.umeng.analytics.pro.g.a(r1)     // Catch: java.lang.Throwable -> L56 android.database.sqlite.SQLiteDatabaseCorruptException -> L65
            android.database.sqlite.SQLiteDatabase r1 = r1.a()     // Catch: java.lang.Throwable -> L56 android.database.sqlite.SQLiteDatabaseCorruptException -> L65
            r1.beginTransaction()     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            r2.<init>()     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            java.lang.String r3 = "__i"
            r2.put(r3, r5)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            java.lang.String r5 = r4.c(r6)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            if (r6 != 0) goto L4b
            java.lang.String r6 = "__a"
            r2.put(r6, r5)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            java.lang.String r5 = "__t"
            java.lang.Integer r6 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            r2.put(r5, r6)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            java.lang.String r5 = "__av"
            android.content.Context r6 = com.umeng.analytics.pro.i.f23601d     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            java.lang.String r6 = com.umeng.commonsdk.utils.UMUtils.getAppVersionName(r6)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            r2.put(r5, r6)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            java.lang.String r5 = "__vc"
            android.content.Context r6 = com.umeng.analytics.pro.i.f23601d     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            java.lang.String r6 = com.umeng.commonsdk.utils.UMUtils.getAppVersionCode(r6)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            r2.put(r5, r6)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            java.lang.String r5 = "__er"
            r1.insert(r5, r0, r2)     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
        L4b:
            r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L52 android.database.sqlite.SQLiteDatabaseCorruptException -> L54
            r1.endTransaction()     // Catch: java.lang.Throwable -> L5b
            goto L5b
        L52:
            r0 = r1
            goto L56
        L54:
            r0 = r1
            goto L65
        L56:
            if (r0 == 0) goto L5b
        L58:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L5b
        L5b:
            android.content.Context r5 = com.umeng.analytics.pro.i.f23601d
            com.umeng.analytics.pro.g r5 = com.umeng.analytics.pro.g.a(r5)
            r5.b()
            goto L6d
        L65:
            android.content.Context r5 = com.umeng.analytics.pro.i.f23601d     // Catch: java.lang.Throwable -> L6f
            com.umeng.analytics.pro.h.a(r5)     // Catch: java.lang.Throwable -> L6f
            if (r0 == 0) goto L5b
            goto L58
        L6d:
            r5 = 0
            return r5
        L6f:
            r5 = move-exception
            if (r0 == 0) goto L75
            r0.endTransaction()     // Catch: java.lang.Throwable -> L75
        L75:
            android.content.Context r6 = com.umeng.analytics.pro.i.f23601d
            com.umeng.analytics.pro.g r6 = com.umeng.analytics.pro.g.a(r6)
            r6.b()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.a(java.lang.String, java.lang.String, int):boolean");
    }

    private JSONArray b(JSONArray jSONArray) {
        JSONArray jSONArray2 = new JSONArray();
        int length = jSONArray.length();
        for (int i10 = 0; i10 < length; i10++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i10);
            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optLong("duration") > 0) {
                jSONArray2.put(jSONObjectOptJSONObject);
            }
        }
        return jSONArray2;
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00e6 A[EXC_TOP_SPLITTER, PHI: r1 r13
  0x00e6: PHI (r1v4 android.database.sqlite.SQLiteDatabase) = (r1v3 android.database.sqlite.SQLiteDatabase), (r1v6 android.database.sqlite.SQLiteDatabase) binds: [B:37:0x00d5, B:43:0x00e4] A[DONT_GENERATE, DONT_INLINE]
  0x00e6: PHI (r13v5 ??) = (r13v4 ??), (r13v7 ??) binds: [B:37:0x00d5, B:43:0x00e4] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r13v0, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r13v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String b(org.json.JSONObject r13, boolean r14) {
        /*
            Method dump skipped, instruction units count: 265
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.b(org.json.JSONObject, boolean):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0085, code lost:
    
        if (r2 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0087, code lost:
    
        r2.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0099, code lost:
    
        if (r2 == null) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(java.lang.String r7, org.json.JSONObject r8, com.umeng.analytics.pro.i.a r9) {
        /*
            r6 = this;
            java.lang.String r0 = "__e"
            r1 = 0
            if (r8 != 0) goto L6
            return r1
        L6:
            r2 = 0
            android.content.Context r3 = com.umeng.analytics.pro.i.f23601d     // Catch: java.lang.Throwable -> L85 android.database.sqlite.SQLiteDatabaseCorruptException -> L94
            com.umeng.analytics.pro.g r3 = com.umeng.analytics.pro.g.a(r3)     // Catch: java.lang.Throwable -> L85 android.database.sqlite.SQLiteDatabaseCorruptException -> L94
            android.database.sqlite.SQLiteDatabase r3 = r3.a()     // Catch: java.lang.Throwable -> L85 android.database.sqlite.SQLiteDatabaseCorruptException -> L94
            r3.beginTransaction()     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            com.umeng.analytics.pro.i$a r4 = com.umeng.analytics.pro.i.a.BEGIN     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            if (r9 != r4) goto L4f
            java.lang.Object r8 = r8.opt(r0)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            java.lang.Long r8 = (java.lang.Long) r8     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            long r8 = r8.longValue()     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            android.content.ContentValues r4 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            r4.<init>()     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            java.lang.String r5 = "__ii"
            r4.put(r5, r7)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            java.lang.String r7 = java.lang.String.valueOf(r8)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            r4.put(r0, r7)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            java.lang.String r7 = "__av"
            android.content.Context r8 = com.umeng.analytics.pro.i.f23601d     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            java.lang.String r8 = com.umeng.commonsdk.utils.UMUtils.getAppVersionName(r8)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            r4.put(r7, r8)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            java.lang.String r7 = "__vc"
            android.content.Context r8 = com.umeng.analytics.pro.i.f23601d     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            java.lang.String r8 = com.umeng.commonsdk.utils.UMUtils.getAppVersionCode(r8)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            r4.put(r7, r8)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            java.lang.String r7 = "__sd"
            r3.insert(r7, r2, r4)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            goto L7a
        L4f:
            com.umeng.analytics.pro.i$a r0 = com.umeng.analytics.pro.i.a.INSTANTSESSIONBEGIN     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            if (r9 != r0) goto L57
            r6.b(r7, r8, r3)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            goto L7a
        L57:
            com.umeng.analytics.pro.i$a r0 = com.umeng.analytics.pro.i.a.END     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            if (r9 != r0) goto L5f
            r6.a(r7, r8, r3)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            goto L7a
        L5f:
            com.umeng.analytics.pro.i$a r0 = com.umeng.analytics.pro.i.a.PAGE     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            if (r9 != r0) goto L69
            java.lang.String r9 = "__a"
            r6.a(r7, r8, r3, r9)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            goto L7a
        L69:
            com.umeng.analytics.pro.i$a r0 = com.umeng.analytics.pro.i.a.AUTOPAGE     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            if (r9 != r0) goto L73
            java.lang.String r9 = "__b"
            r6.a(r7, r8, r3, r9)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            goto L7a
        L73:
            com.umeng.analytics.pro.i$a r0 = com.umeng.analytics.pro.i.a.NEWSESSION     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            if (r9 != r0) goto L7a
            r6.c(r7, r8, r3)     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
        L7a:
            r3.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L81 android.database.sqlite.SQLiteDatabaseCorruptException -> L83
            r3.endTransaction()     // Catch: java.lang.Throwable -> L8a
            goto L8a
        L81:
            r2 = r3
            goto L85
        L83:
            r2 = r3
            goto L94
        L85:
            if (r2 == 0) goto L8a
        L87:
            r2.endTransaction()     // Catch: java.lang.Throwable -> L8a
        L8a:
            android.content.Context r7 = com.umeng.analytics.pro.i.f23601d
            com.umeng.analytics.pro.g r7 = com.umeng.analytics.pro.g.a(r7)
            r7.b()
            goto L9c
        L94:
            android.content.Context r7 = com.umeng.analytics.pro.i.f23601d     // Catch: java.lang.Throwable -> L9d
            com.umeng.analytics.pro.h.a(r7)     // Catch: java.lang.Throwable -> L9d
            if (r2 == 0) goto L8a
            goto L87
        L9c:
            return r1
        L9d:
            r7 = move-exception
            if (r2 == 0) goto La3
            r2.endTransaction()     // Catch: java.lang.Throwable -> La3
        La3:
            android.content.Context r8 = com.umeng.analytics.pro.i.f23601d
            com.umeng.analytics.pro.g r8 = com.umeng.analytics.pro.g.a(r8)
            r8.b()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.a(java.lang.String, org.json.JSONObject, com.umeng.analytics.pro.i$a):boolean");
    }

    private void a(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase) {
        try {
            long jLongValue = ((Long) jSONObject.opt(e.d.a.f23572g)).longValue();
            long jLongValue2 = 0;
            Object objOpt = jSONObject.opt(e.d.a.f23573h);
            if (objOpt != null && (objOpt instanceof Long)) {
                jLongValue2 = ((Long) objOpt).longValue();
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("__sp");
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("__pp");
            String strC = "";
            String strC2 = (jSONObjectOptJSONObject == null || jSONObjectOptJSONObject.length() <= 0) ? "" : c(jSONObjectOptJSONObject.toString());
            if (jSONObjectOptJSONObject2 != null && jSONObjectOptJSONObject2.length() > 0) {
                strC = c(jSONObjectOptJSONObject2.toString());
            }
            sQLiteDatabase.execSQL("update __sd set __f=\"" + jLongValue + "\", " + e.d.a.f23573h + "=\"" + jLongValue2 + "\", __sp=\"" + strC2 + "\", __pp=\"" + strC + "\" where __ii=\"" + str + "\"");
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:0|2|(4:33|3|(1:(1:6))(2:7|(3:9|(2:12|10)|36))|13)|29|16|17|21|(1:(0))) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(boolean r3, boolean r4) {
        /*
            r2 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.i.f23601d     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            com.umeng.analytics.pro.g r1 = com.umeng.analytics.pro.g.a(r1)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            if (r4 == 0) goto L18
            if (r3 == 0) goto L4d
            java.lang.String r3 = "delete from __sd"
            r0.execSQL(r3)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            goto L4d
        L18:
            java.util.List<java.lang.String> r3 = r2.f23606i     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            int r3 = r3.size()     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            if (r3 <= 0) goto L4d
            r3 = 0
        L21:
            java.util.List<java.lang.String> r4 = r2.f23606i     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            int r4 = r4.size()     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            if (r3 >= r4) goto L4d
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            r4.<init>()     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            java.lang.String r1 = "delete from __sd where __ii=\""
            r4.append(r1)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            java.util.List<java.lang.String> r1 = r2.f23606i     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            java.lang.Object r1 = r1.get(r3)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            r4.append(r1)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            java.lang.String r1 = "\""
            r4.append(r1)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            r0.execSQL(r4)     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            int r3 = r3 + 1
            goto L21
        L4d:
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L51 android.database.sqlite.SQLiteDatabaseCorruptException -> L60
            goto L53
        L51:
            if (r0 == 0) goto L56
        L53:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L56
        L56:
            android.content.Context r3 = com.umeng.analytics.pro.i.f23601d
            com.umeng.analytics.pro.g r3 = com.umeng.analytics.pro.g.a(r3)
            r3.b()
            goto L68
        L60:
            android.content.Context r3 = com.umeng.analytics.pro.i.f23601d     // Catch: java.lang.Throwable -> L69
            com.umeng.analytics.pro.h.a(r3)     // Catch: java.lang.Throwable -> L69
            if (r0 == 0) goto L56
            goto L53
        L68:
            return
        L69:
            r3 = move-exception
            if (r0 == 0) goto L6f
            r0.endTransaction()     // Catch: java.lang.Throwable -> L6f
        L6f:
            android.content.Context r4 = com.umeng.analytics.pro.i.f23601d
            com.umeng.analytics.pro.g r4 = com.umeng.analytics.pro.g.a(r4)
            r4.b()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.b(boolean, boolean):void");
    }

    public long a(String str) throws Throwable {
        SQLiteDatabase sQLiteDatabaseA;
        Cursor cursorA = null;
        long j10 = 0;
        try {
            try {
                sQLiteDatabaseA = g.a(f23601d).a();
            } catch (Exception unused) {
            }
            try {
                sQLiteDatabaseA.beginTransaction();
                cursorA = a(e.d.f23565a, sQLiteDatabaseA, new String[]{e.d.a.f23572g}, "__ii=? ", new String[]{str}, null, null, null, null);
                if (cursorA != null) {
                    cursorA.moveToFirst();
                    j10 = cursorA.getLong(cursorA.getColumnIndex(e.d.a.f23572g));
                }
                if (cursorA != null) {
                    cursorA.close();
                }
            } catch (Exception unused2) {
                if (cursorA != null) {
                    cursorA.close();
                }
                if (sQLiteDatabaseA != null) {
                }
                g.a(f23601d).b();
                return j10;
            } catch (Throwable th2) {
                th = th2;
                if (cursorA != null) {
                    try {
                        cursorA.close();
                    } catch (Exception unused3) {
                        g.a(f23601d).b();
                        throw th;
                    }
                }
                if (sQLiteDatabaseA != null) {
                    sQLiteDatabaseA.endTransaction();
                }
                g.a(f23601d).b();
                throw th;
            }
        } catch (Exception unused4) {
            sQLiteDatabaseA = null;
        } catch (Throwable th3) {
            th = th3;
            sQLiteDatabaseA = null;
        }
        sQLiteDatabaseA.endTransaction();
        g.a(f23601d).b();
        return j10;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:0|2|(4:26|3|(1:5)|6)|22|9|10|14|(1:(0))) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(java.lang.String r4) {
        /*
            r3 = this;
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.i.f23601d     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteDatabaseCorruptException -> L40
            com.umeng.analytics.pro.g r1 = com.umeng.analytics.pro.g.a(r1)     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteDatabaseCorruptException -> L40
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteDatabaseCorruptException -> L40
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteDatabaseCorruptException -> L40
            boolean r1 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteDatabaseCorruptException -> L40
            if (r1 != 0) goto L2d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteDatabaseCorruptException -> L40
            r1.<init>()     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteDatabaseCorruptException -> L40
            java.lang.String r2 = "delete from __is where __ii=\""
            r1.append(r2)     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteDatabaseCorruptException -> L40
            r1.append(r4)     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteDatabaseCorruptException -> L40
            java.lang.String r4 = "\""
            r1.append(r4)     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteDatabaseCorruptException -> L40
            java.lang.String r4 = r1.toString()     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteDatabaseCorruptException -> L40
            r0.execSQL(r4)     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteDatabaseCorruptException -> L40
        L2d:
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L31 android.database.sqlite.SQLiteDatabaseCorruptException -> L40
            goto L33
        L31:
            if (r0 == 0) goto L36
        L33:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L36
        L36:
            android.content.Context r4 = com.umeng.analytics.pro.i.f23601d
            com.umeng.analytics.pro.g r4 = com.umeng.analytics.pro.g.a(r4)
            r4.b()
            goto L48
        L40:
            android.content.Context r4 = com.umeng.analytics.pro.i.f23601d     // Catch: java.lang.Throwable -> L49
            com.umeng.analytics.pro.h.a(r4)     // Catch: java.lang.Throwable -> L49
            if (r0 == 0) goto L36
            goto L33
        L48:
            return
        L49:
            r4 = move-exception
            if (r0 == 0) goto L4f
            r0.endTransaction()     // Catch: java.lang.Throwable -> L4f
        L4f:
            android.content.Context r0 = com.umeng.analytics.pro.i.f23601d
            com.umeng.analytics.pro.g r0 = com.umeng.analytics.pro.g.a(r0)
            r0.b()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.b(java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0077 A[Catch: all -> 0x0069, TryCatch #2 {all -> 0x0069, blocks: (B:22:0x0056, B:24:0x005c, B:26:0x006c, B:28:0x0077, B:29:0x007c, B:36:0x008b, B:38:0x0091, B:40:0x0097, B:42:0x009d, B:44:0x00ab, B:41:0x009a), top: B:56:0x0056 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0056 A[EXC_TOP_SPLITTER, LOOP:1: B:56:0x0056->B:24:0x005c, LOOP_START, PHI: r14
  0x0056: PHI (r14v2 java.lang.String) = (r14v7 java.lang.String), (r14v3 java.lang.String) binds: [B:21:0x0054, B:24:0x005c] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(java.lang.String r18, org.json.JSONObject r19, android.database.sqlite.SQLiteDatabase r20, java.lang.String r21) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 233
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.a(java.lang.String, org.json.JSONObject, android.database.sqlite.SQLiteDatabase, java.lang.String):void");
    }

    public JSONObject a(boolean z10) {
        a();
        this.f23607j.clear();
        JSONObject jSONObject = new JSONObject();
        if (!z10) {
            a(jSONObject, z10);
            b(jSONObject, (String) null);
            a(jSONObject, (String) null);
        } else {
            String strA = a(jSONObject, z10);
            if (!TextUtils.isEmpty(strA)) {
                b(jSONObject, strA);
                a(jSONObject, strA);
            }
        }
        return jSONObject;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:0|2|(2:94|3)|(7:97|4|(1:6)(1:7)|8|(7:10|(6:13|(2:17|(2:107|19)(2:114|108))(1:106)|20|(3:105|22|(5:103|27|(1:29)(1:30)|31|112))(3:100|32|(5:104|34|(1:36)(1:37)|38|110)(1:109))|108|11)|99|39|(5:41|(4:44|(3:116|46|119)(1:118)|117|42)|115|47|(1:49))|50|(5:52|(4:55|(3:121|57|124)(1:123)|122|53)|120|58|(1:60)))|61|(1:63))|89|75|93|76|77|(1:(0))) */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0193 A[PHI: r0 r1
  0x0193: PHI (r0v4 android.database.Cursor) = (r0v2 android.database.Cursor), (r0v3 android.database.Cursor), (r0v5 android.database.Cursor) binds: [B:68:0x0180, B:74:0x018e, B:75:0x0190] A[DONT_GENERATE, DONT_INLINE]
  0x0193: PHI (r1v5 android.database.sqlite.SQLiteDatabase) = 
  (r1v3 android.database.sqlite.SQLiteDatabase)
  (r1v4 android.database.sqlite.SQLiteDatabase)
  (r1v6 android.database.sqlite.SQLiteDatabase)
 binds: [B:68:0x0180, B:74:0x018e, B:75:0x0190] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(org.json.JSONObject r14, java.lang.String r15) {
        /*
            Method dump skipped, instruction units count: 434
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.a(org.json.JSONObject, java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x022f A[EXC_TOP_SPLITTER, PHI: r0 r12 r14
  0x022f: PHI (r0v6 java.lang.String) = (r0v2 java.lang.String), (r0v3 java.lang.String), (r0v38 java.lang.String), (r0v38 java.lang.String) binds: [B:90:0x021e, B:96:0x022d, B:82:0x0208, B:83:0x020a] A[DONT_GENERATE, DONT_INLINE]
  0x022f: PHI (r12v6 android.database.sqlite.SQLiteDatabase) = 
  (r12v3 android.database.sqlite.SQLiteDatabase)
  (r12v4 android.database.sqlite.SQLiteDatabase)
  (r12v7 android.database.sqlite.SQLiteDatabase)
  (r12v7 android.database.sqlite.SQLiteDatabase)
 binds: [B:90:0x021e, B:96:0x022d, B:82:0x0208, B:83:0x020a] A[DONT_GENERATE, DONT_INLINE]
  0x022f: PHI (r14v6 android.database.Cursor) = 
  (r14v3 android.database.Cursor)
  (r14v4 android.database.Cursor)
  (r14v33 android.database.Cursor)
  (r14v33 android.database.Cursor)
 binds: [B:90:0x021e, B:96:0x022d, B:82:0x0208, B:83:0x020a] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0232 A[PHI: r0 r12 r14
  0x0232: PHI (r0v5 java.lang.String) = (r0v2 java.lang.String), (r0v3 java.lang.String), (r0v6 java.lang.String) binds: [B:90:0x021e, B:96:0x022d, B:97:0x022f] A[DONT_GENERATE, DONT_INLINE]
  0x0232: PHI (r12v5 android.database.sqlite.SQLiteDatabase) = 
  (r12v3 android.database.sqlite.SQLiteDatabase)
  (r12v4 android.database.sqlite.SQLiteDatabase)
  (r12v6 android.database.sqlite.SQLiteDatabase)
 binds: [B:90:0x021e, B:96:0x022d, B:97:0x022f] A[DONT_GENERATE, DONT_INLINE]
  0x0232: PHI (r14v5 android.database.Cursor) = (r14v3 android.database.Cursor), (r14v4 android.database.Cursor), (r14v6 android.database.Cursor) binds: [B:90:0x021e, B:96:0x022d, B:97:0x022f] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x022a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String a(org.json.JSONObject r22, boolean r23) {
        /*
            Method dump skipped, instruction units count: 593
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.a(org.json.JSONObject, boolean):java.lang.String");
    }

    public void a(boolean z10, boolean z11) {
        SQLiteDatabase sQLiteDatabaseA = null;
        try {
            try {
                try {
                    sQLiteDatabaseA = g.a(f23601d).a();
                    sQLiteDatabaseA.beginTransaction();
                    if (!z11) {
                        int size = this.f23609l.size();
                        int i10 = 0;
                        if (size > 0) {
                            int i11 = 0;
                            while (i10 < size) {
                                String str = this.f23609l.get(i10);
                                if (str == null) {
                                    i11 = 1;
                                }
                                sQLiteDatabaseA.execSQL("delete from __is where __ii=\"" + str + "\"");
                                i10++;
                            }
                            i10 = i11;
                        }
                        if (i10 != 0) {
                            sQLiteDatabaseA.execSQL("delete from __is where __ii is null");
                        }
                    } else if (z10) {
                        sQLiteDatabaseA.execSQL("delete from __is");
                    }
                    sQLiteDatabaseA.setTransactionSuccessful();
                } catch (Throwable unused) {
                    h.a(f23601d);
                    if (sQLiteDatabaseA != null) {
                    }
                    g.a(f23601d).b();
                }
            } catch (SQLiteDatabaseCorruptException unused2) {
                h.a(f23601d);
                if (sQLiteDatabaseA != null) {
                }
                g.a(f23601d).b();
            }
            try {
                sQLiteDatabaseA.endTransaction();
            } catch (Throwable unused3) {
            }
            g.a(f23601d).b();
        } catch (Throwable th2) {
            if (sQLiteDatabaseA != null) {
                try {
                    sQLiteDatabaseA.endTransaction();
                } catch (Throwable unused4) {
                }
            }
            g.a(f23601d).b();
            throw th2;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:0|2|(4:26|3|(1:5)|6)|24|9|10|14|(1:(0))) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(boolean r4, java.lang.String r5) {
        /*
            r3 = this;
            java.lang.String r4 = "\""
            r0 = 0
            android.content.Context r1 = com.umeng.analytics.pro.i.f23601d     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            com.umeng.analytics.pro.g r1 = com.umeng.analytics.pro.g.a(r1)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            android.database.sqlite.SQLiteDatabase r0 = r1.a()     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            r0.beginTransaction()     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            if (r1 != 0) goto L60
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            r1.<init>()     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            java.lang.String r2 = "delete from __er where __i=\""
            r1.append(r2)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            r1.append(r5)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            r1.append(r4)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            r0.execSQL(r1)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            r1.<init>()     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            java.lang.String r2 = "delete from __et where __i=\""
            r1.append(r2)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            r1.append(r5)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            r1.append(r4)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            r0.execSQL(r1)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            java.util.List<java.lang.Integer> r1 = r3.f23607j     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            r1.clear()     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            r1.<init>()     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            java.lang.String r2 = "delete from __sd where __ii=\""
            r1.append(r2)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            r1.append(r5)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            r1.append(r4)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            java.lang.String r4 = r1.toString()     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            r0.execSQL(r4)     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
        L60:
            r0.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L64 android.database.sqlite.SQLiteDatabaseCorruptException -> L73
            goto L66
        L64:
            if (r0 == 0) goto L69
        L66:
            r0.endTransaction()     // Catch: java.lang.Throwable -> L69
        L69:
            android.content.Context r4 = com.umeng.analytics.pro.i.f23601d
            com.umeng.analytics.pro.g r4 = com.umeng.analytics.pro.g.a(r4)
            r4.b()
            goto L7b
        L73:
            android.content.Context r4 = com.umeng.analytics.pro.i.f23601d     // Catch: java.lang.Throwable -> L7c
            com.umeng.analytics.pro.h.a(r4)     // Catch: java.lang.Throwable -> L7c
            if (r0 == 0) goto L69
            goto L66
        L7b:
            return
        L7c:
            r4 = move-exception
            if (r0 == 0) goto L82
            r0.endTransaction()     // Catch: java.lang.Throwable -> L82
        L82:
            android.content.Context r5 = com.umeng.analytics.pro.i.f23601d
            com.umeng.analytics.pro.g r5 = com.umeng.analytics.pro.g.a(r5)
            r5.b()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.pro.i.a(boolean, java.lang.String):void");
    }
}
