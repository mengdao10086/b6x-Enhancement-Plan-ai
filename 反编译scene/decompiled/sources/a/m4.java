package a;

import android.content.Context;
import android.view.ActionProvider;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class m4 extends uf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r4 f6766a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ActionProvider f1887a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m4(r4 r4Var, Context context, ActionProvider actionProvider) {
        super(context);
        this.f6766a = r4Var;
        this.f1887a = actionProvider;
    }

    @Override // a.uf
    public boolean a() {
        return this.f1887a.hasSubMenu();
    }

    @Override // a.uf
    public View c() {
        return this.f1887a.onCreateActionView();
    }

    @Override // a.uf
    public boolean e() {
        return this.f1887a.onPerformDefaultAction();
    }

    @Override // a.uf
    public void f(SubMenu subMenu) {
        ActionProvider actionProvider = this.f1887a;
        this.f6766a.f(subMenu);
        actionProvider.onPrepareSubMenu(subMenu);
    }
}
