package org.kob.backend.service.record;

import com.alibaba.fastjson.JSONObject;

public interface GetRecordlistService {
    JSONObject getList(Integer page);
}
