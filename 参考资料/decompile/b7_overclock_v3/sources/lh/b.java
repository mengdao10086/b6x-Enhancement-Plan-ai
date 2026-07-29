package lh;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.AsyncTask;
import g.n0;
import g.p0;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.util.Objects;
import okhttp3.a0;
import okhttp3.b0;
import okhttp3.d0;
import okio.f0;
import okio.l;
import okio.r0;

/* JADX INFO: loaded from: classes5.dex */
public class b extends AsyncTask<Void, Void, a> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f39790g = "BitmapWorkerTask";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f39791h = 104857600;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<Context> f39792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Uri f39793b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Uri f39794c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f39795d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f39796e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final jh.b f39797f;

    public b(@n0 Context context, @n0 Uri uri, @p0 Uri uri2, int i10, int i11, jh.b bVar) {
        this.f39792a = new WeakReference<>(context);
        this.f39793b = uri;
        this.f39794c = uri2;
        this.f39795d = i10;
        this.f39796e = i11;
        this.f39797f = bVar;
    }

    public final boolean a(Bitmap bitmap, BitmapFactory.Options options) {
        if ((bitmap != null ? bitmap.getByteCount() : 0) <= 104857600) {
            return false;
        }
        options.inSampleSize *= 2;
        return true;
    }

    @Override // android.os.AsyncTask
    @n0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public a doInBackground(Void... voidArr) {
        InputStream inputStreamOpenInputStream;
        Context context = this.f39792a.get();
        if (context == null) {
            return new a(new NullPointerException("context is null"));
        }
        if (this.f39793b == null) {
            return new a(new NullPointerException("Input Uri cannot be null"));
        }
        try {
            e();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            options.inSampleSize = mh.a.a(options, this.f39795d, this.f39796e);
            boolean z10 = false;
            options.inJustDecodeBounds = false;
            Bitmap bitmapDecodeStream = null;
            while (!z10) {
                try {
                    inputStreamOpenInputStream = context.getContentResolver().openInputStream(this.f39793b);
                    try {
                        bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options);
                    } finally {
                        mh.a.c(inputStreamOpenInputStream);
                    }
                } catch (IOException e10) {
                    return new a(new IllegalArgumentException("Bitmap could not be decoded from the Uri: [" + this.f39793b + "]", e10));
                } catch (OutOfMemoryError unused) {
                    options.inSampleSize *= 2;
                }
                if (options.outWidth == -1 || options.outHeight == -1) {
                    return new a(new IllegalArgumentException("Bounds for bitmap could not be retrieved from the Uri: [" + this.f39793b + "]"));
                }
                mh.a.c(inputStreamOpenInputStream);
                if (!a(bitmapDecodeStream, options)) {
                    z10 = true;
                }
            }
            if (bitmapDecodeStream == null) {
                return new a(new IllegalArgumentException("Bitmap could not be decoded from the Uri: [" + this.f39793b + "]"));
            }
            int iG = mh.a.g(context, this.f39793b);
            int iE = mh.a.e(iG);
            int iF = mh.a.f(iG);
            kh.b bVar = new kh.b(iG, iE, iF);
            Matrix matrix = new Matrix();
            if (iE != 0) {
                matrix.preRotate(iE);
            }
            if (iF != 1) {
                matrix.postScale(iF, 1.0f);
            }
            return !matrix.isIdentity() ? new a(mh.a.i(bitmapDecodeStream, matrix), bVar) : new a(bitmapDecodeStream, bVar);
        } catch (IOException | NullPointerException e11) {
            return new a(e11);
        }
    }

    public final void c(@n0 Uri uri, @p0 Uri uri2) throws Throwable {
        Closeable closeable;
        d0 d0Var;
        d0 d0VarX;
        l lVarSource;
        Objects.requireNonNull(uri2, "Output Uri is null - cannot download image");
        Context context = this.f39792a.get();
        Objects.requireNonNull(context, "Context is null");
        a0 a0VarA = ih.b.f32379b.a();
        l lVar = null;
        try {
            d0VarX = a0VarA.a(new b0.a().B(uri.toString()).b()).X();
            try {
                lVarSource = d0VarX.L().source();
            } catch (Throwable th2) {
                th = th2;
                d0Var = d0VarX;
                closeable = null;
            }
        } catch (Throwable th3) {
            th = th3;
            closeable = null;
            d0Var = null;
        }
        try {
            OutputStream outputStreamOpenOutputStream = context.getContentResolver().openOutputStream(uri2);
            if (outputStreamOpenOutputStream == null) {
                throw new NullPointerException("OutputStream for given output Uri is null");
            }
            r0 r0VarP = f0.p(outputStreamOpenOutputStream);
            lVarSource.J1(r0VarP);
            mh.a.c(lVarSource);
            mh.a.c(r0VarP);
            mh.a.c(d0VarX.L());
            a0VarA.Q().b();
            this.f39793b = this.f39794c;
        } catch (Throwable th4) {
            th = th4;
            d0Var = d0VarX;
            closeable = null;
            lVar = lVarSource;
            mh.a.c(lVar);
            mh.a.c(closeable);
            if (d0Var != null) {
                mh.a.c(d0Var.L());
            }
            a0VarA.Q().b();
            this.f39793b = this.f39794c;
            throw th;
        }
    }

    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(@n0 a aVar) {
        Exception exc = aVar.f39800c;
        if (exc == null) {
            this.f39797f.a(aVar.f39798a, aVar.f39799b, this.f39793b, this.f39794c);
        } else {
            this.f39797f.b(exc);
        }
    }

    public final void e() throws IOException, NullPointerException {
        String scheme = this.f39793b.getScheme();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Uri scheme: ");
        sb2.append(scheme);
        if ("http".equals(scheme) || "https".equals(scheme)) {
            try {
                c(this.f39793b, this.f39794c);
            } catch (IOException | NullPointerException e10) {
                throw e10;
            }
        } else {
            if (m7.a.f40702b.equals(scheme) || "content".equals(scheme)) {
                return;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Invalid Uri scheme ");
            sb3.append(scheme);
            throw new IllegalArgumentException("Invalid Uri scheme" + scheme);
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Bitmap f39798a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public kh.b f39799b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Exception f39800c;

        public a(@n0 Bitmap bitmap, @n0 kh.b bVar) {
            this.f39798a = bitmap;
            this.f39799b = bVar;
        }

        public a(@n0 Exception exc) {
            this.f39800c = exc;
        }
    }
}
