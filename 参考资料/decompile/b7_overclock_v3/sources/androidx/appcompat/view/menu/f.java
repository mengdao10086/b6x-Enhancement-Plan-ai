package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.R;
import androidx.appcompat.app.e;
import androidx.appcompat.view.menu.j;
import g.n0;

/* JADX INFO: loaded from: classes2.dex */
public class f implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, j.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f1949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public androidx.appcompat.app.e f1950b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f1951c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public j.a f1952d;

    public f(e eVar) {
        this.f1949a = eVar;
    }

    public void a() {
        androidx.appcompat.app.e eVar = this.f1950b;
        if (eVar != null) {
            eVar.dismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.j.a
    public void b(@n0 e eVar, boolean z10) {
        if (z10 || eVar == this.f1949a) {
            a();
        }
        j.a aVar = this.f1952d;
        if (aVar != null) {
            aVar.b(eVar, z10);
        }
    }

    @Override // androidx.appcompat.view.menu.j.a
    public boolean c(@n0 e eVar) {
        j.a aVar = this.f1952d;
        if (aVar != null) {
            return aVar.c(eVar);
        }
        return false;
    }

    public void d(j.a aVar) {
        this.f1952d = aVar;
    }

    public void e(IBinder iBinder) {
        e eVar = this.f1949a;
        e.a aVar = new e.a(eVar.x());
        c cVar = new c(aVar.getContext(), R.layout.abc_list_menu_item_layout);
        this.f1951c = cVar;
        cVar.h(this);
        this.f1949a.b(this.f1951c);
        aVar.a(this.f1951c.a(), this);
        View viewB = eVar.B();
        if (viewB != null) {
            aVar.d(viewB);
        } else {
            aVar.f(eVar.z()).setTitle(eVar.A());
        }
        aVar.x(this);
        androidx.appcompat.app.e eVarCreate = aVar.create();
        this.f1950b = eVarCreate;
        eVarCreate.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.f1950b.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f1950b.show();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i10) {
        this.f1949a.O((h) this.f1951c.a().getItem(i10), 0);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f1951c.b(this.f1949a, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i10 == 82 || i10 == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f1950b.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f1950b.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f1949a.f(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f1949a.performShortcut(i10, keyEvent, 0);
    }
}
