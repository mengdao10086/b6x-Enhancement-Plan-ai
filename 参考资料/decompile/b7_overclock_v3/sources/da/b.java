package da;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import com.github.dhaval2404.colorpicker.R;
import com.umeng.analytics.pro.d;
import hk.i;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.z1;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes3.dex */
@d0(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t¨\u0006\u0015"}, d2 = {"Lda/b;", "Landroid/view/View;", "Landroid/graphics/Canvas;", "canvas", "Lkotlin/z1;", "onDraw", "", "pointerRadius", "setPointerRadius", "Landroid/graphics/PointF;", "point", "setCurrentPoint", "Landroid/content/Context;", d.R, "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "colorpicker_release"}, k = 1, mv = {1, 5, 1})
public final class b extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f26124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public PointF f26125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @k
    public Paint f26126c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @i
    public b(@k Context context) {
        this(context, null, 0, 0, 14, null);
        f0.p(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @i
    public b(@k Context context, @l AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        f0.p(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @i
    public b(@k Context context, @l AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0, 8, null);
        f0.p(context, "context");
    }

    public /* synthetic */ b(Context context, AttributeSet attributeSet, int i10, int i11, int i12, u uVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i10, (i12 & 8) != 0 ? 0 : i11);
    }

    public void a() {
    }

    @Override // android.view.View
    public void onDraw(@k Canvas canvas) {
        f0.p(canvas, "canvas");
        PointF pointF = this.f26125b;
        canvas.drawCircle(pointF.x, pointF.y, this.f26124a * 0.66f, this.f26126c);
    }

    public final void setCurrentPoint(@k PointF point) {
        f0.p(point, "point");
        this.f26125b = point;
        invalidate();
    }

    public final void setPointerRadius(float f10) {
        this.f26124a = f10;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @i
    public b(@k Context context, @l AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        f0.p(context, "context");
        this.f26124a = 8.0f;
        this.f26125b = new PointF();
        setAlpha(0.5f);
        Paint paint = new Paint(1);
        paint.setColor(h0.d.f(context, R.color.colorPointer));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(8.0f);
        z1 z1Var = z1.f38230a;
        this.f26126c = paint;
    }
}
