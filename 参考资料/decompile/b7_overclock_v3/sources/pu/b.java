package pu;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.flydigi.base.R;
import j0.i;
import kotlin.jvm.internal.f0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes6.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public static final b f47064a = new b();

    public static /* synthetic */ c b(b bVar, Context context, AttributeSet attributeSet, c cVar, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            cVar = new c();
        }
        return bVar.a(context, attributeSet, cVar);
    }

    @k
    public final c a(@k Context context, @l AttributeSet attributeSet, @k c defaultStore) {
        f0.p(context, "context");
        f0.p(defaultStore, "defaultStore");
        if (attributeSet == null) {
            return defaultStore;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SuperButton);
        f0.o(typedArrayObtainStyledAttributes, "context.obtainStyledAttr… R.styleable.SuperButton)");
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i10);
            if (index == R.styleable.SuperButton_text) {
                defaultStore.q0(typedArrayObtainStyledAttributes.getText(index));
            }
            if (index == R.styleable.SuperButton_textColor) {
                defaultStore.r0(typedArrayObtainStyledAttributes.getColor(index, -7829368));
            }
            if (index == R.styleable.SuperButton_typeface) {
                defaultStore.t0(i.j(context, typedArrayObtainStyledAttributes.getResourceId(index, 0)));
            }
            if (index == R.styleable.SuperButton_hintText) {
                defaultStore.f0(typedArrayObtainStyledAttributes.getText(index));
            }
            if (index == R.styleable.SuperButton_hintTextColor) {
                defaultStore.g0(typedArrayObtainStyledAttributes.getColor(index, top.androidman.internal.c.f51479f));
            }
            if (index == R.styleable.SuperButton_textSize) {
                defaultStore.s0(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 54));
            }
            if (index == R.styleable.SuperButton_singleLine) {
                defaultStore.p0(typedArrayObtainStyledAttributes.getBoolean(index, true));
            }
            if (index == R.styleable.SuperButton_icon) {
                defaultStore.h0(typedArrayObtainStyledAttributes.getDrawable(index));
            }
            if (index == R.styleable.SuperButton_iconPadding) {
                defaultStore.m0(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, Integer.MAX_VALUE));
            }
            if (index == R.styleable.SuperButton_iconWidth) {
                defaultStore.n0(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, Integer.MAX_VALUE));
            }
            if (index == R.styleable.SuperButton_iconHeight) {
                defaultStore.l0(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, Integer.MAX_VALUE));
            }
            if (index == R.styleable.SuperButton_iconAuto) {
                defaultStore.j0(typedArrayObtainStyledAttributes.getBoolean(index, false));
            }
            if (index == R.styleable.SuperButton_iconOrientation) {
                defaultStore.i0(typedArrayObtainStyledAttributes.getInt(index, 4));
            }
            if (index == R.styleable.SuperButton_iconColor) {
                defaultStore.k0(typedArrayObtainStyledAttributes.getColor(index, -16777216));
            }
            if (index == R.styleable.SuperButton_maxLength) {
                defaultStore.o0(typedArrayObtainStyledAttributes.getInt(index, Integer.MAX_VALUE));
            }
            if (index == R.styleable.SuperButton_drawable_left) {
                defaultStore.h0(typedArrayObtainStyledAttributes.getDrawable(index));
                defaultStore.i0(4);
            }
            if (index == R.styleable.SuperButton_drawable_right) {
                defaultStore.h0(typedArrayObtainStyledAttributes.getDrawable(index));
                defaultStore.i0(3);
            }
            if (index == R.styleable.SuperButton_drawable_top) {
                defaultStore.h0(typedArrayObtainStyledAttributes.getDrawable(index));
                defaultStore.i0(1);
            }
            if (index == R.styleable.SuperButton_drawable_bottom) {
                defaultStore.h0(typedArrayObtainStyledAttributes.getDrawable(index));
                defaultStore.i0(2);
            }
            if (index == R.styleable.SuperButton_drawable_padding) {
                defaultStore.m0(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, Integer.MAX_VALUE));
            }
            if (index == R.styleable.SuperButton_drawable_auto) {
                defaultStore.j0(typedArrayObtainStyledAttributes.getBoolean(index, false));
            }
            if (index == R.styleable.SuperButton_drawable_middle) {
                defaultStore.h0(typedArrayObtainStyledAttributes.getDrawable(index));
            }
            if (index == R.styleable.SuperButton_drawable_middle_width) {
                defaultStore.n0(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, Integer.MAX_VALUE));
            }
            if (index == R.styleable.SuperButton_drawable_middle_height) {
                defaultStore.l0(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, Integer.MAX_VALUE));
            }
            if (index == R.styleable.SuperButton_drawable_center) {
                defaultStore.h0(typedArrayObtainStyledAttributes.getDrawable(index));
            }
            if (index == R.styleable.SuperButton_drawable_center_width) {
                defaultStore.n0(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, Integer.MAX_VALUE));
            }
            if (index == R.styleable.SuperButton_drawable_center_height) {
                defaultStore.l0(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, Integer.MAX_VALUE));
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        return defaultStore;
    }
}
