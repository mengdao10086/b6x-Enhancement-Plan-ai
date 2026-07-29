package org.bouncycastle.jce.provider;

import com.tencent.connect.common.Constants;
import gm.j2;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.security.cert.CertPathValidatorException;
import java.security.cert.Extension;
import java.security.cert.X509Certificate;
import java.text.ParseException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes5.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f45475a = 15000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f45476b = 32768;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Map<URI, WeakReference<Map<nn.b, nn.g>>> f45477c = Collections.synchronizedMap(new WeakHashMap());

    public static nn.g a(nn.b bVar, jq.g gVar, URI uri, X509Certificate x509Certificate, List<Extension> list, org.bouncycastle.jcajce.util.d dVar) throws CertPathValidatorException {
        nn.g gVar2;
        gm.o oVarB;
        WeakReference<Map<nn.b, nn.g>> weakReference = f45477c.get(uri);
        Map<nn.b, nn.g> map = weakReference != null ? weakReference.get() : null;
        boolean zP = false;
        if (map != null && (gVar2 = map.get(bVar)) != null) {
            gm.f0 f0VarC = nn.l.y(nn.a.z(gm.z.I(gVar2.z().z()).J()).C()).C();
            for (int i10 = 0; i10 != f0VarC.size(); i10++) {
                nn.p pVarA = nn.p.A(f0VarC.K(i10));
                if (bVar.equals(pVarA.x()) && (oVarB = pVarA.B()) != null) {
                    try {
                    } catch (ParseException unused) {
                        map.remove(bVar);
                    }
                    if (gVar.e().after(oVarB.K())) {
                        map.remove(bVar);
                        gVar2 = null;
                    }
                }
            }
            if (gVar2 != null) {
                return gVar2;
            }
        }
        try {
            URL url = uri.toURL();
            gm.i iVar = new gm.i();
            iVar.a(new nn.i(bVar, null));
            gm.i iVar2 = new gm.i();
            byte[] bArr = null;
            for (int i11 = 0; i11 != list.size(); i11++) {
                Extension extension = list.get(i11);
                byte[] value = extension.getValue();
                if (nn.e.f42258c.L().equals(extension.getId())) {
                    bArr = value;
                }
                iVar2.a(new zn.y(new gm.y(extension.getId()), extension.isCritical(), value));
            }
            try {
                byte[] encoded = new nn.f(new nn.q((zn.b0) null, new j2(iVar), zn.z.G(new j2(iVar2))), null).getEncoded();
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setConnectTimeout(15000);
                httpURLConnection.setReadTimeout(15000);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setRequestMethod(Constants.HTTP_POST);
                httpURLConnection.setRequestProperty("Content-type", "application/ocsp-request");
                httpURLConnection.setRequestProperty("Content-length", String.valueOf(encoded.length));
                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(encoded);
                outputStream.flush();
                InputStream inputStream = httpURLConnection.getInputStream();
                int contentLength = httpURLConnection.getContentLength();
                if (contentLength < 0) {
                    contentLength = 32768;
                }
                nn.g gVarY = nn.g.y(kt.c.f(inputStream, contentLength));
                try {
                    if (gVarY.A().y() != 0) {
                        throw new CertPathValidatorException("OCSP responder failed: " + gVarY.A().z(), null, gVar.a(), gVar.b());
                    }
                    nn.k kVarY = nn.k.y(gVarY.z());
                    if (kVarY.A().C(nn.e.f42257b)) {
                        zP = z.p(nn.a.z(kVarY.z().J()), gVar, bArr, x509Certificate, dVar);
                    }
                    if (!zP) {
                        throw new CertPathValidatorException("OCSP response failed to validate", null, gVar.a(), gVar.b());
                    }
                    WeakReference<Map<nn.b, nn.g>> weakReference2 = f45477c.get(uri);
                    if (weakReference2 != null) {
                        weakReference2.get().put(bVar, gVarY);
                    } else {
                        HashMap map2 = new HashMap();
                        map2.put(bVar, gVarY);
                        f45477c.put(uri, new WeakReference<>(map2));
                    }
                    return gVarY;
                } catch (IOException e10) {
                    e = e10;
                }
            } catch (IOException e11) {
                e = e11;
            }
            throw new CertPathValidatorException("configuration error: " + e.getMessage(), e, gVar.a(), gVar.b());
        } catch (MalformedURLException e12) {
            throw new CertPathValidatorException("configuration error: " + e12.getMessage(), e12, gVar.a(), gVar.b());
        }
    }
}
