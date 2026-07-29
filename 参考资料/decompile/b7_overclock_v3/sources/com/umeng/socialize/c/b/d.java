package com.umeng.socialize.c.b;

import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f24609a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f24610b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f24611c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f24612d = 3;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f24613e = 4;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f24614f = 5;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f24615g = 6;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f24616h = 7;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f24617i = 8;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f24618j = 9;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f24619k = 10;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f24620l = 11;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String[] f24621m = {"jpeg", "gif", "png", "bmp", "pcx", "iff", "ras", "pbm", "pgm", "ppm", "psd", "swf"};

    public static String a(byte[] bArr) throws Throwable {
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayInputStream byteArrayInputStream2 = null;
        try {
            try {
                byteArrayInputStream = new ByteArrayInputStream(bArr);
            } catch (Exception e10) {
                e = e10;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            int i10 = byteArrayInputStream.read();
            int i11 = byteArrayInputStream.read();
            if (i10 == 71 && i11 == 73) {
                String str = f24621m[1];
                try {
                    byteArrayInputStream.close();
                } catch (IOException e11) {
                    SLog.error(UmengText.IMAGE.CLOSE, e11);
                }
                return str;
            }
            if (i10 == 137 && i11 == 80) {
                String str2 = f24621m[2];
                try {
                    byteArrayInputStream.close();
                } catch (IOException e12) {
                    SLog.error(UmengText.IMAGE.CLOSE, e12);
                }
                return str2;
            }
            if (i10 == 255 && i11 == 216) {
                String str3 = f24621m[0];
                try {
                    byteArrayInputStream.close();
                } catch (IOException e13) {
                    SLog.error(UmengText.IMAGE.CLOSE, e13);
                }
                return str3;
            }
            if (i10 == 66 && i11 == 77) {
                String str4 = f24621m[3];
                try {
                    byteArrayInputStream.close();
                } catch (IOException e14) {
                    SLog.error(UmengText.IMAGE.CLOSE, e14);
                }
                return str4;
            }
            if (i10 == 10 && i11 < 6) {
                String str5 = f24621m[4];
                try {
                    byteArrayInputStream.close();
                } catch (IOException e15) {
                    SLog.error(UmengText.IMAGE.CLOSE, e15);
                }
                return str5;
            }
            if (i10 == 70 && i11 == 79) {
                String str6 = f24621m[5];
                try {
                    byteArrayInputStream.close();
                } catch (IOException e16) {
                    SLog.error(UmengText.IMAGE.CLOSE, e16);
                }
                return str6;
            }
            if (i10 == 89 && i11 == 166) {
                String str7 = f24621m[6];
                try {
                    byteArrayInputStream.close();
                } catch (IOException e17) {
                    SLog.error(UmengText.IMAGE.CLOSE, e17);
                }
                return str7;
            }
            if (i10 == 80 && i11 >= 49 && i11 <= 54) {
                int i12 = i11 - 48;
                if (i12 < 1 || i12 > 6) {
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException e18) {
                        SLog.error(UmengText.IMAGE.CLOSE, e18);
                    }
                    return "";
                }
                String str8 = f24621m[new int[]{7, 8, 9}[(i12 - 1) % 3]];
                try {
                    byteArrayInputStream.close();
                } catch (IOException e19) {
                    SLog.error(UmengText.IMAGE.CLOSE, e19);
                }
                return str8;
            }
            if (i10 == 56 && i11 == 66) {
                String str9 = f24621m[10];
                try {
                    byteArrayInputStream.close();
                } catch (IOException e20) {
                    SLog.error(UmengText.IMAGE.CLOSE, e20);
                }
                return str9;
            }
            if (i10 != 70 || i11 != 87) {
                try {
                    byteArrayInputStream.close();
                } catch (IOException e21) {
                    SLog.error(UmengText.IMAGE.CLOSE, e21);
                }
                return "";
            }
            String str10 = f24621m[11];
            try {
                byteArrayInputStream.close();
            } catch (IOException e22) {
                SLog.error(UmengText.IMAGE.CLOSE, e22);
            }
            return str10;
        } catch (Exception e23) {
            e = e23;
            byteArrayInputStream2 = byteArrayInputStream;
            SLog.error(UmengText.IMAGE.CHECK_FORMAT_ERROR, e);
            if (byteArrayInputStream2 != null) {
                try {
                    byteArrayInputStream2.close();
                } catch (IOException e24) {
                    SLog.error(UmengText.IMAGE.CLOSE, e24);
                }
            }
            return "";
        } catch (Throwable th3) {
            th = th3;
            byteArrayInputStream2 = byteArrayInputStream;
            if (byteArrayInputStream2 != null) {
                try {
                    byteArrayInputStream2.close();
                } catch (IOException e25) {
                    SLog.error(UmengText.IMAGE.CLOSE, e25);
                }
            }
            throw th;
        }
    }
}
