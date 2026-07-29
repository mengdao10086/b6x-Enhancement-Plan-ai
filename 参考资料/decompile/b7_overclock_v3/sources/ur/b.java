package ur;

import com.google.common.net.HttpHeaders;
import hb.u;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import kotlin.text.y;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.s;
import so.b2;
import so.o0;
import sr.m;

/* JADX INFO: loaded from: classes6.dex */
public class b extends m {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Map f52405f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Map f52406g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Map f52407h;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o0 f52408b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f52409c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final OutputStream f52410d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f52411e;

    /* JADX INFO: renamed from: ur.b$b, reason: collision with other inner class name */
    public static class C0607b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final String[] f52412f = {"Content-Type"};

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final String[] f52413g = {"multipart/signed; protocol=\"application/pkcs7-signature\""};

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final String[] f52414h = {"Content-Type", HttpHeaders.CONTENT_DISPOSITION, "Content-Transfer-Encoding", "Content-Description"};

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final String[] f52415i = {"application/pkcs7-mime; name=\"smime.p7m\"; smime-type=enveloped-data", "attachment; filename=\"smime.p7m\"", "base64", "S/MIME Signed Message"};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final o0 f52416a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<String, String> f52417b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f52418c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Map f52419d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f52420e;

        public C0607b() {
            this(false);
        }

        public C0607b(boolean z10) {
            this.f52416a = new o0();
            this.f52417b = new LinkedHashMap();
            this.f52419d = b.f52407h;
            this.f52420e = "base64";
            this.f52418c = z10;
        }

        public final void b(StringBuffer stringBuffer, String str) {
            stringBuffer.append(";\r\n\tboundary=\"");
            stringBuffer.append(str);
            stringBuffer.append("\"");
        }

        public C0607b c(X509CertificateHolder x509CertificateHolder) throws CMSException {
            this.f52416a.e(x509CertificateHolder);
            return this;
        }

        public C0607b d(s sVar) throws CMSException {
            this.f52416a.f(sVar);
            return this;
        }

        public final void e(StringBuffer stringBuffer, List list) {
            Iterator it2 = list.iterator();
            TreeSet<String> treeSet = new TreeSet();
            while (it2.hasNext()) {
                String str = (String) this.f52419d.get(((zn.b) it2.next()).x());
                if (str == null) {
                    str = "unknown";
                }
                treeSet.add(str);
            }
            int i10 = 0;
            for (String str2 : treeSet) {
                if (i10 == 0) {
                    stringBuffer.append(treeSet.size() != 1 ? "; micalg=\"" : "; micalg=");
                } else {
                    stringBuffer.append(',');
                }
                stringBuffer.append(str2);
                i10++;
            }
            if (i10 == 0 || treeSet.size() == 1) {
                return;
            }
            stringBuffer.append(y.f38188b);
        }

        public C0607b f(b2 b2Var) {
            this.f52416a.i(b2Var);
            return this;
        }

        public b g(OutputStream outputStream) {
            String strH;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int i10 = 0;
            if (!this.f52418c) {
                strH = h();
                StringBuffer stringBuffer = new StringBuffer(f52413g[0]);
                e(stringBuffer, this.f52416a.o());
                b(stringBuffer, strH);
                linkedHashMap.put(f52412f[0], stringBuffer.toString());
                int i11 = 1;
                while (true) {
                    String[] strArr = f52412f;
                    if (i11 >= strArr.length) {
                        break;
                    }
                    linkedHashMap.put(strArr[i11], f52413g[i11]);
                    i11++;
                }
            } else {
                strH = null;
                while (true) {
                    String[] strArr2 = f52414h;
                    if (i10 == strArr2.length) {
                        break;
                    }
                    linkedHashMap.put(strArr2[i10], f52415i[i10]);
                    i10++;
                }
            }
            String str = strH;
            for (Map.Entry<String, String> entry : this.f52417b.entrySet()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
            return new b(this, linkedHashMap, str, g.b(outputStream));
        }

        public final String h() {
            return "==" + new BigInteger(180, new SecureRandom()).setBit(179).toString(16) + u.f30904o;
        }

        public C0607b i(String str, String str2) {
            this.f52417b.put(str, str2);
            return this;
        }
    }

    public class c extends OutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final OutputStream f52421a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final OutputStream f52422b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ByteArrayOutputStream f52423c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final OutputStream f52424d;

        public c(OutputStream outputStream, OutputStream outputStream2, ByteArrayOutputStream byteArrayOutputStream, OutputStream outputStream3) {
            this.f52421a = outputStream;
            this.f52422b = outputStream2;
            this.f52423c = byteArrayOutputStream;
            this.f52424d = outputStream3;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (b.this.f52409c != null) {
                this.f52421a.close();
                this.f52422b.write(Strings.i("\r\n--"));
                this.f52422b.write(Strings.i(b.this.f52409c));
                this.f52422b.write(Strings.i("\r\n"));
                this.f52422b.write(Strings.i("Content-Type: application/pkcs7-signature; name=\"smime.p7s\"\r\n"));
                this.f52422b.write(Strings.i("Content-Transfer-Encoding: base64\r\n"));
                this.f52422b.write(Strings.i("Content-Disposition: attachment; filename=\"smime.p7s\"\r\n"));
                this.f52422b.write(Strings.i("\r\n"));
                OutputStream outputStream = this.f52424d;
                if (outputStream != null) {
                    outputStream.close();
                }
                this.f52422b.write(this.f52423c.toByteArray());
                this.f52422b.write(Strings.i("\r\n--"));
                this.f52422b.write(Strings.i(b.this.f52409c));
                this.f52422b.write(Strings.i("--\r\n"));
            }
            OutputStream outputStream2 = this.f52422b;
            if (outputStream2 != null) {
                outputStream2.close();
            }
        }

        @Override // java.io.OutputStream
        public void write(int i10) throws IOException {
            this.f52421a.write(i10);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.f52421a.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i10, int i11) throws IOException {
            this.f52421a.write(bArr, i10, i11);
        }
    }

    static {
        HashMap map = new HashMap();
        gm.y yVar = so.c.f50092e0;
        map.put(yVar, "md5");
        gm.y yVar2 = so.c.Z;
        map.put(yVar2, "sha-1");
        gm.y yVar3 = so.c.f50084a0;
        map.put(yVar3, "sha-224");
        gm.y yVar4 = so.c.f50086b0;
        map.put(yVar4, "sha-256");
        gm.y yVar5 = so.c.f50088c0;
        map.put(yVar5, "sha-384");
        gm.y yVar6 = so.c.f50090d0;
        map.put(yVar6, "sha-512");
        gm.y yVar7 = so.c.f50094f0;
        map.put(yVar7, "gostr3411-94");
        gm.y yVar8 = so.c.f50096g0;
        map.put(yVar8, "gostr3411-2012-256");
        gm.y yVar9 = so.c.f50098h0;
        map.put(yVar9, "gostr3411-2012-512");
        Map mapUnmodifiableMap = Collections.unmodifiableMap(map);
        f52406g = mapUnmodifiableMap;
        HashMap map2 = new HashMap();
        map2.put(yVar, "md5");
        map2.put(yVar2, "sha1");
        map2.put(yVar3, "sha224");
        map2.put(yVar4, "sha256");
        map2.put(yVar5, "sha384");
        map2.put(yVar6, "sha512");
        map2.put(yVar7, "gostr3411-94");
        map2.put(yVar8, "gostr3411-2012-256");
        map2.put(yVar9, "gostr3411-2012-512");
        f52405f = Collections.unmodifiableMap(map2);
        f52407h = mapUnmodifiableMap;
    }

    public b(C0607b c0607b, Map<String, String> map, String str, OutputStream outputStream) {
        super(new sr.e(m.c(map), c0607b.f52420e));
        this.f52408b = c0607b.f52416a;
        this.f52411e = c0607b.f52420e;
        this.f52409c = str;
        this.f52410d = outputStream;
    }

    @Override // sr.m
    public OutputStream a() throws IOException {
        this.f50412a.d(this.f52410d);
        this.f52410d.write(Strings.i("\r\n"));
        if (this.f52409c == null) {
            return null;
        }
        this.f52410d.write(Strings.i("This is an S/MIME signed message\r\n"));
        this.f52410d.write(Strings.i("\r\n--"));
        this.f52410d.write(Strings.i(this.f52409c));
        this.f52410d.write(Strings.i("\r\n"));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        tr.b bVar = new tr.b(byteArrayOutputStream);
        return new c(this.f52408b.t(bVar, false, g.c(this.f52410d)), this.f52410d, byteArrayOutputStream, bVar);
    }
}
