package u2;

import android.os.Build;
import androidx.room.h3;
import androidx.work.BackoffPolicy;
import androidx.work.NetworkType;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import androidx.work.c;
import g.n0;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class x {

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f51901a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f51902b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f51903c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ int[] f51904d;

        static {
            int[] iArr = new int[OutOfQuotaPolicy.values().length];
            f51904d = iArr;
            try {
                iArr[OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f51904d[OutOfQuotaPolicy.DROP_WORK_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[NetworkType.values().length];
            f51903c = iArr2;
            try {
                iArr2[NetworkType.NOT_REQUIRED.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f51903c[NetworkType.CONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f51903c[NetworkType.UNMETERED.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f51903c[NetworkType.NOT_ROAMING.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f51903c[NetworkType.METERED.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[BackoffPolicy.values().length];
            f51902b = iArr3;
            try {
                iArr3[BackoffPolicy.EXPONENTIAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f51902b[BackoffPolicy.LINEAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            int[] iArr4 = new int[WorkInfo.State.values().length];
            f51901a = iArr4;
            try {
                iArr4[WorkInfo.State.ENQUEUED.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f51901a[WorkInfo.State.RUNNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f51901a[WorkInfo.State.SUCCEEDED.ordinal()] = 3;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f51901a[WorkInfo.State.FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f51901a[WorkInfo.State.BLOCKED.ordinal()] = 5;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f51901a[WorkInfo.State.CANCELLED.ordinal()] = 6;
            } catch (NoSuchFieldError unused15) {
            }
        }
    }

    public interface b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f51905a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f51906b = 1;
    }

    public interface c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f51907a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f51908b = 1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f51909c = 2;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f51910d = 3;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f51911e = 4;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f51912f = 5;
    }

    public interface d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f51913a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f51914b = 1;
    }

    public interface e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f51915a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f51916b = 1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f51917c = 2;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f51918d = 3;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f51919e = 4;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f51920f = 5;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final String f51921g = "(2, 3, 5)";
    }

    @h3
    public static int a(BackoffPolicy backoffPolicy) {
        int i10 = a.f51902b[backoffPolicy.ordinal()];
        if (i10 == 1) {
            return 0;
        }
        if (i10 == 2) {
            return 1;
        }
        throw new IllegalArgumentException("Could not convert " + backoffPolicy + " to int");
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x005a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @androidx.room.h3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.work.c b(byte[] r6) throws java.lang.Throwable {
        /*
            androidx.work.c r0 = new androidx.work.c
            r0.<init>()
            if (r6 != 0) goto L8
            return r0
        L8:
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream
            r1.<init>(r6)
            r6 = 0
            java.io.ObjectInputStream r2 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3d
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3d
            int r6 = r2.readInt()     // Catch: java.io.IOException -> L37 java.lang.Throwable -> L57
        L17:
            if (r6 <= 0) goto L2b
            java.lang.String r3 = r2.readUTF()     // Catch: java.io.IOException -> L37 java.lang.Throwable -> L57
            android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch: java.io.IOException -> L37 java.lang.Throwable -> L57
            boolean r4 = r2.readBoolean()     // Catch: java.io.IOException -> L37 java.lang.Throwable -> L57
            r0.a(r3, r4)     // Catch: java.io.IOException -> L37 java.lang.Throwable -> L57
            int r6 = r6 + (-1)
            goto L17
        L2b:
            r2.close()     // Catch: java.io.IOException -> L2f
            goto L33
        L2f:
            r6 = move-exception
            r6.printStackTrace()
        L33:
            r1.close()     // Catch: java.io.IOException -> L52
            goto L56
        L37:
            r6 = move-exception
            goto L41
        L39:
            r0 = move-exception
            r2 = r6
            r6 = r0
            goto L58
        L3d:
            r2 = move-exception
            r5 = r2
            r2 = r6
            r6 = r5
        L41:
            r6.printStackTrace()     // Catch: java.lang.Throwable -> L57
            if (r2 == 0) goto L4e
            r2.close()     // Catch: java.io.IOException -> L4a
            goto L4e
        L4a:
            r6 = move-exception
            r6.printStackTrace()
        L4e:
            r1.close()     // Catch: java.io.IOException -> L52
            goto L56
        L52:
            r6 = move-exception
            r6.printStackTrace()
        L56:
            return r0
        L57:
            r6 = move-exception
        L58:
            if (r2 == 0) goto L62
            r2.close()     // Catch: java.io.IOException -> L5e
            goto L62
        L5e:
            r0 = move-exception
            r0.printStackTrace()
        L62:
            r1.close()     // Catch: java.io.IOException -> L66
            goto L6a
        L66:
            r0 = move-exception
            r0.printStackTrace()
        L6a:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: u2.x.b(byte[]):androidx.work.c");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.ObjectOutputStream] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0067 -> B:35:0x006a). Please report as a decompilation issue!!! */
    @h3
    public static byte[] c(androidx.work.c cVar) throws Throwable {
        ObjectOutputStream objectOutputStream;
        boolean zHasNext;
        ?? r12 = 0;
        ObjectOutputStream objectOutputStream2 = null;
        r12 = 0;
        if (cVar.c() == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                try {
                    objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e10) {
                e = e10;
            }
            try {
                objectOutputStream.writeInt(cVar.c());
                Iterator<c.a> it2 = cVar.b().iterator();
                while (true) {
                    zHasNext = it2.hasNext();
                    if (zHasNext) {
                        c.a next = it2.next();
                        objectOutputStream.writeUTF(next.a().toString());
                        objectOutputStream.writeBoolean(next.b());
                    } else {
                        try {
                            break;
                        } catch (IOException e11) {
                            e11.printStackTrace();
                        }
                    }
                }
                objectOutputStream.close();
                byteArrayOutputStream.close();
                r12 = zHasNext;
            } catch (IOException e12) {
                e = e12;
                objectOutputStream2 = objectOutputStream;
                e.printStackTrace();
                if (objectOutputStream2 != null) {
                    try {
                        objectOutputStream2.close();
                    } catch (IOException e13) {
                        e13.printStackTrace();
                    }
                }
                byteArrayOutputStream.close();
                r12 = objectOutputStream2;
            } catch (Throwable th3) {
                th = th3;
                r12 = objectOutputStream;
                if (r12 != 0) {
                    try {
                        r12.close();
                    } catch (IOException e14) {
                        e14.printStackTrace();
                    }
                }
                try {
                    byteArrayOutputStream.close();
                    throw th;
                } catch (IOException e15) {
                    e15.printStackTrace();
                    throw th;
                }
            }
        } catch (IOException e16) {
            e16.printStackTrace();
            r12 = r12;
        }
        return byteArrayOutputStream.toByteArray();
    }

    @h3
    public static BackoffPolicy d(int value) {
        if (value == 0) {
            return BackoffPolicy.EXPONENTIAL;
        }
        if (value == 1) {
            return BackoffPolicy.LINEAR;
        }
        throw new IllegalArgumentException("Could not convert " + value + " to BackoffPolicy");
    }

    @h3
    public static NetworkType e(int value) {
        if (value == 0) {
            return NetworkType.NOT_REQUIRED;
        }
        if (value == 1) {
            return NetworkType.CONNECTED;
        }
        if (value == 2) {
            return NetworkType.UNMETERED;
        }
        if (value == 3) {
            return NetworkType.NOT_ROAMING;
        }
        if (value == 4) {
            return NetworkType.METERED;
        }
        if (Build.VERSION.SDK_INT >= 30 && value == 5) {
            return NetworkType.TEMPORARILY_UNMETERED;
        }
        throw new IllegalArgumentException("Could not convert " + value + " to NetworkType");
    }

    @h3
    @n0
    public static OutOfQuotaPolicy f(int value) {
        if (value == 0) {
            return OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
        }
        if (value == 1) {
            return OutOfQuotaPolicy.DROP_WORK_REQUEST;
        }
        throw new IllegalArgumentException("Could not convert " + value + " to OutOfQuotaPolicy");
    }

    @h3
    public static WorkInfo.State g(int value) {
        if (value == 0) {
            return WorkInfo.State.ENQUEUED;
        }
        if (value == 1) {
            return WorkInfo.State.RUNNING;
        }
        if (value == 2) {
            return WorkInfo.State.SUCCEEDED;
        }
        if (value == 3) {
            return WorkInfo.State.FAILED;
        }
        if (value == 4) {
            return WorkInfo.State.BLOCKED;
        }
        if (value == 5) {
            return WorkInfo.State.CANCELLED;
        }
        throw new IllegalArgumentException("Could not convert " + value + " to State");
    }

    @h3
    public static int h(NetworkType networkType) {
        int i10 = a.f51903c[networkType.ordinal()];
        if (i10 == 1) {
            return 0;
        }
        if (i10 == 2) {
            return 1;
        }
        if (i10 == 3) {
            return 2;
        }
        if (i10 == 4) {
            return 3;
        }
        if (i10 == 5) {
            return 4;
        }
        if (Build.VERSION.SDK_INT >= 30 && networkType == NetworkType.TEMPORARILY_UNMETERED) {
            return 5;
        }
        throw new IllegalArgumentException("Could not convert " + networkType + " to int");
    }

    @h3
    public static int i(@n0 OutOfQuotaPolicy policy) {
        int i10 = a.f51904d[policy.ordinal()];
        if (i10 == 1) {
            return 0;
        }
        if (i10 == 2) {
            return 1;
        }
        throw new IllegalArgumentException("Could not convert " + policy + " to int");
    }

    @h3
    public static int j(WorkInfo.State state) {
        switch (a.f51901a[state.ordinal()]) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 4;
            case 6:
                return 5;
            default:
                throw new IllegalArgumentException("Could not convert " + state + " to int");
        }
    }
}
