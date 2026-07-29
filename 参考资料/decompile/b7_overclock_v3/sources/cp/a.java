package cp;

import java.lang.reflect.Array;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;

/* JADX INFO: loaded from: classes5.dex */
public class a implements org.bouncycastle.crypto.f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final byte[] f25156e = {99, 124, 119, 123, -14, 107, pq.b.f46991h, i1.a.f31699s7, jt.l.f36949q, 1, 103, rc.a.f48411c0, -2, -41, -85, 118, i1.a.f31732w7, -126, i1.a.f31723v7, 125, -6, 89, 71, -16, -83, -44, -94, -81, -100, -92, 114, i1.a.f31667o7, -73, -3, -109, rc.a.Y, 54, okio.w0.f44229a, -9, -52, 52, -91, -27, -15, pq.b.f46993j, i1.a.f31659n7, 49, 21, 4, i1.a.f31714u7, 35, i1.a.f31691r7, 24, -106, 5, -102, 7, 18, -128, -30, -21, rc.a.Z, -78, 117, 9, -125, rc.a.f48412d0, 26, 27, pq.b.f46992i, 90, -96, 82, 59, -42, -77, rc.a.f48409a0, -29, 47, -124, 83, -47, 0, -19, 32, -4, -79, 91, 106, i1.a.f31741x7, -66, 57, 74, 76, o5.b.f42741j, i1.a.A7, -48, -17, -86, -5, 67, 77, 51, -123, 69, -7, 2, 127, jt.l.f36951s, 60, -97, -88, 81, -93, 64, -113, -110, -99, 56, -11, rp.u.f49086t, -74, i1.a.B7, rc.a.V, 16, -1, -13, -46, i1.a.f31750y7, 12, 19, -20, 95, -105, 68, 23, -60, -89, 126, 61, 100, 93, 25, 115, jt.l.f36952t, -127, 79, -36, 34, 42, -112, -120, 70, -18, -72, 20, -34, 94, 11, -37, -32, 50, 58, 10, 73, 6, rc.a.W, 92, i1.a.f31683q7, -45, -84, 98, -111, -107, -28, 121, -25, -56, 55, 109, -115, -43, 78, -87, 108, 86, -12, -22, 101, 122, -82, 8, -70, tc.a.f51065w, rc.a.X, rc.a.f48414f0, 28, -90, -76, i1.a.f31707t7, -24, -35, 116, 31, 75, -67, -117, -118, pq.b.f46994k, 62, -75, 102, 72, 3, -10, 14, 97, 53, 87, -71, -122, i1.a.f31675p7, 29, -98, -31, -8, -104, 17, 105, i1.a.E7, -114, -108, -101, 30, -121, -23, i1.a.f31759z7, 85, 40, -33, -116, -95, -119, 13, -65, -26, 66, 104, 65, -103, rc.a.f48413e0, 15, -80, 84, -69, 22};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final byte[] f25157f = {82, 9, 106, -43, jt.l.f36949q, 54, -91, 56, -65, 64, -93, -98, -127, -13, -41, -5, 124, -29, 57, -126, -101, 47, -1, -121, 52, -114, 67, 68, -60, -34, -23, i1.a.f31741x7, 84, 123, -108, 50, -90, i1.a.f31683q7, 35, 61, -18, 76, -107, 11, 66, -6, i1.a.f31691r7, 78, 8, rc.a.f48414f0, -95, 102, 40, i1.a.E7, rc.a.W, -78, 118, 91, -94, 73, 109, -117, -47, rc.a.X, 114, -8, -10, 100, -122, 104, -104, 22, -44, -92, 92, -52, 93, 101, -74, -110, 108, pq.b.f46994k, 72, jt.l.f36951s, -3, -19, -71, i1.a.B7, 94, 21, 70, 87, -89, -115, -99, -124, -112, i1.a.f31659n7, -85, 0, -116, rp.u.f49086t, -45, 10, -9, -28, o5.b.f42741j, 5, -72, -77, 69, 6, -48, rc.a.f48412d0, 30, -113, i1.a.f31732w7, okio.w0.f44229a, 15, 2, i1.a.f31675p7, -81, -67, 3, 1, 19, -118, 107, 58, -111, 17, 65, 79, 103, -36, -22, -105, -14, i1.a.A7, i1.a.f31759z7, -16, -76, -26, 115, -106, -84, 116, 34, -25, -83, 53, -123, -30, -7, 55, -24, 28, 117, -33, pq.b.f46992i, 71, -15, 26, pq.b.f46993j, 29, rc.a.f48409a0, i1.a.f31699s7, -119, pq.b.f46991h, -73, 98, 14, -86, 24, -66, 27, -4, 86, 62, 75, i1.a.f31707t7, -46, 121, 32, -102, -37, i1.a.f31667o7, -2, tc.a.f51065w, i1.a.f31750y7, 90, -12, 31, -35, -88, 51, -120, 7, i1.a.f31714u7, 49, -79, 18, 16, 89, rc.a.Z, -128, -20, 95, jt.l.f36952t, 81, 127, -87, 25, -75, 74, 13, rc.a.f48413e0, -27, 122, -97, -109, i1.a.f31723v7, -100, -17, -96, -32, 59, 77, -82, 42, -11, -80, -56, -21, -69, 60, -125, 83, -103, 97, 23, rc.a.f48411c0, 4, 126, -70, 119, -42, rc.a.Y, -31, 105, 20, 99, 85, rc.a.V, 12, 125};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int[] f25158g = {1, 2, 4, 8, 16, 32, 64, 128, 27, 54, 108, 216, 171, 77, 154, 47, 94, 188, 99, 198, rc.c.f48463k0, 53, 106, 212, 179, 125, 250, 239, 197, 145};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int[] f25159h = {-1520213050, -2072216328, -1720223762, -1921287178, 234025727, -1117033514, -1318096930, 1422247313, 1345335392, 50397442, -1452841010, 2099981142, 436141799, 1658312629, -424957107, -1703512340, 1170918031, -1652391393, 1086966153, -2021818886, 368769775, -346465870, -918075506, 200339707, -324162239, 1742001331, -39673249, -357585083, -1080255453, -140204973, -1770884380, 1539358875, -1028147339, 486407649, -1366060227, 1780885068, 1513502316, 1094664062, 49805301, 1338821763, 1546925160, -190470831, 887481809, 150073849, -1821281822, 1943591083, 1395732834, 1058346282, 201589768, 1388824469, 1696801606, 1589887901, 672667696, -1583966665, 251987210, -1248159185, 151455502, 907153956, -1686077413, 1038279391, 652995533, 1764173646, -843926913, -1619692054, 453576978, -1635548387, 1949051992, 773462580, 756751158, -1301385508, -296068428, -73359269, -162377052, 1295727478, 1641469623, -827083907, 2066295122, 1055122397, 1898917726, -1752923117, -179088474, 1758581177, 0, 753790401, 1612718144, 536673507, -927878791, -312779850, -1100322092, 1187761037, -641810841, 1262041458, -565556588, -733197160, -396863312, 1255133061, 1808847035, 720367557, -441800113, 385612781, -985447546, -682799718, 1429418854, -1803188975, -817543798, 284817897, 100794884, -2122350594, -263171936, 1144798328, -1163944155, -475486133, -212774494, -22830243, -1069531008, -1970303227, -1382903233, -1130521311, 1211644016, 83228145, -541279133, -1044990345, 1977277103, 1663115586, 806359072, 452984805, 250868733, 1842533055, 1288555905, 336333848, 890442534, 804056259, -513843266, -1567123659, -867941240, 957814574, 1472513171, -223893675, -2105639172, 1195195770, -1402706744, -413311558, 723065138, -1787595802, -1604296512, -1736343271, -783331426, 2145180835, 1713513028, 2116692564, -1416589253, -2088204277, -901364084, 703524551, -742868885, 1007948840, 2044649127, -497131844, 487262998, 1994120109, 1004593371, 1446130276, 1312438900, 503974420, -615954030, 168166924, 1814307912, -463709000, 1573044895, 1859376061, -273896381, -1503501628, -1466855111, -1533700815, 937747667, -1954973198, 854058965, 1137232011, 1496790894, -1217565222, -1936880383, 1691735473, -766620004, -525751991, -1267962664, -95005012, 133494003, 636152527, -1352309302, -1904575756, -374428089, 403179536, -709182865, -2005370640, 1864705354, 1915629148, 605822008, -240736681, -944458637, 1371981463, 602466507, 2094914977, -1670089496, 555687742, -582268010, -591544991, -2037675251, -2054518257, -1871679264, 1111375484, -994724495, -1436129588, -666351472, 84083462, 32962295, 302911004, -1553899070, 1597322602, -111716434, -793134743, -1853454825, 1489093017, 656219450, -1180787161, 954327513, 335083755, -1281845205, 856756514, -1150719534, 1893325225, -1987146233, -1483434957, -1231316179, 572399164, -1836611819, 552200649, 1238290055, -11184726, 2015897680, 2061492133, -1886614525, -123625127, -2138470135, 386731290, -624967835, 837215959, -968736124, -1201116976, -1019133566, -1332111063, 1999449434, 286199582, -877612933, -61582168, -692339859, 974525996};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int[] f25160i = {1353184337, 1399144830, -1012656358, -1772214470, -882136261, -247096033, -1420232020, -1828461749, 1442459680, -160598355, -1854485368, 625738485, -52959921, -674551099, -2143013594, -1885117771, 1230680542, 1729870373, -1743852987, -507445667, 41234371, 317738113, -1550367091, -956705941, -413167869, -1784901099, -344298049, -631680363, 763608788, -752782248, 694804553, 1154009486, 1787413109, 2021232372, 1799248025, -579749593, -1236278850, 397248752, 1722556617, -1271214467, 407560035, -2110711067, 1613975959, 1165972322, -529046351, -2068943941, 480281086, -1809118983, 1483229296, 436028815, -2022908268, -1208452270, 601060267, -503166094, 1468997603, 715871590, 120122290, 63092015, -1703164538, -1526188077, -226023376, -1297760477, -1167457534, 1552029421, 723308426, -1833666137, -252573709, -1578997426, -839591323, -708967162, 526529745, -1963022652, -1655493068, -1604979806, 853641733, 1978398372, 971801355, -1427152832, 111112542, 1360031421, -108388034, 1023860118, -1375387939, 1186850381, -1249028975, 90031217, 1876166148, -15380384, 620468249, -1746289194, -868007799, 2006899047, -1119688528, -2004121337, 945494503, -605108103, 1191869601, -384875908, -920746760, 0, -2088337399, 1223502642, -1401941730, 1316117100, -67170563, 1446544655, 517320253, 658058550, 1691946762, 564550760, -783000677, 976107044, -1318647284, 266819475, -761860428, -1634624741, 1338359936, -1574904735, 1766553434, 370807324, 179999714, -450191168, 1138762300, 488053522, 185403662, -1379431438, -1180125651, -928440812, -2061897385, 1275557295, -1143105042, -44007517, -1624899081, -1124765092, -985962940, 880737115, 1982415755, -590994485, 1761406390, 1676797112, -891538985, 277177154, 1076008723, 538035844, 2099530373, -130171950, 288553390, 1839278535, 1261411869, -214912292, -330136051, -790380169, 1813426987, -1715900247, -95906799, 577038663, -997393240, 440397984, -668172970, -275762398, -951170681, -1043253031, -22885748, 906744984, -813566554, 685669029, 646887386, -1530942145, -459458004, 227702864, -1681105046, 1648787028, -1038905866, -390539120, 1593260334, -173030526, -1098883681, 2090061929, -1456614033, -1290656305, 999926984, -1484974064, 1852021992, 2075868123, 158869197, -199730834, 28809964, -1466282109, 1701746150, 2129067946, 147831841, -420997649, -644094022, -835293366, -737566742, -696471511, -1347247055, 824393514, 815048134, -1067015627, 935087732, -1496677636, -1328508704, 366520115, 1251476721, -136647615, 240176511, 804688151, -1915335306, 1303441219, 1414376140, -553347356, -474623586, 461924940, -1205916479, 2136040774, 82468509, 1563790337, 1937016826, 776014843, 1511876531, 1389550482, 861278441, 323475053, -1939744870, 2047648055, -1911228327, -1992551445, -299390514, 902390199, -303751967, 1018251130, 1507840668, 1064563285, 2043548696, -1086863501, -355600557, 1537932639, 342834655, -2032450440, -2114736182, 1053059257, 741614648, 1598071746, 1925389590, 203809468, -1958134744, 1100287487, 1895934009, -558691320, -1662733096, -1866377628, 1636092795, 1890988757, 1952214088, 1113045200};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f25161j = -2139062144;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f25162k = 2139062143;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f25163l = 27;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f25164m = -1061109568;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f25165n = 1061109567;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f25166o = 16;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f25167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[][] f25168b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f25169c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f25170d;

    public static int e(int i10) {
        return (((i10 & (-2139062144)) >>> 7) * 27) ^ ((2139062143 & i10) << 1);
    }

    public static int f(int i10) {
        int i11 = (1061109567 & i10) << 2;
        int i12 = i10 & (-1061109568);
        int i13 = i12 ^ (i12 >>> 1);
        return (i13 >>> 5) ^ (i11 ^ (i13 >>> 2));
    }

    public static int j(int i10) {
        int iK = k(i10, 8) ^ i10;
        int iE = i10 ^ e(iK);
        int iF = iK ^ f(iE);
        return iE ^ (iF ^ k(iF, 16));
    }

    public static int k(int i10, int i11) {
        return (i10 << (-i11)) | (i10 >>> i11);
    }

    public static int l(int i10) {
        byte[] bArr = f25156e;
        return (bArr[(i10 >> 24) & 255] << 24) | (bArr[i10 & 255] & 255) | ((bArr[(i10 >> 8) & 255] & 255) << 8) | ((bArr[(i10 >> 16) & 255] & 255) << 16);
    }

    @Override // org.bouncycastle.crypto.f
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        if (!(kVar instanceof np.n1)) {
            throw new IllegalArgumentException("invalid parameter passed to AES init - " + kVar.getClass().getName());
        }
        this.f25168b = i(((np.n1) kVar).a(), z10);
        this.f25169c = z10;
        if (z10) {
            this.f25170d = org.bouncycastle.util.a.p(f25156e);
        } else {
            this.f25170d = org.bouncycastle.util.a.p(f25157f);
        }
    }

    @Override // org.bouncycastle.crypto.f
    public String b() {
        return m5.b.f40641c;
    }

    @Override // org.bouncycastle.crypto.f
    public int c() {
        return 16;
    }

    @Override // org.bouncycastle.crypto.f
    public int d(byte[] bArr, int i10, byte[] bArr2, int i11) {
        int[][] iArr = this.f25168b;
        if (iArr == null) {
            throw new IllegalStateException("AES engine not initialised");
        }
        if (i10 > bArr.length - 16) {
            throw new DataLengthException("input buffer too short");
        }
        if (i11 > bArr2.length - 16) {
            throw new OutputLengthException("output buffer too short");
        }
        if (this.f25169c) {
            h(bArr, i10, bArr2, i11, iArr);
        } else {
            g(bArr, i10, bArr2, i11, iArr);
        }
        return 16;
    }

    public final void g(byte[] bArr, int i10, byte[] bArr2, int i11, int[][] iArr) {
        int iR = org.bouncycastle.util.o.r(bArr, i10 + 0);
        int iR2 = org.bouncycastle.util.o.r(bArr, i10 + 4);
        int iR3 = org.bouncycastle.util.o.r(bArr, i10 + 8);
        int iR4 = org.bouncycastle.util.o.r(bArr, i10 + 12);
        int i12 = this.f25167a;
        char c10 = 0;
        int i13 = iR ^ iArr[i12][0];
        int i14 = 1;
        int i15 = iR2 ^ iArr[i12][1];
        int i16 = iR3 ^ iArr[i12][2];
        int i17 = i12 - 1;
        int iK = iR4 ^ iArr[i12][3];
        while (i17 > i14) {
            int[] iArr2 = f25160i;
            int iK2 = (((k(iArr2[(iK >> 8) & 255], 24) ^ iArr2[i13 & 255]) ^ k(iArr2[(i16 >> 16) & 255], 16)) ^ k(iArr2[(i15 >> 24) & 255], 8)) ^ iArr[i17][c10];
            int iK3 = (((k(iArr2[(i13 >> 8) & 255], 24) ^ iArr2[i15 & 255]) ^ k(iArr2[(iK >> 16) & 255], 16)) ^ k(iArr2[(i16 >> 24) & 255], 8)) ^ iArr[i17][i14];
            int iK4 = (((k(iArr2[(i15 >> 8) & 255], 24) ^ iArr2[i16 & 255]) ^ k(iArr2[(i13 >> 16) & 255], 16)) ^ k(iArr2[(iK >> 24) & 255], 8)) ^ iArr[i17][2];
            int iK5 = ((iArr2[iK & 255] ^ k(iArr2[(i16 >> 8) & 255], 24)) ^ k(iArr2[(i15 >> 16) & 255], 16)) ^ k(iArr2[(i13 >> 24) & 255], 8);
            int i18 = i17 - 1;
            int i19 = iK5 ^ iArr[i17][3];
            int iK6 = (((iArr2[iK2 & 255] ^ k(iArr2[(i19 >> 8) & 255], 24)) ^ k(iArr2[(iK4 >> 16) & 255], 16)) ^ k(iArr2[(iK3 >> 24) & 255], 8)) ^ iArr[i18][0];
            int iK7 = (((iArr2[iK3 & 255] ^ k(iArr2[(iK2 >> 8) & 255], 24)) ^ k(iArr2[(i19 >> 16) & 255], 16)) ^ k(iArr2[(iK4 >> 24) & 255], 8)) ^ iArr[i18][1];
            int iK8 = (((iArr2[iK4 & 255] ^ k(iArr2[(iK3 >> 8) & 255], 24)) ^ k(iArr2[(iK2 >> 16) & 255], 16)) ^ k(iArr2[(i19 >> 24) & 255], 8)) ^ iArr[i18][2];
            int i20 = i18 - 1;
            iK = (((iArr2[i19 & 255] ^ k(iArr2[(iK4 >> 8) & 255], 24)) ^ k(iArr2[(iK3 >> 16) & 255], 16)) ^ k(iArr2[(iK2 >> 24) & 255], 8)) ^ iArr[i18][3];
            i13 = iK6;
            i15 = iK7;
            i16 = iK8;
            c10 = 0;
            i14 = 1;
            i17 = i20;
        }
        int[] iArr3 = f25160i;
        int iK9 = (((iArr3[i13 & 255] ^ k(iArr3[(iK >> 8) & 255], 24)) ^ k(iArr3[(i16 >> 16) & 255], 16)) ^ k(iArr3[(i15 >> 24) & 255], 8)) ^ iArr[i17][0];
        int iK10 = (((iArr3[i15 & 255] ^ k(iArr3[(i13 >> 8) & 255], 24)) ^ k(iArr3[(iK >> 16) & 255], 16)) ^ k(iArr3[(i16 >> 24) & 255], 8)) ^ iArr[i17][1];
        int iK11 = (((iArr3[i16 & 255] ^ k(iArr3[(i15 >> 8) & 255], 24)) ^ k(iArr3[(i13 >> 16) & 255], 16)) ^ k(iArr3[(iK >> 24) & 255], 8)) ^ iArr[i17][2];
        int iK12 = (((iArr3[iK & 255] ^ k(iArr3[(i16 >> 8) & 255], 24)) ^ k(iArr3[(i15 >> 16) & 255], 16)) ^ k(iArr3[(i13 >> 24) & 255], 8)) ^ iArr[i17][3];
        byte[] bArr3 = f25157f;
        int i21 = bArr3[iK9 & 255] & 255;
        byte[] bArr4 = this.f25170d;
        int i22 = (((i21 ^ ((bArr4[(iK12 >> 8) & 255] & 255) << 8)) ^ ((bArr4[(iK11 >> 16) & 255] & 255) << 16)) ^ (bArr3[(iK10 >> 24) & 255] << 24)) ^ iArr[0][0];
        int i23 = ((((bArr4[iK10 & 255] & 255) ^ ((bArr4[(iK9 >> 8) & 255] & 255) << 8)) ^ ((bArr3[(iK12 >> 16) & 255] & 255) << 16)) ^ (bArr4[(iK11 >> 24) & 255] << 24)) ^ iArr[0][1];
        int i24 = ((((bArr4[iK11 & 255] & 255) ^ ((bArr3[(iK10 >> 8) & 255] & 255) << 8)) ^ ((bArr3[(iK9 >> 16) & 255] & 255) << 16)) ^ (bArr4[(iK12 >> 24) & 255] << 24)) ^ iArr[0][2];
        int i25 = ((((bArr3[iK12 & 255] & 255) ^ ((bArr4[(iK11 >> 8) & 255] & 255) << 8)) ^ ((bArr4[(iK10 >> 16) & 255] & 255) << 16)) ^ (bArr4[(iK9 >> 24) & 255] << 24)) ^ iArr[0][3];
        org.bouncycastle.util.o.m(i22, bArr2, i11 + 0);
        org.bouncycastle.util.o.m(i23, bArr2, i11 + 4);
        org.bouncycastle.util.o.m(i24, bArr2, i11 + 8);
        org.bouncycastle.util.o.m(i25, bArr2, i11 + 12);
    }

    public final void h(byte[] bArr, int i10, byte[] bArr2, int i11, int[][] iArr) {
        int iR = org.bouncycastle.util.o.r(bArr, i10 + 0);
        int iR2 = org.bouncycastle.util.o.r(bArr, i10 + 4);
        int iR3 = org.bouncycastle.util.o.r(bArr, i10 + 8);
        int iR4 = org.bouncycastle.util.o.r(bArr, i10 + 12);
        char c10 = 0;
        int i12 = iR ^ iArr[0][0];
        int i13 = 1;
        int i14 = iR2 ^ iArr[0][1];
        int i15 = iR3 ^ iArr[0][2];
        int i16 = iR4 ^ iArr[0][3];
        int i17 = 1;
        while (i17 < this.f25167a - i13) {
            int[] iArr2 = f25159h;
            int iK = (((k(iArr2[(i14 >> 8) & 255], 24) ^ iArr2[i12 & 255]) ^ k(iArr2[(i15 >> 16) & 255], 16)) ^ k(iArr2[(i16 >> 24) & 255], 8)) ^ iArr[i17][c10];
            int iK2 = (((k(iArr2[(i15 >> 8) & 255], 24) ^ iArr2[i14 & 255]) ^ k(iArr2[(i16 >> 16) & 255], 16)) ^ k(iArr2[(i12 >> 24) & 255], 8)) ^ iArr[i17][i13];
            int iK3 = (((k(iArr2[(i16 >> 8) & 255], 24) ^ iArr2[i15 & 255]) ^ k(iArr2[(i12 >> 16) & 255], 16)) ^ k(iArr2[(i14 >> 24) & 255], 8)) ^ iArr[i17][2];
            int iK4 = ((iArr2[i16 & 255] ^ k(iArr2[(i12 >> 8) & 255], 24)) ^ k(iArr2[(i14 >> 16) & 255], 16)) ^ k(iArr2[(i15 >> 24) & 255], 8);
            int i18 = i17 + 1;
            int i19 = iK4 ^ iArr[i17][3];
            int iK5 = (((iArr2[iK & 255] ^ k(iArr2[(iK2 >> 8) & 255], 24)) ^ k(iArr2[(iK3 >> 16) & 255], 16)) ^ k(iArr2[(i19 >> 24) & 255], 8)) ^ iArr[i18][0];
            int iK6 = (((iArr2[iK2 & 255] ^ k(iArr2[(iK3 >> 8) & 255], 24)) ^ k(iArr2[(i19 >> 16) & 255], 16)) ^ k(iArr2[(iK >> 24) & 255], 8)) ^ iArr[i18][1];
            int iK7 = (((iArr2[iK3 & 255] ^ k(iArr2[(i19 >> 8) & 255], 24)) ^ k(iArr2[(iK >> 16) & 255], 16)) ^ k(iArr2[(iK2 >> 24) & 255], 8)) ^ iArr[i18][2];
            int iK8 = ((iArr2[i19 & 255] ^ k(iArr2[(iK >> 8) & 255], 24)) ^ k(iArr2[(iK2 >> 16) & 255], 16)) ^ k(iArr2[(iK3 >> 24) & 255], 8);
            int i20 = i18 + 1;
            i16 = iK8 ^ iArr[i18][3];
            i12 = iK5;
            i14 = iK6;
            i15 = iK7;
            i13 = 1;
            i17 = i20;
            c10 = 0;
        }
        int[] iArr3 = f25159h;
        int iK9 = (((iArr3[i12 & 255] ^ k(iArr3[(i14 >> 8) & 255], 24)) ^ k(iArr3[(i15 >> 16) & 255], 16)) ^ k(iArr3[(i16 >> 24) & 255], 8)) ^ iArr[i17][0];
        int iK10 = (((iArr3[i14 & 255] ^ k(iArr3[(i15 >> 8) & 255], 24)) ^ k(iArr3[(i16 >> 16) & 255], 16)) ^ k(iArr3[(i12 >> 24) & 255], 8)) ^ iArr[i17][1];
        int iK11 = (((iArr3[i15 & 255] ^ k(iArr3[(i16 >> 8) & 255], 24)) ^ k(iArr3[(i12 >> 16) & 255], 16)) ^ k(iArr3[(i14 >> 24) & 255], 8)) ^ iArr[i17][2];
        int iK12 = ((iArr3[i16 & 255] ^ k(iArr3[(i12 >> 8) & 255], 24)) ^ k(iArr3[(i14 >> 16) & 255], 16)) ^ k(iArr3[(i15 >> 24) & 255], 8);
        int i21 = i17 + 1;
        int i22 = iK12 ^ iArr[i17][3];
        byte[] bArr3 = f25156e;
        int i23 = (bArr3[iK9 & 255] & 255) ^ ((bArr3[(iK10 >> 8) & 255] & 255) << 8);
        byte[] bArr4 = this.f25170d;
        int i24 = ((i23 ^ ((bArr4[(iK11 >> 16) & 255] & 255) << 16)) ^ (bArr4[(i22 >> 24) & 255] << 24)) ^ iArr[i21][0];
        int i25 = ((((bArr4[iK10 & 255] & 255) ^ ((bArr3[(iK11 >> 8) & 255] & 255) << 8)) ^ ((bArr3[(i22 >> 16) & 255] & 255) << 16)) ^ (bArr4[(iK9 >> 24) & 255] << 24)) ^ iArr[i21][1];
        int i26 = (((((bArr3[(i22 >> 8) & 255] & 255) << 8) ^ (bArr4[iK11 & 255] & 255)) ^ ((bArr3[(iK9 >> 16) & 255] & 255) << 16)) ^ (bArr3[(iK10 >> 24) & 255] << 24)) ^ iArr[i21][2];
        int i27 = ((((bArr4[i22 & 255] & 255) ^ ((bArr4[(iK9 >> 8) & 255] & 255) << 8)) ^ ((bArr4[(iK10 >> 16) & 255] & 255) << 16)) ^ (bArr3[(iK11 >> 24) & 255] << 24)) ^ iArr[i21][3];
        org.bouncycastle.util.o.m(i24, bArr2, i11 + 0);
        org.bouncycastle.util.o.m(i25, bArr2, i11 + 4);
        org.bouncycastle.util.o.m(i26, bArr2, i11 + 8);
        org.bouncycastle.util.o.m(i27, bArr2, i11 + 12);
    }

    public final int[][] i(byte[] bArr, boolean z10) {
        int length = bArr.length;
        if (length < 16 || length > 32 || (length & 7) != 0) {
            throw new IllegalArgumentException("Key length not 128/192/256 bits.");
        }
        int i10 = length >>> 2;
        int i11 = i10 + 6;
        this.f25167a = i11;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) int.class, i11 + 1, 4);
        int i12 = 8;
        char c10 = 3;
        if (i10 == 4) {
            int iR = org.bouncycastle.util.o.r(bArr, 0);
            iArr[0][0] = iR;
            int iR2 = org.bouncycastle.util.o.r(bArr, 4);
            iArr[0][1] = iR2;
            int iR3 = org.bouncycastle.util.o.r(bArr, 8);
            iArr[0][2] = iR3;
            int iR4 = org.bouncycastle.util.o.r(bArr, 12);
            iArr[0][3] = iR4;
            for (int i13 = 1; i13 <= 10; i13++) {
                iR ^= l(k(iR4, 8)) ^ f25158g[i13 - 1];
                iArr[i13][0] = iR;
                iR2 ^= iR;
                iArr[i13][1] = iR2;
                iR3 ^= iR2;
                iArr[i13][2] = iR3;
                iR4 ^= iR3;
                iArr[i13][3] = iR4;
            }
        } else if (i10 == 6) {
            int iR5 = org.bouncycastle.util.o.r(bArr, 0);
            iArr[0][0] = iR5;
            int iR6 = org.bouncycastle.util.o.r(bArr, 4);
            iArr[0][1] = iR6;
            int iR7 = org.bouncycastle.util.o.r(bArr, 8);
            iArr[0][2] = iR7;
            int iR8 = org.bouncycastle.util.o.r(bArr, 12);
            iArr[0][3] = iR8;
            int iR9 = org.bouncycastle.util.o.r(bArr, 16);
            int iR10 = org.bouncycastle.util.o.r(bArr, 20);
            int i14 = 1;
            int i15 = 1;
            while (true) {
                iArr[i14][0] = iR9;
                iArr[i14][1] = iR10;
                int iL = l(k(iR10, 8)) ^ i15;
                int i16 = i15 << 1;
                int i17 = iR5 ^ iL;
                iArr[i14][2] = i17;
                int i18 = iR6 ^ i17;
                iArr[i14][3] = i18;
                int i19 = iR7 ^ i18;
                int i20 = i14 + 1;
                iArr[i20][0] = i19;
                int i21 = iR8 ^ i19;
                iArr[i20][1] = i21;
                int i22 = iR9 ^ i21;
                iArr[i20][2] = i22;
                int i23 = iR10 ^ i22;
                iArr[i20][3] = i23;
                int iL2 = l(k(i23, 8)) ^ i16;
                i15 = i16 << 1;
                iR5 = i17 ^ iL2;
                int i24 = i14 + 2;
                iArr[i24][0] = iR5;
                iR6 = i18 ^ iR5;
                iArr[i24][1] = iR6;
                iR7 = i19 ^ iR6;
                iArr[i24][2] = iR7;
                iR8 = i21 ^ iR7;
                iArr[i24][3] = iR8;
                i14 += 3;
                if (i14 >= 13) {
                    break;
                }
                iR9 = i22 ^ iR8;
                iR10 = i23 ^ iR9;
            }
        } else {
            if (i10 != 8) {
                throw new IllegalStateException("Should never get here");
            }
            int iR11 = org.bouncycastle.util.o.r(bArr, 0);
            iArr[0][0] = iR11;
            int iR12 = org.bouncycastle.util.o.r(bArr, 4);
            iArr[0][1] = iR12;
            int iR13 = org.bouncycastle.util.o.r(bArr, 8);
            iArr[0][2] = iR13;
            int iR14 = org.bouncycastle.util.o.r(bArr, 12);
            iArr[0][3] = iR14;
            int iR15 = org.bouncycastle.util.o.r(bArr, 16);
            iArr[1][0] = iR15;
            int iR16 = org.bouncycastle.util.o.r(bArr, 20);
            iArr[1][1] = iR16;
            int iR17 = org.bouncycastle.util.o.r(bArr, 24);
            iArr[1][2] = iR17;
            int iR18 = org.bouncycastle.util.o.r(bArr, 28);
            iArr[1][3] = iR18;
            int i25 = 1;
            int i26 = 2;
            while (true) {
                int iL3 = l(k(iR18, i12)) ^ i25;
                i25 <<= 1;
                iR11 ^= iL3;
                iArr[i26][0] = iR11;
                iR12 ^= iR11;
                iArr[i26][1] = iR12;
                iR13 ^= iR12;
                iArr[i26][2] = iR13;
                iR14 ^= iR13;
                iArr[i26][c10] = iR14;
                int i27 = i26 + 1;
                if (i27 >= 15) {
                    break;
                }
                iR15 ^= l(iR14);
                iArr[i27][0] = iR15;
                iR16 ^= iR15;
                iArr[i27][1] = iR16;
                iR17 ^= iR16;
                iArr[i27][2] = iR17;
                iR18 ^= iR17;
                iArr[i27][3] = iR18;
                i26 = i27 + 1;
                i12 = 8;
                c10 = 3;
            }
        }
        if (!z10) {
            for (int i28 = 1; i28 < this.f25167a; i28++) {
                for (int i29 = 0; i29 < 4; i29++) {
                    iArr[i28][i29] = j(iArr[i28][i29]);
                }
            }
        }
        return iArr;
    }

    @Override // org.bouncycastle.crypto.f
    public void reset() {
    }
}
