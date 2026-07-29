package b0;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.R;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
public class d extends AppCompatButton {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f8960d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f8961e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Path f8962f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ViewOutlineProvider f8963g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public RectF f8964h;

    public class a extends ViewOutlineProvider {
        public a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, d.this.getWidth(), d.this.getHeight(), (Math.min(r3, r4) * d.this.f8960d) / 2.0f);
        }
    }

    public class b extends ViewOutlineProvider {
        public b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, d.this.getWidth(), d.this.getHeight(), d.this.f8961e);
        }
    }

    public d(Context context) {
        super(context);
        this.f8960d = 0.0f;
        this.f8961e = Float.NaN;
        d(context, null);
    }

    public final void d(Context context, AttributeSet attrs) {
        setPadding(0, 0, 0, 0);
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.ImageFilterView);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.ImageFilterView_round) {
                    setRound(typedArrayObtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_roundPercent) {
                    setRoundPercent(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public float getRound() {
        return this.f8961e;
    }

    public float getRoundPercent() {
        return this.f8960d;
    }

    @v0(21)
    public void setRound(float round) {
        if (Float.isNaN(round)) {
            this.f8961e = round;
            float f10 = this.f8960d;
            this.f8960d = -1.0f;
            setRoundPercent(f10);
            return;
        }
        boolean z10 = this.f8961e != round;
        this.f8961e = round;
        if (round != 0.0f) {
            if (this.f8962f == null) {
                this.f8962f = new Path();
            }
            if (this.f8964h == null) {
                this.f8964h = new RectF();
            }
            if (this.f8963g == null) {
                b bVar = new b();
                this.f8963g = bVar;
                setOutlineProvider(bVar);
            }
            setClipToOutline(true);
            this.f8964h.set(0.0f, 0.0f, getWidth(), getHeight());
            this.f8962f.reset();
            Path path = this.f8962f;
            RectF rectF = this.f8964h;
            float f11 = this.f8961e;
            path.addRoundRect(rectF, f11, f11, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z10) {
            invalidateOutline();
        }
    }

    @v0(21)
    public void setRoundPercent(float round) {
        boolean z10 = this.f8960d != round;
        this.f8960d = round;
        if (round != 0.0f) {
            if (this.f8962f == null) {
                this.f8962f = new Path();
            }
            if (this.f8964h == null) {
                this.f8964h = new RectF();
            }
            if (this.f8963g == null) {
                a aVar = new a();
                this.f8963g = aVar;
                setOutlineProvider(aVar);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float fMin = (Math.min(width, height) * this.f8960d) / 2.0f;
            this.f8964h.set(0.0f, 0.0f, width, height);
            this.f8962f.reset();
            this.f8962f.addRoundRect(this.f8964h, fMin, fMin, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z10) {
            invalidateOutline();
        }
    }

    public d(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f8960d = 0.0f;
        this.f8961e = Float.NaN;
        d(context, attrs);
    }

    public d(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f8960d = 0.0f;
        this.f8961e = Float.NaN;
        d(context, attrs);
    }
}
