package Service.utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FeatureListV2 {
    Boolean voiceAds;
    PaymentConfirmationModeVO paymentConfirmationMode;

}
