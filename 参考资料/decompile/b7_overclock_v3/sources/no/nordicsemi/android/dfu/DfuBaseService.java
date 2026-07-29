package no.nordicsemi.android.dfu;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.SystemClock;
import com.flydigi.action.FirmwareUpgradeStatisticsLog;
import f0.v;
import g.n0;
import g.p0;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import no.nordicsemi.android.dfu.DfuProgressInfo;
import no.nordicsemi.android.dfu.internal.ArchiveInputStream;
import no.nordicsemi.android.dfu.internal.HexInputStream;
import s1.a;

/* JADX INFO: loaded from: classes5.dex */
public abstract class DfuBaseService extends IntentService implements DfuProgressInfo.ProgressListener {
    public static final int ACTION_ABORT = 2;
    public static final int ACTION_PAUSE = 0;
    public static final int ACTION_RESUME = 1;
    public static final String BROADCAST_ACTION = "no.nordicsemi.android.dfu.broadcast.BROADCAST_ACTION";
    public static final String BROADCAST_ERROR = "no.nordicsemi.android.dfu.broadcast.BROADCAST_ERROR";
    public static final String BROADCAST_LOG = "no.nordicsemi.android.dfu.broadcast.BROADCAST_LOG";
    public static final String BROADCAST_PROGRESS = "no.nordicsemi.android.dfu.broadcast.BROADCAST_PROGRESS";
    public static boolean DEBUG = false;
    public static final int ERROR_BLUETOOTH_DISABLED = 4106;
    public static final int ERROR_CONNECTION_MASK = 16384;
    public static final int ERROR_CONNECTION_STATE_MASK = 32768;
    public static final int ERROR_CRC_ERROR = 4109;
    public static final int ERROR_DEVICE_DISCONNECTED = 4096;
    public static final int ERROR_DEVICE_NOT_BONDED = 4110;
    public static final int ERROR_FILE_ERROR = 4098;
    public static final int ERROR_FILE_INVALID = 4099;
    public static final int ERROR_FILE_IO_EXCEPTION = 4100;
    public static final int ERROR_FILE_NOT_FOUND = 4097;
    public static final int ERROR_FILE_SIZE_INVALID = 4108;
    public static final int ERROR_FILE_TYPE_UNSUPPORTED = 4105;
    public static final int ERROR_INIT_PACKET_REQUIRED = 4107;
    public static final int ERROR_INVALID_RESPONSE = 4104;
    public static final int ERROR_MASK = 4096;
    public static final int ERROR_REMOTE_MASK = 8192;
    public static final int ERROR_REMOTE_TYPE_LEGACY = 256;
    public static final int ERROR_REMOTE_TYPE_SECURE = 512;
    public static final int ERROR_REMOTE_TYPE_SECURE_BUTTONLESS = 2048;
    public static final int ERROR_REMOTE_TYPE_SECURE_EXTENDED = 1024;
    public static final int ERROR_SERVICE_DISCOVERY_NOT_STARTED = 4101;
    public static final int ERROR_SERVICE_NOT_FOUND = 4102;
    public static final int ERROR_TYPE_COMMUNICATION = 2;
    public static final int ERROR_TYPE_COMMUNICATION_STATE = 1;
    public static final int ERROR_TYPE_DFU_REMOTE = 3;
    public static final int ERROR_TYPE_OTHER = 0;
    public static final String EXTRA_ACTION = "no.nordicsemi.android.dfu.extra.EXTRA_ACTION";
    public static final String EXTRA_AVG_SPEED_B_PER_MS = "no.nordicsemi.android.dfu.extra.EXTRA_AVG_SPEED_B_PER_MS";
    public static final String EXTRA_CURRENT_MTU = "no.nordicsemi.android.dfu.extra.EXTRA_CURRENT_MTU";
    public static final String EXTRA_CUSTOM_UUIDS_FOR_BUTTONLESS_DFU_WITHOUT_BOND_SHARING = "no.nordicsemi.android.dfu.extra.EXTRA_CUSTOM_UUIDS_FOR_BUTTONLESS_DFU_WITHOUT_BOND_SHARING";
    public static final String EXTRA_CUSTOM_UUIDS_FOR_BUTTONLESS_DFU_WITH_BOND_SHARING = "no.nordicsemi.android.dfu.extra.EXTRA_CUSTOM_UUIDS_FOR_BUTTONLESS_DFU_WITH_BOND_SHARING";
    public static final String EXTRA_CUSTOM_UUIDS_FOR_EXPERIMENTAL_BUTTONLESS_DFU = "no.nordicsemi.android.dfu.extra.EXTRA_CUSTOM_UUIDS_FOR_EXPERIMENTAL_BUTTONLESS_DFU";
    public static final String EXTRA_CUSTOM_UUIDS_FOR_LEGACY_DFU = "no.nordicsemi.android.dfu.extra.EXTRA_CUSTOM_UUIDS_FOR_LEGACY_DFU";
    public static final String EXTRA_CUSTOM_UUIDS_FOR_SECURE_DFU = "no.nordicsemi.android.dfu.extra.EXTRA_CUSTOM_UUIDS_FOR_SECURE_DFU";
    public static final String EXTRA_DATA = "no.nordicsemi.android.dfu.extra.EXTRA_DATA";
    public static final String EXTRA_DEVICE_ADDRESS = "no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_ADDRESS";
    public static final String EXTRA_DEVICE_NAME = "no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_NAME";
    public static final String EXTRA_DFU_ATTEMPT = "no.nordicsemi.android.dfu.extra.EXTRA_DFU_ATTEMPT";
    public static final String EXTRA_DISABLE_NOTIFICATION = "no.nordicsemi.android.dfu.extra.EXTRA_DISABLE_NOTIFICATION";
    public static final String EXTRA_DISABLE_RESUME = "no.nordicsemi.android.dfu.extra.EXTRA_DISABLE_RESUME";
    public static final String EXTRA_ERROR_TYPE = "no.nordicsemi.android.dfu.extra.EXTRA_ERROR_TYPE";
    public static final String EXTRA_FILE_MIME_TYPE = "no.nordicsemi.android.dfu.extra.EXTRA_MIME_TYPE";
    public static final String EXTRA_FILE_PATH = "no.nordicsemi.android.dfu.extra.EXTRA_FILE_PATH";
    public static final String EXTRA_FILE_RES_ID = "no.nordicsemi.android.dfu.extra.EXTRA_FILE_RES_ID";
    public static final String EXTRA_FILE_TYPE = "no.nordicsemi.android.dfu.extra.EXTRA_FILE_TYPE";
    public static final String EXTRA_FILE_URI = "no.nordicsemi.android.dfu.extra.EXTRA_FILE_URI";
    public static final String EXTRA_FORCE_DFU = "no.nordicsemi.android.dfu.extra.EXTRA_FORCE_DFU";
    public static final String EXTRA_FOREGROUND_SERVICE = "no.nordicsemi.android.dfu.extra.EXTRA_FOREGROUND_SERVICE";
    public static final String EXTRA_INIT_FILE_PATH = "no.nordicsemi.android.dfu.extra.EXTRA_INIT_FILE_PATH";
    public static final String EXTRA_INIT_FILE_RES_ID = "no.nordicsemi.android.dfu.extra.EXTRA_INIT_FILE_RES_ID";
    public static final String EXTRA_INIT_FILE_URI = "no.nordicsemi.android.dfu.extra.EXTRA_INIT_FILE_URI";
    public static final String EXTRA_KEEP_BOND = "no.nordicsemi.android.dfu.extra.EXTRA_KEEP_BOND";
    public static final String EXTRA_LOG_LEVEL = "no.nordicsemi.android.dfu.extra.EXTRA_LOG_LEVEL";
    public static final String EXTRA_LOG_MESSAGE = "no.nordicsemi.android.dfu.extra.EXTRA_LOG_INFO";
    public static final String EXTRA_MAX_DFU_ATTEMPTS = "no.nordicsemi.android.dfu.extra.EXTRA_MAX_DFU_ATTEMPTS";
    public static final String EXTRA_MBR_SIZE = "no.nordicsemi.android.dfu.extra.EXTRA_MBR_SIZE";
    public static final String EXTRA_MTU = "no.nordicsemi.android.dfu.extra.EXTRA_MTU";
    public static final String EXTRA_PACKET_RECEIPT_NOTIFICATIONS_ENABLED = "no.nordicsemi.android.dfu.extra.EXTRA_PRN_ENABLED";
    public static final String EXTRA_PACKET_RECEIPT_NOTIFICATIONS_VALUE = "no.nordicsemi.android.dfu.extra.EXTRA_PRN_VALUE";
    public static final String EXTRA_PARTS_TOTAL = "no.nordicsemi.android.dfu.extra.EXTRA_PARTS_TOTAL";
    public static final String EXTRA_PART_CURRENT = "no.nordicsemi.android.dfu.extra.EXTRA_PART_CURRENT";
    public static final String EXTRA_PROGRESS = "no.nordicsemi.android.dfu.extra.EXTRA_PROGRESS";
    private static final String EXTRA_RECONNECTION_ATTEMPT = "no.nordicsemi.android.dfu.extra.EXTRA_RECONNECTION_ATTEMPT";
    public static final String EXTRA_RESTORE_BOND = "no.nordicsemi.android.dfu.extra.EXTRA_RESTORE_BOND";
    public static final String EXTRA_SPEED_B_PER_MS = "no.nordicsemi.android.dfu.extra.EXTRA_SPEED_B_PER_MS";
    public static final String EXTRA_UNSAFE_EXPERIMENTAL_BUTTONLESS_DFU = "no.nordicsemi.android.dfu.extra.EXTRA_UNSAFE_EXPERIMENTAL_BUTTONLESS_DFU";
    public static final int LOG_LEVEL_APPLICATION = 10;
    public static final int LOG_LEVEL_DEBUG = 0;
    public static final int LOG_LEVEL_ERROR = 20;
    public static final int LOG_LEVEL_INFO = 5;
    public static final int LOG_LEVEL_VERBOSE = 1;
    public static final int LOG_LEVEL_WARNING = 15;
    public static final String MIME_TYPE_OCTET_STREAM = "application/octet-stream";
    public static final String MIME_TYPE_ZIP = "application/zip";
    public static final String NOTIFICATION_CHANNEL_DFU = "dfu";
    public static final int NOTIFICATION_ID = 283;
    public static final int PROGRESS_ABORTED = -7;
    public static final int PROGRESS_COMPLETED = -6;
    public static final int PROGRESS_CONNECTING = -1;
    public static final int PROGRESS_DISCONNECTING = -5;
    public static final int PROGRESS_ENABLING_DFU_MODE = -3;
    public static final int PROGRESS_STARTING = -2;
    public static final int PROGRESS_VALIDATING = -4;
    public static final int STATE_CLOSED = -5;
    public static final int STATE_CONNECTED = -2;
    public static final int STATE_CONNECTED_AND_READY = -3;
    public static final int STATE_CONNECTING = -1;
    public static final int STATE_DISCONNECTED = 0;
    public static final int STATE_DISCONNECTING = -4;
    private static final String TAG = "DfuBaseService";
    public static final int TYPE_APPLICATION = 4;
    public static final int TYPE_AUTO = 0;
    public static final int TYPE_BOOTLOADER = 2;
    public static final int TYPE_SOFT_DEVICE = 1;
    private boolean mAborted;
    private BluetoothAdapter mBluetoothAdapter;
    private final BroadcastReceiver mBluetoothStateBroadcastReceiver;
    private final BroadcastReceiver mBondStateBroadcastReceiver;
    public int mConnectionState;
    private final BroadcastReceiver mConnectionStateBroadcastReceiver;
    private String mDeviceAddress;
    private String mDeviceName;
    private final BroadcastReceiver mDfuActionReceiver;
    private DfuCallback mDfuServiceImpl;
    private boolean mDisableNotification;
    private int mError;
    private InputStream mFirmwareInputStream;
    private final BluetoothGattCallback mGattCallback;
    private InputStream mInitFileInputStream;
    private long mLastNotificationTime;
    private int mLastProgress;
    private final Object mLock;
    public DfuProgressInfo mProgressInfo;

    public DfuBaseService() {
        super(TAG);
        this.mLock = new Object();
        this.mLastProgress = -1;
        this.mDfuActionReceiver = new BroadcastReceiver() { // from class: no.nordicsemi.android.dfu.DfuBaseService.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(final Context context, final Intent intent) {
                int intExtra = intent.getIntExtra(DfuBaseService.EXTRA_ACTION, 0);
                DfuBaseService.this.logi("User action received: " + intExtra);
                if (intExtra == 0) {
                    DfuBaseService.this.sendLogBroadcast(15, "[Broadcast] Pause action received");
                    if (DfuBaseService.this.mDfuServiceImpl != null) {
                        DfuBaseService.this.mDfuServiceImpl.pause();
                        return;
                    }
                    return;
                }
                if (intExtra == 1) {
                    DfuBaseService.this.sendLogBroadcast(15, "[Broadcast] Resume action received");
                    if (DfuBaseService.this.mDfuServiceImpl != null) {
                        DfuBaseService.this.mDfuServiceImpl.resume();
                        return;
                    }
                    return;
                }
                if (intExtra != 2) {
                    return;
                }
                DfuBaseService.this.sendLogBroadcast(15, "[Broadcast] Abort action received");
                DfuBaseService.this.mAborted = true;
                if (DfuBaseService.this.mDfuServiceImpl != null) {
                    DfuBaseService.this.mDfuServiceImpl.abort();
                }
            }
        };
        this.mBluetoothStateBroadcastReceiver = new BroadcastReceiver() { // from class: no.nordicsemi.android.dfu.DfuBaseService.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(final Context context, final Intent intent) {
                int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 10);
                int intExtra2 = intent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", 12);
                DfuBaseService.this.logw("Action received: android.bluetooth.adapter.action.STATE_CHANGED [state: " + intExtra + ", previous state: " + intExtra2 + "]");
                if (intExtra2 == 12) {
                    if (intExtra == 13 || intExtra == 10) {
                        DfuBaseService.this.sendLogBroadcast(15, "Bluetooth adapter disabled");
                        DfuBaseService dfuBaseService = DfuBaseService.this;
                        dfuBaseService.mConnectionState = 0;
                        if (dfuBaseService.mDfuServiceImpl != null) {
                            DfuBaseService.this.mDfuServiceImpl.getGattCallback().onDisconnected();
                        }
                    }
                }
            }
        };
        this.mBondStateBroadcastReceiver = new BroadcastReceiver() { // from class: no.nordicsemi.android.dfu.DfuBaseService.3
            @Override // android.content.BroadcastReceiver
            public void onReceive(final Context context, final Intent intent) {
                int intExtra;
                if (!((BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE")).getAddress().equals(DfuBaseService.this.mDeviceAddress) || (intExtra = intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", -1)) == 11 || DfuBaseService.this.mDfuServiceImpl == null) {
                    return;
                }
                DfuBaseService.this.mDfuServiceImpl.onBondStateChanged(intExtra);
            }
        };
        this.mConnectionStateBroadcastReceiver = new BroadcastReceiver() { // from class: no.nordicsemi.android.dfu.DfuBaseService.4
            @Override // android.content.BroadcastReceiver
            public void onReceive(final Context context, final Intent intent) {
                if (((BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE")).getAddress().equals(DfuBaseService.this.mDeviceAddress)) {
                    String action = intent.getAction();
                    DfuBaseService.this.logi("Action received: " + action);
                    DfuBaseService.this.sendLogBroadcast(0, "[Broadcast] Action received: " + action);
                }
            }
        };
        this.mGattCallback = new BluetoothGattCallback() { // from class: no.nordicsemi.android.dfu.DfuBaseService.5
            @Override // android.bluetooth.BluetoothGattCallback
            public void onCharacteristicChanged(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic) {
                if (DfuBaseService.this.mDfuServiceImpl != null) {
                    DfuBaseService.this.mDfuServiceImpl.getGattCallback().onCharacteristicChanged(gatt, characteristic);
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onCharacteristicRead(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
                if (DfuBaseService.this.mDfuServiceImpl != null) {
                    DfuBaseService.this.mDfuServiceImpl.getGattCallback().onCharacteristicRead(gatt, characteristic, status);
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onCharacteristicWrite(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
                if (DfuBaseService.this.mDfuServiceImpl != null) {
                    DfuBaseService.this.mDfuServiceImpl.getGattCallback().onCharacteristicWrite(gatt, characteristic, status);
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onConnectionStateChange(final BluetoothGatt gatt, final int status, final int newState) {
                if (status != 0) {
                    if (status == 8 || status == 19) {
                        DfuBaseService.this.logw("Target device disconnected with status: " + status);
                    } else {
                        DfuBaseService.this.loge("Connection state change error: " + status + " newState: " + newState);
                    }
                    DfuBaseService.this.mError = status | 32768;
                    if (newState == 0) {
                        DfuBaseService dfuBaseService = DfuBaseService.this;
                        dfuBaseService.mConnectionState = 0;
                        if (dfuBaseService.mDfuServiceImpl != null) {
                            DfuBaseService.this.mDfuServiceImpl.getGattCallback().onDisconnected();
                        }
                    }
                } else if (newState == 2) {
                    DfuBaseService.this.logi("Connected to GATT server");
                    DfuBaseService.this.sendLogBroadcast(5, "Connected to " + DfuBaseService.this.mDeviceAddress);
                    DfuBaseService dfuBaseService2 = DfuBaseService.this;
                    dfuBaseService2.mConnectionState = -2;
                    dfuBaseService2.refreshDeviceCache(gatt, true);
                    DfuBaseService.this.waitFor(1000);
                    if (gatt.getDevice().getBondState() == 12) {
                        DfuBaseService.this.logi("Waiting 1600 ms for a possible Service Changed indication...");
                        DfuBaseService.this.waitFor(1600);
                    }
                    DfuBaseService.this.sendLogBroadcast(1, "Discovering services...");
                    DfuBaseService.this.sendLogBroadcast(0, "gatt.discoverServices()");
                    boolean zDiscoverServices = gatt.discoverServices();
                    DfuBaseService dfuBaseService3 = DfuBaseService.this;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Attempting to start service discovery... ");
                    sb2.append(zDiscoverServices ? "succeed" : "failed");
                    dfuBaseService3.logi(sb2.toString());
                    if (zDiscoverServices) {
                        return;
                    } else {
                        DfuBaseService.this.mError = 4101;
                    }
                } else if (newState == 0) {
                    DfuBaseService.this.logi("Disconnected from GATT server");
                    DfuBaseService dfuBaseService4 = DfuBaseService.this;
                    dfuBaseService4.mConnectionState = 0;
                    if (dfuBaseService4.mDfuServiceImpl != null) {
                        DfuBaseService.this.mDfuServiceImpl.getGattCallback().onDisconnected();
                    }
                }
                synchronized (DfuBaseService.this.mLock) {
                    DfuBaseService.this.mLock.notifyAll();
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onDescriptorRead(BluetoothGatt gatt, BluetoothGattDescriptor descriptor, int status) {
                if (DfuBaseService.this.mDfuServiceImpl != null) {
                    DfuBaseService.this.mDfuServiceImpl.getGattCallback().onDescriptorRead(gatt, descriptor, status);
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onDescriptorWrite(BluetoothGatt gatt, BluetoothGattDescriptor descriptor, int status) {
                if (DfuBaseService.this.mDfuServiceImpl != null) {
                    DfuBaseService.this.mDfuServiceImpl.getGattCallback().onDescriptorWrite(gatt, descriptor, status);
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            @SuppressLint({"NewApi"})
            public void onMtuChanged(final BluetoothGatt gatt, final int mtu, final int status) {
                if (DfuBaseService.this.mDfuServiceImpl != null) {
                    DfuBaseService.this.mDfuServiceImpl.getGattCallback().onMtuChanged(gatt, mtu, status);
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            @SuppressLint({"NewApi"})
            public void onPhyUpdate(final BluetoothGatt gatt, final int txPhy, final int rxPhy, final int status) {
                if (DfuBaseService.this.mDfuServiceImpl != null) {
                    DfuBaseService.this.mDfuServiceImpl.getGattCallback().onPhyUpdate(gatt, txPhy, rxPhy, status);
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onServicesDiscovered(final BluetoothGatt gatt, final int status) {
                if (status == 0) {
                    DfuBaseService.this.logi("Services discovered");
                    DfuBaseService.this.mConnectionState = -3;
                } else {
                    DfuBaseService.this.loge("Service discovery error: " + status);
                    DfuBaseService.this.mError = status | 16384;
                }
                DfuBaseService.this.waitFor(1000);
                synchronized (DfuBaseService.this.mLock) {
                    DfuBaseService.this.mLock.notifyAll();
                }
            }
        };
    }

    private boolean initialize() {
        BluetoothManager bluetoothManager = (BluetoothManager) getSystemService(FirmwareUpgradeStatisticsLog.f13300c);
        if (bluetoothManager == null) {
            loge("Unable to initialize BluetoothManager.");
            return false;
        }
        BluetoothAdapter adapter = bluetoothManager.getAdapter();
        this.mBluetoothAdapter = adapter;
        if (adapter != null) {
            return true;
        }
        loge("Unable to obtain a BluetoothAdapter.");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loge(final String message) {
    }

    private void loge(final String message, final Throwable e10) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logi(final String message) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logw(final String message) {
    }

    private static IntentFilter makeDfuActionIntentFilter() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BROADCAST_ACTION);
        return intentFilter;
    }

    private InputStream openInputStream(@n0 final String filePath, final String mimeType, final int mbrSize, final int types) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(filePath);
        return MIME_TYPE_ZIP.equals(mimeType) ? new ArchiveInputStream(fileInputStream, mbrSize, types) : filePath.toLowerCase(Locale.US).endsWith("hex") ? new HexInputStream(fileInputStream, mbrSize) : fileInputStream;
    }

    private void report(final int error) {
        sendErrorBroadcast(error);
        if (this.mDisableNotification) {
            return;
        }
        String str = this.mDeviceAddress;
        String string = this.mDeviceName;
        if (string == null) {
            string = getString(R.string.dfu_unknown_name);
        }
        v.n nVarD = new v.n(this, "dfu").t0(android.R.drawable.stat_sys_upload).j0(true).J(-65536).i0(false).P(getString(R.string.dfu_status_error)).t0(android.R.drawable.stat_sys_upload_done).O(getString(R.string.dfu_status_error_msg)).D(true);
        Intent intent = new Intent(this, getNotificationTarget());
        intent.addFlags(268435456);
        intent.putExtra(EXTRA_DEVICE_ADDRESS, str);
        intent.putExtra(EXTRA_DEVICE_NAME, string);
        intent.putExtra(EXTRA_PROGRESS, error);
        nVarD.N(PendingIntent.getActivity(this, 0, intent, 201326592));
        updateErrorNotification(nVarD);
        ((NotificationManager) getSystemService("notification")).notify(NOTIFICATION_ID, nVarD.h());
    }

    private void sendErrorBroadcast(final int error) {
        Intent intent = new Intent(BROADCAST_ERROR);
        if ((error & 16384) > 0) {
            intent.putExtra(EXTRA_DATA, error & (-16385));
            intent.putExtra(EXTRA_ERROR_TYPE, 2);
        } else if ((32768 & error) > 0) {
            intent.putExtra(EXTRA_DATA, error & (-32769));
            intent.putExtra(EXTRA_ERROR_TYPE, 1);
        } else if ((error & 8192) > 0) {
            intent.putExtra(EXTRA_DATA, error & (-8193));
            intent.putExtra(EXTRA_ERROR_TYPE, 3);
        } else {
            intent.putExtra(EXTRA_DATA, error);
            intent.putExtra(EXTRA_ERROR_TYPE, 0);
        }
        intent.putExtra(EXTRA_DEVICE_ADDRESS, this.mDeviceAddress);
        a.b(this).d(intent);
    }

    private void sendProgressBroadcast(final DfuProgressInfo info) {
        Intent intent = new Intent(BROADCAST_PROGRESS);
        intent.putExtra(EXTRA_DATA, info.getProgress());
        intent.putExtra(EXTRA_DEVICE_ADDRESS, this.mDeviceAddress);
        intent.putExtra(EXTRA_PART_CURRENT, info.getCurrentPart());
        intent.putExtra(EXTRA_PARTS_TOTAL, info.getTotalParts());
        intent.putExtra(EXTRA_SPEED_B_PER_MS, info.getSpeed());
        intent.putExtra(EXTRA_AVG_SPEED_B_PER_MS, info.getAverageSpeed());
        a.b(this).d(intent);
    }

    private void startForeground() {
        v.n nVarI0 = new v.n(this, "dfu").t0(android.R.drawable.stat_sys_upload).P(getString(R.string.dfu_status_foreground_title)).O(getString(R.string.dfu_status_foreground_content)).J(-7829368).k0(-1).i0(true);
        Class<? extends Activity> notificationTarget = getNotificationTarget();
        if (notificationTarget != null) {
            Intent intent = new Intent(this, notificationTarget);
            intent.addFlags(268435456);
            intent.putExtra(EXTRA_DEVICE_ADDRESS, this.mDeviceAddress);
            intent.putExtra(EXTRA_DEVICE_NAME, this.mDeviceName);
            nVarI0.N(PendingIntent.getActivity(this, 0, intent, 201326592));
        } else {
            logw("getNotificationTarget() should not return null if the service is to be started as a foreground service");
        }
        updateForegroundNotification(nVarI0);
        startForeground(NOTIFICATION_ID, nVarI0.h());
    }

    public void close(final BluetoothGatt gatt) {
        logi("Cleaning up...");
        sendLogBroadcast(0, "gatt.disconnect()");
        gatt.disconnect();
        sendLogBroadcast(0, "gatt.close()");
        gatt.close();
        this.mConnectionState = -5;
    }

    public BluetoothGatt connect(@n0 final String address) {
        BluetoothGatt bluetoothGattConnectGatt;
        if (!this.mBluetoothAdapter.isEnabled()) {
            return null;
        }
        this.mConnectionState = -1;
        logi("Connecting to the device...");
        BluetoothDevice remoteDevice = this.mBluetoothAdapter.getRemoteDevice(address);
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 26) {
            sendLogBroadcast(0, "gatt = device.connectGatt(autoConnect = false, TRANSPORT_LE, preferredPhy = LE_1M | LE_2M)");
            bluetoothGattConnectGatt = remoteDevice.connectGatt(this, false, this.mGattCallback, 2, 3);
        } else if (i10 >= 23) {
            sendLogBroadcast(0, "gatt = device.connectGatt(autoConnect = false, TRANSPORT_LE)");
            bluetoothGattConnectGatt = remoteDevice.connectGatt(this, false, this.mGattCallback, 2);
        } else {
            sendLogBroadcast(0, "gatt = device.connectGatt(autoConnect = false)");
            bluetoothGattConnectGatt = remoteDevice.connectGatt(this, false, this.mGattCallback);
        }
        try {
            synchronized (this.mLock) {
                while (true) {
                    int i11 = this.mConnectionState;
                    if ((i11 != -1 && i11 != -2) || this.mError != 0) {
                        break;
                    }
                    this.mLock.wait();
                }
            }
        } catch (InterruptedException e10) {
            loge("Sleeping interrupted", e10);
        }
        return bluetoothGattConnectGatt;
    }

    public void disconnect(@n0 final BluetoothGatt gatt) {
        if (this.mConnectionState == 0) {
            return;
        }
        sendLogBroadcast(1, "Disconnecting...");
        this.mProgressInfo.setProgress(-5);
        this.mConnectionState = -4;
        logi("Disconnecting from the device...");
        sendLogBroadcast(0, "gatt.disconnect()");
        gatt.disconnect();
        waitUntilDisconnected();
        sendLogBroadcast(5, "Disconnected");
    }

    @p0
    public abstract Class<? extends Activity> getNotificationTarget();

    public boolean isDebug() {
        return false;
    }

    @Override // android.app.IntentService, android.app.Service
    public void onCreate() {
        super.onCreate();
        DEBUG = isDebug();
        initialize();
        a aVarB = a.b(this);
        IntentFilter intentFilterMakeDfuActionIntentFilter = makeDfuActionIntentFilter();
        aVarB.c(this.mDfuActionReceiver, intentFilterMakeDfuActionIntentFilter);
        registerReceiver(this.mDfuActionReceiver, intentFilterMakeDfuActionIntentFilter);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.device.action.ACL_CONNECTED");
        intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECT_REQUESTED");
        intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
        registerReceiver(this.mConnectionStateBroadcastReceiver, intentFilter);
        registerReceiver(this.mBondStateBroadcastReceiver, new IntentFilter("android.bluetooth.device.action.BOND_STATE_CHANGED"));
        registerReceiver(this.mBluetoothStateBroadcastReceiver, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
    }

    @Override // android.app.IntentService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        DfuCallback dfuCallback = this.mDfuServiceImpl;
        if (dfuCallback != null) {
            dfuCallback.abort();
        }
        a.b(this).f(this.mDfuActionReceiver);
        unregisterReceiver(this.mDfuActionReceiver);
        unregisterReceiver(this.mConnectionStateBroadcastReceiver);
        unregisterReceiver(this.mBondStateBroadcastReceiver);
        unregisterReceiver(this.mBluetoothStateBroadcastReceiver);
        try {
            InputStream inputStream = this.mFirmwareInputStream;
            if (inputStream != null) {
                inputStream.close();
            }
            InputStream inputStream2 = this.mInitFileInputStream;
            if (inputStream2 != null) {
                inputStream2.close();
            }
        } catch (IOException unused) {
        } catch (Throwable th2) {
            this.mFirmwareInputStream = null;
            this.mInitFileInputStream = null;
            throw th2;
        }
        this.mFirmwareInputStream = null;
        this.mInitFileInputStream = null;
        logi("DFU service destroyed");
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x0208 A[Catch: all -> 0x016e, Exception -> 0x0172, IOException -> 0x0176, SizeValidationException -> 0x017a, FileNotFoundException -> 0x017e, SecurityException -> 0x0182, TryCatch #16 {SizeValidationException -> 0x017a, IOException -> 0x0176, blocks: (B:55:0x0119, B:57:0x0123, B:64:0x013a, B:70:0x015c, B:88:0x018a, B:90:0x0190, B:92:0x0195, B:94:0x019e, B:96:0x01a2, B:99:0x01ab, B:100:0x01b2, B:101:0x01b3, B:103:0x01b7, B:106:0x01c0, B:107:0x01c7, B:108:0x01c8, B:110:0x01cc, B:113:0x01d5, B:114:0x01dc, B:117:0x01e0, B:119:0x01e6, B:128:0x0208, B:130:0x0211, B:131:0x0218, B:120:0x01f0, B:122:0x01f6, B:93:0x019a, B:73:0x0166, B:74:0x016d, B:66:0x0145, B:68:0x014f, B:59:0x012a, B:61:0x0131), top: B:288:0x0119, outer: #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x023a A[Catch: all -> 0x016e, TRY_ENTER, TRY_LEAVE, TryCatch #10 {all -> 0x016e, blocks: (B:55:0x0119, B:57:0x0123, B:64:0x013a, B:70:0x015c, B:88:0x018a, B:90:0x0190, B:92:0x0195, B:94:0x019e, B:96:0x01a2, B:99:0x01ab, B:100:0x01b2, B:101:0x01b3, B:103:0x01b7, B:106:0x01c0, B:107:0x01c7, B:108:0x01c8, B:110:0x01cc, B:113:0x01d5, B:114:0x01dc, B:117:0x01e0, B:119:0x01e6, B:128:0x0208, B:130:0x0211, B:131:0x0218, B:134:0x0226, B:135:0x022c, B:138:0x023a, B:142:0x024d, B:144:0x0269, B:148:0x027e, B:160:0x029e, B:163:0x0326, B:165:0x032e, B:167:0x0339, B:168:0x033c, B:172:0x0360, B:161:0x02bf, B:162:0x02f2, B:176:0x036b, B:178:0x036f, B:183:0x0383, B:185:0x0387, B:189:0x039e, B:196:0x03c6, B:206:0x03e5, B:236:0x04c2, B:228:0x0462, B:250:0x04ee, B:251:0x04f1, B:120:0x01f0, B:122:0x01f6, B:93:0x019a, B:73:0x0166, B:74:0x016d, B:66:0x0145, B:68:0x014f, B:59:0x012a, B:61:0x0131, B:252:0x04f2, B:256:0x051a, B:260:0x0542, B:264:0x0559, B:268:0x0570), top: B:280:0x0117, inners: #16, #13 }] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x024d A[Catch: all -> 0x016e, TRY_ENTER, TryCatch #10 {all -> 0x016e, blocks: (B:55:0x0119, B:57:0x0123, B:64:0x013a, B:70:0x015c, B:88:0x018a, B:90:0x0190, B:92:0x0195, B:94:0x019e, B:96:0x01a2, B:99:0x01ab, B:100:0x01b2, B:101:0x01b3, B:103:0x01b7, B:106:0x01c0, B:107:0x01c7, B:108:0x01c8, B:110:0x01cc, B:113:0x01d5, B:114:0x01dc, B:117:0x01e0, B:119:0x01e6, B:128:0x0208, B:130:0x0211, B:131:0x0218, B:134:0x0226, B:135:0x022c, B:138:0x023a, B:142:0x024d, B:144:0x0269, B:148:0x027e, B:160:0x029e, B:163:0x0326, B:165:0x032e, B:167:0x0339, B:168:0x033c, B:172:0x0360, B:161:0x02bf, B:162:0x02f2, B:176:0x036b, B:178:0x036f, B:183:0x0383, B:185:0x0387, B:189:0x039e, B:196:0x03c6, B:206:0x03e5, B:236:0x04c2, B:228:0x0462, B:250:0x04ee, B:251:0x04f1, B:120:0x01f0, B:122:0x01f6, B:93:0x019a, B:73:0x0166, B:74:0x016d, B:66:0x0145, B:68:0x014f, B:59:0x012a, B:61:0x0131, B:252:0x04f2, B:256:0x051a, B:260:0x0542, B:264:0x0559, B:268:0x0570), top: B:280:0x0117, inners: #16, #13 }] */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0462 A[Catch: all -> 0x016e, PHI: r2
  0x0462: PHI (r2v38 no.nordicsemi.android.dfu.DfuService) = 
  (r2v36 no.nordicsemi.android.dfu.DfuService)
  (r2v37 no.nordicsemi.android.dfu.DfuService)
  (r2v39 no.nordicsemi.android.dfu.DfuService)
 binds: [B:244:0x04e2, B:227:0x0460, B:242:0x04d0] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #10 {all -> 0x016e, blocks: (B:55:0x0119, B:57:0x0123, B:64:0x013a, B:70:0x015c, B:88:0x018a, B:90:0x0190, B:92:0x0195, B:94:0x019e, B:96:0x01a2, B:99:0x01ab, B:100:0x01b2, B:101:0x01b3, B:103:0x01b7, B:106:0x01c0, B:107:0x01c7, B:108:0x01c8, B:110:0x01cc, B:113:0x01d5, B:114:0x01dc, B:117:0x01e0, B:119:0x01e6, B:128:0x0208, B:130:0x0211, B:131:0x0218, B:134:0x0226, B:135:0x022c, B:138:0x023a, B:142:0x024d, B:144:0x0269, B:148:0x027e, B:160:0x029e, B:163:0x0326, B:165:0x032e, B:167:0x0339, B:168:0x033c, B:172:0x0360, B:161:0x02bf, B:162:0x02f2, B:176:0x036b, B:178:0x036f, B:183:0x0383, B:185:0x0387, B:189:0x039e, B:196:0x03c6, B:206:0x03e5, B:236:0x04c2, B:228:0x0462, B:250:0x04ee, B:251:0x04f1, B:120:0x01f0, B:122:0x01f6, B:93:0x019a, B:73:0x0166, B:74:0x016d, B:66:0x0145, B:68:0x014f, B:59:0x012a, B:61:0x0131, B:252:0x04f2, B:256:0x051a, B:260:0x0542, B:264:0x0559, B:268:0x0570), top: B:280:0x0117, inners: #16, #13 }] */
    /* JADX WARN: Removed duplicated region for block: B:234:0x048b A[Catch: all -> 0x03ff, TRY_LEAVE, TryCatch #16 {all -> 0x03ff, blocks: (B:191:0x03a9, B:232:0x046b, B:234:0x048b, B:240:0x04cb, B:222:0x0405, B:224:0x040f, B:226:0x0452, B:225:0x0432, B:243:0x04d1), top: B:287:0x03a9 }] */
    /* JADX WARN: Removed duplicated region for block: B:240:0x04cb A[Catch: all -> 0x03ff, TRY_ENTER, TryCatch #16 {all -> 0x03ff, blocks: (B:191:0x03a9, B:232:0x046b, B:234:0x048b, B:240:0x04cb, B:222:0x0405, B:224:0x040f, B:226:0x0452, B:225:0x0432, B:243:0x04d1), top: B:287:0x03a9 }] */
    /* JADX WARN: Removed duplicated region for block: B:247:0x04e8  */
    /* JADX WARN: Removed duplicated region for block: B:298:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00fc  */
    @Override // android.app.IntentService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onHandleIntent(final android.content.Intent r25) {
        /*
            Method dump skipped, instruction units count: 1437
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: no.nordicsemi.android.dfu.DfuBaseService.onHandleIntent(android.content.Intent):void");
    }

    @Override // android.app.Service
    public void onTaskRemoved(final Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
        ((NotificationManager) getSystemService("notification")).cancel(NOTIFICATION_ID);
        stopSelf();
    }

    public void refreshDeviceCache(final BluetoothGatt gatt, final boolean force) {
        if (force || gatt.getDevice().getBondState() == 10) {
            sendLogBroadcast(0, "gatt.refresh() (hidden)");
            try {
                logi("Refreshing result: " + ((Boolean) gatt.getClass().getMethod("refresh", new Class[0]).invoke(gatt, new Object[0])).booleanValue());
            } catch (Exception e10) {
                loge("An exception occurred while refreshing device", e10);
                sendLogBroadcast(15, "Refreshing failed");
            }
        }
    }

    public void sendLogBroadcast(final int level, final String message) {
        Intent intent = new Intent(BROADCAST_LOG);
        intent.putExtra(EXTRA_LOG_MESSAGE, "[DFU] " + message);
        intent.putExtra(EXTRA_LOG_LEVEL, level);
        intent.putExtra(EXTRA_DEVICE_ADDRESS, this.mDeviceAddress);
        a.b(this).d(intent);
    }

    public void terminateConnection(@n0 final BluetoothGatt gatt, final int error) {
        if (this.mConnectionState != 0) {
            disconnect(gatt);
        }
        refreshDeviceCache(gatt, false);
        close(gatt);
        waitFor(600);
        if (error != 0) {
            report(error);
        }
    }

    public void updateErrorNotification(@n0 final v.n builder) {
    }

    public void updateForegroundNotification(@n0 final v.n builder) {
    }

    @Override // no.nordicsemi.android.dfu.DfuProgressInfo.ProgressListener
    public void updateProgressNotification() {
        DfuProgressInfo dfuProgressInfo = this.mProgressInfo;
        int progress = dfuProgressInfo.getProgress();
        if (this.mLastProgress == progress) {
            return;
        }
        this.mLastProgress = progress;
        sendProgressBroadcast(dfuProgressInfo);
        if (this.mDisableNotification) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime - this.mLastNotificationTime >= 250 || -6 == progress || -7 == progress) {
            this.mLastNotificationTime = jElapsedRealtime;
            String str = this.mDeviceAddress;
            String string = this.mDeviceName;
            if (string == null) {
                string = getString(R.string.dfu_unknown_name);
            }
            v.n nVarJ0 = new v.n(this, "dfu").t0(android.R.drawable.stat_sys_upload).j0(true);
            nVarJ0.J(-7829368);
            switch (progress) {
                case -7:
                    nVarJ0.i0(false).P(getString(R.string.dfu_status_aborted)).t0(android.R.drawable.stat_sys_upload_done).O(getString(R.string.dfu_status_aborted_msg)).D(true);
                    break;
                case -6:
                    nVarJ0.i0(false).P(getString(R.string.dfu_status_completed)).t0(android.R.drawable.stat_sys_upload_done).O(getString(R.string.dfu_status_completed_msg)).D(true).J(-16730086);
                    break;
                case -5:
                    nVarJ0.i0(true).P(getString(R.string.dfu_status_disconnecting)).O(getString(R.string.dfu_status_disconnecting_msg, new Object[]{string})).l0(100, 0, true);
                    break;
                case -4:
                    nVarJ0.i0(true).P(getString(R.string.dfu_status_validating)).O(getString(R.string.dfu_status_validating_msg)).l0(100, 0, true);
                    break;
                case -3:
                    nVarJ0.i0(true).P(getString(R.string.dfu_status_switching_to_dfu)).O(getString(R.string.dfu_status_switching_to_dfu_msg)).l0(100, 0, true);
                    break;
                case -2:
                    nVarJ0.i0(true).P(getString(R.string.dfu_status_starting)).O(getString(R.string.dfu_status_starting_msg)).l0(100, 0, true);
                    break;
                case -1:
                    nVarJ0.i0(true).P(getString(R.string.dfu_status_connecting)).O(getString(R.string.dfu_status_connecting_msg, new Object[]{string})).l0(100, 0, true);
                    break;
                default:
                    nVarJ0.i0(true).P(dfuProgressInfo.getTotalParts() == 1 ? getString(R.string.dfu_status_uploading) : getString(R.string.dfu_status_uploading_part, new Object[]{Integer.valueOf(dfuProgressInfo.getCurrentPart()), Integer.valueOf(dfuProgressInfo.getTotalParts())})).O(getString(R.string.dfu_status_uploading_msg, new Object[]{string})).l0(100, progress, false);
                    break;
            }
            Intent intent = new Intent(this, getNotificationTarget());
            intent.addFlags(268435456);
            intent.putExtra(EXTRA_DEVICE_ADDRESS, str);
            intent.putExtra(EXTRA_DEVICE_NAME, string);
            intent.putExtra(EXTRA_PROGRESS, progress);
            nVarJ0.N(PendingIntent.getActivity(this, 0, intent, 201326592));
            updateProgressNotification(nVarJ0, progress);
            ((NotificationManager) getSystemService("notification")).notify(NOTIFICATION_ID, nVarJ0.h());
        }
    }

    public void waitFor(final int millis) {
        synchronized (this.mLock) {
            try {
                sendLogBroadcast(0, "wait(" + millis + ee.a.f26979d);
                this.mLock.wait((long) millis);
            } catch (InterruptedException e10) {
                loge("Sleeping interrupted", e10);
            }
        }
    }

    public void waitUntilDisconnected() {
        try {
            synchronized (this.mLock) {
                while (this.mConnectionState != 0 && this.mError == 0) {
                    this.mLock.wait();
                }
            }
        } catch (InterruptedException e10) {
            loge("Sleeping interrupted", e10);
        }
    }

    private InputStream openInputStream(@n0 final Uri stream, final String mimeType, final int mbrSize, final int types) throws IOException {
        InputStream inputStreamOpenInputStream = getContentResolver().openInputStream(stream);
        if (MIME_TYPE_ZIP.equals(mimeType)) {
            return new ArchiveInputStream(inputStreamOpenInputStream, mbrSize, types);
        }
        Cursor cursorQuery = getContentResolver().query(stream, new String[]{"_display_name"}, null, null, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToNext() && cursorQuery.getString(0).toLowerCase(Locale.US).endsWith("hex")) {
                    return new HexInputStream(inputStreamOpenInputStream, mbrSize);
                }
            } finally {
                cursorQuery.close();
            }
        }
        return inputStreamOpenInputStream;
    }

    private InputStream openInputStream(final int resId, final String mimeType, final int mbrSize, final int types) throws IOException {
        InputStream inputStreamOpenRawResource = getResources().openRawResource(resId);
        if (MIME_TYPE_ZIP.equals(mimeType)) {
            return new ArchiveInputStream(inputStreamOpenRawResource, mbrSize, types);
        }
        inputStreamOpenRawResource.mark(2);
        int i10 = inputStreamOpenRawResource.read();
        inputStreamOpenRawResource.reset();
        return i10 == 58 ? new HexInputStream(inputStreamOpenRawResource, mbrSize) : inputStreamOpenRawResource;
    }

    public void updateProgressNotification(@n0 final v.n builder, final int progress) {
        if (progress == -7 || progress == -6) {
            return;
        }
        Intent intent = new Intent(BROADCAST_ACTION);
        intent.putExtra(EXTRA_ACTION, 2);
        builder.a(R.drawable.ic_action_notify_cancel, getString(R.string.dfu_action_abort), PendingIntent.getBroadcast(this, 1, intent, 201326592));
    }
}
