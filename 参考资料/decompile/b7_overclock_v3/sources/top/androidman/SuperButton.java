package top.androidman;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import hk.i;
import kotlin.b0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.z;
import pu.a;
import pu.b;
import pu.d;
import top.androidman.internal.superview.c;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes6.dex */
public final class SuperButton extends LinearLayout implements c, a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final z f51427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public final z f51428b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @i
    public SuperButton(@k Context context) {
        this(context, null, 0, 6, null);
        f0.p(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @i
    public SuperButton(@k Context context, @l AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        f0.p(context, "context");
    }

    public /* synthetic */ SuperButton(Context context, AttributeSet attributeSet, int i10, int i11, u uVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    private final d getPlasterer() {
        return (d) this.f51428b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final pu.c getValueStore() {
        return (pu.c) this.f51427a.getValue();
    }

    @Override // pu.a
    public void a(int i10, int i11) {
        getPlasterer().N(i10, i11).D();
    }

    @Override // top.androidman.internal.superview.c
    public void b(int i10, int i11, float f10, float f11) {
        getPlasterer().l(i10, i11, f10, f11).D();
    }

    @Override // top.androidman.internal.superview.c
    public void f(int i10, int i11, int i12) {
        getPlasterer().A(i10, i11, i12).D();
    }

    @Override // top.androidman.internal.superview.c
    public void g(int i10, int i11, int i12) {
        getPlasterer().p(i10, i11, i12).D();
    }

    @k
    public final ImageView getIconView() {
        return getPlasterer().E();
    }

    @k
    public final TextView getTextView() {
        return getPlasterer().F();
    }

    @Override // top.androidman.internal.superview.c
    public void i(float f10, float f11) {
        getPlasterer().n(f10, f11).D();
    }

    @Override // top.androidman.internal.superview.c
    public void j(float f10, float f11, float f12, float f13) {
        getPlasterer().r(f10, f11, f12, f13).D();
    }

    @Override // top.androidman.internal.superview.c
    public void setBorderColor(int i10) {
        getPlasterer().m(i10).D();
    }

    @Override // top.androidman.internal.superview.c
    public void setBorderWidth(int i10) {
        getPlasterer().o(i10).D();
    }

    @Override // top.androidman.internal.superview.c
    public void setCorners(float f10) {
        getPlasterer().q(f10).D();
    }

    @Override // top.androidman.internal.superview.c
    public void setDisableColor(int i10) {
        getPlasterer().s(i10).D();
    }

    @Override // pu.a
    public void setHintText(@l CharSequence charSequence) {
        getPlasterer().G(charSequence).D();
    }

    @Override // pu.a
    public void setHintTextColor(int i10) {
        getPlasterer().H(i10).D();
    }

    @Override // pu.a
    public void setIcon(@l Drawable drawable) {
        getPlasterer().I(drawable).D();
    }

    @Override // pu.a
    public void setIconColor(int i10) {
        getPlasterer().J(i10).D();
    }

    @Override // pu.a
    public void setIconOrientation(int i10) {
        getPlasterer().K(i10).D();
    }

    @Override // pu.a
    public void setIconPadding(int i10) {
        getPlasterer().L(i10).D();
    }

    @Override // top.androidman.internal.superview.c
    public void setLeftBottomCorner(float f10) {
        getPlasterer().t(f10).D();
    }

    @Override // top.androidman.internal.superview.c
    public void setLeftTopCorner(float f10) {
        getPlasterer().u(f10).D();
    }

    @Override // pu.a
    public void setMaxLength(int i10) {
        getPlasterer().O(i10).D();
    }

    @Override // top.androidman.internal.superview.c
    public void setNormalColor(int i10) {
        getPlasterer().v(i10).D();
    }

    @Override // top.androidman.internal.superview.c
    public void setOpenPressedEffect(boolean z10) {
        getPlasterer().w(z10).D();
    }

    @Override // top.androidman.internal.superview.c
    public void setPressedColor(int i10) {
        getPlasterer().x(i10).D();
    }

    @Override // top.androidman.internal.superview.c
    public void setRightBottomCorner(float f10) {
        getPlasterer().y(f10).D();
    }

    @Override // top.androidman.internal.superview.c
    public void setRightTopCorner(float f10) {
        getPlasterer().z(f10).D();
    }

    @Override // top.androidman.internal.superview.c
    public void setShape(int i10) {
        getPlasterer().B(i10).D();
    }

    @Override // pu.a
    public void setSingleLine(boolean z10) {
        getPlasterer().P(z10).D();
    }

    @Override // pu.a
    public void setText(@l CharSequence charSequence) {
        getPlasterer().Q(charSequence).D();
    }

    @Override // pu.a
    public void setTextColor(int i10) {
        getPlasterer().R(i10).D();
    }

    @Override // pu.a
    public void setTextSize(int i10) {
        getPlasterer().S(i10).D();
    }

    @Override // pu.a
    public void setTypeface(@k Typeface typeface) {
        f0.p(typeface, "typeface");
        getPlasterer().U(typeface).D();
    }

    @Override // top.androidman.internal.superview.c
    public void setViewClickable(boolean z10) {
        getPlasterer().C(z10).D();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @i
    public SuperButton(@k final Context context, @l final AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        f0.p(context, "context");
        this.f51427a = b0.a(new ik.a<pu.c>() { // from class: top.androidman.SuperButton$valueStore$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // ik.a
            @k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final pu.c o() {
                pu.c cVar = new pu.c();
                top.androidman.internal.superview.a.f51496a.a(context, attributeSet, cVar);
                b.f47064a.a(context, attributeSet, cVar);
                return cVar;
            }
        });
        this.f51428b = b0.a(new ik.a<d>() { // from class: top.androidman.SuperButton$plasterer$2
            {
                super(0);
            }

            @Override // ik.a
            @k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final d o() {
                SuperButton superButton = this.this$0;
                return new d(superButton, superButton.getValueStore());
            }
        });
        getPlasterer().D();
    }
}
