package org.bouncycastle.jcajce.provider.asymmetric.util;

import gm.y;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import javax.crypto.KeyAgreementSpi;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.SecretKeySpec;
import np.m1;
import org.bouncycastle.crypto.q;
import org.bouncycastle.crypto.r;
import org.bouncycastle.util.Strings;
import pn.s;

/* JADX INFO: loaded from: classes7.dex */
public abstract class a extends KeyAgreementSpi {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<String, y> f45043d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<String, Integer> f45044e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Map<String, String> f45045f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Hashtable f45046g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Hashtable f45047h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f45048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q f45049b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f45050c;

    static {
        HashMap map = new HashMap();
        f45043d = map;
        HashMap map2 = new HashMap();
        f45044e = map2;
        HashMap map3 = new HashMap();
        f45045f = map3;
        Hashtable hashtable = new Hashtable();
        f45046g = hashtable;
        Hashtable hashtable2 = new Hashtable();
        f45047h = hashtable2;
        Integer numG = org.bouncycastle.util.j.g(64);
        Integer numG2 = org.bouncycastle.util.j.g(128);
        Integer numG3 = org.bouncycastle.util.j.g(192);
        Integer numG4 = org.bouncycastle.util.j.g(256);
        map2.put("DES", numG);
        map2.put("DESEDE", numG3);
        map2.put("BLOWFISH", numG2);
        map2.put(m5.b.f40641c, numG4);
        map2.put(kn.d.f37624x.L(), numG2);
        map2.put(kn.d.F.L(), numG3);
        map2.put(kn.d.N.L(), numG4);
        map2.put(kn.d.f37625y.L(), numG2);
        map2.put(kn.d.G.L(), numG3);
        y yVar = kn.d.O;
        map2.put(yVar.L(), numG4);
        map2.put(kn.d.A.L(), numG2);
        map2.put(kn.d.I.L(), numG3);
        map2.put(kn.d.Q.L(), numG4);
        map2.put(kn.d.f37626z.L(), numG2);
        map2.put(kn.d.H.L(), numG3);
        map2.put(kn.d.P.L(), numG4);
        y yVar2 = kn.d.B;
        map2.put(yVar2.L(), numG2);
        map2.put(kn.d.J.L(), numG3);
        map2.put(kn.d.R.L(), numG4);
        y yVar3 = kn.d.D;
        map2.put(yVar3.L(), numG2);
        map2.put(kn.d.L.L(), numG3);
        map2.put(kn.d.T.L(), numG4);
        map2.put(kn.d.C.L(), numG2);
        map2.put(kn.d.K.L(), numG3);
        map2.put(kn.d.S.L(), numG4);
        y yVar4 = mn.a.f41446d;
        map2.put(yVar4.L(), numG2);
        y yVar5 = mn.a.f41447e;
        map2.put(yVar5.L(), numG3);
        y yVar6 = mn.a.f41448f;
        map2.put(yVar6.L(), numG4);
        y yVar7 = gn.a.f29841d;
        map2.put(yVar7.L(), numG2);
        y yVar8 = s.f46835p6;
        map2.put(yVar8.L(), numG3);
        y yVar9 = s.Z3;
        map2.put(yVar9.L(), numG3);
        y yVar10 = on.b.f44361e;
        map2.put(yVar10.L(), numG);
        y yVar11 = qm.a.f47456f;
        map2.put(yVar11.L(), numG4);
        map2.put(qm.a.f47454d.L(), numG4);
        map2.put(qm.a.f47455e.L(), numG4);
        y yVar12 = s.f46806g4;
        map2.put(yVar12.L(), org.bouncycastle.util.j.g(160));
        y yVar13 = s.f46812i4;
        map2.put(yVar13.L(), numG4);
        y yVar14 = s.f46815j4;
        map2.put(yVar14.L(), org.bouncycastle.util.j.g(384));
        y yVar15 = s.f46818k4;
        map2.put(yVar15.L(), org.bouncycastle.util.j.g(512));
        map.put("DESEDE", yVar9);
        map.put(m5.b.f40641c, yVar);
        y yVar16 = mn.a.f41445c;
        map.put("CAMELLIA", yVar16);
        y yVar17 = gn.a.f29838a;
        map.put("SEED", yVar17);
        map.put("DES", yVar10);
        map3.put(in.c.f32565u.L(), "CAST5");
        map3.put(in.c.f32567w.L(), "IDEA");
        map3.put(in.c.f32570z.L(), "Blowfish");
        map3.put(in.c.A.L(), "Blowfish");
        map3.put(in.c.B.L(), "Blowfish");
        map3.put(in.c.C.L(), "Blowfish");
        map3.put(on.b.f44360d.L(), "DES");
        map3.put(yVar10.L(), "DES");
        map3.put(on.b.f44363g.L(), "DES");
        map3.put(on.b.f44362f.L(), "DES");
        map3.put(on.b.f44364h.L(), "DESede");
        map3.put(yVar9.L(), "DESede");
        map3.put(yVar8.L(), "DESede");
        map3.put(s.f46838q6.L(), "RC2");
        map3.put(yVar12.L(), hh.c.f31295a);
        map3.put(s.f46809h4.L(), "HmacSHA224");
        map3.put(yVar13.L(), "HmacSHA256");
        map3.put(yVar14.L(), "HmacSHA384");
        map3.put(yVar15.L(), "HmacSHA512");
        map3.put(mn.a.f41443a.L(), "Camellia");
        map3.put(mn.a.f41444b.L(), "Camellia");
        map3.put(yVar16.L(), "Camellia");
        map3.put(yVar4.L(), "Camellia");
        map3.put(yVar5.L(), "Camellia");
        map3.put(yVar6.L(), "Camellia");
        map3.put(yVar7.L(), "SEED");
        map3.put(yVar17.L(), "SEED");
        map3.put(gn.a.f29839b.L(), "SEED");
        map3.put(yVar11.L(), "GOST28147");
        map3.put(yVar2.L(), m5.b.f40641c);
        map3.put(yVar3.L(), m5.b.f40641c);
        map3.put(yVar3.L(), m5.b.f40641c);
        hashtable.put("DESEDE", yVar9);
        hashtable.put(m5.b.f40641c, yVar);
        hashtable.put("DES", yVar10);
        hashtable2.put("DES", "DES");
        hashtable2.put("DESEDE", "DES");
        hashtable2.put(yVar10.L(), "DES");
        hashtable2.put(yVar9.L(), "DES");
        hashtable2.put(yVar8.L(), "DES");
    }

    public a(String str, q qVar) {
        this.f45048a = str;
        this.f45049b = qVar;
    }

    public static String b(String str) {
        if (str.indexOf(91) > 0) {
            return str.substring(0, str.indexOf(91));
        }
        if (str.startsWith(kn.d.f37623w.L())) {
            return m5.b.f40641c;
        }
        if (str.startsWith(ym.a.f57373i.L())) {
            return "Serpent";
        }
        String str2 = f45045f.get(Strings.o(str));
        return str2 != null ? str2 : str;
    }

    public static int c(String str) {
        if (str.indexOf(91) > 0) {
            return Integer.parseInt(str.substring(str.indexOf(91) + 1, str.indexOf(93)));
        }
        String strO = Strings.o(str);
        Map<String, Integer> map = f45044e;
        if (map.containsKey(strO)) {
            return map.get(strO).intValue();
        }
        return -1;
    }

    public static byte[] e(byte[] bArr) {
        if (bArr[0] != 0) {
            return bArr;
        }
        int i10 = 0;
        while (i10 < bArr.length && bArr[i10] == 0) {
            i10++;
        }
        int length = bArr.length - i10;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, i10, bArr2, 0, length);
        return bArr2;
    }

    public abstract byte[] a();

    public final byte[] d(byte[] bArr, String str, int i10) throws NoSuchAlgorithmException {
        r m1Var;
        q qVar = this.f45049b;
        if (qVar == null) {
            if (i10 <= 0) {
                return bArr;
            }
            int i11 = i10 / 8;
            byte[] bArr2 = new byte[i11];
            System.arraycopy(bArr, 0, bArr2, 0, i11);
            org.bouncycastle.util.a.n(bArr);
            return bArr2;
        }
        if (i10 < 0) {
            throw new NoSuchAlgorithmException("unknown algorithm encountered: " + str);
        }
        int i12 = i10 / 8;
        byte[] bArr3 = new byte[i12];
        if (!(qVar instanceof wo.c)) {
            m1Var = new m1(bArr, this.f45050c);
        } else {
            if (str == null) {
                throw new NoSuchAlgorithmException("algorithm OID is null");
            }
            try {
                m1Var = new wo.b(new y(str), i10, bArr, this.f45050c);
            } catch (IllegalArgumentException unused) {
                throw new NoSuchAlgorithmException("no OID for algorithm: " + str);
            }
        }
        this.f45049b.a(m1Var);
        this.f45049b.b(bArr3, 0, i12);
        org.bouncycastle.util.a.n(bArr);
        return bArr3;
    }

    @Override // javax.crypto.KeyAgreementSpi
    public int engineGenerateSecret(byte[] bArr, int i10) throws IllegalStateException, ShortBufferException {
        byte[] bArrEngineGenerateSecret = engineGenerateSecret();
        if (bArr.length - i10 >= bArrEngineGenerateSecret.length) {
            System.arraycopy(bArrEngineGenerateSecret, 0, bArr, i10, bArrEngineGenerateSecret.length);
            return bArrEngineGenerateSecret.length;
        }
        throw new ShortBufferException(this.f45048a + " key agreement: need " + bArrEngineGenerateSecret.length + " bytes");
    }

    @Override // javax.crypto.KeyAgreementSpi
    public SecretKey engineGenerateSecret(String str) throws NoSuchAlgorithmException {
        String strO = Strings.o(str);
        Hashtable hashtable = f45046g;
        String strL = hashtable.containsKey(strO) ? ((y) hashtable.get(strO)).L() : str;
        byte[] bArrD = d(a(), strL, c(strL));
        String strB = b(str);
        if (f45047h.containsKey(strB)) {
            np.k.c(bArrD);
        }
        return new SecretKeySpec(bArrD, strB);
    }

    @Override // javax.crypto.KeyAgreementSpi
    public byte[] engineGenerateSecret() throws IllegalStateException {
        if (this.f45049b == null) {
            return a();
        }
        byte[] bArrA = a();
        try {
            return d(bArrA, null, bArrA.length * 8);
        } catch (NoSuchAlgorithmException e10) {
            throw new IllegalStateException(e10.getMessage());
        }
    }
}
