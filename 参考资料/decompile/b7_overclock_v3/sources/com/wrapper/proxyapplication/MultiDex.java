package com.wrapper.proxyapplication;

import android.os.Build;
import androidx.multidex.MultiDexExtractor;
import dalvik.system.DexFile;
import fh.a;
import j3.b;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes.dex */
public final class MultiDex {
    static final String TAG = "MultiDex";
    static Object baseApkDexFile;
    static IOException[] dexElementsSuppressedExceptions;
    static int hasInjected;
    static int injectDexBeginIndex;
    static Object[] injectDexsObj;
    static Object[] injectFilesObj;
    static Object[] injectPathListObj;
    static Object[] injectPathsObj;
    static Object[] injectZipsObj;

    private MultiDex() {
    }

    private static ArrayList<File> splitPaths(String str) {
        ArrayList<File> arrayList = new ArrayList<>();
        if (str != null) {
            for (String str2 : str.split(File.pathSeparator)) {
                arrayList.add(new File(str2));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getprefixname(String str) {
        int iLastIndexOf = str.lastIndexOf(a.f28350w);
        if (iLastIndexOf >= 0) {
            str = str.substring(iLastIndexOf + 1);
        }
        int iLastIndexOf2 = str.lastIndexOf(b.f36044h);
        return iLastIndexOf2 >= 0 ? str.substring(0, iLastIndexOf2) : str;
    }

    private static ArrayList<Object> openallDexes(ClassLoader classLoader, String str, String str2) {
        Object obj;
        Method methodFindMethod;
        ArrayList<Object> arrayList;
        ArrayList<File> arrayListSplitPaths = splitPaths(str);
        File file = new File(str2);
        ArrayList<Object> arrayList2 = null;
        try {
            try {
                obj = findField(classLoader, "pathList").get(classLoader);
                try {
                    methodFindMethod = findMethod(obj, "loadDexFile", File.class, File.class);
                    try {
                        arrayList = new ArrayList<>();
                    } catch (InvocationTargetException e10) {
                        e = e10;
                    }
                } catch (NoSuchMethodException e11) {
                    e11.printStackTrace();
                }
            } catch (IllegalAccessException e12) {
                e12.printStackTrace();
            } catch (IllegalArgumentException e13) {
                e13.printStackTrace();
            }
        } catch (NoSuchFieldException e14) {
            e = e14;
        }
        try {
            Iterator<File> it2 = arrayListSplitPaths.iterator();
            while (it2.hasNext()) {
                arrayList.add(methodFindMethod.invoke(obj, it2.next(), file));
            }
            arrayList2 = arrayList;
        } catch (IllegalAccessException e15) {
            arrayList2 = arrayList;
            e15.printStackTrace();
        } catch (IllegalArgumentException e16) {
            arrayList2 = arrayList;
            e16.printStackTrace();
        } catch (NoSuchFieldException e17) {
            e = e17;
            arrayList2 = arrayList;
            e.printStackTrace();
            return arrayList2;
        } catch (NoSuchMethodException e18) {
            arrayList2 = arrayList;
            e18.printStackTrace();
        } catch (InvocationTargetException e19) {
            e = e19;
            arrayList2 = arrayList;
            e.printStackTrace();
        }
        return arrayList2;
    }

    private static ArrayList<Object> installDexes(ClassLoader classLoader, String str, String str2, boolean z10, boolean z11) {
        ArrayList<File> arrayListSplitPaths = splitPaths(str);
        File file = new File(str2);
        try {
            try {
                try {
                    try {
                        try {
                            return V19.install(classLoader, findField(classLoader, "pathList"), arrayListSplitPaths, file, z10, z11);
                        } catch (InvocationTargetException e10) {
                            e10.printStackTrace();
                            return null;
                        }
                    } catch (IllegalArgumentException e11) {
                        e11.printStackTrace();
                        return null;
                    }
                } catch (IllegalAccessException e12) {
                    e12.printStackTrace();
                    return null;
                } catch (NoSuchMethodException e13) {
                    e13.printStackTrace();
                    return null;
                }
            } catch (NoSuchFieldException unused) {
                try {
                    return V4.install(classLoader, findField(classLoader, "path"), arrayListSplitPaths, file);
                } catch (IOException e14) {
                    e14.printStackTrace();
                    return null;
                } catch (IllegalAccessException e15) {
                    e15.printStackTrace();
                    return null;
                } catch (IllegalArgumentException e16) {
                    e16.printStackTrace();
                    return null;
                }
            }
        } catch (NoSuchFieldException unused2) {
            return null;
        }
    }

    private static ArrayList<Object> installDexes(ClassLoader classLoader, String str, String str2, int i10, boolean z10, boolean z11) {
        ArrayList<File> arrayListSplitPaths = splitPaths(str);
        File file = new File(str2);
        try {
            try {
                try {
                    try {
                        return V19.install(classLoader, findField(classLoader, "pathList"), arrayListSplitPaths, file, i10, z10, z11);
                    } catch (IllegalAccessException e10) {
                        e10.printStackTrace();
                        return null;
                    } catch (NoSuchMethodException e11) {
                        e11.printStackTrace();
                        return null;
                    }
                } catch (IllegalArgumentException e12) {
                    e12.printStackTrace();
                    return null;
                } catch (InvocationTargetException e13) {
                    e13.printStackTrace();
                    return null;
                }
            } catch (NoSuchFieldException unused) {
                return null;
            }
        } catch (NoSuchFieldException unused2) {
            try {
                try {
                    return V4.install(classLoader, findField(classLoader, "path"), arrayListSplitPaths, file, i10);
                } catch (IllegalAccessException e14) {
                    e14.printStackTrace();
                    return null;
                }
            } catch (IOException e15) {
                e15.printStackTrace();
                return null;
            } catch (IllegalArgumentException e16) {
                e16.printStackTrace();
                return null;
            }
        }
    }

    private static void preparetoinstallDexes(ClassLoader classLoader, int i10) {
        try {
            try {
                try {
                    try {
                        prepareexpandFieldArray(findField(classLoader, "pathList").get(classLoader), "dexElements", i10);
                    } catch (IllegalArgumentException e10) {
                        e10.printStackTrace();
                    }
                } catch (IllegalAccessException e11) {
                    e11.printStackTrace();
                }
            } catch (NoSuchFieldException unused) {
                findField(classLoader, "path");
                try {
                    prepareexpandFieldArray(classLoader, "mPaths", i10);
                    prepareexpandFieldArray(classLoader, "mFiles", i10);
                    prepareexpandFieldArray(classLoader, "mZips", i10);
                    prepareexpandFieldArray(classLoader, "mDexs", i10);
                } catch (IllegalAccessException e12) {
                    e12.printStackTrace();
                } catch (IllegalArgumentException e13) {
                    e13.printStackTrace();
                }
            }
        } catch (NoSuchFieldException unused2) {
        }
    }

    private static void finishinstallDexes(ClassLoader classLoader) {
        try {
            try {
                try {
                    try {
                        Object obj = findField(classLoader, "pathList").get(classLoader);
                        Field fieldFindField = findField(obj, "dexElements");
                        hasInjected = 1;
                        fieldFindField.set(obj, injectPathListObj);
                        if (dexElementsSuppressedExceptions != null) {
                            findField(obj, "dexElementsSuppressedExceptions").set(obj, dexElementsSuppressedExceptions);
                        }
                    } catch (IllegalArgumentException e10) {
                        e10.printStackTrace();
                    }
                } catch (IllegalAccessException e11) {
                    e11.printStackTrace();
                }
            } catch (NoSuchFieldException unused) {
                try {
                    Object obj2 = findField(classLoader, "path").get(classLoader);
                    findField(obj2, "mPaths").set(obj2, injectPathsObj);
                    findField(obj2, "mFiles").set(obj2, injectFilesObj);
                    findField(obj2, "mZips").set(obj2, injectZipsObj);
                    findField(obj2, "mDexs").set(obj2, injectDexsObj);
                    hasInjected = 1;
                } catch (IllegalAccessException e12) {
                    e12.printStackTrace();
                } catch (IllegalArgumentException e13) {
                    e13.printStackTrace();
                }
            }
        } catch (NoSuchFieldException unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Field findField(Object obj, String str) throws NoSuchFieldException {
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

    private static Method findMethodinClazz(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException {
        while (cls != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException unused) {
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchMethodException("Method " + str + " with parameters " + Arrays.asList(clsArr) + " not found in " + cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Method findMethod(Object obj, String str, Class<?>... clsArr) throws NoSuchMethodException {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static void expandFieldArray(Object obj, String str, Object[] objArr) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        Field fieldFindField = findField(obj, str);
        Object[] objArr2 = (Object[]) fieldFindField.get(obj);
        Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
        if (Build.VERSION.SDK_INT == 28 && hasInjected == 0 && objArr2.length > 1) {
            System.arraycopy(objArr2, 0, objArr3, 0, objArr2.length - 1);
            System.arraycopy(objArr, 0, objArr3, objArr2.length - 1, objArr.length);
            System.arraycopy(objArr2, objArr2.length - 1, objArr3, (objArr.length + objArr2.length) - 1, 1);
        } else {
            System.arraycopy(objArr, 0, objArr3, 0, objArr.length);
            System.arraycopy(objArr2, 0, objArr3, objArr.length, objArr2.length);
        }
        fieldFindField.set(obj, objArr3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void expandFieldArray(Object obj, String str, Object[] objArr, int i10) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        if (str.equals("dexElements")) {
            System.arraycopy(objArr, 0, injectPathListObj, injectDexBeginIndex + i10, objArr.length);
            return;
        }
        if (str.equals("mPaths")) {
            System.arraycopy(objArr, 0, injectPathsObj, injectDexBeginIndex + i10, objArr.length);
            return;
        }
        if (str.equals("mFiles")) {
            System.arraycopy(objArr, 0, injectFilesObj, injectDexBeginIndex + i10, objArr.length);
        } else if (str.equals("mDexs")) {
            System.arraycopy(objArr, 0, injectDexsObj, injectDexBeginIndex + i10, objArr.length);
        } else if (str.equals("mZips")) {
            System.arraycopy(objArr, 0, injectZipsObj, injectDexBeginIndex + i10, objArr.length);
        }
    }

    private static void prepareexpandFieldArray(Object obj, String str, int i10) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        Object[] objArr = (Object[]) findField(obj, str).get(obj);
        Object[] objArr2 = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), objArr.length + i10);
        baseApkDexFile = objArr[objArr.length - 1];
        if (Build.VERSION.SDK_INT == 28 && hasInjected == 0 && objArr.length > 1) {
            System.arraycopy(objArr, 0, objArr2, 0, objArr.length - 1);
            injectDexBeginIndex = objArr.length - 1;
            System.arraycopy(objArr, objArr.length - 1, objArr2, (i10 + objArr.length) - 1, 1);
        } else {
            System.arraycopy(objArr, 0, objArr2, i10, objArr.length);
        }
        if (str.equals("dexElements")) {
            injectPathListObj = objArr2;
            return;
        }
        if (str.equals("mPaths")) {
            injectPathsObj = objArr2;
            return;
        }
        if (str.equals("mFiles")) {
            injectFilesObj = objArr2;
        } else if (str.equals("mZips")) {
            injectZipsObj = objArr2;
        } else if (str.equals("mDexs")) {
            injectDexsObj = objArr2;
        }
    }

    private static final class V19 {
        private V19() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static ArrayList<Object> install(ClassLoader classLoader, Field field, List<File> list, File file, boolean z10, boolean z11) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
            IOException[] iOExceptionArr;
            Object obj = field.get(classLoader);
            ArrayList<IOException> arrayList = new ArrayList();
            Object[] objArrMakeDexElements = makeDexElements(obj, new ArrayList(list), file, arrayList);
            if (objArrMakeDexElements == null || objArrMakeDexElements.length != list.size()) {
                return null;
            }
            ArrayList<Object> arrayList2 = new ArrayList<>();
            for (Object obj2 : objArrMakeDexElements) {
                Object obj3 = MultiDex.findField(obj2, "dexFile").get(obj2);
                Field fieldFindField = MultiDex.findField(obj3, "mCookie");
                if (fieldFindField.getType().getName().equals("int")) {
                    arrayList2.add(Integer.valueOf(fieldFindField.getInt(obj3)));
                } else if (fieldFindField.getType().getName().equals("long")) {
                    arrayList2.add(Long.valueOf(fieldFindField.getLong(obj3)));
                    if (z10) {
                        fieldFindField.setLong(obj3, 0L);
                    }
                } else {
                    if (z11) {
                        arrayList2.add(obj3);
                    }
                    arrayList2.add(fieldFindField.get(obj3));
                    if (z10) {
                        fieldFindField.set(obj3, null);
                    }
                }
            }
            MultiDex.expandFieldArray(obj, "dexElements", objArrMakeDexElements);
            if (arrayList.size() > 0) {
                for (IOException iOException : arrayList) {
                }
                Field fieldFindField2 = MultiDex.findField(obj, "dexElementsSuppressedExceptions");
                IOException[] iOExceptionArr2 = (IOException[]) fieldFindField2.get(obj);
                if (iOExceptionArr2 == null) {
                    iOExceptionArr = (IOException[]) arrayList.toArray(new IOException[arrayList.size()]);
                } else {
                    IOException[] iOExceptionArr3 = new IOException[arrayList.size() + iOExceptionArr2.length];
                    arrayList.toArray(iOExceptionArr3);
                    System.arraycopy(iOExceptionArr2, 0, iOExceptionArr3, arrayList.size(), iOExceptionArr2.length);
                    iOExceptionArr = iOExceptionArr3;
                }
                fieldFindField2.set(obj, iOExceptionArr);
            }
            MultiDex.hasInjected = 1;
            return arrayList2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static ArrayList<Object> install(ClassLoader classLoader, Field field, List<File> list, File file, int i10, boolean z10, boolean z11) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
            Object obj = field.get(classLoader);
            ArrayList<IOException> arrayList = new ArrayList();
            Object[] objArrMakeDexElements = makeDexElements(obj, new ArrayList(list), file, arrayList);
            if (objArrMakeDexElements == null || objArrMakeDexElements.length != list.size()) {
                return null;
            }
            ArrayList<Object> arrayList2 = new ArrayList<>();
            for (Object obj2 : objArrMakeDexElements) {
                Object obj3 = MultiDex.findField(obj2, "dexFile").get(obj2);
                Field fieldFindField = MultiDex.findField(obj3, "mCookie");
                if (fieldFindField.getType().getName().equals("int")) {
                    arrayList2.add(Integer.valueOf(fieldFindField.getInt(obj3)));
                } else if (fieldFindField.getType().getName().equals("long")) {
                    arrayList2.add(Long.valueOf(fieldFindField.getLong(obj3)));
                } else {
                    if (z11) {
                        arrayList2.add(obj3);
                    }
                    arrayList2.add(fieldFindField.get(obj3));
                }
            }
            MultiDex.expandFieldArray(obj, "dexElements", objArrMakeDexElements, i10);
            if (arrayList.size() > 0) {
                for (IOException iOException : arrayList) {
                }
                MultiDex.dexElementsSuppressedExceptions = (IOException[]) MultiDex.findField(obj, "dexElementsSuppressedExceptions").get(obj);
                if (MultiDex.dexElementsSuppressedExceptions == null) {
                    MultiDex.dexElementsSuppressedExceptions = (IOException[]) arrayList.toArray(new IOException[arrayList.size()]);
                } else {
                    IOException[] iOExceptionArr = new IOException[arrayList.size() + MultiDex.dexElementsSuppressedExceptions.length];
                    arrayList.toArray(iOExceptionArr);
                    System.arraycopy(MultiDex.dexElementsSuppressedExceptions, 0, iOExceptionArr, arrayList.size(), MultiDex.dexElementsSuppressedExceptions.length);
                    MultiDex.dexElementsSuppressedExceptions = iOExceptionArr;
                }
            }
            return arrayList2;
        }

        private static Object[] makeDexElements(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) {
            try {
                try {
                    try {
                        try {
                            try {
                                return (Object[]) MultiDex.findMethod(obj, "makeDexElements", ArrayList.class, File.class).invoke(obj, arrayList, file);
                            } catch (IllegalArgumentException e10) {
                                e10.printStackTrace();
                                return null;
                            }
                        } catch (IllegalAccessException e11) {
                            e11.printStackTrace();
                            return null;
                        }
                    } catch (RuntimeException e12) {
                        e12.printStackTrace();
                        return null;
                    }
                } catch (InvocationTargetException e13) {
                    e13.printStackTrace();
                    return null;
                }
            } catch (NoSuchMethodException e14) {
                try {
                    try {
                        try {
                            try {
                                return (Object[]) MultiDex.findMethod(obj, "makeDexElements", ArrayList.class, File.class, ArrayList.class).invoke(obj, arrayList, file, arrayList2);
                            } catch (RuntimeException e15) {
                                e15.printStackTrace();
                                e14.printStackTrace();
                                return null;
                            }
                        } catch (IllegalArgumentException e16) {
                            e16.printStackTrace();
                            e14.printStackTrace();
                            return null;
                        }
                    } catch (IllegalAccessException e17) {
                        e17.printStackTrace();
                        e14.printStackTrace();
                        return null;
                    } catch (InvocationTargetException e18) {
                        e18.printStackTrace();
                        e14.printStackTrace();
                        return null;
                    }
                } catch (NoSuchMethodException e19) {
                    try {
                        try {
                            return (Object[]) MultiDex.findMethod(obj, "makePathElements", List.class, File.class, List.class).invoke(obj, arrayList, file, arrayList2);
                        } catch (IllegalAccessException e20) {
                            e20.printStackTrace();
                            e19.printStackTrace();
                            e14.printStackTrace();
                            return null;
                        } catch (IllegalArgumentException e21) {
                            e21.printStackTrace();
                            e19.printStackTrace();
                            e14.printStackTrace();
                            return null;
                        } catch (InvocationTargetException e22) {
                            e22.printStackTrace();
                            e19.printStackTrace();
                            e14.printStackTrace();
                            return null;
                        }
                    } catch (NoSuchMethodException e23) {
                        e23.printStackTrace();
                    } catch (RuntimeException e24) {
                        e24.printStackTrace();
                    }
                }
            }
        }
    }

    private static final class V4 {
        private V4() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static ArrayList<Object> install(ClassLoader classLoader, Field field, List<File> list, File file) throws IllegalAccessException, NoSuchFieldException, IOException, IllegalArgumentException {
            int size = list.size();
            StringBuilder sb2 = new StringBuilder((String) field.get(classLoader));
            String[] strArr = new String[size];
            File[] fileArr = new File[size];
            ZipFile[] zipFileArr = new ZipFile[size];
            DexFile[] dexFileArr = new DexFile[size];
            ArrayList<Object> arrayList = new ArrayList<>();
            ListIterator<File> listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                File next = listIterator.next();
                String absolutePath = next.getAbsolutePath();
                String absolutePath2 = file.getAbsolutePath();
                String str = MultiDex.getprefixname(absolutePath);
                sb2.append(':');
                sb2.append(absolutePath);
                int iPreviousIndex = listIterator.previousIndex();
                strArr[iPreviousIndex] = absolutePath;
                fileArr[iPreviousIndex] = next;
                zipFileArr[iPreviousIndex] = new ZipFile(next);
                dexFileArr[iPreviousIndex] = DexFile.loadDex(absolutePath, absolutePath2 + a.f28350w + str + MultiDexExtractor.f6369i, 0);
                arrayList.add(Integer.valueOf(MultiDex.findField(dexFileArr[iPreviousIndex], "mCookie").getInt(dexFileArr[iPreviousIndex])));
            }
            field.set(classLoader, sb2.toString());
            MultiDex.expandFieldArray(classLoader, "mPaths", strArr);
            MultiDex.expandFieldArray(classLoader, "mFiles", fileArr);
            MultiDex.expandFieldArray(classLoader, "mZips", zipFileArr);
            MultiDex.expandFieldArray(classLoader, "mDexs", dexFileArr);
            if (arrayList.size() == 0) {
                return null;
            }
            MultiDex.hasInjected = 1;
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static ArrayList<Object> install(ClassLoader classLoader, Field field, List<File> list, File file, int i10) throws IllegalAccessException, NoSuchFieldException, IOException, IllegalArgumentException {
            int size = list.size();
            StringBuilder sb2 = new StringBuilder((String) field.get(classLoader));
            String[] strArr = new String[size];
            File[] fileArr = new File[size];
            ZipFile[] zipFileArr = new ZipFile[size];
            DexFile[] dexFileArr = new DexFile[size];
            ArrayList<Object> arrayList = new ArrayList<>();
            ListIterator<File> listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                File next = listIterator.next();
                String absolutePath = next.getAbsolutePath();
                String absolutePath2 = file.getAbsolutePath();
                String str = MultiDex.getprefixname(absolutePath);
                sb2.append(':');
                sb2.append(absolutePath);
                int iPreviousIndex = listIterator.previousIndex();
                strArr[iPreviousIndex] = absolutePath;
                fileArr[iPreviousIndex] = next;
                zipFileArr[iPreviousIndex] = new ZipFile(next);
                dexFileArr[iPreviousIndex] = DexFile.loadDex(absolutePath, absolutePath2 + a.f28350w + str + MultiDexExtractor.f6369i, 0);
                arrayList.add(Integer.valueOf(MultiDex.findField(dexFileArr[iPreviousIndex], "mCookie").getInt(dexFileArr[iPreviousIndex])));
            }
            field.set(classLoader, sb2.toString());
            MultiDex.expandFieldArray(classLoader, "mPaths", strArr, i10);
            MultiDex.expandFieldArray(classLoader, "mFiles", fileArr, i10);
            MultiDex.expandFieldArray(classLoader, "mZips", zipFileArr, i10);
            MultiDex.expandFieldArray(classLoader, "mDexs", dexFileArr, i10);
            if (arrayList.size() == 0) {
                return null;
            }
            return arrayList;
        }
    }
}
