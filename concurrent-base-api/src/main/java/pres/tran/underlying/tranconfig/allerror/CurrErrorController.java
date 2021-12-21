package pres.tran.underlying.tranconfig.allerror;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class CurrErrorController extends BasicErrorController {

    @Value("${server.error.path:${error.path:/error}}")
    private String path;

    public CurrErrorController(ServerProperties serverProperties) {
        super(new DefaultErrorAttributes(), serverProperties.getError());
    }

    /**
     * 覆盖默认的JSON响应
     */
    @Override
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {

        HttpStatus status = getStatus(request);
        if (status == HttpStatus.NO_CONTENT) {
            return new ResponseEntity<>(status);
        }
        Map<String, Object> map = new HashMap<String, Object>(16);
        Map<String, Object> originalMsgMap = getErrorAttributes(request, getErrorAttributeOptions(request, MediaType.ALL));
        String path = (String)originalMsgMap.get("path");
        String error = (String)originalMsgMap.get("error");
        map.put("code", 100404);
        map.put("start",status.value());
        map.put("resMsg", "没有找到该资源，请检查服务是否注册成功");
        map.put("errorInfo",error);
        map.put("path",path);
        return new ResponseEntity<Map<String, Object>>(map, status);
    }


}
