package org.bouncycastle.i18n;

import com.blankj.utilcode.util.i0;
import j3.b;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class MissingEntryException extends RuntimeException {
    private String debugMsg;
    public final String key;
    public final ClassLoader loader;
    public final Locale locale;
    public final String resource;

    public MissingEntryException(String str, String str2, String str3, Locale locale, ClassLoader classLoader) {
        super(str);
        this.resource = str2;
        this.key = str3;
        this.locale = locale;
        this.loader = classLoader;
    }

    public MissingEntryException(String str, Throwable th2, String str2, String str3, Locale locale, ClassLoader classLoader) {
        super(str, th2);
        this.resource = str2;
        this.key = str3;
        this.locale = locale;
        this.loader = classLoader;
    }

    public ClassLoader a() {
        return this.loader;
    }

    public String b() {
        if (this.debugMsg == null) {
            this.debugMsg = "Can not find entry " + this.key + " in resource file " + this.resource + " for the locale " + this.locale + b.f36044h;
            ClassLoader classLoader = this.loader;
            if (classLoader instanceof URLClassLoader) {
                URL[] uRLs = ((URLClassLoader) classLoader).getURLs();
                this.debugMsg += " The following entries in the classpath were searched: ";
                for (int i10 = 0; i10 != uRLs.length; i10++) {
                    this.debugMsg += uRLs[i10] + i0.f11861z;
                }
            }
        }
        return this.debugMsg;
    }

    public String c() {
        return this.key;
    }

    public Locale d() {
        return this.locale;
    }

    public String f() {
        return this.resource;
    }
}
