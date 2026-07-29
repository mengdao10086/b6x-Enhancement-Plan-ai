package k9;

import com.flydigi.sdk.bluetooth.ota.OtaStatus;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes3.dex */
public interface b {

    public static final class a {
        public static /* synthetic */ void a(b bVar, OtaStatus otaStatus, Integer num, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onOtaFailed");
            }
            if ((i10 & 2) != 0) {
                num = 0;
            }
            bVar.S0(otaStatus, num);
        }
    }

    void C();

    void S0(@k OtaStatus otaStatus, @l Integer num);

    void b1(float f10);

    void g0();

    void r0();
}
