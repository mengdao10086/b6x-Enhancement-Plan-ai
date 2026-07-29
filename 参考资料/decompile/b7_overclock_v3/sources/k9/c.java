package k9;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import com.flydigi.sdk.bluetooth.ota.TelinkOtaFactory;
import java.util.List;
import java.util.UUID;
import kotlin.Pair;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes3.dex */
public interface c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public static final a f37079a = a.f37080a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f37080a = new a();

        @l
        public final c a(int i10) {
            if (i10 == 1) {
                return d.f37081b;
            }
            if (i10 == 2) {
                return k9.a.f37069b;
            }
            if (i10 != 3) {
                return null;
            }
            return TelinkOtaFactory.f16306b;
        }
    }

    public static final class b {
        public static /* synthetic */ BluetoothGattCharacteristic a(c cVar, UUID uuid, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOtaCharacteristic");
            }
            if ((i10 & 1) != 0) {
                uuid = cVar.h();
            }
            return cVar.b(uuid);
        }
    }

    @k
    Pair<UUID, j9.b> a(@k byte[] bArr, int i10);

    @l
    BluetoothGattCharacteristic b(@l UUID uuid);

    @l
    Byte c(@k byte[] bArr);

    @k
    Pair<UUID, List<byte[]>> d(@l byte[] bArr);

    boolean e(@k byte[] bArr);

    @k
    UUID f();

    @l
    Pair<BluetoothGattCharacteristic, BluetoothGattCharacteristic> g(int i10, @k BluetoothGatt bluetoothGatt);

    @k
    UUID h();

    boolean i(@k byte[] bArr);

    @k
    UUID j();

    boolean k(@k byte[] bArr);

    boolean l(@k UUID uuid);

    boolean m(@k byte[] bArr);

    @k
    Pair<UUID, List<j9.b>> n(int i10);

    @k
    Pair<UUID, List<byte[]>> o();

    boolean p(@k byte[] bArr);

    int q();
}
