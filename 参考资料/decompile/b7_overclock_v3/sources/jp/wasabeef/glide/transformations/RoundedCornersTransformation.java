package jp.wasabeef.glide.transformations;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import c4.b;
import com.bumptech.glide.load.engine.bitmap_recycle.e;
import g.n0;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes5.dex */
public class RoundedCornersTransformation extends qj.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f36806g = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f36807h = "jp.wasabeef.glide.transformations.RoundedCornersTransformation.1";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f36808c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f36809d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f36810e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CornerType f36811f;

    public enum CornerType {
        ALL,
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT,
        TOP,
        BOTTOM,
        LEFT,
        RIGHT,
        OTHER_TOP_LEFT,
        OTHER_TOP_RIGHT,
        OTHER_BOTTOM_LEFT,
        OTHER_BOTTOM_RIGHT,
        DIAGONAL_FROM_TOP_LEFT,
        DIAGONAL_FROM_TOP_RIGHT
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f36812a;

        static {
            int[] iArr = new int[CornerType.values().length];
            f36812a = iArr;
            try {
                iArr[CornerType.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f36812a[CornerType.TOP_LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f36812a[CornerType.TOP_RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f36812a[CornerType.BOTTOM_LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f36812a[CornerType.BOTTOM_RIGHT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f36812a[CornerType.TOP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f36812a[CornerType.BOTTOM.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f36812a[CornerType.LEFT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f36812a[CornerType.RIGHT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f36812a[CornerType.OTHER_TOP_LEFT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f36812a[CornerType.OTHER_TOP_RIGHT.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f36812a[CornerType.OTHER_BOTTOM_LEFT.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f36812a[CornerType.OTHER_BOTTOM_RIGHT.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f36812a[CornerType.DIAGONAL_FROM_TOP_LEFT.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f36812a[CornerType.DIAGONAL_FROM_TOP_RIGHT.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
        }
    }

    public RoundedCornersTransformation(int i10, int i11) {
        this(i10, i11, CornerType.ALL);
    }

    @Override // qj.a, c4.b
    public void a(@n0 MessageDigest messageDigest) {
        messageDigest.update((f36807h + this.f36808c + this.f36809d + this.f36810e + this.f36811f).getBytes(b.f9745b));
    }

    @Override // qj.a
    public Bitmap c(@n0 Context context, @n0 e eVar, @n0 Bitmap bitmap, int i10, int i11) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap bitmapF = eVar.f(width, height, Bitmap.Config.ARGB_8888);
        bitmapF.setHasAlpha(true);
        Canvas canvas = new Canvas(bitmapF);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
        o(canvas, paint, width, height);
        return bitmapF;
    }

    public final void d(Canvas canvas, Paint paint, float f10, float f11) {
        RectF rectF = new RectF(this.f36810e, f11 - this.f36809d, r1 + r3, f11);
        int i10 = this.f36808c;
        canvas.drawRoundRect(rectF, i10, i10, paint);
        int i11 = this.f36810e;
        canvas.drawRect(new RectF(i11, i11, i11 + this.f36809d, f11 - this.f36808c), paint);
        canvas.drawRect(new RectF(this.f36808c + r1, this.f36810e, f10, f11), paint);
    }

    public final void e(Canvas canvas, Paint paint, float f10, float f11) {
        int i10 = this.f36809d;
        RectF rectF = new RectF(f10 - i10, f11 - i10, f10, f11);
        int i11 = this.f36808c;
        canvas.drawRoundRect(rectF, i11, i11, paint);
        int i12 = this.f36810e;
        canvas.drawRect(new RectF(i12, i12, f10 - this.f36808c, f11), paint);
        int i13 = this.f36808c;
        canvas.drawRect(new RectF(f10 - i13, this.f36810e, f10, f11 - i13), paint);
    }

    @Override // qj.a, c4.b
    public boolean equals(Object obj) {
        if (obj instanceof RoundedCornersTransformation) {
            RoundedCornersTransformation roundedCornersTransformation = (RoundedCornersTransformation) obj;
            if (roundedCornersTransformation.f36808c == this.f36808c && roundedCornersTransformation.f36809d == this.f36809d && roundedCornersTransformation.f36810e == this.f36810e && roundedCornersTransformation.f36811f == this.f36811f) {
                return true;
            }
        }
        return false;
    }

    public final void f(Canvas canvas, Paint paint, float f10, float f11) {
        RectF rectF = new RectF(this.f36810e, f11 - this.f36809d, f10, f11);
        int i10 = this.f36808c;
        canvas.drawRoundRect(rectF, i10, i10, paint);
        int i11 = this.f36810e;
        canvas.drawRect(new RectF(i11, i11, f10, f11 - this.f36808c), paint);
    }

    public final void g(Canvas canvas, Paint paint, float f10, float f11) {
        int i10 = this.f36810e;
        int i11 = this.f36809d;
        RectF rectF = new RectF(i10, i10, i10 + i11, i10 + i11);
        int i12 = this.f36808c;
        canvas.drawRoundRect(rectF, i12, i12, paint);
        int i13 = this.f36809d;
        RectF rectF2 = new RectF(f10 - i13, f11 - i13, f10, f11);
        int i14 = this.f36808c;
        canvas.drawRoundRect(rectF2, i14, i14, paint);
        canvas.drawRect(new RectF(this.f36810e, r1 + this.f36808c, f10 - this.f36809d, f11), paint);
        canvas.drawRect(new RectF(this.f36809d + r1, this.f36810e, f10, f11 - this.f36808c), paint);
    }

    public final void h(Canvas canvas, Paint paint, float f10, float f11) {
        int i10 = this.f36809d;
        RectF rectF = new RectF(f10 - i10, this.f36810e, f10, r3 + i10);
        int i11 = this.f36808c;
        canvas.drawRoundRect(rectF, i11, i11, paint);
        RectF rectF2 = new RectF(this.f36810e, f11 - this.f36809d, r1 + r3, f11);
        int i12 = this.f36808c;
        canvas.drawRoundRect(rectF2, i12, i12, paint);
        int i13 = this.f36810e;
        int i14 = this.f36808c;
        canvas.drawRect(new RectF(i13, i13, f10 - i14, f11 - i14), paint);
        int i15 = this.f36810e;
        int i16 = this.f36808c;
        canvas.drawRect(new RectF(i15 + i16, i15 + i16, f10, f11), paint);
    }

    @Override // qj.a, c4.b
    public int hashCode() {
        return 425235636 + (this.f36808c * 10000) + (this.f36809d * 1000) + (this.f36810e * 100) + (this.f36811f.ordinal() * 10);
    }

    public final void i(Canvas canvas, Paint paint, float f10, float f11) {
        int i10 = this.f36810e;
        RectF rectF = new RectF(i10, i10, i10 + this.f36809d, f11);
        int i11 = this.f36808c;
        canvas.drawRoundRect(rectF, i11, i11, paint);
        canvas.drawRect(new RectF(this.f36808c + r1, this.f36810e, f10, f11), paint);
    }

    public final void j(Canvas canvas, Paint paint, float f10, float f11) {
        int i10 = this.f36810e;
        RectF rectF = new RectF(i10, i10, f10, i10 + this.f36809d);
        int i11 = this.f36808c;
        canvas.drawRoundRect(rectF, i11, i11, paint);
        RectF rectF2 = new RectF(f10 - this.f36809d, this.f36810e, f10, f11);
        int i12 = this.f36808c;
        canvas.drawRoundRect(rectF2, i12, i12, paint);
        canvas.drawRect(new RectF(this.f36810e, r1 + r3, f10 - this.f36808c, f11), paint);
    }

    public final void k(Canvas canvas, Paint paint, float f10, float f11) {
        int i10 = this.f36810e;
        RectF rectF = new RectF(i10, i10, f10, i10 + this.f36809d);
        int i11 = this.f36808c;
        canvas.drawRoundRect(rectF, i11, i11, paint);
        int i12 = this.f36810e;
        RectF rectF2 = new RectF(i12, i12, i12 + this.f36809d, f11);
        int i13 = this.f36808c;
        canvas.drawRoundRect(rectF2, i13, i13, paint);
        int i14 = this.f36810e;
        int i15 = this.f36808c;
        canvas.drawRect(new RectF(i14 + i15, i14 + i15, f10, f11), paint);
    }

    public final void l(Canvas canvas, Paint paint, float f10, float f11) {
        RectF rectF = new RectF(this.f36810e, f11 - this.f36809d, f10, f11);
        int i10 = this.f36808c;
        canvas.drawRoundRect(rectF, i10, i10, paint);
        RectF rectF2 = new RectF(f10 - this.f36809d, this.f36810e, f10, f11);
        int i11 = this.f36808c;
        canvas.drawRoundRect(rectF2, i11, i11, paint);
        int i12 = this.f36810e;
        int i13 = this.f36808c;
        canvas.drawRect(new RectF(i12, i12, f10 - i13, f11 - i13), paint);
    }

    public final void m(Canvas canvas, Paint paint, float f10, float f11) {
        int i10 = this.f36810e;
        RectF rectF = new RectF(i10, i10, i10 + this.f36809d, f11);
        int i11 = this.f36808c;
        canvas.drawRoundRect(rectF, i11, i11, paint);
        RectF rectF2 = new RectF(this.f36810e, f11 - this.f36809d, f10, f11);
        int i12 = this.f36808c;
        canvas.drawRoundRect(rectF2, i12, i12, paint);
        canvas.drawRect(new RectF(r1 + r2, this.f36810e, f10, f11 - this.f36808c), paint);
    }

    public final void n(Canvas canvas, Paint paint, float f10, float f11) {
        RectF rectF = new RectF(f10 - this.f36809d, this.f36810e, f10, f11);
        int i10 = this.f36808c;
        canvas.drawRoundRect(rectF, i10, i10, paint);
        int i11 = this.f36810e;
        canvas.drawRect(new RectF(i11, i11, f10 - this.f36808c, f11), paint);
    }

    public final void o(Canvas canvas, Paint paint, float f10, float f11) {
        int i10 = this.f36810e;
        float f12 = f10 - i10;
        float f13 = f11 - i10;
        switch (a.f36812a[this.f36811f.ordinal()]) {
            case 1:
                int i11 = this.f36810e;
                RectF rectF = new RectF(i11, i11, f12, f13);
                int i12 = this.f36808c;
                canvas.drawRoundRect(rectF, i12, i12, paint);
                break;
            case 2:
                p(canvas, paint, f12, f13);
                break;
            case 3:
                q(canvas, paint, f12, f13);
                break;
            case 4:
                d(canvas, paint, f12, f13);
                break;
            case 5:
                e(canvas, paint, f12, f13);
                break;
            case 6:
                r(canvas, paint, f12, f13);
                break;
            case 7:
                f(canvas, paint, f12, f13);
                break;
            case 8:
                i(canvas, paint, f12, f13);
                break;
            case 9:
                n(canvas, paint, f12, f13);
                break;
            case 10:
                l(canvas, paint, f12, f13);
                break;
            case 11:
                m(canvas, paint, f12, f13);
                break;
            case 12:
                j(canvas, paint, f12, f13);
                break;
            case 13:
                k(canvas, paint, f12, f13);
                break;
            case 14:
                g(canvas, paint, f12, f13);
                break;
            case 15:
                h(canvas, paint, f12, f13);
                break;
            default:
                int i13 = this.f36810e;
                RectF rectF2 = new RectF(i13, i13, f12, f13);
                int i14 = this.f36808c;
                canvas.drawRoundRect(rectF2, i14, i14, paint);
                break;
        }
    }

    public final void p(Canvas canvas, Paint paint, float f10, float f11) {
        int i10 = this.f36810e;
        int i11 = this.f36809d;
        RectF rectF = new RectF(i10, i10, i10 + i11, i10 + i11);
        int i12 = this.f36808c;
        canvas.drawRoundRect(rectF, i12, i12, paint);
        int i13 = this.f36810e;
        int i14 = this.f36808c;
        canvas.drawRect(new RectF(i13, i13 + i14, i13 + i14, f11), paint);
        canvas.drawRect(new RectF(this.f36808c + r1, this.f36810e, f10, f11), paint);
    }

    public final void q(Canvas canvas, Paint paint, float f10, float f11) {
        int i10 = this.f36809d;
        RectF rectF = new RectF(f10 - i10, this.f36810e, f10, r3 + i10);
        int i11 = this.f36808c;
        canvas.drawRoundRect(rectF, i11, i11, paint);
        int i12 = this.f36810e;
        canvas.drawRect(new RectF(i12, i12, f10 - this.f36808c, f11), paint);
        canvas.drawRect(new RectF(f10 - this.f36808c, this.f36810e + r1, f10, f11), paint);
    }

    public final void r(Canvas canvas, Paint paint, float f10, float f11) {
        int i10 = this.f36810e;
        RectF rectF = new RectF(i10, i10, f10, i10 + this.f36809d);
        int i11 = this.f36808c;
        canvas.drawRoundRect(rectF, i11, i11, paint);
        canvas.drawRect(new RectF(this.f36810e, r1 + this.f36808c, f10, f11), paint);
    }

    public String toString() {
        return "RoundedTransformation(radius=" + this.f36808c + ", margin=" + this.f36810e + ", diameter=" + this.f36809d + ", cornerType=" + this.f36811f.name() + ee.a.f26979d;
    }

    public RoundedCornersTransformation(int i10, int i11, CornerType cornerType) {
        this.f36808c = i10;
        this.f36809d = i10 * 2;
        this.f36810e = i11;
        this.f36811f = cornerType;
    }
}
