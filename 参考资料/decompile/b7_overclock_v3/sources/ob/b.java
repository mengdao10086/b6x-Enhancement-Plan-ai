package ob;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry;
import com.google.android.exoplayer2.metadata.mp4.SmtaMetadataEntry;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import g.p0;
import hd.c0;
import hd.t;
import hd.u0;
import hd.w;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import ob.a;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f43101a = "AtomParsers";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f43102b = 1986618469;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f43103c = 1936684398;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f43104d = 1952807028;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f43105e = 1935832172;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f43106f = 1937072756;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f43107g = 1668047728;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f43108h = 1835365473;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f43109i = 1835299937;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f43110j = 4;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final byte[] f43111k = u0.w0("OpusHead");

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f43112a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f43113b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f43114c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f43115d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f43116e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final c0 f43117f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final c0 f43118g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f43119h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f43120i;

        public a(c0 c0Var, c0 c0Var2, boolean z10) {
            this.f43118g = c0Var;
            this.f43117f = c0Var2;
            this.f43116e = z10;
            c0Var2.S(12);
            this.f43112a = c0Var2.K();
            c0Var.S(12);
            this.f43120i = c0Var.K();
            hd.a.j(c0Var.o() == 1, "first_chunk must be 1");
            this.f43113b = -1;
        }

        public boolean a() {
            int i10 = this.f43113b + 1;
            this.f43113b = i10;
            if (i10 == this.f43112a) {
                return false;
            }
            this.f43115d = this.f43116e ? this.f43117f.L() : this.f43117f.I();
            if (this.f43113b == this.f43119h) {
                this.f43114c = this.f43118g.K();
                this.f43118g.T(4);
                int i11 = this.f43120i - 1;
                this.f43120i = i11;
                this.f43119h = i11 > 0 ? this.f43118g.K() - 1 : -1;
            }
            return true;
        }
    }

    /* JADX INFO: renamed from: ob.b$b, reason: collision with other inner class name */
    public interface InterfaceC0486b {
        int a();

        int b();

        int c();
    }

    public static final class c {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f43121e = 8;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final p[] f43122a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @p0
        public Format f43123b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f43124c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f43125d = 0;

        public c(int i10) {
            this.f43122a = new p[i10];
        }
    }

    public static final class d implements InterfaceC0486b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f43126a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f43127b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c0 f43128c;

        public d(a.b bVar, Format format) {
            c0 c0Var = bVar.f43100s1;
            this.f43128c = c0Var;
            c0Var.S(12);
            int iK = c0Var.K();
            if (w.G.equals(format.f16699l)) {
                int iM0 = u0.m0(format.A, format.f16712y);
                if (iK == 0 || iK % iM0 != 0) {
                    t.n(b.f43101a, "Audio sample size mismatch. stsd sample size: " + iM0 + ", stsz sample size: " + iK);
                    iK = iM0;
                }
            }
            this.f43126a = iK == 0 ? -1 : iK;
            this.f43127b = c0Var.K();
        }

        @Override // ob.b.InterfaceC0486b
        public int a() {
            return this.f43126a;
        }

        @Override // ob.b.InterfaceC0486b
        public int b() {
            return this.f43127b;
        }

        @Override // ob.b.InterfaceC0486b
        public int c() {
            int i10 = this.f43126a;
            return i10 == -1 ? this.f43128c.K() : i10;
        }
    }

    public static final class e implements InterfaceC0486b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c0 f43129a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f43130b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f43131c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f43132d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f43133e;

        public e(a.b bVar) {
            c0 c0Var = bVar.f43100s1;
            this.f43129a = c0Var;
            c0Var.S(12);
            this.f43131c = c0Var.K() & 255;
            this.f43130b = c0Var.K();
        }

        @Override // ob.b.InterfaceC0486b
        public int a() {
            return -1;
        }

        @Override // ob.b.InterfaceC0486b
        public int b() {
            return this.f43130b;
        }

        @Override // ob.b.InterfaceC0486b
        public int c() {
            int i10 = this.f43131c;
            if (i10 == 8) {
                return this.f43129a.G();
            }
            if (i10 == 16) {
                return this.f43129a.M();
            }
            int i11 = this.f43132d;
            this.f43132d = i11 + 1;
            if (i11 % 2 != 0) {
                return this.f43133e & 15;
            }
            int iG = this.f43129a.G();
            this.f43133e = iG;
            return (iG & 240) >> 4;
        }
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f43134a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f43135b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f43136c;

        public f(int i10, long j10, int i11) {
            this.f43134a = i10;
            this.f43135b = j10;
            this.f43136c = i11;
        }
    }

    public static Pair<Metadata, Metadata> A(a.b bVar) {
        c0 c0Var = bVar.f43100s1;
        c0Var.S(8);
        Metadata metadataB = null;
        Metadata metadataT = null;
        while (c0Var.a() >= 8) {
            int iE = c0Var.e();
            int iO = c0Var.o();
            int iO2 = c0Var.o();
            if (iO2 == 1835365473) {
                c0Var.S(iE);
                metadataB = B(c0Var, iE + iO);
            } else if (iO2 == 1936553057) {
                c0Var.S(iE);
                metadataT = t(c0Var, iE + iO);
            }
            c0Var.S(iE + iO);
        }
        return Pair.create(metadataB, metadataT);
    }

    @p0
    public static Metadata B(c0 c0Var, int i10) {
        c0Var.T(8);
        d(c0Var);
        while (c0Var.e() < i10) {
            int iE = c0Var.e();
            int iO = c0Var.o();
            if (c0Var.o() == 1768715124) {
                c0Var.S(iE);
                return k(c0Var, iE + iO);
            }
            c0Var.S(iE + iO);
        }
        return null;
    }

    public static void C(c0 c0Var, int i10, int i11, int i12, int i13, int i14, @p0 DrmInitData drmInitData, c cVar, int i15) throws ParserException {
        DrmInitData drmInitData2;
        List<byte[]> list;
        String str;
        List<byte[]> list2;
        String str2;
        String str3;
        int i16 = i11;
        int i17 = i12;
        DrmInitData drmInitDataE = drmInitData;
        c0Var.S(i16 + 8 + 8);
        c0Var.T(16);
        int iM = c0Var.M();
        int iM2 = c0Var.M();
        c0Var.T(50);
        int iE = c0Var.e();
        String str4 = null;
        int iIntValue = i10;
        if (iIntValue == 1701733238) {
            Pair<Integer, p> pairR = r(c0Var, i16, i17);
            if (pairR != null) {
                iIntValue = ((Integer) pairR.first).intValue();
                drmInitDataE = drmInitDataE == null ? null : drmInitDataE.e(((p) pairR.second).f43288b);
                cVar.f43122a[i15] = (p) pairR.second;
            }
            c0Var.S(iE);
        }
        List<byte[]> listOf = null;
        String str5 = iIntValue == 1831958048 ? w.f31204q : null;
        int i18 = -1;
        float fP = 1.0f;
        boolean z10 = false;
        byte[] bArrQ = null;
        while (true) {
            if (iE - i16 >= i17) {
                drmInitData2 = drmInitDataE;
                list = listOf;
                break;
            }
            c0Var.S(iE);
            int iE2 = c0Var.e();
            drmInitData2 = drmInitDataE;
            int iO = c0Var.o();
            if (iO == 0) {
                list = listOf;
                if (c0Var.e() - i16 == i17) {
                    break;
                }
            } else {
                list = listOf;
            }
            hd.a.j(iO > 0, "childAtomSize should be positive");
            int iO2 = c0Var.o();
            if (iO2 == 1635148611) {
                hd.a.i(str5 == null);
                c0Var.S(iE2 + 8);
                id.a aVarB = id.a.b(c0Var);
                list2 = aVarB.f32132a;
                cVar.f43124c = aVarB.f32133b;
                if (!z10) {
                    fP = aVarB.f32136e;
                }
                str2 = aVarB.f32137f;
                str3 = w.f31190j;
            } else if (iO2 == 1752589123) {
                hd.a.i(str5 == null);
                c0Var.S(iE2 + 8);
                id.e eVarA = id.e.a(c0Var);
                list2 = eVarA.f32176a;
                cVar.f43124c = eVarA.f32177b;
                str2 = eVarA.f32178c;
                str3 = w.f31192k;
            } else {
                if (iO2 == 1685480259 || iO2 == 1685485123) {
                    id.c cVarA = id.c.a(c0Var);
                    if (cVarA != null) {
                        str4 = cVarA.f32158c;
                        str5 = w.f31216w;
                    }
                } else {
                    if (iO2 == 1987076931) {
                        hd.a.i(str5 == null);
                        str = iIntValue == 1987063864 ? w.f31194l : w.f31196m;
                    } else if (iO2 == 1635135811) {
                        hd.a.i(str5 == null);
                        str = w.f31198n;
                    } else if (iO2 == 1681012275) {
                        hd.a.i(str5 == null);
                        str = w.f31188i;
                    } else {
                        if (iO2 == 1702061171) {
                            hd.a.i(str5 == null);
                            Pair<String, byte[]> pairH = h(c0Var, iE2);
                            String str6 = (String) pairH.first;
                            byte[] bArr = (byte[]) pairH.second;
                            listOf = bArr != null ? ImmutableList.of(bArr) : list;
                            str5 = str6;
                        } else if (iO2 == 1885434736) {
                            listOf = list;
                            fP = p(c0Var, iE2);
                            z10 = true;
                        } else if (iO2 == 1937126244) {
                            listOf = list;
                            bArrQ = q(c0Var, iE2, iO);
                        } else if (iO2 == 1936995172) {
                            int iG = c0Var.G();
                            c0Var.T(3);
                            if (iG == 0) {
                                int iG2 = c0Var.G();
                                if (iG2 == 0) {
                                    listOf = list;
                                    i18 = 0;
                                } else if (iG2 == 1) {
                                    listOf = list;
                                    i18 = 1;
                                } else if (iG2 == 2) {
                                    listOf = list;
                                    i18 = 2;
                                } else if (iG2 == 3) {
                                    listOf = list;
                                    i18 = 3;
                                }
                            }
                        }
                        iE += iO;
                        i16 = i11;
                        i17 = i12;
                        drmInitDataE = drmInitData2;
                    }
                    listOf = list;
                    str5 = str;
                    iE += iO;
                    i16 = i11;
                    i17 = i12;
                    drmInitDataE = drmInitData2;
                }
                listOf = list;
                iE += iO;
                i16 = i11;
                i17 = i12;
                drmInitDataE = drmInitData2;
            }
            listOf = list2;
            str5 = str3;
            str4 = str2;
            iE += iO;
            i16 = i11;
            i17 = i12;
            drmInitDataE = drmInitData2;
        }
        if (str5 == null) {
            return;
        }
        cVar.f43123b = new Format.b().R(i13).e0(str5).I(str4).j0(iM).Q(iM2).a0(fP).d0(i14).b0(bArrQ).h0(i18).T(list).L(drmInitData2).E();
    }

    public static boolean a(long[] jArr, long j10, long j11, long j12) {
        int length = jArr.length - 1;
        return jArr[0] <= j11 && j11 < jArr[u0.t(4, 0, length)] && jArr[u0.t(jArr.length - 4, 0, length)] < j12 && j12 <= j10;
    }

    public static int b(c0 c0Var, int i10, int i11) {
        int iE = c0Var.e();
        while (iE - i10 < i11) {
            c0Var.S(iE);
            int iO = c0Var.o();
            hd.a.j(iO > 0, "childAtomSize should be positive");
            if (c0Var.o() == 1702061171) {
                return iE;
            }
            iE += iO;
        }
        return -1;
    }

    public static int c(int i10) {
        if (i10 == 1936684398) {
            return 1;
        }
        if (i10 == 1986618469) {
            return 2;
        }
        if (i10 == 1952807028 || i10 == 1935832172 || i10 == 1937072756 || i10 == 1668047728) {
            return 3;
        }
        return i10 == 1835365473 ? 5 : -1;
    }

    public static void d(c0 c0Var) {
        int iE = c0Var.e();
        c0Var.T(4);
        if (c0Var.o() != 1751411826) {
            iE += 4;
        }
        c0Var.S(iE);
    }

    /* JADX WARN: Removed duplicated region for block: B:90:0x0136  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void e(hd.c0 r20, int r21, int r22, int r23, int r24, java.lang.String r25, boolean r26, @g.p0 com.google.android.exoplayer2.drm.DrmInitData r27, ob.b.c r28, int r29) throws com.google.android.exoplayer2.ParserException {
        /*
            Method dump skipped, instruction units count: 717
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ob.b.e(hd.c0, int, int, int, int, java.lang.String, boolean, com.google.android.exoplayer2.drm.DrmInitData, ob.b$c, int):void");
    }

    @p0
    public static Pair<Integer, p> f(c0 c0Var, int i10, int i11) {
        int i12 = i10 + 8;
        String strD = null;
        Integer numValueOf = null;
        int i13 = -1;
        int i14 = 0;
        while (i12 - i10 < i11) {
            c0Var.S(i12);
            int iO = c0Var.o();
            int iO2 = c0Var.o();
            if (iO2 == 1718775137) {
                numValueOf = Integer.valueOf(c0Var.o());
            } else if (iO2 == 1935894637) {
                c0Var.T(4);
                strD = c0Var.D(4);
            } else if (iO2 == 1935894633) {
                i13 = i12;
                i14 = iO;
            }
            i12 += iO;
        }
        if (!"cenc".equals(strD) && !ya.g.E1.equals(strD) && !ya.g.F1.equals(strD) && !ya.g.G1.equals(strD)) {
            return null;
        }
        hd.a.l(numValueOf, "frma atom is mandatory");
        hd.a.j(i13 != -1, "schi atom is mandatory");
        return Pair.create(numValueOf, (p) hd.a.l(s(c0Var, i13, i14, strD), "tenc atom is mandatory"));
    }

    @p0
    public static Pair<long[], long[]> g(a.C0485a c0485a) {
        a.b bVarH = c0485a.h(ob.a.f43060l0);
        if (bVarH == null) {
            return null;
        }
        c0 c0Var = bVarH.f43100s1;
        c0Var.S(8);
        int iC = ob.a.c(c0Var.o());
        int iK = c0Var.K();
        long[] jArr = new long[iK];
        long[] jArr2 = new long[iK];
        for (int i10 = 0; i10 < iK; i10++) {
            jArr[i10] = iC == 1 ? c0Var.L() : c0Var.I();
            jArr2[i10] = iC == 1 ? c0Var.z() : c0Var.o();
            if (c0Var.C() != 1) {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
            c0Var.T(2);
        }
        return Pair.create(jArr, jArr2);
    }

    public static Pair<String, byte[]> h(c0 c0Var, int i10) {
        c0Var.S(i10 + 8 + 4);
        c0Var.T(1);
        i(c0Var);
        c0Var.T(2);
        int iG = c0Var.G();
        if ((iG & 128) != 0) {
            c0Var.T(2);
        }
        if ((iG & 64) != 0) {
            c0Var.T(c0Var.M());
        }
        if ((iG & 32) != 0) {
            c0Var.T(2);
        }
        c0Var.T(1);
        i(c0Var);
        String strH = w.h(c0Var.G());
        if (w.D.equals(strH) || w.O.equals(strH) || w.P.equals(strH)) {
            return Pair.create(strH, null);
        }
        c0Var.T(12);
        c0Var.T(1);
        int i11 = i(c0Var);
        byte[] bArr = new byte[i11];
        c0Var.k(bArr, 0, i11);
        return Pair.create(strH, bArr);
    }

    public static int i(c0 c0Var) {
        int iG = c0Var.G();
        int i10 = iG & 127;
        while ((iG & 128) == 128) {
            iG = c0Var.G();
            i10 = (i10 << 7) | (iG & 127);
        }
        return i10;
    }

    public static int j(c0 c0Var) {
        c0Var.S(16);
        return c0Var.o();
    }

    @p0
    public static Metadata k(c0 c0Var, int i10) {
        c0Var.T(8);
        ArrayList arrayList = new ArrayList();
        while (c0Var.e() < i10) {
            Metadata.Entry entryC = h.c(c0Var);
            if (entryC != null) {
                arrayList.add(entryC);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    public static Pair<Long, String> l(c0 c0Var) {
        c0Var.S(8);
        int iC = ob.a.c(c0Var.o());
        c0Var.T(iC == 0 ? 8 : 16);
        long jI = c0Var.I();
        c0Var.T(iC == 0 ? 4 : 8);
        int iM = c0Var.M();
        return Pair.create(Long.valueOf(jI), "" + ((char) (((iM >> 10) & 31) + 96)) + ((char) (((iM >> 5) & 31) + 96)) + ((char) ((iM & 31) + 96)));
    }

    @p0
    public static Metadata m(a.C0485a c0485a) {
        a.b bVarH = c0485a.h(ob.a.f43066n0);
        a.b bVarH2 = c0485a.h(ob.a.Z0);
        a.b bVarH3 = c0485a.h(ob.a.f43028a1);
        if (bVarH == null || bVarH2 == null || bVarH3 == null || j(bVarH.f43100s1) != 1835299937) {
            return null;
        }
        c0 c0Var = bVarH2.f43100s1;
        c0Var.S(12);
        int iO = c0Var.o();
        String[] strArr = new String[iO];
        for (int i10 = 0; i10 < iO; i10++) {
            int iO2 = c0Var.o();
            c0Var.T(4);
            strArr[i10] = c0Var.D(iO2 - 8);
        }
        c0 c0Var2 = bVarH3.f43100s1;
        c0Var2.S(8);
        ArrayList arrayList = new ArrayList();
        while (c0Var2.a() > 8) {
            int iE = c0Var2.e();
            int iO3 = c0Var2.o();
            int iO4 = c0Var2.o() - 1;
            if (iO4 < 0 || iO4 >= iO) {
                t.n(f43101a, "Skipped metadata with unknown key index: " + iO4);
            } else {
                MdtaMetadataEntry mdtaMetadataEntryF = h.f(c0Var2, iE + iO3, strArr[iO4]);
                if (mdtaMetadataEntryF != null) {
                    arrayList.add(mdtaMetadataEntryF);
                }
            }
            c0Var2.S(iE + iO3);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    public static void n(c0 c0Var, int i10, int i11, int i12, c cVar) {
        c0Var.S(i11 + 8 + 8);
        if (i10 == 1835365492) {
            c0Var.A();
            String strA = c0Var.A();
            if (strA != null) {
                cVar.f43123b = new Format.b().R(i12).e0(strA).E();
            }
        }
    }

    public static long o(c0 c0Var) {
        c0Var.S(8);
        c0Var.T(ob.a.c(c0Var.o()) != 0 ? 16 : 8);
        return c0Var.I();
    }

    public static float p(c0 c0Var, int i10) {
        c0Var.S(i10 + 8);
        return c0Var.K() / c0Var.K();
    }

    @p0
    public static byte[] q(c0 c0Var, int i10, int i11) {
        int i12 = i10 + 8;
        while (i12 - i10 < i11) {
            c0Var.S(i12);
            int iO = c0Var.o();
            if (c0Var.o() == 1886547818) {
                return Arrays.copyOfRange(c0Var.d(), i12, iO + i12);
            }
            i12 += iO;
        }
        return null;
    }

    @p0
    public static Pair<Integer, p> r(c0 c0Var, int i10, int i11) {
        Pair<Integer, p> pairF;
        int iE = c0Var.e();
        while (iE - i10 < i11) {
            c0Var.S(iE);
            int iO = c0Var.o();
            hd.a.j(iO > 0, "childAtomSize should be positive");
            if (c0Var.o() == 1936289382 && (pairF = f(c0Var, iE, iO)) != null) {
                return pairF;
            }
            iE += iO;
        }
        return null;
    }

    @p0
    public static p s(c0 c0Var, int i10, int i11, String str) {
        int i12;
        int i13;
        int i14 = i10 + 8;
        while (true) {
            byte[] bArr = null;
            if (i14 - i10 >= i11) {
                return null;
            }
            c0Var.S(i14);
            int iO = c0Var.o();
            if (c0Var.o() == 1952804451) {
                int iC = ob.a.c(c0Var.o());
                c0Var.T(1);
                if (iC == 0) {
                    c0Var.T(1);
                    i13 = 0;
                    i12 = 0;
                } else {
                    int iG = c0Var.G();
                    i12 = iG & 15;
                    i13 = (iG & 240) >> 4;
                }
                boolean z10 = c0Var.G() == 1;
                int iG2 = c0Var.G();
                byte[] bArr2 = new byte[16];
                c0Var.k(bArr2, 0, 16);
                if (z10 && iG2 == 0) {
                    int iG3 = c0Var.G();
                    bArr = new byte[iG3];
                    c0Var.k(bArr, 0, iG3);
                }
                return new p(z10, str, iG2, bArr2, i13, i12, bArr);
            }
            i14 += iO;
        }
    }

    @p0
    public static Metadata t(c0 c0Var, int i10) {
        c0Var.T(12);
        while (c0Var.e() < i10) {
            int iE = c0Var.e();
            int iO = c0Var.o();
            if (c0Var.o() == 1935766900) {
                if (iO < 14) {
                    return null;
                }
                c0Var.T(5);
                int iG = c0Var.G();
                if (iG != 12 && iG != 13) {
                    return null;
                }
                float f10 = iG == 12 ? 240.0f : 120.0f;
                c0Var.T(1);
                return new Metadata(new SmtaMetadataEntry(f10, c0Var.G()));
            }
            c0Var.S(iE + iO);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0136  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static ob.r u(ob.o r38, ob.a.C0485a r39, hb.w r40) throws com.google.android.exoplayer2.ParserException {
        /*
            Method dump skipped, instruction units count: 1299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ob.b.u(ob.o, ob.a$a, hb.w):ob.r");
    }

    public static c v(c0 c0Var, int i10, int i11, String str, @p0 DrmInitData drmInitData, boolean z10) throws ParserException {
        int i12;
        c0Var.S(12);
        int iO = c0Var.o();
        c cVar = new c(iO);
        for (int i13 = 0; i13 < iO; i13++) {
            int iE = c0Var.e();
            int iO2 = c0Var.o();
            hd.a.j(iO2 > 0, "childAtomSize should be positive");
            int iO3 = c0Var.o();
            if (iO3 == 1635148593 || iO3 == 1635148595 || iO3 == 1701733238 || iO3 == 1831958048 || iO3 == 1836070006 || iO3 == 1752589105 || iO3 == 1751479857 || iO3 == 1932670515 || iO3 == 1987063864 || iO3 == 1987063865 || iO3 == 1635135537 || iO3 == 1685479798 || iO3 == 1685479729 || iO3 == 1685481573 || iO3 == 1685481521) {
                i12 = iE;
                C(c0Var, iO3, i12, iO2, i10, i11, drmInitData, cVar, i13);
            } else if (iO3 == 1836069985 || iO3 == 1701733217 || iO3 == 1633889587 || iO3 == 1700998451 || iO3 == 1633889588 || iO3 == 1685353315 || iO3 == 1685353317 || iO3 == 1685353320 || iO3 == 1685353324 || iO3 == 1935764850 || iO3 == 1935767394 || iO3 == 1819304813 || iO3 == 1936684916 || iO3 == 1953984371 || iO3 == 778924082 || iO3 == 778924083 || iO3 == 1634492771 || iO3 == 1634492791 || iO3 == 1970037111 || iO3 == 1332770163 || iO3 == 1716281667) {
                i12 = iE;
                e(c0Var, iO3, iE, iO2, i10, str, z10, drmInitData, cVar, i13);
            } else {
                if (iO3 == 1414810956 || iO3 == 1954034535 || iO3 == 2004251764 || iO3 == 1937010800 || iO3 == 1664495672) {
                    w(c0Var, iO3, iE, iO2, i10, str, cVar);
                } else if (iO3 == 1835365492) {
                    n(c0Var, iO3, iE, i10, cVar);
                } else if (iO3 == 1667329389) {
                    cVar.f43123b = new Format.b().R(i10).e0(w.f31217w0).E();
                }
                i12 = iE;
            }
            c0Var.S(i12 + iO2);
        }
        return cVar;
    }

    public static void w(c0 c0Var, int i10, int i11, int i12, int i13, String str, c cVar) {
        c0Var.S(i11 + 8 + 8);
        String str2 = w.f31201o0;
        ImmutableList immutableListOf = null;
        long j10 = Long.MAX_VALUE;
        if (i10 != 1414810956) {
            if (i10 == 1954034535) {
                int i14 = (i12 - 8) - 8;
                byte[] bArr = new byte[i14];
                c0Var.k(bArr, 0, i14);
                immutableListOf = ImmutableList.of(bArr);
                str2 = w.f31203p0;
            } else if (i10 == 2004251764) {
                str2 = w.f31205q0;
            } else if (i10 == 1937010800) {
                j10 = 0;
            } else {
                if (i10 != 1664495672) {
                    throw new IllegalStateException();
                }
                cVar.f43125d = 1;
                str2 = w.f31207r0;
            }
        }
        cVar.f43123b = new Format.b().R(i13).e0(str2).V(str).i0(j10).T(immutableListOf).E();
    }

    public static f x(c0 c0Var) {
        boolean z10;
        c0Var.S(8);
        int iC = ob.a.c(c0Var.o());
        c0Var.T(iC == 0 ? 8 : 16);
        int iO = c0Var.o();
        c0Var.T(4);
        int iE = c0Var.e();
        int i10 = iC == 0 ? 4 : 8;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            if (i12 >= i10) {
                z10 = true;
                break;
            }
            if (c0Var.d()[iE + i12] != -1) {
                z10 = false;
                break;
            }
            i12++;
        }
        long j10 = ya.g.f56663b;
        if (z10) {
            c0Var.T(i10);
        } else {
            long jI = iC == 0 ? c0Var.I() : c0Var.L();
            if (jI != 0) {
                j10 = jI;
            }
        }
        c0Var.T(16);
        int iO2 = c0Var.o();
        int iO3 = c0Var.o();
        c0Var.T(4);
        int iO4 = c0Var.o();
        int iO5 = c0Var.o();
        if (iO2 == 0 && iO3 == 65536 && iO4 == -65536 && iO5 == 0) {
            i11 = 90;
        } else if (iO2 == 0 && iO3 == -65536 && iO4 == 65536 && iO5 == 0) {
            i11 = 270;
        } else if (iO2 == -65536 && iO3 == 0 && iO4 == 0 && iO5 == -65536) {
            i11 = 180;
        }
        return new f(iO, j10, i11);
    }

    @p0
    public static o y(a.C0485a c0485a, a.b bVar, long j10, @p0 DrmInitData drmInitData, boolean z10, boolean z11) throws ParserException {
        a.b bVar2;
        long j11;
        long[] jArr;
        long[] jArr2;
        a.C0485a c0485aG;
        Pair<long[], long[]> pairG;
        a.C0485a c0485a2 = (a.C0485a) hd.a.g(c0485a.g(ob.a.f43030b0));
        int iC = c(j(((a.b) hd.a.g(c0485a2.h(ob.a.f43066n0))).f43100s1));
        if (iC == -1) {
            return null;
        }
        f fVarX = x(((a.b) hd.a.g(c0485a.h(ob.a.f43054j0))).f43100s1);
        long jH1 = ya.g.f56663b;
        if (j10 == ya.g.f56663b) {
            bVar2 = bVar;
            j11 = fVarX.f43135b;
        } else {
            bVar2 = bVar;
            j11 = j10;
        }
        long jO = o(bVar2.f43100s1);
        if (j11 != ya.g.f56663b) {
            jH1 = u0.h1(j11, 1000000L, jO);
        }
        long j12 = jH1;
        a.C0485a c0485a3 = (a.C0485a) hd.a.g(((a.C0485a) hd.a.g(c0485a2.g(ob.a.f43033c0))).g(ob.a.f43036d0));
        Pair<Long, String> pairL = l(((a.b) hd.a.g(c0485a2.h(ob.a.f43063m0))).f43100s1);
        c cVarV = v(((a.b) hd.a.g(c0485a3.h(ob.a.f43069o0))).f43100s1, fVarX.f43134a, fVarX.f43136c, (String) pairL.second, drmInitData, z11);
        if (z10 || (c0485aG = c0485a.g(ob.a.f43057k0)) == null || (pairG = g(c0485aG)) == null) {
            jArr = null;
            jArr2 = null;
        } else {
            long[] jArr3 = (long[]) pairG.first;
            jArr2 = (long[]) pairG.second;
            jArr = jArr3;
        }
        if (cVarV.f43123b == null) {
            return null;
        }
        return new o(fVarX.f43134a, iC, ((Long) pairL.first).longValue(), jO, j12, cVarV.f43123b, cVarV.f43125d, cVarV.f43122a, cVarV.f43124c, jArr, jArr2);
    }

    public static List<r> z(a.C0485a c0485a, hb.w wVar, long j10, @p0 DrmInitData drmInitData, boolean z10, boolean z11, Function<o, o> function) throws ParserException {
        o oVarApply;
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < c0485a.f43099u1.size(); i10++) {
            a.C0485a c0485a2 = c0485a.f43099u1.get(i10);
            if (c0485a2.f43096a == 1953653099 && (oVarApply = function.apply(y(c0485a2, (a.b) hd.a.g(c0485a.h(ob.a.Z)), j10, drmInitData, z10, z11))) != null) {
                arrayList.add(u(oVarApply, (a.C0485a) hd.a.g(((a.C0485a) hd.a.g(((a.C0485a) hd.a.g(c0485a2.g(ob.a.f43030b0))).g(ob.a.f43033c0))).g(ob.a.f43036d0)), wVar));
            }
        }
        return arrayList;
    }
}
