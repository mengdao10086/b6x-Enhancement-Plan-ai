package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import android.text.TextUtils;
import com.efs.sdk.base.Constants;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.common.base.Predicate;
import com.google.common.net.HttpHeaders;
import ed.z;
import g.i1;
import g.p0;
import hd.t;
import hd.u0;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: classes3.dex */
public class e extends ed.e implements HttpDataSource {
    public static final int A = 307;
    public static final int B = 308;
    public static final long C = 2048;
    public static final Pattern D = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f19223w = 8000;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f19224x = 8000;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f19225y = "DefaultHttpDataSource";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f19226z = 20;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f19227f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f19228g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f19229h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @p0
    public final String f19230i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @p0
    public final HttpDataSource.c f19231j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final HttpDataSource.c f19232k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @p0
    public Predicate<String> f19233l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @p0
    public com.google.android.exoplayer2.upstream.b f19234m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @p0
    public HttpURLConnection f19235n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @p0
    public InputStream f19236o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public byte[] f19237p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f19238q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f19239r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f19240s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f19241t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f19242u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f19243v;

    public static final class b implements HttpDataSource.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @p0
        public z f19245b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @p0
        public Predicate<String> f19246c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @p0
        public String f19247d;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f19250g;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HttpDataSource.c f19244a = new HttpDataSource.c();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f19248e = 8000;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f19249f = 8000;

        @Override // com.google.android.exoplayer2.upstream.HttpDataSource.b
        @Deprecated
        public final HttpDataSource.c c() {
            return this.f19244a;
        }

        @Override // com.google.android.exoplayer2.upstream.HttpDataSource.b, com.google.android.exoplayer2.upstream.a.InterfaceC0197a
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public e a() {
            e eVar = new e(this.f19247d, this.f19248e, this.f19249f, this.f19250g, this.f19244a, this.f19246c);
            z zVar = this.f19245b;
            if (zVar != null) {
                eVar.d(zVar);
            }
            return eVar;
        }

        public b e(boolean z10) {
            this.f19250g = z10;
            return this;
        }

        public b f(int i10) {
            this.f19248e = i10;
            return this;
        }

        public b g(@p0 Predicate<String> predicate) {
            this.f19246c = predicate;
            return this;
        }

        @Override // com.google.android.exoplayer2.upstream.HttpDataSource.b
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public final b b(Map<String, String> map) {
            this.f19244a.b(map);
            return this;
        }

        public b i(int i10) {
            this.f19249f = i10;
            return this;
        }

        public b j(@p0 z zVar) {
            this.f19245b = zVar;
            return this;
        }

        public b k(@p0 String str) {
            this.f19247d = str;
            return this;
        }
    }

    public static long D(HttpURLConnection httpURLConnection) {
        long j10;
        String headerField = httpURLConnection.getHeaderField(HttpHeaders.CONTENT_LENGTH);
        if (TextUtils.isEmpty(headerField)) {
            j10 = -1;
        } else {
            try {
                j10 = Long.parseLong(headerField);
            } catch (NumberFormatException unused) {
                t.d(f19225y, "Unexpected Content-Length [" + headerField + "]");
                j10 = -1;
            }
        }
        String headerField2 = httpURLConnection.getHeaderField(HttpHeaders.CONTENT_RANGE);
        if (TextUtils.isEmpty(headerField2)) {
            return j10;
        }
        Matcher matcher = D.matcher(headerField2);
        if (!matcher.find()) {
            return j10;
        }
        try {
            long j11 = (Long.parseLong((String) hd.a.g(matcher.group(2))) - Long.parseLong((String) hd.a.g(matcher.group(1)))) + 1;
            if (j10 < 0) {
                return j11;
            }
            if (j10 == j11) {
                return j10;
            }
            t.n(f19225y, "Inconsistent headers [" + headerField + "] [" + headerField2 + "]");
            return Math.max(j10, j11);
        } catch (NumberFormatException unused2) {
            t.d(f19225y, "Unexpected Content-Range [" + headerField2 + "]");
            return j10;
        }
    }

    public static URL E(URL url, @p0 String str) throws IOException {
        if (str == null) {
            throw new ProtocolException("Null location redirect");
        }
        URL url2 = new URL(url, str);
        String protocol = url2.getProtocol();
        if ("https".equals(protocol) || "http".equals(protocol)) {
            return url2;
        }
        throw new ProtocolException("Unsupported protocol redirect: " + protocol);
    }

    public static boolean F(HttpURLConnection httpURLConnection) {
        return Constants.CP_GZIP.equalsIgnoreCase(httpURLConnection.getHeaderField(HttpHeaders.CONTENT_ENCODING));
    }

    public static void I(@p0 HttpURLConnection httpURLConnection, long j10) {
        int i10;
        if (httpURLConnection == null || (i10 = u0.f31154a) < 19 || i10 > 20) {
            return;
        }
        try {
            InputStream inputStream = httpURLConnection.getInputStream();
            if (j10 == -1) {
                if (inputStream.read() == -1) {
                    return;
                }
            } else if (j10 <= 2048) {
                return;
            }
            String name = inputStream.getClass().getName();
            if ("com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream".equals(name) || "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream".equals(name)) {
                Method declaredMethod = ((Class) hd.a.g(inputStream.getClass().getSuperclass())).getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(inputStream, new Object[0]);
            }
        } catch (Exception unused) {
        }
    }

    public final long A() {
        return this.f19242u;
    }

    public final void B() {
        HttpURLConnection httpURLConnection = this.f19235n;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e10) {
                t.e(f19225y, "Unexpected error while disconnecting", e10);
            }
            this.f19235n = null;
        }
    }

    @p0
    public final HttpURLConnection C() {
        return this.f19235n;
    }

    public final HttpURLConnection G(com.google.android.exoplayer2.upstream.b bVar) throws IOException {
        HttpURLConnection httpURLConnectionH;
        com.google.android.exoplayer2.upstream.b bVar2 = bVar;
        URL url = new URL(bVar2.f19092a.toString());
        int i10 = bVar2.f19094c;
        byte[] bArr = bVar2.f19095d;
        long j10 = bVar2.f19098g;
        long j11 = bVar2.f19099h;
        boolean zD = bVar2.d(1);
        if (!this.f19227f) {
            return H(url, i10, bArr, j10, j11, zD, true, bVar2.f19096e);
        }
        int i11 = 0;
        while (true) {
            int i12 = i11 + 1;
            if (i11 > 20) {
                throw new NoRouteToHostException("Too many redirects: " + i12);
            }
            byte[] bArr2 = bArr;
            long j12 = j11;
            long j13 = j10;
            httpURLConnectionH = H(url, i10, bArr, j10, j11, zD, false, bVar2.f19096e);
            int responseCode = httpURLConnectionH.getResponseCode();
            String headerField = httpURLConnectionH.getHeaderField("Location");
            if ((i10 == 1 || i10 == 3) && (responseCode == 300 || responseCode == 301 || responseCode == 302 || responseCode == 303 || responseCode == 307 || responseCode == 308)) {
                httpURLConnectionH.disconnect();
                url = E(url, headerField);
            } else {
                if (i10 != 2 || (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303)) {
                    break;
                }
                httpURLConnectionH.disconnect();
                url = E(url, headerField);
                bArr2 = null;
                i10 = 1;
            }
            i11 = i12;
            bArr = bArr2;
            j11 = j12;
            j10 = j13;
            bVar2 = bVar;
        }
        return httpURLConnectionH;
    }

    public final HttpURLConnection H(URL url, int i10, @p0 byte[] bArr, long j10, long j11, boolean z10, boolean z11, Map<String, String> map) throws IOException {
        HttpURLConnection httpURLConnectionJ = J(url);
        httpURLConnectionJ.setConnectTimeout(this.f19228g);
        httpURLConnectionJ.setReadTimeout(this.f19229h);
        HashMap map2 = new HashMap();
        HttpDataSource.c cVar = this.f19231j;
        if (cVar != null) {
            map2.putAll(cVar.c());
        }
        map2.putAll(this.f19232k.c());
        map2.putAll(map);
        for (Map.Entry entry : map2.entrySet()) {
            httpURLConnectionJ.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        if (j10 != 0 || j11 != -1) {
            String str = "bytes=" + j10 + "-";
            if (j11 != -1) {
                str = str + ((j10 + j11) - 1);
            }
            httpURLConnectionJ.setRequestProperty(HttpHeaders.RANGE, str);
        }
        String str2 = this.f19230i;
        if (str2 != null) {
            httpURLConnectionJ.setRequestProperty("User-Agent", str2);
        }
        httpURLConnectionJ.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, z10 ? Constants.CP_GZIP : HlsPlaylistParser.S);
        httpURLConnectionJ.setInstanceFollowRedirects(z11);
        httpURLConnectionJ.setDoOutput(bArr != null);
        httpURLConnectionJ.setRequestMethod(com.google.android.exoplayer2.upstream.b.c(i10));
        if (bArr != null) {
            httpURLConnectionJ.setFixedLengthStreamingMode(bArr.length);
            httpURLConnectionJ.connect();
            OutputStream outputStream = httpURLConnectionJ.getOutputStream();
            outputStream.write(bArr);
            outputStream.close();
        } else {
            httpURLConnectionJ.connect();
        }
        return httpURLConnectionJ;
    }

    @i1
    public HttpURLConnection J(URL url) throws IOException {
        return (HttpURLConnection) url.openConnection();
    }

    public final int K(byte[] bArr, int i10, int i11) throws IOException {
        if (i11 == 0) {
            return 0;
        }
        long j10 = this.f19241t;
        if (j10 != -1) {
            long j11 = j10 - this.f19243v;
            if (j11 == 0) {
                return -1;
            }
            i11 = (int) Math.min(i11, j11);
        }
        int i12 = ((InputStream) u0.k(this.f19236o)).read(bArr, i10, i11);
        if (i12 == -1) {
            if (this.f19241t == -1) {
                return -1;
            }
            throw new EOFException();
        }
        this.f19243v += (long) i12;
        u(i12);
        return i12;
    }

    @Deprecated
    public void L(@p0 Predicate<String> predicate) {
        this.f19233l = predicate;
    }

    public final void M() throws IOException {
        if (this.f19242u == this.f19240s) {
            return;
        }
        if (this.f19237p == null) {
            this.f19237p = new byte[4096];
        }
        while (true) {
            long j10 = this.f19242u;
            long j11 = this.f19240s;
            if (j10 == j11) {
                return;
            }
            int i10 = ((InputStream) u0.k(this.f19236o)).read(this.f19237p, 0, (int) Math.min(j11 - j10, this.f19237p.length));
            if (Thread.currentThread().isInterrupted()) {
                throw new InterruptedIOException();
            }
            if (i10 == -1) {
                throw new EOFException();
            }
            this.f19242u += (long) i10;
            u(i10);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public long a(com.google.android.exoplayer2.upstream.b bVar) throws HttpDataSource.HttpDataSourceException {
        byte[] bArrT1;
        this.f19234m = bVar;
        long j10 = 0;
        this.f19243v = 0L;
        this.f19242u = 0L;
        w(bVar);
        try {
            HttpURLConnection httpURLConnectionG = G(bVar);
            this.f19235n = httpURLConnectionG;
            try {
                this.f19239r = httpURLConnectionG.getResponseCode();
                String responseMessage = httpURLConnectionG.getResponseMessage();
                int i10 = this.f19239r;
                if (i10 < 200 || i10 > 299) {
                    Map<String, List<String>> headerFields = httpURLConnectionG.getHeaderFields();
                    InputStream errorStream = httpURLConnectionG.getErrorStream();
                    try {
                        bArrT1 = errorStream != null ? u0.t1(errorStream) : u0.f31159f;
                    } catch (IOException unused) {
                        bArrT1 = u0.f31159f;
                    }
                    byte[] bArr = bArrT1;
                    B();
                    HttpDataSource.InvalidResponseCodeException invalidResponseCodeException = new HttpDataSource.InvalidResponseCodeException(this.f19239r, responseMessage, headerFields, bVar, bArr);
                    if (this.f19239r == 416) {
                        invalidResponseCodeException.initCause(new DataSourceException(0));
                    }
                    throw invalidResponseCodeException;
                }
                String contentType = httpURLConnectionG.getContentType();
                Predicate<String> predicate = this.f19233l;
                if (predicate != null && !predicate.apply(contentType)) {
                    B();
                    throw new HttpDataSource.InvalidContentTypeException(contentType, bVar);
                }
                if (this.f19239r == 200) {
                    long j11 = bVar.f19098g;
                    if (j11 != 0) {
                        j10 = j11;
                    }
                }
                this.f19240s = j10;
                boolean zF = F(httpURLConnectionG);
                if (zF) {
                    this.f19241t = bVar.f19099h;
                } else {
                    long j12 = bVar.f19099h;
                    if (j12 != -1) {
                        this.f19241t = j12;
                    } else {
                        long jD = D(httpURLConnectionG);
                        this.f19241t = jD != -1 ? jD - this.f19240s : -1L;
                    }
                }
                try {
                    this.f19236o = httpURLConnectionG.getInputStream();
                    if (zF) {
                        this.f19236o = new GZIPInputStream(this.f19236o);
                    }
                    this.f19238q = true;
                    x(bVar);
                    return this.f19241t;
                } catch (IOException e10) {
                    B();
                    throw new HttpDataSource.HttpDataSourceException(e10, bVar, 1);
                }
            } catch (IOException e11) {
                B();
                throw new HttpDataSource.HttpDataSourceException("Unable to connect", e11, bVar, 1);
            }
        } catch (IOException e12) {
            String message = e12.getMessage();
            if (message == null || !u0.w1(message).matches("cleartext http traffic.*not permitted.*")) {
                throw new HttpDataSource.HttpDataSourceException("Unable to connect", e12, bVar, 1);
            }
            throw new HttpDataSource.CleartextNotPermittedException(e12, bVar);
        }
    }

    @Override // ed.e, com.google.android.exoplayer2.upstream.a
    public Map<String, List<String>> c() {
        HttpURLConnection httpURLConnection = this.f19235n;
        return httpURLConnection == null ? Collections.emptyMap() : httpURLConnection.getHeaderFields();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() throws HttpDataSource.HttpDataSourceException {
        try {
            InputStream inputStream = this.f19236o;
            if (inputStream != null) {
                I(this.f19235n, z());
                try {
                    inputStream.close();
                } catch (IOException e10) {
                    throw new HttpDataSource.HttpDataSourceException(e10, (com.google.android.exoplayer2.upstream.b) u0.k(this.f19234m), 3);
                }
            }
        } finally {
            this.f19236o = null;
            B();
            if (this.f19238q) {
                this.f19238q = false;
                v();
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.HttpDataSource
    public void f(String str, String str2) {
        hd.a.g(str);
        hd.a.g(str2);
        this.f19232k.e(str, str2);
    }

    @Override // com.google.android.exoplayer2.upstream.HttpDataSource
    public int k() {
        int i10;
        if (this.f19235n == null || (i10 = this.f19239r) <= 0) {
            return -1;
        }
        return i10;
    }

    @Override // com.google.android.exoplayer2.upstream.HttpDataSource
    public void p() {
        this.f19232k.a();
    }

    @Override // com.google.android.exoplayer2.upstream.HttpDataSource
    public void r(String str) {
        hd.a.g(str);
        this.f19232k.d(str);
    }

    @Override // ed.h
    public int read(byte[] bArr, int i10, int i11) throws HttpDataSource.HttpDataSourceException {
        try {
            M();
            return K(bArr, i10, i11);
        } catch (IOException e10) {
            throw new HttpDataSource.HttpDataSourceException(e10, (com.google.android.exoplayer2.upstream.b) u0.k(this.f19234m), 2);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    @p0
    public Uri s() {
        HttpURLConnection httpURLConnection = this.f19235n;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    public final long y() {
        return this.f19243v;
    }

    public final long z() {
        long j10 = this.f19241t;
        return j10 == -1 ? j10 : j10 - this.f19243v;
    }

    @Deprecated
    public e() {
        this(null, 8000, 8000);
    }

    @Deprecated
    public e(@p0 String str) {
        this(str, 8000, 8000);
    }

    @Deprecated
    public e(@p0 String str, int i10, int i11) {
        this(str, i10, i11, false, null);
    }

    @Deprecated
    public e(@p0 String str, int i10, int i11, boolean z10, @p0 HttpDataSource.c cVar) {
        this(str, i10, i11, z10, cVar, null);
    }

    public e(@p0 String str, int i10, int i11, boolean z10, @p0 HttpDataSource.c cVar, @p0 Predicate<String> predicate) {
        super(true);
        this.f19230i = str;
        this.f19228g = i10;
        this.f19229h = i11;
        this.f19227f = z10;
        this.f19231j = cVar;
        this.f19233l = predicate;
        this.f19232k = new HttpDataSource.c();
    }
}
