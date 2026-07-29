package pt;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.ByteOrder;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.p;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes6.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile b f47056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f47057b = new C0538b();

    /* JADX INFO: renamed from: pt.b$b, reason: collision with other inner class name */
    public static class C0538b extends b {
        public C0538b() {
        }

        @Override // pt.b
        public int c(byte[] bArr, int i10) {
            return (bArr[i10] << 24) | (bArr[i10 + 3] & 255) | ((bArr[i10 + 2] & 255) << 8) | ((bArr[i10 + 1] & 255) << 16);
        }

        @Override // pt.b
        public int d(byte[] bArr, int i10) {
            return (bArr[i10 + 3] << 24) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16);
        }

        @Override // pt.b
        public int e(char[] cArr, int i10) {
            return ((cArr[i10 + 1] & p.f37930c) << 16) | (cArr[i10] & p.f37930c);
        }

        @Override // pt.b
        public long f(byte[] bArr, int i10) {
            return (((long) bArr[i10]) << 56) | ((long) ((bArr[i10 + 7] & 255) | ((bArr[i10 + 6] & 255) << 8) | ((bArr[i10 + 5] & 255) << 16))) | ((((long) bArr[i10 + 4]) & 255) << 24) | ((((long) bArr[i10 + 3]) & 255) << 32) | ((((long) bArr[i10 + 2]) & 255) << 40) | ((((long) bArr[i10 + 1]) & 255) << 48);
        }

        @Override // pt.b
        public long g(byte[] bArr, int i10) {
            return (((long) bArr[i10 + 7]) << 56) | ((long) ((bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16))) | ((((long) bArr[i10 + 3]) & 255) << 24) | ((((long) bArr[i10 + 4]) & 255) << 32) | ((((long) bArr[i10 + 5]) & 255) << 40) | ((((long) bArr[i10 + 6]) & 255) << 48);
        }
    }

    public static class c extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final boolean f47058c = ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final boolean f47059d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final Unsafe f47060e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final long f47061f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final long f47062g;

        static {
            boolean zK = k();
            f47059d = zK;
            if (!zK) {
                f47060e = null;
                f47061f = 0L;
                f47062g = 0L;
                return;
            }
            Unsafe unsafeL = l();
            f47060e = unsafeL;
            if (unsafeL != null) {
                f47061f = unsafeL.arrayBaseOffset(byte[].class);
                f47062g = unsafeL.arrayBaseOffset(char[].class);
            } else {
                f47061f = 0L;
                f47062g = 0L;
            }
        }

        public c() {
        }

        public static boolean j() {
            String property = System.getProperty("os.arch");
            return property != null && property.matches("^(i[3-6]86|x86(_64)?|x64|amd64)$");
        }

        public static boolean k() {
            String property = System.getProperty("java.vendor");
            if (property != null && property.contains("Android")) {
                return j();
            }
            try {
                Method declaredMethod = Class.forName("java.nio.Bits", false, ClassLoader.getSystemClassLoader()).getDeclaredMethod("unaligned", new Class[0]);
                declaredMethod.setAccessible(true);
                return Boolean.TRUE.equals(declaredMethod.invoke(null, new Object[0]));
            } catch (Throwable unused) {
                return j();
            }
        }

        public static Unsafe l() {
            Field declaredField;
            try {
                try {
                    declaredField = Unsafe.class.getDeclaredField("theUnsafe");
                } catch (NoSuchElementException unused) {
                    declaredField = Unsafe.class.getDeclaredField("THE_ONE");
                }
                declaredField.setAccessible(true);
                Unsafe unsafe = (Unsafe) declaredField.get(null);
                int i10 = unsafe.getInt(new byte[]{i1.a.f31732w7, -2, -70, -66}, unsafe.arrayBaseOffset(byte[].class));
                if (i10 == -889275714) {
                    if (f47058c) {
                        return unsafe;
                    }
                    System.err.println("Big endian confusion");
                } else if (i10 == -1095041334) {
                    if (!f47058c) {
                        return unsafe;
                    }
                    System.err.println("Little endian confusion");
                }
            } catch (Throwable unused2) {
            }
            return null;
        }

        @Override // pt.b
        public int c(byte[] bArr, int i10) {
            int i11 = f47060e.getInt(bArr, f47061f + ((long) i10));
            return f47058c ? i11 : Integer.reverseBytes(i11);
        }

        @Override // pt.b
        public int d(byte[] bArr, int i10) {
            int i11 = f47060e.getInt(bArr, f47061f + ((long) i10));
            return f47058c ? Integer.reverseBytes(i11) : i11;
        }

        @Override // pt.b
        public int e(char[] cArr, int i10) {
            int i11 = f47060e.getInt(cArr, f47062g + ((long) (i10 << 2)));
            return f47058c ? Integer.reverseBytes(i11) : i11;
        }

        @Override // pt.b
        public long f(byte[] bArr, int i10) {
            long j10 = f47060e.getLong(bArr, f47061f + ((long) i10));
            return f47058c ? j10 : Long.reverseBytes(j10);
        }

        @Override // pt.b
        public long g(byte[] bArr, int i10) {
            long j10 = f47060e.getLong(bArr, f47061f + ((long) i10));
            return f47058c ? Long.reverseBytes(j10) : j10;
        }
    }

    public static b a() {
        b bVar = f47056a;
        return bVar == null ? f47057b : bVar;
    }

    public static b b() {
        return f47057b;
    }

    public static boolean h() {
        if (f47056a != null || c.f47060e == null) {
            return false;
        }
        synchronized (b.class) {
            if (f47056a != null) {
                return true;
            }
            try {
                f47056a = new c();
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
    }

    public abstract int c(byte[] bArr, int i10);

    public abstract int d(byte[] bArr, int i10);

    public abstract int e(char[] cArr, int i10);

    public abstract long f(byte[] bArr, int i10);

    public abstract long g(byte[] bArr, int i10);
}
