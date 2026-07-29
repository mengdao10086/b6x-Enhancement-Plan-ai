package ge;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.RestrictTo;
import com.google.android.material.R;
import g.n0;
import g.p0;
import g.t0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends b<g> {
    public static final int A = 1;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f29306y = R.style.Widget_MaterialComponents_CircularProgressIndicator;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f29307z = 0;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface a {
    }

    public f(@n0 Context context) {
        this(context, null);
    }

    public int getIndicatorDirection() {
        return ((g) this.f29254a).f29310i;
    }

    @t0
    public int getIndicatorInset() {
        return ((g) this.f29254a).f29309h;
    }

    @t0
    public int getIndicatorSize() {
        return ((g) this.f29254a).f29308g;
    }

    public void setIndicatorDirection(int i10) {
        ((g) this.f29254a).f29310i = i10;
        invalidate();
    }

    public void setIndicatorInset(@t0 int i10) {
        S s10 = this.f29254a;
        if (((g) s10).f29309h != i10) {
            ((g) s10).f29309h = i10;
            invalidate();
        }
    }

    public void setIndicatorSize(@t0 int i10) {
        int iMax = Math.max(i10, getTrackThickness() * 2);
        S s10 = this.f29254a;
        if (((g) s10).f29308g != iMax) {
            ((g) s10).f29308g = iMax;
            ((g) s10).e();
            invalidate();
        }
    }

    @Override // ge.b
    public void setTrackThickness(int i10) {
        super.setTrackThickness(i10);
        ((g) this.f29254a).e();
    }

    @Override // ge.b
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public g i(@n0 Context context, @n0 AttributeSet attributeSet) {
        return new g(context, attributeSet);
    }

    public final void u() {
        setIndeterminateDrawable(l.x(getContext(), (g) this.f29254a));
        setProgressDrawable(h.A(getContext(), (g) this.f29254a));
    }

    public f(@n0 Context context, @p0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.circularProgressIndicatorStyle);
    }

    public f(@n0 Context context, @p0 AttributeSet attributeSet, @g.f int i10) {
        super(context, attributeSet, i10, f29306y);
        u();
    }
}
