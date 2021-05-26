package module3.lesson9_API.tesk2_Translate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tr {
    public String text;
    public String pos;
    public int fr;
    public Syn[] syn;
    public Mean[] mean;
    public Ex[] ex;
}
