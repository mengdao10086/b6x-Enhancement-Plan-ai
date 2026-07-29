package com.umeng.umzid;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.connect.common.Constants;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.security.SecureRandom;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import no.nordicsemi.android.dfu.DfuBaseService;

/* JADX INFO: loaded from: classes5.dex */
public class a {
    public static SharedPreferences a(Context context) {
        if (context != null) {
            return context.getSharedPreferences("umzid_general_config", 0);
        }
        return null;
    }

    public static synchronized String a(String str, String str2) {
        byte[] byteArray;
        try {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
            httpsURLConnection.setHostnameVerifier(new b());
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, null, new SecureRandom());
            httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
            httpsURLConnection.setRequestProperty("Content-Type", DfuBaseService.MIME_TYPE_OCTET_STREAM);
            httpsURLConnection.setConnectTimeout(30000);
            httpsURLConnection.setReadTimeout(30000);
            httpsURLConnection.setRequestMethod(Constants.HTTP_POST);
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setDoInput(true);
            OutputStream outputStream = httpsURLConnection.getOutputStream();
            byte[] bytes = str2.getBytes();
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                gZIPOutputStream.write(bytes);
                gZIPOutputStream.close();
                byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
            } catch (Exception e10) {
                e10.printStackTrace();
                byteArray = null;
            }
            outputStream.write(a(byteArray, "7EC2papS9acZxgIb".getBytes()));
            outputStream.flush();
            outputStream.close();
            if (httpsURLConnection.getResponseCode() == 200) {
                InputStream inputStream = httpsURLConnection.getInputStream();
                byte[] bArr = new byte[1024];
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                while (true) {
                    int i10 = inputStream.read(bArr);
                    if (i10 == -1) {
                        return new String(a(byteArrayOutputStream2.toByteArray(), "7EC2papS9acZxgIb".getBytes()));
                    }
                    byteArrayOutputStream2.write(bArr, 0, i10);
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr != null && bArr.length != 0 && bArr2 != null && bArr2.length != 0) {
            for (int i10 = 0; i10 < bArr.length; i10++) {
                bArr[i10] = (byte) ((bArr[i10] ^ bArr2[i10 % bArr2.length]) ^ (i10 & 255));
            }
        }
        return bArr;
    }
}
