package com.flydigi.sdk.bluetooth;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f16298a = "l";

    public static String a(byte[] bArr) {
        byte b10;
        ArrayList arrayList = new ArrayList();
        String str = null;
        if (bArr != null) {
            try {
                ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                while (byteBufferOrder.remaining() > 2 && (b10 = byteBufferOrder.get()) != 0) {
                    byte b11 = byteBufferOrder.get();
                    if (b11 == 2 || b11 == 3) {
                        while (b10 >= 2) {
                            arrayList.add(UUID.fromString(String.format("%08x-0000-1000-8000-00805f9b34fb", Short.valueOf(byteBufferOrder.getShort()))));
                            b10 = (byte) (b10 - 2);
                        }
                    } else if (b11 == 6 || b11 == 7) {
                        while (b10 >= 16) {
                            arrayList.add(new UUID(byteBufferOrder.getLong(), byteBufferOrder.getLong()));
                            b10 = (byte) (b10 - 16);
                        }
                    } else if (b11 != 9) {
                        byteBufferOrder.position((byteBufferOrder.position() + b10) - 1);
                    } else {
                        byte[] bArr2 = new byte[b10 - 1];
                        byteBufferOrder.get(bArr2);
                        str = new String(bArr2, StandardCharsets.UTF_8);
                    }
                }
            } catch (Exception unused) {
                return "";
            }
        }
        return str;
    }
}
