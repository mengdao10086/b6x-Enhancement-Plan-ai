package a;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ni0 implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j92 f6921a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ rh0 f2096a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ EditText f2097a;

    public ni0(j92 j92Var, rh0 rh0Var, EditText editText) {
        this.f6921a = j92Var;
        this.f2096a = rh0Var;
        this.f2097a = editText;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        String string;
        if (editable == null || (string = editable.toString()) == null) {
            string = "";
        }
        try {
            double d = Double.parseDouble(string);
            this.f6921a.f6490a = d;
            this.f2096a.a(Double.valueOf(d));
        } catch (Exception unused) {
            this.f2097a.setText(String.valueOf(this.f6921a.f6490a));
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
