package no.nordicsemi.android.error;

import ee.a;
import no.nordicsemi.android.dfu.DfuBaseService;

/* JADX INFO: loaded from: classes5.dex */
public class GattError {
    public static String parse(final int error) {
        if (error == 26) {
            return "HCI ERROR UNSUPPORTED REMOTE FEATURE";
        }
        if (error == 30) {
            return "HCI ERROR INVALID LMP PARAM";
        }
        if (error == 34) {
            return "GATT CONN LMP TIMEOUT";
        }
        if (error == 42) {
            return "HCI ERROR DIFF TRANSACTION COLLISION";
        }
        if (error == 257) {
            return "TOO MANY OPEN CONNECTIONS";
        }
        if (error == 58) {
            return "GATT CONTROLLER BUSY";
        }
        if (error == 59) {
            return "GATT UNACCEPT CONN INTERVAL";
        }
        switch (error) {
            case 1:
                return "GATT INVALID HANDLE";
            case 2:
                return "GATT READ NOT PERMIT";
            case 3:
                return "GATT WRITE NOT PERMIT";
            case 4:
                return "GATT INVALID PDU";
            case 5:
                return "GATT INSUF AUTHENTICATION";
            case 6:
                return "GATT REQ NOT SUPPORTED";
            case 7:
                return "GATT INVALID OFFSET";
            case 8:
                return "GATT INSUF AUTHORIZATION";
            case 9:
                return "GATT PREPARE Q FULL";
            case 10:
                return "GATT NOT FOUND";
            case 11:
                return "GATT NOT LONG";
            case 12:
                return "GATT INSUF KEY SIZE";
            case 13:
                return "GATT INVALID ATTR LEN";
            case 14:
                return "GATT ERR UNLIKELY";
            case 15:
                return "GATT INSUF ENCRYPTION";
            case 16:
                return "GATT UNSUPPORT GRP TYPE";
            case 17:
                return "GATT INSUF RESOURCE";
            default:
                switch (error) {
                    case 128:
                        return "GATT NO RESOURCES";
                    case 129:
                        return "GATT INTERNAL ERROR";
                    case 130:
                        return "GATT WRONG STATE";
                    case 131:
                        return "GATT DB FULL";
                    case 132:
                        return "GATT BUSY";
                    case 133:
                        return "GATT ERROR";
                    case 134:
                        return "GATT CMD STARTED";
                    case 135:
                        return "GATT ILLEGAL PARAMETER";
                    case 136:
                        return "GATT PENDING";
                    case 137:
                        return "GATT AUTH FAIL";
                    case 138:
                        return "GATT MORE";
                    case 139:
                        return "GATT INVALID CFG";
                    case 140:
                        return "GATT SERVICE STARTED";
                    case 141:
                        return "GATT ENCRYPTED NO MITM";
                    case 142:
                        return "GATT NOT ENCRYPTED";
                    case 143:
                        return "GATT CONGESTED";
                    default:
                        switch (error) {
                            case 253:
                                return "GATT CCCD CFG ERROR";
                            case 254:
                                return "GATT PROCEDURE IN PROGRESS";
                            case 255:
                                return "GATT VALUE OUT OF RANGE";
                            default:
                                switch (error) {
                                    case 4096:
                                        return "DFU DEVICE DISCONNECTED";
                                    case 4097:
                                        return "DFU FILE NOT FOUND";
                                    case 4098:
                                        return "DFU FILE ERROR";
                                    case 4099:
                                        return "DFU NOT A VALID HEX FILE";
                                    case 4100:
                                        return "DFU IO EXCEPTION";
                                    case 4101:
                                        return "DFU SERVICE DISCOVERY NOT STARTED";
                                    case 4102:
                                        return "DFU CHARACTERISTICS NOT FOUND";
                                    default:
                                        switch (error) {
                                            case 4104:
                                                return "DFU INVALID RESPONSE";
                                            case 4105:
                                                return "DFU FILE TYPE NOT SUPPORTED";
                                            case 4106:
                                                return "BLUETOOTH ADAPTER DISABLED";
                                            case DfuBaseService.ERROR_INIT_PACKET_REQUIRED /* 4107 */:
                                            case DfuBaseService.ERROR_FILE_SIZE_INVALID /* 4108 */:
                                                return "DFU INIT PACKET REQUIRED";
                                            case DfuBaseService.ERROR_CRC_ERROR /* 4109 */:
                                                return "DFU CRC ERROR";
                                            case DfuBaseService.ERROR_DEVICE_NOT_BONDED /* 4110 */:
                                                return "DFU DEVICE NOT BONDED";
                                            default:
                                                return "UNKNOWN (" + error + a.f26979d;
                                        }
                                }
                        }
                }
        }
    }

    public static String parseConnectionError(final int error) {
        if (error == 0) {
            return "SUCCESS";
        }
        if (error == 1) {
            return "GATT CONN L2C FAILURE";
        }
        if (error == 8) {
            return "GATT CONN TIMEOUT";
        }
        if (error == 19) {
            return "GATT CONN TERMINATE PEER USER";
        }
        if (error == 22) {
            return "GATT CONN TERMINATE LOCAL HOST";
        }
        if (error == 34) {
            return "GATT CONN LMP TIMEOUT";
        }
        if (error == 62) {
            return "GATT CONN FAIL ESTABLISH";
        }
        if (error == 133) {
            return "GATT ERROR";
        }
        if (error == 256) {
            return "GATT CONN CANCEL ";
        }
        return "UNKNOWN (" + error + a.f26979d;
    }

    public static String parseDfuRemoteError(final int error) {
        int i10 = error & 3840;
        if (i10 == 256) {
            return LegacyDfuError.parse(error);
        }
        if (i10 == 512) {
            return SecureDfuError.parse(error);
        }
        if (i10 == 1024) {
            return SecureDfuError.parseExtendedError(error);
        }
        if (i10 == 2048) {
            return SecureDfuError.parseButtonlessError(error);
        }
        return "UNKNOWN (" + error + a.f26979d;
    }
}
