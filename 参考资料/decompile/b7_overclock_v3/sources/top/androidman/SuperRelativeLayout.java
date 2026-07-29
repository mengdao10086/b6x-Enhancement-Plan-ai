package top.androidman;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import hk.i;
import ik.a;
import kotlin.b0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.z;
import top.androidman.internal.superview.Plasterer;
import top.androidman.internal.superview.b;
import top.androidman.internal.superview.c;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes6.dex */
public final class SuperRelativeLayout extends RelativeLayout implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final z f51434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public final z f51435b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @i
    public SuperRelativeLayout(@k Context context) {
        this(context, null, 0, 6, null);
        f0.p(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @i
    public SuperRelativeLayout(@k Context context, @l AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        f0.p(context, "context");
    }

    public /* synthetic */ SuperRelativeLayout(Context context, AttributeSet attributeSet, int i10, int i11, u uVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    private final Plasterer getPlasterer() {
        return (Plasterer) this.f51435b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b getValueStore() {
        return (b) this.f51434a.getValue();
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

    @Override // top.androidman.internal.superview.c
    public void setLeftBottomCorner(float f10) {
        getPlasterer().t(f10).D();
    }

    @Override // top.androidman.internal.superview.c
    public void setLeftTopCorner(float f10) {
        getPlasterer().u(f10).D();
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

    @Override // top.androidman.internal.superview.c
    public void setViewClickable(boolean z10) {
        getPlasterer().C(z10).D();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @i
    public SuperRelativeLayout(@k final Context context, @l final AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        f0.p(context, "context");
        this.f51434a = b0.a(new a<b>() { // from class: top.androidman.SuperRelativeLayout$valueStore$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // ik.a
            @k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final b o() {
                return top.androidman.internal.superview.a.b(top.androidman.internal.superview.a.f51496a, context, attributeSet, null, 4, null);
            }
        });
        this.f51435b = b0.a(new a<Plasterer>() { // from class: top.androidman.SuperRelativeLayout$plasterer$2
            {
                super(0);
            }

            @Override // ik.a
            @k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Plasterer o() {
                SuperRelativeLayout superRelativeLayout = this.this$0;
                return new Plasterer(superRelativeLayout, superRelativeLayout.getValueStore());
            }
        });
        getPlasterer().D();
    }
}
