package minhquan.com.entity.impl.bill;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter @Setter
@ToString
@NoArgsConstructor
public class Bill {
    private int id;
    private int menuId;
    private BigDecimal price;
    private LocalDateTime orderedTime;

    public static Bill getInstance() {
        return new Bill();
    }
}
