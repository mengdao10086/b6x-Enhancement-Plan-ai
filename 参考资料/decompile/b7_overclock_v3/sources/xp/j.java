package xp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import org.bouncycastle.est.r;
import org.bouncycastle.est.s;
import org.bouncycastle.est.t;

/* JADX INFO: loaded from: classes5.dex */
public class j implements s<SSLSession>, t, r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SSLSocket f55754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f55755b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f55756c;

    public j(SSLSocket sSLSocket, a aVar, Long l10) {
        this.f55754a = sSLSocket;
        this.f55755b = aVar;
        this.f55756c = l10;
    }

    @Override // org.bouncycastle.est.t
    public boolean a() {
        return this.f55755b.a(this.f55754a);
    }

    @Override // org.bouncycastle.est.s
    public OutputStream b() throws IOException {
        return this.f55754a.getOutputStream();
    }

    @Override // org.bouncycastle.est.s
    public InputStream c() throws IOException {
        return this.f55754a.getInputStream();
    }

    @Override // org.bouncycastle.est.s
    public void close() throws IOException {
        this.f55754a.close();
    }

    @Override // org.bouncycastle.est.r
    public Long e() {
        return this.f55756c;
    }

    @Override // org.bouncycastle.est.t
    public byte[] f() {
        if (a()) {
            return this.f55755b.b(this.f55754a, "tls-unique");
        }
        throw new IllegalStateException("No binding provider.");
    }

    @Override // org.bouncycastle.est.s
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public SSLSession d() {
        return this.f55754a.getSession();
    }
}
