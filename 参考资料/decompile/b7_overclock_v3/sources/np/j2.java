package np;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class j2 implements org.bouncycastle.crypto.k {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f42449b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f42450c = 4;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f42451d = 8;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f42452e = 12;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f42453f = 16;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f42454g = 20;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f42455h = 48;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f42456i = 63;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Hashtable f42457a;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Hashtable f42458a = new Hashtable();

        public b() {
        }

        public b(Hashtable hashtable) {
            Enumeration enumerationKeys = hashtable.keys();
            while (enumerationKeys.hasMoreElements()) {
                Integer num = (Integer) enumerationKeys.nextElement();
                this.f42458a.put(num, hashtable.get(num));
            }
        }

        public b(j2 j2Var) {
            Enumeration enumerationKeys = j2Var.f42457a.keys();
            while (enumerationKeys.hasMoreElements()) {
                Integer num = (Integer) enumerationKeys.nextElement();
                this.f42458a.put(num, j2Var.f42457a.get(num));
            }
        }

        public j2 a() {
            return new j2(this.f42458a);
        }

        public b b(int i10, byte[] bArr) {
            if (bArr == null) {
                throw new IllegalArgumentException("Parameter value must not be null.");
            }
            if (i10 != 0 && (i10 < 4 || i10 >= 63 || i10 == 48)) {
                throw new IllegalArgumentException("Parameter types must be in the range 0,5..47,49..62.");
            }
            if (i10 == 4) {
                throw new IllegalArgumentException("Parameter type 4 is reserved for internal use.");
            }
            this.f42458a.put(org.bouncycastle.util.j.g(i10), bArr);
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
                outputStreamWriter.write(com.blankj.utilcode.util.i0.f11861z);
                outputStreamWriter.write(str);
                outputStreamWriter.write(com.blankj.utilcode.util.i0.f11861z);
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
                outputStreamWriter.write(com.blankj.utilcode.util.i0.f11861z);
                outputStreamWriter.write(str);
                outputStreamWriter.write(com.blankj.utilcode.util.i0.f11861z);
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

    public j2() {
        this(new Hashtable());
    }

    public j2(Hashtable hashtable) {
        this.f42457a = hashtable;
    }

    public byte[] b() {
        return (byte[]) this.f42457a.get(org.bouncycastle.util.j.g(0));
    }

    public byte[] c() {
        return (byte[]) this.f42457a.get(org.bouncycastle.util.j.g(16));
    }

    public byte[] d() {
        return (byte[]) this.f42457a.get(org.bouncycastle.util.j.g(20));
    }

    public Hashtable e() {
        return this.f42457a;
    }

    public byte[] f() {
        return (byte[]) this.f42457a.get(org.bouncycastle.util.j.g(8));
    }

    public byte[] g() {
        return (byte[]) this.f42457a.get(org.bouncycastle.util.j.g(12));
    }
}
