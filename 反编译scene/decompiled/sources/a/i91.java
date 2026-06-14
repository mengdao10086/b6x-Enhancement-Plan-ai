package a;

import android.widget.Switch;
import android.widget.TextView;
import com.omarea.ui.BlurViewLinearLayout;
import com.omarea.vtools.activities.ActivityChargeControl;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class i91 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i92 f6389a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ j91 f1344a;
    public final /* synthetic */ i92 b;

    public i91(j91 j91Var, i92 i92Var, i92 i92Var2) {
        this.f1344a = j91Var;
        this.f6389a = i92Var;
        this.b = i92Var2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.f1344a.f1516a.b) {
                TextView textView = (TextView) this.f1344a.f1516a._$_findCachedViewById(t61.settings_qc_limit_current);
                f92.c(textView, "settings_qc_limit_current");
                textView.setText(this.f1344a.f1516a.getString(u61.battery_reality_limit) + ((String) this.f1344a.f6489a.f6891a));
            }
            Switch r0 = (Switch) this.f1344a.f1516a._$_findCachedViewById(t61.settings_qc);
            f92.c(r0, "settings_qc");
            r0.setChecked(ActivityChargeControl.o(this.f1344a.f1516a).getBoolean(hz0.f1282a.q(), false));
            TextView textView2 = (TextView) this.f1344a.f1516a._$_findCachedViewById(t61.battery_uevent);
            f92.c(textView2, "battery_uevent");
            textView2.setText((String) this.f1344a.b.f6891a);
            String str = (String) this.f1344a.c.f6891a;
            if (str == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            if (ec2.d0(ec2.r0(str).toString(), new String[]{"\n"}, false, 0, 6, null).size() > 1) {
                TextView textView3 = (TextView) this.f1344a.f1516a._$_findCachedViewById(t61.battery_usb_uevent);
                f92.c(textView3, "battery_usb_uevent");
                textView3.setText((String) this.f1344a.c.f6891a);
                BlurViewLinearLayout blurViewLinearLayout = (BlurViewLinearLayout) this.f1344a.f1516a._$_findCachedViewById(t61.battery_usb);
                f92.c(blurViewLinearLayout, "battery_usb");
                blurViewLinearLayout.setVisibility(0);
            } else {
                BlurViewLinearLayout blurViewLinearLayout2 = (BlurViewLinearLayout) this.f1344a.f1516a._$_findCachedViewById(t61.battery_usb);
                f92.c(blurViewLinearLayout2, "battery_usb");
                blurViewLinearLayout2.setVisibility(8);
            }
            if (this.f1344a.f1516a.c) {
                Switch r02 = (Switch) this.f1344a.f1516a._$_findCachedViewById(t61.settings_pd);
                f92.c(r02, "settings_pd");
                r02.setChecked(this.f6389a.b);
                TextView textView4 = (TextView) this.f1344a.f1516a._$_findCachedViewById(t61.settings_pd_state);
                f92.c(textView4, "settings_pd_state");
                textView4.setText(this.b.b ? this.f1344a.f1516a.getString(u61.battery_pd_active_1) : this.f1344a.f1516a.getString(u61.battery_pd_active_0));
            }
        } catch (Exception unused) {
        }
    }
}
