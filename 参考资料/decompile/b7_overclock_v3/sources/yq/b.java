package yq;

import et.e;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.KeyStoreSpi;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;
import java.util.Objects;
import org.bouncycastle.crypto.s;
import org.bouncycastle.jcajce.util.d;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes7.dex */
public class b extends KeyStoreSpi {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f57478c = "BC JKS store is read-only and only supports certificate entries";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Hashtable<String, a> f57479a = new Hashtable<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f57480b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Date f57481a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Certificate f57482b;

        public a(Date date, Certificate certificate) {
            this.f57481a = date;
            this.f57482b = certificate;
        }
    }

    /* JADX INFO: renamed from: yq.b$b, reason: collision with other inner class name */
    public static final class C0676b extends ByteArrayInputStream {
        public C0676b(byte[] bArr, int i10, int i11) {
            super(bArr, i10, i11);
        }

        public void a() {
            org.bouncycastle.util.a.d0(((ByteArrayInputStream) this).buf, (byte) 0);
        }
    }

    public b(d dVar) {
        this.f57480b = dVar;
    }

    public final void a(s sVar, char[] cArr) throws IOException {
        for (int i10 = 0; i10 < cArr.length; i10++) {
            sVar.update((byte) (cArr[i10] >> '\b'));
            sVar.update((byte) cArr[i10]);
        }
        sVar.update(Strings.i("Mighty Aphrodite"), 0, 16);
    }

    public final CertificateFactory b(String str) throws CertificateException {
        d dVar = this.f57480b;
        if (dVar == null) {
            return CertificateFactory.getInstance(str);
        }
        try {
            return dVar.s(str);
        } catch (NoSuchProviderException e10) {
            throw new CertificateException(e10.toString());
        }
    }

    public final C0676b c(InputStream inputStream, char[] cArr) throws IOException {
        s sVarA = br.d.a(e.f27137f);
        byte[] bArrE = kt.c.e(inputStream);
        if (cArr == null) {
            return new C0676b(bArrE, 0, bArrE.length - sVarA.h());
        }
        a(sVarA, cArr);
        sVarA.update(bArrE, 0, bArrE.length - sVarA.h());
        int iH = sVarA.h();
        byte[] bArr = new byte[iH];
        sVarA.c(bArr, 0);
        byte[] bArr2 = new byte[iH];
        System.arraycopy(bArrE, bArrE.length - iH, bArr2, 0, iH);
        if (org.bouncycastle.util.a.I(bArr, bArr2)) {
            return new C0676b(bArrE, 0, bArrE.length - iH);
        }
        org.bouncycastle.util.a.d0(bArrE, (byte) 0);
        throw new IOException("password incorrect or store tampered with");
    }

    @Override // java.security.KeyStoreSpi
    public Enumeration<String> engineAliases() {
        Enumeration<String> enumerationKeys;
        synchronized (this.f57479a) {
            enumerationKeys = this.f57479a.keys();
        }
        return enumerationKeys;
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineContainsAlias(String str) {
        boolean zContainsKey;
        Objects.requireNonNull(str, "alias value is null");
        synchronized (this.f57479a) {
            zContainsKey = this.f57479a.containsKey(str);
        }
        return zContainsKey;
    }

    @Override // java.security.KeyStoreSpi
    public void engineDeleteEntry(String str) throws KeyStoreException {
        throw new KeyStoreException(f57478c);
    }

    @Override // java.security.KeyStoreSpi
    public Certificate engineGetCertificate(String str) {
        synchronized (this.f57479a) {
            a aVar = this.f57479a.get(str);
            if (aVar == null) {
                return null;
            }
            return aVar.f57482b;
        }
    }

    @Override // java.security.KeyStoreSpi
    public String engineGetCertificateAlias(Certificate certificate) {
        synchronized (this.f57479a) {
            for (Map.Entry<String, a> entry : this.f57479a.entrySet()) {
                if (entry.getValue().f57482b.equals(certificate)) {
                    return entry.getKey();
                }
            }
            return null;
        }
    }

    @Override // java.security.KeyStoreSpi
    public Certificate[] engineGetCertificateChain(String str) {
        return null;
    }

    @Override // java.security.KeyStoreSpi
    public Date engineGetCreationDate(String str) {
        synchronized (this.f57479a) {
            a aVar = this.f57479a.get(str);
            if (aVar == null) {
                return null;
            }
            return aVar.f57481a;
        }
    }

    @Override // java.security.KeyStoreSpi
    public Key engineGetKey(String str, char[] cArr) throws NoSuchAlgorithmException, UnrecoverableKeyException {
        return null;
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineIsCertificateEntry(String str) {
        boolean zContainsKey;
        synchronized (this.f57479a) {
            zContainsKey = this.f57479a.containsKey(str);
        }
        return zContainsKey;
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineIsKeyEntry(String str) {
        return false;
    }

    @Override // java.security.KeyStoreSpi
    public void engineLoad(InputStream inputStream, char[] cArr) throws NoSuchAlgorithmException, IOException, CertificateException {
        Hashtable hashtable;
        if (inputStream == null) {
            return;
        }
        C0676b c0676bC = c(inputStream, cArr);
        synchronized (this.f57479a) {
            try {
                DataInputStream dataInputStream = new DataInputStream(c0676bC);
                int i10 = dataInputStream.readInt();
                int i11 = dataInputStream.readInt();
                if (i10 == -17957139) {
                    CertificateFactory certificateFactoryB = null;
                    int i12 = 2;
                    if (i11 == 1) {
                        hashtable = null;
                        certificateFactoryB = b("X.509");
                    } else {
                        if (i11 != 2) {
                            throw new IllegalStateException("unable to discern store version");
                        }
                        hashtable = new Hashtable();
                    }
                    int i13 = dataInputStream.readInt();
                    int i14 = 0;
                    while (i14 < i13) {
                        int i15 = dataInputStream.readInt();
                        if (i15 == 1) {
                            throw new IOException(f57478c);
                        }
                        if (i15 != i12) {
                            throw new IllegalStateException("unable to discern entry type");
                        }
                        String utf = dataInputStream.readUTF();
                        Date date = new Date(dataInputStream.readLong());
                        if (i11 == i12) {
                            String utf2 = dataInputStream.readUTF();
                            if (hashtable.containsKey(utf2)) {
                                certificateFactoryB = (CertificateFactory) hashtable.get(utf2);
                            } else {
                                CertificateFactory certificateFactoryB2 = b(utf2);
                                hashtable.put(utf2, certificateFactoryB2);
                                certificateFactoryB = certificateFactoryB2;
                            }
                        }
                        int i16 = dataInputStream.readInt();
                        byte[] bArr = new byte[i16];
                        dataInputStream.readFully(bArr);
                        C0676b c0676b = new C0676b(bArr, 0, i16);
                        try {
                            Certificate certificateGenerateCertificate = certificateFactoryB.generateCertificate(c0676b);
                            if (c0676b.available() != 0) {
                                throw new IOException("password incorrect or store tampered with");
                            }
                            c0676b.a();
                            this.f57479a.put(utf, new a(date, certificateGenerateCertificate));
                            i14++;
                            i12 = 2;
                        } catch (Throwable th2) {
                            c0676b.a();
                            throw th2;
                        }
                    }
                }
                if (c0676bC.available() != 0) {
                    throw new IOException("password incorrect or store tampered with");
                }
            } finally {
                c0676bC.a();
            }
        }
    }

    @Override // java.security.KeyStoreSpi
    public void engineLoad(KeyStore.LoadStoreParameter loadStoreParameter) throws NoSuchAlgorithmException, IOException, CertificateException {
        if (loadStoreParameter == null) {
            engineLoad(null, null);
        } else {
            if (loadStoreParameter instanceof jq.b) {
                engineLoad(((jq.b) loadStoreParameter).a(), c.a(loadStoreParameter));
                return;
            }
            throw new IllegalArgumentException("no support for 'param' of type " + loadStoreParameter.getClass().getName());
        }
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineProbe(InputStream inputStream) throws IOException {
        DataInputStream dataInputStream = inputStream instanceof DataInputStream ? (DataInputStream) inputStream : new DataInputStream(inputStream);
        int i10 = dataInputStream.readInt();
        int i11 = dataInputStream.readInt();
        return i10 == -17957139 && (i11 == 1 || i11 == 2);
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetCertificateEntry(String str, Certificate certificate) throws KeyStoreException {
        throw new KeyStoreException(f57478c);
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetKeyEntry(String str, Key key, char[] cArr, Certificate[] certificateArr) throws KeyStoreException {
        throw new KeyStoreException(f57478c);
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetKeyEntry(String str, byte[] bArr, Certificate[] certificateArr) throws KeyStoreException {
        throw new KeyStoreException(f57478c);
    }

    @Override // java.security.KeyStoreSpi
    public int engineSize() {
        return this.f57479a.size();
    }

    @Override // java.security.KeyStoreSpi
    public void engineStore(OutputStream outputStream, char[] cArr) throws NoSuchAlgorithmException, IOException, CertificateException {
        throw new IOException(f57478c);
    }
}
