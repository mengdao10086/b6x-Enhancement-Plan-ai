package a;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class qi0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final qh0 f7214a = new qh0(null);
    public static final String b = "keyboard";
    public static final String c = "change";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f2571a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f2572a;

    public qi0(String str) {
        f92.d(str, "editSyncMode");
        this.f2571a = str;
    }

    public /* synthetic */ qi0(String str, int i, b92 b92Var) {
        this((i & 1) != 0 ? b : str);
    }

    public final void e(CompoundButton compoundButton, rh0<Boolean> rh0Var) {
        f92.d(compoundButton, "compoundButton");
        f92.d(rh0Var, "inputHandler");
        qc2.d(xd2.a(qe2.b()), null, null, new fi0(rh0Var, compoundButton, null), 3, null);
        compoundButton.setOnCheckedChangeListener(new gi0(rh0Var));
    }

    public final void f(EditText editText, rh0<String> rh0Var) {
        f92.d(editText, "editText");
        f92.d(rh0Var, "inputHandler");
        n92 n92Var = new n92();
        n92Var.f6891a = "";
        qc2.d(xd2.a(qe2.b()), null, null, new zh0(rh0Var, n92Var, editText, null), 3, null);
        editText.setOnEditorActionListener(new ai0(this, n92Var, rh0Var, editText));
        editText.setOnFocusChangeListener(new bi0(n92Var, rh0Var));
        if (f92.a(this.f2571a, c)) {
            editText.addTextChangedListener(new ci0(n92Var, rh0Var));
        } else {
            k(editText, new di0(editText, n92Var, rh0Var));
        }
    }

    public final void g(SeekBar seekBar, rh0<Integer> rh0Var, TextView textView, pz0 pz0Var) {
        f92.d(seekBar, "seekBar");
        f92.d(rh0Var, "inputHandler");
        f92.d(pz0Var, "item");
        ii0 ii0Var = new ii0(pz0Var);
        hi0 hi0Var = new hi0(pz0Var);
        qc2.d(xd2.a(qe2.b()), null, null, new wh0(rh0Var, textView, seekBar, pz0Var, null), 3, null);
        seekBar.setOnSeekBarChangeListener(new xh0(textView, ii0Var, rh0Var, hi0Var));
    }

    public final void h(Spinner spinner, rh0<Integer> rh0Var) {
        f92.d(spinner, "spinner");
        f92.d(rh0Var, "inputHandler");
        l92 l92Var = new l92();
        l92Var.f6687a = 0;
        qc2.d(xd2.a(qe2.b()), null, null, new vh0(rh0Var, l92Var, spinner, null), 3, null);
    }

    public final void i(EditText editText, rh0<Double> rh0Var) {
        f92.d(editText, "editText");
        f92.d(rh0Var, "inputHandler");
        j92 j92Var = new j92();
        j92Var.f6490a = 0.0d;
        qc2.d(xd2.a(qe2.b()), null, null, new ki0(rh0Var, j92Var, editText, null), 3, null);
        editText.setOnEditorActionListener(new li0(this, j92Var, rh0Var, editText));
        editText.setOnFocusChangeListener(new mi0(j92Var, rh0Var, editText));
        if (f92.a(this.f2571a, c)) {
            editText.addTextChangedListener(new ni0(j92Var, rh0Var, editText));
        } else {
            k(editText, new oi0(editText, j92Var, rh0Var));
        }
    }

    public final void j(EditText editText) {
        Object systemService = editText.getContext().getSystemService("input_method");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
        ((InputMethodManager) systemService).hideSoftInputFromWindow(editText.getWindowToken(), 0);
        editText.clearFocus();
    }

    public final void k(View view, v72<m42> v72Var) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(new pi0(this, view, v72Var));
    }
}
