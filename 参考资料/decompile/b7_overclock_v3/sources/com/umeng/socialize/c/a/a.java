package com.umeng.socialize.c.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.umeng.socialize.c.b.b;
import com.umeng.socialize.c.b.c;
import com.umeng.socialize.c.b.d;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.net.utils.SocializeNetUtils;
import com.umeng.socialize.utils.DefaultClass;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.SocializeUtils;
import com.umeng.socialize.utils.UmengText;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class a {
    static {
        com.umeng.socialize.c.b.a.a();
    }

    public static byte[] a(UMImage uMImage, int i10) {
        if (uMImage == null) {
            return DefaultClass.getBytes();
        }
        if (uMImage.asBinImage() == null || a(uMImage) < i10) {
            return uMImage.asBinImage();
        }
        if (uMImage.compressStyle == UMImage.CompressStyle.QUALITY) {
            return a(uMImage.asBinImage(), i10, uMImage.compressFormat);
        }
        try {
            byte[] bArrAsBinImage = uMImage.asBinImage();
            if (bArrAsBinImage == null) {
                return new byte[1];
            }
            if (bArrAsBinImage.length <= 0) {
                return uMImage.asBinImage();
            }
            Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrAsBinImage, 0, bArrAsBinImage.length);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(bArrAsBinImage, 0, bArrAsBinImage.length);
            while (byteArrayOutputStream.toByteArray().length > i10) {
                double dSqrt = Math.sqrt((((double) bArrAsBinImage.length) * 1.0d) / ((double) i10));
                bitmapDecodeByteArray = Bitmap.createScaledBitmap(bitmapDecodeByteArray, (int) (((double) bitmapDecodeByteArray.getWidth()) / dSqrt), (int) (((double) bitmapDecodeByteArray.getHeight()) / dSqrt), true);
                byteArrayOutputStream.reset();
                if (bitmapDecodeByteArray != null) {
                    bitmapDecodeByteArray.compress(uMImage.compressFormat, 100, byteArrayOutputStream);
                    bArrAsBinImage = byteArrayOutputStream.toByteArray();
                }
            }
            if (byteArrayOutputStream.toByteArray().length > i10) {
                return null;
            }
            return bArrAsBinImage;
        } catch (Throwable th2) {
            SLog.error(th2);
            return DefaultClass.getBytes();
        }
    }

    private static byte[] b(Bitmap bitmap, Bitmap.CompressFormat compressFormat) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (bitmap != null) {
            try {
                if (!bitmap.isRecycled()) {
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                    } catch (Exception e10) {
                        e = e10;
                    }
                    try {
                        float rowBytes = (bitmap.getRowBytes() * bitmap.getHeight()) / 1024;
                        float f10 = c.f24608g;
                        bitmap.compress(compressFormat, rowBytes > f10 ? (int) ((f10 / rowBytes) * 100) : 100, byteArrayOutputStream);
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e11) {
                            SLog.error(UmengText.IMAGE.CLOSE, e11);
                        }
                        return byteArray;
                    } catch (Exception e12) {
                        e = e12;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        SLog.error(UmengText.IMAGE.BITMAOTOBINARY, e);
                        if (byteArrayOutputStream2 != null) {
                            try {
                                byteArrayOutputStream2.close();
                            } catch (IOException e13) {
                                SLog.error(UmengText.IMAGE.CLOSE, e13);
                            }
                        }
                        return DefaultClass.getBytes();
                    } catch (Throwable th2) {
                        th = th2;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        if (byteArrayOutputStream2 != null) {
                            try {
                                byteArrayOutputStream2.close();
                            } catch (IOException e14) {
                                SLog.error(UmengText.IMAGE.CLOSE, e14);
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
        return null;
    }

    public static String c(byte[] bArr) {
        return d.a(bArr);
    }

    private static BitmapFactory.Options d(byte[] bArr) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        int iCeil = (int) Math.ceil(options.outWidth / UMImage.MAX_WIDTH);
        int iCeil2 = (int) Math.ceil(options.outHeight / UMImage.MAX_HEIGHT);
        if (iCeil2 <= 1 || iCeil <= 1) {
            if (iCeil2 > 2) {
                options.inSampleSize = iCeil2;
            } else if (iCeil > 2) {
                options.inSampleSize = iCeil;
            }
        } else if (iCeil2 > iCeil) {
            options.inSampleSize = iCeil2;
        } else {
            options.inSampleSize = iCeil;
        }
        options.inJustDecodeBounds = false;
        return options;
    }

    private static int e(byte[] bArr) {
        if (bArr != null) {
            return bArr.length;
        }
        return 0;
    }

    public static File b(byte[] bArr) {
        try {
            return a(bArr, b.a().b());
        } catch (IOException e10) {
            SLog.error(UmengText.IMAGE.BINARYTOFILE, e10);
            return null;
        }
    }

    private static byte[] b(File file, Bitmap.CompressFormat compressFormat) {
        if (file != null && file.getAbsoluteFile().exists()) {
            byte[] bArrA = b.a().a(file);
            if (SocializeUtils.assertBinaryInvalid(bArrA)) {
                return d.f24621m[1].equals(d.a(bArrA)) ? bArrA : a(bArrA, compressFormat);
            }
        }
        return null;
    }

    public static byte[] a(String str) {
        return SocializeNetUtils.getNetData(str);
    }

    public static Bitmap a(byte[] bArr) {
        if (bArr != null) {
            return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        }
        return null;
    }

    private static File a(byte[] bArr, File file) throws Throwable {
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                } catch (IOException e10) {
                    SLog.error(UmengText.IMAGE.CLOSE, e10);
                }
            } catch (Exception e11) {
                e = e11;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            bufferedOutputStream.write(bArr);
            bufferedOutputStream.close();
        } catch (Exception e12) {
            e = e12;
            bufferedOutputStream2 = bufferedOutputStream;
            SLog.error(UmengText.IMAGE.GET_FILE_FROM_BINARY, e);
            if (bufferedOutputStream2 != null) {
                bufferedOutputStream2.close();
            }
            return file;
        } catch (Throwable th3) {
            th = th3;
            bufferedOutputStream2 = bufferedOutputStream;
            if (bufferedOutputStream2 != null) {
                try {
                    bufferedOutputStream2.close();
                } catch (IOException e13) {
                    SLog.error(UmengText.IMAGE.CLOSE, e13);
                }
            }
            throw th;
        }
        return file;
    }

    public static byte[] a(Bitmap bitmap, Bitmap.CompressFormat compressFormat) {
        return b(bitmap, compressFormat);
    }

    private static Bitmap a(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    public static byte[] a(Context context, int i10, boolean z10, Bitmap.CompressFormat compressFormat) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (!z10) {
            Bitmap bitmapA = a(context.getResources().getDrawable(i10, null));
            if (bitmapA != null) {
                bitmapA.compress(compressFormat, 100, byteArrayOutputStream);
            }
            return byteArrayOutputStream.toByteArray();
        }
        byte[] bArr = new byte[0];
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.RGB_565;
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(context.getResources().openRawResource(i10), null, options);
            if (bitmapDecodeStream != null) {
                bitmapDecodeStream.compress(compressFormat, 100, byteArrayOutputStream);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Error e10) {
            SLog.error(UmengText.IMAGE.TOOBIG, e10);
            return bArr;
        }
    }

    public static byte[] a(File file, Bitmap.CompressFormat compressFormat) {
        return b(file, compressFormat);
    }

    public static int a(UMImage uMImage) {
        if (uMImage.getImageStyle() == UMImage.FILE_IMAGE) {
            return a(uMImage.asFileImage());
        }
        return e(uMImage.asBinImage());
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0041 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static byte[] a(byte[] r4, android.graphics.Bitmap.CompressFormat r5) throws java.lang.Throwable {
        /*
            r0 = 0
            android.graphics.BitmapFactory$Options r1 = d(r4)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
            r2 = 0
            int r3 = r4.length     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
            android.graphics.Bitmap r4 = android.graphics.BitmapFactory.decodeByteArray(r4, r2, r3, r1)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
            r1.<init>()     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
            if (r4 == 0) goto L1d
            r2 = 100
            r4.compress(r5, r2, r1)     // Catch: java.lang.Exception -> L2c java.lang.Throwable -> L3d
            r4.recycle()     // Catch: java.lang.Exception -> L2c java.lang.Throwable -> L3d
            java.lang.System.gc()     // Catch: java.lang.Exception -> L2c java.lang.Throwable -> L3d
        L1d:
            byte[] r0 = r1.toByteArray()     // Catch: java.lang.Exception -> L2c java.lang.Throwable -> L3d
            r1.close()     // Catch: java.io.IOException -> L25
            goto L3c
        L25:
            r4 = move-exception
            java.lang.String r5 = com.umeng.socialize.utils.UmengText.IMAGE.CLOSE
            com.umeng.socialize.utils.SLog.error(r5, r4)
            goto L3c
        L2c:
            r4 = move-exception
            goto L32
        L2e:
            r4 = move-exception
            goto L3f
        L30:
            r4 = move-exception
            r1 = r0
        L32:
            java.lang.String r5 = com.umeng.socialize.utils.UmengText.IMAGE.FILE_TO_BINARY_ERROR     // Catch: java.lang.Throwable -> L3d
            com.umeng.socialize.utils.SLog.error(r5, r4)     // Catch: java.lang.Throwable -> L3d
            if (r1 == 0) goto L3c
            r1.close()     // Catch: java.io.IOException -> L25
        L3c:
            return r0
        L3d:
            r4 = move-exception
            r0 = r1
        L3f:
            if (r0 == 0) goto L4b
            r0.close()     // Catch: java.io.IOException -> L45
            goto L4b
        L45:
            r5 = move-exception
            java.lang.String r0 = com.umeng.socialize.utils.UmengText.IMAGE.CLOSE
            com.umeng.socialize.utils.SLog.error(r0, r5)
        L4b:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.c.a.a.a(byte[], android.graphics.Bitmap$CompressFormat):byte[]");
    }

    public static byte[] a(byte[] bArr, int i10, Bitmap.CompressFormat compressFormat) {
        if (bArr == null || bArr.length < i10) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        boolean z10 = false;
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        int i11 = 1;
        while (!z10 && i11 <= 10) {
            int iPow = (int) (Math.pow(0.8d, i11) * 100.0d);
            if (bitmapDecodeByteArray != null) {
                bitmapDecodeByteArray.compress(compressFormat, iPow, byteArrayOutputStream);
            }
            if (byteArrayOutputStream.size() < i10) {
                z10 = true;
            } else {
                byteArrayOutputStream.reset();
                i11++;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (!bitmapDecodeByteArray.isRecycled()) {
            bitmapDecodeByteArray.recycle();
        }
        if (byteArray != null && byteArray.length <= 0) {
            SLog.E(UmengText.IMAGE.THUMB_ERROR);
        }
        return byteArray;
    }

    private static int a(File file) {
        if (file == null) {
            return 0;
        }
        try {
            return new FileInputStream(file).available();
        } catch (Throwable th2) {
            SLog.error(UmengText.IMAGE.GET_IMAGE_SCALE_ERROR, th2);
            return 0;
        }
    }
}
