package a;

import android.app.TimePickerDialog;
import android.widget.TextView;
import android.widget.TimePicker;
import com.omarea.vtools.activities.ActivityChargeControl;
import java.util.Arrays;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class l91 implements TimePickerDialog.OnTimeSetListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityChargeControl.i f6686a;

    public l91(ActivityChargeControl.i iVar) {
        this.f6686a = iVar;
    }

    @Override // android.app.TimePickerDialog.OnTimeSetListener
    public final void onTimeSet(TimePicker timePicker, int i, int i2) {
        ActivityChargeControl.o(ActivityChargeControl.this).edit().putInt(hz0.f1282a.v(), (i * 60) + i2).apply();
        TextView textView = (TextView) ActivityChargeControl.this._$_findCachedViewById(t61.battery_sleep);
        f92.c(textView, "battery_sleep");
        q92 q92Var = q92.f7191a;
        String string = ActivityChargeControl.this.getString(u61.battery_night_mode_time);
        f92.c(string, "getString(R.string.battery_night_mode_time)");
        String str = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}, 2));
        f92.c(str, "java.lang.String.format(format, *args)");
        textView.setText(str);
        ActivityChargeControl.this.u();
    }
}
