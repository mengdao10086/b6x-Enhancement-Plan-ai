package a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.omarea.krscript.model.ActionParamInfo;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class tg0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f7497a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ActionParamInfo f3025a;

    public tg0(ActionParamInfo actionParamInfo, Context context) {
        f92.d(actionParamInfo, "actionParamInfo");
        f92.d(context, "context");
        this.f3025a = actionParamInfo;
        this.f7497a = context;
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
        View viewInflate = LayoutInflater.from(this.f7497a).inflate(nb0.kr_param_switch, (ViewGroup) null);
        CompoundButton compoundButton = (CompoundButton) viewInflate.findViewById(mb0.kr_param_switch);
        compoundButton.setTag(this.f3025a.getName());
        compoundButton.setChecked(a(this.f3025a, false));
        String label = this.f3025a.getLabel();
        if (!(label == null || label.length() == 0)) {
            compoundButton.setText(this.f3025a.getLabel());
        }
        compoundButton.setOnClickListener(sg0.f7393a);
        f92.c(viewInflate, "layout");
        return viewInflate;
    }
}
