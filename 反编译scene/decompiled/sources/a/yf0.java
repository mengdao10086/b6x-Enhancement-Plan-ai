package a;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class yf0 implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ag0 f7978a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ View f3705a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ EditText f3706a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ImageView f3707a;

    public yf0(ag0 ag0Var, EditText editText, ImageView imageView, View view) {
        this.f7978a = ag0Var;
        this.f3706a = editText;
        this.f3707a = imageView;
        this.f3705a = view;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        ag0 ag0Var = this.f7978a;
        EditText editText = this.f3706a;
        f92.c(editText, "textView");
        ImageView imageView = this.f3707a;
        f92.c(imageView, "invalidView");
        View view = this.f3705a;
        f92.c(view, "preview");
        f92.b(editable);
        ag0Var.h(editText, imageView, view, editable.toString());
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
