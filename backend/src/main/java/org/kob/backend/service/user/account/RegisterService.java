package org.kob.backend.service.user.account;

import java.util.Map;

public interface RegisterService {
    public Map<String,String> register(String username, String password, String confirmedPassword);
    // 传入参数：用户名、密码、确认密码
}
