package org.kob.backend.controller.record;

import com.alibaba.fastjson.JSONObject;
import org.kob.backend.service.record.GetRecordlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class GetRecordlistController {
    @Autowired
    private GetRecordlistService getRecordlistService;

    @GetMapping("/api/record/getlist/")
    JSONObject getList(@RequestParam Map<String, String> data) {
        Integer page = Integer.parseInt(data.get("page"));
        return getRecordlistService.getList(page);
    }
}
