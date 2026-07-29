package org.bouncycastle.util;

import java.math.BigInteger;
import java.security.AccessControlException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.Security;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes6.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f46048a = new ThreadLocal();

    public static class a implements PrivilegedAction {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f46049a;

        public a(String str) {
            this.f46049a = str;
        }

        @Override // java.security.PrivilegedAction
        public Object run() {
            return Security.getProperty(this.f46049a);
        }
    }

    public static class b implements PrivilegedAction {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f46050a;

        public b(String str) {
            this.f46050a = str;
        }

        @Override // java.security.PrivilegedAction
        public Object run() {
            return System.getProperty(this.f46050a);
        }
    }

    public static BigInteger a(String str) {
        String strC = c(str);
        if (strC != null) {
            return new BigInteger(strC);
        }
        return null;
    }

    public static Set<String> b(String str) {
        HashSet hashSet = new HashSet();
        String strC = c(str);
        if (strC != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(strC, ag.c.f654g);
            while (stringTokenizer.hasMoreElements()) {
                hashSet.add(Strings.k(stringTokenizer.nextToken()).trim());
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public static String c(String str) {
        String str2;
        String str3 = (String) AccessController.doPrivileged(new a(str));
        if (str3 != null) {
            return str3;
        }
        Map map = (Map) f46048a.get();
        return (map == null || (str2 = (String) map.get(str)) == null) ? (String) AccessController.doPrivileged(new b(str)) : str2;
    }

    public static boolean d(String str) {
        try {
            return g(c(str));
        } catch (AccessControlException unused) {
            return false;
        }
    }

    public static boolean e(String str, boolean z10) {
        try {
            String strC = c(str);
            return z10 ? g(strC) : f(strC);
        } catch (AccessControlException unused) {
            return false;
        }
    }

    public static boolean f(String str) {
        if (str == null || str.length() != 5) {
            return false;
        }
        if (str.charAt(0) != 'f' && str.charAt(0) != 'F') {
            return false;
        }
        if (str.charAt(1) != 'a' && str.charAt(1) != 'A') {
            return false;
        }
        if (str.charAt(2) != 'l' && str.charAt(2) != 'L') {
            return false;
        }
        if (str.charAt(3) == 's' || str.charAt(3) == 'S') {
            return str.charAt(4) == 'e' || str.charAt(4) == 'E';
        }
        return false;
    }

    public static boolean g(String str) {
        if (str == null || str.length() != 4) {
            return false;
        }
        if (str.charAt(0) != 't' && str.charAt(0) != 'T') {
            return false;
        }
        if (str.charAt(1) != 'r' && str.charAt(1) != 'R') {
            return false;
        }
        if (str.charAt(2) == 'u' || str.charAt(2) == 'U') {
            return str.charAt(3) == 'e' || str.charAt(3) == 'E';
        }
        return false;
    }

    public static boolean h(String str) {
        String str2;
        ThreadLocal threadLocal = f46048a;
        Map map = (Map) threadLocal.get();
        if (map == null || (str2 = (String) map.remove(str)) == null) {
            return false;
        }
        if (map.isEmpty()) {
            threadLocal.remove();
        }
        return "true".equals(Strings.k(str2));
    }

    public static boolean i(String str, boolean z10) {
        boolean zD = d(str);
        ThreadLocal threadLocal = f46048a;
        Map map = (Map) threadLocal.get();
        if (map == null) {
            map = new HashMap();
            threadLocal.set(map);
        }
        map.put(str, z10 ? "true" : "false");
        return zD;
    }
}
