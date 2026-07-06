package a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import com.omarea.krscript.model.ActionParamInfo;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class uf0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f7591a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ActionParamInfo f3172a;

    public uf0(ActionParamInfo actionParamInfo, Context context) {
        f92.d(actionParamInfo, "actionParamInfo");
        f92.d(context, "context");
        this.f3172a = actionParamInfo;
        this.f7591a = context;
    }

    public final boolean a(ActionParamInfo actionParamInfo, boolean z) {
        if (actionParamInfo.getValueFromShell() != null) {
            if (!f92.a(actionParamInfo.getValueFromShell(), "1")) {
                String valueFromShell = actionParamInfo.getValueFromShell();
                f92.b(valueFromShell);
                if (valueFromShell == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase = valueFromShell.toLowerCase();
                f92.c(lowerCase, "(this as java.lang.String).toLowerCase()");
                if (!f92.a(lowerCase, "true")) {
                    return false;
                }
            }
            return true;
        }
        if (actionParamInfo.getValue() == null) {
            return z;
        }
        if (!f92.a(actionParamInfo.getValue(), "1")) {
            String value = actionParamInfo.getValue();
            f92.b(value);
            if (value == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase2 = value.toLowerCase();
            f92.c(lowerCase2, "(this as java.lang.String).toLowerCase()");
            if (!f92.a(lowerCase2, "true")) {
                return false;
            }
        }
        return true;
    }

    public final View b() {
        View viewInflate = LayoutInflater.from(this.f7591a).inflate(nb0.kr_param_checkbox, (ViewGroup) null);
        CheckBox checkBox = (CheckBox) viewInflate.findViewById(mb0.kr_param_checkbox);
        checkBox.setTag(this.f3172a.getName());
        checkBox.setChecked(a(this.f3172a, false));
        String label = this.f3172a.getLabel();
        if (!(label == null || label.length() == 0)) {
            checkBox.setText(this.f3172a.getLabel());
        }
        checkBox.setOnClickListener(tf0.f7495a);
        f92.c(viewInflate, "layout");
        return viewInflate;
    }
}
