package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.arialyy.aria.core.listener.ISchedulers;

/* JADX INFO: loaded from: classes2.dex */
public class g extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f4491b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4492c;

    public g(Context context) {
        super(context);
        this.f4490a = -1;
        this.f4491b = null;
        this.f4492c = 4;
        a(null);
    }

    public final void a(AttributeSet attrs) {
        super.setVisibility(this.f4492c);
        this.f4490a = -1;
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.ConstraintLayout_placeholder);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.ConstraintLayout_placeholder_content) {
                    this.f4490a = typedArrayObtainStyledAttributes.getResourceId(index, this.f4490a);
                } else if (index == R.styleable.ConstraintLayout_placeholder_placeholder_emptyVisibility) {
                    this.f4492c = typedArrayObtainStyledAttributes.getInt(index, this.f4492c);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public void b(ConstraintLayout container) {
        if (this.f4491b == null) {
            return;
        }
        ConstraintLayout.b bVar = (ConstraintLayout.b) getLayoutParams();
        ConstraintLayout.b bVar2 = (ConstraintLayout.b) this.f4491b.getLayoutParams();
        bVar2.f4116v0.b2(0);
        ConstraintWidget.DimensionBehaviour dimensionBehaviourH = bVar.f4116v0.H();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
        if (dimensionBehaviourH != dimensionBehaviour) {
            bVar.f4116v0.c2(bVar2.f4116v0.m0());
        }
        if (bVar.f4116v0.j0() != dimensionBehaviour) {
            bVar.f4116v0.y1(bVar2.f4116v0.D());
        }
        bVar2.f4116v0.b2(8);
    }

    public void c(ConstraintLayout container) {
        if (this.f4490a == -1 && !isInEditMode()) {
            setVisibility(this.f4492c);
        }
        View viewFindViewById = container.findViewById(this.f4490a);
        this.f4491b = viewFindViewById;
        if (viewFindViewById != null) {
            ((ConstraintLayout.b) viewFindViewById.getLayoutParams()).f4092j0 = true;
            this.f4491b.setVisibility(0);
            setVisibility(0);
        }
    }

    public View getContent() {
        return this.f4491b;
    }

    public int getEmptyVisibility() {
        return this.f4492c;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(223, 223, 223);
            Paint paint = new Paint();
            paint.setARGB(255, ISchedulers.IS_M3U8_PEER, ISchedulers.IS_M3U8_PEER, ISchedulers.IS_M3U8_PEER);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize(rect.height());
            int iHeight = rect.height();
            int iWidth = rect.width();
            paint.setTextAlign(Paint.Align.LEFT);
            paint.getTextBounds("?", 0, 1, rect);
            canvas.drawText("?", ((iWidth / 2.0f) - (rect.width() / 2.0f)) - rect.left, ((iHeight / 2.0f) + (rect.height() / 2.0f)) - rect.bottom, paint);
        }
    }

    public void setContentId(int id2) {
        View viewFindViewById;
        if (this.f4490a == id2) {
            return;
        }
        View view = this.f4491b;
        if (view != null) {
            view.setVisibility(0);
            ((ConstraintLayout.b) this.f4491b.getLayoutParams()).f4092j0 = false;
            this.f4491b = null;
        }
        this.f4490a = id2;
        if (id2 == -1 || (viewFindViewById = ((View) getParent()).findViewById(id2)) == null) {
            return;
        }
        viewFindViewById.setVisibility(8);
    }

    public void setEmptyVisibility(int visibility) {
        this.f4492c = visibility;
    }

    public g(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f4490a = -1;
        this.f4491b = null;
        this.f4492c = 4;
        a(attrs);
    }

    public g(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.f4490a = -1;
        this.f4491b = null;
        this.f4492c = 4;
        a(attrs);
    }

    public g(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr);
        this.f4490a = -1;
        this.f4491b = null;
        this.f4492c = 4;
        a(attrs);
    }
}
