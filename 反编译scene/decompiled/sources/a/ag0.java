package a;

import a.p80;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.omarea.krscript.model.ActionParamInfo;
import java.util.Arrays;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ag0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f5604a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ActionParamInfo f65a;

    public ag0(ActionParamInfo actionParamInfo, Context context) {
        f92.d(actionParamInfo, "actionParamInfo");
        f92.d(context, "context");
        this.f65a = actionParamInfo;
        this.f5604a = context;
    }

    public final int d(CharSequence charSequence) {
        if (charSequence != null) {
            if (charSequence.length() > 0) {
                try {
                    return Color.parseColor(charSequence.toString());
                } catch (Exception unused) {
                }
            }
        }
        return (int) 4278190080L;
    }

    public final void e(TextView textView, ImageView imageView, View view) {
        View viewInflate = LayoutInflater.from(this.f5604a).inflate(nb0.kr_color_picker, (ViewGroup) null);
        int iD = d(textView.getText());
        SeekBar seekBar = (SeekBar) viewInflate.findViewById(mb0.color_alpha);
        SeekBar seekBar2 = (SeekBar) viewInflate.findViewById(mb0.color_red);
        SeekBar seekBar3 = (SeekBar) viewInflate.findViewById(mb0.color_green);
        SeekBar seekBar4 = (SeekBar) viewInflate.findViewById(mb0.color_blue);
        Button button = (Button) viewInflate.findViewById(mb0.color_preview);
        TextView textView2 = (TextView) viewInflate.findViewById(mb0.color_preview_text);
        f92.c(seekBar, "alphaBar");
        seekBar.setProgress(Color.alpha(iD));
        f92.c(seekBar2, "redBar");
        seekBar2.setProgress(Color.red(iD));
        f92.c(seekBar3, "greenBar");
        seekBar3.setProgress(Color.green(iD));
        f92.c(seekBar4, "blueBar");
        seekBar4.setProgress(Color.blue(iD));
        button.setBackgroundColor(iD);
        f92.c(textView2, "colorPreviewText");
        textView2.setText(f(seekBar.getProgress(), seekBar2.getProgress(), seekBar3.getProgress(), seekBar4.getProgress()));
        xf0 xf0Var = new xf0(seekBar, seekBar2, seekBar3, seekBar4, button);
        seekBar.setOnSeekBarChangeListener(xf0Var);
        seekBar2.setOnSeekBarChangeListener(xf0Var);
        seekBar3.setOnSeekBarChangeListener(xf0Var);
        seekBar4.setOnSeekBarChangeListener(xf0Var);
        p80.a aVar = p80.f2403a;
        AlertDialog.Builder negativeButton = new AlertDialog.Builder(this.f5604a).setTitle(this.f5604a.getString(ob0.kr_color_picker)).setView(viewInflate).setPositiveButton(this.f5604a.getString(ob0.btn_confirm), new vf0(this, seekBar, seekBar2, seekBar3, seekBar4, button, textView, imageView, view)).setNegativeButton(this.f5604a.getString(ob0.btn_cancel), wf0.f7782a);
        f92.c(negativeButton, "AlertDialog.Builder(cont….btn_cancel)) { _, _ -> }");
        aVar.c(negativeButton);
    }

    public final String f(int i, int i2, int i3, int i4) {
        q92 q92Var = q92.f7191a;
        String str = String.format("#%02x%02x%02x%02x", Arrays.copyOf(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}, 4));
        f92.c(str, "java.lang.String.format(format, *args)");
        return str;
    }

    public final View g() {
        String value;
        View viewInflate = LayoutInflater.from(this.f5604a).inflate(nb0.kr_param_color, (ViewGroup) null);
        EditText editText = (EditText) viewInflate.findViewById(mb0.kr_param_color_text);
        ImageView imageView = (ImageView) viewInflate.findViewById(mb0.kr_param_color_invalid);
        View viewFindViewById = viewInflate.findViewById(mb0.kr_param_color_preview);
        f92.c(editText, "textView");
        editText.setTag(this.f65a.getName());
        editText.addTextChangedListener(new yf0(this, editText, imageView, viewFindViewById));
        if (this.f65a.getValueFromShell() == null) {
            if (this.f65a.getValue() != null) {
                value = this.f65a.getValue();
            }
            f92.c(imageView, "invalidView");
            f92.c(viewFindViewById, "preview");
            h(editText, imageView, viewFindViewById, editText.getText().toString());
            viewInflate.findViewById(mb0.kr_param_color_picker).setOnClickListener(new zf0(this, editText, imageView, viewFindViewById));
            f92.c(viewInflate, "layout");
            return viewInflate;
        }
        value = this.f65a.getValueFromShell();
        f92.b(value);
        editText.setText(value);
        f92.c(imageView, "invalidView");
        f92.c(viewFindViewById, "preview");
        h(editText, imageView, viewFindViewById, editText.getText().toString());
        viewInflate.findViewById(mb0.kr_param_color_picker).setOnClickListener(new zf0(this, editText, imageView, viewFindViewById));
        f92.c(viewInflate, "layout");
        return viewInflate;
    }

    public final boolean h(TextView textView, ImageView imageView, View view, String str) {
        try {
            int color = Color.parseColor(str);
            imageView.setVisibility(8);
            view.setVisibility(0);
            view.setBackground(new ColorDrawable(color));
            return true;
        } catch (Exception unused) {
            imageView.setVisibility(0);
            view.setVisibility(8);
            return false;
        }
    }
}
