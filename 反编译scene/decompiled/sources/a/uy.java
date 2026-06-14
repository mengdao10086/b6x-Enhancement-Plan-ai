package a;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class uy extends Drawable.ConstantState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public iz f7641a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f3221a;

    public uy(iz izVar) {
        this.f7641a = izVar;
        this.f3221a = false;
    }

    public uy(uy uyVar) {
        this.f7641a = (iz) uyVar.f7641a.getConstantState().newDrawable();
        this.f3221a = uyVar.f3221a;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public vy newDrawable() {
        return new vy(new uy(this));
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        return 0;
    }
}
