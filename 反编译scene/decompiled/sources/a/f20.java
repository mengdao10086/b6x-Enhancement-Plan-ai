package a;

import android.content.Context;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class f20 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f6066a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CheckableImageButton f837a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TextInputLayout f838a;

    public f20(TextInputLayout textInputLayout) {
        this.f838a = textInputLayout;
        this.f6066a = textInputLayout.getContext();
        this.f837a = textInputLayout.getEndIconView();
    }

    public abstract void a();

    public boolean b(int i) {
        return true;
    }

    public void c(boolean z) {
    }

    public boolean d() {
        return false;
    }
}
