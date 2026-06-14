package a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class pt extends Drawable.ConstantState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Drawable.ConstantState f7147a;

    public pt(Drawable.ConstantState constantState) {
        this.f7147a = constantState;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public boolean canApplyTheme() {
        return this.f7147a.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        return this.f7147a.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable() {
        qt qtVar = new qt();
        Drawable drawableNewDrawable = this.f7147a.newDrawable();
        ((wt) qtVar).f7820a = drawableNewDrawable;
        drawableNewDrawable.setCallback(qtVar.f2602a);
        return qtVar;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources) {
        qt qtVar = new qt();
        Drawable drawableNewDrawable = this.f7147a.newDrawable(resources);
        ((wt) qtVar).f7820a = drawableNewDrawable;
        drawableNewDrawable.setCallback(qtVar.f2602a);
        return qtVar;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources, Resources.Theme theme) {
        qt qtVar = new qt();
        Drawable drawableNewDrawable = this.f7147a.newDrawable(resources, theme);
        ((wt) qtVar).f7820a = drawableNewDrawable;
        drawableNewDrawable.setCallback(qtVar.f2602a);
        return qtVar;
    }
}
