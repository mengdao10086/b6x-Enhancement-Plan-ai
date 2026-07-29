package com.umeng.socialize.tracker.utils;

import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.SecureRandom;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import org.apache.http.conn.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes5.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24811a = "HttpClient";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f24812b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f24813c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map<String, String> f24814d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private HttpRequestListener f24815e;

    public enum a {
        POST,
        GET
    }

    public b(String str, a aVar, Map<String, String> map, HttpRequestListener httpRequestListener) {
        this.f24812b = str;
        this.f24813c = aVar;
        this.f24814d = map;
        this.f24815e = httpRequestListener;
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x01cd: IF  (r1 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:85:0x01d2, block:B:83:0x01cd */
    public String a(int i10, String str) {
        HttpsURLConnection httpsURLConnection;
        HttpsURLConnection httpsURLConnection2;
        try {
            try {
                httpsURLConnection = (HttpsURLConnection) new URL(this.f24812b).openConnection();
            } catch (Throwable th2) {
                if (httpsURLConnection2 != null) {
                    httpsURLConnection2.disconnect();
                }
                throw th2;
            }
        } catch (MalformedURLException unused) {
            httpsURLConnection = null;
        } catch (SocketTimeoutException e10) {
            e = e10;
            httpsURLConnection = null;
        } catch (UnknownHostException e11) {
            e = e11;
            httpsURLConnection = null;
        } catch (SSLHandshakeException e12) {
            e = e12;
            httpsURLConnection = null;
        } catch (IOException e13) {
            e = e13;
            httpsURLConnection = null;
        } catch (Throwable th3) {
            th = th3;
            httpsURLConnection = null;
        }
        try {
            httpsURLConnection.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, null, new SecureRandom());
            httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
            Map<String, String> map = this.f24814d;
            if (map != null && !map.isEmpty()) {
                for (String str2 : this.f24814d.keySet()) {
                    if (!TextUtils.isEmpty(str2)) {
                        httpsURLConnection.setRequestProperty(str2, this.f24814d.get(str2));
                    }
                }
            }
            httpsURLConnection.setConnectTimeout(i10);
            httpsURLConnection.setReadTimeout(i10);
            if (this.f24813c == a.POST) {
                httpsURLConnection.setRequestMethod(Constants.HTTP_POST);
            } else {
                httpsURLConnection.setRequestMethod(Constants.HTTP_GET);
            }
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setDefaultUseCaches(false);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpsURLConnection.getOutputStream());
            outputStreamWriter.write(str);
            outputStreamWriter.flush();
            outputStreamWriter.close();
            HttpRequestListener httpRequestListener = this.f24815e;
            if (httpRequestListener != null) {
                httpRequestListener.a();
            }
            httpsURLConnection.connect();
        } catch (MalformedURLException unused2) {
            if (httpsURLConnection != null) {
            }
            return null;
        } catch (SocketTimeoutException e14) {
            e = e14;
            if (this.f24815e != null) {
                this.f24815e.a(new Throwable(com.umeng.socialize.tracker.utils.a.Timeout.a() + e.getMessage()));
            }
            if (httpsURLConnection != null) {
            }
            return null;
        } catch (UnknownHostException e15) {
            e = e15;
            if (this.f24815e != null) {
                this.f24815e.a(new Throwable(com.umeng.socialize.tracker.utils.a.UnKnownHostException.a() + e.getMessage()));
            }
            if (httpsURLConnection != null) {
            }
            return null;
        } catch (SSLHandshakeException e16) {
            e = e16;
            if (this.f24815e != null) {
                this.f24815e.a(new Throwable(com.umeng.socialize.tracker.utils.a.SSLException.a() + e.getMessage()));
            }
            if (httpsURLConnection != null) {
            }
            return null;
        } catch (IOException e17) {
            e = e17;
            if (this.f24815e != null) {
                this.f24815e.a(new Throwable(com.umeng.socialize.tracker.utils.a.IOException.a() + e.getMessage()));
            }
            if (httpsURLConnection != null) {
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            HttpRequestListener httpRequestListener2 = this.f24815e;
            if (httpRequestListener2 != null) {
                httpRequestListener2.a(th);
            }
            if (httpsURLConnection != null) {
            }
            return null;
        }
        if (httpsURLConnection.getResponseCode() != 200) {
            if (this.f24815e != null) {
                this.f24815e.a(new Throwable(com.umeng.socialize.tracker.utils.a.HttpError.a() + "Http Response Code:" + httpsURLConnection.getResponseCode()));
            }
            httpsURLConnection.disconnect();
            return null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream(), "utf-8"));
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            stringBuffer.append(line);
        }
        String string = stringBuffer.toString();
        bufferedReader.close();
        HttpRequestListener httpRequestListener3 = this.f24815e;
        if (httpRequestListener3 != null) {
            httpRequestListener3.a(string);
        }
        httpsURLConnection.disconnect();
        return string;
    }
}
