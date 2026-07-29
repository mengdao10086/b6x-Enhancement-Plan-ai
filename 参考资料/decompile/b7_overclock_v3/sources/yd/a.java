package yd;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Xml;
import androidx.annotation.RestrictTo;
import g.k1;
import g.l;
import g.n0;
import g.p0;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import n0.c;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class a {
    @p0
    public static Drawable a(@p0 Drawable drawable, @p0 Drawable drawable2) {
        int intrinsicWidth;
        int intrinsicHeight;
        if (drawable == null) {
            return drawable2;
        }
        if (drawable2 == null) {
            return drawable;
        }
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{drawable, drawable2});
        if (drawable2.getIntrinsicWidth() == -1 || drawable2.getIntrinsicHeight() == -1) {
            intrinsicWidth = drawable.getIntrinsicWidth();
            intrinsicHeight = drawable.getIntrinsicHeight();
        } else if (drawable2.getIntrinsicWidth() > drawable.getIntrinsicWidth() || drawable2.getIntrinsicHeight() > drawable.getIntrinsicHeight()) {
            float intrinsicWidth2 = drawable2.getIntrinsicWidth() / drawable2.getIntrinsicHeight();
            if (intrinsicWidth2 >= drawable.getIntrinsicWidth() / drawable.getIntrinsicHeight()) {
                int intrinsicWidth3 = drawable.getIntrinsicWidth();
                int i10 = (int) (intrinsicWidth3 / intrinsicWidth2);
                intrinsicWidth = intrinsicWidth3;
                intrinsicHeight = i10;
            } else {
                intrinsicHeight = drawable.getIntrinsicHeight();
                intrinsicWidth = (int) (intrinsicWidth2 * intrinsicHeight);
            }
        } else {
            intrinsicWidth = drawable2.getIntrinsicWidth();
            intrinsicHeight = drawable2.getIntrinsicHeight();
        }
        if (Build.VERSION.SDK_INT >= 23) {
            layerDrawable.setLayerSize(1, intrinsicWidth, intrinsicHeight);
            layerDrawable.setLayerGravity(1, 17);
        } else {
            int intrinsicWidth4 = (drawable.getIntrinsicWidth() - intrinsicWidth) / 2;
            int intrinsicHeight2 = (drawable.getIntrinsicHeight() - intrinsicHeight) / 2;
            layerDrawable.setLayerInset(1, intrinsicWidth4, intrinsicHeight2, intrinsicWidth4, intrinsicHeight2);
        }
        return layerDrawable;
    }

    @p0
    public static Drawable b(@p0 Drawable drawable, @p0 ColorStateList colorStateList, @p0 PorterDuff.Mode mode) {
        return d(drawable, colorStateList, mode, false);
    }

    @p0
    public static Drawable c(@p0 Drawable drawable, @p0 ColorStateList colorStateList, @p0 PorterDuff.Mode mode) {
        return d(drawable, colorStateList, mode, Build.VERSION.SDK_INT < 23);
    }

    @p0
    public static Drawable d(@p0 Drawable drawable, @p0 ColorStateList colorStateList, @p0 PorterDuff.Mode mode, boolean z10) {
        if (drawable == null) {
            return null;
        }
        if (colorStateList != null) {
            drawable = c.r(drawable).mutate();
            if (mode != null) {
                c.p(drawable, mode);
            }
        } else if (z10) {
            drawable.mutate();
        }
        return drawable;
    }

    @n0
    public static int[] e(@n0 int[] iArr) {
        for (int i10 = 0; i10 < iArr.length; i10++) {
            if (iArr[i10] == 16842912) {
                return iArr;
            }
            if (iArr[i10] == 0) {
                int[] iArr2 = (int[]) iArr.clone();
                iArr2[i10] = 16842912;
                return iArr2;
            }
        }
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length + 1);
        iArrCopyOf[iArr.length] = 16842912;
        return iArrCopyOf;
    }

    @n0
    public static int[] f(@n0 int[] iArr) {
        int[] iArr2 = new int[iArr.length];
        int i10 = 0;
        for (int i11 : iArr) {
            if (i11 != 16842912) {
                iArr2[i10] = i11;
                i10++;
            }
        }
        return iArr2;
    }

    @n0
    public static AttributeSet g(@n0 Context context, @k1 int i10, @n0 CharSequence charSequence) {
        int next;
        try {
            XmlResourceParser xml = context.getResources().getXml(i10);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next != 2) {
                throw new XmlPullParserException("No start tag found");
            }
            if (TextUtils.equals(xml.getName(), charSequence)) {
                return Xml.asAttributeSet(xml);
            }
            throw new XmlPullParserException("Must have a <" + ((Object) charSequence) + "> start tag");
        } catch (IOException | XmlPullParserException e10) {
            Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load badge resource ID #0x" + Integer.toHexString(i10));
            notFoundException.initCause(e10);
            throw notFoundException;
        }
    }

    @TargetApi(21)
    public static void h(@p0 RippleDrawable rippleDrawable, int i10) {
        if (Build.VERSION.SDK_INT >= 23) {
            rippleDrawable.setRadius(i10);
            return;
        }
        try {
            RippleDrawable.class.getDeclaredMethod("setMaxRadius", Integer.TYPE).invoke(rippleDrawable, Integer.valueOf(i10));
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e10) {
            throw new IllegalStateException("Couldn't set RippleDrawable radius", e10);
        }
    }

    public static void i(@n0 Drawable drawable, @l int i10) {
        boolean z10 = i10 != 0;
        if (Build.VERSION.SDK_INT == 21) {
            if (z10) {
                drawable.setColorFilter(i10, PorterDuff.Mode.SRC_IN);
                return;
            } else {
                drawable.setColorFilter(null);
                return;
            }
        }
        if (z10) {
            c.n(drawable, i10);
        } else {
            c.o(drawable, null);
        }
    }

    @p0
    public static PorterDuffColorFilter j(@n0 Drawable drawable, @p0 ColorStateList colorStateList, @p0 PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(drawable.getState(), 0), mode);
    }
}
