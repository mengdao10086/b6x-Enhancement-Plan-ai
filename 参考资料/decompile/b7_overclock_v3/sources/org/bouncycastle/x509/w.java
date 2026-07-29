package org.bouncycastle.x509;

import gm.d2;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;
import java.security.Signature;
import java.security.SignatureException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.util.Strings;
import pn.a0;

/* JADX INFO: loaded from: classes6.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Hashtable f46145a = new Hashtable();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Hashtable f46146b = new Hashtable();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Set f46147c = new HashSet();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f46148a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Provider f46149b;

        public a(Object obj, Provider provider) {
            this.f46148a = obj;
            this.f46149b = provider;
        }

        public Object a() {
            return this.f46148a;
        }

        public Provider b() {
            return this.f46149b;
        }
    }

    static {
        Hashtable hashtable = f46145a;
        gm.y yVar = pn.s.f46857y3;
        hashtable.put("MD2WITHRSAENCRYPTION", yVar);
        f46145a.put("MD2WITHRSA", yVar);
        Hashtable hashtable2 = f46145a;
        gm.y yVar2 = pn.s.A3;
        hashtable2.put("MD5WITHRSAENCRYPTION", yVar2);
        f46145a.put("MD5WITHRSA", yVar2);
        Hashtable hashtable3 = f46145a;
        gm.y yVar3 = pn.s.B3;
        hashtable3.put("SHA1WITHRSAENCRYPTION", yVar3);
        f46145a.put("SHA1WITHRSA", yVar3);
        Hashtable hashtable4 = f46145a;
        gm.y yVar4 = pn.s.K3;
        hashtable4.put("SHA224WITHRSAENCRYPTION", yVar4);
        f46145a.put("SHA224WITHRSA", yVar4);
        Hashtable hashtable5 = f46145a;
        gm.y yVar5 = pn.s.H3;
        hashtable5.put("SHA256WITHRSAENCRYPTION", yVar5);
        f46145a.put("SHA256WITHRSA", yVar5);
        Hashtable hashtable6 = f46145a;
        gm.y yVar6 = pn.s.I3;
        hashtable6.put("SHA384WITHRSAENCRYPTION", yVar6);
        f46145a.put("SHA384WITHRSA", yVar6);
        Hashtable hashtable7 = f46145a;
        gm.y yVar7 = pn.s.J3;
        hashtable7.put("SHA512WITHRSAENCRYPTION", yVar7);
        f46145a.put("SHA512WITHRSA", yVar7);
        Hashtable hashtable8 = f46145a;
        gm.y yVar8 = pn.s.G3;
        hashtable8.put("SHA1WITHRSAANDMGF1", yVar8);
        f46145a.put("SHA224WITHRSAANDMGF1", yVar8);
        f46145a.put("SHA256WITHRSAANDMGF1", yVar8);
        f46145a.put("SHA384WITHRSAANDMGF1", yVar8);
        f46145a.put("SHA512WITHRSAANDMGF1", yVar8);
        Hashtable hashtable9 = f46145a;
        gm.y yVar9 = tn.b.f51364f;
        hashtable9.put("RIPEMD160WITHRSAENCRYPTION", yVar9);
        f46145a.put("RIPEMD160WITHRSA", yVar9);
        Hashtable hashtable10 = f46145a;
        gm.y yVar10 = tn.b.f51365g;
        hashtable10.put("RIPEMD128WITHRSAENCRYPTION", yVar10);
        f46145a.put("RIPEMD128WITHRSA", yVar10);
        Hashtable hashtable11 = f46145a;
        gm.y yVar11 = tn.b.f51366h;
        hashtable11.put("RIPEMD256WITHRSAENCRYPTION", yVar11);
        f46145a.put("RIPEMD256WITHRSA", yVar11);
        Hashtable hashtable12 = f46145a;
        gm.y yVar12 = co.r.X0;
        hashtable12.put("SHA1WITHDSA", yVar12);
        f46145a.put("DSAWITHSHA1", yVar12);
        Hashtable hashtable13 = f46145a;
        gm.y yVar13 = kn.d.X;
        hashtable13.put("SHA224WITHDSA", yVar13);
        Hashtable hashtable14 = f46145a;
        gm.y yVar14 = kn.d.Y;
        hashtable14.put("SHA256WITHDSA", yVar14);
        Hashtable hashtable15 = f46145a;
        gm.y yVar15 = kn.d.Z;
        hashtable15.put("SHA384WITHDSA", yVar15);
        Hashtable hashtable16 = f46145a;
        gm.y yVar16 = kn.d.f37589a0;
        hashtable16.put("SHA512WITHDSA", yVar16);
        Hashtable hashtable17 = f46145a;
        gm.y yVar17 = co.r.f11170i0;
        hashtable17.put("SHA1WITHECDSA", yVar17);
        f46145a.put("ECDSAWITHSHA1", yVar17);
        Hashtable hashtable18 = f46145a;
        gm.y yVar18 = co.r.f11178n0;
        hashtable18.put("SHA224WITHECDSA", yVar18);
        Hashtable hashtable19 = f46145a;
        gm.y yVar19 = co.r.f11180o0;
        hashtable19.put("SHA256WITHECDSA", yVar19);
        Hashtable hashtable20 = f46145a;
        gm.y yVar20 = co.r.f11182p0;
        hashtable20.put("SHA384WITHECDSA", yVar20);
        Hashtable hashtable21 = f46145a;
        gm.y yVar21 = co.r.f11184q0;
        hashtable21.put("SHA512WITHECDSA", yVar21);
        Hashtable hashtable22 = f46145a;
        gm.y yVar22 = qm.a.f47464n;
        hashtable22.put("GOST3411WITHGOST3410", yVar22);
        f46145a.put("GOST3411WITHGOST3410-94", yVar22);
        Hashtable hashtable23 = f46145a;
        gm.y yVar23 = qm.a.f47465o;
        hashtable23.put("GOST3411WITHECGOST3410", yVar23);
        f46145a.put("GOST3411WITHECGOST3410-2001", yVar23);
        f46145a.put("GOST3411WITHGOST3410-2001", yVar23);
        f46147c.add(yVar17);
        f46147c.add(yVar18);
        f46147c.add(yVar19);
        f46147c.add(yVar20);
        f46147c.add(yVar21);
        f46147c.add(yVar12);
        f46147c.add(on.b.f44366j);
        f46147c.add(yVar13);
        f46147c.add(yVar14);
        f46147c.add(yVar15);
        f46147c.add(yVar16);
        f46147c.add(yVar22);
        f46147c.add(yVar23);
        gm.y yVar24 = on.b.f44365i;
        d2 d2Var = d2.f29657b;
        f46146b.put("SHA1WITHRSAANDMGF1", d(new zn.b(yVar24, d2Var), 20));
        f46146b.put("SHA224WITHRSAANDMGF1", d(new zn.b(kn.d.f37598f, d2Var), 28));
        f46146b.put("SHA256WITHRSAANDMGF1", d(new zn.b(kn.d.f37592c, d2Var), 32));
        f46146b.put("SHA384WITHRSAANDMGF1", d(new zn.b(kn.d.f37594d, d2Var), 48));
        f46146b.put("SHA512WITHRSAANDMGF1", d(new zn.b(kn.d.f37596e, d2Var), 64));
    }

    public static byte[] a(gm.y yVar, String str, String str2, PrivateKey privateKey, SecureRandom secureRandom, gm.h hVar) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, IOException, NoSuchProviderException {
        if (yVar == null) {
            throw new IllegalStateException("no signature algorithm specified");
        }
        Signature signatureL = l(str, str2);
        if (secureRandom != null) {
            signatureL.initSign(privateKey, secureRandom);
        } else {
            signatureL.initSign(privateKey);
        }
        signatureL.update(hVar.b().v(gm.j.f29713a));
        return signatureL.sign();
    }

    public static byte[] b(gm.y yVar, String str, PrivateKey privateKey, SecureRandom secureRandom, gm.h hVar) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, IOException {
        if (yVar == null) {
            throw new IllegalStateException("no signature algorithm specified");
        }
        Signature signatureK = k(str);
        if (secureRandom != null) {
            signatureK.initSign(privateKey, secureRandom);
        } else {
            signatureK.initSign(privateKey);
        }
        signatureK.update(hVar.b().v(gm.j.f29713a));
        return signatureK.sign();
    }

    public static org.bouncycastle.jce.j c(X500Principal x500Principal) {
        try {
            return new org.bouncycastle.jce.j(x500Principal.getEncoded());
        } catch (IOException unused) {
            throw new IllegalArgumentException("cannot convert principal");
        }
    }

    public static a0 d(zn.b bVar, int i10) {
        return new a0(bVar, new zn.b(pn.s.E3, bVar), new gm.t(i10), new gm.t(1L));
    }

    public static Iterator e() {
        Enumeration enumerationKeys = f46145a.keys();
        ArrayList arrayList = new ArrayList();
        while (enumerationKeys.hasMoreElements()) {
            arrayList.add(enumerationKeys.nextElement());
        }
        return arrayList.iterator();
    }

    public static gm.y f(String str) {
        String strO = Strings.o(str);
        return f46145a.containsKey(strO) ? (gm.y) f46145a.get(strO) : new gm.y(strO);
    }

    public static a g(String str, String str2) throws NoSuchAlgorithmException {
        Provider[] providers = Security.getProviders();
        for (int i10 = 0; i10 != providers.length; i10++) {
            a aVarH = h(str, Strings.o(str2), providers[i10]);
            if (aVarH != null) {
                return aVarH;
            }
            try {
                h(str, str2, providers[i10]);
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        throw new NoSuchAlgorithmException("cannot find implementation " + str2);
    }

    public static a h(String str, String str2, Provider provider) throws NoSuchAlgorithmException {
        String strO = Strings.o(str2);
        while (true) {
            String property = provider.getProperty("Alg.Alias." + str + j3.b.f36044h + strO);
            if (property == null) {
                break;
            }
            strO = property;
        }
        String property2 = provider.getProperty(str + j3.b.f36044h + strO);
        if (property2 == null) {
            throw new NoSuchAlgorithmException("cannot find implementation " + strO + " for provider " + provider.getName());
        }
        try {
            ClassLoader classLoader = provider.getClass().getClassLoader();
            return new a((classLoader != null ? classLoader.loadClass(property2) : Class.forName(property2)).newInstance(), provider);
        } catch (ClassNotFoundException unused) {
            throw new IllegalStateException("algorithm " + strO + " in provider " + provider.getName() + " but no class \"" + property2 + "\" found!");
        } catch (Exception unused2) {
            throw new IllegalStateException("algorithm " + strO + " in provider " + provider.getName() + " but class \"" + property2 + "\" inaccessible!");
        }
    }

    public static Provider i(String str) throws NoSuchProviderException {
        Provider provider = Security.getProvider(str);
        if (provider != null) {
            return provider;
        }
        throw new NoSuchProviderException("Provider " + str + " not found");
    }

    public static zn.b j(gm.y yVar, String str) {
        if (f46147c.contains(yVar)) {
            return new zn.b(yVar);
        }
        String strO = Strings.o(str);
        return f46146b.containsKey(strO) ? new zn.b(yVar, (gm.h) f46146b.get(strO)) : new zn.b(yVar, d2.f29657b);
    }

    public static Signature k(String str) throws NoSuchAlgorithmException {
        return Signature.getInstance(str);
    }

    public static Signature l(String str, String str2) throws NoSuchAlgorithmException, NoSuchProviderException {
        return str2 != null ? Signature.getInstance(str, str2) : Signature.getInstance(str);
    }
}
