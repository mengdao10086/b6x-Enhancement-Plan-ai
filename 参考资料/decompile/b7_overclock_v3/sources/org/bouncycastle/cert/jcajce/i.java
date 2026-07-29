package org.bouncycastle.cert.jcajce;

import cs.o;
import gm.c0;
import gm.f0;
import gm.k0;
import gm.y;
import gm.z;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import javax.security.auth.x500.X500Principal;
import zn.b0;
import zn.b1;
import zn.c1;

/* JADX INFO: loaded from: classes5.dex */
public class i extends p000do.f {

    public static class a implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ByteArrayOutputStream f44490a = new ByteArrayOutputStream();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public MessageDigest f44491b;

        public a(MessageDigest messageDigest) {
            this.f44491b = messageDigest;
        }

        @Override // cs.o
        public zn.b a() {
            return new zn.b(on.b.f44365i);
        }

        @Override // cs.o
        public OutputStream b() {
            return this.f44490a;
        }

        @Override // cs.o
        public byte[] c() {
            byte[] bArrDigest = this.f44491b.digest(this.f44490a.toByteArray());
            this.f44490a.reset();
            return bArrDigest;
        }
    }

    public i() throws NoSuchAlgorithmException {
        super(new a(MessageDigest.getInstance("SHA1")));
    }

    public i(o oVar) {
        super(oVar);
    }

    public static Collection n(byte[] bArr) throws CertificateParsingException {
        Object objB;
        if (bArr == null) {
            return Collections.EMPTY_LIST;
        }
        try {
            ArrayList arrayList = new ArrayList();
            Enumeration enumerationL = f0.J(q(bArr)).L();
            while (enumerationL.hasMoreElements()) {
                b0 b0VarZ = b0.z(enumerationL.nextElement());
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(org.bouncycastle.util.j.g(b0VarZ.q()));
                switch (b0VarZ.q()) {
                    case 0:
                    case 3:
                    case 5:
                        objB = b0VarZ.A().b();
                        break;
                    case 1:
                    case 2:
                    case 6:
                        objB = ((k0) b0VarZ.A()).d();
                        break;
                    case 4:
                        objB = xn.d.A(b0VarZ.A()).toString();
                        break;
                    case 7:
                        arrayList2.add(z.I(b0VarZ.A()).J());
                        continue;
                        arrayList.add(arrayList2);
                        break;
                    case 8:
                        objB = y.N(b0VarZ.A()).L();
                        break;
                    default:
                        throw new IOException("Bad tag number: " + b0VarZ.q());
                }
                arrayList2.add(objB);
                arrayList.add(arrayList2);
            }
            return Collections.unmodifiableCollection(arrayList);
        } catch (Exception e10) {
            throw new CertificateParsingException(e10.getMessage());
        }
    }

    public static Collection o(X509Certificate x509Certificate) throws CertificateParsingException {
        return n(x509Certificate.getExtensionValue(zn.y.f59062i.L()));
    }

    public static Collection p(X509Certificate x509Certificate) throws CertificateParsingException {
        return n(x509Certificate.getExtensionValue(zn.y.f59061h.L()));
    }

    public static c0 q(byte[] bArr) throws IOException {
        return c0.D(z.I(bArr).J());
    }

    public zn.i h(PublicKey publicKey) {
        return super.c(c1.A(publicKey.getEncoded()));
    }

    public zn.i i(PublicKey publicKey, X500Principal x500Principal, BigInteger bigInteger) {
        return super.d(c1.A(publicKey.getEncoded()), new zn.c0(new b0(xn.d.A(x500Principal.getEncoded()))), bigInteger);
    }

    public zn.i j(PublicKey publicKey, zn.c0 c0Var, BigInteger bigInteger) {
        return super.d(c1.A(publicKey.getEncoded()), c0Var, bigInteger);
    }

    public zn.i k(X509Certificate x509Certificate) throws CertificateEncodingException {
        return super.b(new JcaX509CertificateHolder(x509Certificate));
    }

    public b1 l(PublicKey publicKey) {
        return super.e(c1.A(publicKey.getEncoded()));
    }

    public b1 m(PublicKey publicKey) {
        return super.f(c1.A(publicKey.getEncoded()));
    }
}
