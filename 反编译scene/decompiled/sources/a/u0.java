package a;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.widget.ListView;
import androidx.appcompat.app.AlertController;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class u0 extends y1 implements DialogInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AlertController f7550a;

    public u0(Context context, int i) {
        super(context, f(context, i));
        this.f7550a = new AlertController(getContext(), this, getWindow());
    }

    public static int f(Context context, int i) {
        if (((i >>> 24) & 255) >= 1) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(t.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView e() {
        return this.f7550a.d();
    }

    @Override // a.y1, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f7550a.e();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.f7550a.g(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.f7550a.h(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // a.y1, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f7550a.q(charSequence);
    }
}
