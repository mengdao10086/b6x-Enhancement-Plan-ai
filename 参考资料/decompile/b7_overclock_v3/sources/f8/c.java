package f8;

import android.content.Context;
import android.view.View;
import com.flydigi.float_view.R;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyKey;
import kotlin.jvm.internal.f0;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
public final class c extends d8.a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@k Context context, @k GamepadInfo deviceInfo) {
        super(context, deviceInfo, R.layout.floatview_property_key_singletouch_fast);
        f0.p(context, "context");
        f0.p(deviceInfo, "deviceInfo");
    }

    @Override // d8.a
    @k
    public CFGPropertyKey c() {
        CFGPropertyKey cFGPropertyKey = new CFGPropertyKey();
        cFGPropertyKey.type = 1;
        cFGPropertyKey.sub_type = 7;
        cFGPropertyKey.duration = 5;
        return cFGPropertyKey;
    }

    @Override // d8.a
    public void e(@k View view, @k GamepadInfo deviceInfo) {
        f0.p(view, "view");
        f0.p(deviceInfo, "deviceInfo");
    }

    @Override // d8.a
    public void f(@k CFGPropertyKey pkey) {
        f0.p(pkey, "pkey");
    }

    @Override // d8.a
    public void g() {
    }
}
