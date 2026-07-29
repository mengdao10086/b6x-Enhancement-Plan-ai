package jt;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes6.dex */
public class d implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f36920a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, l.f36951s, 81, 82, 83, 84, 85, 86, 87, o5.b.f42741j, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, pq.b.f46992i, pq.b.f46991h, pq.b.f46994k, pq.b.f46993j, 114, 115, 116, 117, 118, 119, tc.a.f51065w, 121, 122, l.f36949q, 49, 50, 51, 52, 53, 54, 55, 56, 57, rc.a.f48411c0, 47};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte f36921b = 61;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f36922c = new byte[128];

    public d() {
        i();
    }

    @Override // jt.g
    public int a(String str, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[54];
        int length = str.length();
        while (length > 0 && h(str.charAt(length - 1))) {
            length--;
        }
        if (length == 0) {
            return 0;
        }
        int i10 = length;
        int i11 = 0;
        while (i10 > 0 && i11 != 4) {
            if (!h(str.charAt(i10 - 1))) {
                i11++;
            }
            i10--;
        }
        int iJ = j(str, 0, i10);
        int i12 = 0;
        int i13 = 0;
        while (iJ < i10) {
            int i14 = iJ + 1;
            byte b10 = this.f36922c[str.charAt(iJ)];
            int iJ2 = j(str, i14, i10);
            int i15 = iJ2 + 1;
            byte b11 = this.f36922c[str.charAt(iJ2)];
            int iJ3 = j(str, i15, i10);
            int i16 = iJ3 + 1;
            byte b12 = this.f36922c[str.charAt(iJ3)];
            int iJ4 = j(str, i16, i10);
            int i17 = iJ4 + 1;
            byte b13 = this.f36922c[str.charAt(iJ4)];
            if ((b10 | b11 | b12 | b13) < 0) {
                throw new IOException("invalid characters encountered in base64 data");
            }
            int i18 = i12 + 1;
            bArr[i12] = (byte) ((b10 << 2) | (b11 >> 4));
            int i19 = i18 + 1;
            bArr[i18] = (byte) ((b11 << 4) | (b12 >> 2));
            i12 = i19 + 1;
            bArr[i19] = (byte) ((b12 << 6) | b13);
            i13 += 3;
            if (i12 == 54) {
                outputStream.write(bArr);
                i12 = 0;
            }
            iJ = j(str, i17, i10);
        }
        if (i12 > 0) {
            outputStream.write(bArr, 0, i12);
        }
        int iJ5 = j(str, iJ, length);
        int iJ6 = j(str, iJ5 + 1, length);
        int iJ7 = j(str, iJ6 + 1, length);
        return i13 + f(outputStream, str.charAt(iJ5), str.charAt(iJ6), str.charAt(iJ7), str.charAt(j(str, iJ7 + 1, length)));
    }

    @Override // jt.g
    public int b(int i10) {
        return ((i10 + 2) / 3) * 4;
    }

    @Override // jt.g
    public int c(byte[] bArr, int i10, int i11, OutputStream outputStream) throws IOException {
        if (i11 < 0) {
            return 0;
        }
        byte[] bArr2 = new byte[72];
        int i12 = i11;
        while (i12 > 0) {
            int iMin = Math.min(54, i12);
            outputStream.write(bArr2, 0, g(bArr, i10, iMin, bArr2, 0));
            i10 += iMin;
            i12 -= iMin;
        }
        return ((i11 + 2) / 3) * 4;
    }

    @Override // jt.g
    public int d(int i10) {
        return (i10 / 4) * 3;
    }

    @Override // jt.g
    public int e(byte[] bArr, int i10, int i11, OutputStream outputStream) throws IOException {
        byte[] bArr2 = new byte[54];
        int i12 = i10 + i11;
        while (i12 > i10 && h((char) bArr[i12 - 1])) {
            i12--;
        }
        if (i12 == 0) {
            return 0;
        }
        int i13 = i12;
        int i14 = 0;
        while (i13 > i10 && i14 != 4) {
            if (!h((char) bArr[i13 - 1])) {
                i14++;
            }
            i13--;
        }
        int iK = k(bArr, i10, i13);
        int i15 = 0;
        int i16 = 0;
        while (iK < i13) {
            int i17 = iK + 1;
            byte b10 = this.f36922c[bArr[iK]];
            int iK2 = k(bArr, i17, i13);
            int i18 = iK2 + 1;
            byte b11 = this.f36922c[bArr[iK2]];
            int iK3 = k(bArr, i18, i13);
            int i19 = iK3 + 1;
            byte b12 = this.f36922c[bArr[iK3]];
            int iK4 = k(bArr, i19, i13);
            int i20 = iK4 + 1;
            byte b13 = this.f36922c[bArr[iK4]];
            if ((b10 | b11 | b12 | b13) < 0) {
                throw new IOException("invalid characters encountered in base64 data");
            }
            int i21 = i15 + 1;
            bArr2[i15] = (byte) ((b10 << 2) | (b11 >> 4));
            int i22 = i21 + 1;
            bArr2[i21] = (byte) ((b11 << 4) | (b12 >> 2));
            i15 = i22 + 1;
            bArr2[i22] = (byte) ((b12 << 6) | b13);
            if (i15 == 54) {
                outputStream.write(bArr2);
                i15 = 0;
            }
            i16 += 3;
            iK = k(bArr, i20, i13);
        }
        if (i15 > 0) {
            outputStream.write(bArr2, 0, i15);
        }
        int iK5 = k(bArr, iK, i12);
        int iK6 = k(bArr, iK5 + 1, i12);
        int iK7 = k(bArr, iK6 + 1, i12);
        return i16 + f(outputStream, (char) bArr[iK5], (char) bArr[iK6], (char) bArr[iK7], (char) bArr[k(bArr, iK7 + 1, i12)]);
    }

    public final int f(OutputStream outputStream, char c10, char c11, char c12, char c13) throws IOException {
        char c14 = this.f36921b;
        if (c12 == c14) {
            if (c13 != c14) {
                throw new IOException("invalid characters encountered at end of base64 data");
            }
            byte[] bArr = this.f36922c;
            byte b10 = bArr[c10];
            byte b11 = bArr[c11];
            if ((b10 | b11) < 0) {
                throw new IOException("invalid characters encountered at end of base64 data");
            }
            outputStream.write((b10 << 2) | (b11 >> 4));
            return 1;
        }
        if (c13 == c14) {
            byte[] bArr2 = this.f36922c;
            byte b12 = bArr2[c10];
            byte b13 = bArr2[c11];
            byte b14 = bArr2[c12];
            if ((b12 | b13 | b14) < 0) {
                throw new IOException("invalid characters encountered at end of base64 data");
            }
            outputStream.write((b12 << 2) | (b13 >> 4));
            outputStream.write((b13 << 4) | (b14 >> 2));
            return 2;
        }
        byte[] bArr3 = this.f36922c;
        byte b15 = bArr3[c10];
        byte b16 = bArr3[c11];
        byte b17 = bArr3[c12];
        byte b18 = bArr3[c13];
        if ((b15 | b16 | b17 | b18) < 0) {
            throw new IOException("invalid characters encountered at end of base64 data");
        }
        outputStream.write((b15 << 2) | (b16 >> 4));
        outputStream.write((b16 << 4) | (b17 >> 2));
        outputStream.write((b17 << 6) | b18);
        return 3;
    }

    public int g(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws IOException {
        int i13 = (i10 + i11) - 2;
        int i14 = i10;
        int i15 = i12;
        while (i14 < i13) {
            int i16 = i14 + 1;
            byte b10 = bArr[i14];
            int i17 = i16 + 1;
            int i18 = bArr[i16] & 255;
            int i19 = i17 + 1;
            int i20 = bArr[i17] & 255;
            int i21 = i15 + 1;
            byte[] bArr3 = this.f36920a;
            bArr2[i15] = bArr3[(b10 >>> 2) & 63];
            int i22 = i21 + 1;
            bArr2[i21] = bArr3[((b10 << 4) | (i18 >>> 4)) & 63];
            int i23 = i22 + 1;
            bArr2[i22] = bArr3[((i18 << 2) | (i20 >>> 6)) & 63];
            i15 = i23 + 1;
            bArr2[i23] = bArr3[i20 & 63];
            i14 = i19;
        }
        int i24 = i11 - (i14 - i10);
        if (i24 == 1) {
            int i25 = bArr[i14] & 255;
            int i26 = i15 + 1;
            byte[] bArr4 = this.f36920a;
            bArr2[i15] = bArr4[(i25 >>> 2) & 63];
            int i27 = i26 + 1;
            bArr2[i26] = bArr4[(i25 << 4) & 63];
            int i28 = i27 + 1;
            byte b11 = this.f36921b;
            bArr2[i27] = b11;
            i15 = i28 + 1;
            bArr2[i28] = b11;
        } else if (i24 == 2) {
            int i29 = bArr[i14] & 255;
            int i30 = bArr[i14 + 1] & 255;
            int i31 = i15 + 1;
            byte[] bArr5 = this.f36920a;
            bArr2[i15] = bArr5[(i29 >>> 2) & 63];
            int i32 = i31 + 1;
            bArr2[i31] = bArr5[((i29 << 4) | (i30 >>> 4)) & 63];
            int i33 = i32 + 1;
            bArr2[i32] = bArr5[(i30 << 2) & 63];
            i15 = i33 + 1;
            bArr2[i33] = this.f36921b;
        }
        return i15 - i12;
    }

    public final boolean h(char c10) {
        return c10 == '\n' || c10 == '\r' || c10 == '\t' || c10 == ' ';
    }

    public void i() {
        int i10 = 0;
        int i11 = 0;
        while (true) {
            byte[] bArr = this.f36922c;
            if (i11 >= bArr.length) {
                break;
            }
            bArr[i11] = -1;
            i11++;
        }
        while (true) {
            byte[] bArr2 = this.f36920a;
            if (i10 >= bArr2.length) {
                return;
            }
            this.f36922c[bArr2[i10]] = (byte) i10;
            i10++;
        }
    }

    public final int j(String str, int i10, int i11) {
        while (i10 < i11 && h(str.charAt(i10))) {
            i10++;
        }
        return i10;
    }

    public final int k(byte[] bArr, int i10, int i11) {
        while (i10 < i11 && h((char) bArr[i10])) {
            i10++;
        }
        return i10;
    }
}
