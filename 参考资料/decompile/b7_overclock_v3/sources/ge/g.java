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
public final class g extends c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @t0
    public int f29308g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @t0
    public int f29309h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f29310i;

    public g(@n0 Context context, @p0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.circularProgressIndicatorStyle);
    }

    @Override // ge.c
    public void e() {
    }

    public g(@n0 Context context, @p0 AttributeSet attributeSet, @g.f int i10) {
        this(context, attributeSet, i10, f.f29306y);
    }

    public g(@n0 Context context, @p0 AttributeSet attributeSet, @g.f int i10, @d1 int i11) {
        super(context, attributeSet, i10, i11);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.mtrl_progress_circular_size_medium);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R.dimen.mtrl_progress_circular_inset_medium);
        TypedArray typedArrayK = t.k(context, attributeSet, R.styleable.CircularProgressIndicator, i10, i11, new int[0]);
        this.f29308g = Math.max(ie.c.d(context, typedArrayK, R.styleable.CircularProgressIndicator_indicatorSize, dimensionPixelSize), this.f29272a * 2);
        this.f29309h = ie.c.d(context, typedArrayK, R.styleable.CircularProgressIndicator_indicatorInset, dimensionPixelSize2);
        this.f29310i = typedArrayK.getInt(R.styleable.CircularProgressIndicator_indicatorDirectionCircular, 0);
        typedArrayK.recycle();
        e();
    }
}
