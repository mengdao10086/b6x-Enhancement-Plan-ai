package gg;

import com.blankj.utilcode.util.i0;
import o5.h;

/* JADX INFO: loaded from: classes5.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f29552a = 4;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f29553b = 8;

    public static void a(int i10, byte[] bArr, int i11, int i12, boolean z10) {
        int i13 = 0;
        if ((i12 < 0) || (i12 > 4)) {
            throw new IndexOutOfBoundsException("Length must be between 0 and 4");
        }
        if (bArr.length < i11 + i12) {
            throw new IndexOutOfBoundsException("The targeted location must be contained in the target array.");
        }
        if (!z10) {
            int i14 = (i12 - 1) * 8;
            while (i13 < i12) {
                bArr[i13 + i11] = (byte) (((255 << i14) & i10) >> i14);
                i14 -= 8;
                i13++;
            }
            return;
        }
        int i15 = 0;
        for (int i16 = i12 - 1; i16 >= 0; i16--) {
            bArr[i15 + i11] = (byte) (((255 << i13) & i10) >> i13);
            i13 += 8;
            i15++;
        }
    }

    public static int b(byte[] bArr, int i10, int i11, boolean z10) {
        int i12 = 0;
        if ((i11 < 0) || (i11 > 4)) {
            throw new IndexOutOfBoundsException("Length must be between 0 and 4");
        }
        int i13 = (i11 - 1) * 8;
        if (z10) {
            for (int i14 = (i11 + i10) - 1; i14 >= i10; i14--) {
                i12 |= (bArr[i14] & 255) << i13;
                i13 -= 8;
            }
        } else {
            for (int i15 = i10; i15 < i10 + i11; i15++) {
                i12 |= (bArr[i15] & 255) << i13;
                i13 -= 8;
            }
        }
        return i12;
    }

    public static String c(int i10) {
        String str;
        if (i10 == 416) {
            str = "COMMAND_GET_MOUNTED_PARTITIONS";
        } else if (i10 != 417) {
            switch (i10) {
                case 256:
                    str = "COMMAND_SET_RAW_CONFIGURATION(deprecated)";
                    break;
                case 257:
                    str = "COMMAND_SET_LED_CONFIGURATION";
                    break;
                case b.f29449j /* 258 */:
                    str = "COMMAND_SET_TONE_CONFIGURATION";
                    break;
                case b.f29457l /* 259 */:
                    str = "COMMAND_SET_DEFAULT_VOLUME";
                    break;
                case b.f29465n /* 260 */:
                    str = "COMMAND_FACTORY_DEFAULT_RESET";
                    break;
                case b.f29473p /* 261 */:
                    str = "COMMAND_SET_VIBRATOR_CONFIGURATION";
                    break;
                case b.f29481r /* 262 */:
                    str = "COMMAND_SET_VOICE_PROMPT_CONFIGURATION";
                    break;
                case 263:
                    str = "COMMAND_SET_FEATURE_CONFIGURATION";
                    break;
                case b.f29497v /* 264 */:
                    str = "COMMAND_SET_USER_EVENT_CONFIGURATION";
                    break;
                case b.f29505x /* 265 */:
                    str = "COMMAND_SET_TIMER_CONFIGURATION";
                    break;
                case b.f29513z /* 266 */:
                    str = "COMMAND_SET_AUDIO_GAIN_CONFIGURATION";
                    break;
                case b.B /* 267 */:
                    str = "COMMAND_SET_VOLUME_CONFIGURATION";
                    break;
                case b.D /* 268 */:
                    str = "COMMAND_SET_POWER_CONFIGURATION";
                    break;
                default:
                    switch (i10) {
                        case 270:
                            str = "COMMAND_SET_USER_TONE_CONFIGURATION";
                            break;
                        case 271:
                            str = "COMMAND_SET_DEVICE_NAME";
                            break;
                        case b.J /* 272 */:
                            str = "COMMAND_SET_WLAN_CREDENTIALS";
                            break;
                        case 273:
                            str = "COMMAND_SET_PEER_PERMITTED_ROUTING";
                            break;
                        case 274:
                            str = "COMMAND_SET_PERMITTED_NEXT_AUDIO_SOURCE";
                            break;
                        default:
                            switch (i10) {
                                case b.P /* 278 */:
                                    str = "COMMAND_SET_ONE_TOUCH_DIAL_STRING";
                                    break;
                                case b.S /* 289 */:
                                    str = "COMMAND_SET_DFU_PARTITION";
                                    break;
                                case 406:
                                    str = "COMMAND_GET_ONE_TOUCH_DIAL_STRING";
                                    break;
                                case b.f29482r0 /* 528 */:
                                    str = "COMMAND_ALERT_EVENT";
                                    break;
                                case b.f29486s0 /* 529 */:
                                    str = "COMMAND_ALERT_VOICE";
                                    break;
                                case b.f29490t0 /* 530 */:
                                    str = "COMMAND_SET_AUDIO_PROMPT_LANGUAGE";
                                    break;
                                case b.f29498v0 /* 531 */:
                                    str = "COMMAND_START_SPEECH_RECOGNITION";
                                    break;
                                case b.f29502w0 /* 532 */:
                                    str = "COMMAND_SET_EQ_CONTROL";
                                    break;
                                case b.f29510y0 /* 533 */:
                                    str = "COMMAND_SET_BASS_BOOST_CONTROL";
                                    break;
                                case b.A0 /* 534 */:
                                    str = "COMMAND_SET_3D_ENHANCEMENT_CONTROL";
                                    break;
                                case b.C0 /* 535 */:
                                    str = "COMMAND_SWITCH_EQ_CONTROL";
                                    break;
                                case b.D0 /* 536 */:
                                    str = "COMMAND_TOGGLE_BASS_BOOST_CONTROL";
                                    break;
                                case b.E0 /* 537 */:
                                    str = "COMMAND_TOGGLE_3D_ENHANCEMENT_CONTROL";
                                    break;
                                case b.F0 /* 538 */:
                                    str = "COMMAND_SET_EQ_PARAMETER";
                                    break;
                                case b.H0 /* 539 */:
                                    str = "COMMAND_SET_EQ_GROUP_PARAMETER";
                                    break;
                                case 540:
                                    str = "COMMAND_DISPLAY_CONTROL";
                                    break;
                                case b.K0 /* 541 */:
                                    str = "COMMAND_ENTER_BLUETOOTH_PAIRING_MODE";
                                    break;
                                case b.L0 /* 542 */:
                                    str = "COMMAND_SET_AUDIO_SOURCE";
                                    break;
                                case b.N0 /* 543 */:
                                    str = "COMMAND_AV_REMOTE_CONTROL";
                                    break;
                                case b.O0 /* 544 */:
                                    str = "COMMAND_SET_USER_EQ_CONTROL";
                                    break;
                                case b.Q0 /* 545 */:
                                    str = "COMMAND_TOGGLE_USER_EQ_CONTROL";
                                    break;
                                case 546:
                                    str = "COMMAND_SET_SPEAKER_EQ_CONTROL";
                                    break;
                                case b.T0 /* 547 */:
                                    str = "COMMAND_TOGGLE_SPEAKER_EQ_CONTROL";
                                    break;
                                case b.U0 /* 548 */:
                                    str = "COMMAND_SET_TWS_AUDIO_ROUTING";
                                    break;
                                case b.W0 /* 549 */:
                                    str = "COMMAND_SET_TWS_VOLUME";
                                    break;
                                case b.Y0 /* 550 */:
                                    str = "COMMAND_TRIM_TWS_VOLUME";
                                    break;
                                case b.Z0 /* 551 */:
                                    str = "COMMAND_SET_PEER_LINK_RESERVED";
                                    break;
                                case 576:
                                    str = "COMMAND_SET_CODEC";
                                    break;
                                case b.f29458l0 /* 650 */:
                                    str = "COMMAND_GET_VOICE_PROMPT_CONTROL";
                                    break;
                                case b.f29470o0 /* 652 */:
                                    str = "COMMAND_GET_SPEECH_RECOGNITION_CONTROL";
                                    break;
                                case b.f29494u0 /* 658 */:
                                    str = "COMMAND_GET_AUDIO_PROMPT_LANGUAGE";
                                    break;
                                case b.G0 /* 666 */:
                                    str = "COMMAND_GET_EQ_PARAMETER";
                                    break;
                                case 667:
                                    str = "COMMAND_GET_EQ_GROUP_PARAMETER";
                                    break;
                                case b.M0 /* 670 */:
                                    str = "COMMAND_GET_AUDIO_SOURCE";
                                    break;
                                case b.P0 /* 672 */:
                                    str = "COMMAND_GET_USER_EQ_CONTROL";
                                    break;
                                case b.S0 /* 674 */:
                                    str = "COMMAND_GET_SPEAKER_EQ_CONTROL";
                                    break;
                                case b.V0 /* 676 */:
                                    str = "COMMAND_GET_TWS_AUDIO_ROUTING";
                                    break;
                                case b.X0 /* 677 */:
                                    str = "COMMAND_GET_TWS_VOLUME";
                                    break;
                                case b.f29415a1 /* 679 */:
                                    str = "COMMAND_GET_PEER_LINK_RESERVED";
                                    break;
                                case 704:
                                    str = "COMMAND_GET_CODEC";
                                    break;
                                case 768:
                                    str = "COMMAND_GET_API_VERSION";
                                    break;
                                case b.f29459l1 /* 769 */:
                                    str = "COMMAND_GET_CURRENT_RSSI";
                                    break;
                                case b.f29463m1 /* 770 */:
                                    str = "COMMAND_GET_CURRENT_BATTERY_LEVEL";
                                    break;
                                case b.f29467n1 /* 771 */:
                                    str = "COMMAND_GET_MODULE_ID";
                                    break;
                                case b.f29471o1 /* 772 */:
                                    str = "COMMAND_GET_APPLICATION_VERSION";
                                    break;
                                case b.f29475p1 /* 774 */:
                                    str = "COMMAND_GET_PIO_STATE";
                                    break;
                                case b.f29479q1 /* 775 */:
                                    str = "COMMAND_READ_ADC";
                                    break;
                                case b.f29483r1 /* 778 */:
                                    str = "COMMAND_GET_PEER_ADDRESS";
                                    break;
                                case b.f29487s1 /* 784 */:
                                    str = "COMMAND_GET_DFU_STATUS(deprecated)";
                                    break;
                                case b.f29491t1 /* 800 */:
                                    str = "COMMAND_GET_HOST_FEATURE_INFORMATION";
                                    break;
                                case b.f29503w1 /* 1281 */:
                                    str = "COMMAND_AUTHENTICATE_REQUEST";
                                    break;
                                case b.f29507x1 /* 1282 */:
                                    str = "COMMAND_AUTHENTICATE_RESPONSE";
                                    break;
                                case 1283:
                                    str = "COMMAND_SET_FEATURE";
                                    break;
                                case b.A1 /* 1284 */:
                                    str = "COMMAND_SET_SESSION_ENABLE";
                                    break;
                                case b.f29499v1 /* 1408 */:
                                    str = "COMMAND_GET_AUTH_BITMAPS";
                                    break;
                                case b.f29515z1 /* 1411 */:
                                    str = "COMMAND_GET_FEATURE";
                                    break;
                                case b.B1 /* 1412 */:
                                    str = "COMMAND_GET_SESSION_ENABLE";
                                    break;
                                case b.D1 /* 1537 */:
                                    str = "COMMAND_DATA_TRANSFER_SETUP";
                                    break;
                                case b.E1 /* 1538 */:
                                    str = "COMMAND_DATA_TRANSFER_CLOSE";
                                    break;
                                case b.F1 /* 1539 */:
                                    str = "COMMAND_HOST_TO_DEVICE_DATA";
                                    break;
                                case b.G1 /* 1540 */:
                                    str = "COMMAND_DEVICE_TO_HOST_DATA";
                                    break;
                                case b.H1 /* 1544 */:
                                    str = "COMMAND_I2C_TRANSFER";
                                    break;
                                case b.I1 /* 1552 */:
                                    str = "COMMAND_GET_STORAGE_PARTITION_STATUS";
                                    break;
                                case b.J1 /* 1553 */:
                                    str = "COMMAND_OPEN_STORAGE_PARTITION";
                                    break;
                                case b.K1 /* 1554 */:
                                    str = "COMMAND_OPEN_UART";
                                    break;
                                case b.L1 /* 1557 */:
                                    str = "COMMAND_WRITE_STORAGE_PARTITION";
                                    break;
                                case b.M1 /* 1559 */:
                                    str = "COMMAND_WRITE_STREAM";
                                    break;
                                case b.N1 /* 1560 */:
                                    str = "COMMAND_CLOSE_STORAGE_PARTITION";
                                    break;
                                case b.O1 /* 1562 */:
                                    str = "COMMAND_MOUNT_STORAGE_PARTITION";
                                    break;
                                case b.P1 /* 1568 */:
                                    str = "COMMAND_GET_FILE_STATUS";
                                    break;
                                case b.Q1 /* 1569 */:
                                    str = "COMMAND_OPEN_FILE";
                                    break;
                                case b.R1 /* 1572 */:
                                    str = "COMMAND_READ_FILE";
                                    break;
                                case b.S1 /* 1576 */:
                                    str = "COMMAND_CLOSE_FILE";
                                    break;
                                case b.T1 /* 1584 */:
                                    str = "COMMAND_DFU_REQUEST";
                                    break;
                                case b.U1 /* 1585 */:
                                    str = "COMMAND_DFU_BEGIN";
                                    break;
                                case b.V1 /* 1586 */:
                                    str = "COMMAND_DFU_WRITE";
                                    break;
                                case b.W1 /* 1587 */:
                                    str = "COMMAND_DFU_COMMIT";
                                    break;
                                case b.X1 /* 1588 */:
                                    str = "COMMAND_DFU_GET_RESULT";
                                    break;
                                case 1600:
                                    str = "COMMAND_VM_UPGRADE_CONNECT";
                                    break;
                                case b.Z1 /* 1601 */:
                                    str = "COMMAND_VM_UPGRADE_DISCONNECT";
                                    break;
                                case b.f29416a2 /* 1602 */:
                                    str = "COMMAND_VM_UPGRADE_CONTROL";
                                    break;
                                case b.f29420b2 /* 1603 */:
                                    str = "COMMAND_VM_UPGRADE_DATA";
                                    break;
                                case 1792:
                                    str = "COMMAND_NO_OPERATION";
                                    break;
                                case b.f29432e2 /* 1793 */:
                                    str = "COMMAND_GET_DEBUG_FLAGS";
                                    break;
                                case b.f29436f2 /* 1794 */:
                                    str = "COMMAND_SET_DEBUG_FLAGS";
                                    break;
                                case b.f29440g2 /* 1808 */:
                                    str = "COMMAND_RETRIEVE_PS_KEY";
                                    break;
                                case b.f29444h2 /* 1809 */:
                                    str = "COMMAND_RETRIEVE_FULL_PS_KEY";
                                    break;
                                case b.f29448i2 /* 1810 */:
                                    str = "COMMAND_STORE_PS_KEY";
                                    break;
                                case b.f29452j2 /* 1811 */:
                                    str = "COMMAND_FLOOD_PS";
                                    break;
                                case b.f29456k2 /* 1812 */:
                                    str = "COMMAND_STORE_FULL_PS_KEY";
                                    break;
                                case 1824:
                                    str = "COMMAND_SEND_DEBUG_MESSAGE";
                                    break;
                                case b.f29464m2 /* 1825 */:
                                    str = "COMMAND_SEND_APPLICATION_MESSAGE";
                                    break;
                                case b.f29468n2 /* 1826 */:
                                    str = "COMMAND_SEND_KALIMBA_MESSAGE";
                                    break;
                                case b.f29472o2 /* 1840 */:
                                    str = "COMMAND_GET_MEMORY_SLOTS";
                                    break;
                                case b.f29476p2 /* 1856 */:
                                    str = "COMMAND_GET_DEBUG_VARIABLE";
                                    break;
                                case b.f29480q2 /* 1857 */:
                                    str = "COMMAND_SET_DEBUG_VARIABLE";
                                    break;
                                case b.f29484r2 /* 1872 */:
                                    str = "COMMAND_DELETE_PDL";
                                    break;
                                case b.f29488s2 /* 1874 */:
                                    str = "COMMAND_SET_BLE_CONNECTION_PARAMETERS";
                                    break;
                                case 4096:
                                    str = "COMMAND_IVOR_START";
                                    break;
                                case 4097:
                                    str = "COMMAND_IVOR_VOICE_DATA_REQUEST";
                                    break;
                                case 4098:
                                    str = "COMMAND_IVOR_VOICE_DATA";
                                    break;
                                case 4099:
                                    str = "COMMAND_IVOR_VOICE_END";
                                    break;
                                case 4100:
                                    str = "COMMAND_IVOR_CANCEL";
                                    break;
                                case 4101:
                                    str = "COMMAND_IVOR_CHECK_VERSION";
                                    break;
                                case 4102:
                                    str = "COMMAND_IVOR_ANSWER_START";
                                    break;
                                case 4103:
                                    str = "COMMAND_IVOR_ANSWER_END";
                                    break;
                                case b.C2 /* 4336 */:
                                    str = "COMMAND_IVOR_PING";
                                    break;
                                case b.E2 /* 16385 */:
                                    str = "COMMAND_REGISTER_NOTIFICATION";
                                    break;
                                case 16386:
                                    str = "COMMAND_CANCEL_NOTIFICATION";
                                    break;
                                case b.H2 /* 16387 */:
                                    str = "COMMAND_EVENT_NOTIFICATION";
                                    break;
                                case b.F2 /* 16513 */:
                                    str = "COMMAND_GET_NOTIFICATION";
                                    break;
                                default:
                                    switch (i10) {
                                        case 384:
                                            str = "COMMAND_GET_CONFIGURATION_VERSION";
                                            break;
                                        case b.f29445i /* 385 */:
                                            str = "COMMAND_GET_LED_CONFIGURATION";
                                            break;
                                        case b.f29453k /* 386 */:
                                            str = "COMMAND_GET_TONE_CONFIGURATION";
                                            break;
                                        case b.f29461m /* 387 */:
                                            str = "COMMAND_GET_DEFAULT_VOLUME";
                                            break;
                                        case b.f29469o /* 388 */:
                                            str = "COMMAND_GET_CONFIGURATION_ID(deprecated)";
                                            break;
                                        case b.f29477q /* 389 */:
                                            str = "COMMAND_GET_VIBRATOR_CONFIGURATION";
                                            break;
                                        case b.f29485s /* 390 */:
                                            str = "COMMAND_GET_VOICE_PROMPT_CONFIGURATION";
                                            break;
                                        case b.f29493u /* 391 */:
                                            str = "COMMAND_GET_FEATURE_CONFIGURATION";
                                            break;
                                        case b.f29501w /* 392 */:
                                            str = "COMMAND_GET_USER_EVENT_CONFIGURATION";
                                            break;
                                        case b.f29509y /* 393 */:
                                            str = "COMMAND_GET_TIMER_CONFIGURATION";
                                            break;
                                        case b.A /* 394 */:
                                            str = "COMMAND_GET_AUDIO_GAIN_CONFIGURATION";
                                            break;
                                        case b.C /* 395 */:
                                            str = "COMMAND_GET_VOLUME_CONFIGURATION";
                                            break;
                                        case b.E /* 396 */:
                                            str = "COMMAND_GET_POWER_CONFIGURATION";
                                            break;
                                        default:
                                            switch (i10) {
                                                case b.G /* 398 */:
                                                    str = "COMMAND_GET_USER_TONE_CONFIGURATION";
                                                    break;
                                                case b.I /* 399 */:
                                                    str = "COMMAND_GET_DEVICE_NAME";
                                                    break;
                                                case 400:
                                                    str = "COMMAND_GET_WLAN_CREDENTIALS";
                                                    break;
                                                case 401:
                                                    str = "COMMAND_GET_PEER_PERMITTED_ROUTING";
                                                    break;
                                                case 402:
                                                    str = "COMMAND_GET_PERMITTED_NEXT_AUDIO_SOURCE";
                                                    break;
                                                default:
                                                    switch (i10) {
                                                        case 513:
                                                            str = "COMMAND_CHANGE_VOLUME";
                                                            break;
                                                        case b.W /* 514 */:
                                                            str = "COMMAND_DEVICE_RESET";
                                                            break;
                                                        case b.Y /* 515 */:
                                                            str = "COMMAND_SET_PIO_CONTROL";
                                                            break;
                                                        case b.f29414a0 /* 516 */:
                                                            str = "COMMAND_SET_POWER_STATE";
                                                            break;
                                                        case b.f29422c0 /* 517 */:
                                                            str = "COMMAND_SET_VOLUME_ORIENTATION";
                                                            break;
                                                        case b.f29430e0 /* 518 */:
                                                            str = "COMMAND_SET_LATENCY_CONTROL";
                                                            break;
                                                        case b.f29438g0 /* 519 */:
                                                            str = "COMMAND_SET_LED_CONTROL";
                                                            break;
                                                        case b.f29446i0 /* 520 */:
                                                            str = "COMMAND_FM_CONTROL";
                                                            break;
                                                        case b.f29450j0 /* 521 */:
                                                            str = "COMMAND_PLAY_TONE";
                                                            break;
                                                        case b.f29454k0 /* 522 */:
                                                            str = "COMMAND_SET_VOICE_PROMPT_CONTROL";
                                                            break;
                                                        case b.f29462m0 /* 523 */:
                                                            str = "COMMAND_CHANGE_AUDIO_PROMPT_LANGUAGE";
                                                            break;
                                                        case 524:
                                                            str = "COMMAND_SET_SPEECH_RECOGNITION_CONTROL";
                                                            break;
                                                        case b.f29474p0 /* 525 */:
                                                            str = "COMMAND_ALERT_LEDS";
                                                            break;
                                                        case b.f29478q0 /* 526 */:
                                                            str = "COMMAND_ALERT_TONE";
                                                            break;
                                                        default:
                                                            switch (i10) {
                                                                case 554:
                                                                    str = "COMMAND_TWS_PEER_START_ADVERTISING";
                                                                    break;
                                                                case b.f29423c1 /* 555 */:
                                                                    str = "COMMAND_FIND_MY_REMOTE";
                                                                    break;
                                                                case b.f29435f1 /* 556 */:
                                                                    str = "COMMAND_SET_SUPPORTED_FEATURES";
                                                                    break;
                                                                case b.f29439g1 /* 557 */:
                                                                    str = "COMMAND_DISCONNECT";
                                                                    break;
                                                                default:
                                                                    switch (i10) {
                                                                        case b.X /* 642 */:
                                                                            str = "COMMAND_GET_BOOT_MODE";
                                                                            break;
                                                                        case b.Z /* 643 */:
                                                                            str = "COMMAND_GET_PIO_CONTROL";
                                                                            break;
                                                                        case b.f29418b0 /* 644 */:
                                                                            str = "COMMAND_GET_POWER_STATE";
                                                                            break;
                                                                        case b.f29426d0 /* 645 */:
                                                                            str = "COMMAND_GET_VOLUME_ORIENTATION";
                                                                            break;
                                                                        case b.f29434f0 /* 646 */:
                                                                            str = "COMMAND_GET_LATENCY_CONTROL";
                                                                            break;
                                                                        case b.f29442h0 /* 647 */:
                                                                            str = "COMMAND_GET_LED_CONTROL";
                                                                            break;
                                                                        default:
                                                                            switch (i10) {
                                                                                case 660:
                                                                                    str = "COMMAND_GET_EQ_CONTROL";
                                                                                    break;
                                                                                case 661:
                                                                                    str = "COMMAND_GET_BASS_BOOST_CONTROL";
                                                                                    break;
                                                                                case b.B0 /* 662 */:
                                                                                    str = "COMMAND_GET_3D_ENHANCEMENT_CONTROL";
                                                                                    break;
                                                                                default:
                                                                                    str = h.f42757n;
                                                                                    break;
                                                                            }
                                                                            break;
                                                                    }
                                                                    break;
                                                            }
                                                            break;
                                                    }
                                                    break;
                                            }
                                            break;
                                    }
                                    break;
                            }
                            break;
                    }
                    break;
            }
        } else {
            str = "COMMAND_GET_DFU_PARTITION";
        }
        return e(i10) + i0.f11861z + str;
    }

    public static String d(byte[] bArr) {
        if (bArr == null) {
            return i0.f11859x;
        }
        StringBuilder sb2 = new StringBuilder(bArr.length * 2);
        for (byte b10 : bArr) {
            sb2.append(String.format("0x%02x ", Byte.valueOf(b10)));
        }
        return sb2.toString();
    }

    public static String e(int i10) {
        return String.format("%04X", Integer.valueOf(i10 & 65535));
    }
}
