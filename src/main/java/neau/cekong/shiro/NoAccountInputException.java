package neau.cekong.shiro;

import org.apache.shiro.authc.AccountException;

public class NoAccountInputException extends AccountException {
    public NoAccountInputException(String message) {
        super(message);
    }
}
