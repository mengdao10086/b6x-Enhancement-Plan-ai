package a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.omarea.krscript.model.ActionParamInfo;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class hg0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public cg0 f6310a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f1165a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ActionParamInfo f1166a;

    public hg0(ActionParamInfo actionParamInfo, Context context, cg0 cg0Var) {
        f92.d(actionParamInfo, "actionParamInfo");
        f92.d(context, "context");
        this.f1166a = actionParamInfo;
        this.f1165a = context;
        this.f6310a = cg0Var;
    }

    public final View d() {
        String value;
        Context context;
        int i;
        View viewInflate = LayoutInflater.from(this.f1165a).inflate(nb0.kr_param_file, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(mb0.kr_param_file_text);
        EditText editText = (EditText) viewInflate.findViewById(mb0.kr_param_file_path);
        View viewFindViewById = viewInflate.findViewById(mb0.kr_param_file_btn);
        if (this.f1166a.getEditable()) {
            f92.c(textView, "textView");
            textView.setVisibility(8);
            f92.c(editText, "pathView");
            editText.setVisibility(0);
            if (f92.a(this.f1166a.getType(), "folder")) {
                context = this.f1165a;
                i = ob0.kr_please_choose_folder;
            } else {
                context = this.f1165a;
                i = ob0.kr_please_choose_file;
            }
            editText.setHint(context.getString(i));
        } else {
            f92.c(editText, "pathView");
            e(editText);
        }
        viewFindViewById.setOnClickListener(new gg0(this, textView, editText));
        if (this.f1166a.getValueFromShell() == null) {
            String value2 = this.f1166a.getValue();
            if (!(value2 == null || value2.length() == 0)) {
                f92.c(textView, "textView");
                textView.setText(this.f1166a.getValue());
                value = this.f1166a.getValue();
            }
            editText.setTag(this.f1166a.getName());
            f92.c(viewInflate, "layout");
            return viewInflate;
        }
        f92.c(textView, "textView");
        textView.setText(this.f1166a.getValueFromShell());
        value = this.f1166a.getValueFromShell();
        editText.setText(value);
        editText.setTag(this.f1166a.getName());
        f92.c(viewInflate, "layout");
        return viewInflate;
    }

    public final void e(TextView textView) {
        f92.d(textView, "view");
        if (textView instanceof EditText) {
            textView.setCursorVisible(false);
            textView.setFocusable(false);
            textView.setFocusableInTouchMode(false);
        }
    }
}
