package a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class pd extends Drawable.ConstantState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7105a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ColorStateList f2417a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public PorterDuff.Mode f2418a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Drawable.ConstantState f2419a;

    public pd(pd pdVar) {
        this.f2417a = null;
        this.f2418a = nd.b;
        if (pdVar != null) {
            this.f7105a = pdVar.f7105a;
            this.f2419a = pdVar.f2419a;
            this.f2417a = pdVar.f2417a;
            this.f2418a = pdVar.f2418a;
        }
    }

    public boolean a() {
        return this.f2419a != null;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        int i = this.f7105a;
        Drawable.ConstantState constantState = this.f2419a;
        return i | (constantState != null ? constantState.getChangingConfigurations() : 0);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable() {
        return newDrawable(null);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources) {
        return Build.VERSION.SDK_INT >= 21 ? new od(this, resources) : new nd(this, resources);
    }
}
