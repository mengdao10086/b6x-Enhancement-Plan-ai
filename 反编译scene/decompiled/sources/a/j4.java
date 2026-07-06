package a;

import a.v4;
import android.content.DialogInterface;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class j4 implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, v4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g4 f6471a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public i4 f1499a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public u0 f1500a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public v4.a f1501a;

    public j4(i4 i4Var) {
        this.f1499a = i4Var;
    }

    public void a() {
        u0 u0Var = this.f1500a;
        if (u0Var != null) {
            u0Var.dismiss();
        }
    }

    @Override // a.v4.a
    public void b(i4 i4Var, boolean z) {
        if (z || i4Var == this.f1499a) {
            a();
        }
        v4.a aVar = this.f1501a;
        if (aVar != null) {
            aVar.b(i4Var, z);
        }
    }

    @Override // a.v4.a
    public boolean c(i4 i4Var) {
        v4.a aVar = this.f1501a;
        if (aVar != null) {
            return aVar.c(i4Var);
        }
        return false;
    }

    public void d(IBinder iBinder) {
        i4 i4Var = this.f1499a;
        t0 t0Var = new t0(i4Var.u());
        g4 g4Var = new g4(t0Var.b(), z.abc_list_menu_item_layout);
        this.f6471a = g4Var;
        g4Var.g(this);
        this.f1499a.b(this.f6471a);
        t0Var.c(this.f6471a.a(), this);
        View viewY = i4Var.y();
        if (viewY != null) {
            t0Var.d(viewY);
        } else {
            t0Var.e(i4Var.w());
            t0Var.h(i4Var.x());
        }
        t0Var.f(this);
        u0 u0VarA = t0Var.a();
        this.f1500a = u0VarA;
        u0VarA.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.f1500a.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f1500a.show();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1499a.L((l4) this.f6471a.a().getItem(i), 0);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f6471a.b(this.f1499a, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i == 82 || i == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f1500a.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f1500a.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f1499a.e(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f1499a.performShortcut(i, keyEvent, 0);
    }
}
