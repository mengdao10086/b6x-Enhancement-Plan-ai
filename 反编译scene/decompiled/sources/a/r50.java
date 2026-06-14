package a;

import android.util.Base64;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPOutputStream;
import javax.crypto.NoSuchPaddingException;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class r50 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7272a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Proxy f2715a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final byte[] f2716a;
    public final int b;

    public r50(Proxy proxy) {
        this.f2715a = proxy;
        this.f2716a = new byte[]{52, 49, 66, 55, 69, 53, 57, 52, 66, 50, 65, 66, 51, 65, 65, 51, 54, 53, 50, 68, 49, 48, 51, 50, 49, 68, 70, 55, 51, 49, 55, 49};
        this.f7272a = 3000;
        this.b = 5000;
    }

    public /* synthetic */ r50(Proxy proxy, int i, b92 b92Var) {
        this((i & 1) != 0 ? null : proxy);
    }

    public static /* synthetic */ g30 n(r50 r50Var, String str, g30 g30Var, long j, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: postBase64JsonSync");
        }
        if ((i & 4) != 0) {
            j = 5;
        }
        return r50Var.m(str, g30Var, j);
    }

    public static /* synthetic */ String p(r50 r50Var, String str, g30 g30Var, long j, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: postBase64Sync");
        }
        if ((i & 4) != 0) {
            j = 5;
        }
        return r50Var.o(str, g30Var, j);
    }

    public static /* synthetic */ String r(r50 r50Var, String str, byte[] bArr, String str2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: postGzip");
        }
        if ((i & 4) != 0) {
            str2 = "application/json";
        }
        return r50Var.q(str, bArr, str2);
    }

    public final byte[] g(String str) throws IOException {
        URLConnection uRLConnectionOpenConnection;
        f92.d(str, "url");
        if (this.f2715a == null) {
            uRLConnectionOpenConnection = new URL(str).openConnection();
            if (uRLConnectionOpenConnection == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.net.HttpURLConnection");
            }
        } else {
            uRLConnectionOpenConnection = new URL(str).openConnection(this.f2715a);
            if (uRLConnectionOpenConnection == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.net.HttpURLConnection");
            }
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setConnectTimeout(h());
        httpURLConnection.setReadTimeout(i());
        httpURLConnection.setUseCaches(false);
        InputStream inputStream = httpURLConnection.getInputStream();
        f92.c(inputStream, "connection.inputStream");
        byte[] bArrC = j72.c(inputStream);
        httpURLConnection.disconnect();
        return bArrC;
    }

    public int h() {
        return this.f7272a;
    }

    public int i() {
        return this.b;
    }

    public final HttpURLConnection j(String str, String str2) throws IOException {
        URLConnection uRLConnectionOpenConnection;
        if (this.f2715a == null) {
            uRLConnectionOpenConnection = new URL(str).openConnection();
            if (uRLConnectionOpenConnection == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.net.HttpURLConnection");
            }
        } else {
            uRLConnectionOpenConnection = new URL(str).openConnection(this.f2715a);
            if (uRLConnectionOpenConnection == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.net.HttpURLConnection");
            }
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setConnectTimeout(h());
        httpURLConnection.setReadTimeout(i());
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setRequestProperty("Content-Type", str2);
        return httpURLConnection;
    }

    public final String k(String str) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        f92.d(str, "response");
        byte[] bArrB = new f50().b(Base64.decode(str, 11), this.f2716a);
        f92.c(bArrB, "decrypted");
        return new String(bArrB, bb2.f5692a);
    }

    public final String l(String str, g30 g30Var) throws IOException {
        f92.d(str, "url");
        f92.d(g30Var, "json");
        HttpURLConnection httpURLConnectionJ = j(str, "text/plain");
        OutputStream outputStream = httpURLConnectionJ.getOutputStream();
        String strA = g30Var.A(0);
        f92.c(strA, "str");
        Charset charset = bb2.f5692a;
        if (strA == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        byte[] bytes = strA.getBytes(charset);
        f92.c(bytes, "(this as java.lang.String).getBytes(charset)");
        outputStream.write(Base64.encode(bytes, 11));
        outputStream.flush();
        outputStream.close();
        return u(httpURLConnectionJ);
    }

    public final g30 m(String str, g30 g30Var, long j) {
        f92.d(str, "url");
        f92.d(g30Var, "json");
        String strO = o(str, g30Var, j);
        if (strO != null) {
            return v(strO);
        }
        return null;
    }

    public final String o(String str, g30 g30Var, long j) {
        f92.d(str, "url");
        f92.d(g30Var, "json");
        FutureTask futureTask = new FutureTask(new q50(this, str, g30Var));
        qc2.d(xd2.a(qe2.b()), null, null, new p50(futureTask, null), 3, null);
        try {
            return (String) futureTask.get(j, TimeUnit.SECONDS);
        } catch (Exception unused) {
            return null;
        }
    }

    public final String q(String str, byte[] bArr, String str2) throws IOException {
        f92.d(str, "url");
        f92.d(bArr, "bytes");
        f92.d(str2, "contentType");
        HttpURLConnection httpURLConnectionJ = j(str, str2);
        httpURLConnectionJ.setRequestMethod("POST");
        httpURLConnectionJ.setRequestProperty("Content-Encoding", "gzip");
        httpURLConnectionJ.setDoOutput(true);
        OutputStream outputStream = httpURLConnectionJ.getOutputStream();
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
            try {
                gZIPOutputStream.write(bArr);
                m42 m42Var = m42.f6769a;
                k72.a(gZIPOutputStream, null);
                m42 m42Var2 = m42.f6769a;
                k72.a(outputStream, null);
                return u(httpURLConnectionJ);
            } finally {
            }
        } finally {
        }
    }

    public final String s(String str, String str2) {
        f92.d(str, "url");
        f92.d(str2, "text");
        byte[] bytes = str2.getBytes(bb2.f5692a);
        f92.c(bytes, "(this as java.lang.String).getBytes(charset)");
        return t(str, bytes);
    }

    public final String t(String str, byte[] bArr) throws IOException {
        f92.d(str, "url");
        f92.d(bArr, "bytes");
        HttpURLConnection httpURLConnectionJ = j(str, "text/plain");
        OutputStream outputStream = httpURLConnectionJ.getOutputStream();
        outputStream.write(bArr);
        outputStream.flush();
        outputStream.close();
        return u(httpURLConnectionJ);
    }

    public final String u(HttpURLConnection httpURLConnection) {
        f92.d(httpURLConnection, "connection");
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    String string = sb.toString();
                    f92.c(string, "stringBuilder.toString()");
                    return string;
                }
                sb.append(line);
                sb.append("\n");
            }
        } finally {
            httpURLConnection.disconnect();
        }
    }

    public final g30 v(String str) {
        f92.d(str, "str");
        try {
            if (str.length() > 0) {
                return new g30(str);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public final d30 w(String str) {
        f92.d(str, "str");
        try {
            if (str.length() > 0) {
                return new d30(str);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
