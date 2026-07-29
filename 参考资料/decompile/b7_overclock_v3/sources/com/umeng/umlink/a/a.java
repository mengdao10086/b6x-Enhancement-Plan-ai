package com.umeng.umlink.a;

import android.text.TextUtils;
import com.google.android.exoplayer2.audio.j;
import com.tencent.connect.common.Constants;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.security.SecureRandom;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static HostnameVerifier f24857a;

    public static String a(String str, String str2) {
        for (int i10 = 0; i10 < 3; i10++) {
            try {
                HttpsURLConnection httpsURLConnectionB = b(str, str2);
                if (httpsURLConnectionB == null || httpsURLConnectionB.getResponseCode() != 200) {
                    return null;
                }
                InputStreamReader inputStreamReader = new InputStreamReader(httpsURLConnectionB.getInputStream());
                StringBuffer stringBuffer = new StringBuffer();
                while (true) {
                    int i11 = inputStreamReader.read();
                    if (i11 == -1) {
                        return stringBuffer.toString();
                    }
                    stringBuffer.append((char) i11);
                }
            } catch (Exception unused) {
                if (i10 == 2) {
                    return null;
                }
                try {
                    Thread.sleep(j.f16899v);
                } catch (InterruptedException unused2) {
                }
            }
        }
        return null;
    }

    private static HttpsURLConnection b(String str, String str2) {
        HttpsURLConnection httpsURLConnection;
        HttpsURLConnection httpsURLConnection2 = null;
        try {
            httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
        } catch (Exception e10) {
            e = e10;
        }
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, null, new SecureRandom());
            httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
            if (f24857a == null) {
                f24857a = new HostnameVerifier() { // from class: com.umeng.umlink.a.a.1
                    @Override // javax.net.ssl.HostnameVerifier
                    public final boolean verify(String str3, SSLSession sSLSession) {
                        if (TextUtils.isEmpty(str3)) {
                            return false;
                        }
                        return "ucc.umeng.com".equalsIgnoreCase(str3) || "pslog.umeng.com".equalsIgnoreCase(str3) || "pre-deeplink.umeng.com".equalsIgnoreCase(str3) || "deeplink.umeng.com".equalsIgnoreCase(str3);
                    }
                };
            }
            httpsURLConnection.setHostnameVerifier(f24857a);
            httpsURLConnection.setRequestMethod(Constants.HTTP_POST);
            httpsURLConnection.setConnectTimeout(15000);
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setReadTimeout(15000);
            httpsURLConnection.setRequestProperty("Content-Type", "application/json");
            httpsURLConnection.connect();
            OutputStream outputStream = httpsURLConnection.getOutputStream();
            outputStream.write(str2.getBytes());
            outputStream.flush();
            outputStream.close();
            return httpsURLConnection;
        } catch (Exception e11) {
            e = e11;
            httpsURLConnection2 = httpsURLConnection;
            e.printStackTrace();
            return httpsURLConnection2;
        }
    }
}
