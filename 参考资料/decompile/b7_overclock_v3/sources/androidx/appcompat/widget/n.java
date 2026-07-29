package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;

/* JADX INFO: loaded from: classes2.dex */
public class n extends ImageButton implements androidx.core.view.r0, androidx.core.widget.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f2596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f2597b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f2598c;

    public n(@g.n0 Context context) {
        this(context, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f2596a;
        if (eVar != null) {
            eVar.b();
        }
        o oVar = this.f2597b;
        if (oVar != null) {
            oVar.c();
        }
    }

    @Override // androidx.core.view.r0
    @g.p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f2596a;
        if (eVar != null) {
            return eVar.c();
        }
        return null;
    }

    @Override // androidx.core.view.r0
    @g.p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f2596a;
        if (eVar != null) {
            return eVar.d();
        }
        return null;
    }

    @Override // androidx.core.widget.w
    @g.p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportImageTintList() {
        o oVar = this.f2597b;
        if (oVar != null) {
            return oVar.d();
        }
        return null;
    }

    @Override // androidx.core.widget.w
    @g.p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportImageTintMode() {
        o oVar = this.f2597b;
        if (oVar != null) {
            return oVar.e();
        }
        return null;
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        return this.f2597b.f() && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@g.p0 Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f2596a;
        if (eVar != null) {
            eVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(@g.v int i10) {
        super.setBackgroundResource(i10);
        e eVar = this.f2596a;
        if (eVar != null) {
            eVar.g(i10);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        o oVar = this.f2597b;
        if (oVar != null) {
            oVar.c();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(@g.p0 Drawable drawable) {
        o oVar = this.f2597b;
        if (oVar != null && drawable != null && !this.f2598c) {
            oVar.h(drawable);
        }
        super.setImageDrawable(drawable);
        o oVar2 = this.f2597b;
        if (oVar2 != null) {
            oVar2.c();
            if (this.f2598c) {
                return;
            }
            this.f2597b.b();
        }
    }

    @Override // android.widget.ImageView
    public void setImageLevel(int i10) {
        super.setImageLevel(i10);
        this.f2598c = true;
    }

    @Override // android.widget.ImageView
    public void setImageResource(@g.v int i10) {
        this.f2597b.i(i10);
    }

    @Override // android.widget.ImageView
    public void setImageURI(@g.p0 Uri uri) {
        super.setImageURI(uri);
        o oVar = this.f2597b;
        if (oVar != null) {
            oVar.c();
        }
    }

    @Override // androidx.core.view.r0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintList(@g.p0 ColorStateList colorStateList) {
        e eVar = this.f2596a;
        if (eVar != null) {
            eVar.i(colorStateList);
        }
    }

    @Override // androidx.core.view.r0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintMode(@g.p0 PorterDuff.Mode mode) {
        e eVar = this.f2596a;
        if (eVar != null) {
            eVar.j(mode);
        }
    }

    @Override // androidx.core.widget.w
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportImageTintList(@g.p0 ColorStateList colorStateList) {
        o oVar = this.f2597b;
        if (oVar != null) {
            oVar.k(colorStateList);
        }
    }

    @Override // androidx.core.widget.w
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setSupportImageTintMode(@g.p0 PorterDuff.Mode mode) {
        o oVar = this.f2597b;
        if (oVar != null) {
            oVar.l(mode);
        }
    }

    public n(@g.n0 Context context, @g.p0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.imageButtonStyle);
    }

    public n(@g.n0 Context context, @g.p0 AttributeSet attributeSet, int i10) {
        super(v0.b(context), attributeSet, i10);
        this.f2598c = false;
        t0.a(this, getContext());
        e eVar = new e(this);
        this.f2596a = eVar;
        eVar.e(attributeSet, i10);
        o oVar = new o(this);
        this.f2597b = oVar;
        oVar.g(attributeSet, i10);
    }
}
