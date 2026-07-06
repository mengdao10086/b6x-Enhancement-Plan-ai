package a;

import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.EditText;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class vh1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ di1 f7697a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Point f3285a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ DisplayMetrics f3286a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ EditText f3287a;
    public final /* synthetic */ EditText b;
    public final /* synthetic */ EditText c;

    public vh1(di1 di1Var, EditText editText, EditText editText2, EditText editText3, DisplayMetrics displayMetrics, Point point) {
        this.f7697a = di1Var;
        this.f3287a = editText;
        this.b = editText2;
        this.c = editText3;
        this.f3286a = displayMetrics;
        this.f3285a = point;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f3287a.setText(String.valueOf(720));
        this.b.setText(String.valueOf(this.f7697a.l(720)));
        this.c.setText(String.valueOf((int) ((this.f3286a.densityDpi * 720) / this.f3285a.x)));
    }
}
