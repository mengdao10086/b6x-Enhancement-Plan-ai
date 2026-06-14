package a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class qt extends wt implements Animatable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ot f7236a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArgbEvaluator f2600a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f2601a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Drawable.Callback f2602a;

    public qt() {
        this(null, null, null);
    }

    public qt(Context context) {
        this(context, null, null);
    }

    public qt(Context context, ot otVar, Resources resources) {
        this.f2600a = null;
        this.f2602a = new nt(this);
        this.f2601a = context;
        if (otVar != null) {
            this.f7236a = otVar;
        } else {
            this.f7236a = new ot(context, otVar, this.f2602a, resources);
        }
    }

    public static qt a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        qt qtVar = new qt(context);
        qtVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return qtVar;
    }

    @Override // a.wt, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = ((wt) this).f7820a;
        if (drawable != null) {
            kd.a(drawable, theme);
        }
    }

    public final void b(String str, Animator animator) {
        animator.setTarget(this.f7236a.f2298a.d(str));
        if (Build.VERSION.SDK_INT < 21) {
            c(animator);
        }
        ot otVar = this.f7236a;
        if (otVar.f2300a == null) {
            otVar.f2300a = new ArrayList<>();
            this.f7236a.f2297a = new ba<>();
        }
        this.f7236a.f2300a.add(animator);
        this.f7236a.f2297a.put(animator, str);
    }

    public final void c(Animator animator) {
        ArrayList<Animator> childAnimations;
        if ((animator instanceof AnimatorSet) && (childAnimations = ((AnimatorSet) animator).getChildAnimations()) != null) {
            for (int i = 0; i < childAnimations.size(); i++) {
                c(childAnimations.get(i));
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.f2600a == null) {
                    this.f2600a = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.f2600a);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = ((wt) this).f7820a;
        if (drawable != null) {
            return kd.b(drawable);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = ((wt) this).f7820a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.f7236a.f2298a.draw(canvas);
        if (this.f7236a.f2299a.isStarted()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = ((wt) this).f7820a;
        return drawable != null ? kd.d(drawable) : this.f7236a.f2298a.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = ((wt) this).f7820a;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f7236a.f7053a;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = ((wt) this).f7820a;
        return drawable != null ? kd.e(drawable) : this.f7236a.f2298a.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (((wt) this).f7820a == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new pt(((wt) this).f7820a.getConstantState());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = ((wt) this).f7820a;
        return drawable != null ? drawable.getIntrinsicHeight() : this.f7236a.f2298a.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = ((wt) this).f7820a;
        return drawable != null ? drawable.getIntrinsicWidth() : this.f7236a.f2298a.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = ((wt) this).f7820a;
        return drawable != null ? drawable.getOpacity() : this.f7236a.f2298a.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        inflate(resources, xmlPullParser, attributeSet, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray typedArrayObtainAttributes;
        Drawable drawable = ((wt) this).f7820a;
        if (drawable != null) {
            kd.g(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    typedArrayObtainAttributes = sc.k(resources, theme, attributeSet, mt.e);
                    int resourceId = typedArrayObtainAttributes.getResourceId(0, 0);
                    if (resourceId != 0) {
                        gu guVarB = gu.b(resources, resourceId, theme);
                        guVarB.h(false);
                        guVarB.setCallback(this.f2602a);
                        gu guVar = this.f7236a.f2298a;
                        if (guVar != null) {
                            guVar.setCallback(null);
                        }
                        this.f7236a.f2298a = guVarB;
                    }
                } else if ("target".equals(name)) {
                    typedArrayObtainAttributes = resources.obtainAttributes(attributeSet, mt.f);
                    String string = typedArrayObtainAttributes.getString(0);
                    int resourceId2 = typedArrayObtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.f2601a;
                        if (context == null) {
                            typedArrayObtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                        b(string, tt.i(context, resourceId2));
                    }
                } else {
                    continue;
                }
                typedArrayObtainAttributes.recycle();
            }
            eventType = xmlPullParser.next();
        }
        this.f7236a.a();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = ((wt) this).f7820a;
        return drawable != null ? kd.h(drawable) : this.f7236a.f2298a.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        Drawable drawable = ((wt) this).f7820a;
        return drawable != null ? ((AnimatedVectorDrawable) drawable).isRunning() : this.f7236a.f2299a.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable drawable = ((wt) this).f7820a;
        return drawable != null ? drawable.isStateful() : this.f7236a.f2298a.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = ((wt) this).f7820a;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = ((wt) this).f7820a;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f7236a.f2298a.setBounds(rect);
        }
    }

    @Override // a.wt, android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        Drawable drawable = ((wt) this).f7820a;
        return drawable != null ? drawable.setLevel(i) : this.f7236a.f2298a.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = ((wt) this).f7820a;
        return drawable != null ? drawable.setState(iArr) : this.f7236a.f2298a.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Drawable drawable = ((wt) this).f7820a;
        if (drawable != null) {
            drawable.setAlpha(i);
        } else {
            this.f7236a.f2298a.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        Drawable drawable = ((wt) this).f7820a;
        if (drawable != null) {
            kd.j(drawable, z);
        } else {
            this.f7236a.f2298a.setAutoMirrored(z);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = ((wt) this).f7820a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f7236a.f2298a.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable, a.ld
    public void setTint(int i) {
        Drawable drawable = ((wt) this).f7820a;
        if (drawable != null) {
            kd.n(drawable, i);
        } else {
            this.f7236a.f2298a.setTint(i);
        }
    }

    @Override // android.graphics.drawable.Drawable, a.ld
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = ((wt) this).f7820a;
        if (drawable != null) {
            kd.o(drawable, colorStateList);
        } else {
            this.f7236a.f2298a.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable, a.ld
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = ((wt) this).f7820a;
        if (drawable != null) {
            kd.p(drawable, mode);
        } else {
            this.f7236a.f2298a.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = ((wt) this).f7820a;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        this.f7236a.f2298a.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable drawable = ((wt) this).f7820a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
        } else {
            if (this.f7236a.f2299a.isStarted()) {
                return;
            }
            this.f7236a.f2299a.start();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Drawable drawable = ((wt) this).f7820a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f7236a.f2299a.end();
        }
    }
}
