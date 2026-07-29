package bs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import pn.u;

/* JADX INFO: loaded from: classes6.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f9591a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JcaX509CertificateConverter f9592b = new JcaX509CertificateConverter();

    public org.bouncycastle.pkix.jcajce.b a(File file, File file2) throws IOException, CertificateException {
        c(file);
        c(file2);
        FileInputStream fileInputStream = new FileInputStream(file);
        FileInputStream fileInputStream2 = new FileInputStream(file2);
        org.bouncycastle.pkix.jcajce.b bVarB = b(fileInputStream, fileInputStream2);
        fileInputStream.close();
        fileInputStream2.close();
        return bVarB;
    }

    public org.bouncycastle.pkix.jcajce.b b(InputStream inputStream, InputStream inputStream2) throws IOException, CertificateException {
        b bVar;
        u uVarA;
        Object object = new zr.i(new InputStreamReader(inputStream)).readObject();
        if (object instanceof zr.g) {
            bVar = this.f9591a;
            uVarA = ((zr.g) object).a();
        } else {
            if (!(object instanceof u)) {
                throw new IOException("unrecognised private key file");
            }
            bVar = this.f9591a;
            uVarA = (u) object;
        }
        PrivateKey privateKeyC = bVar.c(uVarA);
        zr.i iVar = new zr.i(new InputStreamReader(inputStream2));
        ArrayList arrayList = new ArrayList();
        while (true) {
            Object object2 = iVar.readObject();
            if (object2 == null) {
                return new org.bouncycastle.pkix.jcajce.b(privateKeyC, (X509Certificate[]) arrayList.toArray(new X509Certificate[arrayList.size()]));
            }
            arrayList.add(this.f9592b.a((X509CertificateHolder) object2));
        }
    }

    public final void c(File file) throws IOException {
        if (file.canRead()) {
            if (file.exists()) {
                throw new IOException("Unable to open file " + file.getPath() + " for reading.");
            }
            throw new FileNotFoundException("Unable to open " + file.getPath() + ": it does not exist.");
        }
    }

    public e d(String str) {
        this.f9591a = this.f9591a.e(str);
        this.f9592b = this.f9592b.b(str);
        return this;
    }

    public e e(Provider provider) {
        this.f9591a = this.f9591a.f(provider);
        this.f9592b = this.f9592b.c(provider);
        return this;
    }
}
