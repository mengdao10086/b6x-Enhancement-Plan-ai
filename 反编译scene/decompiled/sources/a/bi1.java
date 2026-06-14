package a;

import android.app.Activity;
import android.text.Editable;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import com.omarea.Scene;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class bi1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ di1 f5708a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Activity f276a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ CheckBox f277a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ EditText f278a;
    public final /* synthetic */ EditText b;
    public final /* synthetic */ EditText c;

    public bi1(di1 di1Var, EditText editText, EditText editText2, EditText editText3, CheckBox checkBox, Activity activity) {
        this.f5708a = di1Var;
        this.f278a = editText;
        this.b = editText2;
        this.c = editText3;
        this.f277a = checkBox;
        this.f276a = activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Editable text = this.f278a.getText();
        f92.c(text, "dpiInput.text");
        int i = text.length() > 0 ? Integer.parseInt(this.f278a.getText().toString()) : 0;
        Editable text2 = this.b.getText();
        f92.c(text2, "widthInput.text");
        int i2 = text2.length() > 0 ? Integer.parseInt(this.b.getText().toString()) : 0;
        Editable text3 = this.c.getText();
        f92.c(text3, "heightInput.text");
        int i3 = text3.length() > 0 ? Integer.parseInt(this.c.getText().toString()) : 0;
        boolean zIsChecked = this.f277a.isChecked();
        StringBuilder sb = new StringBuilder();
        if (i2 >= 320 && i3 >= 480) {
            sb.append("wm size " + i2 + 'x' + i3);
            sb.append("\n");
        }
        if (i >= 96) {
            if (zIsChecked) {
                sb.append("wm density " + i);
                sb.append("\n");
            } else if (e60.m()) {
                s60.f7366a.a("wm density reset");
                e60.f698a.s("ro.sf.lcd_density", String.valueOf(i));
                e60.f698a.s("vendor.display.lcd_density", String.valueOf(i));
                Activity activity = this.f276a;
                Toast.makeText(activity, activity.getString(u61.dialog_addin_by_magisk), 0).show();
            } else {
                Scene.c cVar = Scene.f4798a;
                String string = this.f276a.getString(u61.magisk_uninstalled);
                f92.c(string, "context.getString(R.string.magisk_uninstalled)");
                Scene.c.p(cVar, string, 0, 2, null);
            }
        }
        if (sb.length() > 0) {
            s60 s60Var = s60.f7366a;
            String string2 = sb.toString();
            f92.c(string2, "cmd.toString()");
            s60Var.a(string2);
        }
        if (zIsChecked) {
            this.f5708a.g();
        }
    }
}
