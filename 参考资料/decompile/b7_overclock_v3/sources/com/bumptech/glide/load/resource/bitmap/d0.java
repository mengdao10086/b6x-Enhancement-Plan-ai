package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.util.Log;
import g.i1;
import g.n0;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes2.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f12575a = "TransformationUtils";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f12576b = 6;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f12578d = 7;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Paint f12580f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Set<String> f12581g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lock f12582h;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Paint f12577c = new Paint(6);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Paint f12579e = new Paint(7);

    public class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f12583a;

        public a(int i10) {
            this.f12583a = i10;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.d0.c
        public void a(Canvas canvas, Paint paint, RectF rectF) {
            int i10 = this.f12583a;
            canvas.drawRoundRect(rectF, i10, i10, paint);
        }
    }

    public class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f12584a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f12585b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ float f12586c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ float f12587d;

        public b(float f10, float f11, float f12, float f13) {
            this.f12584a = f10;
            this.f12585b = f11;
            this.f12586c = f12;
            this.f12587d = f13;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.d0.c
        public void a(Canvas canvas, Paint paint, RectF rectF) {
            Path path = new Path();
            float f10 = this.f12584a;
            float f11 = this.f12585b;
            float f12 = this.f12586c;
            float f13 = this.f12587d;
            path.addRoundRect(rectF, new float[]{f10, f10, f11, f11, f12, f12, f13, f13}, Path.Direction.CW);
            canvas.drawPath(path, paint);
        }
    }

    public interface c {
        void a(Canvas canvas, Paint paint, RectF rectF);
    }

    public static final class d implements Lock {
        @Override // java.util.concurrent.locks.Lock
        public void lock() {
        }

        @Override // java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
        }

        @Override // java.util.concurrent.locks.Lock
        @n0
        public Condition newCondition() {
            throw new UnsupportedOperationException("Should not be called");
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock() {
            return true;
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock(long j10, @n0 TimeUnit timeUnit) throws InterruptedException {
            return true;
        }

        @Override // java.util.concurrent.locks.Lock
        public void unlock() {
        }
    }

    static {
        HashSet hashSet = new HashSet(Arrays.asList("XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079"));
        f12581g = hashSet;
        f12582h = hashSet.contains(Build.MODEL) ? new ReentrantLock() : new d();
        Paint paint = new Paint(7);
        f12580f = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    public static void a(@n0 Bitmap bitmap, @n0 Bitmap bitmap2, Matrix matrix) {
        Lock lock = f12582h;
        lock.lock();
        try {
            Canvas canvas = new Canvas(bitmap2);
            canvas.drawBitmap(bitmap, matrix, f12577c);
            e(canvas);
            lock.unlock();
        } catch (Throwable th2) {
            f12582h.unlock();
            throw th2;
        }
    }

    public static Bitmap b(@n0 com.bumptech.glide.load.engine.bitmap_recycle.e eVar, @n0 Bitmap bitmap, int i10, int i11) {
        float width;
        float height;
        if (bitmap.getWidth() == i10 && bitmap.getHeight() == i11) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        float width2 = 0.0f;
        if (bitmap.getWidth() * i11 > bitmap.getHeight() * i10) {
            width = i11 / bitmap.getHeight();
            width2 = (i10 - (bitmap.getWidth() * width)) * 0.5f;
            height = 0.0f;
        } else {
            width = i10 / bitmap.getWidth();
            height = (i11 - (bitmap.getHeight() * width)) * 0.5f;
        }
        matrix.setScale(width, width);
        matrix.postTranslate((int) (width2 + 0.5f), (int) (height + 0.5f));
        Bitmap bitmapF = eVar.f(i10, i11, k(bitmap));
        t(bitmap, bitmapF);
        a(bitmap, bitmapF, matrix);
        return bitmapF;
    }

    public static Bitmap c(@n0 com.bumptech.glide.load.engine.bitmap_recycle.e eVar, @n0 Bitmap bitmap, int i10, int i11) {
        return (bitmap.getWidth() > i10 || bitmap.getHeight() > i11) ? f(eVar, bitmap, i10, i11) : bitmap;
    }

    public static Bitmap d(@n0 com.bumptech.glide.load.engine.bitmap_recycle.e eVar, @n0 Bitmap bitmap, int i10, int i11) {
        int iMin = Math.min(i10, i11);
        float f10 = iMin;
        float f11 = f10 / 2.0f;
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        float fMax = Math.max(f10 / width, f10 / height);
        float f12 = width * fMax;
        float f13 = fMax * height;
        float f14 = (f10 - f12) / 2.0f;
        float f15 = (f10 - f13) / 2.0f;
        RectF rectF = new RectF(f14, f15, f12 + f14, f13 + f15);
        Bitmap bitmapG = g(eVar, bitmap);
        Bitmap bitmapF = eVar.f(iMin, iMin, h(bitmap));
        bitmapF.setHasAlpha(true);
        Lock lock = f12582h;
        lock.lock();
        try {
            Canvas canvas = new Canvas(bitmapF);
            canvas.drawCircle(f11, f11, f11, f12579e);
            canvas.drawBitmap(bitmapG, (Rect) null, rectF, f12580f);
            e(canvas);
            lock.unlock();
            if (!bitmapG.equals(bitmap)) {
                eVar.e(bitmapG);
            }
            return bitmapF;
        } catch (Throwable th2) {
            f12582h.unlock();
            throw th2;
        }
    }

    public static void e(Canvas canvas) {
        canvas.setBitmap(null);
    }

    public static Bitmap f(@n0 com.bumptech.glide.load.engine.bitmap_recycle.e eVar, @n0 Bitmap bitmap, int i10, int i11) {
        if (bitmap.getWidth() == i10 && bitmap.getHeight() == i11) {
            return bitmap;
        }
        float fMin = Math.min(i10 / bitmap.getWidth(), i11 / bitmap.getHeight());
        int iRound = Math.round(bitmap.getWidth() * fMin);
        int iRound2 = Math.round(bitmap.getHeight() * fMin);
        if (bitmap.getWidth() == iRound && bitmap.getHeight() == iRound2) {
            return bitmap;
        }
        Bitmap bitmapF = eVar.f((int) (bitmap.getWidth() * fMin), (int) (bitmap.getHeight() * fMin), k(bitmap));
        t(bitmap, bitmapF);
        if (Log.isLoggable(f12575a, 2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("request: ");
            sb2.append(i10);
            sb2.append("x");
            sb2.append(i11);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("toFit:   ");
            sb3.append(bitmap.getWidth());
            sb3.append("x");
            sb3.append(bitmap.getHeight());
            StringBuilder sb4 = new StringBuilder();
            sb4.append("toReuse: ");
            sb4.append(bitmapF.getWidth());
            sb4.append("x");
            sb4.append(bitmapF.getHeight());
            StringBuilder sb5 = new StringBuilder();
            sb5.append("minPct:   ");
            sb5.append(fMin);
        }
        Matrix matrix = new Matrix();
        matrix.setScale(fMin, fMin);
        a(bitmap, bitmapF, matrix);
        return bitmapF;
    }

    public static Bitmap g(@n0 com.bumptech.glide.load.engine.bitmap_recycle.e eVar, @n0 Bitmap bitmap) {
        Bitmap.Config configH = h(bitmap);
        if (configH.equals(bitmap.getConfig())) {
            return bitmap;
        }
        Bitmap bitmapF = eVar.f(bitmap.getWidth(), bitmap.getHeight(), configH);
        new Canvas(bitmapF).drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        return bitmapF;
    }

    @n0
    public static Bitmap.Config h(@n0 Bitmap bitmap) {
        return (Build.VERSION.SDK_INT < 26 || !Bitmap.Config.RGBA_F16.equals(bitmap.getConfig())) ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGBA_F16;
    }

    public static Lock i() {
        return f12582h;
    }

    public static int j(int i10) {
        switch (i10) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    @n0
    public static Bitmap.Config k(@n0 Bitmap bitmap) {
        return bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888;
    }

    @i1
    public static void l(int i10, Matrix matrix) {
        switch (i10) {
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                break;
            case 3:
                matrix.setRotate(180.0f);
                break;
            case 4:
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 5:
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 6:
                matrix.setRotate(90.0f);
                break;
            case 7:
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 8:
                matrix.setRotate(-90.0f);
                break;
        }
    }

    public static boolean m(int i10) {
        switch (i10) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }

    public static Bitmap n(@n0 Bitmap bitmap, int i10) {
        if (i10 == 0) {
            return bitmap;
        }
        try {
            Matrix matrix = new Matrix();
            matrix.setRotate(i10);
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Exception unused) {
            return bitmap;
        }
    }

    public static Bitmap o(@n0 com.bumptech.glide.load.engine.bitmap_recycle.e eVar, @n0 Bitmap bitmap, int i10) {
        if (!m(i10)) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        l(i10, matrix);
        RectF rectF = new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight());
        matrix.mapRect(rectF);
        Bitmap bitmapF = eVar.f(Math.round(rectF.width()), Math.round(rectF.height()), k(bitmap));
        matrix.postTranslate(-rectF.left, -rectF.top);
        bitmapF.setHasAlpha(bitmap.hasAlpha());
        a(bitmap, bitmapF, matrix);
        return bitmapF;
    }

    public static Bitmap p(@n0 com.bumptech.glide.load.engine.bitmap_recycle.e eVar, @n0 Bitmap bitmap, float f10, float f11, float f12, float f13) {
        return s(eVar, bitmap, new b(f10, f11, f12, f13));
    }

    public static Bitmap q(@n0 com.bumptech.glide.load.engine.bitmap_recycle.e eVar, @n0 Bitmap bitmap, int i10) {
        v4.m.a(i10 > 0, "roundingRadius must be greater than 0.");
        return s(eVar, bitmap, new a(i10));
    }

    @Deprecated
    public static Bitmap r(@n0 com.bumptech.glide.load.engine.bitmap_recycle.e eVar, @n0 Bitmap bitmap, int i10, int i11, int i12) {
        return q(eVar, bitmap, i12);
    }

    public static Bitmap s(@n0 com.bumptech.glide.load.engine.bitmap_recycle.e eVar, @n0 Bitmap bitmap, c cVar) {
        Bitmap.Config configH = h(bitmap);
        Bitmap bitmapG = g(eVar, bitmap);
        Bitmap bitmapF = eVar.f(bitmapG.getWidth(), bitmapG.getHeight(), configH);
        bitmapF.setHasAlpha(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmapG, tileMode, tileMode);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(bitmapShader);
        RectF rectF = new RectF(0.0f, 0.0f, bitmapF.getWidth(), bitmapF.getHeight());
        Lock lock = f12582h;
        lock.lock();
        try {
            Canvas canvas = new Canvas(bitmapF);
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            cVar.a(canvas, paint, rectF);
            e(canvas);
            lock.unlock();
            if (!bitmapG.equals(bitmap)) {
                eVar.e(bitmapG);
            }
            return bitmapF;
        } catch (Throwable th2) {
            f12582h.unlock();
            throw th2;
        }
    }

    public static void t(Bitmap bitmap, Bitmap bitmap2) {
        bitmap2.setHasAlpha(bitmap.hasAlpha());
    }
}
