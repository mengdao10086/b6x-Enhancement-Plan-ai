package com.efs.sdk.base.newsharedpreferences;

import android.content.SharedPreferences;
import android.os.FileObserver;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import com.blankj.utilcode.util.i0;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes2.dex */
public final class SharedPreferencesNewImpl implements SharedPreferences {
    private static final String BACKUP_FILE_SUFFIX = ".bak";
    private static final int CONTENT_LENGTH_LOST = 1;
    private static final int CONTENT_OVER_SIZE = 7;
    private static final int DATA_TYPE_ERROR = 8;
    private static final int DATA_TYPE_INVALID = 9;
    private static final long DELAY_TIME_TO_SAVE = 1000;
    private static final byte FINISH_MARK = 18;
    private static final int FINISH_MARK_LENGTH = 1;
    private static final int ID_LENGTH = 4;
    private static final int INIT_EXCEPTION = 10;
    private static final int LOAD_BAK_FILE = 12;
    private static final int MAPPED_BUFFER_ERROR = 4;
    private static final int MAX_HANDLERTHREAD = 3;
    private static final long MAX_LOCK_FILE_TIME = 10000;
    private static final int MAX_NUM = Integer.MAX_VALUE;
    private static final int MAX_TRY_TIME = 6;
    private static final int MIN_INCREASE_LENGTH = 1024;
    private static final int MODIFY_ID_LOST = 2;
    private static final int OTHER_EXCEPTION = 11;
    private static final String TAG = "SharedPreferencesNew";
    private static final long TRY_RELOAD_INTERVAL = 60;
    private static final int TRY_SAVE_TIME_DELAY = 2000;
    private static final int TYPE_CAST_EXCEPTION = 13;
    private static final int VALUE_LOST = 3;
    private static final Object mFileMonitorSyncObj = new Object();
    private static HandlerThread[] mHandlerThreadPool = new HandlerThread[3];
    private static final int mSaveMessageID = 21310;
    private static ExecutorService sCachedThreadPool;
    private String mBackupFilePath;
    private int mCurTryTime;
    private Vector<SharedPreferences.Editor> mEditorList;
    private OnSharedPreferenceErrorListener mErrorListener;
    private File mFile;
    private FileChannel mFileChannel;
    private FileMonitor mFileMonitor;
    private Handler mHandler;
    private boolean mIsSaving;
    private final ArrayList<SharedPreferences.OnSharedPreferenceChangeListener> mListeners;
    private boolean mLoaded;
    private final LinkedHashMap<String, Object> mMap;
    private MappedByteBuffer mMappedByteBuffer;
    private int mModifyErrorCnt;
    private int mModifyID;
    private RunnableEx mSaveRunnable;
    private final Object mSyncObj;
    private final Object mSyncSaveObj;
    private final Runnable mTryReloadRunnable;
    private long mTryReloadStartTime;

    public static class ByteFloatUtils {
        private ByteFloatUtils() {
        }

        public static float bytesToFloat(byte[] bArr) {
            return ByteBuffer.wrap(bArr).getFloat();
        }

        public static byte[] floatToBytes(float f10) {
            return ByteBuffer.allocate(4).putFloat(f10).array();
        }
    }

    public static class ByteIntUtils {
        private ByteIntUtils() {
        }

        public static int bytesToInt(byte[] bArr) {
            return ByteBuffer.wrap(bArr).getInt();
        }

        public static byte[] intToBytes(int i10) {
            return ByteBuffer.allocate(4).putInt(i10).array();
        }
    }

    public static class ByteLongUtils {
        private ByteLongUtils() {
        }

        public static long bytesToLong(byte[] bArr) {
            return ByteBuffer.wrap(bArr).getLong();
        }

        public static byte[] longToBytes(long j10) {
            return ByteBuffer.allocate(8).putLong(j10).array();
        }
    }

    public final class EditorImpl implements SharedPreferences.Editor {
        private boolean mClear;
        private HashMap<String, Object> mModified = new HashMap<>();

        public EditorImpl() {
        }

        @Override // android.content.SharedPreferences.Editor
        public final void apply() {
            SharedPreferencesNewImpl.this.save(this, false, false, true);
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor clear() {
            synchronized (this) {
                this.mClear = true;
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final boolean commit() {
            SharedPreferencesNewImpl.this.save(this, false, true, false);
            return true;
        }

        public final boolean doClear() {
            boolean z10;
            synchronized (this) {
                z10 = this.mClear;
                this.mClear = false;
            }
            return z10;
        }

        public final HashMap<String, Object> getAll() {
            HashMap<String, Object> map;
            synchronized (this) {
                map = this.mModified;
            }
            return map;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putBoolean(String str, boolean z10) {
            synchronized (this) {
                this.mModified.put(str, Boolean.valueOf(z10));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putFloat(String str, float f10) {
            synchronized (this) {
                this.mModified.put(str, Float.valueOf(f10));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putInt(String str, int i10) {
            synchronized (this) {
                this.mModified.put(str, Integer.valueOf(i10));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putLong(String str, long j10) {
            synchronized (this) {
                this.mModified.put(str, Long.valueOf(j10));
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putString(String str, String str2) {
            synchronized (this) {
                this.mModified.put(str, str2);
            }
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            throw new RuntimeException("putStringSet is not supported!");
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor remove(String str) {
            synchronized (this) {
                this.mModified.put(str, null);
            }
            return this;
        }
    }

    public final class FileMonitor extends FileObserver {
        public FileMonitor(String str, int i10) {
            super(str, i10);
        }

        @Override // android.os.FileObserver
        public final void onEvent(int i10, String str) {
            if (SharedPreferencesNewImpl.this.mListeners.size() > 0) {
                SharedPreferencesNewImpl.this.tryReload();
            } else {
                stopWatching();
            }
        }
    }

    public interface OnSharedPreferenceErrorListener {
        void onError(String str, int i10, long j10);
    }

    public static abstract class RunnableEx implements Runnable {
        private Object mArg;

        public Object getArg() {
            return this.mArg;
        }

        public void setArg(Object obj) {
            this.mArg = obj;
        }
    }

    public class SUPPORTED_TYPE {
        public static final byte TYPE_BOOLEAN = 4;
        public static final byte TYPE_FLOAT = 2;
        public static final byte TYPE_INT = 1;
        public static final byte TYPE_LONG = 3;
        public static final byte TYPE_STRING = 5;

        private SUPPORTED_TYPE() {
        }
    }

    static {
        for (int i10 = 0; i10 < 3; i10++) {
            mHandlerThreadPool[i10] = new HandlerThread("newsp".concat(String.valueOf(i10)));
            mHandlerThreadPool[i10].start();
        }
        sCachedThreadPool = Executors.newCachedThreadPool();
    }

    public SharedPreferencesNewImpl(File file) {
        this(file, 0, null, false);
    }

    private MappedByteBuffer allocBuffer(int i10) {
        MappedByteBuffer mappedByteBuffer = this.mMappedByteBuffer;
        int iPosition = mappedByteBuffer != null ? mappedByteBuffer.position() : 0;
        try {
            this.mMappedByteBuffer = this.mFileChannel.map(FileChannel.MapMode.READ_WRITE, 0L, i10);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        MappedByteBuffer mappedByteBuffer2 = this.mMappedByteBuffer;
        if (mappedByteBuffer2 != null) {
            mappedByteBuffer2.position(iPosition);
        }
        return this.mMappedByteBuffer;
    }

    private void awaitLoadedLocked() {
        if (!this.mLoaded) {
            synchronized (this) {
                while (!this.mLoaded) {
                    try {
                        wait();
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
            }
        }
        tryReload();
    }

    private void backup() {
        Throwable th2;
        Closeable closeable;
        FileChannel channel = null;
        try {
            File file = new File(this.mBackupFilePath);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                channel = fileOutputStream.getChannel();
                this.mFileChannel.transferTo(0L, this.mMappedByteBuffer.capacity(), channel);
                safeClose(fileOutputStream);
                safeClose(channel);
            } catch (Throwable th3) {
                closeable = channel;
                channel = fileOutputStream;
                th2 = th3;
                try {
                    th2.printStackTrace();
                } finally {
                    safeClose(channel);
                    safeClose(closeable);
                }
            }
        } catch (Throwable th4) {
            th2 = th4;
            closeable = null;
        }
    }

    private byte getBCCCode(byte[] bArr) {
        byte b10 = 0;
        for (byte b11 : bArr) {
            b10 = (byte) (b10 ^ b11);
        }
        return b10;
    }

    private byte[] getBytes(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            if (obj instanceof String) {
                return ((String) obj).getBytes();
            }
            if (obj instanceof Boolean) {
                int i10 = 1;
                byte[] bArr = new byte[1];
                if (!((Boolean) obj).booleanValue()) {
                    i10 = 0;
                }
                bArr[0] = (byte) i10;
                return bArr;
            }
            if (obj instanceof Float) {
                return ByteFloatUtils.floatToBytes(((Float) obj).floatValue());
            }
            if (obj instanceof Integer) {
                return ByteIntUtils.intToBytes(((Integer) obj).intValue());
            }
            if (obj instanceof Long) {
                return ByteLongUtils.longToBytes(((Long) obj).longValue());
            }
            return null;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    private int getContentLength() {
        if (this.mMappedByteBuffer == null || this.mFileChannel == null) {
            return -1;
        }
        synchronized (this.mSyncObj) {
            this.mMappedByteBuffer.position(0);
            byte[] bArr = new byte[4];
            safeBufferGet(this.mMappedByteBuffer, bArr);
            int iBytesToInt = ByteIntUtils.bytesToInt(bArr);
            this.mMappedByteBuffer.position(4);
            byte b10 = this.mMappedByteBuffer.get();
            if ((b10 == 18 || b10 == getMaskByte(bArr)) && iBytesToInt >= 0) {
                if (iBytesToInt > Integer.MAX_VALUE) {
                    iBytesToInt = Integer.MAX_VALUE;
                }
                return iBytesToInt;
            }
            OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.mErrorListener;
            if (onSharedPreferenceErrorListener != null) {
                File file = this.mFile;
                String absolutePath = file != null ? file.getAbsolutePath() : null;
                File file2 = this.mFile;
                onSharedPreferenceErrorListener.onError(absolutePath, 1, file2 != null ? file2.length() : 0L);
            }
            return -1;
        }
    }

    private Pair<Integer, byte[][]> getDataBytes() {
        byte[][] bArr;
        ArrayList arrayList;
        synchronized (this.mMap) {
            bArr = new byte[this.mMap.size() * 5][];
            arrayList = new ArrayList(this.mMap.entrySet());
            this.mEditorList.clear();
        }
        int i10 = 0;
        int i11 = 0;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            Map.Entry entry = (Map.Entry) arrayList.get(size);
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            if (str != null && str.trim().length() > 0 && value != null) {
                byte[] bytes = str.getBytes();
                byte[] bArrIntToBytes = ByteIntUtils.intToBytes(bytes.length);
                bArr[i11] = bArrIntToBytes;
                bArr[i11 + 1] = bytes;
                int length = i10 + bArrIntToBytes.length + bytes.length;
                byte[] bytes2 = getBytes(value);
                byte[] bArrIntToBytes2 = ByteIntUtils.intToBytes(bytes2.length);
                bArr[i11 + 2] = bArrIntToBytes2;
                bArr[i11 + 3] = bytes2;
                int length2 = length + bArrIntToBytes2.length + bytes2.length;
                bArr[i11 + 4] = new byte[]{(byte) getObjectType(value)};
                i10 = length2 + 1;
                i11 += 5;
            }
        }
        return new Pair<>(Integer.valueOf(i10), bArr);
    }

    private HandlerThread getHandlerThread() {
        int iNextInt = new Random().nextInt();
        if (iNextInt < 0) {
            iNextInt = -iNextInt;
        }
        return mHandlerThreadPool[iNextInt % 3];
    }

    private byte getMaskByte(byte[] bArr) {
        return getBCCCode(bArr);
    }

    private Object getObjectByType(byte[] bArr, int i10) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            if (i10 == 5) {
                return new String(bArr);
            }
            boolean z10 = true;
            if (i10 == 4) {
                if (bArr[0] != 1) {
                    z10 = false;
                }
                return Boolean.valueOf(z10);
            }
            if (i10 == 2) {
                return Float.valueOf(ByteFloatUtils.bytesToFloat(bArr));
            }
            if (i10 == 1) {
                return Integer.valueOf(ByteIntUtils.bytesToInt(bArr));
            }
            if (i10 == 3) {
                return Long.valueOf(ByteLongUtils.bytesToLong(bArr));
            }
            return null;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    private int getObjectType(Object obj) {
        if (obj instanceof String) {
            return 5;
        }
        if (obj instanceof Boolean) {
            return 4;
        }
        if (obj instanceof Float) {
            return 2;
        }
        if (obj instanceof Integer) {
            return 1;
        }
        return obj instanceof Long ? 3 : 0;
    }

    private Pair<byte[], Integer> getOneString(byte[] bArr, int i10) throws Exception {
        int i11;
        byte[] bArr2 = new byte[4];
        System.arraycopy(bArr, i10, bArr2, 0, 4);
        int i12 = i10 + 4;
        if (bArr[i12] != 18 && bArr[i12] != getMaskByte(bArr2)) {
            throw new Exception("length string's finish mark missing");
        }
        int i13 = i12 + 1;
        int iBytesToInt = ByteIntUtils.bytesToInt(bArr2);
        if (iBytesToInt < 0 || (i11 = i13 + iBytesToInt) >= bArr.length || iBytesToInt > Integer.MAX_VALUE) {
            throw new Exception("length string is invalid");
        }
        byte[] bArr3 = null;
        if (iBytesToInt != 0) {
            bArr3 = new byte[iBytesToInt];
            System.arraycopy(bArr, i13, bArr3, 0, iBytesToInt);
            if (bArr[i11] != 18 && bArr[i11] != getMaskByte(bArr3)) {
                throw new Exception("Stored bytes' finish mark missing");
            }
            i13 = i11;
        }
        return new Pair<>(bArr3, Integer.valueOf(i13 + 1));
    }

    private int increaseModifyID() {
        int i10 = (this.mModifyID + 1) % Integer.MAX_VALUE;
        this.mModifyID = i10;
        return i10;
    }

    private boolean initBuffer() {
        boolean zExists = true;
        if (this.mMappedByteBuffer != null) {
            return true;
        }
        try {
            if (!this.mFile.exists()) {
                this.mFile.getParentFile().mkdirs();
                this.mFile.createNewFile();
                zExists = new File(this.mBackupFilePath).exists();
            } else if (this.mFile.length() == 0) {
                OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.mErrorListener;
                if (onSharedPreferenceErrorListener != null) {
                    onSharedPreferenceErrorListener.onError(this.mFile.getAbsolutePath(), 4, this.mFile.length());
                }
                zExists = false;
            }
            this.mFileChannel = new RandomAccessFile(this.mFile, "rw").getChannel();
            allocBuffer(10);
            if (!zExists) {
                initFileHeader();
            }
            return zExists;
        } catch (Exception e10) {
            e10.printStackTrace();
            OnSharedPreferenceErrorListener onSharedPreferenceErrorListener2 = this.mErrorListener;
            if (onSharedPreferenceErrorListener2 == null) {
                return false;
            }
            onSharedPreferenceErrorListener2.onError(this.mFile.getAbsolutePath() + i0.f11861z + e10.getCause(), 10, -1L);
            return false;
        }
    }

    private void initFileHeader() {
        if (this.mMappedByteBuffer != null) {
            byte[] bArr = new byte[10];
            byte[] bArrIntToBytes = ByteIntUtils.intToBytes(0);
            System.arraycopy(bArrIntToBytes, 0, bArr, 0, 4);
            bArr[4] = getMaskByte(bArrIntToBytes);
            byte[] bArrIntToBytes2 = ByteIntUtils.intToBytes(0);
            System.arraycopy(bArrIntToBytes2, 0, bArr, 5, 4);
            bArr[9] = getMaskByte(bArrIntToBytes2);
            this.mMappedByteBuffer.position(0);
            this.mMappedByteBuffer.put(bArr);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:83:0x00ba A[DONT_GENERATE, FINALLY_INSNS] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void load(boolean r9) {
        /*
            r8 = this;
            r0 = 0
            r1 = 1
            if (r9 == 0) goto L6
            r2 = r0
            goto La
        L6:
            java.nio.channels.FileLock r2 = r8.lockFile(r1)
        La:
            if (r2 != 0) goto L15
            if (r9 == 0) goto Lf
            goto L15
        Lf:
            if (r9 != 0) goto L14
            r8.loadFromBakFile()
        L14:
            return
        L15:
            r9 = 0
            r8.reallocBuffer()     // Catch: java.lang.Throwable -> La8
            java.nio.MappedByteBuffer r3 = r8.mMappedByteBuffer     // Catch: java.lang.Throwable -> La8
            if (r3 == 0) goto L8b
            int r3 = r3.capacity()     // Catch: java.lang.Throwable -> La8
            if (r3 != 0) goto L24
            goto L8b
        L24:
            int r3 = r8.getContentLength()     // Catch: java.lang.Throwable -> La8
            long r3 = (long) r3
            r5 = 10
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 > 0) goto L4c
            boolean r9 = r8.parseBytesIntoMap(r0, r1)     // Catch: java.lang.Exception -> L34
            goto L38
        L34:
            r0 = move-exception
            r0.printStackTrace()
        L38:
            if (r9 == 0) goto L3e
            int r9 = r8.mModifyID
            if (r9 >= 0) goto L41
        L3e:
            r8.loadFromBakFile()
        L41:
            if (r2 == 0) goto L4b
            r2.release()     // Catch: java.lang.Exception -> L47
            goto L4b
        L47:
            r9 = move-exception
            r9.printStackTrace()
        L4b:
            return
        L4c:
            int r5 = r8.getModifyID()     // Catch: java.lang.Throwable -> La8
            r8.mModifyID = r5     // Catch: java.lang.Throwable -> La8
            if (r5 <= 0) goto L6c
            java.lang.Object r5 = r8.mSyncObj     // Catch: java.lang.Throwable -> La8
            monitor-enter(r5)     // Catch: java.lang.Throwable -> La8
            java.nio.MappedByteBuffer r6 = r8.mMappedByteBuffer     // Catch: java.lang.Throwable -> L69
            r7 = 10
            r6.position(r7)     // Catch: java.lang.Throwable -> L69
            int r4 = (int) r3     // Catch: java.lang.Throwable -> L69
            int r4 = r4 - r7
            byte[] r0 = new byte[r4]     // Catch: java.lang.Throwable -> L69
            java.nio.MappedByteBuffer r3 = r8.mMappedByteBuffer     // Catch: java.lang.Throwable -> L69
            r8.safeBufferGet(r3, r0)     // Catch: java.lang.Throwable -> L69
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L69
            goto L6c
        L69:
            r3 = move-exception
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L69
            throw r3     // Catch: java.lang.Throwable -> La8
        L6c:
            boolean r9 = r8.parseBytesIntoMap(r0, r1)     // Catch: java.lang.Exception -> L71
            goto L75
        L71:
            r1 = move-exception
            r1.printStackTrace()
        L75:
            if (r9 == 0) goto L7d
            if (r0 != 0) goto L80
            int r9 = r8.mModifyID
            if (r9 >= 0) goto L80
        L7d:
            r8.loadFromBakFile()
        L80:
            if (r2 == 0) goto L8a
            r2.release()     // Catch: java.lang.Exception -> L86
            goto L8a
        L86:
            r9 = move-exception
            r9.printStackTrace()
        L8a:
            return
        L8b:
            boolean r9 = r8.parseBytesIntoMap(r0, r1)     // Catch: java.lang.Exception -> L90
            goto L94
        L90:
            r0 = move-exception
            r0.printStackTrace()
        L94:
            if (r9 == 0) goto L9a
            int r9 = r8.mModifyID
            if (r9 >= 0) goto L9d
        L9a:
            r8.loadFromBakFile()
        L9d:
            if (r2 == 0) goto La7
            r2.release()     // Catch: java.lang.Exception -> La3
            goto La7
        La3:
            r9 = move-exception
            r9.printStackTrace()
        La7:
            return
        La8:
            r3 = move-exception
            boolean r9 = r8.parseBytesIntoMap(r0, r1)     // Catch: java.lang.Exception -> Lae
            goto Lb2
        Lae:
            r1 = move-exception
            r1.printStackTrace()
        Lb2:
            if (r9 == 0) goto Lba
            if (r0 != 0) goto Lbd
            int r9 = r8.mModifyID
            if (r9 >= 0) goto Lbd
        Lba:
            r8.loadFromBakFile()
        Lbd:
            if (r2 == 0) goto Lc7
            r2.release()     // Catch: java.lang.Exception -> Lc3
            goto Lc7
        Lc3:
            r9 = move-exception
            r9.printStackTrace()
        Lc7:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.load(boolean):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v8 */
    private boolean loadFromBakFile() {
        byte[] bArr;
        OnSharedPreferenceErrorListener onSharedPreferenceErrorListener;
        String str;
        long length;
        RandomAccessFile randomAccessFile;
        int iBytesToInt;
        RandomAccessFile randomAccessFile2 = null;
        byte[] bArr2 = null;
        int length2 = 0;
        boolean bytesIntoMap = true;
        try {
            randomAccessFile = new RandomAccessFile(this.mBackupFilePath, SsManifestParser.e.J);
        } catch (Throwable th2) {
            th = th2;
            bArr = null;
        }
        try {
            byte[] bArr3 = new byte[4];
            randomAccessFile.read(bArr3, 0, 4);
            iBytesToInt = ByteIntUtils.bytesToInt(bArr3);
        } catch (Throwable th3) {
            th = th3;
            bArr = bArr2;
            randomAccessFile2 = randomAccessFile;
            try {
                th.printStackTrace();
                safeClose(randomAccessFile2);
                try {
                    bytesIntoMap = parseBytesIntoMap(bArr, false);
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
                onSharedPreferenceErrorListener = this.mErrorListener;
                if (onSharedPreferenceErrorListener != null) {
                    str = this.mBackupFilePath + "#" + th.getCause() + "#" + bytesIntoMap;
                    length = bArr != null ? bArr.length : 0;
                }
                return bytesIntoMap;
            } finally {
            }
        }
        if (iBytesToInt <= 10) {
            safeClose(randomAccessFile);
            try {
                parseBytesIntoMap(null, false);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            return false;
        }
        if (iBytesToInt > Integer.MAX_VALUE) {
            iBytesToInt = Integer.MAX_VALUE;
        }
        if (iBytesToInt > randomAccessFile.length()) {
            iBytesToInt = (int) randomAccessFile.length();
        }
        int i10 = iBytesToInt - 10;
        bArr2 = new byte[i10];
        randomAccessFile.seek(10L);
        randomAccessFile.read(bArr2);
        safeClose(randomAccessFile);
        try {
            bytesIntoMap = parseBytesIntoMap(bArr2, false);
        } catch (Exception e12) {
            e12.printStackTrace();
        }
        onSharedPreferenceErrorListener = this.mErrorListener;
        if (onSharedPreferenceErrorListener != null) {
            str = this.mBackupFilePath + "#" + ((Object) "") + "#" + bytesIntoMap;
            length = i10;
        }
        return bytesIntoMap;
        onSharedPreferenceErrorListener.onError(str, 12, length);
        return bytesIntoMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadFromDiskLocked() {
        if (this.mLoaded) {
            return;
        }
        load(false);
        this.mLoaded = true;
        notifyAll();
    }

    private FileLock lockFile(boolean z10) throws IOException {
        FileChannel fileChannel = this.mFileChannel;
        FileLock fileLockTryLock = null;
        if (fileChannel == null) {
            return null;
        }
        if (!z10) {
            try {
                return fileChannel.tryLock();
            } catch (Exception e10) {
                e10.printStackTrace();
                return null;
            }
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        while (fileLockTryLock == null) {
            try {
                fileLockTryLock = this.mFileChannel.tryLock();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            if (fileLockTryLock == null) {
                try {
                    Thread.sleep(100L);
                } catch (Exception e12) {
                    e12.printStackTrace();
                }
            }
            if (SystemClock.uptimeMillis() - jUptimeMillis > 10000) {
                return fileLockTryLock;
            }
        }
        return fileLockTryLock;
    }

    private boolean merge(SharedPreferences.Editor editor, Map map, boolean z10) {
        if (editor == null) {
            return false;
        }
        EditorImpl editorImpl = (EditorImpl) editor;
        boolean zDoClear = editorImpl.doClear();
        if (zDoClear) {
            map.clear();
            this.mEditorList.clear();
        }
        HashMap<String, Object> all = editorImpl.getAll();
        if (all.size() == 0) {
            return zDoClear;
        }
        synchronized (editor) {
            for (Map.Entry<String, Object> entry : all.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (value == null) {
                    map.remove(key);
                } else {
                    if (map.containsKey(key)) {
                        map.remove(key);
                    }
                    map.put(key, value);
                }
                if (!z10) {
                    notifyDataChanged(key);
                }
            }
        }
        return true;
    }

    private void mergeWhenReload() {
        synchronized (this.mMap) {
            if (this.mEditorList.size() > 0) {
                Iterator<SharedPreferences.Editor> it2 = this.mEditorList.iterator();
                while (it2.hasNext()) {
                    merge(it2.next(), this.mMap, true);
                }
            }
        }
    }

    private void notifyDataChanged(String str) {
        if (this.mListeners.size() > 0) {
            for (int i10 = 0; i10 < this.mListeners.size(); i10++) {
                SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = this.mListeners.get(i10);
                if (onSharedPreferenceChangeListener != null) {
                    onSharedPreferenceChangeListener.onSharedPreferenceChanged(this, str);
                }
            }
        }
    }

    private byte[] obtainTotalBytes() {
        Pair<Integer, byte[][]> dataBytes = getDataBytes();
        int iIntValue = ((Integer) dataBytes.first).intValue() + 10 + (((byte[][]) dataBytes.second).length * 1);
        if (iIntValue > Integer.MAX_VALUE) {
            iIntValue = Integer.MAX_VALUE;
        }
        byte[] bArr = new byte[iIntValue];
        byte[] bArrIntToBytes = ByteIntUtils.intToBytes(iIntValue);
        System.arraycopy(bArrIntToBytes, 0, bArr, 0, bArrIntToBytes.length);
        int length = bArrIntToBytes.length + 0;
        bArr[length] = getMaskByte(bArrIntToBytes);
        int i10 = length + 1;
        byte[] bArrIntToBytes2 = ByteIntUtils.intToBytes(increaseModifyID());
        System.arraycopy(bArrIntToBytes2, 0, bArr, i10, bArrIntToBytes2.length);
        int length2 = i10 + bArrIntToBytes2.length;
        bArr[length2] = getMaskByte(bArrIntToBytes2);
        int i11 = length2 + 1;
        byte[][] bArr2 = (byte[][]) dataBytes.second;
        int length3 = bArr2.length;
        int i12 = 0;
        while (true) {
            if (i12 >= length3) {
                break;
            }
            byte[] bArr3 = bArr2[i12];
            if (bArr3 != null) {
                if (bArr3.length + i11 + 1 <= Integer.MAX_VALUE) {
                    System.arraycopy(bArr3, 0, bArr, i11, bArr3.length);
                    int length4 = i11 + bArr3.length;
                    bArr[length4] = getMaskByte(bArr3);
                    i11 = length4 + 1;
                } else {
                    StringBuilder sb2 = new StringBuilder("Write too much data in ");
                    File file = this.mFile;
                    sb2.append(file != null ? file.getAbsolutePath() : null);
                    OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.mErrorListener;
                    if (onSharedPreferenceErrorListener != null) {
                        File file2 = this.mFile;
                        onSharedPreferenceErrorListener.onError(file2 != null ? file2.getAbsolutePath() : null, 7, -1L);
                    }
                }
            }
            i12++;
        }
        return bArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0059, code lost:
    
        r3 = r12.mErrorListener;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005b, code lost:
    
        if (r3 == null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005d, code lost:
    
        r5 = r12.mFile;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005f, code lost:
    
        if (r5 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0061, code lost:
    
        r5 = r5.getAbsolutePath();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0066, code lost:
    
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0067, code lost:
    
        r3.onError(r5, 8, r13.length);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean parseBytesIntoMap(byte[] r13, boolean r14) {
        /*
            Method dump skipped, instruction units count: 250
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.parseBytesIntoMap(byte[], boolean):boolean");
    }

    private void reallocBuffer() {
        int contentLength;
        if (this.mMappedByteBuffer == null) {
            return;
        }
        synchronized (this.mSyncObj) {
            try {
                contentLength = getContentLength();
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            if (contentLength > this.mMappedByteBuffer.capacity()) {
                allocBuffer(contentLength + 1024);
            }
        }
    }

    private boolean safeBufferGet(MappedByteBuffer mappedByteBuffer, byte[] bArr) {
        if (mappedByteBuffer == null || bArr == null || bArr.length == 0) {
            return false;
        }
        Arrays.fill(bArr, (byte) 0);
        int iPosition = mappedByteBuffer.position();
        if (iPosition + bArr.length > mappedByteBuffer.capacity()) {
            return false;
        }
        mappedByteBuffer.get(bArr);
        return true;
    }

    private void safeBufferPut(MappedByteBuffer mappedByteBuffer, byte[] bArr) {
        if (mappedByteBuffer == null || bArr == null || bArr.length == 0) {
            return;
        }
        if (mappedByteBuffer.position() + bArr.length >= mappedByteBuffer.capacity()) {
            mappedByteBuffer = allocBuffer(mappedByteBuffer.position() + bArr.length + 1024);
        }
        mappedByteBuffer.put(bArr);
    }

    private void safeClose(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e10) {
                e10.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void save(SharedPreferences.Editor editor, boolean z10, boolean z11, boolean z12) {
        if (editor == null) {
            return;
        }
        synchronized (this.mMap) {
            boolean z13 = false;
            this.mCurTryTime = 0;
            if (merge(editor, this.mMap, false)) {
                z13 = true;
            } else if (this.mEditorList.size() == 0) {
                return;
            }
            if (z13) {
                this.mEditorList.add(editor);
            }
            if (z11) {
                saveInner(z10);
                return;
            }
            long j10 = z12 ? 1000L : 0L;
            this.mSaveRunnable.setArg(Boolean.valueOf(z10));
            Message messageObtain = Message.obtain(this.mHandler, this.mSaveRunnable);
            messageObtain.what = mSaveMessageID;
            this.mHandler.sendMessageDelayed(messageObtain, j10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveInner(final boolean z10) {
        synchronized (this.mSyncSaveObj) {
            FileLock fileLockLockFile = lockFile(false);
            if (fileLockLockFile != null) {
                try {
                    this.mIsSaving = true;
                    if (tryReloadWhenSave()) {
                        mergeWhenReload();
                        notifyDataChanged(null);
                    }
                } catch (Throwable th2) {
                    try {
                        th2.printStackTrace();
                        OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.mErrorListener;
                        if (onSharedPreferenceErrorListener != null) {
                            onSharedPreferenceErrorListener.onError(th2.getMessage(), 11, -1L);
                            try {
                                fileLockLockFile.release();
                            } catch (IOException e10) {
                                e10.printStackTrace();
                            }
                        } else {
                            fileLockLockFile.release();
                        }
                    } finally {
                        try {
                            fileLockLockFile.release();
                        } catch (IOException e11) {
                            e11.printStackTrace();
                        }
                        this.mIsSaving = false;
                    }
                }
                synchronized (this.mMap) {
                    if (this.mEditorList.size() <= 0) {
                        return;
                    }
                    saveToMappedBuffer(obtainTotalBytes(), z10);
                    backup();
                    try {
                        fileLockLockFile.release();
                    } catch (IOException e12) {
                        e12.printStackTrace();
                    }
                    this.mIsSaving = false;
                }
            }
            int i10 = this.mCurTryTime;
            this.mCurTryTime = i10 + 1;
            if (i10 < 6) {
                this.mHandler.postDelayed(new Runnable() { // from class: com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.3
                    @Override // java.lang.Runnable
                    public void run() {
                        SharedPreferencesNewImpl.this.saveInner(z10);
                    }
                }, 2000L);
            }
        }
    }

    private void saveToMappedBuffer(byte[] bArr, boolean z10) {
        synchronized (this.mSyncObj) {
            this.mMappedByteBuffer.position(0);
            safeBufferPut(this.mMappedByteBuffer, bArr);
            if (z10) {
                this.mMappedByteBuffer.force();
            }
        }
    }

    private void startLoadFromDisk(boolean z10) {
        synchronized (this) {
            this.mLoaded = false;
        }
        Runnable runnable = new Runnable() { // from class: com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (SharedPreferencesNewImpl.this) {
                    SharedPreferencesNewImpl.this.loadFromDiskLocked();
                }
            }
        };
        if (z10) {
            runnable.run();
        } else {
            sCachedThreadPool.execute(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryReload() {
        if (SystemClock.uptimeMillis() - this.mTryReloadStartTime > 60) {
            this.mTryReloadStartTime = SystemClock.uptimeMillis();
            this.mHandler.removeCallbacks(this.mTryReloadRunnable);
            this.mHandler.post(this.mTryReloadRunnable);
        }
    }

    private boolean tryReloadWhenSave() {
        int modifyID = getModifyID();
        if (modifyID <= 0 || modifyID == this.mModifyID) {
            return false;
        }
        load(true);
        return true;
    }

    public final boolean checkTypeValid(byte b10) {
        return b10 == 4 || b10 == 2 || b10 == 1 || b10 == 3 || b10 == 5;
    }

    @Override // android.content.SharedPreferences
    public final boolean contains(String str) {
        boolean zContainsKey;
        awaitLoadedLocked();
        synchronized (this.mMap) {
            zContainsKey = this.mMap.containsKey(str);
        }
        return zContainsKey;
    }

    @Override // android.content.SharedPreferences
    public final SharedPreferences.Editor edit() {
        awaitLoadedLocked();
        return new EditorImpl();
    }

    @Override // android.content.SharedPreferences
    public final Map<String, ?> getAll() {
        HashMap map;
        awaitLoadedLocked();
        synchronized (this.mMap) {
            map = new HashMap(this.mMap);
        }
        return map;
    }

    @Override // android.content.SharedPreferences
    public final boolean getBoolean(String str, boolean z10) {
        awaitLoadedLocked();
        synchronized (this.mMap) {
            try {
                try {
                    Boolean bool = (Boolean) this.mMap.get(str);
                    if (bool != null) {
                        z10 = bool.booleanValue();
                    }
                } catch (ClassCastException e10) {
                    OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.mErrorListener;
                    if (onSharedPreferenceErrorListener != null) {
                        StringBuilder sb2 = new StringBuilder();
                        File file = this.mFile;
                        sb2.append(file != null ? file.getAbsolutePath() : null);
                        sb2.append("#");
                        sb2.append(str);
                        sb2.append(e10);
                        String string = sb2.toString();
                        File file2 = this.mFile;
                        onSharedPreferenceErrorListener.onError(string, 13, file2 != null ? file2.length() : 0L);
                    }
                    return z10;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return z10;
    }

    @Override // android.content.SharedPreferences
    public final float getFloat(String str, float f10) {
        awaitLoadedLocked();
        synchronized (this.mMap) {
            try {
                try {
                    Float f11 = (Float) this.mMap.get(str);
                    if (f11 != null) {
                        f10 = f11.floatValue();
                    }
                } catch (ClassCastException e10) {
                    OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.mErrorListener;
                    if (onSharedPreferenceErrorListener != null) {
                        StringBuilder sb2 = new StringBuilder();
                        File file = this.mFile;
                        sb2.append(file != null ? file.getAbsolutePath() : null);
                        sb2.append("#");
                        sb2.append(str);
                        sb2.append(e10);
                        String string = sb2.toString();
                        File file2 = this.mFile;
                        onSharedPreferenceErrorListener.onError(string, 13, file2 != null ? file2.length() : 0L);
                    }
                    return f10;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return f10;
    }

    @Override // android.content.SharedPreferences
    public final int getInt(String str, int i10) {
        awaitLoadedLocked();
        synchronized (this.mMap) {
            try {
                try {
                    Integer num = (Integer) this.mMap.get(str);
                    if (num != null) {
                        i10 = num.intValue();
                    }
                } catch (ClassCastException e10) {
                    OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.mErrorListener;
                    if (onSharedPreferenceErrorListener != null) {
                        StringBuilder sb2 = new StringBuilder();
                        File file = this.mFile;
                        sb2.append(file != null ? file.getAbsolutePath() : null);
                        sb2.append("#");
                        sb2.append(str);
                        sb2.append(e10);
                        String string = sb2.toString();
                        File file2 = this.mFile;
                        onSharedPreferenceErrorListener.onError(string, 13, file2 != null ? file2.length() : 0L);
                    }
                    return i10;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return i10;
    }

    @Override // android.content.SharedPreferences
    public final long getLong(String str, long j10) {
        awaitLoadedLocked();
        synchronized (this.mMap) {
            try {
                try {
                    Long l10 = (Long) this.mMap.get(str);
                    if (l10 != null) {
                        j10 = l10.longValue();
                    }
                } catch (ClassCastException e10) {
                    OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.mErrorListener;
                    if (onSharedPreferenceErrorListener != null) {
                        StringBuilder sb2 = new StringBuilder();
                        File file = this.mFile;
                        sb2.append(file != null ? file.getAbsolutePath() : null);
                        sb2.append("#");
                        sb2.append(str);
                        sb2.append(e10);
                        String string = sb2.toString();
                        File file2 = this.mFile;
                        onSharedPreferenceErrorListener.onError(string, 13, file2 != null ? file2.length() : 0L);
                    }
                    return j10;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return j10;
    }

    public final int getModifyID() {
        OnSharedPreferenceErrorListener onSharedPreferenceErrorListener;
        if (this.mMappedByteBuffer == null) {
            return -1;
        }
        synchronized (this.mSyncObj) {
            this.mMappedByteBuffer.position(5);
            byte[] bArr = new byte[4];
            safeBufferGet(this.mMappedByteBuffer, bArr);
            int iBytesToInt = ByteIntUtils.bytesToInt(bArr);
            this.mMappedByteBuffer.position(9);
            byte b10 = this.mMappedByteBuffer.get();
            if ((b10 == 18 || b10 == getMaskByte(bArr)) && iBytesToInt >= 0) {
                return iBytesToInt;
            }
            int i10 = this.mModifyErrorCnt + 1;
            this.mModifyErrorCnt = i10;
            if (i10 < 3 && (onSharedPreferenceErrorListener = this.mErrorListener) != null) {
                File file = this.mFile;
                String absolutePath = file != null ? file.getAbsolutePath() : null;
                File file2 = this.mFile;
                onSharedPreferenceErrorListener.onError(absolutePath, 2, file2 != null ? file2.length() : 0L);
            }
            return -1;
        }
    }

    @Override // android.content.SharedPreferences
    public final String getString(String str, String str2) {
        awaitLoadedLocked();
        synchronized (this.mMap) {
            try {
                try {
                    String str3 = (String) this.mMap.get(str);
                    if (str3 != null) {
                        str2 = str3;
                    }
                } catch (ClassCastException e10) {
                    OnSharedPreferenceErrorListener onSharedPreferenceErrorListener = this.mErrorListener;
                    if (onSharedPreferenceErrorListener != null) {
                        StringBuilder sb2 = new StringBuilder();
                        File file = this.mFile;
                        sb2.append(file != null ? file.getAbsolutePath() : null);
                        sb2.append("#");
                        sb2.append(str);
                        sb2.append(e10);
                        String string = sb2.toString();
                        File file2 = this.mFile;
                        onSharedPreferenceErrorListener.onError(string, 13, file2 != null ? file2.length() : 0L);
                    }
                    return str2;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return str2;
    }

    @Override // android.content.SharedPreferences
    public final Set<String> getStringSet(String str, Set<String> set) {
        throw new RuntimeException("putStringSet is not supported!");
    }

    public final void onDestroy() {
        if (this.mIsSaving || this.mHandler.hasMessages(mSaveMessageID)) {
            saveInner(false);
        }
    }

    @Override // android.content.SharedPreferences
    public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        if (onSharedPreferenceChangeListener != null) {
            synchronized (this.mListeners) {
                this.mListeners.add(onSharedPreferenceChangeListener);
                if (this.mFileMonitor == null) {
                    try {
                        File file = new File(this.mBackupFilePath);
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                    this.mFileMonitor = new FileMonitor(this.mBackupFilePath, 2);
                }
            }
            synchronized (mFileMonitorSyncObj) {
                this.mFileMonitor.startWatching();
            }
        }
    }

    public final void setSharedPreferenceErrorListener(OnSharedPreferenceErrorListener onSharedPreferenceErrorListener) {
        this.mErrorListener = onSharedPreferenceErrorListener;
    }

    @Override // android.content.SharedPreferences
    public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        if (onSharedPreferenceChangeListener != null) {
            synchronized (this.mListeners) {
                this.mListeners.remove(onSharedPreferenceChangeListener);
                if (this.mFileMonitor != null && this.mListeners.size() <= 0) {
                    this.mFileMonitor.stopWatching();
                }
            }
        }
    }

    public SharedPreferencesNewImpl(File file, boolean z10) {
        this(file, 0, null, z10);
    }

    public SharedPreferencesNewImpl(File file, OnSharedPreferenceErrorListener onSharedPreferenceErrorListener) {
        this(file, 0, onSharedPreferenceErrorListener, false);
    }

    public SharedPreferencesNewImpl(File file, int i10, OnSharedPreferenceErrorListener onSharedPreferenceErrorListener) {
        this(file, i10, onSharedPreferenceErrorListener, false);
    }

    public SharedPreferencesNewImpl(File file, int i10, OnSharedPreferenceErrorListener onSharedPreferenceErrorListener, boolean z10) {
        this.mMap = new LinkedHashMap<>();
        this.mListeners = new ArrayList<>();
        this.mLoaded = true;
        this.mSyncObj = new Object();
        this.mSyncSaveObj = new Object();
        this.mEditorList = new Vector<>();
        this.mIsSaving = false;
        this.mTryReloadRunnable = new Runnable() { // from class: com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.2
            @Override // java.lang.Runnable
            public void run() {
                int modifyID = SharedPreferencesNewImpl.this.getModifyID();
                if (modifyID <= 0 || modifyID == SharedPreferencesNewImpl.this.mModifyID) {
                    return;
                }
                SharedPreferencesNewImpl.this.saveInner(false);
            }
        };
        this.mSaveRunnable = new RunnableEx() { // from class: com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.4
            @Override // java.lang.Runnable
            public void run() {
                SharedPreferencesNewImpl.this.saveInner(((Boolean) getArg()).booleanValue());
            }
        };
        this.mErrorListener = onSharedPreferenceErrorListener;
        this.mHandler = new Handler(getHandlerThread().getLooper());
        this.mFile = file;
        this.mBackupFilePath = file.getAbsolutePath() + BACKUP_FILE_SUFFIX;
        if (initBuffer()) {
            startLoadFromDisk(z10);
        }
        this.mHandler.post(new Runnable() { // from class: com.efs.sdk.base.newsharedpreferences.SharedPreferencesNewImpl.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    File file2 = new File(SharedPreferencesNewImpl.this.mBackupFilePath);
                    if (file2.exists()) {
                        return;
                    }
                    file2.createNewFile();
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
        });
    }
}
