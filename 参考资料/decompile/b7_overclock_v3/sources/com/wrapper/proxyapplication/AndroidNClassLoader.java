package com.wrapper.proxyapplication;

import android.app.Application;
import android.content.Context;
import dalvik.system.DexFile;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class AndroidNClassLoader extends PathClassLoader {
    private static final String TAG = "SecShell";
    private static String baseApkFullPath;
    private static Object oldDexPathListHolder;

    private AndroidNClassLoader(String str, ClassLoader classLoader, Application application) {
        super(str, classLoader);
        try {
            baseApkFullPath = application.getPackageCodePath();
        } catch (Throwable unused) {
        }
    }

    private static Object recreateDexPathList(Object obj, ClassLoader classLoader, boolean z10) throws Exception {
        try {
            Constructor<?> constructorFindConstructor = ShareReflectUtil.findConstructor(obj, ClassLoader.class, String.class, String.class, File.class);
            if (z10) {
                return constructorFindConstructor.newInstance(classLoader, "", null, null);
            }
            Object[] objArr = (Object[]) ShareReflectUtil.findField(obj, "dexElements").get(obj);
            List<File> list = (List) ShareReflectUtil.findField(obj, "nativeLibraryDirectories").get(obj);
            StringBuilder sb2 = new StringBuilder();
            Field fieldFindField = ShareReflectUtil.findField(objArr.getClass().getComponentType(), "dexFile");
            boolean z11 = true;
            for (Object obj2 : objArr) {
                DexFile dexFile = (DexFile) fieldFindField.get(obj2);
                if (dexFile != null && dexFile.getName() != null) {
                    try {
                        if (dexFile.getName().equals(baseApkFullPath)) {
                            if (z11) {
                                z11 = false;
                            } else {
                                sb2.append(File.pathSeparator);
                            }
                            sb2.append(dexFile.getName());
                        }
                    } catch (Throwable unused) {
                        return null;
                    }
                }
            }
            String string = sb2.toString();
            StringBuilder sb3 = new StringBuilder();
            boolean z12 = true;
            for (File file : list) {
                if (file != null) {
                    if (z12) {
                        z12 = false;
                    } else {
                        sb3.append(File.pathSeparator);
                    }
                    sb3.append(file.getAbsolutePath());
                }
            }
            String string2 = sb3.toString();
            Object[] objArr2 = new Object[4];
            objArr2[0] = classLoader;
            objArr2[1] = string;
            objArr2[2] = string2;
            try {
                objArr2[3] = null;
                return constructorFindConstructor.newInstance(objArr2);
            } catch (Throwable unused2) {
                return null;
            }
        } catch (Throwable unused3) {
            return null;
        }
    }

    private static ClassLoader createAndroidNClassLoader(String str, ClassLoader classLoader, Application application) throws Exception {
        try {
            AndroidNClassLoader androidNClassLoader = new AndroidNClassLoader(str, classLoader, application);
            Field fieldFindField = ShareReflectUtil.findField(classLoader, "pathList");
            Object obj = fieldFindField.get(classLoader);
            fieldFindField.set(androidNClassLoader, recreateDexPathList(obj, androidNClassLoader, false));
            ShareReflectUtil.findField(obj, "definingContext").set(obj, androidNClassLoader);
            oldDexPathListHolder = obj;
            return androidNClassLoader;
        } catch (Throwable unused) {
            return classLoader;
        }
    }

    private static void reflectPackageInfoClassloader(Application application, ClassLoader classLoader) throws Exception {
        try {
            Context context = (Context) ShareReflectUtil.findField(application, "mBase").get(application);
            Object obj = ShareReflectUtil.findField(context, "mPackageInfo").get(context);
            ShareReflectUtil.findField(obj, "mClassLoader").set(obj, classLoader);
        } catch (Throwable unused) {
        }
    }

    public static ClassLoader inject(ClassLoader classLoader, Application application) throws Exception {
        try {
            ClassLoader classLoaderCreateAndroidNClassLoader = createAndroidNClassLoader("", classLoader, application);
            reflectPackageInfoClassloader(application, classLoaderCreateAndroidNClassLoader);
            return classLoaderCreateAndroidNClassLoader;
        } catch (Throwable unused) {
            return null;
        }
    }
}
