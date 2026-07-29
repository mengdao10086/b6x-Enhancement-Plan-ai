package h8;

import android.content.Context;
import android.view.View;
import com.flydigi.float_view.R;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGPropertyKey;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes7.dex */
public final class f extends d8.a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@yt.k Context context, @yt.k GamepadInfo deviceInfo) {
        super(context, deviceInfo, R.layout.floatview_property_key_moba_lock_view);
        f0.p(context, "context");
        f0.p(deviceInfo, "deviceInfo");
    }

    @Override // d8.a
    @yt.k
    public CFGPropertyKey c() {
        CFGPropertyKey cFGPropertyKey = new CFGPropertyKey();
        cFGPropertyKey.type = 20;
        return cFGPropertyKey;
    }

    @Override // d8.a
    public void e(@yt.k View view, @yt.k GamepadInfo deviceInfo) {
        f0.p(view, "view");
        f0.p(deviceInfo, "deviceInfo");
    }

    @Override // d8.a
    public void f(@yt.k CFGPropertyKey pkey) {
        f0.p(pkey, "pkey");
    }

    @Override // d8.a
    public void g() {
    }
}
