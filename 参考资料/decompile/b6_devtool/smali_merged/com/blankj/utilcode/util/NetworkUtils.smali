.class public final Lcom/blankj/utilcode/util/NetworkUtils;
.super Ljava/lang/Object;
.source "NetworkUtils.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/blankj/utilcode/util/NetworkUtils$WifiScanResults;,
        Lcom/blankj/utilcode/util/NetworkUtils$OnNetworkStatusChangedListener;,
        Lcom/blankj/utilcode/util/NetworkUtils$NetworkChangedReceiver;,
        Lcom/blankj/utilcode/util/NetworkUtils$NetworkType;
    }
.end annotation


# static fields
.field private static final SCAN_PERIOD_MILLIS:J = 0xbb8L

.field private static final SCAN_RESULT_CONSUMERS:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set<",
            "Lcom/blankj/utilcode/util/Utils$Consumer<",
            "Lcom/blankj/utilcode/util/NetworkUtils$WifiScanResults;",
            ">;>;"
        }
    .end annotation
.end field

.field private static sPreWifiScanResults:Lcom/blankj/utilcode/util/NetworkUtils$WifiScanResults;

.field private static sScanWifiTimer:Ljava/util/Timer;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    .line 765
    new-instance v0, Ljava/util/concurrent/CopyOnWriteArraySet;

    invoke-direct {v0}, Ljava/util/concurrent/CopyOnWriteArraySet;-><init>()V

    sput-object v0, Lcom/blankj/utilcode/util/NetworkUtils;->SCAN_RESULT_CONSUMERS:Ljava/util/Set;

    return-void
.end method

.method private constructor <init>()V
    .registers 3

    .line 56
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 57
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "u can\'t instantiate me..."

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method static synthetic access$100()Ljava/util/Set;
    .registers 1

    .line 54
    sget-object v0, Lcom/blankj/utilcode/util/NetworkUtils;->SCAN_RESULT_CONSUMERS:Ljava/util/Set;

    return-object v0
.end method

.method static synthetic access$200()V
    .registers 0

    .line 54
    invoke-static {}, Lcom/blankj/utilcode/util/NetworkUtils;->startScanWifi()V

    return-void
.end method

.method static synthetic access$300()Lcom/blankj/utilcode/util/NetworkUtils$WifiScanResults;
    .registers 1

    .line 54
    sget-object v0, Lcom/blankj/utilcode/util/NetworkUtils;->sPreWifiScanResults:Lcom/blankj/utilcode/util/NetworkUtils$WifiScanResults;

    return-object v0
.end method

.method static synthetic access$302(Lcom/blankj/utilcode/util/NetworkUtils$WifiScanResults;)Lcom/blankj/utilcode/util/NetworkUtils$WifiScanResults;
    .registers 1

    .line 54
    sput-object p0, Lcom/blankj/utilcode/util/NetworkUtils;->sPreWifiScanResults:Lcom/blankj/utilcode/util/NetworkUtils$WifiScanResults;

    return-object p0
.end method

.method static synthetic access$400()V
    .registers 0

    .line 54
    invoke-static {}, Lcom/blankj/utilcode/util/NetworkUtils;->startScanWifiIfEnabled()V

    return-void
.end method

.method static synthetic access$600(Ljava/util/List;Ljava/util/List;)Z
    .registers 2

    .line 54
    invoke-static {p0, p1}, Lcom/blankj/utilcode/util/NetworkUtils;->isSameScanResults(Ljava/util/List;Ljava/util/List;)Z

    move-result p0

    return p0
.end method

.method static synthetic access$700()V
    .registers 0

    .line 54
    invoke-static {}, Lcom/blankj/utilcode/util/NetworkUtils;->stopScanWifi()V

    return-void
.end method

.method public static addOnWifiChangedConsumer(Lcom/blankj/utilcode/util/Utils$Consumer;)V
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/blankj/utilcode/util/Utils$Consumer<",
            "Lcom/blankj/utilcode/util/NetworkUtils$WifiScanResults;",
            ">;)V"
        }
    .end annotation

    if-nez p0, :cond_3

    return-void

    .line 772
    :cond_3
    new-instance v0, Lcom/blankj/utilcode/util/NetworkUtils$7;

    invoke-direct {v0, p0}, Lcom/blankj/utilcode/util/NetworkUtils$7;-><init>(Lcom/blankj/utilcode/util/Utils$Consumer;)V

    invoke-static {v0}, Lcom/blankj/utilcode/util/UtilsBridge;->runOnUiThread(Ljava/lang/Runnable;)V

    return-void
.end method

.method private static getActiveNetworkInfo()Landroid/net/NetworkInfo;
    .registers 2

    .line 515
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v0

    const-string v1, "connectivity"

    invoke-virtual {v0, v1}, Landroid/app/Application;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/ConnectivityManager;

    if-nez v0, :cond_10

    const/4 v0, 0x0

    return-object v0

    .line 517
    :cond_10
    invoke-virtual {v0}, Landroid/net/ConnectivityManager;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v0

    return-object v0
.end method

.method public static getBroadcastIpAddress()Ljava/lang/String;
    .registers 5

    .line 589
    :try_start_0
    invoke-static {}, Ljava/net/NetworkInterface;->getNetworkInterfaces()Ljava/util/Enumeration;

    move-result-object v0

    .line 590
    new-instance v1, Ljava/util/LinkedList;

    invoke-direct {v1}, Ljava/util/LinkedList;-><init>()V

    .line 591
    :cond_9
    :goto_9
    invoke-interface {v0}, Ljava/util/Enumeration;->hasMoreElements()Z

    move-result v1

    if-eqz v1, :cond_45

    .line 592
    invoke-interface {v0}, Ljava/util/Enumeration;->nextElement()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/net/NetworkInterface;

    .line 593
    invoke-virtual {v1}, Ljava/net/NetworkInterface;->isUp()Z

    move-result v2

    if-eqz v2, :cond_9

    invoke-virtual {v1}, Ljava/net/NetworkInterface;->isLoopback()Z

    move-result v2

    if-eqz v2, :cond_22

    goto :goto_9

    .line 594
    :cond_22
    invoke-virtual {v1}, Ljava/net/NetworkInterface;->getInterfaceAddresses()Ljava/util/List;

    move-result-object v1

    .line 595
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v2

    const/4 v3, 0x0

    :goto_2b
    if-ge v3, v2, :cond_9

    .line 596
    invoke-interface {v1, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/net/InterfaceAddress;

    .line 597
    invoke-virtual {v4}, Ljava/net/InterfaceAddress;->getBroadcast()Ljava/net/InetAddress;

    move-result-object v4

    if-eqz v4, :cond_3e

    .line 599
    invoke-virtual {v4}, Ljava/net/InetAddress;->getHostAddress()Ljava/lang/String;

    move-result-object v0
    :try_end_3d
    .catch Ljava/net/SocketException; {:try_start_0 .. :try_end_3d} :catch_41

    return-object v0

    :cond_3e
    add-int/lit8 v3, v3, 0x1

    goto :goto_2b

    :catch_41
    move-exception v0

    .line 604
    invoke-virtual {v0}, Ljava/net/SocketException;->printStackTrace()V

    :cond_45
    const-string v0, ""

    return-object v0
.end method

.method public static getDomainAddress(Ljava/lang/String;)Ljava/lang/String;
    .registers 1

    .line 640
    :try_start_0
    invoke-static {p0}, Ljava/net/InetAddress;->getByName(Ljava/lang/String;)Ljava/net/InetAddress;

    move-result-object p0

    .line 641
    invoke-virtual {p0}, Ljava/net/InetAddress;->getHostAddress()Ljava/lang/String;

    move-result-object p0
    :try_end_8
    .catch Ljava/net/UnknownHostException; {:try_start_0 .. :try_end_8} :catch_9

    return-object p0

    :catch_9
    move-exception p0

    .line 643
    invoke-virtual {p0}, Ljava/net/UnknownHostException;->printStackTrace()V

    const-string p0, ""

    return-object p0
.end method

.method public static getDomainAddressAsync(Ljava/lang/String;Lcom/blankj/utilcode/util/Utils$Consumer;)Lcom/blankj/utilcode/util/Utils$Task;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/blankj/utilcode/util/Utils$Consumer<",
            "Ljava/lang/String;",
            ">;)",
            "Lcom/blankj/utilcode/util/Utils$Task<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .line 620
    new-instance v0, Lcom/blankj/utilcode/util/NetworkUtils$6;

    invoke-direct {v0, p1, p0}, Lcom/blankj/utilcode/util/NetworkUtils$6;-><init>(Lcom/blankj/utilcode/util/Utils$Consumer;Ljava/lang/String;)V

    invoke-static {v0}, Lcom/blankj/utilcode/util/UtilsBridge;->doAsync(Lcom/blankj/utilcode/util/Utils$Task;)Lcom/blankj/utilcode/util/Utils$Task;

    move-result-object p0

    return-object p0
.end method

.method public static getGatewayByWifi()Ljava/lang/String;
    .registers 2

    .line 669
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v0

    const-string v1, "wifi"

    invoke-virtual {v0, v1}, Landroid/app/Application;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/wifi/WifiManager;

    if-nez v0, :cond_11

    const-string v0, ""

    return-object v0

    .line 671
    :cond_11
    invoke-virtual {v0}, Landroid/net/wifi/WifiManager;->getDhcpInfo()Landroid/net/DhcpInfo;

    move-result-object v0

    iget v0, v0, Landroid/net/DhcpInfo;->gateway:I

    invoke-static {v0}, Landroid/text/format/Formatter;->formatIpAddress(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getIPAddress(Z)Ljava/lang/String;
    .registers 5

    .line 549
    :try_start_0
    invoke-static {}, Ljava/net/NetworkInterface;->getNetworkInterfaces()Ljava/util/Enumeration;

    move-result-object v0

    .line 550
    new-instance v1, Ljava/util/LinkedList;

    invoke-direct {v1}, Ljava/util/LinkedList;-><init>()V

    .line 551
    :cond_9
    :goto_9
    invoke-interface {v0}, Ljava/util/Enumeration;->hasMoreElements()Z

    move-result v2

    if-eqz v2, :cond_36

    .line 552
    invoke-interface {v0}, Ljava/util/Enumeration;->nextElement()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/net/NetworkInterface;

    .line 554
    invoke-virtual {v2}, Ljava/net/NetworkInterface;->isUp()Z

    move-result v3

    if-eqz v3, :cond_9

    invoke-virtual {v2}, Ljava/net/NetworkInterface;->isLoopback()Z

    move-result v3

    if-eqz v3, :cond_22

    goto :goto_9

    .line 555
    :cond_22
    invoke-virtual {v2}, Ljava/net/NetworkInterface;->getInetAddresses()Ljava/util/Enumeration;

    move-result-object v2

    .line 556
    :goto_26
    invoke-interface {v2}, Ljava/util/Enumeration;->hasMoreElements()Z

    move-result v3

    if-eqz v3, :cond_9

    .line 557
    invoke-interface {v2}, Ljava/util/Enumeration;->nextElement()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/net/InetAddress;

    invoke-virtual {v1, v3}, Ljava/util/LinkedList;->addFirst(Ljava/lang/Object;)V

    goto :goto_26

    .line 560
    :cond_36
    invoke-virtual {v1}, Ljava/util/LinkedList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :cond_3a
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_7d

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/net/InetAddress;

    .line 561
    invoke-virtual {v1}, Ljava/net/InetAddress;->isLoopbackAddress()Z

    move-result v2

    if-nez v2, :cond_3a

    .line 562
    invoke-virtual {v1}, Ljava/net/InetAddress;->getHostAddress()Ljava/lang/String;

    move-result-object v1

    const/16 v2, 0x3a

    .line 563
    invoke-virtual {v1, v2}, Ljava/lang/String;->indexOf(I)I

    move-result v2

    const/4 v3, 0x0

    if-gez v2, :cond_5b

    const/4 v2, 0x1

    goto :goto_5c

    :cond_5b
    move v2, v3

    :goto_5c
    if-eqz p0, :cond_61

    if-eqz v2, :cond_3a

    return-object v1

    :cond_61
    if-nez v2, :cond_3a

    const/16 p0, 0x25

    .line 568
    invoke-virtual {v1, p0}, Ljava/lang/String;->indexOf(I)I

    move-result p0

    if-gez p0, :cond_70

    .line 570
    invoke-virtual {v1}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object p0

    goto :goto_78

    .line 571
    :cond_70
    invoke-virtual {v1, v3, p0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object p0

    invoke-virtual {p0}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object p0
    :try_end_78
    .catch Ljava/net/SocketException; {:try_start_0 .. :try_end_78} :catch_79

    :goto_78
    return-object p0

    :catch_79
    move-exception p0

    .line 577
    invoke-virtual {p0}, Ljava/net/SocketException;->printStackTrace()V

    :cond_7d
    const-string p0, ""

    return-object p0
.end method

.method public static getIPAddressAsync(ZLcom/blankj/utilcode/util/Utils$Consumer;)Lcom/blankj/utilcode/util/Utils$Task;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(Z",
            "Lcom/blankj/utilcode/util/Utils$Consumer<",
            "Ljava/lang/String;",
            ">;)",
            "Lcom/blankj/utilcode/util/Utils$Task<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .line 530
    new-instance v0, Lcom/blankj/utilcode/util/NetworkUtils$5;

    invoke-direct {v0, p1, p0}, Lcom/blankj/utilcode/util/NetworkUtils$5;-><init>(Lcom/blankj/utilcode/util/Utils$Consumer;Z)V

    invoke-static {v0}, Lcom/blankj/utilcode/util/UtilsBridge;->doAsync(Lcom/blankj/utilcode/util/Utils$Task;)Lcom/blankj/utilcode/util/Utils$Task;

    move-result-object p0

    return-object p0
.end method

.method public static getIpAddressByWifi()Ljava/lang/String;
    .registers 2

    .line 656
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v0

    const-string v1, "wifi"

    invoke-virtual {v0, v1}, Landroid/app/Application;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/wifi/WifiManager;

    if-nez v0, :cond_11

    const-string v0, ""

    return-object v0

    .line 658
    :cond_11
    invoke-virtual {v0}, Landroid/net/wifi/WifiManager;->getDhcpInfo()Landroid/net/DhcpInfo;

    move-result-object v0

    iget v0, v0, Landroid/net/DhcpInfo;->ipAddress:I

    invoke-static {v0}, Landroid/text/format/Formatter;->formatIpAddress(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getMobileDataEnabled()Z
    .registers 3

    const/4 v0, 0x0

    .line 250
    :try_start_1
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v1

    const-string v2, "phone"

    invoke-virtual {v1, v2}, Landroid/app/Application;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/telephony/TelephonyManager;

    if-nez v1, :cond_10

    return v0

    .line 253
    :cond_10
    invoke-virtual {v1}, Landroid/telephony/TelephonyManager;->isDataEnabled()Z

    move-result v0
    :try_end_14
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_14} :catch_15

    return v0

    :catch_15
    move-exception v1

    .line 262
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    return v0
.end method

.method public static getNetMaskByWifi()Ljava/lang/String;
    .registers 2

    .line 682
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v0

    const-string v1, "wifi"

    invoke-virtual {v0, v1}, Landroid/app/Application;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/wifi/WifiManager;

    if-nez v0, :cond_11

    const-string v0, ""

    return-object v0

    .line 684
    :cond_11
    invoke-virtual {v0}, Landroid/net/wifi/WifiManager;->getDhcpInfo()Landroid/net/DhcpInfo;

    move-result-object v0

    iget v0, v0, Landroid/net/DhcpInfo;->netmask:I

    invoke-static {v0}, Landroid/text/format/Formatter;->formatIpAddress(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getNetworkOperatorName()Ljava/lang/String;
    .registers 2

    .line 419
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v0

    const-string v1, "phone"

    invoke-virtual {v0, v1}, Landroid/app/Application;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/telephony/TelephonyManager;

    if-nez v0, :cond_11

    const-string v0, ""

    return-object v0

    .line 421
    :cond_11
    invoke-virtual {v0}, Landroid/telephony/TelephonyManager;->getNetworkOperatorName()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getNetworkType()Lcom/blankj/utilcode/util/NetworkUtils$NetworkType;
    .registers 3

    .line 441
    invoke-static {}, Lcom/blankj/utilcode/util/NetworkUtils;->isEthernet()Z

    move-result v0

    if-eqz v0, :cond_9

    .line 442
    sget-object v0, Lcom/blankj/utilcode/util/NetworkUtils$NetworkType;->NETWORK_ETHERNET:Lcom/blankj/utilcode/util/NetworkUtils$NetworkType;

    return-object v0

    .line 444
    :cond_9
    invoke-static {}, Lcom/blankj/utilcode/util/NetworkUtils;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v0

    if-eqz v0, :cond_5e

    .line 445
    invoke-virtual {v0}, Landroid/net/NetworkInfo;->isAvailable()Z

    move-result v1

    if-eqz v1, :cond_5e

    .line 446
    invoke-virtual {v0}, Landroid/net/NetworkInfo;->getType()I

    move-result v1

    const/4 v2, 0x1

    if-ne v1, v2, :cond_1f

    .line 447
    sget-object v0, Lcom/blankj/utilcode/util/NetworkUtils$NetworkType;->NETWORK_WIFI:Lcom/blankj/utilcode/util/NetworkUtils$NetworkType;

    return-object v0

    .line 448
    :cond_1f
    invoke-virtual {v0}, Landroid/net/NetworkInfo;->getType()I

    move-result v1

    if-nez v1, :cond_5b

    .line 449
    invoke-virtual {v0}, Landroid/net/NetworkInfo;->getSubtype()I

    move-result v1

    packed-switch v1, :pswitch_data_62

    .line 477
    :pswitch_2c
    invoke-virtual {v0}, Landroid/net/NetworkInfo;->getSubtypeName()Ljava/lang/String;

    move-result-object v0

    const-string v1, "TD-SCDMA"

    .line 478
    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_58

    const-string v1, "WCDMA"

    .line 479
    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_58

    const-string v1, "CDMA2000"

    .line 480
    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_55

    goto :goto_58

    .line 475
    :pswitch_49
    sget-object v0, Lcom/blankj/utilcode/util/NetworkUtils$NetworkType;->NETWORK_5G:Lcom/blankj/utilcode/util/NetworkUtils$NetworkType;

    return-object v0

    .line 472
    :pswitch_4c
    sget-object v0, Lcom/blankj/utilcode/util/NetworkUtils$NetworkType;->NETWORK_4G:Lcom/blankj/utilcode/util/NetworkUtils$NetworkType;

    return-object v0

    .line 468
    :pswitch_4f
    sget-object v0, Lcom/blankj/utilcode/util/NetworkUtils$NetworkType;->NETWORK_3G:Lcom/blankj/utilcode/util/NetworkUtils$NetworkType;

    return-object v0

    .line 456
    :pswitch_52
    sget-object v0, Lcom/blankj/utilcode/util/NetworkUtils$NetworkType;->NETWORK_2G:Lcom/blankj/utilcode/util/NetworkUtils$NetworkType;

    return-object v0

    .line 483
    :cond_55
    sget-object v0, Lcom/blankj/utilcode/util/NetworkUtils$NetworkType;->NETWORK_UNKNOWN:Lcom/blankj/utilcode/util/NetworkUtils$NetworkType;

    return-object v0

    .line 481
    :cond_58
    :goto_58
    sget-object v0, Lcom/blankj/utilcode/util/NetworkUtils$NetworkType;->NETWORK_3G:Lcom/blankj/utilcode/util/NetworkUtils$NetworkType;

    return-object v0

    .line 487
    :cond_5b
    sget-object v0, Lcom/blankj/utilcode/util/NetworkUtils$NetworkType;->NETWORK_UNKNOWN:Lcom/blankj/utilcode/util/NetworkUtils$NetworkType;

    return-object v0

    .line 490
    :cond_5e
    sget-object v0, Lcom/blankj/utilcode/util/NetworkUtils$NetworkType;->NETWORK_NO:Lcom/blankj/utilcode/util/NetworkUtils$NetworkType;

    return-object v0

    nop

    :pswitch_data_62
    .packed-switch 0x1
        :pswitch_52
        :pswitch_52
        :pswitch_4f
        :pswitch_52
        :pswitch_4f
        :pswitch_4f
        :pswitch_52
        :pswitch_4f
        :pswitch_4f
        :pswitch_4f
        :pswitch_52
        :pswitch_4f
        :pswitch_4c
        :pswitch_4f
        :pswitch_4f
        :pswitch_52
        :pswitch_4f
        :pswitch_4c
        :pswitch_2c
        :pswitch_49
    .end packed-switch
.end method

.method public static getSSID()Ljava/lang/String;
    .registers 4

    .line 707
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Application;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    const-string v1, "wifi"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/wifi/WifiManager;

    const-string v1, ""

    if-nez v0, :cond_15

    return-object v1

    .line 709
    :cond_15
    invoke-virtual {v0}, Landroid/net/wifi/WifiManager;->getConnectionInfo()Landroid/net/wifi/WifiInfo;

    move-result-object v0

    if-nez v0, :cond_1c

    return-object v1

    .line 711
    :cond_1c
    invoke-virtual {v0}, Landroid/net/wifi/WifiInfo;->getSSID()Ljava/lang/String;

    move-result-object v0

    .line 712
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_27

    return-object v1

    .line 715
    :cond_27
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v1

    const/4 v2, 0x2

    if-le v1, v2, :cond_4c

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/lang/String;->charAt(I)C

    move-result v1

    const/16 v2, 0x22

    if-ne v1, v2, :cond_4c

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v1

    const/4 v3, 0x1

    sub-int/2addr v1, v3

    invoke-virtual {v0, v1}, Ljava/lang/String;->charAt(I)C

    move-result v1

    if-ne v1, v2, :cond_4c

    .line 716
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v1

    sub-int/2addr v1, v3

    invoke-virtual {v0, v3, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    :cond_4c
    return-object v0
.end method

.method public static getServerAddressByWifi()Ljava/lang/String;
    .registers 2

    .line 695
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v0

    const-string v1, "wifi"

    invoke-virtual {v0, v1}, Landroid/app/Application;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/wifi/WifiManager;

    if-nez v0, :cond_11

    const-string v0, ""

    return-object v0

    .line 697
    :cond_11
    invoke-virtual {v0}, Landroid/net/wifi/WifiManager;->getDhcpInfo()Landroid/net/DhcpInfo;

    move-result-object v0

    iget v0, v0, Landroid/net/DhcpInfo;->serverAddress:I

    invoke-static {v0}, Landroid/text/format/Formatter;->formatIpAddress(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getWifiEnabled()Z
    .registers 2

    .line 346
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v0

    const-string v1, "wifi"

    invoke-virtual {v0, v1}, Landroid/app/Application;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/wifi/WifiManager;

    if-nez v0, :cond_10

    const/4 v0, 0x0

    return v0

    .line 348
    :cond_10
    invoke-virtual {v0}, Landroid/net/wifi/WifiManager;->isWifiEnabled()Z

    move-result v0

    return v0
.end method

.method public static getWifiScanResult()Lcom/blankj/utilcode/util/NetworkUtils$WifiScanResults;
    .registers 3

    .line 752
    new-instance v0, Lcom/blankj/utilcode/util/NetworkUtils$WifiScanResults;

    invoke-direct {v0}, Lcom/blankj/utilcode/util/NetworkUtils$WifiScanResults;-><init>()V

    .line 753
    invoke-static {}, Lcom/blankj/utilcode/util/NetworkUtils;->getWifiEnabled()Z

    move-result v1

    if-nez v1, :cond_c

    return-object v0

    .line 755
    :cond_c
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v1

    const-string v2, "wifi"

    invoke-virtual {v1, v2}, Landroid/app/Application;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/net/wifi/WifiManager;

    .line 757
    invoke-virtual {v1}, Landroid/net/wifi/WifiManager;->getScanResults()Ljava/util/List;

    move-result-object v1

    if-eqz v1, :cond_21

    .line 759
    invoke-virtual {v0, v1}, Lcom/blankj/utilcode/util/NetworkUtils$WifiScanResults;->setAllResults(Ljava/util/List;)V

    :cond_21
    return-object v0
.end method

.method public static is4G()Z
    .registers 2

    .line 317
    invoke-static {}, Lcom/blankj/utilcode/util/NetworkUtils;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v0

    if-eqz v0, :cond_16

    .line 319
    invoke-virtual {v0}, Landroid/net/NetworkInfo;->isAvailable()Z

    move-result v1

    if-eqz v1, :cond_16

    .line 320
    invoke-virtual {v0}, Landroid/net/NetworkInfo;->getSubtype()I

    move-result v0

    const/16 v1, 0xd

    if-ne v0, v1, :cond_16

    const/4 v0, 0x1

    goto :goto_17

    :cond_16
    const/4 v0, 0x0

    :goto_17
    return v0
.end method

.method public static is5G()Z
    .registers 2

    .line 331
    invoke-static {}, Lcom/blankj/utilcode/util/NetworkUtils;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v0

    if-eqz v0, :cond_16

    .line 333
    invoke-virtual {v0}, Landroid/net/NetworkInfo;->isAvailable()Z

    move-result v1

    if-eqz v1, :cond_16

    .line 334
    invoke-virtual {v0}, Landroid/net/NetworkInfo;->getSubtype()I

    move-result v0

    const/16 v1, 0x14

    if-ne v0, v1, :cond_16

    const/4 v0, 0x1

    goto :goto_17

    :cond_16
    const/4 v0, 0x0

    :goto_17
    return v0
.end method

.method public static isAvailable()Z
    .registers 1

    .line 119
    invoke-static {}, Lcom/blankj/utilcode/util/NetworkUtils;->isAvailableByDns()Z

    move-result v0

    if-nez v0, :cond_10

    const/4 v0, 0x0

    invoke-static {v0}, Lcom/blankj/utilcode/util/NetworkUtils;->isAvailableByPing(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_e

    goto :goto_10

    :cond_e
    const/4 v0, 0x0

    goto :goto_11

    :cond_10
    :goto_10
    const/4 v0, 0x1

    :goto_11
    return v0
.end method

.method public static isAvailableAsync(Lcom/blankj/utilcode/util/Utils$Consumer;)Lcom/blankj/utilcode/util/Utils$Task;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/blankj/utilcode/util/Utils$Consumer<",
            "Ljava/lang/Boolean;",
            ">;)",
            "Lcom/blankj/utilcode/util/Utils$Task<",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation

    .line 102
    new-instance v0, Lcom/blankj/utilcode/util/NetworkUtils$1;

    invoke-direct {v0, p0}, Lcom/blankj/utilcode/util/NetworkUtils$1;-><init>(Lcom/blankj/utilcode/util/Utils$Consumer;)V

    invoke-static {v0}, Lcom/blankj/utilcode/util/UtilsBridge;->doAsync(Lcom/blankj/utilcode/util/Utils$Task;)Lcom/blankj/utilcode/util/Utils$Task;

    move-result-object p0

    return-object p0
.end method

.method public static isAvailableByDns()Z
    .registers 1

    const-string v0, ""

    .line 219
    invoke-static {v0}, Lcom/blankj/utilcode/util/NetworkUtils;->isAvailableByDns(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public static isAvailableByDns(Ljava/lang/String;)Z
    .registers 2

    .line 231
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_8

    const-string p0, "www.baidu.com"

    :cond_8
    const/4 v0, 0x0

    .line 234
    :try_start_9
    invoke-static {p0}, Ljava/net/InetAddress;->getByName(Ljava/lang/String;)Ljava/net/InetAddress;

    move-result-object p0
    :try_end_d
    .catch Ljava/net/UnknownHostException; {:try_start_9 .. :try_end_d} :catch_11

    if-eqz p0, :cond_10

    const/4 v0, 0x1

    :cond_10
    return v0

    :catch_11
    move-exception p0

    .line 237
    invoke-virtual {p0}, Ljava/net/UnknownHostException;->printStackTrace()V

    return v0
.end method

.method public static isAvailableByDnsAsync(Ljava/lang/String;Lcom/blankj/utilcode/util/Utils$Consumer;)Lcom/blankj/utilcode/util/Utils$Task;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/blankj/utilcode/util/Utils$Consumer<",
            "Ljava/lang/Boolean;",
            ">;)",
            "Lcom/blankj/utilcode/util/Utils$Task;"
        }
    .end annotation

    .line 202
    new-instance v0, Lcom/blankj/utilcode/util/NetworkUtils$3;

    invoke-direct {v0, p1, p0}, Lcom/blankj/utilcode/util/NetworkUtils$3;-><init>(Lcom/blankj/utilcode/util/Utils$Consumer;Ljava/lang/String;)V

    invoke-static {v0}, Lcom/blankj/utilcode/util/UtilsBridge;->doAsync(Lcom/blankj/utilcode/util/Utils$Task;)Lcom/blankj/utilcode/util/Utils$Task;

    move-result-object p0

    return-object p0
.end method

.method public static isAvailableByDnsAsync(Lcom/blankj/utilcode/util/Utils$Consumer;)V
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/blankj/utilcode/util/Utils$Consumer<",
            "Ljava/lang/Boolean;",
            ">;)V"
        }
    .end annotation

    const-string v0, ""

    .line 188
    invoke-static {v0, p0}, Lcom/blankj/utilcode/util/NetworkUtils;->isAvailableByDnsAsync(Ljava/lang/String;Lcom/blankj/utilcode/util/Utils$Consumer;)Lcom/blankj/utilcode/util/Utils$Task;

    return-void
.end method

.method public static isAvailableByPing()Z
    .registers 1

    const-string v0, ""

    .line 163
    invoke-static {v0}, Lcom/blankj/utilcode/util/NetworkUtils;->isAvailableByPing(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public static isAvailableByPing(Ljava/lang/String;)Z
    .registers 4

    .line 175
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_8

    const-string p0, "223.5.5.5"

    :cond_8
    const/4 v0, 0x1

    new-array v1, v0, [Ljava/lang/Object;

    const/4 v2, 0x0

    aput-object p0, v1, v2

    const-string p0, "ping -c 1 %s"

    .line 176
    invoke-static {p0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object p0

    invoke-static {p0, v2}, Lcom/blankj/utilcode/util/ShellUtils;->execCmd(Ljava/lang/String;Z)Lcom/blankj/utilcode/util/ShellUtils$CommandResult;

    move-result-object p0

    .line 177
    iget p0, p0, Lcom/blankj/utilcode/util/ShellUtils$CommandResult;->result:I

    if-nez p0, :cond_1d

    goto :goto_1e

    :cond_1d
    move v0, v2

    :goto_1e
    return v0
.end method

.method public static isAvailableByPingAsync(Ljava/lang/String;Lcom/blankj/utilcode/util/Utils$Consumer;)Lcom/blankj/utilcode/util/Utils$Task;
    .registers 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/blankj/utilcode/util/Utils$Consumer<",
            "Ljava/lang/Boolean;",
            ">;)",
            "Lcom/blankj/utilcode/util/Utils$Task<",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation

    .line 145
    new-instance v0, Lcom/blankj/utilcode/util/NetworkUtils$2;

    invoke-direct {v0, p1, p0}, Lcom/blankj/utilcode/util/NetworkUtils$2;-><init>(Lcom/blankj/utilcode/util/Utils$Consumer;Ljava/lang/String;)V

    invoke-static {v0}, Lcom/blankj/utilcode/util/UtilsBridge;->doAsync(Lcom/blankj/utilcode/util/Utils$Task;)Lcom/blankj/utilcode/util/Utils$Task;

    move-result-object p0

    return-object p0
.end method

.method public static isAvailableByPingAsync(Lcom/blankj/utilcode/util/Utils$Consumer;)V
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/blankj/utilcode/util/Utils$Consumer<",
            "Ljava/lang/Boolean;",
            ">;)V"
        }
    .end annotation

    const-string v0, ""

    .line 131
    invoke-static {v0, p0}, Lcom/blankj/utilcode/util/NetworkUtils;->isAvailableByPingAsync(Ljava/lang/String;Lcom/blankj/utilcode/util/Utils$Consumer;)Lcom/blankj/utilcode/util/Utils$Task;

    return-void
.end method

.method public static isBehindProxy()Z
    .registers 1

    const-string v0, "http.proxyHost"

    .line 273
    invoke-static {v0}, Ljava/lang/System;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_12

    const-string v0, "http.proxyPort"

    invoke-static {v0}, Ljava/lang/System;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_12

    const/4 v0, 0x1

    goto :goto_13

    :cond_12
    const/4 v0, 0x0

    :goto_13
    return v0
.end method

.method public static isConnected()Z
    .registers 1

    .line 89
    invoke-static {}, Lcom/blankj/utilcode/util/NetworkUtils;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v0

    if-eqz v0, :cond_e

    .line 90
    invoke-virtual {v0}, Landroid/net/NetworkInfo;->isConnected()Z

    move-result v0

    if-eqz v0, :cond_e

    const/4 v0, 0x1

    goto :goto_f

    :cond_e
    const/4 v0, 0x0

    :goto_f
    return v0
.end method

.method private static isEthernet()Z
    .registers 3

    .line 503
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v0

    const-string v1, "connectivity"

    invoke-virtual {v0, v1}, Landroid/app/Application;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/ConnectivityManager;

    const/4 v1, 0x0

    if-nez v0, :cond_10

    return v1

    :cond_10
    const/16 v2, 0x9

    .line 505
    invoke-virtual {v0, v2}, Landroid/net/ConnectivityManager;->getNetworkInfo(I)Landroid/net/NetworkInfo;

    move-result-object v0

    if-nez v0, :cond_19

    return v1

    .line 507
    :cond_19
    invoke-virtual {v0}, Landroid/net/NetworkInfo;->getState()Landroid/net/NetworkInfo$State;

    move-result-object v0

    if-nez v0, :cond_20

    return v1

    .line 509
    :cond_20
    sget-object v2, Landroid/net/NetworkInfo$State;->CONNECTED:Landroid/net/NetworkInfo$State;

    if-eq v0, v2, :cond_28

    sget-object v2, Landroid/net/NetworkInfo$State;->CONNECTING:Landroid/net/NetworkInfo$State;

    if-ne v0, v2, :cond_29

    :cond_28
    const/4 v1, 0x1

    :cond_29
    return v1
.end method

.method public static isMobileData()Z
    .registers 2

    .line 303
    invoke-static {}, Lcom/blankj/utilcode/util/NetworkUtils;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v0

    if-eqz v0, :cond_14

    .line 305
    invoke-virtual {v0}, Landroid/net/NetworkInfo;->isAvailable()Z

    move-result v1

    if-eqz v1, :cond_14

    .line 306
    invoke-virtual {v0}, Landroid/net/NetworkInfo;->getType()I

    move-result v0

    if-nez v0, :cond_14

    const/4 v0, 0x1

    goto :goto_15

    :cond_14
    const/4 v0, 0x0

    :goto_15
    return v0
.end method

.method public static isRegisteredNetworkStatusChangedListener(Lcom/blankj/utilcode/util/NetworkUtils$OnNetworkStatusChangedListener;)Z
    .registers 2

    .line 738
    # invokes: Lcom/blankj/utilcode/util/NetworkUtils$NetworkChangedReceiver;->getInstance()Lcom/blankj/utilcode/util/NetworkUtils$NetworkChangedReceiver;
    invoke-static {}, Lcom/blankj/utilcode/util/NetworkUtils$NetworkChangedReceiver;->access$000()Lcom/blankj/utilcode/util/NetworkUtils$NetworkChangedReceiver;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/blankj/utilcode/util/NetworkUtils$NetworkChangedReceiver;->isRegistered(Lcom/blankj/utilcode/util/NetworkUtils$OnNetworkStatusChangedListener;)Z

    move-result p0

    return p0
.end method

.method private static isSameScanResultContent(Landroid/net/wifi/ScanResult;Landroid/net/wifi/ScanResult;)Z
    .registers 4

    if-eqz p0, :cond_2a

    if-eqz p1, :cond_2a

    .line 861
    iget-object v0, p0, Landroid/net/wifi/ScanResult;->BSSID:Ljava/lang/String;

    iget-object v1, p1, Landroid/net/wifi/ScanResult;->BSSID:Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/blankj/utilcode/util/UtilsBridge;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_2a

    iget-object v0, p0, Landroid/net/wifi/ScanResult;->SSID:Ljava/lang/String;

    iget-object v1, p1, Landroid/net/wifi/ScanResult;->SSID:Ljava/lang/String;

    .line 862
    invoke-static {v0, v1}, Lcom/blankj/utilcode/util/UtilsBridge;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_2a

    iget-object v0, p0, Landroid/net/wifi/ScanResult;->capabilities:Ljava/lang/String;

    iget-object v1, p1, Landroid/net/wifi/ScanResult;->capabilities:Ljava/lang/String;

    .line 863
    invoke-static {v0, v1}, Lcom/blankj/utilcode/util/UtilsBridge;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_2a

    iget p0, p0, Landroid/net/wifi/ScanResult;->level:I

    iget p1, p1, Landroid/net/wifi/ScanResult;->level:I

    if-ne p0, p1, :cond_2a

    const/4 p0, 0x1

    goto :goto_2b

    :cond_2a
    const/4 p0, 0x0

    :goto_2b
    return p0
.end method

.method private static isSameScanResults(Ljava/util/List;Ljava/util/List;)Z
    .registers 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List<",
            "Landroid/net/wifi/ScanResult;",
            ">;",
            "Ljava/util/List<",
            "Landroid/net/wifi/ScanResult;",
            ">;)Z"
        }
    .end annotation

    const/4 v0, 0x1

    if-nez p0, :cond_6

    if-nez p1, :cond_6

    return v0

    :cond_6
    const/4 v1, 0x0

    if-eqz p0, :cond_35

    if-nez p1, :cond_c

    goto :goto_35

    .line 847
    :cond_c
    invoke-interface {p0}, Ljava/util/List;->size()I

    move-result v2

    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v3

    if-eq v2, v3, :cond_17

    return v1

    :cond_17
    move v2, v1

    .line 850
    :goto_18
    invoke-interface {p0}, Ljava/util/List;->size()I

    move-result v3

    if-ge v2, v3, :cond_34

    .line 851
    invoke-interface {p0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/net/wifi/ScanResult;

    .line 852
    invoke-interface {p1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/net/wifi/ScanResult;

    .line 853
    invoke-static {v3, v4}, Lcom/blankj/utilcode/util/NetworkUtils;->isSameScanResultContent(Landroid/net/wifi/ScanResult;Landroid/net/wifi/ScanResult;)Z

    move-result v3

    if-nez v3, :cond_31

    return v1

    :cond_31
    add-int/lit8 v2, v2, 0x1

    goto :goto_18

    :cond_34
    return v0

    :cond_35
    :goto_35
    return v1
.end method

.method public static isUsingVPN()Z
    .registers 3

    .line 282
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v0

    const-string v1, "connectivity"

    invoke-virtual {v0, v1}, Landroid/app/Application;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/ConnectivityManager;

    .line 283
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x1c

    if-lt v1, v2, :cond_1d

    const/16 v1, 0x11

    .line 284
    invoke-virtual {v0, v1}, Landroid/net/ConnectivityManager;->getNetworkInfo(I)Landroid/net/NetworkInfo;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/NetworkInfo;->isConnectedOrConnecting()Z

    move-result v0

    return v0

    :cond_1d
    const/4 v1, 0x4

    .line 286
    invoke-virtual {v0, v1}, Landroid/net/ConnectivityManager;->getNetworkInfo(I)Landroid/net/NetworkInfo;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/NetworkInfo;->isConnectedOrConnecting()Z

    move-result v0

    return v0
.end method

.method public static isWifiAvailable()Z
    .registers 1

    .line 390
    invoke-static {}, Lcom/blankj/utilcode/util/NetworkUtils;->getWifiEnabled()Z

    move-result v0

    if-eqz v0, :cond_e

    invoke-static {}, Lcom/blankj/utilcode/util/NetworkUtils;->isAvailable()Z

    move-result v0

    if-eqz v0, :cond_e

    const/4 v0, 0x1

    goto :goto_f

    :cond_e
    const/4 v0, 0x0

    :goto_f
    return v0
.end method

.method public static isWifiAvailableAsync(Lcom/blankj/utilcode/util/Utils$Consumer;)Lcom/blankj/utilcode/util/Utils$Task;
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/blankj/utilcode/util/Utils$Consumer<",
            "Ljava/lang/Boolean;",
            ">;)",
            "Lcom/blankj/utilcode/util/Utils$Task<",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation

    .line 403
    new-instance v0, Lcom/blankj/utilcode/util/NetworkUtils$4;

    invoke-direct {v0, p0}, Lcom/blankj/utilcode/util/NetworkUtils$4;-><init>(Lcom/blankj/utilcode/util/Utils$Consumer;)V

    invoke-static {v0}, Lcom/blankj/utilcode/util/UtilsBridge;->doAsync(Lcom/blankj/utilcode/util/Utils$Task;)Lcom/blankj/utilcode/util/Utils$Task;

    move-result-object p0

    return-object p0
.end method

.method public static isWifiConnected()Z
    .registers 3

    .line 375
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v0

    const-string v1, "connectivity"

    invoke-virtual {v0, v1}, Landroid/app/Application;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/ConnectivityManager;

    const/4 v1, 0x0

    if-nez v0, :cond_10

    return v1

    .line 377
    :cond_10
    invoke-virtual {v0}, Landroid/net/ConnectivityManager;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v0

    if-eqz v0, :cond_1e

    .line 378
    invoke-virtual {v0}, Landroid/net/NetworkInfo;->getType()I

    move-result v0

    const/4 v2, 0x1

    if-ne v0, v2, :cond_1e

    move v1, v2

    :cond_1e
    return v1
.end method

.method public static openWirelessSettings()V
    .registers 3

    .line 75
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v0

    new-instance v1, Landroid/content/Intent;

    const-string v2, "android.settings.WIRELESS_SETTINGS"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    const/high16 v2, 0x10000000

    .line 77
    invoke-virtual {v1, v2}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    move-result-object v1

    .line 75
    invoke-virtual {v0, v1}, Landroid/app/Application;->startActivity(Landroid/content/Intent;)V

    return-void
.end method

.method public static registerNetworkStatusChangedListener(Lcom/blankj/utilcode/util/NetworkUtils$OnNetworkStatusChangedListener;)V
    .registers 2

    .line 728
    # invokes: Lcom/blankj/utilcode/util/NetworkUtils$NetworkChangedReceiver;->getInstance()Lcom/blankj/utilcode/util/NetworkUtils$NetworkChangedReceiver;
    invoke-static {}, Lcom/blankj/utilcode/util/NetworkUtils$NetworkChangedReceiver;->access$000()Lcom/blankj/utilcode/util/NetworkUtils$NetworkChangedReceiver;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/blankj/utilcode/util/NetworkUtils$NetworkChangedReceiver;->registerListener(Lcom/blankj/utilcode/util/NetworkUtils$OnNetworkStatusChangedListener;)V

    return-void
.end method

.method public static removeOnWifiChangedConsumer(Lcom/blankj/utilcode/util/Utils$Consumer;)V
    .registers 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/blankj/utilcode/util/Utils$Consumer<",
            "Lcom/blankj/utilcode/util/NetworkUtils$WifiScanResults;",
            ">;)V"
        }
    .end annotation

    if-nez p0, :cond_3

    return-void

    .line 822
    :cond_3
    new-instance v0, Lcom/blankj/utilcode/util/NetworkUtils$9;

    invoke-direct {v0, p0}, Lcom/blankj/utilcode/util/NetworkUtils$9;-><init>(Lcom/blankj/utilcode/util/Utils$Consumer;)V

    invoke-static {v0}, Lcom/blankj/utilcode/util/UtilsBridge;->runOnUiThread(Ljava/lang/Runnable;)V

    return-void
.end method

.method public static setWifiEnabled(Z)V
    .registers 3

    .line 360
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v0

    const-string v1, "wifi"

    invoke-virtual {v0, v1}, Landroid/app/Application;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/wifi/WifiManager;

    if-nez v0, :cond_f

    return-void

    .line 362
    :cond_f
    invoke-virtual {v0}, Landroid/net/wifi/WifiManager;->isWifiEnabled()Z

    move-result v1

    if-ne p0, v1, :cond_16

    return-void

    .line 363
    :cond_16
    invoke-virtual {v0, p0}, Landroid/net/wifi/WifiManager;->setWifiEnabled(Z)Z

    return-void
.end method

.method private static startScanWifi()V
    .registers 7

    .line 787
    new-instance v0, Lcom/blankj/utilcode/util/NetworkUtils$WifiScanResults;

    invoke-direct {v0}, Lcom/blankj/utilcode/util/NetworkUtils$WifiScanResults;-><init>()V

    sput-object v0, Lcom/blankj/utilcode/util/NetworkUtils;->sPreWifiScanResults:Lcom/blankj/utilcode/util/NetworkUtils$WifiScanResults;

    .line 788
    new-instance v1, Ljava/util/Timer;

    invoke-direct {v1}, Ljava/util/Timer;-><init>()V

    sput-object v1, Lcom/blankj/utilcode/util/NetworkUtils;->sScanWifiTimer:Ljava/util/Timer;

    .line 789
    new-instance v2, Lcom/blankj/utilcode/util/NetworkUtils$8;

    invoke-direct {v2}, Lcom/blankj/utilcode/util/NetworkUtils$8;-><init>()V

    const-wide/16 v3, 0x0

    const-wide/16 v5, 0xbb8

    invoke-virtual/range {v1 .. v6}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;JJ)V

    return-void
.end method

.method private static startScanWifiIfEnabled()V
    .registers 2

    .line 813
    invoke-static {}, Lcom/blankj/utilcode/util/NetworkUtils;->getWifiEnabled()Z

    move-result v0

    if-nez v0, :cond_7

    return-void

    .line 815
    :cond_7
    invoke-static {}, Lcom/blankj/utilcode/util/Utils;->getApp()Landroid/app/Application;

    move-result-object v0

    const-string v1, "wifi"

    invoke-virtual {v0, v1}, Landroid/app/Application;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/wifi/WifiManager;

    .line 817
    invoke-virtual {v0}, Landroid/net/wifi/WifiManager;->startScan()Z

    return-void
.end method

.method private static stopScanWifi()V
    .registers 1

    .line 834
    sget-object v0, Lcom/blankj/utilcode/util/NetworkUtils;->sScanWifiTimer:Ljava/util/Timer;

    if-eqz v0, :cond_a

    .line 835
    invoke-virtual {v0}, Ljava/util/Timer;->cancel()V

    const/4 v0, 0x0

    .line 836
    sput-object v0, Lcom/blankj/utilcode/util/NetworkUtils;->sScanWifiTimer:Ljava/util/Timer;

    :cond_a
    return-void
.end method

.method public static unregisterNetworkStatusChangedListener(Lcom/blankj/utilcode/util/NetworkUtils$OnNetworkStatusChangedListener;)V
    .registers 2

    .line 747
    # invokes: Lcom/blankj/utilcode/util/NetworkUtils$NetworkChangedReceiver;->getInstance()Lcom/blankj/utilcode/util/NetworkUtils$NetworkChangedReceiver;
    invoke-static {}, Lcom/blankj/utilcode/util/NetworkUtils$NetworkChangedReceiver;->access$000()Lcom/blankj/utilcode/util/NetworkUtils$NetworkChangedReceiver;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/blankj/utilcode/util/NetworkUtils$NetworkChangedReceiver;->unregisterListener(Lcom/blankj/utilcode/util/NetworkUtils$OnNetworkStatusChangedListener;)V

    return-void
.end method
