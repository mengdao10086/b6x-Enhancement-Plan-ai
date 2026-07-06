package a;

import android.content.Context;
import android.content.res.Configuration;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.Window;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class h2 extends d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d7 f6265a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Window.Callback f1096a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f1100a;
    public boolean b;
    public boolean c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<e0> f1099a = new ArrayList<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Runnable f1098a = new c2(this);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Toolbar.f f1097a = new d2(this);

    public h2(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        this.f6265a = new s8(toolbar, false);
        g2 g2Var = new g2(this, callback);
        this.f1096a = g2Var;
        this.f6265a.setWindowCallback(g2Var);
        toolbar.setOnMenuItemClickListener(this.f1097a);
        this.f6265a.setWindowTitle(charSequence);
    }

    public void A(int i, int i2) {
        this.f6265a.l((i & i2) | ((~i2) & this.f6265a.t()));
    }

    @Override // a.d0
    public boolean g() {
        return this.f6265a.e();
    }

    @Override // a.d0
    public boolean h() {
        if (!this.f6265a.j()) {
            return false;
        }
        this.f6265a.p();
        return true;
    }

    @Override // a.d0
    public void i(boolean z) {
        if (z == this.c) {
            return;
        }
        this.c = z;
        int size = this.f1099a.size();
        for (int i = 0; i < size; i++) {
            this.f1099a.get(i).a(z);
        }
    }

    @Override // a.d0
    public int j() {
        return this.f6265a.t();
    }

    @Override // a.d0
    public Context k() {
        return this.f6265a.x();
    }

    @Override // a.d0
    public boolean l() {
        this.f6265a.z().removeCallbacks(this.f1098a);
        eh.c0(this.f6265a.z(), this.f1098a);
        return true;
    }

    @Override // a.d0
    public void m(Configuration configuration) {
        super.m(configuration);
    }

    @Override // a.d0
    public void n() {
        this.f6265a.z().removeCallbacks(this.f1098a);
    }

    @Override // a.d0
    public boolean o(int i, KeyEvent keyEvent) {
        Menu menuX = x();
        if (menuX == null) {
            return false;
        }
        menuX.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return menuX.performShortcut(i, keyEvent, 0);
    }

    @Override // a.d0
    public boolean p(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            q();
        }
        return true;
    }

    @Override // a.d0
    public boolean q() {
        return this.f6265a.f();
    }

    @Override // a.d0
    public void r(boolean z) {
    }

    @Override // a.d0
    public void s(boolean z) {
        A(z ? 4 : 0, 4);
    }

    @Override // a.d0
    public void t(boolean z) {
    }

    @Override // a.d0
    public void u(boolean z) {
    }

    @Override // a.d0
    public void v(CharSequence charSequence) {
        this.f6265a.setWindowTitle(charSequence);
    }

    public final Menu x() {
        if (!this.b) {
            this.f6265a.i(new e2(this), new f2(this));
            this.b = true;
        }
        return this.f6265a.m();
    }

    public Window.Callback y() {
        return this.f1096a;
    }

    public void z() {
        Menu menuX = x();
        i4 i4Var = menuX instanceof i4 ? (i4) menuX : null;
        if (i4Var != null) {
            i4Var.d0();
        }
        try {
            menuX.clear();
            if (!this.f1096a.onCreatePanelMenu(0, menuX) || !this.f1096a.onPreparePanel(0, null, menuX)) {
                menuX.clear();
            }
        } finally {
            if (i4Var != null) {
                i4Var.c0();
            }
        }
    }
}
