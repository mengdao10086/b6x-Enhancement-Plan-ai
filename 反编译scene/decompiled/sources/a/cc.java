package a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class cc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5777a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ColorStateList f376a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Shader f377a;

    public cc(Shader shader, ColorStateList colorStateList, int i) {
        this.f377a = shader;
        this.f376a = colorStateList;
        this.f5777a = i;
    }

    public static cc a(Resources resources, int i, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        XmlResourceParser xml = resources.getXml(i);
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
        byte b = -1;
        int iHashCode = name.hashCode();
        if (iHashCode != 89650992) {
            if (iHashCode == 1191572447 && name.equals("selector")) {
                b = 0;
            }
        } else if (name.equals("gradient")) {
            b = 1;
        }
        if (b == 0) {
            return c(bc.b(resources, xml, attributeSetAsAttributeSet, theme));
        }
        if (b == 1) {
            return d(jc.b(resources, xml, attributeSetAsAttributeSet, theme));
        }
        throw new XmlPullParserException(xml.getPositionDescription() + ": unsupported complex color tag " + name);
    }

    public static cc b(int i) {
        return new cc(null, null, i);
    }

    public static cc c(ColorStateList colorStateList) {
        return new cc(null, colorStateList, colorStateList.getDefaultColor());
    }

    public static cc d(Shader shader) {
        return new cc(shader, null, 0);
    }

    public static cc g(Resources resources, int i, Resources.Theme theme) {
        try {
            return a(resources, i, theme);
        } catch (Exception e) {
            Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", e);
            return null;
        }
    }

    public int e() {
        return this.f5777a;
    }

    public Shader f() {
        return this.f377a;
    }

    public boolean h() {
        return this.f377a != null;
    }

    public boolean i() {
        ColorStateList colorStateList;
        return this.f377a == null && (colorStateList = this.f376a) != null && colorStateList.isStateful();
    }

    public boolean j(int[] iArr) {
        if (i()) {
            ColorStateList colorStateList = this.f376a;
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (colorForState != this.f5777a) {
                this.f5777a = colorForState;
                return true;
            }
        }
        return false;
    }

    public void k(int i) {
        this.f5777a = i;
    }

    public boolean l() {
        return h() || this.f5777a != 0;
    }
}
