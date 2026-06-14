package a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@SuppressLint({"RestrictedAPI"})
public class z2 extends g3 implements ld {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public u2 f8029a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public y2 f3789a;
    public int c;
    public int d;
    public boolean e;

    public z2() {
        this(null, null);
    }

    public z2(u2 u2Var, Resources resources) {
        super(null);
        this.c = -1;
        this.d = -1;
        h(new u2(u2Var, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }

    public static z2 l(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        String name = xmlPullParser.getName();
        if (name.equals("animated-selector")) {
            z2 z2Var = new z2();
            z2Var.m(context, resources, xmlPullParser, attributeSet, theme);
            return z2Var;
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + name);
    }

    @Override // a.g3, a.d3
    public void h(c3 c3Var) {
        super.h(c3Var);
        if (c3Var instanceof u2) {
            this.f8029a = (u2) c3Var;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // a.d3, android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        y2 y2Var = this.f3789a;
        if (y2Var != null) {
            y2Var.d();
            this.f3789a = null;
            g(this.c);
            this.c = -1;
            this.d = -1;
        }
    }

    @Override // a.d3
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public u2 b() {
        return new u2(this.f8029a, this, null);
    }

    public void m(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray typedArrayK = sc.k(resources, theme, attributeSet, i3.AnimatedStateListDrawableCompat);
        setVisible(typedArrayK.getBoolean(i3.AnimatedStateListDrawableCompat_android_visible, true), true);
        s(typedArrayK);
        i(resources);
        typedArrayK.recycle();
        n(context, resources, xmlPullParser, attributeSet, theme);
        o();
    }

    @Override // a.g3, a.d3, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.e) {
            super.mutate();
            if (this == this) {
                this.f8029a.r();
                this.e = true;
            }
        }
        return this;
    }

    public final void n(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next == 3) {
                return;
            }
            if (next == 2 && depth2 <= depth) {
                if (xmlPullParser.getName().equals("item")) {
                    p(context, resources, xmlPullParser, attributeSet, theme);
                } else if (xmlPullParser.getName().equals("transition")) {
                    q(context, resources, xmlPullParser, attributeSet, theme);
                }
            }
        }
    }

    public final void o() {
        onStateChange(getState());
    }

    @Override // a.g3, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        int iF = this.f8029a.F(iArr);
        boolean z = iF != c() && (r(iF) || g(iF));
        Drawable current = getCurrent();
        return current != null ? z | current.setState(iArr) : z;
    }

    public final int p(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray typedArrayK = sc.k(resources, theme, attributeSet, i3.AnimatedStateListDrawableItem);
        int resourceId = typedArrayK.getResourceId(i3.AnimatedStateListDrawableItem_android_id, 0);
        int resourceId2 = typedArrayK.getResourceId(i3.AnimatedStateListDrawableItem_android_drawable, -1);
        Drawable drawableJ = resourceId2 > 0 ? d8.h().j(context, resourceId2) : null;
        typedArrayK.recycle();
        int[] iArrJ = j(attributeSet);
        if (drawableJ == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
            drawableJ = xmlPullParser.getName().equals("vector") ? gu.c(resources, xmlPullParser, attributeSet, theme) : Build.VERSION.SDK_INT >= 21 ? Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme) : Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
        }
        if (drawableJ != null) {
            return this.f8029a.B(iArrJ, drawableJ, resourceId);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
    }

    public final int q(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray typedArrayK = sc.k(resources, theme, attributeSet, i3.AnimatedStateListDrawableTransition);
        int resourceId = typedArrayK.getResourceId(i3.AnimatedStateListDrawableTransition_android_fromId, -1);
        int resourceId2 = typedArrayK.getResourceId(i3.AnimatedStateListDrawableTransition_android_toId, -1);
        int resourceId3 = typedArrayK.getResourceId(i3.AnimatedStateListDrawableTransition_android_drawable, -1);
        Drawable drawableJ = resourceId3 > 0 ? d8.h().j(context, resourceId3) : null;
        boolean z = typedArrayK.getBoolean(i3.AnimatedStateListDrawableTransition_android_reversible, false);
        typedArrayK.recycle();
        if (drawableJ == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
            drawableJ = xmlPullParser.getName().equals("animated-vector") ? qt.a(context, resources, xmlPullParser, attributeSet, theme) : Build.VERSION.SDK_INT >= 21 ? Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme) : Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
        }
        if (drawableJ == null) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
        }
        if (resourceId != -1 && resourceId2 != -1) {
            return this.f8029a.C(resourceId, resourceId2, drawableJ, z);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires 'fromId' & 'toId' attributes");
    }

    public final boolean r(int i) {
        int iC;
        int iG;
        y2 t2Var;
        y2 y2Var = this.f3789a;
        if (y2Var == null) {
            iC = c();
        } else {
            if (i == this.c) {
                return true;
            }
            if (i == this.d && y2Var.a()) {
                y2Var.b();
                this.c = this.d;
                this.d = i;
                return true;
            }
            iC = this.c;
            y2Var.d();
        }
        this.f3789a = null;
        this.d = -1;
        this.c = -1;
        u2 u2Var = this.f8029a;
        int iE = u2Var.E(iC);
        int iE2 = u2Var.E(i);
        if (iE2 == 0 || iE == 0 || (iG = u2Var.G(iE, iE2)) < 0) {
            return false;
        }
        boolean zI = u2Var.I(iE, iE2);
        g(iG);
        Object current = getCurrent();
        if (current instanceof AnimationDrawable) {
            t2Var = new w2((AnimationDrawable) current, u2Var.H(iE, iE2), zI);
        } else {
            if (!(current instanceof qt)) {
                if (current instanceof Animatable) {
                    t2Var = new t2((Animatable) current);
                }
                return false;
            }
            t2Var = new v2((qt) current);
        }
        t2Var.c();
        this.f3789a = t2Var;
        this.d = iC;
        this.c = i;
        return true;
    }

    public final void s(TypedArray typedArray) {
        u2 u2Var = this.f8029a;
        if (Build.VERSION.SDK_INT >= 21) {
            ((c3) u2Var).b |= typedArray.getChangingConfigurations();
        }
        u2Var.x(typedArray.getBoolean(i3.AnimatedStateListDrawableCompat_android_variablePadding, ((c3) u2Var).f333a));
        u2Var.t(typedArray.getBoolean(i3.AnimatedStateListDrawableCompat_android_constantSize, ((c3) u2Var).f336c));
        u2Var.u(typedArray.getInt(i3.AnimatedStateListDrawableCompat_android_enterFadeDuration, ((c3) u2Var).k));
        u2Var.v(typedArray.getInt(i3.AnimatedStateListDrawableCompat_android_exitFadeDuration, ((c3) u2Var).l));
        setDither(typedArray.getBoolean(i3.AnimatedStateListDrawableCompat_android_dither, ((c3) u2Var).f343j));
    }

    @Override // a.d3, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (this.f3789a != null && (visible || z2)) {
            if (z) {
                this.f3789a.c();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }
}
