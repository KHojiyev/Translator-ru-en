package module3.lesson9_API.tesk2_Translate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ex {
    public String text;
    public Tr[] tr;
}
