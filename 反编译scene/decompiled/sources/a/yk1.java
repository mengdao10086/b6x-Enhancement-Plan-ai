package a;

import a.p80;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import com.omarea.Scene;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class yk1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f7990a;

    public yk1(Context context) {
        f92.d(context, "context");
        this.f7990a = context;
    }

    public final void b(int i) {
        View viewInflate = LayoutInflater.from(this.f7990a).inflate(2131558494, (ViewGroup) null);
        View viewFindViewById = viewInflate.findViewById(t61.dialog_addin_mac_input);
        if (viewFindViewById == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.EditText");
        }
        EditText editText = (EditText) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(t61.dialog_addin_mac_autochange);
        if (viewFindViewById2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.CheckBox");
        }
        CheckBox checkBox = (CheckBox) viewFindViewById2;
        editText.setText(Scene.f4798a.h(hz0.f1282a.U(), "ec:d0:9f:af:95:01"));
        checkBox.setChecked(Integer.valueOf(Scene.f4798a.g().getInt(hz0.f1282a.V(), 0)).equals(Integer.valueOf(i)));
        checkBox.setOnCheckedChangeListener(new wk1(i));
        p80.a aVar = p80.f2403a;
        Context context = this.f7990a;
        String string = context.getString(u61.dialog_mac_custom);
        f92.c(string, "context.getString(R.string.dialog_mac_custom)");
        aVar.g(context, (32 & 2) != 0 ? "" : string, (32 & 4) == 0 ? "" : "", (32 & 8) != 0 ? null : viewInflate, (32 & 16) != 0 ? null : new xk1(this, editText, i), (32 & 32) == 0 ? null : null);
    }
}
