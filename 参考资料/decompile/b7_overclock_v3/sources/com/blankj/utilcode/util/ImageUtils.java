package com.blankj.utilcode.util;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.View;
import com.google.common.collect.LinkedHashMultimap;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class ImageUtils {

    public enum ImageType {
        TYPE_JPG("jpg"),
        TYPE_PNG("png"),
        TYPE_GIF("gif"),
        TYPE_TIFF("tiff"),
        TYPE_BMP("bmp"),
        TYPE_WEBP("webp"),
        TYPE_ICO("ico"),
        TYPE_UNKNOWN("unknown");

        public String value;

        ImageType(String str) {
            this.value = str;
        }

        public String getValue() {
            return this.value;
        }
    }

    public ImageUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static Bitmap A(Bitmap bitmap, int i10) {
        return D(bitmap, i10, false);
    }

    public static boolean A0(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat, int i10, boolean z10) {
        return w0(bitmap, l1.P(str), compressFormat, i10, z10);
    }

    public static Bitmap B(Bitmap bitmap, int i10, int i11) {
        return C(bitmap, i10, i11, false);
    }

    public static boolean B0(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat, boolean z10) {
        return A0(bitmap, str, compressFormat, 100, z10);
    }

    public static Bitmap C(Bitmap bitmap, int i10, int i11, boolean z10) {
        if (k0(bitmap)) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, options);
        options.inSampleSize = t(options, i10, i11);
        options.inJustDecodeBounds = false;
        if (z10 && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, options);
    }

    @g.p0
    public static File C0(Bitmap bitmap, Bitmap.CompressFormat compressFormat) {
        return E0(bitmap, compressFormat, 100, false);
    }

    public static Bitmap D(Bitmap bitmap, int i10, boolean z10) {
        if (k0(bitmap)) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = i10;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (z10 && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, options);
    }

    @g.p0
    public static File D0(Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i10) {
        return E0(bitmap, compressFormat, i10, false);
    }

    public static Bitmap E(Bitmap bitmap, float f10, float f11) {
        return H0(bitmap, f10, f11, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.OutputStream] */
    @g.p0
    public static File E0(Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i10, boolean z10) throws Throwable {
        OutputStream outputStreamOpenOutputStream;
        String str = System.currentTimeMillis() + "_" + i10 + j3.b.f36044h + (Bitmap.CompressFormat.JPEG.equals(compressFormat) ? "JPG" : compressFormat.name());
        ?? r42 = 0;
        if (Build.VERSION.SDK_INT < 29) {
            if (!l1.v0("android.permission.WRITE_EXTERNAL_STORAGE")) {
                return null;
            }
            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), j1.a().getPackageName() + fh.a.f28350w + str);
            if (!w0(bitmap, file, compressFormat, i10, z10)) {
                return null;
            }
            l1.I0(file);
            return file;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", str);
        contentValues.put(com.google.android.exoplayer2.offline.b.f17433i, "image/*");
        Uri uri = Environment.getExternalStorageState().equals("mounted") ? MediaStore.Images.Media.EXTERNAL_CONTENT_URI : MediaStore.Images.Media.INTERNAL_CONTENT_URI;
        contentValues.put("relative_path", Environment.DIRECTORY_DCIM + fh.a.f28350w + j1.a().getPackageName());
        contentValues.put("is_pending", (Integer) 1);
        ContentResolver contentResolver = j1.a().getContentResolver();
        Uri uriInsert = contentResolver.insert(uri, contentValues);
        try {
            if (uriInsert == null) {
                return null;
            }
            try {
                outputStreamOpenOutputStream = j1.a().getContentResolver().openOutputStream(uriInsert);
                try {
                    bitmap.compress(compressFormat, i10, outputStreamOpenOutputStream);
                    contentValues.clear();
                    contentValues.put("is_pending", (Integer) 0);
                    j1.a().getContentResolver().update(uriInsert, contentValues, null, null);
                    File fileE1 = l1.e1(uriInsert);
                    if (outputStreamOpenOutputStream != null) {
                        try {
                            outputStreamOpenOutputStream.close();
                        } catch (IOException e10) {
                            e10.printStackTrace();
                        }
                    }
                    return fileE1;
                } catch (Exception e11) {
                    e = e11;
                    j1.a().getContentResolver().delete(uriInsert, null, null);
                    e.printStackTrace();
                    if (outputStreamOpenOutputStream != null) {
                        try {
                            outputStreamOpenOutputStream.close();
                        } catch (IOException e12) {
                            e12.printStackTrace();
                        }
                    }
                    return null;
                }
            } catch (Exception e13) {
                e = e13;
                outputStreamOpenOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                if (r42 != 0) {
                    try {
                        r42.close();
                    } catch (IOException e14) {
                        e14.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            r42 = contentResolver;
        }
    }

    public static Bitmap F(Bitmap bitmap, float f10, float f11, boolean z10) {
        return H0(bitmap, f10, f11, z10);
    }

    @g.p0
    public static File F0(Bitmap bitmap, Bitmap.CompressFormat compressFormat, boolean z10) {
        return E0(bitmap, compressFormat, 100, z10);
    }

    public static Bitmap G(Bitmap bitmap, int i10, int i11) {
        return J0(bitmap, i10, i11, false);
    }

    public static Bitmap G0(Bitmap bitmap, float f10, float f11) {
        return H0(bitmap, f10, f11, false);
    }

    public static Bitmap H(Bitmap bitmap, int i10, int i11, boolean z10) {
        return J0(bitmap, i10, i11, z10);
    }

    public static Bitmap H0(Bitmap bitmap, float f10, float f11, boolean z10) {
        if (k0(bitmap)) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.setScale(f10, f11);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (z10 && !bitmap.isRecycled() && bitmapCreateBitmap != bitmap) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }

    public static Bitmap I(@g.n0 Bitmap bitmap, @g.l int i10) {
        Objects.requireNonNull(bitmap, "Argument 'src' of type Bitmap (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return J(bitmap, i10, false);
    }

    public static Bitmap I0(Bitmap bitmap, int i10, int i11) {
        return J0(bitmap, i10, i11, false);
    }

    public static Bitmap J(@g.n0 Bitmap bitmap, @g.l int i10, boolean z10) {
        Objects.requireNonNull(bitmap, "Argument 'src' of type Bitmap (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        if (k0(bitmap)) {
            return null;
        }
        if (!z10) {
            bitmap = bitmap.copy(bitmap.getConfig(), true);
        }
        new Canvas(bitmap).drawColor(i10, PorterDuff.Mode.DARKEN);
        return bitmap;
    }

    public static Bitmap J0(Bitmap bitmap, int i10, int i11, boolean z10) {
        if (k0(bitmap)) {
            return null;
        }
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, i10, i11, true);
        if (z10 && !bitmap.isRecycled() && bitmapCreateScaledBitmap != bitmap) {
            bitmap.recycle();
        }
        return bitmapCreateScaledBitmap;
    }

    public static Bitmap K(Drawable drawable) {
        Bitmap bitmapCreateBitmap;
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
        }
        if (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            bitmapCreateBitmap = Bitmap.createBitmap(1, 1, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        } else {
            bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        }
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    public static Bitmap K0(Bitmap bitmap, float f10, float f11) {
        return M0(bitmap, f10, f11, 0.0f, 0.0f, false);
    }

    public static byte[] L(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        return o(K(drawable));
    }

    public static Bitmap L0(Bitmap bitmap, float f10, float f11, float f12, float f13) {
        return M0(bitmap, f10, f11, f12, f13, false);
    }

    public static byte[] M(Drawable drawable, Bitmap.CompressFormat compressFormat, int i10) {
        if (drawable == null) {
            return null;
        }
        return p(K(drawable), compressFormat, i10);
    }

    public static Bitmap M0(Bitmap bitmap, float f10, float f11, float f12, float f13, boolean z10) {
        if (k0(bitmap)) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.setSkew(f10, f11, f12, f13);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (z10 && !bitmap.isRecycled() && bitmapCreateBitmap != bitmap) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }

    public static Bitmap N(Bitmap bitmap, @g.x(from = 0.0d, fromInclusive = false, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f10, @g.x(from = 0.0d, fromInclusive = false, to = 25.0d) float f11) {
        return P(bitmap, f10, f11, false, false);
    }

    public static Bitmap N0(Bitmap bitmap, float f10, float f11, boolean z10) {
        return M0(bitmap, f10, f11, 0.0f, 0.0f, z10);
    }

    public static Bitmap O(Bitmap bitmap, @g.x(from = 0.0d, fromInclusive = false, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f10, @g.x(from = 0.0d, fromInclusive = false, to = 25.0d) float f11, boolean z10) {
        return P(bitmap, f10, f11, z10, false);
    }

    public static Bitmap O0(Bitmap bitmap, int i10) {
        return P0(bitmap, i10, false);
    }

    public static Bitmap P(Bitmap bitmap, @g.x(from = 0.0d, fromInclusive = false, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f10, @g.x(from = 0.0d, fromInclusive = false, to = 25.0d) float f11, boolean z10, boolean z11) {
        if (k0(bitmap)) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.setScale(f10, f10);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        Paint paint = new Paint(3);
        Canvas canvas = new Canvas();
        paint.setColorFilter(new PorterDuffColorFilter(0, PorterDuff.Mode.SRC_ATOP));
        canvas.scale(f10, f10);
        canvas.drawBitmap(bitmapCreateBitmap, 0.0f, 0.0f, paint);
        Bitmap bitmapR0 = r0(bitmapCreateBitmap, f11, z10);
        if (f10 == 1.0f || z11) {
            if (z10 && !bitmap.isRecycled() && bitmapR0 != bitmap) {
                bitmap.recycle();
            }
            return bitmapR0;
        }
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapR0, width, height, true);
        if (!bitmapR0.isRecycled()) {
            bitmapR0.recycle();
        }
        if (z10 && !bitmap.isRecycled() && bitmapCreateScaledBitmap != bitmap) {
            bitmap.recycle();
        }
        return bitmapCreateScaledBitmap;
    }

    public static Bitmap P0(Bitmap bitmap, int i10, boolean z10) {
        int[] iArr;
        Bitmap bitmapCopy = z10 ? bitmap : bitmap.copy(bitmap.getConfig(), true);
        int i11 = i10 < 1 ? 1 : i10;
        int width = bitmapCopy.getWidth();
        int height = bitmapCopy.getHeight();
        int i12 = width * height;
        int[] iArr2 = new int[i12];
        bitmapCopy.getPixels(iArr2, 0, width, 0, 0, width, height);
        int i13 = width - 1;
        int i14 = height - 1;
        int i15 = i11 + i11 + 1;
        int[] iArr3 = new int[i12];
        int[] iArr4 = new int[i12];
        int[] iArr5 = new int[i12];
        int[] iArr6 = new int[Math.max(width, height)];
        int i16 = (i15 + 1) >> 1;
        int i17 = i16 * i16;
        int i18 = i17 * 256;
        int[] iArr7 = new int[i18];
        for (int i19 = 0; i19 < i18; i19++) {
            iArr7[i19] = i19 / i17;
        }
        int[][] iArr8 = (int[][]) Array.newInstance((Class<?>) int.class, i15, 3);
        int i20 = i11 + 1;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        while (i21 < height) {
            Bitmap bitmap2 = bitmapCopy;
            int i24 = height;
            int i25 = 0;
            int i26 = 0;
            int i27 = 0;
            int i28 = 0;
            int i29 = 0;
            int i30 = 0;
            int i31 = 0;
            int i32 = 0;
            int i33 = -i11;
            int i34 = 0;
            while (i33 <= i11) {
                int i35 = i14;
                int[] iArr9 = iArr6;
                int i36 = iArr2[i22 + Math.min(i13, Math.max(i33, 0))];
                int[] iArr10 = iArr8[i33 + i11];
                iArr10[0] = (i36 & 16711680) >> 16;
                iArr10[1] = (i36 & 65280) >> 8;
                iArr10[2] = i36 & 255;
                int iAbs = i20 - Math.abs(i33);
                i34 += iArr10[0] * iAbs;
                i25 += iArr10[1] * iAbs;
                i26 += iArr10[2] * iAbs;
                if (i33 > 0) {
                    i30 += iArr10[0];
                    i31 += iArr10[1];
                    i32 += iArr10[2];
                } else {
                    i27 += iArr10[0];
                    i28 += iArr10[1];
                    i29 += iArr10[2];
                }
                i33++;
                i14 = i35;
                iArr6 = iArr9;
            }
            int i37 = i14;
            int[] iArr11 = iArr6;
            int i38 = i34;
            int i39 = i11;
            int i40 = 0;
            while (i40 < width) {
                iArr3[i22] = iArr7[i38];
                iArr4[i22] = iArr7[i25];
                iArr5[i22] = iArr7[i26];
                int i41 = i38 - i27;
                int i42 = i25 - i28;
                int i43 = i26 - i29;
                int[] iArr12 = iArr8[((i39 - i11) + i15) % i15];
                int i44 = i27 - iArr12[0];
                int i45 = i28 - iArr12[1];
                int i46 = i29 - iArr12[2];
                if (i21 == 0) {
                    iArr = iArr7;
                    iArr11[i40] = Math.min(i40 + i11 + 1, i13);
                } else {
                    iArr = iArr7;
                }
                int i47 = iArr2[i23 + iArr11[i40]];
                iArr12[0] = (i47 & 16711680) >> 16;
                iArr12[1] = (i47 & 65280) >> 8;
                iArr12[2] = i47 & 255;
                int i48 = i30 + iArr12[0];
                int i49 = i31 + iArr12[1];
                int i50 = i32 + iArr12[2];
                i38 = i41 + i48;
                i25 = i42 + i49;
                i26 = i43 + i50;
                i39 = (i39 + 1) % i15;
                int[] iArr13 = iArr8[i39 % i15];
                i27 = i44 + iArr13[0];
                i28 = i45 + iArr13[1];
                i29 = i46 + iArr13[2];
                i30 = i48 - iArr13[0];
                i31 = i49 - iArr13[1];
                i32 = i50 - iArr13[2];
                i22++;
                i40++;
                iArr7 = iArr;
            }
            i23 += width;
            i21++;
            bitmapCopy = bitmap2;
            height = i24;
            i14 = i37;
            iArr6 = iArr11;
        }
        Bitmap bitmap3 = bitmapCopy;
        int i51 = i14;
        int[] iArr14 = iArr6;
        int i52 = height;
        int[] iArr15 = iArr7;
        int i53 = 0;
        while (i53 < width) {
            int i54 = -i11;
            int i55 = i15;
            int[] iArr16 = iArr2;
            int i56 = 0;
            int i57 = 0;
            int i58 = 0;
            int i59 = 0;
            int i60 = 0;
            int i61 = 0;
            int i62 = 0;
            int i63 = i54;
            int i64 = i54 * width;
            int i65 = 0;
            int i66 = 0;
            while (i63 <= i11) {
                int i67 = width;
                int iMax = Math.max(0, i64) + i53;
                int[] iArr17 = iArr8[i63 + i11];
                iArr17[0] = iArr3[iMax];
                iArr17[1] = iArr4[iMax];
                iArr17[2] = iArr5[iMax];
                int iAbs2 = i20 - Math.abs(i63);
                i65 += iArr3[iMax] * iAbs2;
                i66 += iArr4[iMax] * iAbs2;
                i56 += iArr5[iMax] * iAbs2;
                if (i63 > 0) {
                    i60 += iArr17[0];
                    i61 += iArr17[1];
                    i62 += iArr17[2];
                } else {
                    i57 += iArr17[0];
                    i58 += iArr17[1];
                    i59 += iArr17[2];
                }
                int i68 = i51;
                if (i63 < i68) {
                    i64 += i67;
                }
                i63++;
                i51 = i68;
                width = i67;
            }
            int i69 = width;
            int i70 = i51;
            int i71 = i53;
            int i72 = i66;
            int i73 = i11;
            int i74 = i52;
            int i75 = i65;
            int i76 = 0;
            while (i76 < i74) {
                iArr16[i71] = (iArr16[i71] & (-16777216)) | (iArr15[i75] << 16) | (iArr15[i72] << 8) | iArr15[i56];
                int i77 = i75 - i57;
                int i78 = i72 - i58;
                int i79 = i56 - i59;
                int[] iArr18 = iArr8[((i73 - i11) + i55) % i55];
                int i80 = i57 - iArr18[0];
                int i81 = i58 - iArr18[1];
                int i82 = i59 - iArr18[2];
                int i83 = i11;
                if (i53 == 0) {
                    iArr14[i76] = Math.min(i76 + i20, i70) * i69;
                }
                int i84 = iArr14[i76] + i53;
                iArr18[0] = iArr3[i84];
                iArr18[1] = iArr4[i84];
                iArr18[2] = iArr5[i84];
                int i85 = i60 + iArr18[0];
                int i86 = i61 + iArr18[1];
                int i87 = i62 + iArr18[2];
                i75 = i77 + i85;
                i72 = i78 + i86;
                i56 = i79 + i87;
                i73 = (i73 + 1) % i55;
                int[] iArr19 = iArr8[i73];
                i57 = i80 + iArr19[0];
                i58 = i81 + iArr19[1];
                i59 = i82 + iArr19[2];
                i60 = i85 - iArr19[0];
                i61 = i86 - iArr19[1];
                i62 = i87 - iArr19[2];
                i71 += i69;
                i76++;
                i11 = i83;
            }
            i53++;
            i51 = i70;
            i52 = i74;
            i15 = i55;
            iArr2 = iArr16;
            width = i69;
        }
        int i88 = width;
        bitmap3.setPixels(iArr2, 0, i88, 0, 0, i88, i52);
        return bitmap3;
    }

    public static Bitmap Q(@g.v int i10) {
        return BitmapFactory.decodeResource(j1.a().getResources(), i10);
    }

    public static Bitmap Q0(Bitmap bitmap) {
        return R0(bitmap, Boolean.FALSE);
    }

    public static Bitmap R(@g.v int i10, int i11, int i12) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        Resources resources = j1.a().getResources();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, i10, options);
        options.inSampleSize = t(options, i11, i12);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(resources, i10, options);
    }

    public static Bitmap R0(Bitmap bitmap, Boolean bool) {
        if (k0(bitmap)) {
            return null;
        }
        Bitmap bitmapExtractAlpha = bitmap.extractAlpha();
        if (bool.booleanValue() && !bitmap.isRecycled() && bitmapExtractAlpha != bitmap) {
            bitmap.recycle();
        }
        return bitmapExtractAlpha;
    }

    public static Bitmap S(File file) {
        if (file == null) {
            return null;
        }
        return BitmapFactory.decodeFile(file.getAbsolutePath());
    }

    public static Bitmap S0(Bitmap bitmap) {
        return T0(bitmap, false);
    }

    public static Bitmap T(File file, int i10, int i11) {
        if (file == null) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        options.inSampleSize = t(options, i10, i11);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(file.getAbsolutePath(), options);
    }

    public static Bitmap T0(Bitmap bitmap, boolean z10) {
        if (k0(bitmap)) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        if (z10 && !bitmap.isRecycled() && bitmapCreateBitmap != bitmap) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }

    public static Bitmap U(FileDescriptor fileDescriptor) {
        if (fileDescriptor == null) {
            return null;
        }
        return BitmapFactory.decodeFileDescriptor(fileDescriptor);
    }

    public static Bitmap U0(Bitmap bitmap) {
        return W0(bitmap, 0, 0, false);
    }

    public static Bitmap V(FileDescriptor fileDescriptor, int i10, int i11) {
        if (fileDescriptor == null) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
        options.inSampleSize = t(options, i10, i11);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
    }

    public static Bitmap V0(Bitmap bitmap, @g.f0(from = 0) int i10, @g.l int i11) {
        return W0(bitmap, i10, i11, false);
    }

    public static Bitmap W(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        return BitmapFactory.decodeStream(inputStream);
    }

    public static Bitmap W0(Bitmap bitmap, @g.f0(from = 0) int i10, @g.l int i11, boolean z10) {
        if (k0(bitmap)) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int iMin = Math.min(width, height);
        Paint paint = new Paint(1);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, bitmap.getConfig());
        float f10 = iMin;
        float f11 = f10 / 2.0f;
        float f12 = width;
        float f13 = height;
        RectF rectF = new RectF(0.0f, 0.0f, f12, f13);
        rectF.inset((width - iMin) / 2.0f, (height - iMin) / 2.0f);
        Matrix matrix = new Matrix();
        matrix.setTranslate(rectF.left, rectF.top);
        if (width != height) {
            matrix.preScale(f10 / f12, f10 / f13);
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawRoundRect(rectF, f11, f11, paint);
        if (i10 > 0) {
            paint.setShader(null);
            paint.setColor(i11);
            paint.setStyle(Paint.Style.STROKE);
            float f14 = i10;
            paint.setStrokeWidth(f14);
            canvas.drawCircle(f12 / 2.0f, f13 / 2.0f, f11 - (f14 / 2.0f), paint);
        }
        if (z10 && !bitmap.isRecycled() && bitmapCreateBitmap != bitmap) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }

    public static Bitmap X(InputStream inputStream, int i10, int i11) {
        if (inputStream == null) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, null, options);
        options.inSampleSize = t(options, i10, i11);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeStream(inputStream, null, options);
    }

    public static Bitmap X0(Bitmap bitmap, boolean z10) {
        return W0(bitmap, 0, 0, z10);
    }

    public static Bitmap Y(String str) {
        if (l1.C0(str)) {
            return null;
        }
        return BitmapFactory.decodeFile(str);
    }

    public static Bitmap Y0(Bitmap bitmap, float f10) {
        return a1(bitmap, f10, 0.0f, 0, false);
    }

    public static Bitmap Z(String str, int i10, int i11) {
        if (l1.C0(str)) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = t(options, i10, i11);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    public static Bitmap Z0(Bitmap bitmap, float f10, @g.x(from = 0.0d) float f11, @g.l int i10) {
        return a1(bitmap, f10, f11, i10, false);
    }

    public static Bitmap a(Bitmap bitmap, @g.x(from = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f10, @g.l int i10, boolean z10, float f11, boolean z11) {
        return b(bitmap, f10, i10, z10, new float[]{f11, f11, f11, f11, f11, f11, f11, f11}, z11);
    }

    public static Bitmap a0(byte[] bArr, int i10) {
        if (bArr.length == 0) {
            return null;
        }
        return BitmapFactory.decodeByteArray(bArr, i10, bArr.length);
    }

    public static Bitmap a1(Bitmap bitmap, float f10, @g.x(from = 0.0d) float f11, @g.l int i10, boolean z10) {
        return d1(bitmap, new float[]{f10, f10, f10, f10, f10, f10, f10, f10}, f11, i10, z10);
    }

    public static Bitmap b(Bitmap bitmap, @g.x(from = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f10, @g.l int i10, boolean z10, float[] fArr, boolean z11) {
        if (k0(bitmap)) {
            return null;
        }
        if (!z11) {
            bitmap = bitmap.copy(bitmap.getConfig(), true);
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint(1);
        paint.setColor(i10);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(f10);
        if (z10) {
            canvas.drawCircle(width / 2.0f, height / 2.0f, (Math.min(width, height) / 2.0f) - (f10 / 2.0f), paint);
        } else {
            RectF rectF = new RectF(0.0f, 0.0f, width, height);
            float f11 = f10 / 2.0f;
            rectF.inset(f11, f11);
            Path path = new Path();
            path.addRoundRect(rectF, fArr, Path.Direction.CW);
            canvas.drawPath(path, paint);
        }
        return bitmap;
    }

    public static Bitmap b0(byte[] bArr, int i10, int i11, int i12) {
        if (bArr.length == 0) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bArr, i10, bArr.length, options);
        options.inSampleSize = t(options, i11, i12);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeByteArray(bArr, i10, bArr.length, options);
    }

    public static Bitmap b1(Bitmap bitmap, float f10, boolean z10) {
        return a1(bitmap, f10, 0.0f, 0, z10);
    }

    public static Bitmap c(Bitmap bitmap, @g.x(from = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f10, @g.l int i10) {
        return a(bitmap, f10, i10, true, 0.0f, false);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x002c -> B:36:0x002f). Please report as a decompilation issue!!! */
    public static ImageType c0(File file) throws Throwable {
        FileInputStream fileInputStream;
        ImageType imageTypeD0;
        FileInputStream fileInputStream2 = null;
        try {
            try {
            } catch (Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
            }
        } catch (IOException e10) {
            e10.printStackTrace();
        }
        if (file == null) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                imageTypeD0 = d0(fileInputStream);
            } catch (IOException e11) {
                e = e11;
                e.printStackTrace();
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            }
        } catch (IOException e12) {
            e = e12;
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e13) {
                    e13.printStackTrace();
                }
            }
            throw th;
        }
        if (imageTypeD0 == null) {
            fileInputStream.close();
            return null;
        }
        try {
            fileInputStream.close();
        } catch (IOException e14) {
            e14.printStackTrace();
        }
        return imageTypeD0;
    }

    public static Bitmap c1(Bitmap bitmap, float[] fArr, @g.x(from = 0.0d) float f10, @g.l int i10) {
        return d1(bitmap, fArr, f10, i10, false);
    }

    public static Bitmap d(Bitmap bitmap, @g.x(from = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f10, @g.l int i10, boolean z10) {
        return a(bitmap, f10, i10, true, 0.0f, z10);
    }

    public static ImageType d0(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try {
            byte[] bArr = new byte[12];
            if (inputStream.read(bArr) != -1) {
                return f0(bArr);
            }
            return null;
        } catch (IOException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static Bitmap d1(Bitmap bitmap, float[] fArr, @g.x(from = 0.0d) float f10, @g.l int i10, boolean z10) {
        if (k0(bitmap)) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Paint paint = new Paint(1);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, bitmap.getConfig());
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        RectF rectF = new RectF(0.0f, 0.0f, width, height);
        float f11 = f10 / 2.0f;
        rectF.inset(f11, f11);
        Path path = new Path();
        path.addRoundRect(rectF, fArr, Path.Direction.CW);
        canvas.drawPath(path, paint);
        if (f10 > 0.0f) {
            paint.setShader(null);
            paint.setColor(i10);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(f10);
            paint.setStrokeCap(Paint.Cap.ROUND);
            canvas.drawPath(path, paint);
        }
        if (z10 && !bitmap.isRecycled() && bitmapCreateBitmap != bitmap) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }

    public static Bitmap e(Bitmap bitmap, @g.x(from = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f10, @g.l int i10, @g.x(from = 0.0d) float f11) {
        return a(bitmap, f10, i10, false, f11, false);
    }

    public static ImageType e0(String str) {
        return c0(l1.P(str));
    }

    public static Bitmap e1(View view) {
        Bitmap bitmapCreateBitmap;
        if (view == null) {
            return null;
        }
        boolean zIsDrawingCacheEnabled = view.isDrawingCacheEnabled();
        boolean zWillNotCacheDrawing = view.willNotCacheDrawing();
        view.setDrawingCacheEnabled(true);
        view.setWillNotCacheDrawing(false);
        Bitmap drawingCache = view.getDrawingCache();
        if (drawingCache == null || drawingCache.isRecycled()) {
            view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            view.buildDrawingCache();
            Bitmap drawingCache2 = view.getDrawingCache();
            if (drawingCache2 == null || drawingCache2.isRecycled()) {
                bitmapCreateBitmap = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.RGB_565);
                view.draw(new Canvas(bitmapCreateBitmap));
            } else {
                bitmapCreateBitmap = Bitmap.createBitmap(drawingCache2);
            }
        } else {
            bitmapCreateBitmap = Bitmap.createBitmap(drawingCache);
        }
        view.setWillNotCacheDrawing(zWillNotCacheDrawing);
        view.setDrawingCacheEnabled(zIsDrawingCacheEnabled);
        return bitmapCreateBitmap;
    }

    public static Bitmap f(Bitmap bitmap, @g.x(from = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f10, @g.l int i10, @g.x(from = 0.0d) float f11, boolean z10) {
        return a(bitmap, f10, i10, false, f11, z10);
    }

    public static ImageType f0(byte[] bArr) {
        String upperCase = l1.l(bArr).toUpperCase();
        return upperCase.contains("FFD8FF") ? ImageType.TYPE_JPG : upperCase.contains("89504E47") ? ImageType.TYPE_PNG : upperCase.contains("47494638") ? ImageType.TYPE_GIF : (upperCase.contains("49492A00") || upperCase.contains("4D4D002A")) ? ImageType.TYPE_TIFF : upperCase.contains("424D") ? ImageType.TYPE_BMP : (upperCase.startsWith("52494646") && upperCase.endsWith("57454250")) ? ImageType.TYPE_WEBP : (upperCase.contains("00000100") || upperCase.contains("00000200")) ? ImageType.TYPE_ICO : ImageType.TYPE_UNKNOWN;
    }

    public static Bitmap g(Bitmap bitmap, @g.x(from = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f10, @g.l int i10, float[] fArr) {
        return b(bitmap, f10, i10, false, fArr, false);
    }

    public static int g0(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt(i1.a.C, 1);
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt != 6) {
                return attributeInt != 8 ? 0 : 270;
            }
            return 90;
        } catch (IOException e10) {
            e10.printStackTrace();
            return -1;
        }
    }

    public static Bitmap h(Bitmap bitmap, @g.x(from = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f10, @g.l int i10, float[] fArr, boolean z10) {
        return b(bitmap, f10, i10, false, fArr, z10);
    }

    public static int[] h0(File file) {
        if (file == null) {
            return new int[]{0, 0};
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(file.getAbsolutePath(), options);
        return new int[]{options.outWidth, options.outHeight};
    }

    public static Bitmap i(Bitmap bitmap, Bitmap bitmap2, int i10, int i11, int i12) {
        return j(bitmap, bitmap2, i10, i11, i12, false);
    }

    public static int[] i0(String str) {
        return h0(l1.P(str));
    }

    public static Bitmap j(Bitmap bitmap, Bitmap bitmap2, int i10, int i11, int i12, boolean z10) {
        if (k0(bitmap)) {
            return null;
        }
        Bitmap bitmapCopy = bitmap.copy(bitmap.getConfig(), true);
        if (!k0(bitmap2)) {
            Paint paint = new Paint(1);
            Canvas canvas = new Canvas(bitmapCopy);
            paint.setAlpha(i12);
            canvas.drawBitmap(bitmap2, i10, i11, paint);
        }
        if (z10 && !bitmap.isRecycled() && bitmapCopy != bitmap) {
            bitmap.recycle();
        }
        return bitmapCopy;
    }

    public static boolean j0(byte[] bArr) {
        return bArr.length >= 2 && bArr[0] == 66 && bArr[1] == 77;
    }

    public static Bitmap k(Bitmap bitmap, int i10) {
        return l(bitmap, i10, false);
    }

    public static boolean k0(Bitmap bitmap) {
        return bitmap == null || bitmap.getWidth() == 0 || bitmap.getHeight() == 0;
    }

    public static Bitmap l(Bitmap bitmap, int i10, boolean z10) {
        if (k0(bitmap)) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.preScale(1.0f, -1.0f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, height - i10, width, i10, matrix, false);
        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(width, height + i10, bitmap.getConfig());
        Canvas canvas = new Canvas(bitmapCreateBitmap2);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        float f10 = height + 0;
        canvas.drawBitmap(bitmapCreateBitmap, 0.0f, f10, (Paint) null);
        Paint paint = new Paint(1);
        paint.setShader(new LinearGradient(0.0f, height, 0.0f, bitmapCreateBitmap2.getHeight() + 0, 1895825407, 16777215, Shader.TileMode.MIRROR));
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        canvas.drawRect(0.0f, f10, width, bitmapCreateBitmap2.getHeight(), paint);
        if (!bitmapCreateBitmap.isRecycled()) {
            bitmapCreateBitmap.recycle();
        }
        if (z10 && !bitmap.isRecycled() && bitmapCreateBitmap2 != bitmap) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap2;
    }

    public static boolean l0(byte[] bArr) {
        return bArr.length >= 6 && bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70 && bArr[3] == 56 && (bArr[4] == 55 || bArr[4] == 57) && bArr[5] == 97;
    }

    public static Bitmap m(Bitmap bitmap, String str, float f10, @g.l int i10, float f11, float f12, boolean z10) {
        if (k0(bitmap) || str == null) {
            return null;
        }
        Bitmap bitmapCopy = bitmap.copy(bitmap.getConfig(), true);
        Paint paint = new Paint(1);
        Canvas canvas = new Canvas(bitmapCopy);
        paint.setColor(i10);
        paint.setTextSize(f10);
        paint.getTextBounds(str, 0, str.length(), new Rect());
        canvas.drawText(str, f11, f12 + f10, paint);
        if (z10 && !bitmap.isRecycled() && bitmapCopy != bitmap) {
            bitmap.recycle();
        }
        return bitmapCopy;
    }

    public static boolean m0(File file) {
        if (file == null || !file.exists()) {
            return false;
        }
        return n0(file.getPath());
    }

    public static Bitmap n(Bitmap bitmap, String str, int i10, @g.l int i11, float f10, float f11) {
        return m(bitmap, str, i10, i11, f10, f11, false);
    }

    public static boolean n0(String str) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            if (options.outWidth > 0) {
                return options.outHeight > 0;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static byte[] o(Bitmap bitmap) {
        return p(bitmap, Bitmap.CompressFormat.PNG, 100);
    }

    public static boolean o0(byte[] bArr) {
        return bArr.length >= 2 && bArr[0] == -1 && bArr[1] == -40;
    }

    public static byte[] p(Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i10) {
        if (bitmap == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(compressFormat, i10, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static boolean p0(byte[] bArr) {
        return bArr.length >= 8 && bArr[0] == -119 && bArr[1] == 80 && bArr[2] == 78 && bArr[3] == 71 && bArr[4] == 13 && bArr[5] == 10 && bArr[6] == 26 && bArr[7] == 10;
    }

    public static Drawable q(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return new BitmapDrawable(j1.a().getResources(), bitmap);
    }

    @g.v0(17)
    public static Bitmap q0(Bitmap bitmap, @g.x(from = 0.0d, fromInclusive = false, to = 25.0d) float f10) {
        return r0(bitmap, f10, false);
    }

    public static Bitmap r(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        return BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
    }

    @g.v0(17)
    public static Bitmap r0(Bitmap bitmap, @g.x(from = 0.0d, fromInclusive = false, to = 25.0d) float f10, boolean z10) {
        if (!z10) {
            bitmap = bitmap.copy(bitmap.getConfig(), true);
        }
        RenderScript renderScriptCreate = null;
        try {
            renderScriptCreate = RenderScript.create(j1.a());
            renderScriptCreate.setMessageHandler(new RenderScript.RSMessageHandler());
            Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
            Allocation allocationCreateTyped = Allocation.createTyped(renderScriptCreate, allocationCreateFromBitmap.getType());
            ScriptIntrinsicBlur scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
            scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
            scriptIntrinsicBlurCreate.setRadius(f10);
            scriptIntrinsicBlurCreate.forEach(allocationCreateTyped);
            allocationCreateTyped.copyTo(bitmap);
            renderScriptCreate.destroy();
            return bitmap;
        } catch (Throwable th2) {
            if (renderScriptCreate != null) {
                renderScriptCreate.destroy();
            }
            throw th2;
        }
    }

    public static Drawable s(byte[] bArr) {
        return q(r(bArr));
    }

    public static Bitmap s0(Bitmap bitmap, int i10, float f10, float f11) {
        return t0(bitmap, i10, f10, f11, false);
    }

    public static int t(BitmapFactory.Options options, int i10, int i11) {
        int i12 = options.outHeight;
        int i13 = options.outWidth;
        int i14 = 1;
        while (true) {
            if (i12 <= i11 && i13 <= i10) {
                return i14;
            }
            i12 >>= 1;
            i13 >>= 1;
            i14 <<= 1;
        }
    }

    public static Bitmap t0(Bitmap bitmap, int i10, float f10, float f11, boolean z10) {
        if (k0(bitmap)) {
            return null;
        }
        if (i10 == 0) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.setRotate(i10, f10, f11);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (z10 && !bitmap.isRecycled() && bitmapCreateBitmap != bitmap) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }

    public static Bitmap u(Bitmap bitmap, int i10, int i11, int i12, int i13) {
        return v(bitmap, i10, i11, i12, i13, false);
    }

    public static boolean u0(Bitmap bitmap, File file, Bitmap.CompressFormat compressFormat) {
        return w0(bitmap, file, compressFormat, 100, false);
    }

    public static Bitmap v(Bitmap bitmap, int i10, int i11, int i12, int i13, boolean z10) {
        if (k0(bitmap)) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, i10, i11, i12, i13);
        if (z10 && !bitmap.isRecycled() && bitmapCreateBitmap != bitmap) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }

    public static boolean v0(Bitmap bitmap, File file, Bitmap.CompressFormat compressFormat, int i10) {
        return w0(bitmap, file, compressFormat, i10, false);
    }

    public static byte[] w(Bitmap bitmap, @g.f0(from = 0, to = 100) int i10) {
        return x(bitmap, i10, false);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0047 -> B:40:0x005c). Please report as a decompilation issue!!! */
    public static boolean w0(Bitmap bitmap, File file, Bitmap.CompressFormat compressFormat, int i10, boolean z10) throws Throwable {
        BufferedOutputStream bufferedOutputStream;
        boolean zCompress = false;
        if (k0(bitmap) || bitmap.isRecycled()) {
            return false;
        }
        if (!l1.r(file)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("create or delete file <");
            sb2.append(file);
            sb2.append("> failed.");
            return false;
        }
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e10) {
                e = e10;
            }
            try {
                zCompress = bitmap.compress(compressFormat, i10, bufferedOutputStream);
                if (z10 && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
                bufferedOutputStream.close();
            } catch (IOException e11) {
                e = e11;
                bufferedOutputStream2 = bufferedOutputStream;
                e.printStackTrace();
                if (bufferedOutputStream2 != null) {
                    bufferedOutputStream2.close();
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream2 = bufferedOutputStream;
                if (bufferedOutputStream2 != null) {
                    try {
                        bufferedOutputStream2.close();
                    } catch (IOException e12) {
                        e12.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e13) {
            e13.printStackTrace();
        }
        return zCompress;
    }

    public static byte[] x(Bitmap bitmap, @g.f0(from = 0, to = 100) int i10, boolean z10) {
        if (k0(bitmap)) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, i10, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (z10 && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return byteArray;
    }

    public static boolean x0(Bitmap bitmap, File file, Bitmap.CompressFormat compressFormat, boolean z10) {
        return w0(bitmap, file, compressFormat, 100, z10);
    }

    public static byte[] y(Bitmap bitmap, long j10) {
        return z(bitmap, j10, false);
    }

    public static boolean y0(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat) {
        return A0(bitmap, str, compressFormat, 100, false);
    }

    public static byte[] z(Bitmap bitmap, long j10, boolean z10) {
        byte[] byteArray;
        int i10 = 0;
        if (k0(bitmap) || j10 <= 0) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i11 = 100;
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        if (byteArrayOutputStream.size() <= j10) {
            byteArray = byteArrayOutputStream.toByteArray();
        } else {
            byteArrayOutputStream.reset();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 0, byteArrayOutputStream);
            if (byteArrayOutputStream.size() >= j10) {
                byteArray = byteArrayOutputStream.toByteArray();
            } else {
                int i12 = 0;
                while (i10 < i11) {
                    i12 = (i10 + i11) / 2;
                    byteArrayOutputStream.reset();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, i12, byteArrayOutputStream);
                    long size = byteArrayOutputStream.size();
                    if (size == j10) {
                        break;
                    }
                    if (size > j10) {
                        i11 = i12 - 1;
                    } else {
                        i10 = i12 + 1;
                    }
                }
                if (i11 == i12 - 1) {
                    byteArrayOutputStream.reset();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, i10, byteArrayOutputStream);
                }
                byteArray = byteArrayOutputStream.toByteArray();
            }
        }
        if (z10 && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return byteArray;
    }

    public static boolean z0(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat, int i10) {
        return w0(bitmap, l1.P(str), compressFormat, i10, false);
    }
}
