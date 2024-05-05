package InterfaceAndJavaBasics;

import lombok.Getter;

@Getter
public enum Enum1 {
    INDC("INDC", "PI","02PTMIND"),
    RBDC("RBDC", "PR","02PTMRBL"),
    YBDC("YBDC", "PY","02PTMYES"),
    IFDC("IFDC", "PF","02PTMIDF");

    private final String name;
    private final String tidPrefix;
    private final String mbidPrefix;

    Enum1(String name, String tidPrefix, String mbidPrefix) {
        this.name = name;
        this.tidPrefix = tidPrefix;
        this.mbidPrefix = mbidPrefix;
    }

    public static boolean Enum1(String bankName) {
        for (Enum1 bank : Enum1.values()) {
            if (bankName.equalsIgnoreCase(bank.name()))
                return true;
        }
        return false;
    }

    public static boolean isHitachiGatewayBanksV3(String bankName) {
        for (Enum1 bank : Enum1.values()) {
            if (bankName.equalsIgnoreCase(bank.name()))
                return true;
        }
        return false;
    }
}
