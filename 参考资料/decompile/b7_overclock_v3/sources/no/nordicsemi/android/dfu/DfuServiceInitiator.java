package no.nordicsemi.android.dfu;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelUuid;
import android.os.Parcelable;
import g.f0;
import g.n0;
import g.p0;
import g.u0;
import g.v0;
import gg.b;
import java.security.InvalidParameterException;
import java.util.UUID;

/* JADX INFO: loaded from: classes5.dex */
public final class DfuServiceInitiator {
    public static final int DEFAULT_MBR_SIZE = 4096;
    public static final int DEFAULT_PRN_VALUE = 12;
    public static final int SCOPE_APPLICATION = 2;
    public static final int SCOPE_SYSTEM_COMPONENTS = 1;
    private Parcelable[] buttonlessDfuWithBondSharingUuids;
    private Parcelable[] buttonlessDfuWithoutBondSharingUuids;
    private final String deviceAddress;
    private String deviceName;
    private Parcelable[] experimentalButtonlessDfuUuids;
    private String filePath;
    private int fileResId;
    private Uri fileUri;
    private String initFilePath;
    private int initFileResId;
    private Uri initFileUri;
    private boolean keepBond;
    private Parcelable[] legacyDfuUuids;
    private String mimeType;
    private Boolean packetReceiptNotificationsEnabled;
    private boolean restoreBond;
    private Parcelable[] secureDfuUuids;
    private boolean disableNotification = false;
    private boolean startAsForegroundService = true;
    private int fileType = -1;
    private boolean forceDfu = false;
    private boolean enableUnsafeExperimentalButtonlessDfu = false;
    private boolean disableResume = false;
    private int numberOfRetries = 0;
    private int mbrSize = 4096;
    private int numberOfPackets = 12;
    private int mtu = b.f29422c0;
    private int currentMtu = 23;

    public DfuServiceInitiator(@n0 final String deviceAddress) {
        this.deviceAddress = deviceAddress;
    }

    @v0(api = 26)
    public static void createDfuNotificationChannel(@n0 final Context context) {
        NotificationChannel notificationChannel = new NotificationChannel("dfu", context.getString(R.string.dfu_channel_name), 2);
        notificationChannel.setDescription(context.getString(R.string.dfu_channel_description));
        notificationChannel.setShowBadge(false);
        notificationChannel.setLockscreenVisibility(1);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (notificationManager != null) {
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    private DfuServiceInitiator init(@p0 final Uri initFileUri, @p0 final String initFilePath, @u0 final int initFileResId) {
        if (DfuBaseService.MIME_TYPE_ZIP.equals(this.mimeType)) {
            throw new InvalidParameterException("Init file must be located inside the ZIP");
        }
        this.initFileUri = initFileUri;
        this.initFilePath = initFilePath;
        this.initFileResId = initFileResId;
        return this;
    }

    public DfuServiceInitiator disableMtuRequest() {
        this.mtu = 0;
        return this;
    }

    public DfuServiceInitiator disableResume() {
        this.disableResume = true;
        return this;
    }

    @Deprecated
    public DfuServiceInitiator setBinOrHex(@FileType final int fileType, @n0 final Uri uri) {
        if (fileType != 0) {
            return init(uri, null, 0, fileType, DfuBaseService.MIME_TYPE_OCTET_STREAM);
        }
        throw new UnsupportedOperationException("You must specify the file type");
    }

    public DfuServiceInitiator setCurrentMtu(@f0(from = 23, to = 517) final int mtu) {
        this.currentMtu = mtu;
        return this;
    }

    public DfuServiceInitiator setCustomUuidsForButtonlessDfuWithBondSharing(@p0 final UUID buttonlessDfuServiceUuid, @p0 final UUID buttonlessDfuControlPointUuid) {
        ParcelUuid[] parcelUuidArr = new ParcelUuid[2];
        parcelUuidArr[0] = buttonlessDfuServiceUuid != null ? new ParcelUuid(buttonlessDfuServiceUuid) : null;
        parcelUuidArr[1] = buttonlessDfuControlPointUuid != null ? new ParcelUuid(buttonlessDfuControlPointUuid) : null;
        this.buttonlessDfuWithBondSharingUuids = parcelUuidArr;
        return this;
    }

    public DfuServiceInitiator setCustomUuidsForButtonlessDfuWithoutBondSharing(@p0 final UUID buttonlessDfuServiceUuid, @p0 final UUID buttonlessDfuControlPointUuid) {
        ParcelUuid[] parcelUuidArr = new ParcelUuid[2];
        parcelUuidArr[0] = buttonlessDfuServiceUuid != null ? new ParcelUuid(buttonlessDfuServiceUuid) : null;
        parcelUuidArr[1] = buttonlessDfuControlPointUuid != null ? new ParcelUuid(buttonlessDfuControlPointUuid) : null;
        this.buttonlessDfuWithoutBondSharingUuids = parcelUuidArr;
        return this;
    }

    public DfuServiceInitiator setCustomUuidsForExperimentalButtonlessDfu(@p0 final UUID buttonlessDfuServiceUuid, @p0 final UUID buttonlessDfuControlPointUuid) {
        ParcelUuid[] parcelUuidArr = new ParcelUuid[2];
        parcelUuidArr[0] = buttonlessDfuServiceUuid != null ? new ParcelUuid(buttonlessDfuServiceUuid) : null;
        parcelUuidArr[1] = buttonlessDfuControlPointUuid != null ? new ParcelUuid(buttonlessDfuControlPointUuid) : null;
        this.experimentalButtonlessDfuUuids = parcelUuidArr;
        return this;
    }

    public DfuServiceInitiator setCustomUuidsForLegacyDfu(@p0 final UUID dfuServiceUuid, @p0 final UUID dfuControlPointUuid, @p0 final UUID dfuPacketUuid, @p0 final UUID dfuVersionUuid) {
        ParcelUuid[] parcelUuidArr = new ParcelUuid[4];
        parcelUuidArr[0] = dfuServiceUuid != null ? new ParcelUuid(dfuServiceUuid) : null;
        parcelUuidArr[1] = dfuControlPointUuid != null ? new ParcelUuid(dfuControlPointUuid) : null;
        parcelUuidArr[2] = dfuPacketUuid != null ? new ParcelUuid(dfuPacketUuid) : null;
        parcelUuidArr[3] = dfuVersionUuid != null ? new ParcelUuid(dfuVersionUuid) : null;
        this.legacyDfuUuids = parcelUuidArr;
        return this;
    }

    public DfuServiceInitiator setCustomUuidsForSecureDfu(@p0 final UUID dfuServiceUuid, @p0 final UUID dfuControlPointUuid, @p0 final UUID dfuPacketUuid) {
        ParcelUuid[] parcelUuidArr = new ParcelUuid[3];
        parcelUuidArr[0] = dfuServiceUuid != null ? new ParcelUuid(dfuServiceUuid) : null;
        parcelUuidArr[1] = dfuControlPointUuid != null ? new ParcelUuid(dfuControlPointUuid) : null;
        parcelUuidArr[2] = dfuPacketUuid != null ? new ParcelUuid(dfuPacketUuid) : null;
        this.secureDfuUuids = parcelUuidArr;
        return this;
    }

    public DfuServiceInitiator setDeviceName(@p0 final String name) {
        this.deviceName = name;
        return this;
    }

    public DfuServiceInitiator setDisableNotification(final boolean disableNotification) {
        this.disableNotification = disableNotification;
        return this;
    }

    public DfuServiceInitiator setForceDfu(final boolean force) {
        this.forceDfu = force;
        return this;
    }

    public DfuServiceInitiator setForeground(final boolean foreground) {
        this.startAsForegroundService = foreground;
        return this;
    }

    @Deprecated
    public DfuServiceInitiator setInitFile(@n0 final Uri initFileUri) {
        return init(initFileUri, null, 0);
    }

    public DfuServiceInitiator setKeepBond(final boolean keepBond) {
        this.keepBond = keepBond;
        return this;
    }

    public DfuServiceInitiator setMbrSize(@f0(from = 0) final int mbrSize) {
        this.mbrSize = mbrSize;
        return this;
    }

    public DfuServiceInitiator setMtu(@f0(from = 23, to = 517) final int mtu) {
        this.mtu = mtu;
        return this;
    }

    public DfuServiceInitiator setNumberOfRetries(@f0(from = 0) final int max) {
        this.numberOfRetries = max;
        return this;
    }

    public DfuServiceInitiator setPacketsReceiptNotificationsEnabled(final boolean enabled) {
        this.packetReceiptNotificationsEnabled = Boolean.valueOf(enabled);
        return this;
    }

    public DfuServiceInitiator setPacketsReceiptNotificationsValue(@f0(from = 0) final int number) {
        if (number <= 0) {
            number = 12;
        }
        this.numberOfPackets = number;
        return this;
    }

    public DfuServiceInitiator setRestoreBond(final boolean restoreBond) {
        this.restoreBond = restoreBond;
        return this;
    }

    public DfuServiceInitiator setScope(@DfuScope final int scope) {
        if (!DfuBaseService.MIME_TYPE_ZIP.equals(this.mimeType)) {
            throw new UnsupportedOperationException("Scope can be set only for a ZIP file");
        }
        if (scope == 2) {
            this.fileType = 4;
        } else if (scope == 1) {
            this.fileType = 3;
        } else {
            if (scope != 3) {
                throw new UnsupportedOperationException("Unknown scope");
            }
            this.fileType = 0;
        }
        return this;
    }

    public DfuServiceInitiator setUnsafeExperimentalButtonlessServiceInSecureDfuEnabled(final boolean enable) {
        this.enableUnsafeExperimentalButtonlessDfu = enable;
        return this;
    }

    public DfuServiceInitiator setZip(@n0 final Uri uri) {
        return init(uri, null, 0, 0, DfuBaseService.MIME_TYPE_ZIP);
    }

    public DfuServiceController start(@n0 final Context context, @n0 final Class<? extends DfuBaseService> service) {
        if (this.fileType == -1) {
            throw new UnsupportedOperationException("You must specify the firmware file before starting the service");
        }
        Intent intent = new Intent(context, service);
        intent.putExtra(DfuBaseService.EXTRA_DEVICE_ADDRESS, this.deviceAddress);
        intent.putExtra(DfuBaseService.EXTRA_DEVICE_NAME, this.deviceName);
        intent.putExtra(DfuBaseService.EXTRA_DISABLE_NOTIFICATION, this.disableNotification);
        intent.putExtra(DfuBaseService.EXTRA_FOREGROUND_SERVICE, this.startAsForegroundService);
        intent.putExtra(DfuBaseService.EXTRA_FILE_MIME_TYPE, this.mimeType);
        intent.putExtra(DfuBaseService.EXTRA_FILE_TYPE, this.fileType);
        intent.putExtra(DfuBaseService.EXTRA_FILE_URI, this.fileUri);
        intent.putExtra(DfuBaseService.EXTRA_FILE_PATH, this.filePath);
        intent.putExtra(DfuBaseService.EXTRA_FILE_RES_ID, this.fileResId);
        intent.putExtra(DfuBaseService.EXTRA_INIT_FILE_URI, this.initFileUri);
        intent.putExtra(DfuBaseService.EXTRA_INIT_FILE_PATH, this.initFilePath);
        intent.putExtra(DfuBaseService.EXTRA_INIT_FILE_RES_ID, this.initFileResId);
        intent.putExtra(DfuBaseService.EXTRA_KEEP_BOND, this.keepBond);
        intent.putExtra(DfuBaseService.EXTRA_RESTORE_BOND, this.restoreBond);
        intent.putExtra(DfuBaseService.EXTRA_FORCE_DFU, this.forceDfu);
        intent.putExtra(DfuBaseService.EXTRA_DISABLE_RESUME, this.disableResume);
        intent.putExtra(DfuBaseService.EXTRA_MAX_DFU_ATTEMPTS, this.numberOfRetries);
        intent.putExtra(DfuBaseService.EXTRA_MBR_SIZE, this.mbrSize);
        int i10 = this.mtu;
        if (i10 > 0) {
            intent.putExtra(DfuBaseService.EXTRA_MTU, i10);
        }
        intent.putExtra(DfuBaseService.EXTRA_CURRENT_MTU, this.currentMtu);
        intent.putExtra(DfuBaseService.EXTRA_UNSAFE_EXPERIMENTAL_BUTTONLESS_DFU, this.enableUnsafeExperimentalButtonlessDfu);
        Boolean bool = this.packetReceiptNotificationsEnabled;
        if (bool != null) {
            intent.putExtra(DfuBaseService.EXTRA_PACKET_RECEIPT_NOTIFICATIONS_ENABLED, bool);
            intent.putExtra(DfuBaseService.EXTRA_PACKET_RECEIPT_NOTIFICATIONS_VALUE, this.numberOfPackets);
        }
        Parcelable[] parcelableArr = this.legacyDfuUuids;
        if (parcelableArr != null) {
            intent.putExtra(DfuBaseService.EXTRA_CUSTOM_UUIDS_FOR_LEGACY_DFU, parcelableArr);
        }
        Parcelable[] parcelableArr2 = this.secureDfuUuids;
        if (parcelableArr2 != null) {
            intent.putExtra(DfuBaseService.EXTRA_CUSTOM_UUIDS_FOR_SECURE_DFU, parcelableArr2);
        }
        Parcelable[] parcelableArr3 = this.experimentalButtonlessDfuUuids;
        if (parcelableArr3 != null) {
            intent.putExtra(DfuBaseService.EXTRA_CUSTOM_UUIDS_FOR_EXPERIMENTAL_BUTTONLESS_DFU, parcelableArr3);
        }
        Parcelable[] parcelableArr4 = this.buttonlessDfuWithoutBondSharingUuids;
        if (parcelableArr4 != null) {
            intent.putExtra(DfuBaseService.EXTRA_CUSTOM_UUIDS_FOR_BUTTONLESS_DFU_WITHOUT_BOND_SHARING, parcelableArr4);
        }
        Parcelable[] parcelableArr5 = this.buttonlessDfuWithBondSharingUuids;
        if (parcelableArr5 != null) {
            intent.putExtra(DfuBaseService.EXTRA_CUSTOM_UUIDS_FOR_BUTTONLESS_DFU_WITH_BOND_SHARING, parcelableArr5);
        }
        if (Build.VERSION.SDK_INT < 26 || !this.startAsForegroundService) {
            context.startService(intent);
        } else {
            context.startForegroundService(intent);
        }
        return new DfuServiceController(context);
    }

    @Deprecated
    public DfuServiceInitiator setInitFile(@p0 final String initFilePath) {
        return init(null, initFilePath, 0);
    }

    public DfuServiceInitiator setZip(@n0 final String path) {
        return init(null, path, 0, 0, DfuBaseService.MIME_TYPE_ZIP);
    }

    @Deprecated
    public DfuServiceInitiator setBinOrHex(@FileType final int fileType, @n0 final String path) {
        if (fileType != 0) {
            return init(null, path, 0, fileType, DfuBaseService.MIME_TYPE_OCTET_STREAM);
        }
        throw new UnsupportedOperationException("You must specify the file type");
    }

    @Deprecated
    public DfuServiceInitiator setInitFile(@u0 final int initFileResId) {
        return init(null, null, initFileResId);
    }

    public DfuServiceInitiator setZip(@u0 final int rawResId) {
        return init(null, null, rawResId, 0, DfuBaseService.MIME_TYPE_ZIP);
    }

    @Deprecated
    public DfuServiceInitiator setInitFile(@p0 final Uri initFileUri, @p0 final String initFilePath) {
        return init(initFileUri, initFilePath, 0);
    }

    public DfuServiceInitiator setZip(@p0 final Uri uri, @p0 final String path) {
        return init(uri, path, 0, 0, DfuBaseService.MIME_TYPE_ZIP);
    }

    @Deprecated
    public DfuServiceInitiator setBinOrHex(@FileType final int fileType, @p0 final Uri uri, @p0 final String path) {
        if (fileType != 0) {
            return init(uri, path, 0, fileType, DfuBaseService.MIME_TYPE_OCTET_STREAM);
        }
        throw new UnsupportedOperationException("You must specify the file type");
    }

    private DfuServiceInitiator init(@p0 final Uri fileUri, @p0 final String filePath, @u0 final int fileResId, @FileType final int fileType, @n0 final String mimeType) {
        this.fileUri = fileUri;
        this.filePath = filePath;
        this.fileResId = fileResId;
        this.fileType = fileType;
        this.mimeType = mimeType;
        if (DfuBaseService.MIME_TYPE_ZIP.equals(mimeType)) {
            this.initFileUri = null;
            this.initFilePath = null;
            this.initFileResId = 0;
        }
        return this;
    }

    @Deprecated
    public DfuServiceInitiator setBinOrHex(@FileType final int fileType, @u0 final int rawResId) {
        if (fileType != 0) {
            return init(null, null, rawResId, fileType, DfuBaseService.MIME_TYPE_OCTET_STREAM);
        }
        throw new UnsupportedOperationException("You must specify the file type");
    }
}
