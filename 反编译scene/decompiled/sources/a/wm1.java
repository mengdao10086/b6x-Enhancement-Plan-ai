package a;

import android.widget.TextView;
import com.omarea.Scene;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class wm1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zm1 f7803a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ TextView f3457a;
    public final /* synthetic */ TextView b;

    public wm1(zm1 zm1Var, TextView textView, TextView textView2) {
        this.f7803a = zm1Var;
        this.f3457a = textView;
        this.b = textView2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String string;
        String string2;
        String string3;
        String string4;
        TextView textView = this.f3457a;
        f92.c(textView, "emailInput");
        CharSequence text = textView.getText();
        if (text == null || (string4 = text.toString()) == null) {
            string = null;
        } else {
            if (string4 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            string = ec2.r0(string4).toString();
        }
        TextView textView2 = this.b;
        f92.c(textView2, "passwordInput");
        CharSequence text2 = textView2.getText();
        if (text2 == null || (string3 = text2.toString()) == null) {
            string2 = null;
        } else {
            if (string3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            string2 = ec2.r0(string3).toString();
        }
        boolean z = true;
        if (!(string == null || string.length() == 0)) {
            if (string2 != null && string2.length() != 0) {
                z = false;
            }
            if (!z) {
                this.f7803a.i(string, string2);
                return;
            }
        }
        Scene.c cVar = Scene.f4798a;
        String string5 = this.f7803a.f3870a.getString(u61.user_please_uid);
        f92.c(string5, "context.getString(R.string.user_please_uid)");
        Scene.c.p(cVar, string5, 0, 2, null);
    }
}
