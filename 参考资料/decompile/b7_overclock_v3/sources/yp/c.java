package yp;

import com.blankj.utilcode.util.i0;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.Format;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.TimeZone;
import org.bouncycastle.i18n.MissingEntryException;
import zp.f;

/* JADX INFO: loaded from: classes5.dex */
public class c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f57454h = "ISO-8859-1";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f57455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f57456b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f57457c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f57458d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f57459e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public zp.a f57460f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ClassLoader f57461g;

    public class a {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f57462h = 0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f57463i = 1;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final int f57464j = 2;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public zp.a f57465a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean[] f57466b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int[] f57467c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Object[] f57468d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Object[] f57469e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Object[] f57470f;

        public a(c cVar) {
            this(new Object[0]);
        }

        public a(Object[] objArr) {
            this.f57465a = null;
            this.f57468d = objArr;
            this.f57469e = new Object[objArr.length];
            this.f57470f = new Object[objArr.length];
            this.f57466b = new boolean[objArr.length];
            this.f57467c = new int[objArr.length];
            for (int i10 = 0; i10 < objArr.length; i10++) {
                if (objArr[i10] instanceof zp.d) {
                    this.f57469e[i10] = ((zp.d) objArr[i10]).a();
                    this.f57467c[i10] = 0;
                } else if (objArr[i10] instanceof zp.e) {
                    this.f57469e[i10] = ((zp.e) objArr[i10]).a();
                    if (objArr[i10] instanceof f) {
                        this.f57467c[i10] = 2;
                    } else {
                        this.f57467c[i10] = 1;
                    }
                } else {
                    this.f57469e[i10] = objArr[i10];
                    this.f57467c[i10] = 1;
                }
                this.f57466b[i10] = this.f57469e[i10] instanceof b;
            }
        }

        public final Object a(int i10, Object obj) {
            zp.a aVar = this.f57465a;
            if (aVar != null) {
                if (obj == null) {
                    obj = i0.f11859x;
                }
                if (i10 != 0) {
                    if (i10 == 1) {
                        return aVar.a(obj.toString());
                    }
                    if (i10 != 2) {
                        return null;
                    }
                    return aVar.b(obj.toString());
                }
            }
            return obj;
        }

        public Object[] b() {
            return this.f57468d;
        }

        public zp.a c() {
            return this.f57465a;
        }

        public Object[] d(Locale locale) {
            Object objA;
            Object[] objArr = new Object[this.f57469e.length];
            int i10 = 0;
            while (true) {
                Object[] objArr2 = this.f57469e;
                if (i10 >= objArr2.length) {
                    return objArr;
                }
                Object[] objArr3 = this.f57470f;
                if (objArr3[i10] != null) {
                    objA = objArr3[i10];
                } else {
                    Object obj = objArr2[i10];
                    if (this.f57466b[i10]) {
                        objA = a(this.f57467c[i10], ((b) obj).n(locale));
                    } else {
                        objA = a(this.f57467c[i10], obj);
                        this.f57470f[i10] = objA;
                    }
                }
                objArr[i10] = objA;
                i10++;
            }
        }

        public boolean e() {
            return this.f57469e.length == 0;
        }

        public void f(zp.a aVar) {
            if (aVar != this.f57465a) {
                for (int i10 = 0; i10 < this.f57469e.length; i10++) {
                    this.f57470f[i10] = null;
                }
            }
            this.f57465a = aVar;
        }
    }

    public c(String str, String str2) throws NullPointerException {
        this.f57457c = "ISO-8859-1";
        this.f57459e = null;
        this.f57460f = null;
        this.f57461g = null;
        if (str == null || str2 == null) {
            throw null;
        }
        this.f57455a = str2;
        this.f57456b = str;
        this.f57458d = new a(this);
    }

    public c(String str, String str2, String str3) throws UnsupportedEncodingException, NullPointerException {
        this.f57457c = "ISO-8859-1";
        this.f57459e = null;
        this.f57460f = null;
        this.f57461g = null;
        if (str == null || str2 == null) {
            throw null;
        }
        this.f57455a = str2;
        this.f57456b = str;
        this.f57458d = new a(this);
        if (Charset.isSupported(str3)) {
            this.f57457c = str3;
            return;
        }
        throw new UnsupportedEncodingException("The encoding \"" + str3 + "\" is not supported.");
    }

    public c(String str, String str2, String str3, Object[] objArr) throws UnsupportedEncodingException, NullPointerException {
        this.f57457c = "ISO-8859-1";
        this.f57459e = null;
        this.f57460f = null;
        this.f57461g = null;
        if (str == null || str2 == null || objArr == null) {
            throw null;
        }
        this.f57455a = str2;
        this.f57456b = str;
        this.f57458d = new a(objArr);
        if (Charset.isSupported(str3)) {
            this.f57457c = str3;
            return;
        }
        throw new UnsupportedEncodingException("The encoding \"" + str3 + "\" is not supported.");
    }

    public c(String str, String str2, Object[] objArr) throws NullPointerException {
        this.f57457c = "ISO-8859-1";
        this.f57459e = null;
        this.f57460f = null;
        this.f57461g = null;
        if (str == null || str2 == null || objArr == null) {
            throw null;
        }
        this.f57455a = str2;
        this.f57456b = str;
        this.f57458d = new a(objArr);
    }

    public String a(String str, Locale locale) {
        if (this.f57459e == null) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(str);
        Object[] objArrD = this.f57459e.d(locale);
        for (Object obj : objArrD) {
            stringBuffer.append(obj);
        }
        return stringBuffer.toString();
    }

    public String b(String str, Object[] objArr, Locale locale, TimeZone timeZone) {
        MessageFormat messageFormat = new MessageFormat(i0.f11861z);
        messageFormat.setLocale(locale);
        messageFormat.applyPattern(str);
        if (!timeZone.equals(TimeZone.getDefault())) {
            Format[] formats = messageFormat.getFormats();
            for (int i10 = 0; i10 < formats.length; i10++) {
                if (formats[i10] instanceof DateFormat) {
                    DateFormat dateFormat = (DateFormat) formats[i10];
                    dateFormat.setTimeZone(timeZone);
                    messageFormat.setFormat(i10, dateFormat);
                }
            }
        }
        return messageFormat.format(objArr);
    }

    public Object[] c() {
        return this.f57458d.b();
    }

    public ClassLoader d() {
        return this.f57461g;
    }

    public String e(String str, Locale locale, TimeZone timeZone) throws MissingEntryException {
        String str2 = this.f57455a;
        if (str != null) {
            str2 = str2 + j3.b.f36044h + str;
        }
        String str3 = str2;
        try {
            ClassLoader classLoader = this.f57461g;
            String string = (classLoader == null ? ResourceBundle.getBundle(this.f57456b, locale) : ResourceBundle.getBundle(this.f57456b, locale, classLoader)).getString(str3);
            if (!this.f57457c.equals("ISO-8859-1")) {
                string = new String(string.getBytes("ISO-8859-1"), this.f57457c);
            }
            if (!this.f57458d.e()) {
                string = b(string, this.f57458d.d(locale), locale, timeZone);
            }
            return a(string, locale);
        } catch (UnsupportedEncodingException e10) {
            throw new RuntimeException(e10);
        } catch (MissingResourceException unused) {
            String str4 = "Can't find entry " + str3 + " in resource file " + this.f57456b + j3.b.f36044h;
            String str5 = this.f57456b;
            ClassLoader classLoaderD = this.f57461g;
            if (classLoaderD == null) {
                classLoaderD = d();
            }
            throw new MissingEntryException(str4, str5, str3, locale, classLoaderD);
        }
    }

    public Object[] f() {
        a aVar = this.f57459e;
        if (aVar == null) {
            return null;
        }
        return aVar.b();
    }

    public zp.a g() {
        return this.f57460f;
    }

    public String h() {
        return this.f57455a;
    }

    public String i() {
        return this.f57456b;
    }

    public void j(ClassLoader classLoader) {
        this.f57461g = classLoader;
    }

    public void k(Object obj) {
        l(new Object[]{obj});
    }

    public void l(Object[] objArr) {
        if (objArr == null) {
            this.f57459e = null;
            return;
        }
        a aVar = new a(objArr);
        this.f57459e = aVar;
        aVar.f(this.f57460f);
    }

    public void m(zp.a aVar) {
        this.f57458d.f(aVar);
        a aVar2 = this.f57459e;
        if (aVar2 != null) {
            aVar2.f(aVar);
        }
        this.f57460f = aVar;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Resource: \"");
        stringBuffer.append(this.f57456b);
        stringBuffer.append("\" Id: \"");
        stringBuffer.append(this.f57455a);
        stringBuffer.append("\"");
        stringBuffer.append(" Arguments: ");
        stringBuffer.append(this.f57458d.b().length);
        stringBuffer.append(" normal");
        a aVar = this.f57459e;
        if (aVar != null && aVar.b().length > 0) {
            stringBuffer.append(", ");
            stringBuffer.append(this.f57459e.b().length);
            stringBuffer.append(" extra");
        }
        stringBuffer.append(" Encoding: ");
        stringBuffer.append(this.f57457c);
        stringBuffer.append(" ClassLoader: ");
        stringBuffer.append(this.f57461g);
        return stringBuffer.toString();
    }
}
