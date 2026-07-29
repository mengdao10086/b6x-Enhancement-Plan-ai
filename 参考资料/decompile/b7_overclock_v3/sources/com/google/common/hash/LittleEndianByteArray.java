package com.google.common.hash;

import com.google.common.primitives.Longs;
import java.lang.reflect.Field;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes7.dex */
final class LittleEndianByteArray {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final LittleEndianBytes byteArray;

    public enum JavaLittleEndianBytes implements LittleEndianBytes {
        INSTANCE { // from class: com.google.common.hash.LittleEndianByteArray.JavaLittleEndianBytes.1
            @Override // com.google.common.hash.LittleEndianByteArray.LittleEndianBytes
            public long getLongLittleEndian(byte[] bArr, int i10) {
                return Longs.fromBytes(bArr[i10 + 7], bArr[i10 + 6], bArr[i10 + 5], bArr[i10 + 4], bArr[i10 + 3], bArr[i10 + 2], bArr[i10 + 1], bArr[i10]);
            }

            @Override // com.google.common.hash.LittleEndianByteArray.LittleEndianBytes
            public void putLongLittleEndian(byte[] bArr, int i10, long j10) {
                long j11 = 255;
                for (int i11 = 0; i11 < 8; i11++) {
                    bArr[i10 + i11] = (byte) ((j10 & j11) >> (i11 * 8));
                    j11 <<= 8;
                }
            }
        }
    }

    public interface LittleEndianBytes {
        long getLongLittleEndian(byte[] bArr, int i10);

        void putLongLittleEndian(byte[] bArr, int i10, long j10);
    }

    public enum UnsafeByteArray implements LittleEndianBytes {
        UNSAFE_LITTLE_ENDIAN { // from class: com.google.common.hash.LittleEndianByteArray.UnsafeByteArray.1
            @Override // com.google.common.hash.LittleEndianByteArray.LittleEndianBytes
            public long getLongLittleEndian(byte[] bArr, int i10) {
                return UnsafeByteArray.theUnsafe.getLong(bArr, ((long) i10) + ((long) UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET));
            }

            @Override // com.google.common.hash.LittleEndianByteArray.LittleEndianBytes
            public void putLongLittleEndian(byte[] bArr, int i10, long j10) {
                UnsafeByteArray.theUnsafe.putLong(bArr, ((long) i10) + ((long) UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET), j10);
            }
        },
        UNSAFE_BIG_ENDIAN { // from class: com.google.common.hash.LittleEndianByteArray.UnsafeByteArray.2
            @Override // com.google.common.hash.LittleEndianByteArray.LittleEndianBytes
            public long getLongLittleEndian(byte[] bArr, int i10) {
                return Long.reverseBytes(UnsafeByteArray.theUnsafe.getLong(bArr, ((long) i10) + ((long) UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET)));
            }

            @Override // com.google.common.hash.LittleEndianByteArray.LittleEndianBytes
            public void putLongLittleEndian(byte[] bArr, int i10, long j10) {
                UnsafeByteArray.theUnsafe.putLong(bArr, ((long) i10) + ((long) UnsafeByteArray.BYTE_ARRAY_BASE_OFFSET), Long.reverseBytes(j10));
            }
        };

        private static final int BYTE_ARRAY_BASE_OFFSET;
        private static final Unsafe theUnsafe;

        static {
            Unsafe unsafe = getUnsafe();
            theUnsafe = unsafe;
            BYTE_ARRAY_BASE_OFFSET = unsafe.arrayBaseOffset(byte[].class);
            if (unsafe.arrayIndexScale(byte[].class) != 1) {
                throw new AssertionError();
            }
        }

        private static Unsafe getUnsafe() {
            try {
                try {
                    return Unsafe.getUnsafe();
                } catch (PrivilegedActionException e10) {
                    throw new RuntimeException("Could not initialize intrinsics", e10.getCause());
                }
            } catch (SecurityException unused) {
                return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: com.google.common.hash.LittleEndianByteArray.UnsafeByteArray.3
                    @Override // java.security.PrivilegedExceptionAction
                    public Unsafe run() throws Exception {
                        for (Field field : Unsafe.class.getDeclaredFields()) {
                            field.setAccessible(true);
                            Object obj = field.get(null);
                            if (Unsafe.class.isInstance(obj)) {
                                return (Unsafe) Unsafe.class.cast(obj);
                            }
                        }
                        throw new NoSuchFieldError("the Unsafe");
                    }
                });
            }
        }
    }

    static {
        LittleEndianBytes littleEndianBytes = JavaLittleEndianBytes.INSTANCE;
        try {
            if ("amd64".equals(System.getProperty("os.arch"))) {
                littleEndianBytes = ByteOrder.nativeOrder().equals(ByteOrder.LITTLE_ENDIAN) ? UnsafeByteArray.UNSAFE_LITTLE_ENDIAN : UnsafeByteArray.UNSAFE_BIG_ENDIAN;
            }
        } catch (Throwable unused) {
        }
        byteArray = littleEndianBytes;
    }

    private LittleEndianByteArray() {
    }

    public static int load32(byte[] bArr, int i10) {
        return ((bArr[i10 + 3] & 255) << 24) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16);
    }

    public static long load64(byte[] bArr, int i10) {
        return byteArray.getLongLittleEndian(bArr, i10);
    }

    public static long load64Safely(byte[] bArr, int i10, int i11) {
        int iMin = Math.min(i11, 8);
        long j10 = 0;
        for (int i12 = 0; i12 < iMin; i12++) {
            j10 |= (((long) bArr[i10 + i12]) & 255) << (i12 * 8);
        }
        return j10;
    }

    public static void store64(byte[] bArr, int i10, long j10) {
        byteArray.putLongLittleEndian(bArr, i10, j10);
    }

    public static boolean usingUnsafe() {
        return byteArray instanceof UnsafeByteArray;
    }
}
