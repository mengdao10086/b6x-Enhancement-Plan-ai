package lh;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import g.n0;
import g.p0;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import kh.c;
import mh.e;
import mh.f;

/* JADX INFO: loaded from: classes5.dex */
public class a extends AsyncTask<Void, Void, Throwable> {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f39768u = "BitmapCropTask";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f39769v = "content";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<Context> f39770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Bitmap f39771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RectF f39772c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RectF f39773d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f39774e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f39775f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f39776g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f39777h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Bitmap.CompressFormat f39778i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f39779j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f39780k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f39781l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Uri f39782m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Uri f39783n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final kh.b f39784o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final jh.a f39785p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f39786q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f39787r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f39788s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f39789t;

    public a(@n0 Context context, @p0 Bitmap bitmap, @n0 c cVar, @n0 kh.a aVar, @p0 jh.a aVar2) {
        this.f39770a = new WeakReference<>(context);
        this.f39771b = bitmap;
        this.f39772c = cVar.a();
        this.f39773d = cVar.c();
        this.f39774e = cVar.d();
        this.f39775f = cVar.b();
        this.f39776g = aVar.h();
        this.f39777h = aVar.i();
        this.f39778i = aVar.a();
        this.f39779j = aVar.b();
        this.f39780k = aVar.f();
        this.f39781l = aVar.g();
        this.f39782m = aVar.c();
        this.f39783n = aVar.d();
        this.f39784o = aVar.e();
        this.f39785p = aVar2;
    }

    public final void a(Context context) throws Throwable {
        boolean zH = mh.a.h(this.f39782m);
        boolean zH2 = mh.a.h(this.f39783n);
        if (zH && zH2) {
            f.b(context, this.f39786q, this.f39787r, this.f39782m, this.f39783n);
            return;
        }
        if (zH) {
            f.c(context, this.f39786q, this.f39787r, this.f39782m, this.f39781l);
        } else if (zH2) {
            f.d(context, new i1.a(this.f39780k), this.f39786q, this.f39787r, this.f39783n);
        } else {
            f.e(new i1.a(this.f39780k), this.f39786q, this.f39787r, this.f39781l);
        }
    }

    public final boolean b() throws Throwable {
        Context context = this.f39770a.get();
        if (context == null) {
            return false;
        }
        if (this.f39776g > 0 && this.f39777h > 0) {
            float fWidth = this.f39772c.width() / this.f39774e;
            float fHeight = this.f39772c.height() / this.f39774e;
            int i10 = this.f39776g;
            if (fWidth > i10 || fHeight > this.f39777h) {
                float fMin = Math.min(i10 / fWidth, this.f39777h / fHeight);
                Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(this.f39771b, Math.round(r3.getWidth() * fMin), Math.round(this.f39771b.getHeight() * fMin), false);
                Bitmap bitmap = this.f39771b;
                if (bitmap != bitmapCreateScaledBitmap) {
                    bitmap.recycle();
                }
                this.f39771b = bitmapCreateScaledBitmap;
                this.f39774e /= fMin;
            }
        }
        if (this.f39775f != 0.0f) {
            Matrix matrix = new Matrix();
            matrix.setRotate(this.f39775f, this.f39771b.getWidth() / 2, this.f39771b.getHeight() / 2);
            Bitmap bitmap2 = this.f39771b;
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap2, 0, 0, bitmap2.getWidth(), this.f39771b.getHeight(), matrix, true);
            Bitmap bitmap3 = this.f39771b;
            if (bitmap3 != bitmapCreateBitmap) {
                bitmap3.recycle();
            }
            this.f39771b = bitmapCreateBitmap;
        }
        this.f39788s = Math.round((this.f39772c.left - this.f39773d.left) / this.f39774e);
        this.f39789t = Math.round((this.f39772c.top - this.f39773d.top) / this.f39774e);
        this.f39786q = Math.round(this.f39772c.width() / this.f39774e);
        int iRound = Math.round(this.f39772c.height() / this.f39774e);
        this.f39787r = iRound;
        boolean zF = f(this.f39786q, iRound);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Should crop: ");
        sb2.append(zF);
        if (!zF) {
            e.a(context, this.f39782m, this.f39783n);
            return false;
        }
        e(Bitmap.createBitmap(this.f39771b, this.f39788s, this.f39789t, this.f39786q, this.f39787r));
        if (!this.f39778i.equals(Bitmap.CompressFormat.JPEG)) {
            return true;
        }
        a(context);
        return true;
    }

    @Override // android.os.AsyncTask
    @p0
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Throwable doInBackground(Void... voidArr) {
        Bitmap bitmap = this.f39771b;
        if (bitmap == null) {
            return new NullPointerException("ViewBitmap is null");
        }
        if (bitmap.isRecycled()) {
            return new NullPointerException("ViewBitmap is recycled");
        }
        if (this.f39773d.isEmpty()) {
            return new NullPointerException("CurrentImageRect is empty");
        }
        if (this.f39783n == null) {
            return new NullPointerException("ImageOutputUri is null");
        }
        try {
            b();
            this.f39771b = null;
            return null;
        } catch (Throwable th2) {
            return th2;
        }
    }

    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(@p0 Throwable th2) {
        jh.a aVar = this.f39785p;
        if (aVar != null) {
            if (th2 != null) {
                aVar.b(th2);
            } else {
                this.f39785p.a(mh.a.h(this.f39783n) ? this.f39783n : Uri.fromFile(new File(this.f39781l)), this.f39788s, this.f39789t, this.f39786q, this.f39787r);
            }
        }
    }

    public final void e(@n0 Bitmap bitmap) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        Context context = this.f39770a.get();
        if (context == null) {
            return;
        }
        OutputStream outputStream = null;
        try {
            OutputStream outputStreamOpenOutputStream = context.getContentResolver().openOutputStream(this.f39783n);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    bitmap.compress(this.f39778i, this.f39779j, byteArrayOutputStream);
                    outputStreamOpenOutputStream.write(byteArrayOutputStream.toByteArray());
                    bitmap.recycle();
                    mh.a.c(outputStreamOpenOutputStream);
                } catch (IOException e10) {
                    e = e10;
                    outputStream = outputStreamOpenOutputStream;
                    try {
                        e.getLocalizedMessage();
                        mh.a.c(outputStream);
                    } catch (Throwable th2) {
                        th = th2;
                        mh.a.c(outputStream);
                        mh.a.c(byteArrayOutputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    outputStream = outputStreamOpenOutputStream;
                    mh.a.c(outputStream);
                    mh.a.c(byteArrayOutputStream);
                    throw th;
                }
            } catch (IOException e11) {
                e = e11;
                byteArrayOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                byteArrayOutputStream = null;
            }
        } catch (IOException e12) {
            e = e12;
            byteArrayOutputStream = null;
        } catch (Throwable th5) {
            th = th5;
            byteArrayOutputStream = null;
        }
        mh.a.c(byteArrayOutputStream);
    }

    public final boolean f(int i10, int i11) {
        int iRound = Math.round(Math.max(i10, i11) / 1000.0f) + 1;
        if (this.f39776g > 0 && this.f39777h > 0) {
            return true;
        }
        float f10 = iRound;
        return Math.abs(this.f39772c.left - this.f39773d.left) > f10 || Math.abs(this.f39772c.top - this.f39773d.top) > f10 || Math.abs(this.f39772c.bottom - this.f39773d.bottom) > f10 || Math.abs(this.f39772c.right - this.f39773d.right) > f10 || this.f39775f != 0.0f;
    }
}
