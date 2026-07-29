package com.bumptech.glide.load.data;

import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.HttpException;
import com.bumptech.glide.load.data.d;
import g.i1;
import g.n0;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class j implements d<InputStream> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f12198g = "HttpUrlFetcher";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f12199h = 5;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @i1
    public static final String f12200i = "Location";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @i1
    public static final b f12201j = new a();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @i1
    public static final int f12202k = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h4.g f12203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f12205c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public HttpURLConnection f12206d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public InputStream f12207e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f12208f;

    public static class a implements b {
        @Override // com.bumptech.glide.load.data.j.b
        public HttpURLConnection a(URL url) throws IOException {
            return (HttpURLConnection) url.openConnection();
        }
    }

    public interface b {
        HttpURLConnection a(URL url) throws IOException;
    }

    public j(h4.g gVar, int i10) {
        this(gVar, i10, f12201j);
    }

    public static int d(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getResponseCode();
        } catch (IOException unused) {
            return -1;
        }
    }

    public static boolean h(int i10) {
        return i10 / 100 == 2;
    }

    public static boolean i(int i10) {
        return i10 / 100 == 3;
    }

    @Override // com.bumptech.glide.load.data.d
    @n0
    public Class<InputStream> a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.d
    public void b() {
        InputStream inputStream = this.f12207e;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.f12206d;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.f12206d = null;
    }

    public final HttpURLConnection c(URL url, Map<String, String> map) throws HttpException {
        try {
            HttpURLConnection httpURLConnectionA = this.f12205c.a(url);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                httpURLConnectionA.addRequestProperty(entry.getKey(), entry.getValue());
            }
            httpURLConnectionA.setConnectTimeout(this.f12204b);
            httpURLConnectionA.setReadTimeout(this.f12204b);
            httpURLConnectionA.setUseCaches(false);
            httpURLConnectionA.setDoInput(true);
            httpURLConnectionA.setInstanceFollowRedirects(false);
            return httpURLConnectionA;
        } catch (IOException e10) {
            throw new HttpException("URL.openConnection threw", 0, e10);
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public void cancel() {
        this.f12208f = true;
    }

    @Override // com.bumptech.glide.load.data.d
    @n0
    public DataSource e() {
        return DataSource.REMOTE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.load.data.d
    public void f(@n0 Priority priority, @n0 d.a<? super InputStream> aVar) {
        StringBuilder sb2;
        String str = f12198g;
        long jB = v4.i.b();
        try {
            try {
                aVar.d(j(this.f12203a.i(), 0, null, this.f12203a.e()));
                str = str;
            } catch (IOException e10) {
                Log.isLoggable(f12198g, 3);
                aVar.c(e10);
                str = str;
                if (Log.isLoggable(f12198g, 2)) {
                    sb2 = new StringBuilder();
                }
            }
            if (Log.isLoggable(f12198g, 2)) {
                sb2 = new StringBuilder();
                sb2.append("Finished http url fetcher fetch in ");
                double dA = v4.i.a(jB);
                sb2.append(dA);
                str = dA;
            }
        } catch (Throwable th2) {
            if (Log.isLoggable(str, 2)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Finished http url fetcher fetch in ");
                sb3.append(v4.i.a(jB));
            }
            throw th2;
        }
    }

    public final InputStream g(HttpURLConnection httpURLConnection) throws HttpException {
        try {
            if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
                this.f12207e = v4.c.c(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
            } else {
                if (Log.isLoggable(f12198g, 3)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Got non empty content encoding: ");
                    sb2.append(httpURLConnection.getContentEncoding());
                }
                this.f12207e = httpURLConnection.getInputStream();
            }
            return this.f12207e;
        } catch (IOException e10) {
            throw new HttpException("Failed to obtain InputStream", d(httpURLConnection), e10);
        }
    }

    public final InputStream j(URL url, int i10, URL url2, Map<String, String> map) throws HttpException {
        if (i10 >= 5) {
            throw new HttpException("Too many (> 5) redirects!", -1);
        }
        if (url2 != null) {
            try {
                if (url.toURI().equals(url2.toURI())) {
                    throw new HttpException("In re-direct loop", -1);
                }
            } catch (URISyntaxException unused) {
            }
        }
        HttpURLConnection httpURLConnectionC = c(url, map);
        this.f12206d = httpURLConnectionC;
        try {
            httpURLConnectionC.connect();
            this.f12207e = this.f12206d.getInputStream();
            if (this.f12208f) {
                return null;
            }
            int iD = d(this.f12206d);
            if (h(iD)) {
                return g(this.f12206d);
            }
            if (!i(iD)) {
                if (iD == -1) {
                    throw new HttpException(iD);
                }
                try {
                    throw new HttpException(this.f12206d.getResponseMessage(), iD);
                } catch (IOException e10) {
                    throw new HttpException("Failed to get a response message", iD, e10);
                }
            }
            String headerField = this.f12206d.getHeaderField("Location");
            if (TextUtils.isEmpty(headerField)) {
                throw new HttpException("Received empty or null redirect url", iD);
            }
            try {
                URL url3 = new URL(url, headerField);
                b();
                return j(url3, i10 + 1, url, map);
            } catch (MalformedURLException e11) {
                throw new HttpException("Bad redirect url: " + headerField, iD, e11);
            }
        } catch (IOException e12) {
            throw new HttpException("Failed to connect or obtain data", d(this.f12206d), e12);
        }
    }

    @i1
    public j(h4.g gVar, int i10, b bVar) {
        this.f12203a = gVar;
        this.f12204b = i10;
        this.f12205c = bVar;
    }
}
