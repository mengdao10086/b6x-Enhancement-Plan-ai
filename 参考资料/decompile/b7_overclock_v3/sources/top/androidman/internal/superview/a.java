package top.androidman.internal.superview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.flydigi.base.R;
import kotlin.jvm.internal.f0;
import top.androidman.internal.g;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public static final a f51496a = new a();

    public static /* synthetic */ b b(a aVar, Context context, AttributeSet attributeSet, b bVar, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            bVar = new b();
        }
        return aVar.a(context, attributeSet, bVar);
    }

    @k
    public final b a(@k Context context, @l AttributeSet attributeSet, @k b defaultStore) {
        f0.p(context, "context");
        f0.p(defaultStore, "defaultStore");
        if (attributeSet == null) {
            return defaultStore;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SuperView);
        f0.o(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…s, R.styleable.SuperView)");
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i10);
            if (index == R.styleable.SuperView_background_normalColor) {
                defaultStore.x(typedArrayObtainStyledAttributes.getColor(index, Integer.MAX_VALUE));
            }
            if (index == R.styleable.SuperView_corner) {
                defaultStore.F(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, Integer.MAX_VALUE));
            }
            if (index == R.styleable.SuperView_corner_leftTop) {
                defaultStore.I(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, Integer.MAX_VALUE));
            }
            if (index == R.styleable.SuperView_corner_rightTop) {
                defaultStore.L(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, Integer.MAX_VALUE));
            }
            if (index == R.styleable.SuperView_corner_leftBottom) {
                defaultStore.H(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, Integer.MAX_VALUE));
            }
            if (index == R.styleable.SuperView_corner_rightBottom) {
                defaultStore.K(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, Integer.MAX_VALUE));
            }
            if (index == R.styleable.SuperView_shadow_startColor) {
                defaultStore.O(typedArrayObtainStyledAttributes.getColor(index, Integer.MAX_VALUE));
            }
            if (index == R.styleable.SuperView_shadow_endColor) {
                defaultStore.M(typedArrayObtainStyledAttributes.getColor(index, Integer.MAX_VALUE));
            }
            if (index == R.styleable.SuperView_shadow_size) {
                defaultStore.N(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, Integer.MAX_VALUE));
            }
            if (index == R.styleable.SuperView_border_width) {
                defaultStore.D(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, Integer.MAX_VALUE));
            }
            if (index == R.styleable.SuperView_border_dashWidth) {
                defaultStore.C(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, Integer.MAX_VALUE));
            }
            if (index == R.styleable.SuperView_border_dashGapWidth) {
                defaultStore.B(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, Integer.MAX_VALUE));
            }
            if (index == R.styleable.SuperView_border_color) {
                defaultStore.A(typedArrayObtainStyledAttributes.getColor(index, Integer.MAX_VALUE));
            }
            if (index == R.styleable.SuperView_shape) {
                defaultStore.P(typedArrayObtainStyledAttributes.getInt(index, 1));
            }
            if (index == R.styleable.SuperView_background_startColor) {
                defaultStore.z(typedArrayObtainStyledAttributes.getColor(index, Integer.MAX_VALUE));
            }
            if (index == R.styleable.SuperView_background_endColor) {
                defaultStore.w(typedArrayObtainStyledAttributes.getColor(index, Integer.MAX_VALUE));
            }
            if (index == R.styleable.SuperView_background_colorOrientation) {
                defaultStore.v(g.a(typedArrayObtainStyledAttributes.getInt(index, 7)));
            }
            if (index == R.styleable.SuperView_open_pressed_effect) {
                defaultStore.J(typedArrayObtainStyledAttributes.getBoolean(index, false));
            }
            if (index == R.styleable.SuperView_background_pressedColor) {
                defaultStore.y(typedArrayObtainStyledAttributes.getColor(index, Integer.MAX_VALUE));
            }
            if (index == R.styleable.SuperView_clickable) {
                defaultStore.E(typedArrayObtainStyledAttributes.getBoolean(index, true));
            }
            if (index == R.styleable.SuperView_disableColor) {
                defaultStore.G(typedArrayObtainStyledAttributes.getColor(index, Integer.MAX_VALUE));
            }
            if (index == R.styleable.SuperView_color_normal) {
                defaultStore.x(typedArrayObtainStyledAttributes.getColor(index, Integer.MAX_VALUE));
            }
            if (index == R.styleable.SuperView_color_pressed) {
                defaultStore.y(typedArrayObtainStyledAttributes.getColor(index, Integer.MAX_VALUE));
            }
            if (index == R.styleable.SuperView_color_start) {
                defaultStore.z(typedArrayObtainStyledAttributes.getColor(index, Integer.MAX_VALUE));
            }
            if (index == R.styleable.SuperView_color_end) {
                defaultStore.w(typedArrayObtainStyledAttributes.getColor(index, Integer.MAX_VALUE));
            }
            if (index == R.styleable.SuperView_color_direction) {
                defaultStore.v(g.a(typedArrayObtainStyledAttributes.getInt(index, 7)));
            }
            if (index == R.styleable.SuperView_corner_left_top) {
                defaultStore.I(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, Integer.MAX_VALUE));
            }
            if (index == R.styleable.SuperView_corner_right_top) {
                defaultStore.L(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, Integer.MAX_VALUE));
            }
            if (index == R.styleable.SuperView_corner_left_bottom) {
                defaultStore.H(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, Integer.MAX_VALUE));
            }
            if (index == R.styleable.SuperView_corner_right_bottom) {
                defaultStore.K(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, Integer.MAX_VALUE));
            }
            if (index == R.styleable.SuperView_color_shadow_start) {
                defaultStore.O(typedArrayObtainStyledAttributes.getColor(index, Integer.MAX_VALUE));
            }
            if (index == R.styleable.SuperView_color_shadow_end) {
                defaultStore.M(typedArrayObtainStyledAttributes.getColor(index, Integer.MAX_VALUE));
            }
            if (index == R.styleable.SuperView_button_click_able) {
                defaultStore.E(typedArrayObtainStyledAttributes.getBoolean(index, true));
            }
            if (index == R.styleable.SuperView_button_clickable) {
                defaultStore.E(typedArrayObtainStyledAttributes.getBoolean(index, true));
            }
            if (index == R.styleable.SuperView_close_default_pressed) {
                defaultStore.J(!typedArrayObtainStyledAttributes.getBoolean(index, true));
            }
            if (index == R.styleable.SuperView_color_default_pressed) {
                defaultStore.y(typedArrayObtainStyledAttributes.getColor(index, Integer.MAX_VALUE));
            }
            if (index == R.styleable.SuperView_border_dash_width) {
                defaultStore.C(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, Integer.MAX_VALUE));
            }
            if (index == R.styleable.SuperView_border_dash_gap) {
                defaultStore.B(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, Integer.MAX_VALUE));
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        return defaultStore;
    }
}
