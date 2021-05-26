package module3.lesson9_API.tesk2_Translate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Root {
    public Head head;
    public List<Def> def;
}
