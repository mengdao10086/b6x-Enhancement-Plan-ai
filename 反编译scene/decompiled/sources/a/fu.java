package a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class fu extends Drawable.ConstantState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Drawable.ConstantState f6139a;

    public fu(Drawable.ConstantState constantState) {
        this.f6139a = constantState;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public boolean canApplyTheme() {
        return this.f6139a.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        return this.f6139a.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable() {
        gu guVar = new gu();
        ((wt) guVar).f7820a = (VectorDrawable) this.f6139a.newDrawable();
        return guVar;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources) {
        gu guVar = new gu();
        ((wt) guVar).f7820a = (VectorDrawable) this.f6139a.newDrawable(resources);
        return guVar;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources, Resources.Theme theme) {
        gu guVar = new gu();
        ((wt) guVar).f7820a = (VectorDrawable) this.f6139a.newDrawable(resources, theme);
        return guVar;
    }
}
