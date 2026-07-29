package okhttp3.internal.connection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\f¢\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H\u0002R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012¨\u0006\u0018"}, d2 = {"Lokhttp3/internal/connection/b;", "", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "Lokhttp3/k;", "a", "Ljava/io/IOException;", "e", "", "b", "socket", "c", "", "Ljava/util/List;", "connectionSpecs", "", "I", "nextModeIndex", "Z", "isFallbackPossible", "d", "isFallback", "<init>", "(Ljava/util/List;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final List<okhttp3.k> f43796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f43797b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f43798c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f43799d;

    public b(@k List<okhttp3.k> connectionSpecs) {
        f0.p(connectionSpecs, "connectionSpecs");
        this.f43796a = connectionSpecs;
    }

    @k
    public final okhttp3.k a(@k SSLSocket sslSocket) throws IOException {
        okhttp3.k kVar;
        f0.p(sslSocket, "sslSocket");
        int i10 = this.f43797b;
        int size = this.f43796a.size();
        while (true) {
            if (i10 >= size) {
                kVar = null;
                break;
            }
            int i11 = i10 + 1;
            kVar = this.f43796a.get(i10);
            if (kVar.h(sslSocket)) {
                this.f43797b = i11;
                break;
            }
            i10 = i11;
        }
        if (kVar != null) {
            this.f43798c = c(sslSocket);
            kVar.f(sslSocket, this.f43799d);
            return kVar;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Unable to find acceptable protocols. isFallback=");
        sb2.append(this.f43799d);
        sb2.append(", modes=");
        sb2.append(this.f43796a);
        sb2.append(", supported protocols=");
        String[] enabledProtocols = sslSocket.getEnabledProtocols();
        f0.m(enabledProtocols);
        String string = Arrays.toString(enabledProtocols);
        f0.o(string, "toString(this)");
        sb2.append(string);
        throw new UnknownServiceException(sb2.toString());
    }

    public final boolean b(@k IOException e10) {
        f0.p(e10, "e");
        this.f43799d = true;
        return (!this.f43798c || (e10 instanceof ProtocolException) || (e10 instanceof InterruptedIOException) || ((e10 instanceof SSLHandshakeException) && (e10.getCause() instanceof CertificateException)) || (e10 instanceof SSLPeerUnverifiedException) || !(e10 instanceof SSLException)) ? false : true;
    }

    public final boolean c(SSLSocket sSLSocket) {
        int i10 = this.f43797b;
        int size = this.f43796a.size();
        while (i10 < size) {
            int i11 = i10 + 1;
            if (this.f43796a.get(i10).h(sSLSocket)) {
                return true;
            }
            i10 = i11;
        }
        return false;
    }
}
