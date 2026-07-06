package a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import kotlinx.coroutines.internal.MainDispatcherFactory;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class uh2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final uh2 f7599a = new uh2();

    public final <S> S a(String str, ClassLoader classLoader, Class<S> cls) throws ClassNotFoundException {
        Class<?> cls2 = Class.forName(str, false, classLoader);
        if (cls.isAssignableFrom(cls2)) {
            return cls.cast(cls2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        }
        throw new IllegalArgumentException(("Expected service of class " + cls + ", but found " + cls2).toString());
    }

    public final <S> List<S> b(Class<S> cls, ClassLoader classLoader) {
        try {
            return d(cls, classLoader);
        } catch (Throwable unused) {
            return i52.Y(ServiceLoader.load(cls, classLoader));
        }
    }

    public final List<MainDispatcherFactory> c() {
        MainDispatcherFactory mainDispatcherFactory;
        if (!vh2.a()) {
            return b(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader());
        }
        try {
            ArrayList arrayList = new ArrayList(2);
            MainDispatcherFactory mainDispatcherFactory2 = null;
            try {
                mainDispatcherFactory = (MainDispatcherFactory) MainDispatcherFactory.class.cast(Class.forName("kotlinx.coroutines.android.AndroidDispatcherFactory", true, MainDispatcherFactory.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (ClassNotFoundException unused) {
                mainDispatcherFactory = null;
            }
            if (mainDispatcherFactory != null) {
                arrayList.add(mainDispatcherFactory);
            }
            try {
                mainDispatcherFactory2 = (MainDispatcherFactory) MainDispatcherFactory.class.cast(Class.forName("kotlinx.coroutines.test.internal.TestMainDispatcherFactory", true, MainDispatcherFactory.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (ClassNotFoundException unused2) {
            }
            if (mainDispatcherFactory2 == null) {
                return arrayList;
            }
            arrayList.add(mainDispatcherFactory2);
            return arrayList;
        } catch (Throwable unused3) {
            return b(MainDispatcherFactory.class, MainDispatcherFactory.class.getClassLoader());
        }
    }

    public final <S> List<S> d(Class<S> cls, ClassLoader classLoader) {
        ArrayList list = Collections.list(classLoader.getResources("META-INF/services/" + cls.getName()));
        f92.c(list, "java.util.Collections.list(this)");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            d52.o(arrayList, f7599a.e((URL) it.next()));
        }
        Set setB0 = i52.b0(arrayList);
        if (!(!setB0.isEmpty())) {
            throw new IllegalArgumentException("No providers were loaded with FastServiceLoader".toString());
        }
        ArrayList arrayList2 = new ArrayList(z42.m(setB0, 10));
        Iterator it2 = setB0.iterator();
        while (it2.hasNext()) {
            arrayList2.add(f7599a.a((String) it2.next(), classLoader, cls));
        }
        return arrayList2;
    }

    public final List<String> e(URL url) throws IllegalAccessException, InvocationTargetException {
        BufferedReader bufferedReader;
        String string = url.toString();
        if (!bc2.x(string, "jar", false, 2, null)) {
            bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            try {
                List<String> listF = f7599a.f(bufferedReader);
                k72.a(bufferedReader, null);
                return listF;
            } catch (Throwable th) {
                try {
                    throw th;
                } finally {
                }
            }
        }
        String strP0 = ec2.p0(ec2.k0(string, "jar:file:", null, 2, null), '!', null, 2, null);
        String strK0 = ec2.k0(string, "!/", null, 2, null);
        JarFile jarFile = new JarFile(strP0, false);
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(jarFile.getInputStream(new ZipEntry(strK0)), "UTF-8"));
            try {
                List<String> listF2 = f7599a.f(bufferedReader);
                k72.a(bufferedReader, null);
                jarFile.close();
                return listF2;
            } finally {
            }
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                try {
                    jarFile.close();
                    throw th3;
                } catch (Throwable th4) {
                    x32.a(th2, th4);
                    throw th2;
                }
            }
        }
    }

    public final List<String> f(BufferedReader bufferedReader) throws IOException {
        boolean z;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return i52.Y(linkedHashSet);
            }
            String strQ0 = ec2.q0(line, "#", null, 2, null);
            if (strQ0 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            String string = ec2.r0(strQ0).toString();
            int i = 0;
            while (true) {
                if (i >= string.length()) {
                    z = true;
                    break;
                }
                char cCharAt = string.charAt(i);
                if (!(cCharAt == '.' || Character.isJavaIdentifierPart(cCharAt))) {
                    z = false;
                    break;
                }
                i++;
            }
            if (!z) {
                throw new IllegalArgumentException(("Illegal service provider class name: " + string).toString());
            }
            if (string.length() > 0) {
                linkedHashSet.add(string);
            }
        }
    }
}
