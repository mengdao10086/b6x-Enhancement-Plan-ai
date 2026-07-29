package j0;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.annotation.RestrictTo;
import com.google.common.collect.LinkedHashMultimap;
import g.k1;
import g.n0;
import g.p0;
import g.x;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<TypedValue> f35962a = new ThreadLocal<>();

    @n0
    public static ColorStateList a(@n0 Resources resources, @n0 XmlPullParser xmlPullParser, @p0 Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xmlPullParser);
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return b(resources, xmlPullParser, attributeSetAsAttributeSet, theme);
        }
        throw new XmlPullParserException("No start tag found");
    }

    @n0
    public static ColorStateList b(@n0 Resources resources, @n0 XmlPullParser xmlPullParser, @n0 AttributeSet attributeSet, @p0 Resources.Theme theme) throws XmlPullParserException, IOException {
        String name = xmlPullParser.getName();
        if (name.equals("selector")) {
            return e(resources, xmlPullParser, attributeSet, theme);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
    }

    @n0
    public static TypedValue c() {
        ThreadLocal<TypedValue> threadLocal = f35962a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    @p0
    public static ColorStateList d(@n0 Resources resources, @k1 int i10, @p0 Resources.Theme theme) {
        try {
            return a(resources, resources.getXml(i10), theme);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0095  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.content.res.ColorStateList e(@g.n0 android.content.res.Resources r17, @g.n0 org.xmlpull.v1.XmlPullParser r18, @g.n0 android.util.AttributeSet r19, @g.p0 android.content.res.Resources.Theme r20) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j0.c.e(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):android.content.res.ColorStateList");
    }

    public static boolean f(@n0 Resources resources, @g.n int i10) {
        TypedValue typedValueC = c();
        resources.getValue(i10, typedValueC, true);
        int i11 = typedValueC.type;
        return i11 >= 28 && i11 <= 31;
    }

    @g.l
    public static int g(@g.l int i10, @x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f10, @x(from = 0.0d, to = m0.g.f40541b) float f11) {
        boolean z10 = f11 >= 0.0f && f11 <= 100.0f;
        if (f10 == 1.0f && !z10) {
            return i10;
        }
        int iE = t0.a.e((int) ((Color.alpha(i10) * f10) + 0.5f), 0, 255);
        if (z10) {
            a aVarC = a.c(i10);
            i10 = a.p(aVarC.j(), aVarC.i(), f11);
        }
        return (i10 & 16777215) | (iE << 24);
    }

    public static TypedArray h(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }
}
