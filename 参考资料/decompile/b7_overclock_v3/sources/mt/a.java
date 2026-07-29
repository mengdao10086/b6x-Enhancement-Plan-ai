package mt;

import gm.r;
import gm.y;
import gm.z;
import java.util.ArrayList;
import java.util.List;
import org.bouncycastle.cert.X509AttributeCertificateHolder;
import zn.e;
import zn.g0;

/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f41684f = "1.3.6.1.4.1.8005.100.100.4";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public X509AttributeCertificateHolder f41685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f41686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f41687c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List f41688d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List f41689e = new ArrayList();

    /* JADX INFO: renamed from: mt.a$a, reason: collision with other inner class name */
    public class C0459a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f41690a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f41691b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f41692c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f41693d;

        public C0459a(String str) {
            this.f41690a = str;
        }

        public C0459a(String str, String str2, String str3) {
            this.f41691b = str;
            this.f41692c = str2;
            this.f41693d = str3;
        }

        public String a() {
            if (this.f41691b == null && this.f41690a != null) {
                e();
            }
            return this.f41693d;
        }

        public String b() {
            String str = this.f41690a;
            if (str != null) {
                return str;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f41691b);
            sb2.append("/Role=");
            String str2 = this.f41692c;
            String str3 = "";
            if (str2 == null) {
                str2 = "";
            }
            sb2.append(str2);
            if (this.f41693d != null) {
                str3 = "/Capability=" + this.f41693d;
            }
            sb2.append(str3);
            String string = sb2.toString();
            this.f41690a = string;
            return string;
        }

        public String c() {
            if (this.f41691b == null && this.f41690a != null) {
                e();
            }
            return this.f41691b;
        }

        public String d() {
            if (this.f41691b == null && this.f41690a != null) {
                e();
            }
            return this.f41692c;
        }

        public void e() {
            this.f41690a.length();
            int iIndexOf = this.f41690a.indexOf("/Role=");
            if (iIndexOf < 0) {
                return;
            }
            this.f41691b = this.f41690a.substring(0, iIndexOf);
            int i10 = iIndexOf + 6;
            int iIndexOf2 = this.f41690a.indexOf("/Capability=", i10);
            String str = this.f41690a;
            String strSubstring = iIndexOf2 < 0 ? str.substring(i10) : str.substring(i10, iIndexOf2);
            String str2 = null;
            if (strSubstring.length() == 0) {
                strSubstring = null;
            }
            this.f41692c = strSubstring;
            String strSubstring2 = iIndexOf2 < 0 ? null : this.f41690a.substring(iIndexOf2 + 12);
            if (strSubstring2 != null && strSubstring2.length() != 0) {
                str2 = strSubstring2;
            }
            this.f41693d = str2;
        }

        public String toString() {
            return b();
        }
    }

    public a(X509AttributeCertificateHolder x509AttributeCertificateHolder) {
        if (x509AttributeCertificateHolder == null) {
            throw new IllegalArgumentException("VOMSAttribute: AttributeCertificate is NULL");
        }
        this.f41685a = x509AttributeCertificateHolder;
        e[] eVarArrB = x509AttributeCertificateHolder.b(new y(f41684f));
        if (eVarArrB == null) {
            return;
        }
        for (int i10 = 0; i10 != eVarArrB.length; i10++) {
            try {
                g0 g0VarX = g0.x(eVarArrB[i10].z()[0]);
                String strD = ((r) g0VarX.y().B()[0].A()).d();
                int iIndexOf = strD.indexOf("://");
                if (iIndexOf < 0 || iIndexOf == strD.length() - 1) {
                    throw new IllegalArgumentException("Bad encoding of VOMS policyAuthority : [" + strD + "]");
                }
                this.f41687c = strD.substring(0, iIndexOf);
                this.f41686b = strD.substring(iIndexOf + 3);
                if (g0VarX.z() != 1) {
                    throw new IllegalArgumentException("VOMS attribute values are not encoded as octet strings, policyAuthority = " + strD);
                }
                z[] zVarArr = (z[]) g0VarX.A();
                for (int i11 = 0; i11 != zVarArr.length; i11++) {
                    String str = new String(zVarArr[i11].J());
                    C0459a c0459a = new C0459a(str);
                    if (!this.f41688d.contains(str)) {
                        if (str.startsWith(fh.a.f28350w + this.f41687c + fh.a.f28350w)) {
                            this.f41688d.add(str);
                            this.f41689e.add(c0459a);
                        }
                    }
                }
            } catch (IllegalArgumentException e10) {
                throw e10;
            } catch (Exception unused) {
                throw new IllegalArgumentException("Badly encoded VOMS extension in AC issued by " + x509AttributeCertificateHolder.k());
            }
        }
    }

    public X509AttributeCertificateHolder a() {
        return this.f41685a;
    }

    public List b() {
        return this.f41688d;
    }

    public String c() {
        return this.f41686b;
    }

    public List d() {
        return this.f41689e;
    }

    public String e() {
        return this.f41687c;
    }

    public String toString() {
        return "VO      :" + this.f41687c + "\nHostPort:" + this.f41686b + "\nFQANs   :" + this.f41689e;
    }
}
