package a;

import android.content.Context;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class n4 extends m4 implements ActionProvider.VisibilityListener {
    public tf b;

    public n4(r4 r4Var, Context context, ActionProvider actionProvider) {
        super(r4Var, context, actionProvider);
    }

    @Override // a.uf
    public boolean b() {
        return ((m4) this).f1887a.isVisible();
    }

    @Override // a.uf
    public View d(MenuItem menuItem) {
        return ((m4) this).f1887a.onCreateActionView(menuItem);
    }

    @Override // a.uf
    public boolean g() {
        return ((m4) this).f1887a.overridesItemVisibility();
    }

    @Override // a.uf
    public void j(tf tfVar) {
        this.b = tfVar;
        ((m4) this).f1887a.setVisibilityListener(tfVar != null ? this : null);
    }

    @Override // android.view.ActionProvider.VisibilityListener
    public void onActionProviderVisibilityChanged(boolean z) {
        tf tfVar = this.b;
        if (tfVar != null) {
            tfVar.onActionProviderVisibilityChanged(z);
        }
    }
}
