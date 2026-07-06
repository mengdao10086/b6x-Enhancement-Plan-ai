package a;

import android.view.View;
import android.widget.EditText;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class y80 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EditText f7957a;

    public y80(EditText editText) {
        this.f7957a = editText;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        EditText editText = this.f7957a;
        f92.c(editText, "searchBox");
        editText.setText((CharSequence) null);
    }
}
