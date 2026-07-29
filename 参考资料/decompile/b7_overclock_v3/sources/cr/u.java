package cr;

import com.blankj.utilcode.util.i0;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.security.spec.AlgorithmParameterSpec;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class u implements AlgorithmParameterSpec {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f25856b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f25857c = 4;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f25858d = 8;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f25859e = 12;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f25860f = 16;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f25861g = 20;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f25862h = 48;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f25863i = 63;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map f25864a;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Map f25865a = new HashMap();

        public b() {
        }

        public b(u uVar) {
            for (Integer num : uVar.f25864a.keySet()) {
                this.f25865a.put(num, uVar.f25864a.get(num));
            }
        }

        public u a() {
            return new u(this.f25865a);
        }

        public b b(int i10, byte[] bArr) {
            if (bArr == null) {
                throw new IllegalArgumentException("Parameter value must not be null.");
            }
            if (i10 != 0 && (i10 <= 4 || i10 >= 63 || i10 == 48)) {
                throw new IllegalArgumentException("Parameter types must be in the range 0,5..47,49..62.");
            }
            if (i10 == 4) {
                throw new IllegalArgumentException("Parameter type 4 is reserved for internal use.");
            }
            this.f25865a.put(org.bouncycastle.util.j.g(i10), bArr);
            return this;
        }

        public b c(byte[] bArr) {
            return b(0, bArr);
        }

        public b d(byte[] bArr) {
            return b(16, bArr);
        }

        public b e(byte[] bArr) {
            return b(20, bArr);
        }

        public b f(Date date, String str, String str2) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(byteArrayOutputStream, "UTF-8");
                outputStreamWriter.write(new SimpleDateFormat("YYYYMMDD").format(date));
                outputStreamWriter.write(i0.f11861z);
                outputStreamWriter.write(str);
                outputStreamWriter.write(i0.f11861z);
                outputStreamWriter.write(str2);
                outputStreamWriter.close();
                return b(8, byteArrayOutputStream.toByteArray());
            } catch (IOException e10) {
                throw new IllegalStateException("Byte I/O failed: " + e10);
            }
        }

        public b g(Date date, Locale locale, String str, String str2) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(byteArrayOutputStream, "UTF-8");
                outputStreamWriter.write(new SimpleDateFormat("YYYYMMDD", locale).format(date));
                outputStreamWriter.write(i0.f11861z);
                outputStreamWriter.write(str);
                outputStreamWriter.write(i0.f11861z);
                outputStreamWriter.write(str2);
                outputStreamWriter.close();
                return b(8, byteArrayOutputStream.toByteArray());
            } catch (IOException e10) {
                throw new IllegalStateException("Byte I/O failed: " + e10);
            }
        }

        public b h(byte[] bArr) {
            return b(8, bArr);
        }

        public b i(byte[] bArr) {
            return b(12, bArr);
        }
    }

    public u() {
        this(new HashMap());
    }

    public u(Map map) {
        this.f25864a = Collections.unmodifiableMap(map);
    }

    public byte[] b() {
        return org.bouncycastle.util.a.p((byte[]) this.f25864a.get(org.bouncycastle.util.j.g(0)));
    }

    public byte[] c() {
        return org.bouncycastle.util.a.p((byte[]) this.f25864a.get(org.bouncycastle.util.j.g(16)));
    }

    public byte[] d() {
        return org.bouncycastle.util.a.p((byte[]) this.f25864a.get(org.bouncycastle.util.j.g(20)));
    }

    public Map e() {
        return this.f25864a;
    }

    public byte[] f() {
        return org.bouncycastle.util.a.p((byte[]) this.f25864a.get(org.bouncycastle.util.j.g(8)));
    }

    public byte[] g() {
        return org.bouncycastle.util.a.p((byte[]) this.f25864a.get(org.bouncycastle.util.j.g(12)));
    }
}
