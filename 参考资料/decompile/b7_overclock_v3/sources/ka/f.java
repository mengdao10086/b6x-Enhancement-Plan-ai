package ka;

import android.content.Context;
import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.github.mikephil.charting.data.Entry;
import java.lang.ref.WeakReference;
import xa.g;

/* JADX INFO: loaded from: classes3.dex */
public class f extends RelativeLayout implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f37123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g f37124b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WeakReference<ja.e> f37125c;

    public f(Context context, int i10) {
        super(context);
        this.f37123a = new g();
        this.f37124b = new g();
        setupLayoutResource(i10);
    }

    private void setupLayoutResource(int i10) {
        View viewInflate = LayoutInflater.from(getContext()).inflate(i10, this);
        viewInflate.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        viewInflate.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        viewInflate.layout(0, 0, viewInflate.getMeasuredWidth(), viewInflate.getMeasuredHeight());
    }

    @Override // ka.d
    public void a(Canvas canvas, float f10, float f11) {
        g gVarB = b(f10, f11);
        int iSave = canvas.save();
        canvas.translate(f10 + gVarB.f54987c, f11 + gVarB.f54988d);
        draw(canvas);
        canvas.restoreToCount(iSave);
    }

    @Override // ka.d
    public g b(float f10, float f11) {
        g offset = getOffset();
        g gVar = this.f37124b;
        gVar.f54987c = offset.f54987c;
        gVar.f54988d = offset.f54988d;
        ja.e chartView = getChartView();
        float width = getWidth();
        float height = getHeight();
        g gVar2 = this.f37124b;
        float f12 = gVar2.f54987c;
        if (f10 + f12 < 0.0f) {
            gVar2.f54987c = -f10;
        } else if (chartView != null && f10 + width + f12 > chartView.getWidth()) {
            this.f37124b.f54987c = (chartView.getWidth() - f10) - width;
        }
        g gVar3 = this.f37124b;
        float f13 = gVar3.f54988d;
        if (f11 + f13 < 0.0f) {
            gVar3.f54988d = -f11;
        } else if (chartView != null && f11 + height + f13 > chartView.getHeight()) {
            this.f37124b.f54988d = (chartView.getHeight() - f11) - height;
        }
        return this.f37124b;
    }

    @Override // ka.d
    public void c(Entry entry, oa.d dVar) {
        measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
    }

    public void d(float f10, float f11) {
        g gVar = this.f37123a;
        gVar.f54987c = f10;
        gVar.f54988d = f11;
    }

    public ja.e getChartView() {
        WeakReference<ja.e> weakReference = this.f37125c;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Override // ka.d
    public g getOffset() {
        return this.f37123a;
    }

    public void setChartView(ja.e eVar) {
        this.f37125c = new WeakReference<>(eVar);
    }

    public void setOffset(g gVar) {
        this.f37123a = gVar;
        if (gVar == null) {
            this.f37123a = new g();
        }
    }
}
