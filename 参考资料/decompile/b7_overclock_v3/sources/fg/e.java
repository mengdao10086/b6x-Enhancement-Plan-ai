package fg;

/* JADX INFO: loaded from: classes5.dex */
public final class e {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f28239a = 1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f28240b = 2;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f28241c = 3;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f28242d = 4;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f28243e = 5;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f28244f = 6;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f28245g = 7;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f28246h = 8;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f28247i = 9;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final int f28248j = 10;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final int f28249k = 11;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final int f28250l = 12;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final int f28251m = 13;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final int f28252n = 14;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final int f28253o = 15;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final int f28254p = 16;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final int f28255q = 17;

        public static String a(int i10, boolean z10) {
            String str;
            String str2;
            String str3 = "";
            switch (i10) {
                case 1:
                    str = "INVALID_HANDLE";
                    str2 = "The attribute handle given was not valid on this server.";
                    break;
                case 2:
                    str = "READ_NOT_PERMITTED";
                    str2 = "The attribute cannot be read.";
                    break;
                case 3:
                    str = "WRITE_NOT_PERMITTED";
                    str2 = "The attribute cannot be written.";
                    break;
                case 4:
                    str = "INVALID_PDU";
                    str2 = "The attribute PDU was invalid.";
                    break;
                case 5:
                    str = "INSUFFICIENT_AUTHENTICATION";
                    str2 = "The attribute requires authentication before it can be read or written.";
                    break;
                case 6:
                    str = "REQUEST_NOT_SUPPORTED";
                    str2 = "Attribute server does not support the request received from the client.";
                    break;
                case 7:
                    str = "INVALID_OFFSET";
                    str2 = "Offset specified was past the end of the attribute.";
                    break;
                case 8:
                    str = "INSUFFICIENT_AUTHORIZATION";
                    str2 = "The attribute requires authorization before it can be read or written.";
                    break;
                case 9:
                    str = "PREPARE_QUEUE_FULL";
                    str2 = "Too many prepare writes have been queued.";
                    break;
                case 10:
                    str = "ATTRIBUTE_NOT_FOUND";
                    str2 = "No attribute found within the given attribute handle range.";
                    break;
                case 11:
                    str = "ATTRIBUTE_NOT_LONG";
                    str2 = "The attribute cannot be read using the Read Blob Request.";
                    break;
                case 12:
                    str = "INSUFFICIENT_ENCRYPTION_KEY_SIZE";
                    str2 = "The Encryption Key Size used for encrypting this link is insufficient.";
                    break;
                case 13:
                    str = "INVALID_ATTRIBUTE_VALUE_LENGTH";
                    str2 = "The attribute value length is invalid for the operation.";
                    break;
                case 14:
                    str = "UNLIKELY_ERROR";
                    str2 = "The attribute request that was requested has encountered an error that was unlikely, and therefore could not be completed as requested.";
                    break;
                case 15:
                    str = "INSUFFICIENT_ENCRYPTION";
                    str2 = "The attribute requires encryption before it can be read or written.";
                    break;
                case 16:
                    str = "UNSUPPORTED_GROUP_TYPE";
                    str2 = "The attribute type is not a supported grouping attribute as defined by a higher layer specification.";
                    break;
                case 17:
                    str = "INSUFFICIENT_RESOURCES";
                    str2 = "Insufficient Resources to complete the request.";
                    break;
                default:
                    str = "";
                    str2 = str;
                    break;
            }
            if (str.length() <= 0) {
                return "";
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            if (z10 && str2.length() > 0) {
                str3 = ": " + str2;
            }
            sb2.append(str3);
            return sb2.toString();
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f28256a = 128;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f28257b = 129;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f28258c = 130;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f28259d = 131;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f28260e = 132;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f28261f = 133;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f28262g = 134;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f28263h = 135;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f28264i = 136;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final int f28265j = 137;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final int f28266k = 138;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final int f28267l = 139;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final int f28268m = 140;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final int f28269n = 141;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final int f28270o = 142;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final int f28271p = 253;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final int f28272q = 254;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final int f28273r = 255;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final int f28274s = 256;

        public static String a(int i10, boolean z10) {
            String str;
            String str2;
            String str3 = "";
            switch (i10) {
                case 128:
                    str = "GATT_NO_RESOURCES";
                    str2 = "";
                    break;
                case 129:
                    str = "GATT_INTERNAL_ERROR";
                    str2 = "";
                    break;
                case 130:
                    str = "GATT_WRONG_STATE";
                    str2 = "";
                    break;
                case 131:
                    str = "GATT_DB_FULL";
                    str2 = "";
                    break;
                case 132:
                    str = "GATT_BUSY";
                    str2 = "";
                    break;
                case 133:
                    str = "GATT_ERROR";
                    str2 = "";
                    break;
                case 134:
                    str = "GATT_CMD_STARTED";
                    str2 = "";
                    break;
                case 135:
                    str = "GATT_ILLEGAL_PARAMETER";
                    str2 = "";
                    break;
                case 136:
                    str = "GATT_PENDING";
                    str2 = "";
                    break;
                case 137:
                    str = "GATT_AUTH_FAIL";
                    str2 = "";
                    break;
                case 138:
                    str = "GATT_MORE";
                    str2 = "";
                    break;
                case 139:
                    str = "GATT_INVALID_CFG";
                    str2 = "";
                    break;
                case 140:
                    str = "GATT_SERVICE_STARTED";
                    str2 = "";
                    break;
                case 141:
                    str = "GATT_ENCRYPED_NO_MITM";
                    str2 = "";
                    break;
                case 142:
                    str = "GATT_NOT_ENCRYPTED";
                    str2 = "";
                    break;
                default:
                    switch (i10) {
                        case 253:
                            str = "GATT_CCC_CFG_ERR";
                            str2 = "Client Characteristic Configuration Descriptor improperly configured.";
                            break;
                        case 254:
                            str = "GATT_PRC_IN_PROGRESS or L2CAP_CONN_AMP_FAILED from l2cdefs.h";
                            str2 = "Procedure already in progress for GATT_PRC_IN_PROGRESS.";
                            break;
                        case 255:
                            str = "GATT_OUT_OF_RANGE or L2CAP_CONN_NO_LINK from l2cdefs.h";
                            str2 = "Attribute value out of range for GATT_OUT_OF_RANGE.";
                            break;
                        case 256:
                            str = "L2CAP_CONN_CANCEL";
                            str2 = "L2CAP connection cancelled";
                            break;
                        default:
                            str = "";
                            str2 = str;
                            break;
                    }
                    break;
            }
            if (str.length() <= 0) {
                return "";
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            if (z10 && str2.length() > 0) {
                str3 = ": " + str2;
            }
            sb2.append(str3);
            return sb2.toString();
        }
    }

    public static class c {
        public static final int A = 26;
        public static final int B = 27;
        public static final int C = 28;
        public static final int D = 29;
        public static final int E = 30;
        public static final int F = 31;
        public static final int G = 32;
        public static final int H = 33;
        public static final int I = 34;
        public static final int J = 35;
        public static final int K = 36;
        public static final int L = 37;
        public static final int M = 38;
        public static final int N = 39;
        public static final int O = 40;
        public static final int P = 41;
        public static final int Q = 42;
        public static final int R = 44;
        public static final int S = 45;
        public static final int T = 46;
        public static final int U = 47;
        public static final int V = 48;
        public static final int W = 50;
        public static final int X = 52;
        public static final int Y = 53;
        public static final int Z = 54;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f28275a = 0;

        /* JADX INFO: renamed from: a0, reason: collision with root package name */
        public static final int f28276a0 = 55;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f28277b = 1;

        /* JADX INFO: renamed from: b0, reason: collision with root package name */
        public static final int f28278b0 = 56;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f28279c = 2;

        /* JADX INFO: renamed from: c0, reason: collision with root package name */
        public static final int f28280c0 = 57;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f28281d = 3;

        /* JADX INFO: renamed from: d0, reason: collision with root package name */
        public static final int f28282d0 = 58;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f28283e = 4;

        /* JADX INFO: renamed from: e0, reason: collision with root package name */
        public static final int f28284e0 = 59;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f28285f = 5;

        /* JADX INFO: renamed from: f0, reason: collision with root package name */
        public static final int f28286f0 = 60;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f28287g = 6;

        /* JADX INFO: renamed from: g0, reason: collision with root package name */
        public static final int f28288g0 = 61;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f28289h = 7;

        /* JADX INFO: renamed from: h0, reason: collision with root package name */
        public static final int f28290h0 = 62;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f28291i = 8;

        /* JADX INFO: renamed from: i0, reason: collision with root package name */
        public static final int f28292i0 = 63;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final int f28293j = 9;

        /* JADX INFO: renamed from: j0, reason: collision with root package name */
        public static final int f28294j0 = 64;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final int f28295k = 10;

        /* JADX INFO: renamed from: k0, reason: collision with root package name */
        public static final int f28296k0 = 65;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final int f28297l = 11;

        /* JADX INFO: renamed from: l0, reason: collision with root package name */
        public static final int f28298l0 = 66;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final int f28299m = 12;

        /* JADX INFO: renamed from: m0, reason: collision with root package name */
        public static final int f28300m0 = 67;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final int f28301n = 13;

        /* JADX INFO: renamed from: n0, reason: collision with root package name */
        public static final int f28302n0 = 68;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final int f28303o = 14;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final int f28304p = 15;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final int f28305q = 16;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final int f28306r = 17;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final int f28307s = 18;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static final int f28308t = 19;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public static final int f28309u = 20;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public static final int f28310v = 21;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public static final int f28311w = 22;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public static final int f28312x = 23;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public static final int f28313y = 24;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public static final int f28314z = 25;

        public static String a(int i10, boolean z10) {
            String str;
            String str2 = "REMOTE_USER_TERMINATED_CONNECTION";
            String str3 = "";
            switch (i10) {
                case 0:
                    str2 = "SUCCESS";
                    str = "";
                    break;
                case 1:
                    str2 = "UNKNOWN_HCI_COMMAND";
                    str = "The Unknown HCI Command error code indicates that the Controller does not understand the HCI Command Packet OpCode that the Host sent. The OpCode given might not correspond to any of the OpCodes specified in this document, or any vendor-specific OpCodes, or the command may have not been implemented.";
                    break;
                case 2:
                    str2 = "UNKNOWN_CONNECTION_IDENTIFIER";
                    str = "The Unknown Connection Identifier error code indicates that a command was sent from the Host that should identify a connection, but that connection does not exist.";
                    break;
                case 3:
                    str2 = "HARDWARE_FAILURE";
                    str = "The Hardware Failure error code indicates to the Host that something in the Controller has failed in a manner that cannot be described with any other error code. The meaning implied with this error code is implementation dependent.";
                    break;
                case 4:
                    str2 = "PAGE_TIMEOUT";
                    str = "The Page Timeout error code indicates that a page timed out because of the Page Timeout configuration parameter. This error code may occur only with the Remote_Name_Request and Create_Connection commands.";
                    break;
                case 5:
                    str2 = "AUTHENTICATION_FAILURE";
                    str = "The Authentication Failure error code indicates that pairing or authentication failed due to incorrect results in the pairing or authentication procedure. This could be due to an incorrect PIN or Link Key.";
                    break;
                case 6:
                    str2 = "PIN_OR_KEY_MISSING";
                    str = "The PIN or Key Missing error code is used when pairing failed because of a missing PIN, or authentication failed because of a missing Key.";
                    break;
                case 7:
                    str2 = "MEMORY_CAPACITY_EXCEEDED";
                    str = "The Memory Capacity Exceeded error code indicates to the Host that the Controller has run out of memory to store new parameters.";
                    break;
                case 8:
                    str2 = "CONNECTION_TIMEOUT";
                    str = "The Connection Timeout error code indicates that the link supervision timeout has expired for a given connection.";
                    break;
                case 9:
                    str2 = "CONNECTION_LIMIT_EXCEEDED";
                    str = "The Connection Limit Exceeded error code indicates that an attempt to create another connection failed because the Controller is already at its limit of the number of connections it can support. The number of connections a device can support is implementation dependent.";
                    break;
                case 10:
                    str2 = "SYNCHRONOUS_CONNECTION_LIMIT_TO_A_DEVICE_EXCEEDED";
                    str = "The Synchronous Connection Limit to a Device Exceeded error code indicates that the Controller has reached the limit to the number of synchronous connections that can be achieved to a device. The number of synchronous connections a device can support is implementation dependent.";
                    break;
                case 11:
                    str2 = "CONNECTION_ALREADY_EXISTS";
                    str = "The Connection Already Exists error code indicates that an attempt was made to create a new Connection to a device when there is already a connection to this device and multiple connections to the same device are not permitted.";
                    break;
                case 12:
                    str2 = "COMMAND_DISALLOWED";
                    str = "The Command Disallowed error code indicates that the command requested cannot be executed because the Controller is in a state where it cannot process this command at this time. This error shall not be used for command OpCodes where the error code Unknown HCI Command is valid.";
                    break;
                case 13:
                    str2 = "CONNECTION_REJECTED_LIMITED_RESOURCES";
                    str = "The Connection Rejected Due To Limited Resources error code indicates that a connection was rejected due to limited resources.";
                    break;
                case 14:
                    str2 = "CONNECTION_REJECTED_SECURITY_REASONS";
                    str = "The Connection Rejected Due To Security Reasons error code indicates that a connection was rejected due to security requirements not being fulfilled, like authentication or pairing.";
                    break;
                case 15:
                    str2 = "CONNECTION_REJECTED_UNACCEPTABLE_BD_ADDR";
                    str = "The Connection Rejected due to Unacceptable BD_ADDR error code indicates that a connection was rejected because this device does not accept the BD_ADDR. This may be because the device will only accept connections from specific BD_ADDRs.";
                    break;
                case 16:
                    str2 = "CONNECTION_ACCEPT_TIMEOUT_EXCEEDED";
                    str = "The Connection Accept Timeout Exceeded error code indicates that the Connection Accept Timeout has been exceeded for this connection attempt.";
                    break;
                case 17:
                    str2 = "UNSUPPORTED_FEATURE_OR_PARAMETER_VALUE";
                    str = "The Unsupported Feature Or Parameter Value error code indicates that a feature or parameter value in the HCI command is not supported. This error code shall not be used in an LMP PDU.";
                    break;
                case 18:
                    str2 = "INVALID_HCI_COMMAND_PARAMETERS";
                    str = "The Invalid HCI Command Parameters error code indicates that at least one of the HCI command parameters is invalid. This shall be used when:\n\t\t\t\t- the parameter total length is invalid.\n\t\t\t\t- a command parameter is an invalid type.\n\t\t\t\t- a connection identifier does not match the corresponding event.\n\t\t\t\t- a parameter is odd when it is required to be even.\n\t\t\t\t- a parameter is outside of the specified range.\n\t\t\t\t- two or more parameter values have inconsistent values.\nNote: An invalid type can be, for example, when a SCO connection handle is used where an ACL connection handle is required. </p>";
                    break;
                case 19:
                    str = "The Remote User Terminated Connection error code indicates that the user on the remote device terminated the connection.";
                    break;
                case 20:
                    str = "The Remote Device Terminated Connection due to Low Resources error code indicates that the remote device terminated the connection because of low resources.";
                    break;
                case 21:
                    str2 = "REMOTE_DEVICE_TERMINATED_CONNECTION_POWER_OFF";
                    str = "The Remote Device Terminated Connection due to Power Off error code indicates that the remote device terminated the connection because the device is about to power off.";
                    break;
                case 22:
                    str2 = "CONNECTION_TERMINATED_BY_LOCAL_HOST";
                    str = "The Connection Terminated By Local Host error code indicates that the local device terminated the connection.";
                    break;
                case 23:
                    str2 = "REPEATED_ATTEMPTS";
                    str = "The Repeated Attempts error code indicates that the Controller is disallowing an authentication or pairing procedure because too little time has elapsed since the last authentication or pairing attempt failed.";
                    break;
                case 24:
                    str2 = "PAIRING_NOT_ALLOWED";
                    str = "The Pairing Not Allowed error code indicates that the device does not allow pairing. For example, when a device only allows pairing during a certain time window after some user input allows pairing.";
                    break;
                case 25:
                    str2 = "UNKNOWN_LMP_PDU";
                    str = "The Unknown LMP PDU error code indicates that the Controller has received an unknown LMP OpCode.";
                    break;
                case 26:
                    str2 = "UNSUPPORTED_REMOTE_FEATURE_OR_LMP_FEATURE";
                    str = "The Unsupported Remote Feature error code indicates that the remote device does not support the feature associated with the issued command or LMP PDU.";
                    break;
                case 27:
                    str2 = "SCO_OFFSET_REJECTED";
                    str = "The SCO Offset Rejected error code indicates that the offset requested in the LMP_SCO_link_req PDU has been rejected.";
                    break;
                case 28:
                    str2 = "SCO_INTERVAL_REJECTED";
                    str = "The SCO Interval Rejected error code indicates that the interval requested in the LMP_SCO_link_req PDU has been rejected.";
                    break;
                case 29:
                    str2 = "SCO_AIR_MODE_REJECTED";
                    str = "The SCO Air Mode Rejected error code indicates that the air mode requested in the LMP_SCO_link_req PDU has been rejected.";
                    break;
                case 30:
                    str2 = "INVALID_LMP_OR_LL_PARAMETERS";
                    str = "The Invalid LMP Parameters / Invalid LL Parameters error code indicates that some LMP PDU / LL Control PDU parameters were invalid. This shall be used when:\n\t\t\t\t- the PDU length is invalid.\n\t\t\t\t- a parameter is odd when it is required to be even.\n\t\t\t\t- a parameter is outside of the specified range.\n\t\t\t\t- two or more parameters have inconsistent values.";
                    break;
                case 31:
                    str2 = "UNSPECIFIED_ERROR";
                    str = "The Unspecified Error error code indicates that no other error code specified is appropriate to use.";
                    break;
                case 32:
                    str2 = "UNSUPPORTED_LMP_OR_LL_PARAMETER_VALUE";
                    str = "The Unsupported LMP Parameter Value / Unsupported LL Parameter Value error code indicates that an LMP PDU or an LL Control PDU contains at least one parameter value that is not supported by the Controller at this time. This is normally used after a long negotiation procedure, for example during an LMP_hold_req, LMP_sniff_req and LMP_encryption_key_size_req PDU exchanges. This may be used by the Link Layer, for example during the Connection Parameters Request Link Layer Control procedure.";
                    break;
                case 33:
                    str2 = "ROLE_CHANGE_NOT_ALLOWED";
                    str = "The Role Change Not Allowed error code indicates that a Controller will not allow a role change at this time.";
                    break;
                case 34:
                    str2 = "LMP_OR_LL_RESPONSE_TIMEOUT";
                    str = "The LMP Response Timeout / LL Response Timeout error code indicates that an LMP transaction failed to respond within the LMP response timeout or an LL transaction failed to respond within the LL response timeout.";
                    break;
                case 35:
                    str2 = "LMP_ERROR_TRANSACTION_COLLISION_OR_LL_PROCEDURE_COLLISION";
                    str = "The LMP Error Transaction Collision / LL Procedure Collision error code indicates that an LMP transaction or LL procedure has collided with the same transaction or procedure that is already in progress.";
                    break;
                case 36:
                    str2 = "LMP_PDU_NOT_ALLOWED";
                    str = "The LMP PDU Not Allowed error code indicates that a Controller sent an LMP PDU with an OpCode that was not allowed.";
                    break;
                case 37:
                    str2 = "ENCRYPTION_MODE_NOT_ACCEPTABLE";
                    str = "The Encryption Mode Not Acceptable error code indicates that the requested encryption mode is not acceptable at this time.";
                    break;
                case 38:
                    str2 = "LINK_KEY_CANNOT_BE_CHANGED";
                    str = "The Link Key cannot be Changed error code indicates that a link key cannot be changed because a fixed unit key is being used.";
                    break;
                case 39:
                    str2 = "REQUESTED_QOS_NOT_SUPPORTED";
                    str = "The Requested QoS Not Supported error code indicates that the requested Quality of Service is not supported.";
                    break;
                case 40:
                    str2 = "INSTANT_PASSED";
                    str = "The Instant Passed error code indicates that an LMP PDU or LL PDU that includes an instant cannot be performed because the instant when this would have occurred has passed.";
                    break;
                case 41:
                    str2 = "PAIRING_WITH_UNIT_KEY_NOT_SUPPORTED";
                    str = "The Pairing With Unit Key Not Supported error code indicates that it was not possible to pair as a unit key was requested and it is not supported.";
                    break;
                case 42:
                    str2 = "DIFFERENT_TRANSACTION_COLLISION";
                    str = "The Different Transaction Collision error code indicates that an LMP transaction or LL Procedure was started that collides with an ongoing transaction.";
                    break;
                case 43:
                case 49:
                case 51:
                default:
                    str = "";
                    str2 = str;
                    break;
                case 44:
                    str2 = "UNACCEPTABLE_PARAMETER";
                    str = "The QoS Unacceptable Parameter error code indicates that the specified quality of service parameters could not be accepted at this time, but other parameters may be acceptable.";
                    break;
                case 45:
                    str2 = "QOS_REJECTED";
                    str = "The QoS Rejected error code indicates that the specified quality of service parameters cannot be accepted and QoS negotiation should be terminated";
                    break;
                case 46:
                    str2 = "CHANNEL_CLASSIFICATION_NOT_SUPPORTED";
                    str = "The Channel Assessment Not Supported error code indicates that the Controller cannot perform channel assessment because it is not supported.";
                    break;
                case 47:
                    str2 = "INSUFFICIENT_SECURITY";
                    str = "The Insufficient Security error code indicates that the HCI command or LMP PDU sent is only possible on an encrypted link.";
                    break;
                case 48:
                    str2 = "PARAMETER_OUT_OF_MANDATORY_RANGE";
                    str = "The Parameter Out Of Mandatory Range error code indicates that a parameter value requested is outside the mandatory range of parameters for the given HCI command or LMP PDU and the recipient does not accept that value.";
                    break;
                case 50:
                    str2 = "ROLE_SWITCH_PENDING";
                    str = "The Role Switch Pending error code indicates that a Role Switch is pending. This can be used when an HCI command or LMP PDU cannot be accepted because of a pending role switch. This can also be used to notify a peer device about a pending role switch.";
                    break;
                case 52:
                    str2 = "RESERVED_SLOT_VIOLATION";
                    str = "The Reserved Slot Violation error code indicates that the current Synchronous negotiation was terminated with the negotiation state set to Reserved Slot Violation.";
                    break;
                case 53:
                    str2 = "ROLE_SWITCH_FAILED";
                    str = "The Role Switch Failed error code indicates that a role switch was attempted but it failed and the original piconet structure is restored. The switch may have failed because the TDD switch or piconet switch failed.";
                    break;
                case 54:
                    str2 = "EXTENDED_INQUIRY_RESPONSE_TOO_LARGE";
                    str = "The Extended Inquiry Response Too Large error code indicates that the extended inquiry response, with the requested requirements for FEC, is too large to fit in any of the packet types supported by the Controller.";
                    break;
                case 55:
                    str2 = "SECURE_SIMPLE_PAIRING_NOT_SUPPORTED_BY_HOST";
                    str = "The Secure Simple Pairing Not Supported by Host error code indicates that the IO capabilities request or response was rejected because the sending Host does not support Secure Simple Pairing even though the receiving Link Manager does.";
                    break;
                case 56:
                    str2 = "HOST_BUSY_PAIRING";
                    str = "The Host Busy - Pairing error code indicates that the Host is busy with another pairing operation and unable to support the requested pairing. The receiving device should retry pairing again later.";
                    break;
                case 57:
                    str2 = "CONNECTION_REJECTED_NO_SUITABLE_CHANNEL_FOUND";
                    str = "The Connection Rejected due to No Suitable Channel Found error code indicates that the Controller could not calculate an appropriate value for the Channel selection operation.";
                    break;
                case 58:
                    str2 = "CONTROLLER_BUSY";
                    str = "The Controller Busy error code indicates that the operation was rejected because the Controller was busy and unable to process the request.";
                    break;
                case 59:
                    str2 = "UNACCEPTABLE_CONNECTION_PARAMETERS";
                    str = "The Unacceptable Connection Parameters error code indicates that the remote device either terminated the connection or rejected a request because of one or more unacceptable connection parameters.";
                    break;
                case 60:
                    str2 = "DIRECTED_ADVERTISING_TIMEOUT";
                    str = "The Advertising Timeout error code indicates that advertising for a fixed duration completed or, for directed advertising, that advertising completed without a connection being created. (Formerly called Directed Advertising Timeout)";
                    break;
                case 61:
                    str2 = "CONNECTION_TERMINATED_MIC_FAILURE";
                    str = "The Connection Terminated Due to MIC Failure error code indicates that the connection was terminated because the Message Integrity Check (MIC) failed on a received packet.";
                    break;
                case 62:
                    str2 = "CONNECTION_ESTABLISHMENT_FAILED";
                    str = "The Connection Failed to be Established error code indicates that the LL initiated a connection but the connection has failed to be established.";
                    break;
                case 63:
                    str2 = "MAC_CONNECTION_FAILED";
                    str = "The MAC of the 802.11 AMP was requested to connect to a peer, but the connection failed.";
                    break;
                case 64:
                    str2 = "COARSE_CLOCK_ADJUSTMENT_REJECTED";
                    str = "The Coarse Clock Adjustment Rejected but Will Try to Adjust Using Clock Dragging error code indicates that the master, at this time, is unable to make a coarse adjustment to the piconet clock, using the supplied parameters. Instead the master will attempt to move the clock using clock dragging.";
                    break;
                case 65:
                    str2 = "TYPE_0_SUBMAP_NOT_DEFINED";
                    str = "The Type0 Submap Not Defined error code indicates that the LMP PDU is rejected because the Type 0 submap is not currently defined.";
                    break;
                case 66:
                    str2 = "UNKNOWN_ADVERTISING_IDENTIFIER";
                    str = "The Unknown Advertising Identifier error code indicates that a command was sent from the Host that should identify an Advertising or Sync handle, but the Advertising or Sync handle does not exist.";
                    break;
                case 67:
                    str2 = "LIMIT_REACHED";
                    str = "The Limit Reached error code indicates that number of operations requested has been reached and has indicated the completion of the activity (e.g., advertising or scanning).";
                    break;
                case 68:
                    str2 = "OPERATION_CANCELLED_BY_HOST";
                    str = "The Operation Cancelled by Host error code indicates a request to the Controller issued by the Host and still pending was successfully canceled.";
                    break;
            }
            if (str2.length() <= 0) {
                return "";
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            if (z10 && str.length() > 0) {
                str3 = ": " + str;
            }
            sb2.append(str3);
            return sb2.toString();
        }
    }

    public static String a(int i10, boolean z10) {
        String str;
        String str2;
        String str3 = "";
        if (i10 == 0) {
            str = "GATT_SUCCESS";
            str2 = "A GATT operation completed successfully.";
        } else if (i10 == 13) {
            str = "GATT_INVALID_ATTRIBUTE_LENGTH";
            str2 = "A write operation exceeds the maximum length of the attribute.";
        } else if (i10 == 15) {
            str = "GATT_INSUFFICIENT_ENCRYPTION";
            str2 = "Insufficient encryption for a given operation.";
        } else if (i10 == 143) {
            str = "GATT_CONNECTION_CONGESTED";
            str2 = "A remote device connection is congested.";
        } else if (i10 == 257) {
            str = "GATT_FAILURE";
            str2 = "A GATT operation failed, different error of the BluetoothGatt ones.";
        } else if (i10 == 2) {
            str = "GATT_READ_NOT_PERMITTED";
            str2 = "GATT read operation is not permitted.";
        } else if (i10 == 3) {
            str = "GATT_WRITE_NOT_PERMITTED";
            str2 = "GATT write operation is not permitted.";
        } else if (i10 == 5) {
            str = "GATT_INSUFFICIENT_AUTHENTICATION";
            str2 = "Insufficient authentication for a given operation.";
        } else if (i10 == 6) {
            str = "GATT_REQUEST_NOT_SUPPORTED";
            str2 = "The given request is not supported.";
        } else if (i10 != 7) {
            str = "";
            str2 = str;
        } else {
            str = "GATT_INVALID_OFFSET";
            str2 = "A read or write operation was requested with an invalid offset.";
        }
        if (str.length() <= 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        if (z10 && str2.length() > 0) {
            str3 = ": " + str2;
        }
        sb2.append(str3);
        return sb2.toString();
    }
}
