package org.bouncycastle.x509;

import gm.f0;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.security.PublicKey;
import java.security.cert.CertPath;
import java.security.cert.CertPathValidatorException;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.PKIXParameters;
import java.security.cert.PolicyNode;
import java.security.cert.TrustAnchor;
import java.security.cert.X509CRL;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.Vector;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.jce.provider.AnnotatedException;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.provider.PKIXNameConstraintValidatorException;
import zn.b0;
import zn.c0;
import zn.e0;
import zn.m0;

/* JADX INFO: loaded from: classes6.dex */
public class i extends c {
    public static final String B = zn.y.f59065k0.L();
    public static final String C = zn.y.f59074s.L();
    public static final String D = zn.y.A.L();
    public static final String E = "org.bouncycastle.x509.CertPathReviewerMessages";
    public boolean A;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public CertPath f46109p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public PKIXParameters f46110q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Date f46111r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Date f46112s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public List f46113t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f46114u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public List[] f46115v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public List[] f46116w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public TrustAnchor f46117x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public PublicKey f46118y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public PolicyNode f46119z;

    public i() {
    }

    public i(CertPath certPath, PKIXParameters pKIXParameters) throws CertPathReviewerException {
        Y(certPath, pKIXParameters);
    }

    public void A(yp.a aVar, int i10) {
        if (i10 < -1 || i10 >= this.f46114u) {
            throw new IndexOutOfBoundsException();
        }
        this.f46116w[i10 + 1].add(aVar);
    }

    public void B(yp.a aVar) {
        this.f46115v[0].add(aVar);
    }

    public void C(yp.a aVar, int i10) {
        if (i10 < -1 || i10 >= this.f46114u) {
            throw new IndexOutOfBoundsException();
        }
        this.f46115v[i10 + 1].add(aVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:85:0x0243  */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void D(java.security.cert.PKIXParameters r21, java.security.cert.X509Certificate r22, java.util.Date r23, java.security.cert.X509Certificate r24, java.security.PublicKey r25, java.util.Vector r26, int r27) throws org.bouncycastle.x509.CertPathReviewerException {
        /*
            Method dump skipped, instruction units count: 1063
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.x509.i.D(java.security.cert.PKIXParameters, java.security.cert.X509Certificate, java.util.Date, java.security.cert.X509Certificate, java.security.PublicKey, java.util.Vector, int):void");
    }

    public final void E() {
        List<PKIXCertPathChecker> certPathCheckers = this.f46110q.getCertPathCheckers();
        Iterator<PKIXCertPathChecker> it2 = certPathCheckers.iterator();
        while (it2.hasNext()) {
            try {
                try {
                    it2.next().init(false);
                } catch (CertPathValidatorException e10) {
                    throw new CertPathReviewerException(new yp.a(E, "CertPathReviewer.certPathCheckerError", new Object[]{e10.getMessage(), e10, e10.getClass().getName()}), e10);
                }
            } catch (CertPathReviewerException e11) {
                A(e11.a(), e11.c());
                return;
            }
        }
        for (int size = this.f46113t.size() - 1; size >= 0; size--) {
            X509Certificate x509Certificate = (X509Certificate) this.f46113t.get(size);
            Set<String> criticalExtensionOIDs = x509Certificate.getCriticalExtensionOIDs();
            if (criticalExtensionOIDs != null && !criticalExtensionOIDs.isEmpty()) {
                criticalExtensionOIDs.remove(c.f46081f);
                criticalExtensionOIDs.remove(c.f46076a);
                criticalExtensionOIDs.remove(c.f46078c);
                criticalExtensionOIDs.remove(c.f46082g);
                criticalExtensionOIDs.remove(c.f46083h);
                criticalExtensionOIDs.remove(c.f46084i);
                criticalExtensionOIDs.remove(c.f46085j);
                criticalExtensionOIDs.remove(c.f46077b);
                criticalExtensionOIDs.remove(c.f46079d);
                criticalExtensionOIDs.remove(c.f46080e);
                if (size == 0) {
                    criticalExtensionOIDs.remove(zn.y.f59080x.L());
                }
                String str = B;
                if (criticalExtensionOIDs.contains(str) && a0(x509Certificate, size)) {
                    criticalExtensionOIDs.remove(str);
                }
                Iterator<PKIXCertPathChecker> it3 = certPathCheckers.iterator();
                while (it3.hasNext()) {
                    try {
                        it3.next().check(x509Certificate, criticalExtensionOIDs);
                    } catch (CertPathValidatorException e12) {
                        throw new CertPathReviewerException(new yp.a(E, "CertPathReviewer.criticalExtensionError", new Object[]{e12.getMessage(), e12, e12.getClass().getName()}), e12.getCause(), this.f46109p, size);
                    }
                }
                if (!criticalExtensionOIDs.isEmpty()) {
                    Iterator<String> it4 = criticalExtensionOIDs.iterator();
                    while (it4.hasNext()) {
                        A(new yp.a(E, "CertPathReviewer.unknownCriticalExt", new Object[]{new gm.y(it4.next())}), size);
                    }
                }
            }
        }
    }

    public final void F() {
        org.bouncycastle.jce.provider.v vVar = new org.bouncycastle.jce.provider.v();
        try {
            for (int size = this.f46113t.size() - 1; size > 0; size--) {
                X509Certificate x509Certificate = (X509Certificate) this.f46113t.get(size);
                if (!c.q(x509Certificate)) {
                    X500Principal x500PrincipalM = c.m(x509Certificate);
                    try {
                        f0 f0Var = (f0) new gm.s(new ByteArrayInputStream(x500PrincipalM.getEncoded())).n();
                        try {
                            vVar.e(f0Var);
                            try {
                                vVar.c(f0Var);
                                try {
                                    f0 f0Var2 = (f0) c.g(x509Certificate, c.f46079d);
                                    if (f0Var2 != null) {
                                        for (int i10 = 0; i10 < f0Var2.size(); i10++) {
                                            b0 b0VarZ = b0.z(f0Var2.K(i10));
                                            try {
                                                vVar.d(b0VarZ);
                                                vVar.b(b0VarZ);
                                            } catch (PKIXNameConstraintValidatorException e10) {
                                                throw new CertPathReviewerException(new yp.a(E, "CertPathReviewer.notPermittedEmail", new Object[]{new zp.e(b0VarZ)}), e10, this.f46109p, size);
                                            }
                                        }
                                    }
                                } catch (AnnotatedException e11) {
                                    throw new CertPathReviewerException(new yp.a(E, "CertPathReviewer.subjAltNameExtError"), e11, this.f46109p, size);
                                }
                            } catch (PKIXNameConstraintValidatorException e12) {
                                throw new CertPathReviewerException(new yp.a(E, "CertPathReviewer.excludedDN", new Object[]{new zp.e(x500PrincipalM.getName())}), e12, this.f46109p, size);
                            }
                        } catch (PKIXNameConstraintValidatorException e13) {
                            throw new CertPathReviewerException(new yp.a(E, "CertPathReviewer.notPermittedDN", new Object[]{new zp.e(x500PrincipalM.getName())}), e13, this.f46109p, size);
                        }
                    } catch (IOException e14) {
                        throw new CertPathReviewerException(new yp.a(E, "CertPathReviewer.ncSubjectNameError", new Object[]{new zp.e(x500PrincipalM)}), e14, this.f46109p, size);
                    }
                }
                try {
                    f0 f0Var3 = (f0) c.g(x509Certificate, c.f46080e);
                    if (f0Var3 != null) {
                        m0 m0VarA = m0.A(f0Var3);
                        e0[] e0VarArrB = m0VarA.B();
                        if (e0VarArrB != null) {
                            vVar.h(e0VarArrB);
                        }
                        e0[] e0VarArrZ = m0VarA.z();
                        if (e0VarArrZ != null) {
                            for (int i11 = 0; i11 != e0VarArrZ.length; i11++) {
                                vVar.a(e0VarArrZ[i11]);
                            }
                        }
                    }
                } catch (AnnotatedException e15) {
                    throw new CertPathReviewerException(new yp.a(E, "CertPathReviewer.ncExtError"), e15, this.f46109p, size);
                }
            }
        } catch (CertPathReviewerException e16) {
            A(e16.a(), e16.c());
        }
    }

    public final void G() {
        zn.j jVarZ;
        BigInteger bigIntegerA;
        int iIntValue;
        int i10 = this.f46114u;
        int i11 = 0;
        for (int size = this.f46113t.size() - 1; size > 0; size--) {
            X509Certificate x509Certificate = (X509Certificate) this.f46113t.get(size);
            if (!c.q(x509Certificate)) {
                if (i10 <= 0) {
                    z(new yp.a(E, "CertPathReviewer.pathLengthExtended"));
                }
                i10--;
                i11++;
            }
            try {
                jVarZ = zn.j.z(c.g(x509Certificate, c.f46077b));
            } catch (AnnotatedException unused) {
                A(new yp.a(E, "CertPathReviewer.processLengthConstError"), size);
                jVarZ = null;
            }
            if (jVarZ != null && (bigIntegerA = jVarZ.A()) != null && (iIntValue = bigIntegerA.intValue()) < i10) {
                i10 = iIntValue;
            }
        }
        B(new yp.a(E, "CertPathReviewer.totalPathLength", new Object[]{org.bouncycastle.util.j.g(i11)}));
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x023f A[Catch: CertPathReviewerException -> 0x05f7, TryCatch #7 {CertPathReviewerException -> 0x05f7, blocks: (B:17:0x006f, B:21:0x007f, B:23:0x008c, B:27:0x009c, B:28:0x00a7, B:30:0x00ad, B:32:0x00ce, B:33:0x00d6, B:35:0x00dc, B:37:0x00e1, B:38:0x00ed, B:42:0x00f9, B:45:0x0100, B:46:0x0109, B:48:0x010f, B:50:0x0119, B:53:0x0120, B:55:0x0124, B:95:0x0210, B:97:0x0216, B:98:0x0219, B:100:0x021f, B:102:0x022b, B:105:0x0233, B:106:0x0236, B:107:0x0239, B:109:0x023f, B:110:0x0248, B:112:0x024e, B:120:0x0271, B:121:0x027d, B:122:0x027e, B:124:0x0282, B:126:0x028a, B:127:0x028e, B:129:0x0294, B:132:0x02b6, B:134:0x02c0, B:135:0x02c5, B:136:0x02d1, B:137:0x02d2, B:138:0x02de, B:140:0x02e1, B:141:0x02ee, B:143:0x02f4, B:145:0x031a, B:147:0x0332, B:146:0x0329, B:148:0x0339, B:149:0x033f, B:151:0x0345, B:153:0x034d, B:164:0x0377, B:157:0x0355, B:158:0x0361, B:160:0x0363, B:161:0x0372, B:167:0x0380, B:178:0x039f, B:180:0x03a9, B:181:0x03ad, B:183:0x03b3, B:188:0x03c3, B:191:0x03d0, B:194:0x03dd, B:196:0x03e7, B:207:0x0425, B:199:0x03ef, B:200:0x03fd, B:201:0x03fe, B:202:0x040c, B:204:0x040e, B:205:0x041c, B:59:0x0133, B:60:0x0137, B:62:0x013d, B:64:0x0153, B:66:0x015d, B:67:0x0162, B:69:0x0168, B:70:0x0176, B:72:0x017c, B:74:0x0188, B:78:0x0195, B:79:0x019b, B:81:0x01a1, B:86:0x01ba, B:75:0x018b, B:77:0x018f, B:90:0x01f3, B:93:0x0203, B:94:0x020f, B:209:0x0434, B:210:0x0441, B:211:0x0442, B:215:0x0453, B:217:0x045d, B:218:0x0462, B:220:0x0468, B:223:0x0476, B:230:0x048b, B:308:0x05dd, B:309:0x05e9, B:233:0x0496, B:234:0x04a2, B:235:0x04a3, B:237:0x04a9, B:239:0x04b1, B:241:0x04b7, B:244:0x04c1, B:245:0x04c4, B:247:0x04ca, B:249:0x04da, B:250:0x04de, B:252:0x04e4, B:253:0x04ec, B:254:0x04ef, B:255:0x04f4, B:256:0x04f8, B:258:0x04fe, B:259:0x050c, B:261:0x0514, B:262:0x0517, B:264:0x051d, B:266:0x0529, B:267:0x052d, B:268:0x0530, B:269:0x0533, B:270:0x053f, B:272:0x0544, B:274:0x054e, B:275:0x0551, B:277:0x0557, B:279:0x0567, B:280:0x056b, B:282:0x0571, B:284:0x0581, B:285:0x0585, B:286:0x0588, B:287:0x058b, B:288:0x0591, B:290:0x0597, B:292:0x05a9, B:295:0x05b3, B:297:0x05b9, B:298:0x05bc, B:300:0x05c2, B:302:0x05ce, B:303:0x05d2, B:304:0x05d5, B:310:0x05ea, B:311:0x05f6), top: B:327:0x006f, inners: #0, #1, #2, #3, #5, #6, #8, #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0216 A[Catch: CertPathReviewerException -> 0x05f7, TryCatch #7 {CertPathReviewerException -> 0x05f7, blocks: (B:17:0x006f, B:21:0x007f, B:23:0x008c, B:27:0x009c, B:28:0x00a7, B:30:0x00ad, B:32:0x00ce, B:33:0x00d6, B:35:0x00dc, B:37:0x00e1, B:38:0x00ed, B:42:0x00f9, B:45:0x0100, B:46:0x0109, B:48:0x010f, B:50:0x0119, B:53:0x0120, B:55:0x0124, B:95:0x0210, B:97:0x0216, B:98:0x0219, B:100:0x021f, B:102:0x022b, B:105:0x0233, B:106:0x0236, B:107:0x0239, B:109:0x023f, B:110:0x0248, B:112:0x024e, B:120:0x0271, B:121:0x027d, B:122:0x027e, B:124:0x0282, B:126:0x028a, B:127:0x028e, B:129:0x0294, B:132:0x02b6, B:134:0x02c0, B:135:0x02c5, B:136:0x02d1, B:137:0x02d2, B:138:0x02de, B:140:0x02e1, B:141:0x02ee, B:143:0x02f4, B:145:0x031a, B:147:0x0332, B:146:0x0329, B:148:0x0339, B:149:0x033f, B:151:0x0345, B:153:0x034d, B:164:0x0377, B:157:0x0355, B:158:0x0361, B:160:0x0363, B:161:0x0372, B:167:0x0380, B:178:0x039f, B:180:0x03a9, B:181:0x03ad, B:183:0x03b3, B:188:0x03c3, B:191:0x03d0, B:194:0x03dd, B:196:0x03e7, B:207:0x0425, B:199:0x03ef, B:200:0x03fd, B:201:0x03fe, B:202:0x040c, B:204:0x040e, B:205:0x041c, B:59:0x0133, B:60:0x0137, B:62:0x013d, B:64:0x0153, B:66:0x015d, B:67:0x0162, B:69:0x0168, B:70:0x0176, B:72:0x017c, B:74:0x0188, B:78:0x0195, B:79:0x019b, B:81:0x01a1, B:86:0x01ba, B:75:0x018b, B:77:0x018f, B:90:0x01f3, B:93:0x0203, B:94:0x020f, B:209:0x0434, B:210:0x0441, B:211:0x0442, B:215:0x0453, B:217:0x045d, B:218:0x0462, B:220:0x0468, B:223:0x0476, B:230:0x048b, B:308:0x05dd, B:309:0x05e9, B:233:0x0496, B:234:0x04a2, B:235:0x04a3, B:237:0x04a9, B:239:0x04b1, B:241:0x04b7, B:244:0x04c1, B:245:0x04c4, B:247:0x04ca, B:249:0x04da, B:250:0x04de, B:252:0x04e4, B:253:0x04ec, B:254:0x04ef, B:255:0x04f4, B:256:0x04f8, B:258:0x04fe, B:259:0x050c, B:261:0x0514, B:262:0x0517, B:264:0x051d, B:266:0x0529, B:267:0x052d, B:268:0x0530, B:269:0x0533, B:270:0x053f, B:272:0x0544, B:274:0x054e, B:275:0x0551, B:277:0x0557, B:279:0x0567, B:280:0x056b, B:282:0x0571, B:284:0x0581, B:285:0x0585, B:286:0x0588, B:287:0x058b, B:288:0x0591, B:290:0x0597, B:292:0x05a9, B:295:0x05b3, B:297:0x05b9, B:298:0x05bc, B:300:0x05c2, B:302:0x05ce, B:303:0x05d2, B:304:0x05d5, B:310:0x05ea, B:311:0x05f6), top: B:327:0x006f, inners: #0, #1, #2, #3, #5, #6, #8, #10 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void H() {
        /*
            Method dump skipped, instruction units count: 1540
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.x509.i.H():void");
    }

    public void I(PKIXParameters pKIXParameters, X509Certificate x509Certificate, Date date, X509Certificate x509Certificate2, PublicKey publicKey, Vector vector, Vector vector2, int i10) throws CertPathReviewerException {
        D(pKIXParameters, x509Certificate, date, x509Certificate2, publicKey, vector, i10);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:57|(3:172|59|64)(2:65|(3:174|67|64)(2:71|(2:78|79)(3:75|(1:77)(0)|79)))|(2:185|80)|85|(16:179|87|(1:89)(1:91)|160|93|(1:95)(1:98)|99|(2:102|100)|191|103|(2:106|104)|168|107|108|170|109)(1:116)|(1:121)(1:120)|122|(1:145)(14:124|(1:128)|158|130|(2:132|(1:134))(1:135)|138|(2:140|(1:144))|147|164|148|166|149|190|153)|146|147|164|148|166|149|190|153) */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x03e2, code lost:
    
        r6 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x03e4, code lost:
    
        A(new yp.a(org.bouncycastle.x509.i.E, "CertPathReviewer.pubKeyError"), r11);
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x024a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void J() {
        /*
            Method dump skipped, instruction units count: 1029
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.x509.i.J():void");
    }

    public void K() {
        if (!this.A) {
            throw new IllegalStateException("Object not initialized. Call init() first.");
        }
        if (this.f46115v != null) {
            return;
        }
        int i10 = this.f46114u;
        this.f46115v = new List[i10 + 1];
        this.f46116w = new List[i10 + 1];
        int i11 = 0;
        while (true) {
            List[] listArr = this.f46115v;
            if (i11 >= listArr.length) {
                J();
                F();
                G();
                H();
                E();
                return;
            }
            listArr[i11] = new ArrayList();
            this.f46116w[i11] = new ArrayList();
            i11++;
        }
    }

    public final X509CRL L(String str) throws CertPathReviewerException {
        try {
            URL url = new URL(str);
            if (!url.getProtocol().equals("http") && !url.getProtocol().equals("https")) {
                return null;
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == 200) {
                return (X509CRL) CertificateFactory.getInstance("X.509", BouncyCastleProvider.f45329b).generateCRL(httpURLConnection.getInputStream());
            }
            throw new Exception(httpURLConnection.getResponseMessage());
        } catch (Exception e10) {
            throw new CertPathReviewerException(new yp.a(E, "CertPathReviewer.loadCrlDistPointError", new Object[]{new zp.e(str), e10.getMessage(), e10, e10.getClass().getName()}));
        }
    }

    public Vector M(zn.k kVar) {
        Vector vector = new Vector();
        if (kVar != null) {
            for (zn.v vVar : kVar.y()) {
                zn.w wVarZ = vVar.z();
                if (wVarZ.B() == 0) {
                    b0[] b0VarArrB = c0.A(wVarZ.A()).B();
                    for (int i10 = 0; i10 < b0VarArrB.length; i10++) {
                        if (b0VarArrB[i10].q() == 6) {
                            vector.add(((gm.r) b0VarArrB[i10].A()).d());
                        }
                    }
                }
            }
        }
        return vector;
    }

    public CertPath N() {
        return this.f46109p;
    }

    public int O() {
        return this.f46114u;
    }

    public List P(int i10) {
        K();
        return this.f46116w[i10 + 1];
    }

    public List[] Q() {
        K();
        return this.f46116w;
    }

    public List R(int i10) {
        K();
        return this.f46115v[i10 + 1];
    }

    public List[] S() {
        K();
        return this.f46115v;
    }

    public Vector T(zn.h hVar) {
        Vector vector = new Vector();
        if (hVar != null) {
            zn.a[] aVarArrZ = hVar.z();
            for (int i10 = 0; i10 < aVarArrZ.length; i10++) {
                if (aVarArrZ[i10].y().C(zn.a.f58659d)) {
                    b0 b0VarX = aVarArrZ[i10].x();
                    if (b0VarX.q() == 6) {
                        vector.add(((gm.r) b0VarX.A()).d());
                    }
                }
            }
        }
        return vector;
    }

    public PolicyNode U() {
        K();
        return this.f46119z;
    }

    public PublicKey V() {
        K();
        return this.f46118y;
    }

    public TrustAnchor W() {
        K();
        return this.f46117x;
    }

    public Collection X(X509Certificate x509Certificate, Set set) throws CertPathReviewerException {
        ArrayList arrayList = new ArrayList();
        Iterator it2 = set.iterator();
        X509CertSelector x509CertSelector = new X509CertSelector();
        try {
            x509CertSelector.setSubject(c.f(x509Certificate).getEncoded());
            byte[] extensionValue = x509Certificate.getExtensionValue(zn.y.f59077v.L());
            if (extensionValue != null) {
                zn.i iVarB = zn.i.B(gm.c0.D(((gm.z) gm.c0.D(extensionValue)).J()));
                if (iVarB.z() != null) {
                    x509CertSelector.setSerialNumber(iVarB.z());
                }
            }
            while (it2.hasNext()) {
                TrustAnchor trustAnchor = (TrustAnchor) it2.next();
                if (trustAnchor.getTrustedCert() != null) {
                    if (x509CertSelector.match(trustAnchor.getTrustedCert())) {
                        arrayList.add(trustAnchor);
                    }
                } else if (trustAnchor.getCAName() != null && trustAnchor.getCAPublicKey() != null && c.f(x509Certificate).equals(new X500Principal(trustAnchor.getCAName()))) {
                    arrayList.add(trustAnchor);
                }
            }
            return arrayList;
        } catch (IOException unused) {
            throw new CertPathReviewerException(new yp.a(E, "CertPathReviewer.trustAnchorIssuerError"));
        }
    }

    public void Y(CertPath certPath, PKIXParameters pKIXParameters) throws CertPathReviewerException {
        if (this.A) {
            throw new IllegalStateException("object is already initialized!");
        }
        this.A = true;
        Objects.requireNonNull(certPath, "certPath was null");
        this.f46109p = certPath;
        List<? extends Certificate> certificates = certPath.getCertificates();
        this.f46113t = certificates;
        this.f46114u = certificates.size();
        if (this.f46113t.isEmpty()) {
            throw new CertPathReviewerException(new yp.a(E, "CertPathReviewer.emptyCertPath"));
        }
        this.f46110q = (PKIXParameters) pKIXParameters.clone();
        Date date = new Date();
        this.f46111r = date;
        this.f46112s = c.n(this.f46110q, date);
        this.f46115v = null;
        this.f46116w = null;
        this.f46117x = null;
        this.f46118y = null;
        this.f46119z = null;
    }

    public boolean Z() {
        K();
        int i10 = 0;
        while (true) {
            List[] listArr = this.f46116w;
            if (i10 >= listArr.length) {
                return true;
            }
            if (!listArr[i10].isEmpty()) {
                return false;
            }
            i10++;
        }
    }

    public final boolean a0(X509Certificate x509Certificate, int i10) {
        yp.a aVar;
        try {
            f0 f0Var = (f0) c.g(x509Certificate, B);
            boolean z10 = false;
            for (int i11 = 0; i11 < f0Var.size(); i11++) {
                ao.e eVarX = ao.e.x(f0Var.K(i11));
                if (ao.b.P.C(eVarX.y())) {
                    aVar = new yp.a(E, "CertPathReviewer.QcEuCompliance");
                } else {
                    if (!ao.f.Y.C(eVarX.y())) {
                        if (ao.b.S.C(eVarX.y())) {
                            aVar = new yp.a(E, "CertPathReviewer.QcSSCD");
                        } else if (ao.b.Q.C(eVarX.y())) {
                            ao.d dVarA = ao.d.A(eVarX.z());
                            dVarA.y();
                            double dDoubleValue = dVarA.x().doubleValue() * Math.pow(10.0d, dVarA.z().doubleValue());
                            C(dVarA.y().A() ? new yp.a(E, "CertPathReviewer.QcLimitValueAlpha", new Object[]{dVarA.y().x(), new zp.d(new Double(dDoubleValue)), dVarA}) : new yp.a(E, "CertPathReviewer.QcLimitValueNum", new Object[]{org.bouncycastle.util.j.g(dVarA.y().z()), new zp.d(new Double(dDoubleValue)), dVarA}), i10);
                        } else {
                            C(new yp.a(E, "CertPathReviewer.QcUnknownStatement", new Object[]{eVarX.y(), new zp.e(eVarX)}), i10);
                            z10 = true;
                        }
                    }
                }
                C(aVar, i10);
            }
            return true ^ z10;
        } catch (AnnotatedException unused) {
            A(new yp.a(E, "CertPathReviewer.QcStatementExtError"), i10);
            return false;
        }
    }

    public final String y(byte[] bArr) {
        try {
            return InetAddress.getByAddress(bArr).getHostAddress();
        } catch (Exception unused) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i10 = 0; i10 != bArr.length; i10++) {
                stringBuffer.append(Integer.toHexString(bArr[i10] & 255));
                stringBuffer.append(zc.f.f58383m);
            }
            return stringBuffer.toString();
        }
    }

    public void z(yp.a aVar) {
        this.f46116w[0].add(aVar);
    }
}
