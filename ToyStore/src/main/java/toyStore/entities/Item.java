package toyStore.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "master_inventory")
public class Item {


    @Id
    @NotNull
    private int itemId;

    private String sku;

    private String itemDescription;

    private String vendor;

    @NotNull
    private BigDecimal cost;

    private BigDecimal salePrice;

    @NotNull
    private int quantity;
}
