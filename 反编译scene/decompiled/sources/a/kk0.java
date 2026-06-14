package a;

import android.text.method.LinkMovementMethod;
import android.widget.EditText;
import android.widget.TextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class kk0 {
    public static final void a(TextView textView, String str, v72<m42> v72Var) {
        f92.d(textView, "$this$addLink");
        f92.d(str, "text");
        f92.d(v72Var, "onClick");
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        CharSequence text = textView.getText();
        if (!(text == null || text.length() == 0)) {
            CharSequence text2 = textView.getText();
            f92.c(text2, "this.text");
            if (!ec2.E(text2, "\n", false, 2, null)) {
                textView.append("  ");
            }
        }
        textView.append(new w90().b(str, v72Var));
    }

    public static final void b(TextView textView, String str) {
        f92.d(textView, "$this$appendText");
        f92.d(str, "text");
        textView.post(new ik0(textView, str));
    }

    public static final void c(EditText editText, g82<? super String, m42> g82Var) {
        f92.d(editText, "$this$onChange");
        f92.d(g82Var, "callback");
        editText.addTextChangedListener(new jk0(g82Var));
    }
}
