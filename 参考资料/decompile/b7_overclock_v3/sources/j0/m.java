package j0;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import g.e1;
import g.r;
import g.v0;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes2.dex */
public final class m {
    public static final void a(TypedArray typedArray, @e1 int i10) {
        if (!typedArray.hasValue(i10)) {
            throw new IllegalArgumentException("Attribute not defined in set.");
        }
    }

    public static final boolean b(@yt.k TypedArray typedArray, @e1 int i10) {
        f0.p(typedArray, "<this>");
        a(typedArray, i10);
        return typedArray.getBoolean(i10, false);
    }

    @g.l
    public static final int c(@yt.k TypedArray typedArray, @e1 int i10) {
        f0.p(typedArray, "<this>");
        a(typedArray, i10);
        return typedArray.getColor(i10, 0);
    }

    @yt.k
    public static final ColorStateList d(@yt.k TypedArray typedArray, @e1 int i10) {
        f0.p(typedArray, "<this>");
        a(typedArray, i10);
        ColorStateList colorStateList = typedArray.getColorStateList(i10);
        if (colorStateList != null) {
            return colorStateList;
        }
        throw new IllegalStateException("Attribute value was not a color or color state list.".toString());
    }

    public static final float e(@yt.k TypedArray typedArray, @e1 int i10) {
        f0.p(typedArray, "<this>");
        a(typedArray, i10);
        return typedArray.getDimension(i10, 0.0f);
    }

    @r
    public static final int f(@yt.k TypedArray typedArray, @e1 int i10) {
        f0.p(typedArray, "<this>");
        a(typedArray, i10);
        return typedArray.getDimensionPixelOffset(i10, 0);
    }

    @r
    public static final int g(@yt.k TypedArray typedArray, @e1 int i10) {
        f0.p(typedArray, "<this>");
        a(typedArray, i10);
        return typedArray.getDimensionPixelSize(i10, 0);
    }

    @yt.k
    public static final Drawable h(@yt.k TypedArray typedArray, @e1 int i10) {
        f0.p(typedArray, "<this>");
        a(typedArray, i10);
        Drawable drawable = typedArray.getDrawable(i10);
        f0.m(drawable);
        return drawable;
    }

    public static final float i(@yt.k TypedArray typedArray, @e1 int i10) {
        f0.p(typedArray, "<this>");
        a(typedArray, i10);
        return typedArray.getFloat(i10, 0.0f);
    }

    @yt.k
    @v0(26)
    public static final Typeface j(@yt.k TypedArray typedArray, @e1 int i10) {
        f0.p(typedArray, "<this>");
        a(typedArray, i10);
        return l.a(typedArray, i10);
    }

    public static final int k(@yt.k TypedArray typedArray, @e1 int i10) {
        f0.p(typedArray, "<this>");
        a(typedArray, i10);
        return typedArray.getInt(i10, 0);
    }

    public static final int l(@yt.k TypedArray typedArray, @e1 int i10) {
        f0.p(typedArray, "<this>");
        a(typedArray, i10);
        return typedArray.getInteger(i10, 0);
    }

    @g.c
    public static final int m(@yt.k TypedArray typedArray, @e1 int i10) {
        f0.p(typedArray, "<this>");
        a(typedArray, i10);
        return typedArray.getResourceId(i10, 0);
    }

    @yt.k
    public static final String n(@yt.k TypedArray typedArray, @e1 int i10) {
        f0.p(typedArray, "<this>");
        a(typedArray, i10);
        String string = typedArray.getString(i10);
        if (string != null) {
            return string;
        }
        throw new IllegalStateException("Attribute value could not be coerced to String.".toString());
    }

    @yt.k
    public static final CharSequence[] o(@yt.k TypedArray typedArray, @e1 int i10) {
        f0.p(typedArray, "<this>");
        a(typedArray, i10);
        CharSequence[] textArray = typedArray.getTextArray(i10);
        f0.o(textArray, "getTextArray(index)");
        return textArray;
    }

    @yt.k
    public static final CharSequence p(@yt.k TypedArray typedArray, @e1 int i10) {
        f0.p(typedArray, "<this>");
        a(typedArray, i10);
        CharSequence text = typedArray.getText(i10);
        if (text != null) {
            return text;
        }
        throw new IllegalStateException("Attribute value could not be coerced to CharSequence.".toString());
    }

    public static final <R> R q(@yt.k TypedArray typedArray, @yt.k ik.l<? super TypedArray, ? extends R> block) {
        f0.p(typedArray, "<this>");
        f0.p(block, "block");
        R rI = block.i(typedArray);
        typedArray.recycle();
        return rI;
    }
}
