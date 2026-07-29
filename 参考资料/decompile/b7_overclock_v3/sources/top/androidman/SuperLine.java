package top.androidman;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import hk.i;
import ik.a;
import kotlin.b0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.z;
import qu.b;
import qu.c;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes6.dex */
public final class SuperLine extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final z f51431a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @i
    public SuperLine(@k Context context) {
        this(context, null, 0, 6, null);
        f0.p(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @i
    public SuperLine(@k Context context, @l AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        f0.p(context, "context");
    }

    public /* synthetic */ SuperLine(Context context, AttributeSet attributeSet, int i10, int i11, u uVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    private final c getValueStore() {
        return (c) this.f51431a.getValue();
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onDraw(@l Canvas canvas) {
        float f10;
        float f11;
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.STROKE);
        int iF = getValueStore().f() != Integer.MAX_VALUE ? getValueStore().f() : getMeasuredWidth() >= getMeasuredHeight() ? 2 : 1;
        paint.setStrokeWidth(iF == 2 ? getMeasuredWidth() : getMeasuredHeight());
        float measuredWidth = iF == 2 ? 0.0f : getMeasuredWidth() / 2.0f;
        float measuredHeight = iF == 2 ? getMeasuredHeight() / 2.0f : 0.0f;
        float measuredWidth2 = getMeasuredWidth();
        if (iF != 2) {
            measuredWidth2 /= 2.0f;
        }
        float f12 = measuredWidth2;
        float measuredHeight2 = iF == 2 ? getMeasuredHeight() / 2.0f : getMeasuredHeight();
        Path path = new Path();
        if (getValueStore().b() != Integer.MAX_VALUE) {
            paint.setColor(getValueStore().b());
            path.reset();
            path.moveTo(measuredWidth, measuredHeight);
            path.lineTo(f12, measuredHeight2);
            if (canvas != null) {
                canvas.drawPath(path, paint);
            }
        }
        if (getValueStore().g() == Integer.MAX_VALUE || getValueStore().e() == Integer.MAX_VALUE) {
            f10 = f12;
            f11 = measuredHeight;
            paint.setColor(getValueStore().a());
        } else {
            f10 = f12;
            f11 = measuredHeight;
            paint.setShader(new LinearGradient(measuredWidth, measuredHeight, f12, measuredHeight2, getValueStore().g(), getValueStore().e(), Shader.TileMode.CLAMP));
        }
        if (getValueStore().d() != Integer.MAX_VALUE && getValueStore().c() != Integer.MAX_VALUE) {
            paint.setPathEffect(new DashPathEffect(new float[]{getValueStore().d(), getValueStore().c()}, 0.0f));
        }
        path.reset();
        path.moveTo(measuredWidth, f11);
        path.lineTo(f10, measuredHeight2);
        if (canvas != null) {
            canvas.drawPath(path, paint);
        }
    }

    public final void setLineColor(@g.l int i10) {
        getValueStore().h(i10);
        invalidate();
    }

    public final void setLineDashGapColor(@g.l int i10) {
        getValueStore().i(i10);
        invalidate();
    }

    public final void setLineDashGapWidth(int i10) {
        getValueStore().j(i10);
        invalidate();
    }

    public final void setLineDashWidth(int i10) {
        getValueStore().k(i10);
        invalidate();
    }

    public final void setLineEndColor(@g.l int i10) {
        getValueStore().l(i10);
        invalidate();
    }

    public final void setLineStartColor(@g.l int i10) {
        getValueStore().n(i10);
        invalidate();
    }

    public final void setOrientation(int i10) {
        getValueStore().m(i10);
        invalidate();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @i
    public SuperLine(@k final Context context, @l final AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        f0.p(context, "context");
        this.f51431a = b0.a(new a<c>() { // from class: top.androidman.SuperLine$valueStore$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // ik.a
            @k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final c o() {
                c cVar = new c();
                b.f47637a.a(context, attributeSet, cVar);
                return cVar;
            }
        });
        getValueStore();
    }
}
