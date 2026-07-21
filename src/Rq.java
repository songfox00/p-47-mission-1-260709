import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Rq {

    private String cmd;
    private String actionName;
    private Map<String, String> paramMap = new HashMap<>();

    public Rq(String cmd) {
        this.cmd=cmd;

        //목록?keywordType=content&keyword=과거
        String[] cmdBits = cmd.split("\\?");
        actionName=cmdBits[0];

        String queryString = cmdBits.length > 1 ? cmdBits[1] : "";
        String[] queryStringBits = queryString.split("&");

        paramMap = Arrays.stream(queryStringBits) // key1=value1, key2=value2 ...
                .map(part -> part.split("="))
                .filter(bits -> bits.length == 2 && bits[0] != null && bits[1] != null)// [key1, value1]
                .collect(
                        Collectors.toMap(
                                bits -> bits[0],
                                bits -> bits[1]
                        )
                );
    }

    public String getActionName(){

        return actionName;
    }

    public String getParam(String key, String defaultValue){

        return paramMap.getOrDefault(key,defaultValue);

    }

    public int getParamAsInt(String key, int defaultValue){

        String rst = getParam(key,"");

        try{
            return Integer.parseInt(rst);
        } catch (NumberFormatException e){
            return defaultValue;

        }
    }
}
