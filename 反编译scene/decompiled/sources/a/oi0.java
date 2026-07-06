package a;

import android.text.Editable;
import android.widget.EditText;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class oi0 extends g92 implements v72<m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j92 f7025a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ rh0 f2249a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ EditText f2250a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oi0(EditText editText, j92 j92Var, rh0 rh0Var) {
        super(0);
        this.f2250a = editText;
        this.f7025a = j92Var;
        this.f2249a = rh0Var;
    }

    public final void a() {
        String string;
        Editable text = this.f2250a.getText();
        if (text == null || (string = text.toString()) == null) {
            string = "";
        }
        try {
            double d = Double.parseDouble(string);
            this.f7025a.f6490a = d;
            this.f2249a.a(Double.valueOf(d));
        } catch (Exception unused) {
            this.f2250a.setText(String.valueOf(this.f7025a.f6490a));
        }
    }

    @Override // a.v72
    public /* bridge */ /* synthetic */ m42 i() {
        a();
        return m42.f6769a;
    }
}
