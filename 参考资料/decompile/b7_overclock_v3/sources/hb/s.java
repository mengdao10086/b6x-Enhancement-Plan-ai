package hb;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import com.google.common.base.Charsets;
import g.p0;
import hb.u;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f30896a = 1716281667;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f30897b = 16382;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f30898c = 18;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @p0
        public u f30899a;

        public a(@p0 u uVar) {
            this.f30899a = uVar;
        }
    }

    public static boolean a(l lVar) throws IOException {
        hd.c0 c0Var = new hd.c0(4);
        lVar.t(c0Var.d(), 0, 4);
        return c0Var.I() == 1716281667;
    }

    public static int b(l lVar) throws IOException {
        lVar.n();
        hd.c0 c0Var = new hd.c0(2);
        lVar.t(c0Var.d(), 0, 2);
        int iM = c0Var.M();
        if ((iM >> 2) == 16382) {
            lVar.n();
            return iM;
        }
        lVar.n();
        throw new ParserException("First frame does not start with sync code.");
    }

    @p0
    public static Metadata c(l lVar, boolean z10) throws IOException {
        Metadata metadataA = new x().a(lVar, z10 ? null : zb.b.f58295b);
        if (metadataA == null || metadataA.g() == 0) {
            return null;
        }
        return metadataA;
    }

    @p0
    public static Metadata d(l lVar, boolean z10) throws IOException {
        lVar.n();
        long jI = lVar.i();
        Metadata metadataC = c(lVar, z10);
        lVar.o((int) (lVar.i() - jI));
        return metadataC;
    }

    public static boolean e(l lVar, a aVar) throws IOException {
        lVar.n();
        hd.b0 b0Var = new hd.b0(new byte[4]);
        lVar.t(b0Var.f30961a, 0, 4);
        boolean zG = b0Var.g();
        int iH = b0Var.h(7);
        int iH2 = b0Var.h(24) + 4;
        if (iH == 0) {
            aVar.f30899a = i(lVar);
        } else {
            u uVar = aVar.f30899a;
            if (uVar == null) {
                throw new IllegalArgumentException();
            }
            if (iH == 3) {
                aVar.f30899a = uVar.c(g(lVar, iH2));
            } else if (iH == 4) {
                aVar.f30899a = uVar.d(k(lVar, iH2));
            } else if (iH == 6) {
                aVar.f30899a = uVar.b(Collections.singletonList(f(lVar, iH2)));
            } else {
                lVar.o(iH2);
            }
        }
        return zG;
    }

    public static PictureFrame f(l lVar, int i10) throws IOException {
        hd.c0 c0Var = new hd.c0(i10);
        lVar.readFully(c0Var.d(), 0, i10);
        c0Var.T(4);
        int iO = c0Var.o();
        String strE = c0Var.E(c0Var.o(), Charsets.US_ASCII);
        String strD = c0Var.D(c0Var.o());
        int iO2 = c0Var.o();
        int iO3 = c0Var.o();
        int iO4 = c0Var.o();
        int iO5 = c0Var.o();
        int iO6 = c0Var.o();
        byte[] bArr = new byte[iO6];
        c0Var.k(bArr, 0, iO6);
        return new PictureFrame(iO, strE, strD, iO2, iO3, iO4, iO5, bArr);
    }

    public static u.a g(l lVar, int i10) throws IOException {
        hd.c0 c0Var = new hd.c0(i10);
        lVar.readFully(c0Var.d(), 0, i10);
        return h(c0Var);
    }

    public static u.a h(hd.c0 c0Var) {
        c0Var.T(1);
        int iJ = c0Var.J();
        long jE = ((long) c0Var.e()) + ((long) iJ);
        int i10 = iJ / 18;
        long[] jArrCopyOf = new long[i10];
        long[] jArrCopyOf2 = new long[i10];
        int i11 = 0;
        while (true) {
            if (i11 >= i10) {
                break;
            }
            long jZ = c0Var.z();
            if (jZ == -1) {
                jArrCopyOf = Arrays.copyOf(jArrCopyOf, i11);
                jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i11);
                break;
            }
            jArrCopyOf[i11] = jZ;
            jArrCopyOf2[i11] = c0Var.z();
            c0Var.T(2);
            i11++;
        }
        c0Var.T((int) (jE - ((long) c0Var.e())));
        return new u.a(jArrCopyOf, jArrCopyOf2);
    }

    public static u i(l lVar) throws IOException {
        byte[] bArr = new byte[38];
        lVar.readFully(bArr, 0, 38);
        return new u(bArr, 4);
    }

    public static void j(l lVar) throws IOException {
        hd.c0 c0Var = new hd.c0(4);
        lVar.readFully(c0Var.d(), 0, 4);
        if (c0Var.I() != 1716281667) {
            throw new ParserException("Failed to read FLAC stream marker.");
        }
    }

    public static List<String> k(l lVar, int i10) throws IOException {
        hd.c0 c0Var = new hd.c0(i10);
        lVar.readFully(c0Var.d(), 0, i10);
        c0Var.T(4);
        return Arrays.asList(f0.i(c0Var, false, false).f30849b);
    }
}
