package m;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class g extends e implements SubMenu {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final r0.d f40515p;

    public g(Context context, r0.d dVar) {
        super(context, dVar);
        this.f40515p = dVar;
    }

    @Override // android.view.SubMenu
    public void clearHeader() {
        this.f40515p.clearHeader();
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return e(this.f40515p.getItem());
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i10) {
        this.f40515p.setHeaderIcon(i10);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i10) {
        this.f40515p.setHeaderTitle(i10);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        this.f40515p.setHeaderView(view);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i10) {
        this.f40515p.setIcon(i10);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        this.f40515p.setHeaderIcon(drawable);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        this.f40515p.setHeaderTitle(charSequence);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.f40515p.setIcon(drawable);
        return this;
    }
}
