package androidx.work;

import android.annotation.SuppressLint;
import androidx.annotation.RestrictTo;
import androidx.room.h3;
import g.i1;
import g.n0;
import g.p0;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f8359b = l.f("Data");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f8360c = new a().a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SuppressLint({"MinMaxConstant"})
    public static final int f8361d = 10240;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, Object> f8362a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Map<String, Object> f8363a = new HashMap();

        @n0
        public d a() throws Throwable {
            d dVar = new d((Map<String, ?>) this.f8363a);
            d.F(dVar);
            return dVar;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @n0
        public a b(@n0 String key, @p0 Object value) {
            if (value == null) {
                this.f8363a.put(key, null);
            } else {
                Class<?> cls = value.getClass();
                if (cls == Boolean.class || cls == Byte.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == String.class || cls == Boolean[].class || cls == Byte[].class || cls == Integer[].class || cls == Long[].class || cls == Float[].class || cls == Double[].class || cls == String[].class) {
                    this.f8363a.put(key, value);
                } else if (cls == boolean[].class) {
                    this.f8363a.put(key, d.a((boolean[]) value));
                } else if (cls == byte[].class) {
                    this.f8363a.put(key, d.b((byte[]) value));
                } else if (cls == int[].class) {
                    this.f8363a.put(key, d.e((int[]) value));
                } else if (cls == long[].class) {
                    this.f8363a.put(key, d.f((long[]) value));
                } else if (cls == float[].class) {
                    this.f8363a.put(key, d.d((float[]) value));
                } else {
                    if (cls != double[].class) {
                        throw new IllegalArgumentException(String.format("Key %s has invalid type %s", key, cls));
                    }
                    this.f8363a.put(key, d.c((double[]) value));
                }
            }
            return this;
        }

        @n0
        public a c(@n0 d data) {
            d(data.f8362a);
            return this;
        }

        @n0
        public a d(@n0 Map<String, Object> values) {
            for (Map.Entry<String, Object> entry : values.entrySet()) {
                b(entry.getKey(), entry.getValue());
            }
            return this;
        }

        @n0
        public a e(@n0 String key, boolean value) {
            this.f8363a.put(key, Boolean.valueOf(value));
            return this;
        }

        @n0
        public a f(@n0 String key, @n0 boolean[] value) {
            this.f8363a.put(key, d.a(value));
            return this;
        }

        @n0
        public a g(@n0 String key, byte value) {
            this.f8363a.put(key, Byte.valueOf(value));
            return this;
        }

        @n0
        public a h(@n0 String key, @n0 byte[] value) {
            this.f8363a.put(key, d.b(value));
            return this;
        }

        @n0
        public a i(@n0 String key, double value) {
            this.f8363a.put(key, Double.valueOf(value));
            return this;
        }

        @n0
        public a j(@n0 String key, @n0 double[] value) {
            this.f8363a.put(key, d.c(value));
            return this;
        }

        @n0
        public a k(@n0 String key, float value) {
            this.f8363a.put(key, Float.valueOf(value));
            return this;
        }

        @n0
        public a l(@n0 String key, @n0 float[] value) {
            this.f8363a.put(key, d.d(value));
            return this;
        }

        @n0
        public a m(@n0 String key, int value) {
            this.f8363a.put(key, Integer.valueOf(value));
            return this;
        }

        @n0
        public a n(@n0 String key, @n0 int[] value) {
            this.f8363a.put(key, d.e(value));
            return this;
        }

        @n0
        public a o(@n0 String key, long value) {
            this.f8363a.put(key, Long.valueOf(value));
            return this;
        }

        @n0
        public a p(@n0 String key, @n0 long[] value) {
            this.f8363a.put(key, d.f(value));
            return this;
        }

        @n0
        public a q(@n0 String key, @p0 String value) {
            this.f8363a.put(key, value);
            return this;
        }

        @n0
        public a r(@n0 String key, @n0 String[] value) {
            this.f8363a.put(key, value);
            return this;
        }
    }

    public d() {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @h3
    @n0
    public static byte[] F(@n0 d data) throws Throwable {
        ObjectOutputStream objectOutputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream2 = null;
        try {
            try {
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException unused) {
        }
        try {
            objectOutputStream.writeInt(data.D());
            for (Map.Entry<String, Object> entry : data.f8362a.entrySet()) {
                objectOutputStream.writeUTF(entry.getKey());
                objectOutputStream.writeObject(entry.getValue());
            }
            try {
                objectOutputStream.close();
            } catch (IOException unused2) {
            }
            try {
                byteArrayOutputStream.close();
            } catch (IOException unused3) {
            }
            if (byteArrayOutputStream.size() <= 10240) {
                return byteArrayOutputStream.toByteArray();
            }
            throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
        } catch (IOException unused4) {
            objectOutputStream2 = objectOutputStream;
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (objectOutputStream2 != null) {
                try {
                    objectOutputStream2.close();
                } catch (IOException unused5) {
                }
            }
            try {
                byteArrayOutputStream.close();
            } catch (IOException unused6) {
            }
            return byteArray;
        } catch (Throwable th3) {
            th = th3;
            objectOutputStream2 = objectOutputStream;
            if (objectOutputStream2 != null) {
                try {
                    objectOutputStream2.close();
                } catch (IOException unused7) {
                }
            }
            try {
                byteArrayOutputStream.close();
                throw th;
            } catch (IOException unused8) {
                throw th;
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @n0
    public static Boolean[] a(@n0 boolean[] value) {
        Boolean[] boolArr = new Boolean[value.length];
        for (int i10 = 0; i10 < value.length; i10++) {
            boolArr[i10] = Boolean.valueOf(value[i10]);
        }
        return boolArr;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @n0
    public static Byte[] b(@n0 byte[] value) {
        Byte[] bArr = new Byte[value.length];
        for (int i10 = 0; i10 < value.length; i10++) {
            bArr[i10] = Byte.valueOf(value[i10]);
        }
        return bArr;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @n0
    public static Double[] c(@n0 double[] value) {
        Double[] dArr = new Double[value.length];
        for (int i10 = 0; i10 < value.length; i10++) {
            dArr[i10] = Double.valueOf(value[i10]);
        }
        return dArr;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @n0
    public static Float[] d(@n0 float[] value) {
        Float[] fArr = new Float[value.length];
        for (int i10 = 0; i10 < value.length; i10++) {
            fArr[i10] = Float.valueOf(value[i10]);
        }
        return fArr;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @n0
    public static Integer[] e(@n0 int[] value) {
        Integer[] numArr = new Integer[value.length];
        for (int i10 = 0; i10 < value.length; i10++) {
            numArr[i10] = Integer.valueOf(value[i10]);
        }
        return numArr;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @n0
    public static Long[] f(@n0 long[] value) {
        Long[] lArr = new Long[value.length];
        for (int i10 = 0; i10 < value.length; i10++) {
            lArr[i10] = Long.valueOf(value[i10]);
        }
        return lArr;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @n0
    public static byte[] g(@n0 Byte[] array) {
        byte[] bArr = new byte[array.length];
        for (int i10 = 0; i10 < array.length; i10++) {
            bArr[i10] = array[i10].byteValue();
        }
        return bArr;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @n0
    public static double[] h(@n0 Double[] array) {
        double[] dArr = new double[array.length];
        for (int i10 = 0; i10 < array.length; i10++) {
            dArr[i10] = array[i10].doubleValue();
        }
        return dArr;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @n0
    public static float[] i(@n0 Float[] array) {
        float[] fArr = new float[array.length];
        for (int i10 = 0; i10 < array.length; i10++) {
            fArr[i10] = array[i10].floatValue();
        }
        return fArr;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @n0
    public static int[] j(@n0 Integer[] array) {
        int[] iArr = new int[array.length];
        for (int i10 = 0; i10 < array.length; i10++) {
            iArr[i10] = array[i10].intValue();
        }
        return iArr;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @n0
    public static long[] k(@n0 Long[] array) {
        long[] jArr = new long[array.length];
        for (int i10 = 0; i10 < array.length; i10++) {
            jArr[i10] = array[i10].longValue();
        }
        return jArr;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @n0
    public static boolean[] l(@n0 Boolean[] array) {
        boolean[] zArr = new boolean[array.length];
        for (int i10 = 0; i10 < array.length; i10++) {
            zArr[i10] = array[i10].booleanValue();
        }
        return zArr;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:29:0x002c
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1182)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    @androidx.room.h3
    @g.n0
    public static androidx.work.d m(@g.n0 byte[] r5) {
        /*
            int r0 = r5.length
            r1 = 10240(0x2800, float:1.4349E-41)
            if (r0 > r1) goto L4c
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream
            r1.<init>(r5)
            r5 = 0
            java.io.ObjectInputStream r2 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L34 java.lang.Throwable -> L40
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L34 java.lang.Throwable -> L40
            int r5 = r2.readInt()     // Catch: java.lang.Throwable -> L30 java.lang.Throwable -> L32
        L19:
            if (r5 <= 0) goto L29
            java.lang.String r3 = r2.readUTF()     // Catch: java.lang.Throwable -> L30 java.lang.Throwable -> L32
            java.lang.Object r4 = r2.readObject()     // Catch: java.lang.Throwable -> L30 java.lang.Throwable -> L32
            r0.put(r3, r4)     // Catch: java.lang.Throwable -> L30 java.lang.Throwable -> L32
            int r5 = r5 + (-1)
            goto L19
        L29:
            r2.close()     // Catch: java.io.IOException -> L2c
        L2c:
            r1.close()     // Catch: java.io.IOException -> L46
            goto L46
        L30:
            r5 = move-exception
            goto L37
        L32:
            r5 = r2
            goto L40
        L34:
            r0 = move-exception
            r2 = r5
            r5 = r0
        L37:
            if (r2 == 0) goto L3c
            r2.close()     // Catch: java.io.IOException -> L3c
        L3c:
            r1.close()     // Catch: java.io.IOException -> L3f
        L3f:
            throw r5
        L40:
            if (r5 == 0) goto L2c
            r5.close()     // Catch: java.io.IOException -> L2c
            goto L2c
        L46:
            androidx.work.d r5 = new androidx.work.d
            r5.<init>(r0)
            return r5
        L4c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "Data cannot occupy more than 10240 bytes when serialized"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.d.m(byte[]):androidx.work.d");
    }

    @p0
    public String A(@n0 String key) {
        Object obj = this.f8362a.get(key);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    @p0
    public String[] B(@n0 String key) {
        Object obj = this.f8362a.get(key);
        if (obj instanceof String[]) {
            return (String[]) obj;
        }
        return null;
    }

    public <T> boolean C(@n0 String key, @n0 Class<T> klass) {
        Object obj = this.f8362a.get(key);
        return obj != null && klass.isAssignableFrom(obj.getClass());
    }

    @i1
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int D() {
        return this.f8362a.size();
    }

    @n0
    public byte[] E() {
        return F(this);
    }

    public boolean equals(Object o10) {
        if (this == o10) {
            return true;
        }
        if (o10 == null || d.class != o10.getClass()) {
            return false;
        }
        d dVar = (d) o10;
        Set<String> setKeySet = this.f8362a.keySet();
        if (!setKeySet.equals(dVar.f8362a.keySet())) {
            return false;
        }
        for (String str : setKeySet) {
            Object obj = this.f8362a.get(str);
            Object obj2 = dVar.f8362a.get(str);
            if (!((obj == null || obj2 == null) ? obj == obj2 : ((obj instanceof Object[]) && (obj2 instanceof Object[])) ? Arrays.deepEquals((Object[]) obj, (Object[]) obj2) : obj.equals(obj2))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return this.f8362a.hashCode() * 31;
    }

    public boolean n(@n0 String key, boolean defaultValue) {
        Object obj = this.f8362a.get(key);
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : defaultValue;
    }

    @p0
    public boolean[] o(@n0 String key) {
        Object obj = this.f8362a.get(key);
        if (obj instanceof Boolean[]) {
            return l((Boolean[]) obj);
        }
        return null;
    }

    public byte p(@n0 String key, byte defaultValue) {
        Object obj = this.f8362a.get(key);
        return obj instanceof Byte ? ((Byte) obj).byteValue() : defaultValue;
    }

    @p0
    public byte[] q(@n0 String key) {
        Object obj = this.f8362a.get(key);
        if (obj instanceof Byte[]) {
            return g((Byte[]) obj);
        }
        return null;
    }

    public double r(@n0 String key, double defaultValue) {
        Object obj = this.f8362a.get(key);
        return obj instanceof Double ? ((Double) obj).doubleValue() : defaultValue;
    }

    @p0
    public double[] s(@n0 String key) {
        Object obj = this.f8362a.get(key);
        if (obj instanceof Double[]) {
            return h((Double[]) obj);
        }
        return null;
    }

    public float t(@n0 String key, float defaultValue) {
        Object obj = this.f8362a.get(key);
        return obj instanceof Float ? ((Float) obj).floatValue() : defaultValue;
    }

    @n0
    public String toString() {
        StringBuilder sb2 = new StringBuilder("Data {");
        if (!this.f8362a.isEmpty()) {
            for (String str : this.f8362a.keySet()) {
                sb2.append(str);
                sb2.append(" : ");
                Object obj = this.f8362a.get(str);
                if (obj instanceof Object[]) {
                    sb2.append(Arrays.toString((Object[]) obj));
                } else {
                    sb2.append(obj);
                }
                sb2.append(", ");
            }
        }
        sb2.append(zc.a.f58317e);
        return sb2.toString();
    }

    @p0
    public float[] u(@n0 String key) {
        Object obj = this.f8362a.get(key);
        if (obj instanceof Float[]) {
            return i((Float[]) obj);
        }
        return null;
    }

    public int v(@n0 String key, int defaultValue) {
        Object obj = this.f8362a.get(key);
        return obj instanceof Integer ? ((Integer) obj).intValue() : defaultValue;
    }

    @p0
    public int[] w(@n0 String key) {
        Object obj = this.f8362a.get(key);
        if (obj instanceof Integer[]) {
            return j((Integer[]) obj);
        }
        return null;
    }

    @n0
    public Map<String, Object> x() {
        return Collections.unmodifiableMap(this.f8362a);
    }

    public long y(@n0 String key, long defaultValue) {
        Object obj = this.f8362a.get(key);
        return obj instanceof Long ? ((Long) obj).longValue() : defaultValue;
    }

    @p0
    public long[] z(@n0 String key) {
        Object obj = this.f8362a.get(key);
        if (obj instanceof Long[]) {
            return k((Long[]) obj);
        }
        return null;
    }

    public d(@n0 d other) {
        this.f8362a = new HashMap(other.f8362a);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public d(@n0 Map<String, ?> values) {
        this.f8362a = new HashMap(values);
    }
}
