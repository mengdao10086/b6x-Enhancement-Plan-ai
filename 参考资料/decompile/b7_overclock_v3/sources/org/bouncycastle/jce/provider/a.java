package org.bouncycastle.jce.provider;

import java.security.Permission;
import java.security.spec.DSAParameterSpec;
import java.security.spec.ECParameterSpec;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.crypto.spec.DHParameterSpec;
import org.bouncycastle.crypto.n;
import org.bouncycastle.jcajce.provider.config.ProviderConfigurationPermission;

/* JADX INFO: loaded from: classes5.dex */
public class a implements uq.c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Permission f45358g = new ProviderConfigurationPermission(BouncyCastleProvider.f45329b, uq.a.u6);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Permission f45359h = new ProviderConfigurationPermission(BouncyCastleProvider.f45329b, uq.a.f52388v6);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Permission f45360i = new ProviderConfigurationPermission(BouncyCastleProvider.f45329b, uq.a.f52389w6);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static Permission f45361j = new ProviderConfigurationPermission(BouncyCastleProvider.f45329b, uq.a.f52390x6);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static Permission f45362k = new ProviderConfigurationPermission(BouncyCastleProvider.f45329b, uq.a.f52391y6);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static Permission f45363l = new ProviderConfigurationPermission(BouncyCastleProvider.f45329b, uq.a.f52392z6);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile gr.e f45366c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile Object f45367d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ThreadLocal f45364a = new ThreadLocal();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ThreadLocal f45365b = new ThreadLocal();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile Set f45368e = new HashSet();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile Map f45369f = new HashMap();

    @Override // uq.c
    public Map a() {
        return Collections.unmodifiableMap(this.f45369f);
    }

    @Override // uq.c
    public gr.e b() {
        gr.e eVar = (gr.e) this.f45364a.get();
        return eVar != null ? eVar : this.f45366c;
    }

    @Override // uq.c
    public Set c() {
        return Collections.unmodifiableSet(this.f45368e);
    }

    @Override // uq.c
    public DSAParameterSpec d(int i10) {
        np.z zVar = (np.z) org.bouncycastle.crypto.n.h(n.b.f44703e, i10);
        if (zVar != null) {
            return new DSAParameterSpec(zVar.b(), zVar.c(), zVar.a());
        }
        return null;
    }

    @Override // uq.c
    public DHParameterSpec e(int i10) {
        Object obj = this.f45365b.get();
        if (obj == null) {
            obj = this.f45367d;
        }
        if (obj instanceof DHParameterSpec) {
            DHParameterSpec dHParameterSpec = (DHParameterSpec) obj;
            if (dHParameterSpec.getP().bitLength() == i10) {
                return dHParameterSpec;
            }
        } else if (obj instanceof DHParameterSpec[]) {
            DHParameterSpec[] dHParameterSpecArr = (DHParameterSpec[]) obj;
            for (int i11 = 0; i11 != dHParameterSpecArr.length; i11++) {
                if (dHParameterSpecArr[i11].getP().bitLength() == i10) {
                    return dHParameterSpecArr[i11];
                }
            }
        }
        np.q qVar = (np.q) org.bouncycastle.crypto.n.h(n.b.f44702d, i10);
        if (qVar != null) {
            return new cr.c(qVar);
        }
        return null;
    }

    public void f(String str, Object obj) {
        ThreadLocal threadLocal;
        SecurityManager securityManager = System.getSecurityManager();
        if (str.equals(uq.a.u6)) {
            if (securityManager != null) {
                securityManager.checkPermission(f45358g);
            }
            gr.e eVarG = ((obj instanceof gr.e) || obj == null) ? (gr.e) obj : org.bouncycastle.jcajce.provider.asymmetric.util.h.g((ECParameterSpec) obj);
            if (eVarG != null) {
                this.f45364a.set(eVarG);
                return;
            }
            threadLocal = this.f45364a;
        } else {
            if (str.equals(uq.a.f52388v6)) {
                if (securityManager != null) {
                    securityManager.checkPermission(f45359h);
                }
                if ((obj instanceof gr.e) || obj == null) {
                    this.f45366c = (gr.e) obj;
                    return;
                } else {
                    this.f45366c = org.bouncycastle.jcajce.provider.asymmetric.util.h.g((ECParameterSpec) obj);
                    return;
                }
            }
            if (!str.equals(uq.a.f52389w6)) {
                if (str.equals(uq.a.f52390x6)) {
                    if (securityManager != null) {
                        securityManager.checkPermission(f45361j);
                    }
                    if (!(obj instanceof DHParameterSpec) && !(obj instanceof DHParameterSpec[]) && obj != null) {
                        throw new IllegalArgumentException("not a valid DHParameterSpec or DHParameterSpec[]");
                    }
                    this.f45367d = obj;
                    return;
                }
                if (str.equals(uq.a.f52391y6)) {
                    if (securityManager != null) {
                        securityManager.checkPermission(f45362k);
                    }
                    this.f45368e = (Set) obj;
                    return;
                } else {
                    if (str.equals(uq.a.f52392z6)) {
                        if (securityManager != null) {
                            securityManager.checkPermission(f45363l);
                        }
                        this.f45369f = (Map) obj;
                        return;
                    }
                    return;
                }
            }
            if (securityManager != null) {
                securityManager.checkPermission(f45360i);
            }
            if (!(obj instanceof DHParameterSpec) && !(obj instanceof DHParameterSpec[]) && obj != null) {
                throw new IllegalArgumentException("not a valid DHParameterSpec");
            }
            threadLocal = this.f45365b;
            if (obj != null) {
                threadLocal.set(obj);
                return;
            }
        }
        threadLocal.remove();
    }
}
