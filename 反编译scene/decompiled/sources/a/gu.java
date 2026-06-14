package a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayDeque;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class gu extends wt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PorterDuff.Mode f6243a = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public eu f1063a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ColorFilter f1064a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Matrix f1065a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public PorterDuffColorFilter f1066a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Rect f1067a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final float[] f1068a;
    public boolean b;
    public boolean c;

    public gu() {
        this.c = true;
        this.f1068a = new float[9];
        this.f1065a = new Matrix();
        this.f1067a = new Rect();
        this.f1063a = new eu();
    }

    public gu(eu euVar) {
        this.c = true;
        this.f1068a = new float[9];
        this.f1065a = new Matrix();
        this.f1067a = new Rect();
        this.f1063a = euVar;
        this.f1066a = j(this.f1066a, euVar.f794a, euVar.f797a);
    }

    public static int a(int i, float f) {
        return (i & 16777215) | (((int) (Color.alpha(i) * f)) << 24);
    }

    public static gu b(Resources resources, int i, Resources.Theme theme) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            gu guVar = new gu();
            ((wt) guVar).f7820a = rc.a(resources, i, theme);
            new fu(((wt) guVar).f7820a.getConstantState());
            return guVar;
        }
        try {
            XmlResourceParser xml = resources.getXml(i);
            AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return c(resources, xml, attributeSetAsAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (IOException | XmlPullParserException e) {
            Log.e("VectorDrawableCompat", "parser error", e);
            return null;
        }
    }

    public static gu c(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        gu guVar = new gu();
        guVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return guVar;
    }

    public static PorterDuff.Mode g(int i, PorterDuff.Mode mode) {
        if (i == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = ((wt) this).f7820a;
        if (drawable == null) {
            return false;
        }
        kd.b(drawable);
        return false;
    }

    public Object d(String str) {
        return this.f1063a.f793a.f603a.get(str);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = ((wt) this).f7820a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.f1067a);
        if (this.f1067a.width() <= 0 || this.f1067a.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.f1064a;
        if (colorFilter == null) {
            colorFilter = this.f1066a;
        }
        canvas.getMatrix(this.f1065a);
        this.f1065a.getValues(this.f1068a);
        float fAbs = Math.abs(this.f1068a[0]);
        float fAbs2 = Math.abs(this.f1068a[4]);
        float fAbs3 = Math.abs(this.f1068a[1]);
        float fAbs4 = Math.abs(this.f1068a[3]);
        if (fAbs3 != 0.0f || fAbs4 != 0.0f) {
            fAbs = 1.0f;
            fAbs2 = 1.0f;
        }
        int iMin = Math.min(2048, (int) (this.f1067a.width() * fAbs));
        int iMin2 = Math.min(2048, (int) (this.f1067a.height() * fAbs2));
        if (iMin <= 0 || iMin2 <= 0) {
            return;
        }
        int iSave = canvas.save();
        Rect rect = this.f1067a;
        canvas.translate(rect.left, rect.top);
        if (f()) {
            canvas.translate(this.f1067a.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        this.f1067a.offsetTo(0, 0);
        this.f1063a.c(iMin, iMin2);
        if (!this.c) {
            this.f1063a.j(iMin, iMin2);
        } else if (!this.f1063a.b()) {
            this.f1063a.j(iMin, iMin2);
            this.f1063a.i();
        }
        this.f1063a.d(canvas, colorFilter, this.f1067a);
        canvas.restoreToCount(iSave);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void e(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int i;
        int i2;
        cu cuVar;
        eu euVar = this.f1063a;
        du duVar = euVar.f793a;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(duVar.f602a);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                au auVar = (au) arrayDeque.peek();
                if ("path".equals(name)) {
                    zt ztVar = new zt();
                    ztVar.g(resources, attributeSet, theme, xmlPullParser);
                    auVar.f138a.add(ztVar);
                    if (ztVar.getPathName() != null) {
                        duVar.f603a.put(ztVar.getPathName(), ztVar);
                    }
                    z = false;
                    cuVar = ztVar;
                } else if ("clip-path".equals(name)) {
                    yt ytVar = new yt();
                    ytVar.e(resources, attributeSet, theme, xmlPullParser);
                    auVar.f138a.add(ytVar);
                    String pathName = ytVar.getPathName();
                    cuVar = ytVar;
                    if (pathName != null) {
                        duVar.f603a.put(ytVar.getPathName(), ytVar);
                        cuVar = ytVar;
                    }
                } else if ("group".equals(name)) {
                    au auVar2 = new au();
                    auVar2.c(resources, attributeSet, theme, xmlPullParser);
                    auVar.f138a.add(auVar2);
                    arrayDeque.push(auVar2);
                    if (auVar2.getGroupName() != null) {
                        duVar.f603a.put(auVar2.getGroupName(), auVar2);
                    }
                    i = euVar.f6041a;
                    i2 = auVar2.f135a;
                    euVar.f6041a = i2 | i;
                }
                i = euVar.f6041a;
                i2 = cuVar.b;
                euVar.f6041a = i2 | i;
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z) {
            throw new XmlPullParserException("no path defined");
        }
    }

    public final boolean f() {
        return Build.VERSION.SDK_INT >= 17 && isAutoMirrored() && kd.f(this) == 1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = ((wt) this).f7820a;
        return drawable != null ? kd.d(drawable) : this.f1063a.f793a.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = ((wt) this).f7820a;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f1063a.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = ((wt) this).f7820a;
        return drawable != null ? kd.e(drawable) : this.f1064a;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (((wt) this).f7820a != null && Build.VERSION.SDK_INT >= 24) {
            return new fu(((wt) this).f7820a.getConstantState());
        }
        this.f1063a.f6041a = getChangingConfigurations();
        return this.f1063a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = ((wt) this).f7820a;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.f1063a.f793a.f610b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = ((wt) this).f7820a;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.f1063a.f793a.f5937a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = ((wt) this).f7820a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    public void h(boolean z) {
        this.c = z;
    }

    public final void i(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException {
        eu euVar = this.f1063a;
        du duVar = euVar.f793a;
        euVar.f797a = g(sc.g(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList colorStateListC = sc.c(typedArray, xmlPullParser, theme, "tint", 1);
        if (colorStateListC != null) {
            euVar.f794a = colorStateListC;
        }
        euVar.f798a = sc.a(typedArray, xmlPullParser, "autoMirrored", 5, euVar.f798a);
        duVar.c = sc.f(typedArray, xmlPullParser, "viewportWidth", 7, duVar.c);
        float f = sc.f(typedArray, xmlPullParser, "viewportHeight", 8, duVar.d);
        duVar.d = f;
        if (duVar.c <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (f <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
        duVar.f5937a = typedArray.getDimension(3, duVar.f5937a);
        float dimension = typedArray.getDimension(2, duVar.f610b);
        duVar.f610b = dimension;
        if (duVar.f5937a <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
        }
        if (dimension <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
        }
        duVar.setAlpha(sc.f(typedArray, xmlPullParser, "alpha", 4, duVar.getAlpha()));
        String string = typedArray.getString(0);
        if (string != null) {
            duVar.f609a = string;
            duVar.f603a.put(string, duVar);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = ((wt) this).f7820a;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = ((wt) this).f7820a;
        if (drawable != null) {
            kd.g(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        eu euVar = this.f1063a;
        euVar.f793a = new du();
        TypedArray typedArrayK = sc.k(resources, theme, attributeSet, mt.f6840a);
        i(typedArrayK, xmlPullParser, theme);
        typedArrayK.recycle();
        euVar.f6041a = getChangingConfigurations();
        euVar.c = true;
        e(resources, xmlPullParser, attributeSet, theme);
        this.f1066a = j(this.f1066a, euVar.f794a, euVar.f797a);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable drawable = ((wt) this).f7820a;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = ((wt) this).f7820a;
        return drawable != null ? kd.h(drawable) : this.f1063a.f798a;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        eu euVar;
        ColorStateList colorStateList;
        Drawable drawable = ((wt) this).f7820a;
        return drawable != null ? drawable.isStateful() : super.isStateful() || ((euVar = this.f1063a) != null && (euVar.g() || ((colorStateList = this.f1063a.f794a) != null && colorStateList.isStateful())));
    }

    public PorterDuffColorFilter j(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = ((wt) this).f7820a;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.b && super.mutate() == this) {
            this.f1063a = new eu(this.f1063a);
            this.b = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = ((wt) this).f7820a;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        Drawable drawable = ((wt) this).f7820a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        boolean z = false;
        eu euVar = this.f1063a;
        ColorStateList colorStateList = euVar.f794a;
        if (colorStateList != null && (mode = euVar.f797a) != null) {
            this.f1066a = j(this.f1066a, colorStateList, mode);
            invalidateSelf();
            z = true;
        }
        if (!euVar.g() || !euVar.h(iArr)) {
            return z;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j) {
        Drawable drawable = ((wt) this).f7820a;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Drawable drawable = ((wt) this).f7820a;
        if (drawable != null) {
            drawable.setAlpha(i);
        } else if (this.f1063a.f793a.getRootAlpha() != i) {
            this.f1063a.f793a.setRootAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        Drawable drawable = ((wt) this).f7820a;
        if (drawable != null) {
            kd.j(drawable, z);
        } else {
            this.f1063a.f798a = z;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = ((wt) this).f7820a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f1064a = colorFilter;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable, a.ld
    public void setTint(int i) {
        Drawable drawable = ((wt) this).f7820a;
        if (drawable != null) {
            kd.n(drawable, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    @Override // android.graphics.drawable.Drawable, a.ld
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = ((wt) this).f7820a;
        if (drawable != null) {
            kd.o(drawable, colorStateList);
            return;
        }
        eu euVar = this.f1063a;
        if (euVar.f794a != colorStateList) {
            euVar.f794a = colorStateList;
            this.f1066a = j(this.f1066a, colorStateList, euVar.f797a);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable, a.ld
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = ((wt) this).f7820a;
        if (drawable != null) {
            kd.p(drawable, mode);
            return;
        }
        eu euVar = this.f1063a;
        if (euVar.f797a != mode) {
            euVar.f797a = mode;
            this.f1066a = j(this.f1066a, euVar.f794a, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = ((wt) this).f7820a;
        return drawable != null ? drawable.setVisible(z, z2) : super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = ((wt) this).f7820a;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }
}
