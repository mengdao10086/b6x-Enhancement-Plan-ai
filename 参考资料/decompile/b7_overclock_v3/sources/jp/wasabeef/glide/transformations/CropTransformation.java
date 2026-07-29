package jp.wasabeef.glide.transformations;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import c4.b;
import com.bumptech.glide.load.engine.bitmap_recycle.e;
import g.n0;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes5.dex */
public class CropTransformation extends qj.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f36800f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f36801g = "jp.wasabeef.glide.transformations.CropTransformation.1";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f36802c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f36803d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CropType f36804e;

    public enum CropType {
        TOP,
        CENTER,
        BOTTOM
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f36805a;

        static {
            int[] iArr = new int[CropType.values().length];
            f36805a = iArr;
            try {
                iArr[CropType.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f36805a[CropType.CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f36805a[CropType.BOTTOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public CropTransformation(int i10, int i11) {
        this(i10, i11, CropType.CENTER);
    }

    @Override // qj.a, c4.b
    public void a(@n0 MessageDigest messageDigest) {
        messageDigest.update((f36801g + this.f36802c + this.f36803d + this.f36804e).getBytes(b.f9745b));
    }

    @Override // qj.a
    public Bitmap c(@n0 Context context, @n0 e eVar, @n0 Bitmap bitmap, int i10, int i11) {
        int width = this.f36802c;
        if (width == 0) {
            width = bitmap.getWidth();
        }
        this.f36802c = width;
        int height = this.f36803d;
        if (height == 0) {
            height = bitmap.getHeight();
        }
        this.f36803d = height;
        Bitmap bitmapF = eVar.f(this.f36802c, this.f36803d, bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888);
        bitmapF.setHasAlpha(true);
        float fMax = Math.max(this.f36802c / bitmap.getWidth(), this.f36803d / bitmap.getHeight());
        float width2 = bitmap.getWidth() * fMax;
        float height2 = fMax * bitmap.getHeight();
        float f10 = (this.f36802c - width2) / 2.0f;
        float fD = d(height2);
        new Canvas(bitmapF).drawBitmap(bitmap, (Rect) null, new RectF(f10, fD, width2 + f10, height2 + fD), (Paint) null);
        return bitmapF;
    }

    public final float d(float f10) {
        int i10 = a.f36805a[this.f36804e.ordinal()];
        if (i10 == 2) {
            return (this.f36803d - f10) / 2.0f;
        }
        if (i10 != 3) {
            return 0.0f;
        }
        return this.f36803d - f10;
    }

    @Override // qj.a, c4.b
    public boolean equals(Object obj) {
        if (obj instanceof CropTransformation) {
            CropTransformation cropTransformation = (CropTransformation) obj;
            if (cropTransformation.f36802c == this.f36802c && cropTransformation.f36803d == this.f36803d && cropTransformation.f36804e == this.f36804e) {
                return true;
            }
        }
        return false;
    }

    @Override // qj.a, c4.b
    public int hashCode() {
        return (-1462327117) + (this.f36802c * 100000) + (this.f36803d * 1000) + (this.f36804e.ordinal() * 10);
    }

    public String toString() {
        return "CropTransformation(width=" + this.f36802c + ", height=" + this.f36803d + ", cropType=" + this.f36804e + ee.a.f26979d;
    }

    public CropTransformation(int i10, int i11, CropType cropType) {
        CropType cropType2 = CropType.CENTER;
        this.f36802c = i10;
        this.f36803d = i11;
        this.f36804e = cropType;
    }
}
