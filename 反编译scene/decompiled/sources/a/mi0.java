package a;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class mi0 implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j92 f6811a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ rh0 f1931a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ EditText f1932a;

    public mi0(j92 j92Var, rh0 rh0Var, EditText editText) {
        this.f6811a = j92Var;
        this.f1931a = rh0Var;
        this.f1932a = editText;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z) {
        String string;
        if (view == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        }
        CharSequence text = ((TextView) view).getText();
        if (text == null || (string = text.toString()) == null) {
            string = "";
        }
        try {
            double d = Double.parseDouble(string);
            this.f6811a.f6490a = d;
            this.f1931a.a(Double.valueOf(d));
        } catch (Exception unused) {
            this.f1932a.setText(String.valueOf(this.f6811a.f6490a));
        }
    }
}
