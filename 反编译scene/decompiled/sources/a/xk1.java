package a;

import android.content.Context;
import android.text.Editable;
import android.widget.EditText;
import android.widget.Toast;
import com.omarea.Scene;
import java.util.Locale;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class xk1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7900a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ yk1 f3598a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ EditText f3599a;

    public xk1(yk1 yk1Var, EditText editText, int i) {
        this.f3598a = yk1Var;
        this.f3599a = editText;
        this.f7900a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        h60 h60Var;
        Context context;
        Editable text = this.f3599a.getText();
        f92.c(text, "macInput.text");
        String strG = new nb2("-").g(ec2.r0(text), ":");
        Locale locale = Locale.ENGLISH;
        f92.c(locale, "Locale.ENGLISH");
        if (strG == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = strG.toLowerCase(locale);
        f92.c(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        if (!new nb2("[\\w\\d]{2}:[\\w\\d]{2}:[\\w\\d]{2}:[\\w\\d]{2}:[\\w\\d]{2}:[\\w\\d]{2}$", pb2.f7102a).f(lowerCase)) {
            Toast.makeText(this.f3598a.f7990a, this.f3598a.f7990a.getString(u61.dialog_mac_invalid), 1).show();
            return;
        }
        int i = 2131820545;
        if (this.f7900a != hz0.f1282a.W() && this.f7900a == hz0.f1282a.X()) {
            h60Var = h60.f6280a;
            context = this.f3598a.f7990a;
            i = 2131820546;
        } else {
            h60Var = h60.f6280a;
            context = this.f3598a.f7990a;
        }
        if (f92.a(s60.f7366a.a("mac=\"" + lowerCase + "\"\n" + h60Var.b(context, i)), "error")) {
            Toast.makeText(this.f3598a.f7990a, this.f3598a.f7990a.getString(u61.dialog_mac_modify_fail), 0).show();
        } else {
            Toast.makeText(this.f3598a.f7990a, this.f3598a.f7990a.getString(u61.dialog_mac_modify_ok), 0).show();
            Scene.f4798a.m(hz0.f1282a.U(), lowerCase);
        }
    }
}
