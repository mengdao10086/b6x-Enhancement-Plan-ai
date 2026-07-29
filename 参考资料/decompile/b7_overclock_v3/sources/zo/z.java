package zo;

/* JADX INFO: loaded from: classes5.dex */
public class z extends l {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f59546l = 20;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f59547e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f59548f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f59549g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f59550h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f59551i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int[] f59552j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f59553k;

    public z() {
        this.f59552j = new int[16];
        reset();
    }

    public z(z zVar) {
        super(zVar);
        this.f59552j = new int[16];
        r(zVar);
    }

    @Override // org.bouncycastle.crypto.s
    public String b() {
        return "RIPEMD160";
    }

    @Override // org.bouncycastle.crypto.s
    public int c(byte[] bArr, int i10) {
        l();
        x(this.f59547e, bArr, i10);
        x(this.f59548f, bArr, i10 + 4);
        x(this.f59549g, bArr, i10 + 8);
        x(this.f59550h, bArr, i10 + 12);
        x(this.f59551i, bArr, i10 + 16);
        reset();
        return 20;
    }

    @Override // org.bouncycastle.util.m
    public org.bouncycastle.util.m d() {
        return new z(this);
    }

    @Override // org.bouncycastle.crypto.s
    public int h() {
        return 20;
    }

    @Override // org.bouncycastle.util.m
    public void i(org.bouncycastle.util.m mVar) {
        r((z) mVar);
    }

    @Override // zo.l
    public void n() {
        int i10 = this.f59547e;
        int i11 = this.f59548f;
        int i12 = this.f59549g;
        int i13 = this.f59550h;
        int i14 = this.f59551i;
        int iQ = q(s(i11, i12, i13) + i10 + this.f59552j[0], 11) + i14;
        int iQ2 = q(i12, 10);
        int iQ3 = q(s(iQ, i11, iQ2) + i14 + this.f59552j[1], 14) + i13;
        int iQ4 = q(i11, 10);
        int iQ5 = q(s(iQ3, iQ, iQ4) + i13 + this.f59552j[2], 15) + iQ2;
        int iQ6 = q(iQ, 10);
        int iQ7 = q(iQ2 + s(iQ5, iQ3, iQ6) + this.f59552j[3], 12) + iQ4;
        int iQ8 = q(iQ3, 10);
        int iQ9 = q(iQ4 + s(iQ7, iQ5, iQ8) + this.f59552j[4], 5) + iQ6;
        int iQ10 = q(iQ5, 10);
        int iQ11 = q(iQ6 + s(iQ9, iQ7, iQ10) + this.f59552j[5], 8) + iQ8;
        int iQ12 = q(iQ7, 10);
        int iQ13 = q(iQ8 + s(iQ11, iQ9, iQ12) + this.f59552j[6], 7) + iQ10;
        int iQ14 = q(iQ9, 10);
        int iQ15 = q(iQ10 + s(iQ13, iQ11, iQ14) + this.f59552j[7], 9) + iQ12;
        int iQ16 = q(iQ11, 10);
        int iQ17 = q(iQ12 + s(iQ15, iQ13, iQ16) + this.f59552j[8], 11) + iQ14;
        int iQ18 = q(iQ13, 10);
        int iQ19 = q(iQ14 + s(iQ17, iQ15, iQ18) + this.f59552j[9], 13) + iQ16;
        int iQ20 = q(iQ15, 10);
        int iQ21 = q(iQ16 + s(iQ19, iQ17, iQ20) + this.f59552j[10], 14) + iQ18;
        int iQ22 = q(iQ17, 10);
        int iQ23 = q(iQ18 + s(iQ21, iQ19, iQ22) + this.f59552j[11], 15) + iQ20;
        int iQ24 = q(iQ19, 10);
        int iQ25 = q(iQ20 + s(iQ23, iQ21, iQ24) + this.f59552j[12], 6) + iQ22;
        int iQ26 = q(iQ21, 10);
        int iQ27 = q(iQ22 + s(iQ25, iQ23, iQ26) + this.f59552j[13], 7) + iQ24;
        int iQ28 = q(iQ23, 10);
        int iQ29 = q(iQ24 + s(iQ27, iQ25, iQ28) + this.f59552j[14], 9) + iQ26;
        int iQ30 = q(iQ25, 10);
        int iQ31 = q(iQ26 + s(iQ29, iQ27, iQ30) + this.f59552j[15], 8) + iQ28;
        int iQ32 = q(iQ27, 10);
        int iQ33 = q(i10 + w(i11, i12, i13) + this.f59552j[5] + 1352829926, 8) + i14;
        int iQ34 = q(i12, 10);
        int iQ35 = q(i14 + w(iQ33, i11, iQ34) + this.f59552j[14] + 1352829926, 9) + i13;
        int iQ36 = q(i11, 10);
        int iQ37 = q(i13 + w(iQ35, iQ33, iQ36) + this.f59552j[7] + 1352829926, 9) + iQ34;
        int iQ38 = q(iQ33, 10);
        int iQ39 = q(iQ34 + w(iQ37, iQ35, iQ38) + this.f59552j[0] + 1352829926, 11) + iQ36;
        int iQ40 = q(iQ35, 10);
        int iQ41 = q(iQ36 + w(iQ39, iQ37, iQ40) + this.f59552j[9] + 1352829926, 13) + iQ38;
        int iQ42 = q(iQ37, 10);
        int iQ43 = q(iQ38 + w(iQ41, iQ39, iQ42) + this.f59552j[2] + 1352829926, 15) + iQ40;
        int iQ44 = q(iQ39, 10);
        int iQ45 = q(iQ40 + w(iQ43, iQ41, iQ44) + this.f59552j[11] + 1352829926, 15) + iQ42;
        int iQ46 = q(iQ41, 10);
        int iQ47 = q(iQ42 + w(iQ45, iQ43, iQ46) + this.f59552j[4] + 1352829926, 5) + iQ44;
        int iQ48 = q(iQ43, 10);
        int iQ49 = q(iQ44 + w(iQ47, iQ45, iQ48) + this.f59552j[13] + 1352829926, 7) + iQ46;
        int iQ50 = q(iQ45, 10);
        int iQ51 = q(iQ46 + w(iQ49, iQ47, iQ50) + this.f59552j[6] + 1352829926, 7) + iQ48;
        int iQ52 = q(iQ47, 10);
        int iQ53 = q(iQ48 + w(iQ51, iQ49, iQ52) + this.f59552j[15] + 1352829926, 8) + iQ50;
        int iQ54 = q(iQ49, 10);
        int iQ55 = q(iQ50 + w(iQ53, iQ51, iQ54) + this.f59552j[8] + 1352829926, 11) + iQ52;
        int iQ56 = q(iQ51, 10);
        int iQ57 = q(iQ52 + w(iQ55, iQ53, iQ56) + this.f59552j[1] + 1352829926, 14) + iQ54;
        int iQ58 = q(iQ53, 10);
        int iQ59 = q(iQ54 + w(iQ57, iQ55, iQ58) + this.f59552j[10] + 1352829926, 14) + iQ56;
        int iQ60 = q(iQ55, 10);
        int iQ61 = q(iQ56 + w(iQ59, iQ57, iQ60) + this.f59552j[3] + 1352829926, 12) + iQ58;
        int iQ62 = q(iQ57, 10);
        int iQ63 = q(iQ58 + w(iQ61, iQ59, iQ62) + this.f59552j[12] + 1352829926, 6) + iQ60;
        int iQ64 = q(iQ59, 10);
        int iQ65 = q(iQ28 + t(iQ31, iQ29, iQ32) + this.f59552j[7] + 1518500249, 7) + iQ30;
        int iQ66 = q(iQ29, 10);
        int iQ67 = q(iQ30 + t(iQ65, iQ31, iQ66) + this.f59552j[4] + 1518500249, 6) + iQ32;
        int iQ68 = q(iQ31, 10);
        int iQ69 = q(iQ32 + t(iQ67, iQ65, iQ68) + this.f59552j[13] + 1518500249, 8) + iQ66;
        int iQ70 = q(iQ65, 10);
        int iQ71 = q(iQ66 + t(iQ69, iQ67, iQ70) + this.f59552j[1] + 1518500249, 13) + iQ68;
        int iQ72 = q(iQ67, 10);
        int iQ73 = q(iQ68 + t(iQ71, iQ69, iQ72) + this.f59552j[10] + 1518500249, 11) + iQ70;
        int iQ74 = q(iQ69, 10);
        int iQ75 = q(iQ70 + t(iQ73, iQ71, iQ74) + this.f59552j[6] + 1518500249, 9) + iQ72;
        int iQ76 = q(iQ71, 10);
        int iQ77 = q(iQ72 + t(iQ75, iQ73, iQ76) + this.f59552j[15] + 1518500249, 7) + iQ74;
        int iQ78 = q(iQ73, 10);
        int iQ79 = q(iQ74 + t(iQ77, iQ75, iQ78) + this.f59552j[3] + 1518500249, 15) + iQ76;
        int iQ80 = q(iQ75, 10);
        int iQ81 = q(iQ76 + t(iQ79, iQ77, iQ80) + this.f59552j[12] + 1518500249, 7) + iQ78;
        int iQ82 = q(iQ77, 10);
        int iQ83 = q(iQ78 + t(iQ81, iQ79, iQ82) + this.f59552j[0] + 1518500249, 12) + iQ80;
        int iQ84 = q(iQ79, 10);
        int iQ85 = q(iQ80 + t(iQ83, iQ81, iQ84) + this.f59552j[9] + 1518500249, 15) + iQ82;
        int iQ86 = q(iQ81, 10);
        int iQ87 = q(iQ82 + t(iQ85, iQ83, iQ86) + this.f59552j[5] + 1518500249, 9) + iQ84;
        int iQ88 = q(iQ83, 10);
        int iQ89 = q(iQ84 + t(iQ87, iQ85, iQ88) + this.f59552j[2] + 1518500249, 11) + iQ86;
        int iQ90 = q(iQ85, 10);
        int iQ91 = q(iQ86 + t(iQ89, iQ87, iQ90) + this.f59552j[14] + 1518500249, 7) + iQ88;
        int iQ92 = q(iQ87, 10);
        int iQ93 = q(iQ88 + t(iQ91, iQ89, iQ92) + this.f59552j[11] + 1518500249, 13) + iQ90;
        int iQ94 = q(iQ89, 10);
        int iQ95 = q(iQ90 + t(iQ93, iQ91, iQ94) + this.f59552j[8] + 1518500249, 12) + iQ92;
        int iQ96 = q(iQ91, 10);
        int iQ97 = q(iQ60 + v(iQ63, iQ61, iQ64) + this.f59552j[6] + 1548603684, 9) + iQ62;
        int iQ98 = q(iQ61, 10);
        int iQ99 = q(iQ62 + v(iQ97, iQ63, iQ98) + this.f59552j[11] + 1548603684, 13) + iQ64;
        int iQ100 = q(iQ63, 10);
        int iQ101 = q(iQ64 + v(iQ99, iQ97, iQ100) + this.f59552j[3] + 1548603684, 15) + iQ98;
        int iQ102 = q(iQ97, 10);
        int iQ103 = q(iQ98 + v(iQ101, iQ99, iQ102) + this.f59552j[7] + 1548603684, 7) + iQ100;
        int iQ104 = q(iQ99, 10);
        int iQ105 = q(iQ100 + v(iQ103, iQ101, iQ104) + this.f59552j[0] + 1548603684, 12) + iQ102;
        int iQ106 = q(iQ101, 10);
        int iQ107 = q(iQ102 + v(iQ105, iQ103, iQ106) + this.f59552j[13] + 1548603684, 8) + iQ104;
        int iQ108 = q(iQ103, 10);
        int iQ109 = q(iQ104 + v(iQ107, iQ105, iQ108) + this.f59552j[5] + 1548603684, 9) + iQ106;
        int iQ110 = q(iQ105, 10);
        int iQ111 = q(iQ106 + v(iQ109, iQ107, iQ110) + this.f59552j[10] + 1548603684, 11) + iQ108;
        int iQ112 = q(iQ107, 10);
        int iQ113 = q(iQ108 + v(iQ111, iQ109, iQ112) + this.f59552j[14] + 1548603684, 7) + iQ110;
        int iQ114 = q(iQ109, 10);
        int iQ115 = q(iQ110 + v(iQ113, iQ111, iQ114) + this.f59552j[15] + 1548603684, 7) + iQ112;
        int iQ116 = q(iQ111, 10);
        int iQ117 = q(iQ112 + v(iQ115, iQ113, iQ116) + this.f59552j[8] + 1548603684, 12) + iQ114;
        int iQ118 = q(iQ113, 10);
        int iQ119 = q(iQ114 + v(iQ117, iQ115, iQ118) + this.f59552j[12] + 1548603684, 7) + iQ116;
        int iQ120 = q(iQ115, 10);
        int iQ121 = q(iQ116 + v(iQ119, iQ117, iQ120) + this.f59552j[4] + 1548603684, 6) + iQ118;
        int iQ122 = q(iQ117, 10);
        int iQ123 = q(iQ118 + v(iQ121, iQ119, iQ122) + this.f59552j[9] + 1548603684, 15) + iQ120;
        int iQ124 = q(iQ119, 10);
        int iQ125 = q(iQ120 + v(iQ123, iQ121, iQ124) + this.f59552j[1] + 1548603684, 13) + iQ122;
        int iQ126 = q(iQ121, 10);
        int iQ127 = q(iQ122 + v(iQ125, iQ123, iQ126) + this.f59552j[2] + 1548603684, 11) + iQ124;
        int iQ128 = q(iQ123, 10);
        int iQ129 = q(iQ92 + u(iQ95, iQ93, iQ96) + this.f59552j[3] + 1859775393, 11) + iQ94;
        int iQ130 = q(iQ93, 10);
        int iQ131 = q(iQ94 + u(iQ129, iQ95, iQ130) + this.f59552j[10] + 1859775393, 13) + iQ96;
        int iQ132 = q(iQ95, 10);
        int iQ133 = q(iQ96 + u(iQ131, iQ129, iQ132) + this.f59552j[14] + 1859775393, 6) + iQ130;
        int iQ134 = q(iQ129, 10);
        int iQ135 = q(iQ130 + u(iQ133, iQ131, iQ134) + this.f59552j[4] + 1859775393, 7) + iQ132;
        int iQ136 = q(iQ131, 10);
        int iQ137 = q(iQ132 + u(iQ135, iQ133, iQ136) + this.f59552j[9] + 1859775393, 14) + iQ134;
        int iQ138 = q(iQ133, 10);
        int iQ139 = q(iQ134 + u(iQ137, iQ135, iQ138) + this.f59552j[15] + 1859775393, 9) + iQ136;
        int iQ140 = q(iQ135, 10);
        int iQ141 = q(iQ136 + u(iQ139, iQ137, iQ140) + this.f59552j[8] + 1859775393, 13) + iQ138;
        int iQ142 = q(iQ137, 10);
        int iQ143 = q(iQ138 + u(iQ141, iQ139, iQ142) + this.f59552j[1] + 1859775393, 15) + iQ140;
        int iQ144 = q(iQ139, 10);
        int iQ145 = q(iQ140 + u(iQ143, iQ141, iQ144) + this.f59552j[2] + 1859775393, 14) + iQ142;
        int iQ146 = q(iQ141, 10);
        int iQ147 = q(iQ142 + u(iQ145, iQ143, iQ146) + this.f59552j[7] + 1859775393, 8) + iQ144;
        int iQ148 = q(iQ143, 10);
        int iQ149 = q(iQ144 + u(iQ147, iQ145, iQ148) + this.f59552j[0] + 1859775393, 13) + iQ146;
        int iQ150 = q(iQ145, 10);
        int iQ151 = q(iQ146 + u(iQ149, iQ147, iQ150) + this.f59552j[6] + 1859775393, 6) + iQ148;
        int iQ152 = q(iQ147, 10);
        int iQ153 = q(iQ148 + u(iQ151, iQ149, iQ152) + this.f59552j[13] + 1859775393, 5) + iQ150;
        int iQ154 = q(iQ149, 10);
        int iQ155 = q(iQ150 + u(iQ153, iQ151, iQ154) + this.f59552j[11] + 1859775393, 12) + iQ152;
        int iQ156 = q(iQ151, 10);
        int iQ157 = q(iQ152 + u(iQ155, iQ153, iQ156) + this.f59552j[5] + 1859775393, 7) + iQ154;
        int iQ158 = q(iQ153, 10);
        int iQ159 = q(iQ154 + u(iQ157, iQ155, iQ158) + this.f59552j[12] + 1859775393, 5) + iQ156;
        int iQ160 = q(iQ155, 10);
        int iQ161 = q(iQ124 + u(iQ127, iQ125, iQ128) + this.f59552j[15] + 1836072691, 9) + iQ126;
        int iQ162 = q(iQ125, 10);
        int iQ163 = q(iQ126 + u(iQ161, iQ127, iQ162) + this.f59552j[5] + 1836072691, 7) + iQ128;
        int iQ164 = q(iQ127, 10);
        int iQ165 = q(iQ128 + u(iQ163, iQ161, iQ164) + this.f59552j[1] + 1836072691, 15) + iQ162;
        int iQ166 = q(iQ161, 10);
        int iQ167 = q(iQ162 + u(iQ165, iQ163, iQ166) + this.f59552j[3] + 1836072691, 11) + iQ164;
        int iQ168 = q(iQ163, 10);
        int iQ169 = q(iQ164 + u(iQ167, iQ165, iQ168) + this.f59552j[7] + 1836072691, 8) + iQ166;
        int iQ170 = q(iQ165, 10);
        int iQ171 = q(iQ166 + u(iQ169, iQ167, iQ170) + this.f59552j[14] + 1836072691, 6) + iQ168;
        int iQ172 = q(iQ167, 10);
        int iQ173 = q(iQ168 + u(iQ171, iQ169, iQ172) + this.f59552j[6] + 1836072691, 6) + iQ170;
        int iQ174 = q(iQ169, 10);
        int iQ175 = q(iQ170 + u(iQ173, iQ171, iQ174) + this.f59552j[9] + 1836072691, 14) + iQ172;
        int iQ176 = q(iQ171, 10);
        int iQ177 = q(iQ172 + u(iQ175, iQ173, iQ176) + this.f59552j[11] + 1836072691, 12) + iQ174;
        int iQ178 = q(iQ173, 10);
        int iQ179 = q(iQ174 + u(iQ177, iQ175, iQ178) + this.f59552j[8] + 1836072691, 13) + iQ176;
        int iQ180 = q(iQ175, 10);
        int iQ181 = q(iQ176 + u(iQ179, iQ177, iQ180) + this.f59552j[12] + 1836072691, 5) + iQ178;
        int iQ182 = q(iQ177, 10);
        int iQ183 = q(iQ178 + u(iQ181, iQ179, iQ182) + this.f59552j[2] + 1836072691, 14) + iQ180;
        int iQ184 = q(iQ179, 10);
        int iQ185 = q(iQ180 + u(iQ183, iQ181, iQ184) + this.f59552j[10] + 1836072691, 13) + iQ182;
        int iQ186 = q(iQ181, 10);
        int iQ187 = q(iQ182 + u(iQ185, iQ183, iQ186) + this.f59552j[0] + 1836072691, 13) + iQ184;
        int iQ188 = q(iQ183, 10);
        int iQ189 = q(iQ184 + u(iQ187, iQ185, iQ188) + this.f59552j[4] + 1836072691, 7) + iQ186;
        int iQ190 = q(iQ185, 10);
        int iQ191 = q(iQ186 + u(iQ189, iQ187, iQ190) + this.f59552j[13] + 1836072691, 5) + iQ188;
        int iQ192 = q(iQ187, 10);
        int iQ193 = q(((iQ156 + v(iQ159, iQ157, iQ160)) + this.f59552j[1]) - 1894007588, 11) + iQ158;
        int iQ194 = q(iQ157, 10);
        int iQ195 = q(((iQ158 + v(iQ193, iQ159, iQ194)) + this.f59552j[9]) - 1894007588, 12) + iQ160;
        int iQ196 = q(iQ159, 10);
        int iQ197 = q(((iQ160 + v(iQ195, iQ193, iQ196)) + this.f59552j[11]) - 1894007588, 14) + iQ194;
        int iQ198 = q(iQ193, 10);
        int iQ199 = q(((iQ194 + v(iQ197, iQ195, iQ198)) + this.f59552j[10]) - 1894007588, 15) + iQ196;
        int iQ200 = q(iQ195, 10);
        int iQ201 = q(((iQ196 + v(iQ199, iQ197, iQ200)) + this.f59552j[0]) - 1894007588, 14) + iQ198;
        int iQ202 = q(iQ197, 10);
        int iQ203 = q(((iQ198 + v(iQ201, iQ199, iQ202)) + this.f59552j[8]) - 1894007588, 15) + iQ200;
        int iQ204 = q(iQ199, 10);
        int iQ205 = q(((iQ200 + v(iQ203, iQ201, iQ204)) + this.f59552j[12]) - 1894007588, 9) + iQ202;
        int iQ206 = q(iQ201, 10);
        int iQ207 = q(((iQ202 + v(iQ205, iQ203, iQ206)) + this.f59552j[4]) - 1894007588, 8) + iQ204;
        int iQ208 = q(iQ203, 10);
        int iQ209 = q(((iQ204 + v(iQ207, iQ205, iQ208)) + this.f59552j[13]) - 1894007588, 9) + iQ206;
        int iQ210 = q(iQ205, 10);
        int iQ211 = q(((iQ206 + v(iQ209, iQ207, iQ210)) + this.f59552j[3]) - 1894007588, 14) + iQ208;
        int iQ212 = q(iQ207, 10);
        int iQ213 = q(((iQ208 + v(iQ211, iQ209, iQ212)) + this.f59552j[7]) - 1894007588, 5) + iQ210;
        int iQ214 = q(iQ209, 10);
        int iQ215 = q(((iQ210 + v(iQ213, iQ211, iQ214)) + this.f59552j[15]) - 1894007588, 6) + iQ212;
        int iQ216 = q(iQ211, 10);
        int iQ217 = q(((iQ212 + v(iQ215, iQ213, iQ216)) + this.f59552j[14]) - 1894007588, 8) + iQ214;
        int iQ218 = q(iQ213, 10);
        int iQ219 = q(((iQ214 + v(iQ217, iQ215, iQ218)) + this.f59552j[5]) - 1894007588, 6) + iQ216;
        int iQ220 = q(iQ215, 10);
        int iQ221 = q(((iQ216 + v(iQ219, iQ217, iQ220)) + this.f59552j[6]) - 1894007588, 5) + iQ218;
        int iQ222 = q(iQ217, 10);
        int iQ223 = q(((iQ218 + v(iQ221, iQ219, iQ222)) + this.f59552j[2]) - 1894007588, 12) + iQ220;
        int iQ224 = q(iQ219, 10);
        int iQ225 = q(iQ188 + t(iQ191, iQ189, iQ192) + this.f59552j[8] + 2053994217, 15) + iQ190;
        int iQ226 = q(iQ189, 10);
        int iQ227 = q(iQ190 + t(iQ225, iQ191, iQ226) + this.f59552j[6] + 2053994217, 5) + iQ192;
        int iQ228 = q(iQ191, 10);
        int iQ229 = q(iQ192 + t(iQ227, iQ225, iQ228) + this.f59552j[4] + 2053994217, 8) + iQ226;
        int iQ230 = q(iQ225, 10);
        int iQ231 = q(iQ226 + t(iQ229, iQ227, iQ230) + this.f59552j[1] + 2053994217, 11) + iQ228;
        int iQ232 = q(iQ227, 10);
        int iQ233 = q(iQ228 + t(iQ231, iQ229, iQ232) + this.f59552j[3] + 2053994217, 14) + iQ230;
        int iQ234 = q(iQ229, 10);
        int iQ235 = q(iQ230 + t(iQ233, iQ231, iQ234) + this.f59552j[11] + 2053994217, 14) + iQ232;
        int iQ236 = q(iQ231, 10);
        int iQ237 = q(iQ232 + t(iQ235, iQ233, iQ236) + this.f59552j[15] + 2053994217, 6) + iQ234;
        int iQ238 = q(iQ233, 10);
        int iQ239 = q(iQ234 + t(iQ237, iQ235, iQ238) + this.f59552j[0] + 2053994217, 14) + iQ236;
        int iQ240 = q(iQ235, 10);
        int iQ241 = q(iQ236 + t(iQ239, iQ237, iQ240) + this.f59552j[5] + 2053994217, 6) + iQ238;
        int iQ242 = q(iQ237, 10);
        int iQ243 = q(iQ238 + t(iQ241, iQ239, iQ242) + this.f59552j[12] + 2053994217, 9) + iQ240;
        int iQ244 = q(iQ239, 10);
        int iQ245 = q(iQ240 + t(iQ243, iQ241, iQ244) + this.f59552j[2] + 2053994217, 12) + iQ242;
        int iQ246 = q(iQ241, 10);
        int iQ247 = q(iQ242 + t(iQ245, iQ243, iQ246) + this.f59552j[13] + 2053994217, 9) + iQ244;
        int iQ248 = q(iQ243, 10);
        int iQ249 = q(iQ244 + t(iQ247, iQ245, iQ248) + this.f59552j[9] + 2053994217, 12) + iQ246;
        int iQ250 = q(iQ245, 10);
        int iQ251 = q(iQ246 + t(iQ249, iQ247, iQ250) + this.f59552j[7] + 2053994217, 5) + iQ248;
        int iQ252 = q(iQ247, 10);
        int iQ253 = q(iQ248 + t(iQ251, iQ249, iQ252) + this.f59552j[10] + 2053994217, 15) + iQ250;
        int iQ254 = q(iQ249, 10);
        int iQ255 = q(iQ250 + t(iQ253, iQ251, iQ254) + this.f59552j[14] + 2053994217, 8) + iQ252;
        int iQ256 = q(iQ251, 10);
        int iQ257 = q(((iQ220 + w(iQ223, iQ221, iQ224)) + this.f59552j[4]) - 1454113458, 9) + iQ222;
        int iQ258 = q(iQ221, 10);
        int iQ259 = q(((iQ222 + w(iQ257, iQ223, iQ258)) + this.f59552j[0]) - 1454113458, 15) + iQ224;
        int iQ260 = q(iQ223, 10);
        int iQ261 = q(((iQ224 + w(iQ259, iQ257, iQ260)) + this.f59552j[5]) - 1454113458, 5) + iQ258;
        int iQ262 = q(iQ257, 10);
        int iQ263 = q(((iQ258 + w(iQ261, iQ259, iQ262)) + this.f59552j[9]) - 1454113458, 11) + iQ260;
        int iQ264 = q(iQ259, 10);
        int iQ265 = q(((iQ260 + w(iQ263, iQ261, iQ264)) + this.f59552j[7]) - 1454113458, 6) + iQ262;
        int iQ266 = q(iQ261, 10);
        int iQ267 = q(((iQ262 + w(iQ265, iQ263, iQ266)) + this.f59552j[12]) - 1454113458, 8) + iQ264;
        int iQ268 = q(iQ263, 10);
        int iQ269 = q(((iQ264 + w(iQ267, iQ265, iQ268)) + this.f59552j[2]) - 1454113458, 13) + iQ266;
        int iQ270 = q(iQ265, 10);
        int iQ271 = q(((iQ266 + w(iQ269, iQ267, iQ270)) + this.f59552j[10]) - 1454113458, 12) + iQ268;
        int iQ272 = q(iQ267, 10);
        int iQ273 = q(((iQ268 + w(iQ271, iQ269, iQ272)) + this.f59552j[14]) - 1454113458, 5) + iQ270;
        int iQ274 = q(iQ269, 10);
        int iQ275 = q(((iQ270 + w(iQ273, iQ271, iQ274)) + this.f59552j[1]) - 1454113458, 12) + iQ272;
        int iQ276 = q(iQ271, 10);
        int iQ277 = q(((iQ272 + w(iQ275, iQ273, iQ276)) + this.f59552j[3]) - 1454113458, 13) + iQ274;
        int iQ278 = q(iQ273, 10);
        int iQ279 = q(((iQ274 + w(iQ277, iQ275, iQ278)) + this.f59552j[8]) - 1454113458, 14) + iQ276;
        int iQ280 = q(iQ275, 10);
        int iQ281 = q(((iQ276 + w(iQ279, iQ277, iQ280)) + this.f59552j[11]) - 1454113458, 11) + iQ278;
        int iQ282 = q(iQ277, 10);
        int iQ283 = q(((iQ278 + w(iQ281, iQ279, iQ282)) + this.f59552j[6]) - 1454113458, 8) + iQ280;
        int iQ284 = q(iQ279, 10);
        int iQ285 = q(((iQ280 + w(iQ283, iQ281, iQ284)) + this.f59552j[15]) - 1454113458, 5) + iQ282;
        int iQ286 = q(iQ281, 10);
        int iQ287 = q(((iQ282 + w(iQ285, iQ283, iQ286)) + this.f59552j[13]) - 1454113458, 6) + iQ284;
        int iQ288 = q(iQ283, 10);
        int iQ289 = q(iQ252 + s(iQ255, iQ253, iQ256) + this.f59552j[12], 8) + iQ254;
        int iQ290 = q(iQ253, 10);
        int iQ291 = q(iQ254 + s(iQ289, iQ255, iQ290) + this.f59552j[15], 5) + iQ256;
        int iQ292 = q(iQ255, 10);
        int iQ293 = q(iQ256 + s(iQ291, iQ289, iQ292) + this.f59552j[10], 12) + iQ290;
        int iQ294 = q(iQ289, 10);
        int iQ295 = q(iQ290 + s(iQ293, iQ291, iQ294) + this.f59552j[4], 9) + iQ292;
        int iQ296 = q(iQ291, 10);
        int iQ297 = q(iQ292 + s(iQ295, iQ293, iQ296) + this.f59552j[1], 12) + iQ294;
        int iQ298 = q(iQ293, 10);
        int iQ299 = q(iQ294 + s(iQ297, iQ295, iQ298) + this.f59552j[5], 5) + iQ296;
        int iQ300 = q(iQ295, 10);
        int iQ301 = q(iQ296 + s(iQ299, iQ297, iQ300) + this.f59552j[8], 14) + iQ298;
        int iQ302 = q(iQ297, 10);
        int iQ303 = q(iQ298 + s(iQ301, iQ299, iQ302) + this.f59552j[7], 6) + iQ300;
        int iQ304 = q(iQ299, 10);
        int iQ305 = q(iQ300 + s(iQ303, iQ301, iQ304) + this.f59552j[6], 8) + iQ302;
        int iQ306 = q(iQ301, 10);
        int iQ307 = q(iQ302 + s(iQ305, iQ303, iQ306) + this.f59552j[2], 13) + iQ304;
        int iQ308 = q(iQ303, 10);
        int iQ309 = q(iQ304 + s(iQ307, iQ305, iQ308) + this.f59552j[13], 6) + iQ306;
        int iQ310 = q(iQ305, 10);
        int iQ311 = q(iQ306 + s(iQ309, iQ307, iQ310) + this.f59552j[14], 5) + iQ308;
        int iQ312 = q(iQ307, 10);
        int iQ313 = q(iQ308 + s(iQ311, iQ309, iQ312) + this.f59552j[0], 15) + iQ310;
        int iQ314 = q(iQ309, 10);
        int iQ315 = q(iQ310 + s(iQ313, iQ311, iQ314) + this.f59552j[3], 13) + iQ312;
        int iQ316 = q(iQ311, 10);
        int iQ317 = q(iQ312 + s(iQ315, iQ313, iQ316) + this.f59552j[9], 11) + iQ314;
        int iQ318 = q(iQ313, 10);
        int iQ319 = q(iQ314 + s(iQ317, iQ315, iQ318) + this.f59552j[11], 11) + iQ316;
        int iQ320 = q(iQ315, 10) + iQ285 + this.f59548f;
        this.f59548f = this.f59549g + iQ288 + iQ318;
        this.f59549g = this.f59550h + iQ286 + iQ316;
        this.f59550h = this.f59551i + iQ284 + iQ319;
        this.f59551i = this.f59547e + iQ287 + iQ317;
        this.f59547e = iQ320;
        this.f59553k = 0;
        int i15 = 0;
        while (true) {
            int[] iArr = this.f59552j;
            if (i15 == iArr.length) {
                return;
            }
            iArr[i15] = 0;
            i15++;
        }
    }

    @Override // zo.l
    public void o(long j10) {
        if (this.f59553k > 14) {
            n();
        }
        int[] iArr = this.f59552j;
        iArr[14] = (int) ((-1) & j10);
        iArr[15] = (int) (j10 >>> 32);
    }

    @Override // zo.l
    public void p(byte[] bArr, int i10) {
        int[] iArr = this.f59552j;
        int i11 = this.f59553k;
        int i12 = i11 + 1;
        this.f59553k = i12;
        iArr[i11] = ((bArr[i10 + 3] & 255) << 24) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16);
        if (i12 == 16) {
            n();
        }
    }

    public final int q(int i10, int i11) {
        return (i10 >>> (32 - i11)) | (i10 << i11);
    }

    public final void r(z zVar) {
        super.k(zVar);
        this.f59547e = zVar.f59547e;
        this.f59548f = zVar.f59548f;
        this.f59549g = zVar.f59549g;
        this.f59550h = zVar.f59550h;
        this.f59551i = zVar.f59551i;
        int[] iArr = zVar.f59552j;
        System.arraycopy(iArr, 0, this.f59552j, 0, iArr.length);
        this.f59553k = zVar.f59553k;
    }

    @Override // zo.l, org.bouncycastle.crypto.s
    public void reset() {
        super.reset();
        this.f59547e = 1732584193;
        this.f59548f = -271733879;
        this.f59549g = -1732584194;
        this.f59550h = 271733878;
        this.f59551i = -1009589776;
        this.f59553k = 0;
        int i10 = 0;
        while (true) {
            int[] iArr = this.f59552j;
            if (i10 == iArr.length) {
                return;
            }
            iArr[i10] = 0;
            i10++;
        }
    }

    public final int s(int i10, int i11, int i12) {
        return (i10 ^ i11) ^ i12;
    }

    public final int t(int i10, int i11, int i12) {
        return ((~i10) & i12) | (i11 & i10);
    }

    public final int u(int i10, int i11, int i12) {
        return (i10 | (~i11)) ^ i12;
    }

    public final int v(int i10, int i11, int i12) {
        return (i10 & i12) | (i11 & (~i12));
    }

    public final int w(int i10, int i11, int i12) {
        return i10 ^ (i11 | (~i12));
    }

    public final void x(int i10, byte[] bArr, int i11) {
        bArr[i11] = (byte) i10;
        bArr[i11 + 1] = (byte) (i10 >>> 8);
        bArr[i11 + 2] = (byte) (i10 >>> 16);
        bArr[i11 + 3] = (byte) (i10 >>> 24);
    }
}
