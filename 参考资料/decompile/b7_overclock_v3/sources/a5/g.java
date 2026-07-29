package a5;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.blankj.utilcode.util.d1;
import com.blankj.utilcode.util.n0;
import com.flydigi.data.DataConstant;
import com.flydigi.data.bean.FZUserAccount;
import com.flydigi.data.event.FZAccountLoginChangeEvent;
import kotlin.jvm.internal.f0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(@l Context context, @k Intent intent) {
        f0.p(intent, "intent");
        if (n0.b(DataConstant.BROADCAST_RECEIVER_ACTION_LOGIN_STATUS, d1.l(intent.getAction()))) {
            tt.c.f().q(new FZAccountLoginChangeEvent((FZUserAccount) intent.getParcelableExtra(DataConstant.EXTRA_KEY_LOGIN_ACCOUNT), intent.getBooleanExtra(DataConstant.EXTRA_KEY_LOGIN_STATUS, false)));
        }
    }
}
