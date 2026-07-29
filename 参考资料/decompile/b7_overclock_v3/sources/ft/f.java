package ft;

import com.blankj.utilcode.util.i0;
import com.google.common.primitives.Shorts;
import com.tencent.connect.common.Constants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.math.BigInteger;
import java.util.Random;

/* JADX INFO: loaded from: classes6.dex */
public class f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Random f28758d = new Random();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final boolean[] f28759e = {false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final short[] f28760f = {0, 1, 4, 5, 16, 17, 20, 21, 64, 65, 68, 69, 80, 81, 84, 85, 256, 257, 260, 261, 272, 273, 276, 277, 320, 321, 324, 325, 336, 337, 340, 341, com.google.android.exoplayer2.audio.j.f16900w, 1025, 1028, 1029, 1040, 1041, 1044, 1045, 1088, 1089, 1092, 1093, 1104, 1105, 1108, 1109, 1280, 1281, 1284, 1285, 1296, 1297, 1300, 1301, 1344, 1345, 1348, 1349, 1360, 1361, 1364, 1365, 4096, 4097, 4100, 4101, 4112, 4113, 4116, 4117, 4160, 4161, 4164, 4165, 4176, 4177, 4180, 4181, 4352, 4353, 4356, 4357, 4368, 4369, 4372, 4373, 4416, 4417, 4420, 4421, 4432, 4433, 4436, 4437, 5120, 5121, 5124, 5125, 5136, 5137, 5140, 5141, 5184, 5185, 5188, 5189, 5200, 5201, 5204, 5205, 5376, 5377, 5380, 5381, 5392, 5393, 5396, 5397, 5440, 5441, 5444, 5445, 5456, 5457, 5460, 5461, Shorts.MAX_POWER_OF_TWO, 16385, 16388, 16389, 16400, 16401, 16404, 16405, 16448, 16449, 16452, 16453, 16464, 16465, 16468, 16469, 16640, 16641, 16644, 16645, 16656, 16657, 16660, 16661, 16704, 16705, 16708, 16709, 16720, 16721, 16724, 16725, 17408, 17409, 17412, 17413, 17424, 17425, 17428, 17429, 17472, 17473, 17476, 17477, 17488, 17489, 17492, 17493, 17664, 17665, 17668, 17669, 17680, 17681, 17684, 17685, 17728, 17729, 17732, 17733, 17744, 17745, 17748, 17749, 20480, 20481, 20484, 20485, 20496, 20497, 20500, 20501, 20544, 20545, 20548, 20549, 20560, 20561, 20564, 20565, 20736, 20737, 20740, 20741, 20752, 20753, 20756, 20757, 20800, 20801, 20804, 20805, 20816, 20817, 20820, 20821, 21504, 21505, 21508, 21509, 21520, 21521, 21524, 21525, 21568, 21569, 21572, 21573, 21584, 21585, 21588, 21589, 21760, 21761, 21764, 21765, 21776, 21777, 21780, 21781, 21824, 21825, 21828, 21829, 21840, 21841, 21844, 21845};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int[] f28761g = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288, 1048576, 2097152, 4194304, 8388608, 16777216, CommonNetImpl.FLAG_SHARE_JUMP, 67108864, 134217728, 268435456, 536870912, 1073741824, Integer.MIN_VALUE, 0};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int[] f28762h = {0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, gg.b.f29413a, 65535, 131071, ns.o.f42676c, os.i.f46229g, os.i.A, os.j.f46261g, os.j.f46280z, 8388607, 16777215, nr.b.f42626c, nr.b.f42627d, 134217727, nr.d.f42636b, 536870911, 1073741823, Integer.MAX_VALUE, -1};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f28764b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[] f28765c;

    public f(int i10) {
        i10 = i10 < 1 ? 1 : i10;
        int i11 = ((i10 - 1) >> 5) + 1;
        this.f28764b = i11;
        this.f28765c = new int[i11];
        this.f28763a = i10;
    }

    public f(int i10, String str) {
        i10 = i10 < 1 ? 1 : i10;
        int i11 = ((i10 - 1) >> 5) + 1;
        this.f28764b = i11;
        this.f28765c = new int[i11];
        this.f28763a = i10;
        if (str.equalsIgnoreCase("ZERO")) {
            f();
            return;
        }
        if (str.equalsIgnoreCase("ONE")) {
            d();
            return;
        }
        if (str.equalsIgnoreCase("RANDOM")) {
            B();
            return;
        }
        if (str.equalsIgnoreCase("X")) {
            e();
            return;
        }
        if (str.equalsIgnoreCase("ALL")) {
            c();
            return;
        }
        throw new IllegalArgumentException("Error: GF2Polynomial was called using " + str + " as value!");
    }

    public f(int i10, BigInteger bigInteger) {
        i10 = i10 < 1 ? 1 : i10;
        int i11 = ((i10 - 1) >> 5) + 1;
        this.f28764b = i11;
        this.f28765c = new int[i11];
        this.f28763a = i10;
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray[0] == 0) {
            int length = byteArray.length - 1;
            byte[] bArr = new byte[length];
            System.arraycopy(byteArray, 1, bArr, 0, length);
            byteArray = bArr;
        }
        int length2 = byteArray.length & 3;
        int length3 = ((byteArray.length - 1) >> 2) + 1;
        for (int i12 = 0; i12 < length2; i12++) {
            int[] iArr = this.f28765c;
            int i13 = length3 - 1;
            iArr[i13] = iArr[i13] | ((byteArray[i12] & 255) << (((length2 - 1) - i12) << 3));
        }
        for (int i14 = 0; i14 <= ((byteArray.length - 4) >> 2); i14++) {
            int length4 = (byteArray.length - 1) - (i14 << 2);
            int[] iArr2 = this.f28765c;
            iArr2[i14] = byteArray[length4] & 255;
            iArr2[i14] = iArr2[i14] | ((byteArray[length4 - 1] << 8) & 65280);
            iArr2[i14] = iArr2[i14] | ((byteArray[length4 - 2] << 16) & 16711680);
            iArr2[i14] = ((byteArray[length4 - 3] << 24) & (-16777216)) | iArr2[i14];
        }
        int i15 = this.f28763a;
        if ((i15 & 31) != 0) {
            int[] iArr3 = this.f28765c;
            int i16 = this.f28764b - 1;
            iArr3[i16] = f28762h[i15 & 31] & iArr3[i16];
        }
        D();
    }

    public f(int i10, Random random) {
        i10 = i10 < 1 ? 1 : i10;
        int i11 = ((i10 - 1) >> 5) + 1;
        this.f28764b = i11;
        this.f28765c = new int[i11];
        this.f28763a = i10;
        C(random);
    }

    public f(int i10, byte[] bArr) {
        int i11;
        i10 = i10 < 1 ? 1 : i10;
        int i12 = ((i10 - 1) >> 5) + 1;
        this.f28764b = i12;
        this.f28765c = new int[i12];
        this.f28763a = i10;
        int iMin = Math.min(((bArr.length - 1) >> 2) + 1, i12);
        int i13 = 0;
        while (true) {
            i11 = iMin - 1;
            if (i13 >= i11) {
                break;
            }
            int length = (bArr.length - (i13 << 2)) - 1;
            int[] iArr = this.f28765c;
            iArr[i13] = bArr[length] & 255;
            iArr[i13] = (65280 & (bArr[length - 1] << 8)) | iArr[i13];
            iArr[i13] = (16711680 & (bArr[length - 2] << 16)) | iArr[i13];
            iArr[i13] = ((bArr[length - 3] << 24) & (-16777216)) | iArr[i13];
            i13++;
        }
        int length2 = (bArr.length - (i11 << 2)) - 1;
        int[] iArr2 = this.f28765c;
        iArr2[i11] = bArr[length2] & 255;
        if (length2 > 0) {
            iArr2[i11] = (65280 & (bArr[length2 - 1] << 8)) | iArr2[i11];
        }
        if (length2 > 1) {
            iArr2[i11] = iArr2[i11] | (16711680 & (bArr[length2 - 2] << 16));
        }
        if (length2 > 2) {
            iArr2[i11] = ((bArr[length2 - 3] << 24) & (-16777216)) | iArr2[i11];
        }
        e0();
        D();
    }

    public f(int i10, int[] iArr) {
        i10 = i10 < 1 ? 1 : i10;
        int i11 = ((i10 - 1) >> 5) + 1;
        this.f28764b = i11;
        this.f28765c = new int[i11];
        this.f28763a = i10;
        System.arraycopy(iArr, 0, this.f28765c, 0, Math.min(i11, iArr.length));
        e0();
    }

    public f(f fVar) {
        this.f28763a = fVar.f28763a;
        this.f28764b = fVar.f28764b;
        this.f28765c = t.a(fVar.f28765c);
    }

    public static int[] t(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[8];
        int[] iArr4 = new int[2];
        System.arraycopy(iArr, 0, iArr4, 0, Math.min(2, iArr.length));
        int[] iArr5 = new int[2];
        if (iArr.length > 2) {
            System.arraycopy(iArr, 2, iArr5, 0, Math.min(2, iArr.length - 2));
        }
        int[] iArr6 = new int[2];
        System.arraycopy(iArr2, 0, iArr6, 0, Math.min(2, iArr2.length));
        int[] iArr7 = new int[2];
        if (iArr2.length > 2) {
            System.arraycopy(iArr2, 2, iArr7, 0, Math.min(2, iArr2.length - 2));
        }
        if (iArr5[1] != 0 || iArr7[1] != 0) {
            int[] iArrX = x(iArr5, iArr7);
            iArr3[7] = iArr3[7] ^ iArrX[3];
            iArr3[6] = iArr3[6] ^ iArrX[2];
            iArr3[5] = iArr3[5] ^ (iArrX[1] ^ iArrX[3]);
            iArr3[4] = iArr3[4] ^ (iArrX[0] ^ iArrX[2]);
            iArr3[3] = iArr3[3] ^ iArrX[1];
            iArr3[2] = iArrX[0] ^ iArr3[2];
        } else if (iArr5[0] != 0 || iArr7[0] != 0) {
            int[] iArrV = v(iArr5[0], iArr7[0]);
            iArr3[5] = iArr3[5] ^ iArrV[1];
            iArr3[4] = iArr3[4] ^ iArrV[0];
            iArr3[3] = iArr3[3] ^ iArrV[1];
            iArr3[2] = iArrV[0] ^ iArr3[2];
        }
        iArr5[0] = iArr5[0] ^ iArr4[0];
        iArr5[1] = iArr5[1] ^ iArr4[1];
        iArr7[0] = iArr7[0] ^ iArr6[0];
        iArr7[1] = iArr7[1] ^ iArr6[1];
        if (iArr5[1] == 0 && iArr7[1] == 0) {
            int[] iArrV2 = v(iArr5[0], iArr7[0]);
            iArr3[3] = iArr3[3] ^ iArrV2[1];
            iArr3[2] = iArrV2[0] ^ iArr3[2];
        } else {
            int[] iArrX2 = x(iArr5, iArr7);
            iArr3[5] = iArr3[5] ^ iArrX2[3];
            iArr3[4] = iArr3[4] ^ iArrX2[2];
            iArr3[3] = iArr3[3] ^ iArrX2[1];
            iArr3[2] = iArrX2[0] ^ iArr3[2];
        }
        if (iArr4[1] == 0 && iArr6[1] == 0) {
            int[] iArrV3 = v(iArr4[0], iArr6[0]);
            iArr3[3] = iArr3[3] ^ iArrV3[1];
            iArr3[2] = iArr3[2] ^ iArrV3[0];
            iArr3[1] = iArr3[1] ^ iArrV3[1];
            iArr3[0] = iArrV3[0] ^ iArr3[0];
        } else {
            int[] iArrX3 = x(iArr4, iArr6);
            iArr3[5] = iArr3[5] ^ iArrX3[3];
            iArr3[4] = iArr3[4] ^ iArrX3[2];
            iArr3[3] = iArr3[3] ^ (iArrX3[1] ^ iArrX3[3]);
            iArr3[2] = iArr3[2] ^ (iArrX3[0] ^ iArrX3[2]);
            iArr3[1] = iArr3[1] ^ iArrX3[1];
            iArr3[0] = iArrX3[0] ^ iArr3[0];
        }
        return iArr3;
    }

    public static int[] u(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[16];
        int[] iArr4 = new int[4];
        System.arraycopy(iArr, 0, iArr4, 0, Math.min(4, iArr.length));
        int[] iArr5 = new int[4];
        if (iArr.length > 4) {
            System.arraycopy(iArr, 4, iArr5, 0, Math.min(4, iArr.length - 4));
        }
        int[] iArr6 = new int[4];
        System.arraycopy(iArr2, 0, iArr6, 0, Math.min(4, iArr2.length));
        int[] iArr7 = new int[4];
        if (iArr2.length > 4) {
            System.arraycopy(iArr2, 4, iArr7, 0, Math.min(4, iArr2.length - 4));
        }
        if (iArr5[3] != 0 || iArr5[2] != 0 || iArr7[3] != 0 || iArr7[2] != 0) {
            int[] iArrT = t(iArr5, iArr7);
            iArr3[15] = iArr3[15] ^ iArrT[7];
            iArr3[14] = iArr3[14] ^ iArrT[6];
            iArr3[13] = iArr3[13] ^ iArrT[5];
            iArr3[12] = iArr3[12] ^ iArrT[4];
            iArr3[11] = iArr3[11] ^ (iArrT[3] ^ iArrT[7]);
            iArr3[10] = iArr3[10] ^ (iArrT[2] ^ iArrT[6]);
            iArr3[9] = iArr3[9] ^ (iArrT[1] ^ iArrT[5]);
            iArr3[8] = iArr3[8] ^ (iArrT[0] ^ iArrT[4]);
            iArr3[7] = iArr3[7] ^ iArrT[3];
            iArr3[6] = iArr3[6] ^ iArrT[2];
            iArr3[5] = iArr3[5] ^ iArrT[1];
            iArr3[4] = iArrT[0] ^ iArr3[4];
        } else if (iArr5[1] != 0 || iArr7[1] != 0) {
            int[] iArrX = x(iArr5, iArr7);
            iArr3[11] = iArr3[11] ^ iArrX[3];
            iArr3[10] = iArr3[10] ^ iArrX[2];
            iArr3[9] = iArr3[9] ^ iArrX[1];
            iArr3[8] = iArr3[8] ^ iArrX[0];
            iArr3[7] = iArr3[7] ^ iArrX[3];
            iArr3[6] = iArr3[6] ^ iArrX[2];
            iArr3[5] = iArr3[5] ^ iArrX[1];
            iArr3[4] = iArrX[0] ^ iArr3[4];
        } else if (iArr5[0] != 0 || iArr7[0] != 0) {
            int[] iArrV = v(iArr5[0], iArr7[0]);
            iArr3[9] = iArr3[9] ^ iArrV[1];
            iArr3[8] = iArr3[8] ^ iArrV[0];
            iArr3[5] = iArr3[5] ^ iArrV[1];
            iArr3[4] = iArrV[0] ^ iArr3[4];
        }
        iArr5[0] = iArr5[0] ^ iArr4[0];
        iArr5[1] = iArr5[1] ^ iArr4[1];
        iArr5[2] = iArr5[2] ^ iArr4[2];
        iArr5[3] = iArr5[3] ^ iArr4[3];
        iArr7[0] = iArr7[0] ^ iArr6[0];
        iArr7[1] = iArr7[1] ^ iArr6[1];
        iArr7[2] = iArr7[2] ^ iArr6[2];
        iArr7[3] = iArr7[3] ^ iArr6[3];
        int[] iArrT2 = t(iArr5, iArr7);
        iArr3[11] = iArr3[11] ^ iArrT2[7];
        iArr3[10] = iArr3[10] ^ iArrT2[6];
        iArr3[9] = iArr3[9] ^ iArrT2[5];
        iArr3[8] = iArr3[8] ^ iArrT2[4];
        iArr3[7] = iArr3[7] ^ iArrT2[3];
        iArr3[6] = iArr3[6] ^ iArrT2[2];
        iArr3[5] = iArr3[5] ^ iArrT2[1];
        iArr3[4] = iArrT2[0] ^ iArr3[4];
        int[] iArrT3 = t(iArr4, iArr6);
        iArr3[11] = iArr3[11] ^ iArrT3[7];
        iArr3[10] = iArr3[10] ^ iArrT3[6];
        iArr3[9] = iArr3[9] ^ iArrT3[5];
        iArr3[8] = iArr3[8] ^ iArrT3[4];
        iArr3[7] = iArr3[7] ^ (iArrT3[3] ^ iArrT3[7]);
        iArr3[6] = iArr3[6] ^ (iArrT3[2] ^ iArrT3[6]);
        iArr3[5] = iArr3[5] ^ (iArrT3[1] ^ iArrT3[5]);
        iArr3[4] = iArr3[4] ^ (iArrT3[0] ^ iArrT3[4]);
        iArr3[3] = iArr3[3] ^ iArrT3[3];
        iArr3[2] = iArr3[2] ^ iArrT3[2];
        iArr3[1] = iArr3[1] ^ iArrT3[1];
        iArr3[0] = iArrT3[0] ^ iArr3[0];
        return iArr3;
    }

    public static int[] v(int i10, int i11) {
        int[] iArr = new int[2];
        if (i10 != 0 && i11 != 0) {
            long j10 = ((long) i11) & 4294967295L;
            long j11 = 0;
            for (int i12 = 1; i12 <= 32; i12++) {
                if ((f28761g[i12 - 1] & i10) != 0) {
                    j11 ^= j10;
                }
                j10 <<= 1;
            }
            iArr[1] = (int) (j11 >>> 32);
            iArr[0] = (int) (j11 & 4294967295L);
        }
        return iArr;
    }

    public static int[] w(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[32];
        int[] iArr4 = new int[8];
        System.arraycopy(iArr, 0, iArr4, 0, Math.min(8, iArr.length));
        int[] iArr5 = new int[8];
        if (iArr.length > 8) {
            System.arraycopy(iArr, 8, iArr5, 0, Math.min(8, iArr.length - 8));
        }
        int[] iArr6 = new int[8];
        System.arraycopy(iArr2, 0, iArr6, 0, Math.min(8, iArr2.length));
        int[] iArr7 = new int[8];
        if (iArr2.length > 8) {
            System.arraycopy(iArr2, 8, iArr7, 0, Math.min(8, iArr2.length - 8));
        }
        int[] iArrU = u(iArr5, iArr7);
        iArr3[31] = iArr3[31] ^ iArrU[15];
        iArr3[30] = iArr3[30] ^ iArrU[14];
        iArr3[29] = iArr3[29] ^ iArrU[13];
        iArr3[28] = iArr3[28] ^ iArrU[12];
        iArr3[27] = iArr3[27] ^ iArrU[11];
        iArr3[26] = iArr3[26] ^ iArrU[10];
        iArr3[25] = iArr3[25] ^ iArrU[9];
        iArr3[24] = iArr3[24] ^ iArrU[8];
        iArr3[23] = iArr3[23] ^ (iArrU[7] ^ iArrU[15]);
        iArr3[22] = iArr3[22] ^ (iArrU[6] ^ iArrU[14]);
        iArr3[21] = iArr3[21] ^ (iArrU[5] ^ iArrU[13]);
        iArr3[20] = iArr3[20] ^ (iArrU[4] ^ iArrU[12]);
        iArr3[19] = iArr3[19] ^ (iArrU[3] ^ iArrU[11]);
        iArr3[18] = iArr3[18] ^ (iArrU[2] ^ iArrU[10]);
        iArr3[17] = iArr3[17] ^ (iArrU[1] ^ iArrU[9]);
        iArr3[16] = iArr3[16] ^ (iArrU[0] ^ iArrU[8]);
        iArr3[15] = iArr3[15] ^ iArrU[7];
        iArr3[14] = iArr3[14] ^ iArrU[6];
        iArr3[13] = iArr3[13] ^ iArrU[5];
        iArr3[12] = iArr3[12] ^ iArrU[4];
        iArr3[11] = iArr3[11] ^ iArrU[3];
        iArr3[10] = iArr3[10] ^ iArrU[2];
        iArr3[9] = iArr3[9] ^ iArrU[1];
        iArr3[8] = iArr3[8] ^ iArrU[0];
        iArr5[0] = iArr5[0] ^ iArr4[0];
        iArr5[1] = iArr5[1] ^ iArr4[1];
        iArr5[2] = iArr5[2] ^ iArr4[2];
        iArr5[3] = iArr5[3] ^ iArr4[3];
        iArr5[4] = iArr5[4] ^ iArr4[4];
        iArr5[5] = iArr5[5] ^ iArr4[5];
        iArr5[6] = iArr5[6] ^ iArr4[6];
        iArr5[7] = iArr5[7] ^ iArr4[7];
        iArr7[0] = iArr7[0] ^ iArr6[0];
        iArr7[1] = iArr7[1] ^ iArr6[1];
        iArr7[2] = iArr7[2] ^ iArr6[2];
        iArr7[3] = iArr7[3] ^ iArr6[3];
        iArr7[4] = iArr7[4] ^ iArr6[4];
        iArr7[5] = iArr7[5] ^ iArr6[5];
        iArr7[6] = iArr7[6] ^ iArr6[6];
        iArr7[7] = iArr7[7] ^ iArr6[7];
        int[] iArrU2 = u(iArr5, iArr7);
        iArr3[23] = iArr3[23] ^ iArrU2[15];
        iArr3[22] = iArr3[22] ^ iArrU2[14];
        iArr3[21] = iArr3[21] ^ iArrU2[13];
        iArr3[20] = iArr3[20] ^ iArrU2[12];
        iArr3[19] = iArr3[19] ^ iArrU2[11];
        iArr3[18] = iArr3[18] ^ iArrU2[10];
        iArr3[17] = iArr3[17] ^ iArrU2[9];
        iArr3[16] = iArr3[16] ^ iArrU2[8];
        iArr3[15] = iArr3[15] ^ iArrU2[7];
        iArr3[14] = iArr3[14] ^ iArrU2[6];
        iArr3[13] = iArr3[13] ^ iArrU2[5];
        iArr3[12] = iArr3[12] ^ iArrU2[4];
        iArr3[11] = iArr3[11] ^ iArrU2[3];
        iArr3[10] = iArr3[10] ^ iArrU2[2];
        iArr3[9] = iArr3[9] ^ iArrU2[1];
        iArr3[8] = iArrU2[0] ^ iArr3[8];
        int[] iArrU3 = u(iArr4, iArr6);
        iArr3[23] = iArr3[23] ^ iArrU3[15];
        iArr3[22] = iArr3[22] ^ iArrU3[14];
        iArr3[21] = iArr3[21] ^ iArrU3[13];
        iArr3[20] = iArr3[20] ^ iArrU3[12];
        iArr3[19] = iArr3[19] ^ iArrU3[11];
        iArr3[18] = iArr3[18] ^ iArrU3[10];
        iArr3[17] = iArr3[17] ^ iArrU3[9];
        iArr3[16] = iArr3[16] ^ iArrU3[8];
        iArr3[15] = iArr3[15] ^ (iArrU3[7] ^ iArrU3[15]);
        iArr3[14] = iArr3[14] ^ (iArrU3[6] ^ iArrU3[14]);
        iArr3[13] = iArr3[13] ^ (iArrU3[5] ^ iArrU3[13]);
        iArr3[12] = iArr3[12] ^ (iArrU3[4] ^ iArrU3[12]);
        iArr3[11] = iArr3[11] ^ (iArrU3[3] ^ iArrU3[11]);
        iArr3[10] = iArr3[10] ^ (iArrU3[2] ^ iArrU3[10]);
        iArr3[9] = iArr3[9] ^ (iArrU3[1] ^ iArrU3[9]);
        iArr3[8] = iArr3[8] ^ (iArrU3[0] ^ iArrU3[8]);
        iArr3[7] = iArr3[7] ^ iArrU3[7];
        iArr3[6] = iArr3[6] ^ iArrU3[6];
        iArr3[5] = iArr3[5] ^ iArrU3[5];
        iArr3[4] = iArr3[4] ^ iArrU3[4];
        iArr3[3] = iArr3[3] ^ iArrU3[3];
        iArr3[2] = iArr3[2] ^ iArrU3[2];
        iArr3[1] = iArr3[1] ^ iArrU3[1];
        iArr3[0] = iArrU3[0] ^ iArr3[0];
        return iArr3;
    }

    public static int[] x(int[] iArr, int[] iArr2) {
        int[] iArr3 = new int[4];
        int i10 = iArr[0];
        int i11 = iArr.length > 1 ? iArr[1] : 0;
        int i12 = iArr2[0];
        int i13 = iArr2.length > 1 ? iArr2[1] : 0;
        if (i11 != 0 || i13 != 0) {
            int[] iArrV = v(i11, i13);
            iArr3[3] = iArr3[3] ^ iArrV[1];
            iArr3[2] = iArr3[2] ^ (iArrV[0] ^ iArrV[1]);
            iArr3[1] = iArrV[0] ^ iArr3[1];
        }
        int[] iArrV2 = v(i11 ^ i10, i13 ^ i12);
        iArr3[2] = iArr3[2] ^ iArrV2[1];
        iArr3[1] = iArrV2[0] ^ iArr3[1];
        int[] iArrV3 = v(i10, i12);
        iArr3[2] = iArr3[2] ^ iArrV3[1];
        iArr3[1] = iArr3[1] ^ (iArrV3[0] ^ iArrV3[1]);
        iArr3[0] = iArrV3[0] ^ iArr3[0];
        return iArr3;
    }

    public f A(f fVar) throws RuntimeException {
        f fVar2 = new f(this.f28763a);
        f fVar3 = new f(this);
        f fVar4 = new f(fVar);
        if (fVar4.q()) {
            throw new RuntimeException();
        }
        fVar3.D();
        fVar4.D();
        int i10 = fVar3.f28763a;
        int i11 = fVar4.f28763a;
        if (i10 < i11) {
            return new f(0);
        }
        int i12 = i10 - i11;
        fVar2.i(i12 + 1);
        while (i12 >= 0) {
            fVar3.T(fVar4.L(i12));
            fVar3.D();
            fVar2.c0(i12);
            i12 = fVar3.f28763a - fVar4.f28763a;
        }
        return fVar2;
    }

    public void B() {
        for (int i10 = 0; i10 < this.f28764b; i10++) {
            this.f28765c[i10] = f28758d.nextInt();
        }
        e0();
    }

    public void C(Random random) {
        for (int i10 = 0; i10 < this.f28764b; i10++) {
            this.f28765c[i10] = random.nextInt();
        }
        e0();
    }

    public void D() {
        int[] iArr;
        int i10 = this.f28764b;
        do {
            i10--;
            iArr = this.f28765c;
            if (iArr[i10] != 0) {
                break;
            }
        } while (i10 > 0);
        int i11 = iArr[i10];
        int i12 = 0;
        while (i11 != 0) {
            i11 >>>= 1;
            i12++;
        }
        this.f28763a = (i10 << 5) + i12;
        this.f28764b = i10 + 1;
    }

    public void E(int i10, int[] iArr) {
        f fVar = this;
        int i11 = i10 >>> 5;
        int i12 = i10 & 31;
        int i13 = 32 - i12;
        int i14 = (i10 - iArr[0]) >>> 5;
        int i15 = 32 - ((i10 - iArr[0]) & 31);
        int i16 = (i10 - iArr[1]) >>> 5;
        int i17 = 32 - ((i10 - iArr[1]) & 31);
        int i18 = (i10 - iArr[2]) >>> 5;
        int i19 = 32 - ((i10 - iArr[2]) & 31);
        int i20 = ((i10 << 1) - 2) >>> 5;
        while (i20 > i11) {
            int[] iArr2 = fVar.f28765c;
            long j10 = ((long) iArr2[i20]) & 4294967295L;
            int i21 = i20 - i11;
            int i22 = i21 - 1;
            int i23 = i11;
            int i24 = i12;
            iArr2[i22] = iArr2[i22] ^ ((int) (j10 << i13));
            iArr2[i21] = (int) (((long) iArr2[i21]) ^ (j10 >>> (32 - i13)));
            int i25 = i20 - i14;
            int i26 = i25 - 1;
            iArr2[i26] = iArr2[i26] ^ ((int) (j10 << i15));
            iArr2[i25] = (int) (((long) iArr2[i25]) ^ (j10 >>> (32 - i15)));
            int i27 = i20 - i16;
            int i28 = i27 - 1;
            iArr2[i28] = iArr2[i28] ^ ((int) (j10 << i17));
            iArr2[i27] = (int) (((long) iArr2[i27]) ^ (j10 >>> (32 - i17)));
            int i29 = i20 - i18;
            int i30 = i29 - 1;
            iArr2[i30] = iArr2[i30] ^ ((int) (j10 << i19));
            iArr2[i29] = (int) ((j10 >>> (32 - i19)) ^ ((long) iArr2[i29]));
            iArr2[i20] = 0;
            i20--;
            fVar = this;
            i11 = i23;
            i12 = i24;
        }
        int i31 = i11;
        int i32 = i12;
        int[] iArr3 = fVar.f28765c;
        long j11 = ((long) iArr3[i31]) & 4294967295L & (4294967295 << i32);
        iArr3[0] = (int) ((j11 >>> (32 - i13)) ^ ((long) iArr3[0]));
        int i33 = i31 - i14;
        int i34 = i33 - 1;
        if (i34 >= 0) {
            iArr3[i34] = iArr3[i34] ^ ((int) (j11 << i15));
        }
        iArr3[i33] = (int) (((long) iArr3[i33]) ^ (j11 >>> (32 - i15)));
        int i35 = i31 - i16;
        int i36 = i35 - 1;
        if (i36 >= 0) {
            iArr3[i36] = iArr3[i36] ^ ((int) (j11 << i17));
        }
        iArr3[i35] = (int) (((long) iArr3[i35]) ^ (j11 >>> (32 - i17)));
        int i37 = i31 - i18;
        int i38 = i37 - 1;
        if (i38 >= 0) {
            iArr3[i38] = iArr3[i38] ^ ((int) (j11 << i19));
        }
        iArr3[i37] = (int) ((j11 >>> (32 - i19)) ^ ((long) iArr3[i37]));
        iArr3[i31] = iArr3[i31] & f28762h[i32];
        this.f28764b = ((i10 - 1) >>> 5) + 1;
        this.f28763a = i10;
    }

    public void F(int i10, int i11) {
        int i12 = i10 >>> 5;
        int i13 = i10 & 31;
        int i14 = 32 - i13;
        int i15 = i10 - i11;
        int i16 = i15 >>> 5;
        int i17 = 32 - (i15 & 31);
        int i18 = ((i10 << 1) - 2) >>> 5;
        while (i18 > i12) {
            int[] iArr = this.f28765c;
            long j10 = 4294967295L & ((long) iArr[i18]);
            int i19 = i18 - i12;
            int i20 = i19 - 1;
            int i21 = i12;
            iArr[i20] = iArr[i20] ^ ((int) (j10 << i14));
            iArr[i19] = (int) (((long) iArr[i19]) ^ (j10 >>> (32 - i14)));
            int i22 = i18 - i16;
            int i23 = i22 - 1;
            iArr[i23] = iArr[i23] ^ ((int) (j10 << i17));
            iArr[i22] = (int) ((j10 >>> (32 - i17)) ^ ((long) iArr[i22]));
            iArr[i18] = 0;
            i18--;
            i12 = i21;
        }
        int i24 = i12;
        int[] iArr2 = this.f28765c;
        long j11 = (4294967295 << i13) & ((long) iArr2[i24]) & 4294967295L;
        iArr2[0] = (int) (((long) iArr2[0]) ^ (j11 >>> (32 - i14)));
        int i25 = i24 - i16;
        int i26 = i25 - 1;
        if (i26 >= 0) {
            iArr2[i26] = iArr2[i26] ^ ((int) (j11 << i17));
        }
        iArr2[i25] = (int) ((j11 >>> (32 - i17)) ^ ((long) iArr2[i25]));
        iArr2[i24] = iArr2[i24] & f28762h[i13];
        this.f28764b = ((i10 - 1) >>> 5) + 1;
        this.f28763a = i10;
    }

    public f G(f fVar) throws RuntimeException {
        f fVar2 = new f(this);
        f fVar3 = new f(fVar);
        if (fVar3.q()) {
            throw new RuntimeException();
        }
        fVar2.D();
        fVar3.D();
        int i10 = fVar2.f28763a;
        int i11 = fVar3.f28763a;
        if (i10 < i11) {
            return fVar2;
        }
        while (true) {
            int i12 = i10 - i11;
            if (i12 < 0) {
                return fVar2;
            }
            fVar2.T(fVar3.L(i12));
            fVar2.D();
            i10 = fVar2.f28763a;
            i11 = fVar3.f28763a;
        }
    }

    public void H(int i10) throws RuntimeException {
        if (i10 < 0) {
            throw new RuntimeException();
        }
        if (i10 > this.f28763a - 1) {
            return;
        }
        int[] iArr = this.f28765c;
        int i11 = i10 >>> 5;
        iArr[i11] = (~f28761g[i10 & 31]) & iArr[i11];
    }

    public void I(int i10) throws RuntimeException {
        if (i10 < 0 || i10 > this.f28763a - 1) {
            throw new RuntimeException();
        }
        int[] iArr = this.f28765c;
        int i11 = i10 >>> 5;
        iArr[i11] = f28761g[i10 & 31] | iArr[i11];
    }

    public void J() {
        int i10 = this.f28764b + 1;
        this.f28764b = i10;
        this.f28763a += 32;
        int[] iArr = this.f28765c;
        if (i10 > iArr.length) {
            int[] iArr2 = new int[i10];
            System.arraycopy(iArr, 0, iArr2, 1, i10 - 1);
            this.f28765c = iArr2;
        } else {
            for (int i11 = i10 - 1; i11 >= 1; i11--) {
                int[] iArr3 = this.f28765c;
                iArr3[i11] = iArr3[i11 - 1];
            }
            this.f28765c[0] = 0;
        }
    }

    public f K() {
        f fVar = new f(this.f28763a + 1, this.f28765c);
        for (int i10 = fVar.f28764b - 1; i10 >= 1; i10--) {
            int[] iArr = fVar.f28765c;
            iArr[i10] = iArr[i10] << 1;
            iArr[i10] = iArr[i10] | (iArr[i10 - 1] >>> 31);
        }
        int[] iArr2 = fVar.f28765c;
        iArr2[0] = iArr2[0] << 1;
        return fVar;
    }

    public f L(int i10) {
        f fVar = new f(this.f28763a + i10, this.f28765c);
        if (i10 >= 32) {
            fVar.h(i10 >>> 5);
        }
        int i11 = i10 & 31;
        if (i11 != 0) {
            for (int i12 = fVar.f28764b - 1; i12 >= 1; i12--) {
                int[] iArr = fVar.f28765c;
                iArr[i12] = iArr[i12] << i11;
                iArr[i12] = iArr[i12] | (iArr[i12 - 1] >>> (32 - i11));
            }
            int[] iArr2 = fVar.f28765c;
            iArr2[0] = iArr2[0] << i11;
        }
        return fVar;
    }

    public void M(f fVar, int i10) {
        int i11;
        if (i10 == 0) {
            b(fVar);
            return;
        }
        i(fVar.f28763a + i10);
        int i12 = i10 >>> 5;
        for (int i13 = fVar.f28764b - 1; i13 >= 0; i13--) {
            int i14 = i13 + i12;
            int i15 = i14 + 1;
            if (i15 < this.f28764b && (i11 = i10 & 31) != 0) {
                int[] iArr = this.f28765c;
                iArr[i15] = (fVar.f28765c[i13] >>> (32 - i11)) ^ iArr[i15];
            }
            int[] iArr2 = this.f28765c;
            iArr2[i14] = iArr2[i14] ^ (fVar.f28765c[i13] << (i10 & 31));
        }
    }

    public void N() {
        int i10 = this.f28763a;
        int i11 = i10 & 31;
        this.f28763a = i10 + 1;
        int i12 = this.f28764b;
        if (i11 != 0) {
            for (int i13 = i12 - 1; i13 >= 1; i13--) {
                int[] iArr = this.f28765c;
                iArr[i13] = iArr[i13] << 1;
                iArr[i13] = iArr[i13] | (iArr[i13 - 1] >>> 31);
            }
            int[] iArr2 = this.f28765c;
            iArr2[0] = iArr2[0] << 1;
            return;
        }
        int i14 = i12 + 1;
        this.f28764b = i14;
        int[] iArr3 = this.f28765c;
        if (i14 > iArr3.length) {
            int[] iArr4 = new int[i14];
            System.arraycopy(iArr3, 0, iArr4, 0, iArr3.length);
            this.f28765c = iArr4;
        }
        for (int i15 = this.f28764b - 1; i15 >= 1; i15--) {
            int[] iArr5 = this.f28765c;
            int i16 = i15 - 1;
            iArr5[i15] = iArr5[i15] | (iArr5[i16] >>> 31);
            iArr5[i16] = iArr5[i16] << 1;
        }
    }

    public f O() {
        int i10;
        f fVar = new f(this.f28763a - 1);
        int i11 = 0;
        System.arraycopy(this.f28765c, 0, fVar.f28765c, 0, fVar.f28764b);
        while (true) {
            i10 = fVar.f28764b;
            if (i11 > i10 - 2) {
                break;
            }
            int[] iArr = fVar.f28765c;
            iArr[i11] = iArr[i11] >>> 1;
            int i12 = i11 + 1;
            iArr[i11] = iArr[i11] | (iArr[i12] << 31);
            i11 = i12;
        }
        int[] iArr2 = fVar.f28765c;
        int i13 = i10 - 1;
        iArr2[i13] = iArr2[i13] >>> 1;
        if (i10 < this.f28764b) {
            int i14 = i10 - 1;
            iArr2[i14] = (this.f28765c[i10] << 31) | iArr2[i14];
        }
        return fVar;
    }

    public void P() {
        int i10;
        int i11 = this.f28763a - 1;
        this.f28763a = i11;
        this.f28764b = ((i11 - 1) >>> 5) + 1;
        int i12 = 0;
        while (true) {
            i10 = this.f28764b;
            if (i12 > i10 - 2) {
                break;
            }
            int[] iArr = this.f28765c;
            iArr[i12] = iArr[i12] >>> 1;
            int i13 = i12 + 1;
            iArr[i12] = iArr[i12] | (iArr[i13] << 31);
            i12 = i13;
        }
        int[] iArr2 = this.f28765c;
        int i14 = i10 - 1;
        iArr2[i14] = iArr2[i14] >>> 1;
        if ((this.f28763a & 31) == 0) {
            int i15 = i10 - 1;
            iArr2[i15] = (iArr2[i10] << 31) | iArr2[i15];
        }
    }

    public void Q() {
        if (q()) {
            return;
        }
        int i10 = this.f28764b;
        int i11 = i10 << 1;
        int[] iArr = new int[i11];
        for (int i12 = i10 - 1; i12 >= 0; i12--) {
            int i13 = this.f28765c[i12];
            int i14 = 1;
            for (int i15 = 0; i15 < 16; i15++) {
                if ((i13 & 1) != 0) {
                    int i16 = i12 << 1;
                    iArr[i16] = iArr[i16] | i14;
                }
                if ((65536 & i13) != 0) {
                    int i17 = (i12 << 1) + 1;
                    iArr[i17] = iArr[i17] | i14;
                }
                i14 <<= 2;
                i13 >>>= 1;
            }
        }
        this.f28765c = iArr;
        this.f28764b = i11;
        this.f28763a = (this.f28763a << 1) - 1;
    }

    public void R() {
        int i10;
        int i11;
        if (q()) {
            return;
        }
        int length = this.f28765c.length;
        int i12 = this.f28764b;
        if (length >= (i12 << 1)) {
            for (int i13 = i12 - 1; i13 >= 0; i13--) {
                int[] iArr = this.f28765c;
                int i14 = i13 << 1;
                short[] sArr = f28760f;
                iArr[i14 + 1] = sArr[(iArr[i13] & 16711680) >>> 16] | (sArr[(iArr[i13] & (-16777216)) >>> 24] << 16);
                iArr[i14] = sArr[iArr[i13] & 255] | (sArr[(iArr[i13] & 65280) >>> 8] << 16);
            }
            i11 = this.f28764b << 1;
        } else {
            int[] iArr2 = new int[i12 << 1];
            int i15 = 0;
            while (true) {
                i10 = this.f28764b;
                if (i15 >= i10) {
                    break;
                }
                int i16 = i15 << 1;
                short[] sArr2 = f28760f;
                int[] iArr3 = this.f28765c;
                iArr2[i16] = sArr2[iArr3[i15] & 255] | (sArr2[(iArr3[i15] & 65280) >>> 8] << 16);
                iArr2[i16 + 1] = (sArr2[(iArr3[i15] & (-16777216)) >>> 24] << 16) | sArr2[(iArr3[i15] & 16711680) >>> 16];
                i15++;
            }
            this.f28765c = iArr2;
            i11 = i10 << 1;
        }
        this.f28764b = i11;
        this.f28763a = (this.f28763a << 1) - 1;
    }

    public f S(f fVar) {
        return b0(fVar);
    }

    public void T(f fVar) {
        i(fVar.f28763a);
        d0(fVar);
    }

    public boolean U(int i10) {
        if (i10 < 0) {
            throw new RuntimeException();
        }
        if (i10 > this.f28763a - 1) {
            return false;
        }
        return (f28761g[i10 & 31] & this.f28765c[i10 >>> 5]) != 0;
    }

    public byte[] V() {
        int i10 = ((this.f28763a - 1) >> 3) + 1;
        int i11 = i10 & 3;
        byte[] bArr = new byte[i10];
        for (int i12 = 0; i12 < (i10 >> 2); i12++) {
            int i13 = (i10 - (i12 << 2)) - 1;
            int[] iArr = this.f28765c;
            bArr[i13] = (byte) (255 & iArr[i12]);
            bArr[i13 - 1] = (byte) ((iArr[i12] & 65280) >>> 8);
            bArr[i13 - 2] = (byte) ((iArr[i12] & 16711680) >>> 16);
            bArr[i13 - 3] = (byte) ((iArr[i12] & (-16777216)) >>> 24);
        }
        for (int i14 = 0; i14 < i11; i14++) {
            int i15 = ((i11 - i14) - 1) << 3;
            bArr[i14] = (byte) ((this.f28765c[this.f28764b - 1] & (255 << i15)) >>> i15);
        }
        return bArr;
    }

    public BigInteger W() {
        return (this.f28763a == 0 || q()) ? new BigInteger(0, new byte[0]) : new BigInteger(1, V());
    }

    public int[] X() {
        int i10 = this.f28764b;
        int[] iArr = new int[i10];
        System.arraycopy(this.f28765c, 0, iArr, 0, i10);
        return iArr;
    }

    public String Y(int i10) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        String[] strArr = {"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", Constants.DEFAULT_UIN, "1001", "1010", "1011", "1100", "1101", "1110", "1111"};
        String str = new String();
        if (i10 == 16) {
            for (int i11 = this.f28764b - 1; i11 >= 0; i11--) {
                str = ((((((((str + cArr[(this.f28765c[i11] >>> 28) & 15]) + cArr[(this.f28765c[i11] >>> 24) & 15]) + cArr[(this.f28765c[i11] >>> 20) & 15]) + cArr[(this.f28765c[i11] >>> 16) & 15]) + cArr[(this.f28765c[i11] >>> 12) & 15]) + cArr[(this.f28765c[i11] >>> 8) & 15]) + cArr[(this.f28765c[i11] >>> 4) & 15]) + cArr[this.f28765c[i11] & 15]) + i0.f11861z;
            }
        } else {
            for (int i12 = this.f28764b - 1; i12 >= 0; i12--) {
                str = ((((((((str + strArr[(this.f28765c[i12] >>> 28) & 15]) + strArr[(this.f28765c[i12] >>> 24) & 15]) + strArr[(this.f28765c[i12] >>> 20) & 15]) + strArr[(this.f28765c[i12] >>> 16) & 15]) + strArr[(this.f28765c[i12] >>> 12) & 15]) + strArr[(this.f28765c[i12] >>> 8) & 15]) + strArr[(this.f28765c[i12] >>> 4) & 15]) + strArr[this.f28765c[i12] & 15]) + i0.f11861z;
            }
        }
        return str;
    }

    public final f Z(int i10) {
        int iMin = Math.min(i10, this.f28764b - i10);
        f fVar = new f(iMin << 5);
        if (this.f28764b >= i10) {
            System.arraycopy(this.f28765c, i10, fVar.f28765c, 0, iMin);
        }
        return fVar;
    }

    public f a(f fVar) {
        return b0(fVar);
    }

    public boolean a0(f fVar) throws RuntimeException {
        if (this.f28763a != fVar.f28763a) {
            throw new RuntimeException();
        }
        boolean z10 = false;
        for (int i10 = 0; i10 < this.f28764b; i10++) {
            int i11 = this.f28765c[i10] & fVar.f28765c[i10];
            boolean[] zArr = f28759e;
            z10 = (((z10 ^ zArr[i11 & 255]) ^ zArr[(i11 >>> 8) & 255]) ^ zArr[(i11 >>> 16) & 255]) ^ zArr[(i11 >>> 24) & 255];
        }
        return z10;
    }

    public void b(f fVar) {
        i(fVar.f28763a);
        d0(fVar);
    }

    public f b0(f fVar) {
        f fVar2;
        int iMin = Math.min(this.f28764b, fVar.f28764b);
        int i10 = 0;
        if (this.f28763a >= fVar.f28763a) {
            fVar2 = new f(this);
            while (i10 < iMin) {
                int[] iArr = fVar2.f28765c;
                iArr[i10] = iArr[i10] ^ fVar.f28765c[i10];
                i10++;
            }
        } else {
            fVar2 = new f(fVar);
            while (i10 < iMin) {
                int[] iArr2 = fVar2.f28765c;
                iArr2[i10] = iArr2[i10] ^ this.f28765c[i10];
                i10++;
            }
        }
        fVar2.e0();
        return fVar2;
    }

    public void c() {
        for (int i10 = 0; i10 < this.f28764b; i10++) {
            this.f28765c[i10] = -1;
        }
        e0();
    }

    public void c0(int i10) throws RuntimeException {
        if (i10 < 0 || i10 > this.f28763a - 1) {
            throw new RuntimeException();
        }
        int[] iArr = this.f28765c;
        int i11 = i10 >>> 5;
        iArr[i11] = f28761g[i10 & 31] ^ iArr[i11];
    }

    public Object clone() {
        return new f(this);
    }

    public void d() {
        for (int i10 = 1; i10 < this.f28764b; i10++) {
            this.f28765c[i10] = 0;
        }
        this.f28765c[0] = 1;
    }

    public void d0(f fVar) {
        for (int i10 = 0; i10 < Math.min(this.f28764b, fVar.f28764b); i10++) {
            int[] iArr = this.f28765c;
            iArr[i10] = iArr[i10] ^ fVar.f28765c[i10];
        }
        e0();
    }

    public void e() {
        for (int i10 = 1; i10 < this.f28764b; i10++) {
            this.f28765c[i10] = 0;
        }
        this.f28765c[0] = 2;
    }

    public final void e0() {
        int i10 = this.f28763a;
        if ((i10 & 31) != 0) {
            int[] iArr = this.f28765c;
            int i11 = this.f28764b - 1;
            iArr[i11] = f28762h[i10 & 31] & iArr[i11];
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (this.f28763a != fVar.f28763a) {
            return false;
        }
        for (int i10 = 0; i10 < this.f28764b; i10++) {
            if (this.f28765c[i10] != fVar.f28765c[i10]) {
                return false;
            }
        }
        return true;
    }

    public void f() {
        for (int i10 = 0; i10 < this.f28764b; i10++) {
            this.f28765c[i10] = 0;
        }
    }

    public f[] g(f fVar) throws RuntimeException {
        f[] fVarArr = new f[2];
        f fVar2 = new f(this.f28763a);
        f fVar3 = new f(this);
        f fVar4 = new f(fVar);
        if (fVar4.q()) {
            throw new RuntimeException();
        }
        fVar3.D();
        fVar4.D();
        int i10 = fVar3.f28763a;
        int i11 = fVar4.f28763a;
        if (i10 < i11) {
            fVarArr[0] = new f(0);
            fVarArr[1] = fVar3;
            return fVarArr;
        }
        int i12 = i10 - i11;
        fVar2.i(i12 + 1);
        while (i12 >= 0) {
            fVar3.T(fVar4.L(i12));
            fVar3.D();
            fVar2.c0(i12);
            i12 = fVar3.f28763a - fVar4.f28763a;
        }
        fVarArr[0] = fVar2;
        fVarArr[1] = fVar3;
        return fVarArr;
    }

    public final void h(int i10) {
        int i11 = this.f28764b;
        int[] iArr = this.f28765c;
        if (i11 > iArr.length) {
            int[] iArr2 = new int[i11];
            System.arraycopy(iArr, 0, iArr2, i10, i11 - i10);
            this.f28765c = iArr2;
            return;
        }
        for (int i12 = i11 - 1; i12 >= i10; i12--) {
            int[] iArr3 = this.f28765c;
            iArr3[i12] = iArr3[i12 - i10];
        }
        for (int i13 = 0; i13 < i10; i13++) {
            this.f28765c[i13] = 0;
        }
    }

    public int hashCode() {
        return this.f28763a + org.bouncycastle.util.a.v0(this.f28765c);
    }

    public void i(int i10) {
        if (this.f28763a >= i10) {
            return;
        }
        this.f28763a = i10;
        int i11 = ((i10 - 1) >>> 5) + 1;
        int i12 = this.f28764b;
        if (i12 >= i11) {
            return;
        }
        int[] iArr = this.f28765c;
        if (iArr.length >= i11) {
            while (i12 < i11) {
                this.f28765c[i12] = 0;
                i12++;
            }
            this.f28764b = i11;
            return;
        }
        int[] iArr2 = new int[i11];
        System.arraycopy(iArr, 0, iArr2, 0, i12);
        this.f28764b = i11;
        this.f28765c = iArr2;
    }

    public f j(f fVar) throws RuntimeException {
        if (q() && fVar.q()) {
            throw new ArithmeticException("Both operands of gcd equal zero.");
        }
        if (q()) {
            return new f(fVar);
        }
        if (fVar.q()) {
            return new f(this);
        }
        f fVar2 = new f(this);
        f fVar3 = new f(fVar);
        f fVar4 = fVar2;
        f fVarG = fVar3;
        while (!fVarG.q()) {
            f fVar5 = fVarG;
            fVarG = fVar4.G(fVarG);
            fVar4 = fVar5;
        }
        return fVar4;
    }

    public int k(int i10) {
        if (i10 < 0) {
            throw new RuntimeException();
        }
        if (i10 > this.f28763a - 1) {
            return 0;
        }
        return (f28761g[i10 & 31] & this.f28765c[i10 >>> 5]) != 0 ? 1 : 0;
    }

    public int l() {
        return this.f28763a;
    }

    public f m() {
        f fVar = new f(this);
        fVar.n();
        return fVar;
    }

    public void n() {
        c0(0);
    }

    public boolean o() {
        if (q()) {
            return false;
        }
        f fVar = new f(this);
        fVar.D();
        int i10 = fVar.f28763a;
        int i11 = i10 - 1;
        f fVar2 = new f(i10, "X");
        for (int i12 = 1; i12 <= (i11 >> 1); i12++) {
            fVar2.R();
            fVar2 = fVar2.G(fVar);
            f fVarA = fVar2.a(new f(32, "X"));
            if (fVarA.q() || !fVar.j(fVarA).p()) {
                return false;
            }
        }
        return true;
    }

    public boolean p() {
        for (int i10 = 1; i10 < this.f28764b; i10++) {
            if (this.f28765c[i10] != 0) {
                return false;
            }
        }
        return this.f28765c[0] == 1;
    }

    public boolean q() {
        if (this.f28763a == 0) {
            return true;
        }
        for (int i10 = 0; i10 < this.f28764b; i10++) {
            if (this.f28765c[i10] != 0) {
                return false;
            }
        }
        return true;
    }

    public final f r(f fVar) {
        f fVar2 = new f(this.f28763a << 1);
        int i10 = this.f28763a;
        if (i10 <= 32) {
            fVar2.f28765c = v(this.f28765c[0], fVar.f28765c[0]);
            return fVar2;
        }
        if (i10 <= 64) {
            fVar2.f28765c = x(this.f28765c, fVar.f28765c);
            return fVar2;
        }
        if (i10 <= 128) {
            fVar2.f28765c = t(this.f28765c, fVar.f28765c);
            return fVar2;
        }
        if (i10 <= 256) {
            fVar2.f28765c = u(this.f28765c, fVar.f28765c);
            return fVar2;
        }
        if (i10 <= 512) {
            fVar2.f28765c = w(this.f28765c, fVar.f28765c);
            return fVar2;
        }
        int i11 = f28761g[u.l(i10 - 1)];
        int i12 = ((i11 - 1) >> 5) + 1;
        f fVarS = s(i12);
        f fVarZ = Z(i12);
        f fVarS2 = fVar.s(i12);
        f fVarZ2 = fVar.Z(i12);
        f fVarR = fVarZ.r(fVarZ2);
        f fVarR2 = fVarS.r(fVarS2);
        fVarS.b(fVarZ);
        fVarS2.b(fVarZ2);
        f fVarR3 = fVarS.r(fVarS2);
        fVar2.M(fVarR, i11 << 1);
        fVar2.M(fVarR, i11);
        fVar2.M(fVarR3, i11);
        fVar2.M(fVarR2, i11);
        fVar2.b(fVarR2);
        return fVar2;
    }

    public final f s(int i10) {
        f fVar = new f(i10 << 5);
        System.arraycopy(this.f28765c, 0, fVar.f28765c, 0, Math.min(i10, this.f28764b));
        return fVar;
    }

    public f y(f fVar) {
        int iMax = Math.max(this.f28763a, fVar.f28763a);
        i(iMax);
        fVar.i(iMax);
        return r(fVar);
    }

    public f z(f fVar) {
        f fVar2 = new f(Math.max(this.f28763a, fVar.f28763a) << 1);
        f[] fVarArr = new f[32];
        fVarArr[0] = new f(this);
        for (int i10 = 1; i10 <= 31; i10++) {
            fVarArr[i10] = fVarArr[i10 - 1].K();
        }
        for (int i11 = 0; i11 < fVar.f28764b; i11++) {
            for (int i12 = 0; i12 <= 31; i12++) {
                if ((fVar.f28765c[i11] & f28761g[i12]) != 0) {
                    fVar2.d0(fVarArr[i12]);
                }
            }
            for (int i13 = 0; i13 <= 31; i13++) {
                fVarArr[i13].J();
            }
        }
        return fVar2;
    }
}
