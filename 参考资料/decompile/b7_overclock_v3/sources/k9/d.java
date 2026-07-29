package k9;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import com.flydigi.sdk.bluetooth.ota.TelinkOtaFactory;
import java.util.List;
import java.util.UUID;
import kotlin.NotImplementedError;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.s;
import kotlin.jvm.internal.f0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public static final d f37081b = new d();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @k
    public static final UUID f37082c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @k
    public static final UUID f37083d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @k
    public static final UUID f37084e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f37085f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @l
    public static BluetoothGattService f37086g;

    static {
        UUID uuidFromString = UUID.fromString("0000fee0-0000-1000-8000-00805f9b34fb");
        f0.o(uuidFromString, "fromString(\"0000fee0-0000-1000-8000-00805f9b34fb\")");
        f37082c = uuidFromString;
        UUID uuidFromString2 = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
        f0.o(uuidFromString2, "fromString(\"00002902-0000-1000-8000-00805f9b34fb\")");
        f37083d = uuidFromString2;
        UUID uuidFromString3 = UUID.fromString("0000fee1-0000-1000-8000-00805f9b34fb");
        f0.o(uuidFromString3, "fromString(\"0000fee1-0000-1000-8000-00805f9b34fb\")");
        f37084e = uuidFromString3;
        f37085f = 20;
    }

    @Override // k9.c
    @k
    public Pair<UUID, j9.b> a(@k byte[] total, int i10) {
        f0.p(total, "total");
        int length = total.length;
        int iQ = length % q() == 0 ? length / q() : (int) Math.floor((length / q()) + 1);
        int iQ2 = i10 + 1 == iQ ? length - (q() * i10) : q();
        byte[] bArr = new byte[iQ2];
        System.arraycopy(total, q() * i10, bArr, 0, iQ2);
        return new Pair<>(f37081b.h(), new j9.b(h(), bArr, Integer.valueOf(i10), Integer.valueOf(iQ), Boolean.FALSE, null, 5L, 32, null));
    }

    @Override // k9.c
    @l
    public BluetoothGattCharacteristic b(@l UUID uuid) {
        BluetoothGattService bluetoothGattService = f37086g;
        if (bluetoothGattService == null) {
            return null;
        }
        if (uuid == null) {
            uuid = TelinkOtaFactory.f16306b.h();
        }
        return bluetoothGattService.getCharacteristic(uuid);
    }

    @Override // k9.c
    @l
    public Byte c(@k byte[] value) {
        f0.p(value, "value");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // k9.c
    @k
    public Pair<UUID, List<byte[]>> d(@l byte[] bArr) {
        return new Pair<>(h(), s.k(new byte[]{-1, 90, -91}));
    }

    @Override // k9.c
    public boolean e(@k byte[] value) {
        f0.p(value, "value");
        return false;
    }

    @Override // k9.c
    @k
    public UUID f() {
        return f37083d;
    }

    @Override // k9.c
    @l
    public Pair<BluetoothGattCharacteristic, BluetoothGattCharacteristic> g(int i10, @k BluetoothGatt gatt) {
        f0.p(gatt, "gatt");
        BluetoothGattService service = gatt.getService(j());
        if (service == null) {
            return null;
        }
        d dVar = f37081b;
        f37086g = service;
        BluetoothGattCharacteristic characteristic = service.getCharacteristic(dVar.h());
        gatt.setCharacteristicNotification(characteristic, true);
        return new Pair<>(characteristic, characteristic);
    }

    @Override // k9.c
    @k
    public UUID h() {
        return f37084e;
    }

    @Override // k9.c
    public boolean i(@k byte[] value) {
        f0.p(value, "value");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // k9.c
    @k
    public UUID j() {
        return f37082c;
    }

    @Override // k9.c
    public boolean k(@k byte[] command) {
        f0.p(command, "command");
        return command[0] == -86 && command[1] == -86;
    }

    @Override // k9.c
    public boolean l(@k UUID first) {
        f0.p(first, "first");
        return false;
    }

    @Override // k9.c
    public boolean m(@k byte[] value) {
        f0.p(value, "value");
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // k9.c
    @k
    public Pair<UUID, List<j9.b>> n(int i10) {
        return new Pair<>(h(), CollectionsKt__CollectionsKt.L(new j9.b(h(), new byte[]{85, 85}, null, null, null, null, null, 124, null), new j9.b(h(), new byte[]{85, -86}, null, null, null, null, null, 124, null), new j9.b(h(), new byte[]{-86, -86}, null, null, null, null, null, 124, null)));
    }

    @Override // k9.c
    @k
    public Pair<UUID, List<byte[]>> o() {
        return new Pair<>(TelinkOtaFactory.f16306b.h(), CollectionsKt__CollectionsKt.E());
    }

    @Override // k9.c
    public boolean p(@k byte[] value) {
        f0.p(value, "value");
        return true;
    }

    @Override // k9.c
    public int q() {
        return f37085f;
    }
}
