package org.bouncycastle.jcajce.provider.keystore.bc;

import fp.h0;
import gp.f;
import ip.k;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Key;
import java.security.KeyStoreException;
import java.security.KeyStoreSpi;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kt.e;
import org.bouncycastle.crypto.n;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.p;
import pn.u;
import zn.c1;
import zo.c0;

/* JADX INFO: loaded from: classes7.dex */
public class BcKeyStoreSpi extends KeyStoreSpi implements er.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f45135e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f45136f = 20;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f45137g = "PBEWithSHAAndTwofish-CBC";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f45138h = 20;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f45139i = 1024;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f45140j = "PBEWithSHAAnd3-KeyTripleDES-CBC";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f45141k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f45142l = 1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f45143m = 2;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f45144n = 3;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f45145o = 4;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f45146p = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f45147q = 1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f45148r = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f45151c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Hashtable f45149a = new Hashtable();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SecureRandom f45150b = n.f();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final org.bouncycastle.jcajce.util.d f45152d = new org.bouncycastle.jcajce.util.b();

    public static class BCKeyStoreException extends KeyStoreException {
        private final Exception cause;

        public BCKeyStoreException(String str, Exception exc) {
            super(str);
            this.cause = exc;
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            return this.cause;
        }
    }

    public static class a extends BcKeyStoreSpi {
        public a() {
            super(1);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bc.BcKeyStoreSpi, java.security.KeyStoreSpi
        public void engineLoad(InputStream inputStream, char[] cArr) throws IOException {
            this.f45149a.clear();
            if (inputStream == null) {
                return;
            }
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            int i10 = dataInputStream.readInt();
            if (i10 != 2 && i10 != 0 && i10 != 1) {
                throw new IOException("Wrong version of key store.");
            }
            int i11 = dataInputStream.readInt();
            byte[] bArr = new byte[i11];
            if (i11 != 20) {
                throw new IOException("Key store corrupted.");
            }
            dataInputStream.readFully(bArr);
            int i12 = dataInputStream.readInt();
            if (i12 < 0 || i12 > 65536) {
                throw new IOException("Key store corrupted.");
            }
            lq.a aVar = new lq.a(dataInputStream, i(i10 == 0 ? "OldPBEWithSHAAndTwofish-CBC" : BcKeyStoreSpi.f45137g, 2, cArr, bArr, i12));
            c0 c0Var = new c0();
            h(new gp.c(aVar, c0Var));
            byte[] bArr2 = new byte[c0Var.h()];
            c0Var.c(bArr2, 0);
            byte[] bArr3 = new byte[c0Var.h()];
            kt.c.g(aVar, bArr3);
            if (org.bouncycastle.util.a.I(bArr2, bArr3)) {
                return;
            }
            this.f45149a.clear();
            throw new IOException("KeyStore integrity check failed.");
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bc.BcKeyStoreSpi, java.security.KeyStoreSpi
        public void engineStore(OutputStream outputStream, char[] cArr) throws IOException {
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            byte[] bArr = new byte[20];
            int iNextInt = (this.f45150b.nextInt() & 1023) + 1024;
            this.f45150b.nextBytes(bArr);
            dataOutputStream.writeInt(this.f45151c);
            dataOutputStream.writeInt(20);
            dataOutputStream.write(bArr);
            dataOutputStream.writeInt(iNextInt);
            lq.b bVar = new lq.b(dataOutputStream, i(BcKeyStoreSpi.f45137g, 1, cArr, bArr, iNextInt));
            gp.d dVar = new gp.d(new c0());
            j(new e(bVar, dVar));
            bVar.write(dVar.a());
            bVar.close();
        }
    }

    public static class b extends BcKeyStoreSpi {
        public b() {
            super(2);
        }
    }

    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f45153a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f45154b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f45155c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Certificate[] f45156d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Date f45157e;

        public c(String str, Key key, char[] cArr, Certificate[] certificateArr) throws Exception {
            this.f45157e = new Date();
            this.f45153a = 4;
            this.f45154b = str;
            this.f45156d = certificateArr;
            byte[] bArr = new byte[20];
            BcKeyStoreSpi.this.f45150b.nextBytes(bArr);
            int iNextInt = (BcKeyStoreSpi.this.f45150b.nextInt() & 1023) + 1024;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeInt(20);
            dataOutputStream.write(bArr);
            dataOutputStream.writeInt(iNextInt);
            DataOutputStream dataOutputStream2 = new DataOutputStream(new lq.b(dataOutputStream, BcKeyStoreSpi.this.i(BcKeyStoreSpi.f45140j, 1, cArr, bArr, iNextInt)));
            BcKeyStoreSpi.this.g(key, dataOutputStream2);
            dataOutputStream2.close();
            this.f45155c = byteArrayOutputStream.toByteArray();
        }

        public c(String str, Certificate certificate) {
            this.f45157e = new Date();
            this.f45153a = 1;
            this.f45154b = str;
            this.f45155c = certificate;
            this.f45156d = null;
        }

        public c(String str, Date date, int i10, Object obj) {
            new Date();
            this.f45154b = str;
            this.f45157e = date;
            this.f45153a = i10;
            this.f45155c = obj;
        }

        public c(String str, Date date, int i10, Object obj, Certificate[] certificateArr) {
            new Date();
            this.f45154b = str;
            this.f45157e = date;
            this.f45153a = i10;
            this.f45155c = obj;
            this.f45156d = certificateArr;
        }

        public c(String str, byte[] bArr, Certificate[] certificateArr) {
            this.f45157e = new Date();
            this.f45153a = 3;
            this.f45154b = str;
            this.f45155c = bArr;
            this.f45156d = certificateArr;
        }

        public String a() {
            return this.f45154b;
        }

        public Certificate[] b() {
            return this.f45156d;
        }

        public Date c() {
            return this.f45157e;
        }

        public Object d() {
            return this.f45155c;
        }

        public Object e(char[] cArr) throws UnrecoverableKeyException, NoSuchAlgorithmException {
            Key keyE;
            if (cArr == null || cArr.length == 0) {
                Object obj = this.f45155c;
                if (obj instanceof Key) {
                    return obj;
                }
            }
            if (this.f45153a != 4) {
                throw new RuntimeException("forget something!");
            }
            DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream((byte[]) this.f45155c));
            try {
                byte[] bArr = new byte[dataInputStream.readInt()];
                dataInputStream.readFully(bArr);
                try {
                    return BcKeyStoreSpi.this.e(new DataInputStream(new lq.a(dataInputStream, BcKeyStoreSpi.this.i(BcKeyStoreSpi.f45140j, 2, cArr, bArr, dataInputStream.readInt()))));
                } catch (Exception unused) {
                    DataInputStream dataInputStream2 = new DataInputStream(new ByteArrayInputStream((byte[]) this.f45155c));
                    byte[] bArr2 = new byte[dataInputStream2.readInt()];
                    dataInputStream2.readFully(bArr2);
                    int i10 = dataInputStream2.readInt();
                    try {
                        keyE = BcKeyStoreSpi.this.e(new DataInputStream(new lq.a(dataInputStream2, BcKeyStoreSpi.this.i("BrokenPBEWithSHAAnd3-KeyTripleDES-CBC", 2, cArr, bArr2, i10))));
                    } catch (Exception unused2) {
                        DataInputStream dataInputStream3 = new DataInputStream(new ByteArrayInputStream((byte[]) this.f45155c));
                        bArr2 = new byte[dataInputStream3.readInt()];
                        dataInputStream3.readFully(bArr2);
                        i10 = dataInputStream3.readInt();
                        keyE = BcKeyStoreSpi.this.e(new DataInputStream(new lq.a(dataInputStream3, BcKeyStoreSpi.this.i("OldPBEWithSHAAnd3-KeyTripleDES-CBC", 2, cArr, bArr2, i10))));
                    }
                    byte[] bArr3 = bArr2;
                    int i11 = i10;
                    if (keyE == null) {
                        throw new UnrecoverableKeyException("no match");
                    }
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                    dataOutputStream.writeInt(bArr3.length);
                    dataOutputStream.write(bArr3);
                    dataOutputStream.writeInt(i11);
                    DataOutputStream dataOutputStream2 = new DataOutputStream(new lq.b(dataOutputStream, BcKeyStoreSpi.this.i(BcKeyStoreSpi.f45140j, 1, cArr, bArr3, i11)));
                    BcKeyStoreSpi.this.g(keyE, dataOutputStream2);
                    dataOutputStream2.close();
                    this.f45155c = byteArrayOutputStream.toByteArray();
                    return keyE;
                }
            } catch (Exception unused3) {
                throw new UnrecoverableKeyException("no match");
            }
        }

        public int f() {
            return this.f45153a;
        }
    }

    public static class d extends BcKeyStoreSpi {
        public d() {
            super(1);
            if (!p.d("org.bouncycastle.bks.enable_v1")) {
                throw new IllegalStateException("BKS-V1 not enabled");
            }
        }
    }

    public BcKeyStoreSpi(int i10) {
        this.f45151c = i10;
    }

    @Override // er.a
    public void a(SecureRandom secureRandom) {
        this.f45150b = secureRandom;
    }

    public final Certificate d(DataInputStream dataInputStream) throws IOException {
        String utf = dataInputStream.readUTF();
        byte[] bArr = new byte[dataInputStream.readInt()];
        dataInputStream.readFully(bArr);
        try {
            return this.f45152d.s(utf).generateCertificate(new ByteArrayInputStream(bArr));
        } catch (NoSuchProviderException e10) {
            throw new IOException(e10.toString());
        } catch (CertificateException e11) {
            throw new IOException(e11.toString());
        }
    }

    public final Key e(DataInputStream dataInputStream) throws IOException {
        KeySpec pKCS8EncodedKeySpec;
        int i10 = dataInputStream.read();
        String utf = dataInputStream.readUTF();
        String utf2 = dataInputStream.readUTF();
        byte[] bArr = new byte[dataInputStream.readInt()];
        dataInputStream.readFully(bArr);
        if (utf.equals("PKCS#8") || utf.equals("PKCS8")) {
            pKCS8EncodedKeySpec = new PKCS8EncodedKeySpec(bArr);
        } else {
            if (!utf.equals("X.509") && !utf.equals("X509")) {
                if (utf.equals("RAW")) {
                    return new SecretKeySpec(bArr, utf2);
                }
                throw new IOException("Key format " + utf + " not recognised!");
            }
            pKCS8EncodedKeySpec = new X509EncodedKeySpec(bArr);
        }
        try {
            if (i10 == 0) {
                return BouncyCastleProvider.o(u.z(bArr));
            }
            if (i10 == 1) {
                return BouncyCastleProvider.p(c1.A(bArr));
            }
            if (i10 == 2) {
                return this.f45152d.u(utf2).generateSecret(pKCS8EncodedKeySpec);
            }
            throw new IOException("Key type " + i10 + " not recognised!");
        } catch (Exception e10) {
            throw new IOException("Exception creating key: " + e10.toString());
        }
    }

    @Override // java.security.KeyStoreSpi
    public Enumeration engineAliases() {
        return this.f45149a.keys();
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineContainsAlias(String str) {
        return this.f45149a.get(str) != null;
    }

    @Override // java.security.KeyStoreSpi
    public void engineDeleteEntry(String str) throws KeyStoreException {
        if (this.f45149a.get(str) == null) {
            return;
        }
        this.f45149a.remove(str);
    }

    @Override // java.security.KeyStoreSpi
    public Certificate engineGetCertificate(String str) {
        c cVar = (c) this.f45149a.get(str);
        if (cVar == null) {
            return null;
        }
        if (cVar.f() == 1) {
            return (Certificate) cVar.d();
        }
        Certificate[] certificateArrB = cVar.b();
        if (certificateArrB != null) {
            return certificateArrB[0];
        }
        return null;
    }

    @Override // java.security.KeyStoreSpi
    public String engineGetCertificateAlias(Certificate certificate) {
        Enumeration enumerationElements = this.f45149a.elements();
        while (enumerationElements.hasMoreElements()) {
            c cVar = (c) enumerationElements.nextElement();
            if (!(cVar.d() instanceof Certificate)) {
                Certificate[] certificateArrB = cVar.b();
                if (certificateArrB != null && certificateArrB[0].equals(certificate)) {
                    return cVar.a();
                }
            } else if (((Certificate) cVar.d()).equals(certificate)) {
                return cVar.a();
            }
        }
        return null;
    }

    @Override // java.security.KeyStoreSpi
    public Certificate[] engineGetCertificateChain(String str) {
        c cVar = (c) this.f45149a.get(str);
        if (cVar != null) {
            return cVar.b();
        }
        return null;
    }

    @Override // java.security.KeyStoreSpi
    public Date engineGetCreationDate(String str) {
        c cVar = (c) this.f45149a.get(str);
        if (cVar != null) {
            return cVar.c();
        }
        return null;
    }

    @Override // java.security.KeyStoreSpi
    public Key engineGetKey(String str, char[] cArr) throws NoSuchAlgorithmException, UnrecoverableKeyException {
        c cVar = (c) this.f45149a.get(str);
        if (cVar == null || cVar.f() == 1) {
            return null;
        }
        return (Key) cVar.e(cArr);
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineIsCertificateEntry(String str) {
        c cVar = (c) this.f45149a.get(str);
        return cVar != null && cVar.f() == 1;
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineIsKeyEntry(String str) {
        c cVar = (c) this.f45149a.get(str);
        return (cVar == null || cVar.f() == 1) ? false : true;
    }

    @Override // java.security.KeyStoreSpi
    public void engineLoad(InputStream inputStream, char[] cArr) throws IOException {
        this.f45149a.clear();
        if (inputStream == null) {
            return;
        }
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        int i10 = dataInputStream.readInt();
        if (i10 != 2 && i10 != 0 && i10 != 1) {
            throw new IOException("Wrong version of key store.");
        }
        int i11 = dataInputStream.readInt();
        if (i11 <= 0) {
            throw new IOException("Invalid salt detected");
        }
        byte[] bArr = new byte[i11];
        dataInputStream.readFully(bArr);
        int i12 = dataInputStream.readInt();
        k kVar = new k(new c0());
        if (cArr == null || cArr.length == 0) {
            h(dataInputStream);
            dataInputStream.readFully(new byte[kVar.d()]);
            return;
        }
        byte[] bArrA = org.bouncycastle.crypto.c0.a(cArr);
        h0 h0Var = new h0(new c0());
        h0Var.j(bArrA, bArr, i12);
        org.bouncycastle.crypto.k kVarD = h0Var.d(i10 != 2 ? kVar.d() : kVar.d() * 8);
        org.bouncycastle.util.a.d0(bArrA, (byte) 0);
        kVar.a(kVarD);
        h(new gp.e(dataInputStream, kVar));
        byte[] bArr2 = new byte[kVar.d()];
        kVar.c(bArr2, 0);
        byte[] bArr3 = new byte[kVar.d()];
        dataInputStream.readFully(bArr3);
        if (org.bouncycastle.util.a.I(bArr2, bArr3)) {
            return;
        }
        this.f45149a.clear();
        throw new IOException("KeyStore integrity check failed.");
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetCertificateEntry(String str, Certificate certificate) throws KeyStoreException {
        c cVar = (c) this.f45149a.get(str);
        if (cVar == null || cVar.f() == 1) {
            this.f45149a.put(str, new c(str, certificate));
            return;
        }
        throw new KeyStoreException("key store already has a key entry with alias " + str);
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetKeyEntry(String str, Key key, char[] cArr, Certificate[] certificateArr) throws KeyStoreException {
        if (key instanceof PrivateKey) {
            if (certificateArr == null) {
                throw new KeyStoreException("no certificate chain for private key");
            }
            if (key.getEncoded() == null) {
                this.f45149a.put(str, new c(str, new Date(), 2, key, certificateArr));
                return;
            }
        }
        try {
            this.f45149a.put(str, new c(str, key, cArr, certificateArr));
        } catch (Exception e10) {
            throw new BCKeyStoreException(e10.toString(), e10);
        }
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetKeyEntry(String str, byte[] bArr, Certificate[] certificateArr) throws KeyStoreException {
        this.f45149a.put(str, new c(str, bArr, certificateArr));
    }

    @Override // java.security.KeyStoreSpi
    public int engineSize() {
        return this.f45149a.size();
    }

    @Override // java.security.KeyStoreSpi
    public void engineStore(OutputStream outputStream, char[] cArr) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        byte[] bArr = new byte[20];
        int iNextInt = (this.f45150b.nextInt() & 1023) + 1024;
        this.f45150b.nextBytes(bArr);
        dataOutputStream.writeInt(this.f45151c);
        dataOutputStream.writeInt(20);
        dataOutputStream.write(bArr);
        dataOutputStream.writeInt(iNextInt);
        k kVar = new k(new c0());
        f fVar = new f(kVar);
        h0 h0Var = new h0(new c0());
        byte[] bArrA = org.bouncycastle.crypto.c0.a(cArr);
        h0Var.j(bArrA, bArr, iNextInt);
        kVar.a(h0Var.d(this.f45151c < 2 ? kVar.d() : kVar.d() * 8));
        for (int i10 = 0; i10 != bArrA.length; i10++) {
            bArrA[i10] = 0;
        }
        j(new e(dataOutputStream, fVar));
        byte[] bArr2 = new byte[kVar.d()];
        kVar.c(bArr2, 0);
        dataOutputStream.write(bArr2);
        dataOutputStream.close();
    }

    public final void f(Certificate certificate, DataOutputStream dataOutputStream) throws IOException {
        try {
            byte[] encoded = certificate.getEncoded();
            dataOutputStream.writeUTF(certificate.getType());
            dataOutputStream.writeInt(encoded.length);
            dataOutputStream.write(encoded);
        } catch (CertificateEncodingException e10) {
            throw new IOException(e10.toString());
        }
    }

    public final void g(Key key, DataOutputStream dataOutputStream) throws IOException {
        byte[] encoded = key.getEncoded();
        if (encoded == null) {
            throw new IOException("unable to store encoding of protected key");
        }
        dataOutputStream.write(key instanceof PrivateKey ? 0 : key instanceof PublicKey ? 1 : 2);
        dataOutputStream.writeUTF(key.getFormat());
        dataOutputStream.writeUTF(key.getAlgorithm());
        dataOutputStream.writeInt(encoded.length);
        dataOutputStream.write(encoded);
    }

    public void h(InputStream inputStream) throws IOException {
        Hashtable hashtable;
        c cVar;
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        for (int i10 = dataInputStream.read(); i10 > 0; i10 = dataInputStream.read()) {
            String utf = dataInputStream.readUTF();
            Date date = new Date(dataInputStream.readLong());
            int i11 = dataInputStream.readInt();
            Certificate[] certificateArr = null;
            if (i11 != 0) {
                certificateArr = new Certificate[i11];
                for (int i12 = 0; i12 != i11; i12++) {
                    certificateArr[i12] = d(dataInputStream);
                }
            }
            Certificate[] certificateArr2 = certificateArr;
            if (i10 == 1) {
                Certificate certificateD = d(dataInputStream);
                hashtable = this.f45149a;
                cVar = new c(utf, date, 1, certificateD);
            } else if (i10 == 2) {
                Key keyE = e(dataInputStream);
                hashtable = this.f45149a;
                cVar = new c(utf, date, 2, keyE, certificateArr2);
            } else {
                if (i10 != 3 && i10 != 4) {
                    throw new IOException("Unknown object type in store.");
                }
                byte[] bArr = new byte[dataInputStream.readInt()];
                dataInputStream.readFully(bArr);
                this.f45149a.put(utf, new c(utf, date, i10, bArr, certificateArr2));
            }
            hashtable.put(utf, cVar);
        }
    }

    public Cipher i(String str, int i10, char[] cArr, byte[] bArr, int i11) throws IOException {
        try {
            PBEKeySpec pBEKeySpec = new PBEKeySpec(cArr);
            SecretKeyFactory secretKeyFactoryU = this.f45152d.u(str);
            PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(bArr, i11);
            Cipher cipherI = this.f45152d.i(str);
            cipherI.init(i10, secretKeyFactoryU.generateSecret(pBEKeySpec), pBEParameterSpec);
            return cipherI;
        } catch (Exception e10) {
            throw new IOException("Error initialising store of key store: " + e10);
        }
    }

    public void j(OutputStream outputStream) throws IOException {
        Enumeration enumerationElements = this.f45149a.elements();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        while (true) {
            if (!enumerationElements.hasMoreElements()) {
                dataOutputStream.write(0);
                return;
            }
            c cVar = (c) enumerationElements.nextElement();
            dataOutputStream.write(cVar.f());
            dataOutputStream.writeUTF(cVar.a());
            dataOutputStream.writeLong(cVar.c().getTime());
            Certificate[] certificateArrB = cVar.b();
            if (certificateArrB == null) {
                dataOutputStream.writeInt(0);
            } else {
                dataOutputStream.writeInt(certificateArrB.length);
                for (int i10 = 0; i10 != certificateArrB.length; i10++) {
                    f(certificateArrB[i10], dataOutputStream);
                }
            }
            int iF = cVar.f();
            if (iF == 1) {
                f((Certificate) cVar.d(), dataOutputStream);
            } else if (iF == 2) {
                g((Key) cVar.d(), dataOutputStream);
            } else {
                if (iF != 3 && iF != 4) {
                    throw new IOException("Unknown object type in store.");
                }
                byte[] bArr = (byte[]) cVar.d();
                dataOutputStream.writeInt(bArr.length);
                dataOutputStream.write(bArr);
            }
        }
    }
}
