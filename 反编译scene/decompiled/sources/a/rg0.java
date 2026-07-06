package a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.omarea.krscript.model.ActionParamInfo;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class rg0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7297a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public cl f2735a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ActionParamInfo f2736a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Integer f2737a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList<n30> f2738a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f2739a;

    public rg0(ActionParamInfo actionParamInfo, cl clVar) {
        View decorView;
        f92.d(actionParamInfo, "actionParamInfo");
        f92.d(clVar, "context");
        this.f2736a = actionParamInfo;
        this.f2735a = clVar;
        Window window = clVar.getWindow();
        Integer numValueOf = (window == null || (decorView = window.getDecorView()) == null) ? null : Integer.valueOf(decorView.getSystemUiVisibility());
        this.f2737a = numValueOf;
        this.f2739a = numValueOf != null && (numValueOf.intValue() & 8192) == 0;
        ArrayList<n30> optionsFromShell = this.f2736a.getOptionsFromShell();
        f92.b(optionsFromShell);
        this.f2738a = optionsFromShell;
        this.f7297a = he0.f6306a.a(this.f2736a, optionsFromShell);
    }

    public final void c(TextView textView, TextView textView2) {
        boolean z = this.f2739a;
        ArrayList<n30> arrayList = this.f2738a;
        ArrayList arrayList2 = new ArrayList(z42.m(arrayList, 10));
        int i = 0;
        for (Object obj : arrayList) {
            int i2 = i + 1;
            if (i < 0) {
                y42.l();
                throw null;
            }
            n30 n30Var = new n30();
            n30Var.i(((n30) obj).d());
            n30Var.h(i == this.f7297a);
            arrayList2.add(n30Var);
            i = i2;
        }
        new b90(z, new ArrayList(arrayList2), false, new pg0(this, textView, textView2), 0, 16, null).B1(this.f2735a.getSupportFragmentManager(), "params-single-select");
    }

    public final View d() {
        if (this.f2738a.size() > 5) {
            View viewInflate = LayoutInflater.from(this.f2735a).inflate(nb0.kr_param_single_select, (ViewGroup) null);
            TextView textView = (TextView) viewInflate.findViewById(mb0.kr_param_single_select);
            TextView textView2 = (TextView) viewInflate.findViewById(mb0.kr_param_value);
            textView2.setTag(this.f2736a.getName());
            f92.c(textView2, "this");
            f92.c(textView, "textView");
            f(textView2, textView);
            textView.setOnClickListener(new qg0(this, textView2, textView));
            f92.c(viewInflate, "layout");
            return viewInflate;
        }
        View viewInflate2 = LayoutInflater.from(this.f2735a).inflate(nb0.kr_param_spinner, (ViewGroup) null);
        Spinner spinner = (Spinner) viewInflate2.findViewById(mb0.kr_param_spinner);
        spinner.setTag(this.f2736a.getName());
        ArrayAdapter arrayAdapter = new ArrayAdapter(spinner.getContext(), nb0.kr_spinner_default, mb0.text, this.f2738a);
        arrayAdapter.setDropDownViewResource(nb0.kr_spinner_dropdown);
        m42 m42Var = m42.f6769a;
        spinner.setAdapter((SpinnerAdapter) arrayAdapter);
        spinner.setEnabled(!this.f2736a.getReadonly());
        int i = this.f7297a;
        if (i > -1 && i < this.f2738a.size()) {
            spinner.setSelection(this.f7297a);
        }
        f92.c(viewInflate2, "layout");
        return viewInflate2;
    }

    public final void e(int i) {
        this.f7297a = i;
    }

    public final void f(TextView textView, TextView textView2) {
        int i = this.f7297a;
        if (i <= -1 || i >= this.f2738a.size()) {
            textView.setText("");
            textView2.setText("");
        } else {
            textView.setText(this.f2738a.get(this.f7297a).e());
            textView2.setText(this.f2738a.get(this.f7297a).d());
        }
    }
}
