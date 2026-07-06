package a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import com.omarea.krscript.model.ActionParamInfo;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class og0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f7019a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ActionParamInfo f2243a;

    public og0(ActionParamInfo actionParamInfo, Context context) {
        f92.d(actionParamInfo, "actionParamInfo");
        f92.d(context, "context");
        this.f2243a = actionParamInfo;
        this.f7019a = context;
    }

    public final View b() {
        String value;
        View viewInflate = LayoutInflater.from(this.f7019a).inflate(nb0.kr_param_seekbar, (ViewGroup) null);
        SeekBar seekBar = (SeekBar) viewInflate.findViewById(mb0.kr_param_seekbar);
        f92.c(seekBar, "seekbar");
        seekBar.setMax(this.f2243a.getMax());
        seekBar.setMax(this.f2243a.getMax() - this.f2243a.getMin());
        if (this.f2243a.getValueFromShell() == null) {
            if (this.f2243a.getValue() != null) {
                value = this.f2243a.getValue();
                f92.b(value);
            }
            seekBar.setTag(this.f2243a.getName());
            ImageButton imageButton = (ImageButton) viewInflate.findViewById(mb0.kr_param_seekbar_minus);
            ImageButton imageButton2 = (ImageButton) viewInflate.findViewById(mb0.kr_param_seekbar_plus);
            TextView textView = (TextView) viewInflate.findViewById(mb0.kr_param_seekbar_value);
            f92.c(textView, "textView");
            textView.setText(String.valueOf(seekBar.getProgress() + this.f2243a.getMin()));
            seekBar.setOnSeekBarChangeListener(new lg0(this, textView));
            imageButton.setOnClickListener(new mg0(seekBar));
            imageButton2.setOnClickListener(new ng0(seekBar));
            f92.c(viewInflate, "layout");
            return viewInflate;
        }
        value = this.f2243a.getValueFromShell();
        f92.b(value);
        seekBar.setProgress(Integer.parseInt(value) - this.f2243a.getMin());
        seekBar.setTag(this.f2243a.getName());
        ImageButton imageButton3 = (ImageButton) viewInflate.findViewById(mb0.kr_param_seekbar_minus);
        ImageButton imageButton22 = (ImageButton) viewInflate.findViewById(mb0.kr_param_seekbar_plus);
        TextView textView2 = (TextView) viewInflate.findViewById(mb0.kr_param_seekbar_value);
        f92.c(textView2, "textView");
        textView2.setText(String.valueOf(seekBar.getProgress() + this.f2243a.getMin()));
        seekBar.setOnSeekBarChangeListener(new lg0(this, textView2));
        imageButton3.setOnClickListener(new mg0(seekBar));
        imageButton22.setOnClickListener(new ng0(seekBar));
        f92.c(viewInflate, "layout");
        return viewInflate;
    }
}
