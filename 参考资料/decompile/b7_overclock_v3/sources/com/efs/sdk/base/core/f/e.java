package com.efs.sdk.base.core.f;

import android.text.TextUtils;
import com.efs.sdk.base.core.f.f;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.http.HttpResponse;
import com.google.common.net.HttpHeaders;
import g.n0;
import hb.u;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements com.efs.sdk.base.core.c.c {
    private static void a(HttpResponse httpResponse) {
        if (httpResponse == null || TextUtils.isEmpty(httpResponse.data)) {
            return;
        }
        for (String str : httpResponse.data.split("`")) {
            String[] strArrSplit = str.split(u.f30904o);
            if (strArrSplit.length >= 2) {
                if (strArrSplit[0].equalsIgnoreCase("retcode")) {
                    httpResponse.setBizCode(strArrSplit[1]);
                } else {
                    ((Map) httpResponse.extra).put(strArrSplit[0], strArrSplit[1]);
                }
            }
        }
    }

    @Override // com.efs.sdk.base.core.c.c
    @n0
    public final HttpResponse a(com.efs.sdk.base.core.d.b bVar, boolean z10) {
        HttpResponse httpResponse;
        try {
            c cVar = f.a.f12921a.f12917a;
            String strValueOf = String.valueOf(System.currentTimeMillis());
            String strA = com.efs.sdk.base.core.util.b.b.a(cVar.f12910b + cVar.f12911c + strValueOf + "AppChk#2014");
            StringBuilder sb2 = new StringBuilder();
            String str = cVar.f12909a;
            if (str.startsWith("http")) {
                sb2.append(str);
                sb2.append("?chk=");
            } else {
                sb2.append(str);
                sb2.append("?chk=");
            }
            sb2.append(strA.substring(strA.length() - 8));
            sb2.append("&vno=");
            sb2.append(strValueOf);
            sb2.append("&uuid=");
            sb2.append(cVar.f12911c);
            sb2.append("&app=");
            sb2.append(cVar.f12910b);
            sb2.append("&zip=gzip");
            String string = sb2.toString();
            int length = 0;
            byte[] bArrA = new byte[0];
            int i10 = bVar.f12890a.f12885c;
            if (i10 == 0) {
                bArrA = bVar.f12892c;
                length = bArrA.length;
            } else if (1 == i10) {
                bArrA = com.efs.sdk.base.core.util.b.a(bVar.f12893d.getPath());
                length = bArrA.length;
            }
            HashMap map = new HashMap();
            map.put("Content-Type", "application/x-www-form-urlencoded");
            map.put(HttpHeaders.CONTENT_LENGTH, String.valueOf(length));
            com.efs.sdk.base.core.util.a.d dVarA = new com.efs.sdk.base.core.util.a.d(string).a(map);
            dVarA.f12941a.f12935c = bArrA;
            httpResponse = dVarA.a().b();
            a(httpResponse);
        } catch (Throwable th2) {
            httpResponse = 0 == 0 ? new HttpResponse() : null;
            Log.e("efs.wa.send", "get file size error", th2);
        }
        if (httpResponse.succ) {
            Log.i("efs.base", "wa upload succ, " + httpResponse.toString());
            com.efs.sdk.base.core.util.b.b(bVar.f12893d);
            return httpResponse;
        }
        Log.i("efs.base", "wa upload fail, resp is " + httpResponse.toString());
        return httpResponse;
    }
}
