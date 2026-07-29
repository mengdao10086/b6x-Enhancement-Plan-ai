package org.bouncycastle.pqc.jcajce.provider;

import com.blankj.utilcode.util.i0;
import gm.y;
import java.io.IOException;
import java.security.AccessController;
import java.security.PrivateKey;
import java.security.PrivilegedAction;
import java.security.Provider;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;
import pn.u;
import uq.c;
import zn.c1;

/* JADX INFO: loaded from: classes6.dex */
public class BouncyCastlePQCProvider extends Provider implements uq.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f45994a = "BouncyCastle Post-Quantum Security Provider v1.70";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f45995b = "BCPQC";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f45996c = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f45998e = "org.bouncycastle.pqc.jcajce.provider.";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map f45997d = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String[] f45999f = {"Rainbow", "McEliece", "SPHINCS", "LMS", "NH", "XMSS", "QTESLA"};

    public class a implements PrivilegedAction {
        public a() {
        }

        @Override // java.security.PrivilegedAction
        public Object run() {
            BouncyCastlePQCProvider.this.t();
            return null;
        }
    }

    public static class b implements PrivilegedAction {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f46001a;

        public b(String str) {
            this.f46001a = str;
        }

        @Override // java.security.PrivilegedAction
        public Object run() {
            try {
                return Class.forName(this.f46001a);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    public BouncyCastlePQCProvider() {
        super(f45995b, 1.7d, f45994a);
        AccessController.doPrivileged(new a());
    }

    public static br.c n(y yVar) {
        br.c cVar;
        Map map = f45997d;
        synchronized (map) {
            cVar = (br.c) map.get(yVar);
        }
        return cVar;
    }

    public static PrivateKey o(u uVar) throws IOException {
        br.c cVarN = n(uVar.B().x());
        if (cVarN == null) {
            return null;
        }
        return cVarN.b(uVar);
    }

    public static PublicKey p(c1 c1Var) throws IOException {
        br.c cVarN = n(c1Var.x().x());
        if (cVarN == null) {
            return null;
        }
        return cVarN.a(c1Var);
    }

    public static Class r(Class cls, String str) {
        try {
            ClassLoader classLoader = cls.getClassLoader();
            return classLoader != null ? classLoader.loadClass(str) : (Class) AccessController.doPrivileged(new b(str));
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    @Override // uq.a
    public void a(String str, Object obj) {
        synchronized (f45996c) {
        }
    }

    @Override // uq.a
    public void b(y yVar, br.c cVar) {
        Map map = f45997d;
        synchronized (map) {
            map.put(yVar, cVar);
        }
    }

    @Override // uq.a
    public boolean c(String str, String str2) {
        if (!containsKey(str + j3.b.f36044h + str2)) {
            if (!containsKey("Alg.Alias." + str + j3.b.f36044h + str2)) {
                return false;
            }
        }
        return true;
    }

    @Override // uq.a
    public void d(String str, Map<String, String> map) {
        for (String str2 : map.keySet()) {
            String str3 = str + i0.f11861z + str2;
            if (containsKey(str3)) {
                throw new IllegalStateException("duplicate provider attribute key (" + str3 + ") found");
            }
            put(str3, map.get(str2));
        }
    }

    @Override // uq.a
    public void h(String str, String str2) {
        if (!containsKey(str)) {
            put(str, str2);
            return;
        }
        throw new IllegalStateException("duplicate provider key (" + str + ") found");
    }

    @Override // uq.a
    public void k(String str, y yVar, String str2) {
        if (!containsKey(str + j3.b.f36044h + str2)) {
            throw new IllegalStateException("primary key (" + str + j3.b.f36044h + str2 + ") not found");
        }
        h(str + j3.b.f36044h + yVar, str2);
        h(str + ".OID." + yVar, str2);
    }

    @Override // uq.a
    public br.c l(y yVar) {
        return (br.c) f45997d.get(yVar);
    }

    public final void q(String str, String[] strArr) {
        for (int i10 = 0; i10 != strArr.length; i10++) {
            Class clsR = r(BouncyCastlePQCProvider.class, str + strArr[i10] + "$Mappings");
            if (clsR != null) {
                try {
                    ((br.a) clsR.newInstance()).a(this);
                } catch (Exception e10) {
                    throw new InternalError("cannot create instance of " + str + strArr[i10] + "$Mappings : " + e10);
                }
            }
        }
    }

    public final void t() {
        q(f45998e, f45999f);
    }
}
