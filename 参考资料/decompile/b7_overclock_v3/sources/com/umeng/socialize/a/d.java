package com.umeng.socialize.a;

import android.os.SystemClock;
import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import com.tencent.connect.common.Constants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import no.nordicsemi.android.dfu.DfuBaseService;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24533a = "NetClient";

    public static JSONObject a(JSONObject jSONObject, String str, String str2, boolean z10) throws Exception {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        URL url = new URL(str);
        try {
            JSONObject jSONObject2 = new JSONObject(a(jSONObject.toString(), (HttpURLConnection) url.openConnection(), str2));
            if (m.a() && z10) {
                m.a(f24533a, "req: ", url, "\n", jSONObject, "\nresp:\n", jSONObject2, "\nconsume:", Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime));
            }
            return jSONObject2;
        } catch (Throwable th2) {
            if (m.a() && z10) {
                m.a(f24533a, "req: ", url, "\n", jSONObject, "\nresp:\n", null, "\nconsume:", Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime));
            }
            throw th2;
        }
    }

    private static String a(String str, HttpURLConnection httpURLConnection, String str2) throws Exception {
        OutputStream outputStream;
        InputStream errorStream;
        byte[] bytes = str2.getBytes();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        l.a(str.getBytes(), byteArrayOutputStream);
        byte[] bArrA = i.a(byteArrayOutputStream.toByteArray(), bytes);
        httpURLConnection.setRequestMethod(Constants.HTTP_POST);
        httpURLConnection.setReadTimeout(30000);
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.addRequestProperty("Content-Type", DfuBaseService.MIME_TYPE_OCTET_STREAM);
        httpURLConnection.addRequestProperty(HttpHeaders.CONTENT_ENCODING, "xgzip");
        httpURLConnection.addRequestProperty("appkey", str2);
        httpURLConnection.setFixedLengthStreamingMode(bArrA.length);
        httpURLConnection.setDoOutput(true);
        try {
            outputStream = httpURLConnection.getOutputStream();
            try {
                outputStream.write(bArrA);
                c.a(outputStream);
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode < 400) {
                    errorStream = httpURLConnection.getInputStream();
                } else {
                    errorStream = httpURLConnection.getErrorStream();
                }
                byteArrayOutputStream.reset();
                if (errorStream != null) {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        try {
                            int i10 = errorStream.read(bArr);
                            if (i10 == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, i10);
                        } finally {
                            c.a(errorStream);
                        }
                    }
                }
                try {
                    httpURLConnection.disconnect();
                } catch (Throwable unused) {
                }
                if (responseCode == 200 && TextUtils.equals("xgzip", httpURLConnection.getHeaderField(HttpHeaders.CONTENT_ENCODING))) {
                    byte[] bArrA2 = i.a(byteArrayOutputStream.toByteArray(), bytes);
                    byteArrayOutputStream.reset();
                    l.b(bArrA2, byteArrayOutputStream);
                }
                String string = byteArrayOutputStream.toString();
                if (responseCode == 200) {
                    return string;
                }
                throw new IOException("code:" + responseCode + " msg:" + string);
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            outputStream = null;
        }
    }

    public static void a(JSONObject jSONObject, String str, String str2) throws Exception {
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        String string = jSONObject.toString();
        byte[] bytes = str2.getBytes();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        l.a(string.getBytes(), byteArrayOutputStream);
        byte[] bArrA = i.a(byteArrayOutputStream.toByteArray(), bytes);
        SystemClock.elapsedRealtime();
        InputStream errorStream = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection2.setRequestMethod(Constants.HTTP_POST);
                httpURLConnection2.setReadTimeout(60000);
                httpURLConnection2.setConnectTimeout(60000);
                httpURLConnection2.addRequestProperty("Content-Type", DfuBaseService.MIME_TYPE_OCTET_STREAM);
                httpURLConnection2.addRequestProperty("appkey", str2);
                httpURLConnection2.setFixedLengthStreamingMode(bArrA.length);
                httpURLConnection2.setDoOutput(true);
                OutputStream outputStream = httpURLConnection2.getOutputStream();
                try {
                    outputStream.write(bArrA);
                    int responseCode = httpURLConnection2.getResponseCode();
                    if (responseCode < 400) {
                        errorStream = httpURLConnection2.getInputStream();
                    } else {
                        errorStream = httpURLConnection2.getErrorStream();
                    }
                    byteArrayOutputStream.reset();
                    if (errorStream != null) {
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int i10 = errorStream.read(bArr);
                            if (i10 == -1) {
                                break;
                            } else {
                                byteArrayOutputStream.write(bArr, 0, i10);
                            }
                        }
                    }
                    c.a(outputStream);
                    c.a(errorStream);
                    try {
                        httpURLConnection2.disconnect();
                    } catch (Throwable unused) {
                    }
                    if (responseCode == 200) {
                        byte[] bArrA2 = i.a(byteArrayOutputStream.toByteArray(), bytes);
                        byteArrayOutputStream.reset();
                        l.b(bArrA2, byteArrayOutputStream);
                    }
                    byteArrayOutputStream.toString();
                    if (responseCode == 200) {
                        return;
                    }
                    throw new Exception("response code " + responseCode);
                } catch (Throwable th2) {
                    th = th2;
                    httpURLConnection = httpURLConnection2;
                    inputStream = errorStream;
                    errorStream = outputStream;
                    c.a(errorStream);
                    c.a(inputStream);
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Throwable unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                httpURLConnection = httpURLConnection2;
                inputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
            inputStream = null;
            httpURLConnection = null;
        }
    }
}
