package com.umeng.commonsdk.stateless;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.statistics.common.DataHelper;

/* JADX INFO: loaded from: classes5.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f24144a = "10.0.0.172";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f24145b = 80;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f24146c;

    public c(Context context) {
        this.f24146c = context;
    }

    private void a() {
        String strImprintProperty = UMEnvelopeBuild.imprintProperty(this.f24146c, "sl_domain_p", "");
        if (TextUtils.isEmpty(strImprintProperty)) {
            return;
        }
        a.f24128i = DataHelper.assembleStatelessURL(strImprintProperty);
    }

    private void b() {
        String strImprintProperty = UMEnvelopeBuild.imprintProperty(this.f24146c, "sl_domain_p", "");
        String strImprintProperty2 = UMEnvelopeBuild.imprintProperty(this.f24146c, "oversea_sl_domain_p", "");
        if (!TextUtils.isEmpty(strImprintProperty)) {
            a.f24127h = DataHelper.assembleStatelessURL(strImprintProperty);
        }
        if (!TextUtils.isEmpty(strImprintProperty2)) {
            a.f24130k = DataHelper.assembleStatelessURL(strImprintProperty2);
        }
        a.f24128i = a.f24130k;
        if (TextUtils.isEmpty(com.umeng.commonsdk.statistics.b.f24154b)) {
            return;
        }
        if (com.umeng.commonsdk.statistics.b.f24154b.startsWith("460") || com.umeng.commonsdk.statistics.b.f24154b.startsWith("461")) {
            a.f24128i = a.f24127h;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0120 A[PHI: r1 r3 r11
  0x0120: PHI (r1v2 boolean) = (r1v0 boolean), (r1v0 boolean), (r1v3 boolean) binds: [B:34:0x010c, B:43:0x011d, B:21:0x00f3] A[DONT_GENERATE, DONT_INLINE]
  0x0120: PHI (r3v9 java.io.OutputStream) = (r3v7 java.io.OutputStream), (r3v8 java.io.OutputStream), (r3v10 java.io.OutputStream) binds: [B:34:0x010c, B:43:0x011d, B:21:0x00f3] A[DONT_GENERATE, DONT_INLINE]
  0x0120: PHI (r11v7 ??) = (r11v5 javax.net.ssl.HttpsURLConnection), (r11v6 javax.net.ssl.HttpsURLConnection), (r11v8 ??) binds: [B:34:0x010c, B:43:0x011d, B:21:0x00f3] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v12, types: [javax.net.ssl.HttpsURLConnection] */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r11v8, types: [javax.net.ssl.HttpsURLConnection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(byte[] r9, java.lang.String r10, java.lang.String r11, java.lang.String r12) {
        /*
            Method dump skipped, instruction units count: 318
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.stateless.c.a(byte[], java.lang.String, java.lang.String, java.lang.String):boolean");
    }
}
