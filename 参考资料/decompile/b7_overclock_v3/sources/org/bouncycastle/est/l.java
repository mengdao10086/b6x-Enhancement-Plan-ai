package org.bouncycastle.est;

import com.google.common.net.HttpHeaders;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;
import org.bouncycastle.est.HttpUtil;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes5.dex */
public class l {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Long f44808l = 0L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f44809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HttpUtil.Headers f44810b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f44811c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final s f44812d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f44813e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f44814f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f44815g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public InputStream f44816h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Long f44817i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f44818j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Long f44819k;

    public class a extends InputStream {
        public a() {
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            return -1;
        }
    }

    public class b extends InputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InputStream f44821a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Long f44822b;

        public b(InputStream inputStream, Long l10) {
            this.f44821a = inputStream;
            this.f44822b = l10;
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (l.this.f44817i == null || l.this.f44817i.longValue() - 1 <= l.this.f44818j) {
                if (this.f44821a.available() > 0) {
                    throw new IOException("Stream closed with extra content in pipe that exceeds content length.");
                }
                this.f44821a.close();
            } else {
                throw new IOException("Stream closed before limit fully read, Read: " + l.this.f44818j + " ContentLength: " + l.this.f44817i);
            }
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            int i10 = this.f44821a.read();
            if (i10 > -1) {
                l.b(l.this);
                if (this.f44822b != null && l.this.f44818j >= this.f44822b.longValue()) {
                    throw new IOException("Absolute Read Limit exceeded: " + this.f44822b);
                }
            }
            return i10;
        }
    }

    public class c extends InputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InputStream f44824a;

        public c(InputStream inputStream) {
            this.f44824a = inputStream;
        }

        public /* synthetic */ c(l lVar, InputStream inputStream, a aVar) {
            this(inputStream);
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return this.f44824a.available();
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f44824a.close();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            return this.f44824a.read();
        }
    }

    public l(j jVar, s sVar) throws IOException {
        this.f44809a = jVar;
        this.f44812d = sVar;
        if (sVar instanceof r) {
            this.f44819k = ((r) sVar).e();
        }
        Set<String> setB = org.bouncycastle.util.p.b("org.bouncycastle.debug.est");
        this.f44816h = (setB.contains("input") || setB.contains("all")) ? new c(this, sVar.c(), null) : sVar.c();
        this.f44810b = new HttpUtil.Headers();
        this.f44811c = new byte[1024];
        n();
    }

    public static /* synthetic */ long b(l lVar) {
        long j10 = lVar.f44818j;
        lVar.f44818j = 1 + j10;
        return j10;
    }

    public void d() throws IOException {
        InputStream inputStream = this.f44816h;
        if (inputStream != null) {
            inputStream.close();
        }
        this.f44812d.close();
    }

    public Long e() {
        String strH = this.f44810b.h(HttpHeaders.CONTENT_LENGTH);
        if (strH == null) {
            return null;
        }
        try {
            return Long.valueOf(Long.parseLong(strH));
        } catch (RuntimeException e10) {
            throw new RuntimeException("Content Length: '" + strH + "' invalid. " + e10.getMessage());
        }
    }

    public String f(String str) {
        return this.f44810b.h(str);
    }

    public HttpUtil.Headers g() {
        return this.f44810b;
    }

    public String h() {
        return this.f44813e;
    }

    public InputStream i() {
        return this.f44816h;
    }

    public j j() {
        return this.f44809a;
    }

    public s k() {
        return this.f44812d;
    }

    public int l() {
        return this.f44814f;
    }

    public String m() {
        return this.f44815g;
    }

    public final void n() throws IOException {
        this.f44813e = o(zc.f.f58383m);
        this.f44814f = Integer.parseInt(o(zc.f.f58383m));
        this.f44815g = o('\n');
        while (true) {
            String strO = o('\n');
            if (strO.length() <= 0) {
                break;
            }
            int iIndexOf = strO.indexOf(58);
            if (iIndexOf > -1) {
                this.f44810b.b(Strings.k(strO.substring(0, iIndexOf).trim()), strO.substring(iIndexOf + 1).trim());
            }
        }
        Long lE = e();
        this.f44817i = lE;
        int i10 = this.f44814f;
        if (i10 == 204 || i10 == 202) {
            if (lE == null) {
                this.f44817i = 0L;
            } else if (i10 == 204 && lE.longValue() > 0) {
                throw new IOException("Got HTTP status 204 but Content-length > 0.");
            }
        }
        Long l10 = this.f44817i;
        if (l10 == null) {
            throw new IOException("No Content-length header.");
        }
        if (l10.equals(f44808l)) {
            this.f44816h = new a();
        }
        if (this.f44817i.longValue() < 0) {
            throw new IOException("Server returned negative content length: " + this.f44819k);
        }
        if (this.f44819k == null || this.f44817i.longValue() < this.f44819k.longValue()) {
            this.f44816h = p(this.f44816h, this.f44819k);
            if ("base64".equalsIgnoreCase(f("content-transfer-encoding"))) {
                this.f44816h = new d(this.f44816h, e());
                return;
            }
            return;
        }
        throw new IOException("Content length longer than absolute read limit: " + this.f44819k + " Content-Length: " + this.f44817i);
    }

    public String o(char c10) throws IOException {
        int i10;
        byte[] bArr;
        int i11;
        int i12 = 0;
        while (true) {
            i10 = this.f44816h.read();
            bArr = this.f44811c;
            i11 = i12 + 1;
            bArr[i12] = (byte) i10;
            if (i11 >= bArr.length) {
                throw new IOException("Server sent line > " + this.f44811c.length);
            }
            if (i10 == c10 || i10 <= -1) {
                break;
            }
            i12 = i11;
        }
        if (i10 != -1) {
            return new String(bArr, 0, i11).trim();
        }
        throw new EOFException();
    }

    public InputStream p(InputStream inputStream, Long l10) {
        return new b(inputStream, l10);
    }
}
