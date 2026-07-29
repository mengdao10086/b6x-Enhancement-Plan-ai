package x1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentInfo;
import android.print.PrintManager;
import android.print.pdf.PrintedPdfDocument;
import g.n0;
import g.p0;
import g.v0;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f54838g = "PrintHelper";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f54839h = 3500;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final boolean f54840i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final boolean f54841j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f54842k = 1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f54843l = 2;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @SuppressLint({"InlinedApi"})
    public static final int f54844m = 1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @SuppressLint({"InlinedApi"})
    public static final int f54845n = 2;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f54846o = 1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f54847p = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f54848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BitmapFactory.Options f54849b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f54850c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f54851d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f54852e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f54853f = 1;

    /* JADX INFO: renamed from: x1.a$a, reason: collision with other inner class name */
    public class AsyncTaskC0644a extends AsyncTask<Void, Void, Throwable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CancellationSignal f54854a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PrintAttributes f54855b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Bitmap f54856c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ PrintAttributes f54857d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f54858e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ ParcelFileDescriptor f54859f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ PrintDocumentAdapter.WriteResultCallback f54860g;

        public AsyncTaskC0644a(CancellationSignal cancellationSignal, PrintAttributes printAttributes, Bitmap bitmap, PrintAttributes printAttributes2, int i10, ParcelFileDescriptor parcelFileDescriptor, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
            this.f54854a = cancellationSignal;
            this.f54855b = printAttributes;
            this.f54856c = bitmap;
            this.f54857d = printAttributes2;
            this.f54858e = i10;
            this.f54859f = parcelFileDescriptor;
            this.f54860g = writeResultCallback;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Throwable doInBackground(Void... voidArr) {
            RectF rectF;
            try {
                if (this.f54854a.isCanceled()) {
                    return null;
                }
                PrintedPdfDocument printedPdfDocument = new PrintedPdfDocument(a.this.f54848a, this.f54855b);
                Bitmap bitmapA = a.a(this.f54856c, this.f54855b.getColorMode());
                if (this.f54854a.isCanceled()) {
                    return null;
                }
                try {
                    PdfDocument.Page pageStartPage = printedPdfDocument.startPage(1);
                    boolean z10 = a.f54841j;
                    if (z10) {
                        rectF = new RectF(pageStartPage.getInfo().getContentRect());
                    } else {
                        PrintedPdfDocument printedPdfDocument2 = new PrintedPdfDocument(a.this.f54848a, this.f54857d);
                        PdfDocument.Page pageStartPage2 = printedPdfDocument2.startPage(1);
                        RectF rectF2 = new RectF(pageStartPage2.getInfo().getContentRect());
                        printedPdfDocument2.finishPage(pageStartPage2);
                        printedPdfDocument2.close();
                        rectF = rectF2;
                    }
                    Matrix matrixD = a.d(bitmapA.getWidth(), bitmapA.getHeight(), rectF, this.f54858e);
                    if (!z10) {
                        matrixD.postTranslate(rectF.left, rectF.top);
                        pageStartPage.getCanvas().clipRect(rectF);
                    }
                    pageStartPage.getCanvas().drawBitmap(bitmapA, matrixD, null);
                    printedPdfDocument.finishPage(pageStartPage);
                    if (this.f54854a.isCanceled()) {
                        printedPdfDocument.close();
                        ParcelFileDescriptor parcelFileDescriptor = this.f54859f;
                        if (parcelFileDescriptor != null) {
                            try {
                                parcelFileDescriptor.close();
                            } catch (IOException unused) {
                            }
                        }
                        if (bitmapA != this.f54856c) {
                            bitmapA.recycle();
                        }
                        return null;
                    }
                    printedPdfDocument.writeTo(new FileOutputStream(this.f54859f.getFileDescriptor()));
                    printedPdfDocument.close();
                    ParcelFileDescriptor parcelFileDescriptor2 = this.f54859f;
                    if (parcelFileDescriptor2 != null) {
                        try {
                            parcelFileDescriptor2.close();
                        } catch (IOException unused2) {
                        }
                    }
                    if (bitmapA != this.f54856c) {
                        bitmapA.recycle();
                    }
                    return null;
                } finally {
                }
            } catch (Throwable th2) {
                return th2;
            }
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Throwable th2) {
            if (this.f54854a.isCanceled()) {
                this.f54860g.onWriteCancelled();
            } else if (th2 == null) {
                this.f54860g.onWriteFinished(new PageRange[]{PageRange.ALL_PAGES});
            } else {
                this.f54860g.onWriteFailed(null);
            }
        }
    }

    public interface b {
        void a();
    }

    @v0(19)
    public class c extends PrintDocumentAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f54862a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f54863b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Bitmap f54864c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final b f54865d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public PrintAttributes f54866e;

        public c(String str, int i10, Bitmap bitmap, b bVar) {
            this.f54862a = str;
            this.f54863b = i10;
            this.f54864c = bitmap;
            this.f54865d = bVar;
        }

        @Override // android.print.PrintDocumentAdapter
        public void onFinish() {
            b bVar = this.f54865d;
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // android.print.PrintDocumentAdapter
        public void onLayout(PrintAttributes printAttributes, PrintAttributes printAttributes2, CancellationSignal cancellationSignal, PrintDocumentAdapter.LayoutResultCallback layoutResultCallback, Bundle bundle) {
            this.f54866e = printAttributes2;
            layoutResultCallback.onLayoutFinished(new PrintDocumentInfo.Builder(this.f54862a).setContentType(1).setPageCount(1).build(), !printAttributes2.equals(printAttributes));
        }

        @Override // android.print.PrintDocumentAdapter
        public void onWrite(PageRange[] pageRangeArr, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
            a.this.r(this.f54866e, this.f54863b, this.f54864c, parcelFileDescriptor, cancellationSignal, writeResultCallback);
        }
    }

    @v0(19)
    public class d extends PrintDocumentAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f54868a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Uri f54869b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final b f54870c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f54871d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public PrintAttributes f54872e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public AsyncTask<Uri, Boolean, Bitmap> f54873f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Bitmap f54874g = null;

        /* JADX INFO: renamed from: x1.a$d$a, reason: collision with other inner class name */
        public class AsyncTaskC0645a extends AsyncTask<Uri, Boolean, Bitmap> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CancellationSignal f54876a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ PrintAttributes f54877b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ PrintAttributes f54878c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ PrintDocumentAdapter.LayoutResultCallback f54879d;

            /* JADX INFO: renamed from: x1.a$d$a$a, reason: collision with other inner class name */
            public class C0646a implements CancellationSignal.OnCancelListener {
                public C0646a() {
                }

                @Override // android.os.CancellationSignal.OnCancelListener
                public void onCancel() {
                    d.this.a();
                    AsyncTaskC0645a.this.cancel(false);
                }
            }

            public AsyncTaskC0645a(CancellationSignal cancellationSignal, PrintAttributes printAttributes, PrintAttributes printAttributes2, PrintDocumentAdapter.LayoutResultCallback layoutResultCallback) {
                this.f54876a = cancellationSignal;
                this.f54877b = printAttributes;
                this.f54878c = printAttributes2;
                this.f54879d = layoutResultCallback;
            }

            @Override // android.os.AsyncTask
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Bitmap doInBackground(Uri... uriArr) {
                try {
                    d dVar = d.this;
                    return a.this.i(dVar.f54869b);
                } catch (FileNotFoundException unused) {
                    return null;
                }
            }

            @Override // android.os.AsyncTask
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void onCancelled(Bitmap bitmap) {
                this.f54879d.onLayoutCancelled();
                d.this.f54873f = null;
            }

            @Override // android.os.AsyncTask
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(Bitmap bitmap) {
                PrintAttributes.MediaSize mediaSize;
                super.onPostExecute(bitmap);
                if (bitmap != null && (!a.f54840i || a.this.f54853f == 0)) {
                    synchronized (this) {
                        mediaSize = d.this.f54872e.getMediaSize();
                    }
                    if (mediaSize != null && mediaSize.isPortrait() != a.g(bitmap)) {
                        Matrix matrix = new Matrix();
                        matrix.postRotate(90.0f);
                        bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                    }
                }
                d.this.f54874g = bitmap;
                if (bitmap != null) {
                    this.f54879d.onLayoutFinished(new PrintDocumentInfo.Builder(d.this.f54868a).setContentType(1).setPageCount(1).build(), true ^ this.f54877b.equals(this.f54878c));
                } else {
                    this.f54879d.onLayoutFailed(null);
                }
                d.this.f54873f = null;
            }

            @Override // android.os.AsyncTask
            public void onPreExecute() {
                this.f54876a.setOnCancelListener(new C0646a());
            }
        }

        public d(String str, Uri uri, b bVar, int i10) {
            this.f54868a = str;
            this.f54869b = uri;
            this.f54870c = bVar;
            this.f54871d = i10;
        }

        public void a() {
            synchronized (a.this.f54850c) {
                BitmapFactory.Options options = a.this.f54849b;
                if (options != null) {
                    if (Build.VERSION.SDK_INT < 24) {
                        options.requestCancelDecode();
                    }
                    a.this.f54849b = null;
                }
            }
        }

        @Override // android.print.PrintDocumentAdapter
        public void onFinish() {
            super.onFinish();
            a();
            AsyncTask<Uri, Boolean, Bitmap> asyncTask = this.f54873f;
            if (asyncTask != null) {
                asyncTask.cancel(true);
            }
            b bVar = this.f54870c;
            if (bVar != null) {
                bVar.a();
            }
            Bitmap bitmap = this.f54874g;
            if (bitmap != null) {
                bitmap.recycle();
                this.f54874g = null;
            }
        }

        @Override // android.print.PrintDocumentAdapter
        public void onLayout(PrintAttributes printAttributes, PrintAttributes printAttributes2, CancellationSignal cancellationSignal, PrintDocumentAdapter.LayoutResultCallback layoutResultCallback, Bundle bundle) {
            synchronized (this) {
                this.f54872e = printAttributes2;
            }
            if (cancellationSignal.isCanceled()) {
                layoutResultCallback.onLayoutCancelled();
            } else if (this.f54874g != null) {
                layoutResultCallback.onLayoutFinished(new PrintDocumentInfo.Builder(this.f54868a).setContentType(1).setPageCount(1).build(), !printAttributes2.equals(printAttributes));
            } else {
                this.f54873f = new AsyncTaskC0645a(cancellationSignal, printAttributes2, printAttributes, layoutResultCallback).execute(new Uri[0]);
            }
        }

        @Override // android.print.PrintDocumentAdapter
        public void onWrite(PageRange[] pageRangeArr, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
            a.this.r(this.f54872e, this.f54871d, this.f54874g, parcelFileDescriptor, cancellationSignal, writeResultCallback);
        }
    }

    static {
        int i10 = Build.VERSION.SDK_INT;
        f54840i = i10 > 23;
        f54841j = i10 != 23;
    }

    public a(@n0 Context context) {
        this.f54848a = context;
    }

    public static Bitmap a(Bitmap bitmap, int i10) {
        if (i10 != 1) {
            return bitmap;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.0f);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        canvas.setBitmap(null);
        return bitmapCreateBitmap;
    }

    @v0(19)
    public static PrintAttributes.Builder b(PrintAttributes printAttributes) {
        PrintAttributes.Builder minMargins = new PrintAttributes.Builder().setMediaSize(printAttributes.getMediaSize()).setResolution(printAttributes.getResolution()).setMinMargins(printAttributes.getMinMargins());
        if (printAttributes.getColorMode() != 0) {
            minMargins.setColorMode(printAttributes.getColorMode());
        }
        if (Build.VERSION.SDK_INT >= 23 && printAttributes.getDuplexMode() != 0) {
            minMargins.setDuplexMode(printAttributes.getDuplexMode());
        }
        return minMargins;
    }

    public static Matrix d(int i10, int i11, RectF rectF, int i12) {
        Matrix matrix = new Matrix();
        float f10 = i10;
        float fWidth = rectF.width() / f10;
        float fMax = i12 == 2 ? Math.max(fWidth, rectF.height() / i11) : Math.min(fWidth, rectF.height() / i11);
        matrix.postScale(fMax, fMax);
        matrix.postTranslate((rectF.width() - (f10 * fMax)) / 2.0f, (rectF.height() - (i11 * fMax)) / 2.0f);
        return matrix;
    }

    public static boolean g(Bitmap bitmap) {
        return bitmap.getWidth() <= bitmap.getHeight();
    }

    public static boolean q() {
        return true;
    }

    public int c() {
        return this.f54852e;
    }

    public int e() {
        int i10 = this.f54853f;
        if (i10 == 0) {
            return 1;
        }
        return i10;
    }

    public int f() {
        return this.f54851d;
    }

    public final Bitmap h(Uri uri, BitmapFactory.Options options) throws Throwable {
        Context context;
        if (uri == null || (context = this.f54848a) == null) {
            throw new IllegalArgumentException("bad argument to loadBitmap");
        }
        InputStream inputStream = null;
        try {
            InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
            try {
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options);
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (IOException unused) {
                    }
                }
                return bitmapDecodeStream;
            } catch (Throwable th2) {
                th = th2;
                inputStream = inputStreamOpenInputStream;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public Bitmap i(Uri uri) throws Throwable {
        BitmapFactory.Options options;
        if (uri == null || this.f54848a == null) {
            throw new IllegalArgumentException("bad argument to getScaledBitmap");
        }
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        options2.inJustDecodeBounds = true;
        h(uri, options2);
        int i10 = options2.outWidth;
        int i11 = options2.outHeight;
        if (i10 > 0 && i11 > 0) {
            int iMax = Math.max(i10, i11);
            int i12 = 1;
            while (iMax > 3500) {
                iMax >>>= 1;
                i12 <<= 1;
            }
            if (i12 > 0 && Math.min(i10, i11) / i12 > 0) {
                synchronized (this.f54850c) {
                    options = new BitmapFactory.Options();
                    this.f54849b = options;
                    options.inMutable = true;
                    options.inSampleSize = i12;
                }
                try {
                    Bitmap bitmapH = h(uri, options);
                    synchronized (this.f54850c) {
                        this.f54849b = null;
                    }
                    return bitmapH;
                } catch (Throwable th2) {
                    synchronized (this.f54850c) {
                        this.f54849b = null;
                        throw th2;
                    }
                }
            }
        }
        return null;
    }

    public void j(@n0 String str, @n0 Bitmap bitmap) {
        k(str, bitmap, null);
    }

    public void k(@n0 String str, @n0 Bitmap bitmap, @p0 b bVar) {
        if (bitmap == null) {
            return;
        }
        ((PrintManager) this.f54848a.getSystemService("print")).print(str, new c(str, this.f54851d, bitmap, bVar), new PrintAttributes.Builder().setMediaSize(g(bitmap) ? PrintAttributes.MediaSize.UNKNOWN_PORTRAIT : PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE).setColorMode(this.f54852e).build());
    }

    public void l(@n0 String str, @n0 Uri uri) throws FileNotFoundException {
        m(str, uri, null);
    }

    public void m(@n0 String str, @n0 Uri uri, @p0 b bVar) throws FileNotFoundException {
        d dVar = new d(str, uri, bVar, this.f54851d);
        PrintManager printManager = (PrintManager) this.f54848a.getSystemService("print");
        PrintAttributes.Builder builder = new PrintAttributes.Builder();
        builder.setColorMode(this.f54852e);
        int i10 = this.f54853f;
        if (i10 == 1 || i10 == 0) {
            builder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_LANDSCAPE);
        } else if (i10 == 2) {
            builder.setMediaSize(PrintAttributes.MediaSize.UNKNOWN_PORTRAIT);
        }
        printManager.print(str, dVar, builder.build());
    }

    public void n(int i10) {
        this.f54852e = i10;
    }

    public void o(int i10) {
        this.f54853f = i10;
    }

    public void p(int i10) {
        this.f54851d = i10;
    }

    @v0(19)
    public void r(PrintAttributes printAttributes, int i10, Bitmap bitmap, ParcelFileDescriptor parcelFileDescriptor, CancellationSignal cancellationSignal, PrintDocumentAdapter.WriteResultCallback writeResultCallback) {
        new AsyncTaskC0644a(cancellationSignal, f54841j ? printAttributes : b(printAttributes).setMinMargins(new PrintAttributes.Margins(0, 0, 0, 0)).build(), bitmap, printAttributes, i10, parcelFileDescriptor, writeResultCallback).execute(new Void[0]);
    }
}
