package Sevryugin.task3;

import lombok.Data;

/**\
 * POJO класс цветок, нужен для хранения данных из XML документа
 */
@Data
public class Plant {
    private String common;
    private String botanical;
    private String zone;
    private String light;
    private String price;
    private String availability;
}
