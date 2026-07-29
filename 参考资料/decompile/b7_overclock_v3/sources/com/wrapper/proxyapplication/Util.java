package com.wrapper.proxyapplication;

import android.os.Process;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import hd.u0;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import x9.d;

/* JADX INFO: loaded from: classes.dex */
public class Util {
    public static String CPUABI = null;
    static final int ERROR_EXCEPTION = -2;
    static final int ERROR_FALSE = 0;
    static final int ERROR_FILE_EXIST = 2;
    static final int ERROR_FILE_NOT_FOUND = -1;
    static final int ERROR_FILE_NOT_FOUND_INZIP = -3;
    static final int ERROR_SUCCESS = 1;
    public static String libname;
    public static String simplelibname;
    public static int MAX_DEX_NUM = 300;
    public static String TAG = u0.f31160g;
    public static String securename0 = "00O000ll111l.dex";
    public static String securename1 = "00O000ll111l.jar";
    public static String securename2 = "000O00ll111l.dex";
    public static String securename3 = "0000000lllll.dex";
    public static String securename4 = "000000olllll.dex";
    public static String securename5 = "0OO00l111l1l";
    public static String securename6 = "o0oooOO0ooOo.dat";
    public static String securename7 = "exportService.txt";
    public static String securename8 = ".flag00O000ll111l.dex";
    public static String securename9 = ".updateIV.dat";
    public static String versionname = "tosversion";
    public static String securename11 = ".flag00O000ll111l.vdex";
    public static String securename14 = "00O000ll111l.vdex";
    public static String securename15 = "00O000ll111l.odex";
    public static String dexname = "classes.dex";
    public static boolean ifoverwrite = true;

    static {
        CPUABI = null;
        libname = "";
        simplelibname = "";
        int tid = Process.myTid();
        CPUABI = getelffilearch("/proc/" + tid + "/exe");
        String str = CPUABI;
        if (str != "86" && str != "86_64") {
            simplelibname = "shell-super.com.fdg.flashplay.farsee";
            libname = d.f54956g + simplelibname + ".so";
            return;
        }
        simplelibname = "shellx-super.com.fdg.flashplay.farsee";
        libname = d.f54956g + simplelibname + ".so";
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:8:0x001a -> B:29:0x0034). Please report as a decompilation issue!!! */
    public static int readelfarch(String filename) throws IOException {
        int c10 = 0;
        RandomAccessFile rf2 = null;
        try {
            try {
                try {
                    try {
                        rf2 = new RandomAccessFile(filename, SsManifestParser.e.J);
                        rf2.seek(18L);
                        c10 = rf2.read();
                        rf2.close();
                    } catch (IOException e10) {
                        e10.printStackTrace();
                        if (rf2 != null) {
                            rf2.close();
                        }
                        return c10;
                    }
                } catch (FileNotFoundException e11) {
                    e11.printStackTrace();
                    if (rf2 != null) {
                        rf2.close();
                    }
                    return c10;
                }
            } catch (IOException e12) {
                e12.printStackTrace();
            }
            return c10;
        } catch (Throwable th2) {
            if (rf2 != null) {
                try {
                    rf2.close();
                } catch (IOException e13) {
                    e13.printStackTrace();
                }
            }
            throw th2;
        }
    }

    public static String getelffilearch(String elffile) throws IOException {
        int archcode = readelfarch(elffile);
        if (archcode == 3) {
            return "86";
        }
        if (archcode == 40) {
            return "armeabi";
        }
        if (archcode == 62) {
            return "86_64";
        }
        if (archcode == 183) {
            return "arm64-v8a";
        }
        return "unknown";
    }

    public static int DeleteFile(String filepath) {
        File tmpfile = new File(filepath);
        if (tmpfile.exists()) {
            if (!tmpfile.delete()) {
                return -2;
            }
            return 1;
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:126:0x00c6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean UnzipFile(java.util.zip.ZipFile r7, java.lang.String r8, java.io.File r9) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wrapper.proxyapplication.Util.UnzipFile(java.util.zip.ZipFile, java.lang.String, java.io.File):boolean");
    }

    public static int Comparetxtinzip(ZipFile apkzf, String filepathinzip, File fileinfiledir) throws IOException {
        BufferedInputStream checkzbr = null;
        BufferedInputStream checkfbr = null;
        ZipEntry cookie_entry = apkzf.getEntry(filepathinzip);
        if (cookie_entry == null) {
            try {
                if (0 != 0) {
                    try {
                        checkzbr.close();
                        if (0 != 0) {
                            try {
                                checkfbr.close();
                            } catch (IOException e10) {
                                e10.printStackTrace();
                                return -2;
                            }
                        }
                    } catch (IOException e11) {
                        e11.printStackTrace();
                        if (0 != 0) {
                            try {
                                checkfbr.close();
                            } catch (IOException e12) {
                                e12.printStackTrace();
                                return -2;
                            }
                        }
                        return -2;
                    }
                }
                return -3;
            } catch (Throwable e13) {
                if (0 != 0) {
                    try {
                        checkfbr.close();
                    } catch (IOException e14) {
                        e14.printStackTrace();
                        return -2;
                    }
                }
                throw e13;
            }
        }
        try {
            try {
                byte[] checkzipbuf = new byte[1024];
                byte[] checkfilebuf = new byte[1024];
                checkzbr = new BufferedInputStream(apkzf.getInputStream(cookie_entry));
                int readziplen = checkzbr.read(checkzipbuf);
                String tmpzipstr = new String(checkzipbuf).substring(0, readziplen);
                checkfbr = new BufferedInputStream(new FileInputStream(fileinfiledir));
                int readfilelen = checkfbr.read(checkfilebuf);
                String tmpfilestr = new String(checkfilebuf).substring(0, readfilelen);
                int result = tmpfilestr.equals(tmpzipstr) ? 1 : 0;
                try {
                    try {
                        checkzbr.close();
                        try {
                            checkfbr.close();
                            return result;
                        } catch (IOException e15) {
                            e15.printStackTrace();
                            return -2;
                        }
                    } catch (IOException e16) {
                        e16.printStackTrace();
                        try {
                            checkfbr.close();
                            return -2;
                        } catch (IOException e17) {
                            e17.printStackTrace();
                            return -2;
                        }
                    }
                } catch (Throwable e18) {
                    try {
                        checkfbr.close();
                        throw e18;
                    } catch (IOException e19) {
                        e19.printStackTrace();
                        return -2;
                    }
                }
            } catch (Exception e20) {
                e20.printStackTrace();
                if (checkzbr != null) {
                    try {
                        try {
                            checkzbr.close();
                            if (checkfbr != null) {
                                try {
                                    checkfbr.close();
                                } catch (IOException e21) {
                                    e21.printStackTrace();
                                    return -2;
                                }
                            }
                        } catch (IOException e22) {
                            e22.printStackTrace();
                            if (checkfbr != null) {
                                try {
                                    checkfbr.close();
                                } catch (IOException e23) {
                                    e23.printStackTrace();
                                    return -2;
                                }
                            }
                            return -2;
                        }
                    } catch (Throwable e24) {
                        if (checkfbr != null) {
                            try {
                                checkfbr.close();
                            } catch (IOException e25) {
                                e25.printStackTrace();
                                return -2;
                            }
                        }
                        throw e24;
                    }
                }
                return -2;
            }
        } catch (Throwable e26) {
            if (checkzbr != null) {
                try {
                    try {
                        checkzbr.close();
                        if (checkfbr != null) {
                            try {
                                checkfbr.close();
                            } catch (IOException e27) {
                                e27.printStackTrace();
                                return -2;
                            }
                        }
                    } catch (IOException e28) {
                        e28.printStackTrace();
                        if (checkfbr != null) {
                            try {
                                checkfbr.close();
                            } catch (IOException e29) {
                                e29.printStackTrace();
                                return -2;
                            }
                        }
                        return -2;
                    }
                } catch (Throwable e30) {
                    if (checkfbr != null) {
                        try {
                            checkfbr.close();
                        } catch (IOException e31) {
                            e31.printStackTrace();
                            return -2;
                        }
                    }
                    throw e30;
                }
            }
            throw e26;
        }
    }

    public static boolean deleteDir(File file) {
        if (file.isDirectory()) {
            String[] children = file.list();
            for (String str : children) {
                boolean success = deleteDir(new File(file, str));
                if (!success) {
                    return false;
                }
            }
        }
        if (!file.exists()) {
            return true;
        }
        boolean result = file.delete();
        return result;
    }

    /* JADX WARN: Removed duplicated region for block: B:442:0x1119  */
    /* JADX WARN: Removed duplicated region for block: B:446:0x116b  */
    /* JADX WARN: Removed duplicated region for block: B:449:0x1185  */
    /* JADX WARN: Removed duplicated region for block: B:454:0x11e5  */
    /* JADX WARN: Removed duplicated region for block: B:459:0x1236  */
    /* JADX WARN: Removed duplicated region for block: B:558:0x1309 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:768:0x124a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int PrepareSecurefiles(android.content.Context r32, java.util.zip.ZipFile r33) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 5390
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wrapper.proxyapplication.Util.PrepareSecurefiles(android.content.Context, java.util.zip.ZipFile):int");
    }

    private static boolean isFileValid(String path, long length) {
        File tmpfile = new File(path);
        if (tmpfile.exists() && tmpfile.length() == length) {
            return true;
        }
        return false;
    }

    public static long getCRC32(File fileUri) {
        CRC32 crc32 = new CRC32();
        long crc = 0;
        try {
            try {
                BufferedInputStream bufbr = new BufferedInputStream(new FileInputStream(fileUri));
                CheckedInputStream checkedinputstream = new CheckedInputStream(bufbr, crc32);
                byte[] buf = new byte[65536];
                while (checkedinputstream.read(buf) >= 0) {
                }
                crc = checkedinputstream.getChecksum().getValue();
                checkedinputstream.close();
            } catch (IOException e10) {
                e10.printStackTrace();
            }
        } catch (FileNotFoundException e11) {
            e11.printStackTrace();
        }
        return crc;
    }

    public static String CreatenewFileName(String Oldfilename, String SplitString, String InsertString) {
        int index = Oldfilename.lastIndexOf(SplitString);
        if (index >= 0) {
            return Oldfilename.substring(0, index) + InsertString + Oldfilename.substring(index, Oldfilename.length());
        }
        return null;
    }

    public static boolean SafeUnzipFile(ZipFile zf2, String filepathinzip, File fileinfiledir) {
        return SafeUnzipFile(zf2, filepathinzip, fileinfiledir, 0L);
    }

    public static boolean SafeUnzipFile(ZipFile zf2, String filepathinzip, File fileinfiledir, long crc) throws IOException {
        BufferedOutputStream Output_fos = null;
        BufferedInputStream bufbr = null;
        try {
            try {
                ZipEntry ze2 = zf2.getEntry(filepathinzip);
                if (ze2 == null) {
                    if (0 != 0) {
                        try {
                            try {
                                Output_fos.close();
                                if (0 != 0) {
                                    try {
                                        bufbr.close();
                                    } catch (IOException e10) {
                                        e10.printStackTrace();
                                        return false;
                                    }
                                }
                            } catch (IOException e11) {
                                e11.printStackTrace();
                                if (0 != 0) {
                                    try {
                                        bufbr.close();
                                    } catch (IOException e12) {
                                        e12.printStackTrace();
                                        return false;
                                    }
                                }
                                return false;
                            }
                        } catch (Throwable e13) {
                            if (0 != 0) {
                                try {
                                    bufbr.close();
                                } catch (IOException e14) {
                                    e14.printStackTrace();
                                    return false;
                                }
                            }
                            throw e13;
                        }
                    }
                    return false;
                }
                if (crc != 0 && ze2.getCrc() == crc) {
                    if (0 != 0) {
                        try {
                            try {
                                Output_fos.close();
                                if (0 != 0) {
                                    try {
                                        bufbr.close();
                                    } catch (IOException e15) {
                                        e15.printStackTrace();
                                        return false;
                                    }
                                }
                            } catch (IOException e16) {
                                e16.printStackTrace();
                                if (0 != 0) {
                                    try {
                                        bufbr.close();
                                    } catch (IOException e17) {
                                        e17.printStackTrace();
                                        return false;
                                    }
                                }
                                return false;
                            }
                        } catch (Throwable e18) {
                            if (0 != 0) {
                                try {
                                    bufbr.close();
                                } catch (IOException e19) {
                                    e19.printStackTrace();
                                    return false;
                                }
                            }
                            throw e18;
                        }
                    }
                    return true;
                }
                byte[] buf = UnzipFile(zf2, ze2);
                if (1 != 0) {
                    Output_fos = new BufferedOutputStream(new FileOutputStream(fileinfiledir));
                    Output_fos.write(buf, 0, buf.length);
                }
                try {
                    if (Output_fos != null) {
                        try {
                            Output_fos.close();
                            if (0 != 0) {
                                try {
                                    bufbr.close();
                                } catch (IOException e20) {
                                    e20.printStackTrace();
                                    return false;
                                }
                            }
                        } catch (IOException e21) {
                            e21.printStackTrace();
                            if (0 != 0) {
                                try {
                                    bufbr.close();
                                } catch (IOException e22) {
                                    e22.printStackTrace();
                                    return false;
                                }
                            }
                            return false;
                        }
                    }
                    return true;
                } catch (Throwable e23) {
                    if (0 != 0) {
                        try {
                            bufbr.close();
                        } catch (IOException e24) {
                            e24.printStackTrace();
                            return false;
                        }
                    }
                    throw e23;
                }
            } catch (Throwable th2) {
                if (Output_fos != null) {
                    try {
                        try {
                            Output_fos.close();
                            if (0 != 0) {
                                try {
                                    bufbr.close();
                                } catch (IOException e25) {
                                    e25.printStackTrace();
                                    return false;
                                }
                            }
                        } catch (IOException e26) {
                            e26.printStackTrace();
                            if (0 != 0) {
                                try {
                                    bufbr.close();
                                } catch (IOException e27) {
                                    e27.printStackTrace();
                                    return false;
                                }
                            }
                            return false;
                        }
                    } catch (Throwable e28) {
                        if (0 != 0) {
                            try {
                                bufbr.close();
                            } catch (IOException e29) {
                                e29.printStackTrace();
                                return false;
                            }
                        }
                        throw e28;
                    }
                }
                throw th2;
            }
        } catch (Exception e30) {
            e30.printStackTrace();
            if (Output_fos != null) {
                try {
                    try {
                        Output_fos.close();
                        if (0 != 0) {
                            try {
                                bufbr.close();
                            } catch (IOException e31) {
                                e31.printStackTrace();
                                return false;
                            }
                        }
                    } catch (IOException e32) {
                        e32.printStackTrace();
                        if (0 != 0) {
                            try {
                                bufbr.close();
                            } catch (IOException e33) {
                                e33.printStackTrace();
                                return false;
                            }
                        }
                        return false;
                    }
                } catch (Throwable e34) {
                    if (0 != 0) {
                        try {
                            bufbr.close();
                        } catch (IOException e35) {
                            e35.printStackTrace();
                            return false;
                        }
                    }
                    throw e34;
                }
            }
            return false;
        }
    }

    public static byte[] UnzipFile(ZipFile zf2, ZipEntry ze2) throws IOException {
        byte[] buf = new byte[(int) ze2.getSize()];
        BufferedInputStream bufbr = new BufferedInputStream(zf2.getInputStream(ze2));
        int totallen = 0;
        do {
            int readlen = bufbr.read(buf, totallen, ((int) ze2.getSize()) - totallen);
            if (readlen < 0) {
                break;
            }
            totallen += readlen;
        } while (totallen != ze2.getSize());
        if (totallen != ((int) ze2.getSize())) {
            throw new IOException("incorrect zip file size");
        }
        return buf;
    }

    private static long getFileCRC32(File file) {
        long result = -1;
        byte[] filebuf = new byte[(int) file.length()];
        BufferedInputStream filebr = null;
        CRC32 crc32 = new CRC32();
        try {
        } catch (IOException e10) {
            e10.printStackTrace();
        }
        try {
            try {
                filebr = new BufferedInputStream(new FileInputStream(file));
                int totallen = 0;
                while (true) {
                    int readlen = filebr.read(filebuf);
                    if (readlen < 0) {
                        break;
                    }
                    crc32.update(filebuf);
                    totallen += readlen;
                }
                result = crc32.getValue();
                filebr.close();
            } catch (Throwable th2) {
                if (filebr != null) {
                    try {
                        filebr.close();
                    } catch (IOException e11) {
                        e11.printStackTrace();
                    }
                }
                throw th2;
            }
        } catch (FileNotFoundException e12) {
            e12.printStackTrace();
            if (filebr != null) {
                filebr.close();
            }
            return result;
        } catch (IOException e13) {
            e13.printStackTrace();
            if (filebr != null) {
                filebr.close();
            }
            return result;
        }
        return result;
    }

    private static boolean checkCopiedFileCrc(ZipFile zf2, String filepathinzip, File file) {
        long crc = getFileCRC32(file);
        if (crc == -1) {
            return false;
        }
        try {
            ZipEntry ze2 = zf2.getEntry(filepathinzip);
            if (ze2 != null && crc != 0) {
                if (ze2.getCrc() == crc) {
                    return true;
                }
            }
            return false;
        } catch (Exception e10) {
            return false;
        }
    }
}
