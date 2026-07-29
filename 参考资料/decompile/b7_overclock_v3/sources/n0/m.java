package n0;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends Drawable.ConstantState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f41744a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Drawable.ConstantState f41745b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ColorStateList f41746c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PorterDuff.Mode f41747d;

    public m(@p0 m mVar) {
        this.f41746c = null;
        this.f41747d = k.f41735g;
        if (mVar != null) {
            this.f41744a = mVar.f41744a;
            this.f41745b = mVar.f41745b;
            this.f41746c = mVar.f41746c;
            this.f41747d = mVar.f41747d;
        }
    }

    public boolean a() {
        return this.f41745b != null;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        int i10 = this.f41744a;
        Drawable.ConstantState constantState = this.f41745b;
        return i10 | (constantState != null ? constantState.getChangingConfigurations() : 0);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    @n0
    public Drawable newDrawable() {
        return newDrawable(null);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    @n0
    public Drawable newDrawable(@p0 Resources resources) {
        return new l(this, resources);
    }
}
