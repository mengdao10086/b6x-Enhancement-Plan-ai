package org.bouncycastle.cms.jcajce;

import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.HashSet;
import java.util.Set;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.jcajce.util.AnnotatedPrivateKey;

/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set f44498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set f44499b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set f44500c;

    static {
        HashSet hashSet = new HashSet();
        f44498a = hashSet;
        HashSet hashSet2 = new HashSet();
        f44499b = hashSet2;
        HashSet hashSet3 = new HashSet();
        f44500c = hashSet3;
        hashSet.add(co.r.f11157b1);
        hashSet.add(rn.d.R);
        hashSet.add(rn.d.S);
        hashSet.add(rn.d.T);
        hashSet.add(rn.d.U);
        hashSet2.add(co.r.f11155a1);
        hashSet2.add(co.r.Z0);
        hashSet2.add(rn.d.N);
        hashSet2.add(rn.d.J);
        hashSet2.add(rn.d.O);
        hashSet2.add(rn.d.K);
        hashSet2.add(rn.d.P);
        hashSet2.add(rn.d.L);
        hashSet2.add(rn.d.Q);
        hashSet2.add(rn.d.M);
        hashSet3.add(qm.a.E);
        hashSet3.add(qm.a.f47463m);
        hashSet3.add(qn.a.f47522l);
        hashSet3.add(qn.a.f47523m);
        hashSet3.add(qn.a.f47517g);
        hashSet3.add(qn.a.f47518h);
    }

    public static PrivateKey a(PrivateKey privateKey) {
        return privateKey instanceof AnnotatedPrivateKey ? a(((AnnotatedPrivateKey) privateKey).d()) : privateKey;
    }

    public static c b(String str) {
        return str != null ? new c(new m0(str)) : new c(new b());
    }

    public static c c(Provider provider) {
        return provider != null ? new c(new n0(provider)) : new c(new b());
    }

    public static gm.h d(AlgorithmParameters algorithmParameters) throws CMSException {
        try {
            return org.bouncycastle.jcajce.util.a.a(algorithmParameters);
        } catch (IOException e10) {
            throw new CMSException("cannot extract parameters: " + e10.getMessage(), e10);
        }
    }

    public static mm.y e(X509Certificate x509Certificate) throws CertificateEncodingException {
        return new mm.y(zn.o.z(x509Certificate.getEncoded()).A(), x509Certificate.getSerialNumber());
    }

    public static byte[] f(X509Certificate x509Certificate) {
        byte[] extensionValue = x509Certificate.getExtensionValue(zn.y.f59058e.L());
        if (extensionValue != null) {
            return gm.z.I(gm.z.I(extensionValue).J()).J();
        }
        return null;
    }

    public static boolean g(gm.y yVar) {
        return f44499b.contains(yVar);
    }

    public static boolean h(gm.y yVar) {
        return f44500c.contains(yVar);
    }

    public static boolean i(gm.y yVar) {
        return f44498a.contains(yVar);
    }

    public static boolean j(gm.y yVar) {
        return yVar.C(pn.s.f46841r6) || yVar.C(pn.s.f46844s6);
    }

    public static void k(AlgorithmParameters algorithmParameters, gm.h hVar) throws CMSException {
        try {
            org.bouncycastle.jcajce.util.a.b(algorithmParameters, hVar);
        } catch (IOException e10) {
            throw new CMSException("error encoding algorithm parameters.", e10);
        }
    }
}
