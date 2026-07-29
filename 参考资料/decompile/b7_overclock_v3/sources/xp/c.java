package xp;

import com.blankj.utilcode.util.i0;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import org.bouncycastle.est.s;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes5.dex */
public class c implements org.bouncycastle.est.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SSLSocketFactory f55721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f55722b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f55723c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f55724d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<String> f55725e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Long f55726f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f55727g;

    public c(SSLSocketFactory sSLSocketFactory, i iVar, int i10, a aVar, Set<String> set, Long l10, boolean z10) throws GeneralSecurityException {
        this.f55721a = sSLSocketFactory;
        this.f55722b = iVar;
        this.f55723c = i10;
        this.f55724d = aVar;
        this.f55725e = set;
        this.f55726f = l10;
        this.f55727g = z10;
    }

    @Override // org.bouncycastle.est.h
    public s a(String str, int i10) throws IOException {
        SSLSocket sSLSocket = (SSLSocket) this.f55721a.createSocket(str, i10);
        sSLSocket.setSoTimeout(this.f55723c);
        Set<String> set = this.f55725e;
        if (set != null && !set.isEmpty()) {
            if (this.f55727g) {
                HashSet hashSet = new HashSet();
                String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
                for (int i11 = 0; i11 != supportedCipherSuites.length; i11++) {
                    hashSet.add(supportedCipherSuites[i11]);
                }
                ArrayList arrayList = new ArrayList();
                for (String str2 : this.f55725e) {
                    if (hashSet.contains(str2)) {
                        arrayList.add(str2);
                    }
                }
                if (arrayList.isEmpty()) {
                    throw new IllegalStateException("No supplied cipher suite is supported by the provider.");
                }
                sSLSocket.setEnabledCipherSuites((String[]) arrayList.toArray(new String[arrayList.size()]));
            } else {
                Set<String> set2 = this.f55725e;
                sSLSocket.setEnabledCipherSuites((String[]) set2.toArray(new String[set2.size()]));
            }
        }
        sSLSocket.startHandshake();
        i iVar = this.f55722b;
        if (iVar != null && !iVar.a(str, sSLSocket.getSession())) {
            throw new IOException("Host name could not be verified.");
        }
        String strK = Strings.k(sSLSocket.getSession().getCipherSuite());
        if (strK.contains("_des_") || strK.contains("_des40_") || strK.contains("_3des_")) {
            throw new IOException("EST clients must not use DES ciphers");
        }
        if (Strings.k(sSLSocket.getSession().getCipherSuite()).contains(i0.f11859x)) {
            throw new IOException("EST clients must not use NULL ciphers");
        }
        if (Strings.k(sSLSocket.getSession().getCipherSuite()).contains("anon")) {
            throw new IOException("EST clients must not use anon ciphers");
        }
        if (Strings.k(sSLSocket.getSession().getCipherSuite()).contains("export")) {
            throw new IOException("EST clients must not use export ciphers");
        }
        if (sSLSocket.getSession().getProtocol().equalsIgnoreCase("tlsv1")) {
            try {
                sSLSocket.close();
            } catch (Exception unused) {
            }
            throw new IOException("EST clients must not use TLSv1");
        }
        i iVar2 = this.f55722b;
        if (iVar2 == null || iVar2.a(str, sSLSocket.getSession())) {
            return new j(sSLSocket, this.f55724d, this.f55726f);
        }
        throw new IOException("Hostname was not verified: " + str);
    }
}
