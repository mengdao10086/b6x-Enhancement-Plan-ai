package fg;

import fg.e;
import o5.h;

/* JADX INFO: loaded from: classes5.dex */
public class b {
    public static String a(int i10) {
        return i10 == 10 ? "BOND_NONE" : i10 == 12 ? "BOND_BONDED" : i10 == 11 ? "BOND_BONDING" : h.f42757n;
    }

    public static String b(int i10) {
        return i10 == 2 ? "CONNECTED" : i10 == 1 ? "CONNECTING" : i10 == 3 ? "DISCONNECTING" : i10 == 0 ? "DISCONNECTED" : h.f42757n;
    }

    public static String c(int i10, boolean z10) {
        String strD = d(i10);
        StringBuilder sb2 = new StringBuilder();
        if (i10 == 0) {
            sb2.append("Status ");
            sb2.append(strD);
            sb2.append(": SUCCESS");
        } else {
            boolean z11 = false;
            sb2.append("Error status ");
            sb2.append(strD);
            sb2.append(": ");
            String strA = e.a(i10, z10);
            boolean z12 = true;
            if (strA.length() > 0) {
                sb2.append("\n\t> BluetoothGatt - ");
                sb2.append(strA);
                z11 = true;
            }
            String strA2 = e.a.a(i10, z10);
            if (strA2.length() > 0) {
                sb2.append("\n\t> ATT - ");
                sb2.append(strA2);
                z11 = true;
            }
            String strA3 = e.c.a(i10, z10);
            if (strA3.length() > 0) {
                sb2.append("\n\t> HCI - ");
                sb2.append(strA3);
                z11 = true;
            }
            String strA4 = e.b.a(i10, z10);
            if (strA4.length() > 0) {
                sb2.append("\n\t> gatt_api.h - ");
                sb2.append(strA4);
            } else {
                z12 = z11;
            }
            if (!z12) {
                sb2.append("UNDEFINED");
            }
        }
        return sb2.toString();
    }

    public static String d(int i10) {
        return String.format("0x%04X", Integer.valueOf(i10 & 65535));
    }
}
