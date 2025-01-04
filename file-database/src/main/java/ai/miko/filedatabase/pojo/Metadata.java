package ai.miko.filedatabase.pojo;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Metadata {
    String UUID;
    String TableName;
    Map<String,String> ColumnsDefinations;
}
