package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.a;
import com.google.common.base.Predicate;
import g.p0;
import hd.u0;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface HttpDataSource extends com.google.android.exoplayer2.upstream.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Predicate<String> f19028a = new Predicate() { // from class: ed.q
        @Override // com.google.common.base.Predicate
        public final boolean apply(Object obj) {
            return r.a((String) obj);
        }
    };

    public static final class CleartextNotPermittedException extends HttpDataSourceException {
        public CleartextNotPermittedException(IOException iOException, com.google.android.exoplayer2.upstream.b bVar) {
            super("Cleartext HTTP traffic not permitted. See https://exoplayer.dev/issues/cleartext-not-permitted", iOException, bVar, 1);
        }
    }

    public static final class InvalidContentTypeException extends HttpDataSourceException {
        public final String contentType;

        public InvalidContentTypeException(String str, com.google.android.exoplayer2.upstream.b bVar) {
            super("Invalid content type: " + str, bVar, 1);
            this.contentType = str;
        }
    }

    public static final class InvalidResponseCodeException extends HttpDataSourceException {
        public final Map<String, List<String>> headerFields;
        public final byte[] responseBody;
        public final int responseCode;

        @p0
        public final String responseMessage;

        @Deprecated
        public InvalidResponseCodeException(int i10, Map<String, List<String>> map, com.google.android.exoplayer2.upstream.b bVar) {
            this(i10, null, map, bVar, u0.f31159f);
        }

        @Deprecated
        public InvalidResponseCodeException(int i10, @p0 String str, Map<String, List<String>> map, com.google.android.exoplayer2.upstream.b bVar) {
            this(i10, str, map, bVar, u0.f31159f);
        }

        public InvalidResponseCodeException(int i10, @p0 String str, Map<String, List<String>> map, com.google.android.exoplayer2.upstream.b bVar, byte[] bArr) {
            super("Response code: " + i10, bVar, 1);
            this.responseCode = i10;
            this.responseMessage = str;
            this.headerFields = map;
            this.responseBody = bArr;
        }
    }

    public static abstract class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f19032a = new c();

        @Override // com.google.android.exoplayer2.upstream.HttpDataSource.b
        public final b b(Map<String, String> map) {
            this.f19032a.b(map);
            return this;
        }

        @Override // com.google.android.exoplayer2.upstream.HttpDataSource.b
        @Deprecated
        public final c c() {
            return this.f19032a;
        }

        public abstract HttpDataSource d(c cVar);

        @Override // com.google.android.exoplayer2.upstream.HttpDataSource.b, com.google.android.exoplayer2.upstream.a.InterfaceC0197a
        public final HttpDataSource a() {
            return d(this.f19032a);
        }
    }

    public interface b extends a.InterfaceC0197a {
        @Override // com.google.android.exoplayer2.upstream.a.InterfaceC0197a
        HttpDataSource a();

        @Override // com.google.android.exoplayer2.upstream.a.InterfaceC0197a
        /* bridge */ /* synthetic */ com.google.android.exoplayer2.upstream.a a();

        b b(Map<String, String> map);

        @Deprecated
        c c();
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, String> f19033a = new HashMap();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @p0
        public Map<String, String> f19034b;

        public synchronized void a() {
            this.f19034b = null;
            this.f19033a.clear();
        }

        public synchronized void b(Map<String, String> map) {
            this.f19034b = null;
            this.f19033a.clear();
            this.f19033a.putAll(map);
        }

        public synchronized Map<String, String> c() {
            if (this.f19034b == null) {
                this.f19034b = Collections.unmodifiableMap(new HashMap(this.f19033a));
            }
            return this.f19034b;
        }

        public synchronized void d(String str) {
            this.f19034b = null;
            this.f19033a.remove(str);
        }

        public synchronized void e(String str, String str2) {
            this.f19034b = null;
            this.f19033a.put(str, str2);
        }

        public synchronized void f(Map<String, String> map) {
            this.f19034b = null;
            this.f19033a.putAll(map);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    long a(com.google.android.exoplayer2.upstream.b bVar) throws HttpDataSourceException;

    @Override // com.google.android.exoplayer2.upstream.a
    Map<String, List<String>> c();

    @Override // com.google.android.exoplayer2.upstream.a
    void close() throws HttpDataSourceException;

    void f(String str, String str2);

    int k();

    void p();

    void r(String str);

    @Override // ed.h
    int read(byte[] bArr, int i10, int i11) throws HttpDataSourceException;

    public static class HttpDataSourceException extends IOException {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f19029a = 1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f19030b = 2;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f19031c = 3;
        public final com.google.android.exoplayer2.upstream.b dataSpec;
        public final int type;

        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface a {
        }

        public HttpDataSourceException(com.google.android.exoplayer2.upstream.b bVar, int i10) {
            this.dataSpec = bVar;
            this.type = i10;
        }

        public HttpDataSourceException(String str, com.google.android.exoplayer2.upstream.b bVar, int i10) {
            super(str);
            this.dataSpec = bVar;
            this.type = i10;
        }

        public HttpDataSourceException(IOException iOException, com.google.android.exoplayer2.upstream.b bVar, int i10) {
            super(iOException);
            this.dataSpec = bVar;
            this.type = i10;
        }

        public HttpDataSourceException(String str, IOException iOException, com.google.android.exoplayer2.upstream.b bVar, int i10) {
            super(str, iOException);
            this.dataSpec = bVar;
            this.type = i10;
        }
    }
}
