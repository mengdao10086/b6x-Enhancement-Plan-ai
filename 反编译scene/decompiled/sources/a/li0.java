package a;

import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class li0 implements TextView.OnEditorActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j92 f6710a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ qi0 f1804a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ rh0 f1805a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ EditText f1806a;

    public li0(qi0 qi0Var, j92 j92Var, rh0 rh0Var, EditText editText) {
        this.f1804a = qi0Var;
        this.f6710a = j92Var;
        this.f1805a = rh0Var;
        this.f1806a = editText;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        String string;
        CharSequence text;
        if (i != 3 && i != 6 && i != 5) {
            return false;
        }
        if (textView == null || (text = textView.getText()) == null || (string = text.toString()) == null) {
            string = "";
        }
        try {
            this.f6710a.f6490a = Double.parseDouble(string);
            this.f1805a.a(Double.valueOf(this.f6710a.f6490a));
            if (i != 3) {
                this.f1804a.j(this.f1806a);
            }
        } catch (Exception unused) {
            this.f1806a.setText(String.valueOf(this.f6710a.f6490a));
        }
        return true;
    }
}
