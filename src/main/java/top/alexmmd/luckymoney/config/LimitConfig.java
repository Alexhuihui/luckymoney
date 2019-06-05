package top.alexmmd.luckymoney.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author 汪永晖
 */
@Data
@ConfigurationProperties(prefix = "limit")
@Component
public class LimitConfig {

    private BigDecimal minMoney;

    private BigDecimal maxMoney;

    private String description;
}
