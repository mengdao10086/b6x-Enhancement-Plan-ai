package ge;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.RestrictTo;
import androidx.core.view.u0;
import com.google.android.material.R;
import g.n0;
import g.p0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes3.dex */
public final class p extends ge.b<q> {
    public static final int A = 1;
    public static final int B = 0;
    public static final int C = 1;
    public static final int D = 2;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final int f29372k0 = 3;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f29373y = R.style.Widget_MaterialComponents_LinearProgressIndicator;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f29374z = 0;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface a {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface b {
    }

    public p(@n0 Context context) {
        this(context, null);
    }

    public int getIndeterminateAnimationType() {
        return ((q) this.f29254a).f29375g;
    }

    public int getIndicatorDirection() {
        return ((q) this.f29254a).f29376h;
    }

    @Override // android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        S s10 = this.f29254a;
        q qVar = (q) s10;
        boolean z11 = true;
        if (((q) s10).f29376h != 1 && ((u0.Z(this) != 1 || ((q) this.f29254a).f29376h != 2) && (u0.Z(this) != 0 || ((q) this.f29254a).f29376h != 3))) {
            z11 = false;
        }
        qVar.f29377i = z11;
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        int paddingLeft = i10 - (getPaddingLeft() + getPaddingRight());
        int paddingTop = i11 - (getPaddingTop() + getPaddingBottom());
        l<q> indeterminateDrawable = getIndeterminateDrawable();
        if (indeterminateDrawable != null) {
            indeterminateDrawable.setBounds(0, 0, paddingLeft, paddingTop);
        }
        h<q> progressDrawable = getProgressDrawable();
        if (progressDrawable != null) {
            progressDrawable.setBounds(0, 0, paddingLeft, paddingTop);
        }
    }

    @Override // ge.b
    public void p(int i10, boolean z10) {
        S s10 = this.f29254a;
        if (s10 != 0 && ((q) s10).f29375g == 0 && isIndeterminate()) {
            return;
        }
        super.p(i10, z10);
    }

    public void setIndeterminateAnimationType(int i10) {
        if (((q) this.f29254a).f29375g == i10) {
            return;
        }
        if (s() && isIndeterminate()) {
            throw new IllegalStateException("Cannot change indeterminate animation type while the progress indicator is show in indeterminate mode.");
        }
        S s10 = this.f29254a;
        ((q) s10).f29375g = i10;
        ((q) s10).e();
        if (i10 == 0) {
            getIndeterminateDrawable().B(new n((q) this.f29254a));
        } else {
            getIndeterminateDrawable().B(new o(getContext(), (q) this.f29254a));
        }
        invalidate();
    }

    @Override // ge.b
    public void setIndicatorColor(@n0 int... iArr) {
        super.setIndicatorColor(iArr);
        ((q) this.f29254a).e();
    }

    public void setIndicatorDirection(int i10) {
        S s10 = this.f29254a;
        ((q) s10).f29376h = i10;
        q qVar = (q) s10;
        boolean z10 = true;
        if (i10 != 1 && ((u0.Z(this) != 1 || ((q) this.f29254a).f29376h != 2) && (u0.Z(this) != 0 || i10 != 3))) {
            z10 = false;
        }
        qVar.f29377i = z10;
        invalidate();
    }

    @Override // ge.b
    public void setTrackCornerRadius(int i10) {
        super.setTrackCornerRadius(i10);
        ((q) this.f29254a).e();
        invalidate();
    }

    @Override // ge.b
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public q i(@n0 Context context, @n0 AttributeSet attributeSet) {
        return new q(context, attributeSet);
    }

    public final void u() {
        setIndeterminateDrawable(l.y(getContext(), (q) this.f29254a));
        setProgressDrawable(h.B(getContext(), (q) this.f29254a));
    }

    public p(@n0 Context context, @p0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.linearProgressIndicatorStyle);
    }

    public p(@n0 Context context, @p0 AttributeSet attributeSet, @g.f int i10) {
        super(context, attributeSet, i10, f29373y);
        u();
    }
}
