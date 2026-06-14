package a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.omarea.krscript.model.ActionParamInfo;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class kg0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final cl f6602a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ActionParamInfo f1628a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<n30> f1629a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String[] f1630a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean[] f1631a;
    public String[] b;

    public kg0(ActionParamInfo actionParamInfo, cl clVar) {
        f92.d(actionParamInfo, "actionParamInfo");
        f92.d(clVar, "context");
        this.f1628a = actionParamInfo;
        this.f6602a = clVar;
        this.f1631a = new boolean[0];
        this.f1630a = new String[0];
        this.b = new String[0];
    }

    public final void d(TextView textView, TextView textView2, TextView textView3) {
        if (this.f1629a != null) {
            ArrayList arrayList = new ArrayList();
            int length = this.f1630a.length;
            for (int i = 0; i < length; i++) {
                n30 n30Var = new n30();
                n30Var.i("" + this.f1630a[i]);
                n30Var.h(this.f1631a[i]);
                m42 m42Var = m42.f6769a;
                arrayList.add(n30Var);
            }
            new b90(true, new ArrayList(arrayList), true, new ig0(this, textView, textView2, textView3), 0, 16, null).B1(this.f6602a.getSupportFragmentManager(), "params-multi-select");
        }
    }

    public final View e() {
        ArrayList<n30> optionsFromShell = this.f1628a.getOptionsFromShell();
        this.f1629a = optionsFromShell;
        if (optionsFromShell != null) {
            ArrayList arrayList = new ArrayList(z42.m(optionsFromShell, 10));
            Iterator<T> it = optionsFromShell.iterator();
            while (it.hasNext()) {
                CharSequence charSequenceD = ((n30) it.next()).d();
                arrayList.add(charSequenceD != null ? charSequenceD.toString() : null);
            }
            Object[] array = arrayList.toArray(new String[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            this.f1630a = (String[]) array;
            ArrayList arrayList2 = new ArrayList(z42.m(optionsFromShell, 10));
            Iterator<T> it2 = optionsFromShell.iterator();
            while (it2.hasNext()) {
                arrayList2.add(((n30) it2.next()).e());
            }
            Object[] array2 = arrayList2.toArray(new String[0]);
            if (array2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            this.b = (String[]) array2;
            this.f1631a = he0.f6306a.b(this.f1628a, optionsFromShell);
        }
        View viewInflate = LayoutInflater.from(this.f6602a).inflate(nb0.kr_param_multiple_select, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(mb0.kr_param_label_text);
        TextView textView2 = (TextView) viewInflate.findViewById(mb0.kr_param_value_text);
        TextView textView3 = (TextView) viewInflate.findViewById(mb0.kr_param_count_text);
        f92.c(textView2, "valueView");
        textView2.setTag(this.f1628a.getName());
        f92.c(textView, "textView");
        f92.c(textView3, "countView");
        f(textView, textView2, textView3);
        textView.setOnClickListener(new jg0(this, textView, textView2, textView3));
        f92.c(viewInflate, "layout");
        return viewInflate;
    }

    public final void f(TextView textView, TextView textView2, TextView textView3) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int length = this.f1631a.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.f1631a[i2]) {
                String str = this.b[i2];
                if (str != null) {
                    arrayList.add(str);
                }
                String str2 = this.f1630a[i2];
                if (str2 != null) {
                    arrayList2.add(str2);
                }
                i++;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(i52.H(arrayList, this.f1628a.getSeparator(), null, null, 0, null, null, 62, null));
        String string = sb.toString();
        textView.setText(arrayList2.size() > 0 ? "" + i52.H(arrayList2, "，", null, null, 0, null, null, 62, null) : "");
        textView2.setText(string);
        textView3.setText(String.valueOf(i));
    }
}
