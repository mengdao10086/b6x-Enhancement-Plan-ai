package nh;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import g.f0;
import g.n0;
import g.p0;
import mh.d;
import mh.g;

/* JADX INFO: loaded from: classes5.dex */
public class b extends AppCompatImageView {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f42175u = "TransformImageView";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f42176v = 8;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f42177w = 2;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f42178x = 9;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float[] f42179d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float[] f42180e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float[] f42181f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Matrix f42182g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f42183h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f42184i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public InterfaceC0475b f42185j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float[] f42186k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float[] f42187l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f42188m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f42189n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f42190o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f42191p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f42192q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Uri f42193r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Uri f42194s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public kh.b f42195t;

    public class a implements jh.b {
        public a() {
        }

        @Override // jh.b
        public void a(@n0 Bitmap bitmap, @n0 kh.b bVar, @n0 Uri uri, @p0 Uri uri2) {
            b.this.f42193r = uri;
            b.this.f42194s = uri2;
            b.this.f42191p = uri.getPath();
            b.this.f42192q = uri2 != null ? uri2.getPath() : null;
            b.this.f42195t = bVar;
            b bVar2 = b.this;
            bVar2.f42188m = true;
            bVar2.setImageBitmap(bitmap);
        }

        @Override // jh.b
        public void b(@n0 Exception exc) {
            InterfaceC0475b interfaceC0475b = b.this.f42185j;
            if (interfaceC0475b != null) {
                interfaceC0475b.c(exc);
            }
        }
    }

    /* JADX INFO: renamed from: nh.b$b, reason: collision with other inner class name */
    public interface InterfaceC0475b {
        void a(float f10);

        void b();

        void c(@n0 Exception exc);

        void d(float f10);
    }

    public b(Context context) {
        this(context, null);
    }

    public float getCurrentAngle() {
        return h(this.f42182g);
    }

    public float getCurrentScale() {
        return i(this.f42182g);
    }

    public kh.b getExifInfo() {
        return this.f42195t;
    }

    public String getImageInputPath() {
        return this.f42191p;
    }

    public Uri getImageInputUri() {
        return this.f42193r;
    }

    public String getImageOutputPath() {
        return this.f42192q;
    }

    public Uri getImageOutputUri() {
        return this.f42194s;
    }

    public int getMaxBitmapSize() {
        if (this.f42190o <= 0) {
            this.f42190o = mh.a.b(getContext());
        }
        return this.f42190o;
    }

    @p0
    public Bitmap getViewBitmap() {
        if (getDrawable() == null || !(getDrawable() instanceof d)) {
            return null;
        }
        return ((d) getDrawable()).a();
    }

    public float h(@n0 Matrix matrix) {
        return (float) (-(Math.atan2(j(matrix, 1), j(matrix, 0)) * 57.29577951308232d));
    }

    public float i(@n0 Matrix matrix) {
        return (float) Math.sqrt(Math.pow(j(matrix, 0), 2.0d) + Math.pow(j(matrix, 3), 2.0d));
    }

    public float j(@n0 Matrix matrix, @f0(from = 0, to = 9) int i10) {
        matrix.getValues(this.f42181f);
        return this.f42181f[i10];
    }

    public void k() {
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    public void l() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        float intrinsicWidth = drawable.getIntrinsicWidth();
        float intrinsicHeight = drawable.getIntrinsicHeight();
        String.format("Image size: [%d:%d]", Integer.valueOf((int) intrinsicWidth), Integer.valueOf((int) intrinsicHeight));
        RectF rectF = new RectF(0.0f, 0.0f, intrinsicWidth, intrinsicHeight);
        this.f42186k = g.b(rectF);
        this.f42187l = g.a(rectF);
        this.f42189n = true;
        InterfaceC0475b interfaceC0475b = this.f42185j;
        if (interfaceC0475b != null) {
            interfaceC0475b.b();
        }
    }

    public void m(float f10, float f11, float f12) {
        if (f10 != 0.0f) {
            this.f42182g.postRotate(f10, f11, f12);
            setImageMatrix(this.f42182g);
            InterfaceC0475b interfaceC0475b = this.f42185j;
            if (interfaceC0475b != null) {
                interfaceC0475b.a(h(this.f42182g));
            }
        }
    }

    public void n(float f10, float f11, float f12) {
        if (f10 != 0.0f) {
            this.f42182g.postScale(f10, f10, f11, f12);
            setImageMatrix(this.f42182g);
            InterfaceC0475b interfaceC0475b = this.f42185j;
            if (interfaceC0475b != null) {
                interfaceC0475b.d(i(this.f42182g));
            }
        }
    }

    public void o(float f10, float f11) {
        if (f10 == 0.0f && f11 == 0.0f) {
            return;
        }
        this.f42182g.postTranslate(f10, f11);
        setImageMatrix(this.f42182g);
    }

    @Override // android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (z10 || (this.f42188m && !this.f42189n)) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            this.f42183h = width - paddingLeft;
            this.f42184i = height - paddingTop;
            l();
        }
    }

    public void p(@n0 String str, @n0 Matrix matrix) {
        float fJ = j(matrix, 2);
        float fJ2 = j(matrix, 5);
        float fI = i(matrix);
        float fH = h(matrix);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(": matrix: { x: ");
        sb2.append(fJ);
        sb2.append(", y: ");
        sb2.append(fJ2);
        sb2.append(", scale: ");
        sb2.append(fI);
        sb2.append(", angle: ");
        sb2.append(fH);
        sb2.append(" }");
    }

    public void q(@n0 Uri uri, @p0 Uri uri2) throws Exception {
        int maxBitmapSize = getMaxBitmapSize();
        mh.a.d(getContext(), uri, uri2, maxBitmapSize, maxBitmapSize, new a());
    }

    public final void r() {
        this.f42182g.mapPoints(this.f42179d, this.f42186k);
        this.f42182g.mapPoints(this.f42180e, this.f42187l);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        setImageDrawable(new d(bitmap));
    }

    @Override // android.widget.ImageView
    public void setImageMatrix(Matrix matrix) {
        super.setImageMatrix(matrix);
        this.f42182g.set(matrix);
        r();
    }

    public void setMaxBitmapSize(int i10) {
        this.f42190o = i10;
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == ImageView.ScaleType.MATRIX) {
            super.setScaleType(scaleType);
        }
    }

    public void setTransformImageListener(InterfaceC0475b interfaceC0475b) {
        this.f42185j = interfaceC0475b;
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f42179d = new float[8];
        this.f42180e = new float[2];
        this.f42181f = new float[9];
        this.f42182g = new Matrix();
        this.f42188m = false;
        this.f42189n = false;
        this.f42190o = 0;
        k();
    }
}
