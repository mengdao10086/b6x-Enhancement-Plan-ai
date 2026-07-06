package a;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class zf0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ag0 f8067a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ View f3839a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ EditText f3840a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ImageView f3841a;

    public zf0(ag0 ag0Var, EditText editText, ImageView imageView, View view) {
        this.f8067a = ag0Var;
        this.f3840a = editText;
        this.f3841a = imageView;
        this.f3839a = view;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ag0 ag0Var = this.f8067a;
        EditText editText = this.f3840a;
        f92.c(editText, "textView");
        ImageView imageView = this.f3841a;
        f92.c(imageView, "invalidView");
        View view2 = this.f3839a;
        f92.c(view2, "preview");
        ag0Var.e(editText, imageView, view2);
    }
}
