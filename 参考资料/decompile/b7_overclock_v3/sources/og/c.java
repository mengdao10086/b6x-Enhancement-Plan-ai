package og;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.slidingpanelayout.widget.SlidingPaneLayout;
import com.scwang.smartrefresh.layout.R;
import g.n0;
import mg.f;
import mg.i;
import mg.j;

/* JADX INFO: loaded from: classes5.dex */
public class c extends rg.b implements f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public i f43343d;

    public c(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int iD = tg.b.d(5.0f);
            Context context = getContext();
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(SlidingPaneLayout.f7647z);
            paint.setStrokeWidth(tg.b.d(1.0f));
            float f10 = iD;
            paint.setPathEffect(new DashPathEffect(new float[]{f10, f10, f10, f10}, 1.0f));
            canvas.drawRect(f10, f10, getWidth() - iD, getBottom() - iD, paint);
            TextView textView = new TextView(context);
            textView.setText(context.getString(R.string.srl_component_falsify, getClass().getSimpleName(), Float.valueOf(tg.b.j(getHeight()))));
            textView.setTextColor(SlidingPaneLayout.f7647z);
            textView.setGravity(17);
            textView.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824));
            textView.layout(0, 0, getWidth(), getHeight());
            textView.draw(canvas);
        }
    }

    @Override // rg.b, mg.h
    public void i(@n0 j jVar, int i10, int i11) {
        if (this.f43343d != null) {
            jVar.i();
        }
    }

    @Override // rg.b, mg.h
    public void n(@n0 i iVar, int i10, int i11) {
        this.f43343d = iVar;
        iVar.h().a0(false);
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }
}
