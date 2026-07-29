package org.bouncycastle.jce.provider;

import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import np.n1;
import np.v1;
import org.bouncycastle.jcajce.provider.symmetric.util.BCPBEKey;

/* JADX INFO: loaded from: classes5.dex */
public interface d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f45412a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f45413b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f45414c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f45415d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f45416e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f45417f = 2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f45418g = 3;

    public static class a {
        public static org.bouncycastle.crypto.c0 a(int i10, int i11) {
            if (i10 == 0) {
                if (i11 == 0) {
                    return new fp.i0(new zo.u());
                }
                if (i11 == 1) {
                    return new fp.i0(new zo.c0());
                }
                throw new IllegalStateException("PKCS5 scheme 1 only supports only MD5 and SHA1.");
            }
            if (i10 == 1) {
                return new fp.j0();
            }
            if (i10 == 3) {
                if (i11 == 0) {
                    return new m(new zo.u());
                }
                if (i11 == 1) {
                    return new m(new zo.c0());
                }
                if (i11 == 2) {
                    return new m(new zo.z());
                }
                throw new IllegalStateException("unknown digest scheme for PBE encryption.");
            }
            if (i11 == 0) {
                return new fp.h0(new zo.u());
            }
            if (i11 == 1) {
                return new fp.h0(new zo.c0());
            }
            if (i11 == 2) {
                return new fp.h0(new zo.z());
            }
            throw new IllegalStateException("unknown digest scheme for PBE encryption.");
        }

        public static org.bouncycastle.crypto.k b(BCPBEKey bCPBEKey, AlgorithmParameterSpec algorithmParameterSpec, int i10, int i11, int i12) {
            if (algorithmParameterSpec == null || !(algorithmParameterSpec instanceof PBEParameterSpec)) {
                throw new IllegalArgumentException("Need a PBEParameter spec with a PBE key.");
            }
            PBEParameterSpec pBEParameterSpec = (PBEParameterSpec) algorithmParameterSpec;
            org.bouncycastle.crypto.c0 c0VarA = a(i10, i11);
            byte[] encoded = bCPBEKey.getEncoded();
            c0VarA.j(encoded, pBEParameterSpec.getSalt(), pBEParameterSpec.getIterationCount());
            org.bouncycastle.crypto.k kVarD = c0VarA.d(i12);
            for (int i13 = 0; i13 != encoded.length; i13++) {
                encoded[i13] = 0;
            }
            return kVarD;
        }

        public static org.bouncycastle.crypto.k c(BCPBEKey bCPBEKey, AlgorithmParameterSpec algorithmParameterSpec, int i10, int i11, String str, int i12, int i13) {
            if (algorithmParameterSpec == null || !(algorithmParameterSpec instanceof PBEParameterSpec)) {
                throw new IllegalArgumentException("Need a PBEParameter spec with a PBE key.");
            }
            PBEParameterSpec pBEParameterSpec = (PBEParameterSpec) algorithmParameterSpec;
            org.bouncycastle.crypto.c0 c0VarA = a(i10, i11);
            byte[] encoded = bCPBEKey.getEncoded();
            c0VarA.j(encoded, pBEParameterSpec.getSalt(), pBEParameterSpec.getIterationCount());
            org.bouncycastle.crypto.k kVarF = i13 != 0 ? c0VarA.f(i12, i13) : c0VarA.e(i12);
            if (str.startsWith("DES")) {
                if (kVarF instanceof v1) {
                    d(((n1) ((v1) kVarF).b()).a());
                } else {
                    d(((n1) kVarF).a());
                }
            }
            for (int i14 = 0; i14 != encoded.length; i14++) {
                encoded[i14] = 0;
            }
            return kVarF;
        }

        public static void d(byte[] bArr) {
            for (int i10 = 0; i10 < bArr.length; i10++) {
                byte b10 = bArr[i10];
                bArr[i10] = (byte) ((((b10 >> 7) ^ ((((((b10 >> 1) ^ (b10 >> 2)) ^ (b10 >> 3)) ^ (b10 >> 4)) ^ (b10 >> 5)) ^ (b10 >> 6))) ^ 1) | (b10 & 254));
            }
        }
    }
}
