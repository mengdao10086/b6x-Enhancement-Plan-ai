package h0;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import g.d1;
import kotlin.z1;

/* JADX INFO: loaded from: classes2.dex */
public final class e {
    public static final /* synthetic */ <T> T a(Context context) {
        kotlin.jvm.internal.f0.p(context, "<this>");
        kotlin.jvm.internal.f0.y(4, i1.a.f31577d5);
        return (T) d.o(context, Object.class);
    }

    public static final void b(@yt.k Context context, @d1 int i10, @yt.k int[] attrs, @yt.k ik.l<? super TypedArray, z1> block) {
        kotlin.jvm.internal.f0.p(context, "<this>");
        kotlin.jvm.internal.f0.p(attrs, "attrs");
        kotlin.jvm.internal.f0.p(block, "block");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i10, attrs);
        kotlin.jvm.internal.f0.o(typedArrayObtainStyledAttributes, "obtainStyledAttributes(resourceId, attrs)");
        block.i(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
    }

    public static final void c(@yt.k Context context, @yt.l AttributeSet attributeSet, @yt.k int[] attrs, @g.f int i10, @d1 int i11, @yt.k ik.l<? super TypedArray, z1> block) {
        kotlin.jvm.internal.f0.p(context, "<this>");
        kotlin.jvm.internal.f0.p(attrs, "attrs");
        kotlin.jvm.internal.f0.p(block, "block");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, attrs, i10, i11);
        kotlin.jvm.internal.f0.o(typedArrayObtainStyledAttributes, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        block.i(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
    }

    public static /* synthetic */ void d(Context context, AttributeSet attributeSet, int[] attrs, int i10, int i11, ik.l block, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            attributeSet = null;
        }
        if ((i12 & 4) != 0) {
            i10 = 0;
        }
        if ((i12 & 8) != 0) {
            i11 = 0;
        }
        kotlin.jvm.internal.f0.p(context, "<this>");
        kotlin.jvm.internal.f0.p(attrs, "attrs");
        kotlin.jvm.internal.f0.p(block, "block");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, attrs, i10, i11);
        kotlin.jvm.internal.f0.o(typedArrayObtainStyledAttributes, "obtainStyledAttributes(s…efStyleAttr, defStyleRes)");
        block.i(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
    }
}
