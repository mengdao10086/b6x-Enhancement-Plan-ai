package bs;

import gm.y;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.openssl.EncryptionException;
import org.bouncycastle.openssl.PEMException;
import pn.s;

/* JADX INFO: loaded from: classes6.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map f9634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set f9635b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set f9636c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map f9637d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map f9638e;

    static {
        HashMap map = new HashMap();
        f9634a = map;
        HashSet hashSet = new HashSet();
        f9635b = hashSet;
        HashSet hashSet2 = new HashSet();
        f9636c = hashSet2;
        HashMap map2 = new HashMap();
        f9637d = map2;
        HashMap map3 = new HashMap();
        f9638e = map3;
        hashSet.add(s.Q3);
        hashSet.add(s.R3);
        hashSet.add(s.S3);
        hashSet.add(s.T3);
        hashSet.add(s.U3);
        hashSet.add(s.V3);
        hashSet2.add(s.W3);
        y yVar = s.Z3;
        hashSet2.add(yVar);
        y yVar2 = kn.d.f37625y;
        hashSet2.add(yVar2);
        y yVar3 = kn.d.G;
        hashSet2.add(yVar3);
        y yVar4 = kn.d.O;
        hashSet2.add(yVar4);
        map.put(yVar.L(), org.bouncycastle.util.j.g(192));
        map.put(yVar2.L(), org.bouncycastle.util.j.g(128));
        map.put(yVar3.L(), org.bouncycastle.util.j.g(192));
        map.put(yVar4.L(), org.bouncycastle.util.j.g(256));
        map.put(s.f46814i6.L(), org.bouncycastle.util.j.g(128));
        map.put(s.f46817j6, org.bouncycastle.util.j.g(40));
        map.put(s.f46823l6, org.bouncycastle.util.j.g(128));
        map.put(s.f46820k6, org.bouncycastle.util.j.g(192));
        map.put(s.f46826m6, org.bouncycastle.util.j.g(128));
        map.put(s.f46829n6, org.bouncycastle.util.j.g(40));
        y yVar5 = s.f46806g4;
        map2.put(yVar5, "PBKDF2withHMACSHA1");
        y yVar6 = s.f46812i4;
        map2.put(yVar6, "PBKDF2withHMACSHA256");
        y yVar7 = s.f46818k4;
        map2.put(yVar7, "PBKDF2withHMACSHA512");
        y yVar8 = s.f46809h4;
        map2.put(yVar8, "PBKDF2withHMACSHA224");
        y yVar9 = s.f46815j4;
        map2.put(yVar9, "PBKDF2withHMACSHA384");
        y yVar10 = kn.d.f37615o;
        map2.put(yVar10, "PBKDF2withHMACSHA3-224");
        y yVar11 = kn.d.f37616p;
        map2.put(yVar11, "PBKDF2withHMACSHA3-256");
        y yVar12 = kn.d.f37617q;
        map2.put(yVar12, "PBKDF2withHMACSHA3-384");
        y yVar13 = kn.d.f37618r;
        map2.put(yVar13, "PBKDF2withHMACSHA3-512");
        y yVar14 = qm.a.f47453c;
        map2.put(yVar14, "PBKDF2withHMACGOST3411");
        map3.put(yVar5, org.bouncycastle.util.j.g(20));
        map3.put(yVar6, org.bouncycastle.util.j.g(32));
        map3.put(yVar7, org.bouncycastle.util.j.g(64));
        map3.put(yVar8, org.bouncycastle.util.j.g(28));
        map3.put(yVar9, org.bouncycastle.util.j.g(48));
        map3.put(yVar10, org.bouncycastle.util.j.g(28));
        map3.put(yVar11, org.bouncycastle.util.j.g(32));
        map3.put(yVar12, org.bouncycastle.util.j.g(48));
        map3.put(yVar13, org.bouncycastle.util.j.g(64));
        map3.put(yVar14, org.bouncycastle.util.j.g(32));
    }

    public static byte[] a(boolean z10, org.bouncycastle.jcajce.util.d dVar, byte[] bArr, char[] cArr, String str, byte[] bArr2) throws PEMException {
        String str2;
        String str3;
        String str4;
        String str5;
        byte[] bArr3;
        SecretKey secretKeyD;
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr2);
        if (str.endsWith("-CFB")) {
            str2 = "CFB";
            str3 = "NoPadding";
        } else {
            str2 = "CBC";
            str3 = "PKCS5Padding";
        }
        if (str.endsWith("-ECB") || "DES-EDE".equals(str) || "DES-EDE3".equals(str)) {
            ivParameterSpec = null;
            str2 = "ECB";
        }
        AlgorithmParameterSpec rC2ParameterSpec = ivParameterSpec;
        if (str.endsWith("-OFB")) {
            str5 = "OFB";
            str4 = "NoPadding";
        } else {
            str4 = str3;
            str5 = str2;
        }
        boolean zStartsWith = str.startsWith("DES-EDE");
        String str6 = m5.b.f40641c;
        int i10 = 1;
        if (zStartsWith) {
            secretKeyD = e(dVar, cArr, "DESede", 24, bArr2, !str.startsWith("DES-EDE3"));
            str6 = "DESede";
        } else if (str.startsWith("DES-")) {
            str6 = "DES";
            secretKeyD = d(dVar, cArr, "DES", 8, bArr2);
        } else if (str.startsWith("BF-")) {
            str6 = "Blowfish";
            secretKeyD = d(dVar, cArr, "Blowfish", 16, bArr2);
        } else {
            int i11 = 128;
            if (str.startsWith("RC2-")) {
                str6 = "RC2";
                if (str.startsWith("RC2-40-")) {
                    i11 = 40;
                } else if (str.startsWith("RC2-64-")) {
                    i11 = 64;
                }
                secretKeyD = d(dVar, cArr, "RC2", i11 / 8, bArr2);
                rC2ParameterSpec = rC2ParameterSpec == null ? new RC2ParameterSpec(i11) : new RC2ParameterSpec(i11, bArr2);
            } else {
                if (!str.startsWith("AES-")) {
                    throw new EncryptionException("unknown encryption with private key");
                }
                if (bArr2.length > 8) {
                    bArr3 = new byte[8];
                    System.arraycopy(bArr2, 0, bArr3, 0, 8);
                } else {
                    bArr3 = bArr2;
                }
                if (!str.startsWith("AES-128-")) {
                    if (str.startsWith("AES-192-")) {
                        i11 = 192;
                    } else {
                        if (!str.startsWith("AES-256-")) {
                            throw new EncryptionException("unknown AES encryption with private key");
                        }
                        i11 = 256;
                    }
                }
                secretKeyD = d(dVar, cArr, m5.b.f40641c, i11 / 8, bArr3);
            }
        }
        try {
            Cipher cipherI = dVar.i(str6 + fh.a.f28350w + str5 + fh.a.f28350w + str4);
            if (!z10) {
                i10 = 2;
            }
            if (rC2ParameterSpec == null) {
                cipherI.init(i10, secretKeyD);
            } else {
                cipherI.init(i10, secretKeyD, rC2ParameterSpec);
            }
            return cipherI.doFinal(bArr);
        } catch (Exception e10) {
            throw new EncryptionException("exception using cipher - please check password and data.", e10);
        }
    }

    public static SecretKey b(org.bouncycastle.jcajce.util.d dVar, String str, char[] cArr, byte[] bArr, int i10) throws InvalidKeySpecException, NoSuchAlgorithmException, NoSuchProviderException {
        return new SecretKeySpec(dVar.u("PBKDF2with8BIT").generateSecret(new PBEKeySpec(cArr, bArr, i10, f(str))).getEncoded(), str);
    }

    public static SecretKey c(org.bouncycastle.jcajce.util.d dVar, String str, char[] cArr, byte[] bArr, int i10, zn.b bVar) throws InvalidKeySpecException, NoSuchAlgorithmException, NoSuchProviderException {
        String str2 = (String) f9637d.get(bVar.x());
        if (str2 != null) {
            return new SecretKeySpec(dVar.u(str2).generateSecret(new PBEKeySpec(cArr, bArr, i10, f(str))).getEncoded(), str);
        }
        throw new NoSuchAlgorithmException("unknown PRF in PKCS#2: " + bVar.x());
    }

    public static SecretKey d(org.bouncycastle.jcajce.util.d dVar, char[] cArr, String str, int i10, byte[] bArr) throws PEMException {
        return e(dVar, cArr, str, i10, bArr, false);
    }

    public static SecretKey e(org.bouncycastle.jcajce.util.d dVar, char[] cArr, String str, int i10, byte[] bArr, boolean z10) throws PEMException {
        try {
            byte[] encoded = dVar.u("PBKDF-OpenSSL").generateSecret(new PBEKeySpec(cArr, bArr, 1, i10 * 8)).getEncoded();
            if (z10 && encoded.length >= 24) {
                System.arraycopy(encoded, 0, encoded, 16, 8);
            }
            return new SecretKeySpec(encoded, str);
        } catch (GeneralSecurityException e10) {
            throw new PEMException("Unable to create OpenSSL PBDKF: " + e10.getMessage(), e10);
        }
    }

    public static int f(String str) {
        Map map = f9634a;
        if (map.containsKey(str)) {
            return ((Integer) map.get(str)).intValue();
        }
        throw new IllegalStateException("no key size for algorithm: " + str);
    }

    public static int g(y yVar) {
        Map map = f9638e;
        if (map.containsKey(yVar)) {
            return ((Integer) map.get(yVar)).intValue();
        }
        throw new IllegalStateException("no salt size for algorithm: " + yVar);
    }

    public static boolean h(zn.b bVar) {
        return bVar == null || bVar.x().C(s.f46806g4);
    }

    public static boolean i(y yVar) {
        return yVar.L().startsWith(s.f46811h6.L());
    }

    public static boolean j(y yVar) {
        return f9635b.contains(yVar);
    }

    public static boolean k(y yVar) {
        return f9636c.contains(yVar);
    }
}
