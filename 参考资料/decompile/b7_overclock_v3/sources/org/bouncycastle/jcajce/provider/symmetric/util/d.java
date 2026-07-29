package org.bouncycastle.jcajce.provider.symmetric.util;

import fp.g0;
import fp.h0;
import fp.i0;
import fp.j0;
import java.security.InvalidAlgorithmParameterException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.SecretKey;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import np.n1;
import np.v1;
import org.bouncycastle.crypto.c0;
import org.bouncycastle.crypto.k;
import org.bouncycastle.crypto.util.f;
import zo.h;
import zo.k0;
import zo.o0;
import zo.s;
import zo.z;

/* JADX INFO: loaded from: classes5.dex */
public interface d {

    /* JADX INFO: renamed from: b3, reason: collision with root package name */
    public static final int f45225b3 = 0;

    /* JADX INFO: renamed from: c3, reason: collision with root package name */
    public static final int f45226c3 = 1;

    /* JADX INFO: renamed from: d3, reason: collision with root package name */
    public static final int f45227d3 = 2;

    /* JADX INFO: renamed from: e3, reason: collision with root package name */
    public static final int f45228e3 = 3;

    /* JADX INFO: renamed from: f3, reason: collision with root package name */
    public static final int f45229f3 = 4;

    /* JADX INFO: renamed from: g3, reason: collision with root package name */
    public static final int f45230g3 = 5;

    /* JADX INFO: renamed from: h3, reason: collision with root package name */
    public static final int f45231h3 = 6;

    /* JADX INFO: renamed from: i3, reason: collision with root package name */
    public static final int f45232i3 = 7;

    /* JADX INFO: renamed from: j3, reason: collision with root package name */
    public static final int f45233j3 = 8;

    /* JADX INFO: renamed from: k3, reason: collision with root package name */
    public static final int f45234k3 = 9;

    /* JADX INFO: renamed from: l3, reason: collision with root package name */
    public static final int f45235l3 = 10;

    /* JADX INFO: renamed from: m3, reason: collision with root package name */
    public static final int f45236m3 = 11;

    /* JADX INFO: renamed from: n3, reason: collision with root package name */
    public static final int f45237n3 = 12;

    /* JADX INFO: renamed from: o3, reason: collision with root package name */
    public static final int f45238o3 = 13;

    /* JADX INFO: renamed from: p3, reason: collision with root package name */
    public static final int f45239p3 = 14;

    /* JADX INFO: renamed from: q3, reason: collision with root package name */
    public static final int f45240q3 = 0;

    /* JADX INFO: renamed from: r3, reason: collision with root package name */
    public static final int f45241r3 = 1;

    /* JADX INFO: renamed from: s3, reason: collision with root package name */
    public static final int f45242s3 = 2;

    /* JADX INFO: renamed from: t3, reason: collision with root package name */
    public static final int f45243t3 = 3;

    /* JADX INFO: renamed from: u3, reason: collision with root package name */
    public static final int f45244u3 = 4;

    /* JADX INFO: renamed from: v3, reason: collision with root package name */
    public static final int f45245v3 = 5;

    public static class a {
        public static byte[] a(int i10, PBEKeySpec pBEKeySpec) {
            return i10 == 2 ? c0.a(pBEKeySpec.getPassword()) : (i10 == 5 || i10 == 4) ? c0.c(pBEKeySpec.getPassword()) : c0.b(pBEKeySpec.getPassword());
        }

        public static c0 b(int i10, int i11) {
            if (i10 == 0 || i10 == 4) {
                if (i11 == 0) {
                    return new i0(f.b());
                }
                if (i11 == 1) {
                    return new i0(f.c());
                }
                if (i11 == 5) {
                    return new i0(new s());
                }
                throw new IllegalStateException("PKCS5 scheme 1 only supports MD2, MD5 and SHA1.");
            }
            if (i10 != 1 && i10 != 5) {
                if (i10 != 2) {
                    return new g0();
                }
                switch (i11) {
                    case 0:
                        return new h0(f.b());
                    case 1:
                        return new h0(f.c());
                    case 2:
                        return new h0(new z());
                    case 3:
                        return new h0(new o0());
                    case 4:
                        return new h0(f.e());
                    case 5:
                        return new h0(new s());
                    case 6:
                        return new h0(new h());
                    case 7:
                        return new h0(f.d());
                    case 8:
                        return new h0(f.f());
                    case 9:
                        return new h0(f.k());
                    default:
                        throw new IllegalStateException("unknown digest scheme for PBE encryption.");
                }
            }
            switch (i11) {
                case 0:
                    return new j0(f.b());
                case 1:
                    return new j0(f.c());
                case 2:
                    return new j0(new z());
                case 3:
                    return new j0(new o0());
                case 4:
                    return new j0(f.e());
                case 5:
                    return new j0(new s());
                case 6:
                    return new j0(new h());
                case 7:
                    return new j0(f.d());
                case 8:
                    return new j0(f.f());
                case 9:
                    return new j0(f.k());
                case 10:
                    return new j0(f.g());
                case 11:
                    return new j0(f.h());
                case 12:
                    return new j0(f.i());
                case 13:
                    return new j0(f.j());
                case 14:
                    return new j0(new k0());
                default:
                    throw new IllegalStateException("unknown digest scheme for PBE PKCS5S2 encryption.");
            }
        }

        public static k c(SecretKey secretKey, int i10, int i11, int i12, PBEParameterSpec pBEParameterSpec) {
            c0 c0VarB = b(i10, i11);
            byte[] encoded = secretKey.getEncoded();
            c0VarB.j(secretKey.getEncoded(), pBEParameterSpec.getSalt(), pBEParameterSpec.getIterationCount());
            k kVarD = c0VarB.d(i12);
            for (int i13 = 0; i13 != encoded.length; i13++) {
                encoded[i13] = 0;
            }
            return kVarD;
        }

        public static k d(PBEKeySpec pBEKeySpec, int i10, int i11, int i12) {
            c0 c0VarB = b(i10, i11);
            byte[] bArrA = a(i10, pBEKeySpec);
            c0VarB.j(bArrA, pBEKeySpec.getSalt(), pBEKeySpec.getIterationCount());
            k kVarD = c0VarB.d(i12);
            for (int i13 = 0; i13 != bArrA.length; i13++) {
                bArrA[i13] = 0;
            }
            return kVarD;
        }

        public static k e(BCPBEKey bCPBEKey, AlgorithmParameterSpec algorithmParameterSpec) {
            if (algorithmParameterSpec == null || !(algorithmParameterSpec instanceof PBEParameterSpec)) {
                throw new IllegalArgumentException("Need a PBEParameter spec with a PBE key.");
            }
            PBEParameterSpec pBEParameterSpec = (PBEParameterSpec) algorithmParameterSpec;
            c0 c0VarB = b(bCPBEKey.i(), bCPBEKey.b());
            c0VarB.j(bCPBEKey.getEncoded(), pBEParameterSpec.getSalt(), pBEParameterSpec.getIterationCount());
            return c0VarB.d(bCPBEKey.d());
        }

        public static k f(PBEKeySpec pBEKeySpec, int i10, int i11, int i12, int i13) {
            c0 c0VarB = b(i10, i11);
            byte[] bArrA = a(i10, pBEKeySpec);
            c0VarB.j(bArrA, pBEKeySpec.getSalt(), pBEKeySpec.getIterationCount());
            k kVarF = i13 != 0 ? c0VarB.f(i12, i13) : c0VarB.e(i12);
            for (int i14 = 0; i14 != bArrA.length; i14++) {
                bArrA[i14] = 0;
            }
            return kVarF;
        }

        public static k g(BCPBEKey bCPBEKey, AlgorithmParameterSpec algorithmParameterSpec, String str) {
            if (algorithmParameterSpec == null || !(algorithmParameterSpec instanceof PBEParameterSpec)) {
                throw new IllegalArgumentException("Need a PBEParameter spec with a PBE key.");
            }
            PBEParameterSpec pBEParameterSpec = (PBEParameterSpec) algorithmParameterSpec;
            c0 c0VarB = b(bCPBEKey.i(), bCPBEKey.b());
            byte[] encoded = bCPBEKey.getEncoded();
            if (bCPBEKey.l()) {
                encoded = new byte[2];
            }
            c0VarB.j(encoded, pBEParameterSpec.getSalt(), pBEParameterSpec.getIterationCount());
            k kVarF = bCPBEKey.c() != 0 ? c0VarB.f(bCPBEKey.d(), bCPBEKey.c()) : c0VarB.e(bCPBEKey.d());
            if (str.startsWith("DES")) {
                if (kVarF instanceof v1) {
                    np.k.c(((n1) ((v1) kVarF).b()).a());
                } else {
                    np.k.c(((n1) kVarF).a());
                }
            }
            return kVarF;
        }

        public static k h(byte[] bArr, int i10, int i11, int i12, int i13, AlgorithmParameterSpec algorithmParameterSpec, String str) throws InvalidAlgorithmParameterException {
            if (algorithmParameterSpec == null || !(algorithmParameterSpec instanceof PBEParameterSpec)) {
                throw new InvalidAlgorithmParameterException("Need a PBEParameter spec with a PBE key.");
            }
            PBEParameterSpec pBEParameterSpec = (PBEParameterSpec) algorithmParameterSpec;
            c0 c0VarB = b(i10, i11);
            c0VarB.j(bArr, pBEParameterSpec.getSalt(), pBEParameterSpec.getIterationCount());
            k kVarF = i13 != 0 ? c0VarB.f(i12, i13) : c0VarB.e(i12);
            if (str.startsWith("DES")) {
                if (kVarF instanceof v1) {
                    np.k.c(((n1) ((v1) kVarF).b()).a());
                } else {
                    np.k.c(((n1) kVarF).a());
                }
            }
            return kVarF;
        }
    }
}
