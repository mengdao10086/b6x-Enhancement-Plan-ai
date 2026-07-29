package ge;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.R;
import com.google.android.material.internal.t;
import g.d1;
import g.n0;
import g.p0;
import g.t0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @t0
    public int f29272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @t0
    public int f29273b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public int[] f29274c = new int[0];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.l
    public int f29275d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f29276e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f29277f;

    public c(@n0 Context context, @p0 AttributeSet attributeSet, @g.f int i10, @d1 int i11) {
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.mtrl_progress_track_thickness);
        TypedArray typedArrayK = t.k(context, attributeSet, R.styleable.BaseProgressIndicator, i10, i11, new int[0]);
        this.f29272a = ie.c.d(context, typedArrayK, R.styleable.BaseProgressIndicator_trackThickness, dimensionPixelSize);
        this.f29273b = Math.min(ie.c.d(context, typedArrayK, R.styleable.BaseProgressIndicator_trackCornerRadius, 0), this.f29272a / 2);
        this.f29276e = typedArrayK.getInt(R.styleable.BaseProgressIndicator_showAnimationBehavior, 0);
        this.f29277f = typedArrayK.getInt(R.styleable.BaseProgressIndicator_hideAnimationBehavior, 0);
        c(context, typedArrayK);
        d(context, typedArrayK);
        typedArrayK.recycle();
    }

    public boolean a() {
        return this.f29277f != 0;
    }

    public boolean b() {
        return this.f29276e != 0;
    }

    public final void c(@n0 Context context, @n0 TypedArray typedArray) {
        int i10 = R.styleable.BaseProgressIndicator_indicatorColor;
        if (!typedArray.hasValue(i10)) {
            this.f29274c = new int[]{vd.m.b(context, R.attr.colorPrimary, -1)};
            return;
        }
        if (typedArray.peekValue(i10).type != 1) {
            this.f29274c = new int[]{typedArray.getColor(i10, -1)};
            return;
        }
        int[] intArray = context.getResources().getIntArray(typedArray.getResourceId(i10, -1));
        this.f29274c = intArray;
        if (intArray.length == 0) {
            throw new IllegalArgumentException("indicatorColors cannot be empty when indicatorColor is not used.");
        }
    }

    public final void d(@n0 Context context, @n0 TypedArray typedArray) {
        int i10 = R.styleable.BaseProgressIndicator_trackColor;
        if (typedArray.hasValue(i10)) {
            this.f29275d = typedArray.getColor(i10, -1);
            return;
        }
        this.f29275d = this.f29274c[0];
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{android.R.attr.disabledAlpha});
        float f10 = typedArrayObtainStyledAttributes.getFloat(0, 0.2f);
        typedArrayObtainStyledAttributes.recycle();
        this.f29275d = vd.m.a(this.f29275d, (int) (f10 * 255.0f));
    }

    public abstract void e();
}
