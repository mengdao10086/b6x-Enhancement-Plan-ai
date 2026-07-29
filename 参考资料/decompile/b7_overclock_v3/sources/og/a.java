package og;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.scwang.smartrefresh.layout.R;
import g.l;
import g.n0;
import g.p0;
import m0.g;
import mg.f;
import mg.j;

/* JADX INFO: loaded from: classes5.dex */
public class a extends rg.b implements f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f43323d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f43324e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Paint f43325f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f43326g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f43327h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f43328i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f43329j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f43330k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TimeInterpolator f43331l;

    public a(Context context) {
        this(context, null);
    }

    @Override // rg.b, mg.h
    public void b(@n0 j jVar, int i10, int i11) {
        if (this.f43330k) {
            return;
        }
        invalidate();
        this.f43330k = true;
        this.f43329j = System.currentTimeMillis();
        this.f43325f.setColor(this.f43327h);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        float fMin = Math.min(width, height);
        float f10 = this.f43328i;
        float f11 = (fMin - (f10 * 2.0f)) / 6.0f;
        float f12 = f11 * 2.0f;
        float f13 = (width / 2.0f) - (f10 + f12);
        float f14 = height / 2.0f;
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i10 = 0;
        while (i10 < 3) {
            int i11 = i10 + 1;
            float interpolation = this.f43331l.getInterpolation((jCurrentTimeMillis - this.f43329j) - ((long) (i11 * 120)) > 0 ? (r10 % 750) / 750.0f : 0.0f);
            canvas.save();
            float f15 = i10;
            canvas.translate((f12 * f15) + f13 + (this.f43328i * f15), f14);
            if (interpolation < 0.5d) {
                float f16 = 1.0f - ((interpolation * 2.0f) * 0.7f);
                canvas.scale(f16, f16);
            } else {
                float f17 = ((interpolation * 2.0f) * 0.7f) - 0.4f;
                canvas.scale(f17, f17);
            }
            canvas.drawCircle(0.0f, 0.0f, f11, this.f43325f);
            canvas.restore();
            i10 = i11;
        }
        super.dispatchDraw(canvas);
        if (this.f43330k) {
            invalidate();
        }
    }

    public a g(@l int i10) {
        this.f43327h = i10;
        this.f43324e = true;
        if (this.f43330k) {
            this.f43325f.setColor(i10);
        }
        return this;
    }

    @Override // rg.b, mg.h
    public int l(@n0 j jVar, boolean z10) {
        this.f43330k = false;
        this.f43329j = 0L;
        this.f43325f.setColor(this.f43326g);
        return 0;
    }

    public a o(@l int i10) {
        this.f43326g = i10;
        this.f43323d = true;
        if (!this.f43330k) {
            this.f43325f.setColor(i10);
        }
        return this;
    }

    @Override // rg.b, mg.h
    @Deprecated
    public void setPrimaryColors(@l int... iArr) {
        if (!this.f43324e && iArr.length > 1) {
            g(iArr[0]);
            this.f43324e = false;
        }
        if (this.f43323d) {
            return;
        }
        if (iArr.length > 1) {
            o(iArr[1]);
        } else if (iArr.length > 0) {
            o(g.t(-1711276033, iArr[0]));
        }
        this.f43323d = false;
    }

    public a t(ng.b bVar) {
        this.f48755b = bVar;
        return this;
    }

    public a(Context context, @p0 AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f43326g = -1118482;
        this.f43327h = -1615546;
        this.f43329j = 0L;
        this.f43330k = false;
        this.f43331l = new AccelerateDecelerateInterpolator();
        setMinimumHeight(tg.b.d(60.0f));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BallPulseFooter);
        Paint paint = new Paint();
        this.f43325f = paint;
        paint.setColor(-1);
        this.f43325f.setStyle(Paint.Style.FILL);
        this.f43325f.setAntiAlias(true);
        ng.b bVar = ng.b.f42143d;
        this.f48755b = bVar;
        this.f48755b = ng.b.f42148i[typedArrayObtainStyledAttributes.getInt(R.styleable.BallPulseFooter_srlClassicsSpinnerStyle, bVar.f42149a)];
        int i10 = R.styleable.BallPulseFooter_srlNormalColor;
        if (typedArrayObtainStyledAttributes.hasValue(i10)) {
            o(typedArrayObtainStyledAttributes.getColor(i10, 0));
        }
        int i11 = R.styleable.BallPulseFooter_srlAnimatingColor;
        if (typedArrayObtainStyledAttributes.hasValue(i11)) {
            g(typedArrayObtainStyledAttributes.getColor(i11, 0));
        }
        typedArrayObtainStyledAttributes.recycle();
        this.f43328i = tg.b.d(4.0f);
    }
}
