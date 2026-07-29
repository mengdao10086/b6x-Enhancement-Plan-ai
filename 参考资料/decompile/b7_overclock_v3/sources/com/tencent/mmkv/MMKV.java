package com.tencent.mmkv;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import g.p0;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public class MMKV implements SharedPreferences, SharedPreferences.Editor {
    private static final int ASHMEM_MODE = 8;
    private static final int BACKUP_MODE = 16;
    private static final int CONTEXT_MODE_MULTI_PROCESS = 4;
    public static final int MULTI_PROCESS_MODE = 2;
    public static final int SINGLE_PROCESS_MODE = 1;
    private static final Set<Long> checkedHandleSet;
    private static MMKVHandler gCallbackHandler;
    private static MMKVContentChangeNotification gContentChangeNotify;
    private static boolean gWantLogReDirecting;
    private static final MMKVLogLevel[] index2LogLevel;
    private static boolean isProcessModeCheckerEnabled;
    private static final EnumMap<MMKVLogLevel, Integer> logLevel2Index;
    private static final HashMap<String, Parcelable.Creator<?>> mCreators;
    private static final EnumMap<MMKVRecoverStrategic, Integer> recoverIndex;
    private static String rootDir;
    private final long nativeHandle;

    /* JADX INFO: renamed from: com.tencent.mmkv.MMKV$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$tencent$mmkv$MMKVLogLevel;

        static {
            int[] iArr = new int[MMKVLogLevel.values().length];
            $SwitchMap$com$tencent$mmkv$MMKVLogLevel = iArr;
            try {
                iArr[MMKVLogLevel.LevelDebug.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$mmkv$MMKVLogLevel[MMKVLogLevel.LevelWarning.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tencent$mmkv$MMKVLogLevel[MMKVLogLevel.LevelError.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$tencent$mmkv$MMKVLogLevel[MMKVLogLevel.LevelNone.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$tencent$mmkv$MMKVLogLevel[MMKVLogLevel.LevelInfo.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public interface LibLoader {
        void loadLibrary(String libName);
    }

    static {
        EnumMap<MMKVRecoverStrategic, Integer> enumMap = new EnumMap<>(MMKVRecoverStrategic.class);
        recoverIndex = enumMap;
        enumMap.put(MMKVRecoverStrategic.OnErrorDiscard, 0);
        enumMap.put(MMKVRecoverStrategic.OnErrorRecover, 1);
        EnumMap<MMKVLogLevel, Integer> enumMap2 = new EnumMap<>(MMKVLogLevel.class);
        logLevel2Index = enumMap2;
        MMKVLogLevel mMKVLogLevel = MMKVLogLevel.LevelDebug;
        enumMap2.put(mMKVLogLevel, 0);
        MMKVLogLevel mMKVLogLevel2 = MMKVLogLevel.LevelInfo;
        enumMap2.put(mMKVLogLevel2, 1);
        MMKVLogLevel mMKVLogLevel3 = MMKVLogLevel.LevelWarning;
        enumMap2.put(mMKVLogLevel3, 2);
        MMKVLogLevel mMKVLogLevel4 = MMKVLogLevel.LevelError;
        enumMap2.put(mMKVLogLevel4, 3);
        MMKVLogLevel mMKVLogLevel5 = MMKVLogLevel.LevelNone;
        enumMap2.put(mMKVLogLevel5, 4);
        index2LogLevel = new MMKVLogLevel[]{mMKVLogLevel, mMKVLogLevel2, mMKVLogLevel3, mMKVLogLevel4, mMKVLogLevel5};
        checkedHandleSet = new HashSet();
        rootDir = null;
        isProcessModeCheckerEnabled = true;
        mCreators = new HashMap<>();
        gWantLogReDirecting = false;
    }

    private MMKV(long handle) {
        this.nativeHandle = handle;
    }

    private native long actualSize(long handle);

    public static MMKV backedUpMMKVWithID(String mmapID, int mode, @p0 String cryptKey, String rootPath) throws RuntimeException {
        if (rootDir == null) {
            throw new IllegalStateException("You should Call MMKV.initialize() first.");
        }
        int i10 = mode | 16;
        return checkProcessMode(getMMKVWithID(mmapID, i10, cryptKey, rootPath), mmapID, i10);
    }

    public static native long backupAllToDirectory(String dstDir);

    public static native boolean backupOneToDirectory(String mmapID, String dstDir, @p0 String rootPath);

    private static MMKV checkProcessMode(long handle, String mmapID, int mode) throws RuntimeException {
        String str;
        if (handle == 0) {
            throw new RuntimeException("Fail to create an MMKV instance [" + mmapID + "] in JNI");
        }
        if (!isProcessModeCheckerEnabled) {
            return new MMKV(handle);
        }
        Set<Long> set = checkedHandleSet;
        synchronized (set) {
            if (!set.contains(Long.valueOf(handle))) {
                if (!checkProcessMode(handle)) {
                    if (mode == 1) {
                        str = "Opening a multi-process MMKV instance [" + mmapID + "] with SINGLE_PROCESS_MODE!";
                    } else {
                        str = ("Opening an MMKV instance [" + mmapID + "] with MULTI_PROCESS_MODE, ") + "while it's already been opened with SINGLE_PROCESS_MODE by someone somewhere else!";
                    }
                    throw new IllegalArgumentException(str);
                }
                set.add(Long.valueOf(handle));
            }
        }
        return new MMKV(handle);
    }

    private static native boolean checkProcessMode(long handle);

    private native boolean containsKey(long handle, String key);

    private native long count(long handle);

    private static native long createNB(int size);

    @p0
    public static NativeBuffer createNativeBuffer(int size) {
        long jCreateNB = createNB(size);
        if (jCreateNB <= 0) {
            return null;
        }
        return new NativeBuffer(jCreateNB, size);
    }

    private native boolean decodeBool(long handle, String key, boolean defaultValue);

    @p0
    private native byte[] decodeBytes(long handle, String key);

    private native double decodeDouble(long handle, String key, double defaultValue);

    private native float decodeFloat(long handle, String key, float defaultValue);

    private native int decodeInt(long handle, String key, int defaultValue);

    private native long decodeLong(long handle, String key, long defaultValue);

    @p0
    private native String decodeString(long handle, String key, @p0 String defaultValue);

    @p0
    private native String[] decodeStringSet(long handle, String key);

    public static MMKV defaultMMKV() throws RuntimeException {
        if (rootDir != null) {
            return checkProcessMode(getDefaultMMKV(1, null), "DefaultMMKV", 1);
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    private static native void destroyNB(long pointer, int size);

    public static void destroyNativeBuffer(NativeBuffer buffer) {
        destroyNB(buffer.pointer, buffer.size);
    }

    public static void disableProcessModeChecker() {
        synchronized (checkedHandleSet) {
            isProcessModeCheckerEnabled = false;
        }
    }

    private static String doInitialize(String rootDir2, String cacheDir, LibLoader loader, MMKVLogLevel logLevel) {
        if (loader != null) {
            loader.loadLibrary("mmkv");
        } else {
            System.loadLibrary("mmkv");
        }
        jniInitialize(rootDir2, cacheDir, logLevel2Int(logLevel));
        rootDir = rootDir2;
        return rootDir2;
    }

    public static void enableProcessModeChecker() {
        synchronized (checkedHandleSet) {
            isProcessModeCheckerEnabled = true;
        }
    }

    private native boolean encodeBool(long handle, String key, boolean value);

    private native boolean encodeBytes(long handle, String key, @p0 byte[] value);

    private native boolean encodeDouble(long handle, String key, double value);

    private native boolean encodeFloat(long handle, String key, float value);

    private native boolean encodeInt(long handle, String key, int value);

    private native boolean encodeLong(long handle, String key, long value);

    private native boolean encodeSet(long handle, String key, @p0 String[] value);

    private native boolean encodeString(long handle, String key, @p0 String value);

    private static native long getDefaultMMKV(int mode, @p0 String cryptKey);

    private static native long getMMKVWithAshmemFD(String mmapID, int fd2, int metaFD, @p0 String cryptKey);

    private static native long getMMKVWithID(String mmapID, int mode, @p0 String cryptKey, @p0 String rootPath);

    private static native long getMMKVWithIDAndSize(String mmapID, int size, int mode, @p0 String cryptKey);

    public static String getRootDir() {
        return rootDir;
    }

    public static String initialize(Context context) {
        return initialize(context, context.getFilesDir().getAbsolutePath() + "/mmkv", null, MMKVLogLevel.LevelInfo);
    }

    public static boolean isFileValid(String mmapID) {
        return isFileValid(mmapID, null);
    }

    public static native boolean isFileValid(String mmapID, @p0 String rootPath);

    private static native void jniInitialize(String rootDir2, String cacheDir, int level);

    private static int logLevel2Int(MMKVLogLevel level) {
        int i10 = AnonymousClass1.$SwitchMap$com$tencent$mmkv$MMKVLogLevel[level.ordinal()];
        if (i10 == 1) {
            return 0;
        }
        if (i10 == 2) {
            return 2;
        }
        if (i10 != 3) {
            return i10 != 4 ? 1 : 4;
        }
        return 3;
    }

    private static void mmkvLogImp(int level, String file, int line, String function, String message) {
        MMKVHandler mMKVHandler = gCallbackHandler;
        if (mMKVHandler == null || !gWantLogReDirecting) {
            int i10 = AnonymousClass1.$SwitchMap$com$tencent$mmkv$MMKVLogLevel[index2LogLevel[level].ordinal()];
        } else {
            mMKVHandler.mmkvLog(index2LogLevel[level], file, line, function, message);
        }
    }

    public static MMKV mmkvWithAshmemFD(String mmapID, int fd2, int metaFD, String cryptKey) throws RuntimeException {
        long mMKVWithAshmemFD = getMMKVWithAshmemFD(mmapID, fd2, metaFD, cryptKey);
        if (mMKVWithAshmemFD != 0) {
            return new MMKV(mMKVWithAshmemFD);
        }
        throw new RuntimeException("Fail to create an ashmem MMKV instance [" + mmapID + "] in JNI");
    }

    public static MMKV mmkvWithAshmemID(Context context, String mmapID, int size, int mode, @p0 String cryptKey) throws RuntimeException {
        MMKV mmkv;
        if (rootDir == null) {
            throw new IllegalStateException("You should Call MMKV.initialize() first.");
        }
        String processNameByPID = MMKVContentProvider.getProcessNameByPID(context, Process.myPid());
        if (processNameByPID == null || processNameByPID.length() == 0) {
            simpleLog(MMKVLogLevel.LevelError, "process name detect fail, try again later");
            throw new IllegalStateException("process name detect fail, try again later");
        }
        if (processNameByPID.contains(":")) {
            Uri uriContentUri = MMKVContentProvider.contentUri(context);
            if (uriContentUri == null) {
                simpleLog(MMKVLogLevel.LevelError, "MMKVContentProvider has invalid authority");
                throw new IllegalStateException("MMKVContentProvider has invalid authority");
            }
            MMKVLogLevel mMKVLogLevel = MMKVLogLevel.LevelInfo;
            simpleLog(mMKVLogLevel, "getting parcelable mmkv in process, Uri = " + uriContentUri);
            Bundle bundle = new Bundle();
            bundle.putInt(MMKVContentProvider.KEY_SIZE, size);
            bundle.putInt(MMKVContentProvider.KEY_MODE, mode);
            if (cryptKey != null) {
                bundle.putString(MMKVContentProvider.KEY_CRYPT, cryptKey);
            }
            Bundle bundleCall = context.getContentResolver().call(uriContentUri, MMKVContentProvider.FUNCTION_NAME, mmapID, bundle);
            if (bundleCall != null) {
                bundleCall.setClassLoader(ParcelableMMKV.class.getClassLoader());
                ParcelableMMKV parcelableMMKV = (ParcelableMMKV) bundleCall.getParcelable(MMKVContentProvider.KEY);
                if (parcelableMMKV != null && (mmkv = parcelableMMKV.toMMKV()) != null) {
                    simpleLog(mMKVLogLevel, mmkv.mmapID() + " fd = " + mmkv.ashmemFD() + ", meta fd = " + mmkv.ashmemMetaFD());
                    return mmkv;
                }
            }
        }
        simpleLog(MMKVLogLevel.LevelInfo, "getting mmkv in main process");
        long mMKVWithIDAndSize = getMMKVWithIDAndSize(mmapID, size, mode | 8, cryptKey);
        if (mMKVWithIDAndSize != 0) {
            return new MMKV(mMKVWithIDAndSize);
        }
        throw new IllegalStateException("Fail to create an Ashmem MMKV instance [" + mmapID + "]");
    }

    public static MMKV mmkvWithID(String mmapID) throws RuntimeException {
        if (rootDir != null) {
            return checkProcessMode(getMMKVWithID(mmapID, 1, null, null), mmapID, 1);
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    private static void onContentChangedByOuterProcess(String mmapID) {
        MMKVContentChangeNotification mMKVContentChangeNotification = gContentChangeNotify;
        if (mMKVContentChangeNotification != null) {
            mMKVContentChangeNotification.onContentChangedByOuterProcess(mmapID);
        }
    }

    public static native void onExit();

    private static int onMMKVCRCCheckFail(String mmapID) {
        MMKVRecoverStrategic mMKVRecoverStrategicOnMMKVCRCCheckFail = MMKVRecoverStrategic.OnErrorDiscard;
        MMKVHandler mMKVHandler = gCallbackHandler;
        if (mMKVHandler != null) {
            mMKVRecoverStrategicOnMMKVCRCCheckFail = mMKVHandler.onMMKVCRCCheckFail(mmapID);
        }
        simpleLog(MMKVLogLevel.LevelInfo, "Recover strategic for " + mmapID + " is " + mMKVRecoverStrategicOnMMKVCRCCheckFail);
        Integer num = recoverIndex.get(mMKVRecoverStrategicOnMMKVCRCCheckFail);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    private static int onMMKVFileLengthError(String mmapID) {
        MMKVRecoverStrategic mMKVRecoverStrategicOnMMKVFileLengthError = MMKVRecoverStrategic.OnErrorDiscard;
        MMKVHandler mMKVHandler = gCallbackHandler;
        if (mMKVHandler != null) {
            mMKVRecoverStrategicOnMMKVFileLengthError = mMKVHandler.onMMKVFileLengthError(mmapID);
        }
        simpleLog(MMKVLogLevel.LevelInfo, "Recover strategic for " + mmapID + " is " + mMKVRecoverStrategicOnMMKVFileLengthError);
        Integer num = recoverIndex.get(mMKVRecoverStrategicOnMMKVFileLengthError);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static native int pageSize();

    public static void registerContentChangeNotify(MMKVContentChangeNotification notify) {
        gContentChangeNotify = notify;
        setWantsContentChangeNotify(notify != null);
    }

    public static void registerHandler(MMKVHandler handler) {
        gCallbackHandler = handler;
        if (handler.wantLogRedirecting()) {
            setCallbackHandler(true, true);
            gWantLogReDirecting = true;
        } else {
            setCallbackHandler(false, true);
            gWantLogReDirecting = false;
        }
    }

    private native void removeValueForKey(long handle, String key);

    public static native long restoreAllFromDirectory(String srcDir);

    public static native boolean restoreOneMMKVFromDirectory(String mmapID, String srcDir, @p0 String rootPath);

    private static native void setCallbackHandler(boolean logReDirecting, boolean hasCallback);

    private static native void setLogLevel(int level);

    public static void setLogLevel(MMKVLogLevel level) {
        setLogLevel(logLevel2Int(level));
    }

    private static native void setWantsContentChangeNotify(boolean needsNotify);

    private static void simpleLog(MMKVLogLevel level, String message) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[r0.length - 1];
        Integer num = logLevel2Index.get(level);
        mmkvLogImp(num == null ? 0 : num.intValue(), stackTraceElement.getFileName(), stackTraceElement.getLineNumber(), stackTraceElement.getMethodName(), message);
    }

    private native void sync(boolean sync);

    private native long totalSize(long handle);

    public static void unregisterContentChangeNotify() {
        gContentChangeNotify = null;
        setWantsContentChangeNotify(false);
    }

    public static void unregisterHandler() {
        gCallbackHandler = null;
        setCallbackHandler(false, false);
        gWantLogReDirecting = false;
    }

    private native int valueSize(long handle, String key, boolean actualSize);

    public static native String version();

    private native int writeValueToNB(long handle, String key, long pointer, int size);

    public long actualSize() {
        return actualSize(this.nativeHandle);
    }

    @p0
    public native String[] allKeys();

    @Override // android.content.SharedPreferences.Editor
    @Deprecated
    public void apply() {
        sync(false);
    }

    public native int ashmemFD();

    public native int ashmemMetaFD();

    public void async() {
        sync(false);
    }

    public native void checkContentChangedByOuterProcess();

    public native void checkReSetCryptKey(@p0 String cryptKey);

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor clear() {
        clearAll();
        return this;
    }

    public native void clearAll();

    public native void clearMemoryCache();

    public native void close();

    @Override // android.content.SharedPreferences.Editor
    @Deprecated
    public boolean commit() {
        sync(true);
        return true;
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String key) {
        return containsKey(key);
    }

    public boolean containsKey(String key) {
        return containsKey(this.nativeHandle, key);
    }

    public long count() {
        return count(this.nativeHandle);
    }

    @p0
    public native String cryptKey();

    public boolean decodeBool(String key) {
        return decodeBool(this.nativeHandle, key, false);
    }

    @p0
    public byte[] decodeBytes(String key) {
        return decodeBytes(key, (byte[]) null);
    }

    public double decodeDouble(String key) {
        return decodeDouble(this.nativeHandle, key, 0.0d);
    }

    public float decodeFloat(String key) {
        return decodeFloat(this.nativeHandle, key, 0.0f);
    }

    public int decodeInt(String key) {
        return decodeInt(this.nativeHandle, key, 0);
    }

    public long decodeLong(String key) {
        return decodeLong(this.nativeHandle, key, 0L);
    }

    @p0
    public <T extends Parcelable> T decodeParcelable(String str, Class<T> cls) {
        return (T) decodeParcelable(str, cls, null);
    }

    @p0
    public String decodeString(String key) {
        return decodeString(this.nativeHandle, key, null);
    }

    @p0
    public Set<String> decodeStringSet(String key) {
        return decodeStringSet(key, (Set<String>) null);
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this;
    }

    public boolean encode(String key, boolean value) {
        return encodeBool(this.nativeHandle, key, value);
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        throw new UnsupportedOperationException("Intentionally Not Supported. Use allKeys() instead, getAll() not implement because type-erasure inside mmkv");
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String key, boolean defValue) {
        return decodeBool(this.nativeHandle, key, defValue);
    }

    public byte[] getBytes(String key, @p0 byte[] defValue) {
        return decodeBytes(key, defValue);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String key, float defValue) {
        return decodeFloat(this.nativeHandle, key, defValue);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String key, int defValue) {
        return decodeInt(this.nativeHandle, key, defValue);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String key, long defValue) {
        return decodeLong(this.nativeHandle, key, defValue);
    }

    @Override // android.content.SharedPreferences
    @p0
    public String getString(String key, @p0 String defValue) {
        return decodeString(this.nativeHandle, key, defValue);
    }

    @Override // android.content.SharedPreferences
    @p0
    public Set<String> getStringSet(String key, @p0 Set<String> defValues) {
        return decodeStringSet(key, defValues);
    }

    public int getValueActualSize(String key) {
        return valueSize(this.nativeHandle, key, true);
    }

    public int getValueSize(String key) {
        return valueSize(this.nativeHandle, key, false);
    }

    public int importFromSharedPreferences(SharedPreferences preferences) {
        Map<String, ?> all = preferences.getAll();
        if (all == null || all.size() <= 0) {
            return 0;
        }
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (key != null && value != null) {
                if (value instanceof Boolean) {
                    encodeBool(this.nativeHandle, key, ((Boolean) value).booleanValue());
                } else if (value instanceof Integer) {
                    encodeInt(this.nativeHandle, key, ((Integer) value).intValue());
                } else if (value instanceof Long) {
                    encodeLong(this.nativeHandle, key, ((Long) value).longValue());
                } else if (value instanceof Float) {
                    encodeFloat(this.nativeHandle, key, ((Float) value).floatValue());
                } else if (value instanceof Double) {
                    encodeDouble(this.nativeHandle, key, ((Double) value).doubleValue());
                } else if (value instanceof String) {
                    encodeString(this.nativeHandle, key, (String) value);
                } else if (value instanceof Set) {
                    encode(key, (Set<String>) value);
                } else {
                    simpleLog(MMKVLogLevel.LevelError, "unknown type: " + value.getClass());
                }
            }
        }
        return all.size();
    }

    public native void lock();

    public native String mmapID();

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putBoolean(String key, boolean value) {
        encodeBool(this.nativeHandle, key, value);
        return this;
    }

    public SharedPreferences.Editor putBytes(String key, @p0 byte[] bytes) {
        encode(key, bytes);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putFloat(String key, float value) {
        encodeFloat(this.nativeHandle, key, value);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putInt(String key, int value) {
        encodeInt(this.nativeHandle, key, value);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putLong(String key, long value) {
        encodeLong(this.nativeHandle, key, value);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putString(String key, @p0 String value) {
        encodeString(this.nativeHandle, key, value);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor putStringSet(String key, @p0 Set<String> values) {
        encode(key, values);
        return this;
    }

    public native boolean reKey(@p0 String cryptKey);

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener listener) {
        throw new UnsupportedOperationException("Intentionally Not implement in MMKV");
    }

    @Override // android.content.SharedPreferences.Editor
    public SharedPreferences.Editor remove(String key) {
        removeValueForKey(key);
        return this;
    }

    public void removeValueForKey(String key) {
        removeValueForKey(this.nativeHandle, key);
    }

    public native void removeValuesForKeys(String[] arrKeys);

    public void sync() {
        sync(true);
    }

    public long totalSize() {
        return totalSize(this.nativeHandle);
    }

    public native void trim();

    public native boolean tryLock();

    public native void unlock();

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener listener) {
        throw new UnsupportedOperationException("Intentionally Not implement in MMKV");
    }

    public int writeValueToNativeBuffer(String key, NativeBuffer buffer) {
        return writeValueToNB(this.nativeHandle, key, buffer.pointer, buffer.size);
    }

    public boolean decodeBool(String key, boolean defaultValue) {
        return decodeBool(this.nativeHandle, key, defaultValue);
    }

    @p0
    public byte[] decodeBytes(String key, @p0 byte[] defaultValue) {
        byte[] bArrDecodeBytes = decodeBytes(this.nativeHandle, key);
        return bArrDecodeBytes != null ? bArrDecodeBytes : defaultValue;
    }

    public double decodeDouble(String key, double defaultValue) {
        return decodeDouble(this.nativeHandle, key, defaultValue);
    }

    public float decodeFloat(String key, float defaultValue) {
        return decodeFloat(this.nativeHandle, key, defaultValue);
    }

    public int decodeInt(String key, int defaultValue) {
        return decodeInt(this.nativeHandle, key, defaultValue);
    }

    public long decodeLong(String key, long defaultValue) {
        return decodeLong(this.nativeHandle, key, defaultValue);
    }

    @p0
    public <T extends Parcelable> T decodeParcelable(String key, Class<T> tClass, @p0 T defaultValue) {
        byte[] bArrDecodeBytes;
        Parcelable.Creator<?> creator;
        if (tClass == null || (bArrDecodeBytes = decodeBytes(this.nativeHandle, key)) == null) {
            return defaultValue;
        }
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.unmarshall(bArrDecodeBytes, 0, bArrDecodeBytes.length);
        parcelObtain.setDataPosition(0);
        try {
            String string = tClass.toString();
            HashMap<String, Parcelable.Creator<?>> map = mCreators;
            synchronized (map) {
                creator = map.get(string);
                if (creator == null && (creator = (Parcelable.Creator) tClass.getField("CREATOR").get(null)) != null) {
                    map.put(string, creator);
                }
            }
            if (creator != null) {
                return (T) creator.createFromParcel(parcelObtain);
            }
            throw new Exception("Parcelable protocol requires a non-null static Parcelable.Creator object called CREATOR on class " + string);
        } catch (Exception e10) {
            simpleLog(MMKVLogLevel.LevelError, e10.toString());
            return defaultValue;
        } finally {
            parcelObtain.recycle();
        }
    }

    @p0
    public String decodeString(String key, @p0 String defaultValue) {
        return decodeString(this.nativeHandle, key, defaultValue);
    }

    @p0
    public Set<String> decodeStringSet(String key, @p0 Set<String> defaultValue) {
        return decodeStringSet(key, defaultValue, HashSet.class);
    }

    public boolean encode(String key, int value) {
        return encodeInt(this.nativeHandle, key, value);
    }

    @p0
    public Set<String> decodeStringSet(String key, @p0 Set<String> defaultValue, Class<? extends Set> cls) {
        String[] strArrDecodeStringSet = decodeStringSet(this.nativeHandle, key);
        if (strArrDecodeStringSet == null) {
            return defaultValue;
        }
        try {
            Set<String> setNewInstance = cls.newInstance();
            setNewInstance.addAll(Arrays.asList(strArrDecodeStringSet));
            return setNewInstance;
        } catch (IllegalAccessException | InstantiationException unused) {
            return defaultValue;
        }
    }

    public boolean encode(String key, long value) {
        return encodeLong(this.nativeHandle, key, value);
    }

    public static String initialize(Context context, MMKVLogLevel logLevel) {
        return initialize(context, context.getFilesDir().getAbsolutePath() + "/mmkv", null, logLevel);
    }

    public boolean encode(String key, float value) {
        return encodeFloat(this.nativeHandle, key, value);
    }

    public static MMKV defaultMMKV(int mode, @p0 String cryptKey) throws RuntimeException {
        if (rootDir != null) {
            return checkProcessMode(getDefaultMMKV(mode, cryptKey), "DefaultMMKV", mode);
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    public static MMKV mmkvWithID(String mmapID, int mode) throws RuntimeException {
        if (rootDir != null) {
            return checkProcessMode(getMMKVWithID(mmapID, mode, null, null), mmapID, mode);
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    public boolean encode(String key, double value) {
        return encodeDouble(this.nativeHandle, key, value);
    }

    public static String initialize(Context context, LibLoader loader) {
        return initialize(context, context.getFilesDir().getAbsolutePath() + "/mmkv", loader, MMKVLogLevel.LevelInfo);
    }

    public boolean encode(String key, @p0 String value) {
        return encodeString(this.nativeHandle, key, value);
    }

    public boolean encode(String key, @p0 Set<String> value) {
        return encodeSet(this.nativeHandle, key, value == null ? null : (String[]) value.toArray(new String[0]));
    }

    public boolean encode(String key, @p0 byte[] value) {
        return encodeBytes(this.nativeHandle, key, value);
    }

    public static String initialize(Context context, LibLoader loader, MMKVLogLevel logLevel) {
        return initialize(context, context.getFilesDir().getAbsolutePath() + "/mmkv", loader, logLevel);
    }

    public static MMKV mmkvWithID(String mmapID, int mode, @p0 String cryptKey) throws RuntimeException {
        if (rootDir != null) {
            return checkProcessMode(getMMKVWithID(mmapID, mode, cryptKey, null), mmapID, mode);
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    public boolean encode(String key, @p0 Parcelable value) {
        if (value == null) {
            return encodeBytes(this.nativeHandle, key, null);
        }
        Parcel parcelObtain = Parcel.obtain();
        value.writeToParcel(parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        return encodeBytes(this.nativeHandle, key, bArrMarshall);
    }

    public static String initialize(Context context, String rootDir2) {
        return initialize(context, rootDir2, null, MMKVLogLevel.LevelInfo);
    }

    public static String initialize(Context context, String rootDir2, MMKVLogLevel logLevel) {
        return initialize(context, rootDir2, null, logLevel);
    }

    public static MMKV mmkvWithID(String mmapID, String rootPath) throws RuntimeException {
        if (rootDir != null) {
            return checkProcessMode(getMMKVWithID(mmapID, 1, null, rootPath), mmapID, 1);
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    public static String initialize(Context context, String rootDir2, LibLoader loader) {
        return initialize(context, rootDir2, loader, MMKVLogLevel.LevelInfo);
    }

    public static String initialize(Context context, String rootDir2, LibLoader loader, MMKVLogLevel logLevel) {
        if ((context.getApplicationInfo().flags & 2) == 0) {
            disableProcessModeChecker();
        } else {
            enableProcessModeChecker();
        }
        return doInitialize(rootDir2, context.getCacheDir().getAbsolutePath(), loader, logLevel);
    }

    public static MMKV mmkvWithID(String mmapID, int mode, @p0 String cryptKey, String rootPath) throws RuntimeException {
        if (rootDir != null) {
            return checkProcessMode(getMMKVWithID(mmapID, mode, cryptKey, rootPath), mmapID, mode);
        }
        throw new IllegalStateException("You should Call MMKV.initialize() first.");
    }

    @Deprecated
    public static String initialize(String rootDir2) {
        return doInitialize(rootDir2, rootDir2 + "/.tmp", null, MMKVLogLevel.LevelInfo);
    }

    @Deprecated
    public static String initialize(String rootDir2, MMKVLogLevel logLevel) {
        return doInitialize(rootDir2, rootDir2 + "/.tmp", null, logLevel);
    }

    @Deprecated
    public static String initialize(String rootDir2, LibLoader loader) {
        return doInitialize(rootDir2, rootDir2 + "/.tmp", loader, MMKVLogLevel.LevelInfo);
    }

    @Deprecated
    public static String initialize(String rootDir2, LibLoader loader, MMKVLogLevel logLevel) {
        return doInitialize(rootDir2, rootDir2 + "/.tmp", loader, logLevel);
    }
}
