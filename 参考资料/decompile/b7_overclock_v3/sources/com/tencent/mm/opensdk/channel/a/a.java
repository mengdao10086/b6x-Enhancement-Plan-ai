package com.tencent.mm.opensdk.channel.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.b;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: com.tencent.mm.opensdk.channel.a.a$a, reason: collision with other inner class name */
    public static class C0244a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f22556a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f22557b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f22558c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f22559d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Bundle f22560e;
    }

    public static int a(Bundle bundle, String str, int i10) {
        if (bundle == null) {
            return i10;
        }
        try {
            return bundle.getInt(str, i10);
        } catch (Exception e10) {
            Log.e("MicroMsg.IntentUtil", "getIntExtra exception:" + e10.getMessage());
            return i10;
        }
    }

    public static Object a(int i10, String str) {
        try {
            switch (i10) {
                case 1:
                    return Integer.valueOf(str);
                case 2:
                    return Long.valueOf(str);
                case 3:
                    return str;
                case 4:
                    return Boolean.valueOf(str);
                case 5:
                    return Float.valueOf(str);
                case 6:
                    return Double.valueOf(str);
                default:
                    Log.e("MicroMsg.SDK.PluginProvider.Resolver", "unknown type");
                    return null;
            }
        } catch (Exception e10) {
            Log.e("MicroMsg.SDK.PluginProvider.Resolver", "resolveObj exception:" + e10.getMessage());
            return null;
        }
    }

    public static String a(Bundle bundle, String str) {
        if (bundle == null) {
            return null;
        }
        try {
            return bundle.getString(str);
        } catch (Exception e10) {
            Log.e("MicroMsg.IntentUtil", "getStringExtra exception:" + e10.getMessage());
            return null;
        }
    }

    public static boolean a(Context context, C0244a c0244a) {
        String str;
        if (context == null || c0244a == null) {
            str = "send fail, invalid argument";
        } else {
            if (!b.b(c0244a.f22557b)) {
                String str2 = null;
                if (!b.b(c0244a.f22556a)) {
                    str2 = c0244a.f22556a + ".permission.MM_MESSAGE";
                }
                Intent intent = new Intent(c0244a.f22557b);
                Bundle bundle = c0244a.f22560e;
                if (bundle != null) {
                    intent.putExtras(bundle);
                }
                String packageName = context.getPackageName();
                intent.putExtra(ConstantsAPI.SDK_VERSION, Build.SDK_INT);
                intent.putExtra(ConstantsAPI.APP_PACKAGE, packageName);
                intent.putExtra(ConstantsAPI.CONTENT, c0244a.f22558c);
                intent.putExtra(ConstantsAPI.APP_SUPORT_CONTENT_TYPE, c0244a.f22559d);
                intent.putExtra(ConstantsAPI.CHECK_SUM, a(c0244a.f22558c, Build.SDK_INT, packageName));
                context.sendBroadcast(intent, str2);
                Log.d("MicroMsg.SDK.MMessage", "send mm message, intent=" + intent + ", perm=" + str2);
                return true;
            }
            str = "send fail, action is null";
        }
        Log.e("MicroMsg.SDK.MMessage", str);
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 4, insn: 0x015b: MOVE (r2 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]), block:B:116:0x015b */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0120 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0160 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0127 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0167 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x00ea A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x016e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:154:0x00f1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x00f8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0119 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:185:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v31 */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r8v32 */
    /* JADX WARN: Type inference failed for: r8v33 */
    /* JADX WARN: Type inference failed for: r8v34 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static byte[] a(java.lang.String r8, int r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 376
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.opensdk.channel.a.a.a(java.lang.String, int):byte[]");
    }

    public static byte[] a(String str, int i10, String str2) {
        String str3;
        StringBuffer stringBuffer = new StringBuffer();
        if (str != null) {
            stringBuffer.append(str);
        }
        stringBuffer.append(i10);
        stringBuffer.append(str2);
        stringBuffer.append("mMcShCsTr");
        byte[] bytes = stringBuffer.toString().substring(1, 9).getBytes();
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bytes);
            byte[] bArrDigest = messageDigest.digest();
            char[] cArr2 = new char[bArrDigest.length * 2];
            int i11 = 0;
            for (byte b10 : bArrDigest) {
                int i12 = i11 + 1;
                cArr2[i11] = cArr[(b10 >>> 4) & 15];
                i11 = i12 + 1;
                cArr2[i12] = cArr[b10 & 15];
            }
            str3 = new String(cArr2);
        } catch (Exception unused) {
            str3 = null;
        }
        return str3.getBytes();
    }
}
