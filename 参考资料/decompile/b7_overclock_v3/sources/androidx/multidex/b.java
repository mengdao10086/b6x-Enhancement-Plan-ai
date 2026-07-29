package androidx.multidex;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f6395a = "MultiDex";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f6396b = "secondary-dexes";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f6397c = "code_cache";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f6398d = "secondary-dexes";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f6399e = 20;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f6400f = 4;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f6401g = 2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f6402h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f6403i = "";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Set<File> f6404j = new HashSet();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final boolean f6405k = o(System.getProperty("java.vm.version"));

    public static final class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f6406b = 4;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InterfaceC0058a f6407a;

        /* JADX INFO: renamed from: androidx.multidex.b$a$a, reason: collision with other inner class name */
        public interface InterfaceC0058a {
            Object a(File file, DexFile dexFile) throws IllegalAccessException, InstantiationException, IOException, IllegalArgumentException, InvocationTargetException;
        }

        /* JADX INFO: renamed from: androidx.multidex.b$a$b, reason: collision with other inner class name */
        public static class C0059b implements InterfaceC0058a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Constructor<?> f6408a;

            public C0059b(Class<?> cls) throws NoSuchMethodException, SecurityException {
                Constructor<?> constructor = cls.getConstructor(File.class, ZipFile.class, DexFile.class);
                this.f6408a = constructor;
                constructor.setAccessible(true);
            }

            @Override // androidx.multidex.b.a.InterfaceC0058a
            public Object a(File file, DexFile dexFile) throws IllegalAccessException, InstantiationException, IOException, IllegalArgumentException, InvocationTargetException {
                return this.f6408a.newInstance(file, new ZipFile(file), dexFile);
            }
        }

        public static class c implements InterfaceC0058a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Constructor<?> f6409a;

            public c(Class<?> cls) throws NoSuchMethodException, SecurityException {
                Constructor<?> constructor = cls.getConstructor(File.class, File.class, DexFile.class);
                this.f6409a = constructor;
                constructor.setAccessible(true);
            }

            @Override // androidx.multidex.b.a.InterfaceC0058a
            public Object a(File file, DexFile dexFile) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
                return this.f6409a.newInstance(file, file, dexFile);
            }
        }

        public static class d implements InterfaceC0058a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Constructor<?> f6410a;

            public d(Class<?> cls) throws NoSuchMethodException, SecurityException {
                Constructor<?> constructor = cls.getConstructor(File.class, Boolean.TYPE, File.class, DexFile.class);
                this.f6410a = constructor;
                constructor.setAccessible(true);
            }

            @Override // androidx.multidex.b.a.InterfaceC0058a
            public Object a(File file, DexFile dexFile) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
                return this.f6410a.newInstance(file, Boolean.FALSE, file, dexFile);
            }
        }

        public a() throws NoSuchMethodException, ClassNotFoundException, SecurityException {
            InterfaceC0058a dVar;
            Class<?> cls = Class.forName("dalvik.system.DexPathList$Element");
            try {
                try {
                    dVar = new C0059b(cls);
                } catch (NoSuchMethodException unused) {
                    dVar = new c(cls);
                }
            } catch (NoSuchMethodException unused2) {
                dVar = new d(cls);
            }
            this.f6407a = dVar;
        }

        public static void a(ClassLoader classLoader, List<? extends File> list) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InstantiationException, IOException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
            Object obj = b.g(classLoader, "pathList").get(classLoader);
            Object[] objArrB = new a().b(list);
            try {
                b.f(obj, "dexElements", objArrB);
            } catch (NoSuchFieldException unused) {
                b.f(obj, "pathElements", objArrB);
            }
        }

        public static String c(File file) {
            File parentFile = file.getParentFile();
            String name = file.getName();
            return new File(parentFile, name.substring(0, name.length() - f6406b) + MultiDexExtractor.f6369i).getPath();
        }

        public final Object[] b(List<? extends File> list) throws IllegalAccessException, InstantiationException, IOException, SecurityException, IllegalArgumentException, InvocationTargetException {
            int size = list.size();
            Object[] objArr = new Object[size];
            for (int i10 = 0; i10 < size; i10++) {
                File file = list.get(i10);
                objArr[i10] = this.f6407a.a(file, DexFile.loadDex(file.getPath(), c(file), 0));
            }
            return objArr;
        }
    }

    /* JADX INFO: renamed from: androidx.multidex.b$b, reason: collision with other inner class name */
    public static final class C0060b {
        public static void a(ClassLoader classLoader, List<? extends File> list, File file) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, IOException, IllegalArgumentException, InvocationTargetException {
            IOException[] iOExceptionArr;
            Object obj = b.g(classLoader, "pathList").get(classLoader);
            ArrayList<IOException> arrayList = new ArrayList();
            b.f(obj, "dexElements", b(obj, new ArrayList(list), file, arrayList));
            if (arrayList.size() > 0) {
                for (IOException iOException : arrayList) {
                }
                Field fieldG = b.g(obj, "dexElementsSuppressedExceptions");
                IOException[] iOExceptionArr2 = (IOException[]) fieldG.get(obj);
                if (iOExceptionArr2 == null) {
                    iOExceptionArr = (IOException[]) arrayList.toArray(new IOException[arrayList.size()]);
                } else {
                    IOException[] iOExceptionArr3 = new IOException[arrayList.size() + iOExceptionArr2.length];
                    arrayList.toArray(iOExceptionArr3);
                    System.arraycopy(iOExceptionArr2, 0, iOExceptionArr3, arrayList.size(), iOExceptionArr2.length);
                    iOExceptionArr = iOExceptionArr3;
                }
                fieldG.set(obj, iOExceptionArr);
                IOException iOException2 = new IOException("I/O exception during makeDexElement");
                iOException2.initCause((Throwable) arrayList.get(0));
                throw iOException2;
            }
        }

        public static Object[] b(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
            return (Object[]) b.h(obj, "makeDexElements", ArrayList.class, File.class, ArrayList.class).invoke(obj, arrayList, file, arrayList2);
        }
    }

    public static final class c {
        public static void a(ClassLoader classLoader, List<? extends File> list) throws IllegalAccessException, NoSuchFieldException, IOException, IllegalArgumentException {
            int size = list.size();
            Field fieldG = b.g(classLoader, "path");
            StringBuilder sb2 = new StringBuilder((String) fieldG.get(classLoader));
            String[] strArr = new String[size];
            File[] fileArr = new File[size];
            ZipFile[] zipFileArr = new ZipFile[size];
            DexFile[] dexFileArr = new DexFile[size];
            ListIterator<? extends File> listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                File next = listIterator.next();
                String absolutePath = next.getAbsolutePath();
                sb2.append(':');
                sb2.append(absolutePath);
                int iPreviousIndex = listIterator.previousIndex();
                strArr[iPreviousIndex] = absolutePath;
                fileArr[iPreviousIndex] = next;
                zipFileArr[iPreviousIndex] = new ZipFile(next);
                dexFileArr[iPreviousIndex] = DexFile.loadDex(absolutePath, absolutePath + MultiDexExtractor.f6369i, 0);
            }
            fieldG.set(classLoader, sb2.toString());
            b.f(classLoader, "mPaths", strArr);
            b.f(classLoader, "mFiles", fileArr);
            b.f(classLoader, "mZips", zipFileArr);
            b.f(classLoader, "mDexs", dexFileArr);
        }
    }

    public static void d(Context context) throws Exception {
        File file = new File(context.getFilesDir(), "secondary-dexes");
        if (file.isDirectory()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Clearing old secondary dex dir (");
            sb2.append(file.getPath());
            sb2.append(").");
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Failed to list secondary dex dir content (");
                sb3.append(file.getPath());
                sb3.append(").");
                return;
            }
            for (File file2 : fileArrListFiles) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Trying to delete old file ");
                sb4.append(file2.getPath());
                sb4.append(" of size ");
                sb4.append(file2.length());
                if (file2.delete()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("Deleted old file ");
                    sb5.append(file2.getPath());
                } else {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("Failed to delete old file ");
                    sb6.append(file2.getPath());
                }
            }
            if (file.delete()) {
                StringBuilder sb7 = new StringBuilder();
                sb7.append("Deleted old secondary dex dir ");
                sb7.append(file.getPath());
            } else {
                StringBuilder sb8 = new StringBuilder();
                sb8.append("Failed to delete secondary dex dir ");
                sb8.append(file.getPath());
            }
        }
    }

    public static void e(Context context, File file, File file2, String str, String str2, boolean z10) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InstantiationException, IOException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        Set<File> set = f6404j;
        synchronized (set) {
            if (set.contains(file)) {
                return;
            }
            set.add(file);
            int i10 = Build.VERSION.SDK_INT;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("MultiDex is not guaranteed to work in SDK version ");
            sb2.append(i10);
            sb2.append(": SDK version higher than ");
            sb2.append(20);
            sb2.append(" should be backed by ");
            sb2.append("runtime with built-in multidex capabilty but it's not the ");
            sb2.append("case here: java.vm.version=\"");
            sb2.append(System.getProperty("java.vm.version"));
            sb2.append("\"");
            ClassLoader classLoaderJ = j(context);
            if (classLoaderJ == null) {
                return;
            }
            try {
                d(context);
            } catch (Throwable unused) {
            }
            File fileK = k(context, file2, str);
            MultiDexExtractor multiDexExtractor = new MultiDexExtractor(file, fileK);
            IOException e10 = null;
            try {
                try {
                    n(classLoaderJ, fileK, multiDexExtractor.l(context, str2, false));
                } catch (IOException e11) {
                    if (!z10) {
                        throw e11;
                    }
                    n(classLoaderJ, fileK, multiDexExtractor.l(context, str2, true));
                }
                try {
                } catch (IOException e12) {
                    e10 = e12;
                }
                if (e10 != null) {
                    throw e10;
                }
            } finally {
                try {
                    multiDexExtractor.close();
                } catch (IOException unused2) {
                }
            }
        }
    }

    public static void f(Object obj, String str, Object[] objArr) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        Field fieldG = g(obj, str);
        Object[] objArr2 = (Object[]) fieldG.get(obj);
        Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
        System.arraycopy(objArr2, 0, objArr3, 0, objArr2.length);
        System.arraycopy(objArr, 0, objArr3, objArr2.length, objArr.length);
        fieldG.set(obj, objArr3);
    }

    public static Field g(Object obj, String str) throws NoSuchFieldException {
        for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            try {
                Field declaredField = superclass.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
            }
        }
        throw new NoSuchFieldException("Field " + str + " not found in " + obj.getClass());
    }

    public static Method h(Object obj, String str, Class<?>... clsArr) throws NoSuchMethodException {
        for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            try {
                Method declaredMethod = superclass.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException unused) {
            }
        }
        throw new NoSuchMethodException("Method " + str + " with parameters " + Arrays.asList(clsArr) + " not found in " + obj.getClass());
    }

    public static ApplicationInfo i(Context context) {
        try {
            return context.getApplicationInfo();
        } catch (RuntimeException unused) {
            return null;
        }
    }

    public static ClassLoader j(Context context) {
        ClassLoader classLoader;
        try {
            classLoader = context.getClassLoader();
        } catch (RuntimeException unused) {
        }
        if (classLoader instanceof BaseDexClassLoader) {
            return classLoader;
        }
        return null;
    }

    public static File k(Context context, File file, String str) throws IOException {
        File file2 = new File(file, f6397c);
        try {
            p(file2);
        } catch (IOException unused) {
            file2 = new File(context.getFilesDir(), f6397c);
            p(file2);
        }
        File file3 = new File(file2, str);
        p(file3);
        return file3;
    }

    public static void l(Context context) {
        if (f6405k) {
            return;
        }
        try {
            ApplicationInfo applicationInfoI = i(context);
            if (applicationInfoI == null) {
                return;
            }
            e(context, new File(applicationInfoI.sourceDir), new File(applicationInfoI.dataDir), "secondary-dexes", "", true);
        } catch (Exception e10) {
            throw new RuntimeException("MultiDex installation failed (" + e10.getMessage() + ").");
        }
    }

    public static void m(Context context, Context context2) {
        ApplicationInfo applicationInfoI;
        if (f6405k) {
            return;
        }
        try {
            ApplicationInfo applicationInfoI2 = i(context);
            if (applicationInfoI2 == null || (applicationInfoI = i(context2)) == null) {
                return;
            }
            String str = context.getPackageName() + j3.b.f36044h;
            File file = new File(applicationInfoI.dataDir);
            e(context2, new File(applicationInfoI2.sourceDir), file, str + "secondary-dexes", str, false);
            e(context2, new File(applicationInfoI.sourceDir), file, "secondary-dexes", "", false);
        } catch (Exception e10) {
            throw new RuntimeException("MultiDex installation failed (" + e10.getMessage() + ").");
        }
    }

    public static void n(ClassLoader classLoader, File file, List<? extends File> list) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InstantiationException, IOException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (list.isEmpty()) {
            return;
        }
        C0060b.a(classLoader, list, file);
    }

    public static boolean o(String str) {
        boolean z10 = false;
        if (str != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, j3.b.f36044h);
            String strNextToken = stringTokenizer.hasMoreTokens() ? stringTokenizer.nextToken() : null;
            String strNextToken2 = stringTokenizer.hasMoreTokens() ? stringTokenizer.nextToken() : null;
            if (strNextToken != null && strNextToken2 != null) {
                try {
                    int i10 = Integer.parseInt(strNextToken);
                    int i11 = Integer.parseInt(strNextToken2);
                    if (i10 > 2 || (i10 == 2 && i11 >= 1)) {
                        z10 = true;
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("VM with version ");
        sb2.append(str);
        sb2.append(z10 ? " has multidex support" : " does not have multidex support");
        return z10;
    }

    public static void p(File file) throws IOException {
        file.mkdir();
        if (file.isDirectory()) {
            return;
        }
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Failed to create dir ");
            sb2.append(file.getPath());
            sb2.append(". Parent file is null.");
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Failed to create dir ");
            sb3.append(file.getPath());
            sb3.append(". parent file is a dir ");
            sb3.append(parentFile.isDirectory());
            sb3.append(", a file ");
            sb3.append(parentFile.isFile());
            sb3.append(", exists ");
            sb3.append(parentFile.exists());
            sb3.append(", readable ");
            sb3.append(parentFile.canRead());
            sb3.append(", writable ");
            sb3.append(parentFile.canWrite());
        }
        throw new IOException("Failed to create directory " + file.getPath());
    }
}
