package com.blankj.utilcode.util;

import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f11691a = 524288;

    public interface a {
        void a(double d10);
    }

    public a0() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static boolean A(File file, byte[] bArr, boolean z10, boolean z11) {
        if (bArr == null || !l1.t(file)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("create file <");
            sb2.append(file);
            sb2.append("> failed.");
            return false;
        }
        FileChannel fileChannel = null;
        try {
            try {
                FileChannel channel = new FileOutputStream(file, z10).getChannel();
                if (channel == null) {
                    if (channel != null) {
                        try {
                            channel.close();
                        } catch (IOException e10) {
                            e10.printStackTrace();
                        }
                    }
                    return false;
                }
                MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, channel.size(), bArr.length);
                map.put(bArr);
                if (z11) {
                    map.force();
                }
                try {
                    channel.close();
                } catch (IOException e11) {
                    e11.printStackTrace();
                }
                return true;
            } catch (Throwable th2) {
                if (0 != 0) {
                    try {
                        fileChannel.close();
                    } catch (IOException e12) {
                        e12.printStackTrace();
                    }
                }
                throw th2;
            }
        } catch (IOException e13) {
            e13.printStackTrace();
            if (0 != 0) {
                try {
                    fileChannel.close();
                } catch (IOException e14) {
                    e14.printStackTrace();
                }
            }
            return false;
        }
    }

    public static boolean B(String str, byte[] bArr, boolean z10) {
        return C(str, bArr, false, z10);
    }

    public static boolean C(String str, byte[] bArr, boolean z10, boolean z11) {
        return A(l1.P(str), bArr, z10, z11);
    }

    public static boolean D(File file, byte[] bArr) {
        return G(file, bArr, false, null);
    }

    public static boolean E(File file, byte[] bArr, a aVar) {
        return G(file, bArr, false, aVar);
    }

    public static boolean F(File file, byte[] bArr, boolean z10) {
        return G(file, bArr, z10, null);
    }

    public static boolean G(File file, byte[] bArr, boolean z10, a aVar) {
        if (bArr == null) {
            return false;
        }
        return O(file, new ByteArrayInputStream(bArr), z10, aVar);
    }

    public static boolean H(String str, byte[] bArr) {
        return G(l1.P(str), bArr, false, null);
    }

    public static boolean I(String str, byte[] bArr, a aVar) {
        return G(l1.P(str), bArr, false, aVar);
    }

    public static boolean J(String str, byte[] bArr, boolean z10) {
        return G(l1.P(str), bArr, z10, null);
    }

    public static boolean K(String str, byte[] bArr, boolean z10, a aVar) {
        return G(l1.P(str), bArr, z10, aVar);
    }

    public static boolean L(File file, InputStream inputStream) {
        return O(file, inputStream, false, null);
    }

    public static boolean M(File file, InputStream inputStream, a aVar) {
        return O(file, inputStream, false, aVar);
    }

    public static boolean N(File file, InputStream inputStream, boolean z10) {
        return O(file, inputStream, z10, null);
    }

    public static boolean O(File file, InputStream inputStream, boolean z10, a aVar) throws Throwable {
        BufferedOutputStream bufferedOutputStream;
        if (inputStream == null || !l1.t(file)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("create file <");
            sb2.append(file);
            sb2.append("> failed.");
            return false;
        }
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file, z10), f11691a);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e10) {
            e = e10;
        }
        try {
            if (aVar != null) {
                double dAvailable = inputStream.available();
                aVar.a(0.0d);
                byte[] bArr = new byte[f11691a];
                int i10 = 0;
                while (true) {
                    int i11 = inputStream.read(bArr);
                    if (i11 == -1) {
                        break;
                    }
                    bufferedOutputStream.write(bArr, 0, i11);
                    i10 += i11;
                    aVar.a(((double) i10) / dAvailable);
                }
            } else {
                byte[] bArr2 = new byte[f11691a];
                while (true) {
                    int i12 = inputStream.read(bArr2);
                    if (i12 == -1) {
                        break;
                    }
                    bufferedOutputStream.write(bArr2, 0, i12);
                }
            }
            try {
                inputStream.close();
            } catch (IOException e11) {
                e11.printStackTrace();
            }
            try {
                bufferedOutputStream.close();
            } catch (IOException e12) {
                e12.printStackTrace();
            }
            return true;
        } catch (IOException e13) {
            e = e13;
            bufferedOutputStream2 = bufferedOutputStream;
            e.printStackTrace();
            try {
                inputStream.close();
            } catch (IOException e14) {
                e14.printStackTrace();
            }
            if (bufferedOutputStream2 != null) {
                try {
                    bufferedOutputStream2.close();
                } catch (IOException e15) {
                    e15.printStackTrace();
                }
            }
            return false;
        } catch (Throwable th3) {
            th = th3;
            bufferedOutputStream2 = bufferedOutputStream;
            try {
                inputStream.close();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
            if (bufferedOutputStream2 == null) {
                throw th;
            }
            try {
                bufferedOutputStream2.close();
                throw th;
            } catch (IOException e17) {
                e17.printStackTrace();
                throw th;
            }
        }
    }

    public static boolean P(String str, InputStream inputStream) {
        return O(l1.P(str), inputStream, false, null);
    }

    public static boolean Q(String str, InputStream inputStream, a aVar) {
        return O(l1.P(str), inputStream, false, aVar);
    }

    public static boolean R(String str, InputStream inputStream, boolean z10) {
        return O(l1.P(str), inputStream, z10, null);
    }

    public static boolean S(String str, InputStream inputStream, boolean z10, a aVar) {
        return O(l1.P(str), inputStream, z10, aVar);
    }

    public static boolean T(File file, String str) {
        return U(file, str, false);
    }

    public static boolean U(File file, String str, boolean z10) throws Throwable {
        BufferedWriter bufferedWriter;
        if (file == null || str == null) {
            return false;
        }
        if (!l1.t(file)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("create file <");
            sb2.append(file);
            sb2.append("> failed.");
            return false;
        }
        BufferedWriter bufferedWriter2 = null;
        try {
            try {
                bufferedWriter = new BufferedWriter(new FileWriter(file, z10));
            } catch (IOException e10) {
                e = e10;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            bufferedWriter.write(str);
            try {
                bufferedWriter.close();
            } catch (IOException e11) {
                e11.printStackTrace();
            }
            return true;
        } catch (IOException e12) {
            e = e12;
            bufferedWriter2 = bufferedWriter;
            e.printStackTrace();
            if (bufferedWriter2 != null) {
                try {
                    bufferedWriter2.close();
                } catch (IOException e13) {
                    e13.printStackTrace();
                }
            }
            return false;
        } catch (Throwable th3) {
            th = th3;
            bufferedWriter2 = bufferedWriter;
            if (bufferedWriter2 != null) {
                try {
                    bufferedWriter2.close();
                } catch (IOException e14) {
                    e14.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static boolean V(String str, String str2) {
        return U(l1.P(str), str2, false);
    }

    public static boolean W(String str, String str2, boolean z10) {
        return U(l1.P(str), str2, z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static byte[] a(File file) throws Throwable {
        FileChannel channel;
        FileChannel fileChannel = 0;
        try {
            if (!l1.u0(file)) {
                return null;
            }
            try {
                channel = new RandomAccessFile(file, SsManifestParser.e.J).getChannel();
                try {
                    if (channel == null) {
                        byte[] bArr = new byte[0];
                        if (channel != null) {
                            try {
                                channel.close();
                            } catch (IOException e10) {
                                e10.printStackTrace();
                            }
                        }
                        return bArr;
                    }
                    ByteBuffer byteBufferAllocate = ByteBuffer.allocate((int) channel.size());
                    while (channel.read(byteBufferAllocate) > 0) {
                    }
                    byte[] bArrArray = byteBufferAllocate.array();
                    try {
                        channel.close();
                    } catch (IOException e11) {
                        e11.printStackTrace();
                    }
                    return bArrArray;
                } catch (IOException e12) {
                    e = e12;
                    e.printStackTrace();
                    if (channel != null) {
                        try {
                            channel.close();
                        } catch (IOException e13) {
                            e13.printStackTrace();
                        }
                    }
                    return null;
                }
            } catch (IOException e14) {
                e = e14;
                channel = null;
            } catch (Throwable th2) {
                th = th2;
                if (fileChannel != 0) {
                    try {
                        fileChannel.close();
                    } catch (IOException e15) {
                        e15.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileChannel = file;
        }
    }

    public static byte[] b(String str) {
        return a(l1.P(str));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static byte[] c(File file) throws Throwable {
        FileChannel channel;
        FileChannel fileChannel = 0;
        try {
            if (!l1.u0(file)) {
                return null;
            }
            try {
                channel = new RandomAccessFile(file, SsManifestParser.e.J).getChannel();
                try {
                    if (channel == null) {
                        byte[] bArr = new byte[0];
                        if (channel != null) {
                            try {
                                channel.close();
                            } catch (IOException e10) {
                                e10.printStackTrace();
                            }
                        }
                        return bArr;
                    }
                    int size = (int) channel.size();
                    byte[] bArr2 = new byte[size];
                    channel.map(FileChannel.MapMode.READ_ONLY, 0L, size).load().get(bArr2, 0, size);
                    try {
                        channel.close();
                    } catch (IOException e11) {
                        e11.printStackTrace();
                    }
                    return bArr2;
                } catch (IOException e12) {
                    e = e12;
                    e.printStackTrace();
                    if (channel != null) {
                        try {
                            channel.close();
                        } catch (IOException e13) {
                            e13.printStackTrace();
                        }
                    }
                    return null;
                }
            } catch (IOException e14) {
                e = e14;
                channel = null;
            } catch (Throwable th2) {
                th = th2;
                if (fileChannel != 0) {
                    try {
                        fileChannel.close();
                    } catch (IOException e15) {
                        e15.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileChannel = file;
        }
    }

    public static byte[] d(String str) {
        return c(l1.P(str));
    }

    public static byte[] e(File file) {
        return f(file, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x0087 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:? A[Catch: FileNotFoundException -> 0x0090, SYNTHETIC, TRY_LEAVE, TryCatch #0 {FileNotFoundException -> 0x0090, blocks: (B:5:0x0008, B:24:0x005b, B:20:0x0053, B:41:0x0078, B:36:0x006e, B:53:0x008f, B:52:0x008c, B:47:0x0082, B:21:0x0056, B:38:0x0073, B:44:0x007d, B:17:0x004e, B:33:0x0069, B:49:0x0087), top: B:57:0x0008, inners: #1, #3, #5, #6, #8, #10 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static byte[] f(java.io.File r10, com.blankj.utilcode.util.a0.a r11) throws java.lang.Throwable {
        /*
            boolean r0 = com.blankj.utilcode.util.l1.u0(r10)
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream     // Catch: java.io.FileNotFoundException -> L90
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.io.FileNotFoundException -> L90
            r2.<init>(r10)     // Catch: java.io.FileNotFoundException -> L90
            int r10 = com.blankj.utilcode.util.a0.f11691a     // Catch: java.io.FileNotFoundException -> L90
            r0.<init>(r2, r10)     // Catch: java.io.FileNotFoundException -> L90
            java.io.ByteArrayOutputStream r10 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L61 java.io.IOException -> L64
            r10.<init>()     // Catch: java.lang.Throwable -> L61 java.io.IOException -> L64
            int r2 = com.blankj.utilcode.util.a0.f11691a     // Catch: java.io.IOException -> L5f java.lang.Throwable -> L7c
            byte[] r2 = new byte[r2]     // Catch: java.io.IOException -> L5f java.lang.Throwable -> L7c
            r3 = -1
            r4 = 0
            if (r11 != 0) goto L2d
        L21:
            int r11 = com.blankj.utilcode.util.a0.f11691a     // Catch: java.io.IOException -> L5f java.lang.Throwable -> L7c
            int r11 = r0.read(r2, r4, r11)     // Catch: java.io.IOException -> L5f java.lang.Throwable -> L7c
            if (r11 == r3) goto L4a
            r10.write(r2, r4, r11)     // Catch: java.io.IOException -> L5f java.lang.Throwable -> L7c
            goto L21
        L2d:
            int r5 = r0.available()     // Catch: java.io.IOException -> L5f java.lang.Throwable -> L7c
            double r5 = (double) r5     // Catch: java.io.IOException -> L5f java.lang.Throwable -> L7c
            r7 = 0
            r11.a(r7)     // Catch: java.io.IOException -> L5f java.lang.Throwable -> L7c
            r7 = 0
        L38:
            int r8 = com.blankj.utilcode.util.a0.f11691a     // Catch: java.io.IOException -> L5f java.lang.Throwable -> L7c
            int r8 = r0.read(r2, r4, r8)     // Catch: java.io.IOException -> L5f java.lang.Throwable -> L7c
            if (r8 == r3) goto L4a
            r10.write(r2, r4, r8)     // Catch: java.io.IOException -> L5f java.lang.Throwable -> L7c
            int r7 = r7 + r8
            double r8 = (double) r7     // Catch: java.io.IOException -> L5f java.lang.Throwable -> L7c
            double r8 = r8 / r5
            r11.a(r8)     // Catch: java.io.IOException -> L5f java.lang.Throwable -> L7c
            goto L38
        L4a:
            byte[] r11 = r10.toByteArray()     // Catch: java.io.IOException -> L5f java.lang.Throwable -> L7c
            r0.close()     // Catch: java.io.IOException -> L52
            goto L56
        L52:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.io.FileNotFoundException -> L90
        L56:
            r10.close()     // Catch: java.io.IOException -> L5a
            goto L5e
        L5a:
            r10 = move-exception
            r10.printStackTrace()     // Catch: java.io.FileNotFoundException -> L90
        L5e:
            return r11
        L5f:
            r11 = move-exception
            goto L66
        L61:
            r11 = move-exception
            r10 = r1
            goto L7d
        L64:
            r11 = move-exception
            r10 = r1
        L66:
            r11.printStackTrace()     // Catch: java.lang.Throwable -> L7c
            r0.close()     // Catch: java.io.IOException -> L6d
            goto L71
        L6d:
            r11 = move-exception
            r11.printStackTrace()     // Catch: java.io.FileNotFoundException -> L90
        L71:
            if (r10 == 0) goto L7b
            r10.close()     // Catch: java.io.IOException -> L77
            goto L7b
        L77:
            r10 = move-exception
            r10.printStackTrace()     // Catch: java.io.FileNotFoundException -> L90
        L7b:
            return r1
        L7c:
            r11 = move-exception
        L7d:
            r0.close()     // Catch: java.io.IOException -> L81
            goto L85
        L81:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.io.FileNotFoundException -> L90
        L85:
            if (r10 == 0) goto L8f
            r10.close()     // Catch: java.io.IOException -> L8b
            goto L8f
        L8b:
            r10 = move-exception
            r10.printStackTrace()     // Catch: java.io.FileNotFoundException -> L90
        L8f:
            throw r11     // Catch: java.io.FileNotFoundException -> L90
        L90:
            r10 = move-exception
            r10.printStackTrace()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.a0.f(java.io.File, com.blankj.utilcode.util.a0$a):byte[]");
    }

    public static byte[] g(String str) {
        return f(l1.P(str), null);
    }

    public static byte[] h(String str, a aVar) {
        return f(l1.P(str), aVar);
    }

    public static List<String> i(File file) {
        return k(file, 0, Integer.MAX_VALUE, null);
    }

    public static List<String> j(File file, int i10, int i11) {
        return k(file, i10, i11, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x006b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.List<java.lang.String> k(java.io.File r6, int r7, int r8, java.lang.String r9) throws java.lang.Throwable {
        /*
            boolean r0 = com.blankj.utilcode.util.l1.u0(r6)
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            if (r7 <= r8) goto Lb
            return r1
        Lb:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
            r0.<init>()     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
            boolean r2 = com.blankj.utilcode.util.l1.C0(r9)     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
            r3 = 1
            if (r2 == 0) goto L27
            java.io.BufferedReader r9 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
            r4.<init>(r6)     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
            r9.<init>(r2)     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
            goto L37
        L27:
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
            r4.<init>(r5, r9)     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L55 java.io.IOException -> L57
            r9 = r2
        L37:
            java.lang.String r6 = r9.readLine()     // Catch: java.io.IOException -> L53 java.lang.Throwable -> L67
            if (r6 == 0) goto L4a
            if (r3 <= r8) goto L40
            goto L4a
        L40:
            if (r7 > r3) goto L47
            if (r3 > r8) goto L47
            r0.add(r6)     // Catch: java.io.IOException -> L53 java.lang.Throwable -> L67
        L47:
            int r3 = r3 + 1
            goto L37
        L4a:
            r9.close()     // Catch: java.io.IOException -> L4e
            goto L52
        L4e:
            r6 = move-exception
            r6.printStackTrace()
        L52:
            return r0
        L53:
            r6 = move-exception
            goto L59
        L55:
            r6 = move-exception
            goto L69
        L57:
            r6 = move-exception
            r9 = r1
        L59:
            r6.printStackTrace()     // Catch: java.lang.Throwable -> L67
            if (r9 == 0) goto L66
            r9.close()     // Catch: java.io.IOException -> L62
            goto L66
        L62:
            r6 = move-exception
            r6.printStackTrace()
        L66:
            return r1
        L67:
            r6 = move-exception
            r1 = r9
        L69:
            if (r1 == 0) goto L73
            r1.close()     // Catch: java.io.IOException -> L6f
            goto L73
        L6f:
            r7 = move-exception
            r7.printStackTrace()
        L73:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.a0.k(java.io.File, int, int, java.lang.String):java.util.List");
    }

    public static List<String> l(File file, String str) {
        return k(file, 0, Integer.MAX_VALUE, str);
    }

    public static List<String> m(String str) {
        return l(l1.P(str), null);
    }

    public static List<String> n(String str, int i10, int i11) {
        return k(l1.P(str), i10, i11, null);
    }

    public static List<String> o(String str, int i10, int i11, String str2) {
        return k(l1.P(str), i10, i11, str2);
    }

    public static List<String> p(String str, String str2) {
        return l(l1.P(str), str2);
    }

    public static String q(File file) {
        return r(file, null);
    }

    public static String r(File file, String str) {
        byte[] bArrE = e(file);
        if (bArrE == null) {
            return null;
        }
        if (l1.C0(str)) {
            return new String(bArrE);
        }
        try {
            return new String(bArrE, str);
        } catch (UnsupportedEncodingException e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static String s(String str) {
        return r(l1.P(str), null);
    }

    public static String t(String str, String str2) {
        return r(l1.P(str), str2);
    }

    public static void u(int i10) {
        f11691a = i10;
    }

    public static boolean v(File file, byte[] bArr, boolean z10) {
        return w(file, bArr, false, z10);
    }

    public static boolean w(File file, byte[] bArr, boolean z10, boolean z11) {
        if (bArr == null) {
            return false;
        }
        if (!l1.t(file)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("create file <");
            sb2.append(file);
            sb2.append("> failed.");
            return false;
        }
        FileChannel fileChannel = null;
        try {
            try {
                FileChannel channel = new FileOutputStream(file, z10).getChannel();
                if (channel == null) {
                    if (channel != null) {
                        try {
                            channel.close();
                        } catch (IOException e10) {
                            e10.printStackTrace();
                        }
                    }
                    return false;
                }
                channel.position(channel.size());
                channel.write(ByteBuffer.wrap(bArr));
                if (z11) {
                    channel.force(true);
                }
                try {
                    channel.close();
                } catch (IOException e11) {
                    e11.printStackTrace();
                }
                return true;
            } catch (Throwable th2) {
                if (0 != 0) {
                    try {
                        fileChannel.close();
                    } catch (IOException e12) {
                        e12.printStackTrace();
                    }
                }
                throw th2;
            }
        } catch (IOException e13) {
            e13.printStackTrace();
            if (0 != 0) {
                try {
                    fileChannel.close();
                } catch (IOException e14) {
                    e14.printStackTrace();
                }
            }
            return false;
        }
    }

    public static boolean x(String str, byte[] bArr, boolean z10) {
        return w(l1.P(str), bArr, false, z10);
    }

    public static boolean y(String str, byte[] bArr, boolean z10, boolean z11) {
        return w(l1.P(str), bArr, z10, z11);
    }

    public static boolean z(File file, byte[] bArr, boolean z10) {
        return A(file, bArr, false, z10);
    }
}
