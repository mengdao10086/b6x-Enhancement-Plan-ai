package k9;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import androidx.core.util.j;
import java.util.List;
import java.util.UUID;
import kotlin.Pair;
import kotlin.collections.s;
import kotlin.jvm.internal.f0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public static final a f37069b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @k
    public static final UUID f37070c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @k
    public static final UUID f37071d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @k
    public static final UUID f37072e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @k
    public static final UUID f37073f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f37074g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f37075h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static int f37076i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @l
    public static BluetoothGattService f37077j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static boolean f37078k;

    static {
        UUID uuidFromString = UUID.fromString("0000FF10-0000-1000-8000-00805F9B34FB");
        f0.o(uuidFromString, "fromString(\"0000FF10-0000-1000-8000-00805F9B34FB\")");
        f37070c = uuidFromString;
        UUID uuidFromString2 = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
        f0.o(uuidFromString2, "fromString(\"00002902-0000-1000-8000-00805f9b34fb\")");
        f37071d = uuidFromString2;
        UUID uuidFromString3 = UUID.fromString("0000FF11-0000-1000-8000-00805F9B34FB");
        f0.o(uuidFromString3, "fromString(\"0000FF11-0000-1000-8000-00805F9B34FB\")");
        f37072e = uuidFromString3;
        UUID uuidFromString4 = UUID.fromString("0000FF12-0000-1000-8000-00805F9B34FB");
        f0.o(uuidFromString4, "fromString(\"0000FF12-0000-1000-8000-00805F9B34FB\")");
        f37073f = uuidFromString4;
        f37074g = 20;
    }

    @Override // k9.c
    @k
    public Pair<UUID, j9.b> a(@k byte[] total, int i10) {
        f0.p(total, "total");
        int length = total.length;
        int iQ = length % q() == 0 ? length / q() : (int) Math.floor((length / q()) + 1);
        int i11 = i10 + 1;
        int iQ2 = i11 == iQ ? length - (q() * i10) : q();
        byte[] bArr = new byte[iQ2];
        System.arraycopy(total, q() * i10, bArr, 0, iQ2);
        f37076i += iQ2;
        boolean z10 = i11 % f37075h == 0;
        UUID uuid = f37073f;
        j9.b bVar = new j9.b(uuid, bArr, Integer.valueOf(i10), Integer.valueOf(iQ), Boolean.valueOf(z10), null, Long.valueOf(z10 ? 1000L : 15L), 32, null);
        if (f37076i == f37075h) {
            f37076i = 0;
        }
        return new Pair<>(uuid, bVar);
    }

    @Override // k9.c
    @l
    public BluetoothGattCharacteristic b(@l UUID uuid) {
        BluetoothGattService bluetoothGattService = f37077j;
        if (bluetoothGattService == null) {
            return null;
        }
        if (uuid == null) {
            uuid = h();
        }
        return bluetoothGattService.getCharacteristic(uuid);
    }

    @Override // k9.c
    @l
    public Byte c(@k byte[] value) {
        f0.p(value, "value");
        if (m(value)) {
            return Byte.valueOf(value[3]);
        }
        return null;
    }

    @Override // k9.c
    @k
    public Pair<UUID, List<byte[]>> d(@l byte[] bArr) {
        byte[] bArr2 = new byte[8];
        bArr2[0] = 8;
        bArr2[1] = jt.l.f36951s;
        bArr2[2] = 0;
        int iR = r(bArr);
        bArr2[3] = (byte) (iR >> 8);
        bArr2[4] = (byte) (iR & 255);
        bArr2[5] = (byte) ((bArr != null ? bArr.length : 0) >> 16);
        bArr2[6] = (byte) (((bArr != null ? bArr.length : 0) & 65280) >> 8);
        bArr2[7] = (byte) ((bArr != null ? bArr.length : 0) & 255);
        return new Pair<>(h(), s.k(bArr2));
    }

    @Override // k9.c
    public boolean e(@k byte[] value) {
        f0.p(value, "value");
        return ((value.length == 0) ^ true) && value[0] == 4 && value[1] == 80 && value[2] == 0 && value[3] == 0;
    }

    @Override // k9.c
    @k
    public UUID f() {
        return f37071d;
    }

    @Override // k9.c
    @l
    public Pair<BluetoothGattCharacteristic, BluetoothGattCharacteristic> g(int i10, @k BluetoothGatt gatt) {
        f0.p(gatt, "gatt");
        BluetoothGattService service = gatt.getService(j());
        if (service == null) {
            return null;
        }
        a aVar = f37069b;
        f37077j = service;
        BluetoothGattCharacteristic characteristic = service.getCharacteristic(aVar.h());
        gatt.setCharacteristicNotification(characteristic, true);
        return new Pair<>(characteristic, characteristic);
    }

    @Override // k9.c
    @k
    public UUID h() {
        return f37072e;
    }

    @Override // k9.c
    public boolean i(@k byte[] value) {
        f0.p(value, "value");
        return m(value) && (value[3] & 255) == 0;
    }

    @Override // k9.c
    @k
    public UUID j() {
        return f37070c;
    }

    @Override // k9.c
    public boolean k(@k byte[] command) {
        f0.p(command, "command");
        return j.a(command, new byte[]{3, 83, 0});
    }

    @Override // k9.c
    public boolean l(@k UUID first) {
        f0.p(first, "first");
        return f37078k;
    }

    @Override // k9.c
    public boolean m(@k byte[] value) {
        f0.p(value, "value");
        return value[0] == 4 && value[1] == 83 && value[2] == 0;
    }

    @Override // k9.c
    @k
    public Pair<UUID, List<j9.b>> n(int i10) {
        return new Pair<>(h(), s.k(new j9.b(h(), new byte[]{3, 83, 0}, null, null, Boolean.FALSE, null, null, 108, null)));
    }

    @Override // k9.c
    @k
    public Pair<UUID, List<byte[]>> o() {
        return new Pair<>(h(), s.k(new byte[]{3, 81, 0}));
    }

    @Override // k9.c
    public boolean p(@k byte[] value) {
        f0.p(value, "value");
        if (value[0] == 5 && value[1] == 81 && value[2] == 0) {
            f37075h = (value[3] & 255) * 20;
        } else if (value[0] == 8 && value[1] == 82 && value[2] == 0) {
            f37078k = false;
            return value[3] == 0;
        }
        return true;
    }

    @Override // k9.c
    public int q() {
        return f37074g;
    }

    public final int r(byte[] bArr) {
        if (bArr == null) {
            return 0;
        }
        int i10 = 0;
        for (byte b10 : bArr) {
            for (int i11 = 0; i11 < 8; i11++) {
                boolean z10 = ((b10 >> (7 - i11)) & 1) == 1;
                boolean z11 = ((i10 >> 15) & 1) == 1;
                i10 <<= 1;
                if (z10 ^ z11) {
                    i10 ^= 4129;
                }
            }
        }
        return i10;
    }
}
