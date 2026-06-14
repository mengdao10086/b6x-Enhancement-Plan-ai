package a;

import android.content.SharedPreferences;
import android.widget.CompoundButton;
import com.omarea.Scene;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class wk1 implements CompoundButton.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7799a;

    public wk1(int i) {
        this.f7799a = i;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        SharedPreferences.Editor editorEdit = Scene.f4798a.g().edit();
        (z ? editorEdit.putInt(hz0.f1282a.V(), this.f7799a) : editorEdit.remove(hz0.f1282a.V())).apply();
    }
}
