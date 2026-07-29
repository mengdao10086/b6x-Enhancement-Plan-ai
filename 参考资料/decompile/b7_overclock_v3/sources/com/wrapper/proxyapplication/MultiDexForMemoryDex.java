package com.wrapper.proxyapplication;

import android.os.Build;
import fh.a;
import j3.b;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MultiDexForMemoryDex {
    static final String TAG = "MultiDexForMemoryDex";
    static int hasInjected;

    private MultiDexForMemoryDex() {
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

    private static String getprefixname(String str) {
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

    private static ArrayList<Object> installDexes(ClassLoader classLoader, ByteBuffer[] byteBufferArr, boolean z10, boolean z11) {
        try {
            try {
                try {
                    try {
                        return V26.install(classLoader, findField(classLoader, "pathList"), byteBufferArr, z10, z11);
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
            return null;
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

    private static final class V26 {
        private V26() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static ArrayList<Object> install(ClassLoader classLoader, Field field, ByteBuffer[] byteBufferArr, boolean z10, boolean z11) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
            IOException[] iOExceptionArr;
            Object obj = field.get(classLoader);
            ArrayList<IOException> arrayList = new ArrayList();
            Object[] objArrMakeDexElements = makeDexElements(obj, byteBufferArr, arrayList);
            if (objArrMakeDexElements == null || objArrMakeDexElements.length != byteBufferArr.length) {
                return null;
            }
            ArrayList<Object> arrayList2 = new ArrayList<>();
            for (Object obj2 : objArrMakeDexElements) {
                Object obj3 = MultiDexForMemoryDex.findField(obj2, "dexFile").get(obj2);
                Field fieldFindField = MultiDexForMemoryDex.findField(obj3, "mCookie");
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
            MultiDexForMemoryDex.expandFieldArray(obj, "dexElements", objArrMakeDexElements);
            if (arrayList.size() > 0) {
                for (IOException iOException : arrayList) {
                }
                Field fieldFindField2 = MultiDexForMemoryDex.findField(obj, "dexElementsSuppressedExceptions");
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
            MultiDexForMemoryDex.hasInjected = 1;
            return arrayList2;
        }

        private static Object[] makeDexElements(Object obj, ByteBuffer[] byteBufferArr, List<IOException> list) {
            try {
                try {
                    try {
                        return (Object[]) MultiDexForMemoryDex.findMethod(obj, "makeInMemoryDexElements", ByteBuffer[].class, List.class).invoke(obj, byteBufferArr, list);
                    } catch (IllegalAccessException e10) {
                        e10.printStackTrace();
                        return null;
                    } catch (RuntimeException e11) {
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
            } catch (NoSuchMethodException unused) {
            }
        }
    }
}
