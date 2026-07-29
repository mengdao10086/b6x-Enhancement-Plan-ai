package com.wrapper.proxyapplication;

import android.annotation.SuppressLint;
import android.os.Build;
import androidx.constraintlayout.widget.d;
import androidx.multidex.MultiDexExtractor;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.umeng.socialize.utils.DeviceConfigInternal;
import dalvik.system.DexFile;
import dalvik.system.PathClassLoader;
import fh.a;
import j3.b;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import zc.f;

/* JADX INFO: loaded from: classes.dex */
public class CustomerClassLoader extends PathClassLoader {
    private static final boolean VERBOSE_DEBUG = false;
    private boolean initialized;
    private final String libPath;
    private final String mDexOutputPath;
    private DexFile[] mDexs;
    private File[] mFiles;
    private String[] mLibPaths;
    private String[] mPaths;
    private ZipFile[] mZips;
    private final String path;

    private native int ShowLogs(String str, int i10);

    public CustomerClassLoader(String path, String optimizedDirectory, String libPath, ClassLoader parent) throws IllegalAccessException, NoSuchFieldException, IOException, IllegalArgumentException, NullPointerException {
        super("", libPath, parent.getParent());
        if (path == null || optimizedDirectory == null) {
            throw new NullPointerException();
        }
        this.path = path;
        this.libPath = libPath;
        this.mDexOutputPath = optimizedDirectory;
        try {
            Field parentLoader = findField(parent, d.V1);
            parentLoader.set(parent, this);
            ensureInit();
        } catch (IOException e22) {
            throw e22;
        } catch (NoSuchFieldException e10) {
            throw e10;
        }
    }

    private synchronized void ensureInit() throws IOException {
        if (this.initialized) {
            return;
        }
        this.initialized = true;
        this.mPaths = this.path.split(":");
        int length = this.mPaths.length;
        this.mFiles = new File[length];
        this.mZips = new ZipFile[length];
        this.mDexs = new DexFile[length];
        for (int i10 = 0; i10 < length; i10++) {
            File pathFile = new File(this.mPaths[i10]);
            this.mFiles[i10] = pathFile;
            if (Build.VERSION.SDK_INT > 33) {
                pathFile.setReadOnly();
            }
            if (pathFile.isFile()) {
                try {
                    this.mZips[i10] = new ZipFile(pathFile);
                } catch (IOException e10) {
                }
                try {
                    if (this.mDexOutputPath != null) {
                        String outputName = generateOutputName(this.mPaths[i10], this.mDexOutputPath);
                        this.mDexs[i10] = DexFile.loadDex(this.mPaths[i10], outputName, 0);
                    }
                } catch (IOException e11) {
                    throw new IOException("load dex fail");
                } catch (RuntimeException e12) {
                    throw new IOException("load dex fail");
                }
            }
        }
        String pathList = System.getProperty("java.library.path", b.f36044h);
        String pathSep = System.getProperty("path.separator", ":");
        String fileSep = System.getProperty("file.separator", a.f28350w);
        if (this.libPath != null) {
            if (pathList.length() > 0) {
                String tmpPathList = this.libPath + pathSep + pathList;
                pathList = tmpPathList;
            } else {
                pathList = this.libPath;
            }
        }
        this.mLibPaths = pathList.split(pathSep);
        int length2 = this.mLibPaths.length;
        for (int i11 = 0; i11 < length2; i11++) {
            if (!this.mLibPaths[i11].endsWith(fileSep)) {
                StringBuilder sb2 = new StringBuilder();
                String[] strArr = this.mLibPaths;
                sb2.append(strArr[i11]);
                sb2.append(fileSep);
                strArr[i11] = sb2.toString();
            }
        }
    }

    private static String generateOutputName(String sourcePathName, String outputDir) {
        String sourceFileName;
        StringBuilder newStr = new StringBuilder(80);
        newStr.append(outputDir);
        if (!outputDir.endsWith(a.f28350w)) {
            newStr.append(a.f28350w);
        }
        int lastSlash = sourcePathName.lastIndexOf(a.f28350w);
        if (lastSlash < 0) {
            sourceFileName = sourcePathName;
        } else {
            sourceFileName = sourcePathName.substring(lastSlash + 1);
        }
        int lastDot = sourceFileName.lastIndexOf(b.f36044h);
        if (lastDot < 0) {
            newStr.append(sourceFileName);
        } else {
            newStr.append((CharSequence) sourceFileName, 0, lastDot);
        }
        newStr.append(MultiDexExtractor.f6369i);
        return newStr.toString();
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            ensureInit();
        } catch (IOException e12) {
            e12.printStackTrace();
        }
        int length = this.mPaths.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (this.mDexs[i10] != null) {
                ShowLogs(name, i10);
                String slashName = name.replace('.', f.f58380j);
                Class<?> clsLoadClass = this.mDexs[i10].loadClass(slashName, this);
                if (clsLoadClass != null) {
                    return clsLoadClass;
                }
                try {
                    Class<?> clsFindClass = super.findClass(name);
                    if (clsFindClass != null) {
                        return clsFindClass;
                    }
                } catch (ClassNotFoundException e10) {
                }
            } else if (this.mZips[i10] != null) {
                String fileName = name.replace('.', f.f58380j) + ".class";
                loadFromArchive(this.mZips[i10], fileName);
            } else {
                File pathFile = this.mFiles[i10];
                if (pathFile.isDirectory()) {
                    String fileName2 = this.mPaths[i10] + a.f28350w + name.replace('.', f.f58380j) + ".class";
                    loadFromDirectory(fileName2);
                }
            }
        }
        throw new ClassNotFoundException(name + " in loader " + this);
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    protected URL findResource(String name) {
        URL url = super.findResource(name);
        if (url != null) {
            return url;
        }
        int length = this.mPaths.length;
        for (int i10 = 0; i10 < length; i10++) {
            File pathFile = this.mFiles[i10];
            ZipFile zip = this.mZips[i10];
            if (!this.mPaths[i10].endsWith(MultiDexExtractor.f6369i) && zip.getEntry(name) != null) {
                try {
                    return new URL("jar:" + pathFile.toURL() + "!/" + name);
                } catch (MalformedURLException e10) {
                    throw new RuntimeException(e10);
                }
            }
        }
        return null;
    }

    private byte[] loadFromDirectory(String path) {
        try {
            RandomAccessFile raf = new RandomAccessFile(path, SsManifestParser.e.J);
            try {
                byte[] fileData = new byte[(int) raf.length()];
                raf.read(fileData);
                raf.close();
                return fileData;
            } catch (IOException e10) {
                return null;
            }
        } catch (FileNotFoundException e11) {
            return null;
        }
    }

    private byte[] loadFromArchive(ZipFile zip, String name) {
        ZipEntry entry = zip.getEntry(name);
        if (entry == null) {
            return null;
        }
        try {
            InputStream stream = zip.getInputStream(entry);
            ByteArrayOutputStream byteStream = new ByteArrayOutputStream((int) entry.getSize());
            byte[] buf = new byte[4096];
            while (true) {
                int count = stream.read(buf);
                if (count > 0) {
                    byteStream.write(buf, 0, count);
                } else {
                    stream.close();
                    return byteStream.toByteArray();
                }
            }
        } catch (IOException e10) {
            return null;
        }
    }

    private boolean isInArchive(ZipFile zip, String name) {
        return zip.getEntry(name) != null;
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public String findLibrary(String libname) {
        try {
            ensureInit();
        } catch (IOException e10) {
            e10.printStackTrace();
        }
        String fileName = System.mapLibraryName(libname);
        for (int i10 = 0; i10 < this.mLibPaths.length; i10++) {
            String pathName = this.mLibPaths[i10] + fileName;
            File test = new File(pathName);
            if (test.exists()) {
                return pathName;
            }
            String path = super.findLibrary(libname);
            if (path != null) {
                return path;
            }
        }
        return null;
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    @SuppressLint({"NewApi"})
    protected Package getPackage(String name) {
        Package pack;
        if (name != null && !"".equals(name)) {
            synchronized (this) {
                pack = super.getPackage(name);
                if (pack == null) {
                    pack = definePackage(name, DeviceConfigInternal.UNKNOW, "0.0", DeviceConfigInternal.UNKNOW, DeviceConfigInternal.UNKNOW, "0.0", DeviceConfigInternal.UNKNOW, null);
                }
            }
            return pack;
        }
        return null;
    }

    private static Field findField(Object instance, String name) throws NoSuchFieldException {
        for (Class<?> clazz = instance.getClass(); clazz != null; clazz = clazz.getSuperclass()) {
            try {
                Field field = clazz.getDeclaredField(name);
                if (!field.isAccessible()) {
                    field.setAccessible(true);
                }
                return field;
            } catch (NoSuchFieldException e10) {
            }
        }
        throw new NoSuchFieldException("Field " + name + " not found in " + instance.getClass());
    }
}
