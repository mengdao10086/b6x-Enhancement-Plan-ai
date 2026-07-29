package top.zibin.luban;

import android.graphics.BitmapFactory;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
enum Checker {
    SINGLE;

    private static final String GIF = ".gif";
    private static final String JPEG = ".jpeg";
    private static final String JPG = ".jpg";
    private static final String PNG = ".png";
    private static final String TAG = "Luban";
    private static final String WEBP = ".webp";
    private static List<String> format;
    private final byte[] JPEG_SIGNATURE = {-1, i1.a.f31659n7, -1};

    static {
        ArrayList arrayList = new ArrayList();
        format = arrayList;
        arrayList.add(".jpg");
        format.add(".jpeg");
        format.add(PNG);
        format.add(WEBP);
        format.add(GIF);
    }

    Checker() {
    }

    private int pack(byte[] bArr, int i10, int i11, boolean z10) {
        int i12;
        if (z10) {
            i10 += i11 - 1;
            i12 = -1;
        } else {
            i12 = 1;
        }
        int i13 = 0;
        while (true) {
            int i14 = i11 - 1;
            if (i11 <= 0) {
                return i13;
            }
            i13 = (bArr[i10] & 255) | (i13 << 8);
            i10 += i12;
            i11 = i14;
        }
    }

    private byte[] toByteArray(InputStream inputStream) {
        if (inputStream == null) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            try {
                try {
                    int i10 = inputStream.read(bArr, 0, 4096);
                    if (i10 != -1) {
                        byteArrayOutputStream.write(bArr, 0, i10);
                    } else {
                        try {
                            break;
                        } catch (IOException unused) {
                        }
                    }
                } finally {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException unused2) {
                    }
                }
            } catch (Exception unused3) {
                byte[] bArr2 = new byte[0];
                try {
                    byteArrayOutputStream.close();
                } catch (IOException unused4) {
                }
                return bArr2;
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    public String extSuffix(d dVar) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(dVar.open(), null, options);
            return options.outMimeType.replace("image/", j3.b.f36044h);
        } catch (Exception unused) {
            return ".jpg";
        }
    }

    public int getOrientation(InputStream inputStream) {
        return getOrientation(toByteArray(inputStream));
    }

    public boolean isJPG(InputStream inputStream) {
        return isJPG(toByteArray(inputStream));
    }

    public boolean needCompress(int i10, String str) {
        if (i10 <= 0) {
            return true;
        }
        File file = new File(str);
        return file.exists() && file.length() > ((long) (i10 << 10));
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x005c, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x005f, code lost:
    
        r1 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0060, code lost:
    
        r3 = 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int getOrientation(byte[] r11) {
        /*
            r10 = this;
            r0 = 0
            if (r11 != 0) goto L4
            return r0
        L4:
            r1 = 0
        L5:
            int r2 = r1 + 3
            int r3 = r11.length
            r4 = 4
            r5 = 1
            r6 = 8
            r7 = 2
            if (r2 >= r3) goto L60
            int r2 = r1 + 1
            r1 = r11[r1]
            r3 = 255(0xff, float:3.57E-43)
            r1 = r1 & r3
            if (r1 != r3) goto L5f
            r1 = r11[r2]
            r1 = r1 & r3
            if (r1 != r3) goto L1e
            goto L5d
        L1e:
            int r2 = r2 + 1
            r3 = 216(0xd8, float:3.03E-43)
            if (r1 == r3) goto L5d
            if (r1 != r5) goto L27
            goto L5d
        L27:
            r3 = 217(0xd9, float:3.04E-43)
            if (r1 == r3) goto L5f
            r3 = 218(0xda, float:3.05E-43)
            if (r1 != r3) goto L30
            goto L5f
        L30:
            int r3 = r10.pack(r11, r2, r7, r0)
            if (r3 < r7) goto L5c
            int r8 = r2 + r3
            int r9 = r11.length
            if (r8 <= r9) goto L3c
            goto L5c
        L3c:
            r9 = 225(0xe1, float:3.15E-43)
            if (r1 != r9) goto L5a
            if (r3 < r6) goto L5a
            int r1 = r2 + 2
            int r1 = r10.pack(r11, r1, r4, r0)
            r9 = 1165519206(0x45786966, float:3974.5874)
            if (r1 != r9) goto L5a
            int r1 = r2 + 6
            int r1 = r10.pack(r11, r1, r7, r0)
            if (r1 != 0) goto L5a
            int r1 = r2 + 8
            int r3 = r3 + (-8)
            goto L61
        L5a:
            r1 = r8
            goto L5
        L5c:
            return r0
        L5d:
            r1 = r2
            goto L5
        L5f:
            r1 = r2
        L60:
            r3 = 0
        L61:
            if (r3 <= r6) goto Lb9
            int r2 = r10.pack(r11, r1, r4, r0)
            r8 = 1229531648(0x49492a00, float:823968.0)
            if (r2 == r8) goto L72
            r9 = 1296891946(0x4d4d002a, float:2.1495875E8)
            if (r2 == r9) goto L72
            return r0
        L72:
            if (r2 != r8) goto L75
            goto L76
        L75:
            r5 = 0
        L76:
            int r2 = r1 + 4
            int r2 = r10.pack(r11, r2, r4, r5)
            int r2 = r2 + r7
            r4 = 10
            if (r2 < r4) goto Lb9
            if (r2 <= r3) goto L84
            goto Lb9
        L84:
            int r1 = r1 + r2
            int r3 = r3 - r2
            int r2 = r1 + (-2)
            int r2 = r10.pack(r11, r2, r7, r5)
        L8c:
            int r4 = r2 + (-1)
            if (r2 <= 0) goto Lb9
            r2 = 12
            if (r3 < r2) goto Lb9
            int r2 = r10.pack(r11, r1, r7, r5)
            r8 = 274(0x112, float:3.84E-43)
            if (r2 != r8) goto Lb3
            int r1 = r1 + r6
            int r11 = r10.pack(r11, r1, r7, r5)
            r1 = 3
            if (r11 == r1) goto Lb0
            r1 = 6
            if (r11 == r1) goto Lad
            if (r11 == r6) goto Laa
            return r0
        Laa:
            r11 = 270(0x10e, float:3.78E-43)
            return r11
        Lad:
            r11 = 90
            return r11
        Lb0:
            r11 = 180(0xb4, float:2.52E-43)
            return r11
        Lb3:
            int r1 = r1 + 12
            int r3 = r3 + (-12)
            r2 = r4
            goto L8c
        Lb9:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: top.zibin.luban.Checker.getOrientation(byte[]):int");
    }

    private boolean isJPG(byte[] bArr) {
        if (bArr == null || bArr.length < 3) {
            return false;
        }
        return Arrays.equals(this.JPEG_SIGNATURE, new byte[]{bArr[0], bArr[1], bArr[2]});
    }
}
