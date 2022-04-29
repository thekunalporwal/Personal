package Service.url;

import Service.utils.LombookCheck;
import Service.utils.StringEncoderUtil;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Test {

    public static void main(String[] args) throws JsonProcessingException {

        LombookCheck lombookCheck=new LombookCheck();
        lombookCheck.setIsCircleId(5);
        StringBuilder query = new StringBuilder( "SELECT CAM.ID, CAM.GL_CODE, CAM.GL_NAME, CAM.NARRATION AS DESCRIPTION, CAM.TXN_KEY, CAM.REF_KEY, CAM.STATUS FROM CTRL_ACCT_MASTER CAM");
        query.append(" WHERE CAM." + lombookCheck.getIsCircleId() + " =:searchVal");

        String str="<0.0% for transaction amount<=Rs.2000 & 0.9% + GST as applicable for transaction amount >Rs.2000 >";
        List<String> convertedCountriesList = Stream.of(str.split(",", -1))
                .collect(Collectors.toList());

        System.out.println(StringEncoderUtil.hasHtml(str));
        System.out.println(StringEncoderUtil.escapeHTML(str));

        System.out.println(convertedCountriesList);

    }
}
