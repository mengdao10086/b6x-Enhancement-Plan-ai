package is;

import gm.c0;
import gm.f0;
import gm.f2;
import gm.j2;
import gm.t;
import gm.w;
import java.util.Vector;

/* JADX INFO: loaded from: classes6.dex */
public class a extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c0 f35751a;

    public a(f0 f0Var) {
        f0 f0Var2 = (f0) f0Var.K(0);
        int[] iArr = new int[f0Var2.size()];
        for (int i10 = 0; i10 < f0Var2.size(); i10++) {
            iArr[i10] = x(f0Var2.K(i10));
        }
        f0 f0Var3 = (f0) f0Var.K(1);
        int size = f0Var3.size();
        byte[][] bArr = new byte[size][];
        for (int i11 = 0; i11 < size; i11++) {
            bArr[i11] = ((f2) f0Var3.K(i11)).J();
        }
        f0 f0Var4 = (f0) f0Var.K(2);
        int size2 = f0Var4.size();
        byte[][] bArr2 = new byte[size2][];
        for (int i12 = 0; i12 < size2; i12++) {
            bArr2[i12] = ((f2) f0Var4.K(i12)).J();
        }
        f0 f0Var5 = (f0) f0Var.K(3);
        int size3 = f0Var5.size();
        byte[][][] bArr3 = new byte[size3][][];
        for (int i13 = 0; i13 < size3; i13++) {
            f0 f0Var6 = (f0) f0Var5.K(i13);
            bArr3[i13] = new byte[f0Var6.size()][];
            for (int i14 = 0; i14 < bArr3[i13].length; i14++) {
                bArr3[i13][i14] = ((f2) f0Var6.K(i14)).J();
            }
        }
        f0 f0Var7 = (f0) f0Var.K(4);
        int size4 = f0Var7.size();
        byte[][][] bArr4 = new byte[size4][][];
        for (int i15 = 0; i15 < size4; i15++) {
            f0 f0Var8 = (f0) f0Var7.K(i15);
            bArr4[i15] = new byte[f0Var8.size()][];
            for (int i16 = 0; i16 < bArr4[i15].length; i16++) {
                bArr4[i15][i16] = ((f2) f0Var8.K(i16)).J();
            }
        }
        ks.n[][] nVarArr = new ks.n[((f0) f0Var.K(5)).size()][];
    }

    public a(int[] iArr, byte[][] bArr, byte[][] bArr2, byte[][][] bArr3, byte[][][] bArr4, ks.n[][] nVarArr, ks.n[][] nVarArr2, Vector[] vectorArr, Vector[] vectorArr2, Vector[][] vectorArr3, Vector[][] vectorArr4, byte[][][] bArr5, ks.e[] eVarArr, ks.e[] eVarArr2, ks.e[] eVarArr3, int[] iArr2, byte[][] bArr6, ks.i[] iVarArr, byte[][] bArr7, ks.j[] jVarArr, ks.f fVar, zn.b bVar) {
        this.f35751a = y(iArr, bArr, bArr2, bArr3, bArr4, bArr5, nVarArr, nVarArr2, vectorArr, vectorArr2, vectorArr3, vectorArr4, eVarArr, eVarArr2, eVarArr3, iArr2, bArr6, iVarArr, bArr7, jVarArr, fVar, new zn.b[]{bVar});
    }

    public static int x(gm.h hVar) {
        return ((t) hVar).Q();
    }

    @Override // gm.w, gm.h
    public c0 b() {
        return this.f35751a;
    }

    public final c0 y(int[] iArr, byte[][] bArr, byte[][] bArr2, byte[][][] bArr3, byte[][][] bArr4, byte[][][] bArr5, ks.n[][] nVarArr, ks.n[][] nVarArr2, Vector[] vectorArr, Vector[] vectorArr2, Vector[][] vectorArr3, Vector[][] vectorArr4, ks.e[] eVarArr, ks.e[] eVarArr2, ks.e[] eVarArr3, int[] iArr2, byte[][] bArr6, ks.i[] iVarArr, byte[][] bArr7, ks.j[] jVarArr, ks.f fVar, zn.b[] bVarArr) {
        ks.n[][] nVarArr3 = nVarArr;
        gm.i iVar = new gm.i();
        gm.i iVar2 = new gm.i();
        for (int i10 : iArr) {
            iVar2.a(new t(i10));
        }
        iVar.a(new j2(iVar2));
        gm.i iVar3 = new gm.i();
        for (byte[] bArr8 : bArr) {
            iVar3.a(new f2(bArr8));
        }
        iVar.a(new j2(iVar3));
        gm.i iVar4 = new gm.i();
        for (byte[] bArr9 : bArr2) {
            iVar4.a(new f2(bArr9));
        }
        iVar.a(new j2(iVar4));
        gm.i iVar5 = new gm.i();
        gm.i iVar6 = new gm.i();
        for (int i11 = 0; i11 < bArr3.length; i11++) {
            for (int i12 = 0; i12 < bArr3[i11].length; i12++) {
                iVar5.a(new f2(bArr3[i11][i12]));
            }
            iVar6.a(new j2(iVar5));
            iVar5 = new gm.i();
        }
        iVar.a(new j2(iVar6));
        gm.i iVar7 = new gm.i();
        gm.i iVar8 = new gm.i();
        for (int i13 = 0; i13 < bArr4.length; i13++) {
            for (int i14 = 0; i14 < bArr4[i13].length; i14++) {
                iVar7.a(new f2(bArr4[i13][i14]));
            }
            iVar8.a(new j2(iVar7));
            iVar7 = new gm.i();
        }
        iVar.a(new j2(iVar8));
        gm.i iVar9 = new gm.i();
        gm.i iVar10 = new gm.i();
        gm.i iVar11 = new gm.i();
        gm.i iVar12 = new gm.i();
        gm.i iVar13 = new gm.i();
        int i15 = 0;
        while (i15 < nVarArr3.length) {
            int i16 = 0;
            while (i16 < nVarArr3[i15].length) {
                iVar11.a(new j2(bVarArr[0]));
                int i17 = nVarArr3[i15][i16].g()[1];
                iVar12.a(new f2(nVarArr3[i15][i16].f()[0]));
                iVar12.a(new f2(nVarArr3[i15][i16].f()[1]));
                iVar12.a(new f2(nVarArr3[i15][i16].f()[2]));
                for (int i18 = 0; i18 < i17; i18++) {
                    iVar12.a(new f2(nVarArr3[i15][i16].f()[i18 + 3]));
                }
                iVar11.a(new j2(iVar12));
                iVar12 = new gm.i();
                iVar13.a(new t(nVarArr3[i15][i16].g()[0]));
                iVar13.a(new t(i17));
                iVar13.a(new t(nVarArr3[i15][i16].g()[2]));
                iVar13.a(new t(nVarArr3[i15][i16].g()[3]));
                iVar13.a(new t(nVarArr3[i15][i16].g()[4]));
                iVar13.a(new t(nVarArr3[i15][i16].g()[5]));
                int i19 = 0;
                while (i19 < i17) {
                    iVar13.a(new t(nVarArr3[i15][i16].g()[i19 + 6]));
                    i19++;
                    nVarArr3 = nVarArr;
                }
                iVar11.a(new j2(iVar13));
                iVar13 = new gm.i();
                iVar10.a(new j2(iVar11));
                iVar11 = new gm.i();
                i16++;
                nVarArr3 = nVarArr;
            }
            iVar9.a(new j2(iVar10));
            iVar10 = new gm.i();
            i15++;
            nVarArr3 = nVarArr;
        }
        iVar.a(new j2(iVar9));
        gm.i iVar14 = new gm.i();
        gm.i iVar15 = new gm.i();
        gm.i iVar16 = new gm.i();
        gm.i iVar17 = new gm.i();
        gm.i iVar18 = new gm.i();
        for (int i20 = 0; i20 < nVarArr2.length; i20++) {
            for (int i21 = 0; i21 < nVarArr2[i20].length; i21++) {
                iVar16.a(new j2(bVarArr[0]));
                int i22 = nVarArr2[i20][i21].g()[1];
                iVar17.a(new f2(nVarArr2[i20][i21].f()[0]));
                iVar17.a(new f2(nVarArr2[i20][i21].f()[1]));
                iVar17.a(new f2(nVarArr2[i20][i21].f()[2]));
                for (int i23 = 0; i23 < i22; i23++) {
                    iVar17.a(new f2(nVarArr2[i20][i21].f()[i23 + 3]));
                }
                iVar16.a(new j2(iVar17));
                iVar17 = new gm.i();
                iVar18.a(new t(nVarArr2[i20][i21].g()[0]));
                iVar18.a(new t(i22));
                iVar18.a(new t(nVarArr2[i20][i21].g()[2]));
                iVar18.a(new t(nVarArr2[i20][i21].g()[3]));
                iVar18.a(new t(nVarArr2[i20][i21].g()[4]));
                iVar18.a(new t(nVarArr2[i20][i21].g()[5]));
                for (int i24 = 0; i24 < i22; i24++) {
                    iVar18.a(new t(nVarArr2[i20][i21].g()[i24 + 6]));
                }
                iVar16.a(new j2(iVar18));
                iVar18 = new gm.i();
                iVar15.a(new j2(iVar16));
                iVar16 = new gm.i();
            }
            iVar14.a(new j2(new j2(iVar15)));
            iVar15 = new gm.i();
        }
        iVar.a(new j2(iVar14));
        gm.i iVar19 = new gm.i();
        gm.i iVar20 = new gm.i();
        for (int i25 = 0; i25 < bArr5.length; i25++) {
            for (int i26 = 0; i26 < bArr5[i25].length; i26++) {
                iVar19.a(new f2(bArr5[i25][i26]));
            }
            iVar20.a(new j2(iVar19));
            iVar19 = new gm.i();
        }
        iVar.a(new j2(iVar20));
        gm.i iVar21 = new gm.i();
        gm.i iVar22 = new gm.i();
        for (int i27 = 0; i27 < vectorArr.length; i27++) {
            for (int i28 = 0; i28 < vectorArr[i27].size(); i28++) {
                iVar21.a(new f2((byte[]) vectorArr[i27].elementAt(i28)));
            }
            iVar22.a(new j2(iVar21));
            iVar21 = new gm.i();
        }
        iVar.a(new j2(iVar22));
        gm.i iVar23 = new gm.i();
        gm.i iVar24 = new gm.i();
        for (int i29 = 0; i29 < vectorArr2.length; i29++) {
            for (int i30 = 0; i30 < vectorArr2[i29].size(); i30++) {
                iVar23.a(new f2((byte[]) vectorArr2[i29].elementAt(i30)));
            }
            iVar24.a(new j2(iVar23));
            iVar23 = new gm.i();
        }
        iVar.a(new j2(iVar24));
        gm.i iVar25 = new gm.i();
        gm.i iVar26 = new gm.i();
        gm.i iVar27 = new gm.i();
        for (int i31 = 0; i31 < vectorArr3.length; i31++) {
            for (int i32 = 0; i32 < vectorArr3[i31].length; i32++) {
                for (int i33 = 0; i33 < vectorArr3[i31][i32].size(); i33++) {
                    iVar25.a(new f2((byte[]) vectorArr3[i31][i32].elementAt(i33)));
                }
                iVar26.a(new j2(iVar25));
                iVar25 = new gm.i();
            }
            iVar27.a(new j2(iVar26));
            iVar26 = new gm.i();
        }
        iVar.a(new j2(iVar27));
        gm.i iVar28 = new gm.i();
        gm.i iVar29 = new gm.i();
        gm.i iVar30 = new gm.i();
        for (int i34 = 0; i34 < vectorArr4.length; i34++) {
            for (int i35 = 0; i35 < vectorArr4[i34].length; i35++) {
                for (int i36 = 0; i36 < vectorArr4[i34][i35].size(); i36++) {
                    iVar28.a(new f2((byte[]) vectorArr4[i34][i35].elementAt(i36)));
                }
                iVar29.a(new j2(iVar28));
                iVar28 = new gm.i();
            }
            iVar30.a(new j2(iVar29));
            iVar29 = new gm.i();
        }
        iVar.a(new j2(iVar30));
        gm.i iVar31 = new gm.i();
        gm.i iVar32 = new gm.i();
        gm.i iVar33 = new gm.i();
        gm.i iVar34 = new gm.i();
        for (int i37 = 0; i37 < eVarArr.length; i37++) {
            iVar32.a(new j2(bVarArr[0]));
            byte[][] bArrC = eVarArr[i37].c();
            iVar33.a(new f2(bArrC[0]));
            iVar33.a(new f2(bArrC[1]));
            iVar33.a(new f2(bArrC[2]));
            iVar33.a(new f2(bArrC[3]));
            iVar32.a(new j2(iVar33));
            iVar33 = new gm.i();
            int[] iArrD = eVarArr[i37].d();
            iVar34.a(new t(iArrD[0]));
            iVar34.a(new t(iArrD[1]));
            iVar34.a(new t(iArrD[2]));
            iVar34.a(new t(iArrD[3]));
            iVar32.a(new j2(iVar34));
            iVar34 = new gm.i();
            iVar31.a(new j2(iVar32));
            iVar32 = new gm.i();
        }
        iVar.a(new j2(iVar31));
        gm.i iVar35 = new gm.i();
        gm.i iVar36 = new gm.i();
        gm.i iVar37 = new gm.i();
        gm.i iVar38 = new gm.i();
        for (int i38 = 0; i38 < eVarArr2.length; i38++) {
            iVar36.a(new j2(bVarArr[0]));
            byte[][] bArrC2 = eVarArr2[i38].c();
            iVar37.a(new f2(bArrC2[0]));
            iVar37.a(new f2(bArrC2[1]));
            iVar37.a(new f2(bArrC2[2]));
            iVar37.a(new f2(bArrC2[3]));
            iVar36.a(new j2(iVar37));
            iVar37 = new gm.i();
            int[] iArrD2 = eVarArr2[i38].d();
            iVar38.a(new t(iArrD2[0]));
            iVar38.a(new t(iArrD2[1]));
            iVar38.a(new t(iArrD2[2]));
            iVar38.a(new t(iArrD2[3]));
            iVar36.a(new j2(iVar38));
            iVar38 = new gm.i();
            iVar35.a(new j2(iVar36));
            iVar36 = new gm.i();
        }
        iVar.a(new j2(iVar35));
        gm.i iVar39 = new gm.i();
        gm.i iVar40 = new gm.i();
        gm.i iVar41 = new gm.i();
        gm.i iVar42 = new gm.i();
        gm.i iVar43 = iVar;
        for (int i39 = 0; i39 < eVarArr3.length; i39++) {
            iVar40.a(new j2(bVarArr[0]));
            byte[][] bArrC3 = eVarArr3[i39].c();
            iVar41.a(new f2(bArrC3[0]));
            iVar41.a(new f2(bArrC3[1]));
            iVar41.a(new f2(bArrC3[2]));
            iVar41.a(new f2(bArrC3[3]));
            iVar40.a(new j2(iVar41));
            iVar41 = new gm.i();
            int[] iArrD3 = eVarArr3[i39].d();
            iVar42.a(new t(iArrD3[0]));
            iVar42.a(new t(iArrD3[1]));
            iVar42.a(new t(iArrD3[2]));
            iVar42.a(new t(iArrD3[3]));
            iVar40.a(new j2(iVar42));
            iVar42 = new gm.i();
            iVar39.a(new j2(iVar40));
            iVar40 = new gm.i();
        }
        iVar43.a(new j2(iVar39));
        gm.i iVar44 = new gm.i();
        for (int i40 : iArr2) {
            iVar44.a(new t(i40));
        }
        iVar43.a(new j2(iVar44));
        gm.i iVar45 = new gm.i();
        for (byte[] bArr10 : bArr6) {
            iVar45.a(new f2(bArr10));
        }
        iVar43.a(new j2(iVar45));
        gm.i iVar46 = new gm.i();
        gm.i iVar47 = new gm.i();
        new gm.i();
        gm.i iVar48 = new gm.i();
        gm.i iVar49 = new gm.i();
        gm.i iVar50 = new gm.i();
        gm.i iVar51 = new gm.i();
        int i41 = 0;
        while (i41 < iVarArr.length) {
            iVar47.a(new j2(bVarArr[0]));
            new gm.i();
            int i42 = iVarArr[i41].f()[0];
            int i43 = iVarArr[i41].f()[7];
            iVar48.a(new f2(iVarArr[i41].e()[0]));
            int i44 = 0;
            while (i44 < i42) {
                i44++;
                iVar48.a(new f2(iVarArr[i41].e()[i44]));
            }
            for (int i45 = 0; i45 < i43; i45++) {
                iVar48.a(new f2(iVarArr[i41].e()[i42 + 1 + i45]));
            }
            iVar47.a(new j2(iVar48));
            gm.i iVar52 = new gm.i();
            iVar49.a(new t(i42));
            iVar49.a(new t(iVarArr[i41].f()[1]));
            iVar49.a(new t(iVarArr[i41].f()[2]));
            iVar49.a(new t(iVarArr[i41].f()[3]));
            iVar49.a(new t(iVarArr[i41].f()[4]));
            iVar49.a(new t(iVarArr[i41].f()[5]));
            iVar49.a(new t(iVarArr[i41].f()[6]));
            iVar49.a(new t(i43));
            for (int i46 = 0; i46 < i42; i46++) {
                iVar49.a(new t(iVarArr[i41].f()[i46 + 8]));
            }
            for (int i47 = 0; i47 < i43; i47++) {
                iVar49.a(new t(iVarArr[i41].f()[i42 + 8 + i47]));
            }
            iVar47.a(new j2(iVar49));
            gm.i iVar53 = new gm.i();
            gm.i iVar54 = new gm.i();
            gm.i iVar55 = new gm.i();
            gm.i iVar56 = new gm.i();
            if (iVarArr[i41].g() != null) {
                int i48 = 0;
                while (i48 < iVarArr[i41].g().length) {
                    iVar54.a(new j2(bVarArr[0]));
                    int i49 = iVarArr[i41].g()[i48].g()[1];
                    gm.i iVar57 = iVar52;
                    iVar55.a(new f2(iVarArr[i41].g()[i48].f()[0]));
                    iVar55.a(new f2(iVarArr[i41].g()[i48].f()[1]));
                    iVar55.a(new f2(iVarArr[i41].g()[i48].f()[2]));
                    int i50 = 0;
                    while (i50 < i49) {
                        iVar55.a(new f2(iVarArr[i41].g()[i48].f()[i50 + 3]));
                        i50++;
                        iVar53 = iVar53;
                    }
                    gm.i iVar58 = iVar53;
                    iVar54.a(new j2(iVar55));
                    iVar55 = new gm.i();
                    gm.i iVar59 = iVar43;
                    iVar56.a(new t(iVarArr[i41].g()[i48].g()[0]));
                    iVar56.a(new t(i49));
                    iVar56.a(new t(iVarArr[i41].g()[i48].g()[2]));
                    iVar56.a(new t(iVarArr[i41].g()[i48].g()[3]));
                    iVar56.a(new t(iVarArr[i41].g()[i48].g()[4]));
                    iVar56.a(new t(iVarArr[i41].g()[i48].g()[5]));
                    int i51 = 0;
                    while (i51 < i49) {
                        iVar56.a(new t(iVarArr[i41].g()[i48].g()[i51 + 6]));
                        i51++;
                        i49 = i49;
                        iVar59 = iVar59;
                    }
                    iVar54.a(new j2(iVar56));
                    iVar56 = new gm.i();
                    iVar50.a(new j2(iVar54));
                    iVar54 = new gm.i();
                    i48++;
                    iVar52 = iVar57;
                    iVar53 = iVar58;
                    iVar43 = iVar59;
                }
            }
            gm.i iVar60 = iVar52;
            gm.i iVar61 = iVar53;
            gm.i iVar62 = iVar43;
            iVar47.a(new j2(iVar50));
            iVar50 = new gm.i();
            gm.i iVar63 = new gm.i();
            if (iVarArr[i41].b() != null) {
                for (int i52 = 0; i52 < iVarArr[i41].b().length; i52++) {
                    for (int i53 = 0; i53 < iVarArr[i41].b()[i52].size(); i53++) {
                        iVar63.a(new f2((byte[]) iVarArr[i41].b()[i52].elementAt(i53)));
                    }
                    iVar51.a(new j2(iVar63));
                    iVar63 = new gm.i();
                }
            }
            iVar47.a(new j2(iVar51));
            iVar51 = new gm.i();
            iVar46.a(new j2(iVar47));
            iVar47 = new gm.i();
            i41++;
            iVar48 = iVar60;
            iVar49 = iVar61;
            iVar43 = iVar62;
        }
        gm.i iVar64 = iVar43;
        iVar64.a(new j2(iVar46));
        gm.i iVar65 = new gm.i();
        for (byte[] bArr11 : bArr7) {
            iVar65.a(new f2(bArr11));
        }
        iVar64.a(new j2(iVar65));
        gm.i iVar66 = new gm.i();
        gm.i iVar67 = new gm.i();
        new gm.i();
        gm.i iVar68 = new gm.i();
        gm.i iVar69 = new gm.i();
        for (int i54 = 0; i54 < jVarArr.length; i54++) {
            iVar67.a(new j2(bVarArr[0]));
            new gm.i();
            iVar68.a(new f2(jVarArr[i54].c()[0]));
            iVar68.a(new f2(jVarArr[i54].c()[1]));
            iVar68.a(new f2(jVarArr[i54].c()[2]));
            iVar68.a(new f2(jVarArr[i54].c()[3]));
            iVar68.a(new f2(jVarArr[i54].c()[4]));
            iVar67.a(new j2(iVar68));
            iVar68 = new gm.i();
            iVar69.a(new t(jVarArr[i54].d()[0]));
            iVar69.a(new t(jVarArr[i54].d()[1]));
            iVar69.a(new t(jVarArr[i54].d()[2]));
            iVar69.a(new t(jVarArr[i54].d()[3]));
            iVar69.a(new t(jVarArr[i54].d()[4]));
            iVar69.a(new t(jVarArr[i54].d()[5]));
            iVar69.a(new t(jVarArr[i54].d()[6]));
            iVar69.a(new t(jVarArr[i54].d()[7]));
            iVar69.a(new t(jVarArr[i54].d()[8]));
            iVar67.a(new j2(iVar69));
            iVar69 = new gm.i();
            iVar66.a(new j2(iVar67));
            iVar67 = new gm.i();
        }
        iVar64.a(new j2(iVar66));
        gm.i iVar70 = new gm.i();
        gm.i iVar71 = new gm.i();
        gm.i iVar72 = new gm.i();
        gm.i iVar73 = new gm.i();
        for (int i55 = 0; i55 < fVar.a().length; i55++) {
            iVar71.a(new t(fVar.a()[i55]));
            iVar72.a(new t(fVar.d()[i55]));
            iVar73.a(new t(fVar.b()[i55]));
        }
        iVar70.a(new t(fVar.c()));
        iVar70.a(new j2(iVar71));
        iVar70.a(new j2(iVar72));
        iVar70.a(new j2(iVar73));
        iVar64.a(new j2(iVar70));
        gm.i iVar74 = new gm.i();
        for (zn.b bVar : bVarArr) {
            iVar74.a(bVar);
        }
        iVar64.a(new j2(iVar74));
        return new j2(iVar64);
    }
}
