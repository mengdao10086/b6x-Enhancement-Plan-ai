package a;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class i10 implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q10 f6365a;

    public i10(q10 q10Var) {
        this.f6365a = q10Var;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        this.f6365a.i((TextUtils.isEmpty(((EditText) view).getText()) ^ true) && z);
    }
}
