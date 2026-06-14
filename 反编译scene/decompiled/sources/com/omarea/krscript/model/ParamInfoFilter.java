package com.omarea.krscript.model;

import a.f92;
import android.text.InputFilter;
import android.text.Spanned;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ParamInfoFilter implements InputFilter {
    public final ActionParamInfo paramInfo;

    public ParamInfoFilter(ActionParamInfo actionParamInfo) {
        f92.d(actionParamInfo, "paramInfo");
        this.paramInfo = actionParamInfo;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        f92.d(spanned, "dest");
        if (this.paramInfo.getMaxLength() >= 0 && this.paramInfo.getMaxLength() - (spanned.length() - (i4 - i3)) <= 0) {
            return "";
        }
        if (this.paramInfo.getType() == null || !(!f92.a(this.paramInfo.getType(), "")) || charSequence == null) {
            return null;
        }
        if (f92.a(this.paramInfo.getType(), "int")) {
            if (Pattern.compile("^[0-9]{0,}$").matcher(charSequence.toString()).matches()) {
                return null;
            }
            return "";
        }
        if (!f92.a(this.paramInfo.getType(), "number") || Pattern.compile("^[\\-.,0-9]{0,}$").matcher(charSequence.toString()).matches()) {
            return null;
        }
        return "";
    }
}
