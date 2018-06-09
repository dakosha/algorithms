package leetcode;

/**
 * @author Dauren Mussa
 * @since 5/16/18
 */
public class ValidateIpAddress {

    public static void main(String[] args) {
        ValidateIpAddress validateIpAddress = new ValidateIpAddress();

        String data = "0.0.0.-0";

        System.out.println(validateIpAddress.validIPAddress(data));
    }

    public String validIPAddress(String IP) {
        int dotIndex = IP.indexOf(".");
        int colonIndex = IP.indexOf(":");
        if (dotIndex > 0) {
            String[] tokens = IP.split("\\.");
            if (tokens.length != 4) {
                return "Neither";
            }

            StringBuilder temp = new StringBuilder();
            for (String token : tokens) {
                if (token.length() > 1 && token.startsWith("0")) {
                    return "Neither";
                } else {
                    try {
                        int number = Integer.parseInt(token);
                        if ((number < 0 || number > 255) || token.startsWith("-")) {
                            return "Neither";
                        }
                    } catch (Exception ex) {
                        return "Neither";
                    }
                }

                temp.append(token).append(".");
            }

            return (IP + ".").equals(temp.toString()) ? "IPv4" : "Neither";
        } else if (colonIndex > 0) {
            String[] tokens = IP.split(":");
            if (tokens.length != 8) {
                return "Neither";
            }

            StringBuilder temp = new StringBuilder();
            for (String token : tokens) {
                if (token.length() > 4 || token.startsWith("-")) {
                    return "Neither";
                }
                try {
                    int number = Integer.parseInt(token, 16);
                    if ((number < 0 || number > 0xffff)) {
                        return "Neither";
                    }
                } catch (Exception ex) {
                    return "Neither";
                }

                temp.append(token).append(":");
            }

            return (IP + ":").equals(temp.toString()) ? "IPv6" : "Neither";
        } else {
            return "Neither";
        }
    }

}
