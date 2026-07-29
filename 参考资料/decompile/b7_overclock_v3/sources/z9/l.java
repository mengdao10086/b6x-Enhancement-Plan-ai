package z9;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.OverScroller;

/* JADX INFO: loaded from: classes3.dex */
public class l implements View.OnTouchListener, View.OnLayoutChangeListener {
    public static int C1 = 200;
    public static final int C2 = 1;
    public static final int E7 = -1;
    public static final int F7 = 0;
    public static final int G7 = 1;
    public static final int H7 = 2;
    public static int I7 = 1;
    public static float K0 = 3.0f;
    public static final int K1 = -1;
    public static final int K2 = 2;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public static float f57971k1 = 1.75f;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public static float f57972v1 = 1.0f;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public static final int f57973v2 = 0;
    public float B;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ImageView f57981h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public GestureDetector f57982i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public z9.c f57983j;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public z9.e f57990p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public g f57991q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public z9.f f57992r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public k f57993s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public View.OnClickListener f57994t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public View.OnLongClickListener f57995u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public h f57996v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public i f57997w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public j f57998x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public f f57999y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Interpolator f57974a = new AccelerateDecelerateInterpolator();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f57975b = C1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f57976c = f57972v1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f57977d = f57971k1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f57978e = K0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f57979f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f57980g = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Matrix f57984k = new Matrix();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Matrix f57986l = new Matrix();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Matrix f57987m = new Matrix();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final RectF f57988n = new RectF();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final float[] f57989o = new float[9];

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f58000z = 2;
    public int A = 2;
    public boolean C = true;
    public ImageView.ScaleType D = ImageView.ScaleType.FIT_CENTER;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public z9.d f57985k0 = new a();

    public class a implements z9.d {
        public a() {
        }

        @Override // z9.d
        public void a(float f10, float f11) {
            if (l.this.f57983j.e()) {
                return;
            }
            if (l.this.f57998x != null) {
                l.this.f57998x.a(f10, f11);
            }
            l.this.f57987m.postTranslate(f10, f11);
            l.this.B();
            ViewParent parent = l.this.f57981h.getParent();
            if (!l.this.f57979f || l.this.f57983j.e() || l.this.f57980g) {
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            } else if ((l.this.f58000z == 2 || ((l.this.f58000z == 0 && f10 >= 1.0f) || ((l.this.f58000z == 1 && f10 <= -1.0f) || ((l.this.A == 0 && f11 >= 1.0f) || (l.this.A == 1 && f11 <= -1.0f))))) && parent != null) {
                parent.requestDisallowInterceptTouchEvent(false);
            }
        }

        @Override // z9.d
        public void b(float f10, float f11, float f12) {
            if (l.this.N() < l.this.f57978e || f10 < 1.0f) {
                if (l.this.f57996v != null) {
                    l.this.f57996v.a(f10, f11, f12);
                }
                l.this.f57987m.postScale(f10, f10, f11, f12);
                l.this.B();
            }
        }

        @Override // z9.d
        public void c(float f10, float f11, float f12, float f13) {
            l lVar = l.this;
            lVar.f57999y = lVar.new f(lVar.f57981h.getContext());
            f fVar = l.this.f57999y;
            l lVar2 = l.this;
            int iJ = lVar2.J(lVar2.f57981h);
            l lVar3 = l.this;
            fVar.b(iJ, lVar3.I(lVar3.f57981h), (int) f12, (int) f13);
            l.this.f57981h.post(l.this.f57999y);
        }
    }

    public class b extends GestureDetector.SimpleOnGestureListener {
        public b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
            if (l.this.f57997w == null || l.this.N() > l.f57972v1 || motionEvent.getPointerCount() > l.I7 || motionEvent2.getPointerCount() > l.I7) {
                return false;
            }
            return l.this.f57997w.onFling(motionEvent, motionEvent2, f10, f11);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (l.this.f57995u != null) {
                l.this.f57995u.onLongClick(l.this.f57981h);
            }
        }
    }

    public class c implements GestureDetector.OnDoubleTapListener {
        public c() {
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            try {
                float fN = l.this.N();
                float x10 = motionEvent.getX();
                float y10 = motionEvent.getY();
                if (fN < l.this.L()) {
                    l lVar = l.this;
                    lVar.o0(lVar.L(), x10, y10, true);
                } else if (fN < l.this.L() || fN >= l.this.K()) {
                    l lVar2 = l.this;
                    lVar2.o0(lVar2.M(), x10, y10, true);
                } else {
                    l lVar3 = l.this;
                    lVar3.o0(lVar3.K(), x10, y10, true);
                }
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
            return true;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (l.this.f57994t != null) {
                l.this.f57994t.onClick(l.this.f57981h);
            }
            RectF rectFE = l.this.E();
            float x10 = motionEvent.getX();
            float y10 = motionEvent.getY();
            if (l.this.f57993s != null) {
                l.this.f57993s.a(l.this.f57981h, x10, y10);
            }
            if (rectFE == null) {
                return false;
            }
            if (!rectFE.contains(x10, y10)) {
                if (l.this.f57992r == null) {
                    return false;
                }
                l.this.f57992r.a(l.this.f57981h);
                return false;
            }
            float fWidth = (x10 - rectFE.left) / rectFE.width();
            float fHeight = (y10 - rectFE.top) / rectFE.height();
            if (l.this.f57991q == null) {
                return true;
            }
            l.this.f57991q.a(l.this.f57981h, fWidth, fHeight);
            return true;
        }
    }

    public static /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f58004a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f58004a = iArr;
            try {
                iArr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f58004a[ImageView.ScaleType.FIT_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f58004a[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f58004a[ImageView.ScaleType.FIT_XY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f58005a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f58006b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f58007c = System.currentTimeMillis();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f58008d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f58009e;

        public e(float f10, float f11, float f12, float f13) {
            this.f58005a = f12;
            this.f58006b = f13;
            this.f58008d = f10;
            this.f58009e = f11;
        }

        public final float a() {
            return l.this.f57974a.getInterpolation(Math.min(1.0f, ((System.currentTimeMillis() - this.f58007c) * 1.0f) / l.this.f57975b));
        }

        @Override // java.lang.Runnable
        public void run() {
            float fA = a();
            float f10 = this.f58008d;
            l.this.f57985k0.b((f10 + ((this.f58009e - f10) * fA)) / l.this.N(), this.f58005a, this.f58006b);
            if (fA < 1.0f) {
                z9.b.a(l.this.f57981h, this);
            }
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final OverScroller f58011a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f58012b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f58013c;

        public f(Context context) {
            this.f58011a = new OverScroller(context);
        }

        public void a() {
            this.f58011a.forceFinished(true);
        }

        public void b(int i10, int i11, int i12, int i13) {
            int i14;
            int iRound;
            int i15;
            int iRound2;
            RectF rectFE = l.this.E();
            if (rectFE == null) {
                return;
            }
            int iRound3 = Math.round(-rectFE.left);
            float f10 = i10;
            if (f10 < rectFE.width()) {
                iRound = Math.round(rectFE.width() - f10);
                i14 = 0;
            } else {
                i14 = iRound3;
                iRound = i14;
            }
            int iRound4 = Math.round(-rectFE.top);
            float f11 = i11;
            if (f11 < rectFE.height()) {
                iRound2 = Math.round(rectFE.height() - f11);
                i15 = 0;
            } else {
                i15 = iRound4;
                iRound2 = i15;
            }
            this.f58012b = iRound3;
            this.f58013c = iRound4;
            if (iRound3 == iRound && iRound4 == iRound2) {
                return;
            }
            this.f58011a.fling(iRound3, iRound4, i12, i13, i14, iRound, i15, iRound2, 0, 0);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f58011a.isFinished() && this.f58011a.computeScrollOffset()) {
                int currX = this.f58011a.getCurrX();
                int currY = this.f58011a.getCurrY();
                l.this.f57987m.postTranslate(this.f58012b - currX, this.f58013c - currY);
                l.this.B();
                this.f58012b = currX;
                this.f58013c = currY;
                z9.b.a(l.this.f57981h, this);
            }
        }
    }

    public l(ImageView imageView) {
        this.f57981h = imageView;
        imageView.setOnTouchListener(this);
        imageView.addOnLayoutChangeListener(this);
        if (imageView.isInEditMode()) {
            return;
        }
        this.B = 0.0f;
        this.f57983j = new z9.c(imageView.getContext(), this.f57985k0);
        GestureDetector gestureDetector = new GestureDetector(imageView.getContext(), new b());
        this.f57982i = gestureDetector;
        gestureDetector.setOnDoubleTapListener(new c());
    }

    public final void A() {
        f fVar = this.f57999y;
        if (fVar != null) {
            fVar.a();
            this.f57999y = null;
        }
    }

    public final void B() {
        if (C()) {
            X(G());
        }
    }

    public final boolean C() {
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        RectF rectFF = F(G());
        if (rectFF == null) {
            return false;
        }
        float fHeight = rectFF.height();
        float fWidth = rectFF.width();
        float fI = I(this.f57981h);
        float f15 = 0.0f;
        if (fHeight <= fI) {
            int i10 = d.f58004a[this.D.ordinal()];
            if (i10 != 2) {
                if (i10 != 3) {
                    f13 = (fI - fHeight) / 2.0f;
                    f14 = rectFF.top;
                } else {
                    f13 = fI - fHeight;
                    f14 = rectFF.top;
                }
                f10 = f13 - f14;
            } else {
                f10 = -rectFF.top;
            }
            this.A = 2;
        } else {
            float f16 = rectFF.top;
            if (f16 > 0.0f) {
                this.A = 0;
                f10 = -f16;
            } else {
                float f17 = rectFF.bottom;
                if (f17 < fI) {
                    this.A = 1;
                    f10 = fI - f17;
                } else {
                    this.A = -1;
                    f10 = 0.0f;
                }
            }
        }
        float fJ = J(this.f57981h);
        if (fWidth <= fJ) {
            int i11 = d.f58004a[this.D.ordinal()];
            if (i11 != 2) {
                if (i11 != 3) {
                    f11 = (fJ - fWidth) / 2.0f;
                    f12 = rectFF.left;
                } else {
                    f11 = fJ - fWidth;
                    f12 = rectFF.left;
                }
                f15 = f11 - f12;
            } else {
                f15 = -rectFF.left;
            }
            this.f58000z = 2;
        } else {
            float f18 = rectFF.left;
            if (f18 > 0.0f) {
                this.f58000z = 0;
                f15 = -f18;
            } else {
                float f19 = rectFF.right;
                if (f19 < fJ) {
                    f15 = fJ - f19;
                    this.f58000z = 1;
                } else {
                    this.f58000z = -1;
                }
            }
        }
        this.f57987m.postTranslate(f15, f10);
        return true;
    }

    public void D(Matrix matrix) {
        matrix.set(G());
    }

    public RectF E() {
        C();
        return F(G());
    }

    public final RectF F(Matrix matrix) {
        if (this.f57981h.getDrawable() == null) {
            return null;
        }
        this.f57988n.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        matrix.mapRect(this.f57988n);
        return this.f57988n;
    }

    public final Matrix G() {
        this.f57986l.set(this.f57984k);
        this.f57986l.postConcat(this.f57987m);
        return this.f57986l;
    }

    public Matrix H() {
        return this.f57986l;
    }

    public final int I(ImageView imageView) {
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    public final int J(ImageView imageView) {
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    public float K() {
        return this.f57978e;
    }

    public float L() {
        return this.f57977d;
    }

    public float M() {
        return this.f57976c;
    }

    public float N() {
        return (float) Math.sqrt(((float) Math.pow(Q(this.f57987m, 0), 2.0d)) + ((float) Math.pow(Q(this.f57987m, 3), 2.0d)));
    }

    public ImageView.ScaleType O() {
        return this.D;
    }

    public void P(Matrix matrix) {
        matrix.set(this.f57987m);
    }

    public final float Q(Matrix matrix, int i10) {
        matrix.getValues(this.f57989o);
        return this.f57989o[i10];
    }

    @Deprecated
    public boolean R() {
        return this.C;
    }

    public boolean S() {
        return this.C;
    }

    public final void T() {
        this.f57987m.reset();
        l0(this.B);
        X(G());
        C();
    }

    public void U(boolean z10) {
        this.f57979f = z10;
    }

    public void V(float f10) {
        this.B = f10 % 360.0f;
        v0();
        l0(this.B);
        B();
    }

    public boolean W(Matrix matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException("Matrix cannot be null");
        }
        if (this.f57981h.getDrawable() == null) {
            return false;
        }
        this.f57987m.set(matrix);
        B();
        return true;
    }

    public final void X(Matrix matrix) {
        RectF rectFF;
        this.f57981h.setImageMatrix(matrix);
        if (this.f57990p == null || (rectFF = F(matrix)) == null) {
            return;
        }
        this.f57990p.a(rectFF);
    }

    public void Y(float f10) {
        m.a(this.f57976c, this.f57977d, f10);
        this.f57978e = f10;
    }

    public void Z(float f10) {
        m.a(this.f57976c, f10, this.f57978e);
        this.f57977d = f10;
    }

    public void a0(float f10) {
        m.a(f10, this.f57977d, this.f57978e);
        this.f57976c = f10;
    }

    public void b0(View.OnClickListener onClickListener) {
        this.f57994t = onClickListener;
    }

    public void c0(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f57982i.setOnDoubleTapListener(onDoubleTapListener);
    }

    public void d0(View.OnLongClickListener onLongClickListener) {
        this.f57995u = onLongClickListener;
    }

    public void e0(z9.e eVar) {
        this.f57990p = eVar;
    }

    public void f0(z9.f fVar) {
        this.f57992r = fVar;
    }

    public void g0(g gVar) {
        this.f57991q = gVar;
    }

    public void h0(h hVar) {
        this.f57996v = hVar;
    }

    public void i0(i iVar) {
        this.f57997w = iVar;
    }

    public void j0(j jVar) {
        this.f57998x = jVar;
    }

    public void k0(k kVar) {
        this.f57993s = kVar;
    }

    public void l0(float f10) {
        this.f57987m.postRotate(f10 % 360.0f);
        B();
    }

    public void m0(float f10) {
        this.f57987m.setRotate(f10 % 360.0f);
        B();
    }

    public void n0(float f10) {
        p0(f10, false);
    }

    public void o0(float f10, float f11, float f12, boolean z10) {
        if (f10 < this.f57976c || f10 > this.f57978e) {
            throw new IllegalArgumentException("Scale must be within the range of minScale and maxScale");
        }
        if (z10) {
            this.f57981h.post(new e(N(), f10, f11, f12));
        } else {
            this.f57987m.setScale(f10, f10, f11, f12);
            B();
        }
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        if (i10 == i14 && i11 == i15 && i12 == i16 && i13 == i17) {
            return;
        }
        w0(this.f57981h.getDrawable());
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b2  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouch(android.view.View r11, android.view.MotionEvent r12) {
        /*
            r10 = this;
            boolean r0 = r10.C
            r1 = 0
            r2 = 1
            if (r0 == 0) goto Lbe
            r0 = r11
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            boolean r0 = z9.m.c(r0)
            if (r0 == 0) goto Lbe
            int r0 = r12.getAction()
            if (r0 == 0) goto L6e
            if (r0 == r2) goto L1b
            r3 = 3
            if (r0 == r3) goto L1b
            goto L7a
        L1b:
            float r0 = r10.N()
            float r3 = r10.f57976c
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 >= 0) goto L44
            android.graphics.RectF r0 = r10.E()
            if (r0 == 0) goto L7a
            z9.l$e r9 = new z9.l$e
            float r5 = r10.N()
            float r6 = r10.f57976c
            float r7 = r0.centerX()
            float r8 = r0.centerY()
            r3 = r9
            r4 = r10
            r3.<init>(r5, r6, r7, r8)
            r11.post(r9)
            goto L6c
        L44:
            float r0 = r10.N()
            float r3 = r10.f57978e
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L7a
            android.graphics.RectF r0 = r10.E()
            if (r0 == 0) goto L7a
            z9.l$e r9 = new z9.l$e
            float r5 = r10.N()
            float r6 = r10.f57978e
            float r7 = r0.centerX()
            float r8 = r0.centerY()
            r3 = r9
            r4 = r10
            r3.<init>(r5, r6, r7, r8)
            r11.post(r9)
        L6c:
            r11 = 1
            goto L7b
        L6e:
            android.view.ViewParent r11 = r11.getParent()
            if (r11 == 0) goto L77
            r11.requestDisallowInterceptTouchEvent(r2)
        L77:
            r10.A()
        L7a:
            r11 = 0
        L7b:
            z9.c r0 = r10.f57983j
            if (r0 == 0) goto Lb2
            boolean r11 = r0.e()
            z9.c r0 = r10.f57983j
            boolean r0 = r0.d()
            z9.c r3 = r10.f57983j
            boolean r3 = r3.f(r12)
            if (r11 != 0) goto L9b
            z9.c r11 = r10.f57983j
            boolean r11 = r11.e()
            if (r11 != 0) goto L9b
            r11 = 1
            goto L9c
        L9b:
            r11 = 0
        L9c:
            if (r0 != 0) goto La8
            z9.c r0 = r10.f57983j
            boolean r0 = r0.d()
            if (r0 != 0) goto La8
            r0 = 1
            goto La9
        La8:
            r0 = 0
        La9:
            if (r11 == 0) goto Lae
            if (r0 == 0) goto Lae
            r1 = 1
        Lae:
            r10.f57980g = r1
            r1 = r3
            goto Lb3
        Lb2:
            r1 = r11
        Lb3:
            android.view.GestureDetector r11 = r10.f57982i
            if (r11 == 0) goto Lbe
            boolean r11 = r11.onTouchEvent(r12)
            if (r11 == 0) goto Lbe
            r1 = 1
        Lbe:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: z9.l.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public void p0(float f10, boolean z10) {
        o0(f10, this.f57981h.getRight() / 2, this.f57981h.getBottom() / 2, z10);
    }

    public void q0(float f10, float f11, float f12) {
        m.a(f10, f11, f12);
        this.f57976c = f10;
        this.f57977d = f11;
        this.f57978e = f12;
    }

    public void r0(ImageView.ScaleType scaleType) {
        if (!m.d(scaleType) || scaleType == this.D) {
            return;
        }
        this.D = scaleType;
        v0();
    }

    public void s0(Interpolator interpolator) {
        this.f57974a = interpolator;
    }

    public void t0(int i10) {
        this.f57975b = i10;
    }

    public void u0(boolean z10) {
        this.C = z10;
        v0();
    }

    public void v0() {
        if (this.C) {
            w0(this.f57981h.getDrawable());
        } else {
            T();
        }
    }

    public final void w0(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        float fJ = J(this.f57981h);
        float fI = I(this.f57981h);
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        this.f57984k.reset();
        float f10 = intrinsicWidth;
        float f11 = fJ / f10;
        float f12 = intrinsicHeight;
        float f13 = fI / f12;
        ImageView.ScaleType scaleType = this.D;
        if (scaleType == ImageView.ScaleType.CENTER) {
            this.f57984k.postTranslate((fJ - f10) / 2.0f, (fI - f12) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            float fMax = Math.max(f11, f13);
            this.f57984k.postScale(fMax, fMax);
            this.f57984k.postTranslate((fJ - (f10 * fMax)) / 2.0f, (fI - (f12 * fMax)) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
            float fMin = Math.min(1.0f, Math.min(f11, f13));
            this.f57984k.postScale(fMin, fMin);
            this.f57984k.postTranslate((fJ - (f10 * fMin)) / 2.0f, (fI - (f12 * fMin)) / 2.0f);
        } else {
            RectF rectF = new RectF(0.0f, 0.0f, f10, f12);
            RectF rectF2 = new RectF(0.0f, 0.0f, fJ, fI);
            if (((int) this.B) % 180 != 0) {
                rectF = new RectF(0.0f, 0.0f, f12, f10);
            }
            int i10 = d.f58004a[this.D.ordinal()];
            if (i10 == 1) {
                this.f57984k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            } else if (i10 == 2) {
                this.f57984k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
            } else if (i10 == 3) {
                this.f57984k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
            } else if (i10 == 4) {
                this.f57984k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
            }
        }
        T();
    }
}
