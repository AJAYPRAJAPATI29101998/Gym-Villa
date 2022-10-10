package com.stackroute.paymentservice.paypalconfig;

import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.OAuthTokenCredential;
import com.paypal.base.rest.PayPalRESTException;
import lombok.NonNull;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

public class PayPalConfig {
    private String mode="sandbox";

    private String clientId="AZebFN6kJ8-iTRmLrcgHXcJeoGswllU2aA30UCTljTIw8x676JGYldrkoJbY2VT30QAUjLcsyOeYZ_-E";

    private String clientSecret="ELaROaUeu6mG5YRLcmpb9GzCG2563iWwRD-EV_jJOUzR499iCOmgOeio_7-Y4SlPuAONHp3p-tMvjKnw";

    @Bean
    public Map paypalSdkConfig() {
        Map configMap = new HashMap<>();
        configMap.put("mode", mode);
        return configMap;
    }


    @Bean
    public OAuthTokenCredential oAuthTokenCredential() {
        return new OAuthTokenCredential(clientId, clientSecret, paypalSdkConfig());
    }

    @Bean
    @NonNull
    public APIContext apiContext() throws PayPalRESTException {
        APIContext context = new APIContext(oAuthTokenCredential().getAccessToken());
        context.setConfigurationMap(paypalSdkConfig());
        return context;
    }


}
