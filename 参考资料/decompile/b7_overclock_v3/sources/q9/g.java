package q9;

import kotlin.jvm.internal.f0;
import yt.k;

/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public static final g f47181a = new g();

    @k
    public final String a(@k String bluetoothName) {
        f0.p(bluetoothName, "bluetoothName");
        int iHashCode = bluetoothName.hashCode();
        if (iHashCode != -935053220) {
            if (iHashCode != 987438241) {
                if (iHashCode == 987438365 && bluetoothName.equals(a.f47159d)) {
                    return c.f47168e;
                }
            } else if (bluetoothName.equals(a.f47158c)) {
                return c.f47167d;
            }
        } else if (bluetoothName.equals(a.f47157b)) {
            return c.f47166c;
        }
        return "all";
    }

    @k
    public final String b(@k String deviceCode) {
        f0.p(deviceCode, "deviceCode");
        int iHashCode = deviceCode.hashCode();
        if (iHashCode != -639242794) {
            if (iHashCode != 3769) {
                if (iHashCode == 203009350 && deviceCode.equals(c.f47167d)) {
                    return a.f47158c;
                }
            } else if (deviceCode.equals(c.f47168e)) {
                return a.f47159d;
            }
        } else if (deviceCode.equals(c.f47166c)) {
            return a.f47157b;
        }
        return "";
    }
}
