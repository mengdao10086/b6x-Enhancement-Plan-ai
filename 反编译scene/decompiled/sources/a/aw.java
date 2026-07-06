package a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class aw extends Drawable implements by {
    public static final int b = iv.Widget_MaterialComponents_Badge;
    public static final int c = zu.badgeStyle;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f5646a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f144a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final cy f145a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final iz f146a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final zv f147a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Rect f148a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final WeakReference<Context> f149a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final float f150b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public WeakReference<View> f151b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final float f152c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public WeakReference<ViewGroup> f153c;
    public float d;
    public float e;
    public float f;
    public float g;
    public float h;

    public aw(Context context) {
        this.f149a = new WeakReference<>(context);
        dy.c(context);
        Resources resources = context.getResources();
        this.f148a = new Rect();
        this.f146a = new iz();
        this.f5646a = resources.getDimensionPixelSize(bv.mtrl_badge_radius);
        this.f152c = resources.getDimensionPixelSize(bv.mtrl_badge_long_text_horizontal_padding);
        this.f150b = resources.getDimensionPixelSize(bv.mtrl_badge_with_text_radius);
        cy cyVar = new cy(this);
        this.f145a = cyVar;
        cyVar.e().setTextAlign(Paint.Align.CENTER);
        this.f147a = new zv(context);
        t(iv.TextAppearance_MaterialComponents_Badge);
    }

    public static aw c(Context context) {
        return d(context, null, c, b);
    }

    public static aw d(Context context, AttributeSet attributeSet, int i, int i2) {
        aw awVar = new aw(context);
        awVar.k(context, attributeSet, i, i2);
        return awVar;
    }

    public static int l(Context context, TypedArray typedArray, int i) {
        return ny.a(context, typedArray, i).getDefaultColor();
    }

    @Override // a.by
    public void a() {
        invalidateSelf();
    }

    public final void b(Context context, Rect rect, View view) {
        float f;
        int i = this.f147a.h;
        this.e = (i == 8388691 || i == 8388693) ? rect.bottom - this.f147a.j : rect.top + this.f147a.j;
        if (i() <= 9) {
            f = !j() ? this.f5646a : this.f150b;
            this.f = f;
            this.h = f;
        } else {
            float f2 = this.f150b;
            this.f = f2;
            this.h = f2;
            f = (this.f145a.f(f()) / 2.0f) + this.f152c;
        }
        this.g = f;
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(j() ? bv.mtrl_badge_text_horizontal_edge_offset : bv.mtrl_badge_horizontal_edge_offset);
        int i2 = this.f147a.h;
        this.d = (i2 == 8388659 || i2 == 8388691 ? eh.y(view) != 0 : eh.y(view) == 0) ? ((rect.right + this.g) - dimensionPixelSize) - this.f147a.i : (rect.left - this.g) + dimensionPixelSize + this.f147a.i;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (getBounds().isEmpty() || getAlpha() == 0 || !isVisible()) {
            return;
        }
        this.f146a.draw(canvas);
        if (j()) {
            e(canvas);
        }
    }

    public final void e(Canvas canvas) {
        Rect rect = new Rect();
        String strF = f();
        this.f145a.e().getTextBounds(strF, 0, strF.length(), rect);
        canvas.drawText(strF, this.d, this.e + (rect.height() / 2), this.f145a.e());
    }

    public final String f() {
        if (i() <= this.f144a) {
            return Integer.toString(i());
        }
        Context context = this.f149a.get();
        return context == null ? "" : context.getString(hv.mtrl_exceed_max_badge_number_suffix, Integer.valueOf(this.f144a), "+");
    }

    public CharSequence g() {
        Context context;
        if (!isVisible()) {
            return null;
        }
        if (!j()) {
            return this.f147a.f3889a;
        }
        if (this.f147a.f <= 0 || (context = this.f149a.get()) == null) {
            return null;
        }
        return i() <= this.f144a ? context.getResources().getQuantityString(this.f147a.f, i(), Integer.valueOf(i())) : context.getString(this.f147a.g, Integer.valueOf(this.f144a));
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f147a.c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f148a.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f148a.width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public int h() {
        return this.f147a.e;
    }

    public int i() {
        if (j()) {
            return this.f147a.d;
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return false;
    }

    public boolean j() {
        return this.f147a.d != -1;
    }

    public final void k(Context context, AttributeSet attributeSet, int i, int i2) {
        TypedArray typedArrayH = dy.h(context, attributeSet, jv.Badge, i, i2, new int[0]);
        q(typedArrayH.getInt(jv.Badge_maxCharacterCount, 4));
        if (typedArrayH.hasValue(jv.Badge_number)) {
            r(typedArrayH.getInt(jv.Badge_number, 0));
        }
        m(l(context, typedArrayH, jv.Badge_backgroundColor));
        if (typedArrayH.hasValue(jv.Badge_badgeTextColor)) {
            o(l(context, typedArrayH, jv.Badge_badgeTextColor));
        }
        n(typedArrayH.getInt(jv.Badge_badgeGravity, 8388661));
        p(typedArrayH.getDimensionPixelOffset(jv.Badge_horizontalOffset, 0));
        u(typedArrayH.getDimensionPixelOffset(jv.Badge_verticalOffset, 0));
        typedArrayH.recycle();
    }

    public void m(int i) {
        this.f147a.f8099a = i;
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(i);
        if (this.f146a.x() != colorStateListValueOf) {
            this.f146a.U(colorStateListValueOf);
            invalidateSelf();
        }
    }

    public void n(int i) {
        if (this.f147a.h != i) {
            this.f147a.h = i;
            WeakReference<View> weakReference = this.f151b;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            View view = this.f151b.get();
            WeakReference<ViewGroup> weakReference2 = this.f153c;
            v(view, weakReference2 != null ? weakReference2.get() : null);
        }
    }

    public void o(int i) {
        this.f147a.b = i;
        if (this.f145a.e().getColor() != i) {
            this.f145a.e().setColor(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable, a.by
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    public void p(int i) {
        this.f147a.i = i;
        w();
    }

    public void q(int i) {
        if (this.f147a.e != i) {
            this.f147a.e = i;
            x();
            this.f145a.i(true);
            w();
            invalidateSelf();
        }
    }

    public void r(int i) {
        int iMax = Math.max(0, i);
        if (this.f147a.d != iMax) {
            this.f147a.d = iMax;
            this.f145a.i(true);
            w();
            invalidateSelf();
        }
    }

    public final void s(qy qyVar) {
        Context context;
        if (this.f145a.d() == qyVar || (context = this.f149a.get()) == null) {
            return;
        }
        this.f145a.h(qyVar, context);
        w();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f147a.c = i;
        this.f145a.e().setAlpha(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public final void t(int i) {
        Context context = this.f149a.get();
        if (context == null) {
            return;
        }
        s(new qy(context, i));
    }

    public void u(int i) {
        this.f147a.j = i;
        w();
    }

    public void v(View view, ViewGroup viewGroup) {
        this.f151b = new WeakReference<>(view);
        this.f153c = new WeakReference<>(viewGroup);
        w();
        invalidateSelf();
    }

    public final void w() {
        Context context = this.f149a.get();
        WeakReference<View> weakReference = this.f151b;
        View view = weakReference != null ? weakReference.get() : null;
        if (context == null || view == null) {
            return;
        }
        Rect rect = new Rect();
        rect.set(this.f148a);
        Rect rect2 = new Rect();
        view.getDrawingRect(rect2);
        WeakReference<ViewGroup> weakReference2 = this.f153c;
        ViewGroup viewGroup = weakReference2 != null ? weakReference2.get() : null;
        if (viewGroup != null || bw.f5737a) {
            if (viewGroup == null) {
                viewGroup = (ViewGroup) view.getParent();
            }
            viewGroup.offsetDescendantRectToMyCoords(view, rect2);
        }
        b(context, rect2, view);
        bw.d(this.f148a, this.d, this.e, this.g, this.h);
        this.f146a.S(this.f);
        if (rect.equals(this.f148a)) {
            return;
        }
        this.f146a.setBounds(this.f148a);
    }

    public final void x() {
        this.f144a = ((int) Math.pow(10.0d, ((double) h()) - 1.0d)) - 1;
    }
}
