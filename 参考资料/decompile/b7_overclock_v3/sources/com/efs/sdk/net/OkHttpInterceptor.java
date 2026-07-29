package com.efs.sdk.net;

import com.efs.sdk.base.Constants;
import com.efs.sdk.net.a.a.e;
import com.efs.sdk.net.a.a.f;
import com.efs.sdk.net.a.a.g;
import com.efs.sdk.net.a.a.h;
import com.google.common.net.HttpHeaders;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.InflaterOutputStream;
import okhttp3.b0;
import okhttp3.c0;
import okhttp3.d0;
import okhttp3.e0;
import okhttp3.i;
import okhttp3.v;
import okhttp3.w;
import okio.f0;
import okio.k;
import okio.l;

/* JADX INFO: loaded from: classes2.dex */
public class OkHttpInterceptor implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f f13038a = g.c();

    public static class a extends e0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final e0 f13039a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final l f13040b;

        public a(e0 e0Var, InputStream inputStream) {
            this.f13039a = e0Var;
            this.f13040b = f0.e(f0.u(inputStream));
        }

        @Override // okhttp3.e0
        public final long contentLength() {
            return this.f13039a.contentLength();
        }

        @Override // okhttp3.e0
        public final w contentType() {
            return this.f13039a.contentType();
        }

        @Override // okhttp3.e0
        public final l source() {
            return this.f13040b;
        }
    }

    public static class b implements f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f13041a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final b0 f13042b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private h f13043c;

        public b(String str, b0 b0Var, h hVar) {
            this.f13041a = str;
            this.f13042b = b0Var;
            this.f13043c = hVar;
        }

        @Override // com.efs.sdk.net.a.a.f.b
        public final String a() {
            return this.f13041a;
        }

        @Override // com.efs.sdk.net.a.a.f.a
        public final String b() {
            return this.f13042b.q().toString();
        }

        @Override // com.efs.sdk.net.a.a.f.a
        public final String c() {
            return this.f13042b.m();
        }

        @Override // com.efs.sdk.net.a.a.f.a
        @yt.l
        public final byte[] d() throws IOException {
            c0 c0VarF = this.f13042b.f();
            if (c0VarF == null) {
                return null;
            }
            h hVar = this.f13043c;
            String strI = this.f13042b.i(HttpHeaders.CONTENT_ENCODING);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            com.efs.sdk.net.a.a.a aVar = new com.efs.sdk.net.a.a.a(Constants.CP_GZIP.equals(strI) ? e.a(byteArrayOutputStream) : "deflate".equals(strI) ? new InflaterOutputStream(byteArrayOutputStream) : byteArrayOutputStream);
            hVar.f13070c = aVar;
            hVar.f13069b = byteArrayOutputStream;
            k kVarD = f0.d(f0.p(aVar));
            try {
                c0VarF.r(kVarD);
                kVarD.close();
                h hVar2 = this.f13043c;
                hVar2.b();
                return hVar2.f13069b.toByteArray();
            } catch (Throwable th2) {
                kVarD.close();
                throw th2;
            }
        }
    }

    public static class c implements f.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f13044a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final b0 f13045b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final d0 f13046c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @yt.l
        private final i f13047d;

        public c(String str, b0 b0Var, d0 d0Var, @yt.l i iVar) {
            this.f13044a = str;
            this.f13045b = b0Var;
            this.f13046c = d0Var;
            this.f13047d = iVar;
        }

        @Override // com.efs.sdk.net.a.a.f.d
        public final String a() {
            return this.f13044a;
        }

        @Override // com.efs.sdk.net.a.a.f.d
        public final int b() {
            return this.f13046c.W();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0035 A[Catch: all -> 0x002d, TryCatch #3 {all -> 0x002d, blocks: (B:7:0x001d, B:10:0x0024, B:14:0x0035, B:16:0x0050, B:15:0x004b), top: B:59:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004b A[Catch: all -> 0x002d, TryCatch #3 {all -> 0x002d, blocks: (B:7:0x001d, B:10:0x0024, B:14:0x0035, B:16:0x0050, B:15:0x004b), top: B:59:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c7 A[Catch: all -> 0x00aa, TryCatch #2 {all -> 0x00aa, blocks: (B:29:0x00a3, B:35:0x00ae, B:37:0x00b4, B:38:0x00c1, B:40:0x00c7, B:42:0x00d7, B:44:0x00e2, B:46:0x00e6, B:47:0x00ea, B:49:0x00fd, B:50:0x0110, B:51:0x0117), top: B:58:0x00a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0110 A[Catch: all -> 0x00aa, TryCatch #2 {all -> 0x00aa, blocks: (B:29:0x00a3, B:35:0x00ae, B:37:0x00b4, B:38:0x00c1, B:40:0x00c7, B:42:0x00d7, B:44:0x00e2, B:46:0x00e6, B:47:0x00ea, B:49:0x00fd, B:50:0x0110, B:51:0x0117), top: B:58:0x00a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // okhttp3.v
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public okhttp3.d0 intercept(okhttp3.v.a r10) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.efs.sdk.net.OkHttpInterceptor.intercept(okhttp3.v$a):okhttp3.d0");
    }
}
