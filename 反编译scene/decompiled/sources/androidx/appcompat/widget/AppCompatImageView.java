package androidx.appcompat.widget;

import a.k8;
import a.l8;
import a.p5;
import a.qg;
import a.rj;
import a.z5;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class AppCompatImageView extends ImageView implements qg, rj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p5 f8154a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final z5 f4057a;

    public AppCompatImageView(Context context) {
        this(context, null);
    }

    public AppCompatImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppCompatImageView(Context context, AttributeSet attributeSet, int i) {
        super(l8.b(context), attributeSet, i);
        k8.a(this, getContext());
        p5 p5Var = new p5(this);
        this.f8154a = p5Var;
        p5Var.e(attributeSet, i);
        z5 z5Var = new z5(this);
        this.f4057a = z5Var;
        z5Var.f(attributeSet, i);
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        p5 p5Var = this.f8154a;
        if (p5Var != null) {
            p5Var.b();
        }
        z5 z5Var = this.f4057a;
        if (z5Var != null) {
            z5Var.b();
        }
    }

    @Override // a.qg
    public ColorStateList getSupportBackgroundTintList() {
        p5 p5Var = this.f8154a;
        if (p5Var != null) {
            return p5Var.c();
        }
        return null;
    }

    @Override // a.qg
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        p5 p5Var = this.f8154a;
        if (p5Var != null) {
            return p5Var.d();
        }
        return null;
    }

    @Override // a.rj
    public ColorStateList getSupportImageTintList() {
        z5 z5Var = this.f4057a;
        if (z5Var != null) {
            return z5Var.c();
        }
        return null;
    }

    @Override // a.rj
    public PorterDuff.Mode getSupportImageTintMode() {
        z5 z5Var = this.f4057a;
        if (z5Var != null) {
            return z5Var.d();
        }
        return null;
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        return this.f4057a.e() && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        p5 p5Var = this.f8154a;
        if (p5Var != null) {
            p5Var.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        p5 p5Var = this.f8154a;
        if (p5Var != null) {
            p5Var.g(i);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        z5 z5Var = this.f4057a;
        if (z5Var != null) {
            z5Var.b();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        z5 z5Var = this.f4057a;
        if (z5Var != null) {
            z5Var.b();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        z5 z5Var = this.f4057a;
        if (z5Var != null) {
            z5Var.g(i);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        z5 z5Var = this.f4057a;
        if (z5Var != null) {
            z5Var.b();
        }
    }

    @Override // a.qg
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        p5 p5Var = this.f8154a;
        if (p5Var != null) {
            p5Var.i(colorStateList);
        }
    }

    @Override // a.qg
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        p5 p5Var = this.f8154a;
        if (p5Var != null) {
            p5Var.j(mode);
        }
    }

    @Override // a.rj
    public void setSupportImageTintList(ColorStateList colorStateList) {
        z5 z5Var = this.f4057a;
        if (z5Var != null) {
            z5Var.h(colorStateList);
        }
    }

    @Override // a.rj
    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        z5 z5Var = this.f4057a;
        if (z5Var != null) {
            z5Var.i(mode);
        }
    }
}
