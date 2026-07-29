package com.android.motionelf.tools;

import android.util.Base64;
import com.blankj.utilcode.util.r;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import jt.l;

/* JADX INFO: loaded from: classes2.dex */
public class SimpleAdbUtils {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f11326e = "SimpleAdbUtils";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f11327f = 1129208147;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f11328g = 1314410051;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f11329h = 1313165391;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f11330i = 1497451343;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f11331j = 1163086915;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f11332k = 1163154007;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f11333l = 1213486401;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f11334m = 16777216;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f11335n = 4096;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f11336o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f11337p = 1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f11338q = 2;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f11339r = 2;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f11340s = 3;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f11341t = 24;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f11342u = "QAAAAMX7NM/zNF0rm8UwGpkYyPPtelfR3dKH9+hSR+neEUUzbZLkqg9iQgDQCV7tlbXVYd9be/moIwDi1fGHvHK/bv27AliJVPu6yxTkYee0Z2ro54Q8gP/iffKEme+q1sZFNGXWUJmv0ccyJH/l5+HroCPDH4MTVj4FNPjQqoh5kdzeQXNLKSyNUFZIV+IC+DG4wAbbJfTMTd+jup9cHY89LFxnIOxi+VHyDrBY+JFG95gMZgjvkXa0KFzE+BHfXOI2H7OtN96dVGAWZyeWtC72P/HxBm4jTv44s+R5JzuuLX56KFfAzLe5WAMOuRMg4y/+UsGYfIOtzj0hYIYDLxxbTLVknvTJifbvd84bKTp+QmfaL3ZqXpT3ZXvIFmXlMXeiUv4YEhWYBgyl5P0WFcZpMSxaSGopoNREaRh+B0aR9mKDlfKHUNhGZflFucs4ruo5x57KnpxyH34Z+++lxzWJij7EalhmRZTx3/QOFgks+wqRPtmw5BNM9oBItnQ05t9Pgr8tjhSIkssKgcd/r/Bj8Y6s3mtMKcVpy5xRVbfZCyuUHyLakXn2GO8NKW48IIJ97kQwKJZAgoYztWggKVrgOocb8skmNgvQ2/H2Bnudx48nhM+zQmdlxfACFyYpo7lafS1I6irkrUXZOyRdqBxlc64ONju7FF8jc0uvTtS6M79gRhVjKQEAAQA= unknown@unknown";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f11343v = "00:c9:f4:9e:64:b5:4c:5b:1c:2f:03:86:60:21:3d:ce:ad:83:7c:98:c1:52:fe:2f:e3:20:13:b9:0e:03:58:b9:b7:cc:c0:57:28:7a:7e:2d:ae:3b:27:79:e4:b3:38:fe:4e:23:6e:06:f1:f1:3f:f6:2e:b4:96:27:67:16:60:54:9d:de:37:ad:b3:1f:36:e2:5c:df:11:f8:c4:5c:28:b4:76:91:ef:08:66:0c:98:f7:46:91:f8:58:b0:0e:f2:51:f9:62:ec:20:67:5c:2c:3d:8f:1d:5c:9f:ba:a3:df:4d:cc:f4:25:db:06:c0:b8:31:f8:02:e2:57:48:56:50:8d:2c:29:4b:73:41:de:dc:91:79:88:aa:d0:f8:34:05:3e:56:13:83:1f:c3:23:a0:eb:e1:e7:e5:7f:24:32:c7:d1:af:99:50:d6:65:34:45:c6:d6:aa:ef:99:84:f2:7d:e2:ff:80:3c:84:e7:e8:6a:67:b4:e7:61:e4:14:cb:ba:fb:54:89:58:02:bb:fd:6e:bf:72:bc:87:f1:d5:e2:00:23:a8:f9:7b:5b:df:61:d5:b5:95:ed:5e:09:d0:00:42:62:0f:aa:e4:92:6d:33:45:11:de:e9:47:52:e8:f7:87:d2:dd:d1:57:7a:ed:f3:c8:18:99:1a:30:c5:9b:2b:5d:34:f3";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f11344w = "5d:70:52:80:a1:e9:4c:16:44:22:4b:5f:da:c1:70:08:93:d7:68:0d:ba:4a:64:f9:9e:f3:c1:21:1c:a7:46:76:25:c3:b0:0f:c8:6c:ec:d1:ba:08:cf:ba:e2:b9:31:e0:11:40:6c:f2:2f:fe:b9:f6:6e:13:32:f3:dd:44:80:a1:f2:18:ac:c3:3d:63:f5:63:a6:c9:f7:e1:52:0a:7b:44:88:cc:a1:84:25:bb:f8:5c:ac:58:cd:1f:d8:2a:81:86:f3:1f:f0:f6:21:8d:4e:86:12:bd:b2:21:76:84:70:c8:ad:05:7e:cb:27:0b:92:02:ff:c2:9d:43:98:bb:f8:34:6e:16:2d:f3:05:29:37:82:f4:ce:cc:10:1f:79:45:84:a5:6b:1f:4b:8f:81:96:fc:e8:df:0d:43:0f:c7:7e:d2:2a:71:1d:a0:f5:b4:57:e1:55:9d:a0:34:07:63:06:a0:52:29:3f:7f:e3:67:59:f8:fe:6f:83:11:79:0d:33:59:85:8c:79:78:26:3b:58:c5:f0:4c:3b:74:c8:88:fb:1e:34:88:77:d4:08:71:41:cd:84:1e:33:da:81:f6:63:84:14:b2:88:e2:af:5b:ec:b7:6e:50:14:27:fc:b5:00:68:a5:95:62:7c:8e:e5:96:3d:24:31:e9:e6:ef:57:01:c1";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final byte[] f11345x = {0, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, l.f36949q, rc.a.V, l.f36949q, 9, 6, 5, rc.a.f48411c0, 14, 3, 2, 26, 5, 0, 4, 20};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BigInteger f11346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BigInteger f11347b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f11348c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f11349d;

    public static class AdbException extends IOException {
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f11350a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f11351b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f11352c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f11353d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f11354e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f11355f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public byte[] f11356g;

        public a() {
        }

        public a(int i10, int i11, int i12, byte[] bArr) {
            this.f11350a = i10;
            this.f11351b = i11;
            this.f11352c = i12;
            this.f11356g = bArr;
        }
    }

    public SimpleAdbUtils() {
        this.f11349d = 0;
        this.f11348c = f(f11342u);
        this.f11347b = d(f11343v);
        this.f11346a = d(f11344w);
    }

    public static String c(int i10) {
        switch (i10) {
            case 1129208147:
                return "SYNC";
            case 1163086915:
                return "CLSE";
            case 1163154007:
                return "WRTE";
            case 1213486401:
                return "AUTH";
            case 1313165391:
                return "OPEN";
            case 1314410051:
                return "CNXN";
            case 1497451343:
                return "OKAY";
            default:
                return "XXXX";
        }
    }

    public static BigInteger d(String str) {
        return new BigInteger(str.replaceAll("[ :\n]", ""), 16);
    }

    public static byte[] f(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        return Arrays.copyOf(bytes, bytes.length + 1);
    }

    public static byte[] g(byte[] bArr) {
        return Arrays.copyOf(bArr, bArr.length + 1);
    }

    public static a i(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[24];
        if (inputStream.read(bArr) != 24) {
            throw new AdbException();
        }
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        byteBufferWrap.order(ByteOrder.LITTLE_ENDIAN);
        a aVar = new a();
        aVar.f11350a = byteBufferWrap.getInt();
        aVar.f11351b = byteBufferWrap.getInt();
        aVar.f11352c = byteBufferWrap.getInt();
        aVar.f11353d = byteBufferWrap.getInt();
        aVar.f11354e = byteBufferWrap.getInt();
        aVar.f11355f = byteBufferWrap.getInt();
        int i10 = aVar.f11353d;
        if (i10 > 0) {
            byte[] bArr2 = new byte[i10];
            if (inputStream.read(bArr2) != i10) {
                throw new AdbException();
            }
            aVar.f11356g = bArr2;
        }
        return aVar;
    }

    public static void j(OutputStream outputStream, a aVar) throws IOException {
        if (aVar.f11356g == null) {
            aVar.f11356g = new byte[0];
        }
        int i10 = 0;
        for (byte b10 : aVar.f11356g) {
            i10 += b10 & 255;
        }
        int length = aVar.f11356g.length;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length + 24);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        byteBufferAllocate.putInt(aVar.f11350a);
        byteBufferAllocate.putInt(aVar.f11351b);
        byteBufferAllocate.putInt(aVar.f11352c);
        byteBufferAllocate.putInt(length);
        byteBufferAllocate.putInt(i10);
        byteBufferAllocate.putInt(~aVar.f11350a);
        if (length > 0) {
            byteBufferAllocate.put(aVar.f11356g);
        }
        outputStream.write(byteBufferAllocate.array());
        outputStream.flush();
    }

    public final byte[] a(byte[] bArr) {
        byte[] bArrCopyOf = Arrays.copyOf(f11345x, 256);
        System.arraycopy(bArr, 0, bArrCopyOf, 236, 20);
        byte[] byteArray = new BigInteger(bArrCopyOf).modPow(this.f11346a, this.f11347b).toByteArray();
        if (byteArray.length > bArrCopyOf.length) {
            System.arraycopy(byteArray, byteArray.length - bArrCopyOf.length, bArrCopyOf, 0, bArrCopyOf.length);
        } else {
            System.arraycopy(byteArray, 0, bArrCopyOf, bArrCopyOf.length - byteArray.length, byteArray.length);
        }
        return bArrCopyOf;
    }

    public final String b(OutputStream outputStream, InputStream inputStream, String str) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        j(outputStream, new a(1314410051, 16777216, 4096, f("host::brevent")));
        a aVarI = i(inputStream);
        while (true) {
            int i10 = aVarI.f11350a;
            if (i10 == 1314410051) {
                while (true) {
                    j(outputStream, new a(1313165391, 1, 0, f("shell:")));
                    a aVarI2 = i(inputStream);
                    int i11 = aVarI2.f11350a;
                    if (i11 == 1497451343) {
                        try {
                            h(outputStream, inputStream, byteArrayOutputStream);
                        } catch (AdbException unused) {
                        }
                    } else if (i11 == 1163086915) {
                        j(outputStream, new a(1163086915, 1, aVarI2.f11351b, new byte[0]));
                    }
                    try {
                        Thread.sleep(50L);
                    } catch (InterruptedException e10) {
                        e10.printStackTrace();
                    }
                    j(outputStream, new a(1163154007, 1, aVarI2.f11351b, f(str)));
                    a aVarI3 = i(inputStream);
                    int i12 = aVarI3.f11350a;
                    if (i12 == 1497451343) {
                        try {
                            h(outputStream, inputStream, byteArrayOutputStream);
                            break;
                        } catch (AdbException unused2) {
                        }
                    } else if (i12 == 1163086915) {
                        j(outputStream, new a(1163086915, 1, aVarI3.f11351b, new byte[0]));
                        break;
                    }
                }
                return byteArrayOutputStream.toString("UTF-8");
            }
            if (i10 != 1213486401) {
                return null;
            }
            int i13 = this.f11349d;
            if (i13 == 0) {
                j(outputStream, new a(1213486401, 2, 0, a(aVarI.f11356g)));
                aVarI = i(inputStream);
                this.f11349d = 1;
            } else if (i13 == 1) {
                j(outputStream, new a(1213486401, 3, 0, this.f11348c));
                aVarI = i(inputStream);
                this.f11349d = 2;
            } else if (i13 == 2) {
                return null;
            }
        }
    }

    public String e(int i10, String str) throws Throwable {
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream;
        Socket socket = null;
        try {
            Socket socket2 = new Socket(InetAddress.getLoopbackAddress().getHostName(), i10);
            try {
                bufferedOutputStream = new BufferedOutputStream(socket2.getOutputStream());
                try {
                    bufferedInputStream = new BufferedInputStream(socket2.getInputStream());
                    try {
                        String strB = b(bufferedOutputStream, bufferedInputStream, str);
                        r.a(socket2, bufferedOutputStream, bufferedInputStream);
                        return strB;
                    } catch (Exception e10) {
                        e = e10;
                        socket = socket2;
                        try {
                            e.getMessage();
                            r.a(socket, bufferedOutputStream, bufferedInputStream);
                            return "";
                        } catch (Throwable th2) {
                            th = th2;
                            r.a(socket, bufferedOutputStream, bufferedInputStream);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        socket = socket2;
                        r.a(socket, bufferedOutputStream, bufferedInputStream);
                        throw th;
                    }
                } catch (Exception e11) {
                    e = e11;
                    bufferedInputStream = null;
                } catch (Throwable th4) {
                    th = th4;
                    bufferedInputStream = null;
                }
            } catch (Exception e12) {
                e = e12;
                bufferedOutputStream = null;
                bufferedInputStream = null;
            } catch (Throwable th5) {
                th = th5;
                bufferedOutputStream = null;
                bufferedInputStream = null;
            }
        } catch (Exception e13) {
            e = e13;
            bufferedOutputStream = null;
            bufferedInputStream = null;
        } catch (Throwable th6) {
            th = th6;
            bufferedOutputStream = null;
            bufferedInputStream = null;
        }
    }

    public final void h(OutputStream outputStream, InputStream inputStream, OutputStream outputStream2) throws IOException {
        a aVarI;
        int i10;
        do {
            aVarI = i(inputStream);
            i10 = aVarI.f11350a;
            if (i10 == 1163086915) {
                j(outputStream, new a(1163086915, 1, aVarI.f11351b, new byte[0]));
                return;
            }
        } while (i10 != 1163154007);
        if (aVarI.f11353d > 0) {
            outputStream2.write(aVarI.f11356g);
        }
        j(outputStream, new a(1497451343, 1, aVarI.f11351b, new byte[0]));
    }

    public SimpleAdbUtils(String str, String str2, String str3) {
        this.f11349d = 0;
        this.f11348c = f(str);
        this.f11347b = d(str2);
        this.f11346a = d(str3);
    }

    public SimpleAdbUtils(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this.f11349d = 0;
        this.f11348c = g(Base64.encode(bArr, 2));
        this.f11347b = new BigInteger(1, bArr2);
        this.f11346a = new BigInteger(1, bArr3);
    }
}
