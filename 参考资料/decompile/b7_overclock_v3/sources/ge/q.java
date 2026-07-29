package ge;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.R;
import com.google.android.material.internal.t;
import g.d1;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes3.dex */
public final class q extends c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f29375g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f29376h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f29377i;

    public q(@n0 Context context, @p0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.linearProgressIndicatorStyle);
    }

    @Override // ge.c
    public void e() {
        if (this.f29375g == 0) {
            if (this.f29273b > 0) {
                throw new IllegalArgumentException("Rounded corners are not supported in contiguous indeterminate animation.");
            }
            if (this.f29274c.length < 3) {
                throw new IllegalArgumentException("Contiguous indeterminate animation must be used with 3 or more indicator colors.");
            }
        }
    }

    public q(@n0 Context context, @p0 AttributeSet attributeSet, @g.f int i10) {
        this(context, attributeSet, i10, p.f29373y);
    }

    public q(@n0 Context context, @p0 AttributeSet attributeSet, @g.f int i10, @d1 int i11) {
        super(context, attributeSet, i10, i11);
        TypedArray typedArrayK = t.k(context, attributeSet, R.styleable.LinearProgressIndicator, R.attr.linearProgressIndicatorStyle, p.f29373y, new int[0]);
        this.f29375g = typedArrayK.getInt(R.styleable.LinearProgressIndicator_indeterminateAnimationType, 1);
        this.f29376h = typedArrayK.getInt(R.styleable.LinearProgressIndicator_indicatorDirectionLinear, 0);
        typedArrayK.recycle();
        e();
        this.f29377i = this.f29376h == 1;
    }
}
