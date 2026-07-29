package qf;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import com.flydigi.action.FirmwareUpgradeStatisticsLog;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes7.dex */
public class a {
    public static boolean a(BluetoothDevice bluetoothDevice) {
        Boolean bool = Boolean.FALSE;
        try {
            bool = (Boolean) bluetoothDevice.getClass().getMethod("cancelBondProcess", new Class[0]).invoke(bluetoothDevice, new Object[0]);
        } catch (IllegalArgumentException e10) {
            e10.printStackTrace();
        } catch (SecurityException e11) {
            e11.printStackTrace();
        } catch (Exception e12) {
            e12.printStackTrace();
        }
        return bool.booleanValue();
    }

    public static boolean b(BluetoothDevice bluetoothDevice) {
        try {
            ((Boolean) bluetoothDevice.getClass().getMethod("cancelPairingUserInput", new Class[0]).invoke(bluetoothDevice, new Object[0])).booleanValue();
        } catch (IllegalAccessException e10) {
            e10.printStackTrace();
        } catch (NoSuchMethodException e11) {
            e11.printStackTrace();
        } catch (InvocationTargetException e12) {
            e12.printStackTrace();
        }
        return false;
    }

    public static boolean c(BluetoothDevice bluetoothDevice) {
        return bluetoothDevice.createBond();
    }

    public static BluetoothAdapter d(Context context) {
        return e(context).getAdapter();
    }

    public static BluetoothManager e(Context context) {
        return (BluetoothManager) context.getSystemService(FirmwareUpgradeStatisticsLog.f13300c);
    }

    public static BluetoothDevice f(Context context, String str) {
        try {
            return d(context).getRemoteDevice(str);
        } catch (IllegalArgumentException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static byte[] g(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int i10 = 0;
        while (i10 < bArr.length) {
            int i11 = i10 + 1;
            int i12 = bArr[i10] & 255;
            if (i12 == 0) {
                return null;
            }
            int i13 = i12 - 1;
            int i14 = i11 + 1;
            if ((bArr[i11] & 255) == 255 && i13 > 2) {
                return wf.a.g(bArr, i14 + 2, i13 - 2);
            }
            i10 = i13 + i14;
        }
        return null;
    }

    public static boolean h(BluetoothDevice bluetoothDevice) {
        Boolean boolValueOf = Boolean.FALSE;
        try {
            boolValueOf = Boolean.valueOf(((Boolean) bluetoothDevice.getClass().getMethod("removeBond", new Class[0]).invoke(bluetoothDevice, new Object[0])).booleanValue());
        } catch (IllegalAccessException e10) {
            e10.printStackTrace();
        } catch (NoSuchMethodException e11) {
            e11.printStackTrace();
        } catch (InvocationTargetException e12) {
            e12.printStackTrace();
        }
        return boolValueOf.booleanValue();
    }

    public static boolean i(BluetoothDevice bluetoothDevice, String str) throws Exception {
        Boolean bool = Boolean.FALSE;
        try {
            bool = (Boolean) bluetoothDevice.getClass().getDeclaredMethod("setPin", byte[].class).invoke(bluetoothDevice, str.getBytes(StandardCharsets.UTF_8));
        } catch (IllegalArgumentException e10) {
            e10.printStackTrace();
        } catch (SecurityException e11) {
            e11.printStackTrace();
        } catch (Exception e12) {
            e12.printStackTrace();
        }
        return bool.booleanValue();
    }
}
