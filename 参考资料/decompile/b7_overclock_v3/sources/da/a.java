package da;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;
import com.umeng.analytics.pro.d;
import hk.i;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import qk.v;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes3.dex */
@d0(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J(\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0014J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0014¨\u0006\u0014"}, d2 = {"Lda/a;", "Landroid/view/View;", "", "w", "h", "oldw", "oldh", "Lkotlin/z1;", "onSizeChanged", "Landroid/graphics/Canvas;", "canvas", "onDraw", "Landroid/content/Context;", d.R, "Landroid/util/AttributeSet;", "attrs", "defStyle", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "colorpicker_release"}, k = 1, mv = {1, 5, 1})
public final class a extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f26118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f26119b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f26120c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @k
    public Paint f26121d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @k
    public Paint f26122e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @k
    public int[] f26123f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @i
    public a(@k Context context) {
        this(context, null, 0, 0, 14, null);
        f0.p(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @i
    public a(@k Context context, @l AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        f0.p(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @i
    public a(@k Context context, @l AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0, 8, null);
        f0.p(context, "context");
    }

    public /* synthetic */ a(Context context, AttributeSet attributeSet, int i10, int i11, int i12, u uVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i10, (i12 & 8) != 0 ? 0 : i11);
    }

    public void a() {
    }

    @Override // android.view.View
    public void onDraw(@k Canvas canvas) {
        f0.p(canvas, "canvas");
        canvas.drawCircle(this.f26119b, this.f26120c, this.f26118a, this.f26121d);
        canvas.drawCircle(this.f26119b, this.f26120c, this.f26118a, this.f26122e);
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        float fB = v.B((i10 - getPaddingLeft()) - getPaddingRight(), (i11 - getPaddingTop()) - getPaddingBottom()) * 0.5f;
        this.f26118a = fB;
        if (fB < 0.0f) {
            return;
        }
        this.f26119b = i10 * 0.5f;
        this.f26120c = i11 * 0.5f;
        this.f26121d.setShader(new SweepGradient(this.f26119b, this.f26120c, this.f26123f, (float[]) null));
        this.f26122e.setShader(new RadialGradient(this.f26119b, this.f26120c, this.f26118a, -1, 16777215, Shader.TileMode.CLAMP));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @i
    public a(@k Context context, @l AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        f0.p(context, "context");
        this.f26121d = new Paint(1);
        this.f26122e = new Paint(1);
        this.f26123f = new int[]{-65536, -65281, -16776961, -16711681, -16711936, -256, -65536};
    }
}
