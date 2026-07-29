package j;

import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.RestrictTo;
import g.n0;
import g.p0;
import g.u;
import g.v0;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class a {

    /* JADX INFO: renamed from: j.a$a, reason: collision with other inner class name */
    @v0(15)
    public static class C0404a {
        @u
        public static void a(@n0 Resources resources, int i10, int i11, @n0 TypedValue typedValue, boolean z10) {
            resources.getValueForDensity(i10, i11, typedValue, z10);
        }
    }

    @v0(18)
    public static class b {
        @u
        public static void a(@n0 ObjectAnimator objectAnimator, boolean z10) {
            objectAnimator.setAutoCancel(z10);
        }
    }

    @v0(21)
    public static class c {
        @u
        @n0
        public static Drawable a(@n0 Resources resources, @n0 XmlPullParser xmlPullParser, @n0 AttributeSet attributeSet, @p0 Resources.Theme theme) throws XmlPullParserException, IOException {
            return Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
        }

        @u
        public static int b(@n0 TypedArray typedArray) {
            return typedArray.getChangingConfigurations();
        }

        @u
        public static void c(@n0 Drawable drawable, @n0 Resources resources, @n0 XmlPullParser xmlPullParser, @n0 AttributeSet attributeSet, @p0 Resources.Theme theme) throws XmlPullParserException, IOException {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
        }
    }
}
