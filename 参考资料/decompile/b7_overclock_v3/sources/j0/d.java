package j0;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Xml;
import androidx.annotation.RestrictTo;
import g.n0;
import g.p0;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f35963d = "ComplexColorCompat";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Shader f35964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ColorStateList f35965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f35966c;

    public d(Shader shader, ColorStateList colorStateList, @g.l int i10) {
        this.f35964a = shader;
        this.f35965b = colorStateList;
        this.f35966c = i10;
    }

    @n0
    public static d a(@n0 Resources resources, @g.n int i10, @p0 Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        XmlResourceParser xml = resources.getXml(i10);
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
        do {
            next = xml.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        String name = xml.getName();
        name.hashCode();
        if (name.equals("gradient")) {
            return d(g.c(resources, xml, attributeSetAsAttributeSet, theme));
        }
        if (name.equals("selector")) {
            return c(c.b(resources, xml, attributeSetAsAttributeSet, theme));
        }
        throw new XmlPullParserException(xml.getPositionDescription() + ": unsupported complex color tag " + name);
    }

    public static d b(@g.l int i10) {
        return new d(null, null, i10);
    }

    public static d c(@n0 ColorStateList colorStateList) {
        return new d(null, colorStateList, colorStateList.getDefaultColor());
    }

    public static d d(@n0 Shader shader) {
        return new d(shader, null, 0);
    }

    @p0
    public static d g(@n0 Resources resources, @g.n int i10, @p0 Resources.Theme theme) {
        try {
            return a(resources, i10, theme);
        } catch (Exception unused) {
            return null;
        }
    }

    @g.l
    public int e() {
        return this.f35966c;
    }

    @p0
    public Shader f() {
        return this.f35964a;
    }

    public boolean h() {
        return this.f35964a != null;
    }

    public boolean i() {
        ColorStateList colorStateList;
        return this.f35964a == null && (colorStateList = this.f35965b) != null && colorStateList.isStateful();
    }

    public boolean j(int[] iArr) {
        if (i()) {
            ColorStateList colorStateList = this.f35965b;
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (colorForState != this.f35966c) {
                this.f35966c = colorForState;
                return true;
            }
        }
        return false;
    }

    public void k(@g.l int i10) {
        this.f35966c = i10;
    }

    public boolean l() {
        return h() || this.f35966c != 0;
    }
}
